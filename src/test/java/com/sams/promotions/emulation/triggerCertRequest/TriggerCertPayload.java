package com.sams.promotions.emulation.triggerCertRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"MembershipNbr",
"CardholderNbr",
"RequestTs",
"ClubNbr",
"ActionInfo"
})
public class TriggerCertPayload {

@JsonProperty("MembershipNbr")
private Long membershipNbr;
@JsonProperty("CardholderNbr")
private Long cardholderNbr;
@JsonProperty("RequestTs")
private String requestTs;
@JsonProperty("ClubNbr")
private Long clubNbr;
@JsonProperty("ActionInfo")
private ActionInfo actionInfo;

@JsonProperty("MembershipNbr")
public Long getMembershipNbr() {
return membershipNbr;
}

@JsonProperty("MembershipNbr")
public void setMembershipNbr(Long membershipNbr) {
this.membershipNbr = membershipNbr;
}

@JsonProperty("CardholderNbr")
public Long getCardholderNbr() {
return cardholderNbr;
}

@JsonProperty("CardholderNbr")
public void setCardholderNbr(Long cardholderNbr) {
this.cardholderNbr = cardholderNbr;
}

@JsonProperty("RequestTs")
public String getRequestTs() {
return requestTs;
}

@JsonProperty("RequestTs")
public void setRequestTs(String requestTs) {
this.requestTs = requestTs;
}

@JsonProperty("ClubNbr")
public Long getClubNbr() {
return clubNbr;
}

@JsonProperty("ClubNbr")
public void setClubNbr(Long clubNbr) {
this.clubNbr = clubNbr;
}

@JsonProperty("ActionInfo")
public ActionInfo getActionInfo() {
return actionInfo;
}

@JsonProperty("ActionInfo")
public void setActionInfo(ActionInfo actionInfo) {
this.actionInfo = actionInfo;
}

}