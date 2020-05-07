package com.sams.promotions.emulation.checkoutcustomerbasket.request;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Amount implements Cloneable{
	
	private BigInteger value;
	
	public Object clone() throws CloneNotSupportedException {	
	    return super.clone();
	}
}
