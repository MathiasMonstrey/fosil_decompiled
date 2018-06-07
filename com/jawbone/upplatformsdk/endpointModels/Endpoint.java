package com.jawbone.upplatformsdk.endpointModels;

import com.fossil.cga;
import com.jawbone.upplatformsdk.datamodel.Meta;

public class Endpoint {
    @cga("meta")
    protected Meta meta;

    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
