package com.sams.promotions.emulation.refundLookUp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlType(namespace="http://www.xmlns.walmartstores.com/membership/Header/datatypes/MessageHeader/1.0/")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageHeader {
	@XmlElement(name="PrefLanguage")
	private String prefLanguage;
	
	@XmlElement(name="SrcSysId")
	private String srcSysId;
	
	@XmlElement(name="SubId")
	private String subId;
	
	@XmlElement(name="CnsmrId")
	private String cnsmrId;
	
	@XmlElement(name="SrvcNm")
	private String srvcNm;
	
	@XmlElement(name="TranId")
	private String tranId;
	
	@XmlElement(name="Version")
	private String version;
}

