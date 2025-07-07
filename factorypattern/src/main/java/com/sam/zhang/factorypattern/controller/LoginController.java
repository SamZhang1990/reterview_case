package com.sam.zhang.factorypattern.controller;

import com.sam.zhang.factorypattern.model.dto.LoginReq;
import com.sam.zhang.factorypattern.model.dto.LoginResp;
import com.sam.zhang.factorypattern.service.UserService;
import com.sam.zhang.factorypattern.strategy.UserGranter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class LoginController {

    private Map<String, UserGranter> userGranterMap;
//
//    @Autowired
//    private UserService userService;

    public LoginController(Map<String, UserGranter> userGranterMap) {
        this.userGranterMap = userGranterMap;
    }

    @PostMapping("/login")
    public LoginResp login(@RequestBody LoginReq loginReq) {
        UserGranter userGranter = userGranterMap.get(loginReq.getType());
        if (userGranter == null) {
            return new LoginResp();
        }

        return userGranter.login(loginReq);
    }
}
