package com.sams.promotions.emulation.triggerCertRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"ActionCodeInfo"
})
public class ActionInfo {

@JsonProperty("ActionCodeInfo")
private ActionCodeInfo actionCodeInfo;

@JsonProperty("ActionCodeInfo")
public ActionCodeInfo getActionCodeInfo() {
return actionCodeInfo;
}

@JsonProperty("ActionCodeInfo")
public void setActionCodeInfo(ActionCodeInfo actionCodeInfo) {
this.actionCodeInfo = actionCodeInfo;
}

}

