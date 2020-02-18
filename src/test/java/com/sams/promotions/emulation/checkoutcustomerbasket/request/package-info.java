@XmlSchema(
        namespace="http://www.xmlns.walmartstores.com/DemandChain/ShoppingExperienceManagement/datatypes/CheckoutCustomerBasket/1.0/",
        elementFormDefault=XmlNsForm.QUALIFIED,
        xmlns={
        		@XmlNs(prefix="ns3", namespaceURI="http://www.xmlns.walmartstores.com/Fault/datatypes/MessageFault/1.0/"),
        		@XmlNs(prefix="ns2",  namespaceURI = "http://www.xmlns.walmartstores.com/DemandChain/ShoppingExperienceManagement/datatypes/CheckoutCustomerBasket/1.0/"),
                @XmlNs(prefix="", namespaceURI="http://www.xmlns.walmartstores.com/Header/datatypes/MessageHeader/1.4/")
        }
)
package com.sams.promotions.emulation.checkoutcustomerbasket.request;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
