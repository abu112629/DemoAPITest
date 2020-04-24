package com.sams.promotions.emulator.regression.emulatedMetaData.instantsavingMetaDataTest;

import java.io.IOException;
import java.util.Map;

import org.junit.Assert;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.membershipCreate.Membership;
import com.sams.promotions.emulation.test.steps.util.HeaderMapper;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MetaDataPromotions extends BaseStep{

	public MetaDataPromotions() throws IOException {
		super();
	}
	MetaDataHelper metadatahelper;
	HeaderMapper headerMapper;
	protected Map<String, String> promotionDetails;
	
	@Before
	public void beforeSetup() throws IOException {

		headerMapper = new HeaderMapper();
		helper = new Helper();
		membership = new Membership();
		reserveemulator = new ReserveEmulationHelper();
		metadatahelper=new MetaDataHelper();
	}
	
	
	@Given("^Check Promotion count from both Prod DataPower and Mercury QS$")
	public void Check_Promotion_Count() throws Exception
	{
		

		
			
		String arrbroad = reserveemulator.BroadReachSingleLinePromoMetaData(prop.get("metadata.prod.rest").toString(),1);
		String arrpackage = reserveemulator.AnalyticPromoMetaData(prop.get("metadata.prod.rest").toString(),1);
		//String arrbroademu=metadatahelper.BroadReachPromoMetaData(prop.get("metadata.rest").toString(),UrlConstants.EMULATION_METADATA_BROADREACH,1);	
		Map<String, String> mapx = Helper.getPromotionDetails(arrbroad);
		//Map<String, String> mapemu = Helper.getPromotionDetails(arrbroademu);
		Map<String, String> mapemu = Helper.getPromotionDetails(arrpackage);
		
		int sizepro=Integer.valueOf(mapx.get("SizeOfMetaData"));
		//int sizeemu=Integer.valueOf(mapemu.get("SizeOfMetaData"));
		int sizeemu=Integer.valueOf(mapemu.get("SizeOfMetaData"));
		
		
		for(int i=0;i<sizepro;i++) {
			
			String promodetails=metadatahelper.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), UrlConstants.METADATA_PROMOTION_BROADREACH, i);
			Map<String, String> mapprod =MetaDataHelper.getmetaDataPromotionDetails(promodetails);
			//System.out.println("PromoID : "+mapprod.get("PromoId"));
			
			
			  for(int j=0;j<sizeemu;) {
			  
				/*
				 * String
				 * emmpack=metadatahelper.BroadReachPromoMetaData(prop.get("metadata.rest").
				 * toString(),UrlConstants.EMULATION_METADATA_BROADREACH,j); Map<String, String>
				 * mapemmpack=Helper.getPromotionDetails(emmpack);
				 */
				  String emmpack=reserveemulator.AnalyticPromoMetaData(prop.get("metadata.prod.rest").toString(),j); 
				  Map<String, String> mapemmpack=Helper.getPromotionDetails(emmpack);
				    
			  if(mapprod.get("PromoId").contentEquals(mapemmpack.get("PromoId"))) {
			  
				  try {
					  Assert.assertEquals(mapprod,mapemmpack);
				  }
				  catch (AssertionError e) {
					    System.out.println("Promotion Details are not equal in the MetaData");
					    throw e;
					}
				  System.out.println("Promotion Details are equal in the MetaData");
			  break;
			  
			  } else {
			  
			  j++; }
			  
			
			  
			  }
			 
			 
			
		}

		
		
	}
	
	@Then("^Compare count of promotions$")
	public void Assert_Count_from_both_and_Compare() throws Exception
	{
		
		
	}

	
	
}
