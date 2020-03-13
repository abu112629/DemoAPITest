package com.sams.promotions.emulation.analyticOffers;

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
private List<AnalyticItemDetail> itemDetails = null;

@JsonProperty("itemDetails")
public List<AnalyticItemDetail> getItemDetails() {
return itemDetails;
}

@JsonProperty("itemDetails")
public void setItemDetails(List<AnalyticItemDetail> itemDetails) {
this.itemDetails = itemDetails;
}

}