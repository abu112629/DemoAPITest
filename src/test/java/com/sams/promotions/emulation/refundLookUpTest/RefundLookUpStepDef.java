package com.sams.promotions.emulation.refundLookUpTest;

import java.io.IOException;
import java.util.Map;

import org.assertj.core.api.SoftAssertions;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;

public class RefundLookUpStepDef extends BaseStep {

	RefundLookUpRequestUpdater refund;
	RedeemDocumentLookUp redeemlookup;
	protected String refundrequest, result,postdata,postdata2;
	SoftAssertions softAssertions;

	public RefundLookUpStepDef() throws IOException {
		super();
	}

	@Before
	public void beforeSetup() throws IOException {

		reserveemulator = new ReserveEmulationHelper();
		helper = new Helper();
		refund = new RefundLookUpRequestUpdater();
		refundrequest = UrlConstants.REFUND_LOOKUP_REQUEST;
		redeemlookup = new RedeemDocumentLookUp();
		softAssertions = new SoftAssertions();

	}

	@Given("^Refund LookUp Request with (.*),(\\d+),(.*),(.*),(.*),(.*),(.*)$")
	public void RefundCheckoutCartCreation(String OrderId, int code, String Channel, String BasketId, String BusinessUnit,
			String terminalID, String lineNumber) throws Exception {

		{

			Map<String, String> promodetails = helper
					.getCosmosTransactionDetails(redeemlookup.ForwardSyncValidator(0, OrderId));

			int size = Integer.valueOf(promodetails.get("Size"));

			for (int i = 0; i < size; i++) {

				result = redeemlookup.ForwardSyncValidator(i, OrderId);
				Map<String, String> promodetailsCosmos = helper.getCosmosTransactionDetails(result);

				String PromoId = promodetailsCosmos.get("PromoId");
				String Quantity = promodetailsCosmos.get("Quantity");
				String RegisterNumber = promodetailsCosmos.get("RegisterNumber");
				String TransactioNumber = promodetailsCosmos.get("TransactioNumber");
				String MembershipId = promodetailsCosmos.get("MembershipId");
				String Clubid = promodetailsCosmos.get("Clubid");
				String RedemptionDate = promodetailsCosmos.get("RedemptionDate");

				postdata = refund.RefundRequestUpdater(MembershipId, code, Channel, BasketId, Helper.CurrentDate(),
						BusinessUnit, terminalID, lineNumber, PromoId, Quantity, RegisterNumber, RedemptionDate, Clubid,
						TransactioNumber, refundrequest);
				System.out.println(postdata);
			}
			
			POST_Refund_API_LookUp_Request_Legacy();
			POST_Refund_API_LookUp_Request_QuickSilver();
			Getparameter_and_postOperation_for_Legacy_Refund_API();
			Getparameter_and_postOperation_for_QuickSilver_Refund_API();
			ChecktheResultsforRefundAPI();
			

		}	
		
		softAssertions.assertAll();
	}
	
	
	public void POST_Refund_API_LookUp_Request_Legacy() {
		
		RestAssured.baseURI = prop.getProperty("datapower.refundlookup");
		thisRequestSpecification = RestAssured.with();
		thisRequestSpecification.given().header("Content-Type", "text/xml").relaxedHTTPSValidation("TLS").body(postdata).when();
		
	}
	

	public void POST_Refund_API_LookUp_Request_QuickSilver() {
		
		RestAssured.baseURI = prop.getProperty("mercury.quicksilver.refundlookup");
		thisRequestSpecification2 = RestAssured.with();
		thisRequestSpecification2.given().header("Content-Type", "application/xml").relaxedHTTPSValidation("TLS").body(postdata).when();
		
	}

	public void Getparameter_and_postOperation_for_Legacy_Refund_API() {

		response = thisRequestSpecification.post(UrlConstants.REFUND_SERVICES_CHECKOUT).then();

	}

	
	public void Getparameter_and_postOperation_for_QuickSilver_Refund_API() {

		response2 = thisRequestSpecification2.post(UrlConstants.REFUND_SERVICES_QS).then();

	}
	
	
	public void ChecktheResultsforRefundAPI() throws Exception {

		softAssertions =redeemlookup.ValidationsAll(response, response2) ;


	}
}
