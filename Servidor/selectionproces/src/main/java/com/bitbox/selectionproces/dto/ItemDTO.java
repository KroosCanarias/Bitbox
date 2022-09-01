package com.bitbox.selectionproces.dto;

import com.bitbox.selectionproces.model.Usuario;

import java.util.Date;
import java.util.Set;

public class ItemDTO {
    private Long price;
    private boolean state=true;
    private String description;
    private Long code_id; //id
    private Long id;
    private UsuarioDTO usuario;
    private Set<SupplierDTO> supplierList;
    private Set<PriceReductionDTO> priceReductionList;
    private Date creationDate;
    public ItemDTO(){

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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Set<SupplierDTO> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(Set<SupplierDTO> supplierList) {
        this.supplierList = supplierList;
    }

    public Set<PriceReductionDTO> getPriceReductionList() {
        return priceReductionList;
    }

    public void setPriceReductionList(Set<PriceReductionDTO> priceReductionList) {
        this.priceReductionList = priceReductionList;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean addPriceReduction(PriceReductionDTO priceReduction){
        for(PriceReductionDTO i: priceReductionList){
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
    private boolean isValidDate(PriceReductionDTO priceReduction,PriceReductionDTO priceReduction2){
        return isAfter(priceReduction.getStart(),priceReduction2.getEnd()) ||
                isBefore(priceReduction.getEnd(),priceReduction2.getStart());

    }
    public void addSupplier(SupplierDTO supplier){
        supplierList.add(supplier);
    }

    @Override
    public String toString(){
        return id+"-"+price+"-"+creationDate.toString()+"-"+code_id+"-"+priceReductionList.size();    }
}
