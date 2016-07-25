package com.sfdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by matro on 24/07/2016.
 */
@Controller
@RequestMapping("/about")
public class AboutController {

    @RequestMapping(value = "")
    public String about() {

        return "about";
    }
}
