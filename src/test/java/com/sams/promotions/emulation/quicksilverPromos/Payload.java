package com.sams.promotions.emulation.quicksilverPromos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"items",
"total"
})
public class Payload {

@JsonProperty("items")
private List<Item> items = null;
@JsonProperty("total")
private Long total;

@JsonProperty("items")
public List<Item> getItems() {
return items;
}

@JsonProperty("items")
public void setItems(List<Item> items) {
this.items = items;
}

@JsonProperty("total")
public Long getTotal() {
return total;
}

@JsonProperty("total")
public void setTotal(Long total) {
this.total = total;
}

}

