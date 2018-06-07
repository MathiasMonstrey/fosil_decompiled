package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import com.fossil.eh.C3379a;
import java.util.List;
import java.util.Map;

@TargetApi(23)
class ei {

    public interface C1306b {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static abstract class C3383c extends C3379a {
        public abstract void mo2853a(List<String> list, List<View> list2, C3404a c3404a);
    }

    public interface C3404a {
        void onSharedElementsReady();
    }

    static class C3406d extends SharedElementCallback {
        private C3383c HQ;

        public C3406d(C3383c c3383c) {
            this.HQ = c3383c;
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.HQ.onSharedElementStart(list, list2, list3);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.HQ.onSharedElementEnd(list, list2, list3);
        }

        public void onRejectSharedElements(List<View> list) {
            this.HQ.onRejectSharedElements(list);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.HQ.onMapSharedElements(list, map);
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.HQ.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.HQ.onCreateSnapshotView(context, parcelable);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, final OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.HQ.mo2853a(list, list2, new C3404a(this) {
                final /* synthetic */ C3406d HS;

                public void onSharedElementsReady() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            });
        }
    }

    public static void m10755a(Activity activity, String[] strArr, int i) {
        if (activity instanceof C1306b) {
            ((C1306b) activity).validateRequestPermissionsRequestCode(i);
        }
        activity.requestPermissions(strArr, i);
    }

    public static boolean m10756a(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }

    public static void m10754a(Activity activity, C3383c c3383c) {
        activity.setEnterSharedElementCallback(m10753a(c3383c));
    }

    public static void m10757b(Activity activity, C3383c c3383c) {
        activity.setExitSharedElementCallback(m10753a(c3383c));
    }

    private static SharedElementCallback m10753a(C3383c c3383c) {
        if (c3383c != null) {
            return new C3406d(c3383c);
        }
        return null;
    }
}
