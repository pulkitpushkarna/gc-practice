package com.springmvc.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by diwakar on 17/09/17.
 */
public enum UserRole {
    ROLE_GOD("God"), ROLE_ADMIN("Admin"), ROLE_NEWER("Newer");

    UserRole(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public static List<UserRole> listRolesExcept(UserRole role) {
        return Stream.of(values())
                .filter(role1 -> role1 != role)
                .collect(Collectors.toList());
    }
}
