package com.fossil;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.service.FossilNotificationListenerService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;

public final class dre {
    private static final String ACCESS_FINE_LOCATION = ACCESS_FINE_LOCATION;
    private static final String BLUETOOTH = BLUETOOTH;
    private static final String CAMERA = CAMERA;
    private static final String HUAWEI_LOCAL_PROVIDER = HUAWEI_LOCAL_PROVIDER;
    private static final String HUAWEI_MODEL = HUAWEI_MODEL;
    private static final String LOCATION_SERVICE = LOCATION_SERVICE;
    private static final String READ_CONTACTS = READ_CONTACTS;
    private static final String READ_PHONE_STATE = READ_PHONE_STATE;
    private static final String READ_SMS = READ_SMS;
    private static final String TAG = TAG;
    private static final String WRITE_EXTERNAL_STORAGE = WRITE_EXTERNAL_STORAGE;
    private static final int dfd = 113;
    private static final String dfe = dfe;
    public static final C3112a dff = new C3112a();

    public static final class C3112a {
        private C3112a() {
        }

        private final String getTAG() {
            return dre.TAG;
        }

        private final String auA() {
            return dre.HUAWEI_MODEL;
        }

        private final String auB() {
            return dre.HUAWEI_LOCAL_PROVIDER;
        }

        public final boolean auC() {
            LocationManager locationManager = (LocationManager) PortfolioApp.ZQ().getSystemService("location");
            if (locationManager == null) {
                return false;
            }
            String bestProvider = locationManager.getBestProvider(new Criteria(), true);
            if (euh.m11223L(bestProvider) || esl.m11125C("passive", bestProvider) || (etc.m11134c(auA(), Build.MANUFACTURER, true) && etc.m11134c(auB(), bestProvider, true))) {
                return false;
            }
            return true;
        }

        public final boolean auD() {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            return defaultAdapter != null && defaultAdapter.isEnabled();
        }

        public final boolean auE() {
            PortfolioApp ZQ = PortfolioApp.ZQ();
            String string = Secure.getString(ZQ.getContentResolver(), "enabled_notification_listeners");
            String str = ZQ.getPackageName() + "/" + FossilNotificationListenerService.class.getCanonicalName();
            MFLogger.m12670d(getTAG(), "isNotificationListenerEnabled - notificationServicePath=" + str + ", enabledNotificationListeners=" + string);
            return !TextUtils.isEmpty((CharSequence) string) && etd.m11143a(string, str, false, 2, null);
        }

        public final boolean ct(Context context) {
            esl.m11128j(context, "context");
            return m9459G(context, "android.permission.READ_CONTACTS");
        }

        public final boolean cu(Context context) {
            esl.m11128j(context, "context");
            return m9459G(context, "android.permission.READ_PHONE_STATE");
        }

        public final boolean cv(Context context) {
            esl.m11128j(context, "context");
            return m9459G(context, "android.permission.READ_SMS");
        }

        public final boolean cw(Context context) {
            esl.m11128j(context, "context");
            return m9459G(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        }

        public final boolean cx(Context context) {
            esl.m11128j(context, "context");
            return m9459G(context, "android.permission.ACCESS_FINE_LOCATION");
        }

        public final boolean cy(Context context) {
            esl.m11128j(context, "context");
            return m9459G(context, "android.permission.CAMERA");
        }

        public final boolean m9462a(Context context, String... strArr) {
            esl.m11128j(strArr, "perms");
            return evb.m11256b(context, (String[]) Arrays.copyOf(strArr, strArr.length));
        }

        private final String auF() {
            return dre.ACCESS_FINE_LOCATION;
        }

        private final String auG() {
            return dre.LOCATION_SERVICE;
        }

        private final String auH() {
            return dre.BLUETOOTH;
        }

        private final String auI() {
            return dre.READ_CONTACTS;
        }

        private final String auJ() {
            return dre.READ_PHONE_STATE;
        }

        private final String auK() {
            return dre.READ_SMS;
        }

        private final String auL() {
            return dre.CAMERA;
        }

        private final String auM() {
            return dre.WRITE_EXTERNAL_STORAGE;
        }

        private final String auN() {
            return dre.dfe;
        }

        private final HashMap<String, Boolean> auO() {
            PortfolioApp ZQ = PortfolioApp.ZQ();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map map = linkedHashMap;
            String auF = auF();
            C3112a c3112a = this;
            esl.m11127i(ZQ, "context");
            map.put(auF, Boolean.valueOf(cx(ZQ)));
            linkedHashMap.put(auG(), Boolean.valueOf(auC()));
            linkedHashMap.put(auH(), Boolean.valueOf(auD()));
            linkedHashMap.put(auI(), Boolean.valueOf(ct(ZQ)));
            linkedHashMap.put(auJ(), Boolean.valueOf(cu(ZQ)));
            linkedHashMap.put(auK(), Boolean.valueOf(cv(ZQ)));
            linkedHashMap.put(auN(), Boolean.valueOf(auE()));
            linkedHashMap.put(auL(), Boolean.valueOf(cy(ZQ)));
            linkedHashMap.put(auM(), Boolean.valueOf(cw(ZQ)));
            return linkedHashMap;
        }

        public final String[] auP() {
            HashMap auO = auO();
            Collection arrayList = new ArrayList();
            for (Object next : auO.keySet()) {
                String str = (String) next;
                Map map = auO;
                esl.m11127i(str, "it");
                if (((Boolean) esh.m11122h(map, str)).booleanValue()) {
                    arrayList.add(next);
                }
            }
            arrayList = (List) arrayList;
            Object[] toArray = arrayList.toArray(new String[arrayList.size()]);
            if (toArray != null) {
                return (String[]) toArray;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final boolean m9463c(Activity activity, int i) {
            esl.m11128j(activity, Constants.ACTIVITY);
            if (cx(activity)) {
                return true;
            }
            eg.m10642a(activity, (String[]) ((Object[]) new String[]{"android.permission.ACCESS_FINE_LOCATION"}), i);
            return false;
        }

        private final boolean m9459G(Context context, String str) {
            if (VERSION.SDK_INT >= 23 && gn.m10631b(context, str) != 0) {
                return false;
            }
            return true;
        }

        public final void m9461a(Fragment fragment, int i, String... strArr) {
            esl.m11128j(fragment, "fragment");
            esl.m11128j(strArr, "perms");
            if (evb.m11256b(fragment.getContext(), (String[]) Arrays.copyOf(strArr, strArr.length))) {
                m9460a((Object) fragment, i, (String[]) Arrays.copyOf(strArr, strArr.length));
            } else {
                fragment.requestPermissions(strArr, i);
            }
        }

        private final void m9460a(Object obj, int i, String... strArr) {
            int[] iArr = new int[((Object[]) strArr).length];
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = 0;
            }
            evb.m11254a(i, strArr, iArr, obj);
        }
    }
}
