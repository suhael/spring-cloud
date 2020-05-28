package com.suhael.spring.cloud.kinesis.producer.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloController {

  @GetMapping(consumes = "application/json", produces = "application/json")
  public String hello() {
    return "Hello";
  }

}
