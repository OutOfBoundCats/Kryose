package com.kryose.kryose.Controller;


import com.kryose.kryose.Service.Payment.Razorpay_Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Payment {

    @Autowired
    Razorpay_Payment myRazorpay;

    @GetMapping("/get_razor_key")
    public String getRazorKey(){
        String razorKey;
        razorKey=myRazorpay.getRazorpay_key_id();

        return razorKey;
    }


}
