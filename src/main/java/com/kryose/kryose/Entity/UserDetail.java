package com.kryose.kryose.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userDetails")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resourceID")
    private CreditResource myCreditResource;

    @OneToMany(mappedBy = "myUserDetail")
    private List<PaymentTransactions> myPaymentTransactions;

    @OneToMany(mappedBy = "myUserDetails")
    private  List<ApiTransactions> ApiTransactions;






}
