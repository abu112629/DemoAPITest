
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
import com.sams.promotions.emulation.test.helper.PrimaryRequestHelper;
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

public class SavingsPlusPromotionsDoubleLinesStepDef extends BaseStep {

	protected String postdata, postdata2,packagecode, packagecode2;
	protected String pathsingle,OfferId,OfferId2;
	protected String membershipNbr;
	private Response membershipResponse;
	protected String expected;
	protected int i,disc, disc2;
	protected Map<String, String> postRequestDetails,postDoubleRequestDetails;

	private SoftAssertions softAssertions;

	public SavingsPlusPromotionsDoubleLinesStepDef() throws IOException {
		super();
	}

	@Before
	public void beforeSetup() throws IOException {

		primaryrequest=new PrimaryRequestHelper();
		reserveemulator = new ReserveEmulationHelper();
		helper = new Helper();
		asserthelper=new AssertHelper();
		membership = new Membership();
		softAssertions = new SoftAssertions();
		pathsingle = UrlConstants.DATA_POWER_CLUB;

	}

	@Given("^DataPower with (.*),(\\d+),(\\d+) and (\\d+) with (\\d+) and Single OrderLine (\\d+) and Double Order Line (\\d+) in (.*) to be Utilised to Get Offer for Savings Plus Primary Member$")
	public void createthesingleLineRequestSavingsPlus(String channelName, String ClubId, String ClubId2, int code,
			int RetailPrice, String lineNumber, String lineNumber2, String Applied_Dates) throws Exception {

		membershipResponse = membership
				.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_SAVINGS_PLUS_REQUEST_PATH);
		membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);

		String arrz = reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), 0);
		Map<String, String> getsize = Helper.getPromotionDetails(arrz);

		int size = Integer.valueOf(getsize.get("SizeOfMetaData"));

		i = 0;
		size = 7;

		while (i < size) {
			
			postRequestDetails=primaryrequest.getInitialDoubleLinesPostRequestDetails(i, membershipNbr, 
					channelName, ClubId, ClubId2, code, RetailPrice, lineNumber, Applied_Dates, OfferId, OfferId2, pathsingle);
			
			postdata=postRequestDetails.get("DataPowerRequest");
			postdata2=postRequestDetails.get("EmulatorRequest");
			disc=Integer.valueOf(postRequestDetails.get("FirstItemDiscount"));
			disc2=Integer.valueOf(postRequestDetails.get("SecondItemDiscount"));
			
			packagecode=postRequestDetails.get("PackageCode");
			packagecode2=postRequestDetails.get("PackageCode2");
			
			OfferId = postRequestDetails.get("OfferId");
			OfferId2 = postRequestDetails.get("OfferId2");
			
			UpdatetheRequesttoDoubleLinesSavingsPlus(ClubId, ClubId2, RetailPrice, lineNumber2, Applied_Dates);

			POST_the_request_for_Double_linesSavingsPlus();
			Getparameter_and_postOperation_for_Double_LinesSavingsPlus();

			POST_the_emulator_request_for_Double_linesSavingsPlus();
			Getemulatorparameter_and_postOperation_for_Double_linesSavingsPlus();

			ChecktheResultsdoubleLinesSavingsPlus();

			i++;

		}

		softAssertions.assertAll();

	}

	@Given("^DataPower with Second Item and (\\d+),(\\d+) with (\\d+) and Second OrderLine (\\d+) in (.*) to be Utilised to Get Offer for Savings Plus Primary Member$")

	public void UpdatetheRequesttoDoubleLinesSavingsPlus(String ClubId, String ClubId2, int RetailPrice,
			String lineNumber, String Applied_Dates) throws Exception {

		

		postDoubleRequestDetails=primaryrequest.getSavingsBasePostRequestDetails(disc, disc2, packagecode, 
				packagecode2, ClubId, ClubId2, RetailPrice, lineNumber, Applied_Dates, OfferId, OfferId2, postdata, postdata2);

		postdata=postDoubleRequestDetails.get("DataPowerRequest");
		postdata2=postDoubleRequestDetails.get("EmulatorRequest");
		
		expected=postDoubleRequestDetails.get("expected");

	}

	@When("^DataPower Endpoint POST request for Savings Plus Primary Member$")
	public void POST_the_request_for_Double_linesSavingsPlus() {

		RestAssured.baseURI = prop.getProperty("datapower.prod.instantsavings");
		thisRequestSpecification = RestAssured.with();
		thisRequestSpecification.given().relaxedHTTPSValidation("TLS").body(postdata).when(); // header("Content-Type",
																								// // "text/xml").

	}

	@When("^Post the request to Emulator Endpoint for Savings Plus Primary Member$")
	public void POST_the_emulator_request_for_Double_linesSavingsPlus() {

		RestAssured.baseURI = prop.getProperty("datapower.cert.instantsavings");
		thisRequestSpecification2 = RestAssured.with();

		thisRequestSpecification2.given().header("Content-Type", "text/xml").relaxedHTTPSValidation("TLS")
				.body(postdata2).when();

	}

	@When("^Response for DataPower and get the required discount for Savings Plus Primary Member$")
	public void Getparameter_and_postOperation_for_Double_LinesSavingsPlus() {

		response = thisRequestSpecification.post(UrlConstants.SERVICES_CHECKOUT).then();

	}

	@When("^Response for Emulator and get the required discount for Savings Plus Primary Member$")
	public void Getemulatorparameter_and_postOperation_for_Double_linesSavingsPlus() {

		response2 = thisRequestSpecification2.post(UrlConstants.RESERVE_EMULATION).then();

	}

	@Then("^Assert on DataPower request and get attributes for Savings Plus Primary Member$")
	public void ChecktheResultsdoubleLinesSavingsPlus() throws Exception {

		
		softAssertions=asserthelper.SavingsPlusDoubleLinesValidation(response, response2, packagecode, packagecode2, OfferId, OfferId2, expected);
		
		membership.deleteMembership(membershipNbr);

	}

}
