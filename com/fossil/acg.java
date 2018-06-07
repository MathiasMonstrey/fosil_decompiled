package com.fossil;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class acg extends emr<Boolean> implements enk {
    private final emx<String> aIm = new emx();
    private final acl aIn = new acl();
    private acn aIo;

    protected /* synthetic */ Object xf() {
        return xi();
    }

    @TargetApi(14)
    protected boolean xh() {
        this.aIo = m2930a(VERSION.SDK_INT, (Application) getContext().getApplicationContext());
        return true;
    }

    protected Boolean xi() {
        emm.aEU().mo2950d("Beta", "Beta kit initializing...");
        Context context = getContext();
        IdManager aEZ = aEZ();
        if (TextUtils.isEmpty(m2929g(context, aEZ.getInstallerPackageName()))) {
            emm.aEU().mo2950d("Beta", "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        emm.aEU().mo2950d("Beta", "Beta device token is present, checking for app updates.");
        epi xz = xz();
        ach N = m2928N(context);
        if (m2931a(xz, N)) {
            this.aIo.mo809a(context, this, aEZ, xz, N, new epc(this), new enp(), new eou(emm.aEU()));
        }
        return Boolean.valueOf(true);
    }

    @TargetApi(14)
    acn m2930a(int i, Application application) {
        if (i >= 14) {
            return new acf(aFa().aES(), aFa().aET());
        }
        return new acm();
    }

    public Map<DeviceIdentifierType, String> xy() {
        CharSequence g = m2929g(getContext(), aEZ().getInstallerPackageName());
        Map<DeviceIdentifierType, String> hashMap = new HashMap();
        if (!TextUtils.isEmpty(g)) {
            hashMap.put(DeviceIdentifierType.FONT_TOKEN, g);
        }
        return hashMap;
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String getVersion() {
        return "1.1.3.61";
    }

    @TargetApi(11)
    boolean m2932f(String str, int i) {
        if (i < 11) {
            return str == null;
        } else {
            return DeliveryMechanism.BETA_APP_PACKAGE_NAME.equals(str);
        }
    }

    boolean m2931a(epi com_fossil_epi, ach com_fossil_ach) {
        return (com_fossil_epi == null || TextUtils.isEmpty(com_fossil_epi.dQd) || com_fossil_ach == null) ? false : true;
    }

    private String m2929g(Context context, String str) {
        if (m2932f(str, VERSION.SDK_INT)) {
            emm.aEU().mo2950d("Beta", "App was possibly installed by Beta. Getting device token");
            try {
                String str2 = (String) this.aIm.mo2961a(context, this.aIn);
                if ("".equals(str2)) {
                    str2 = null;
                }
                return str2;
            } catch (Throwable e) {
                emm.aEU().mo2953g("Beta", "Failed to load the Beta device token", e);
                return null;
            }
        }
        emm.aEU().mo2950d("Beta", "App was not installed by Beta. Skipping device token");
        return null;
    }

    private epi xz() {
        epv aGB = ept.aGA().aGB();
        if (aGB != null) {
            return aGB.dQH;
        }
        return null;
    }

    private ach m2928N(Context context) {
        Throwable th;
        Throwable e;
        Object obj;
        Throwable th2;
        ach com_fossil_ach;
        InputStream inputStream = null;
        InputStream open;
        try {
            open = context.getAssets().open("crashlytics-build.properties");
            if (open != null) {
                ach h;
                try {
                    h = ach.m2934h(open);
                } catch (Throwable e2) {
                    th = e2;
                    obj = inputStream;
                    th2 = th;
                    try {
                        emm.aEU().mo2953g("Beta", "Error reading Beta build properties", th2);
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th22) {
                                emm.aEU().mo2953g("Beta", "Error closing Beta build properties asset", th22);
                            }
                        }
                        return com_fossil_ach;
                    } catch (Throwable th3) {
                        e2 = th3;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th222) {
                                emm.aEU().mo2953g("Beta", "Error closing Beta build properties asset", th222);
                            }
                        }
                        throw e2;
                    }
                }
                try {
                    emm.aEU().mo2950d("Beta", h.packageName + " build properties: " + h.versionName + " (" + h.aHl + ")" + " - " + h.aHV);
                    com_fossil_ach = h;
                } catch (Throwable e22) {
                    th = e22;
                    com_fossil_ach = h;
                    th222 = th;
                    emm.aEU().mo2953g("Beta", "Error reading Beta build properties", th222);
                    if (open != null) {
                        open.close();
                    }
                    return com_fossil_ach;
                }
            }
            obj = inputStream;
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2222) {
                    emm.aEU().mo2953g("Beta", "Error closing Beta build properties asset", th2222);
                }
            }
        } catch (Throwable e222) {
            open = inputStream;
            InputStream inputStream2 = inputStream;
            th2222 = e222;
            com_fossil_ach = inputStream2;
            emm.aEU().mo2953g("Beta", "Error reading Beta build properties", th2222);
            if (open != null) {
                open.close();
            }
            return com_fossil_ach;
        } catch (Throwable th4) {
            e222 = th4;
            open = inputStream;
            if (open != null) {
                open.close();
            }
            throw e222;
        }
        return com_fossil_ach;
    }

    String xj() {
        return CommonUtils.aa(getContext(), "com.crashlytics.ApiEndpoint");
    }
}
