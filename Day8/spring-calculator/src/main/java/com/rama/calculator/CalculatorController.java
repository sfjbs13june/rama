package com.rama.calculator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public  class CalculatorController {


    @GetMapping("/add")

    public float addition(@RequestHeader(name = "a", required = true) float a,@RequestHeader(name = "b", required = true) float b) {
        return a+b;
    }

    @GetMapping("/sub")
    public float subtraction(@RequestHeader(name = "a", required = true) float a,@RequestHeader(name = "b", required = true) float b) {
        return a-b;
    }

    @GetMapping("/mul")
    public float multiplication(@RequestHeader(name = "a", required = true) float a,@RequestHeader(name = "b", required = true) float b) {
        return a*b;
    }

    @GetMapping("/div")
    public float division(@RequestHeader(name = "a", required = true) float a,@RequestHeader(name = "b", required = true) float b) {

        return a/b;
    }

    @GetMapping("/addstring")
    public String addString(@RequestHeader(name = "a", required = true) String a,@RequestHeader(name = "b", required = true) String b) {

        return a.concat(b);
    }

    @GetMapping("/sendpath/{version}")
    public String sendpath(@PathVariable String version) {
        System.out.println(version);
        return version;
    }

    @GetMapping("/operation/{opr}")
    public float doOpration(@PathVariable String opr,@RequestHeader(name = "a", required = true) float a ,@RequestHeader(name = "b", required = true) float  b) {
        System.out.println(opr);
        if(opr.equals("add")){
            return a+b;
        }
        if(opr.equals("sub")){
            return a-b;
        }
        if(opr.equals("mul")){
            return a*b;
        }
        if(opr.equals("div")){
            return a/b;
        }
        return a+b;
    }

}
