package com.sams.promotions.emulation.packageRedeem.request;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.sams.promotions.emulation.packageRedeem.request.PackageDurationInfo;
import com.sams.promotions.emulation.packageRedeem.request.RedemptionInfo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@XmlType(namespace="http://www.xmlns.walmartstores.com/membership/bsl/datatypes/ManageMbrCoupon/1.0.0/")
@XmlAccessorType(XmlAccessType.FIELD)
public class CouponInfo {
	
	private String ValueCouponNbr;
	private PackageDurationInfo PackageDurationInfo;
	private RedemptionInfo RedemptionInfo;
}
