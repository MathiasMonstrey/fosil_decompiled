package com.misfit.ble.parser;

import com.misfit.ble.shine.sync.UserProfile;
import java.util.List;

public class SyncSessionBuilder {
    public static SyncSession buildSyncSession(List<byte[]> list, UserProfile userProfile, int i, int i2, long j) throws IllegalStateException {
        SyncSession syncSession = new SyncSession(list, userProfile, i, i2, j);
        long a = syncSession.m15235a();
        if (a >= 1000) {
            return syncSession;
        }
        throw new IllegalStateException(syncSession.m15236b().getErrorMessage(a));
    }
}
