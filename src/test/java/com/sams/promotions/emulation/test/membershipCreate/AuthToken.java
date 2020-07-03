package com.sams.promotions.emulation.test.membershipCreate;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpStatus;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.AuthTokenConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.steps.util.HeaderMapper;

import io.restassured.response.Response;

public class AuthToken extends BaseStep{

	public AuthToken() throws IOException {
		super();
	}

	HeaderMapper headerMapper = new HeaderMapper();
	Helper helper=new Helper();

	public String getMembershipAuthToken() {
		Map<String, Object> header = headerMapper
				.mapHeaders(AuthTokenConstants.AUTH_TOKEN_HEADER_PATH + "authTokenMembershipHeader.txt");

		Response response = helper.getAuthToken(prop.get("membership.stage.endpoint").toString(),
				AuthTokenConstants.AUTH_TOKEN_PATH_PARAMS, header,
				AuthTokenConstants.AUTH_TOKEN_FORM_PARAMS_MEMBERSHIP_CLIENT_ID,
				AuthTokenConstants.AUTH_TOKEN_FORM_PARAMS_MEMBERSHIP_CLIENT_SECRET);
		
		assertEquals("Auth token is not created. Error : " + response.asString(), HttpStatus.SC_OK,
				response.getStatusCode());

		return response.jsonPath().getString("access_token");
	}


}
