package com.sfdc.controller;

import jdk.nashorn.internal.runtime.Debug;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ros on 25/07/2016.
 */
@Controller
@RequestMapping("/lightning")
public class LightningController {

    @RequestMapping(value = "")
    public String index() {
        System.out.println("*******************************");

        return "lightning";
    }
}
