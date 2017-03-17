package com.toxa.phonebook2.model.dao.impl;

import com.toxa.phonebook2.model.dao.PhoneDao;
import com.toxa.phonebook2.model.entity.Phone;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class PhoneDaoImpl implements PhoneDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Phone addPhone(Phone phone) {
        sessionFactory.getCurrentSession().save(phone);
        return phone;
    }

    @Transactional
    public void updatePhone(Phone phone) {
        sessionFactory.getCurrentSession().saveOrUpdate(phone);
    }

    @Transactional
    public Phone getPhone(Integer id) {
        Phone phone = (Phone) sessionFactory.getCurrentSession().createCriteria(Phone.class).add(Restrictions.eq("id", id)).uniqueResult();
        return phone;
    }

    @Transactional
    public Phone getPhone(String phoneMobile) {
        Phone phone = (Phone) sessionFactory.getCurrentSession().createCriteria(Phone.class).add(Restrictions.eq("phoneMobile", phoneMobile)).uniqueResult();
        return phone;
    }

    @Transactional
    public Collection<Phone> getAllPhones() {
        List<Phone> phoneList = (List<Phone>) sessionFactory.getCurrentSession().createCriteria(Phone.class).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
        return phoneList;
    }

    @Transactional
    public void deletePhone(String phoneMobile) {
        if(phoneMobile.indexOf("+") != 0)
            phoneMobile = "+" + phoneMobile;

        Phone phone = (Phone) sessionFactory.getCurrentSession().createCriteria(Phone.class).add(Restrictions.eq("phoneMobile", phoneMobile)).uniqueResult();
        sessionFactory.getCurrentSession().delete(phone);
    }
}
