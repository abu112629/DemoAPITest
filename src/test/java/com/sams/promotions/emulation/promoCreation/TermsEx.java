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
"desktop",
"mweb",
"desktopContentType",
"mwebContentType",
"code"
})
public class TermsEx {

@JsonProperty("desktop")
private String desktop;
@JsonProperty("mweb")
private String mweb;
@JsonProperty("desktopContentType")
private String desktopContentType;
@JsonProperty("mwebContentType")
private String mwebContentType;
@JsonProperty("code")
private String code;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("desktop")
public String getDesktop() {
return desktop;
}

@JsonProperty("desktop")
public void setDesktop(String desktop) {
this.desktop = desktop;
}

@JsonProperty("mweb")
public String getMweb() {
return mweb;
}

@JsonProperty("mweb")
public void setMweb(String mweb) {
this.mweb = mweb;
}

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