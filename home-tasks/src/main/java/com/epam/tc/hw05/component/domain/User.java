package com.epam.tc.hw05.component.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    @NonNull
    private String number;
    @NonNull
    private String name;
    @NonNull
    private String description;
}
