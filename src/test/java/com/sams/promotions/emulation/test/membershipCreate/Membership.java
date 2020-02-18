package com.sams.promotions.emulation.test.membershipCreate;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.AuthTokenConstants;
import com.sams.promotions.emulation.test.common.constants.MembershipConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.steps.util.HeaderMapper;

import io.restassured.response.Response;

public class Membership extends BaseStep{
	
	
	public Membership() throws IOException {
		super();
	}
	Helper helper=new Helper();
	HeaderMapper headerMapper = new HeaderMapper();
	AuthToken authToken = new AuthToken();
	
	public Response createPRIMARYMembership(String path) {

		Map<String, Object> header = headerMapper
				.mapHeaders(MembershipConstants.MEMBERSHIP_HEADER_PATH + "createMembershipHeader.txt");

		// Get auth token
		header.put(AuthTokenConstants.AUTHORIZATION, authToken.getMembershipAuthToken());
		

		Response response = helper.sendPostRequest(prop.get("membership.stage.endpoint").toString(),
				MembershipConstants.MEMBERSHIP_PATH_PARAMS, header,
				path);

		assertEquals("Membership is not created. Error : " + response.asString(), HttpStatus.SC_OK,
				response.getStatusCode());
		
		return response;

	}
	
	public Response createOtherMembership(String requestBody) {

		Map<String, Object> header = headerMapper
				.mapHeaders(MembershipConstants.MEMBERSHIP_HEADER_PATH + "createMembershipHeader.txt");

		// Get auth token
		header.put(AuthTokenConstants.AUTHORIZATION, authToken.getMembershipAuthToken());
		
		
		Response response = helper.sendPostRequest(prop.get("membership.stage.endpoint").toString(),
				MembershipConstants.MEMBERSHIP_PATH_PARAMS, header,
				requestBody);

		assertEquals("Membership is not created. Error : " + response.asString(), HttpStatus.SC_OK,
				response.getStatusCode());
		
		return response;

	}
	
	public Response deleteMembership(String membershipReference ) {
		

		Map<String, Object> header = headerMapper
				.mapHeaders(MembershipConstants.MEMBERSHIP_HEADER_PATH + "createMembershipHeader.txt");

		// Get auth token
		header.put(AuthTokenConstants.AUTHORIZATION, authToken.getMembershipAuthToken());
		
		Response response = helper.deleteRequest(prop.get("membership.stage.endpoint").toString(),
				MembershipConstants.MEMBERSHIP_PATH_PARAMS, header,
				MembershipConstants.MEMBERSHIP_DELETE_PARAMS,membershipReference);

		return response;

	}
	
	
	
	public String membershipComplimentary(String complimentaryPath,String membershipNbr) throws IOException, ParseException {
		
		JSONObject req2 = helper.updateMembershipRequest("COMPLIMENTARY", membershipNbr,complimentaryPath);
		Response complimentarymemberhipResponse = createOtherMembership(req2.toJSONString());
		String complimentarymembershipNbr = helper.getResponseValue(complimentarymemberhipResponse,
				MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
		return complimentarymembershipNbr;
		
		
	}
	
	public String membershipAddOn(String addOnPath,String membershipNbr) throws IOException, ParseException {
		
		JSONObject req2=helper.updateMembershipRequest("ADD_ON",membershipNbr,addOnPath);
		Response add_On_memberhipResponse=createOtherMembership(req2.toJSONString());
		String add_On_membershipNbr=helper.getResponseValue(add_On_memberhipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
		return add_On_membershipNbr;
		
		
	}
	
	public String membershipAddOnComplimentary(String addOnComplimentaryPath,String membershipNbr) throws IOException, ParseException {
		
		JSONObject req2=helper.updateMembershipRequest("ADD_ON",membershipNbr,addOnComplimentaryPath);
		Response add_On_memberhipResponse=createOtherMembership(req2.toJSONString());
		String add_On_membershipNbr=helper.getResponseValue(add_On_memberhipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);

		JSONObject req3 = helper.updateMembershipRequest("ADD_ON_COMPLIMENTARY", add_On_membershipNbr,addOnComplimentaryPath);
		Response add_On_Complimentary_memberhipResponse = createOtherMembership(req3.toJSONString());
		String add_On_Complimentary_membershipNbr = helper.getResponseValue(add_On_Complimentary_memberhipResponse,
				MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
		return add_On_Complimentary_membershipNbr;
		
		
	}
	
	
}
