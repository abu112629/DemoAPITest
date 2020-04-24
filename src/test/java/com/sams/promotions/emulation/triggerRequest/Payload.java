package com.sams.promotions.emulation.triggerRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"eventId",
"deviceType",
"requestTimestamp",
"evaluateInstantSavings",
"eventAttributes"
})
public class Payload {

@JsonProperty("eventId")
private String eventId;
@JsonProperty("deviceType")
private String deviceType;
@JsonProperty("requestTimestamp")
private String requestTimestamp;
@JsonProperty("evaluateInstantSavings")
private String evaluateInstantSavings;
@JsonProperty("eventAttributes")
private EventAttributes eventAttributes;

@JsonProperty("eventId")
public String getEventId() {
return eventId;
}

@JsonProperty("eventId")
public void setEventId(String eventId) {
this.eventId = eventId;
}

@JsonProperty("deviceType")
public String getDeviceType() {
return deviceType;
}

@JsonProperty("deviceType")
public void setDeviceType(String deviceType) {
this.deviceType = deviceType;
}

@JsonProperty("requestTimestamp")
public String getRequestTimestamp() {
return requestTimestamp;
}

@JsonProperty("requestTimestamp")
public void setRequestTimestamp(String requestTimestamp) {
this.requestTimestamp = requestTimestamp;
}

@JsonProperty("evaluateInstantSavings")
public String getEvaluateInstantSavings() {
return evaluateInstantSavings;
}

@JsonProperty("evaluateInstantSavings")
public void setEvaluateInstantSavings(String evaluateInstantSavings) {
this.evaluateInstantSavings = evaluateInstantSavings;
}

@JsonProperty("eventAttributes")
public EventAttributes getEventAttributes() {
return eventAttributes;
}

@JsonProperty("eventAttributes")
public void setEventAttributes(EventAttributes eventAttributes) {
this.eventAttributes = eventAttributes;
}

}

