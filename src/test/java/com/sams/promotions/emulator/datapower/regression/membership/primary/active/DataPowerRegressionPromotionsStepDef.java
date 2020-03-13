package com.sams.promotions.emulator.datapower.regression.membership.primary.active;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

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
	protected String membershipNbr;
	private Response membershipResponse;
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

	@Given("^Minimum (\\d+) required for DataPower with (.*),(\\d+),(\\d+) and (\\d+) with (\\d+) and Single OrderLine (\\d+) in (.*) to be Utilised to Get Offer (.*) for Primary Member$")
	public void createtheRequest(int Quantity, String channelName, int ItemId, String ClubId, int code, int RetailPrice,
			String lineNumber, String Applied_Dates, String OfferId) throws Exception {

		membershipResponse = membership.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH);
		membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);

		String xyz = connection.Connect_Get_Applicable_Promo_Dates(OfferId, ClubId);
		Map<String, String> map = Helper.getDates(xyz);

		switch (Applied_Dates) {
		case "LAST_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNbr, map.get("lastdate"), pathsingle);
			break;
		case "FIRST_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNbr, map.get("firstdate"), pathsingle);
			break;
		case "MIDDLE_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNbr, map.get("midDate"), pathsingle);
			break;

		}

	}

	@Given("^Minimum (\\d+) required for DataPower with Second (\\d+) and (\\d+) with (\\d+) and Second OrderLine (\\d+) to be Utilised to Get Offer for Primary Member$")
	public void UpdatetheRequest(int Quantity, int ItemId2, String ClubId, int RetailPrice, String lineNumber)
			throws Exception {

		postdata = reserveemulator.XMLRequestUpdaternew(Quantity, ItemId2, RetailPrice, ClubId, lineNumber, postdata);

	}

	@When("^Post request to the DataPower Endpoint for Primary Member$") 
	public void POST_THE_Datapower_request() {
  
			thisRequestSpecification.given().relaxedHTTPSValidation("TLS").body(postdata).when(); 
			// header("Content-Type", "text/xml"). 
  
	}

	@When("^Request posted to the DataPower and get the required discount for Primary Member$")
	public void Getparameter_AND_posttheOperation() {

		response = thisRequestSpecification.post(UrlConstants.SERVICES_CHECKOUT).then();

	}

	@Then("^Assert required to the DataPower and get the attributes for Primary Member$")
	public void ChecktheAssertResults(DataTable dataTable) throws Exception {

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
