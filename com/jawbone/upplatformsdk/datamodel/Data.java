package com.jawbone.upplatformsdk.datamodel;

import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class Data {
    public String xid;

    public String getXid() {
        return this.xid;
    }

    public void setXid(String str) {
        this.xid = str;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
