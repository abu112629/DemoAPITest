package com.sams.promotions.emulation.refundLookUp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="CheckOutRefundRequest", namespace="http://www.xmlns.walmartstores.com/membership/bsl/messages/CheckOutRefund/1.0.0/")
public class CheckoutRefundReserveRequest {
	
	@XmlElement(name="MessageHeader", namespace="http://www.xmlns.walmartstores.com/membership/bsl/messages/CheckOutRefund/1.0.0/")
	private MessageHeader messageHeader;
	
	@XmlElement(name="CheckOutRefundRequestBody", namespace="http://www.xmlns.walmartstores.com/membership/bsl/messages/CheckOutRefund/1.0.0/")
	private CheckOutRefundRequestBody checkOutRefundRequestBody;
	
}
