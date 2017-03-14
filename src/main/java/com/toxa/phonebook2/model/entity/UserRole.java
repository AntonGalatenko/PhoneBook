package com.toxa.phonebook2.model.entity;

import com.toxa.phonebook2.model.entity.Enums.UserRoleEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String type = UserRoleEnum.USER.getUserRoleType();

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Set<User> usersRole = new HashSet<User>();

    public UserRole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<User> getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(Set<User> usersRole) {
        this.usersRole = usersRole;
    }
}
