package com.fossil;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class cbk extends aul implements cau {
    private final int bKV;

    public cbk(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.bKV = i2;
    }

    public final Map<String, cav> TU() {
        Map<String, cav> hashMap = new HashMap(this.bKV);
        for (int i = 0; i < this.bKV; i++) {
            cbi com_fossil_cbi = new cbi(this.bgD, this.bgT + i);
            if (com_fossil_cbi.TV() != null) {
                hashMap.put(com_fossil_cbi.TV(), com_fossil_cbi);
            }
        }
        return hashMap;
    }

    public final /* synthetic */ Object freeze() {
        return new cbj(this);
    }

    public final byte[] getData() {
        return getByteArray("data");
    }

    public final Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        byte[] data = getData();
        Map TU = TU();
        StringBuilder stringBuilder = new StringBuilder("DataItemInternal{ ");
        String valueOf = String.valueOf(getUri());
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 4).append("uri=").append(valueOf).toString());
        String valueOf2 = String.valueOf(data == null ? "null" : Integer.valueOf(data.length));
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf2).length() + 9).append(", dataSz=").append(valueOf2).toString());
        stringBuilder.append(", numAssets=" + TU.size());
        if (isLoggable && !TU.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            for (Entry entry : TU.entrySet()) {
                String str2 = (String) entry.getKey();
                valueOf2 = String.valueOf(((cav) entry.getValue()).getId());
                stringBuilder.append(new StringBuilder(((String.valueOf(str).length() + 2) + String.valueOf(str2).length()) + String.valueOf(valueOf2).length()).append(str).append(str2).append(": ").append(valueOf2).toString());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
