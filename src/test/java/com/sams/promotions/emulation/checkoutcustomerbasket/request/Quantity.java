package com.sams.promotions.emulation.checkoutcustomerbasket.request;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Quantity implements Cloneable{
	
	private BigInteger amount;
	
	//Defined clone method in Department class.
	@Override
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}
