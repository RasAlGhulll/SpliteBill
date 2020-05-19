package com.splitbill.splitbillapp.tansaction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @GetMapping(value = "/transcation")
    public String getTransaction(){
        return "Hello from transaction";
    }
}
