package com.ua.sdk.friendship;

public enum FriendshipStatus {
    NONE("none"),
    PENDING("pending"),
    ACTIVE("active");
    
    private String value;

    private FriendshipStatus(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static FriendshipStatus getStatusFromString(String str) {
        for (FriendshipStatus friendshipStatus : values()) {
            if (friendshipStatus.value.equals(str)) {
                return friendshipStatus;
            }
        }
        return null;
    }
}
