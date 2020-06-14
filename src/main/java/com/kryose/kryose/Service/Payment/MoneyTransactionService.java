package com.kryose.kryose.Service.Payment;


import com.kryose.kryose.Dao.MoneyTransactionsDao;
import com.kryose.kryose.Entity.MoneyTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyTransactionService {
    @Autowired
    MoneyTransactionsDao myMoneyTransactionDao;

    public String makePayment(MoneyTransactions myMoneyTransactions){

        return myMoneyTransactionDao.makePayment(myMoneyTransactions);
    }
}
