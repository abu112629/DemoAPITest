package com.sams.promotions.emulation.quicksilverPromos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"type",
"applyTo",
"duration",
"deferred",
"sendEmail",
"perMemberItemLimit",
"isAlreadyApplied",
"couponGroup",
"couponType",
"memberLimit",
"discountType",
"value",
"currencyUnit",
"promotionItemNumber",
"gs1Code",
"discountLimit",
"sortOptionEnum"
})
public class Award {

@JsonProperty("type")
private String type;
@JsonProperty("applyTo")
private String applyTo;
@JsonProperty("duration")
private Duration duration;
@JsonProperty("deferred")
private Boolean deferred;
@JsonProperty("sendEmail")
private Boolean sendEmail;
@JsonProperty("perMemberItemLimit")
private Long perMemberItemLimit;
@JsonProperty("isAlreadyApplied")
private Boolean isAlreadyApplied;
@JsonProperty("couponGroup")
private String couponGroup;
@JsonProperty("couponType")
private String couponType;
@JsonProperty("memberLimit")
private Long memberLimit;
@JsonProperty("discountType")
private String discountType;
@JsonProperty("value")
private Long value;
@JsonProperty("currencyUnit")
private String currencyUnit;
@JsonProperty("promotionItemNumber")
private String promotionItemNumber;
@JsonProperty("gs1Code")
private String gs1Code;
@JsonProperty("discountLimit")
private Long discountLimit;
@JsonProperty("sortOptionEnum")
private String sortOptionEnum;

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("applyTo")
public String getApplyTo() {
return applyTo;
}

@JsonProperty("applyTo")
public void setApplyTo(String applyTo) {
this.applyTo = applyTo;
}

@JsonProperty("duration")
public Duration getDuration() {
return duration;
}

@JsonProperty("duration")
public void setDuration(Duration duration) {
this.duration = duration;
}

@JsonProperty("deferred")
public Boolean getDeferred() {
return deferred;
}

@JsonProperty("deferred")
public void setDeferred(Boolean deferred) {
this.deferred = deferred;
}

@JsonProperty("sendEmail")
public Boolean getSendEmail() {
return sendEmail;
}

@JsonProperty("sendEmail")
public void setSendEmail(Boolean sendEmail) {
this.sendEmail = sendEmail;
}

@JsonProperty("perMemberItemLimit")
public Long getPerMemberItemLimit() {
return perMemberItemLimit;
}

@JsonProperty("perMemberItemLimit")
public void setPerMemberItemLimit(Long perMemberItemLimit) {
this.perMemberItemLimit = perMemberItemLimit;
}

@JsonProperty("isAlreadyApplied")
public Boolean getIsAlreadyApplied() {
return isAlreadyApplied;
}

@JsonProperty("isAlreadyApplied")
public void setIsAlreadyApplied(Boolean isAlreadyApplied) {
this.isAlreadyApplied = isAlreadyApplied;
}

@JsonProperty("couponGroup")
public String getCouponGroup() {
return couponGroup;
}

@JsonProperty("couponGroup")
public void setCouponGroup(String couponGroup) {
this.couponGroup = couponGroup;
}

@JsonProperty("couponType")
public String getCouponType() {
return couponType;
}

@JsonProperty("couponType")
public void setCouponType(String couponType) {
this.couponType = couponType;
}

@JsonProperty("memberLimit")
public Long getMemberLimit() {
return memberLimit;
}

@JsonProperty("memberLimit")
public void setMemberLimit(Long memberLimit) {
this.memberLimit = memberLimit;
}

@JsonProperty("discountType")
public String getDiscountType() {
return discountType;
}

@JsonProperty("discountType")
public void setDiscountType(String discountType) {
this.discountType = discountType;
}

@JsonProperty("value")
public Long getValue() {
return value;
}

@JsonProperty("value")
public void setValue(Long value) {
this.value = value;
}

@JsonProperty("currencyUnit")
public String getCurrencyUnit() {
return currencyUnit;
}

@JsonProperty("currencyUnit")
public void setCurrencyUnit(String currencyUnit) {
this.currencyUnit = currencyUnit;
}

@JsonProperty("promotionItemNumber")
public String getPromotionItemNumber() {
return promotionItemNumber;
}

@JsonProperty("promotionItemNumber")
public void setPromotionItemNumber(String promotionItemNumber) {
this.promotionItemNumber = promotionItemNumber;
}

@JsonProperty("gs1Code")
public String getGs1Code() {
return gs1Code;
}

@JsonProperty("gs1Code")
public void setGs1Code(String gs1Code) {
this.gs1Code = gs1Code;
}

@JsonProperty("discountLimit")
public Long getDiscountLimit() {
return discountLimit;
}

@JsonProperty("discountLimit")
public void setDiscountLimit(Long discountLimit) {
this.discountLimit = discountLimit;
}

@JsonProperty("sortOptionEnum")
public String getSortOptionEnum() {
return sortOptionEnum;
}

@JsonProperty("sortOptionEnum")
public void setSortOptionEnum(String sortOptionEnum) {
this.sortOptionEnum = sortOptionEnum;
}

}

