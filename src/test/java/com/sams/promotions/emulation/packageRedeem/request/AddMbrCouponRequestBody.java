package com.sams.promotions.emulation.packageRedeem.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.sams.promotions.emulation.packageRedeem.request.MembershipInfo;
import com.sams.promotions.emulation.packageRedeem.request.CouponInfo;
import lombok.Getter;
import lombok.Setter;
//"http://www.xmlns.walmartstores.com/membership/bsl/messages/ManageMbrCoupon/1.0.0/"
@Getter
@Setter
@XmlType(namespace="http://www.xmlns.walmartstores.com/membership/bsl/datatypes/ManageMbrCoupon/1.0.0/")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddMbrCouponRequestBody {

	private MembershipInfo MembershipInfo;
	private CouponInfo CouponInfo;
}