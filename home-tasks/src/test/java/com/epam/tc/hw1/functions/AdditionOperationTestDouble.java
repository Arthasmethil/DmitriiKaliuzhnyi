package com.epam.tc.hw1.functions;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import com.epam.tc.hw1.providers.DataProviderForCalculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdditionOperationTestDouble {
    Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(
        dataProviderClass = DataProviderForCalculator.class,
        dataProvider = "getTestDataForAdditionWithDouble")
    public void additionTestWithDouble(double a, double b, double expected) {
        double actual =  calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
