package com.epam.tc.hw1.functions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.epam.tc.hw1.providers.DataProviderForCalculator;
import org.testng.annotations.Test;

public class DivideOperationTest extends AbstractCalculatorOperationTest {

    @Test(
        groups = {"complexOperations"},
        dataProvider = "getTestDataForDivide",
        dataProviderClass = DataProviderForCalculator.class)
    public void divideTest(long a, long b, long expected) {
        long actual =  calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(
        groups = {"complexOperations"},
        dataProvider = "getTestDataForDivideByZero",
        dataProviderClass = DataProviderForCalculator.class)
    public void divideByZeroTest(long a, long b) throws NumberFormatException {
        assertThatThrownBy(() -> calculator.div(a, b))
            .isInstanceOf(NumberFormatException.class)
            .hasMessageContaining("Attempt to divide by zero");
    }
}
