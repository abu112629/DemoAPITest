package com.sams.promotions.emulation.triggerOffers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"channelProductTypeCode",
"channelProductTypeCodeDescription"
})
public class ChannelProductDetail {

@JsonProperty("channelProductTypeCode")
private Long channelProductTypeCode;
@JsonProperty("channelProductTypeCodeDescription")
private String channelProductTypeCodeDescription;

@JsonProperty("channelProductTypeCode")
public Long getChannelProductTypeCode() {
return channelProductTypeCode;
}

@JsonProperty("channelProductTypeCode")
public void setChannelProductTypeCode(Long channelProductTypeCode) {
this.channelProductTypeCode = channelProductTypeCode;
}

@JsonProperty("channelProductTypeCodeDescription")
public String getChannelProductTypeCodeDescription() {
return channelProductTypeCodeDescription;
}

@JsonProperty("channelProductTypeCodeDescription")
public void setChannelProductTypeCodeDescription(String channelProductTypeCodeDescription) {
this.channelProductTypeCodeDescription = channelProductTypeCodeDescription;
}

}

