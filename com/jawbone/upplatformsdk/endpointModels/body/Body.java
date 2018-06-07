package com.jawbone.upplatformsdk.endpointModels.body;

import com.fossil.cga;
import com.jawbone.upplatformsdk.endpointModels.Endpoint;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class Body extends Endpoint {
    @cga("data")
    BodyData data;

    public BodyData getData() {
        return this.data;
    }

    public void setData(BodyData bodyData) {
        this.data = bodyData;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
