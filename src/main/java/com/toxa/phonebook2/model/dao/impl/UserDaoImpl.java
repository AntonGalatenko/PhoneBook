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
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();

//        UserRole role = (UserRole)session.createCriteria(UserRole.class)
//                .add(Restrictions.eq("type", UserRoleEnum.USER.getUserRoleType())).uniqueResult();
//        user.setRole(role);

        sessionFactory.getCurrentSession().save(user);
//        session.getTransaction().commit();
//        session.close();
        return user;
    }

    @Transactional
    public void updateUser(User user) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
        sessionFactory.getCurrentSession().saveOrUpdate(user);
//        session.getTransaction().commit();
//        session.close();
    }

    @Transactional
    public User getUser(Integer id) {
//        Session session = sessionFactory.openSession();
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
//        session.close();
        return user;
    }

    @Transactional
    public User getUser(String login) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
        return user;
    }

    @Transactional
    public void deleteUser(User user) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
        sessionFactory.getCurrentSession().remove(user);
//        session.getTransaction().commit();
//        session.close();
    }
}
