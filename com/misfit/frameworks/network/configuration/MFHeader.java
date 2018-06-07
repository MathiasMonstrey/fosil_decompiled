package com.misfit.frameworks.network.configuration;

import java.util.HashMap;

public class MFHeader {
    private HashMap<String, String> extraInfoHeader = new HashMap();

    public void addHeader(String str, String str2) {
        this.extraInfoHeader.put(str, str2);
    }

    public void addAll(HashMap<String, String> hashMap) {
        this.extraInfoHeader.putAll(hashMap);
    }

    public HashMap<String, String> getHeaderMap() {
        return this.extraInfoHeader;
    }
}
