package com.bitbox.selectionproces.mapper.interfaces;

import com.bitbox.selectionproces.dto.SupplierDTO;
import com.bitbox.selectionproces.model.Supplier;

public interface ISupplierMapper {
    public Supplier DTOToSupplier(SupplierDTO supplierDTO);
    public SupplierDTO supplierToDTO(Supplier supplier);
}
