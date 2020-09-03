@XmlSchema(
        namespace="http://www.xmlns.walmartstores.com/membership/bsl/datatypes/CheckOutRefund/1.0.0/",
        elementFormDefault=XmlNsForm.QUALIFIED,
        xmlns={
        		@XmlNs(prefix="", namespaceURI="http://www.xmlns.walmartstores.com/membership/bsl/datatypes/CheckOutRefund/1.0.0/"),
        		@XmlNs(prefix="ns2", namespaceURI="http://www.xmlns.walmartstores.com/membership/bsl/messages/CheckOutRefund/1.0.0/"),
                @XmlNs(prefix="ns3",  namespaceURI = "http://www.xmlns.walmartstores.com/membership/Header/datatypes/MessageHeader/1.0/"),
                @XmlNs(prefix="ns4", namespaceURI="http://www.xmlns.walmartstores.com/membership/Header/datatypes/MembershipHeader/1.0/")
        }
)
package com.sams.promotions.emulation.refundLookUp;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
