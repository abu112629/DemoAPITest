package com.sams.promotions.emulation.createPromotions;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.membershipCreate.Membership;
import com.sams.promotions.emulation.test.steps.util.HeaderMapper;
import com.sams.promotions.emulator.datapower.regression.membership.allAnalyticPromotions.MemberSelect;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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
	MemberSelect memberrequest;

	public CreatePromotions() throws IOException {
		super();

	}

	@Before
	public void beforeSetup() throws IOException {

		headerMapper = new HeaderMapper();
		helper = new Helper();
		membership = new Membership();
		reserveemulator = new ReserveEmulationHelper();
		memberrequest=new MemberSelect();
	}

	@Given("^Utilize URL and post data$")
	public void POST_Operation(DataTable datatable) throws Exception {
		
		 
		
		/*
		 * String arrx =
		 * reserveemulator.AnalyticPromoMetaData(prop.get("metadata.prod.rest").toString
		 * (),1);
		 * 
		 * String arry =
		 * reserveemulator.AnalyticPromoMetaData(prop.get("metadata.prod.rest").toString
		 * (),2);
		 * 
		 * Map<String, String> maptest = helper.getRetailPriceMetadata(arrx, arry);
		 * 
		 * System.out.println(maptest.get("SameRetailPrice"));
		 * System.out.println(maptest.get("LessRetailPrice"));
		 * System.out.println(maptest.get("MoreRetailPrice"));
		 * 
		 * 
		 * Map<String, String> maptestsst= Helper.getPromotionDetails(arrx); int
		 * size=Integer.valueOf(maptestsst.get("SizeOfMetaData"));
		 * 
		 * for (int i = 0; i < size; i++) {
		 * 
		 * String arrzte1
		 * =reserveemulator.AnalyticPromoMetaData(prop.get("metadata.prod.rest").
		 * toString(),i); //Map<String, String> mapnew=
		 * Helper.getPromotionDetails(arrzte1);
		 * 
		 * writer.write(arrzte1); writer.newLine();
		 * 
		 * System.out.println(arrzte1); // System.out.println(mapnew.get("PromoId"));
		 * 
		 * } //
		 * 
		 * writer.close();
		 */

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

	}

	@When("^POST the provided request$")
	public void postrequest() {

	}

	@Then("^Response code$")
	public void CheckResults() {

	}

}
