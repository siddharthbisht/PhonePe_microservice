package com.perpule.phonepay;

import com.perpule.phonepay.qrcode.qrinit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController

public class PhonepayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhonepayApplication.class, args);
    }

    @RequestMapping("/requestpayment")
    public String RequestPayment() {

        RequestPayment v = new RequestPayment();
        v.requestpayment_main();
        return v.getResponseData();
    }

    @RequestMapping("/checkpaymentstatus")
    public String CheckPaymentStatus() {

        CheckPaymentStatus c = new CheckPaymentStatus();
        c.checkpaymentstatus_main();
        return c.getResponseData();
    }


    @RequestMapping("/cancelpaymentrequest")
    public String CancelPaymentRequest() {

        CancelPaymentRequest can = new CancelPaymentRequest();
        can.cancelpaymentrequest_main();
        return can.getResponseData();
    }


    @RequestMapping("/remindpaymentrequest")
    public String RemindPaymentRequest() {

        RemindPaymentRequest remind = new RemindPaymentRequest();
        remind.remindpaymentrequest_main();
        return remind.getResponseData();
    }

    @RequestMapping("/qr/init")
    public String qrinit() {

        qrinit qr = new qrinit();
        qr.qrinit_main();
        return qr.getResponseData();
    }

}