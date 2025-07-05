package com.sam.fizzbuzz;

import com.sam.fizzbuzz.constant.Constant;
import com.sam.fizzbuzz.service.impl.IntegerToBuzzServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegerToBuzzServiceImplTest {
    private IntegerToBuzzServiceImpl integerToBuzzService;

    @Before
    public void init() {
        integerToBuzzService = new IntegerToBuzzServiceImpl();
    }

    @Test
    public void testSupport01() {
        int n = 5;
        Assert.assertTrue(integerToBuzzService.support(n));
    }

    @Test
    public void testSupport02() {
        int n = 20;
        Assert.assertTrue(integerToBuzzService.support(n));
    }

    @Test
    public void testConcert() {
        Assert.assertEquals(Constant.BUZZ, integerToBuzzService.convert());
    }
}
