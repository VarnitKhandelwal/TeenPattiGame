package com.varnit.teenpatti;

public enum Suits {
    SPADE("♠"),
    HEART("♥"),
    DIAMOND("♦"),
    CLUB("♣");

    private final String value;

    Suits(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
