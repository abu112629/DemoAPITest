package com.sams.promotions.emulation.integrationTest;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.steps.util.ClientConfigurationDatabase;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationTestEmulator extends BaseStep {

	public IntegrationTestEmulator() throws IOException {
		super();
	}

	@SuppressWarnings("unused")
	private Map<String, String> Items;
	protected String testjson;

	private ClientConfigurationDatabase connection;
	protected ResultSet rs;
	ReserveEmulationHelper reserveemulator;
	protected String qs_response;
	protected String res;

	@Before
	public void beforeSetup() throws IOException {

		reserveemulator = new ReserveEmulationHelper();
		helper=new Helper();

	}

	@Given("^XML Request Conversion JSON$")
	public void Post_XML_Request() throws Exception {

		testjson = reserveemulator.XMLtoJSON(UrlConstants.EMULATOR_CLUB);

	}

	@When("^Request Sent for ClubId 4702$")
	public void POST_Operation() throws Exception {

		System.out.println(testjson);

	}

	@Then("^Get JSON Response QuickSilver$")
	public void CheckOutputOldClubId() throws Exception {

		qs_response = helper.POSTJSONResponse("mercury.quicksilver", testjson, UrlConstants.INTEGRATION_JSON_CONVERT);

	}

	@Then("^Validate with CosmosDB with generated OrderID$")
	public void Validate() throws Exception {

		String ordernumber = reserveemulator.OrderNumber(UrlConstants.EMULATOR_CLUB);

		System.out.println(ordernumber);
		
		TimeUnit.SECONDS.sleep(2);
		connection = new ClientConfigurationDatabase();
		String result = connection.setClient(ordernumber);
		
		
		assertNotNull(result);
		System.out.println(result);
	}

	@Then("^Convert Response from JSON into XML$")
	public void convert() throws Exception {

		System.out.println("Response in XML :");

		res = reserveemulator.convertJSONtoXML(qs_response);
	}

	@Then("^Get the XML Response$")
	public void Check(Map<String, String> Items) throws Exception {

		this.Items = Items;

		String response = Helper.getPrettyString(res);
		System.out.println(response);

		/*
		 * String[] actual = helper.Actual(response);
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
