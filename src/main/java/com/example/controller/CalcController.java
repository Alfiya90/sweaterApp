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
        double resault;

        switch (operation){
            case "multiplication":
                resault = a*b;
                break;
            case "addition":
                resault =a+b;
                break;
            case "subtraction":
                resault = a-b;
                break;
            case "division":
                resault = (double) a/b;
                break;
            default: resault = 0;
        }


        model.addAttribute("massage", resault);
        return "calculation";
    }


}
