package com.fossil;

public class emt {
    private final String dNo;
    private final String identifier;
    private final String version;

    public emt(String str, String str2, String str3) {
        this.identifier = str;
        this.version = str2;
        this.dNo = str3;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getVersion() {
        return this.version;
    }

    public String aFd() {
        return this.dNo;
    }
}
