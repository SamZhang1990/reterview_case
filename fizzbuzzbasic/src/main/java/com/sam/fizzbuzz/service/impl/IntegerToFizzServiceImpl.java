package com.sam.fizzbuzz.service.impl;

import com.sam.fizzbuzz.constant.Constant;
import com.sam.fizzbuzz.service.IntegerStringService;

public class IntegerToFizzServiceImpl implements IntegerStringService {
    @Override
    public boolean support(int n) {
        return String.valueOf(n).contains("3") || n % 3 == 0;
    }

    @Override
    public String convert() {
        return Constant.FIZZ;
    }
}
