package com.jawbone.upplatformsdk.endpointModels.body;

import com.fossil.cga;
import com.jawbone.upplatformsdk.endpointModels.EndpointData;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;
import java.util.List;

public class BodyData extends EndpointData {
    @cga("items")
    List<BodyItem> bodyItems;

    public List<BodyItem> getBodyItems() {
        return this.bodyItems;
    }

    public void setBodyItems(List<BodyItem> list) {
        this.bodyItems = list;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
