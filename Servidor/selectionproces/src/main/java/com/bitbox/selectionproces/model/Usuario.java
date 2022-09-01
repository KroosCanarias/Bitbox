package com.bitbox.selectionproces.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usuario")

public class Usuario implements Serializable {

    @Column(name="role")
    private boolean roleAdmin;
    @Column(name="nick", nullable = false)
    private String nick;
    @Column(name="password", nullable=false)
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Item> itemList=new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Usuario(){

    }
    public Usuario(Long id,boolean roleAdmin, String nick, String password) {
        this.roleAdmin = roleAdmin;
        this.nick = nick;
        this.password = password;
        this.id=id;
    }

    public boolean isRoleAdmin() {
        return roleAdmin;
    }

    public Set<Item> getItemList() {
        return itemList;
    }

    public void setItemList(Set<Item> itemList) {
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
