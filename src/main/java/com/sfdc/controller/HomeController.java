package com.sfdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

/**
 * Created by Ros on 23/07/2016.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(Model model) {
        //System.out.println("HomeController");
        int year = Calendar.getInstance().get(Calendar.YEAR);
        model.addAttribute("year", year);

        return "home";
    }
}
