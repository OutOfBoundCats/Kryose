package com.kryose.kryose.Dao;


import com.kryose.kryose.Entity.MoneyTransactions;
import com.kryose.kryose.Entity.MyUserDetails;
import com.kryose.kryose.Service.UserServiceImpl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class MoneyTransactionsDao {

    @Autowired
    EntityManager myEntityManager;
    @Autowired
    UserServiceImpl myUserServiceImp;

    public String makePayment(MoneyTransactions myMoneyTransaction){

        MyUserDetails myUserDetails;
        Session currectSession=myEntityManager.unwrap(Session.class);
        currectSession.save(myMoneyTransaction);
        //myUserServiceImp.getMyuserDetailsByUsername()
        myUserDetails=myUserServiceImp.getMyuserDetailsByUsername(myMoneyTransaction.getUsername());
        myUserDetails.addMyMoneyTransactions(myMoneyTransaction);
        myMoneyTransaction.setUser_details_id(myUserDetails);
        currectSession.save(myUserDetails);

        return null;
    }

}
