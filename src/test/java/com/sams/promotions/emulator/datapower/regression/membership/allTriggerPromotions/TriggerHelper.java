package com.sams.promotions.emulator.datapower.regression.membership.allTriggerPromotions;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.steps.util.HeaderMapper;
import com.sams.promotions.emulation.triggerCertRequest.ActionCodeInfo;
import com.sams.promotions.emulation.triggerCertRequest.ActionInfo;
import com.sams.promotions.emulation.triggerCertRequest.TriggerCertPayload;
import com.sams.promotions.emulation.triggerRequest.EventAttributes;
import com.sams.promotions.emulation.triggerRequest.Payload;
import com.sams.promotions.emulation.triggerRequest.TriggerPayload;

import io.restassured.response.Response;

public class TriggerHelper extends BaseStep{

	public TriggerHelper() throws IOException {
		super();
	}

	HeaderMapper headerMapper;
	protected Helper helpermethod;
	
	public String TriggerCertRequest(String arrx,String membershipNbr,String requestTs,String ClubNbr,String actioncode,String actionDesc,String Uri) throws JsonParseException, JsonMappingException, IOException, ParseException {

		headerMapper = new HeaderMapper();
		helpermethod = new Helper();
		
		Map<String, String> map = Helper.getDatesMetadata(arrx);
		
		long membershipNumber=Long.valueOf(membershipNbr);
		long ClubId=Long.valueOf(ClubNbr);
		long actcode=Long.valueOf(actioncode);
		String triggerpayload=helpermethod.GenerateStringFromResource(UrlConstants.TRIGGER_JSON_CERT_REQUEST);
		ObjectMapper objectmapper = new ObjectMapper();
		TriggerCertPayload triggerreq = objectmapper.readValue(triggerpayload, TriggerCertPayload.class);
		
		
		triggerreq.setMembershipNbr(membershipNumber);
		
		switch (requestTs) {
		
		case "FIRST_DATE":
			
			triggerreq.setRequestTs(map.get("firstdate"));
			break;
			
		case "MIDDLE_DATE":
			triggerreq.setRequestTs(map.get("midDate"));
			break;
			
		case "LAST_DATE":
			triggerreq.setRequestTs(map.get("lastdate"));
			break;
		
		}
		
		triggerreq.setClubNbr(ClubId);
		ActionInfo actionInfo=triggerreq.getActionInfo();
		ActionCodeInfo actioncodeInfo=actionInfo.getActionCodeInfo();
		actioncodeInfo.setActionCode(actcode);
		actioncodeInfo.setActionDesc(actionDesc);
		
		objectmapper.writeValueAsString(triggerreq);
		Map<String, Object> header = headerMapper.mapHeaders(UrlConstants.TRIGGER_CERT_HEADER_PATH);
		
		Response res = helpermethod.sendPostRequest(Uri, UrlConstants.CHECKOUT_TRIGGERS_CERT, header,objectmapper.writeValueAsString(triggerreq));
		String triggerCertResponse = res.prettyPrint();
		
		return triggerCertResponse;

		
	
	}
	
	public String TriggerEmulatorRequest(String arrx,String membershipNbr,String requestTs,String ClubNbr,String actioncode,String Uri) throws Exception {

		headerMapper = new HeaderMapper();
		helpermethod = new Helper();
		
		Map<String, String> map = Helper.getDatesMetadata(arrx);
		
		String triggerpayload=helpermethod.GenerateStringFromResource(UrlConstants.TRIGGER_JSON_EMULATOR_REQUEST);
		ObjectMapper objectmapper = new ObjectMapper();
		TriggerPayload triggerreq = objectmapper.readValue(triggerpayload, TriggerPayload.class);
		
		
		Payload payload=triggerreq.getPayload();
		payload.setEventId(actioncode);
		
		switch (requestTs) {
		
		case "FIRST_DATE":
			
			payload.setRequestTimestamp(map.get("firstdate"));
			break;
			
		case "MIDDLE_DATE":
			payload.setRequestTimestamp(map.get("midDate"));
			break;
			
		case "LAST_DATE":
			payload.setRequestTimestamp(map.get("lastdate"));
			break;
		
		}
		
		EventAttributes eventattr=payload.getEventAttributes();
		eventattr.setMembershipId(membershipNbr);
		eventattr.setClubId(ClubNbr);
		
		
		objectmapper.writeValueAsString(triggerreq);
		
		Map<String, Object> header = headerMapper.mapHeaders(UrlConstants.TRIGGER_QS_HEADER_PATH);
		
		Response res = helpermethod.sendPostRequest(Uri, UrlConstants.CHECKOUT_TRIGGERS_QS, header,objectmapper.writeValueAsString(triggerreq));
		String triggerCertResponse = res.prettyPrint();

		
		return triggerCertResponse;

		
	
	}

}