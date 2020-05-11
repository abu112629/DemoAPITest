package com.sams.promotions.emulation.quicksilverPromos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"extId",
"code",
"desktop",
"mweb",
"kiosk",
"desktopContentType",
"mwebContentType",
"kioskContentType"
})
public class Message {

@JsonProperty("id")
private String id;
@JsonProperty("extId")
private String extId;
@JsonProperty("code")
private String code;
@JsonProperty("desktop")
private String desktop;
@JsonProperty("mweb")
private String mweb;
@JsonProperty("kiosk")
private String kiosk;
@JsonProperty("desktopContentType")
private String desktopContentType;
@JsonProperty("mwebContentType")
private String mwebContentType;
@JsonProperty("kioskContentType")
private String kioskContentType;

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
return extId;
}

@JsonProperty("extId")
public void setextId(String extId) {
this.extId = extId;
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

@JsonProperty("kiosk")
public String getKiosk() {
return kiosk;
}

@JsonProperty("kiosk")
public void setKiosk(String kiosk) {
this.kiosk = kiosk;
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

@JsonProperty("kioskContentType")
public String getKioskContentType() {
return kioskContentType;
}

@JsonProperty("kioskContentType")
public void setKioskContentType(String kioskContentType) {
this.kioskContentType = kioskContentType;
}

}

