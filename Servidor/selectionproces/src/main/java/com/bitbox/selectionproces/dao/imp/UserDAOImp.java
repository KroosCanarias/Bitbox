package com.bitbox.selectionproces.dao.imp;

import com.bitbox.selectionproces.dao.interfaces.IUserDAO;
import com.bitbox.selectionproces.model.Usuario;
import com.bitbox.selectionproces.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserDAOImp implements IUserDAO {


    @PersistenceContext
    EntityManager entitryManager;
    @Autowired
    private UserRepository repository;
    @Override
    public List<Usuario> getAllUsers() {
        return (List<Usuario>) repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void createUser(Usuario usuario) {
        if(getAllUsers().isEmpty()){
            usuario.setRoleAdmin(true);
        }
        repository.save(usuario);
    }
    @Override
    public Usuario findUser(Usuario usuario){
        String hql="FROM Usuario u where u.nick= :nick AND u.password= :password";
        try{
            List<Usuario> usuarioList =(List<Usuario>)entitryManager.createQuery(hql)
                    .setParameter("nick", usuario.getNick()).setParameter("password", usuario.getPassword())
                    .getResultList();
            return usuarioList.get(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public void updateUser(Usuario usuario) {
        repository.save(usuario);
    }
    @Override
    public List<Usuario> authentication(Usuario usuario){
        String hql="FROM Usuario u where u.nick= :nick AND u.password= :password";
        try{
            List<Usuario> usuarioList =(List<Usuario>)entitryManager.createQuery(hql)
                    .setParameter("nick", usuario.getNick()).setParameter("password", usuario.getPassword())
                    .getResultList();
            return usuarioList;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;

    }


}
