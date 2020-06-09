package com.kryose.kryose.Dao;


import com.kryose.kryose.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CreditResourceDao {

    @Autowired
    EntityManager myEntityManager;

    public String addCreditByUsername(String theUserName,int amount){



        return "success";
    }
}
