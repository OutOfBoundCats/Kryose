package com.kryose.kryose.Entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.*;


@Entity
@Table(name = "resource")
public class CreditResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "credits")
    private Long creditsAvailable;

    @Column(name = "startDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime stratDate;

    @Column(name = "endDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "myCreditResource",fetch = FetchType.LAZY)
    private List<UserDetail> userDetailList;



}
