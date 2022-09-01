package com.bitbox.selectionproces.controllers;

import com.bitbox.selectionproces.dao.interfaces.IPriceReductionDAO;
import com.bitbox.selectionproces.dto.PriceReductionDTO;
import com.bitbox.selectionproces.mapper.imp.PriceReductionMapper;
import com.bitbox.selectionproces.model.PriceReduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PriceReductionController {
    @Autowired
    private IPriceReductionDAO priceReductionDAO;
    private PriceReductionMapper priceReductionMapper=new PriceReductionMapper();
    @RequestMapping(value="/getallpricereduction", method = RequestMethod.GET)
    public List<PriceReductionDTO> getAllPriceReduction(){

        return  priceReductionMapper.getListDTO(priceReductionDAO.getAllItem());
    }

    @RequestMapping(value="/addpricereduction", method= RequestMethod.POST)
    public void addPriceReduction(@RequestBody PriceReduction priceReduction){
        if(priceReduction==null)return;

        priceReductionDAO.createPriceReduction(priceReduction);
    }
}
