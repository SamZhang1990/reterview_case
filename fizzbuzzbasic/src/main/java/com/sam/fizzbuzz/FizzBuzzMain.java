package com.sam.fizzbuzz;

import com.sam.fizzbuzz.enumeration.FizzBuzzEnum;
import com.sam.fizzbuzz.service.FizzBuzzService;
import com.sam.fizzbuzz.service.IntegerStringService;
import com.sam.fizzbuzz.service.impl.FizzBuzzServiceImpl;
import com.sam.fizzbuzz.service.impl.IntegerToBuzzServiceImpl;
import com.sam.fizzbuzz.service.impl.IntegerToFizzServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzMain {
    public static void main(String[] args) {
        FizzBuzzService fizzBuzzService = new FizzBuzzServiceImpl();
        List<IntegerStringService> integerStringServiceList = new ArrayList<>();
        integerStringServiceList.add(new IntegerToBuzzServiceImpl());
        integerStringServiceList.add(new IntegerToFizzServiceImpl());

        for (int i=1; i<=100; i++) {
            System.out.println(fizzBuzzService.output(i, integerStringServiceList, FizzBuzzEnum.APPEND_BY_ASC));
        }
    }
}
