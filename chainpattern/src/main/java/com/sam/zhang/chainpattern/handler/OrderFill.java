package com.sam.zhang.chainpattern.handler;

import com.sam.zhang.chainpattern.entity.OrderInfo;

public class OrderFill extends Handler{
    @Override
    public void process(OrderInfo orderInfo) {
        System.out.println("Fill order info");
        handler.process(orderInfo);
    }
}
