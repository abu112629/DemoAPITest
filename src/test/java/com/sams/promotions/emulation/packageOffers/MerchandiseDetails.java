package com.sams.promotions.emulation.packageOffers;

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
private List<PackageItemDetail> itemDetails = null;

@JsonProperty("itemDetails")
public List<PackageItemDetail> getItemDetails() {
return itemDetails;
}

@JsonProperty("itemDetails")
public void setItemDetails(List<PackageItemDetail> itemDetails) {
this.itemDetails = itemDetails;
}

}

