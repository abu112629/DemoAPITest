package com.sams.promotions.emulation.AllPromotionOffers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"couponNumber",
"campaignNumber",
"offerNumber",
"couponMarketingNumber",
"startDate",
"endDate",
"packageCode",
"packageDescription",
"offerTypeCode",
"offerTypeDescription",
"couponValue",
"maxRedemptionCount",
"minimumBasketAmount",
"maxDiscountAmount",
"minimumCorePurchaseQuantity",
"merchandiseDetails"
})
public class AnalyticOffer {

@JsonProperty("couponNumber")
private Long couponNumber;
@JsonProperty("campaignNumber")
private Long campaignNumber;
@JsonProperty("offerNumber")
private Long offerNumber;
@JsonProperty("couponMarketingNumber")
private Long couponMarketingNumber;
@JsonProperty("startDate")
private String startDate;
@JsonProperty("endDate")
private String endDate;
@JsonProperty("packageCode")
private Long packageCode;
@JsonProperty("packageDescription")
private String packageDescription;
@JsonProperty("offerTypeCode")
private Long offerTypeCode;
@JsonProperty("offerTypeDescription")
private String offerTypeDescription;
@JsonProperty("couponValue")
private Long couponValue;
@JsonProperty("maxRedemptionCount")
private Long maxRedemptionCount;
@JsonProperty("minimumBasketAmount")
private Long minimumBasketAmount;
@JsonProperty("maxDiscountAmount")
private Long maxDiscountAmount;
@JsonProperty("minimumCorePurchaseQuantity")
private Long minimumCorePurchaseQuantity;
@JsonProperty("merchandiseDetails")
private MerchandiseDetails merchandiseDetails;

@JsonProperty("couponNumber")
public Long getCouponNumber() {
return couponNumber;
}

@JsonProperty("couponNumber")
public void setCouponNumber(Long couponNumber) {
this.couponNumber = couponNumber;
}

@JsonProperty("campaignNumber")
public Long getCampaignNumber() {
return campaignNumber;
}

@JsonProperty("campaignNumber")
public void setCampaignNumber(Long campaignNumber) {
this.campaignNumber = campaignNumber;
}

@JsonProperty("offerNumber")
public Long getOfferNumber() {
return offerNumber;
}

@JsonProperty("offerNumber")
public void setOfferNumber(Long offerNumber) {
this.offerNumber = offerNumber;
}

@JsonProperty("couponMarketingNumber")
public Long getCouponMarketingNumber() {
return couponMarketingNumber;
}

@JsonProperty("couponMarketingNumber")
public void setCouponMarketingNumber(Long couponMarketingNumber) {
this.couponMarketingNumber = couponMarketingNumber;
}

@JsonProperty("startDate")
public String getStartDate() {
return startDate;
}

@JsonProperty("startDate")
public void setStartDate(String startDate) {
this.startDate = startDate;
}

@JsonProperty("endDate")
public String getEndDate() {
return endDate;
}

@JsonProperty("endDate")
public void setEndDate(String endDate) {
this.endDate = endDate;
}

@JsonProperty("packageCode")
public Long getPackageCode() {
return packageCode;
}

@JsonProperty("packageCode")
public void setPackageCode(Long packageCode) {
this.packageCode = packageCode;
}

@JsonProperty("packageDescription")
public String getPackageDescription() {
return packageDescription;
}

@JsonProperty("packageDescription")
public void setPackageDescription(String packageDescription) {
this.packageDescription = packageDescription;
}

@JsonProperty("offerTypeCode")
public Long getOfferTypeCode() {
return offerTypeCode;
}

@JsonProperty("offerTypeCode")
public void setOfferTypeCode(Long offerTypeCode) {
this.offerTypeCode = offerTypeCode;
}

@JsonProperty("offerTypeDescription")
public String getOfferTypeDescription() {
return offerTypeDescription;
}

@JsonProperty("offerTypeDescription")
public void setOfferTypeDescription(String offerTypeDescription) {
this.offerTypeDescription = offerTypeDescription;
}

@JsonProperty("couponValue")
public Long getCouponValue() {
return couponValue;
}

@JsonProperty("couponValue")
public void setCouponValue(Long couponValue) {
this.couponValue = couponValue;
}

@JsonProperty("maxRedemptionCount")
public Long getMaxRedemptionCount() {
return maxRedemptionCount;
}

@JsonProperty("maxRedemptionCount")
public void setMaxRedemptionCount(Long maxRedemptionCount) {
this.maxRedemptionCount = maxRedemptionCount;
}

@JsonProperty("minimumBasketAmount")
public Long getMinimumBasketAmount() {
return minimumBasketAmount;
}

@JsonProperty("minimumBasketAmount")
public void setMinimumBasketAmount(Long minimumBasketAmount) {
this.minimumBasketAmount = minimumBasketAmount;
}

@JsonProperty("maxDiscountAmount")
public Long getMaxDiscountAmount() {
return maxDiscountAmount;
}

@JsonProperty("maxDiscountAmount")
public void setMaxDiscountAmount(Long maxDiscountAmount) {
this.maxDiscountAmount = maxDiscountAmount;
}

@JsonProperty("minimumCorePurchaseQuantity")
public Long getMinimumCorePurchaseQuantity() {
return minimumCorePurchaseQuantity;
}

@JsonProperty("minimumCorePurchaseQuantity")
public void setMinimumCorePurchaseQuantity(Long minimumCorePurchaseQuantity) {
this.minimumCorePurchaseQuantity = minimumCorePurchaseQuantity;
}

@JsonProperty("merchandiseDetails")
public MerchandiseDetails getMerchandiseDetails() {
return merchandiseDetails;
}

@JsonProperty("merchandiseDetails")
public void setMerchandiseDetails(MerchandiseDetails merchandiseDetails) {
this.merchandiseDetails = merchandiseDetails;
}

}
