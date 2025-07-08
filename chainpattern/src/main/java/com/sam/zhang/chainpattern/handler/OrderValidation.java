package com.sam.zhang.chainpattern.handler;

import com.sam.zhang.chainpattern.entity.OrderInfo;

public class OrderValidation extends Handler{
    @Override
    public void process(OrderInfo orderInfo) {
        System.out.println("Valid the order info");
        handler.process(orderInfo);
    }
}
