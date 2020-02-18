package com.sams.promotions.emulation.broadreachOffers;

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
"broadReachOffers"
})
public class MetaDataResponse {

@JsonProperty("broadReachOffers")
private List<BroadReachOffer> broadReachOffers = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("broadReachOffers")
public List<BroadReachOffer> getBroadReachOffers() {
return broadReachOffers;
}

@JsonProperty("broadReachOffers")
public void setBroadReachOffers(List<BroadReachOffer> broadReachOffers) {
this.broadReachOffers = broadReachOffers;
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