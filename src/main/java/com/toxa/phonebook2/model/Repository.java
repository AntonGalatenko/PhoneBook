package com.toxa.phonebook2.model;

import com.toxa.phonebook2.config.RepositoryConfig;
import com.toxa.phonebook2.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class Repository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void doSomeThings(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }


}
