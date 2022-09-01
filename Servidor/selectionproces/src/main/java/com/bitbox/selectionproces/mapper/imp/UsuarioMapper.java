package com.bitbox.selectionproces.mapper.imp;

import com.bitbox.selectionproces.dto.ItemDTO;
import com.bitbox.selectionproces.dto.SupplierDTO;
import com.bitbox.selectionproces.dto.UsuarioDTO;
import com.bitbox.selectionproces.mapper.interfaces.IUsuarioMapper;
import com.bitbox.selectionproces.model.Item;
import com.bitbox.selectionproces.model.Supplier;
import com.bitbox.selectionproces.model.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsuarioMapper implements IUsuarioMapper {
    @Override
    public Usuario DTOToUsuario(UsuarioDTO usuarioDTO) {
        if(usuarioDTO==null)return null;
        Usuario usuario=new Usuario();
        usuario.setId(usuarioDTO.getId()==0?null:usuarioDTO.getId());
        usuario.setRoleAdmin(usuarioDTO.getRoleAdmin());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setNick(usuarioDTO.getNick());
        Set<Item> itemList=new HashSet<>();
        if(usuarioDTO.getItemList()!=null){
            for(ItemDTO i: usuarioDTO.getItemList()){
                Item item= new Item();
                item.setDescription(i.getDescription());
                item.setPrice(i.getPrice());
                item.setCode_id(i.getCode_id());
                item.setCreationDate(i.getCreationDate());
                item.setState(i.getState());
                item.setId(i.getId());
                itemList.add(item);
            }
        }

        usuario.setItemList(itemList);
        return usuario;
    }

    @Override
    public UsuarioDTO usuarioToDTO(Usuario usuario) {
        if(usuario==null)return null;
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId()==0?null:usuario.getId());
        usuarioDTO.setNick(usuario.getNick());
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setRoleAdmin(usuario.getRoleAdmin());
        Set<ItemDTO>itemList=new HashSet<>();
        for(Item i: usuario.getItemList()){
            ItemDTO itemDTO=new ItemDTO();
            itemDTO.setPrice(i.getPrice());
            itemDTO.setDescription(i.getDescription());
            itemDTO.setState(i.getState());
            itemDTO.setCreationDate(i.getCreationDate());
            itemDTO.setCode_id(i.getCode_id());
            itemDTO.setId(i.getId());
            itemList.add(itemDTO);
        }
        usuarioDTO.setItemList(itemList);
        return usuarioDTO;
    }

    public List<UsuarioDTO> getListDTO(List<Usuario> usuarioList){
        List <UsuarioDTO> usuarioDTOList=new ArrayList<>();
        for(Usuario i: usuarioList){
            usuarioDTOList.add(usuarioToDTO(i));
        }
        return usuarioDTOList;
    }
    public List <Usuario> getListPriceReduction(List<UsuarioDTO> usuarioDTOList){
        List <Usuario> usuarioList=new ArrayList<>();
        for(UsuarioDTO i: usuarioDTOList){
            usuarioList.add(DTOToUsuario(i));
        }
        return usuarioList;
    }
}
