package com.sams.promotions.emulation.AllPromotionOffers;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"analyticOffers",
"broadReachOffers",
"packageOffers",
"triggerOffers"
})
public class PromotionMetaDataAll {

@JsonProperty("analyticOffers")
private List<AnalyticOffer> analyticOffers = null;
@JsonProperty("broadReachOffers")
private List<BroadReachOffer> broadReachOffers = null;
@JsonProperty("packageOffers")
private List<PackageOffer> packageOffers = null;
@JsonProperty("triggerOffers")
private List<TriggerOffer> triggerOffers = null;

@JsonProperty("analyticOffers")
public List<AnalyticOffer> getAnalyticOffers() {
return analyticOffers;
}

@JsonProperty("analyticOffers")
public void setAnalyticOffers(List<AnalyticOffer> analyticOffers) {
this.analyticOffers = analyticOffers;
}

@JsonProperty("broadReachOffers")
public List<BroadReachOffer> getBroadReachOffers() {
return broadReachOffers;
}

@JsonProperty("broadReachOffers")
public void setBroadReachOffers(List<BroadReachOffer> broadReachOffers) {
this.broadReachOffers = broadReachOffers;
}

@JsonProperty("packageOffers")
public List<PackageOffer> getPackageOffers() {
return packageOffers;
}

@JsonProperty("packageOffers")
public void setPackageOffers(List<PackageOffer> packageOffers) {
this.packageOffers = packageOffers;
}

@JsonProperty("triggerOffers")
public List<TriggerOffer> getTriggerOffers() {
return triggerOffers;
}

@JsonProperty("triggerOffers")
public void setTriggerOffers(List<TriggerOffer> triggerOffers) {
this.triggerOffers = triggerOffers;
}

}

