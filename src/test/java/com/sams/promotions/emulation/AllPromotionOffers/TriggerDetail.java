package com.sams.promotions.emulation.AllPromotionOffers;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"triggerNumber",
"triggerStatusIndicator",
"triggerDescription",
"maxAssignQuantity",
"channelDetails",
"memberDetails",
"actionDetails",
"transactionDetails"
})
public class TriggerDetail {

@JsonProperty("triggerNumber")
private Long triggerNumber;
@JsonProperty("triggerStatusIndicator")
private String triggerStatusIndicator;
@JsonProperty("triggerDescription")
private String triggerDescription;
@JsonProperty("maxAssignQuantity")
private Long maxAssignQuantity;
@JsonProperty("channelDetails")
private List<ChannelDetail> channelDetails = null;
@JsonProperty("memberDetails")
private List<MemberDetail> memberDetails = null;
@JsonProperty("actionDetails")
private List<ActionDetail> actionDetails = null;
@JsonProperty("transactionDetails")
private TransactionDetails transactionDetails;

@JsonProperty("triggerNumber")
public Long getTriggerNumber() {
return triggerNumber;
}

@JsonProperty("triggerNumber")
public void setTriggerNumber(Long triggerNumber) {
this.triggerNumber = triggerNumber;
}

@JsonProperty("triggerStatusIndicator")
public String getTriggerStatusIndicator() {
return triggerStatusIndicator;
}

@JsonProperty("triggerStatusIndicator")
public void setTriggerStatusIndicator(String triggerStatusIndicator) {
this.triggerStatusIndicator = triggerStatusIndicator;
}

@JsonProperty("triggerDescription")
public String getTriggerDescription() {
return triggerDescription;
}

@JsonProperty("triggerDescription")
public void setTriggerDescription(String triggerDescription) {
this.triggerDescription = triggerDescription;
}

@JsonProperty("maxAssignQuantity")
public Long getMaxAssignQuantity() {
return maxAssignQuantity;
}

@JsonProperty("maxAssignQuantity")
public void setMaxAssignQuantity(Long maxAssignQuantity) {
this.maxAssignQuantity = maxAssignQuantity;
}

@JsonProperty("channelDetails")
public List<ChannelDetail> getChannelDetails() {
return channelDetails;
}

@JsonProperty("channelDetails")
public void setChannelDetails(List<ChannelDetail> channelDetails) {
this.channelDetails = channelDetails;
}

@JsonProperty("memberDetails")
public List<MemberDetail> getMemberDetails() {
return memberDetails;
}

@JsonProperty("memberDetails")
public void setMemberDetails(List<MemberDetail> memberDetails) {
this.memberDetails = memberDetails;
}

@JsonProperty("actionDetails")
public List<ActionDetail> getActionDetails() {
return actionDetails;
}

@JsonProperty("actionDetails")
public void setActionDetails(List<ActionDetail> actionDetails) {
this.actionDetails = actionDetails;
}

@JsonProperty("transactionDetails")
public TransactionDetails getTransactionDetails() {
return transactionDetails;
}

@JsonProperty("transactionDetails")
public void setTransactionDetails(TransactionDetails transactionDetails) {
this.transactionDetails = transactionDetails;
}

}

