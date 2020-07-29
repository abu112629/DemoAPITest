package com.sams.promotions.reserveCollection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"promotionsName",
"promotionId",
"promotionNumber",
"billingDetails",
"discountedQuantity",
"discountType",
"promotionItemNumber",
"discountAmount",
"returnedQuantity"
})
public class DiscountInfo {

@JsonProperty("promotionsName")
private String promotionsName;
@JsonProperty("promotionId")
private String promotionId;
@JsonProperty("promotionNumber")
private String promotionNumber;
@JsonProperty("billingDetails")
private BillingDetails billingDetails;
@JsonProperty("discountedQuantity")
private Long discountedQuantity;
@JsonProperty("returnedQuantity")
private Long returnedQuantity;
@JsonProperty("discountedRefundQuantity")
private Long discountedRefundQuantity;
@JsonProperty("discountType")
private String discountType;
@JsonProperty("promotionItemNumber")
private String promotionItemNumber;
@JsonProperty("discountAmount")
private DiscountAmount discountAmount;

@JsonProperty("promotionsName")
public String getPromotionsName() {
return promotionsName;
}

@JsonProperty("promotionsName")
public void setPromotionsName(String promotionsName) {
this.promotionsName = promotionsName;
}

@JsonProperty("promotionId")
public String getPromotionId() {
return promotionId;
}

@JsonProperty("promotionId")
public void setPromotionId(String promotionId) {
this.promotionId = promotionId;
}

@JsonProperty("promotionNumber")
public String getPromotionNumber() {
return promotionNumber;
}

@JsonProperty("promotionNumber")
public void setPromotionNumber(String promotionNumber) {
this.promotionNumber = promotionNumber;
}

@JsonProperty("billingDetails")
public BillingDetails getBillingDetails() {
return billingDetails;
}

@JsonProperty("billingDetails")
public void setBillingDetails(BillingDetails billingDetails) {
this.billingDetails = billingDetails;
}

@JsonProperty("discountedQuantity")
public Long getDiscountedQuantity() {
return discountedQuantity;
}

@JsonProperty("discountedQuantity")
public void setDiscountedQuantity(Long discountedQuantity) {
this.discountedQuantity = discountedQuantity;
}

@JsonProperty("returnedQuantity")
public Long getReturnedQuantity() {
return returnedQuantity;
}

@JsonProperty("returnedQuantity")
public void setReturnedQuantity(Long returnedQuantity) {
this.returnedQuantity = returnedQuantity;
}

@JsonProperty("discountedRefundQuantity")
public Long getDiscountedRefundQuantity() {
return discountedRefundQuantity;
}

@JsonProperty("discountedRefundQuantity")
public void setDiscountedRefundQuantity(Long discountedRefundQuantity) {
this.discountedRefundQuantity = discountedRefundQuantity;
}

@JsonProperty("discountType")
public String getDiscountType() {
return discountType;
}

@JsonProperty("discountType")
public void setDiscountType(String discountType) {
this.discountType = discountType;
}

@JsonProperty("promotionItemNumber")
public String getPromotionItemNumber() {
return promotionItemNumber;
}

@JsonProperty("promotionItemNumber")
public void setPromotionItemNumber(String promotionItemNumber) {
this.promotionItemNumber = promotionItemNumber;
}

@JsonProperty("discountAmount")
public DiscountAmount getDiscountAmount() {
return discountAmount;
}

@JsonProperty("discountAmount")
public void setDiscountAmount(DiscountAmount discountAmount) {
this.discountAmount = discountAmount;
}

}

