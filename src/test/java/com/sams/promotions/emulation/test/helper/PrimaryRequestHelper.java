package com.sams.promotions.emulation.test.helper;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.sams.promotions.emulation.test.common.constants.UrlConstants;

import groovy.util.logging.Slf4j;

@Slf4j
@Component

public class PrimaryRequestHelper {

	/*
	 * Author : Abu Description : Helper Method Date : 11/11/2019
	 * 
	 */

	protected String[] expected;
	protected Properties prop;
	protected Helper helpermethod;
	protected String postdata,postdata2;
	protected int ItemId,Quantity,ItemId2,Quantity2;
	protected ReserveEmulationHelper reserveemulator;
	
	
	public Map<String,String> getInitialDoubleLinesPostRequestDetails(int i,String membershipNumber,String channelName, String ClubId, String ClubId2, int code, int RetailPrice,
			String lineNumber, String Applied_Dates, String OfferId,String OfferId2,String pathsingle) throws Exception {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(UrlConstants.PROPERTIES_FILE);
		prop.load(fis);
		
		helpermethod=new Helper();
		reserveemulator=new ReserveEmulationHelper();
		
		String arrx = reserveemulator.PromoMetaData(prop.get("datapower.production.cert").toString(), i);
		String arry = reserveemulator.PromoMetaData(prop.get("datapower.production.cert").toString(), i + 1);

		Map<String, String> promodetails = Helper.getPromotionDetails(arrx);
		Map<String, String> promodetails2 = Helper.getPromotionDetails(arry);

		String packagecode = promodetails.get("PackageCode");
		String packagecode2 = promodetails2.get("PackageCode");
		
		OfferId = promodetails.get("PromoId");
		OfferId2 = promodetails2.get("PromoId");

		if (promodetails.get("ItemId").contentEquals("null")) {

			ItemId = 725443;

		} else {
			ItemId = Integer.valueOf(promodetails.get("ItemId"));

		}

		if (promodetails2.get("ItemId").contentEquals("null")) {

			ItemId2 = 725443;

		} else {

			ItemId2 = Integer.valueOf(promodetails2.get("ItemId"));
		}

		Map<String, String> map = helpermethod.getDatesDoubleLinesMetadata(arrx, arry);

		Double Discount = Double.valueOf(promodetails.get("Discount"));
		int disc = (int) Math.round(Discount) * 100;

		Double Discount2 = Double.valueOf(promodetails2.get("Discount"));
		int disc2 = (int) Math.round(Discount2) * 100;

		Quantity = Integer.valueOf(promodetails.get("MinimumPurchaseQuantity"));

		Quantity2 = Integer.valueOf(promodetails2.get("MinimumPurchaseQuantity"));

		switch (Applied_Dates) {
		case "FIRST_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNumber, map.get("firstdate"), pathsingle);

			postdata2 = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId2, lineNumber, code,
					channelName, membershipNumber, map.get("firstdate"), pathsingle);

			break;
		case "MIDDLE_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity * 2, ItemId, RetailPrice, ClubId, lineNumber,
					code, channelName, membershipNumber, map.get("midDate"), pathsingle);

			postdata2 = reserveemulator.XMLRequestUpdater(Quantity * 2, ItemId, RetailPrice, ClubId2, lineNumber,
					code, channelName, membershipNumber, map.get("midDate"), pathsingle);

			break;
		case "LAST_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity * 3, ItemId, RetailPrice, ClubId, lineNumber,
					code, channelName, membershipNumber, map.get("lastdate"), pathsingle);

			postdata2 = reserveemulator.XMLRequestUpdater(Quantity * 3, ItemId, RetailPrice, ClubId2, lineNumber,
					code, channelName, membershipNumber, map.get("lastdate"), pathsingle);

			break;

		}
		
		
		Map<String,String> postrequestDetails = new HashMap<String,String>();
		
		
		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);
		postrequestDetails.put("FirstItemDiscount",String.valueOf(disc));
		postrequestDetails.put("SecondItemDiscount",String.valueOf(disc2));
		postrequestDetails.put("PackageCode",packagecode);
		postrequestDetails.put("PackageCode2",packagecode2);
		postrequestDetails.put("OfferId", OfferId);
		postrequestDetails.put("OfferId2", OfferId2);
		
		
		  
		 
		return postrequestDetails;
		
	}
	
	
	
	public Map<String,String> getBusinessBasePostRequestDetails(int disc,int disc2,String packagecode,String packagecode2,
			String ClubId, String ClubId2,int RetailPrice,String lineNumber, String Applied_Dates, 
			String OfferId,String OfferId2,String postdata,String postdata2) throws Exception {
		
		reserveemulator=new ReserveEmulationHelper();
		
		switch (Applied_Dates) {
		case "FIRST_DATE":
			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 =reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);
			int abs_disc = disc + disc2;

			if (OfferId.contentEquals(OfferId2)) {

				expected = new String[] { OfferId, String.valueOf(abs_disc) };

			}

			else {

				if (packagecode.contentEquals("91") || packagecode.contentEquals("99")
						|| packagecode.contentEquals("90") || packagecode.contentEquals("98")
						|| packagecode.contentEquals("94") || packagecode.contentEquals("95")) {
					expected = new String[] { OfferId2, String.valueOf(disc2) };
				}

				else if (packagecode2.contentEquals("91") || packagecode2.contentEquals("99")
						|| packagecode2.contentEquals("90") || packagecode2.contentEquals("98")
						|| packagecode2.contentEquals("94") || packagecode2.contentEquals("95")) {

					expected = new String[] { OfferId, String.valueOf(disc) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc) };
				}
			}

			break;
		case "MIDDLE_DATE":
			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);

			int SecondDiscountfirstline = disc * 2;
			int SecondDiscountsecondline = disc2 * 2;
			int abs_disc2 = SecondDiscountfirstline + SecondDiscountsecondline;

			if (OfferId.contentEquals(OfferId2)) {

				expected = new String[] { OfferId, String.valueOf(abs_disc2) };
			} else {

				if (packagecode.contentEquals("91") || packagecode.contentEquals("99")
						|| packagecode.contentEquals("90") || packagecode.contentEquals("98")
						|| packagecode.contentEquals("94") || packagecode.contentEquals("95")) {
					expected = new String[] { OfferId2, String.valueOf(SecondDiscountsecondline) };
				}

				else if (packagecode2.contentEquals("91") || packagecode2.contentEquals("99")
						|| packagecode2.contentEquals("90") || packagecode2.contentEquals("98")
						|| packagecode2.contentEquals("94") || packagecode2.contentEquals("95")) {

					expected = new String[] { OfferId, String.valueOf(SecondDiscountfirstline) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc2) };
				}

			}

			break;
		case "LAST_DATE":
			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);

			int ThirdDiscountfirstline = disc * 3;
			int ThirdDiscountsecondline = disc2 * 3;

			int abs_disc3 = ThirdDiscountfirstline + ThirdDiscountsecondline;

			if (OfferId.contentEquals(OfferId2)) {

				expected = new String[] { OfferId, String.valueOf(abs_disc3) };

			} else {

				if (packagecode.contentEquals("91") || packagecode.contentEquals("99")
						|| packagecode.contentEquals("90") || packagecode.contentEquals("98")
						|| packagecode.contentEquals("94") || packagecode.contentEquals("95")) {
					expected = new String[] { OfferId2, String.valueOf(ThirdDiscountsecondline) };
				}

				else if (packagecode2.contentEquals("91") || packagecode2.contentEquals("99")
						|| packagecode2.contentEquals("90") || packagecode2.contentEquals("98")
						|| packagecode2.contentEquals("94") || packagecode2.contentEquals("95")) {

					expected = new String[] { OfferId, String.valueOf(ThirdDiscountfirstline) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc3) };
				}
			}

			break;

		}
		
		
		Map<String,String> postrequestDetails = new HashMap<String,String>();
		
		
		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);
		postrequestDetails.put("FirstItemDiscount",String.valueOf(disc));
		postrequestDetails.put("SecondItemDiscount",String.valueOf(disc2));
		postrequestDetails.put("PackageCode",packagecode);
		postrequestDetails.put("PackageCode2",packagecode2);
		postrequestDetails.put("OfferId", OfferId);
		postrequestDetails.put("OfferId2", OfferId2);
		
		postrequestDetails.put("expected", Arrays.toString(expected));
		
		
		  
		 
		return postrequestDetails;
		
	}
	
	
	public Map<String,String> getBusinessPlusPostRequestDetails(int disc,int disc2,String packagecode,String packagecode2,
			String ClubId, String ClubId2,int RetailPrice,String lineNumber, String Applied_Dates, 
			String OfferId,String OfferId2,String postdata,String postdata2) throws Exception {
		

		reserveemulator=new ReserveEmulationHelper();
		
		switch (Applied_Dates) {
		case "FIRST_DATE":
			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);
			int abs_disc = disc + disc2;

			if (OfferId.contentEquals(OfferId2)) {

				expected = new String[] { OfferId, String.valueOf(abs_disc) };

			}

			else {

				if (packagecode.contentEquals("96") || packagecode.contentEquals("97")
						|| packagecode.contentEquals("91") || packagecode.contentEquals("99")
						|| packagecode.contentEquals("90") || packagecode.contentEquals("98")) {
					expected = new String[] { OfferId2, String.valueOf(disc2) };
				}

				else if (packagecode2.contentEquals("96") || packagecode2.contentEquals("97")
						|| packagecode2.contentEquals("91") || packagecode2.contentEquals("99")
						|| packagecode2.contentEquals("90") || packagecode2.contentEquals("98")) {

					expected = new String[] { OfferId, String.valueOf(disc) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc) };
				}
			}

			break;
		case "MIDDLE_DATE":
			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);

			int SecondDiscountfirstline = disc * 2;
			int SecondDiscountsecondline = disc2 * 2;
			int abs_disc2 = SecondDiscountfirstline + SecondDiscountsecondline;

			if (OfferId.contentEquals(OfferId2)) {

				expected = new String[] { OfferId, String.valueOf(abs_disc2) };
			} else {

				if (packagecode.contentEquals("96") || packagecode.contentEquals("97")
						|| packagecode.contentEquals("91") || packagecode.contentEquals("99")
						|| packagecode.contentEquals("90") || packagecode.contentEquals("98")) {
					expected = new String[] { OfferId2, String.valueOf(SecondDiscountsecondline) };
				}

				else if (packagecode2.contentEquals("96") || packagecode2.contentEquals("97")
						|| packagecode2.contentEquals("91") || packagecode2.contentEquals("99")
						|| packagecode2.contentEquals("90") || packagecode2.contentEquals("98")) {

					expected = new String[] { OfferId, String.valueOf(SecondDiscountfirstline) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc2) };
				}

			}

			break;
		case "LAST_DATE":
			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);

			int ThirdDiscountfirstline = disc * 3;
			int ThirdDiscountsecondline = disc2 * 3;

			int abs_disc3 = ThirdDiscountfirstline + ThirdDiscountsecondline;

			if (OfferId.contentEquals(OfferId2)) {

				expected = new String[] { OfferId, String.valueOf(abs_disc3) };

			} else {

				if (packagecode.contentEquals("96") || packagecode.contentEquals("97")
						|| packagecode.contentEquals("91") || packagecode.contentEquals("99")
						|| packagecode.contentEquals("90") || packagecode.contentEquals("98")) {
					expected = new String[] { OfferId2, String.valueOf(ThirdDiscountsecondline) };
				}

				else if (packagecode2.contentEquals("96") || packagecode2.contentEquals("97")
						|| packagecode2.contentEquals("91") || packagecode2.contentEquals("99")
						|| packagecode2.contentEquals("90") || packagecode2.contentEquals("98")) {

					expected = new String[] { OfferId, String.valueOf(ThirdDiscountfirstline) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc3) };
				}
			}

			break;

		}
		
		
		Map<String,String> postrequestDetails = new HashMap<String,String>();
		
		
		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);
		postrequestDetails.put("FirstItemDiscount",String.valueOf(disc));
		postrequestDetails.put("SecondItemDiscount",String.valueOf(disc2));
		postrequestDetails.put("PackageCode",packagecode);
		postrequestDetails.put("PackageCode2",packagecode2);
		postrequestDetails.put("OfferId", OfferId);
		postrequestDetails.put("OfferId2", OfferId2);
		
		postrequestDetails.put("expected", Arrays.toString(expected));
		
		
		  
		 
		return postrequestDetails;
		
	}
	
	public Map<String,String> getSavingsBasePostRequestDetails(int disc,int disc2,String packagecode,String packagecode2,
			String ClubId, String ClubId2,int RetailPrice,String lineNumber, String Applied_Dates, 
			String OfferId,String OfferId2,String postdata,String postdata2) throws Exception {
		
	
		reserveemulator=new ReserveEmulationHelper();
		
		switch (Applied_Dates) {
		case "FIRST_DATE":
			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);
			int abs_disc = disc + disc2;

			if (OfferId.contentEquals(OfferId2)) {

				expected = new String[] { OfferId, String.valueOf(abs_disc) };

			}

			else {

				if (packagecode.contentEquals("91") || packagecode.contentEquals("99")
						|| packagecode.contentEquals("94") || packagecode.contentEquals("95")
						|| packagecode.contentEquals("92") || packagecode.contentEquals("93")) {
					expected = new String[] { OfferId2, String.valueOf(disc2) };
				}

				else if (packagecode2.contentEquals("91") || packagecode2.contentEquals("99")
						|| packagecode2.contentEquals("94") || packagecode2.contentEquals("95")
						|| packagecode2.contentEquals("92") || packagecode2.contentEquals("93")) {

					expected = new String[] { OfferId, String.valueOf(disc) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc) };
				}
			}

			break;
		case "MIDDLE_DATE":
			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);

			int SecondDiscountfirstline = disc * 2;
			int SecondDiscountsecondline = disc2 * 2;
			int abs_disc2 = SecondDiscountfirstline + SecondDiscountsecondline;

			if (OfferId.contentEquals(OfferId2)) {

				expected = new String[] { OfferId, String.valueOf(abs_disc2) };
			} else {

				if (packagecode.contentEquals("91") || packagecode.contentEquals("99")
						|| packagecode.contentEquals("94") || packagecode.contentEquals("95")
						|| packagecode.contentEquals("92") || packagecode.contentEquals("93")) {
					expected = new String[] { OfferId2, String.valueOf(SecondDiscountsecondline) };
				}

				else if (packagecode2.contentEquals("91") || packagecode2.contentEquals("99")
						|| packagecode2.contentEquals("94") || packagecode2.contentEquals("95")
						|| packagecode2.contentEquals("92") || packagecode2.contentEquals("93")) {

					expected = new String[] { OfferId, String.valueOf(SecondDiscountfirstline) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc2) };
				}

			}

			break;
		case "LAST_DATE":
			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);

			int ThirdDiscountfirstline = disc * 3;
			int ThirdDiscountsecondline = disc2 * 3;

			int abs_disc3 = ThirdDiscountfirstline + ThirdDiscountsecondline;

			if (OfferId.contentEquals(OfferId2)) {

				expected = new String[] { OfferId, String.valueOf(abs_disc3) };

			} else {

				if (packagecode.contentEquals("91") || packagecode.contentEquals("99")
						|| packagecode.contentEquals("94") || packagecode.contentEquals("95")
						|| packagecode.contentEquals("92") || packagecode.contentEquals("93")) {
					expected = new String[] { OfferId2, String.valueOf(ThirdDiscountsecondline) };
				}

				else if (packagecode2.contentEquals("91") || packagecode2.contentEquals("99")
						|| packagecode2.contentEquals("94") || packagecode2.contentEquals("95")
						|| packagecode2.contentEquals("92") || packagecode2.contentEquals("93")) {

					expected = new String[] { OfferId, String.valueOf(ThirdDiscountfirstline) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc3) };
				}
			}

			break;

		}
		
		Map<String,String> postrequestDetails = new HashMap<String,String>();
		
		
		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);
		postrequestDetails.put("FirstItemDiscount",String.valueOf(disc));
		postrequestDetails.put("SecondItemDiscount",String.valueOf(disc2));
		postrequestDetails.put("PackageCode",packagecode);
		postrequestDetails.put("PackageCode2",packagecode2);
		postrequestDetails.put("OfferId", OfferId);
		postrequestDetails.put("OfferId2", OfferId2);
		
		postrequestDetails.put("expected", Arrays.toString(expected));
		
		
		  
		 
		return postrequestDetails;
		
	}
	
	public Map<String,String> getSavingsPlusPostRequestDetails(int disc,int disc2,String packagecode,String packagecode2,
			String ClubId, String ClubId2,int RetailPrice,String lineNumber, String Applied_Dates, 
			String OfferId,String OfferId2,String postdata,String postdata2) throws Exception {
		
		reserveemulator=new ReserveEmulationHelper();
		
		switch (Applied_Dates) {
		case "FIRST_DATE":
			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);
			int abs_disc = disc + disc2;

			if (OfferId.contentEquals(OfferId2)) {

				expected = new String[] { OfferId, String.valueOf(abs_disc) };

			}

			else {

				if (packagecode.contentEquals("96") || packagecode.contentEquals("97")
						|| packagecode.contentEquals("94") || packagecode.contentEquals("95")
						|| packagecode.contentEquals("92") || packagecode.contentEquals("93")) {
					expected = new String[] { OfferId2, String.valueOf(disc2) };
				}

				else if (packagecode2.contentEquals("96") || packagecode2.contentEquals("97")
						|| packagecode2.contentEquals("94") || packagecode2.contentEquals("95")
						|| packagecode2.contentEquals("92") || packagecode2.contentEquals("93")) {

					expected = new String[] { OfferId, String.valueOf(disc) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc) };
				}
			}

			break;
		case "MIDDLE_DATE":
			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);

			int SecondDiscountfirstline = disc * 2;
			int SecondDiscountsecondline = disc2 * 2;
			int abs_disc2 = SecondDiscountfirstline + SecondDiscountsecondline;

			if (OfferId.contentEquals(OfferId2)) {

				expected = new String[] { OfferId, String.valueOf(abs_disc2) };
			} else {

				if (packagecode.contentEquals("96") || packagecode.contentEquals("97")
						|| packagecode.contentEquals("94") || packagecode.contentEquals("95")
						|| packagecode.contentEquals("92") || packagecode.contentEquals("93")) {
					expected = new String[] { OfferId2, String.valueOf(SecondDiscountsecondline) };
				}

				else if (packagecode2.contentEquals("96") || packagecode2.contentEquals("97")
						|| packagecode2.contentEquals("94") || packagecode2.contentEquals("95")
						|| packagecode2.contentEquals("92") || packagecode2.contentEquals("93")) {

					expected = new String[] { OfferId, String.valueOf(SecondDiscountfirstline) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc2) };
				}

			}

			break;
		case "LAST_DATE":
			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);

			int ThirdDiscountfirstline = disc * 3;
			int ThirdDiscountsecondline = disc2 * 3;

			int abs_disc3 = ThirdDiscountfirstline + ThirdDiscountsecondline;

			if (OfferId.contentEquals(OfferId2)) {

				expected = new String[] { OfferId, String.valueOf(abs_disc3) };

			} else {

				if (packagecode.contentEquals("96") || packagecode.contentEquals("97")
						|| packagecode.contentEquals("94") || packagecode.contentEquals("95")
						|| packagecode.contentEquals("92") || packagecode.contentEquals("93")) {
					expected = new String[] { OfferId2, String.valueOf(ThirdDiscountsecondline) };
				}

				else if (packagecode2.contentEquals("96") || packagecode2.contentEquals("97")
						|| packagecode2.contentEquals("94") || packagecode2.contentEquals("95")
						|| packagecode2.contentEquals("92") || packagecode2.contentEquals("93")) {

					expected = new String[] { OfferId, String.valueOf(ThirdDiscountfirstline) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc3) };
				}
			}

			break;

		}
		Map<String,String> postrequestDetails = new HashMap<String,String>();
		
		
		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);
		postrequestDetails.put("FirstItemDiscount",String.valueOf(disc));
		postrequestDetails.put("SecondItemDiscount",String.valueOf(disc2));
		postrequestDetails.put("PackageCode",packagecode);
		postrequestDetails.put("PackageCode2",packagecode2);
		postrequestDetails.put("OfferId", OfferId);
		postrequestDetails.put("OfferId2", OfferId2);
		
		postrequestDetails.put("expected", Arrays.toString(expected));
		
		
		  
		 
		return postrequestDetails;
		
	}
	
}
