package com.sams.promotions.emulation.triggerRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"membershipId",
"clubId"
})
public class EventAttributes {

@JsonProperty("membershipId")
private String membershipId;
@JsonProperty("clubId")
private String clubId;

@JsonProperty("membershipId")
public String getMembershipId() {
return membershipId;
}

@JsonProperty("membershipId")
public void setMembershipId(String membershipId) {
this.membershipId = membershipId;
}

@JsonProperty("clubId")
public String getClubId() {
return clubId;
}

@JsonProperty("clubId")
public void setClubId(String clubId) {
this.clubId = clubId;
}

}

