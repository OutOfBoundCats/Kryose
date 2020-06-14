package com.kryose.kryose.Dao;


import com.kryose.kryose.Controller.AuthController;
import com.kryose.kryose.Entity.MoneyTransactions;
import com.kryose.kryose.Entity.MyUserDetails;
import com.kryose.kryose.Service.UserServiceImpl;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MoneyTransactionsDao {
    Logger logger= LoggerFactory.getLogger(AuthController.class);
    @Autowired
    EntityManager myEntityManager;
    @Autowired
    UserServiceImpl myUserServiceImp;

    public String makePayment(MoneyTransactions myMoneyTransaction){
        //saves MoneyTransaction object in database
        MyUserDetails myUserDetails;
        //get session from entitymanager
        Session currectSession=myEntityManager.unwrap(Session.class);
        //get MyUserDetails from UserServiceImp
        myUserDetails=myUserServiceImp.getMyuserDetailsByUsername(myMoneyTransaction.getUsername());
        logger.error(String.valueOf(myUserDetails));
        logger.error(String.valueOf(myUserDetails.getMyResource()));
        //set MyUserDetails of MoneyTransactions
        myMoneyTransaction.setUserDetailsID(myUserDetails);
        logger.error(String.valueOf(myMoneyTransaction));
        //Add MoneyTransactions to MyUserDetails
        myUserDetails.addMyMoneyTransactions(myMoneyTransaction);
        logger.error(String.valueOf(myUserDetails.getMyMoneyTransactions()));
        //SAVE transaction
        currectSession.save(myMoneyTransaction);

        return null;
    }

}
