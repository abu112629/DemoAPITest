package com.sams.promotions.emulation.refundLookUp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)

public class Channel {
	
	@XmlElement(name="Code")
	private int code;
	
	@XmlElement(name="Description")
	private String description;
}
