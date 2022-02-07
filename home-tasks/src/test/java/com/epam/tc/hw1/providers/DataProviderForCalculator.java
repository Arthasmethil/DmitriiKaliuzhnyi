package com.epam.tc.hw1.providers;

import org.testng.annotations.DataProvider;

public class DataProviderForCalculator {
    @DataProvider(name = "getTestDataForAdditionWithLong")
    public static Object[][] getTestDataForAdditionWithLong() {
        return new Object[][] {
            {-2, 3, 1},
            {8, 0, 8},
            {152, 50, 202},
            {1L, 12L, 13L}
        };
    }

    @DataProvider(name = "getTestDataForAdditionWithDouble")
    public static Object[][] getTestDataForAdditionWithDouble() {
        return new Object[][] {
            {6.0, 3.0, 9.0},
            {-7.0, 3.4, -3.6},
            {10.0, 3.30, 13.30},
            {2.0, 0.0, 2.0}
        };
    }

    @DataProvider(name = "getTestDataForSubtractWithLong")
    public static Object[][] getTestDataForSubtractWithLong() {
        return new Object[][] {
            {-2, -4, 2},
            {75, 50, 25},
            {123, 124, -1},
            {2L, -3L, 5}
        };
    }

    @DataProvider(name = "getTestDataForSubtractWithDouble")
    public static Object[][] getTestDataForSubtractWithDouble() {
        return new Object[][] {
            {8.5, 3.2, 5.3},
            {-2.2, -4.2, 2.0},
            {0.0, 4.0, -4.0},
            {75.25, 50.25, 25.0},
        };
    }

    @DataProvider(name = "getTestDataForMultiply")
    public static Object[][] getTestDataForMultiply() {
        return new Object[][] {
            {7, 7, 49},
            {-3, 3, -9},
            {0, 1, 0},
            {3, 0, 0},
            {25, 25, 625},
            {-5L, -5L, 25L},
            {2L, -3L, -6L}
        };
    }

    @DataProvider(name = "getTestDataForDivide")
    public static Object[][] getTestDataForDivide() {
        return new Object[][] {
            {15, 3, 5},
            {-8, 2, -4},
            {0, 2, 0},
            {150, 50, 3},
            {12L, 1L, 12L},
            {6L, -3L, -2L}
        };
    }

    @DataProvider(name = "getTestDataForDivideByZero")
    public static Object[][] getTestDataForDivideByZero() {
        return new Object[][] {
            {0, 0},
            {8, 0},
            {-12, 0},
        };
    }

    @DataProvider(name = "getTestDataForSin")
    public static Object[][] getTestDataForSin() {
        return new Object[][] {
            {15},
            {-8},
            {0},
            {150},
            {12L},
            {6L}
        };
    }

}
