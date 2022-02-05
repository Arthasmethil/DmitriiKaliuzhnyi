package com.epam.tc.hw1.functions;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import com.epam.tc.hw1.providers.DataProviderForCalculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DivideByZeroOperationTest {
    Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(
        expectedExceptions = NumberFormatException.class,
        dataProviderClass = DataProviderForCalculator.class,
        dataProvider = "getTestDataForDivideByZero")
    public void divideTest(long a, long b) throws NumberFormatException {
        assertThat(calculator.div(a, b)).isEqualTo(a / b);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
