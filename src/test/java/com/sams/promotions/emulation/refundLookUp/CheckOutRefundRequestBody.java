package com.sams.promotions.emulation.refundLookUp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.sams.promotions.emulation.refundLookUp.CustomerBasket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class CheckOutRefundRequestBody {

	@XmlElement(name="CustomerBasket",  namespace="http://www.xmlns.walmartstores.com/membership/bsl/datatypes/CheckOutRefund/1.0.0/")
	private CustomerBasket customerBasket;
}
