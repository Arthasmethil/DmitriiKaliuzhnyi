package com.epam.tc.jdi.data.support;

import com.epam.tc.jdi.support.MetalColorsData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import lombok.SneakyThrows;

public class JsonMapper {

    private static final String PATH_TO_JSON_DATA = "src\\test\\resources\\jdi\\JDI_ex8_metalsColorsDataSet.json";

    @SneakyThrows
    public static Map<String, MetalColorsData> parseJson() {
        Map<String, MetalColorsData> dataFromJson;
        ObjectMapper mapper = new ObjectMapper();

        TypeReference<HashMap<String, MetalColorsData>> typeRef
            = new TypeReference<HashMap<String, MetalColorsData>>() {};
        dataFromJson = mapper.readValue(new File(PATH_TO_JSON_DATA), typeRef);
        return dataFromJson;
    }
}

