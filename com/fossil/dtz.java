package com.fossil;

import android.text.TextUtils;
import com.sina.weibo.sdk.statistic.LogType;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class dtz {
    private static /* synthetic */ int[] dtv;

    static /* synthetic */ int[] axL() {
        int[] iArr = dtv;
        if (iArr == null) {
            iArr = new int[LogType.values().length];
            try {
                iArr[LogType.ACTIVITY.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LogType.EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LogType.FRAGMENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[LogType.SESSION_END.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[LogType.SESSION_START.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            dtv = iArr;
        }
        return iArr;
    }

    public static String au(List<duc> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (duc a : list) {
            stringBuilder.append(m9755a(a).toString()).append(",");
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.json.JSONObject m9755a(com.fossil.duc r6) {
        /*
        r1 = new org.json.JSONObject;
        r1.<init>();
        r0 = axL();	 Catch:{ Exception -> 0x002a }
        r2 = r6.axN();	 Catch:{ Exception -> 0x002a }
        r2 = r2.ordinal();	 Catch:{ Exception -> 0x002a }
        r0 = r0[r2];	 Catch:{ Exception -> 0x002a }
        switch(r0) {
            case 1: goto L_0x0017;
            case 2: goto L_0x0040;
            case 3: goto L_0x005f;
            case 4: goto L_0x0087;
            case 5: goto L_0x00a9;
            default: goto L_0x0016;
        };	 Catch:{ Exception -> 0x002a }
    L_0x0016:
        return r1;
    L_0x0017:
        r0 = "type";
        r2 = 0;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        r0 = "time";
        r2 = r6.getStartTime();	 Catch:{ Exception -> 0x002a }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        goto L_0x0016;
    L_0x002a:
        r0 = move-exception;
        r2 = "WBAgent";
        r3 = new java.lang.StringBuilder;
        r4 = "get page log error.";
        r3.<init>(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.fossil.duj.m9770e(r2, r0);
        goto L_0x0016;
    L_0x0040:
        r0 = "type";
        r2 = 1;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        r0 = "time";
        r2 = r6.getEndTime();	 Catch:{ Exception -> 0x002a }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        r0 = "duration";
        r2 = r6.getDuration();	 Catch:{ Exception -> 0x002a }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        goto L_0x0016;
    L_0x005f:
        r0 = "type";
        r2 = 2;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        r0 = "page_id";
        r2 = r6.axO();	 Catch:{ Exception -> 0x002a }
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        r0 = "time";
        r2 = r6.getStartTime();	 Catch:{ Exception -> 0x002a }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        r0 = "duration";
        r2 = r6.getDuration();	 Catch:{ Exception -> 0x002a }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        goto L_0x0016;
    L_0x0087:
        r0 = "type";
        r2 = 3;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        r0 = "page_id";
        r2 = r6.axO();	 Catch:{ Exception -> 0x002a }
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        r0 = "time";
        r2 = r6.getStartTime();	 Catch:{ Exception -> 0x002a }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        r6 = (com.fossil.dty) r6;	 Catch:{ Exception -> 0x002a }
        m9756a(r1, r6);	 Catch:{ Exception -> 0x002a }
        goto L_0x0016;
    L_0x00a9:
        r0 = "type";
        r2 = 4;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        r0 = "page_id";
        r2 = r6.axO();	 Catch:{ Exception -> 0x002a }
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        r0 = "time";
        r2 = r6.getStartTime();	 Catch:{ Exception -> 0x002a }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        r0 = "duration";
        r2 = r6.getDuration();	 Catch:{ Exception -> 0x002a }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r1.put(r0, r2);	 Catch:{ Exception -> 0x002a }
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dtz.a(com.fossil.duc):org.json.JSONObject");
    }

    private static JSONObject m9756a(JSONObject jSONObject, dty com_fossil_dty) {
        try {
            jSONObject.put("event_id", com_fossil_dty.axJ());
            if (com_fossil_dty.axK() != null) {
                Map axK = com_fossil_dty.axK();
                StringBuilder stringBuilder = new StringBuilder();
                int i = 0;
                for (String str : axK.keySet()) {
                    if (i >= 10) {
                        break;
                    } else if (!TextUtils.isEmpty((CharSequence) axK.get(str))) {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append("|");
                        }
                        stringBuilder.append(str).append(":").append((String) axK.get(str));
                        i++;
                    }
                }
                jSONObject.put("extend", stringBuilder.toString());
            }
        } catch (Exception e) {
            duj.m9770e("WBAgent", "add event log error." + e);
        }
        return jSONObject;
    }
}
