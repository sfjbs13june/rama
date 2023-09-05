package com.rama.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public double add(){
        return 9+3;
    }
    @GetMapping("/sub")
    public double substract(){
        return 9-3;
    }
    @GetMapping("/mul")
    public double mutiply(){
        return 9*3;
    }
    @GetMapping("/div")
    public double devision(){
        return 9/3;
    }

}
