package com.sams.promotions.reserveCollection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"unitPrice",
"extendedPrice",
"unitDiscount",
"extendedDiscount",
"netUnitPrice",
"netExtendedPrice"
})
public class PriceInfo {

@JsonProperty("unitPrice")
private UnitPrice unitPrice;
@JsonProperty("extendedPrice")
private ExtendedPrice extendedPrice;
@JsonProperty("unitDiscount")
private UnitDiscount unitDiscount;
@JsonProperty("extendedDiscount")
private ExtendedDiscount extendedDiscount;
@JsonProperty("netUnitPrice")
private NetUnitPrice netUnitPrice;
@JsonProperty("netExtendedPrice")
private NetExtendedPrice netExtendedPrice;

@JsonProperty("unitPrice")
public UnitPrice getUnitPrice() {
return unitPrice;
}

@JsonProperty("unitPrice")
public void setUnitPrice(UnitPrice unitPrice) {
this.unitPrice = unitPrice;
}

@JsonProperty("extendedPrice")
public ExtendedPrice getExtendedPrice() {
return extendedPrice;
}

@JsonProperty("extendedPrice")
public void setExtendedPrice(ExtendedPrice extendedPrice) {
this.extendedPrice = extendedPrice;
}

@JsonProperty("unitDiscount")
public UnitDiscount getUnitDiscount() {
return unitDiscount;
}

@JsonProperty("unitDiscount")
public void setUnitDiscount(UnitDiscount unitDiscount) {
this.unitDiscount = unitDiscount;
}

@JsonProperty("extendedDiscount")
public ExtendedDiscount getExtendedDiscount() {
return extendedDiscount;
}

@JsonProperty("extendedDiscount")
public void setExtendedDiscount(ExtendedDiscount extendedDiscount) {
this.extendedDiscount = extendedDiscount;
}

@JsonProperty("netUnitPrice")
public NetUnitPrice getNetUnitPrice() {
return netUnitPrice;
}

@JsonProperty("netUnitPrice")
public void setNetUnitPrice(NetUnitPrice netUnitPrice) {
this.netUnitPrice = netUnitPrice;
}

@JsonProperty("netExtendedPrice")
public NetExtendedPrice getNetExtendedPrice() {
return netExtendedPrice;
}

@JsonProperty("netExtendedPrice")
public void setNetExtendedPrice(NetExtendedPrice netExtendedPrice) {
this.netExtendedPrice = netExtendedPrice;
}

}

