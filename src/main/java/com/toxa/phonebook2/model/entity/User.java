package com.toxa.phonebook2.model.entity;

import com.toxa.phonebook2.model.entity.Enums.UserRoleEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Phone> phones = new HashSet<Phone>();

    public User() {
    }

    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        User that = (User) obj;
        if(!login.equals(that.login) || !password.equals(that.password) || !fullName.equals(that.fullName))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        int hash = 3;
        hash = 53 * hash + login.hashCode() + password.hashCode() + fullName.hashCode();
        return hash;
    }

    @Override
    public String toString(){
        return "[id=" + this.id + ", login=" + this.login + ", Full name=" + this.fullName + "]";
    }
}
