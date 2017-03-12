package com.toxa.phonebook2.model.dao;

import com.toxa.phonebook2.model.entity.Phone;

public interface PhoneDao {

    public Phone addPhone(Phone phone);
    public void updatePhone(Phone phone);
    public Phone getPhone(Integer id);
    public Phone getPhone(String lastName);
    public void deletePhone(Phone phone);
}
