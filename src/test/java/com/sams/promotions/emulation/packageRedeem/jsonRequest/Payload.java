package com.sams.promotions.emulation.packageRedeem.jsonRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"memberLimit",
"lockOnFirstUse",
"couponGroup",
"assignDate",
"createDate",
"expiryDate",
"startDate",
"autoUse",
"memberId"
})
public class Payload {

@JsonProperty("memberLimit")
private Long memberLimit;
@JsonProperty("lockOnFirstUse")
private Boolean lockOnFirstUse;
@JsonProperty("couponGroup")
private String couponGroup;
@JsonProperty("assignDate")
private String assignDate;
@JsonProperty("createDate")
private String createDate;
@JsonProperty("expiryDate")
private String expiryDate;
@JsonProperty("startDate")
private String startDate;
@JsonProperty("autoUse")
private Boolean autoUse;
@JsonProperty("memberId")
private String memberId;

@JsonProperty("memberLimit")
public Long getMemberLimit() {
return memberLimit;
}

@JsonProperty("memberLimit")
public void setMemberLimit(Long memberLimit) {
this.memberLimit = memberLimit;
}

@JsonProperty("lockOnFirstUse")
public Boolean getLockOnFirstUse() {
return lockOnFirstUse;
}

@JsonProperty("lockOnFirstUse")
public void setLockOnFirstUse(Boolean lockOnFirstUse) {
this.lockOnFirstUse = lockOnFirstUse;
}

@JsonProperty("couponGroup")
public String getCouponGroup() {
return couponGroup;
}

@JsonProperty("couponGroup")
public void setCouponGroup(String couponGroup) {
this.couponGroup = couponGroup;
}

@JsonProperty("assignDate")
public String getAssignDate() {
return assignDate;
}

@JsonProperty("assignDate")
public void setAssignDate(String assignDate) {
this.assignDate = assignDate;
}

@JsonProperty("createDate")
public String getCreateDate() {
return createDate;
}

@JsonProperty("createDate")
public void setCreateDate(String createDate) {
this.createDate = createDate;
}

@JsonProperty("expiryDate")
public String getExpiryDate() {
return expiryDate;
}

@JsonProperty("expiryDate")
public void setExpiryDate(String expiryDate) {
this.expiryDate = expiryDate;
}

@JsonProperty("startDate")
public String getStartDate() {
return startDate;
}

@JsonProperty("startDate")
public void setStartDate(String startDate) {
this.startDate = startDate;
}

@JsonProperty("autoUse")
public Boolean getAutoUse() {
return autoUse;
}

@JsonProperty("autoUse")
public void setAutoUse(Boolean autoUse) {
this.autoUse = autoUse;
}

@JsonProperty("memberId")
public String getMemberId() {
return memberId;
}

@JsonProperty("memberId")
public void setMemberId(String memberId) {
this.memberId = memberId;
}

}