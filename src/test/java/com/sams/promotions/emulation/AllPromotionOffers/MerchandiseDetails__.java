package com.sams.promotions.emulation.AllPromotionOffers;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"itemDetails"
})
public class MerchandiseDetails__ {

@JsonProperty("itemDetails")
private List<ItemDetail__> itemDetails = null;

@JsonProperty("itemDetails")
public List<ItemDetail__> getItemDetails() {
return itemDetails;
}

@JsonProperty("itemDetails")
public void setItemDetails(List<ItemDetail__> itemDetails) {
this.itemDetails = itemDetails;
}

}

