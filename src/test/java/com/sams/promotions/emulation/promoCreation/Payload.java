package com.sams.promotions.emulation.promoCreation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"createdBy",
"modifiedBy",
"name",
"description",
"termsEx",
"message",
"redemptionLimit",
"perCustomerRedemptionLimit",
"perMembershipRedemptionLimit",
"perPrimaryHouseholdRedemptionLimit",
"perAddOnHouseholdRedemptionLimit",
"perCustomerRedemptionExpirDays",
"multiMatchLimit",
"promoMatchCount",
"type",
"status",
"schedule",
"conditionString",
"eligiblityConditionString",
"actions",
"displayAtOrderLevel",
"autoApply",
"thresholdValue",
"vendorFundingPercent",
"promotionNumber"
})
public class Payload {

@JsonProperty("createdBy")
private String createdBy;
@JsonProperty("modifiedBy")
private String modifiedBy;
@JsonProperty("name")
private String name;
@JsonProperty("description")
private String description;
@JsonProperty("termsEx")
private TermsEx termsEx;
@JsonProperty("message")
private Message message;
@JsonProperty("redemptionLimit")
private Integer redemptionLimit;
@JsonProperty("perCustomerRedemptionLimit")
private Integer perCustomerRedemptionLimit;
@JsonProperty("perMembershipRedemptionLimit")
private Integer perMembershipRedemptionLimit;
@JsonProperty("perPrimaryHouseholdRedemptionLimit")
private Integer perPrimaryHouseholdRedemptionLimit;
@JsonProperty("perAddOnHouseholdRedemptionLimit")
private Integer perAddOnHouseholdRedemptionLimit;
@JsonProperty("perCustomerRedemptionExpirDays")
private Integer perCustomerRedemptionExpirDays;
@JsonProperty("multiMatchLimit")
private Integer multiMatchLimit;
@JsonProperty("promoMatchCount")
private Integer promoMatchCount;
@JsonProperty("type")
private String type;
@JsonProperty("status")
private String status;
@JsonProperty("schedule")
private Schedule schedule;
@JsonProperty("conditionString")
private String conditionString;
@JsonProperty("eligiblityConditionString")
private String eligiblityConditionString;
@JsonProperty("actions")
private List<Action> actions = null;
@JsonProperty("displayAtOrderLevel")
private Boolean displayAtOrderLevel;
@JsonProperty("autoApply")
private Boolean autoApply;
@JsonProperty("thresholdValue")
private Integer thresholdValue;
@JsonProperty("vendorFundingPercent")
private Integer vendorFundingPercent;
@JsonProperty("promotionNumber")
private Integer promotionNumber;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("createdBy")
public String getCreatedBy() {
return createdBy;
}

@JsonProperty("createdBy")
public void setCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

@JsonProperty("modifiedBy")
public String getModifiedBy() {
return modifiedBy;
}

@JsonProperty("modifiedBy")
public void setModifiedBy(String modifiedBy) {
this.modifiedBy = modifiedBy;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("termsEx")
public TermsEx getTermsEx() {
return termsEx;
}

@JsonProperty("termsEx")
public void setTermsEx(TermsEx termsEx) {
this.termsEx = termsEx;
}

@JsonProperty("message")
public Message getMessage() {
return message;
}

@JsonProperty("message")
public void setMessage(Message message) {
this.message = message;
}

@JsonProperty("redemptionLimit")
public Integer getRedemptionLimit() {
return redemptionLimit;
}

@JsonProperty("redemptionLimit")
public void setRedemptionLimit(Integer redemptionLimit) {
this.redemptionLimit = redemptionLimit;
}

@JsonProperty("perCustomerRedemptionLimit")
public Integer getPerCustomerRedemptionLimit() {
return perCustomerRedemptionLimit;
}

@JsonProperty("perCustomerRedemptionLimit")
public void setPerCustomerRedemptionLimit(Integer perCustomerRedemptionLimit) {
this.perCustomerRedemptionLimit = perCustomerRedemptionLimit;
}

@JsonProperty("perMembershipRedemptionLimit")
public Integer getPerMembershipRedemptionLimit() {
return perMembershipRedemptionLimit;
}

@JsonProperty("perMembershipRedemptionLimit")
public void setPerMembershipRedemptionLimit(Integer perMembershipRedemptionLimit) {
this.perMembershipRedemptionLimit = perMembershipRedemptionLimit;
}

@JsonProperty("perPrimaryHouseholdRedemptionLimit")
public Integer getPerPrimaryHouseholdRedemptionLimit() {
return perPrimaryHouseholdRedemptionLimit;
}

@JsonProperty("perPrimaryHouseholdRedemptionLimit")
public void setPerPrimaryHouseholdRedemptionLimit(Integer perPrimaryHouseholdRedemptionLimit) {
this.perPrimaryHouseholdRedemptionLimit = perPrimaryHouseholdRedemptionLimit;
}

@JsonProperty("perAddOnHouseholdRedemptionLimit")
public Integer getPerAddOnHouseholdRedemptionLimit() {
return perAddOnHouseholdRedemptionLimit;
}

@JsonProperty("perAddOnHouseholdRedemptionLimit")
public void setPerAddOnHouseholdRedemptionLimit(Integer perAddOnHouseholdRedemptionLimit) {
this.perAddOnHouseholdRedemptionLimit = perAddOnHouseholdRedemptionLimit;
}

@JsonProperty("perCustomerRedemptionExpirDays")
public Integer getPerCustomerRedemptionExpirDays() {
return perCustomerRedemptionExpirDays;
}

@JsonProperty("perCustomerRedemptionExpirDays")
public void setPerCustomerRedemptionExpirDays(Integer perCustomerRedemptionExpirDays) {
this.perCustomerRedemptionExpirDays = perCustomerRedemptionExpirDays;
}

@JsonProperty("multiMatchLimit")
public Integer getMultiMatchLimit() {
return multiMatchLimit;
}

@JsonProperty("multiMatchLimit")
public void setMultiMatchLimit(Integer multiMatchLimit) {
this.multiMatchLimit = multiMatchLimit;
}

@JsonProperty("promoMatchCount")
public Integer getPromoMatchCount() {
return promoMatchCount;
}

@JsonProperty("promoMatchCount")
public void setPromoMatchCount(Integer promoMatchCount) {
this.promoMatchCount = promoMatchCount;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("status")
public String getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(String status) {
this.status = status;
}

@JsonProperty("schedule")
public Schedule getSchedule() {
return schedule;
}

@JsonProperty("schedule")
public void setSchedule(Schedule schedule) {
this.schedule = schedule;
}

@JsonProperty("conditionString")
public String getConditionString() {
return conditionString;
}

@JsonProperty("conditionString")
public void setConditionString(String conditionString) {
this.conditionString = conditionString;
}

@JsonProperty("eligiblityConditionString")
public String getEligiblityConditionString() {
return eligiblityConditionString;
}

@JsonProperty("eligiblityConditionString")
public void setEligiblityConditionString(String eligiblityConditionString) {
this.eligiblityConditionString = eligiblityConditionString;
}

@JsonProperty("actions")
public List<Action> getActions() {
return actions;
}

@JsonProperty("actions")
public void setActions(List<Action> actions) {
this.actions = actions;
}

@JsonProperty("displayAtOrderLevel")
public Boolean getDisplayAtOrderLevel() {
return displayAtOrderLevel;
}

@JsonProperty("displayAtOrderLevel")
public void setDisplayAtOrderLevel(Boolean displayAtOrderLevel) {
this.displayAtOrderLevel = displayAtOrderLevel;
}

@JsonProperty("autoApply")
public Boolean getAutoApply() {
return autoApply;
}

@JsonProperty("autoApply")
public void setAutoApply(Boolean autoApply) {
this.autoApply = autoApply;
}

@JsonProperty("thresholdValue")
public Integer getThresholdValue() {
return thresholdValue;
}

@JsonProperty("thresholdValue")
public void setThresholdValue(Integer thresholdValue) {
this.thresholdValue = thresholdValue;
}

@JsonProperty("vendorFundingPercent")
public Integer getVendorFundingPercent() {
return vendorFundingPercent;
}

@JsonProperty("vendorFundingPercent")
public void setVendorFundingPercent(Integer vendorFundingPercent) {
this.vendorFundingPercent = vendorFundingPercent;
}

@JsonProperty("promotionNumber")
public Integer getPromotionNumber() {
return promotionNumber;
}

@JsonProperty("promotionNumber")
public void setPromotionNumber(Integer promotionNumber) {
this.promotionNumber = promotionNumber;
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

