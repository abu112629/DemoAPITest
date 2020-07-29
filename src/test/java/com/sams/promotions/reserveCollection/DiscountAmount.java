package com.sams.promotions.reserveCollection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"unitPriceDiscount",
"unitShipPriceDiscount",
"unitSurchargeDiscount",
"unitDiscount"
})
public class DiscountAmount {

@JsonProperty("unitPriceDiscount")
private UnitPriceDiscount unitPriceDiscount;
@JsonProperty("unitShipPriceDiscount")
private UnitShipPriceDiscount unitShipPriceDiscount;
@JsonProperty("unitSurchargeDiscount")
private UnitSurchargeDiscount unitSurchargeDiscount;
@JsonProperty("unitDiscount")
private UnitDiscount_ unitDiscount;

@JsonProperty("unitPriceDiscount")
public UnitPriceDiscount getUnitPriceDiscount() {
return unitPriceDiscount;
}

@JsonProperty("unitPriceDiscount")
public void setUnitPriceDiscount(UnitPriceDiscount unitPriceDiscount) {
this.unitPriceDiscount = unitPriceDiscount;
}

@JsonProperty("unitShipPriceDiscount")
public UnitShipPriceDiscount getUnitShipPriceDiscount() {
return unitShipPriceDiscount;
}

@JsonProperty("unitShipPriceDiscount")
public void setUnitShipPriceDiscount(UnitShipPriceDiscount unitShipPriceDiscount) {
this.unitShipPriceDiscount = unitShipPriceDiscount;
}

@JsonProperty("unitSurchargeDiscount")
public UnitSurchargeDiscount getUnitSurchargeDiscount() {
return unitSurchargeDiscount;
}

@JsonProperty("unitSurchargeDiscount")
public void setUnitSurchargeDiscount(UnitSurchargeDiscount unitSurchargeDiscount) {
this.unitSurchargeDiscount = unitSurchargeDiscount;
}

@JsonProperty("unitDiscount")
public UnitDiscount_ getUnitDiscount() {
return unitDiscount;
}

@JsonProperty("unitDiscount")
public void setUnitDiscount(UnitDiscount_ unitDiscount) {
this.unitDiscount = unitDiscount;
}

}

