package com.sams.promotions.emulation.triggerOffers;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"itemDetails"
})
public class MerchandiseDetails {

@JsonProperty("itemDetails")
private List<ItemDetails> itemDetails = null;

@JsonProperty("itemDetails")
public List<ItemDetails> getItemDetails() {
return itemDetails;
}

@JsonProperty("itemDetails")
public void setItemDetails(List<ItemDetails> itemDetails) {
this.itemDetails = itemDetails;
}

}

