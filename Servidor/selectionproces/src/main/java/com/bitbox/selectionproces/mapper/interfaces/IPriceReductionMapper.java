package com.bitbox.selectionproces.mapper.interfaces;

import com.bitbox.selectionproces.dto.PriceReductionDTO;
import com.bitbox.selectionproces.model.PriceReduction;

public interface IPriceReductionMapper {
    public PriceReduction DTOToPriceReduction(PriceReductionDTO priceReductionDTO);
    public PriceReductionDTO priceReductionToDTO(PriceReduction priceReduction);
}
