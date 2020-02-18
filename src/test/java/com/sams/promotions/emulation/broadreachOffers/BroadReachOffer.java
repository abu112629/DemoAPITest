package com.sams.promotions.emulation.broadreachOffers;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class BroadReachOffer {

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
private Float couponValue;
@JsonProperty("maxRedemptionCount")
private Long maxRedemptionCount;
@JsonProperty("minimumBasketAmount")
private Float minimumBasketAmount;
@JsonProperty("maxDiscountAmount")
private Float maxDiscountAmount;
@JsonProperty("minimumCorePurchaseQuantity")
private Long minimumCorePurchaseQuantity;
@JsonProperty("merchandiseDetails")
private MerchandiseDetails merchandiseDetails;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
public Float getCouponValue() {
return couponValue;
}

@JsonProperty("couponValue")
public void setCouponValue(Float couponValue) {
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
public Float getMinimumBasketAmount() {
return minimumBasketAmount;
}

@JsonProperty("minimumBasketAmount")
public void setMinimumBasketAmount(Float minimumBasketAmount) {
this.minimumBasketAmount = minimumBasketAmount;
}

@JsonProperty("maxDiscountAmount")
public Float getMaxDiscountAmount() {
return maxDiscountAmount;
}

@JsonProperty("maxDiscountAmount")
public void setMaxDiscountAmount(Float maxDiscountAmount) {
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

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

