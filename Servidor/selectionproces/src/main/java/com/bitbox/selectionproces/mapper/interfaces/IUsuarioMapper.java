package com.bitbox.selectionproces.mapper.interfaces;

import com.bitbox.selectionproces.dto.UsuarioDTO;
import com.bitbox.selectionproces.model.Usuario;

public interface IUsuarioMapper {
    public Usuario DTOToUsuario(UsuarioDTO usuarioDTO);
    public UsuarioDTO usuarioToDTO(Usuario usuario);
}
