package com.sam.zhang.factorypattern.strategy;

import com.sam.zhang.factorypattern.model.dto.LoginReq;
import com.sam.zhang.factorypattern.model.dto.LoginResp;
import org.springframework.stereotype.Component;

@Component("we_chat")
public class WeChatGranter implements UserGranter{
    @Override
    public LoginResp login(LoginReq loginReq) {
        System.out.println("strategy: we_chat login");
        return new LoginResp();
    }
}
