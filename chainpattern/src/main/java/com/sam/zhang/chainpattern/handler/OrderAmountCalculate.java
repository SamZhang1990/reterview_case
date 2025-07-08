package com.sam.zhang.chainpattern.handler;

import com.sam.zhang.chainpattern.entity.OrderInfo;

public class OrderAmountCalculate extends Handler{
    @Override
    public void process(OrderInfo orderInfo) {
        System.out.println("Calculate order amount");
        handler.process(orderInfo);
    }
}
