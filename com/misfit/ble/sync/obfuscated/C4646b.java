package com.misfit.ble.sync.obfuscated;

import android.content.Context;
import com.misfit.ble.shine.sync.result.MinuteData;
import java.util.List;

public class C4646b {
    private static C4646b f1613A;
    private C4645a f1614B;

    public static C4646b m15466a(Context context) throws IllegalArgumentException {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null!");
        }
        if (f1613A == null) {
            f1613A = new C4646b(context);
        }
        return f1613A;
    }

    private C4646b(Context context) {
        this.f1614B = new C4645a(context);
    }

    public int m15468a(List<MinuteData> list) {
        return this.f1614B.m15464a(list);
    }

    public List<MinuteData> m15469a(long j, long j2) {
        return this.f1614B.m15465a("start_time >= ? AND start_time < ?", new String[]{String.valueOf(j), String.valueOf(j2)}, "start_time ASC", null);
    }

    public int m15467a(long j) {
        this.f1614B.m15463a("start_time < ?", new String[]{String.valueOf(j)});
        return 0;
    }

    public int clearAllMinuteData() {
        this.f1614B.m15463a(null, null);
        return 0;
    }

    public void dispose() {
        this.f1614B.close();
    }
}
