package com.sam.zhang.chainpattern.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderInfo {
    private String productId;
    private String userId;
    private BigDecimal amount;

}
