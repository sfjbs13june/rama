package com.rama.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HeaderController {

  @PostMapping("/send/data")
  public ResponseEntity sendData(@RequestHeader("sessionid") String sessionid) {

    if (sessionid == null) {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    System.out.println(sessionid);
    return new ResponseEntity(HttpStatus.OK);
  }
}
