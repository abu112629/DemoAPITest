package com.sams.promotions.emulation.quicksilverPromos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"extId"	
})
public class DescriptionEx {

@JsonProperty("id")
private String id;

@JsonProperty("extId")
private String extId;

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("extId")
public String getExtId() {
return extId;
}

@JsonProperty("extId")
public void setExtId(String extId) {
this.extId = extId;
}

}

