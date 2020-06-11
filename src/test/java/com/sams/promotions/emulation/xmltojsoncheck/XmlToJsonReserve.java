package com.sams.promotions.emulation.xmltojsoncheck;

import static com.sams.promotions.emulation.test.steps.util.UnitTestUtil.loadResourceAsString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import java.time.format.DateTimeFormatter;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.steps.util.ReserveTestHelper;
import com.sams.promotions.platform.emulation.core.ChannelAware;
import com.sams.promotions.platform.emulation.core.Lookup;
import com.sams.promotions.platform.emulation.core.helpers.ReserveHelper;
import com.sams.promotions.platform.emulation.core.xml_to_json.XmlToJsonReserveImpl;
import com.sams.promotions.platform.emulation.model.MutableMessage;
import com.sams.promotions.platform.emulation.model.mercury.wrappers.OrderApplyRequestWrapper;
import com.sams.promotions.platform.emulation.util.mapper.CurrencyUnitMapper;
import com.sams.promotions.platform.emulation.util.mapper.EmulationSerializeHelper;
import com.sams.promotions.platform.emulation.util.soap.SOAPUtil;
import com.sams.promotions.platform.emulation.util.validator.impl.ReserveRequestValidator;
import com.walmart.sams.order.common.model.CurrencyUnitEnum;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

@RunWith(MockitoJUnitRunner.class)

public class XmlToJsonReserve {
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Mock
	private CurrencyUnitMapper currencyUnitMapper;

	@Mock
	private ChannelAware channelAware;
	
	@Mock
	private ReserveHelper reserveHelper;

	@Spy
	private SOAPUtil soapUtil;

	@Spy
	private EmulationSerializeHelper helper;


	private XmlToJsonReserveImpl xmlToJsonHelperReserve;
	
	private ReserveRequestValidator validator;
	
	private DateTimeFormatter dateTimeFormatter;

	private static String inputreserve;
	
	
	@Before()
	public void BeforeTest() throws Exception{
		
		
		validator = new ReserveRequestValidator();
		dateTimeFormatter = EmulationSerializeHelper.getDateTimeFormmatter();
		
	}

	@SuppressWarnings("deprecation")
	@Given("^Post XML Request$")
	public void Post_XML_Request() throws Exception {

		inputreserve = loadResourceAsString(UrlConstants.EMULATOR_CLUB);		
		
	}

	@When("^Reserve Promotion First Step$")
	public void reserveTestPromotion() throws Exception {

		MockitoAnnotations.initMocks(this);
		xmlToJsonHelperReserve = new XmlToJsonReserveImpl(
				currencyUnitMapper, soapUtil, helper, reserveHelper, validator, dateTimeFormatter);
		Mockito.doReturn(CurrencyUnitEnum.USD)
			.when(currencyUnitMapper).mapCurrencyUnit(Mockito.nullable(String.class));
		Mockito.doReturn(Lookup.RESERVE_APPLY)
			.when(reserveHelper).shouldLookup(anyInt(), anyString());
		
		
		MutableMessage<OrderApplyRequestWrapper> request = xmlToJsonHelperReserve.fromSOAP(inputreserve);
		String jsonBody = ReserveTestHelper.get().unwrapRequest(request);
		System.out.println(jsonBody);

	}
}
