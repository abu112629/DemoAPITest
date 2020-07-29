package com.sams.promotions.reserveCollection;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"currencyAmount",
"currencyUnit"
})
public class UnitDiscount_ {

@JsonProperty("currencyAmount")
private BigDecimal currencyAmount;

@JsonProperty("currencyUnit")
private String currencyUnit;

@JsonProperty("currencyAmount")
public BigDecimal getCurrencyAmount() {
return currencyAmount;
}

@JsonProperty("currencyAmount")
public void setCurrencyAmount(BigDecimal currencyAmount) {
this.currencyAmount = currencyAmount;
}

@JsonProperty("currencyUnit")
public String getCurrencyUnit() {
return currencyUnit;
}

@JsonProperty("currencyUnit")
public void setCurrencyUnit(String currencyUnit) {
this.currencyUnit = currencyUnit;
}

}

