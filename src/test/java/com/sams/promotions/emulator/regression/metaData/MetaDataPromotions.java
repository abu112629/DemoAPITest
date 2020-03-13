package com.sams.promotions.emulator.regression.metaData;

import java.io.IOException;
import java.util.Map;

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

	HeaderMapper headerMapper;
	
	@Before
	public void beforeSetup() throws IOException {

		headerMapper = new HeaderMapper();
		helper = new Helper();
		membership = new Membership();
		reserveemulator = new ReserveEmulationHelper();
	}
	
	
	@Given("^Check Promotion count from both Prod DataPower and Mercury QS$")
	public void Check_Promotion_Count() throws Exception
	{
		
		String arrpackage = reserveemulator.PackagePromoMetaData(prop.get("metadata.prod.rest").toString(),
				UrlConstants.METADATA_PROMOTION_PACKAGE,1);
		
		String emmpackage = reserveemulator.PackagePromoMetaData(prop.get("metadata.rest").toString(),
				UrlConstants.EMULATION_METADATA_PACKAGE,1);
		
			
		String arrbroad = reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").toString(),1);
		
		String arranalytic=reserveemulator.AnalyticPromoMetaData(prop.get("metadata.prod.rest").toString(), 1);
		
		String arrtrigger=reserveemulator.TriggerPromoMetaData(prop.get("metadata.prod.rest").toString(), 1);
		
		String arrxyz1234=reserveemulator.QSPromoMetaData(prop.get("mercury.quicksilver").toString());
		System.out.println("Mercury Quick Silver Promotions count :"+arrxyz1234);
		
		
		Map<String, String> map = Helper.getPromotionDetails(arrpackage);
		Map<String, String> mapx = Helper.getPromotionDetails(arrbroad);
		Map<String, String> mapy = Helper.getPromotionDetails(arranalytic);
		Map<String, String> mapz = Helper.getPromotionDetails(arrtrigger);
		Map<String, String> mapzyx = Helper.getPromotionDetails(emmpackage);
		
		System.out.println("Datapower Production Package count :"+map.get("SizeOfMetaData"));
		System.out.println("Datapower Production BroadReach count :"+mapx.get("SizeOfMetaData"));
		System.out.println("Datapower Production Analytic count :"+mapy.get("SizeOfMetaData"));
		System.out.println("Datapower Production Trigger count :"+mapz.get("SizeOfMetaData"));
		
		int TotalPromotions=Integer.valueOf(map.get("SizeOfMetaData"))+
				Integer.valueOf(mapx.get("SizeOfMetaData"))+Integer.valueOf(mapy.get("SizeOfMetaData"))
				+Integer.valueOf(mapz.get("SizeOfMetaData"));
		System.out.println(TotalPromotions);
		
		int sizepro=Integer.valueOf(map.get("SizeOfMetaData"));
		int sizeemu=Integer.valueOf(mapzyx.get("SizeOfMetaData"));
		
		for(int i=0;i<sizepro;i++) {
			
			for(int j=0;j<sizeemu;) {
				
				String emmpack = reserveemulator.PackagePromoMetaData(prop.get("metadata.rest").toString(),
						UrlConstants.EMULATION_METADATA_PACKAGE,j);
				Map<String, String> mapemmpack = Helper.getPromotionDetails(emmpack);
				
				if(map.get("PromoId").contentEquals(mapemmpack.get("PromoId"))) {
					
					System.out.println("PromoIds are present in both apis :"+map.get("PromoId"));
					break;
				}
				else {
					
					j++;
				}
				
			}
			
		}

		
		
	}
	
	@Then("^Compare count of promotions$")
	public void Assert_Count_from_both_and_Compare() throws Exception
	{
		
		
	}

	
	
}
