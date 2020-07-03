package com.sams.promotions.emulation.jsontoxmlcheck;

import static com.sams.promotions.emulation.test.steps.util.UnitTestUtil.loadResourceAsString;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveHelper;
import com.sams.promotions.platform.emulation.core.constants.ChannelConstants;
import com.sams.promotions.platform.emulation.core.constants.MappingConstants;
import com.sams.promotions.platform.emulation.core.json_to_xml.JsonToXmlReserveImpl;
import com.sams.promotions.platform.emulation.util.mapper.EmulationSerializeHelper;
import com.sams.promotions.platform.emulation.util.soap.SOAPUtil;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(MockitoJUnitRunner.class)
public class JsonToXml{
		

	@Spy
	private EmulationSerializeHelper helper;
	
	@Spy
	private SOAPUtil soapUtil;
	
	@InjectMocks
	private JsonToXmlReserveImpl transform;
	
	
	protected String qs_response;
	protected String res;
	
	@Before
	public void setupBefore() {
		
		MockitoAnnotations.initMocks(this);
		
		ReserveHelper.get().resetRequestProperties();
		ReserveHelper.get().getRequestProperties()
			.put(MappingConstants.BASKET_ID_KEY, 1234L);
		ReserveHelper.get().getRequestProperties()
			.put(MappingConstants.CHANNEL_NAME_KEY, 
				ChannelConstants.DOTCOM_NAME);
		ReserveHelper.get().getRequestProperties().put(MappingConstants.CHANNEL_CODE_KEY, 2);
		soapUtil.setXmlDeclaration(SOAPUtil.DEFAULT_XML_DECLARATION);
		
	}
	
	@SuppressWarnings("deprecation")
	@Given("^Post JSON Request$")
	public void request() throws Exception {
		
		qs_response = loadResourceAsString(UrlConstants.JSON_TO_XML); 
	}
	
	@When("^Convert Payload$")
	public void convert() throws Exception {
		
		System.out.println("request:");
		
		res = transform.toSOAP(ReserveHelper.get().wrapResponse(qs_response));
				
	}
	
	@Then("^Check and compare XML Values$")
	public void Check() throws Exception {
		
		String response=Helper.getPrettyString(res);
		System.out.println(response);
		
	}
		
	
}
