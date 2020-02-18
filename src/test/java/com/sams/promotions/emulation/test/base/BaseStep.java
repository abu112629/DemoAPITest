package com.sams.promotions.emulation.test.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Configuration;

import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.AddOnPrimaryRequestHelper;
import com.sams.promotions.emulation.test.helper.AssertHelper;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.PrimaryRequestHelper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.membershipCreate.Membership;

import io.restassured.response.ValidatableResponse;

//import com.sams.membership.nextgentest.steps.util.MembershipHelper;
//import com.sams.membership.nextgentest.validation.ValidationHelper;

import io.restassured.specification.RequestSpecification;

@Configuration
public class BaseStep {

	public static Properties prop;

//	 @Autowired
//	    protected ValidationHelper validationHelper;

	protected RequestSpecification thisRequestSpecification,thisRequestSpecification2;

	protected ValidatableResponse response,response2;

	protected ReserveEmulationHelper reserveemulator;
	
	protected PrimaryRequestHelper primaryrequest;
	
	protected AddOnPrimaryRequestHelper addOnprimaryrequest;
	
	protected Membership membership;
	
	protected Helper helper;
	
	protected AssertHelper asserthelper;

	public BaseStep() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(UrlConstants.PROPERTIES_FILE);
		prop.load(fis);

	}

}
