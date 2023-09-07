package com.calculator.app.controller;

import com.calculator.app.process.MyCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final MyCalculator myCalculator;

    public CalculatorController(MyCalculator myCalculator){
        this.myCalculator=myCalculator;
    }

    @GetMapping("/add")
    public double addition(@RequestParam("a") int a,@RequestParam("b") int b){
        return a+b;
    }
    @GetMapping("/sub")
    public double substraction(@RequestParam("a") int a,@RequestParam("b") int b){
        return a-b;
    }
    @GetMapping("/mul")
    public double multiplication(@RequestParam("a") int a,@RequestParam("b") int b){
        return a*b;
    }
    @GetMapping("/div")
    public double division(@RequestParam("a") int a,@RequestParam("b") int b){
        return a/b;
    }

    @GetMapping("/addstr")
    public String stringAdd(@RequestParam("a") String a,@RequestParam("b") String b){
        return myCalculator.addString(a,b);
    }

    @GetMapping("/avg")
    public float averageValue(@RequestParam("a") int a,@RequestParam("b") int b){
        return myCalculator.averageData(a,b);
    }

}
