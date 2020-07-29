package com.sams.promotions.reserveCollection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"lastUpdatedOn",
"complete",
"migrationUpdate"
})
public class AuditTrail {

@JsonProperty("lastUpdatedOn")
private String lastUpdatedOn;
@JsonProperty("complete")
private Boolean complete;
@JsonProperty("migrationUpdate")
private Boolean migrationUpdate;

@JsonProperty("lastUpdatedOn")
public String getLastUpdatedOn() {
return lastUpdatedOn;
}

@JsonProperty("lastUpdatedOn")
public void setLastUpdatedOn(String lastUpdatedOn) {
this.lastUpdatedOn = lastUpdatedOn;
}

@JsonProperty("complete")
public Boolean getComplete() {
return complete;
}

@JsonProperty("complete")
public void setComplete(Boolean complete) {
this.complete = complete;
}

@JsonProperty("migrationUpdate")
public Boolean getMigrationUpdate() {
return migrationUpdate;
}

@JsonProperty("migrationUpdate")
public void setMigrationUpdate(Boolean migrationUpdate) {
this.migrationUpdate = migrationUpdate;
}

}
