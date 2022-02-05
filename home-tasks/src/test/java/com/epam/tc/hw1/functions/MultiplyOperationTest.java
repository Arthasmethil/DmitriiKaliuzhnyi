package com.epam.tc.hw1.functions;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import com.epam.tc.hw1.providers.DataProviderForCalculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiplyOperationTest {
    Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(
        dataProviderClass = DataProviderForCalculator.class,
        dataProvider = "getTestDataForMultiply")
    public void multiplyTest(long a, long b, long expected) {
        long actual =  calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
