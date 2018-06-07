package com.jawbone.upplatformsdk.endpointModels.body;

import com.fossil.cga;
import com.jawbone.upplatformsdk.endpointModels.Endpoint;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class BodyCompositionEvent extends Endpoint {
    @cga("data")
    BodyItem data;

    public BodyItem getData() {
        return this.data;
    }

    public void setData(BodyItem bodyItem) {
        this.data = bodyItem;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
