package com.sam.fizzbuzz.service.impl;

import com.sam.fizzbuzz.enumeration.FizzBuzzEnum;
import com.sam.fizzbuzz.exception.FizzBuzzException;
import com.sam.fizzbuzz.service.FizzBuzzService;
import com.sam.fizzbuzz.service.IntegerStringService;

import java.util.List;

public class FizzBuzzServiceImpl implements FizzBuzzService {

    @Override
    public String output(int n, List<IntegerStringService> integerStringServiceList, FizzBuzzEnum fizzBuzzEnum) {

        StringBuffer sb = new StringBuffer();

        if (FizzBuzzEnum.APPEND_BY_ASC.getCode().equalsIgnoreCase(fizzBuzzEnum.getCode())) {
            try {
                for (IntegerStringService service : integerStringServiceList) {
                    if (service.support(n)) {
                        sb.append(service.convert());
                    }
                }

                if (sb.isEmpty()) {
                    sb.append(n);
                }
            } catch (Exception e) {
                throw new FizzBuzzException("n cannot be converted to String");
            }
        } else {
            throw new FizzBuzzException(fizzBuzzEnum.getCode() + " cannot bu supported");
        }
        return sb.toString();
    }
}
