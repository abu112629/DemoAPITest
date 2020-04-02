package com.sams.promotions.emulation.test.helper;

import static com.sams.promotions.emulation.test.steps.util.UnitTestUtil.loadResourceAsString;
import static org.mockito.ArgumentMatchers.anyInt;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.Unmarshaller;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sams.promotions.emulation.analyticOffers.AnalyticItemDetail;
import com.sams.promotions.emulation.analyticOffers.AnalyticOffer;
import com.sams.promotions.emulation.analyticOffers.AnalyticOffers;
import com.sams.promotions.emulation.broadreachOffers.BroadReachOffer;
import com.sams.promotions.emulation.broadreachOffers.ItemDetail;
import com.sams.promotions.emulation.broadreachOffers.MetaDataResponse;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.CheckoutCustomerBasketRequest;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.OrderLine;
import com.sams.promotions.emulation.packageOffers.PackageItemDetail;
import com.sams.promotions.emulation.packageOffers.PackageOffer;
import com.sams.promotions.emulation.packageOffers.PackageOffers;
import com.sams.promotions.emulation.promoCreation.Action;
import com.sams.promotions.emulation.promoCreation.PromoCreationRequest;
import com.sams.promotions.emulation.quicksilverPromos.Item;
import com.sams.promotions.emulation.quicksilverPromos.QSPromos;
import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.steps.util.HeaderMapper;
import com.sams.promotions.emulation.test.steps.util.MemberShipNbrValidate;
import com.sams.promotions.emulation.triggerOffers.ItemDetails;
import com.sams.promotions.emulation.triggerOffers.TriggerOffer;
import com.sams.promotions.emulation.triggerOffers.TriggerOffer_;
import com.sams.promotions.platform.common.dateutil.DateUtil;
import com.sams.promotions.platform.emulation.core.ChannelAware;
import com.sams.promotions.platform.emulation.core.Lookup;
import com.sams.promotions.platform.emulation.core.constants.ChannelConstants;
import com.sams.promotions.platform.emulation.core.constants.MappingConstants;
import com.sams.promotions.platform.emulation.core.json_to_xml.JsonToXmlReserveImpl;
import com.sams.promotions.platform.emulation.core.xml_to_json.XmlToJsonReserveImpl;
import com.sams.promotions.platform.emulation.model.MutableMessage;
import com.sams.promotions.platform.emulation.model.mercury.wrappers.OrderApplyRequestWrapper;
import com.sams.promotions.platform.emulation.util.mapper.CurrencyUnitMapper;
import com.sams.promotions.platform.emulation.util.mapper.EmulationSerializeHelper;
import com.sams.promotions.platform.emulation.util.mapper.JaxBInitializer;
import com.sams.promotions.platform.emulation.util.soap.SOAPUtil;
import com.sams.promotions.platform.models.emulation.redeemoffers.Offer;
import com.sams.promotions.platform.models.emulation.redeemoffers.RedeemOffersRequest;
import com.walmart.mercury.api.dto.TransactionKeyAttributes;
import com.walmart.sams.order.common.model.CurrencyUnitEnum;

import cucumber.api.DataTable;
import groovy.util.logging.Slf4j;
import io.restassured.response.Response;

@Slf4j
@Component

public class ReserveEmulationHelper extends BaseStep {

	/*
	 * Author : Abu Description : Helper Method Date : 11/11/2019
	 * 
	 */

	public ReserveEmulationHelper() throws IOException {
		super();
	}

	private static String inputreserve;
	private static DateUtil dUtil;
	private static String testjson;

	protected long PromoNumber, Itemnumber, Mpq, PackageCode,maxRedemptionCount;
	protected ArrayList<String> arrList = new ArrayList<String>();
	protected float Discount;
	protected String[] expected;
	protected String StartDate, EndDate, arr[], postdata, postdata2,offerTypeDescription;
	protected int ItemId, Quantity, ItemId2, Quantity2;

	protected String conditionString, eligibilitycondition, name, value, limit, promotionItem,maxredcnt;

	@SuppressWarnings("unused")
	private Map<String, String> Items;

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

	@InjectMocks
	private JsonToXmlReserveImpl transform;

	private MemberShipNbrValidate membershipNbr;

	private static Unmarshaller xmlUnmarshaller;
	HeaderMapper headerMapper;
	private Helper helpermethod;
	private String res;

	@SuppressWarnings("deprecation")
	public String XMLtoJSON(String path) throws Exception {

		inputreserve = loadResourceAsString(path);
		xmlToJsonHelperReserve = new XmlToJsonReserveImpl();
		MockitoAnnotations.initMocks(this);

		Mockito.doReturn(CurrencyUnitEnum.USD).when(currencyUnitMapper).mapCurrencyUnit(Mockito.nullable(String.class));
		Mockito.doReturn(Lookup.RESERVE_APPLY).when(channelAware).shouldLookup(anyInt());

		MutableMessage<OrderApplyRequestWrapper> test = xmlToJsonHelperReserve.fromSOAP(inputreserve);

		String test2 = ReserveHelper.get().unwrapRequest(test);

		testjson = Helper.getPrettyJson(test2);

		return testjson;
	}

	@SuppressWarnings("deprecation")
	public String OrderNumber(String path) throws Exception {

		inputreserve = loadResourceAsString(path);
		xmlToJsonHelperReserve = new XmlToJsonReserveImpl();
		membershipNbr = new MemberShipNbrValidate();

		MockitoAnnotations.initMocks(this);

		Mockito.doReturn(CurrencyUnitEnum.USD).when(currencyUnitMapper).mapCurrencyUnit(Mockito.nullable(String.class));
		Mockito.doReturn(Lookup.RESERVE_APPLY).when(channelAware).shouldLookup(anyInt());

		dUtil = new DateUtil();
		TransactionKeyAttributes body = xmlToJsonHelperReserve.fromSOAP(inputreserve).getBody().getPayload()
				.getTransactionKeyAttributes();

		String membershipNBRFinal = null;
		membershipNBRFinal = membershipNbr.validateMembershipNbr(body.getMembershipId());
		String orderNumber = membershipNBRFinal + body.getRegistrationNumber() + body.getTransactionNumber()
				+ body.getClubId() + String.valueOf(dUtil.convertToJulian(body.getRedemptionDate()));

		return orderNumber;

	}

	public String convertJSONtoXML(String qs_response) throws Exception {

		MockitoAnnotations.initMocks(this);

		transform.afterPropertiesSet();
		ReserveHelper.get().resetRequestProperties();
		ReserveHelper.get().getRequestProperties().put(MappingConstants.BASKET_ID_KEY, "4116");
		ReserveHelper.get().getRequestProperties().put(MappingConstants.CHANNEL_NAME_KEY, ChannelConstants.DOTCOM_NAME);

		res = transform.toSOAP(ReserveHelper.get().wrapResponse(qs_response));

		String response = Helper.getPrettyString(res);

		return response;
	}

	public String RedeemRequestUpdater(String Reservepath, String Redeempath) throws Exception {

		helpermethod = new Helper();

		String xml = helpermethod.GenerateStringFromResource(Reservepath);

		xmlUnmarshaller = new JaxBInitializer().initUnmarshaller(CheckoutCustomerBasketRequest.class);

		soapUtil = new SOAPUtil();

		CheckoutCustomerBasketRequest request = soapUtil.unwrapSoap(xmlUnmarshaller, xml,
				CheckoutCustomerBasketRequest.class);
		
		int cod = request.getMessageBody().getCustomerBasket().getChannel().getCode();
		String code = String.valueOf(cod);
		String id = request.getMessageBody().getCustomerBasket().getCustomer().getId();
		String txTime = request.getMessageBody().getCustomerBasket().getCreateTimestamp();
		String terminalID = request.getMessageBody().getCustomerBasket().getBasketID();
		String number = request.getMessageBody().getCustomerBasket().getBusinessUnit().getNumber();
		String transactionCode = request.getMessageBody().getCustomerBasket().getTerminal().getTerminalID();

		List<OrderLine> list = request.getMessageBody().getCustomerBasket().getOrderLines();
		
		
		String redeemxml = helpermethod.GenerateStringFromResource(Redeempath);

		xmlUnmarshaller = new JaxBInitializer().initUnmarshaller(RedeemOffersRequest.class);
		soapUtil = new SOAPUtil();
		RedeemOffersRequest req = soapUtil.unwrapSoap(xmlUnmarshaller, redeemxml, RedeemOffersRequest.class);
		req.getMessageBody().getChannel().setCode(code);
		req.getMessageBody().getCustomerOrder().getCustomer().setId(id);
		req.getMessageBody().getCustomerOrder().getSalesTransaction().setTxTime(txTime);
		req.getMessageBody().getCustomerOrder().getSalesTransaction().getBusinessUnit().getBusinessUnitType()
				.getTerminal().setTerminalID(terminalID);
		req.getMessageBody().getCustomerOrder().getSalesTransaction().getBusinessUnit().setNumber(number);
		req.getMessageBody().getCustomerOrder().getSalesTransaction().setTransactionCode(transactionCode);

		List<Offer> listredeem = req.getMessageBody().getCustomerOrder().getOffers();
		

		for (Offer line : listredeem) {

			for (OrderLine lines : list) {

				String OfferId = lines.getProductOffering().getId();
				line.setId(OfferId);

			}

		}

		String req1 = soapUtil.wrapSoap(req);

		HashMap<String, String> customData = new HashMap<String, String>();
		customData.put("<soapenv:Header/>", "<soapenv:Header>\r\n"
				+ "		<wsse:Security soapenv:mustUnderstand=\"1\"\r\n"
				+ "			xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\r\n"
				+ "			<wsse:UsernameToken>\r\n" + "				<wsse:Username>MESPROD</wsse:Username>\r\n"
				+ "				<wsse:Password>RErahin6K</wsse:Password>\r\n" + "			</wsse:UsernameToken>\r\n"
				+ "		</wsse:Security>\r\n" + "	</soapenv:Header>");
		String req2 = helpermethod.updateRequest(customData, req1);
		System.out.println(Helper.getPrettyString(req2));
		return req1;

	}

	public String XMLRequestUpdater(int number, int ItemId, int RetailPrice, String BusinessUnit, String lineNumber,
			int code, String channelName, String Custid, String createTimestamp,

			String path) throws Exception {

		helpermethod = new Helper();

		BigInteger b1 = BigInteger.valueOf(number);
		String b2 = String.valueOf(ItemId);
		BigInteger b3 = BigInteger.valueOf(RetailPrice);

		xmlUnmarshaller = new JaxBInitializer().initUnmarshaller(CheckoutCustomerBasketRequest.class);

		String xml = helpermethod.GenerateStringFromResource(path);

		soapUtil = new SOAPUtil();

		CheckoutCustomerBasketRequest req = soapUtil.unwrapSoap(xmlUnmarshaller, xml,
				CheckoutCustomerBasketRequest.class);

		req.getMessageBody().getCustomerBasket().getBusinessUnit().setNumber(BusinessUnit);
		req.getMessageBody().getCustomerBasket().getChannel().setCode(code);
		req.getMessageBody().getCustomerBasket().getChannel().setName(channelName);
		req.getMessageBody().getCustomerBasket().getCustomer().setId(Custid);
		req.getMessageBody().getCustomerBasket().setCreateTimestamp(createTimestamp);

		List<OrderLine> list = req.getMessageBody().getCustomerBasket().getOrderLines();

		for (OrderLine line : list) {

			line.setLineNumber(lineNumber);
			line.getQuantity().setAmount(b1);
			line.getProductOffering().setId(b2);
			line.getProductOffering().getPrice().getAmount().setValue(b3);

		}

		String req1 = soapUtil.wrapSoap(req);
		HashMap<String, String> customData = new HashMap<String, String>();
		customData.put("<soapenv:Header/>", " <soapenv:Header>\r\n"
				+ "      <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\r\n"
				+ "         <wsse:UsernameToken>\r\n"
				+ "            <wsse:Username>SVCSamsInstantSaving</wsse:Username>\r\n"
				+ "            <wsse:Password>qtayWn-wW7+%*NAbs1W1</wsse:Password>\r\n"
				+ "         </wsse:UsernameToken>\r\n" + "      </wsse:Security>\r\n" + "   </soapenv:Header>");
		String req2 = helpermethod.updateRequest(customData, req1);
		System.out.println(Helper.getPrettyString(req2));

		return req2;

	}
	
	
	public String ReserveRequestUpdater(int number, int ItemId, int RetailPrice, String BusinessUnit, String lineNumber,
			int code, String channelName, String Custid, String createTimestamp,String BasketId,String terminalID,

			String path) throws Exception {

		helpermethod = new Helper();

		BigInteger b1 = BigInteger.valueOf(number);
		String b2 = String.valueOf(ItemId);
		BigInteger b3 = BigInteger.valueOf(RetailPrice);

		xmlUnmarshaller = new JaxBInitializer().initUnmarshaller(CheckoutCustomerBasketRequest.class);

		String xml = helpermethod.GenerateStringFromResource(path);

		soapUtil = new SOAPUtil();

		CheckoutCustomerBasketRequest req = soapUtil.unwrapSoap(xmlUnmarshaller, xml,
				CheckoutCustomerBasketRequest.class);
		req.getMessageBody().getCustomerBasket().setBasketID(BasketId);
		req.getMessageBody().getCustomerBasket().getTerminal().setTerminalID(terminalID);
		req.getMessageBody().getCustomerBasket().getBusinessUnit().setNumber(BusinessUnit);
		req.getMessageBody().getCustomerBasket().getChannel().setCode(code);
		req.getMessageBody().getCustomerBasket().getChannel().setName(channelName);
		req.getMessageBody().getCustomerBasket().getCustomer().setId(Custid);
		req.getMessageBody().getCustomerBasket().setCreateTimestamp(createTimestamp);

		List<OrderLine> list = req.getMessageBody().getCustomerBasket().getOrderLines();

		for (OrderLine line : list) {

			line.setLineNumber(lineNumber);
			line.getQuantity().setAmount(b1);
			line.getProductOffering().setId(b2);
			line.getProductOffering().getPrice().getAmount().setValue(b3);

		}

		String req1 = soapUtil.wrapSoap(req);
		HashMap<String, String> customData = new HashMap<String, String>();
		customData.put("<soapenv:Header/>", " <soapenv:Header>\r\n"
				+ "      <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\r\n"
				+ "         <wsse:UsernameToken>\r\n"
				+ "            <wsse:Username>SVCSamsInstantSaving</wsse:Username>\r\n"
				+ "            <wsse:Password>qtayWn-wW7+%*NAbs1W1</wsse:Password>\r\n"
				+ "         </wsse:UsernameToken>\r\n" + "      </wsse:Security>\r\n" + "   </soapenv:Header>");
		String req2 = helpermethod.updateRequest(customData, req1);
		System.out.println(Helper.getPrettyString(req2));

		return req2;

	}

	public String XMLRequestUpdaternew(int number, int ItemId, int RetailPrice, String BusinessUnit, String lineNumber,
			String xml) throws Exception {

		helpermethod = new Helper();

		BigInteger b1 = BigInteger.valueOf(number);
		String b2 = String.valueOf(ItemId);
		BigInteger b3 = BigInteger.valueOf(RetailPrice);

		xmlUnmarshaller = new JaxBInitializer().initUnmarshaller(CheckoutCustomerBasketRequest.class);

		soapUtil = new SOAPUtil();

		CheckoutCustomerBasketRequest req = soapUtil.unwrapSoap(xmlUnmarshaller, xml,
				CheckoutCustomerBasketRequest.class);

		req.getMessageBody().getCustomerBasket().getBusinessUnit().setNumber(BusinessUnit);

		List<OrderLine> list = req.getMessageBody().getCustomerBasket().getOrderLines();

		OrderLine orderLine = list.stream().findFirst().get();
		OrderLine orderLineClone = (OrderLine) orderLine.clone();
		orderLineClone.setLineNumber(lineNumber);
		orderLineClone.getQuantity().setAmount(b1);
		orderLineClone.getProductOffering().setId(b2);
		orderLineClone.getProductOffering().getPrice().getAmount().setValue(b3);

		list.add(orderLineClone);

		String req1 = soapUtil.wrapSoap(req);
		HashMap<String, String> customData = new HashMap<String, String>();
		customData.put("<soapenv:Header/>", " <soapenv:Header>\r\n"
				+ "      <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\r\n"
				+ "         <wsse:UsernameToken>\r\n"
				+ "            <wsse:Username>SVCSamsInstantSaving</wsse:Username>\r\n"
				+ "            <wsse:Password>qtayWn-wW7+%*NAbs1W1</wsse:Password>\r\n"
				+ "         </wsse:UsernameToken>\r\n" + "      </wsse:Security>\r\n" + "   </soapenv:Header>");
		String req2 = helpermethod.updateRequest(customData, req1);
		System.out.println(Helper.getPrettyString(req2));

		return req2;

	}

	public String PromoCreationRequestPayload(DataTable dataTable) throws Exception {

		helpermethod = new Helper();

		int x = Helper.generateRandomDigits(6);
		List<Map<String, String>> elements = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> promo : elements) {
			conditionString = promo.get("Condition String");
			eligibilitycondition = promo.get("eligibility Condition");
			name = promo.get("PromoName");
			value = promo.get("AwardValue");
			limit = promo.get("Discount limit");
			promotionItem = promo.get("Promotion ItemNumber");

		}

		String promoJson = helpermethod.GenerateStringFromResource(UrlConstants.JSON_PROMOTION_FILE);
		ObjectMapper objectmapper = new ObjectMapper();

		PromoCreationRequest promo = objectmapper.readValue(promoJson, PromoCreationRequest.class);
		promo.getPayload().setConditionString(conditionString);
		promo.getPayload().setEligiblityConditionString(eligibilitycondition);
		promo.getPayload().setName(name + "_" + x);
		promo.getPayload().setDescription(name + "_" + x);
		promo.getPayload().setPromotionNumber(x);
		List<Action> list = promo.getPayload().getActions();

		for (Action line : list) {

			line.getAward().setValue(Integer.valueOf(value));
			line.getAward().setDiscountLimit(Integer.valueOf(limit));
			line.getAward().setPromotionItemNumber(promotionItem);

		}

		return objectmapper.writeValueAsString(promo);
	}

	public String BroadReachPromoMetaData(String Uri, int index) throws JsonParseException, JsonMappingException, IOException {

		headerMapper = new HeaderMapper();
		helpermethod = new Helper();

		Map<String, Object> header = headerMapper.mapHeaders(UrlConstants.METADATA_HEADER_PATH);
		
		//UrlConstants.METADATA_PROMOTION_BROADREACH
		
		Response res = helpermethod.sendGetRequest(Uri, UrlConstants.METADATA_PROMOTION_BROADREACH, header);
		String metadataJson = res.asString();

		ObjectMapper objectmapper = new ObjectMapper();
		MetaDataResponse metadata = objectmapper.readValue(metadataJson, MetaDataResponse.class);
		List<BroadReachOffer> list = metadata.getBroadReachOffers();

		for (BroadReachOffer line : list) {

			
			PromoNumber = line.getCouponNumber();
			Discount = line.getCouponValue();
			StartDate = line.getStartDate();
			EndDate = line.getEndDate();
			PackageCode = line.getPackageCode();
			maxRedemptionCount=line.getMaxRedemptionCount();
			offerTypeDescription=line.getOfferTypeDescription();
			
			maxredcnt=String.valueOf(maxRedemptionCount);
			String ite = null;
			String mpq = null;

			if (line.getMerchandiseDetails().getItemDetails() != null) {
				List<ItemDetail> item = line.getMerchandiseDetails().getItemDetails();
				int i = 0;
				for (ItemDetail linenew : item) {

					i++;
					if (i > 1) {
						break;
					}
					Itemnumber = linenew.getItemNumber();
					Mpq = linenew.getMinimumPurchaseQuantity();
					ite = String.valueOf(Itemnumber);
					mpq = String.valueOf(Mpq);
					arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
							+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
					arrList.add(arr[0].toString()); 

				}
			}

			else {
				arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
						+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
				arrList.add(arr[0].toString());

			}

		}

		return arrList.get(index) + "||" + arrList.size();

	}
	
	public String TriggerPromoMetaData(String Uri, int index) throws JsonParseException, JsonMappingException, IOException {

		headerMapper = new HeaderMapper();
		helpermethod = new Helper();

		ArrayList<String> arrList = new ArrayList<String>();
		String arr[]=null;
		Map<String, Object> header = headerMapper.mapHeaders(UrlConstants.METADATA_HEADER_PATH);

		Response res = helpermethod.sendGetRequest(Uri, UrlConstants.METADATA_PROMOTION_TRIGGERS, header);
		String metadataJson = res.asString();

		ObjectMapper objectmapper = new ObjectMapper();
		TriggerOffer metadata = objectmapper.readValue(metadataJson, TriggerOffer.class);
		List<TriggerOffer_> list = metadata.getTriggerOffers();

		for (TriggerOffer_ line : list) {

			long PromoNumber = line.getCouponNumber();
			float Discount = line.getCouponValue();
			String StartDate = line.getStartDate();
			String EndDate = line.getEndDate();
			long PackageCode = line.getPackageCode();
			long maxRedemptionCount=line.getMaxRedemptionCount();
			String maxredcnt=String.valueOf(maxRedemptionCount);
			String offerTypeDescription=line.getOfferTypeDescription();
		
			String ite = null;
			String mpq = null;

			if (line.getMerchandiseDetails().getItemDetails() != null) {				

				List<ItemDetails> item = line.getMerchandiseDetails().getItemDetails();
				int i = 0;
				for (ItemDetails linenew : item) {

					
					i++;
					if (i > 1) {
						break;
					}
					Itemnumber = linenew.getItemNumber();
					Mpq = linenew.getMinimumPurchaseQuantity();
					ite = String.valueOf(Itemnumber);
					mpq = String.valueOf(Mpq);
					arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
							+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
					arrList.add(arr[0].toString()); 

				}
			}

			else {
				arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
						+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
				arrList.add(arr[0].toString());

			}

		}

		return arrList.get(index) + "||" + arrList.size();

	}
	
	public String AnalyticPromoMetaData(String Uri, int index) throws JsonParseException, JsonMappingException, IOException {

		headerMapper = new HeaderMapper();
		helpermethod = new Helper();

		ArrayList<String> arrList = new ArrayList<String>();
		String arr[]=null;
		
		Map<String, Object> header = headerMapper.mapHeaders(UrlConstants.METADATA_HEADER_PATH);

		Response res = helpermethod.sendGetRequest(Uri, UrlConstants.METADATA_PROMOTION_ANALYTIC, header);
		String metadataJson = res.asString();

		ObjectMapper objectmapper = new ObjectMapper();
		AnalyticOffers metadata = objectmapper.readValue(metadataJson, AnalyticOffers.class);
		List<AnalyticOffer> list = metadata.getAnalyticOffers();

		for (AnalyticOffer line : list) {
			
			long PromoNumber = line.getCouponNumber();
			float Discount = line.getCouponValue();
			String StartDate = line.getStartDate();
			String EndDate = line.getEndDate();
			long PackageCode = line.getPackageCode();
			long maxRedemptionCount=line.getMaxRedemptionCount();
			String maxredcnt=String.valueOf(maxRedemptionCount);
			
			String offerTypeDescription=line.getOfferTypeDescription();


			String ite = null;
			String mpq = null;

			if (line.getMerchandiseDetails().getItemDetails() != null) {
				List<AnalyticItemDetail> item = line.getMerchandiseDetails().getItemDetails();
				int i = 0;
				for (AnalyticItemDetail linenew : item) {				

					i++;
					if (i > 1) {
						break;
					}
					Itemnumber = linenew.getItemNumber();
					Mpq = linenew.getMinimumPurchaseQuantity();
					ite = String.valueOf(Itemnumber);
					mpq = String.valueOf(Mpq);
					arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
							+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
					arrList.add(arr[0].toString()); 

				}
			}

			else {
				arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
						+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
				arrList.add(arr[0].toString());

			}

		}

		return arrList.get(index) + "||" + arrList.size();

	}

	public String PackagePromoMetaData(String Uri,String parameter,int index) throws JsonParseException, JsonMappingException, IOException {

		headerMapper = new HeaderMapper();
		helpermethod = new Helper();

		ArrayList<String> arrList = new ArrayList<String>();
		String arr[]=null;
		
		Map<String, Object> header = headerMapper.mapHeaders(UrlConstants.METADATA_HEADER_PATH);

		//UrlConstants.METADATA_PROMOTION_PACKAGE
		Response res = helpermethod.sendGetRequest(Uri, parameter, header);
		String metadataJson = res.asString();

		ObjectMapper objectmapper = new ObjectMapper();
		PackageOffers metadata = objectmapper.readValue(metadataJson, PackageOffers.class);
		List<PackageOffer> list = metadata.getPackageOffers();

		for (PackageOffer line : list) {
			
			long PromoNumber = line.getCouponNumber();
			float Discount = line.getCouponValue();
			String StartDate = line.getStartDate();
			String EndDate = line.getEndDate();
			long PackageCode=line.getPackageCode();
			/*
			 * if (line.getPackageCode()!=null) {
			 * 
			 * PackageCode=line.getPackageCode(); } else {
			 * 
			 * PackageCode=0; }
			 */
			long maxRedemptionCount=line.getMaxRedemptionCount();
			/*
			 * String maxredcnt;
			 * 
			 * if (line.getPackageCode()!=null) {
			 * 
			 * maxredcnt=String.valueOf(maxRedemptionCount); } else {
			 * 
			 * maxredcnt=null; }
			 */
			
			
			String offerTypeDescription=line.getOfferTypeDescription();
			
			String maxredcnt=String.valueOf(maxRedemptionCount);
			String ite = null;
			String mpq = null;

			if (line.getMerchandiseDetails().getItemDetails() != null) {
				List<PackageItemDetail> item = line.getMerchandiseDetails().getItemDetails();
				int i = 0;
				for (PackageItemDetail linenew : item) {				
					
					
					i++;
					if (i > 1) {
						break;
					}
					Itemnumber = linenew.getItemNumber();
					Mpq = linenew.getMinimumPurchaseQuantity();
					ite = String.valueOf(Itemnumber);
					mpq = String.valueOf(Mpq);
					arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
							+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
					arrList.add(arr[0].toString()); 

				}
			}

			else {
				arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
						+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
				arrList.add(arr[0].toString());

			}

		}

		return arrList.get(index) + "||" + arrList.size();

	}
	
	public String QSPromoMetaData(String Uri,int index) throws JsonParseException, JsonMappingException, IOException {

		headerMapper = new HeaderMapper();
		helpermethod = new Helper();
		
		ArrayList<String> arrList = new ArrayList<String>();
		String arr[]=null;
		
		Long QSOfferId=null;
		
		Map<String, Object> header = headerMapper.mapHeaders(UrlConstants.QSPROMO_HEADER_PATH);

		Response res = helpermethod.sendGetRequest(Uri, UrlConstants.PROMO_CREATION, header);
		String metadataJson = res.asString();

		ObjectMapper objectmapper = new ObjectMapper();
		QSPromos metadata = objectmapper.readValue(metadataJson, QSPromos.class);
		List<Item> list=metadata.getPayload().getItems();
		
		for(Item line : list) {
			
			QSOfferId=line.getPromotionNumber();
			
			String Total = String.valueOf(metadata.getPayload().getTotal());
			arr = new String[] {QSOfferId+ "||" + Total}; 
			arrList.add(arr[0].toString());
			
		}
		
		
		

		return arrList.get(index);

	}
	
	public Map<String, String> getPostRequestDetails(int i, String membershipNumber, String channelName, String ClubId,
			String ClubId2, int code, int RetailPrice, String lineNumber, String Applied_Dates, String OfferId,
			String pathsingle) throws Exception {


		String arrx = BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), i);

		Map<String, String> promodetails = Helper.getPromotionDetails(arrx);

		if (promodetails.get("ItemId").contentEquals("null")) {

			ItemId = 772543;

		}

		else {
			ItemId = Integer.valueOf(promodetails.get("ItemId"));
		}

		Map<String, String> map = Helper.getDatesMetadata(arrx);

		String packagecode = promodetails.get("PackageCode");

		Double Discount = Double.valueOf(promodetails.get("Discount"))*100;
		int disc = (int) Math.abs(Discount);
		OfferId = promodetails.get("PromoId");

		Quantity = Integer.valueOf(promodetails.get("MinimumPurchaseQuantity"));

		switch (Applied_Dates) {
		
		case "FIRST_DATE":
			postdata = XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code, channelName,
					membershipNumber, map.get("firstdate"), pathsingle);
			postdata2 = XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId2, lineNumber, code, channelName,
					membershipNumber, map.get("firstdate"), pathsingle);
			
			expected = new String[] { OfferId, String.valueOf(disc) };
			

			break;
		case "MIDDLE_DATE":

			postdata = XMLRequestUpdater(Quantity * 2, ItemId, RetailPrice, ClubId, lineNumber, code, channelName,
					membershipNumber, map.get("midDate"), pathsingle);

			postdata2 = XMLRequestUpdater(Quantity * 2, ItemId, RetailPrice, ClubId2, lineNumber, code, channelName,
					membershipNumber, map.get("midDate"), pathsingle);

			int SecondDiscountfirstline = disc * 2;
			String discount2 = String.valueOf(SecondDiscountfirstline);

			expected = new String[] { OfferId, discount2 };

			break;
		case "LAST_DATE":
			postdata = XMLRequestUpdater(Quantity * 3, ItemId, RetailPrice, ClubId, lineNumber, code, channelName,
					membershipNumber, map.get("lastdate"), pathsingle);

			postdata2 = XMLRequestUpdater(Quantity * 3, ItemId, RetailPrice, ClubId2, lineNumber, code, channelName,
					membershipNumber, map.get("lastdate"), pathsingle);

			int ThirdDiscountfirstline = disc * 3;
			String discount3 = String.valueOf(ThirdDiscountfirstline);

			expected = new String[] { OfferId, discount3 };

			break;

		}

		Map<String, String> postrequestDetails = new HashMap<String, String>();

		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);
		postrequestDetails.put("PackageCode", packagecode);
		postrequestDetails.put("OfferId", OfferId);
		postrequestDetails.put("expected", Arrays.toString(expected));

		return postrequestDetails;

	}
	
	
	/*alternate*/
	
	public Map<String, String> getReserveRequestDetails(int i, String membershipNumber, String channelName, String ClubId,
			String ClubId2, int code, String RetailPrice, String lineNumber, String Applied_Dates,String BasketId,String terminalID,String arrx,
			String pathsingle) throws Exception {


		//String arrx = BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), i);
		helpermethod = new Helper();

		Map<String, String> promodetails = Helper.getPromotionDetails(arrx);

		if (promodetails.get("ItemId").contentEquals("null")) {

			ItemId = 772543;

		}

		else {
			ItemId = Integer.valueOf(promodetails.get("ItemId"));
		}

		Map<String, String> map = Helper.getDatesMetadata(arrx);
		Map<String, String> maprx = helpermethod.getRetailPrice(arrx);

		Quantity = Integer.valueOf(promodetails.get("MinimumPurchaseQuantity"));
		

		switch (RetailPrice) {
		
		case "SAME_PRICE":
			
		switch (Applied_Dates) {
		
		case "FIRST_DATE":
			postdata = ReserveRequestUpdater(Quantity, ItemId, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId, lineNumber, code, channelName,
					membershipNumber, map.get("firstdate"),BasketId, terminalID,pathsingle);
			postdata2 = ReserveRequestUpdater(Quantity, ItemId, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId2, lineNumber, code, channelName,
					membershipNumber, map.get("firstdate"), BasketId,terminalID,pathsingle);
			

			break;
			
		case "MIDDLE_DATE":

			postdata = ReserveRequestUpdater(Quantity * 2, ItemId, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId, lineNumber, code, channelName,
					membershipNumber, map.get("midDate"), BasketId, terminalID,pathsingle);

			postdata2 = ReserveRequestUpdater(Quantity * 2, ItemId, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId2, lineNumber, code, channelName,
					membershipNumber, map.get("midDate"), BasketId, terminalID,pathsingle);


			break;
			
		case "LAST_DATE":
			postdata = ReserveRequestUpdater(Quantity * 3, ItemId, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId, lineNumber, code, channelName,
					membershipNumber, map.get("lastdate"), BasketId, terminalID,pathsingle);

			postdata2 = ReserveRequestUpdater(Quantity * 3, ItemId, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId2, lineNumber, code, channelName,
					membershipNumber, map.get("lastdate"),BasketId, terminalID, pathsingle);


			break;

		}
		break;
		
		case "LESS_PRICE":
			switch (Applied_Dates) {
			
			case "FIRST_DATE":
				postdata = ReserveRequestUpdater(Quantity, ItemId, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId, lineNumber, code, channelName,
						membershipNumber, map.get("firstdate"),BasketId, terminalID,pathsingle);
				postdata2 = ReserveRequestUpdater(Quantity, ItemId, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId2, lineNumber, code, channelName,
						membershipNumber, map.get("firstdate"), BasketId,terminalID,pathsingle);
				

				break;
				
			case "MIDDLE_DATE":

				postdata = ReserveRequestUpdater(Quantity * 2, ItemId, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId, lineNumber, code, channelName,
						membershipNumber, map.get("midDate"), BasketId, terminalID,pathsingle);

				postdata2 = ReserveRequestUpdater(Quantity * 2, ItemId, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId2, lineNumber, code, channelName,
						membershipNumber, map.get("midDate"), BasketId, terminalID,pathsingle);


				break;
				
			case "LAST_DATE":
				postdata = ReserveRequestUpdater(Quantity * 3, ItemId, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId, lineNumber, code, channelName,
						membershipNumber, map.get("lastdate"), BasketId, terminalID,pathsingle);

				postdata2 = ReserveRequestUpdater(Quantity * 3, ItemId, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId2, lineNumber, code, channelName,
						membershipNumber, map.get("lastdate"),BasketId, terminalID, pathsingle);


				break;

			}
			break;
			
		case "MORE_PRICE":
			
			switch (Applied_Dates) {
			
			case "FIRST_DATE":
				postdata = ReserveRequestUpdater(Quantity, ItemId, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId, lineNumber, code, channelName,
						membershipNumber, map.get("firstdate"),BasketId, terminalID,pathsingle);
				postdata2 = ReserveRequestUpdater(Quantity, ItemId, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId2, lineNumber, code, channelName,
						membershipNumber, map.get("firstdate"), BasketId,terminalID,pathsingle);
				

				break;
				
			case "MIDDLE_DATE":

				postdata = ReserveRequestUpdater(Quantity * 2, ItemId, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId, lineNumber, code, channelName,
						membershipNumber, map.get("midDate"), BasketId, terminalID,pathsingle);

				postdata2 = ReserveRequestUpdater(Quantity * 2, ItemId, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId2, lineNumber, code, channelName,
						membershipNumber, map.get("midDate"), BasketId, terminalID,pathsingle);


				break;
				
			case "LAST_DATE":
				postdata = ReserveRequestUpdater(Quantity * 3, ItemId, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId, lineNumber, code, channelName,
						membershipNumber, map.get("lastdate"), BasketId, terminalID,pathsingle);

				postdata2 = ReserveRequestUpdater(Quantity * 3, ItemId, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId2, lineNumber, code, channelName,
						membershipNumber, map.get("lastdate"),BasketId, terminalID, pathsingle);


				break;

			}
			break;
			
			
		
		}
		Map<String, String> postrequestDetails = new HashMap<String, String>();

		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);

		return postrequestDetails;

	}

}
