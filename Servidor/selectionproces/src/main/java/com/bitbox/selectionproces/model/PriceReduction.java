package com.bitbox.selectionproces.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="pricereduction")

public class PriceReduction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="reducedprice")
    private Long reducedPrice;
    @Column(name="startdate")
    private Date startDate;
    @Column(name="enddate")
    private Date endDate;

    public PriceReduction(){

    }
    @ManyToMany(mappedBy = "priceReductionList", cascade = { CascadeType.ALL })
    @JsonBackReference
    private Set<Item> itemList=new HashSet<>();
    public PriceReduction(Long id,Long reducedPrice, Date startDate, Date endDate) {
        this.reducedPrice = reducedPrice;
        this.id=id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

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

    public Set<Item> getItemList() {
        return itemList;
    }
    public void addItem(Item item){
        itemList.add(item);
    }
    public void setItemList(Set<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString(){
        return id+"-"+startDate.toString()+"-"+itemList.size();
    }
}
