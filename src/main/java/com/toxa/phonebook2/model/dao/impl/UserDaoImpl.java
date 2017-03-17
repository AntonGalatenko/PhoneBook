package com.toxa.phonebook2.model.dao.impl;

import com.toxa.phonebook2.model.dao.UserDao;
import com.toxa.phonebook2.model.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public User addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Transactional
    public User getUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
        return user;
    }

    @Transactional
    public User getUser(String login) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
        return user;
    }

    @Transactional
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().remove(user);
    }
}
