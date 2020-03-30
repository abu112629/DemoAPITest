package com.sams.promotions.emulator.datapower.regression.membership.allPromotions;

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
	Membership_Types member;
	protected String expected;
	protected int i, ItemId, ItemId2, Quantity, Quantity2, disc, disc2;
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
		member = new Membership_Types();

	}

	@Given("DataPower with a (.*), (.*), (.*), and (.*) with (\\d+) for InstantSavings and (\\d+) for QuickSilver with Code (\\d+) and Price (\\d+) and Single OrderLine (\\d+), Second Order Line (\\d+) in (.*) with Registration Number (\\d+) and TransactionId (\\d+) to be Utilised to Get Analytic Offer$")
	public void createtheInitialLinerequestforAllMembersAnalytic(String membershipBase, String type, String Tier,
			String channelName, String ClubId, String ClubId2, int code, int RetailPrice, String lineNumber,
			String lineNumber2, String Applied_Dates, String RegistrationNumber, String TransactionId)
			throws Exception {

		membershipNbr = member.getMembershipType(type, membershipBase, Tier);

		if (code == 1) {

			long y = Long.valueOf(membershipNbr) / 10000000000L;
			long x = Integer.parseInt((membershipNbr).substring(8));

			membershipNbr = Long.toString(y) + Long.toString(x);

		}

		/*
		 * Map<String, String> mapqs =
		 * Helper.getPromotionDetails(reserveemulator.BroadReachPromoMetaData(prop.get(
		 * "metadata.prod.rest").toString(), i)); int size =
		 * Integer.valueOf(mapqs.get("SizeOfMetaData"));
		 */

		i = 0;

		while (i < 1) {

			String arrbr = reserveemulator.AnalyticPromoMetaData(prop.get("metadata.prod.rest").toString(),i);

			String arrbry = reserveemulator.AnalyticPromoMetaData(prop.get("metadata.prod.rest").toString(),i+1);

			postRequestDetails = primaryrequest.getInitialReserveDoubleLinesPostRequestDetails(i, membershipNbr,
					channelName, ClubId, ClubId2, code, RetailPrice, lineNumber, Applied_Dates, OfferId, OfferId2,
					RegistrationNumber, TransactionId, arrbr, arrbry, pathsingle);

			postdata = postRequestDetails.get("DataPowerRequest");
			postdata2 = postRequestDetails.get("EmulatorRequest");
			disc = Integer.valueOf(postRequestDetails.get("FirstItemDiscount"));
			disc2 = Integer.valueOf(postRequestDetails.get("SecondItemDiscount"));

			packagecode = postRequestDetails.get("PackageCode");
			packagecode2 = postRequestDetails.get("PackageCode2");

			OfferId = postRequestDetails.get("OfferId");
			OfferId2 = postRequestDetails.get("OfferId2");

			UpdatetheRequesttoDoubleLinesAnalytic(ClubId, ClubId2, RetailPrice, lineNumber2, Applied_Dates);

			POST_the_request_for_DoubleLines_Analytic();
			Getparameter_and_postOperation_for_DoubleLines_Analytic();

			POST_the_emulator_request_for_Doublelines_Analytic();
			Getemulatorparameter_and_postOperation_for_Doublelines_Analytic();

			ChecktheResultsdoubleLinesAnalytic();

			i++;

		}

		softAssertions.assertAll();

	}

	@Given("^DataPower with a (.*),(.*),(.*), and (.*) with (\\d+) for InstantSavings and (\\d+) for QuickSilver with code (\\d+) and Price (\\d+) and Single OrderLine (\\d+) in (.*) with Registration Number (\\d+) and TransactionId (\\d+) to be Utilised to Get Analytic Offer$")

	public void createtheSingleLineRequestAnalytic(String membershipBase,String type,String Tier,
			String channelName, String ClubId, String ClubId2, int code, int RetailPrice, String lineNumber,
			String Applied_Dates, String RegistrationNumber, String TransactionId) throws Exception {
		    
		/*
		 * String arrz =
		 * reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").
		 * toString(), 0); Map<String, String> getsize =
		 * Helper.getPromotionDetails(arrz);
		 * 
		 * int size = Integer.valueOf(getsize.get("SizeOfMetaData"));
		 */

		
		membershipNbr = member.getMembershipType(type,membershipBase,Tier);

		if (code == 1) {

			long y = Long.valueOf(membershipNbr) / 10000000000L;
			long x = Integer.parseInt((membershipNbr).substring(8));

			membershipNbr = Long.toString(y) + Long.toString(x);

		}

		i = 0;

		while (i < 1) {
			
			String arrbr = reserveemulator.AnalyticPromoMetaData(prop.get("metadata.prod.rest").toString(),i);

			postRequestDetails = reserveemulator.getReserveRequestDetails(i, membershipNbr, channelName, ClubId,
					ClubId2, code, RetailPrice, lineNumber, Applied_Dates, OfferId, RegistrationNumber, TransactionId,arrbr,
					pathsingle);

			postdata = postRequestDetails.get("DataPowerRequest");
			postdata2 = postRequestDetails.get("EmulatorRequest");

			packagecode = postRequestDetails.get("PackageCode");
			OfferId = postRequestDetails.get("OfferId");
			expected = postRequestDetails.get("expected");

			POST_the_request_for_DoubleLines_Analytic();
			Getparameter_and_postOperation_for_DoubleLines_Analytic();

			POST_the_emulator_request_for_Doublelines_Analytic();
			Getemulatorparameter_and_postOperation_for_Doublelines_Analytic();

			ChecktheResultsdoubleLinesAnalytic();

			i++;

		}

		softAssertions.assertAll();
	}


	public void UpdatetheRequesttoDoubleLinesAnalytic(String ClubId, String ClubId2, int RetailPrice,
			String lineNumber, String Applied_Dates) throws Exception {

		postDoubleRequestDetails = primaryrequest.getDoubleLinesRequest(disc, disc2, packagecode, packagecode2, ClubId,
				ClubId2, RetailPrice, lineNumber, Applied_Dates, OfferId, OfferId2, postdata, postdata2);

		postdata = postDoubleRequestDetails.get("DataPowerRequest");
		postdata2 = postDoubleRequestDetails.get("EmulatorRequest");

		expected = postDoubleRequestDetails.get("expected");

	}

	public void POST_the_request_for_DoubleLines_Analytic() {

		RestAssured.baseURI = prop.getProperty("datapower.prod.instantsavings");
		thisRequestSpecification = RestAssured.with();
		thisRequestSpecification.given().relaxedHTTPSValidation("TLS").body(postdata).when(); // header("Content-Type",
																								// // "text/xml").

	}

	public void POST_the_emulator_request_for_Doublelines_Analytic() {

		RestAssured.baseURI = prop.getProperty("datapower.cert.instantsavings");
		thisRequestSpecification2 = RestAssured.with();

		thisRequestSpecification2.given().header("Content-Type", "text/xml").relaxedHTTPSValidation("TLS")
				.body(postdata2).when();

	}

	public void Getparameter_and_postOperation_for_DoubleLines_Analytic() {

		response = thisRequestSpecification.post(UrlConstants.SERVICES_CHECKOUT).then();

	}

	public void Getemulatorparameter_and_postOperation_for_Doublelines_Analytic() {

		response2 = thisRequestSpecification2.post(UrlConstants.RESERVE_EMULATION).then();

	}

	public void ChecktheResultsdoubleLinesAnalytic() throws Exception {

		softAssertions = asserthelper.ValidationsAll(response, response2, packagecode, packagecode2, OfferId, OfferId2,
				expected);

		membership.deleteMembership(membershipNbr);

	}

}
