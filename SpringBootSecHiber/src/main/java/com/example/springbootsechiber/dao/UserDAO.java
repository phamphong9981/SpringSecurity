package com.example.springbootsechiber.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.springbootsechiber.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository(value = "userDAO")
@Transactional(rollbackFor = Exception.class)
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public User loadUserByUsername(final String username) {
        List<User> users = new ArrayList<User>();
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println("a");
        users = session.createQuery("from User where username=:username", User.class).setParameter("username", username).list();
        System.out.println("b");
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
