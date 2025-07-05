package com.sam.fizzbuzz.enumeration;

public enum FizzBuzzEnum {
    APPEND_BY_ASC("APPEND_BY_ASC"),

    APPEND_BY_DESC("APPEND_BY_DESC");

    private final String code;

    private FizzBuzzEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
