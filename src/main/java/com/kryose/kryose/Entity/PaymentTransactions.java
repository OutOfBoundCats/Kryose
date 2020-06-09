package com.kryose.kryose.Entity;


import javax.persistence.*;

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




}
