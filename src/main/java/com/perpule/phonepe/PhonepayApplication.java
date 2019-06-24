package com.perpule.phonepe;

/*import com.perpule.phonepay.model.qrcode.qrinit;*/
import com.perpule.phonepe.BO.AllocateTransactionId;
import com.perpule.phonepe.BO.Phonepe.CancelPayment;
import com.perpule.phonepe.BO.Phonepe.CheckPaymentStatus;
import com.perpule.phonepe.BO.Phonepe.RemindPayment;
import com.perpule.phonepe.BO.Phonepe.RequestPayment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController

public class PhonepayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhonepayApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }


    @RequestMapping("/initiate")
    public void initiate(@RequestParam(value ="number",defaultValue = "0")String number,
                         @RequestParam(value="totalamount", defaultValue="0.00") String totalamount){
        AllocateTransactionId allocate = new AllocateTransactionId();
        String txnID = allocate.Get_transactionID();

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

        CancelPayment can = new CancelPayment();
        can.cancelpaymentrequest_main();
        return can.getResponseData();
    }


    @RequestMapping("/remindpaymentrequest")
    public String RemindPaymentRequest() {

        RemindPayment remind = new RemindPayment();
        remind.remindpaymentrequest_main();
        return remind.getResponseData();
    }
/*
    @RequestMapping("/qr/init")
    public String qrinit() {

        qrinit qr = new qrinit();
        qr.qrinit_main();
        return qr.getResponseData();
    }*/

}
