package com.bitbox.selectionproces.mapper.imp;

import com.bitbox.selectionproces.dto.ItemDTO;
import com.bitbox.selectionproces.dto.PriceReductionDTO;
import com.bitbox.selectionproces.dto.SupplierDTO;
import com.bitbox.selectionproces.dto.UsuarioDTO;
import com.bitbox.selectionproces.mapper.interfaces.IItemMapper;
import com.bitbox.selectionproces.model.Item;
import com.bitbox.selectionproces.model.PriceReduction;
import com.bitbox.selectionproces.model.Supplier;
import com.bitbox.selectionproces.model.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemMapper implements IItemMapper {
    PriceReductionMapper priceReductionMapper=new PriceReductionMapper();
    SupplierMapper supplierMapper=new SupplierMapper();
    UsuarioMapper usuarioMapper=new UsuarioMapper();
    @Override
    public Item DTOToItem(ItemDTO itemDTO) {
        if(itemDTO==null)return null;
        Item item=new Item();
        item.setId(itemDTO.getId()==0?null:itemDTO.getId());
        item.setState(itemDTO.getState());
        item.setCode_id(itemDTO.getCode_id());
        item.setCreationDate(itemDTO.getCreationDate());
        item.setPrice(itemDTO.getPrice());
        item.setDescription(itemDTO.getDescription());
        Set<PriceReduction> priceReductionList=new HashSet<>();
        if(itemDTO.getPriceReductionList()!=null){
            for(PriceReductionDTO i: itemDTO.getPriceReductionList()){
                PriceReduction priceReduction=new PriceReduction();
                priceReduction.setEnd(i.getEnd());
                priceReduction.setId(i.getId());
                priceReduction.setReducedPrice(i.getReducedPrice());
                priceReduction.setStart(i.getStart());
                priceReductionList.add(priceReduction);
            }
        }

        item.setPriceReductionList(priceReductionList);
        Set<Supplier> supplierList=new HashSet<>();
        if(itemDTO.getSupplierList()!=null){
            for(SupplierDTO i: itemDTO.getSupplierList()){
                Supplier supplier=new Supplier();
                supplier.setCountry(i.getCountry());
                supplier.setId(i.getId());
                supplier.setName(i.getName());
                supplierList.add(supplier);
            }
        }

        item.setSupplierList(supplierList);
        Usuario usuario=new Usuario();
        UsuarioDTO usuarioDTO=itemDTO.getUsuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNick(usuarioDTO.getNick());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setRoleAdmin(usuarioDTO.getRoleAdmin());
        item.setUsuario(usuario);
        return item;
    }

    @Override
    public ItemDTO itemToDTO(Item item) {
        if(item==null)return null;
        ItemDTO itemDTO=new ItemDTO();
        itemDTO.setId(item.getId()==0?null:item.getId());
        itemDTO.setState(item.getState());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setCreationDate(item.getCreationDate());
        itemDTO.setCode_id(item.getCode_id());
        itemDTO.setDescription(item.getDescription());
        Set<PriceReductionDTO> priceReductionList=new HashSet<>();
        Set<SupplierDTO> supplierList=new HashSet<>();
        Usuario usuario=item.getUsuario();
        UsuarioDTO usuarioDTO=new UsuarioDTO();
        for(PriceReduction i: item.getPriceReductionList()){
            PriceReductionDTO priceReductionDTO=new PriceReductionDTO();
            priceReductionDTO.setReducedPrice(i.getReducedPrice());
            priceReductionDTO.setEnd(i.getEnd());
            priceReductionDTO.setStart(i.getStart());
            priceReductionDTO.setId(i.getId());
            priceReductionList.add(priceReductionDTO);
        }
        for(Supplier i: item.getSupplierList()){
            SupplierDTO supplier=new SupplierDTO();
            supplier.setCountry(i.getCountry());
            supplier.setId(i.getId());
            supplier.setName(i.getName());
            supplierList.add(supplier);
        }
        if(usuario!=null){
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNick(usuario.getNick());
            usuarioDTO.setPassword(usuario.getPassword());
            usuarioDTO.setRoleAdmin(usuario.getRoleAdmin());
        }

        itemDTO.setPriceReductionList(priceReductionList);

        itemDTO.setSupplierList(supplierList);
        itemDTO.setUsuario(usuarioDTO);
        return itemDTO;

    }



    public List<ItemDTO> getListDTO(List<Item> itemList){
        List <ItemDTO> itemDTOList=new ArrayList<>();
        for(Item i: itemList){
            itemDTOList.add(itemToDTO(i));
        }
        return itemDTOList;
    }
    public List <Item> getListItem(List<ItemDTO> itemDTO){
        List <Item> itemList=new ArrayList<>();
        for(ItemDTO i: itemDTO){
            itemList.add(DTOToItem(i));
        }
        return itemList;
    }
}
