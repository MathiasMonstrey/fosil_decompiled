package com.fossil;

import android.support.v8.renderscript.Allocation;
import android.util.Log;
import java.io.Writer;

public class jp extends Writer {
    private StringBuilder mBuilder = new StringBuilder(Allocation.USAGE_SHARED);
    private final String mTag;

    public jp(String str) {
        this.mTag = str;
    }

    public void close() {
        jr();
    }

    public void flush() {
        jr();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                jr();
            } else {
                this.mBuilder.append(c);
            }
        }
    }

    private void jr() {
        if (this.mBuilder.length() > 0) {
            Log.d(this.mTag, this.mBuilder.toString());
            this.mBuilder.delete(0, this.mBuilder.length());
        }
    }
}
