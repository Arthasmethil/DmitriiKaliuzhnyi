package com.epam.tc.hw1.functions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import com.epam.tc.hw1.providers.DataProviderForCalculator;
import org.testng.annotations.Test;

public class SubtractOperationTestDouble extends AbstractCalculatorOperationTest {

    @Test(
        groups = {"simpleOperations"},
        dataProvider = "getTestDataForSubtractWithDouble",
        dataProviderClass = DataProviderForCalculator.class)
    public void subtractTestWithDouble(double a, double b, double expected) {
        double actual =  calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected, within(0.01));
    }
}
