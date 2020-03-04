package com.sams.promotions.emulation.triggerOffers;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"triggerOffers"
})
public class TriggerOffer {

@JsonProperty("triggerOffers")
private List<TriggerOffer_> triggerOffers = null;

@JsonProperty("triggerOffers")
public List<TriggerOffer_> getTriggerOffers() {
return triggerOffers;
}

@JsonProperty("triggerOffers")
public void setTriggerOffers(List<TriggerOffer_> triggerOffers) {
this.triggerOffers = triggerOffers;
}

}

