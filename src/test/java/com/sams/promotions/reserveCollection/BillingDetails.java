package com.sams.promotions.reserveCollection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"fundingType",
"vendorFundingPercent"
})
public class BillingDetails {

@JsonProperty("fundingType")
private String fundingType;
@JsonProperty("vendorFundingPercent")
private Long vendorFundingPercent;

@JsonProperty("fundingType")
public String getFundingType() {
return fundingType;
}

@JsonProperty("fundingType")
public void setFundingType(String fundingType) {
this.fundingType = fundingType;
}

@JsonProperty("vendorFundingPercent")
public Long getVendorFundingPercent() {
return vendorFundingPercent;
}

@JsonProperty("vendorFundingPercent")
public void setVendorFundingPercent(Long vendorFundingPercent) {
this.vendorFundingPercent = vendorFundingPercent;
}

}

