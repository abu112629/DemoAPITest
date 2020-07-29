package com.sams.promotions.emulation.integrationTest;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Map;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.steps.util.ClientConfigurationDatabase;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IntegrationTestDataPower extends BaseStep {

	public IntegrationTestDataPower() throws IOException {
		super();
	}

	@SuppressWarnings("unused")
	private Map<String, String> Items;
	protected String body;

	@SuppressWarnings("unused")
	private ClientConfigurationDatabase connection;
	protected ResultSet rs;
	ReserveEmulationHelper reserveemulator;
	protected String qs_response;
	

	@Before
	public void beforeSetup() throws IOException {

		reserveemulator = new ReserveEmulationHelper();
		helper = new Helper();

	}

	@Given("^Request Sent for ClubId 4969$")
	public void Post_XML_Request() throws Exception {

		body=helper.GenerateStringFromResource(UrlConstants.DATA_POWER_CLUB);
		System.out.println(body);
		

	}

	@When("^Get XML Response from DataPower EndPoint$")
	public void POST_Operation() throws Exception {
		
		qs_response = helper.POSTXMLResponse("datapower.instantsavings", body, UrlConstants.SERVICES_CHECKOUT).asString();
		

	}


	@Then("^Validate with DB2 tables for ItemNumber \"([^\"]*)\" and StoreID \"([^\"]*)\" and ValueCoupon \"([^\"]*)\"$")
	public void Validate(String ITN,String PSN,String VCN) throws Exception {

		connection = new ClientConfigurationDatabase();
		//rs = connection.ConnectDB2(ITN,PSN,VCN);
		
	}


	@Then("^Get XML Response$")
	public void Check(Map<String, String> Items) throws Exception {

		this.Items = Items;

		System.out.println(qs_response);

		/*
		 * String[] actual = helper.Actual(qs_response);
		 * System.out.println(Arrays.toString(actual));
		 * 
		 * String[] expected = helper.Expected(Items);
		 * 
		 * try { Assert.assertArrayEquals(expected, actual);
		 * System.out.println("Successfully Compared Values"); } catch (Exception e) {
		 * System.out.println("Data not equal"); }
		 */

	}

}
