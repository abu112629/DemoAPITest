package com.sams.promotions.reserveCollection;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"category",
"subCategory",
"orderedQuantity",
"priceInfo",
"itemNumber",
"itemUPCNumber",
"vendorNbr",
"instantSavingsItem",
"discountInfo"
})
public class Item {

@JsonProperty("category")
private String category;
@JsonProperty("subCategory")
private String subCategory;
@JsonProperty("orderedQuantity")
private Long orderedQuantity;
@JsonProperty("priceInfo")
private PriceInfo priceInfo;
@JsonProperty("itemNumber")
private String itemNumber;
@JsonProperty("itemUPCNumber")
private String itemUPCNumber;
@JsonProperty("vendorNbr")
private String vendorNbr;
@JsonProperty("instantSavingsItem")
private Boolean instantSavingsItem;
@JsonProperty("discountInfo")
private List<DiscountInfo> discountInfo = null;

@JsonProperty("category")
public String getCategory() {
return category;
}

@JsonProperty("category")
public void setCategory(String category) {
this.category = category;
}

@JsonProperty("subCategory")
public String getSubCategory() {
return subCategory;
}

@JsonProperty("subCategory")
public void setSubCategory(String subCategory) {
this.subCategory = subCategory;
}

@JsonProperty("orderedQuantity")
public Long getOrderedQuantity() {
return orderedQuantity;
}

@JsonProperty("orderedQuantity")
public void setOrderedQuantity(Long orderedQuantity) {
this.orderedQuantity = orderedQuantity;
}

@JsonProperty("priceInfo")
public PriceInfo getPriceInfo() {
return priceInfo;
}

@JsonProperty("priceInfo")
public void setPriceInfo(PriceInfo priceInfo) {
this.priceInfo = priceInfo;
}

@JsonProperty("itemNumber")
public String getItemNumber() {
return itemNumber;
}

@JsonProperty("itemNumber")
public void setItemNumber(String itemNumber) {
this.itemNumber = itemNumber;
}

@JsonProperty("itemUPCNumber")
public String getItemUPCNumber() {
return itemUPCNumber;
}

@JsonProperty("itemUPCNumber")
public void setItemUPCNumber(String itemUPCNumber) {
this.itemUPCNumber = itemUPCNumber;
}

@JsonProperty("vendorNbr")
public String getVendorNbr() {
return vendorNbr;
}

@JsonProperty("vendorNbr")
public void setVendorNbr(String vendorNbr) {
this.vendorNbr = vendorNbr;
}

@JsonProperty("instantSavingsItem")
public Boolean getInstantSavingsItem() {
return instantSavingsItem;
}

@JsonProperty("instantSavingsItem")
public void setInstantSavingsItem(Boolean instantSavingsItem) {
this.instantSavingsItem = instantSavingsItem;
}

@JsonProperty("discountInfo")
public List<DiscountInfo> getDiscountInfo() {
return discountInfo;
}

@JsonProperty("discountInfo")
public void setDiscountInfo(List<DiscountInfo> discountInfo) {
this.discountInfo = discountInfo;
}

}

