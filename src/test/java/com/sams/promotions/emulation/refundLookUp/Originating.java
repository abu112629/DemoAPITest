package com.sams.promotions.emulation.refundLookUp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.sams.promotions.emulation.refundLookUp.BusinessUnit;
import com.sams.promotions.emulation.refundLookUp.Terminal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)

public class Originating {

	@XmlElement(name="BasketID")
	private String basketID;
	
	@XmlElement(name="CreateTimeStamp")
	private String createTimestamp;

	@XmlElement(name="BusinessUnit")
	private BusinessUnit businessUnit;
	
	@XmlElement(name="Terminal")
	private Terminal terminal;
}
