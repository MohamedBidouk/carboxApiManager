package com.carbox.apimanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApimanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApimanagerApplication.class, args);
    }
    @GetMapping("/Apimanager/status")
    public ResponseEntity<?> getApiManagerStatus(){
        return new ResponseEntity<>("I'm active api manager", HttpStatus.OK);
    }
    @GetMapping("/facebook")
    public String redirectToFacebook() {
        return "redirect:https://www.facebook.com";
    }

}
