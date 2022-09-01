package com.bitbox.selectionproces.dao.imp;

import com.bitbox.selectionproces.dao.interfaces.IPriceReductionDAO;
import com.bitbox.selectionproces.model.PriceReduction;
import com.bitbox.selectionproces.repository.PriceReductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PriceReductionDAOImp implements IPriceReductionDAO {

    @PersistenceContext
    EntityManager entitryManager;
    @Autowired
    private PriceReductionRepository repository;

    @Override
    public List<PriceReduction> getAllItem() {
        return (List<PriceReduction>)repository.findAll();
    }

    @Override
    public void createPriceReduction(PriceReduction priceReduction) {
        if(priceReduction==null)return;
        repository.save(priceReduction);
    }


}
