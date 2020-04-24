@XmlSchema(
        namespace="http://www.xmlns.walmartstores.com/membership/bsl/messages/ManageMbrCoupon/1.0.0/",
        elementFormDefault=XmlNsForm.QUALIFIED,
        xmlns={
        		@XmlNs(prefix="ns3", namespaceURI="http://www.xmlns.walmartstores.com/membership/bsl/datatypes/ManageMbrCoupon/1.0.0/"),
        		@XmlNs(prefix="ns2",  namespaceURI = "http://www.xmlns.walmartstores.com/membership/Header/datatypes/MembershipHeader/1.0/"),
                @XmlNs(prefix="ns1", namespaceURI="http://www.xmlns.walmartstores.com/membership/Header/datatypes/MessageHeader/1.0/"),
                @XmlNs(prefix="ns",  namespaceURI="http://www.xmlns.walmartstores.com/membership/bsl/messages/ManageMbrCoupon/1.0.0/")
        }
)
package com.sams.promotions.emulation.packageRedeem.request;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
