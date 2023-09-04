package com.rama.app;

import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    @GetMapping("/get")
    public String getData(){
        return "get data";
    }

    @PostMapping("/post")
    public String postData(){
        return "post data";
    }

    @PutMapping("/put")
    public String putData(){
        return "put data";
    }

    @DeleteMapping("/delete")
    public String deleteData(){
        return "delete data";
    }
}
