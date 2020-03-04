package com.sams.promotions.emulation.triggerOffers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"offerMerchTypeCode",
"offerTypeCode",
"minimumBasketAmount",
"triggerMerchandiseDetails"
})
public class TransactionDetails {

@JsonProperty("offerMerchTypeCode")
private Long offerMerchTypeCode;
@JsonProperty("offerTypeCode")
private Long offerTypeCode;
@JsonProperty("minimumBasketAmount")
private Float minimumBasketAmount;
@JsonProperty("triggerMerchandiseDetails")
private TriggerMerchandiseDetails triggerMerchandiseDetails;

@JsonProperty("offerMerchTypeCode")
public Long getOfferMerchTypeCode() {
return offerMerchTypeCode;
}

@JsonProperty("offerMerchTypeCode")
public void setOfferMerchTypeCode(Long offerMerchTypeCode) {
this.offerMerchTypeCode = offerMerchTypeCode;
}

@JsonProperty("offerTypeCode")
public Long getOfferTypeCode() {
return offerTypeCode;
}

@JsonProperty("offerTypeCode")
public void setOfferTypeCode(Long offerTypeCode) {
this.offerTypeCode = offerTypeCode;
}

@JsonProperty("minimumBasketAmount")
public Float getMinimumBasketAmount() {
return minimumBasketAmount;
}

@JsonProperty("minimumBasketAmount")
public void setMinimumBasketAmount(Float minimumBasketAmount) {
this.minimumBasketAmount = minimumBasketAmount;
}

@JsonProperty("triggerMerchandiseDetails")
public TriggerMerchandiseDetails getTriggerMerchandiseDetails() {
return triggerMerchandiseDetails;
}

@JsonProperty("triggerMerchandiseDetails")
public void setTriggerMerchandiseDetails(TriggerMerchandiseDetails triggerMerchandiseDetails) {
this.triggerMerchandiseDetails = triggerMerchandiseDetails;
}

}

