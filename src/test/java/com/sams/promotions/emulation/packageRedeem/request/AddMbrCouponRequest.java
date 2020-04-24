package com.sams.promotions.emulation.packageRedeem.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sams.promotions.emulation.packageRedeem.request.MessageHeader;
import com.sams.promotions.emulation.packageRedeem.request.MembershipHeader;
import com.sams.promotions.emulation.packageRedeem.request.AddMbrCouponRequestBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="AddMbrCouponRequest")
public class AddMbrCouponRequest {
	
	private MessageHeader MessageHeader;
	
	private MembershipHeader MembershipHeader;
	
	private AddMbrCouponRequestBody AddMbrCouponRequestBody;
}
