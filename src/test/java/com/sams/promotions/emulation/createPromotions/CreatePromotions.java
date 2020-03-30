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
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.membershipCreate.Membership;
import com.sams.promotions.emulation.test.steps.util.HeaderMapper;
import com.sams.promotions.emulator.datapower.regression.membership.allPromotions.Membership_Types;

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
	Membership_Types member;

	public CreatePromotions() throws IOException {
		super();

	}

	@Before
	public void beforeSetup() throws IOException {

		headerMapper = new HeaderMapper();
		helper = new Helper();
		membership = new Membership();
		reserveemulator = new ReserveEmulationHelper();
		member=new Membership_Types();
	}

	@Given("^Utilize URL and post data$")
	public void POST_Operation(DataTable datatable) throws Exception {
		
		 //System.out.println("Savings Primary : "+ member.getMembershipType("primary", "savings", "Club"));
		 
		 membershipNbr = member.getMembershipType("primary", "savings", "Plus");
		 System.out.println(membershipNbr);
		 
		 
		 
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/Emulation_Input/Promotions.txt"));
		//String xyz=reserveemulator.QSPromoMetaData(prop.get("mercury.quicksilver").toString());
		
		//System.out.println(xyz);
		
		String arrpackage = reserveemulator.PackagePromoMetaData(prop.get("metadata.prod.rest").toString(), 
				UrlConstants.METADATA_PROMOTION_PACKAGE,1);

		Map<String, String> map = Helper.getPromotionDetails(arrpackage);
		

		int size=Integer.valueOf(map.get("SizeOfMetaData"));
		int MaxRedemptionCount = Integer.valueOf(map.get("MaxRedemptionCount"));
		System.out.println(MaxRedemptionCount);


		for (int i = 0; i < size; i++) {

			String arrx = reserveemulator.PackagePromoMetaData(prop.get("metadata.prod.rest").toString(), 
					UrlConstants.METADATA_PROMOTION_PACKAGE,i);
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

	}

	@When("^POST the provided request$")
	public void postrequest() {

	}

	@Then("^Response code$")
	public void CheckResults() {

	}

}
