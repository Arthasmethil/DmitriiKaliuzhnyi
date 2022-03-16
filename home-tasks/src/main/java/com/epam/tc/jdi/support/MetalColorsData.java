package com.epam.tc.jdi.support;

import com.jdiai.tools.DataClass;
import java.util.List;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@lombok.Data
public class MetalColorsData extends DataClass<MetalColorsData> {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;
}
