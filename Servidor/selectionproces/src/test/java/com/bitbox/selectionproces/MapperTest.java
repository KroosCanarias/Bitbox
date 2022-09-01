package com.bitbox.selectionproces;

import static org.junit.Assert.assertEquals;

import com.bitbox.selectionproces.dto.ItemDTO;
import com.bitbox.selectionproces.dto.PriceReductionDTO;
import com.bitbox.selectionproces.dto.SupplierDTO;
import com.bitbox.selectionproces.dto.UsuarioDTO;
import com.bitbox.selectionproces.mapper.imp.ItemMapper;
import com.bitbox.selectionproces.mapper.imp.PriceReductionMapper;
import com.bitbox.selectionproces.mapper.imp.SupplierMapper;
import com.bitbox.selectionproces.mapper.imp.UsuarioMapper;
import com.bitbox.selectionproces.model.Item;
import com.bitbox.selectionproces.model.PriceReduction;
import com.bitbox.selectionproces.model.Supplier;
import com.bitbox.selectionproces.model.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class MapperTest {
    Item item;
    Item item2;

    PriceReduction priceReduction;
    PriceReduction priceReduction2;
    Supplier supplier;
    Supplier supplier2;
    Usuario usuario;
    Usuario usuario2;
    @Before
    public void init(){
        item=new Item();
        item2=new Item();
        item2.setId(2L);
        item2.setState(true);
        item2.setCreationDate(new Date());
        item2.setCode_id(2L);
        item2.setDescription("jaja");
        item.setId(1L);
        item.setState(true);
        item.setCreationDate(new Date());
        item.setCode_id(2L);
        item.setDescription("jaja");
        priceReduction=new PriceReduction(1L,55L,new Date(),new Date());
        priceReduction2=new PriceReduction(2L,3L,new Date(),new Date());
        item.addPriceReduction(priceReduction);
        item.addPriceReduction(priceReduction2);
        supplier =new Supplier(1L,"IBERDROLLA","ESPAÑA");
        supplier2=new Supplier(2L,"EMIRATOS","ARABIA");
        usuario=new Usuario(1L,true,"Erika","1");
        usuario2 =new Usuario(2L,false,"Kevin","2");
        item.addSupplier(supplier);
        item.addSupplier(supplier2);
        item.addPriceReduction(priceReduction);
        item.addPriceReduction(priceReduction2);
        item.setUsuario(usuario);
        supplier.addItem(item);
        priceReduction.addItem(item);
    }
    @Test
    public void EmptyListsItem(){
        ItemMapper itemMapper=new ItemMapper();
        ItemDTO itemDTO2 = itemMapper.itemToDTO(item2);
        assertEquals(itemDTO2.toString(),item2.toString());
        Item itemPrueba=itemMapper.DTOToItem(itemDTO2);
        assertEquals(itemDTO2.toString(),itemPrueba.toString());
    }
    @Test
    public void EmptyListPriceReduction(){
        Supplier supplierPrueba=new Supplier(6L,"EMIRATOS","ARABIA");
        SupplierMapper supplierMapper=new SupplierMapper();
        SupplierDTO supplierDTO=supplierMapper.supplierToDTO(supplierPrueba);
        assertEquals(supplierPrueba.toString(),supplierDTO.toString());
        Supplier supplierPrueba2=supplierMapper.DTOToSupplier(supplierDTO);
        assertEquals(supplierPrueba.toString(),supplierPrueba2.toString());
    }
    @Test
    public void ItemToDTOItemAndItemDTOToItem(){
        ItemMapper itemMapper=new ItemMapper();
        ItemDTO itemDTO= itemMapper.itemToDTO(item);
        assertEquals(itemDTO.toString(),item.toString());
        assertEquals(itemDTO.getId(),item.getId());
        assertEquals(itemDTO.getPriceReductionList().size(),item.getPriceReductionList().size());
        assertEquals(itemDTO.getSupplierList().size(),item.getSupplierList().size());
        assertEquals(itemDTO.getUsuario().getId(),item.getUsuario().getId());
        Item itemPrueba=itemMapper.DTOToItem(itemDTO);
        assertEquals(itemDTO.toString(),itemPrueba.toString());
        assertEquals(itemDTO.getId(),itemPrueba.getId());
        assertEquals(itemDTO.getPriceReductionList().size(),itemPrueba.getPriceReductionList().size());
        assertEquals(itemDTO.getSupplierList().size(),itemPrueba.getSupplierList().size());
        assertEquals(itemDTO.getUsuario().getId(),itemPrueba.getUsuario().getId());
    }
    @Test
    public void SupplierToDTOSupplierAndDTOToSupplier(){
        SupplierMapper supplierMapper=new SupplierMapper();
        SupplierDTO supplierDTO = supplierMapper.supplierToDTO(supplier);
        assertEquals(supplierDTO.toString(),supplier.toString());
        assertEquals(supplierDTO.getId(),supplier.getId());
        assertEquals(supplierDTO.getItemList().size(),supplier.getItemList().size());
        Supplier supplierPrueba=supplierMapper.DTOToSupplier(supplierDTO);
        assertEquals(supplierDTO.toString(),supplierPrueba.toString());
        assertEquals(supplierDTO.getId(),supplierPrueba.getId());
        assertEquals(supplierDTO.getItemList().size(),supplierPrueba.getItemList().size());
    }

    @Test
    public void PriceReductionToDTOPriceReductionAndDTOToPriceReduction(){
        PriceReductionMapper priceReductionMapper=new PriceReductionMapper();
        PriceReductionDTO priceReductionDTO=priceReductionMapper.priceReductionToDTO(priceReduction);
        assertEquals(priceReductionDTO.toString(),priceReduction.toString());
        PriceReduction priceReduction=priceReductionMapper.DTOToPriceReduction(priceReductionDTO);
        assertEquals(priceReductionDTO.toString(),priceReduction.toString());
    }
    @Test
    public void UserToDTOAndDtoToUser(){
        UsuarioMapper usuarioMapper=new UsuarioMapper();
        UsuarioDTO usuarioDTO=usuarioMapper.usuarioToDTO(usuario);
        assertEquals(usuarioDTO.toString(),usuario.toString());
        Usuario usuario=usuarioMapper.DTOToUsuario(usuarioDTO);
        assertEquals(usuarioDTO.toString(),usuario.toString());

    }

}
