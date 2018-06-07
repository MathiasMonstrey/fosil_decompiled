package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import com.fossil.eh.C3379a;
import com.fossil.ei.C3383c;
import com.fossil.ei.C3404a;
import com.fossil.gg.C3381a;
import java.util.List;
import java.util.Map;

public class eg extends gn {

    public interface C1305a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    static class C3380b extends C3379a {
        private gg HM;

        public C3380b(gg ggVar) {
            this.HM = ggVar;
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.HM.onSharedElementStart(list, list2, list3);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.HM.onSharedElementEnd(list, list2, list3);
        }

        public void onRejectSharedElements(List<View> list) {
            this.HM.onRejectSharedElements(list);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.HM.onMapSharedElements(list, map);
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.HM.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.HM.onCreateSnapshotView(context, parcelable);
        }
    }

    static class C3384c extends C3383c {
        private gg HM;

        public C3384c(gg ggVar) {
            this.HM = ggVar;
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.HM.onSharedElementStart(list, list2, list3);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.HM.onSharedElementEnd(list, list2, list3);
        }

        public void onRejectSharedElements(List<View> list) {
            this.HM.onRejectSharedElements(list);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.HM.onMapSharedElements(list, map);
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.HM.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.HM.onCreateSnapshotView(context, parcelable);
        }

        public void mo2853a(List<String> list, List<View> list2, final C3404a c3404a) {
            this.HM.m11511a(list, list2, new C3381a(this) {
                final /* synthetic */ C3384c HO;

                public void onSharedElementsReady() {
                    c3404a.onSharedElementsReady();
                }
            });
        }
    }

    public static void m10639a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            ek.m10794a(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void m10640a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        if (VERSION.SDK_INT >= 16) {
            ek.m10795a(activity, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public static void m10638a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            ek.m10793a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m10645b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            eh.m10746b(activity);
        } else {
            activity.finish();
        }
    }

    public static void m10641a(Activity activity, gg ggVar) {
        if (VERSION.SDK_INT >= 23) {
            ei.m10754a(activity, m10644b(ggVar));
        } else if (VERSION.SDK_INT >= 21) {
            eh.m10745a(activity, m10637a(ggVar));
        }
    }

    public static void m10646b(Activity activity, gg ggVar) {
        if (VERSION.SDK_INT >= 23) {
            ei.m10757b(activity, m10644b(ggVar));
        } else if (VERSION.SDK_INT >= 21) {
            eh.m10747b(activity, m10637a(ggVar));
        }
    }

    public static void m10647c(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            eh.m10748c(activity);
        }
    }

    public static void m10648d(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            eh.m10749d(activity);
        }
    }

    public static void m10642a(final Activity activity, final String[] strArr, final int i) {
        if (VERSION.SDK_INT >= 23) {
            ei.m10755a(activity, strArr, i);
        } else if (activity instanceof C1305a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((C1305a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean m10643a(Activity activity, String str) {
        if (VERSION.SDK_INT >= 23) {
            return ei.m10756a(activity, str);
        }
        return false;
    }

    private static C3379a m10637a(gg ggVar) {
        if (ggVar != null) {
            return new C3380b(ggVar);
        }
        return null;
    }

    private static C3383c m10644b(gg ggVar) {
        if (ggVar != null) {
            return new C3384c(ggVar);
        }
        return null;
    }
}
