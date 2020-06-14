package com.kryose.kryose.Dao;


import com.kryose.kryose.Controller.AuthController;
import com.kryose.kryose.Entity.MyUserDetails;
import com.kryose.kryose.Entity.User;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;

@Repository
public class UserDao {

    Logger logger= LoggerFactory.getLogger(AuthController.class);
    @Autowired
    EntityManager myEntityManager;

    public User findUserByUsername(String theUserName){
        logger.error("inside find user nby username");
        Session currectSession=myEntityManager.unwrap(Session.class);
        // now retrieve/read from database using username
        Query<User> theQuery = currectSession.createQuery("from User where userName=:uName", User.class);
        theQuery.setParameter("uName", theUserName);
        User theUser = null;
        try {
            logger.error("executing query");
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    public void save(User theUser) {
        // get current hibernate session
        logger.error("in dao method");
        Session currectSession=myEntityManager.unwrap(Session.class);
        logger.error("saving user in dao");
        // create the user ... finally LOL
        currectSession.saveOrUpdate(theUser);
    }

    public User deleteUser(String theUser) {

        logger.error("in dao delete method");
        logger.error("deleting user in dao");
        Session currectSession=myEntityManager.unwrap(Session.class);
        Query<User> theQuery = currectSession.createQuery("from User where userName=:uName", User.class);
        theQuery.setParameter("uName", theUser);
        User myUser = null;
        try {
            logger.error("executing delete query");
            myUser = theQuery.getSingleResult();
        } catch (Exception e) {
            myUser = null;
        }
        currectSession.delete(myUser);

        return myUser;
    }

    public MyUserDetails getMyuserDetailsByUsername(String username){
        //return MyUserDetails object from datatbase based on username
        MyUserDetails myUserDetails = null;
        Session currectSession=myEntityManager.unwrap(Session.class);
        Query<MyUserDetails> theQuery = currectSession.createQuery("from MyUserDetails where userName=:uName", MyUserDetails.class);
        theQuery.setParameter("uName", username);
        User myUser = null;
        try {
            logger.error("executing delete query");
            myUserDetails = theQuery.getSingleResult();
        } catch (Exception e) {
            myUser = null;
        }

        return myUserDetails;
    }








}
