package com.sams.promotions.emulation.test.helper;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sams.promotions.emulation.test.base.BaseStep;

import groovy.util.logging.Slf4j;

@Slf4j
@Component

public class PrimaryRequestHelper extends BaseStep {

	public PrimaryRequestHelper() throws IOException {
		super();
	}

	/*
	 * Author : Abu Description : Helper Method Date : 11/11/2019
	 * 
	 */

	protected String[] expected;
	protected Helper helpermethod;
	protected String postdata, postdata2, offerTypeDescription, offerTypeDescription2;
	protected int ItemId, Quantity, ItemId2, Quantity2, Maxdemcnt, Maxdemcnt2;
	protected ReserveEmulationHelper reserveemulator;

	public Map<String, String> getInitialDoubleLinesPostRequestDetails(int i, String membershipNumber,
			String channelName, String ClubId, String ClubId2, int code, int RetailPrice, String lineNumber,
			String Applied_Dates, String OfferId, String OfferId2, String pathsingle) throws Exception {

		helpermethod = new Helper();
		reserveemulator = new ReserveEmulationHelper();

		
		  String arrx =
		  reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").
		  toString(), i); String arry =
		  reserveemulator.BroadReachPromoMetaData(prop.get("metadata.prod.rest").
		  toString(), i + 1);
		 

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

		Double Discount = Double.valueOf(promodetails.get("Discount")) * 100;
		int disc = (int) Math.abs(Discount);

		Double Discount2 = Double.valueOf(promodetails2.get("Discount")) * 100;
		int disc2 = (int) Math.abs(Discount2);

		Quantity = Integer.valueOf(promodetails.get("MinimumPurchaseQuantity"));
		Maxdemcnt = Integer.valueOf(promodetails.get("MaxRedemptionCount"));
		offerTypeDescription = promodetails.get("offerTypeDescription");

		Quantity2 = Integer.valueOf(promodetails2.get("MinimumPurchaseQuantity"));
		Maxdemcnt2 = Integer.valueOf(promodetails2.get("MaxRedemptionCount"));
		offerTypeDescription2 = promodetails2.get("offerTypeDescription");

		switch (Applied_Dates) {
		case "FIRST_DATE":
			postdata = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNumber, map.get("firstdate"), pathsingle);

			postdata2 = reserveemulator.XMLRequestUpdater(Quantity, ItemId, RetailPrice, ClubId2, lineNumber, code,
					channelName, membershipNumber, map.get("firstdate"), pathsingle);

			break;
		case "MIDDLE_DATE":

			postdata = reserveemulator.XMLRequestUpdater(Quantity * 2, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNumber, map.get("midDate"), pathsingle);

			postdata2 = reserveemulator.XMLRequestUpdater(Quantity * 2, ItemId, RetailPrice, ClubId2, lineNumber, code,
					channelName, membershipNumber, map.get("midDate"), pathsingle);

			break;
		case "LAST_DATE":

			postdata = reserveemulator.XMLRequestUpdater(Quantity * 3, ItemId, RetailPrice, ClubId, lineNumber, code,
					channelName, membershipNumber, map.get("lastdate"), pathsingle);

			postdata2 = reserveemulator.XMLRequestUpdater(Quantity * 3, ItemId, RetailPrice, ClubId2, lineNumber, code,
					channelName, membershipNumber, map.get("lastdate"), pathsingle);

			break;

		}

		Map<String, String> postrequestDetails = new HashMap<String, String>();

		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);
		postrequestDetails.put("FirstItemDiscount", String.valueOf(disc));
		postrequestDetails.put("SecondItemDiscount", String.valueOf(disc2));
		postrequestDetails.put("PackageCode", packagecode);
		postrequestDetails.put("PackageCode2", packagecode2);
		postrequestDetails.put("OfferId", OfferId);
		postrequestDetails.put("OfferId2", OfferId2);

		return postrequestDetails;

	}

	public Map<String, String> getBusinessBasePostRequestDetails(int disc, int disc2, String packagecode,
			String packagecode2, String ClubId, String ClubId2, int RetailPrice, String lineNumber,
			String Applied_Dates, String OfferId, String OfferId2, String postdata, String postdata2) throws Exception {

		reserveemulator = new ReserveEmulationHelper();

		switch (Applied_Dates) {
		case "FIRST_DATE":

			postdata = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, RetailPrice, ClubId, lineNumber,
					postdata);

			postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, RetailPrice, ClubId2, lineNumber,
					postdata2);

			int abs_disc = disc + disc2;

			if (OfferId.contentEquals(OfferId2)) {

				if ((Quantity + Quantity2) <= Maxdemcnt) {

					expected = new String[] { OfferId, String.valueOf(abs_disc) };

				}

				else {

					expected = new String[] { OfferId, String.valueOf(disc) };
				}

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

				if ((Quantity * 2 + Quantity2 * 2) <= Maxdemcnt) {

					expected = new String[] { OfferId, String.valueOf(abs_disc2) };

				}

				else {

					expected = new String[] { OfferId, String.valueOf(Maxdemcnt * disc) };
				}

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

				if ((Quantity * 3 + Quantity2 * 3) <= Maxdemcnt) {

					expected = new String[] { OfferId, String.valueOf(abs_disc3) };

				}

				else {

					expected = new String[] { OfferId, String.valueOf(Maxdemcnt * disc) };
				}

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

		Map<String, String> postrequestDetails = new HashMap<String, String>();

		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);
		postrequestDetails.put("FirstItemDiscount", String.valueOf(disc));
		postrequestDetails.put("SecondItemDiscount", String.valueOf(disc2));
		postrequestDetails.put("PackageCode", packagecode);
		postrequestDetails.put("PackageCode2", packagecode2);
		postrequestDetails.put("OfferId", OfferId);
		postrequestDetails.put("OfferId2", OfferId2);

		postrequestDetails.put("expected", Arrays.toString(expected));

		return postrequestDetails;

	}

	public Map<String, String> getBusinessPlusPostRequestDetails(int disc, int disc2, String packagecode,
			String packagecode2, String ClubId, String ClubId2, int RetailPrice, String lineNumber,
			String Applied_Dates, String OfferId, String OfferId2, String postdata, String postdata2) throws Exception {

		reserveemulator = new ReserveEmulationHelper();

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

				if (packagecode.contentEquals("97") || packagecode.contentEquals("91")
						|| packagecode.contentEquals("99") || packagecode.contentEquals("90")
						|| packagecode.contentEquals("98")) {
					expected = new String[] { OfferId2, String.valueOf(disc2) };
				}

				else if (packagecode2.contentEquals("97") || packagecode2.contentEquals("91")
						|| packagecode2.contentEquals("99") || packagecode2.contentEquals("90")
						|| packagecode2.contentEquals("98")) {

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

				if (packagecode.contentEquals("97") || packagecode.contentEquals("91")
						|| packagecode.contentEquals("99") || packagecode.contentEquals("90")
						|| packagecode.contentEquals("98")) {
					expected = new String[] { OfferId2, String.valueOf(SecondDiscountsecondline) };
				}

				else if (packagecode2.contentEquals("97") || packagecode2.contentEquals("91")
						|| packagecode2.contentEquals("99") || packagecode2.contentEquals("90")
						|| packagecode2.contentEquals("98")) {

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

				if (packagecode.contentEquals("97") || packagecode.contentEquals("91")
						|| packagecode.contentEquals("99") || packagecode.contentEquals("90")
						|| packagecode.contentEquals("98")) {
					expected = new String[] { OfferId2, String.valueOf(ThirdDiscountsecondline) };
				}

				else if (packagecode2.contentEquals("97") || packagecode2.contentEquals("91")
						|| packagecode2.contentEquals("99") || packagecode2.contentEquals("90")
						|| packagecode2.contentEquals("98")) {

					expected = new String[] { OfferId, String.valueOf(ThirdDiscountfirstline) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc3) };
				}
			}

			break;

		}

		Map<String, String> postrequestDetails = new HashMap<String, String>();

		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);
		postrequestDetails.put("FirstItemDiscount", String.valueOf(disc));
		postrequestDetails.put("SecondItemDiscount", String.valueOf(disc2));
		postrequestDetails.put("PackageCode", packagecode);
		postrequestDetails.put("PackageCode2", packagecode2);
		postrequestDetails.put("OfferId", OfferId);
		postrequestDetails.put("OfferId2", OfferId2);

		postrequestDetails.put("expected", Arrays.toString(expected));

		return postrequestDetails;

	}

	public Map<String, String> getSavingsBasePostRequestDetails(int disc, int disc2, String packagecode,
			String packagecode2, String ClubId, String ClubId2, int RetailPrice, String lineNumber,
			String Applied_Dates, String OfferId, String OfferId2, String postdata, String postdata2) throws Exception {

		reserveemulator = new ReserveEmulationHelper();

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

		Map<String, String> postrequestDetails = new HashMap<String, String>();

		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);
		postrequestDetails.put("FirstItemDiscount", String.valueOf(disc));
		postrequestDetails.put("SecondItemDiscount", String.valueOf(disc2));
		postrequestDetails.put("PackageCode", packagecode);
		postrequestDetails.put("PackageCode2", packagecode2);
		postrequestDetails.put("OfferId", OfferId);
		postrequestDetails.put("OfferId2", OfferId2);

		postrequestDetails.put("expected", Arrays.toString(expected));

		return postrequestDetails;

	}

	public Map<String, String> getSavingsPlusPostRequestDetails(int disc, int disc2, String packagecode,
			String packagecode2, String ClubId, String ClubId2, int RetailPrice, String lineNumber,
			String Applied_Dates, String OfferId, String OfferId2, String postdata, String postdata2) throws Exception {

		reserveemulator = new ReserveEmulationHelper();

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

				if (packagecode.contentEquals("97") || packagecode.contentEquals("94")
						|| packagecode.contentEquals("95") || packagecode.contentEquals("92")
						|| packagecode.contentEquals("93")) {
					expected = new String[] { OfferId2, String.valueOf(disc2) };
				}

				else if (packagecode2.contentEquals("97") || packagecode2.contentEquals("94")
						|| packagecode2.contentEquals("95") || packagecode2.contentEquals("92")
						|| packagecode2.contentEquals("93")) {

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

				if (packagecode.contentEquals("97") || packagecode.contentEquals("94")
						|| packagecode.contentEquals("95") || packagecode.contentEquals("92")
						|| packagecode.contentEquals("93")) {
					expected = new String[] { OfferId2, String.valueOf(SecondDiscountsecondline) };
				}

				else if (packagecode2.contentEquals("97") || packagecode2.contentEquals("94")
						|| packagecode2.contentEquals("95") || packagecode2.contentEquals("92")
						|| packagecode2.contentEquals("93")) {

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

				if (packagecode.contentEquals("97") || packagecode.contentEquals("94")
						|| packagecode.contentEquals("95") || packagecode.contentEquals("92")
						|| packagecode.contentEquals("93")) {
					expected = new String[] { OfferId2, String.valueOf(ThirdDiscountsecondline) };
				}

				else if (packagecode2.contentEquals("97") || packagecode2.contentEquals("94")
						|| packagecode2.contentEquals("95") || packagecode2.contentEquals("92")
						|| packagecode2.contentEquals("93")) {

					expected = new String[] { OfferId, String.valueOf(ThirdDiscountfirstline) };
				}

				else {
					expected = new String[] { OfferId + "" + OfferId2, String.valueOf(abs_disc3) };
				}
			}

			break;

		}
		Map<String, String> postrequestDetails = new HashMap<String, String>();

		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);
		postrequestDetails.put("FirstItemDiscount", String.valueOf(disc));
		postrequestDetails.put("SecondItemDiscount", String.valueOf(disc2));
		postrequestDetails.put("PackageCode", packagecode);
		postrequestDetails.put("PackageCode2", packagecode2);
		postrequestDetails.put("OfferId", OfferId);
		postrequestDetails.put("OfferId2", OfferId2);

		postrequestDetails.put("expected", Arrays.toString(expected));

		return postrequestDetails;

	}
	
	/***alternate***/
	
	
	public Map<String, String> getInitialReserveDoubleLinesPostRequestDetails(int i, String membershipNumber,
			String channelName, String ClubId, String ClubId2, int code, String RetailPrice, String lineNumber,
			String Applied_Dates,String RegistrationNumber,String TransactionId,String arrx,String arry,String pathsingle) throws Exception {

		helpermethod = new Helper();
		reserveemulator = new ReserveEmulationHelper();	

		String postdata="",postdata2="";
		Map<String, String> promodetails = Helper.getPromotionDetails(arrx);
		Map<String, String> promodetails2 = Helper.getPromotionDetails(arry);
		
		if(promodetails.get("PromoId").contains(promodetails2.get("PromoId"))) {
			
			if(promodetails.get("ItemTypeDescription").contentEquals("Reward")) {
				
				ItemId=Integer.valueOf(promodetails.get("ItemId"));
				
				if(promodetails.get("ItemTypeDescription").contentEquals("Seed")) {
					ItemId2 = Integer.valueOf(promodetails2.get("ItemId"));
				}
				
			}
			else if (promodetails.get("ItemTypeDescription").contentEquals("Seed")){
				
					
					ItemId=Integer.valueOf(promodetails.get("ItemId"));
					
					if(promodetails2.get("ItemTypeDescription").contentEquals("Reward")) {
						ItemId2 = Integer.valueOf(promodetails2.get("ItemId"));
					}
									
			}
			
			else {
				
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
				
				
			}
			
			
		}
		
		else {
			
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
		}

		

		Map<String, String> map = helpermethod.getDatesDoubleLinesMetadata(arrx, arry);
		Map<String, String> maprx = helpermethod.getRetailPriceMetadata(arrx, arry);


		Quantity = Integer.valueOf(promodetails.get("MinimumPurchaseQuantity"));
		Quantity2 = Integer.valueOf(promodetails2.get("MinimumPurchaseQuantity"));

		
		switch (RetailPrice) {
		
		case "SAME_PRICE":
			
			switch(Applied_Dates) {
			
			case "FIRST_DATE":
				postdata = reserveemulator.ReserveRequestUpdater(Quantity, ItemId, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId, lineNumber, code,
						channelName, membershipNumber, map.get("firstdate"),RegistrationNumber,TransactionId, pathsingle);

				postdata2 = reserveemulator.ReserveRequestUpdater(Quantity, ItemId, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId2, lineNumber, code,
						channelName, membershipNumber, map.get("firstdate"), RegistrationNumber,TransactionId,pathsingle);

				break;
			case "MIDDLE_DATE":

				postdata = reserveemulator.ReserveRequestUpdater(Quantity * 2, ItemId, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId, lineNumber, code,
						channelName, membershipNumber, map.get("midDate"),RegistrationNumber,TransactionId, pathsingle);

				postdata2 = reserveemulator.ReserveRequestUpdater(Quantity * 2, ItemId, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId2, lineNumber, code,
						channelName, membershipNumber, map.get("midDate"),RegistrationNumber,TransactionId, pathsingle);

				break;
			case "LAST_DATE":

				postdata = reserveemulator.ReserveRequestUpdater(Quantity * 3, ItemId, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId, lineNumber, code,
						channelName, membershipNumber, map.get("lastdate"),RegistrationNumber,TransactionId, pathsingle);

				postdata2 = reserveemulator.ReserveRequestUpdater(Quantity * 3, ItemId, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId2, lineNumber, code,
						channelName, membershipNumber, map.get("lastdate"),RegistrationNumber,TransactionId, pathsingle);

				break;
			
			}

			break;
			
			case "LESS_PRICE":

			switch(Applied_Dates) {
			
			case "FIRST_DATE":
				postdata = reserveemulator.ReserveRequestUpdater(Quantity, ItemId, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId, lineNumber, code,
						channelName, membershipNumber, map.get("firstdate"),RegistrationNumber,TransactionId, pathsingle);

				postdata2 = reserveemulator.ReserveRequestUpdater(Quantity, ItemId, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId2, lineNumber, code,
						channelName, membershipNumber, map.get("firstdate"), RegistrationNumber,TransactionId,pathsingle);

				break;
			case "MIDDLE_DATE":

				postdata = reserveemulator.ReserveRequestUpdater(Quantity * 2, ItemId, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId, lineNumber, code,
						channelName, membershipNumber, map.get("midDate"),RegistrationNumber,TransactionId, pathsingle);

				postdata2 = reserveemulator.ReserveRequestUpdater(Quantity * 2, ItemId, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId2, lineNumber, code,
						channelName, membershipNumber, map.get("midDate"),RegistrationNumber,TransactionId, pathsingle);

				break;
			case "LAST_DATE":

				postdata = reserveemulator.ReserveRequestUpdater(Quantity * 3, ItemId, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId, lineNumber, code,
						channelName, membershipNumber, map.get("lastdate"),RegistrationNumber,TransactionId, pathsingle);

				postdata2 = reserveemulator.ReserveRequestUpdater(Quantity * 3, ItemId, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId2, lineNumber, code,
						channelName, membershipNumber, map.get("lastdate"),RegistrationNumber,TransactionId, pathsingle);

				break;
			
			}

			break;
			
		case "MORE_PRICE":
			switch(Applied_Dates) {
			
			case "FIRST_DATE":
				postdata = reserveemulator.ReserveRequestUpdater(Quantity, ItemId, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId, lineNumber, code,
						channelName, membershipNumber, map.get("firstdate"),RegistrationNumber,TransactionId, pathsingle);

				postdata2 = reserveemulator.ReserveRequestUpdater(Quantity, ItemId, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId2, lineNumber, code,
						channelName, membershipNumber, map.get("firstdate"), RegistrationNumber,TransactionId,pathsingle);

				break;
			case "MIDDLE_DATE":

				postdata = reserveemulator.ReserveRequestUpdater(Quantity * 2, ItemId, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId, lineNumber, code,
						channelName, membershipNumber, map.get("midDate"),RegistrationNumber,TransactionId, pathsingle);

				postdata2 = reserveemulator.ReserveRequestUpdater(Quantity * 2, ItemId, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId2, lineNumber, code,
						channelName, membershipNumber, map.get("midDate"),RegistrationNumber,TransactionId, pathsingle);

				break;
			case "LAST_DATE":

				postdata = reserveemulator.ReserveRequestUpdater(Quantity * 3, ItemId, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId, lineNumber, code,
						channelName, membershipNumber, map.get("lastdate"),RegistrationNumber,TransactionId, pathsingle);

				postdata2 = reserveemulator.ReserveRequestUpdater(Quantity * 3, ItemId, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId2, lineNumber, code,
						channelName, membershipNumber, map.get("lastdate"),RegistrationNumber,TransactionId, pathsingle);

				break;
			
			}

			break;

		}

		Map<String, String> postrequestDetails = new HashMap<String, String>();

		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);

		return postrequestDetails;

	}
	
	
	public Map<String, String> getDoubleLinesRequest(String ClubId, String ClubId2, String RetailPrice, String lineNumber,
			String Applied_Dates,String postdata, String postdata2,String arrx,String arry) throws Exception {

		reserveemulator = new ReserveEmulationHelper();
		helpermethod = new Helper();
		Map<String, String> maprx = helpermethod.getRetailPriceMetadata(arrx, arry);
		
		
		switch (RetailPrice) {
		
		case "SAME_PRICE":
			

			switch (Applied_Dates) {
			case "FIRST_DATE":

				postdata = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId, lineNumber,
						postdata);

				postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId2, lineNumber,
						postdata2);
				

				break;
				
			case "MIDDLE_DATE":

				postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId, lineNumber,
						postdata);

				postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId2, lineNumber,
						postdata2);


				break;
			case "LAST_DATE":

				postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId, lineNumber,
						postdata);

				postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, Integer.valueOf(maprx.get("SameRetailPrice")), ClubId2, lineNumber,
						postdata2);


				break;

			}

			break;
			
			case "LESS_PRICE":

				switch (Applied_Dates) {
				case "FIRST_DATE":

					postdata = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId, lineNumber,
							postdata);

					postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId2, lineNumber,
							postdata2);
					

					break;
					
				case "MIDDLE_DATE":

					postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId, lineNumber,
							postdata);

					postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId2, lineNumber,
							postdata2);


					break;
				case "LAST_DATE":

					postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId, lineNumber,
							postdata);

					postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, Integer.valueOf(maprx.get("LessRetailPrice")), ClubId2, lineNumber,
							postdata2);


					break;

				}	
				
				break;
			
		case "MORE_PRICE":
			
			switch (Applied_Dates) {
			case "FIRST_DATE":

				postdata = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId, lineNumber,
						postdata);

				postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2, ItemId2, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId2, lineNumber,
						postdata2);
				

				break;
				
			case "MIDDLE_DATE":

				postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId, lineNumber,
						postdata);

				postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 2, ItemId2, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId2, lineNumber,
						postdata2);


				break;
			case "LAST_DATE":

				postdata = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId, lineNumber,
						postdata);

				postdata2 = reserveemulator.XMLRequestUpdaternew(Quantity2 * 3, ItemId2, Integer.valueOf(maprx.get("MoreRetailPrice")), ClubId2, lineNumber,
						postdata2);


				break;

			}	
			break;

		}



		Map<String, String> postrequestDetails = new HashMap<String, String>();

		postrequestDetails.put("DataPowerRequest", postdata);
		postrequestDetails.put("EmulatorRequest", postdata2);

		return postrequestDetails;

	}

}
