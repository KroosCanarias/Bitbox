package com.bitbox.selectionproces.repository;


import com.bitbox.selectionproces.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {

}
