package com.sams.promotions.emulator.datapower.regression.membership.standAlonePromotions;

import java.io.IOException;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.AssertHelper;
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

@SpringBootTest

@RunWith(SpringRunner.class)

public class BroadReachStandAloneRegressionPromotionsStepDef extends BaseStep {

	protected String postdata,postdata2;
	protected String pathsingle;
	protected String membershipNbr;
	Membership_Types member;
	private ClientConfigurationDatabase connection;

	public BroadReachStandAloneRegressionPromotionsStepDef() throws IOException {
		super();
	}

	@Before
	public void beforeSetup() throws IOException {

		reserveemulator = new ReserveEmulationHelper();
		asserthelper = new AssertHelper();
		helper = new Helper();
		membership = new Membership();
		member = new Membership_Types();

		connection = new ClientConfigurationDatabase();
		pathsingle = UrlConstants.DATA_POWER_CLUB;

	}
	
	@Given("^(.*), (.*), (.*) member and Quantity (\\d+) for DataPower with (.*),(\\d+),(\\d+) and (\\d+) with (\\d+) and Single OrderLine (\\d+) in (.*) to be Utilised to Get Offer (.*) for Primary Member$")
	public void createtheRequest(String membershipBase, String type, String Tier,int Quantity, String channelName, int ItemId, String ClubId, int code, int RetailPrice,
			String lineNumber, String Applied_Dates, String OfferId) throws Exception {

		
		membershipNbr = member.getMembershipType(type, membershipBase, Tier);

		String xyz = connection.Connect_Get_Applicable_Promo_Dates(OfferId, ClubId);
		Map<String, String> map = Helper.getDates(xyz);

		switch (Applied_Dates) {
		case "LAST_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNbr, map.get("lastdate"), pathsingle);
			
			postdata2 = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNbr, map.get("lastdate"), pathsingle);
			break;
		case "FIRST_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNbr, map.get("firstdate"), pathsingle);
			postdata2 = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNbr, map.get("lastdate"), pathsingle);
			break;
		case "MIDDLE_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNbr, map.get("midDate"), pathsingle);
			postdata2 = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNbr, map.get("lastdate"), pathsingle);
			break;

		}

	}

	@Given("^Minimum (\\d+) required for DataPower with Second (\\d+) and (\\d+) with (\\d+) and Second OrderLine (\\d+) to be Utilised to Get Offer for Primary Member$")
	public void UpdatetheRequest(int Quantity, int ItemId2, String ClubId, int RetailPrice, String lineNumber)
			throws Exception {

		postdata = reserveemulator.XMLRequestUpdaternew(Quantity, ItemId2, RetailPrice, ClubId, lineNumber, postdata);
		postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity, ItemId2, RetailPrice, ClubId, lineNumber, postdata2);
		

	}

	@When("^Post request to the DataPower Endpoint for Primary Member$") 
	public void POST_THE_Datapower_request() {
		
		RestAssured.baseURI = prop.getProperty("datapower.prod.instantsavings");
		thisRequestSpecification = RestAssured.with();
  
			thisRequestSpecification.given().relaxedHTTPSValidation("TLS").body(postdata).when(); 
			// header("Content-Type", "text/xml"). 
			
  
	}
	
	
	@When("^Post request to the Emulator Endpoint for Primary Member$") 
	public void POST_THE_emulator_request() {
		
		RestAssured.baseURI = prop.getProperty("mercury.quicksilver");
		thisRequestSpecification2 = RestAssured.with();
  
			thisRequestSpecification2.given().header("Content-Type", "text/xml").relaxedHTTPSValidation("TLS").body(postdata2).when(); 
			// header("Content-Type", "text/xml"). 
			
  
	}

	@When("^Request posted to the DataPower and get the required discount for Primary Member$")
	public void Getparameter_AND_posttheOperation() {

		response = thisRequestSpecification.post(UrlConstants.SERVICES_CHECKOUT).then();
		

	}
	
	@When("^Request posted to the Emulator and get the required discount for Primary Member$")
	public void Getemulatorparameter_AND_posttheOperation() {
		
		response2=thisRequestSpecification2.post(UrlConstants.RESERVE_EMULATION).then();
	}


	@Then("^Assert required to the DataPower and get the attributes for Primary Member$")
	public void ChecktheAssertResults(DataTable dataTable) throws Exception {

		asserthelper.ValidationResponse(response, response2);

		membership.deleteMembership(membershipNbr);

	}
}
