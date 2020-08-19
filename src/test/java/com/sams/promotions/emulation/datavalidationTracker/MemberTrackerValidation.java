package com.sams.promotions.emulation.datavalidationTracker;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.SoftAssertions;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.steps.util.ClientConfigurationDatabase;

import cucumber.api.java.en.Given;

public class MemberTrackerValidation extends BaseStep{
	
	private ClientConfigurationDatabase connection;
	private SoftAssertions softAssertions = new SoftAssertions();
	
	public MemberTrackerValidation() throws IOException {
		super();
	}

	
	@Given("^Validate Member Tracker Data with (.*),(.*),(.*) and (\\d+)$")
	public void validate_Member_Tracker(String membershipId,String CardHolder,String Promotion,int redemptionLeft) throws Exception {

		String redemption=String.valueOf(redemptionLeft);
		String memberId;
		if(membershipId.length()<9) {
			
			memberId=StringUtils.leftPad(""+ Integer.valueOf(membershipId),9, "0");
		}
		
		else {
			memberId=membershipId;
		}
		
		connection = new ClientConfigurationDatabase();
		String document=connection.checkMemberTracker(memberId, CardHolder, Promotion, redemption, "Metadata");
		
		System.out.println(document);
		softAssertions.assertThat(!document.isEmpty());
		
		softAssertions.assertAll();
	}
	
	
	
}

