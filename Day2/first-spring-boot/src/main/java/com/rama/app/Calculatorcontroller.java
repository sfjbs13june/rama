package com.example.app;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Calculatorcontroller {
   @GetMapping("/hi")
    public String say(){

       return"Hiiiiiiiiiiii,Mounikaaaa";
   }
}
