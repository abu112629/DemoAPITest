package com.sams.promotions.emulation.triggerCertRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"ActionCode",
"ActionDesc"
})
public class ActionCodeInfo {

@JsonProperty("ActionCode")
private Long actionCode;
@JsonProperty("ActionDesc")
private String actionDesc;

@JsonProperty("ActionCode")
public Long getActionCode() {
return actionCode;
}

@JsonProperty("ActionCode")
public void setActionCode(Long actionCode) {
this.actionCode = actionCode;
}

@JsonProperty("ActionDesc")
public String getActionDesc() {
return actionDesc;
}

@JsonProperty("ActionDesc")
public void setActionDesc(String actionDesc) {
this.actionDesc = actionDesc;
}

}

