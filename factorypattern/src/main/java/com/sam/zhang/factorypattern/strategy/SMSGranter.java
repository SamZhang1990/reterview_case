package com.sam.zhang.factorypattern.strategy;

import com.sam.zhang.factorypattern.model.dto.LoginReq;
import com.sam.zhang.factorypattern.model.dto.LoginResp;
import org.springframework.stereotype.Component;

@Component("sms")
public class SMSGranter implements UserGranter{
    @Override
    public LoginResp login(LoginReq loginReq) {
        System.out.println("strategy: SMS login");
        return new LoginResp();
    }
}
