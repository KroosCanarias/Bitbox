package com.bitbox.selectionproces.dao.interfaces;

import com.bitbox.selectionproces.model.Supplier;

import java.util.List;

public interface ISupplierDAO {
    //public List<Supplier> getSupplierListByPriceWhoHasReducedPrice();
    public List<Supplier> getAllSupplier();
    public void addSupplier(Supplier supplier);
}
