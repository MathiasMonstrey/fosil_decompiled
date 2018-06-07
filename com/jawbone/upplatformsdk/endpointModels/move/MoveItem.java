package com.jawbone.upplatformsdk.endpointModels.move;

import com.fossil.cga;
import com.jawbone.upplatformsdk.endpointModels.DefaultItem;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class MoveItem extends DefaultItem {
    @cga("details")
    MoveDetails details;
    @cga("snapshot_image")
    String snapshotImage;

    public String getSnapshotImage() {
        return this.snapshotImage;
    }

    public void setSnapshotImage(String str) {
        this.snapshotImage = str;
    }

    public MoveDetails getDetails() {
        return this.details;
    }

    public void setDetails(MoveDetails moveDetails) {
        this.details = moveDetails;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
