package com.fossil;

import android.support.v8.renderscript.Allocation;
import com.fossil.efg.C3368a;
import com.ua.sdk.MeasurementSystem;
import com.ua.sdk.MeasurementSystem.MeasurementSystemAdapter;
import com.ua.sdk.activitystory.Attachment;
import com.ua.sdk.activitystory.AttachmentAdapter;
import com.ua.sdk.friendship.FriendshipStatus;
import com.ua.sdk.friendship.FriendshipStatusAdapter;
import com.ua.sdk.net.json.DateAdapter;
import com.ua.sdk.net.json.LocalDateAdapter;
import com.ua.sdk.user.Gender;
import com.ua.sdk.user.Gender.GenderAdapter;
import java.util.Date;

public class ejh {
    public static cfj aDX() {
        cfk com_fossil_cfk = new cfk();
        com_fossil_cfk.m6208f(8, Allocation.USAGE_SHARED);
        com_fossil_cfk.m6207a(Date.class, new DateAdapter());
        com_fossil_cfk.m6207a(ech.class, new LocalDateAdapter());
        com_fossil_cfk.m6207a(Gender.class, new GenderAdapter());
        com_fossil_cfk.m6207a(FriendshipStatus.class, new FriendshipStatusAdapter());
        com_fossil_cfk.m6207a(MeasurementSystem.class, new MeasurementSystemAdapter());
        com_fossil_cfk.m6207a(Attachment.class, new AttachmentAdapter());
        return com_fossil_cfk.Wu();
    }

    public static cfj aDY() {
        cfk com_fossil_cfk = new cfk();
        com_fossil_cfk.m6208f(8, Allocation.USAGE_SHARED);
        com_fossil_cfk.m6207a(C3368a.class, new efm());
        return com_fossil_cfk.Wu();
    }
}
