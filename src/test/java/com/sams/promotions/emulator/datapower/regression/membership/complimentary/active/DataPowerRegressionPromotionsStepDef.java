
package com.sams.promotions.emulator.datapower.regression.membership.complimentary.active;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.MembershipConstants;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.membershipCreate.Membership;
import com.sams.promotions.emulation.test.steps.util.ClientConfigurationDatabase;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@SpringBootTest

@RunWith(SpringRunner.class)

public class DataPowerRegressionPromotionsStepDef extends BaseStep {

	protected String postdata;
	protected String pathsingle;
	protected String membershipNbr, complimentarymembershipNbr;
	private Response membershipResponse, complimentarymemberhipResponse;
	private ClientConfigurationDatabase connection;

	public DataPowerRegressionPromotionsStepDef() throws IOException {
		super();
	}

	@Before
	public void beforeSetup() throws IOException {

		RestAssured.baseURI = prop.getProperty("datapower.cert.instantsavings");
		thisRequestSpecification = RestAssured.with();

		reserveemulator = new ReserveEmulationHelper();
		helper = new Helper();
		membership = new Membership();
		connection = new ClientConfigurationDatabase();

		pathsingle = UrlConstants.DATA_POWER_CLUB;

	}

	@Given("^Minimum (\\d+) required for DataPower with (.*),(\\d+),(\\d+) and (\\d+) with (\\d+) and Single OrderLine (\\d+) in (.*) to be Utilised to Get Offer (.*) for complimentary member$")
	public void createtheComplimentaryRequest(int Quantity, String channelName, int ItemId, String ClubId, int code,
			int RetailPrice, String lineNumber, String Applied_Dates, String OfferId) throws Exception {

		membershipResponse = membership.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH);
		membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
		JSONObject req2 = helper.updateMembershipRequest("COMPLIMENTARY", membershipNbr,
				MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH);
		complimentarymemberhipResponse = membership.createOtherMembership(req2.toJSONString());
		complimentarymembershipNbr = helper.getResponseValue(complimentarymemberhipResponse,
				MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);

		String xyz = connection.Connect_Get_Applicable_Promo_Dates(OfferId, ClubId);
		Map<String, String> map = Helper.getDates(xyz);

		switch (Applied_Dates) {
		case "LAST_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, complimentarymembershipNbr, map.get("lastdate"), pathsingle);
			break;
		case "FIRST_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, complimentarymembershipNbr, map.get("firstdate"), pathsingle);
			break;
		case "MIDDLE_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, complimentarymembershipNbr, map.get("midDate"), pathsingle);
			break;

		}

	}

	@Given("^Minimum (\\d+) required for DataPower with Second (\\d+) and (\\d+) with (\\d+) and Second OrderLine (\\d+) to be Utilised to Get Offer for Complimentary Member$")
	public void UpdatetheComplimentaryRequest(int Quantity, int ItemId2, String ClubId, int RetailPrice,
			String lineNumber) throws Exception {

		postdata = reserveemulator.XMLRequestUpdaternew(Quantity, ItemId2, RetailPrice, ClubId, lineNumber, postdata);

	}

	@When("^Post request to DataPower Endpoint for Complimentary Member$")
	public void POST_the_Complimentary_request() {

		thisRequestSpecification.given().relaxedHTTPSValidation("TLS").body(postdata).when();
		// header("Content-Type", "text/xml").
	}

	@When("^Request posted to DataPower and get the required discount for Complimentary Member$")
	public void GetComplimentaryparameter_and_postOperation() {

		response = thisRequestSpecification.post(UrlConstants.SERVICES_CHECKOUT).then();

	}

	@Then("^Assert required to DataPower and get attributes for Complimentary Member$")
	public void ChecktheComplimentaryResults(DataTable dataTable) throws Exception {

		String[] expected = helper.ExpectedDataTable(dataTable);

		Response res = response.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualValidations(res.prettyPrint().toString());
		System.out.println("Actual : " + Arrays.toString(actual));

		System.out.println("Expected : " + Arrays.toString(expected));

		try {
			Assert.assertArrayEquals(expected, actual);
			System.out.println("Successfully Compared Values");
		} catch (Exception e) {
			System.out.println("Data not equal");
		}

		membership.deleteMembership(membershipNbr);

	}
}
