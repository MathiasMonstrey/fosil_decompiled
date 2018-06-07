package com.jawbone.upplatformsdk.datamodel;

import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class Links {
    public String next;
    public String prev;

    public String getNext() {
        return this.next;
    }

    public void setNext(String str) {
        this.next = str;
    }

    public String getPrev() {
        return this.prev;
    }

    public void setPrev(String str) {
        this.prev = str;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
