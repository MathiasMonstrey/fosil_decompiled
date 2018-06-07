package com.fossil;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.crashlytics.android.core.CodedOutputStream;
import com.facebook.appevents.AppEventsConstants;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class adk {
    private static final acp aKp = acp.ar(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    private RunningAppProcessInfo aKq;
    private Thread[] aKr;
    private List<StackTraceElement[]> aKs;
    private StackTraceElement[] aKt;
    private final acp aKu;
    private final acp aKv;
    private final int aKw = 8;
    private final Context context;

    public adk(Context context, String str, String str2) {
        this.context = context;
        this.aKu = acp.ar(str2);
        this.aKv = str == null ? null : acp.ar(str.replace("-", ""));
    }

    public void m3085a(CodedOutputStream codedOutputStream, String str, String str2, long j) throws Exception {
        codedOutputStream.m2640a(1, acp.ar(str2));
        codedOutputStream.m2640a(2, acp.ar(str));
        codedOutputStream.m2647f(3, j);
    }

    public void m3087a(CodedOutputStream codedOutputStream, String str, String str2, String str3, String str4, int i) throws Exception {
        acp ar = acp.ar(str);
        acp ar2 = acp.ar(str2);
        acp ar3 = acp.ar(str3);
        acp ar4 = acp.ar(str4);
        codedOutputStream.bn(7, 2);
        codedOutputStream.fd(m3064a(ar, ar2, ar3, ar4, i));
        codedOutputStream.m2640a(1, ar);
        codedOutputStream.m2640a(2, ar2);
        codedOutputStream.m2640a(3, ar3);
        codedOutputStream.bn(5, 2);
        codedOutputStream.fd(yJ());
        codedOutputStream.m2648f(1, new eng().er(this.context));
        codedOutputStream.m2640a(6, ar4);
        codedOutputStream.bi(10, i);
    }

    public void m3088a(CodedOutputStream codedOutputStream, boolean z) throws Exception {
        acp ar = acp.ar(VERSION.RELEASE);
        acp ar2 = acp.ar(VERSION.CODENAME);
        codedOutputStream.bn(8, 2);
        codedOutputStream.fd(m3065a(ar, ar2, z));
        codedOutputStream.bi(1, 3);
        codedOutputStream.m2640a(2, ar);
        codedOutputStream.m2640a(3, ar2);
        codedOutputStream.m2649o(4, z);
    }

    public void m3084a(CodedOutputStream codedOutputStream, String str, int i, String str2, int i2, long j, long j2, boolean z, Map<DeviceIdentifierType, String> map, int i3, String str3, String str4) throws Exception {
        acp ar = acp.ar(str);
        acp aO = aO(str2);
        acp aO2 = aO(str4);
        acp aO3 = aO(str3);
        codedOutputStream.bn(9, 2);
        codedOutputStream.fd(m3063a(i, ar, aO, i2, j, j2, z, map, i3, aO3, aO2));
        codedOutputStream.m2640a(1, ar);
        codedOutputStream.bi(3, i);
        codedOutputStream.m2640a(4, aO);
        codedOutputStream.bh(5, i2);
        codedOutputStream.m2647f(6, j);
        codedOutputStream.m2647f(7, j2);
        codedOutputStream.m2649o(10, z);
        for (Entry entry : map.entrySet()) {
            codedOutputStream.bn(11, 2);
            codedOutputStream.fd(m3066a((DeviceIdentifierType) entry.getKey(), (String) entry.getValue()));
            codedOutputStream.bi(1, ((DeviceIdentifierType) entry.getKey()).protobufIndex);
            codedOutputStream.m2640a(2, acp.ar((String) entry.getValue()));
        }
        codedOutputStream.bh(12, i3);
        if (aO3 != null) {
            codedOutputStream.m2640a(13, aO3);
        }
        if (aO2 != null) {
            codedOutputStream.m2640a(14, aO2);
        }
    }

    public void m3086a(CodedOutputStream codedOutputStream, String str, String str2, String str3) throws Exception {
        if (str == null) {
            str = "";
        }
        acp ar = acp.ar(str);
        acp aO = aO(str2);
        acp aO2 = aO(str3);
        int b = 0 + CodedOutputStream.m2630b(1, ar);
        if (str2 != null) {
            b += CodedOutputStream.m2630b(2, aO);
        }
        if (str3 != null) {
            b += CodedOutputStream.m2630b(3, aO2);
        }
        codedOutputStream.bn(6, 2);
        codedOutputStream.fd(b);
        codedOutputStream.m2640a(1, ar);
        if (str2 != null) {
            codedOutputStream.m2640a(2, aO);
        }
        if (str3 != null) {
            codedOutputStream.m2640a(3, aO2);
        }
    }

    public void m3083a(CodedOutputStream codedOutputStream, long j, Thread thread, Throwable th, String str, Thread[] threadArr, float f, int i, boolean z, int i2, long j2, long j3, RunningAppProcessInfo runningAppProcessInfo, List<StackTraceElement[]> list, StackTraceElement[] stackTraceElementArr, add com_fossil_add, Map<String, String> map) throws Exception {
        this.aKq = runningAppProcessInfo;
        this.aKs = list;
        this.aKt = stackTraceElementArr;
        this.aKr = threadArr;
        acp yv = com_fossil_add.yv();
        if (yv == null) {
            emm.aEU().mo2950d("Fabric", "No log data to include with this event.");
        }
        com_fossil_add.yw();
        codedOutputStream.bn(10, 2);
        codedOutputStream.fd(m3070a(thread, th, str, j, (Map) map, f, i, z, i2, j2, j3, yv));
        codedOutputStream.m2647f(1, j);
        codedOutputStream.m2640a(2, acp.ar(str));
        m3077a(codedOutputStream, thread, th, i2, (Map) map);
        m3073a(codedOutputStream, f, i, z, i2, j2, j3);
        m3075a(codedOutputStream, yv);
    }

    private void m3077a(CodedOutputStream codedOutputStream, Thread thread, Throwable th, int i, Map<String, String> map) throws Exception {
        codedOutputStream.bn(3, 2);
        codedOutputStream.fd(m3069a(thread, th, i, (Map) map));
        m3076a(codedOutputStream, thread, th);
        if (!(map == null || map.isEmpty())) {
            m3080a(codedOutputStream, (Map) map);
        }
        if (this.aKq != null) {
            codedOutputStream.m2649o(3, this.aKq.importance != 100);
        }
        codedOutputStream.bh(4, i);
    }

    private void m3076a(CodedOutputStream codedOutputStream, Thread thread, Throwable th) throws Exception {
        codedOutputStream.bn(1, 2);
        codedOutputStream.fd(m3068a(thread, th));
        m3078a(codedOutputStream, thread, this.aKt, 4, true);
        int length = this.aKr.length;
        for (int i = 0; i < length; i++) {
            m3078a(codedOutputStream, this.aKr[i], (StackTraceElement[]) this.aKs.get(i), 0, false);
        }
        m3079a(codedOutputStream, th, 1, 2);
        codedOutputStream.bn(3, 2);
        codedOutputStream.fd(yL());
        codedOutputStream.m2640a(1, aKp);
        codedOutputStream.m2640a(2, aKp);
        codedOutputStream.m2647f(3, 0);
        codedOutputStream.bn(4, 2);
        codedOutputStream.fd(yK());
        codedOutputStream.m2647f(1, 0);
        codedOutputStream.m2647f(2, 0);
        codedOutputStream.m2640a(3, this.aKu);
        if (this.aKv != null) {
            codedOutputStream.m2640a(4, this.aKv);
        }
    }

    private void m3080a(CodedOutputStream codedOutputStream, Map<String, String> map) throws Exception {
        for (Entry entry : map.entrySet()) {
            codedOutputStream.bn(2, 2);
            codedOutputStream.fd(m3082q((String) entry.getKey(), (String) entry.getValue()));
            codedOutputStream.m2640a(1, acp.ar((String) entry.getKey()));
            String str = (String) entry.getValue();
            if (str == null) {
                str = "";
            }
            codedOutputStream.m2640a(2, acp.ar(str));
        }
    }

    private void m3079a(CodedOutputStream codedOutputStream, Throwable th, int i, int i2) throws Exception {
        int i3 = 0;
        codedOutputStream.bn(i2, 2);
        codedOutputStream.fd(m3072a(th, 1));
        codedOutputStream.m2640a(1, acp.ar(th.getClass().getName()));
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            codedOutputStream.m2640a(3, acp.ar(localizedMessage));
        }
        for (StackTraceElement a : th.getStackTrace()) {
            m3074a(codedOutputStream, 4, a, true);
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return;
        }
        if (i < this.aKw) {
            m3079a(codedOutputStream, cause, i + 1, 6);
            return;
        }
        while (cause != null) {
            cause = cause.getCause();
            i3++;
        }
        codedOutputStream.bh(7, i3);
    }

    private void m3078a(CodedOutputStream codedOutputStream, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) throws Exception {
        codedOutputStream.bn(1, 2);
        codedOutputStream.fd(m3071a(thread, stackTraceElementArr, i, z));
        codedOutputStream.m2640a(1, acp.ar(thread.getName()));
        codedOutputStream.bh(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            m3074a(codedOutputStream, 3, a, z);
        }
    }

    private void m3074a(CodedOutputStream codedOutputStream, int i, StackTraceElement stackTraceElement, boolean z) throws Exception {
        int i2 = 4;
        codedOutputStream.bn(i, 2);
        codedOutputStream.fd(m3067a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            codedOutputStream.m2647f(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            codedOutputStream.m2647f(1, 0);
        }
        codedOutputStream.m2640a(2, acp.ar(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream.m2640a(3, acp.ar(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream.m2647f(4, (long) stackTraceElement.getLineNumber());
        }
        if (!z) {
            i2 = 0;
        }
        codedOutputStream.bh(5, i2);
    }

    private void m3073a(CodedOutputStream codedOutputStream, float f, int i, boolean z, int i2, long j, long j2) throws Exception {
        codedOutputStream.bn(5, 2);
        codedOutputStream.fd(m3062a(f, i, z, i2, j, j2));
        codedOutputStream.m2646e(1, f);
        codedOutputStream.bj(2, i);
        codedOutputStream.m2649o(3, z);
        codedOutputStream.bh(4, i2);
        codedOutputStream.m2647f(5, j);
        codedOutputStream.m2647f(6, j2);
    }

    private void m3075a(CodedOutputStream codedOutputStream, acp com_fossil_acp) throws Exception {
        if (com_fossil_acp != null) {
            codedOutputStream.bn(6, 2);
            codedOutputStream.fd(m3081d(com_fossil_acp));
            codedOutputStream.m2640a(1, com_fossil_acp);
        }
    }

    private int m3064a(acp com_fossil_acp, acp com_fossil_acp2, acp com_fossil_acp3, acp com_fossil_acp4, int i) {
        int b = ((0 + CodedOutputStream.m2630b(1, com_fossil_acp)) + CodedOutputStream.m2630b(2, com_fossil_acp2)) + CodedOutputStream.m2630b(3, com_fossil_acp3);
        int yJ = yJ();
        return ((b + (yJ + (CodedOutputStream.fc(5) + CodedOutputStream.fe(yJ)))) + CodedOutputStream.m2630b(6, com_fossil_acp4)) + CodedOutputStream.bl(10, i);
    }

    private int yJ() {
        return 0 + CodedOutputStream.m2630b(1, acp.ar(new eng().er(this.context)));
    }

    private int m3065a(acp com_fossil_acp, acp com_fossil_acp2, boolean z) {
        return (((0 + CodedOutputStream.bl(1, 3)) + CodedOutputStream.m2630b(2, com_fossil_acp)) + CodedOutputStream.m2630b(3, com_fossil_acp2)) + CodedOutputStream.m2635p(4, z);
    }

    private int m3066a(DeviceIdentifierType deviceIdentifierType, String str) {
        return CodedOutputStream.bl(1, deviceIdentifierType.protobufIndex) + CodedOutputStream.m2630b(2, acp.ar(str));
    }

    private int m3063a(int i, acp com_fossil_acp, acp com_fossil_acp2, int i2, long j, long j2, boolean z, Map<DeviceIdentifierType, String> map, int i3, acp com_fossil_acp3, acp com_fossil_acp4) {
        int i4;
        int i5;
        int bl = CodedOutputStream.bl(3, i) + (0 + CodedOutputStream.m2630b(1, com_fossil_acp));
        if (com_fossil_acp2 == null) {
            i4 = 0;
        } else {
            i4 = CodedOutputStream.m2630b(4, com_fossil_acp2);
        }
        i4 = ((((i4 + bl) + CodedOutputStream.bk(5, i2)) + CodedOutputStream.m2634g(6, j)) + CodedOutputStream.m2634g(7, j2)) + CodedOutputStream.m2635p(10, z);
        if (map != null) {
            i5 = i4;
            for (Entry entry : map.entrySet()) {
                i4 = m3066a((DeviceIdentifierType) entry.getKey(), (String) entry.getValue());
                i5 = (i4 + (CodedOutputStream.fc(11) + CodedOutputStream.fe(i4))) + i5;
            }
        } else {
            i5 = i4;
        }
        return (com_fossil_acp4 == null ? 0 : CodedOutputStream.m2630b(14, com_fossil_acp4)) + ((i5 + CodedOutputStream.bk(12, i3)) + (com_fossil_acp3 == null ? 0 : CodedOutputStream.m2630b(13, com_fossil_acp3)));
    }

    private int yK() {
        int g = ((0 + CodedOutputStream.m2634g(1, 0)) + CodedOutputStream.m2634g(2, 0)) + CodedOutputStream.m2630b(3, this.aKu);
        if (this.aKv != null) {
            return g + CodedOutputStream.m2630b(4, this.aKv);
        }
        return g;
    }

    private int m3070a(Thread thread, Throwable th, String str, long j, Map<String, String> map, float f, int i, boolean z, int i2, long j2, long j3, acp com_fossil_acp) {
        int g = (0 + CodedOutputStream.m2634g(1, j)) + CodedOutputStream.m2630b(2, acp.ar(str));
        int a = m3069a(thread, th, i2, (Map) map);
        g += a + (CodedOutputStream.fc(3) + CodedOutputStream.fe(a));
        a = m3062a(f, i, z, i2, j2, j3);
        g += a + (CodedOutputStream.fc(5) + CodedOutputStream.fe(a));
        if (com_fossil_acp == null) {
            return g;
        }
        a = m3081d(com_fossil_acp);
        return g + (a + (CodedOutputStream.fc(6) + CodedOutputStream.fe(a)));
    }

    private int m3069a(Thread thread, Throwable th, int i, Map<String, String> map) {
        int i2;
        int a = m3068a(thread, th);
        a = (a + (CodedOutputStream.fc(1) + CodedOutputStream.fe(a))) + 0;
        if (map != null) {
            i2 = a;
            for (Entry entry : map.entrySet()) {
                a = m3082q((String) entry.getKey(), (String) entry.getValue());
                i2 = (a + (CodedOutputStream.fc(2) + CodedOutputStream.fe(a))) + i2;
            }
        } else {
            i2 = a;
        }
        if (this.aKq != null) {
            i2 += CodedOutputStream.m2635p(3, this.aKq.importance != 100);
        }
        return CodedOutputStream.bk(4, i) + i2;
    }

    private int m3068a(Thread thread, Throwable th) {
        int i;
        int a = m3071a(thread, this.aKt, 4, true);
        a = (a + (CodedOutputStream.fc(1) + CodedOutputStream.fe(a))) + 0;
        int length = this.aKr.length;
        int i2 = a;
        for (i = 0; i < length; i++) {
            a = m3071a(this.aKr[i], (StackTraceElement[]) this.aKs.get(i), 0, false);
            i2 += a + (CodedOutputStream.fc(1) + CodedOutputStream.fe(a));
        }
        a = m3072a(th, 1);
        a = (a + (CodedOutputStream.fc(2) + CodedOutputStream.fe(a))) + i2;
        i = yL();
        a += i + (CodedOutputStream.fc(3) + CodedOutputStream.fe(i));
        i = yK();
        return a + (i + (CodedOutputStream.fc(3) + CodedOutputStream.fe(i)));
    }

    private int m3082q(String str, String str2) {
        int b = CodedOutputStream.m2630b(1, acp.ar(str));
        if (str2 == null) {
            str2 = "";
        }
        return b + CodedOutputStream.m2630b(2, acp.ar(str2));
    }

    private int m3062a(float f, int i, boolean z, int i2, long j, long j2) {
        return (((((0 + CodedOutputStream.m2633f(1, f)) + CodedOutputStream.bm(2, i)) + CodedOutputStream.m2635p(3, z)) + CodedOutputStream.bk(4, i2)) + CodedOutputStream.m2634g(5, j)) + CodedOutputStream.m2634g(6, j2);
    }

    private int m3081d(acp com_fossil_acp) {
        return CodedOutputStream.m2630b(1, com_fossil_acp);
    }

    private int m3072a(Throwable th, int i) {
        int i2 = 0;
        int b = CodedOutputStream.m2630b(1, acp.ar(th.getClass().getName())) + 0;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            b += CodedOutputStream.m2630b(3, acp.ar(localizedMessage));
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i3 = 0;
        while (i3 < length) {
            int a = m3067a(stackTrace[i3], true);
            i3++;
            b = (a + (CodedOutputStream.fc(4) + CodedOutputStream.fe(a))) + b;
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return b;
        }
        if (i < this.aKw) {
            i2 = m3072a(cause, i + 1);
            return b + (i2 + (CodedOutputStream.fc(6) + CodedOutputStream.fe(i2)));
        }
        while (cause != null) {
            cause = cause.getCause();
            i2++;
        }
        return b + CodedOutputStream.bk(7, i2);
    }

    private int yL() {
        return ((0 + CodedOutputStream.m2630b(1, aKp)) + CodedOutputStream.m2630b(2, aKp)) + CodedOutputStream.m2634g(3, 0);
    }

    private int m3067a(StackTraceElement stackTraceElement, boolean z) {
        int g;
        int i;
        if (stackTraceElement.isNativeMethod()) {
            g = CodedOutputStream.m2634g(1, (long) Math.max(stackTraceElement.getLineNumber(), 0)) + 0;
        } else {
            g = CodedOutputStream.m2634g(1, 0) + 0;
        }
        g += CodedOutputStream.m2630b(2, acp.ar(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            g += CodedOutputStream.m2630b(3, acp.ar(stackTraceElement.getFileName()));
        }
        if (stackTraceElement.isNativeMethod() || stackTraceElement.getLineNumber() <= 0) {
            i = g;
        } else {
            i = g + CodedOutputStream.m2634g(4, (long) stackTraceElement.getLineNumber());
        }
        return CodedOutputStream.bk(5, z ? 2 : 0) + i;
    }

    private int m3071a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int bk = CodedOutputStream.bk(2, i) + CodedOutputStream.m2630b(1, acp.ar(thread.getName()));
        for (StackTraceElement a : stackTraceElementArr) {
            int a2 = m3067a(a, z);
            bk += a2 + (CodedOutputStream.fc(3) + CodedOutputStream.fe(a2));
        }
        return bk;
    }

    private acp aO(String str) {
        return str == null ? null : acp.ar(str);
    }
}
