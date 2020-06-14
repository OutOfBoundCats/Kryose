package com.kryose.kryose.Entity;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "money_transactions")
public class MoneyTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id")
    private MyUserDetails user_details_id;

    @Column(name = "amount")
    private int amount;
    @Column(name = "username")
    private String username;
    @Column(name = "transaction_date")
    private Date transactionDate;
    @Column(name = "info")
    private String info;
    @Column(name = "credits_deposited")
    private int credits_deposited;
    @Column(name = "current_plan_surcharge")
    private int current_plan_surcharge;

    public MoneyTransactions() {
    }

    public MoneyTransactions( int amount, String username, Date transactionDate, String info, int credits_deposited, int current_plan_surcharge) {

        this.amount = amount;
        this.username = username;
        this.transactionDate = transactionDate;
        this.info = info;
        this.credits_deposited = credits_deposited;
        this.current_plan_surcharge = current_plan_surcharge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MyUserDetails getUser_details_id() {
        return user_details_id;
    }

    public void setUser_details_id(MyUserDetails user_details_id) {
        this.user_details_id = user_details_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCredits_deposited() {
        return credits_deposited;
    }

    public void setCredits_deposited(int credits_deposited) {
        this.credits_deposited = credits_deposited;
    }

    public int getCurrent_plan_surcharge() {
        return current_plan_surcharge;
    }

    public void setCurrent_plan_surcharge(int current_plan_surcharge) {
        this.current_plan_surcharge = current_plan_surcharge;
    }
}
