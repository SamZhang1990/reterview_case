package com.sam.zhang.chainpattern.handler;

import com.sam.zhang.chainpattern.entity.OrderInfo;

public class OrderApp {
    public static void main(String[] args) {
        /**
         *
         */
        Handler orderValidation = new OrderValidation();

        Handler orderFill = new OrderFill();

        Handler orderAmountCalculate = new OrderAmountCalculate();

        Handler orderCreate = new OrderCreate();

        orderValidation.setNext(orderFill);

        orderFill.setNext(orderAmountCalculate);

        orderAmountCalculate.setNext(orderCreate);

        orderValidation.process(new OrderInfo());

    }
}
