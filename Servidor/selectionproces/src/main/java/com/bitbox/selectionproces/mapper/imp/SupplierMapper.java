package com.bitbox.selectionproces.mapper.imp;

import com.bitbox.selectionproces.dto.ItemDTO;
import com.bitbox.selectionproces.dto.PriceReductionDTO;
import com.bitbox.selectionproces.dto.SupplierDTO;
import com.bitbox.selectionproces.mapper.interfaces.ISupplierMapper;
import com.bitbox.selectionproces.model.Item;
import com.bitbox.selectionproces.model.PriceReduction;
import com.bitbox.selectionproces.model.Supplier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SupplierMapper implements ISupplierMapper {
    @Override
    public Supplier DTOToSupplier(SupplierDTO supplierDTO) {
        if(supplierDTO==null)return null;
        Supplier supplier=new Supplier();
        supplier.setId(supplierDTO.getId()==0?null:supplierDTO.getId());
        supplier.setName(supplierDTO.getName());
        supplier.setCountry(supplierDTO.getCountry());
        Set<Item> itemList=new HashSet<>();
        for(ItemDTO i: supplierDTO.getItemList()){
            Item item= new Item();
            item.setDescription(i.getDescription());
            item.setPrice(i.getPrice());
            item.setCode_id(i.getCode_id());
            item.setCreationDate(i.getCreationDate());
            item.setState(i.getState());
            item.setId(i.getId());
            itemList.add(item);
        }
        supplier.setItemList(itemList);
        return supplier;
    }

    @Override
    public SupplierDTO supplierToDTO(Supplier supplier) {
        if(supplier==null)return null;
        SupplierDTO supplierDTO=new SupplierDTO();
        supplierDTO.setId(supplier.getId()==0?null:supplier.getId());
        supplierDTO.setCountry(supplier.getCountry());
        supplierDTO.setName(supplier.getName());
        Set<ItemDTO>itemList=new HashSet<>();
        for(Item i: supplier.getItemList()){
            ItemDTO itemDTO=new ItemDTO();
            itemDTO.setPrice(i.getPrice());
            itemDTO.setDescription(i.getDescription());
            itemDTO.setState(i.getState());
            itemDTO.setCreationDate(i.getCreationDate());
            itemDTO.setCode_id(i.getCode_id());
            itemDTO.setId(i.getId());
            itemList.add(itemDTO);
        }
        supplierDTO.setItemList(itemList);
        return supplierDTO;
    }
    public List<SupplierDTO> getListDTO(List<Supplier> supplierList){
        List <SupplierDTO> supplierDTOList=new ArrayList<>();
        for(Supplier i: supplierList){
            supplierDTOList.add(supplierToDTO(i));
        }
        return supplierDTOList;
    }
    public List <Supplier> getListPriceReduction(List<SupplierDTO> supplierDTOList){
        List <Supplier> supplierList=new ArrayList<>();
        for(SupplierDTO i: supplierDTOList){
            supplierList.add(DTOToSupplier(i));
        }
        return supplierList;
    }
}
