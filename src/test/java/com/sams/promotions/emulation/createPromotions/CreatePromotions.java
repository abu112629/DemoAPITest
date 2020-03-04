package com.sams.promotions.emulation.createPromotions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.MembershipConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.membershipCreate.Membership;
import com.sams.promotions.emulation.test.steps.util.HeaderMapper;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

@SpringBootTest

@RunWith(SpringRunner.class)

public class CreatePromotions extends BaseStep {

	protected String membershipNbr;
	HeaderMapper headerMapper;
	protected long PromoNumber, Itemnumber, Mpq;
	protected ArrayList<String> arrList = new ArrayList<String>();
	protected float Discount;
	protected String StartDate, EndDate, arr[];
	protected int pro1, pro2;

	public CreatePromotions() throws IOException {
		super();

	}

	@Before
	public void beforeSetup() throws IOException {

		headerMapper = new HeaderMapper();
		helper = new Helper();
		membership = new Membership();
		reserveemulator = new ReserveEmulationHelper();
	}

	@Given("^Utilize URL and post data$")
	public void POST_Operation(DataTable datatable) throws Exception {
		

		Response membershipResponse = membership.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_BUSINESS_REQUEST_PATH);
		membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
		
		System.out.println(membershipNbr);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/Emulation_Input/Promotions.txt"));

		String arr = reserveemulator.TriggerPromoMetaData(prop.get("datapower.production.cert").toString(), 1);

		String arrxyz = reserveemulator.PromoMetaData(prop.get("datapower.production.cert").toString(), 5);

		Map<String, String> map = Helper.getPromotionDetails(arr);
		Map<String, String> mapx = Helper.getPromotionDetails(arrxyz);

		int size = Integer.valueOf(map.get("SizeOfMetaData"));

		System.out.println(map.get("SizeOfMetaData"));

		int MaxRedemptionCount = Integer.valueOf(map.get("MaxRedemptionCount"));
		System.out.println(MaxRedemptionCount);

		int MaxRedemptionCountX = Integer.valueOf(mapx.get("MaxRedemptionCount"));
		System.out.println(MaxRedemptionCountX);

		for (int i = 0; i < size; i++) {

			String arrx = reserveemulator.TriggerPromoMetaData(prop.get("datapower.production.cert").toString(), i);
			// Map<String, String> mapnew = Helper.getPromotionDetails(arrx);

			writer.write(arrx);
			writer.newLine();

			System.out.println(arrx); // System.out.println(mapnew.get("PromoId"));

		} //

		writer.close();

		// System.out.println(arr);

		/*
		 * String promoPayload = reserveemulator.PromoCreationRequestPayload(datatable);
		 * System.out.println(Helper.getPrettyJson(promoPayload)); String res =
		 * helper.PromotionJSONResponse("mercury.quicksilver", promoPayload,
		 * UrlConstants.PROMO_CREATION);
		 * 
		 * JsonPath jp=helper.rawToJSON(res);
		 * 
		 * String id = jp.get("payload.id"); Response reqs =
		 * helper.unpublishPromotion(prop.get("mercury.quicksilver").toString(),
		 * UrlConstants.PROMO_CREATION, id); System.out.println(reqs.asString());
		 * 
		 * Response ressss =
		 * helper.deletePromotion(prop.get("mercury.quicksilver").toString(),
		 * UrlConstants.PROMO_CREATION, "a6070b42-0c1c-483a-abe5-b152caed2366");
		 * System.out.println(ressss.asString());
		 */

		/*
		 * Map<String, Object> header =
		 * headerMapper.mapHeaders(UrlConstants.METADATA_HEADER_PATH);
		 * 
		 * Response res =
		 * helper.sendGetRequest(prop.get("datapower.production.cert").toString(),
		 * UrlConstants.METADATA_PROMOTION, header); String metadataJson =
		 * res.asString();
		 * 
		 * ObjectMapper objectmapper = new ObjectMapper(); MetaDataResponse metadata =
		 * objectmapper.readValue(metadataJson, MetaDataResponse.class);
		 * List<BroadReachOffer> list = metadata.getBroadReachOffers();
		 * 
		 * for (BroadReachOffer line : list) {
		 * 
		 * PromoNumber = line.getCouponNumber(); Discount = line.getCouponValue();
		 * StartDate = line.getStartDate(); EndDate = line.getEndDate();
		 * 
		 * String ite = null; String mpq = null;
		 * 
		 * if (line.getMerchandiseDetails().getItemDetails() != null) { List<ItemDetail>
		 * item = line.getMerchandiseDetails().getItemDetails(); for (ItemDetail linenew
		 * : item) {
		 * 
		 * Itemnumber = linenew.getItemNumber(); Mpq =
		 * linenew.getMinimumPurchaseQuantity(); ite = String.valueOf(Itemnumber); mpq =
		 * String.valueOf(Mpq); arr = new String[] { PromoNumber + " " + Discount + " "
		 * + StartDate + " " + EndDate + " " + ite + " " + mpq };
		 * arrList.add(arr[0].toString());
		 * 
		 * } }
		 * 
		 * else { arr = new String[] { PromoNumber + " " + Discount + " " + StartDate +
		 * " " + EndDate + " " + ite + " " + mpq }; arrList.add(arr[0].toString());
		 * 
		 * }
		 * 
		 * }
		 * 
		 * for(int i=0;i<arrList.size();i++) {
		 * 
		 * System.out.println(arrList.get(i)); }
		 */

	}

	@When("^POST the provided request$")
	public void postrequest() {

	}

	@Then("^Response code$")
	public void CheckResults() {

	}

}
