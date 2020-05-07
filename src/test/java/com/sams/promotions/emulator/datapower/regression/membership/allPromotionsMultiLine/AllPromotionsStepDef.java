package com.sams.promotions.emulator.datapower.regression.membership.allPromotionsMultiLine;

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

public class AllPromotionsStepDef extends BaseStep{
	
	protected String postdata, postdata2, arrx, arry, packagecode, packagecode2;
	protected String pathsingle, OfferId, OfferId2;
	protected String membershipNbr;
	MemberSelect member;
	protected String expected;
	protected int ItemId, ItemId2, Quantity, Quantity2, disc, disc2;
	protected Map<String, String> promodetails, promodetails2, postRequestDetails, postDoubleRequestDetails;

	private SoftAssertions softAssertions;

	public AllPromotionsStepDef() throws IOException {
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

	@Given("DataPower with a (.*), (.*), (.*), and (.*) with (\\d+) for InstantSavings and (\\d+) for QuickSilver with Code (\\d+) and Price (.*) in (.*) with Registration Number (\\d+) and TransactionId (\\d+) to be Utilised to Get Analytic Offer$")
	public void createtheInitialLinerequestforAllMembersAnalytic(String membershipBase, String type, String Tier,
			String channelName, String ClubId, String ClubId2, int code, String RetailPrice,String Applied_Dates, String RegistrationNumber, String TransactionId)
			throws Exception {

		membershipNbr = member.memberRequest(type, membershipBase, Tier);

		if (code == 1) {

			long y = Long.valueOf(membershipNbr) / 10000000000L;
			long x = Integer.parseInt((membershipNbr).substring(8));

			membershipNbr = Long.toString(y) + Long.toString(x);
			

			int i = 0;

			Map<String, String> mapqs = Helper.getPromotionDetails(
					reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), i));
			int size = Integer.valueOf(mapqs.get("SizeOfMetaData"));

			while (i < size-1) {
				
				String arrbr = reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), i);
				
				 Map<String, String> mapr = Helper.getPromotionDetails(arrbr); String offerTypeDescription
				  = mapr.get("offerTypeDescription");
				  
				 
				  
				  if(offerTypeDescription.contentEquals("OR $ off")) {
					  
					  int lineNum=1;
					  String lineNumber=Integer.toString(lineNum);
					  
					  Map<String, String> postRequestDetails = reserveemulator.getReserveRequestDetails(i, "12356789",
								"POS", "49", "47", 2, "SAME_PRICE", lineNumber, "FIRST_DATE", "27",
								"24", arrbr,UrlConstants.DATA_POWER_CLUB);
					  
					 String postdata = postRequestDetails.get("DataPowerRequest");
					 String postdata2 = postRequestDetails.get("EmulatorRequest");
					 int j=0;
					 
					 while(j<size-1) {
						 
						 String arrn = reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), j);
							
							 Map<String, String> mapn = Helper.getPromotionDetails(arrn); String offerTypeDescriptionn
							  = mapn.get("offerTypeDescription");
							  
						 
						 if(offerTypeDescriptionn.contentEquals("OR % off")) {
							  
							  lineNum=lineNum+1;
							  lineNumber=Integer.toString(lineNum);
							  
							  Map<String, String> postMultiRequestDetails = reserveemulator.getMultiLinesRequest("467", "567", "SAME_PRICE", lineNumber,
									 "FIRST_DATE", postdata, postdata2, arrn);
							 
								postdata = postMultiRequestDetails.get("DataPowerRequest");
								postdata2 = postMultiRequestDetails.get("EmulatorRequest");
								
							
								break;
							  
							 
						  }
						  
						  else {
							  j++;
						  }
					 }  
						
					 break;
				  }
				  else {
					  i++;
				  }
			}
			

		}
		
		
		softAssertions.assertAll();

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

		softAssertions = asserthelper.ValidationsAll(response, response2);

		//membership.deleteMembership(membershipNbr);

	}

}
