package com.epam.tc.jdi.entities;

import com.jdiai.tools.DataClass;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User extends DataClass<User> {

    public String userName;
    public String password;
    public String displayedName;
}
