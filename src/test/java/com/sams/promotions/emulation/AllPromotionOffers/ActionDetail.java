package com.sams.promotions.emulation.AllPromotionOffers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"actionCode",
"actionCodeDescription"
})
public class ActionDetail {

@JsonProperty("actionCode")
private Long actionCode;
@JsonProperty("actionCodeDescription")
private String actionCodeDescription;

@JsonProperty("actionCode")
public Long getActionCode() {
return actionCode;
}

@JsonProperty("actionCode")
public void setActionCode(Long actionCode) {
this.actionCode = actionCode;
}

@JsonProperty("actionCodeDescription")
public String getActionCodeDescription() {
return actionCodeDescription;
}

@JsonProperty("actionCodeDescription")
public void setActionCodeDescription(String actionCodeDescription) {
this.actionCodeDescription = actionCodeDescription;
}

}

