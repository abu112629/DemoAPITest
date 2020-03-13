package com.sams.promotions.emulation.analyticOffers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sams.promotions.emulation.quicksilverPromos.Award;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"created",
"lastModified",
"actionType",
"award"
})
public class Action {

@JsonProperty("id")
private String id;
@JsonProperty("created")
private String created;
@JsonProperty("lastModified")
private String lastModified;
@JsonProperty("actionType")
private String actionType;
@JsonProperty("award")
private Award award;

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("created")
public String getCreated() {
return created;
}

@JsonProperty("created")
public void setCreated(String created) {
this.created = created;
}

@JsonProperty("lastModified")
public String getLastModified() {
return lastModified;
}

@JsonProperty("lastModified")
public void setLastModified(String lastModified) {
this.lastModified = lastModified;
}

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

}

