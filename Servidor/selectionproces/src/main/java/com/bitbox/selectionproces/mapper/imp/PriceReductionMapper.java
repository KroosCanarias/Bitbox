package com.bitbox.selectionproces.mapper.imp;

import com.bitbox.selectionproces.dto.ItemDTO;
import com.bitbox.selectionproces.dto.PriceReductionDTO;
import com.bitbox.selectionproces.mapper.interfaces.IPriceReductionMapper;
import com.bitbox.selectionproces.model.Item;
import com.bitbox.selectionproces.model.PriceReduction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PriceReductionMapper implements IPriceReductionMapper {
    @Override
    public PriceReduction DTOToPriceReduction(PriceReductionDTO priceReductionDTO) {
        if(priceReductionDTO==null)return null;
        PriceReduction priceReduction=new PriceReduction();
        priceReduction.setId(priceReductionDTO.getId()==0?null:priceReductionDTO.getId());
        priceReduction.setReducedPrice(priceReductionDTO.getReducedPrice());
        priceReduction.setStart(priceReductionDTO.getStart());
        priceReduction.setEnd(priceReductionDTO.getEnd());
        Set<Item> itemList=new HashSet<>();
        for(ItemDTO i: priceReductionDTO.getItemList()){
            Item item= new Item();
            item.setDescription(i.getDescription());
            item.setPrice(i.getPrice());
            item.setCode_id(i.getCode_id());
            item.setCreationDate(i.getCreationDate());
            item.setState(i.getState());
            item.setId(i.getId());
            itemList.add(item);
        }
        priceReduction.setItemList(itemList);
        return priceReduction;
    }

    @Override
    public PriceReductionDTO priceReductionToDTO(PriceReduction priceReduction) {
        if(priceReduction==null)return null;
        PriceReductionDTO priceReductionDTO=new PriceReductionDTO();
        priceReductionDTO.setId(priceReduction.getId()==0?null:priceReduction.getId());
        priceReductionDTO.setStart(priceReduction.getStart());
        priceReductionDTO.setEnd(priceReduction.getEnd());
        priceReductionDTO.setReducedPrice(priceReduction.getReducedPrice());
        Set<ItemDTO> itemList=new HashSet<>();
        for(Item i: priceReduction.getItemList()){
            ItemDTO item= new ItemDTO();
            item.setDescription(i.getDescription());
            item.setPrice(i.getPrice());
            item.setCode_id(i.getCode_id());
            item.setCreationDate(i.getCreationDate());
            item.setState(i.getState());
            item.setId(i.getId());
            itemList.add(item);
        }
        priceReductionDTO.setItemList(itemList);
        return priceReductionDTO;
    }

    public List<PriceReductionDTO> getListDTO(List<PriceReduction> priceReductions){
        List <PriceReductionDTO> priceReductionDTOS=new ArrayList<>();
        for(PriceReduction i: priceReductions){
            priceReductionDTOS.add(priceReductionToDTO(i));
        }
        return priceReductionDTOS;
    }
    public List <PriceReduction> getAllPriceReduction(List<PriceReductionDTO> priceReductionDTOList){
        List <PriceReduction> priceReductionList=new ArrayList<>();
        for(PriceReductionDTO i: priceReductionDTOList){
            priceReductionList.add(DTOToPriceReduction(i));
        }
        return priceReductionList;
    }
}
