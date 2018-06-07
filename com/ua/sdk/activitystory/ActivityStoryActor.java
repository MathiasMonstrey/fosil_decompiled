package com.ua.sdk.activitystory;

import android.os.Parcelable;

public interface ActivityStoryActor extends Parcelable {

    public enum Type {
        USER,
        SITE,
        BRAND,
        PAGE,
        GROUP,
        UNKNOWN
    }

    Type aCI();
}
