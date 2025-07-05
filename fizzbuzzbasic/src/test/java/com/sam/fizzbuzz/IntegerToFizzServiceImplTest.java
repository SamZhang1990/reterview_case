package com.sam.fizzbuzz;

import com.sam.fizzbuzz.constant.Constant;
import com.sam.fizzbuzz.service.impl.IntegerToFizzServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(JUnit4ClassRunner.class)
public class IntegerToFizzServiceImplTest {

    private IntegerToFizzServiceImpl integerToFizzService;

    @Before
    public void initService() {
        integerToFizzService = new IntegerToFizzServiceImpl();
    }

    @Test
    public void testSupport() {
        int n = 3;
        Assert.assertTrue(integerToFizzService.support(n));
    }

    @Test
    public void testSupport02() {
        int n = 9;
        Assert.assertTrue(integerToFizzService.support(n));
    }

    @Test
    public void testNotSupport() {
        int n = 2;
        Assert.assertFalse(integerToFizzService.support(n));
    }

    @Test
    public void testConvert() {
        Assert.assertEquals(Constant.FIZZ, integerToFizzService.convert());
    }

}
