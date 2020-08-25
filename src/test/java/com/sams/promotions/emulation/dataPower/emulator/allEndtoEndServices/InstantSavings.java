
package com.sams.promotions.emulation.dataPower.emulator.allEndtoEndServices;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.Unmarshaller;

import org.assertj.core.api.SoftAssertions;
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

	protected String postdata,ordernumber;
	protected String qs_response;
	private ClientConfigurationDatabase connection;
	CosmosValidator validation;

	protected Map<String, String> rs;
	private SoftAssertions softAssertions;
	protected SOAPUtil soapUtil;
	protected Unmarshaller xmlUnmarshaller;
	protected String IR, VCN, PSN, MMBR_ID, PromoId, Discount, GS1Code, GTin, Quantity, Unitdiscount;

	public InstantSavings() throws IOException {
		super();
	}

	@Before
	public void beforeSetup() throws IOException {

		reserveemulator = new ReserveEmulationHelper();
		helper = new Helper();
		validation = new CosmosValidator();
		softAssertions = new SoftAssertions();

	}

	@Given("^Request Sent for the ClubId with (.*)$")
	public void POST_Operation_4969(String Request) throws Exception {

		switch (Request) {

		case "BroadReach Dollar Off Request Type":
			postdata = helper.GenerateStringFromResource(UrlConstants.DATA_POWER_CLUB);
			ordernumber = reserveemulator.OrderNum(UrlConstants.DATA_POWER_CLUB);
			break;

		case "BroadReach Seed and Reward":
			postdata = helper.GenerateStringFromResource(UrlConstants.SEED_AND_REWARD_REQUEST);
			ordernumber = reserveemulator.OrderNum(UrlConstants.SEED_AND_REWARD_REQUEST);
			break;

		case "Package Coupon Dollar off":
			postdata = helper.GenerateStringFromResource(UrlConstants.PACKAGE_DOLLAR_OFF_REQUEST);
			ordernumber = reserveemulator.OrderNum(UrlConstants.PACKAGE_DOLLAR_OFF_REQUEST);
			break;

		case "Package Coupon Percentage Off":
			postdata = helper.GenerateStringFromResource(UrlConstants.PACKAGE_PERCENT_OFF_REQUEST);
			ordernumber = reserveemulator.OrderNum(UrlConstants.PACKAGE_PERCENT_OFF_REQUEST);
			break;

		case "Package and BroadReach":
			postdata = helper.GenerateStringFromResource(UrlConstants.PACKAGE_BROADREACH_REQUEST);
			ordernumber = reserveemulator.OrderNum(UrlConstants.PACKAGE_BROADREACH_REQUEST);
			break;

		}

		System.out.println(postdata);
	}

	@When("^POST the provided request to InstantSavings$")
	public void postrequest() throws Exception {

		qs_response = helper.POSTXMLEmulator("datapower.instantsavings", postdata, UrlConstants.SERVICES_CHECKOUT);

	}

	@Then("^Create Input parameters for Database Validations$")
	public void ValidateCPNItm() throws Exception {

		xmlUnmarshaller = new JaxBInitializer().initUnmarshaller(CheckoutCustomerBasketRequest.class);
		soapUtil = new SOAPUtil();

		CheckoutCustomerBasketRequest req = soapUtil.unwrapSoap(xmlUnmarshaller, postdata,
				CheckoutCustomerBasketRequest.class);
		PSN = req.getMessageBody().getCustomerBasket().getBusinessUnit().getNumber();

		String membershipNumber = req.getMessageBody().getCustomerBasket().getCustomer().getId();

		MMBR_ID = membershipNumber.substring(7);

	}

	@Then("^Validate VALUE_CPN_TXN_TEMP and Cosmos DB$")
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
			IR = promodetailsMap.get("ItemId");

			rs = connection.ConnectDB2(IR, PSN, MMBR_ID, PromoId);

		}

		

		System.out.println(ordernumber);

		TimeUnit.SECONDS.sleep(2);

		validation.CosmosExtractedResults(ordernumber);

	}

	@Then("^Assert and compare the values of both Database$")
	public void Check() throws Exception {

		
		softAssertions = validation.ValidationsAll(ordernumber);

		softAssertions.assertAll();

	}

}
