package com.sams.promotions.emulation.refundLookUp;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "requestRefundTransaction")
public class RefundTransaction {

	@XmlElement(name="BasketID", defaultValue="")
	private String basketID = "";
	
	@XmlElement(name="CreateTimeStamp", defaultValue="")
	private String createTimestamp = "";

	@XmlElement(name="BusinessUnit")
	private BusinessUnit businessUnit;
	
	@XmlElement(name="Terminal")
	private Terminal terminal;
}
