package com.fossil;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

public final class bnu {
    final long byh;
    final long byi;
    final bnw byj;
    final String mAppId;
    final String mName;
    private String mOrigin;

    bnu(bpk com_fossil_bpk, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        awa.df(str2);
        awa.df(str3);
        this.mAppId = str2;
        this.mName = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.mOrigin = str;
        this.byh = j;
        this.byi = j2;
        if (this.byi != 0 && this.byi > this.byh) {
            com_fossil_bpk.Pf().Re().m5439d("Event created with reverse previous/current timestamps. appId", bol.ei(str2));
        }
        this.byj = m5375a(com_fossil_bpk, bundle);
    }

    private bnu(bpk com_fossil_bpk, String str, String str2, String str3, long j, long j2, bnw com_fossil_bnw) {
        awa.df(str2);
        awa.df(str3);
        awa.bO(com_fossil_bnw);
        this.mAppId = str2;
        this.mName = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.mOrigin = str;
        this.byh = j;
        this.byi = j2;
        if (this.byi != 0 && this.byi > this.byh) {
            com_fossil_bpk.Pf().Re().m5439d("Event created with reverse previous/current timestamps. appId", bol.ei(str2));
        }
        this.byj = com_fossil_bnw;
    }

    private static bnw m5375a(bpk com_fossil_bpk, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new bnw(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                com_fossil_bpk.Pf().Rc().log("Param name can't be null");
                it.remove();
            } else {
                Object e = com_fossil_bpk.Pb().m5606e(str, bundle2.get(str));
                if (e == null) {
                    com_fossil_bpk.Pf().Re().m5439d("Param value can't be null", com_fossil_bpk.Pa().eg(str));
                    it.remove();
                } else {
                    com_fossil_bpk.Pb().m5599a(bundle2, str, e);
                }
            }
        }
        return new bnw(bundle2);
    }

    final bnu m5376a(bpk com_fossil_bpk, long j) {
        return new bnu(com_fossil_bpk, this.mOrigin, this.mAppId, this.mName, this.byh, j, this.byj);
    }

    public final String toString() {
        String str = this.mAppId;
        String str2 = this.mName;
        String valueOf = String.valueOf(this.byj);
        return new StringBuilder(((String.valueOf(str).length() + 33) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("Event{appId='").append(str).append("', name='").append(str2).append("', params=").append(valueOf).append("}").toString();
    }
}
