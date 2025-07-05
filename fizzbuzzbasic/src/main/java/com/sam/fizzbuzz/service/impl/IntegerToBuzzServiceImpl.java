package com.sam.fizzbuzz.service.impl;

import com.sam.fizzbuzz.constant.Constant;
import com.sam.fizzbuzz.service.IntegerStringService;

public class IntegerToBuzzServiceImpl implements IntegerStringService {
    @Override
    public boolean support(int n) {
        return String.valueOf(n).contains("5") || n % 5 == 0;
    }

    @Override
    public String convert() {
        return Constant.BUZZ;
    }
}
