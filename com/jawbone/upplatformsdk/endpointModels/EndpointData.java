package com.jawbone.upplatformsdk.endpointModels;

import com.fossil.cga;
import com.jawbone.upplatformsdk.datamodel.Links;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class EndpointData {
    @cga("links")
    protected Links links;
    @cga("size")
    protected Integer size;

    public Links getLinks() {
        return this.links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer num) {
        this.size = num;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
