package com.sams.promotions.reserveCollection;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
"registerNbr",
"transactionNbr",
"status",
"reserveOrderNumber",
"orderNumber",
"membershipId",
"channel",
"clubId",
"redemptionDate",
"promoTrackers",
"source",
"items",
"auditTrail",
"id",
"partitionKey",
"_rid",
"_self",
"_etag",
"_attachments",
"_ts"
})
public class ReserveForwardSyncDocument {

@JsonProperty("registerNbr")
private String registerNbr;
@JsonProperty("transactionNbr")
private String transactionNbr;
@JsonProperty("status")
private String status;
@JsonProperty("reserveOrderNumber")
private String reserveOrderNumber;
@JsonProperty("orderNumber")
private String orderNumber;
@JsonProperty("membershipId")
private String membershipId;
@JsonProperty("channel")
private String channel;
@JsonProperty("clubId")
private String clubId;
@JsonProperty("redemptionDate")
private String redemptionDate;
@JsonProperty("promoTrackers")
private List<PromoTracker> promoTrackers = null;
@JsonProperty("source")
private String source;
@JsonProperty("items")
private List<Item> items = null;
@JsonProperty("auditTrail")
private AuditTrail auditTrail;
@JsonProperty("id")
private String id;
@JsonProperty("partitionKey")
private String partitionKey;
@JsonProperty("_rid")
private String rid;
@JsonProperty("_self")
private String self;
@JsonProperty("_etag")
private String etag;
@JsonProperty("_attachments")
private String attachments;
@JsonProperty("_ts")
private Long ts;

@JsonProperty("registerNbr")
public String getRegisterNbr() {
return registerNbr;
}

@JsonProperty("registerNbr")
public void setRegisterNbr(String registerNbr) {
this.registerNbr = registerNbr;
}

@JsonProperty("transactionNbr")
public String getTransactionNbr() {
return transactionNbr;
}

@JsonProperty("transactionNbr")
public void setTransactionNbr(String transactionNbr) {
this.transactionNbr = transactionNbr;
}

@JsonProperty("status")
public String getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(String status) {
this.status = status;
}

@JsonProperty("reserveOrderNumber")
public String getReserveOrderNumber() {
return reserveOrderNumber;
}

@JsonProperty("reserveOrderNumber")
public void setReserveOrderNumber(String reserveOrderNumber) {
this.reserveOrderNumber = reserveOrderNumber;
}

@JsonProperty("orderNumber")
public String getOrderNumber() {
return orderNumber;
}

@JsonProperty("orderNumber")
public void setOrderNumber(String orderNumber) {
this.orderNumber = orderNumber;
}

@JsonProperty("membershipId")
public String getMembershipId() {
return membershipId;
}

@JsonProperty("membershipId")
public void setMembershipId(String membershipId) {
this.membershipId = membershipId;
}

@JsonProperty("channel")
public String getChannel() {
return channel;
}

@JsonProperty("channel")
public void setChannel(String channel) {
this.channel = channel;
}

@JsonProperty("clubId")
public String getClubId() {
return clubId;
}

@JsonProperty("clubId")
public void setClubId(String clubId) {
this.clubId = clubId;
}

@JsonProperty("redemptionDate")
public String getRedemptionDate() {
return redemptionDate;
}

@JsonProperty("redemptionDate")
public void setRedemptionDate(String redemptionDate) {
this.redemptionDate = redemptionDate;
}

@JsonProperty("promoTrackers")
public List<PromoTracker> getPromoTrackers() {
return promoTrackers;
}

@JsonProperty("promoTrackers")
public void setPromoTrackers(List<PromoTracker> promoTrackers) {
this.promoTrackers = promoTrackers;
}

@JsonProperty("source")
public String getSource() {
return source;
}

@JsonProperty("source")
public void setSource(String source) {
this.source = source;
}

@JsonProperty("items")
public List<Item> getItems() {
return items;
}

@JsonProperty("items")
public void setItems(List<Item> items) {
this.items = items;
}

@JsonProperty("auditTrail")
public AuditTrail getAuditTrail() {
return auditTrail;
}

@JsonProperty("auditTrail")
public void setAuditTrail(AuditTrail auditTrail) {
this.auditTrail = auditTrail;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("partitionKey")
public String getPartitionKey() {
return partitionKey;
}

@JsonProperty("partitionKey")
public void setPartitionKey(String partitionKey) {
this.partitionKey = partitionKey;
}

@JsonProperty("_rid")
public String getRid() {
return rid;
}

@JsonProperty("_rid")
public void setRid(String rid) {
this.rid = rid;
}

@JsonProperty("_self")
public String getSelf() {
return self;
}

@JsonProperty("_self")
public void setSelf(String self) {
this.self = self;
}

@JsonProperty("_etag")
public String getEtag() {
return etag;
}

@JsonProperty("_etag")
public void setEtag(String etag) {
this.etag = etag;
}

@JsonProperty("_attachments")
public String getAttachments() {
return attachments;
}

@JsonProperty("_attachments")
public void setAttachments(String attachments) {
this.attachments = attachments;
}

@JsonProperty("_ts")
public Long getTs() {
return ts;
}

@JsonProperty("_ts")
public void setTs(Long ts) {
this.ts = ts;
}

}

