package com.sams.promotions.emulation.quicksilverPromos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"code",
"desktop",
"mweb",
"desktopContentType",
"mwebContentType"
})
public class TermsEx {

@JsonProperty("id")
private String id;
@JsonProperty("code")
private String code;
@JsonProperty("desktop")
private String desktop;
@JsonProperty("mweb")
private String mweb;
@JsonProperty("desktopContentType")
private String desktopContentType;
@JsonProperty("mwebContentType")
private String mwebContentType;

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("code")
public String getCode() {
return code;
}

@JsonProperty("code")
public void setCode(String code) {
this.code = code;
}

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

}