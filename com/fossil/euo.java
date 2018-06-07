package com.fossil;

public class euo {
    private final String name;
    private final String value;

    euo(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getBody() {
        return this.value;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(": ");
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }
}
