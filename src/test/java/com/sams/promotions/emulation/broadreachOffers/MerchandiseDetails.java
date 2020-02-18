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
"itemDetails"
})
public class MerchandiseDetails {

@JsonProperty("itemDetails")
private List<ItemDetail> itemDetails = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("itemDetails")
public List<ItemDetail> getItemDetails() {
return itemDetails;
}

@JsonProperty("itemDetails")
public void setItemDetails(List<ItemDetail> itemDetails) {
this.itemDetails = itemDetails;
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

