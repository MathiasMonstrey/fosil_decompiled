package com.fossil;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ua.sdk.MeasurementSystem;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class edx implements Parcelable, edw {
    public static Creator<edx> CREATOR = new C33271();
    @cga("icon")
    String dEm;
    @cga("title")
    String dEn;
    @cga("subtitle")
    String dEo;
    @cga("message")
    String dEp;
    transient Map<String, Object> dEq;
    transient Map<String, Object> dEr;
    transient Map<String, Object> dEs;

    static class C33271 implements Creator<edx> {
        C33271() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10550N(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nd(i);
        }

        public edx m10550N(Parcel parcel) {
            return new edx(parcel);
        }

        public edx[] nd(int i) {
            return new edx[i];
        }
    }

    static /* synthetic */ class C33282 {
        static final /* synthetic */ int[] dDu = new int[MeasurementSystem.values().length];

        static {
            try {
                dDu[MeasurementSystem.IMPERIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dDu[MeasurementSystem.METRIC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public String m10557b(MeasurementSystem measurementSystem) {
        return m10552a(this.dEn, this.dEq, measurementSystem);
    }

    public String m10558c(MeasurementSystem measurementSystem) {
        return m10552a(this.dEo, this.dEr, measurementSystem);
    }

    public String m10559d(MeasurementSystem measurementSystem) {
        return m10552a(this.dEp, this.dEs, measurementSystem);
    }

    public void m10556a(cfr com_fossil_cfr) {
        this.dEq = m10555a(this.dEn, com_fossil_cfr);
        this.dEr = m10555a(this.dEo, com_fossil_cfr);
        this.dEs = m10555a(this.dEp, com_fossil_cfr);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    java.util.Map<java.lang.String, java.lang.Object> m10555a(java.lang.String r11, com.fossil.cfr r12) {
        /*
        r10 = this;
        if (r12 == 0) goto L_0x000a;
    L_0x0002:
        if (r11 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r11.isEmpty();
        if (r0 == 0) goto L_0x000f;
    L_0x000a:
        r1 = java.util.Collections.emptyMap();
    L_0x000e:
        return r1;
    L_0x000f:
        r1 = 0;
        r5 = 0;
        r4 = 0;
        r0 = 0;
        r2 = -1;
        r7 = r11.length();
        r3 = 0;
    L_0x0019:
        if (r3 >= r7) goto L_0x00e0;
    L_0x001b:
        r6 = r11.charAt(r3);
        if (r5 == 0) goto L_0x0031;
    L_0x0021:
        r5 = 0;
        r9 = r2;
        r2 = r4;
        r4 = r5;
        r5 = r1;
        r1 = r0;
        r0 = r9;
    L_0x0028:
        r3 = r3 + 1;
        r9 = r0;
        r0 = r1;
        r1 = r5;
        r5 = r4;
        r4 = r2;
        r2 = r9;
        goto L_0x0019;
    L_0x0031:
        switch(r6) {
            case 92: goto L_0x003b;
            case 123: goto L_0x0043;
            case 125: goto L_0x004e;
            default: goto L_0x0034;
        };
    L_0x0034:
        r9 = r2;
        r2 = r4;
        r4 = r5;
        r5 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0028;
    L_0x003b:
        r5 = 1;
        r9 = r2;
        r2 = r4;
        r4 = r5;
        r5 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0028;
    L_0x0043:
        r4 = r4 + 1;
        r6 = 1;
        if (r4 != r6) goto L_0x0034;
    L_0x0048:
        r2 = r4;
        r4 = r5;
        r5 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0028;
    L_0x004e:
        if (r4 <= 0) goto L_0x0034;
    L_0x0050:
        r0 = r0 + 1;
        if (r4 != r0) goto L_0x0034;
    L_0x0054:
        r4 = r4 + r2;
        r6 = r3 + 1;
        r0 = r6 - r0;
        r0 = r11.substring(r4, r0);
        r4 = r0;
        r0 = r12;
    L_0x005f:
        r6 = r4.length();
        if (r6 <= 0) goto L_0x008f;
    L_0x0065:
        r6 = 46;
        r8 = r4.indexOf(r6);
        if (r8 <= 0) goto L_0x0087;
    L_0x006d:
        r6 = 0;
        r6 = r4.substring(r6, r8);
        r8 = r8 + 1;
        r4 = r4.substring(r8);
    L_0x0078:
        r8 = r0.Wx();
        if (r8 == 0) goto L_0x008d;
    L_0x007e:
        r0 = r0.WA();
        r0 = r0.fq(r6);
        goto L_0x005f;
    L_0x0087:
        r6 = "";
        r9 = r4;
        r4 = r6;
        r6 = r9;
        goto L_0x0078;
    L_0x008d:
        r0 = 0;
        goto L_0x005f;
    L_0x008f:
        if (r0 == 0) goto L_0x00c0;
    L_0x0091:
        r4 = r0.Wz();
        if (r4 != 0) goto L_0x00c0;
    L_0x0097:
        r4 = r3 + 1;
        r4 = r11.substring(r2, r4);
        r2 = r0.Wy();
        if (r2 == 0) goto L_0x00da;
    L_0x00a3:
        r0 = (com.fossil.cft) r0;
        r2 = r0.isBoolean();
        if (r2 == 0) goto L_0x00ca;
    L_0x00ab:
        r0 = r0.getAsBoolean();
        r0 = java.lang.Boolean.valueOf(r0);
    L_0x00b3:
        r2 = r0;
    L_0x00b4:
        if (r1 != 0) goto L_0x00e8;
    L_0x00b6:
        r0 = new java.util.HashMap;
        r1 = 2;
        r0.<init>(r1);
    L_0x00bc:
        r0.put(r4, r2);
        r1 = r0;
    L_0x00c0:
        r0 = -1;
        r4 = 0;
        r2 = 0;
        r9 = r2;
        r2 = r4;
        r4 = r5;
        r5 = r1;
        r1 = r9;
        goto L_0x0028;
    L_0x00ca:
        r2 = r0.DI();
        if (r2 == 0) goto L_0x00d5;
    L_0x00d0:
        r0 = r0.Wv();
        goto L_0x00b3;
    L_0x00d5:
        r0 = r0.getAsString();
        goto L_0x00b3;
    L_0x00da:
        r0 = r0.getAsString();
        r2 = r0;
        goto L_0x00b4;
    L_0x00e0:
        if (r1 != 0) goto L_0x000e;
    L_0x00e2:
        r1 = java.util.Collections.emptyMap();
        goto L_0x000e;
    L_0x00e8:
        r0 = r1;
        goto L_0x00bc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.edx.a(java.lang.String, com.fossil.cfr):java.util.Map<java.lang.String, java.lang.Object>");
    }

    private String m10552a(String str, Map<String, Object> map, MeasurementSystem measurementSystem) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (measurementSystem == null) {
            measurementSystem = MeasurementSystem.IMPERIAL;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int length = str.length();
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        Object obj = null;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (obj == null) {
                switch (charAt) {
                    case '\\':
                        stringBuilder.append(charAt);
                        int i5 = 1;
                        break;
                    case '{':
                        i3++;
                        if (i3 != 1) {
                            break;
                        }
                        i = i4;
                        break;
                    case '}':
                        if (i3 <= 0) {
                            break;
                        }
                        i2++;
                        if (i3 != i2) {
                            break;
                        }
                        String substring = str.substring(i, i4 + 1);
                        Object obj2 = map.get(substring);
                        if (obj2 == null) {
                            stringBuilder.append(substring);
                        } else if (substring.contains("distance")) {
                            m10553a(stringBuilder, obj2, measurementSystem);
                        } else {
                            stringBuilder.append(obj2);
                        }
                        i = -1;
                        i2 = 0;
                        i3 = 0;
                        break;
                    default:
                        if (i >= 0) {
                            break;
                        }
                        stringBuilder.append(charAt);
                        break;
                }
            }
            stringBuilder.append(charAt);
            obj = null;
        }
        return stringBuilder.toString();
    }

    private void m10553a(StringBuilder stringBuilder, Object obj, MeasurementSystem measurementSystem) {
        double doubleValue;
        if (obj instanceof Number) {
            doubleValue = ((Number) obj).doubleValue();
        } else {
            try {
                doubleValue = Double.parseDouble(obj.toString());
            } catch (NumberFormatException e) {
                stringBuilder.append(obj.toString());
                return;
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        switch (C33282.dDu[measurementSystem.ordinal()]) {
            case 1:
                stringBuilder.append(decimalFormat.format(eby.m10467b(Double.valueOf(doubleValue)).doubleValue()));
                stringBuilder.append("mi");
                return;
            case 2:
                stringBuilder.append(decimalFormat.format(eby.m10466a(Double.valueOf(doubleValue)).doubleValue()));
                stringBuilder.append("km");
                return;
            default:
                return;
        }
    }

    public int describeContents() {
        return 0;
    }

    private void m10554a(Map<String, Object> map, Parcel parcel) {
        if (map == null || map.isEmpty()) {
            parcel.writeBundle(null);
            return;
        }
        Bundle bundle = new Bundle();
        for (Entry entry : map.entrySet()) {
            bundle.putSerializable((String) entry.getKey(), (Serializable) entry.getValue());
        }
        parcel.writeBundle(bundle);
    }

    private Map<String, Object> m10551M(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        if (readBundle == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(readBundle.size());
        for (String str : readBundle.keySet()) {
            hashMap.put(str, readBundle.getSerializable(str));
        }
        return hashMap;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dEm);
        m10554a(this.dEq, parcel);
        m10554a(this.dEr, parcel);
        m10554a(this.dEs, parcel);
        parcel.writeString(this.dEn);
        parcel.writeString(this.dEo);
        parcel.writeString(this.dEp);
    }

    private edx(Parcel parcel) {
        this.dEm = parcel.readString();
        this.dEq = m10551M(parcel);
        this.dEr = m10551M(parcel);
        this.dEs = m10551M(parcel);
        this.dEn = parcel.readString();
        this.dEo = parcel.readString();
        this.dEp = parcel.readString();
    }

    public String toString() {
        return m10560e(null);
    }

    public String m10560e(MeasurementSystem measurementSystem) {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.dEn != null) {
            stringBuilder.append(m10557b(measurementSystem));
        }
        if (this.dEo != null) {
            stringBuilder.append('\n');
            stringBuilder.append(m10558c(measurementSystem));
        }
        if (this.dEp != null) {
            stringBuilder.append('\n');
            stringBuilder.append(m10559d(measurementSystem));
        }
        return stringBuilder.toString();
    }
}
