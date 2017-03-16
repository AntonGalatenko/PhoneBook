package com.toxa.phonebook2.model.dao;

import com.toxa.phonebook2.model.entity.Phone;
import com.toxa.phonebook2.model.entity.User;

import java.util.Collection;

public interface PhoneDao {

    public Phone addPhone(Phone phone);
    public void updatePhone(Phone phone);
    public Phone getPhone(Integer id);
    public Phone getPhone(String phoneMobile);
    public Collection<Phone> getAllPhones();
    public void deletePhone(String phoneMobile);
}
