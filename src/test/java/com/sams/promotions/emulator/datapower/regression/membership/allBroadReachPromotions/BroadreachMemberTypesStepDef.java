package com.sams.promotions.emulator.datapower.regression.membership.allBroadReachPromotions;

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

public class BroadreachMemberTypesStepDef extends BaseStep {

	protected String postdata, postdata2, arrx, arry, packagecode, packagecode2;
	protected String pathsingle, OfferId, OfferId2;
	protected String membershipNbr;
	MemberSelect member;
	protected String expected;
	protected int ItemId, ItemId2, Quantity, Quantity2, disc, disc2;
	//protected Map<String, String> promodetails, promodetails2, postRequestDetails, postDoubleRequestDetails;

	private SoftAssertions softAssertions;

	public BroadreachMemberTypesStepDef() throws IOException {
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

	@Given("DataPower with a (.*), (.*), (.*), and (.*) with (\\d+) for InstantSavings and (\\d+) for QuickSilver with Code (\\d+) and Price (.*) and Single OrderLine (\\d+), Second Order Line (\\d+) in (.*) with Registration Number (\\d+) and TransactionId (\\d+) to be Utilised to Get BroadReach Offer$")
	public void createtheInitialLinerequestforAllMembers(String membershipBase, String type, String Tier,
			String channelName, String ClubId, String ClubId2, int code, String RetailPrice, String lineNumber,
			String lineNumber2, String Applied_Dates, String RegistrationNumber, String TransactionId)
			throws Exception {

		
		
		/*
		 * membershipNbr = member.memberRequest(type, membershipBase, Tier);
		 * 
		 * if (code == 1) {
		 * 
		 * long y = Long.valueOf(membershipNbr) / 10000000000L; long x =
		 * Integer.parseInt((membershipNbr).substring(8));
		 * 
		 * membershipNbr = Long.toString(y) + Long.toString(x);
		 * 
		 * }
		 */
		 

		int i = 0;

		Map<String, String> mapqs = Helper.getPromotionDetails(
				reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), i));
		int size = Integer.valueOf(mapqs.get("SizeOfMetaData"));

		while (i < size-1) {

			String arrbr = reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), i);

			String arrbry = reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), i + 1);


			//if (promoIdr.contentEquals(promoIdry)) {
			
				
				Map<String, String> postRequestDetails = primaryrequest.getInitialReserveDoubleLinesPostRequestDetails(i,"10142100124208539",
						channelName, ClubId, ClubId2, code, RetailPrice, lineNumber, Applied_Dates, RegistrationNumber,
						TransactionId, arrbr, arrbry, pathsingle);
				
				Map<String, String> postRequestDetailsx = primaryrequest.getInitialReserveDoubleLinesPostRequestDetails(i,"10142100124210055",
						channelName, ClubId, ClubId2, code, RetailPrice, lineNumber, Applied_Dates, RegistrationNumber,
						TransactionId, arrbr, arrbry, pathsingle);
				
		
				
				
				postdata = postRequestDetails.get("DataPowerRequest");
				postdata2 = postRequestDetailsx.get("EmulatorRequest");

				UpdatetheRequesttoDoubleLinesBroadReach(ClubId, ClubId2, RetailPrice, lineNumber2, Applied_Dates, arrbr,
						arrbry);

				POST_the_request_for_DoubleLines_BroadReach();
				Getparameter_and_postOperation_for_DoubleLines_BroadReach();

				POST_the_emulator_request_for_Doublelines_BroadReach();
				Getemulatorparameter_and_postOperation_for_Doublelines_BroadReach();

				ChecktheResultsdoubleLinesBroadReach();

				i++;

			//}

			//else {

				//i++;
			//}

		}

		softAssertions.assertAll();

	}

	@Given("^DataPower with a (.*),(.*),(.*), and (.*) with (\\d+) for InstantSavings and (\\d+) for QuickSilver with code (\\d+) and Price (.*) and Single OrderLine (\\d+) in (.*) with Registration Number (\\d+) and TransactionId (\\d+) to be Utilised to Get BroadReach Offer$")

	public void createtheSingleLineRequest(String membershipBase, String type, String Tier, String channelName,
			String ClubId, String ClubId2, int code, String RetailPrice, String lineNumber, String Applied_Dates,
			String RegistrationNumber, String TransactionId) throws Exception {

		
		
		/*
		 * membershipNbr = member.memberRequest(type, membershipBase, Tier);
		 * 
		 * if (code == 1) {
		 * 
		 * long y = Long.valueOf(membershipNbr) / 10000000000L; long x =
		 * Integer.parseInt((membershipNbr).substring(8));
		 * 
		 * membershipNbr = Long.toString(y) + Long.toString(x);
		 * 
		 * }
		 */
		 
		 

		int i = 0;

		Map<String, String> mapqs = Helper.getPromotionDetails(
				reserveemulator.BroadReachSingleLinePromoMetaData(prop.get("metadata.prod.rest").toString(), i));
		int size = Integer.valueOf(mapqs.get("SizeOfMetaData"));

		while (i < size) {
			String arrbr = reserveemulator.BroadReachSingleLinePromoMetaData(prop.get("metadata.prod.rest").toString(), i);
			//10134100913186870 ,10142100863234050
			
			Map<String, String> postRequestDetails = reserveemulator.getReserveRequestDetails(i, "10142100124208539", channelName, ClubId,
					ClubId2, code, RetailPrice, lineNumber, Applied_Dates, RegistrationNumber, TransactionId, arrbr,
					pathsingle);
			
			Map<String, String> postRequestDetailsx = reserveemulator.getReserveRequestDetails(i, "10142100124210055", channelName, ClubId,
					ClubId2, code, RetailPrice, lineNumber, Applied_Dates, RegistrationNumber, TransactionId, arrbr,
					pathsingle);
			
		
			postdata = postRequestDetails.get("DataPowerRequest");
			postdata2 = postRequestDetailsx.get("EmulatorRequest");

			POST_the_request_for_DoubleLines_BroadReach();
			Getparameter_and_postOperation_for_DoubleLines_BroadReach();

			POST_the_emulator_request_for_Doublelines_BroadReach();
			Getemulatorparameter_and_postOperation_for_Doublelines_BroadReach();

			ChecktheResultsdoubleLinesBroadReach();

			i++;

		}

		softAssertions.assertAll();
	}

	@Given("DataPower with a (.*), (.*), (.*), and (.*) with (\\d+) for InstantSavings and (\\d+) for QuickSilver with Code (\\d+) and Price (.*) and Single OrderLine (\\d+), Second Order Line (\\d+) in (.*) with Registration Number (\\d+) and TransactionId (\\d+) for Complimentary to be Utilised to Get BroadReach Offer$")
	public void createtheInitialLinerequestforAllAddOnMembers(String membershipBase, String type, String Tier,
			String channelName, String ClubId, String ClubId2, int code, String RetailPrice, String lineNumber,
			String lineNumber2, String Applied_Dates, String RegistrationNumber, String TransactionId)
			throws Exception {

		
		
		/*
		 * membershipNbr = member.memberRequest(type, membershipBase, Tier);
		 * 
		 * if (code == 1) {
		 * 
		 * long y = Long.valueOf(membershipNbr) / 10000000000L; long x =
		 * Integer.parseInt((membershipNbr).substring(8));
		 * 
		 * membershipNbr = Long.toString(y) + Long.toString(x);
		 * 
		 * }
		 */
		 

		int i = 0;

		Map<String, String> mapqs = Helper.getPromotionDetails(
				reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), i));
		int size = Integer.valueOf(mapqs.get("SizeOfMetaData"));

		while (i < size-1) {

			String arrbr = reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), i);

			String arrbry = reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), i + 1);


			//if (promoIdr.contentEquals(promoIdry)) {
			
				
				Map<String, String> postRequestDetails = primaryrequest.getInitialReserveDoubleLinesPostRequestDetails(i,"10142100124208539",
						channelName, ClubId, ClubId2, code, RetailPrice, lineNumber, Applied_Dates, RegistrationNumber,
						TransactionId, arrbr, arrbry, pathsingle);
				
				Map<String, String> postRequestDetailsx = primaryrequest.getInitialReserveDoubleLinesPostRequestDetails(i,"10142100124210055",
						channelName, ClubId, ClubId2, code, RetailPrice, lineNumber, Applied_Dates, RegistrationNumber,
						TransactionId, arrbr, arrbry, pathsingle);
				
		
				
				
				postdata = postRequestDetails.get("DataPowerRequest");
				postdata2 = postRequestDetailsx.get("EmulatorRequest");

				UpdatetheRequesttoDoubleLinesBroadReach(ClubId, ClubId2, RetailPrice, lineNumber2, Applied_Dates, arrbr,
						arrbry);

				POST_the_request_for_DoubleLines_BroadReach();
				Getparameter_and_postOperation_for_DoubleLines_BroadReach();

				POST_the_emulator_request_for_Doublelines_BroadReach();
				Getemulatorparameter_and_postOperation_for_Doublelines_BroadReach();

				ChecktheResultsdoubleLinesBroadReach();

				i++;

			//}

			//else {

				//i++;
			//}

		}

		softAssertions.assertAll();

	}

	@Given("^DataPower with a (.*),(.*),(.*), and (.*) with (\\d+) for InstantSavings and (\\d+) for QuickSilver with code (\\d+) and Price (.*) and Single OrderLine (\\d+) in (.*) with Registration Number (\\d+) and TransactionId (\\d+) for Complimentary to be Utilised to Get BroadReach Offer$")

	public void createtheSingleLineAddOnRequest(String membershipBase, String type, String Tier, String channelName,
			String ClubId, String ClubId2, int code, String RetailPrice, String lineNumber, String Applied_Dates,
			String RegistrationNumber, String TransactionId) throws Exception {

		
		
		/*
		 * membershipNbr = member.memberRequest(type, membershipBase, Tier);
		 * 
		 * if (code == 1) {
		 * 
		 * long y = Long.valueOf(membershipNbr) / 10000000000L; long x =
		 * Integer.parseInt((membershipNbr).substring(8));
		 * 
		 * membershipNbr = Long.toString(y) + Long.toString(x);
		 * 
		 * }
		 */
		 
		 

		int i = 0;

		Map<String, String> mapqs = Helper.getPromotionDetails(
				reserveemulator.BroadReachSingleLinePromoMetaData(prop.get("metadata.prod.rest").toString(), i));
		int size = Integer.valueOf(mapqs.get("SizeOfMetaData"));

		while (i < size) {
			String arrbr = reserveemulator.BroadReachSingleLinePromoMetaData(prop.get("metadata.prod.rest").toString(), i);
			//10134100913186870 ,10142100863234050
			
			Map<String, String> postRequestDetails = reserveemulator.getReserveRequestDetails(i, "10142100124208539", channelName, ClubId,
					ClubId2, code, RetailPrice, lineNumber, Applied_Dates, RegistrationNumber, TransactionId, arrbr,
					pathsingle);
			
			Map<String, String> postRequestDetailsx = reserveemulator.getReserveRequestDetails(i, "10142100124210055", channelName, ClubId,
					ClubId2, code, RetailPrice, lineNumber, Applied_Dates, RegistrationNumber, TransactionId, arrbr,
					pathsingle);
			
		
			postdata = postRequestDetails.get("DataPowerRequest");
			postdata2 = postRequestDetailsx.get("EmulatorRequest");

			POST_the_request_for_DoubleLines_BroadReach();
			Getparameter_and_postOperation_for_DoubleLines_BroadReach();

			POST_the_emulator_request_for_Doublelines_BroadReach();
			Getemulatorparameter_and_postOperation_for_Doublelines_BroadReach();

			ChecktheResultsdoubleLinesBroadReach();

			i++;

		}

		softAssertions.assertAll();
	}

	
	public void UpdatetheRequesttoDoubleLinesBroadReach(String ClubId, String ClubId2, String RetailPrice,
			String lineNumber, String Applied_Dates, String arrx, String arry) throws Exception {

		Map<String, String> postDoubleRequestDetails = primaryrequest.getDoubleLinesRequest(ClubId, ClubId2, RetailPrice, lineNumber,
				Applied_Dates, postdata, postdata2, arrx, arry);

		postdata = postDoubleRequestDetails.get("DataPowerRequest");
		postdata2 = postDoubleRequestDetails.get("EmulatorRequest");

	}

	public void POST_the_request_for_DoubleLines_BroadReach() {

		RestAssured.baseURI = prop.getProperty("datapower.instantsavings");
		thisRequestSpecification = RestAssured.with();
		thisRequestSpecification.given().header("Content-Type", "text/xml").relaxedHTTPSValidation("TLS").body(postdata).when(); // header("Content-Type",
																								// // "text/xml").

	}

	public void POST_the_emulator_request_for_Doublelines_BroadReach() {

		RestAssured.baseURI = prop.getProperty("datapower.instantsavings");
		thisRequestSpecification2 = RestAssured.with();

		thisRequestSpecification2.given().header("Content-Type", "text/xml").relaxedHTTPSValidation("TLS")
				.body(postdata2).when();

	}

	public void Getparameter_and_postOperation_for_DoubleLines_BroadReach() {

		response = thisRequestSpecification.post(UrlConstants.SERVICES_CHECKOUT).then();

	}

	public void Getemulatorparameter_and_postOperation_for_Doublelines_BroadReach() {

		response2 = thisRequestSpecification2.post(UrlConstants.RESERVE_EMULATION).then();

	}

	public void ChecktheResultsdoubleLinesBroadReach() throws Exception {

		softAssertions = asserthelper.ValidationsAll(response, response2);

		// membership.deleteMembership(membershipNbr);

	}

}
