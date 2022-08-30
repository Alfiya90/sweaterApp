package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@RequestMapping("/first")
@Controller
public class CalcController {

    public CalcController(){
        System.out.println("-------------------------");
    }
    @GetMapping("/calculation")
    public String calculation(@RequestParam(value = "a", required = false) int a,
                              @RequestParam(value =  "b", required = false) int b,
                              @RequestParam (value = "operation",required = false) String operation,
                              Model model){
        int x;

        if ("multiplication".equals(operation)){
            x = (a*b);
        }
        if ("addition".equals(operation)){
            x = a+b;
        }
        if ("subtraction".equals(operation)){
            x = a-b;
        } else x = a/b;
        model.addAttribute("massage", x);
        return "calculation";
    }

    @GetMapping("/")
    public Integer get(){
        return new Integer(5);
    }
}
