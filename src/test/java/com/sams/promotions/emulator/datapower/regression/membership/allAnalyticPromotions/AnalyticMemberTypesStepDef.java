package com.sams.promotions.emulator.datapower.regression.membership.allAnalyticPromotions;

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

public class AnalyticMemberTypesStepDef extends BaseStep{
	
	protected String postdata, postdata2, arrx, arry, packagecode, packagecode2;
	protected String pathsingle, OfferId, OfferId2;
	protected String membershipNbr;
	MemberSelect member;
	protected String expected;
	protected int ItemId, ItemId2, Quantity, Quantity2, disc, disc2;
	protected Map<String, String> promodetails, promodetails2, postRequestDetails, postDoubleRequestDetails;

	private SoftAssertions softAssertions;

	public AnalyticMemberTypesStepDef() throws IOException {
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

	}

	@Given("DataPower with a (.*), (.*), (.*), and (.*) with (\\d+) for InstantSavings and (\\d+) for QuickSilver with Code (\\d+) and Price (.*) and Single OrderLine (\\d+), Second Order Line (\\d+) in (.*) with Registration Number (\\d+) and TransactionId (\\d+) to be Utilised to Get Analytic Offer$")
	public void createtheInitialLinerequestforAllMembersAnalytic(String membershipBase, String type, String Tier,
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
		
		  Map<String, String> mapqs =Helper.getPromotionDetails(reserveemulator.AnalyticPromoMetaData(prop.get(
		  "metadata.prod.rest").toString(), i)); 
		  int size =
		  Integer.valueOf(mapqs.get("SizeOfMetaData"));
		 

		

		while (i < size-1) {
			
				

			String arrbr = reserveemulator.AnalyticPromoMetaData(prop.get("metadata.prod.rest").toString(),i);
			String arrbry = reserveemulator.AnalyticPromoMetaData(prop.get("metadata.prod.rest").toString(),i+1);
			
				
			
			postRequestDetails = primaryrequest.getInitialReserveDoubleLinesPostRequestDetails(i, membershipNbr,
					channelName, ClubId, ClubId2, code, RetailPrice, lineNumber, Applied_Dates,
					RegistrationNumber, TransactionId, arrbr, arrbry, pathsingle);

			postdata = postRequestDetails.get("DataPowerRequest");
			postdata2 = postRequestDetails.get("EmulatorRequest");


			UpdatetheRequesttoDoubleLinesAnalytic(ClubId, ClubId2, RetailPrice, lineNumber2, Applied_Dates,arrbr,arrbry);

			POST_the_request_for_DoubleLines_Analytic();
			Getparameter_and_postOperation_for_DoubleLines_Analytic();

			POST_the_emulator_request_for_Doublelines_Analytic();
			Getemulatorparameter_and_postOperation_for_Doublelines_Analytic();

			ChecktheResultsdoubleLinesAnalytic();
			
			i++;		
			
			

		}

		softAssertions.assertAll();

	}

	@Given("^DataPower with a (.*),(.*),(.*), and (.*) with (\\d+) for InstantSavings and (\\d+) for QuickSilver with code (\\d+) and Price (.*) and Single OrderLine (\\d+) in (.*) with Registration Number (\\d+) and TransactionId (\\d+) to be Utilised to Get Analytic Offer$")

	public void createtheSingleLineRequestAnalytic(String membershipBase,String type,String Tier,
			String channelName, String ClubId, String ClubId2, int code, String RetailPrice, String lineNumber,
			String Applied_Dates, String RegistrationNumber, String TransactionId) throws Exception {
		    
		
		membershipNbr = member.memberRequest(type,membershipBase,Tier);

		if (code == 1) {

			long y = Long.valueOf(membershipNbr) / 10000000000L;
			long x = Integer.parseInt((membershipNbr).substring(8));

			membershipNbr = Long.toString(y) + Long.toString(x);

		}

		int i = 0;
		
		  Map<String, String> mapqs =Helper.getPromotionDetails(reserveemulator.AnalyticSingleLinePromoMetaData(prop.get(
				  "metadata.prod.rest").toString(), i)); 
				  int size =
				  Integer.valueOf(mapqs.get("SizeOfMetaData"));

		while (i < size) {
			
			String arrbr = reserveemulator.AnalyticSingleLinePromoMetaData(prop.get("metadata.prod.rest").toString(),i);

			postRequestDetails = reserveemulator.getReserveRequestDetails(i, membershipNbr, channelName, ClubId,
					ClubId2, code, RetailPrice, lineNumber, Applied_Dates,RegistrationNumber, TransactionId,arrbr,
					pathsingle);

			postdata = postRequestDetails.get("DataPowerRequest");
			postdata2 = postRequestDetails.get("EmulatorRequest");


			POST_the_request_for_DoubleLines_Analytic();
			Getparameter_and_postOperation_for_DoubleLines_Analytic();

			POST_the_emulator_request_for_Doublelines_Analytic();
			Getemulatorparameter_and_postOperation_for_Doublelines_Analytic();

			ChecktheResultsdoubleLinesAnalytic();

			i++;

		}

		softAssertions.assertAll();
	}


	public void UpdatetheRequesttoDoubleLinesAnalytic(String ClubId, String ClubId2, String RetailPrice,
			String lineNumber, String Applied_Dates,String arrx,String arry) throws Exception {

		postDoubleRequestDetails = primaryrequest.getDoubleLinesRequest(ClubId,
				ClubId2, RetailPrice, lineNumber, Applied_Dates,postdata, postdata2,arrx,arry);

		postdata = postDoubleRequestDetails.get("DataPowerRequest");
		postdata2 = postDoubleRequestDetails.get("EmulatorRequest");


	}

	public void POST_the_request_for_DoubleLines_Analytic() {

		RestAssured.baseURI = prop.getProperty("datapower.instantsavings");
		thisRequestSpecification = RestAssured.with();
		thisRequestSpecification.given().relaxedHTTPSValidation("TLS").body(postdata).when(); // header("Content-Type",
																								// // "text/xml").	
		

	}

	public void POST_the_emulator_request_for_Doublelines_Analytic() {

		RestAssured.baseURI = prop.getProperty("datapower.instantsavings");
		thisRequestSpecification2 = RestAssured.with();

		thisRequestSpecification2.given().header("Content-Type", "text/xml").relaxedHTTPSValidation("TLS")
				.body(postdata2).when();

	}

	public void Getparameter_and_postOperation_for_DoubleLines_Analytic() {

		response = thisRequestSpecification.post(UrlConstants.SERVICES_CHECKOUT).then();

	}

	public void Getemulatorparameter_and_postOperation_for_Doublelines_Analytic() {

		response2 = thisRequestSpecification2.post(UrlConstants.SERVICES_CHECKOUT).then();

	}

	public void ChecktheResultsdoubleLinesAnalytic() throws Exception {

		softAssertions = asserthelper.ValidationsAll(response, response2);

		//membership.deleteMembership(membershipNbr);

	}

}
