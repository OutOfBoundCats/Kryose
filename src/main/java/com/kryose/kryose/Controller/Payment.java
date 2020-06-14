package com.kryose.kryose.Controller;


import com.kryose.kryose.Entity.In_Out.MoneyPayment_In;
import com.kryose.kryose.Entity.MoneyTransactions;
import com.kryose.kryose.Service.Payment.MoneyTransactionService;
import com.kryose.kryose.Service.Payment.Razorpay_Payment;
import com.kryose.kryose.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class Payment {

    @Autowired
    Razorpay_Payment myRazorpay;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    MoneyTransactionService myMoneyTransactionService;

    @GetMapping("/get_razor_key")
    public String getRazorKey(){
        String razorKey;
        razorKey=myRazorpay.getRazorpay_key_id();

        return razorKey;
    }

    @PostMapping("/makePayment")
    public String makePayment(@RequestBody MoneyPayment_In myMoneyPayement, HttpServletRequest request){

        String username = null;
        String jwt = null;
        final String authorizationHeader = request.getHeader("Authorization");
        jwt = authorizationHeader.substring(7);
        username = jwtUtil.extractUsername(jwt);
        MoneyTransactions myMoneyTransactions = new MoneyTransactions(500,username,null,"demo transaction",400,4 );


        myMoneyTransactionService.makePayment(myMoneyTransactions);


        return "success";
    }


}
