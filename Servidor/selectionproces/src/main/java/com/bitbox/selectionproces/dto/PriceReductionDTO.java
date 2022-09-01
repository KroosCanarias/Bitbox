package com.bitbox.selectionproces.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PriceReductionDTO {
    private Long id;
    private Long reducedPrice;
    private Date startDate;
    private Date endDate;

    public PriceReductionDTO(){

    }
    private Set<ItemDTO> itemList=new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(Long reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public Date getStart() {
        return startDate;
    }

    public void setStart(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEnd() {
        return endDate;
    }

    public void setEnd(Date endDate) {
        this.endDate = endDate;
    }

    public Set<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(Set<ItemDTO> itemList) {
        this.itemList = itemList;
    }
    @Override
    public String toString(){
        return id+"-"+startDate.toString()+"-"+itemList.size();
    }
}

