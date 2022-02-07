package com.epam.tc.hw1.functions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import com.epam.tc.hw1.providers.DataProviderForCalculator;
import org.testng.annotations.Test;

public class AdditionOperationTestDouble extends AbstractCalculatorOperationTest {

    @Test(
        groups = {"simpleOperations"},
        dataProvider = "getTestDataForAdditionWithDouble",
        dataProviderClass = DataProviderForCalculator.class)
    public void additionTestWithDouble(double a, double b, double expected) {
        double actual =  calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected, within(0.01));
    }
}
