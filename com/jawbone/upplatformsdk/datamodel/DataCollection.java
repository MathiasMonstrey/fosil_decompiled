package com.jawbone.upplatformsdk.datamodel;

import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class DataCollection {
    public Links links;
    public int size;

    public Links getLinks() {
        return this.links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
