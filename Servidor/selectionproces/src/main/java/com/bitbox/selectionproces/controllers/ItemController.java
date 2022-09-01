package com.bitbox.selectionproces.controllers;

import com.bitbox.selectionproces.dao.interfaces.IItemDAO;
import com.bitbox.selectionproces.dto.ItemDTO;
import com.bitbox.selectionproces.mapper.imp.ItemMapper;
import com.bitbox.selectionproces.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
public class ItemController {

    @Autowired
    private IItemDAO itemDao;
    private ItemMapper itemMapper=new ItemMapper();
    @RequestMapping(value="/getallitem", method = RequestMethod.GET)
    public List<ItemDTO> getAllItem(){
        return itemMapper.getListDTO(itemDao.getAllItem());
    }
    @RequestMapping(value="/editaritem", method= RequestMethod.POST)
    public List<ItemDTO> edit(@RequestBody ItemDTO item){
        if(item==null)return null;
        itemDao.updateItem(itemMapper.DTOToItem(item));
        return itemMapper.getListDTO(itemDao.getAllItem());
    }
    @RequestMapping(value="/desactivaritem", method=RequestMethod.POST)
    public void desactivarItem(@RequestBody ItemDTO item){
        if(item==null)return;
        itemDao.updateItem(itemMapper.DTOToItem(item));
    }
    @RequestMapping(value="/deleteitem/{item}", method=RequestMethod.DELETE)
    public List<ItemDTO> deleteItem(@PathVariable Long item){
        if(item==null)return null;
        itemDao.deleteItem(item);
        return itemMapper.getListDTO(itemDao.getAllItem());
    }
    @RequestMapping(value="/item/{idPrice}/{id}", method= RequestMethod.POST)
    public List<ItemDTO> addPriceReductionToItem(@PathVariable Long idPrice, @PathVariable Long id){
        itemDao.addPriceReduction(idPrice,id);
        return itemMapper.getListDTO(itemDao.getAllItem());
    }
    @RequestMapping(value="/item/supplier/{idSupplier}/{id}", method= RequestMethod.POST)
    public List<ItemDTO> addSupplierToItem(@PathVariable Long idSupplier, @PathVariable Long id){

        itemDao.addSupplier(idSupplier,id);
        return itemMapper.getListDTO(itemDao.getAllItem());
    }


}
