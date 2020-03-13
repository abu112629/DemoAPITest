package com.sams.promotions.emulation.quicksilverPromos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"name",
"description",
"rank",
"maxAwardCount",
"created",
"lastModified"
})
public class PromotionGroup {

@JsonProperty("id")
private String id;
@JsonProperty("name")
private String name;
@JsonProperty("description")
private String description;
@JsonProperty("rank")
private Float rank;
@JsonProperty("maxAwardCount")
private Long maxAwardCount;
@JsonProperty("created")
private String created;
@JsonProperty("lastModified")
private String lastModified;

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("rank")
public Float getRank() {
return rank;
}

@JsonProperty("rank")
public void setRank(Float rank) {
this.rank = rank;
}

@JsonProperty("maxAwardCount")
public Long getMaxAwardCount() {
return maxAwardCount;
}

@JsonProperty("maxAwardCount")
public void setMaxAwardCount(Long maxAwardCount) {
this.maxAwardCount = maxAwardCount;
}

@JsonProperty("created")
public String getCreated() {
return created;
}

@JsonProperty("created")
public void setCreated(String created) {
this.created = created;
}

@JsonProperty("lastModified")
public String getLastModified() {
return lastModified;
}

@JsonProperty("lastModified")
public void setLastModified(String lastModified) {
this.lastModified = lastModified;
}

}

