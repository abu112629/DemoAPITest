package com.sams.promotions.emulator.regression.emulatedMetaData.instantsavingMetaDataTest;

import java.io.IOException;
import java.util.Map;

import org.assertj.core.api.SoftAssertions;

import com.sams.promotions.emulation.test.base.BaseStep;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.helper.ReserveEmulationHelper;
import com.sams.promotions.emulation.test.membershipCreate.Membership;
import com.sams.promotions.emulation.test.steps.util.HeaderMapper;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class MetaDataPromotions extends BaseStep{

	public MetaDataPromotions() throws IOException {
		super();
	}
	MetaDataHelper metadatahelper;
	HeaderMapper headerMapper;
	protected Map<String, String> promotionDetails;
	private SoftAssertions softAssertions = new SoftAssertions();
	@Before
	public void beforeSetup() throws IOException {

		headerMapper = new HeaderMapper();
		helper = new Helper();
		membership = new Membership();
		reserveemulator = new ReserveEmulationHelper();
		metadatahelper=new MetaDataHelper();
	}
	
	
	@Given("^Check Promotion count from both Prod DataPower and Emulator Metadata QS$")
	public void Check_Promotion_Count() throws Exception
	{
				
		String arrbroad = reserveemulator.BroadReachSingleLinePromoMetaData(prop.get("metadata.prod.rest").toString(),1);
		String arrbroademu=metadatahelper.BroadReachPromoMetaData(prop.get("metadata.rest").toString(),UrlConstants.EMULATION_METADATA_BROADREACH,1);	
		Map<String, String> mapx = Helper.getPromotionDetails(arrbroad);
		Map<String, String> mapemu = Helper.getPromotionDetails(arrbroademu);
		
		int sizepro=Integer.valueOf(mapx.get("SizeOfMetaData"));
		int Total=Integer.valueOf(mapemu.get("SizeOfMetaData"));

		
		
		for(int j=0;j<sizepro;j++) {
			
			String promodetails=metadatahelper.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(), UrlConstants.METADATA_PROMOTION_BROADREACH, j);
			Map<String, String> mapprod =MetaDataHelper.getmetaDataPromotionDetails(promodetails);
			
			
			  for(int i=0;i<Total;) {
			  
				
				  String emmpack=metadatahelper.BroadReachPromoMetaData(prop.get("metadata.rest").toString(),UrlConstants.EMULATION_METADATA_BROADREACH,j); 
				  Map<String, String> mapemmpack=MetaDataHelper.getmetaDataPromotionDetails(emmpack);
				 
				  
				    
			  if(mapprod.get("PromoId").contentEquals(mapemmpack.get("PromoId"))) {
			  
				  		System.out.println("Legacy Promotion Offer Id :" +mapprod.get("PromoId"));
				  		System.out.println("Emulator Metadata Offer Id :"+mapemmpack.get("PromoId"));
				  		
					  softAssertions.assertThat(mapprod).isEqualTo(mapemmpack);

				  //System.out.println("Promotion Details are equal in the MetaData");
			  break;
			  
			  } else {
			  
			  i++; }
			  
			
			  
			  }
			 
			 
			
		}

		
		
	}

	
	
}
