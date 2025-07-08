package com.sam.zhang.chainpattern.handler;

import com.sam.zhang.chainpattern.entity.OrderInfo;

/**
 * the last step , no next step require
 */
public class OrderCreate extends Handler{
    @Override
    public void process(OrderInfo orderInfo) {
        System.out.println("Create order info");
    }
}
