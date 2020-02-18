package com.sams.promotions.emulation.test.membershipCreate;

import java.io.IOException;

import com.sams.promotions.emulation.test.common.constants.MembershipConstants;

public class CreateMembershipSteps extends Membership {

	public CreateMembershipSteps() throws IOException {
		super();
	}

	public void verify_user_can_create_membership() {
		createPRIMARYMembership(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH);
	}
}
