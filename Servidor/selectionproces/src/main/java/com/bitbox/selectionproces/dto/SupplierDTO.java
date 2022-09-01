package com.bitbox.selectionproces.dto;

import java.util.HashSet;
import java.util.Set;

public class SupplierDTO {
    private Long id;
    private String name;
    private String country;

    private Set<ItemDTO> itemList=new HashSet<>();
    public SupplierDTO(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(Set<ItemDTO> itemList) {
        this.itemList = itemList;
    }
    @Override
    public String toString(){
        return id+"-"+name+"-"+country;
    }
}
