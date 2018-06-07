package com.jawbone.upplatformsdk.endpointModels.body;

import com.fossil.cga;
import com.jawbone.upplatformsdk.endpointModels.DefaultItem;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class PostBodyComposition extends DefaultItem {
    @cga("share")
    Boolean share;

    public Boolean isShare() {
        return this.share;
    }

    public void setShare(Boolean bool) {
        this.share = bool;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
