package com.misfit.frameworks.network.configuration;

public class MFConfiguration {
    private String baseServerUrl;
    private MFHeader header;

    public MFConfiguration(String str, MFHeader mFHeader) {
        this.baseServerUrl = str;
        this.header = mFHeader;
    }

    public String getBaseServerUrl() {
        return this.baseServerUrl;
    }

    public MFHeader getHeader() {
        return this.header;
    }
}
