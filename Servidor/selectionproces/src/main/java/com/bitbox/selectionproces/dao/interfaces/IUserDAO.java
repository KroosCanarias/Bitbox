package com.bitbox.selectionproces.dao.interfaces;

import com.bitbox.selectionproces.model.Usuario;

import java.util.List;

public interface IUserDAO {
    public List<Usuario> getAllUsers();
    public void delete(Long id);
    public void createUser(Usuario usuario);

    Usuario findUser(Usuario usuario);

    public void updateUser(Usuario usuario);
    public List<Usuario> authentication(Usuario usuario);
}
