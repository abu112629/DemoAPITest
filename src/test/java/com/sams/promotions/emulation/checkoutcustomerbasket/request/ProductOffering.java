package com.sams.promotions.emulation.checkoutcustomerbasket.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.sams.promotions.emulation.checkoutcustomerbasket.request.Price;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductOffering implements Cloneable{
	
	private String id;
	
	private Price price;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}
