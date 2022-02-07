package com.epam.tc.hw1.functions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import com.epam.tc.hw1.providers.DataProviderForCalculator;
import org.testng.annotations.Test;

public class GetSinOperationTest extends AbstractCalculatorOperationTest {

    @Test(
        groups = {"sinCosGroup"},
        dataProvider = "getTestDataForSin",
        dataProviderClass = DataProviderForCalculator.class)
    public void sinOperationTest(double a) {
        double actual = calculator.sin(a);
        double expected = Math.sin(a);
        assertThat(actual).isEqualTo(expected, within(0.01));
    }
}
