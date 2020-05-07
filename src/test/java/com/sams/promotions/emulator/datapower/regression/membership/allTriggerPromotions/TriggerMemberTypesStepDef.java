package com.sams.promotions.emulator.datapower.regression.membership.allTriggerPromotions;

import java.io.IOException;
import java.util.Map;

import org.assertj.core.api.SoftAssertions;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.AssertHelper;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.PrimaryRequestHelper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.membershipCreate.Membership;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;

public class TriggerMemberTypesStepDef extends BaseStep{
	
	protected String postdata, postdata2, arrx, arry, packagecode, packagecode2;
	protected String pathsingle, OfferId, OfferId2;
	protected String membershipNbr;
	MemberSelect member;
	TriggerHelper triggerHelper;
	protected String expected;
	protected int ItemId, ItemId2, Quantity, Quantity2, disc, disc2;
	protected Map<String, String> promodetails, promodetails2, postRequestDetails, postDoubleRequestDetails;

	private SoftAssertions softAssertions;

	public TriggerMemberTypesStepDef() throws IOException {
		super();
	}

	@Before
	public void beforeSetup() throws IOException {

		primaryrequest = new PrimaryRequestHelper();
		reserveemulator = new ReserveEmulationHelper();
		helper = new Helper();
		asserthelper = new AssertHelper();
		membership = new Membership();
		softAssertions = new SoftAssertions();
		pathsingle = UrlConstants.DATA_POWER_CLUB;
		member = new MemberSelect();
		triggerHelper=new TriggerHelper();

	}

	@Given("DataPower with a (.*), (.*), (.*), and (.*) with (\\d+) for InstantSavings and (\\d+) for QuickSilver with Code (\\d+) and Price (.*) and Single OrderLine (\\d+), Second Order Line (\\d+) in (.*) with Registration Number (\\d+) and TransactionId (\\d+) to be Utilised to Get Trigger Offer$")
	public void createtheInitialLinerequestforAllMembersTrigger(String membershipBase, String type, String Tier,
			String channelName, String ClubId, String ClubId2, int code, String RetailPrice, String lineNumber,
			String lineNumber2, String Applied_Dates, String RegistrationNumber, String TransactionId)
			throws Exception {

		membershipNbr = member.memberRequest(type, membershipBase, Tier);

		if (code == 1) {

			long y = Long.valueOf(membershipNbr) / 10000000000L;
			long x = Integer.parseInt((membershipNbr).substring(8));

			membershipNbr = Long.toString(y) + Long.toString(x);

		}
		
		
		int i = 0;
		
		  Map<String, String> mapqs =Helper.getTriggerPromotionDetails(reserveemulator.TriggerPromoMetaData(prop.get("metadata.prod.rest").toString(), i)); 
		  int size =
		  Integer.valueOf(mapqs.get("SizeOfMetaData"));
		 
		  
		

		while (i < size-1) {
			
				

			String arrbr = reserveemulator.TriggerPromoMetaData(prop.get("metadata.prod.rest").toString(),i);
			String arrbry = reserveemulator.TriggerPromoMetaData(prop.get("metadata.prod.rest").toString(),i+1);
			
			
			
			  Map<String, String> mapr =Helper.getTriggerPromotionDetails(arrbr);
			  String promoIdr = mapr.get("PromoId");
			  
			  Map<String, String> mapry =Helper.getTriggerPromotionDetails(arrbry); 
			  String promoIdry = mapry.get("PromoId");
			  
			  if(promoIdr.contentEquals(promoIdry)) {
				  
				  triggerHelper.TriggerCertRequest(membershipNbr, Applied_Dates, ClubId, mapr.get("actioncode"), mapr.get("actionDescription"), prop.get("metadata.prod.rest").toString());
				  triggerHelper.TriggerEmulatorRequest(membershipNbr, Applied_Dates, ClubId, mapr.get("actioncode"), prop.get("mercury.quicksilver").toString());
				  
			  }
			 
			  else {
				  
				  triggerHelper.TriggerCertRequest(membershipNbr, Applied_Dates, ClubId, mapr.get("actioncode"), mapr.get("actionDescription"), prop.get("metadata.prod.rest").toString());
				  triggerHelper.TriggerEmulatorRequest(membershipNbr, Applied_Dates, ClubId, mapr.get("actioncode"), prop.get("mercury.quicksilver").toString());
				  
				  triggerHelper.TriggerCertRequest(membershipNbr, Applied_Dates, ClubId, mapry.get("actioncode"), mapry.get("actionDescription"), prop.get("metadata.prod.rest").toString());
				  triggerHelper.TriggerEmulatorRequest(membershipNbr, Applied_Dates, ClubId, mapry.get("actioncode"), prop.get("mercury.quicksilver").toString());
				  
			  }
			 
				
			
			postRequestDetails = primaryrequest.getInitialReserveDoubleLinesPostRequestDetails(i, membershipNbr,
					channelName, ClubId, ClubId2, code, RetailPrice, lineNumber, Applied_Dates,
					RegistrationNumber, TransactionId, arrbr, arrbry, pathsingle);

			postdata = postRequestDetails.get("DataPowerRequest");
			postdata2 = postRequestDetails.get("EmulatorRequest");


			UpdatetheRequesttoDoubleLinesTrigger(ClubId, ClubId2, RetailPrice, lineNumber2, Applied_Dates,arrbr,arrbry);

			POST_the_request_for_DoubleLines_Trigger();
			Getparameter_and_postOperation_for_DoubleLines_Trigger();

			POST_the_emulator_request_for_Doublelines_Trigger();
			Getemulatorparameter_and_postOperation_for_Doublelines_Trigger();

			ChecktheResultsdoubleLinesTrigger();
			i++;
			
					
			
			

		}

		softAssertions.assertAll();

	}

	@Given("^DataPower with a (.*),(.*),(.*), and (.*) with (\\d+) for InstantSavings and (\\d+) for QuickSilver with code (\\d+) and Price (.*) and Single OrderLine (\\d+) in (.*) with Registration Number (\\d+) and TransactionId (\\d+) to be Utilised to Get Trigger Offer$")

	public void createtheSingleLineRequestTrigger(String membershipBase,String type,String Tier,
			String channelName, String ClubId, String ClubId2, int code, String RetailPrice, String lineNumber,
			String Applied_Dates, String RegistrationNumber, String TransactionId) throws Exception {
		    
		
		membershipNbr = member.memberRequest(type,membershipBase,Tier);

		if (code == 1) {

			long y = Long.valueOf(membershipNbr) / 10000000000L;
			long x = Integer.parseInt((membershipNbr).substring(8));

			membershipNbr = Long.toString(y) + Long.toString(x);

		}

		int i = 0;
		
		  Map<String, String> mapqs =Helper.
				  getTriggerPromotionDetails(reserveemulator.TriggerPromoMetaData(prop.get("metadata.prod.rest").toString(), i)); 
				  int size =
				  Integer.valueOf(mapqs.get("SizeOfMetaData"));

		while (i < size) {
			
			String arrbr = reserveemulator.TriggerSinglePromoMetaData(prop.get("metadata.prod.rest").toString(),i);
			Map<String, String> mapr =Helper.getTriggerPromotionDetails(arrbr);
			triggerHelper.
			TriggerCertRequest(membershipNbr, Applied_Dates, ClubId, mapr.get("actioncode"), mapr.get("actionDescription"), prop.get("metadata.prod.rest").toString());
			triggerHelper.
			 TriggerEmulatorRequest(membershipNbr, Applied_Dates, ClubId, mapr.get("actioncode"), prop.get("mercury.quicksilver").toString());

			postRequestDetails = reserveemulator.getReserveRequestDetails(i, membershipNbr, channelName, ClubId,
					ClubId2, code, RetailPrice, lineNumber, Applied_Dates,RegistrationNumber, TransactionId,arrbr,
					pathsingle);

			postdata = postRequestDetails.get("DataPowerRequest");
			postdata2 = postRequestDetails.get("EmulatorRequest");


			POST_the_request_for_DoubleLines_Trigger();
			Getparameter_and_postOperation_for_DoubleLines_Trigger();

			POST_the_emulator_request_for_Doublelines_Trigger();
			Getemulatorparameter_and_postOperation_for_Doublelines_Trigger();

			ChecktheResultsdoubleLinesTrigger();

			i++;

		}

		softAssertions.assertAll();
	}


	public void UpdatetheRequesttoDoubleLinesTrigger(String ClubId, String ClubId2, String RetailPrice,
			String lineNumber, String Applied_Dates,String arrx,String arry) throws Exception {

		postDoubleRequestDetails = primaryrequest.getDoubleLinesRequest(ClubId,
				ClubId2, RetailPrice, lineNumber, Applied_Dates,postdata, postdata2,arrx,arry);

		postdata = postDoubleRequestDetails.get("DataPowerRequest");
		postdata2 = postDoubleRequestDetails.get("EmulatorRequest");


	}

	public void POST_the_request_for_DoubleLines_Trigger() {

		RestAssured.baseURI = prop.getProperty("datapower.prod.instantsavings");
		thisRequestSpecification = RestAssured.with();
		thisRequestSpecification.given().relaxedHTTPSValidation("TLS").body(postdata).when(); // header("Content-Type",
																								// // "text/xml").	
		

	}

	public void POST_the_emulator_request_for_Doublelines_Trigger() {

		RestAssured.baseURI = prop.getProperty("datapower.cert.instantsavings");
		thisRequestSpecification2 = RestAssured.with();

		thisRequestSpecification2.given().header("Content-Type", "text/xml").relaxedHTTPSValidation("TLS")
				.body(postdata2).when();

	}

	public void Getparameter_and_postOperation_for_DoubleLines_Trigger() {

		response = thisRequestSpecification.post(UrlConstants.SERVICES_CHECKOUT).then();

	}

	public void Getemulatorparameter_and_postOperation_for_Doublelines_Trigger() {

		response2 = thisRequestSpecification2.post(UrlConstants.RESERVE_EMULATION).then();

	}

	public void ChecktheResultsdoubleLinesTrigger() throws Exception {

		softAssertions = asserthelper.ValidationsAll(response, response2);

		//membership.deleteMembership(membershipNbr);

	}

}
