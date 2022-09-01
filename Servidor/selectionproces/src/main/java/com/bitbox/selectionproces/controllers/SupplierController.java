package com.bitbox.selectionproces.controllers;

import com.bitbox.selectionproces.dao.interfaces.IPriceReductionDAO;
import com.bitbox.selectionproces.dao.interfaces.ISupplierDAO;
import com.bitbox.selectionproces.dto.SupplierDTO;
import com.bitbox.selectionproces.mapper.imp.SupplierMapper;
import com.bitbox.selectionproces.model.PriceReduction;
import com.bitbox.selectionproces.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
public class SupplierController {
    @Autowired
    private ISupplierDAO supplierDAO;
    private SupplierMapper supplierMapper=new SupplierMapper();
    @RequestMapping(value="/getallsupplier", method = RequestMethod.GET)
    public List<SupplierDTO> getAllSupplier(){

        return  supplierMapper.getListDTO(supplierDAO.getAllSupplier());
    }

    @RequestMapping(value="/addsupplier", method= RequestMethod.POST)
    public void addPriceReduction(@RequestBody Supplier supplier){
        if(supplier==null)return;

        supplierDAO.addSupplier(supplier);
    }
}
