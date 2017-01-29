package com.sfdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by matro on 29-Jan-17.
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "")
    public String index() {
        System.out.println("*******************************");

        return "api";
    }
}
