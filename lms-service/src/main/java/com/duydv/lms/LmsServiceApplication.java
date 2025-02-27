package com.duydv.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LmsServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(LmsServiceApplication.class, args);
  }

}
