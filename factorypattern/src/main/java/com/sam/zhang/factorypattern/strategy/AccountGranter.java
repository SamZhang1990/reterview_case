package com.sam.zhang.factorypattern.strategy;

import com.sam.zhang.factorypattern.model.dto.LoginReq;
import com.sam.zhang.factorypattern.model.dto.LoginResp;
import org.springframework.stereotype.Component;

@Component("account")
public class AccountGranter implements UserGranter {
    @Override
    public LoginResp login(LoginReq loginReq) {
        System.out.println("Strategy: account login");
        return new LoginResp();
    }
}
