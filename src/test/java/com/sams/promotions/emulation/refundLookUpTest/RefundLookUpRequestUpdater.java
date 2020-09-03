package com.sams.promotions.emulation.refundLookUpTest;

import java.util.HashMap;
import java.util.List;

import javax.xml.bind.Unmarshaller;

import org.mockito.Spy;

import com.sams.promotions.emulation.refundLookUp.CheckoutRefundReserveRequest;
import com.sams.promotions.emulation.refundLookUp.OrderLine;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.platform.emulation.util.mapper.JaxBInitializer;
import com.sams.promotions.platform.emulation.util.soap.SOAPUtil;

public class RefundLookUpRequestUpdater {
	
	Helper helpermethod;
	protected Unmarshaller xmlUnmarshaller;
	
	@Spy
	private SOAPUtil soapUtil;
	
	public String RefundRequestUpdater(String Custid, int code,String Channel, String BasketId,String createTimestamp,String BusinessUnit,
			String terminalID,String lineNumber,String PromotionId,String Quantity,String returnBasketID,String returnCreateTimeStamp,
			String returnClubNumber,String returnTerminalID,String path) throws Exception {

		helpermethod = new Helper();

		xmlUnmarshaller = new JaxBInitializer().initUnmarshaller(CheckoutRefundReserveRequest.class);

		String xml = helpermethod.GenerateStringFromResource(path);

		soapUtil = new SOAPUtil();

		CheckoutRefundReserveRequest req = soapUtil.unwrapSoap(xmlUnmarshaller, xml,
				CheckoutRefundReserveRequest.class);
		req.getCheckOutRefundRequestBody().getCustomerBasket().getCustomer().setMembershipNumber(Custid);
		req.getCheckOutRefundRequestBody().getCustomerBasket().getChannel().setCode(code);
		req.getCheckOutRefundRequestBody().getCustomerBasket().getChannel().setDescription(Channel);
		req.getCheckOutRefundRequestBody().getCustomerBasket().getRefundTransaction().setBasketID(BasketId);
		req.getCheckOutRefundRequestBody().getCustomerBasket().getRefundTransaction().setCreateTimestamp(createTimestamp);
		req.getCheckOutRefundRequestBody().getCustomerBasket().getRefundTransaction().getBusinessUnit().setClubNumber(BusinessUnit);
		req.getCheckOutRefundRequestBody().getCustomerBasket().getRefundTransaction().getBusinessUnit().setCountryCode("US");
		req.getCheckOutRefundRequestBody().getCustomerBasket().getRefundTransaction().getTerminal().setTerminalID(terminalID);
		
		

		List<OrderLine> list = req.getCheckOutRefundRequestBody().getCustomerBasket().getOrderLines();

		for (OrderLine line : list) {

			line.setLineNumber(lineNumber);
			line.setId(PromotionId);
			line.setQuantity(Quantity);
			line.setExchange(false);
			
			line.getOriginating().setBasketID(returnBasketID);
			line.getOriginating().setCreateTimestamp(returnCreateTimeStamp);
			
			line.getOriginating().getBusinessUnit().setClubNumber(returnClubNumber);
			line.getOriginating().getBusinessUnit().setCountryCode("US");
			
			line.getOriginating().getTerminal().setTerminalID(returnTerminalID);
			

		}

		String req1 = soapUtil.wrapSoap(req);
		HashMap<String, String> customData = new HashMap<String, String>();
		customData.put("<soapenv:Header/>","<soapenv:Header>\r\n" + 
				"        <wsse:Security\r\n" + 
				"            xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\r\n" + 
				"            <wsse:UsernameToken>\r\n" + 
				"                <wsse:Username>SVCSamsInstantSaving</wsse:Username>\r\n" + 
				"                <wsse:Password>qtayWn-wW7+%*NAbs1W1</wsse:Password>\r\n" + 
				"            </wsse:UsernameToken>\r\n" + 
				"        </wsse:Security>\r\n" + 
				"   </soapenv:Header>");
		String req2 = helpermethod.updateRequest(customData, req1);
		System.out.println(Helper.getPrettyString(req2));

		return req2;

	}


}
