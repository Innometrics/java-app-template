package com.innometrics.integrationapp.gettingstart;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by killpack on 13.01.15.
 */
@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping(value = "/")
    public String root() {
        return "test";
    }

    @RequestMapping(value = "/payments")
    public String allPayments() {
        return "123.jsp";
    }
}
