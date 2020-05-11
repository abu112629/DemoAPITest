package com.sams.promotions.emulation.quicksilverPromos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"extId",
"created",
"lastModified",
"name",
"promotionGroup",
"priority",
"conditionString",
"status",
"actions",
"type",
"description",
"schedule",
"descriptionEx",
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
"displayAtOrderLevel",
"autoApply",
"thresholdValue",
"vendorFundingPercent",
"createdBy",
"modifiedBy",
"promotionNumber",
"eligiblityConditionString",
"multiMatchType"
})
public class Item {

@JsonProperty("id")
private String id;
@JsonProperty("extId")
private String extId;
@JsonProperty("created")
private String created;
@JsonProperty("lastModified")
private String lastModified;
@JsonProperty("name")
private String name;
@JsonProperty("promotionGroup")
private PromotionGroup promotionGroup;
@JsonProperty("priority")
private Float priority;
@JsonProperty("conditionString")
private String conditionString;
@JsonProperty("status")
private String status;
@JsonProperty("actions")
private List<Action> actions = null;
@JsonProperty("type")
private String type;
@JsonProperty("description")
private String description;
@JsonProperty("schedule")
private Schedule schedule;
@JsonProperty("descriptionEx")
private DescriptionEx descriptionEx;
@JsonProperty("termsEx")
private TermsEx termsEx;
@JsonProperty("message")
private Message message;
@JsonProperty("redemptionLimit")
private Long redemptionLimit;
@JsonProperty("perCustomerRedemptionLimit")
private Long perCustomerRedemptionLimit;
@JsonProperty("perMembershipRedemptionLimit")
private Long perMembershipRedemptionLimit;
@JsonProperty("perPrimaryHouseholdRedemptionLimit")
private Long perPrimaryHouseholdRedemptionLimit;
@JsonProperty("perAddOnHouseholdRedemptionLimit")
private Long perAddOnHouseholdRedemptionLimit;
@JsonProperty("perCustomerRedemptionExpirDays")
private Long perCustomerRedemptionExpirDays;
@JsonProperty("multiMatchLimit")
private Long multiMatchLimit;
@JsonProperty("promoMatchCount")
private Long promoMatchCount;
@JsonProperty("displayAtOrderLevel")
private Boolean displayAtOrderLevel;
@JsonProperty("autoApply")
private Boolean autoApply;
@JsonProperty("thresholdValue")
private Float thresholdValue;
@JsonProperty("vendorFundingPercent")
private Float vendorFundingPercent;
@JsonProperty("createdBy")
private String createdBy;
@JsonProperty("modifiedBy")
private String modifiedBy;
@JsonProperty("promotionNumber")
private Long promotionNumber;
@JsonProperty("eligiblityConditionString")
private String eligiblityConditionString;
@JsonProperty("multiMatchType")
private String multiMatchType;

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("extId")
public String getextId() {
return extId;
}

@JsonProperty("extId")
public void setextId(String extId) {
this.extId = extId;
}

@JsonProperty("created")
public String getCreated() {
return created;
}

@JsonProperty("created")
public void setCreated(String created) {
this.created = created;
}

@JsonProperty("lastModified")
public String getLastModified() {
return lastModified;
}

@JsonProperty("lastModified")
public void setLastModified(String lastModified) {
this.lastModified = lastModified;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("promotionGroup")
public PromotionGroup getPromotionGroup() {
return promotionGroup;
}

@JsonProperty("promotionGroup")
public void setPromotionGroup(PromotionGroup promotionGroup) {
this.promotionGroup = promotionGroup;
}

@JsonProperty("priority")
public Float getPriority() {
return priority;
}

@JsonProperty("priority")
public void setPriority(Float priority) {
this.priority = priority;
}

@JsonProperty("conditionString")
public String getConditionString() {
return conditionString;
}

@JsonProperty("conditionString")
public void setConditionString(String conditionString) {
this.conditionString = conditionString;
}

@JsonProperty("status")
public String getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(String status) {
this.status = status;
}

@JsonProperty("actions")
public List<Action> getActions() {
return actions;
}

@JsonProperty("actions")
public void setActions(List<Action> actions) {
this.actions = actions;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("schedule")
public Schedule getSchedule() {
return schedule;
}

@JsonProperty("schedule")
public void setSchedule(Schedule schedule) {
this.schedule = schedule;
}

@JsonProperty("descriptionEx")
public DescriptionEx getDescriptionEx() {
return descriptionEx;
}

@JsonProperty("descriptionEx")
public void setDescriptionEx(DescriptionEx descriptionEx) {
this.descriptionEx = descriptionEx;
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
public Long getRedemptionLimit() {
return redemptionLimit;
}

@JsonProperty("redemptionLimit")
public void setRedemptionLimit(Long redemptionLimit) {
this.redemptionLimit = redemptionLimit;
}

@JsonProperty("perCustomerRedemptionLimit")
public Long getPerCustomerRedemptionLimit() {
return perCustomerRedemptionLimit;
}

@JsonProperty("perCustomerRedemptionLimit")
public void setPerCustomerRedemptionLimit(Long perCustomerRedemptionLimit) {
this.perCustomerRedemptionLimit = perCustomerRedemptionLimit;
}

@JsonProperty("perMembershipRedemptionLimit")
public Long getPerMembershipRedemptionLimit() {
return perMembershipRedemptionLimit;
}

@JsonProperty("perMembershipRedemptionLimit")
public void setPerMembershipRedemptionLimit(Long perMembershipRedemptionLimit) {
this.perMembershipRedemptionLimit = perMembershipRedemptionLimit;
}

@JsonProperty("perPrimaryHouseholdRedemptionLimit")
public Long getPerPrimaryHouseholdRedemptionLimit() {
return perPrimaryHouseholdRedemptionLimit;
}

@JsonProperty("perPrimaryHouseholdRedemptionLimit")
public void setPerPrimaryHouseholdRedemptionLimit(Long perPrimaryHouseholdRedemptionLimit) {
this.perPrimaryHouseholdRedemptionLimit = perPrimaryHouseholdRedemptionLimit;
}

@JsonProperty("perAddOnHouseholdRedemptionLimit")
public Long getPerAddOnHouseholdRedemptionLimit() {
return perAddOnHouseholdRedemptionLimit;
}

@JsonProperty("perAddOnHouseholdRedemptionLimit")
public void setPerAddOnHouseholdRedemptionLimit(Long perAddOnHouseholdRedemptionLimit) {
this.perAddOnHouseholdRedemptionLimit = perAddOnHouseholdRedemptionLimit;
}

@JsonProperty("perCustomerRedemptionExpirDays")
public Long getPerCustomerRedemptionExpirDays() {
return perCustomerRedemptionExpirDays;
}

@JsonProperty("perCustomerRedemptionExpirDays")
public void setPerCustomerRedemptionExpirDays(Long perCustomerRedemptionExpirDays) {
this.perCustomerRedemptionExpirDays = perCustomerRedemptionExpirDays;
}

@JsonProperty("multiMatchLimit")
public Long getMultiMatchLimit() {
return multiMatchLimit;
}

@JsonProperty("multiMatchLimit")
public void setMultiMatchLimit(Long multiMatchLimit) {
this.multiMatchLimit = multiMatchLimit;
}

@JsonProperty("promoMatchCount")
public Long getPromoMatchCount() {
return promoMatchCount;
}

@JsonProperty("promoMatchCount")
public void setPromoMatchCount(Long promoMatchCount) {
this.promoMatchCount = promoMatchCount;
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
public Float getThresholdValue() {
return thresholdValue;
}

@JsonProperty("thresholdValue")
public void setThresholdValue(Float thresholdValue) {
this.thresholdValue = thresholdValue;
}

@JsonProperty("vendorFundingPercent")
public Float getVendorFundingPercent() {
return vendorFundingPercent;
}

@JsonProperty("vendorFundingPercent")
public void setVendorFundingPercent(Float vendorFundingPercent) {
this.vendorFundingPercent = vendorFundingPercent;
}

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

@JsonProperty("promotionNumber")
public Long getPromotionNumber() {
return promotionNumber;
}

@JsonProperty("promotionNumber")
public void setPromotionNumber(Long promotionNumber) {
this.promotionNumber = promotionNumber;
}

@JsonProperty("eligiblityConditionString")
public String getEligiblityConditionString() {
return eligiblityConditionString;
}

@JsonProperty("eligiblityConditionString")
public void setEligiblityConditionString(String eligiblityConditionString) {
this.eligiblityConditionString = eligiblityConditionString;
}

@JsonProperty("multiMatchType")
public String getMultiMatchType() {
return multiMatchType;
}

@JsonProperty("multiMatchType")
public void setMultiMatchType(String multiMatchType) {
this.multiMatchType = multiMatchType;
}

}

