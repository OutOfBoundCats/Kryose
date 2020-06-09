package com.kryose.kryose.Entity;


import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "apitransactions")
public class ApiTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userDetailsID")
    private UserDetail myUserDetails;

    @Column(name = "username")
    private String username;

    @Column(name = "transactionDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transactionDate;

    @Column(name="creditDeducted")
    private Long creditDeducted;

    @Column(name = "info")
    private String info;


}
