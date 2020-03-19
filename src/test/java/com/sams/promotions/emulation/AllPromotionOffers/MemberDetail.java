package com.sams.promotions.emulation.AllPromotionOffers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"categoryCode",
"categoryCodeDescription",
"memberStatusCode",
"memberStatusCodeDescription",
"cardholderType",
"cardholderTypeDescription",
"cardholderStatus",
"cardholderStatusDescription",
"maintenanceIndicator",
"maintenanceIndicatorDescription",
"premierStatusCode",
"premierStatusCodeDescription"
})
public class MemberDetail {

@JsonProperty("categoryCode")
private Long categoryCode;
@JsonProperty("categoryCodeDescription")
private String categoryCodeDescription;
@JsonProperty("memberStatusCode")
private String memberStatusCode;
@JsonProperty("memberStatusCodeDescription")
private String memberStatusCodeDescription;
@JsonProperty("cardholderType")
private String cardholderType;
@JsonProperty("cardholderTypeDescription")
private String cardholderTypeDescription;
@JsonProperty("cardholderStatus")
private String cardholderStatus;
@JsonProperty("cardholderStatusDescription")
private String cardholderStatusDescription;
@JsonProperty("maintenanceIndicator")
private String maintenanceIndicator;
@JsonProperty("maintenanceIndicatorDescription")
private String maintenanceIndicatorDescription;
@JsonProperty("premierStatusCode")
private String premierStatusCode;
@JsonProperty("premierStatusCodeDescription")
private String premierStatusCodeDescription;

@JsonProperty("categoryCode")
public Long getCategoryCode() {
return categoryCode;
}

@JsonProperty("categoryCode")
public void setCategoryCode(Long categoryCode) {
this.categoryCode = categoryCode;
}

@JsonProperty("categoryCodeDescription")
public String getCategoryCodeDescription() {
return categoryCodeDescription;
}

@JsonProperty("categoryCodeDescription")
public void setCategoryCodeDescription(String categoryCodeDescription) {
this.categoryCodeDescription = categoryCodeDescription;
}

@JsonProperty("memberStatusCode")
public String getMemberStatusCode() {
return memberStatusCode;
}

@JsonProperty("memberStatusCode")
public void setMemberStatusCode(String memberStatusCode) {
this.memberStatusCode = memberStatusCode;
}

@JsonProperty("memberStatusCodeDescription")
public String getMemberStatusCodeDescription() {
return memberStatusCodeDescription;
}

@JsonProperty("memberStatusCodeDescription")
public void setMemberStatusCodeDescription(String memberStatusCodeDescription) {
this.memberStatusCodeDescription = memberStatusCodeDescription;
}

@JsonProperty("cardholderType")
public String getCardholderType() {
return cardholderType;
}

@JsonProperty("cardholderType")
public void setCardholderType(String cardholderType) {
this.cardholderType = cardholderType;
}

@JsonProperty("cardholderTypeDescription")
public String getCardholderTypeDescription() {
return cardholderTypeDescription;
}

@JsonProperty("cardholderTypeDescription")
public void setCardholderTypeDescription(String cardholderTypeDescription) {
this.cardholderTypeDescription = cardholderTypeDescription;
}

@JsonProperty("cardholderStatus")
public String getCardholderStatus() {
return cardholderStatus;
}

@JsonProperty("cardholderStatus")
public void setCardholderStatus(String cardholderStatus) {
this.cardholderStatus = cardholderStatus;
}

@JsonProperty("cardholderStatusDescription")
public String getCardholderStatusDescription() {
return cardholderStatusDescription;
}

@JsonProperty("cardholderStatusDescription")
public void setCardholderStatusDescription(String cardholderStatusDescription) {
this.cardholderStatusDescription = cardholderStatusDescription;
}

@JsonProperty("maintenanceIndicator")
public String getMaintenanceIndicator() {
return maintenanceIndicator;
}

@JsonProperty("maintenanceIndicator")
public void setMaintenanceIndicator(String maintenanceIndicator) {
this.maintenanceIndicator = maintenanceIndicator;
}

@JsonProperty("maintenanceIndicatorDescription")
public String getMaintenanceIndicatorDescription() {
return maintenanceIndicatorDescription;
}

@JsonProperty("maintenanceIndicatorDescription")
public void setMaintenanceIndicatorDescription(String maintenanceIndicatorDescription) {
this.maintenanceIndicatorDescription = maintenanceIndicatorDescription;
}

@JsonProperty("premierStatusCode")
public String getPremierStatusCode() {
return premierStatusCode;
}

@JsonProperty("premierStatusCode")
public void setPremierStatusCode(String premierStatusCode) {
this.premierStatusCode = premierStatusCode;
}

@JsonProperty("premierStatusCodeDescription")
public String getPremierStatusCodeDescription() {
return premierStatusCodeDescription;
}

@JsonProperty("premierStatusCodeDescription")
public void setPremierStatusCodeDescription(String premierStatusCodeDescription) {
this.premierStatusCodeDescription = premierStatusCodeDescription;
}

}

