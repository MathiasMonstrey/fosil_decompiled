package com.fossil.wearables.fsl.dial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public interface DialListItem {
    int getDbRowId();

    String getDisplayName();

    Bitmap getThumbnailBitmap();

    Drawable getThumbnailDrawable(Context context);
}
