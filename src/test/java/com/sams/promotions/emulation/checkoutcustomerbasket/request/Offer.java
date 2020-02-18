package com.sams.promotions.emulation.checkoutcustomerbasket.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.sams.promotions.emulation.checkoutcustomerbasket.request.Discount;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.OfferGlobalTradeItem;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.OrderLinesInOfferSummary;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.SettlementDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Offer {
	
	private String id;
	
	private String description;
	
	private String type;
	
	@XmlElement(defaultValue="0")
	private String gs1Code;
	
	@XmlElement(defaultValue="")
	private String featuredText;
	
	private String serialNumber;
	
	private SettlementDetails settlementDetails;
	
	private OfferGlobalTradeItem offerGlobalTradeItem;
	
	private Discount discount;
	
	@XmlElement(name="orderLinesinOfferSummary")
	private OrderLinesInOfferSummary orderLinesInOfferSummary;
}
