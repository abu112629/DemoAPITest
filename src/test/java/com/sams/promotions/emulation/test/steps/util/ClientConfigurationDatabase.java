package com.sams.promotions.emulation.test.steps.util;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

import cucumber.api.DataTable;
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
	
		client.close();
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
	
		client.close();	
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

			con.close();
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

			con.close();
			
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
			
			con.close();
		}

		catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		return rs;

	}

	
	public ResultSet PromotionsDB2(DataTable dataTable) throws IOException {

		try {
			
			List<Map<String, String>> validations = dataTable.asMaps(String.class, String.class);
			for (Map<String, String> form : validations) {

				String VALUE_COUPON_NBR = form.get("VALUE_COUPON_NBR");
				String BASE_DIV_NBR = form.get("BASE_DIV_NBR");
				String START_DATE = form.get("START_DATE");
				String END_DATE = form.get("END_DATE");
				String START_TIME = form.get("START_TIME");
				String END_TIME = form.get("END_TIME");
				String ACTIVE_IND = form.get("ACTIVE_IND");
				String COUPON_ITEM_NBR = form.get("COUPON_ITEM_NBR");
				String COUPON_UPC_NBR = form.get("COUPON_UPC_NBR");
				String VALUE_AMT = form.get("VALUE_AMT");
				String VALUE_PCT = form.get("VALUE_PCT");
				String PACKAGE_CODE = form.get("PACKAGE_CODE");
				String INVESTMENT_AMT = form.get("INVESTMENT_AMT");
				String INVESTMENT_CNT = form.get("INVESTMENT_CNT");
				String DURATION_CODE = form.get("DURATION_CODE");
				String VENDOR_FUNDED_IND = form.get("VENDOR_FUNDED_IND");
				String SHARED_VALUE_IND = form.get("SHARED_VALUE_IND");
				String PRVDR_COUPON_NBR = form.get("PRVDR_COUPON_NBR");
				String MANUAL_LOAD_IND = form.get("MANUAL_LOAD_IND");
				String VAL_OFFER_TYP_CODE = form.get("VAL_OFFER_TYP_CODE");
				String MAX_RDMPT_CNT = form.get("MAX_RDMPT_CNT");
				String MIN_BASKET_AMT = form.get("MIN_BASKET_AMT");
				String VAL_ASSIGN_TYPE_CD = form.get("VAL_ASSIGN_TYPE_CD");
				String LAST_CHANGE_DATE = form.get("LAST_CHANGE_DATE");
				String LAST_CHG_PGM_ID = form.get("LAST_CHG_PGM_ID");
				String CAMPAIGN_NBR = form.get("CAMPAIGN_NBR");
				String PURCH_FREQUENCY_PCT = form.get("PURCH_FREQUENCY_PCT");
				String FUNDING_TYPE_CD = form.get("FUNDING_TYPE_CD");
				String SUMMARY_DESC = form.get("SUMMARY_DESC");
				String DETAIL_DESC = form.get("DETAIL_DESC");
				String RETAIL_AFTER_DISC_IND = form.get("RETAIL_AFTER_DISC_IND");
				String MAX_PURCHASE_AMT = form.get("MAX_PURCHASE_AMT");
				String MAX_PURCHASE_QTY = form.get("MAX_PURCHASE_QTY");
				String MAX_DISC_AMT = form.get("MAX_DISC_AMT");
				String MIN_CORE_PURCH_QTY = form.get("MIN_CORE_PURCH_QTY");
				String MIN_SEED_PURCH_QTY = form.get("MIN_SEED_PURCH_QTY");
				String MIN_REWARD_PURCH_QTY = form.get("MIN_REWARD_PURCH_QTY");
				String OFFER_AVAIL_DELAY_DAY_CNT = form.get("OFFER_AVAIL_DELAY_DAY_CNT");
				String OFFER_DUR_DELAY_DAY_CNT = form.get("OFFER_DUR_DELAY_DAY_CNT");
				String ASSGN_INVST_CNT = form.get("ASSGN_INVST_CNT");
				String REDEMPTION_INVST_CNT = form.get("REDEMPTION_INVST_CNT");
				
			
			con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("username"),
					prop.getProperty("password"));
			Class.forName(prop.getProperty("database_driver"));
			
			query = "INSERT INTO VALUE_COUPON ("
			+ "VALUE_COUPON_NBR,BASE_DIV_NBR,START_DATE,"
			+ "END_DATE,START_TIME,END_TIME,ACTIVE_IND,COUPON_ITEM_NBR,COUPON_UPC_NBR,"
			+ "VALUE_AMT,VALUE_PCT,PACKAGE_CODE,INVESTMENT_AMT,INVESTMENT_CNT,DURATION_CODE,VENDOR_FUNDED_IND,"
			+ "SHARED_VALUE_IND,PRVDR_COUPON_NBR,MANUAL_LOAD_IND,VAL_OFFER_TYP_CODE,MAX_RDMPT_CNT,MIN_BASKET_AMT,"
			+ "VAL_ASSIGN_TYPE_CD,LAST_CHANGE_DATE,LAST_CHG_PGM_ID,CAMPAIGN_NBR,PURCH_FREQUENCY_PCT,FUNDING_TYPE_CD,"
			+ "SUMMARY_DESC,DETAIL_DESC,RETAIL_AFTER_DISC_IND,MAX_PURCHASE_AMT,MAX_PURCHASE_QTY,"
			+ "MAX_DISC_AMT,MIN_CORE_PURCH_QTY,MIN_SEED_PURCH_QTY,MIN_REWARD_PURCH_QTY,OFFER_AVAIL_DELAY_DAY_CNT,"
			+ "OFFER_DUR_DELAY_DAY_CNT,ASSGN_INVST_CNT,REDEMPTION_INVST_CNT) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.valueOf(VALUE_COUPON_NBR));
			pstmt.setInt(2, Integer.valueOf(BASE_DIV_NBR));
			pstmt.setDate(3, Date.valueOf(START_DATE));
			pstmt.setDate(4, Date.valueOf(END_DATE));
			pstmt.setTime(5, Time.valueOf(START_TIME));
			pstmt.setTime(6, Time.valueOf(END_TIME));
			pstmt.setString(7, ACTIVE_IND);
			pstmt.setInt(8, Integer.valueOf(COUPON_ITEM_NBR));
			pstmt.setLong(9, Long.valueOf(COUPON_UPC_NBR));
			pstmt.setFloat(10, Float.valueOf(VALUE_AMT));
			pstmt.setFloat(11, Float.valueOf(VALUE_PCT));
			pstmt.setInt(12, Integer.valueOf(PACKAGE_CODE));
			pstmt.setFloat(13, Float.valueOf(INVESTMENT_AMT));
			pstmt.setInt(14, Integer.valueOf(INVESTMENT_CNT));
			pstmt.setInt(15, Integer.valueOf(DURATION_CODE));
			pstmt.setString(16, VENDOR_FUNDED_IND);
			pstmt.setString(17, SHARED_VALUE_IND);
			pstmt.setInt(18, Integer.valueOf(PRVDR_COUPON_NBR));
			pstmt.setString(19, MANUAL_LOAD_IND);
			pstmt.setInt(20, Integer.valueOf(VAL_OFFER_TYP_CODE));
			pstmt.setInt(21, Integer.valueOf(MAX_RDMPT_CNT));
			pstmt.setFloat(22, Float.valueOf(MIN_BASKET_AMT));
			pstmt.setInt(23, Integer.valueOf(VAL_ASSIGN_TYPE_CD));
			pstmt.setDate(24, Date.valueOf(LAST_CHANGE_DATE));
			pstmt.setString(25, LAST_CHG_PGM_ID);
			pstmt.setInt(26, Integer.valueOf(CAMPAIGN_NBR));
			pstmt.setFloat(27, Float.valueOf(PURCH_FREQUENCY_PCT));
			pstmt.setInt(28, Integer.valueOf(FUNDING_TYPE_CD));
			pstmt.setString(29, SUMMARY_DESC);
			pstmt.setString(30, DETAIL_DESC);
			pstmt.setString(31, RETAIL_AFTER_DISC_IND);
			pstmt.setString(32, MAX_PURCHASE_AMT);
			pstmt.setString(33, MAX_PURCHASE_QTY);
			pstmt.setString(34, MAX_DISC_AMT);
			pstmt.setInt(35, Integer.valueOf(MIN_CORE_PURCH_QTY));
			pstmt.setString(36, MIN_SEED_PURCH_QTY);
			pstmt.setString(37, MIN_REWARD_PURCH_QTY);
			pstmt.setString(38, OFFER_AVAIL_DELAY_DAY_CNT);
			pstmt.setString(39, OFFER_DUR_DELAY_DAY_CNT);
			pstmt.setString(40, ASSGN_INVST_CNT);
			pstmt.setString(41, REDEMPTION_INVST_CNT);
			
			pstmt.addBatch();
			
			int []rows=pstmt.executeBatch();	
			
			System.out.println(Arrays.toString(rows));
			
			query = "SELECT * FROM VALUE_COUPON WHERE VALUE_COUPON_NBR="+VALUE_COUPON_NBR;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			
			if (rs.next() == false) {
				System.out.println("No Values entered into DB2");
				assertTrue(rs.toString().isEmpty());
				rs.close();
			}
			
			con.close();
			

			}
		}
		catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		return rs;

	}

	
	public ResultSet Promotions_VAL_CPN_ITEM(DataTable dataTable) throws IOException {

		try {
			
			List<Map<String, String>> validations = dataTable.asMaps(String.class, String.class);
			for (Map<String, String> form : validations) {

				String VALUE_COUPON_NBR = form.get("VALUE_COUPON_NBR");
				String ITEM_NBR=form.get("ITEM_NBR");   
				String VAL_ITEM_TYPE_CODE=form.get("VAL_ITEM_TYPE_CODE"); 
				String DEPT_NBR=form.get("DEPT_NBR"); 
				String SUBCLASS_NBR=form.get("SUBCLASS_NBR");
				String VENDOR_NBR=form.get("VENDOR_NBR");
				String MIN_ITEM_PURCH_QTY=form.get("MIN_ITEM_PURCH_QTY");
				
				
			
			con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("username"),
					prop.getProperty("password"));
			Class.forName(prop.getProperty("database_driver"));
			
			query = "INSERT INTO VALUE_COUPON_ITEM (VALUE_COUPON_NBR,ITEM_NBR," + 
					"VAL_ITEM_TYPE_CODE,DEPT_NBR,SUBCLASS_NBR,VENDOR_NBR,MIN_ITEM_PURCH_QTY)" + 
					"VALUES (?,?,?,?,?,?,?)";
			
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.valueOf(VALUE_COUPON_NBR));
			pstmt.setInt(2, Integer.valueOf(ITEM_NBR));
			pstmt.setInt(3, Integer.valueOf(VAL_ITEM_TYPE_CODE));
			pstmt.setInt(4, Integer.valueOf(DEPT_NBR));
			pstmt.setInt(5, Integer.valueOf(SUBCLASS_NBR));
			pstmt.setInt(6, Integer.valueOf(VENDOR_NBR));
			pstmt.setInt(7, Integer.valueOf(MIN_ITEM_PURCH_QTY));
			pstmt.addBatch();
			
			int []rows=pstmt.executeBatch();	
			
			System.out.println(Arrays.toString(rows));
			
			query = "SELECT * FROM VALUE_COUPON_ITEM WHERE VALUE_COUPON_NBR="+VALUE_COUPON_NBR;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			
			if (rs.next() == false) {
				System.out.println("No Values entered into DB2");
				assertTrue(rs.toString().isEmpty());
				rs.close();
			}
			
			con.close();
			

			}
		}
		catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		return rs;

	}
	
	
	public ResultSet Promotions_VAL_CPN_STORE(DataTable dataTable) throws IOException {

		try {
			
			List<Map<String, String>> validations = dataTable.asMaps(String.class, String.class);
			for (Map<String, String> form : validations) {

				String VALUE_COUPON_NBR = form.get("VALUE_COUPON_NBR");
				String STORE_NBR=form.get("STORE_NBR");   
				String START_DATE=form.get("START_DATE"); 
				String END_DATE=form.get("END_DATE"); 
				String START_TIME=form.get("START_TIME");
				String END_TIME=form.get("END_TIME");
				
				
				 
			
			con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("username"),
					prop.getProperty("password"));
			Class.forName(prop.getProperty("database_driver"));
			
			query = "INSERT INTO VAL_COUPON_STORE (VALUE_COUPON_NBR,"
					+ "STORE_NBR,START_DATE,END_DATE,START_TIME,END_TIME) "
					+ "VALUES (?,?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.valueOf(VALUE_COUPON_NBR));
			pstmt.setInt(2, Integer.valueOf(STORE_NBR));
			pstmt.setDate(3, Date.valueOf(START_DATE));
			pstmt.setDate(4, Date.valueOf(END_DATE));
			pstmt.setTime(5, Time.valueOf(START_TIME));
			pstmt.setTime(6, Time.valueOf(END_TIME));
			pstmt.addBatch();
			
			int []rows=pstmt.executeBatch();	
			
			System.out.println(Arrays.toString(rows));
			
			query = "SELECT * FROM VAL_COUPON_STORE WHERE VALUE_COUPON_NBR="+VALUE_COUPON_NBR;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			
			if (rs.next() == false) {
				System.out.println("No Values entered into DB2");
				assertTrue(rs.toString().isEmpty());
				rs.close();
			}
			
			con.close();
			

			}
		}
		catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		return rs;

	}
	
	
}
