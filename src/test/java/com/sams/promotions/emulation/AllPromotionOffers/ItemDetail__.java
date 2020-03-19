package com.sams.promotions.emulation.AllPromotionOffers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"itemNumber",
"itemTypeCode",
"itemTypeDescription",
"minimumPurchaseQuantity"
})
public class ItemDetail__ {

@JsonProperty("itemNumber")
private Long itemNumber;
@JsonProperty("itemTypeCode")
private Long itemTypeCode;
@JsonProperty("itemTypeDescription")
private String itemTypeDescription;
@JsonProperty("minimumPurchaseQuantity")
private Long minimumPurchaseQuantity;

@JsonProperty("itemNumber")
public Long getItemNumber() {
return itemNumber;
}

@JsonProperty("itemNumber")
public void setItemNumber(Long itemNumber) {
this.itemNumber = itemNumber;
}

@JsonProperty("itemTypeCode")
public Long getItemTypeCode() {
return itemTypeCode;
}

@JsonProperty("itemTypeCode")
public void setItemTypeCode(Long itemTypeCode) {
this.itemTypeCode = itemTypeCode;
}

@JsonProperty("itemTypeDescription")
public String getItemTypeDescription() {
return itemTypeDescription;
}

@JsonProperty("itemTypeDescription")
public void setItemTypeDescription(String itemTypeDescription) {
this.itemTypeDescription = itemTypeDescription;
}

@JsonProperty("minimumPurchaseQuantity")
public Long getMinimumPurchaseQuantity() {
return minimumPurchaseQuantity;
}

@JsonProperty("minimumPurchaseQuantity")
public void setMinimumPurchaseQuantity(Long minimumPurchaseQuantity) {
this.minimumPurchaseQuantity = minimumPurchaseQuantity;
}

}

