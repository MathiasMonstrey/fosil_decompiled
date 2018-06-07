package com.misfit.ble.shine.sync.result;

import java.util.ArrayList;
import java.util.List;

public class SessionTimestampShine {
    public long endTimestamp;
    public String jsonStringUserIdle;
    public long startTimestamp;
    public int timezoneOffsetInSecond;

    public SessionTimestampShine() {
        this.startTimestamp = 0;
        this.endTimestamp = 0;
        this.timezoneOffsetInSecond = 0;
        this.jsonStringUserIdle = null;
    }

    public SessionTimestampShine(long j, long j2, int i) {
        this.startTimestamp = j;
        this.endTimestamp = j2;
        this.timezoneOffsetInSecond = i;
    }

    public List<SessionTimestampShine> parseJsonSessionTimestampShine() {
        if (this.jsonStringUserIdle == null) {
            return null;
        }
        this.jsonStringUserIdle = this.jsonStringUserIdle.replace("{", "");
        this.jsonStringUserIdle = this.jsonStringUserIdle.replace("}", "");
        if (this.jsonStringUserIdle.equals("")) {
            return null;
        }
        String[] split = this.jsonStringUserIdle.split(":");
        List<SessionTimestampShine> arrayList = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].replace("[", "");
            split[i] = split[i].replace("]", "");
            String[] split2 = split[i].split(",");
            if (!(split2[0].equals("") || split2[1].equals("") || split2[2].equals(""))) {
                arrayList.add(new SessionTimestampShine(Long.parseLong(split2[0]), Long.parseLong(split2[1]), Integer.parseInt(split2[2])));
            }
        }
        return arrayList;
    }
}
