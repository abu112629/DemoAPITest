package com.sams.promotions.emulation.quicksilverPromos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"extId",
"created",
"lastModified",
"actionType",
"award"
})
public class Action_ {

@JsonProperty("id")
private String id;
@JsonProperty("extId")
private String extId;
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

@JsonProperty("extId")
public String getextId() {
return id;
}

@JsonProperty("extId")
public void setextId(String extId) {
this.extId = extId;
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

