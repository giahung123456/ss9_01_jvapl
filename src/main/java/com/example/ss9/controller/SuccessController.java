package com.example.ss9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessController {
    @GetMapping("/success")
    public String eargeag(){
        return "success";
    }
}
