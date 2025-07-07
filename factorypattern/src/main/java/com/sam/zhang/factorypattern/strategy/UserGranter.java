package com.sam.zhang.factorypattern.strategy;

import com.sam.zhang.factorypattern.model.dto.LoginReq;
import com.sam.zhang.factorypattern.model.dto.LoginResp;

public interface UserGranter {
    /**
     *
     * @param loginReq
     * @return
     */
    LoginResp login(LoginReq loginReq);
}
