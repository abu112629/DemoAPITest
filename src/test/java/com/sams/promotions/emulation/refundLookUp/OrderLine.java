package com.sams.promotions.emulation.refundLookUp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.sams.promotions.emulation.refundLookUp.Originating;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderLine implements Cloneable{
	
	@XmlElement(name="LineNumber")
	private String lineNumber;
	
	@XmlElement(name="Id")
	private String Id;
	
	@XmlElement(name="Quantity")
	private String Quantity;
	
	@XmlElement(name="Originating")
	private Originating originating;
	
	@XmlElement(name="isExchange", defaultValue="false")
	private boolean isExchange;
}
