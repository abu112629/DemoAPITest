package com.sams.promotions.emulation.promoCreation;

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
"type",
"applyTo",
"deferred",
"sendEmail",
"discountType",
"value",
"currencyUnit",
"gs1Code",
"promotionItemNumber",
"discountLimit",
"isAlreadyApplied"
})
public class Award {

@JsonProperty("type")
private String type;
@JsonProperty("applyTo")
private String applyTo;
@JsonProperty("deferred")
private Boolean deferred;
@JsonProperty("sendEmail")
private Boolean sendEmail;
@JsonProperty("discountType")
private String discountType;
@JsonProperty("value")
private Integer value;
@JsonProperty("currencyUnit")
private String currencyUnit;
@JsonProperty("gs1Code")
private String gs1Code;
@JsonProperty("promotionItemNumber")
private String promotionItemNumber;
@JsonProperty("discountLimit")
private Integer discountLimit;
@JsonProperty("isAlreadyApplied")
private Boolean isAlreadyApplied;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

@JsonProperty("discountType")
public String getDiscountType() {
return discountType;
}

@JsonProperty("discountType")
public void setDiscountType(String discountType) {
this.discountType = discountType;
}

@JsonProperty("value")
public Integer getValue() {
return value;
}

@JsonProperty("value")
public void setValue(Integer value) {
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

@JsonProperty("gs1Code")
public String getGs1Code() {
return gs1Code;
}

@JsonProperty("gs1Code")
public void setGs1Code(String gs1Code) {
this.gs1Code = gs1Code;
}

@JsonProperty("promotionItemNumber")
public String getPromotionItemNumber() {
return promotionItemNumber;
}

@JsonProperty("promotionItemNumber")
public void setPromotionItemNumber(String promotionItemNumber) {
this.promotionItemNumber = promotionItemNumber;
}

@JsonProperty("discountLimit")
public Integer getDiscountLimit() {
return discountLimit;
}

@JsonProperty("discountLimit")
public void setDiscountLimit(Integer discountLimit) {
this.discountLimit = discountLimit;
}

@JsonProperty("isAlreadyApplied")
public Boolean getIsAlreadyApplied() {
return isAlreadyApplied;
}

@JsonProperty("isAlreadyApplied")
public void setIsAlreadyApplied(Boolean isAlreadyApplied) {
this.isAlreadyApplied = isAlreadyApplied;
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

