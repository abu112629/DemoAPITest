package com.sams.promotions.emulation.checkoutcustomerbasket.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sams.promotions.emulation.checkoutcustomerbasket.request.MessageBody;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.MessageHeader;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="checkoutCustomerBasketRequest")
public class CheckoutCustomerBasketRequest {
	
	private MessageHeader messageHeader;
	
	private MessageBody messageBody;
}
