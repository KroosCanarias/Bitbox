package com.bitbox.selectionproces.controllers;

import com.bitbox.selectionproces.dto.UsuarioDTO;
import com.bitbox.selectionproces.mapper.imp.UsuarioMapper;
import com.bitbox.selectionproces.model.Usuario;
import com.bitbox.selectionproces.utils.JWTUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bitbox.selectionproces.dao.interfaces.IUserDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
public class UserController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private IUserDAO userDao;
    private UsuarioMapper usuarioMapper=new UsuarioMapper();
    //@RequestMapping(value = "/usuario/{id}")
    @RequestMapping(value = "/getall", method= RequestMethod.GET)
    public List<UsuarioDTO> getAllUser() {
        return usuarioMapper.getListDTO(userDao.getAllUsers());
    }
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public List<UsuarioDTO> add(@RequestBody UsuarioDTO usuario) {
        userDao.createUser(usuarioMapper.DTOToUsuario(usuario));
        return usuarioMapper.getListDTO(userDao.getAllUsers());
    }
    @RequestMapping(value="/regis",method=RequestMethod.POST)
    public void regis(@RequestBody UsuarioDTO usuario) {

        userDao.createUser(usuarioMapper.DTOToUsuario(usuario));
    }
    @RequestMapping(value = "/edit",method=RequestMethod.POST)
    public List<UsuarioDTO> edit(@RequestBody UsuarioDTO usuario) {

        userDao.updateUser(usuarioMapper.DTOToUsuario(usuario));
        return usuarioMapper.getListDTO(userDao.getAllUsers());
    }

    @RequestMapping(value = "/delete/{id}",method= RequestMethod.DELETE)
    public List<UsuarioDTO> delete(@PathVariable Long id ) {

        userDao.delete(id);
        return usuarioMapper.getListDTO(userDao.getAllUsers());
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@RequestBody UsuarioDTO usuario) throws JsonProcessingException {
        if(usuario ==null)return "";
        Usuario usuarioLogged =userDao.authentication(usuarioMapper.DTOToUsuario(usuario)).size()==0?
                                            null:userDao.authentication(usuarioMapper.DTOToUsuario(usuario)).get(0);
        if(usuarioLogged==null)return "";
        String token="";
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(usuarioLogged);
        if(usuarioLogged!=null){
            token=jwtUtil.create(usuarioLogged.getId().toString(),json);
        }
        return token;

    }
}
