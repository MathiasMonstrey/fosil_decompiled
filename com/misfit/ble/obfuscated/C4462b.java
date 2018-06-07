package com.misfit.ble.obfuscated;

import com.flurry.android.FlurryEventRecordStatus;
import com.fossil.amv;
import com.fossil.amv.a;
import com.fossil.amw;
import com.misfit.ble.obfuscated.C4435a.C4434a;
import com.misfit.ble.setting.SDKSetting;
import com.misfit.ble.util.LogUtils;
import java.util.HashMap;

public class C4462b {
    private static final String TAG = C4462b.class.getName();
    private static volatile int f1527j = 0;
    private static volatile int f1528k = 0;
    private static amw f1529l = new C44611();

    static class C44611 implements amw {
        C44611() {
        }

        public void onSessionStarted() {
            amv.ce(SDKSetting.getSDKVersion() + "-" + SDKSetting.getBuildNumber());
            amv.setUserId(SDKSetting.getUserId());
        }
    }

    public static void init() {
        new a().aS(false).b(f1529l).O(5000).j(C4592s.getApplicationContext(), "D8JMM3NVKK6SX8M7FS52");
    }

    private static boolean m14832c() {
        if (amv.HB()) {
            return true;
        }
        try {
            amv.T(C4592s.getApplicationContext());
            f1527j = 0;
            f1528k = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amv.HB();
    }

    public static void m14833d() {
        if (C4592s.getApplicationContext() != null && amv.HB()) {
            LogUtils.m15476d(TAG, "Finish Flurry Session");
            amv.U(C4592s.getApplicationContext());
        }
    }

    public static FlurryEventRecordStatus m14830a(C4435a c4435a) {
        return C4462b.m14829a(c4435a.m14671a(), c4435a.m14673b(), false);
    }

    private static FlurryEventRecordStatus m14829a(C4434a c4434a, HashMap<String, String> hashMap, boolean z) {
        if (!C4462b.m14832c()) {
            return FlurryEventRecordStatus.kFlurryEventFailed;
        }
        FlurryEventRecordStatus a = amv.a(c4434a.name(), hashMap, z);
        if (a != FlurryEventRecordStatus.kFlurryEventRecorded && a != FlurryEventRecordStatus.kFlurryEventLoggingDelayed) {
            return a;
        }
        f1527j++;
        if (f1527j <= 50) {
            return a;
        }
        C4462b.m14833d();
        return a;
    }

    public static void m14831a(Throwable th, String str) {
        if (C4462b.m14832c()) {
            amv.a(C4434a.EXCEPTION.name(), str, th);
            f1528k++;
            if (f1528k > 30) {
                C4462b.m14833d();
            }
        }
    }
}
