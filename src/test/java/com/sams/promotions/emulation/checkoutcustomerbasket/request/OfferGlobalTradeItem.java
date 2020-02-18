package com.sams.promotions.emulation.checkoutcustomerbasket.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferGlobalTradeItem {
	
	@XmlElement(defaultValue="0")
	private String gtin;
}
