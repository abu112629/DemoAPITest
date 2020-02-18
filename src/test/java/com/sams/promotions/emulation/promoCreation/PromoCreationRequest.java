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
"header",
"payload"
})
public class PromoCreationRequest {

@JsonProperty("header")
private Header header;
@JsonProperty("payload")
private Payload payload;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("header")
public Header getHeader() {
return header;
}

@JsonProperty("header")
public void setHeader(Header header) {
this.header = header;
}

@JsonProperty("payload")
public Payload getPayload() {
return payload;
}

@JsonProperty("payload")
public void setPayload(Payload payload) {
this.payload = payload;
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

