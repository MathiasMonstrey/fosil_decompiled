package com.fossil;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Map;

public final class cez extends auq {
    public static final Creator<cez> CREATOR = new cfe();
    Bundle Oo;
    private Map<String, String> bQv;

    public cez(Bundle bundle) {
        this.Oo = bundle;
    }

    public final Map<String, String> Wm() {
        if (this.bQv == null) {
            this.bQv = new jl();
            for (String str : this.Oo.keySet()) {
                Object obj = this.Oo.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!(str.startsWith("google.") || str.startsWith("gcm.") || str.equals("from") || str.equals("message_type") || str.equals("collapse_key"))) {
                        this.bQv.put(str, str2);
                    }
                }
            }
        }
        return this.bQv;
    }

    public final String getFrom() {
        return this.Oo.getString("from");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4545a(parcel, 2, this.Oo, false);
        aus.m4540G(parcel, A);
    }
}
