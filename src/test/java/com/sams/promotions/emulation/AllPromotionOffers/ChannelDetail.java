package com.sams.promotions.emulation.AllPromotionOffers;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"channelTypeCode",
"channelTypeDescription",
"channelProductDetails"
})
public class ChannelDetail {

@JsonProperty("channelTypeCode")
private Long channelTypeCode;
@JsonProperty("channelTypeDescription")
private String channelTypeDescription;
@JsonProperty("channelProductDetails")
private List<ChannelProductDetail> channelProductDetails = null;

@JsonProperty("channelTypeCode")
public Long getChannelTypeCode() {
return channelTypeCode;
}

@JsonProperty("channelTypeCode")
public void setChannelTypeCode(Long channelTypeCode) {
this.channelTypeCode = channelTypeCode;
}

@JsonProperty("channelTypeDescription")
public String getChannelTypeDescription() {
return channelTypeDescription;
}

@JsonProperty("channelTypeDescription")
public void setChannelTypeDescription(String channelTypeDescription) {
this.channelTypeDescription = channelTypeDescription;
}

@JsonProperty("channelProductDetails")
public List<ChannelProductDetail> getChannelProductDetails() {
return channelProductDetails;
}

@JsonProperty("channelProductDetails")
public void setChannelProductDetails(List<ChannelProductDetail> channelProductDetails) {
this.channelProductDetails = channelProductDetails;
}

}

