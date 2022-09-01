package com.bitbox.selectionproces.dao.interfaces;

import com.bitbox.selectionproces.model.PriceReduction;

import java.util.List;

public interface IPriceReductionDAO {
    public List<PriceReduction> getAllItem();
    public void createPriceReduction(PriceReduction priceReduction);
}
