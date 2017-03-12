package com.toxa.phonebook2.model.dao.impl;

import com.toxa.phonebook2.model.dao.UserDao;
import com.toxa.phonebook2.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    public User addUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getUser(Integer id) {
        Session session = sessionFactory.openSession();
        User user = (User) session.createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.close();
        return user;
    }

    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(user);
        session.getTransaction().commit();
        session.close();
    }
}
