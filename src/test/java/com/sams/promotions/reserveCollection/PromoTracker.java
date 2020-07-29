package com.sams.promotions.reserveCollection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"promotionId",
"startDate",
"endDate",
"promotionName",
"redemptionCount",
"promotionNumber"
})
public class PromoTracker {

@JsonProperty("promotionId")
private String promotionId;
@JsonProperty("startDate")
private String startDate;
@JsonProperty("endDate")
private String endDate;
@JsonProperty("promotionName")
private String promotionName;
@JsonProperty("redemptionCount")
private Long redemptionCount;
@JsonProperty("promotionNumber")
private Long promotionNumber;

@JsonProperty("promotionId")
public String getPromotionId() {
return promotionId;
}

@JsonProperty("promotionId")
public void setPromotionId(String promotionId) {
this.promotionId = promotionId;
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

@JsonProperty("promotionName")
public String getPromotionName() {
return promotionName;
}

@JsonProperty("promotionName")
public void setPromotionName(String promotionName) {
this.promotionName = promotionName;
}

@JsonProperty("redemptionCount")
public Long getRedemptionCount() {
return redemptionCount;
}

@JsonProperty("redemptionCount")
public void setRedemptionCount(Long redemptionCount) {
this.redemptionCount = redemptionCount;
}

@JsonProperty("promotionNumber")
public Long getPromotionNumber() {
return promotionNumber;
}

@JsonProperty("promotionNumber")
public void setPromotionNumber(Long promotionNumber) {
this.promotionNumber = promotionNumber;
}

}

