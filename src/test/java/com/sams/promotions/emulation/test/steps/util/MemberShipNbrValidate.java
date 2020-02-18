package com.sams.promotions.emulation.test.steps.util;

public class MemberShipNbrValidate {
	
	
public String validateMembershipNbr(String membershipNbr) throws Exception {
		
		switch (membershipNbr.length()) {
		case 11:
			return membershipNbr;
		case 13:
			return membershipNbr.substring(2, 13);
		case 16:
			return membershipNbr.substring(5, 16);
		case 17:
			return membershipNbr.substring(5, 7) + membershipNbr.substring(8, 17);
	}
		return membershipNbr;
	

	}
	 
	 
	 

}
