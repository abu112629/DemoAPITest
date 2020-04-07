package com.sams.promotions.emulation.test.helper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.AuthTokenConstants;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.platform.emulation.util.mapper.JaxBInitializer;
import com.sams.promotions.platform.emulation.util.soap.SOAPUtil;
import com.sams.promotions.platform.models.emulation.checkoutcustomerbasket.response.CheckoutCustomerBasketResponse;
import com.sams.promotions.platform.models.emulation.checkoutcustomerbasket.response.Offer;
import com.sams.promotions.platform.models.emulation.checkoutcustomerbasket.response.OrderLine;

import cucumber.api.DataTable;
import groovy.util.logging.Slf4j;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Slf4j
@Component

public class Helper extends BaseStep {

	/*
	 * Author : Abu Description : Helper Method Date : 11/11/2019
	 * 
	 */

	public Helper() throws IOException {
		super();
	}

	protected RequestSpecification thisRequestSpecification;

	@SuppressWarnings("unused")
	private Map<String, String> Items;

	private String qs_response;
	protected String[] actual;
	protected String offerDes, disc, offerId, gtin, gs1Code, firstdate, midDate, lastdate;

	public String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));

	}

	public XmlPath rawToXML(Response r) {

		String response = r.asString();
		XmlPath xp = new XmlPath(response);
		return xp;

	}

	public JsonPath rawToJSON(Response r) {

		String response = r.asString();
		JsonPath jp = new JsonPath(response);
		return jp;

	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}

	public static Map<String, String> getDates(String requiredDates) throws java.text.ParseException {

		Map<String, String> ReqDates = new HashMap<String, String>();
		String[] abc = requiredDates.split(Pattern.quote("||"));
		// System.out.println(abc[0]);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date MidDate = format.parse(abc[0]);
		Date firstDate = format.parse(abc[0]);
		Date lastDate = format.parse(abc[1]);
		MidDate = addDays(MidDate, 1);

		String firstdate = outputFormat.format(firstDate);
		String midDate = outputFormat.format(MidDate);
		String lastdate = outputFormat.format(lastDate);

		ReqDates.put("firstdate", firstdate);
		ReqDates.put("midDate", midDate);
		ReqDates.put("lastdate", lastdate);

		return ReqDates;

	}

	public static Map<String, String> getDatesMetadata(String arr) throws java.text.ParseException {

		Map<String, String> ReqDates = new HashMap<String, String>();

		Map<String, String> mapx = Helper.getPromotionDetails(arr);
		String stdate = mapx.get("StartDate");
		String enddt = mapx.get("EndDate");

		// System.out.println(abc[0]);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date MidDate = format.parse(stdate);
		Date firstDate = format.parse(stdate);
		Date lastDate = format.parse(enddt);
		MidDate = addDays(MidDate, 1);

		String firstdate = outputFormat.format(firstDate);
		String midDate = outputFormat.format(MidDate);
		String lastdate = outputFormat.format(lastDate);

		ReqDates.put("firstdate", firstdate);
		ReqDates.put("midDate", midDate);
		ReqDates.put("lastdate", lastdate);

		return ReqDates;

	}

	public Map<String, String> getRetailPrice(String arrx) throws java.text.ParseException {

		String SameRetailPrice, LessRetailPrice, MoreRetailPrice;

		Map<String, String> RetailPrices = new HashMap<String, String>();

		Map<String, String> mapx = Helper.getPromotionDetails(arrx);
		String retailPx = mapx.get("Discount");

		DecimalFormat format = new DecimalFormat("0.#");

		float retpx = Float.valueOf(retailPx) * 100;
		float SameRetailPx = retpx;
		float LessRetailPx = retpx - 100;
		float MoreRetailPx = retpx + 100;

		SameRetailPrice = format.format(SameRetailPx);

		LessRetailPrice = format.format(LessRetailPx);

		MoreRetailPrice = format.format(MoreRetailPx);

		RetailPrices.put("SameRetailPrice", SameRetailPrice);
		RetailPrices.put("LessRetailPrice", LessRetailPrice);
		RetailPrices.put("MoreRetailPrice", MoreRetailPrice);

		return RetailPrices;

	}

	public Map<String, String> getDatesDoubleLinesMetadata(String arrx, String arry) throws java.text.ParseException {

		Map<String, String> ReqDates = new HashMap<String, String>();

		Map<String, String> mapx = Helper.getPromotionDetails(arrx);
		String stdate = mapx.get("StartDate");
		String enddt = mapx.get("EndDate");

		Map<String, String> mapy = Helper.getPromotionDetails(arry);
		String strdate = mapy.get("StartDate");
		String enddat = mapy.get("EndDate");
		// System.out.println(abc[0]);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date MidDate = format.parse(stdate);
		Date firstDate = format.parse(stdate);
		Date lastDate = format.parse(enddt);
		MidDate = addDays(MidDate, 1);

		Date MidDate2 = format.parse(strdate);
		Date firstDate2 = format.parse(strdate);
		Date lastDate2 = format.parse(enddat);
		MidDate2 = addDays(MidDate2, 1);

		if (firstDate.compareTo(firstDate2) < 0) {
			firstdate = outputFormat.format(firstDate2);
		}

		else {
			firstdate = outputFormat.format(firstDate);

		}

		if (MidDate.compareTo(MidDate2) < 0) {

			midDate = outputFormat.format(MidDate2);
		}

		else {

			midDate = outputFormat.format(MidDate);
		}

		if (lastDate.compareTo(lastDate2) < 0) {

			lastdate = outputFormat.format(lastDate);
		} else {
			lastdate = outputFormat.format(lastDate2);
		}

		ReqDates.put("firstdate", firstdate);
		ReqDates.put("midDate", midDate);
		ReqDates.put("lastdate", lastdate);

		return ReqDates;

	}

	public Map<String, String> getRetailPriceMetadata(String arrx, String arry) throws java.text.ParseException {

		String SameRetailPrice, LessRetailPrice, MoreRetailPrice;

		Map<String, String> RetailPrices = new HashMap<String, String>();

		Map<String, String> mapx = Helper.getPromotionDetails(arrx);
		String retailPx = mapx.get("Discount");

		Map<String, String> mapy = Helper.getPromotionDetails(arry);
		String retailPy = mapy.get("Discount");

		DecimalFormat format = new DecimalFormat("0.#");

		float retpx = Float.valueOf(retailPx) * 100;
		float retpy = Float.valueOf(retailPy) * 100;

		float SameRetailPx = retpx;
		float LessRetailPx = retpx - 100;
		float MoreRetailPx = retpx + 100;

		float SameRetaily = retpy;
		float LessRetailPy = retpy - 100;
		float MoreRetailPy = retpy + 100;

		if (Float.compare(SameRetailPx, SameRetaily) < 0) {
			SameRetailPrice = format.format(SameRetaily);
		}

		else {
			SameRetailPrice = format.format(SameRetailPx);

		}

		if (Float.compare(LessRetailPx, LessRetailPy) < 0) {

			LessRetailPrice = format.format(LessRetailPx);
		}

		else {

			LessRetailPrice = format.format(LessRetailPy);
		}

		if (Float.compare(MoreRetailPx, MoreRetailPy) < 0) {

			MoreRetailPrice = format.format(MoreRetailPy);
		} else {
			MoreRetailPrice = format.format(MoreRetailPx);
		}

		RetailPrices.put("SameRetailPrice", SameRetailPrice);
		RetailPrices.put("LessRetailPrice", LessRetailPrice);
		RetailPrices.put("MoreRetailPrice", MoreRetailPrice);

		return RetailPrices;

	}

	public static Map<String, String> getPromotionDetails(String promotion) throws java.text.ParseException {

		Map<String, String> promotionDetails = new HashMap<String, String>();
		String[] abc = promotion.split(Pattern.quote("||"));

		promotionDetails.put("PromoId", abc[0]);
		promotionDetails.put("Discount", abc[1]);
		promotionDetails.put("StartDate", abc[2]);
		promotionDetails.put("EndDate", abc[3]);
		promotionDetails.put("ItemId", abc[4]);
		promotionDetails.put("MinimumPurchaseQuantity", abc[5]);
		promotionDetails.put("PackageCode", abc[6]);
		promotionDetails.put("MaxRedemptionCount", abc[7]);
		promotionDetails.put("offerTypeDescription", abc[8]);
		promotionDetails.put("SizeOfMetaData", abc[9]);

		return promotionDetails;

	}

	public static Map<String, String> getQSPromotionDetails(String promotion) throws java.text.ParseException {

		Map<String, String> promotionDetails = new HashMap<String, String>();
		String[] abc = promotion.split(Pattern.quote("||"));

		promotionDetails.put("QSOfferId", abc[0]);
		promotionDetails.put("Total", abc[1]);

		return promotionDetails;

	}

	public static String getPrettyString(String xmlData) throws Exception {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

		StringWriter stringWriter = new StringWriter();
		StreamResult xmlOutput = new StreamResult(stringWriter);

		Source xmlInput = new StreamSource(new StringReader(xmlData));
		transformer.transform(xmlInput, xmlOutput);

		return xmlOutput.getWriter().toString();
	}

	public static String getPrettyJson(String jsonData) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		Object json = mapper.readValue(jsonData, Object.class);
		String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json); // Pretty print JSON
		return (jsonStr);

	}

	@SuppressWarnings("unchecked")
	public JSONObject Jsonupdater(String value) throws ParseException, IOException {

		String json = GenerateStringFromResource(UrlConstants.JSON_PROMOTION_FILE);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(json);

		JSONObject jsonob = (JSONObject) obj;

		JSONObject structure = (JSONObject) jsonob.get("payload");
		structure.put("name", value);

		jsonob.toJSONString();

		return jsonob;
	}

	public XmlPath rawToXML(String response) {
		XmlPath xp = new XmlPath(response);
		return xp;
	}

	public JsonPath rawToJSON(String response) {

		JsonPath jp = new JsonPath(response);
		return jp;

	}

	public String POSTJSONResponse(String HOST, String body, String requestType) throws Exception {

		RestAssured.baseURI = prop.getProperty(HOST);

		thisRequestSpecification = RestAssured.with();
		thisRequestSpecification.given().relaxedHTTPSValidation("TLS").contentType(ContentType.JSON).body(body).when();

		Response response = thisRequestSpecification.post(requestType).then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).extract().response();

		qs_response = response.prettyPrint().toString();
		return qs_response;

	}

	public String PromotionJSONResponse(String HOST, String body, String requestType) throws Exception {

		RestAssured.baseURI = prop.getProperty(HOST);

		thisRequestSpecification = RestAssured.with();
		thisRequestSpecification.given().relaxedHTTPSValidation("TLS").contentType(ContentType.JSON).body(body).when();

		Response response = thisRequestSpecification.post(requestType).then().assertThat().statusCode(201).and()
				.contentType(ContentType.JSON).extract().response();

		qs_response = response.prettyPrint().toString();
		return qs_response;

	}

	public Response POSTXMLResponse(String HOST, String body, String requestType) throws Exception {

		RestAssured.baseURI = prop.getProperty(HOST);

		thisRequestSpecification = RestAssured.with();
		thisRequestSpecification.given().relaxedHTTPSValidation("TLS").contentType(ContentType.XML).body(body).when();

		Response response = thisRequestSpecification.post(requestType).then().assertThat().statusCode(200).and()
				.contentType(ContentType.XML).extract().response();

		return response;

	}

	public String POSTXMLEmulator(String HOST, String body, String requestType) throws Exception {

		RestAssured.baseURI = prop.getProperty(HOST);

		thisRequestSpecification = RestAssured.with();
		thisRequestSpecification.given().header("Content-Type", "text/xml").relaxedHTTPSValidation("TLS")
				.contentType(ContentType.XML).body(body).when();

		Response response = thisRequestSpecification.post(requestType).then().assertThat().statusCode(200).and()
				.contentType(ContentType.XML).extract().response();

		qs_response = response.prettyPrint().toString();
		return qs_response;

	}

	public String[] Actual(String response) throws Exception {

		XmlPath xp = rawToXML(response);

		String od = xp
				.getString("Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.description");
		String gs1code = xp
				.getString("Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.gs1Code");
		String id = xp.getString("Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.id");
		String gtin = xp.getString(
				"Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.offerGlobalTradeItem.gtin");

		String[] actual = new String[] { id, od, gs1code, gtin };

		return actual;

	}

	public String[] ActualValidations(String response) throws Exception {

		XmlPath xp = rawToXML(response);

		String od = xp
				.getString("Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.description");
		String gs1code = xp
				.getString("Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.gs1Code");
		String id = xp.getString("Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.id");
		String gtin = xp.getString(
				"Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.offerGlobalTradeItem.gtin");
		String disc = xp.getString(
				"Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.discount.amount.value");

		String[] actual = new String[] { id, od, gs1code, gtin, disc };

		return actual;

	}

	public String[] ActualMigratedValidations(String response) throws Exception {

		XmlPath xp = rawToXML(response);
		String message = xp.getString("Envelope.Body.checkoutCustomerBasketResponse.responseMessage.description");

		if (message.contentEquals("NO VALID OFFER PRESENT")) {

			actual = new String[] { message };
		} else {

			String id = xp.getString("Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.id");

			int length = xp.getInt("Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer.size()");

			int discount = 0;
			for (int i = 0; i < length; i++) {

				int linediscount = xp.getInt("Envelope.Body.checkoutCustomerBasketResponse.customerBasket.offers.offer["
						+ i + "].discount.amount.value");

				discount = discount + linediscount;
			}

			String disc = String.valueOf(discount);
			actual = new String[] { id, disc };
		}

		return actual;

	}

	public String[] Expected(Map<String, String> Items) throws Exception {

		this.Items = Items;

		String OfferId = Items.get("Offer Id");
		String OfferDescription = Items.get("Offer Description");
		String GS1Code = Items.get("GS1Code");
		String Gtin = Items.get("Gtin");

		String[] expected = new String[] { OfferId, OfferDescription, GS1Code, Gtin };

		return expected;

	}

	public String[] ExpectedDataTable(DataTable dataTable) throws Exception {

		List<Map<String, String>> validations = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> form : validations) {

			offerId = form.get("Offer Id");
			disc = form.get("Discount");

		}

		String[] expected = new String[] { offerId, disc };

		return expected;

	}

	public String updateRequest(HashMap<String, String> customData, String requestPath) {
		String requestBody = "";
		try {
			if (requestPath.contains(".json")) {
				requestBody = GenerateStringFromResource(requestPath);
			} else {
				requestBody = requestPath;
			}
			for (@SuppressWarnings("rawtypes")
			Map.Entry data : customData.entrySet()) {
				if (requestBody.contains(data.getKey().toString())) {
					requestBody = requestBody.replace(data.getKey().toString(), data.getValue().toString());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return requestBody;
	}

	public Response getAuthToken(String baseURI, String pathParams, Map<String, Object> header, String clientID,
			String clientSecret) {

		Response response = null;

		try {
			RestAssured.baseURI = baseURI.toString();
			RequestSpecification request = RestAssured.given();
			request.headers(header);

			request.config(RestAssured.config().encoderConfig(
					EncoderConfig.encoderConfig().encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
					.contentType("application/x-www-form-urlencoded; charset=UTF-8")
					.formParam("grant_type", AuthTokenConstants.AUTH_TOKEN_FORM_PARAMS_GRANT_TYPE)
					.formParam("client_id", clientID).formParam("client_secret", clientSecret)
					.formParam("resource", AuthTokenConstants.AUTH_TOKEN_FORM_PARAMS_RESOURCE);

			response = request.post(pathParams);

		} catch (Exception e) {
			System.out.println(e);
		}

		return response;
	}

	public Response sendPostRequest(String baseURI, String pathParams, Map<String, Object> header, String requestPath) {

		Response response = null;

		try {
			RestAssured.baseURI = baseURI.toString();
			RequestSpecification request = RestAssured.given();
			request.headers(header);

			if (requestPath.contains(".json")) {
				request.body(GenerateStringFromResource(requestPath));
			} else {
				request.body(requestPath);
			}

			// Log
			/*
			 * request.log().uri(); ; request.log().body();request.log().headers();
			 */

			response = request.post(pathParams);

		} catch (Exception e) {
			System.out.println(e);
		}

		return response;

	}

	public Response sendGetRequest(String baseURI, String pathParams, Map<String, Object> header) {

		Response response = null;

		try {
			RestAssured.baseURI = baseURI.toString();
			RequestSpecification request = RestAssured.given();
			request.headers(header).when().relaxedHTTPSValidation("TLS");

			response = request.get(pathParams);

		} catch (Exception e) {
			System.out.println(e);
		}

		return response;

	}

	public Response deleteRequest(String baseURI, String pathParams, Map<String, Object> header, String requestPath,
			String membershipReference) {

		Response response = null;

		RestAssured.baseURI = baseURI.toString();
		RequestSpecification request = RestAssured.given();
		request.headers(header);

		response = request.given().basePath(pathParams).put(membershipReference + requestPath);

		return response;

	}

	public Response deletePromotion(String baseURI, String pathParams, String PromoId) {

		Response response = null;

		RestAssured.baseURI = baseURI.toString();
		RequestSpecification request = RestAssured.given();

		response = request.given().basePath(pathParams).delete(PromoId);

		return response;

	}

	public Response unpublishPromotion(String baseURI, String pathParams, String PromoId) {

		Response response = null;

		RestAssured.baseURI = baseURI.toString();
		RequestSpecification request = RestAssured.given();

		response = request.given().basePath(pathParams).put(PromoId + "/unpublish");

		return response;

	}

	public String getResponseValue(Response response, String valuePath) {
		String value = "";
		try {
			value = response.jsonPath().getString(valuePath);
		} catch (Exception e) {
			System.out.println(e);
		}
		if (value.contains("[")) {
			value = value.replace("[", "");
			value = value.replace("]", "");
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	public JSONObject updateMembershipRequest(String RoleType, String membershipNumber, String RequestPath)
			throws IOException, ParseException {

		String json = GenerateStringFromResource(RequestPath);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(json);

		JSONObject jsonob = (JSONObject) obj;

		JSONObject structure = (JSONObject) jsonob.get("membership");
		structure.put("memberRole", RoleType);
		structure.put("parentMembershipReference", membershipNumber);

		jsonob.toJSONString();

		return jsonob;

	}

	public static int generateRandomDigits(int n) {
		int m = (int) Math.pow(10, n - 1);
		return m + new Random().nextInt(9 * m);
	}

	public static String getEnvironment() {

		String environment = "";
		try {
			// environment = System.getenv("env");
			environment = System.getProperty("environment");
			if (environment == null) {
				environment = System.getenv("env");
			}
			if (environment.trim().length() > 0) {
				if (!(environment.equalsIgnoreCase("dev") || environment.equalsIgnoreCase("stage"))) {
					System.out.println("Invalid environment.");
					System.exit(0);
				}
			} else {
				System.out.println("Environment not set. Key name : env. Value : dev/stage");
				System.exit(0);
			}
		} catch (NullPointerException e) {
			System.out.println("Environment not set. Key name : env. Value : dev/stage");
			System.exit(0);
		}
		return environment;

	}

	public Map<String, String> getAssertValues(String qs_response) throws Exception {

		String basketId, responseDescription, FirstLineOfferId, FirstLineOfferDescription, FirstLinetype,
				FirstLinegs1Code, FirstLinefeaturedText, FirstLineserialNumber, FirstLinesettlementId, FirstLinegtin,
				FirstLineTotalDiscount, FirstLineQuanity, FirstLineItemId, FirstLineEachItemDiscount;

		String SecondLineOfferId, SecondLineOfferDescription, SecondLinetype, SecondLinegs1Code, SecondLinefeaturedText,
				SecondLineserialNumber, SecondLinesettlementId, SecondLinegtin, SecondLineTotalDiscount,
				SecondLineQuanity, SecondLineItemId, SecondLineEachItemDiscount;

		basketId = responseDescription = FirstLineOfferId = FirstLineOfferDescription = FirstLinetype = FirstLinegs1Code = FirstLinefeaturedText = FirstLineserialNumber = FirstLinesettlementId = FirstLinegtin = FirstLineTotalDiscount = FirstLineQuanity = FirstLineItemId = FirstLineEachItemDiscount = "";

		SecondLineOfferId = SecondLineOfferDescription = SecondLinetype = SecondLinegs1Code = SecondLinefeaturedText = SecondLineserialNumber = SecondLinesettlementId = SecondLinegtin = SecondLineTotalDiscount = SecondLineQuanity = SecondLineItemId = SecondLineEachItemDiscount = "";

		Unmarshaller xmlUnmarshaller = new JaxBInitializer().initUnmarshaller(CheckoutCustomerBasketResponse.class);

		SOAPUtil soapUtil = new SOAPUtil();

		CheckoutCustomerBasketResponse res = soapUtil.unwrapSoap(xmlUnmarshaller, qs_response,
				CheckoutCustomerBasketResponse.class);

		int code = res.getResponseMessage().getCode();
		responseDescription = res.getResponseMessage().getDescription();
		basketId = res.getCustomerBasket().getBasketID();

		List<Offer> offerid = res.getCustomerBasket().getOffers();

		for (Offer line : offerid) {

			// List<OrderLine> orderline =
			// line.getOrderLinesInOfferSummary().getOrderLines();

			List<OrderLine> orderLines = line.getOrderLinesInOfferSummary().getOrderLines().stream()
					.sorted((ol1, ol2) -> ol1.getLineNumber().compareTo(ol2.getLineNumber()))
					.collect(Collectors.toList());

			for (OrderLine ol : orderLines) {

				if (ol.getLineNumber().contentEquals("1")) {

					FirstLineOfferId = line.getId();
					FirstLineOfferDescription = line.getDescription();
					FirstLinetype = line.getType();
					FirstLinegs1Code = line.getGs1Code();
					FirstLinefeaturedText = line.getFeaturedText();
					FirstLineserialNumber = line.getSerialNumber();
					FirstLinesettlementId = line.getSettlementDetails().getSettlementId();
					FirstLinegtin = line.getOfferGlobalTradeItem().getGtin();

					FirstLineTotalDiscount = line.getDiscount().getAmount().getValue().toString();
					FirstLineQuanity = ol.getQuantity().getAmount().toString();
					FirstLineItemId = ol.getProductOffering().getId();
					FirstLineEachItemDiscount = ol.getProductOffering().getPrice().getAmount().getValue().toString();

				}

				else if (ol.getLineNumber().contentEquals("2")) {

					SecondLineOfferId = line.getId();
					SecondLineOfferDescription = line.getDescription();
					SecondLinetype = line.getType();
					SecondLinegs1Code = line.getGs1Code();
					SecondLinefeaturedText = line.getFeaturedText();
					SecondLineserialNumber = line.getSerialNumber();
					SecondLinesettlementId = line.getSettlementDetails().getSettlementId();
					SecondLinegtin = line.getOfferGlobalTradeItem().getGtin();

					SecondLineTotalDiscount = line.getDiscount().getAmount().getValue().toString();
					SecondLineQuanity = ol.getQuantity().getAmount().toString();
					SecondLineItemId = ol.getProductOffering().getId();
					SecondLineEachItemDiscount = ol.getProductOffering().getPrice().getAmount().getValue().toString();
				}

			}

		}

		Map<String, String> getAssertValues = new HashMap<String, String>();

		getAssertValues.put("code", String.valueOf(code));
		getAssertValues.put("responseDescription", responseDescription);
		getAssertValues.put("basketId", basketId);
		getAssertValues.put("FirstLineOfferId", FirstLineOfferId);
		getAssertValues.put("FirstLineOfferDescription", FirstLineOfferDescription);
		getAssertValues.put("FirstLinetype", FirstLinetype);
		getAssertValues.put("FirstLinegs1Code", FirstLinegs1Code);
		getAssertValues.put("FirstLinefeaturedText", FirstLinefeaturedText);
		getAssertValues.put("FirstLineserialNumber", FirstLineserialNumber);
		getAssertValues.put("FirstLinesettlementId", FirstLinesettlementId);
		getAssertValues.put("FirstLinegtin", FirstLinegtin);
		getAssertValues.put("FirstLineTotalDiscount", FirstLineTotalDiscount);
		getAssertValues.put("FirstLineQuanity", FirstLineQuanity);
		getAssertValues.put("FirstLineItemId", FirstLineItemId);
		getAssertValues.put("FirstLineEachItemDiscount", FirstLineEachItemDiscount);
		getAssertValues.put("SecondLineOfferId", SecondLineOfferId);
		getAssertValues.put("SecondLineOfferDescription", SecondLineOfferDescription);
		getAssertValues.put("SecondLinetype", SecondLinetype);
		getAssertValues.put("SecondLinegs1Code", SecondLinegs1Code);
		getAssertValues.put("SecondLinefeaturedText", SecondLinefeaturedText);
		getAssertValues.put("SecondLineserialNumber", SecondLineserialNumber);
		getAssertValues.put("SecondLinesettlementId", SecondLinesettlementId);
		getAssertValues.put("SecondLinegtin", SecondLinegtin);
		getAssertValues.put("SecondLineTotalDiscount", SecondLineTotalDiscount);
		getAssertValues.put("SecondLineQuanity", SecondLineQuanity);
		getAssertValues.put("SecondLineItemId", SecondLineItemId);
		getAssertValues.put("SecondLineEachItemDiscount", SecondLineEachItemDiscount);

		return getAssertValues;

	}

}
