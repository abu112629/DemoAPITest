package com.sams.promotions.emulation.dataPower.emulator.allEndtoEndServices;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.Unmarshaller;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sams.promotions.emulation.checkoutcustomerbasket.request.CheckoutCustomerBasketRequest;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.OrderLine;
import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.steps.util.ClientConfigurationDatabase;
import com.sams.promotions.platform.emulation.util.mapper.JaxBInitializer;
import com.sams.promotions.platform.emulation.util.soap.SOAPUtil;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.xml.XmlPath;

@SpringBootTest

@RunWith(SpringRunner.class)

public class Emulator extends BaseStep {

	protected String postdata;
	protected String qs_response,qs_response2;
	private ClientConfigurationDatabase connection;
	private SOAPUtil soapUtil;

	protected ResultSet rs;
	protected Unmarshaller xmlUnmarshaller;
	protected String IR, VCN, PSN;

	public Emulator() throws IOException {
		super();
	}

	@SuppressWarnings("unused")
	private Map<String, String> Items;

	@Before
	public void beforeSetup() throws IOException {

		reserveemulator = new ReserveEmulationHelper();
		helper = new Helper();
	}

	@Given("^Request Sent for the ClubId 4702$")
	public void POST_Operation_4702() throws Exception {

		postdata = helper.GenerateStringFromResource(UrlConstants.EMULATOR_CLUB);
		System.out.println(postdata);
	}

	@When("^POST the provided request for Emulator$")
	public void postrequest() throws Exception {

		qs_response = helper.POSTXMLEmulator("mercury.quicksilver", postdata, UrlConstants.RESERVE_EMULATION);

	}

	@Then("^Validate with DB2 VAL_CPN_ITEM table for UUID$")
	public void ValidateDB2() throws Exception {

		
		  xmlUnmarshaller = new JaxBInitializer().initUnmarshaller(CheckoutCustomerBasketRequest.class);
		  soapUtil = new SOAPUtil();
		  
		  CheckoutCustomerBasketRequest req = soapUtil.unwrapSoap(xmlUnmarshaller,postdata, CheckoutCustomerBasketRequest.class); 
		  PSN =req.getMessageBody().getCustomerBasket().getBusinessUnit().getNumber();
		  
		  List<OrderLine> list =
		  req.getMessageBody().getCustomerBasket().getOrderLines();
		  
		  for (OrderLine line : list) {
		  
		  IR = line.getProductOffering().getId();
		  
		  }
		  
		  XmlPath xp = helper.rawToXML(qs_response); VCN = xp.getString(
		  "Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.id"
		  );
		  
		  // System.out.println(IR+" "+VCN); 
		  connection = new ClientConfigurationDatabase(); 
		  rs = connection.connectValCpn(IR, VCN);
		 
		 
	}

	@Then("^Validate with CosmosDB with the generated OrderID$")
	public void ValidateCosmosDB() throws Exception {

		
		  String ordernumber = reserveemulator.OrderNumber(UrlConstants.EMULATOR_CLUB);
		  
		  System.out.println(ordernumber);
		  
		  TimeUnit.SECONDS.sleep(2); connection = new ClientConfigurationDatabase();
		  String result = connection.setClient(ordernumber);
		  
		  assertNotNull(result); System.out.println(result);
		 
	}

	@Then("^Validate with VALUE_CPN_TXN_TMP DB2 tables if row inserted for CheckOutResponse 4702$")
	public void ValidateValCPN() throws Exception {

		
		  connection = new ClientConfigurationDatabase(); rs =
		  connection.ConnectDB2(IR, PSN, VCN);
		 

	}

	@Then("^Assert and compare the values for ClubId 4702$")
	public void Check(Map<String, String> Items) throws Exception {

		
		
		  this.Items = Items;
		  
		  String[] actual = helper.Actual(qs_response);
		  System.out.println(Arrays.toString(actual));
		  
		  String[] expected = helper.Expected(Items);
		  
		  try { Assert.assertArrayEquals(expected, actual);
		  System.out.println("Successfully Compared Values"); } catch (Exception e) {
		  System.out.println("Data not equal"); }
		 

	}

	 @Then("^POST Redeem Request after reserve$") 
	 public void RedeemRequest() throws Exception { 
		 
     String redeemrequest = reserveemulator.RedeemRequestUpdater(UrlConstants.EMULATOR_CLUB, UrlConstants.REDEEM_REQUEST);
     qs_response2=helper.POSTXMLEmulator("mercury.quicksilver", redeemrequest,UrlConstants.REDEEM_EMULATION);
     
     System.out.println(qs_response2);
     
     
     }
   
	 
}
