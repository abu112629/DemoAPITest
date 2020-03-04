package com.sams.promotions.migrations.emulator.datapower.regression.membership.primary.active;

import java.io.IOException;
import java.util.Map;

import org.assertj.core.api.SoftAssertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.MembershipConstants;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.AssertHelper;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.membershipCreate.Membership;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@SpringBootTest

@RunWith(SpringRunner.class)

public class BusinessBasePromotionsStepDef extends BaseStep {

	protected String postdata,postdata2,packagecode;
	protected String pathsingle,OfferId;
	protected String membershipNbr;
	private Response membershipResponse;
	protected String expected;
	protected int i;
	protected Map<String, String> postRequestDetails;

	private SoftAssertions softAssertions;

	public BusinessBasePromotionsStepDef() throws IOException {
		super();
	}

	@Before
	public void beforeSetup() throws IOException {

		reserveemulator = new ReserveEmulationHelper();
		helper = new Helper();
		asserthelper=new AssertHelper();
		membership = new Membership();
		softAssertions = new SoftAssertions();
		pathsingle = UrlConstants.DATA_POWER_CLUB;

	}

	@Given("^Minimum required for DataPower with (.*),(\\d+),(\\d+) and (\\d+) with (\\d+) and Single OrderLine (\\d+) in (.*) to be Utilised to Get Offer for Business Base Primary Member$")
	public void createtheRequestBusinessBase(String channelName, String ClubId, String ClubId2, int code, int RetailPrice,
			String lineNumber, String Applied_Dates) throws Exception {

		membershipResponse = membership
				.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_BUSINESS_REQUEST_PATH);
		membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);

		String arrz = reserveemulator.PromoMetaData(prop.get("datapower.production.cert").toString(), 0);
		Map<String, String> getsize = Helper.getPromotionDetails(arrz);
		
		int size = Integer.valueOf(getsize.get("SizeOfMetaData"));

		i = 0;
		size = 1;

		while (i < size) {
			
			postRequestDetails=reserveemulator.getPostRequestDetails(i, membershipNbr, channelName, ClubId, ClubId2, code,
					RetailPrice, lineNumber, Applied_Dates, OfferId, pathsingle);
			
			postdata=postRequestDetails.get("DataPowerRequest");
			postdata2=postRequestDetails.get("EmulatorRequest");
			
			packagecode=postRequestDetails.get("PackageCode");
			OfferId = postRequestDetails.get("OfferId");
			expected=postRequestDetails.get("expected");
			
			POST_the_requestBusinessBase();
			Getparameter_and_postOperationBusinessBase();

			POST_the_emulator_requestBusinessBase();
			Getemulatorparameter_and_postOperationBusinessBase();

			ChecktheResultsBusinessBase();

			i++;

		}

		softAssertions.assertAll();
	}

	@When("^Post request to DataPower Endpoint for Business Base Primary Member$")
	public void POST_the_requestBusinessBase() {

		RestAssured.baseURI = prop.getProperty("datapower.prod.instantsavings");
		thisRequestSpecification = RestAssured.with();

		thisRequestSpecification.given().relaxedHTTPSValidation("TLS").body(postdata).when();

	}

	@When("^Post request to Emulator Endpoint for Business Base Primary Member$")
	public void POST_the_emulator_requestBusinessBase() {

		RestAssured.baseURI = prop.getProperty("mercury.quicksilver");
		thisRequestSpecification2 = RestAssured.with();

		thisRequestSpecification2.given().header("Content-Type", "text/xml").relaxedHTTPSValidation("TLS")
				.body(postdata2).when();

	}

	@When("^Request posted to DataPower and get the required discount for Business Base Primary Member$")
	public void Getparameter_and_postOperationBusinessBase() {

		response = thisRequestSpecification.post(UrlConstants.SERVICES_CHECKOUT).then();

	}

	@When("^Request posted to Emulator and get the required discount for Business Base Primary Member$")
	public void Getemulatorparameter_and_postOperationBusinessBase() {

		response2 = thisRequestSpecification2.post(UrlConstants.RESERVE_EMULATION).then();

	}

	@Then("^Assert required to DataPower and get attributes for Business Base Primary Member$")
	public void ChecktheResultsBusinessBase() throws Exception {

		softAssertions=asserthelper.BusinessBaseValidation(response, response2, packagecode, OfferId, expected);

		membership.deleteMembership(membershipNbr);

	}

}
