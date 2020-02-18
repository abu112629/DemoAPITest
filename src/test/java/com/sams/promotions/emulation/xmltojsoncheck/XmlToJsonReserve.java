package com.sams.promotions.emulation.xmltojsoncheck;

import static com.sams.promotions.emulation.test.steps.util.UnitTestUtil.loadResourceAsString;
import static org.mockito.ArgumentMatchers.anyInt;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveHelper;
import com.sams.promotions.platform.emulation.core.ChannelAware;
import com.sams.promotions.platform.emulation.core.Lookup;
import com.sams.promotions.platform.emulation.core.xml_to_json.XmlToJsonReserveImpl;
import com.sams.promotions.platform.emulation.model.MutableMessage;
import com.sams.promotions.platform.emulation.model.mercury.wrappers.OrderApplyRequestWrapper;
import com.sams.promotions.platform.emulation.util.mapper.CurrencyUnitMapper;
import com.sams.promotions.platform.emulation.util.mapper.EmulationSerializeHelper;
import com.sams.promotions.platform.emulation.util.soap.SOAPUtil;
import com.walmart.sams.order.common.model.CurrencyUnitEnum;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

@RunWith(MockitoJUnitRunner.class)

public class XmlToJsonReserve {

	@Mock
	private CurrencyUnitMapper currencyUnitMapper;

	@Mock
	private ChannelAware channelAware;

	@Spy
	private SOAPUtil soapUtil;

	@Spy
	private EmulationSerializeHelper helper;

	@InjectMocks
	private XmlToJsonReserveImpl xmlToJsonHelperReserve;

	private static String inputreserve;

	@SuppressWarnings("deprecation")
	@Given("^Post XML Request$")
	public void Post_XML_Request() throws Exception {

		inputreserve = loadResourceAsString(UrlConstants.EMULATOR_CLUB);
		xmlToJsonHelperReserve = new XmlToJsonReserveImpl();
	}

	@When("^Reserve Promotion First Step$")
	public void reserveTestPromotion() throws Exception {

		MockitoAnnotations.initMocks(this);

		Mockito.doReturn(CurrencyUnitEnum.USD).when(currencyUnitMapper).mapCurrencyUnit(Mockito.nullable(String.class));
		Mockito.doReturn(Lookup.RESERVE_APPLY).when(channelAware).shouldLookup(anyInt());

		MutableMessage<OrderApplyRequestWrapper> test = xmlToJsonHelperReserve.fromSOAP(inputreserve);

		String jsonBody = ReserveHelper.get().unwrapRequest(test);

		String testjson = Helper.getPrettyJson(jsonBody);
		System.out.println(testjson.toString());

	}
}
