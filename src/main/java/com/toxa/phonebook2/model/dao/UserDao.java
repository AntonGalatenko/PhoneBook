package com.toxa.phonebook2.model.dao;

import com.toxa.phonebook2.model.entity.Phone;
import com.toxa.phonebook2.model.entity.User;

import java.util.Collection;

public interface UserDao {

    public User addUser(User user);
    public void updateUser(User user);
    public User getUser(Integer id);
    public User getUser(String login);
    public void deleteUser(User user);
}
