package com.kryose.kryose.Entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class PaymentTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userDetailsID")
    private UserDetail myUserDetail;

    @Column(name = "username")
    private String username;

    @Column(name = "transactionDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transactionDate;

    @Column(name = "endDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "info")
    private String info;




}
