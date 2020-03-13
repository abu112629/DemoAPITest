package com.sams.promotions.emulation.packageOffers;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"packageOffers"
})
public class PackageOffers {

@JsonProperty("packageOffers")
private List<PackageOffer> packageOffers = null;

@JsonProperty("packageOffers")
public List<PackageOffer> getPackageOffers() {
return packageOffers;
}

@JsonProperty("packageOffers")
public void setPackageOffers(List<PackageOffer> packageOffers) {
this.packageOffers = packageOffers;
}

}