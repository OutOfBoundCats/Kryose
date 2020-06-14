package com.kryose.kryose.Service.Payment;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class Razorpay_Payment implements PaymentInterface{

    //https://razorpay.com/docs/server-integration/java/usage/
    @Autowired
    private Environment env;

    @Value("${razorpay_key_id}")
    private String razorpay_key_id;

    public String getRazorpay_key_id() {
        return razorpay_key_id;
    }


    @Override
    public String make_Payment() {
        return null;
    }

    @Override
    public String start_subscription() {
        return null;
    }


}
