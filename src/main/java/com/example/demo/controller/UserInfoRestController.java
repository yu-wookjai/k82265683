package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/v1/user")
@RestController
public class UserInfoRestController {
    /**
     * 하드코딩 사번 리턴
     * @return 82265683
     */
    @GetMapping
    public String getUserNumber(){
        return "82265683";
    }

    /**
     * 입력된 사번 리턴
     * @param userNumber
     * @return {userNumber}
     */
    @GetMapping("/{userNumber}")
    public String getUserName(@PathVariable("userNumber") String userNumber){
        return userNumber;
    }
}
