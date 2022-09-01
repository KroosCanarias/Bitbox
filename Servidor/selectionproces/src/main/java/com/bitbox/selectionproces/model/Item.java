package com.bitbox.selectionproces.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="item")

public class Item implements Serializable {

    @Column(name="price")
    private Long price;
    @Column(name="state")
    private boolean state=true; //active or discontinued
    @Column(name="description")
    private String description;
    @Column(name="code_id")
    private Long code_id; //id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private Usuario usuario;
    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "supplier_item",
            joinColumns = {
                    @JoinColumn(name = "item_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "supplier_id")
            }
    )
    private Set<Supplier> supplierList=new HashSet<>();;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "pricereduction_item",
            joinColumns = {
                    @JoinColumn(name = "code_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "pricereduction_id")
            }
    )
    private Set<PriceReduction> priceReductionList=new HashSet<>();
    @Column(name="creationdate")
    private Date creationDate;
    public Item(){

    }

    public Item(Long price, boolean state, String description,  Usuario usuario,
                Set<Supplier> supplierList, Set<PriceReduction> priceReductionList, Date creationDate) {
        this.price = price;
        this.state = state;
        this.description = description;
        this.usuario = usuario;
        this.supplierList = supplierList;
        this.priceReductionList = priceReductionList;
        this.creationDate = creationDate;
    }

    public boolean isState() {
        return state;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCode_id() {
        return code_id;
    }

    public void setCode_id(Long code_id) {
        this.code_id = code_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Supplier> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(Set<Supplier> supplierList) {
        this.supplierList = supplierList;
    }

    public Set<PriceReduction> getPriceReductionList() {
        return priceReductionList;
    }

    public void setPriceReductionList(Set<PriceReduction> priceReductionList) {
        this.priceReductionList = priceReductionList;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean addPriceReduction(PriceReduction priceReduction){
        for(PriceReduction i: priceReductionList){
            if(!isValidDate(priceReduction,i)){
                return false;
            }
        }
        priceReductionList.add(priceReduction);
        return true;
    }
    private boolean isBefore(Date date, Date date2){
        return date.before(date2);
    }
    private boolean isAfter(Date date, Date date2){
        return date.after(date2);
    }
    private boolean isValidDate(PriceReduction priceReduction,PriceReduction priceReduction2){
        return isAfter(priceReduction.getStart(),priceReduction2.getEnd()) ||
                isBefore(priceReduction.getEnd(),priceReduction2.getStart());

    }
    public void addSupplier(Supplier supplier){
        if(supplierList==null){
            supplierList=new HashSet<>();
        }
        supplierList.add(supplier);
    }
    @Override
    public String toString(){
        return id+"-"+price+"-"+creationDate.toString()+"-"+code_id+"-"+priceReductionList.size();
    }
}
