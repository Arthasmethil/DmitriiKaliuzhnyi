package com.epam.tc.hw5.support;

import java.util.List;
import lombok.AllArgsConstructor;

@lombok.Data
@AllArgsConstructor
public class DataForTests {

    private String title;
    private String login;
    private String password;
    private String displayedName;

    private List<String> expectedTextLogs;
    private List<String> expectedUserLogSection;
}
