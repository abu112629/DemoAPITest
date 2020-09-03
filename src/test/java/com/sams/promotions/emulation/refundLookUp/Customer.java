package com.sams.promotions.emulation.refundLookUp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)

public class Customer {
	
	@XmlElement(name="MembershipNbr")
	private String membershipNumber;
}
