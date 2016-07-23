package com.sfdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ros on 23/07/2016.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home() {

        return "home";
    }
}
