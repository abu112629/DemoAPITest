package com.sams.promotions.emulation.promoCreation;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"actionType",
"award"
})
public class Action {

@JsonProperty("actionType")
private String actionType;
@JsonProperty("award")
private Award award;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("actionType")
public String getActionType() {
return actionType;
}

@JsonProperty("actionType")
public void setActionType(String actionType) {
this.actionType = actionType;
}

@JsonProperty("award")
public Award getAward() {
return award;
}

@JsonProperty("award")
public void setAward(Award award) {
this.award = award;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

