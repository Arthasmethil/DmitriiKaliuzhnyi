package com.epam.tc.hw05.support;

import java.util.List;
import lombok.AllArgsConstructor;

@lombok.Data
@AllArgsConstructor
public class DataForTests {

    private String title;
    private String login;
    private String password;
    private String displayedName;

    private List<String> expectedTextHeadMenu;
    private List<String> expectedTextLeftMenu;
    private List<String> expectedTextIcons;
    private List<String> expectedTextLogs;
    private List<String> expectedUserLogSection;
}
