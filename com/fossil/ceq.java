package com.fossil;

import android.text.TextUtils;

public final class ceq {
    private static final Object bhH = new Object();
    private final cex bQa;

    public ceq(cex com_fossil_cex) {
        this.bQa = com_fossil_cex;
    }

    public final String Wg() {
        String str = null;
        synchronized (bhH) {
            String string = this.bQa.bqd.getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                }
            }
        }
        return str;
    }

    public final boolean fh(String str) {
        boolean z;
        synchronized (bhH) {
            String string = this.bQa.bqd.getString("topic_operaion_queue", "");
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                valueOf = String.valueOf(",");
                valueOf2 = String.valueOf(str);
                this.bQa.bqd.edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).length())).apply();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
