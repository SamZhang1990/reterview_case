package com.sam.zhang.factorypattern.service;

import com.sam.zhang.factorypattern.model.dto.LoginReq;
import com.sam.zhang.factorypattern.model.dto.LoginResp;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public LoginResp login(LoginReq loginReq) {

//        if (loginReq.getType().equals("account")) {
//            System.out.println("user account login");
//            return new LoginResp();
//        } else if (loginReq.getType().equals("sms")) {
//            System.out.println("sms login");
//            return new LoginResp();
//        } else if (loginReq.getType().equals("we_chat")) {
//            System.out.println("we chat login");
//            return new LoginResp();
//        }
//
//        LoginResp loginResp = new LoginResp();
//        loginResp.setSuccess(false);
//        System.out.println("login failed");
//        return loginResp;
        return new LoginResp();
    }
}
