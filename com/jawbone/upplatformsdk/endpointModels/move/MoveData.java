package com.jawbone.upplatformsdk.endpointModels.move;

import com.fossil.cga;
import com.jawbone.upplatformsdk.endpointModels.EndpointData;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;
import java.util.List;

public class MoveData extends EndpointData {
    @cga("items")
    List<MoveItem> moveItems;

    public List<MoveItem> getMoveItems() {
        return this.moveItems;
    }

    public void setMoveItems(List<MoveItem> list) {
        this.moveItems = list;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
