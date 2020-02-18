package com.sams.promotions.emulation.test.steps.util;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sams.promotions.emulation.test.common.constants.UrlConstants;

import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.io.IOException;
import java.util.HashMap;  

public class XMLReader  {  

	
		public HashMap<String, String> xml() throws ParserConfigurationException, SAXException, IOException{  
		 
			//creating a constructor of file class and parsing an XML file  
			File file = new File(UrlConstants.CHECKOUT_RESPONSE);  
			//an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();   
			//an instance of builder to parse the specified xml file  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(file);  
			doc.getDocumentElement().normalize();  
			//System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
			HashMap<String,String> map = new HashMap<>(); 
		
			NodeList nodeList = doc.getElementsByTagName("ns:offers");
				// nodeList is not iterable, so we are using for loop  
			for (int itr = 0; itr < nodeList.getLength(); itr++) {  
			
			Node node = nodeList.item(itr);  
			//System.out.println("\nNode Name :" + node.getNodeName());  
			if (node.getNodeType() == Node.ELEMENT_NODE) {  
			Element eElement = (Element) node;  
		
			String Id=eElement.getElementsByTagName("ns:id").item(0).getTextContent();
			String Description=eElement.getElementsByTagName("ns:description").item(0).getTextContent();  
			String GS1Code=eElement.getElementsByTagName("ns:gs1Code").item(0).getTextContent();  
			String Discount=eElement.getElementsByTagName("ns:value").item(0).getTextContent();  
			String Gtincode=eElement.getElementsByTagName("ns:gtin").item(0).getTextContent();  
			
			map.put("Id", Id);
			map.put("Description", Description);
			map.put("GS1code", GS1Code);
			map.put("Discount", Discount);	
			map.put("Gtincode", Gtincode);
			
			

			}   
			
		}
			return map;
		
	}
		
		
}  

