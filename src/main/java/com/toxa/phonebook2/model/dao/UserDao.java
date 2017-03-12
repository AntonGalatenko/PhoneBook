package com.toxa.phonebook2.model.dao;

import com.toxa.phonebook2.model.entity.User;

public interface UserDao {

    public User addUser(User user);
    public void updateUser(User user);
    public User getUser(Integer id);
    public void deleteUser(User user);
}
