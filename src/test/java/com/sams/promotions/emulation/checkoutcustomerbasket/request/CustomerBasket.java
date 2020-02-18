package com.sams.promotions.emulation.checkoutcustomerbasket.request;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.sams.promotions.emulation.checkoutcustomerbasket.request.BusinessUnit;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.Channel;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.Currency;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.Customer;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.OrderLine;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.Terminal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerBasket {
	
	private String basketID;
	private String createTimestamp;
	
	private Customer customer;
	
	@XmlElementWrapper(name="orderLines")
    @XmlElement(name="orderLine")
    private List<OrderLine> orderLines;
	private Terminal terminal;
	private BusinessUnit businessUnit;
	private Channel channel;
	
	
	private Currency currency;
	
	
	
	
	
	
	
	
	
	
	
	
	
}
