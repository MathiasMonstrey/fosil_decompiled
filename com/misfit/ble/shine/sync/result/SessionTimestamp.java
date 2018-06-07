package com.misfit.ble.shine.sync.result;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.List;

public class SessionTimestamp {
    private SessionTimestampShine f1609w;

    public SessionTimestamp() {
        this.f1609w = new SessionTimestampShine();
    }

    public SessionTimestamp(long j, long j2, int i) {
        this.f1609w = new SessionTimestampShine(j, j2, i);
    }

    public SessionTimestamp(SessionTimestampShine sessionTimestampShine) {
        this.f1609w = sessionTimestampShine;
    }

    public long getStartTimestamp() {
        return this.f1609w.startTimestamp;
    }

    public long getEndTimestamp() {
        return this.f1609w.endTimestamp;
    }

    public int getTimezoneOffsetInSecond() {
        return this.f1609w.timezoneOffsetInSecond;
    }

    public List<SessionTimestamp> getSessionTimestamps() {
        List<SessionTimestampShine> parseJsonSessionTimestampShine = this.f1609w.parseJsonSessionTimestampShine();
        if (parseJsonSessionTimestampShine == null) {
            return null;
        }
        List<SessionTimestamp> arrayList = new ArrayList();
        for (SessionTimestampShine sessionTimestamp : parseJsonSessionTimestampShine) {
            arrayList.add(new SessionTimestamp(sessionTimestamp));
        }
        return arrayList;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return this.f1609w.toString();
    }

    public SessionTimestampShine convertToJNIProperty() {
        return this.f1609w;
    }
}
