package com.sams.promotions.emulation.test.common.constants;

public class MembershipConstants {

	public static final String MEMBERSHIP_PATH_PARAMS = "/membership-core/membership/";
	public static final String MEMBERSHIP_HEADER = "createMembershipHeader.txt";
	public static final String MEMBERSHIP_DELETE_PARAMS="/updateStatus/deleted";

	public static final String MEMBERSHIP_HEADER_PATH = "src/test/resources/requestHeader/";
	public static final String MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH = "src/test/resources/Emulation_Input/createMembershipRequest.json";
	public static final String MEMBERSHIP_SAVINGS_PLUS_REQUEST_PATH = "src/test/resources/Emulation_Input/createPlusMembershipRequest.json";
	
	public static final String MEMBERSHIP_BUSINESS_REQUEST_PATH="src/test/resources/Emulation_Input/createBusinessMembershipRequest.json";
	public static final String MEMBERSHIP_BUSINESS_PLUS_REQUEST_PATH="src/test/resources/Emulation_Input/createBusinessPlusMembershipRequest.json";
	//Response path
	public static final String MEMBERSHIP_MEMBERSHIPCARD_PATH = "membership.printedMembershipCard";
	public static final String MEMBERSHIP_REFERENCE = "membership.parentMembershipReference";
	public static final String MEMBERSHIP_ROLE = "membership.memberRole";
}
