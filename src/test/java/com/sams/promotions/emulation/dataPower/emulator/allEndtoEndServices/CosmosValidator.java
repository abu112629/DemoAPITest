package com.sams.promotions.emulation.dataPower.emulator.allEndtoEndServices;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sams.promotions.emulation.test.helper.Helper;
import com.sams.promotions.emulation.test.steps.util.ClientConfigurationDatabase;
import com.sams.promotions.reserveCollection.DiscountInfo;
import com.sams.promotions.reserveCollection.Item;
import com.sams.promotions.reserveCollection.PromoTracker;
import com.sams.promotions.reserveCollection.ReserveForwardSyncDocument;

public class CosmosValidator {

	private ClientConfigurationDatabase connection;
	protected String PromotionId;

	public String ForwardSyncValidator(int index, String OrderNumber) throws Exception {

		connection = new ClientConfigurationDatabase();
		String result = connection.setClient(OrderNumber);

		assertNotNull(result);

		ObjectMapper objectmapper = new ObjectMapper();
		ReserveForwardSyncDocument document = objectmapper.readValue(result, ReserveForwardSyncDocument.class);

		ArrayList<String> arrListnew = new ArrayList<String>();
		String actualnew[] = null;
		String registerNumber = document.getRegisterNbr();
		String transactioNo = document.getTransactionNbr();
		String memberId = document.getMembershipId().substring(2);
		String ClubId = document.getClubId();
		String redDate = document.getRedemptionDate();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date redemptionparsedDate = format.parse(redDate);

		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
		String redemptionDate = outputFormat.format(redemptionparsedDate);

		List<PromoTracker> list = document.getPromoTrackers();

		if (list != null) {
			String discount = null;
			String gtin = "";
			String ItemNumber = null;
			long qty = 0;
			long nonvalueitemqtty;
			String PVRC = null;

			List<Item> itemlist = document.getItems();

			for (Item lineitem : itemlist) {

				List<DiscountInfo> discountInfolist = lineitem.getDiscountInfo();

				for (DiscountInfo newline : discountInfolist) {

					String PromoId = newline.getPromotionNumber();

					for (PromoTracker line : list) {
						PromotionId = String.valueOf(line.getPromotionNumber());

						if (PromoId.contentEquals(PromotionId)) {

							PVRC = String.valueOf(line.getRedemptionCount());

						} else {
							PVRC = String.valueOf(newline.getDiscountedQuantity());
						}

					}

					nonvalueitemqtty = lineitem.getOrderedQuantity() - newline.getDiscountedQuantity();
					discount = String.format("%.2f",
							(newline.getDiscountAmount().getUnitDiscount().getCurrencyAmount()));

					BigDecimal discount2 = new BigDecimal(discount);
					BigDecimal unitdiscount = discount2.abs();

					ItemNumber = lineitem.getItemNumber();
					qty = lineitem.getOrderedQuantity();

					actualnew = new String[] { PromoId + "||" + PVRC + "||" + gtin + "||" + qty + "||" + ItemNumber
							+ "||" + unitdiscount + "||" + registerNumber + "||" + transactioNo + "||" + memberId + "||"
							+ ClubId + "||" + redemptionDate + "||" + nonvalueitemqtty };
					arrListnew.add(actualnew[0].toString());
				}

			}

		}

		else {

			String PromoId = null;
			long PVRC = 0;
			String discount = null;
			String gtin = "";
			String ItemNumber = null;
			long qty = 0;
			long nonvalueitemqtty;

			List<Item> itemlist = document.getItems();

			for (Item lineitem : itemlist) {

				List<DiscountInfo> discountInfolist = lineitem.getDiscountInfo();

				for (DiscountInfo newline : discountInfolist) {

					PromoId = newline.getPromotionNumber();
					PVRC = newline.getDiscountedQuantity();

					nonvalueitemqtty = lineitem.getOrderedQuantity() - newline.getDiscountedQuantity();
					discount = String.format("%.2f",
							(newline.getDiscountAmount().getUnitDiscount().getCurrencyAmount()));

					BigDecimal discount2 = new BigDecimal(discount);
					BigDecimal unitdiscount = discount2.abs();

					ItemNumber = lineitem.getItemNumber();
					qty = lineitem.getOrderedQuantity();

					actualnew = new String[] { PromoId + "||" + PVRC + "||" + gtin + "||" + qty + "||" + ItemNumber
							+ "||" + unitdiscount + "||" + registerNumber + "||" + transactioNo + "||" + memberId + "||"
							+ ClubId + "||" + redemptionDate + "||" + nonvalueitemqtty };
					arrListnew.add(actualnew[0].toString());

				}

			}

			arrListnew.add(actualnew[0].toString());

		}
		return arrListnew.get(index) + "||" + arrListnew.size();
	}

	public String CosmosExtractedResults(String orderNumber) throws Exception {

		Helper helper = new Helper();
		String result = null;

		Map<String, String> promodetails =helper.getCosmosTransactionDetails(ForwardSyncValidator(0, orderNumber));

		int size = Integer.valueOf(promodetails.get("Size"));
		
		for (int i = 0; i < size; i++) {
			
			result = ForwardSyncValidator(i, orderNumber);
			Map<String, String> promodetailsCosmos = helper.getCosmosTransactionDetails(result);
			
			String PromoId = promodetailsCosmos.get("PromoId");
			String PVRC = promodetailsCosmos.get("PVRC");
			promodetailsCosmos.get("Gtin");
			String Quantity = promodetailsCosmos.get("Quantity");
			String ItemId = promodetailsCosmos.get("ItemId");
			String UnitDiscount = promodetailsCosmos.get("UnitDiscount");
			String RegisterNumber = promodetailsCosmos.get("RegisterNumber");
			String TransactioNumber = promodetailsCosmos.get("TransactioNumber");
			String MembershipId = promodetailsCosmos.get("MembershipId");
			String Clubid = promodetailsCosmos.get("Clubid");
			String RedemptionDate = promodetailsCosmos.get("RedemptionDate");
			String NonValueItemQuantity = promodetailsCosmos.get("NonValueItemQuantity");
			
			System.out.println(
					"PURCHASE_TXN_NBR\tPURCHASE_STORE_NBR\tPURCHASE_REG_NBR\tVALUE_COUPON_NBR\tMEMBERSHIP_NBR\t\tITEM_NBR\t\tPURCHASE_DATE\t\tPURCHASE_QTY\t\tPURCHASE_AMT\t\tPURCHASE_VALUE_RDMPT_CNT"
							+ "\tNON_VALUE_ITEM_QTY");
			System.out.println(
					"=================\t==================\t==================\t==================\t================\t================\t================\t================\t================"
							+ "\t======================\t\t================");

			System.out.println(TransactioNumber + "\t\t\t" + Clubid + "\t\t\t" + RegisterNumber + "\t\t\t" + PromoId
					+ "\t\t\t" + MembershipId + "\t\t" + ItemId + "\t\t" + RedemptionDate + "\t\t\t" + Quantity
					+ "\t\t\t" + UnitDiscount + "\t\t\t" + PVRC + "\t\t\t\t" + NonValueItemQuantity);

		}
		return result;

	}

}
