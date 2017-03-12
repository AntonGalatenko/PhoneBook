package com.toxa.phonebook2.model.dao.impl;

import com.toxa.phonebook2.model.dao.PhoneDao;
import com.toxa.phonebook2.model.entity.Phone;
import com.toxa.phonebook2.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneDaoImpl implements PhoneDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Phone addPhone(Phone phone) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(phone);
        session.getTransaction().commit();
        session.close();
        return phone;
    }

    public void updatePhone(Phone phone) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(phone);
        session.getTransaction().commit();
        session.close();
    }

    public Phone getPhone(Integer id) {
        Session session = sessionFactory.openSession();
        Phone phone = (Phone) session.createCriteria(Phone.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.close();
        return phone;
    }

    public Phone getPhone(String lastName) {
        Session session = sessionFactory.openSession();
        Phone phone = (Phone) session.createCriteria(Phone.class).add(Restrictions.eq("last_name", lastName)).uniqueResult();
        session.close();
        return phone;
    }

    public void deletePhone(Phone phone) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(phone);
        session.getTransaction().commit();
        session.close();
    }
}
