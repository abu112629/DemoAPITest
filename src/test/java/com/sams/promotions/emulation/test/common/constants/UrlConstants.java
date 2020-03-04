package com.sams.promotions.emulation.test.common.constants;

import com.sams.promotions.emulation.test.helper.Helper;

public class UrlConstants {

		Helper helper;
		public static final String RESERVE_EMULATION = "/emulate/reserve";
		public static final String REDEEM_EMULATION = "/emulate/redeem";
		public static final String SERVICES_CHECKOUT = "/Services/CheckoutCustomerBasket";
		public static final String PROMO_CREATION = "/promotions";
		public static final String METADATA_PROMOTION_BROADREACH="/rest/InstantSavings/MetaDataFile/Broadreach";
		public static final String METADATA_PROMOTION_ALL="/rest/InstantSavings/MetaDataFile/All";
		public static final String METADATA_PROMOTION_TRIGGERS="/rest/InstantSavings/MetaDataFile/Triggers";
		public static final String INTEGRATION_JSON_CONVERT="/promotions/apply/reserve";
		public static final String PROPERTIES_FILE = "src/test/resources/promo.properties";
		public static final String PROPERTIES_FILE_TEST = "src/test/resources/"+Helper.getEnvironment()+"/promo.properties";
		public static final String EMULATOR_CLUB="src/test/resources/Emulation_Input/NewSystemTest.xml";
		public static final String DATA_POWER_CLUB= "src/test/resources/Emulation_Input/OldSystemTest.xml";
		public static final String JSON_PROMOTION_FILE= "src/test/resources/Emulation_Input/Promotions.json";
		public static final String XML_TO_JSON= "src/test/resources/Emulation_Input/CheckoutCustomerBasket_request.xml";
		public static final String JSON_TO_XML= "src/test/resources/Emulation_Input/quickSilver_response.json";
		public static final String CHECKOUT_RESPONSE="src/test/resources/Emulation_Input/CustomerBasketResponse.xml";
		public static final String CHECKOUT_MUL_REQ="src/test/resources/Emulation_Input/CheckoutCustomerBasket_MultipleRequests.xml";
		public static final String REDEEM_REQUEST="src/test/resources/Emulation_Input/RedeemRequest.xml";
		public static final String METADATA_HEADER_PATH="src/test/resources/requestHeader/BroadReachOffers_MetaDataHeaders.txt";
	
		
	

}
