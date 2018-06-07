package com.fossil;

import android.net.Uri;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class cbj implements cau {
    private byte[] bKW;
    private Map<String, cav> bKX;
    private Uri mUri;

    public cbj(cau com_fossil_cau) {
        this.mUri = com_fossil_cau.getUri();
        this.bKW = com_fossil_cau.getData();
        Map hashMap = new HashMap();
        for (Entry entry : com_fossil_cau.TU().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put((String) entry.getKey(), (cav) ((cav) entry.getValue()).freeze());
            }
        }
        this.bKX = Collections.unmodifiableMap(hashMap);
    }

    public final Map<String, cav> TU() {
        return this.bKX;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final byte[] getData() {
        return this.bKW;
    }

    public final Uri getUri() {
        return this.mUri;
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity{ ");
        String valueOf = String.valueOf(this.mUri);
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 4).append("uri=").append(valueOf).toString());
        valueOf = String.valueOf(this.bKW == null ? "null" : Integer.valueOf(this.bKW.length));
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 9).append(", dataSz=").append(valueOf).toString());
        stringBuilder.append(", numAssets=" + this.bKX.size());
        if (isLoggable && !this.bKX.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            for (Entry entry : this.bKX.entrySet()) {
                String str2 = (String) entry.getKey();
                valueOf = String.valueOf(((cav) entry.getValue()).getId());
                stringBuilder.append(new StringBuilder(((String.valueOf(str).length() + 2) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append(str).append(str2).append(": ").append(valueOf).toString());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
