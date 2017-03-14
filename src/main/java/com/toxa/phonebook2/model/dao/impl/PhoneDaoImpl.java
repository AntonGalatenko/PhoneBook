package com.toxa.phonebook2.model.dao.impl;

import com.toxa.phonebook2.model.dao.PhoneDao;
import com.toxa.phonebook2.model.entity.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

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

    public Phone getPhone(String phoneMobile) {
        Session session = sessionFactory.openSession();
        Phone phone = (Phone) session.createCriteria(Phone.class).add(Restrictions.eq("phoneMobile", phoneMobile)).uniqueResult();
        session.close();

        System.out.println(phoneMobile + " || " + phone.getPhoneMobile());
        return phone;
    }

    @Override
    public Collection<Phone> getAllPhones() {
        Session session = sessionFactory.openSession();
        List<Phone> phoneList = (List<Phone>) session.createCriteria(Phone.class).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
        session.close();
        return phoneList;
    }

    public void deletePhone(String phoneMobile) {
        if(phoneMobile.indexOf("+") != 0)
            phoneMobile = "+" + phoneMobile;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Phone phone = (Phone) session.createCriteria(Phone.class).add(Restrictions.eq("phoneMobile", phoneMobile)).uniqueResult();
        session.delete(phone);
        session.getTransaction().commit();
        session.close();
    }
}
