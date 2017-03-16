package com.toxa.phonebook2.model.entity.Enums;

public enum UserRoleEnum {

    USER ("USER");

    private String userRoleType;

    UserRoleEnum(String userRoleType) {
        this.userRoleType = userRoleType;
    }

    public String getUserRoleType() {
        return userRoleType;
    }
}
