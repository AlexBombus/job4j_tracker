package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FunctionInRangeTest {

    @Test
    public void whenLinearFunction() {
        List<Double> result = FunctionInRange.diapason(5, 8, (x) -> x);
        List<Double> expected = Arrays.asList(5D, 6D, 7D, 8D);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = FunctionInRange.diapason(5, 8, (x) -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D, 64D);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenFunction() {
        final int a = 2;
        List<Double> result = FunctionInRange.diapason(5, 8, (x) -> Math.pow(a, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D, 256D);
        Assert.assertEquals(result, expected);
    }

}