package com.sams.promotions.emulator.datapower.regression.membership.allPackagePromotions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.Unmarshaller;

import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sams.promotions.emulation.packageRedeem.jsonRequest.CouponSingleUserCoupon;
import com.sams.promotions.emulation.packageRedeem.jsonRequest.Payload;
import com.sams.promotions.emulation.packageRedeem.request.AddMbrCouponRequest;
import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.steps.util.HeaderMapper;
import com.sams.promotions.platform.emulation.util.mapper.JaxBInitializer;
import com.sams.promotions.platform.emulation.util.soap.SOAPUtil;

import io.restassured.response.Response;

public class PackagePromoHelper extends BaseStep{
	
	protected Helper helpermethod;
	protected Unmarshaller xmlUnmarshaller;
	HeaderMapper headerMapper;
	private SOAPUtil soapUtil;
	public PackagePromoHelper() throws IOException {
		super();
	}

	public String RedeemCouponUpdater(String ClubNbr, String MembershipNbr, String CardholderNbr, String ValueCouponNbr,
			String RedeemCouponPath,String uri) throws Exception {

		helpermethod = new Helper();

		xmlUnmarshaller = new JaxBInitializer().initUnmarshaller(AddMbrCouponRequest.class);

		String xml = helpermethod.GenerateStringFromResource(RedeemCouponPath);
		soapUtil = new SOAPUtil();

		AddMbrCouponRequest req = soapUtil.unwrapSoap(xmlUnmarshaller, xml, AddMbrCouponRequest.class);
		req.getMembershipHeader().setCountryCode("1");
		req.getMembershipHeader().setClubNbr(ClubNbr);
		req.getAddMbrCouponRequestBody().getMembershipInfo().setMembershipNbr(MembershipNbr);
		req.getAddMbrCouponRequestBody().getMembershipInfo().setCardholderNbr(CardholderNbr);
		req.getAddMbrCouponRequestBody().getCouponInfo().setValueCouponNbr(ValueCouponNbr);
		//req.getAddMbrCouponRequestBody().getCouponInfo().getPackageDurationInfo().setPkgDurationCode(PkgDurationCode);
		//req.getAddMbrCouponRequestBody().getCouponInfo().getPackageDurationInfo().setPkgDurationDesc(PkgDurationDesc);

		//req.getAddMbrCouponRequestBody().getCouponInfo().getRedemptionInfo().setDateRedeemed(DateRedeemed);
		//req.getAddMbrCouponRequestBody().getCouponInfo().getRedemptionInfo().setRedeemptionLeft(RedeemptionLeft);

		String req1 = soapUtil.wrapSoap(req);
		System.out.println(Helper.getPrettyString(req1));
		Map<String, Object> header =new HashMap<>();
		header.put("Content-Type", "text/xml");
		
		Response res=helpermethod.sendPostRequest(uri, UrlConstants.CHECKOUT_PACKAGE_COUPON, header, req1);
		
		String packageCouponResp=res.prettyPrint();
		return packageCouponResp;

	}
	
	public String RedeemCouponUpdaterEmulator(String couponGroup,String memberId,String Uri) throws IOException,ClientProtocolException {
		
		helpermethod = new Helper();
		headerMapper = new HeaderMapper();
		
		String redeempayload=helpermethod.GenerateStringFromResource(UrlConstants.COUPON_REDEMPTION_JSON);
		ObjectMapper objectmapper = new ObjectMapper();
		
		CouponSingleUserCoupon redeempay=objectmapper.readValue(redeempayload, CouponSingleUserCoupon.class);
		Payload payload =redeempay.getPayload();
		
		payload.setMemberId(memberId);
		payload.setCouponGroup(couponGroup);
		
		
		objectmapper.writeValueAsString(redeempay);
		
		Map<String, Object> header = headerMapper.mapHeaders(UrlConstants.PACKAGE_QS_HEADER_PATH);
		Response res = helpermethod.sendPostRequest(Uri, UrlConstants.CHECKOUT_PACKAGE_QS, header,objectmapper.writeValueAsString(redeempay));
		String packageresponse=res.prettyPrint();
		
		
		return packageresponse;
		
		
		
	}
	
}
