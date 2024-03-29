package com.sams.promotions.emulation.checkoutcustomerbasket.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.sams.promotions.emulation.checkoutcustomerbasket.request.Amount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Price implements Cloneable{
	
	private Amount amount;
	
	@Override
	public Object clone() throws CloneNotSupportedException {	
		
		Price cloned=(Price)super.clone();
		cloned.setAmount((Amount)cloned.getAmount().clone()); 
		
	    return cloned;
	}
}
