package com.epam.tc.hw1.functions;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.providers.DataProviderForCalculator;
import org.testng.annotations.Test;

public class MultiplyOperationTest extends AbstractCalculatorOperationTest {

    @Test(
        groups = {"complexOperations"},
        dataProvider = "getTestDataForMultiply",
        dataProviderClass = DataProviderForCalculator.class)
    public void multiplyTest(long a, long b, long expected) {
        long actual =  calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
