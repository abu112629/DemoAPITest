package com.sams.promotions.emulator.datapower.regression.membership.allPromotions;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.MembershipConstants;
import com.sams.promotions.emulation.test.helper.AssertHelper;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.PrimaryRequestHelper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.membershipCreate.Membership;
import io.restassured.response.Response;

public class Membership_Types extends BaseStep{

	private Response membershipResponse;
	
	public Membership_Types() throws IOException {
		super();
	}
	
	public String getMembershipType(String memberRequest,String type,String tier) throws IOException, ParseException {
		
		primaryrequest=new PrimaryRequestHelper();
		reserveemulator = new ReserveEmulationHelper();
		helper = new Helper();
		asserthelper=new AssertHelper();
		membership = new Membership();

		
		String membershipNbr;
		
		String requiredMembership="";
		
		switch(memberRequest) {
		
		case "primary":
			
			switch(type) {
		
					case "business":
						
						switch(tier) {
						
							case "Club":
								
								membershipResponse = membership
								.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_BUSINESS_REQUEST_PATH);
								requiredMembership = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
								break;
						
							case "Plus":
								
								membershipResponse = membership
								.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_BUSINESS_PLUS_REQUEST_PATH);
								requiredMembership = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
								break;
						
						
						}
						
					   break;
						
					case "savings":
						
						switch(tier) {
						
								case "Club":
									
									membershipResponse = membership
									.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH);
									requiredMembership = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);

									break;
									
							
								case "Plus":
									

									membershipResponse = membership
											.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_SAVINGS_PLUS_REQUEST_PATH);
									requiredMembership = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);

									
									break;
								
						
						}
						break;					
				
				
		}
			break;
			
			case "complimentary":
			
			switch(type) {
		
					case "business":
						
						switch(tier) {
						
							case "Club":
								
								membershipResponse = membership.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_BUSINESS_REQUEST_PATH);
								membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
								
								requiredMembership=membership.membershipComplimentary(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH,
										membershipNbr);
								break;
						
							case "Plus":
								
								membershipResponse = membership.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_BUSINESS_PLUS_REQUEST_PATH);
								membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
								
								requiredMembership=membership.membershipComplimentary(MembershipConstants.MEMBERSHIP_SAVINGS_PLUS_REQUEST_PATH,
										membershipNbr);
								break;
						
						
						}
						
					   break;
						
					case "savings":
						
						switch(tier) {
						
								case "Club":
									
									membershipResponse = membership.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH);
									membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
									
									requiredMembership=membership.membershipComplimentary(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH,
											membershipNbr);	break;
							
								case "Plus":
									
									membershipResponse = membership.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_SAVINGS_PLUS_REQUEST_PATH);
									membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
									
									requiredMembership=membership.membershipComplimentary(MembershipConstants.MEMBERSHIP_SAVINGS_PLUS_REQUEST_PATH,
											membershipNbr);
									break;
								
						
						}
						break;					
				
				
		}
			break;
			
			case "addon complimentary":
				
				switch(type) {
			
						case "business":
							
							switch(tier) {
							
								case "Club":
									
									membershipResponse = membership
									.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_BUSINESS_REQUEST_PATH);
									membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
							
									requiredMembership=membership.membershipAddOnComplimentary(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH,
									membershipNbr);
									break;
							
								case "Plus":
									
									membershipResponse = membership
									.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_BUSINESS_PLUS_REQUEST_PATH);
									membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
									requiredMembership=membership.membershipAddOnComplimentary(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH,
									membershipNbr);
							
									break;
							
							
							}
							
						   break;
							
						case "savings":
							
							switch(tier) {
							
									case "Club":
										
										membershipResponse = membership
										.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH);
										membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
								
										requiredMembership=membership.membershipAddOnComplimentary(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH,
										membershipNbr);
										break;
								
									case "Plus":
										
										membershipResponse = membership
										.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_SAVINGS_PLUS_REQUEST_PATH);
										membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);	
										requiredMembership=membership.membershipAddOnComplimentary(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH,
										membershipNbr);
										break;
									
							
							}
							break;					
					
					
			}
			break;
			
			
			case "addon":
				
				switch(type) {
			
						case "business":
							
							switch(tier) {
							
								case "Club":
									
									membershipResponse = membership
									.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_BUSINESS_REQUEST_PATH);
									membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
						
									requiredMembership=membership.membershipAddOn(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH,
									membershipNbr);
									break;
							
								case "Plus":
									
									membershipResponse = membership
									.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_BUSINESS_PLUS_REQUEST_PATH);
									membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
						
									requiredMembership=membership.membershipAddOn(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH,
									membershipNbr);
									break;
							
							
							}
							
						   break;
							
						case "savings":
							
							switch(tier) {
							
									case "Club":
										
										membershipResponse = membership
										.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH);
										membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
								
										requiredMembership=membership.membershipAddOn(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH,
										membershipNbr);

										break;
								
									case "Plus":
										
									
										membershipResponse = membership
										.createPRIMARYMembership(MembershipConstants.MEMBERSHIP_SAVINGS_PLUS_REQUEST_PATH);
										membershipNbr = helper.getResponseValue(membershipResponse, MembershipConstants.MEMBERSHIP_MEMBERSHIPCARD_PATH);
								
										requiredMembership=membership.membershipAddOn(MembershipConstants.MEMBERSHIP_SAVINGS_BASE_REQUEST_PATH,
										membershipNbr);

										break;
									
							
							}
							break;					
					
					
			}
			break;
		}
		
		
		return requiredMembership;
		
		
	}
	
	
	
	
}
