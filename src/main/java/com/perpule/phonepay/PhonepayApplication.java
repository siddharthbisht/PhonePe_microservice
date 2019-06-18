package com.perpule.phonepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController

public class PhonepayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhonepayApplication.class, args);
    }

    @RequestMapping("/xverify")
    public String xverify() {

        Xverify v = new Xverify();
        v.xverify_main();
        return v.getResponseData();
    }

}
