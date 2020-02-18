package com.sams.promotions.emulation.checkoutcustomerbasket.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.sams.promotions.emulation.checkoutcustomerbasket.request.ProductOffering;
import com.sams.promotions.emulation.checkoutcustomerbasket.request.Quantity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderLine implements Cloneable{
	
	private String lineNumber;
	
	private Quantity quantity;
	
	private ProductOffering productOffering;
	
	/*
	 * @Override public Object clone() throws CloneNotSupportedException { return
	 * super.clone(); }
	 */
	
	//Modified clone() method in Employee class
	@Override
	public Object clone() throws CloneNotSupportedException {
		OrderLine cloned = (OrderLine)super.clone();
	    cloned.setQuantity((Quantity)cloned.getQuantity().clone());  
	    cloned.setProductOffering((ProductOffering)cloned.getProductOffering().clone());  
	    return cloned;
	}
}
