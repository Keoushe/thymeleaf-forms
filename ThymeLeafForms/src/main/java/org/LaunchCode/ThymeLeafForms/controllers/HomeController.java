package org.LaunchCode.ThymeLeafForms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String indexReturned(){
        return "index";
    }


}
