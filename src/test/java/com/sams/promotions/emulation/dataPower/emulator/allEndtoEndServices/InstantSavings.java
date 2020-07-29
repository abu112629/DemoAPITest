
package com.sams.promotions.emulation.dataPower.emulator.allEndtoEndServices;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.Unmarshaller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sams.promotions.emulation.checkoutcustomerbasket.request.CheckoutCustomerBasketRequest;
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

public class InstantSavings extends BaseStep {

	protected String postdata;
	protected String qs_response;
	private ClientConfigurationDatabase connection;
	CosmosValidator validation;

	protected ResultSet rs;
	protected SOAPUtil soapUtil;
	protected Unmarshaller xmlUnmarshaller;
	protected String IR, VCN, PSN, MMBR_ID, PromoId, Discount, GS1Code, GTin, Quantity, Unitdiscount;

	public InstantSavings() throws IOException {
		super();
	}

	@SuppressWarnings("unused")
	private Map<String, String> Items;

	@Before
	public void beforeSetup() throws IOException {

		reserveemulator = new ReserveEmulationHelper();
		helper = new Helper();
		validation = new CosmosValidator();

	}

	@Given("^Request Sent for the ClubId 4969$")
	public void POST_Operation_4969() throws Exception {

		postdata = helper.GenerateStringFromResource(UrlConstants.DATA_POWER_CLUB);
		System.out.println(postdata);

	}

	@When("^POST the provided request to InstantSavings$")
	public void postrequest() throws Exception {

		qs_response = helper.POSTXMLEmulator("datapower.stage.instantsavings", postdata,
				UrlConstants.SERVICES_CHECKOUT);

	}

	@Then("^Validate with DB2 VAL_CPN_ITEM table for ISPromo$")
	public void ValidateCPNItm() throws Exception {

		xmlUnmarshaller = new JaxBInitializer().initUnmarshaller(CheckoutCustomerBasketRequest.class);
		soapUtil = new SOAPUtil();

		CheckoutCustomerBasketRequest req = soapUtil.unwrapSoap(xmlUnmarshaller, postdata,
				CheckoutCustomerBasketRequest.class);
		PSN = req.getMessageBody().getCustomerBasket().getBusinessUnit().getNumber();
		String membershipNumber = req.getMessageBody().getCustomerBasket().getCustomer().getId();
		MMBR_ID = membershipNumber.substring(7);
		/*
		 * List<OrderLine> list =
		 * req.getMessageBody().getCustomerBasket().getOrderLines(); for (OrderLine line
		 * : list) {
		 * 
		 * IR = line.getProductOffering().getId();
		 * 
		 * }
		 */

	}

	@Then("^Validate with VALUE_CPN_TXN_TMP DB2 tables if row inserted for CheckOutResponse 4969$")
	public void ValidateValCPN() throws Exception {

		connection = new ClientConfigurationDatabase();
		String actual = null;

		XmlPath xp;
		xp = helper.rawToXML(qs_response);

		int length = xp.getInt("Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.size()");

		for (int i = 0; i < length; i++) {

			actual = helper.Actual(qs_response, i);
			Map<String, String> promodetailsMap = helper.getTransactionDetails(actual);

			PromoId = promodetailsMap.get("PromoId");
			GS1Code = promodetailsMap.get("Gs1Code");
			GTin = promodetailsMap.get("Gtin");
			Quantity = promodetailsMap.get("Quantity");
			IR = promodetailsMap.get("ItemId");
			Unitdiscount = promodetailsMap.get("UnitDiscount");

			rs = connection.ConnectDB2(IR, PSN, MMBR_ID, PromoId);
			
		}
		
		String ordernumber = reserveemulator.OrderNum(UrlConstants.DATA_POWER_CLUB);

		System.out.println(ordernumber);

		TimeUnit.SECONDS.sleep(2);
		
		validation.CosmosExtractedResults("2420400450689759735627920198", length);

	}

	@Then("^Assert and compare the values for ClubId 4969$")
	public void Check(Map<String, String> Items) throws Exception {

	}
}
