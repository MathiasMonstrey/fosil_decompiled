package com.ua.sdk.activitystory;

import android.os.Parcelable;

public interface ActivityStoryObject extends Parcelable {

    public enum Type {
        WORKOUT,
        ROUTE,
        USER,
        ACTIGRAPHY,
        COMMENT,
        LIKE,
        TOUT,
        AD,
        STATUS,
        REPOST,
        GROUP,
        GROUP_LEADERBOARD
    }

    Type aCJ();
}
