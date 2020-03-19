package com.sams.promotions.emulation.AllPromotionOffers;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"itemDetails"
})
public class MerchandiseDetails_ {

@JsonProperty("itemDetails")
private List<ItemDetail_> itemDetails = null;

@JsonProperty("itemDetails")
public List<ItemDetail_> getItemDetails() {
return itemDetails;
}

@JsonProperty("itemDetails")
public void setItemDetails(List<ItemDetail_> itemDetails) {
this.itemDetails = itemDetails;
}

}

