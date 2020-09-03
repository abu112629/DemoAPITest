package com.sams.promotions.emulation.refundLookUp;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.sams.promotions.emulation.refundLookUp.OrderLine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderLinesInOfferSummary {
	
	@XmlElementWrapper(name="orderLines")
    @XmlElement(name="orderLine")
    private List<OrderLine> orderLines;
}
