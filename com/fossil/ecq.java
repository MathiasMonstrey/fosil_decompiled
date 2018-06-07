package com.fossil;

import android.util.Log;
import com.facebook.internal.ServerProtocol;
import java.util.Locale;

public class ecq {
    public static final C3318a dDF = new C3318a();
    private static C3317b dDG = dDF;

    public interface C3317b {
        void mo2796a(int i, String str, Object obj);

        void mo2797a(int i, String str, Throwable th);

        void mo2798a(int i, String str, Object... objArr);

        void mo2799y(int i, String str);
    }

    public static class C3318a implements C3317b {
        private int dDH = 4;

        public void mo2799y(int i, String str) {
            if (i >= this.dDH) {
                switch (i) {
                    case 3:
                        Log.d(ServerProtocol.DIALOG_PARAM_SDK_VERSION, str);
                        return;
                    case 4:
                        Log.i(ServerProtocol.DIALOG_PARAM_SDK_VERSION, str);
                        return;
                    case 5:
                        Log.w(ServerProtocol.DIALOG_PARAM_SDK_VERSION, str);
                        return;
                    case 6:
                        Log.e(ServerProtocol.DIALOG_PARAM_SDK_VERSION, str);
                        return;
                    case 8:
                        Log.e(ServerProtocol.DIALOG_PARAM_SDK_VERSION, str);
                        return;
                    default:
                        return;
                }
            }
        }

        public void mo2796a(int i, String str, Object obj) {
            if (i >= this.dDH) {
                mo2799y(i, ecq.m10492j(str, obj));
            }
        }

        public void mo2798a(int i, String str, Object... objArr) {
            if (i >= this.dDH) {
                mo2799y(i, ecq.m10491f(str, objArr));
            }
        }

        public void mo2797a(int i, String str, Throwable th) {
            if (i >= this.dDH) {
                switch (i) {
                    case 3:
                        Log.d(ServerProtocol.DIALOG_PARAM_SDK_VERSION, str, th);
                        return;
                    case 4:
                        Log.i(ServerProtocol.DIALOG_PARAM_SDK_VERSION, str, th);
                        return;
                    case 5:
                        Log.w(ServerProtocol.DIALOG_PARAM_SDK_VERSION, str, th);
                        return;
                    case 6:
                        Log.e(ServerProtocol.DIALOG_PARAM_SDK_VERSION, str, th);
                        return;
                    case 8:
                        Log.e(ServerProtocol.DIALOG_PARAM_SDK_VERSION, str, th);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static void error(String str) {
        dDG.mo2799y(6, str);
    }

    public static void error(String str, Object... objArr) {
        dDG.mo2798a(6, str, objArr);
    }

    public static void m10489d(String str, Throwable th) {
        dDG.mo2797a(6, str, th);
    }

    public static void debug(String str) {
        dDG.mo2799y(3, str);
    }

    public static void debug(String str, Object obj) {
        dDG.mo2796a(3, str, obj);
    }

    public static void m10490e(String str, Throwable th) {
        dDG.mo2797a(3, str, th);
    }

    public static String m10492j(String str, Object obj) {
        if (obj == null) {
            return str;
        }
        return String.format(Locale.US, str, new Object[]{obj});
    }

    public static String m10491f(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }
}
