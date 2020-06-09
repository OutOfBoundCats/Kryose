package com.kryose.kryose.Dao;


import com.kryose.kryose.Entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;

@Repository
public class UserDao {

    @Autowired
    EntityManager myEntityManager;

    public User findUserByUsername(String theUserName){

        Session currectSession=myEntityManager.unwrap(Session.class);
        // now retrieve/read from database using username
        Query<User> theQuery = currectSession.createQuery("from User where userName=:uName", User.class);
        theQuery.setParameter("uName", theUserName);
        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    public void save(User theUser) {
        // get current hibernate session
        Session currectSession=myEntityManager.unwrap(Session.class);

        // create the user ... finally LOL
        currectSession.saveOrUpdate(theUser);
    }





}
