package com.sams.promotions.emulation.createPromotions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.assertj.core.api.SoftAssertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.PrimaryRequestHelper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.membershipCreate.Membership;
import com.sams.promotions.emulation.test.steps.util.ClientConfigurationDatabase;
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
	ClientConfigurationDatabase connection;
	SoftAssertions softAssertions;

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
		primaryrequest = new PrimaryRequestHelper();
		connection=new ClientConfigurationDatabase();
		softAssertions=new SoftAssertions();
	}

	@Given("^Utilize URL and post data$")
	public void POST_Operation(DataTable datatable) throws Exception {
		
		/*
		 * String qsarr=reserveemulator.QSPromoMetaData(prop.get("mercury.quicksilver").
		 * toString(), 1); Map<String, String>
		 * mapqs=Helper.getQSPromotionDetails(qsarr);
		 * 
		 * int Total=Integer.valueOf(mapqs.get("Total"));
		 * 
		 * int i=0;
		 * 
		 * while(i<Total) {
		 * 
		 * String
		 * qsarry=reserveemulator.QSPromoMetaData(prop.get("mercury.quicksilver").
		 * toString(), i); Map<String, String>
		 * mapqsy=Helper.getQSPromotionDetails(qsarry);
		 * 
		 * System.out.println(mapqsy); i++; }
		 */
			
		
		
		  Map<String, String> mapqs
		  =Helper.getPromotionDetails(reserveemulator.AnalyticPromoMetaData(prop.get(
		  "metadata.prod.rest").toString(), 0)); int size =
		  Integer.valueOf(mapqs.get("SizeOfMetaData"));
		  
		  BufferedWriter writer = new BufferedWriter(new
		  FileWriter("src/test/resources/Emulation_Input/Promotions.txt"));
		  
		  for (int i = 0; i < size; i++) {
		  
		  String
		  arrzte1=reserveemulator.AnalyticPromoMetaData(prop.get("metadata.prod.rest").
		  toString(),i);
		  
		  writer.write(arrzte1); writer.newLine();
		  
		  System.out.println(arrzte1); // System.out.println(mapnew.get("PromoId"));
		  
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
