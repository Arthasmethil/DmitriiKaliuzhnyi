package com.epam.tc.hw1.functions;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.providers.DataProviderForCalculator;
import org.testng.annotations.Test;

public class SubtractOperationTestLong extends AbstractCalculatorOperationTest {

    @Test(
        groups = {"simpleOperations"},
        dataProvider = "getTestDataForSubtractWithLong",
        dataProviderClass = DataProviderForCalculator.class)
    public void subtractTestWithLong(long a, long b, long expected) {
        long actual =  calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
