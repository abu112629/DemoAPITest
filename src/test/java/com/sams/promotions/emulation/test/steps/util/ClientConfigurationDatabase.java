package com.sams.promotions.emulation.test.steps.util;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;

import com.microsoft.azure.cosmosdb.ConnectionPolicy;
import com.microsoft.azure.cosmosdb.ConsistencyLevel;
import com.microsoft.azure.cosmosdb.Document;
import com.microsoft.azure.cosmosdb.FeedOptions;
import com.microsoft.azure.cosmosdb.FeedResponse;
import com.microsoft.azure.cosmosdb.rx.AsyncDocumentClient;
import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.helper.Helper;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class ClientConfigurationDatabase extends BaseStep {

	public ClientConfigurationDatabase() throws IOException {
		super();
	}

	private static ExecutorService executorService;
	@SuppressWarnings("unused")
	private static Scheduler scheduler;
	private AsyncDocumentClient client;
	public String databaseName = "promo";
	public String collectionId = "reserve";
	private String collectionId2="promotion";
	private String query;
	private String sql;
	private static String result;
	private Statement stmt;
	private ResultSet rs;

	Connection con;

	public String setClient(String orderNumber) throws Exception {
		


		executorService = Executors.newFixedThreadPool(100);
		scheduler = Schedulers.from(executorService);
		client = new AsyncDocumentClient.Builder().withServiceEndpoint(prop.getProperty("uri"))
				.withMasterKeyOrResourceToken(prop.getProperty("key"))
				.withConnectionPolicy(ConnectionPolicy.GetDefault()).withConsistencyLevel(ConsistencyLevel.Eventual)
				.build();

		sql = "SELECT * FROM coll s WHERE s.orderNumber ='" + orderNumber + "'";
	

		ClientConfigurationDatabase connection = new ClientConfigurationDatabase();
		FeedOptions options = new FeedOptions();
		options.setEnableCrossPartitionQuery(true);
		options.setMaxItemCount(2);

		Observable<FeedResponse<Document>> documentQueryObservable = client
				.queryDocuments("dbs/" + connection.databaseName + "/colls/" + connection.collectionId, sql, options);
		Iterator<FeedResponse<Document>> it = documentQueryObservable.toBlocking().getIterator();


			System.out.println("========================Document Created in Cosmos DB=======================");
			System.out.println("============================================================================");
			
			
			while (it.hasNext()) {
				FeedResponse<Document> page = it.next();
				List<Document> results = page.getResults();
				
				
				
				for (Object doc : results) {
					
					result = Helper.getPrettyJson(doc.toString());

				}
				
				
			}
	
		return result;

	}
	
	public String setPromo(String promoId) throws Exception {

		
		executorService = Executors.newFixedThreadPool(100);
		scheduler = Schedulers.from(executorService);
		client = new AsyncDocumentClient.Builder().withServiceEndpoint(prop.getProperty("uri"))
				.withMasterKeyOrResourceToken(prop.getProperty("key"))
				.withConnectionPolicy(ConnectionPolicy.GetDefault()).withConsistencyLevel(ConsistencyLevel.Eventual)
				.build();

		sql = "SELECT * FROM coll s WHERE s..values.is_promotion_number ='"+promoId+"'";
	

		ClientConfigurationDatabase connection = new ClientConfigurationDatabase();
		FeedOptions options = new FeedOptions();
		options.setEnableCrossPartitionQuery(true);
		options.setMaxItemCount(2);

		Observable<FeedResponse<Document>> documentQueryObservable = client
				.queryDocuments("dbs/" + connection.databaseName + "/colls/" + connection.collectionId2, sql, options);
		Iterator<FeedResponse<Document>> it = documentQueryObservable.toBlocking().getIterator();


			System.out.println("========================Promo Created in Cosmos DB=======================");
			System.out.println("============================================================================");
			
			
			while (it.hasNext()) {
				FeedResponse<Document> page = it.next();
				List<Document> results = page.getResults();
				
				
				
				for (Object doc : results) {
					
					result = Helper.getPrettyJson(doc.toString());

				}
				
				
			}
	
		return result;

	}
	
	public ResultSet connectValCpn(String IR, String VCN) throws IOException {


		try {
			con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("username"),
					prop.getProperty("password"));
			Class.forName(prop.getProperty("database_driver"));

			query = "SELECT * FROM VALUE_COUPON_ITEM WHERE ITEM_NBR=" + IR + " AND VALUE_COUPON_NBR=" + VCN;

			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			
			if (rs.next() == false) {
				System.out.println("No Values exist into DB2");
				assertTrue(rs.toString().isEmpty());
				rs.close();
			}

			else {
				
				System.out.println(
					"================VALUE_COUPON_ITEM : DB2 TABLE ==================");
				System.out.println(
						"VALUE_COUPON_NBR\tITEM_NBR");
				System.out.println(
						"=================\t==================");
				
				//while (rs.next()) {
					

					int vcno = rs.getInt("VALUE_COUPON_NBR");
					int itno = rs.getInt("ITEM_NBR");

					System.out.println(vcno + "\t\t\t" + itno);

				//}
			}

		}

		catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		return rs;

	

	}

	public String Connect_Get_Applicable_Promo_Dates(String IR,String STRN) throws IOException {

		String resultDate = "";

		try {
			con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("username"),
					prop.getProperty("password"));
			Class.forName(prop.getProperty("database_driver"));

			query = "SELECT * FROM VAL_COUPON_STORE WHERE VALUE_COUPON_NBR=" + IR + " AND STORE_NBR=" + STRN;

			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next() == false) {
				System.out.println("No Values exist in Database");
				assertTrue(rs.toString().isEmpty());
				rs.close();
			}

			else {
								
				//while (rs.next()) {
					

					Date ptxno = rs.getDate("START_DATE");
					Date pno = rs.getDate("END_DATE");
					
					System.out.println(ptxno +"||"+ pno);
					
					resultDate = ptxno +"||"+ pno;

				//}
			}


			
		}

		catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
		return resultDate;

	}

	public ResultSet ConnectDB2(String ITN,String PSN,String VCN) throws IOException {


		try {
			con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("username"),
					prop.getProperty("password"));
			Class.forName(prop.getProperty("database_driver"));
			
			query = "SELECT * FROM VAL_COUPN_TXN_TEMP WHERE ITEM_NBR=" + ITN + " AND PURCHASE_STORE_NBR=" + PSN +" AND VALUE_COUPON_NBR=" + VCN;
			 
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			if (rs.next() == false) {
				System.out.println("No Values entered into DB2");
				assertTrue(rs.toString().isEmpty());
				rs.close();
			}

			else {
				
				System.out.println(
						"========================VALUE_COUPON_TXN_TEMP : DB2 TABLE ===============================");
				System.out.println(
						"PURCHASE_TXN_NBR\tPURCHASE_STORE_NBR\tPURCHASE_REG_NBR\tVALUE_COUPON_NBR\tMEMBERSHIP_NBR");
				System.out.println(
						"=================\t==================\t==================\t==================\t================");
				
				//while (rs.next()) {
					

					int ptxno = rs.getInt("PURCHASE_TXN_NBR");
					int pno = rs.getInt("PURCHASE_STORE_NBR");
					int pro = rs.getInt("PURCHASE_REG_NBR");
					int vno = rs.getInt("VALUE_COUPON_NBR");
					int mno = rs.getInt("MEMBERSHIP_NBR");

					System.out.println(ptxno + "\t\t\t" + pno + "\t\t\t" + pro + "\t\t\t" + vno + "\t\t\t" + mno);

				//}
			}

		}

		catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		return rs;

	}

}
