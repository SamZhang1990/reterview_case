package com.sam.fizzbuzz;

import com.sam.fizzbuzz.constant.Constant;
import com.sam.fizzbuzz.enumeration.FizzBuzzEnum;
import com.sam.fizzbuzz.exception.FizzBuzzException;
import com.sam.fizzbuzz.service.IntegerStringService;
import com.sam.fizzbuzz.service.impl.FizzBuzzServiceImpl;
import com.sam.fizzbuzz.service.impl.IntegerToBuzzServiceImpl;
import com.sam.fizzbuzz.service.impl.IntegerToFizzServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzServiceImplTest {
    private FizzBuzzServiceImpl fizzBuzzService;
    private List<IntegerStringService> integerStringServiceList;

    @Before
    public void init() {
        fizzBuzzService = new FizzBuzzServiceImpl();
        integerStringServiceList = new ArrayList<>();
        integerStringServiceList.add(new IntegerToFizzServiceImpl());
        integerStringServiceList.add(new IntegerToBuzzServiceImpl());
    }

    @Test
    public void testNoConvert() {
        int n = 2;
        Assert.assertEquals(String.valueOf(n), fizzBuzzService.output(n, integerStringServiceList, FizzBuzzEnum.APPEND_BY_ASC));
    }

    @Test
    public void testFizzConvertOnly() {
        int n = 13;
        Assert.assertEquals(Constant.FIZZ, fizzBuzzService.output(n, integerStringServiceList, FizzBuzzEnum.APPEND_BY_ASC));
    }

    @Test
    public void testBuzzConvertOnly() {
        int n = 20;
        Assert.assertEquals(Constant.BUZZ, fizzBuzzService.output(n, integerStringServiceList, FizzBuzzEnum.APPEND_BY_ASC));
    }

    @Test
    public void testBothFizzBuzzConvert() {
        int n = 15;
        String expect = Constant.FIZZ + Constant.BUZZ;
        Assert.assertEquals(expect, fizzBuzzService.output(n, integerStringServiceList, FizzBuzzEnum.APPEND_BY_ASC));
    }

    @Test(expected = FizzBuzzException.class)
    public void testExceptionWhenNotAppendTypeNotSupported() {
        int n = 1;
        Assert.assertEquals(Constant.BUZZ, fizzBuzzService.output(n, integerStringServiceList, FizzBuzzEnum.APPEND_BY_DESC));
    }

}
