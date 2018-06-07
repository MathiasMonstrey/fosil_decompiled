package com.jawbone.upplatformsdk.endpointModels.move;

import com.fossil.cga;
import com.jawbone.upplatformsdk.endpointModels.Endpoint;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class Move extends Endpoint {
    @cga("data")
    protected MoveData moveData;

    public MoveData getMoveData() {
        return this.moveData;
    }

    public void setMoveData(MoveData moveData) {
        this.moveData = moveData;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
