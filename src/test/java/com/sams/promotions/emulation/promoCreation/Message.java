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
"desktopContentType",
"mwebContentType",
"kioskContentType",
"code"
})
public class Message {

@JsonProperty("desktopContentType")
private String desktopContentType;
@JsonProperty("mwebContentType")
private String mwebContentType;
@JsonProperty("kioskContentType")
private String kioskContentType;
@JsonProperty("code")
private String code;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("desktopContentType")
public String getDesktopContentType() {
return desktopContentType;
}

@JsonProperty("desktopContentType")
public void setDesktopContentType(String desktopContentType) {
this.desktopContentType = desktopContentType;
}

@JsonProperty("mwebContentType")
public String getMwebContentType() {
return mwebContentType;
}

@JsonProperty("mwebContentType")
public void setMwebContentType(String mwebContentType) {
this.mwebContentType = mwebContentType;
}

@JsonProperty("kioskContentType")
public String getKioskContentType() {
return kioskContentType;
}

@JsonProperty("kioskContentType")
public void setKioskContentType(String kioskContentType) {
this.kioskContentType = kioskContentType;
}

@JsonProperty("code")
public String getCode() {
return code;
}

@JsonProperty("code")
public void setCode(String code) {
this.code = code;
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

