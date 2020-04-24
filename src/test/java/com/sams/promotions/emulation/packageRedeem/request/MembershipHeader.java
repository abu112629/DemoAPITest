package com.sams.promotions.emulation.packageRedeem.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlType(namespace="http://www.xmlns.walmartstores.com/membership/Header/datatypes/MembershipHeader/1.0/")
@XmlAccessorType(XmlAccessType.FIELD)
public class MembershipHeader {

	private String CountryCode;
	private String ClubNbr;
}
