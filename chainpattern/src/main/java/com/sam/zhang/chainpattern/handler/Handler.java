package com.sam.zhang.chainpattern.handler;

import com.sam.zhang.chainpattern.entity.OrderInfo;

public abstract class Handler {
    protected Handler handler;

    public void setNext(Handler handler) {
        this.handler = handler;
    }

    /**
     *
     * @param orderInfo
     */
    public abstract void process(OrderInfo orderInfo);
}
