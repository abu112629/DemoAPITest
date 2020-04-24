package com.sams.promotions.emulation.packageRedeem.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlType(namespace="http://www.xmlns.walmartstores.com/membership/Header/datatypes/MessageHeader/1.0/")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageHeader {
	
	private String CountryCode;
	
	private String PrefLanguage;
	
	private String SrcSysId;
	

}
