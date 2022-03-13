package com.epam.tc.jdi.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.jdi.support.MetalColorsData;
import java.util.List;

@Url("metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @UI("#elements-checklist > .checkbox")
    public static WebList elements;

    @UI("[name*=custom_radio]")
    public static RadioButtons radioButtons;

    @ByText("Calculate")
    public static Button calculate;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
               list = "li", expand = ".caret")
    public static DropdownExpand colors;

    @JDropdown(root = "div[ui=combobox]", value = "input",
               list = "li", expand = ".caret")
    public static Dropdown metals;


    @JDropdown(root = "#salad-dropdown", value = ".dropdown-menu",
               list = "li", expand = ".caret")
    public static Dropdown vegetables;

    @ByText("Submit")
    public static Button submit;

    @UI(".results > .summ-res")
    public static Text resultSummary;

    @UI(".results > .elem-res")
    public static Text resultElements;

    @UI(".results > .col-res")
    public static Text resultColor;

    @UI(".results > .met-res")
    public static Text resultMetals;

    @UI(".results > .sal-res")
    public static Text resultVegetables;

    //Action step
    public void fillMetalColorForm(MetalColorsData data) {
        radioButtons.select(data.getSummary().get(0).toString(), data.getSummary().get(1).toString());
        calculate.click();

        data.getElements().forEach(elements::select);

        colors.select(data.getColor());

        metals.select(data.getMetals());

        vegetables.select("Vegetables");
        data.getVegetables().forEach(vegetables::select);

        submit.click();
    }

    // Assertion steps
    public static void assertRadioSum(List<Integer> integerList) {
        int sum = integerList.stream().mapToInt(elem -> elem).sum();
        resultSummary.is().text(String.format("Summary: %s", sum));
    }

    public static void assertElements(List<String> expectedElements) {
        String expectedElementsInRow = String.join(", ", expectedElements);
        resultElements.is().text(String.format("Elements: %s", expectedElementsInRow));
    }

    public static void assertColor(String expectedColor) {
        resultColor.is().text(String.format("Color: %s", expectedColor));
    }

    public static void assertMetal(String expectedMetal) {
        resultMetals.is().text(String.format("Metal: %s", expectedMetal));
    }

    public static void assertVegetables(List<String> expectedVegetables) {
        String expectedVegetablesInRow = String.join(", ", expectedVegetables);
        resultVegetables.is().text(String.format("Vegetables: %s", expectedVegetablesInRow));
    }

    public void assertFilledForm(MetalColorsData data) {
        assertRadioSum(data.getSummary());
        assertElements(data.getElements());
        assertColor(data.getColor());
        assertMetal(data.getMetals());
        assertVegetables(data.getVegetables());
    }

}
