package com.sams.promotions.emulator.regression.emulatedMetaData.instantsavingMetaDataTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sams.promotions.emulation.analyticOffers.AnalyticItemDetail;
import com.sams.promotions.emulation.analyticOffers.AnalyticOffer;
import com.sams.promotions.emulation.analyticOffers.AnalyticOffers;
import com.sams.promotions.emulation.broadreachOffers.BroadReachOffer;
import com.sams.promotions.emulation.broadreachOffers.ItemDetail;
import com.sams.promotions.emulation.broadreachOffers.MetaDataResponse;
import com.sams.promotions.emulation.packageOffers.PackageItemDetail;
import com.sams.promotions.emulation.packageOffers.PackageOffer;
import com.sams.promotions.emulation.packageOffers.PackageOffers;
import com.sams.promotions.emulation.test.common.constants.UrlConstants;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.steps.util.HeaderMapper;
import com.sams.promotions.emulation.triggerOffers.ItemDetails;
import com.sams.promotions.emulation.triggerOffers.TriggerOffer;
import com.sams.promotions.emulation.triggerOffers.TriggerOffer_;

import io.restassured.response.Response;

public class MetaDataHelper {
	
	
	HeaderMapper headerMapper;
	protected Helper helpermethod;
	
	public String TriggerPromoMetaData(String Uri,String parameter,int index) throws JsonParseException, JsonMappingException, IOException {

		headerMapper = new HeaderMapper();
		helpermethod = new Helper();

		ArrayList<String> arrList = new ArrayList<String>();
		String arr[]=null;
		Map<String, Object> header = headerMapper.mapHeaders(UrlConstants.METADATA_HEADER_PATH);

		Response res = helpermethod.sendGetRequest(Uri, parameter, header);
		String metadataJson = res.asString();

		ObjectMapper objectmapper = new ObjectMapper();
		TriggerOffer metadata = objectmapper.readValue(metadataJson, TriggerOffer.class);
		List<TriggerOffer_> list = metadata.getTriggerOffers();

		for (TriggerOffer_ line : list) {

			long PromoNumber = line.getCouponNumber();
			float Discount = line.getCouponValue();
			String StartDate = line.getStartDate();
			String EndDate = line.getEndDate();
			long PackageCode = line.getPackageCode();
			long maxRedemptionCount=line.getMaxRedemptionCount();
			String maxredcnt=String.valueOf(maxRedemptionCount);
			String offerTypeDescription=line.getOfferTypeDescription();
		
			String ite = null;
			String mpq = null;

			if (line.getMerchandiseDetails().getItemDetails() != null) {				

				List<ItemDetails> item = line.getMerchandiseDetails().getItemDetails();
				for (ItemDetails linenew : item) {

					long Itemnumber = linenew.getItemNumber();
					long Mpq = linenew.getMinimumPurchaseQuantity();
					ite = String.valueOf(Itemnumber);
					mpq = String.valueOf(Mpq);
					arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
							+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
					arrList.add(arr[0].toString()); 

				}
			}

			else {
				arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
						+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
				arrList.add(arr[0].toString());

			}

		}

		return arrList.get(index) + "||" + arrList.size();

	}
	
	
	public String AnalyticPromoMetaData(String Uri,String parameter,int index) throws JsonParseException, JsonMappingException, IOException {

		headerMapper = new HeaderMapper();
		helpermethod = new Helper();

		ArrayList<String> arrList = new ArrayList<String>();
		String arr[]=null;
		
		Map<String, Object> header = headerMapper.mapHeaders(UrlConstants.METADATA_HEADER_PATH);

		Response res = helpermethod.sendGetRequest(Uri, parameter, header);
		String metadataJson = res.asString();

		ObjectMapper objectmapper = new ObjectMapper();
		AnalyticOffers metadata = objectmapper.readValue(metadataJson, AnalyticOffers.class);
		List<AnalyticOffer> list = metadata.getAnalyticOffers();

		for (AnalyticOffer line : list) {
			
			long PromoNumber = line.getCouponNumber();
			float Discount = line.getCouponValue();
			String StartDate = line.getStartDate();
			String EndDate = line.getEndDate();
			long PackageCode = line.getPackageCode();
			long maxRedemptionCount=line.getMaxRedemptionCount();
			String maxredcnt=String.valueOf(maxRedemptionCount);
			
			String offerTypeDescription=line.getOfferTypeDescription();


			String ite = null;
			String mpq = null;

			if (line.getMerchandiseDetails().getItemDetails() != null) {
				List<AnalyticItemDetail> item = line.getMerchandiseDetails().getItemDetails();
				
				for (AnalyticItemDetail linenew : item) {				

					long Itemnumber = linenew.getItemNumber();
					long Mpq = linenew.getMinimumPurchaseQuantity();
					ite = String.valueOf(Itemnumber);
					mpq = String.valueOf(Mpq);
					arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
							+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
					arrList.add(arr[0].toString()); 

				}
			}

			else {
				arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
						+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
				arrList.add(arr[0].toString());

			}

		}

		return arrList.get(index) + "||" + arrList.size();

	}
	
	public String PackagePromoMetaData(String Uri,String parameter,int index) throws JsonParseException, JsonMappingException, IOException {

		headerMapper = new HeaderMapper();
		helpermethod = new Helper();

		ArrayList<String> arrList = new ArrayList<String>();
		String arr[]=null;
		
		Map<String, Object> header = headerMapper.mapHeaders(UrlConstants.METADATA_HEADER_PATH);

		Response res = helpermethod.sendGetRequest(Uri, parameter, header);
		String metadataJson = res.asString();

		ObjectMapper objectmapper = new ObjectMapper();
		PackageOffers metadata = objectmapper.readValue(metadataJson, PackageOffers.class);
		List<PackageOffer> list = metadata.getPackageOffers();

		for (PackageOffer line : list) {
			
			long PromoNumber = line.getCouponNumber();
			float Discount = line.getCouponValue();
			String StartDate = line.getStartDate();
			String EndDate = line.getEndDate();
			long PackageCode=line.getPackageCode();
			long maxRedemptionCount=line.getMaxRedemptionCount();	
			
			String offerTypeDescription=line.getOfferTypeDescription();
			
			String maxredcnt=String.valueOf(maxRedemptionCount);
			String ite = null;
			String mpq = null;

			if (line.getMerchandiseDetails().getItemDetails() != null) {
				List<PackageItemDetail> item = line.getMerchandiseDetails().getItemDetails();
				
				for (PackageItemDetail linenew : item) {				
					
					long Itemnumber = linenew.getItemNumber();
					long Mpq = linenew.getMinimumPurchaseQuantity();
					ite = String.valueOf(Itemnumber);
					mpq = String.valueOf(Mpq);
					arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
							+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
					arrList.add(arr[0].toString()); 

				}
			}

			else {
				arr = new String[] { PromoNumber + "||" + Discount + "||" + StartDate + "||" + EndDate + "||" + ite
						+ "||" + mpq + "||" + PackageCode + "||" + maxredcnt + "||" + offerTypeDescription};
				arrList.add(arr[0].toString());

			}

		}

		return arrList.get(index) + "||" + arrList.size();

	}
	
	public String BroadReachPromoMetaData(String Uri,String parameter,int index) throws JsonParseException, JsonMappingException, IOException {

		headerMapper = new HeaderMapper();
		helpermethod = new Helper();
		
		ArrayList<String> arrList = new ArrayList<String>();
		String arr[]=null;
		
		Map<String, Object> header = headerMapper.mapHeaders(UrlConstants.METADATA_HEADER_PATH);
		
		Response res = helpermethod.sendGetRequest(Uri,parameter, header);
		String metadataJson = res.asString();

		ObjectMapper objectmapper = new ObjectMapper();
		MetaDataResponse metadata = objectmapper.readValue(metadataJson, MetaDataResponse.class);
		List<BroadReachOffer> list = metadata.getBroadReachOffers();

		for (BroadReachOffer line : list) {
			
			
			long PromoNumber = line.getCouponNumber();
			long CampaignNumber=line.getCampaignNumber();
			//long OfferNumber=line.getOfferNumber();
			long CouponMarketingNumber=line.getCouponMarketingNumber();
			String description=line.getPackageDescription();
			long OfferTypeCode=line.getOfferTypeCode();
			float Discount = line.getCouponValue();
			String StartDate = line.getStartDate();
			String EndDate = line.getEndDate();
			long PackageCode = line.getPackageCode();
			long maxRedemptionCount=line.getMaxRedemptionCount();
			float minbasketAmount=line.getMinimumBasketAmount();
			float maxdiscountAmount=line.getMaxDiscountAmount();
			//float minCoreQuantity=line.getMinimumCorePurchaseQuantity();
			
			//String offerTypeDescription=line.getOfferTypeDescription();
	
			String ite = null;
			String mpq = null;
			String iteCode=null;
			if (line.getMerchandiseDetails().getItemDetails() != null) {
				List<ItemDetail> item = line.getMerchandiseDetails().getItemDetails();
				//int i = 0;
				for (ItemDetail linenew : item) {
					
					/*
					 * i++; if (i > 1) { break; }
					 */
					
					long Itemnumber = linenew.getItemNumber();
					long Mpq = linenew.getMinimumPurchaseQuantity();
					long ItemTypeCode=linenew.getItemTypeCode();
					String ItemTypeDescription=linenew.getItemTypeDescription();
					
					ite = String.valueOf(Itemnumber);
					mpq = String.valueOf(Mpq);
					iteCode=String.valueOf(ItemTypeCode);
					

					arr = new String[] { PromoNumber + 
							"||" + CampaignNumber +"||"+CouponMarketingNumber+"||" +description+"||"+
							OfferTypeCode+"||"+minbasketAmount+"||"+maxdiscountAmount+"||"+
							 "||"+Discount + "||" + StartDate + "||" + EndDate + "||" + ite
							+ "||" + mpq + "||" + PackageCode + "||" + maxRedemptionCount + "||"+iteCode+
							"||"+ItemTypeDescription};
					arrList.add(arr[0].toString()); 

					
					
					
					
					
					

				}
			}

			else {
				
				arr = new String[] { PromoNumber + 
						"||" + CampaignNumber +"||"+CouponMarketingNumber+"||" +description+"||"+
						OfferTypeCode+"||"+minbasketAmount+"||"+maxdiscountAmount+"||"+
						 "||"+Discount + "||" + StartDate + "||" + EndDate +"||" + PackageCode + "||" + maxRedemptionCount};
				arrList.add(arr[0].toString());


			}

		}
		
		
		

		return arrList.get(index);

	}
	
	
	public static Map<String, String> getmetaDataPromotionDetails(String promotion) throws java.text.ParseException {

		Map<String, String> promotionDetails = new HashMap<String, String>();
		String[] abc = promotion.split(Pattern.quote("||"));

		promotionDetails.put("PromoId", abc[0]);
		promotionDetails.put("CampaignNumber", abc[1]);
		promotionDetails.put("CouponMarketingNumber", abc[2]);
		promotionDetails.put("PackageDescription", abc[3]);
		promotionDetails.put("OfferTypeCode", abc[4]);
		promotionDetails.put("Minimum basketAmount", abc[5]);
		promotionDetails.put("Maximum discountAmount", abc[6]);
		promotionDetails.put("Discount", abc[7]);
		promotionDetails.put("StartDate", abc[8]);
		promotionDetails.put("EndDate", abc[9]);
		promotionDetails.put("PackageCode", abc[10]);
		promotionDetails.put("Max RedemptionCount", abc[11]);
		
		return promotionDetails;

	}

}
