package com.sams.promotions.emulation.packageRedeem.jsonRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"payload"
})
public class CouponSingleUserCoupon {

@JsonProperty("payload")
private Payload payload;

@JsonProperty("payload")
public Payload getPayload() {
return payload;
}

@JsonProperty("payload")
public void setPayload(Payload payload) {
this.payload = payload;
}

}

