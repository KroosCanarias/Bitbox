package com.bitbox.selectionproces.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="supplier")

public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="country")
    private String country;

    @ManyToMany(mappedBy = "supplierList", cascade = { CascadeType.ALL })
    @JsonBackReference
    private Set<Item> itemList=new HashSet<>();
    public Supplier(){

    }
    public Supplier(Long id,String name, String country) {
        this.name = name;
        this.country = country;
        this.id=id;
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


    public Set<Item> getItemList() {
        return itemList;
    }

    public void setItemList(Set<Item> itemList) {
        this.itemList = itemList;
    }
    public void addItem(Item item){
        itemList.add(item);
    }
    public String toString(){
        return id+"-"+name+"-"+country;
    }
}
