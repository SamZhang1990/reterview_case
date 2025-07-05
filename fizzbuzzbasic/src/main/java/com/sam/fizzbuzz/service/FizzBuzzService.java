package com.sam.fizzbuzz.service;

import com.sam.fizzbuzz.enumeration.FizzBuzzEnum;

import java.util.List;

public interface FizzBuzzService {
    String output(int n, List<IntegerStringService> integerStringServiceList, FizzBuzzEnum fizzBuzzEnum);
}
