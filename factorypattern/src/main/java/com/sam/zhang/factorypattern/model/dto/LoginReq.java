package com.sam.zhang.factorypattern.model.dto;

import lombok.Data;

@Data
public class LoginReq {

    private String name;
    private String password;

    private String phone;
    private String validateCode;//手机验证码

    private String wxCode;// wechat login

    private String type;
}
