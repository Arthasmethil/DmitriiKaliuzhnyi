package com.epam.tc.hw1.functions;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.providers.DataProviderForCalculator;
import org.testng.annotations.Test;


public class AdditionOperationTestLong extends AbstractCalculatorOperationTest {

    @Test(
        groups = {"simpleOperations"},
        dataProvider = "getTestDataForAdditionWithLong",
        dataProviderClass = DataProviderForCalculator.class)
    public void additionTestWithLong(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
