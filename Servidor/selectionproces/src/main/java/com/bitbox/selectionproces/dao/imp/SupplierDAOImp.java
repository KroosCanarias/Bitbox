package com.bitbox.selectionproces.dao.imp;

import com.bitbox.selectionproces.dao.interfaces.ISupplierDAO;
import com.bitbox.selectionproces.model.Supplier;
import com.bitbox.selectionproces.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class SupplierDAOImp implements ISupplierDAO {
    @PersistenceContext
    EntityManager entitryManager;
    @Autowired
    private SupplierRepository repository;

    @Override
    public List<Supplier> getAllSupplier() {
        return (List<Supplier>) repository.findAll();
    }

    @Override
    public void addSupplier(Supplier supplier) {
        if(supplier==null) return;
        repository.save(supplier);
    }


}
