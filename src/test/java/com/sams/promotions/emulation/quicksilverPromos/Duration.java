package com.sams.promotions.emulation.quicksilverPromos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"period",
"periodUnit"
})
public class Duration {

@JsonProperty("period")
private Long period;
@JsonProperty("periodUnit")
private String periodUnit;

@JsonProperty("period")
public Long getPeriod() {
return period;
}

@JsonProperty("period")
public void setPeriod(Long period) {
this.period = period;
}

@JsonProperty("periodUnit")
public String getPeriodUnit() {
return periodUnit;
}

@JsonProperty("periodUnit")
public void setPeriodUnit(String periodUnit) {
this.periodUnit = periodUnit;
}

}

