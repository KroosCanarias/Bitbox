package com.bitbox.selectionproces.dto;

import java.util.Set;

public class UsuarioDTO {

    private boolean roleAdmin;
    private String nick;
    private String password;
    private Set<ItemDTO> itemList;

    private Long id;

    public UsuarioDTO(){

    }

    public Set<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(Set<ItemDTO> itemList) {
        this.itemList = itemList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getRoleAdmin() {
        return roleAdmin;
    }

    public void setRoleAdmin(boolean roleAdmin) {
        this.roleAdmin = roleAdmin;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString(){
        return nick+"-"+password+"-"+roleAdmin;
    }
}
