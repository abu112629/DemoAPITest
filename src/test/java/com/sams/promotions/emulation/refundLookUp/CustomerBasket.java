package com.sams.promotions.emulation.refundLookUp;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.sams.promotions.emulation.refundLookUp.Customer;
import com.sams.promotions.emulation.refundLookUp.Channel;
import com.sams.promotions.emulation.refundLookUp.RefundTransaction;
import com.sams.promotions.emulation.refundLookUp.OrderLine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)

public class CustomerBasket {
	
	@XmlElement(name="Customer")
	private Customer customer;
	
	@XmlElement(name="Channel")
	private Channel channel;
	
	@XmlElement(name="RefundTransaction")
	private RefundTransaction refundTransaction;
	
	@XmlElementWrapper(name="Orderlines")
    @XmlElement(name="OrderLine")
    private List<OrderLine> orderLines;
	
	

}
