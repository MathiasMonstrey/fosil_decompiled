package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

@TargetApi(21)
class eh {

    public static abstract class C3379a {
        public abstract Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF);

        public abstract View onCreateSnapshotView(Context context, Parcelable parcelable);

        public abstract void onMapSharedElements(List<String> list, Map<String, View> map);

        public abstract void onRejectSharedElements(List<View> list);

        public abstract void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3);

        public abstract void onSharedElementStart(List<String> list, List<View> list2, List<View> list3);
    }

    static class C3391b extends SharedElementCallback {
        private C3379a HP;

        public C3391b(C3379a c3379a) {
            this.HP = c3379a;
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.HP.onSharedElementStart(list, list2, list3);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.HP.onSharedElementEnd(list, list2, list3);
        }

        public void onRejectSharedElements(List<View> list) {
            this.HP.onRejectSharedElements(list);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.HP.onMapSharedElements(list, map);
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.HP.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.HP.onCreateSnapshotView(context, parcelable);
        }
    }

    public static void m10746b(Activity activity) {
        activity.finishAfterTransition();
    }

    public static void m10745a(Activity activity, C3379a c3379a) {
        activity.setEnterSharedElementCallback(m10744a(c3379a));
    }

    public static void m10747b(Activity activity, C3379a c3379a) {
        activity.setExitSharedElementCallback(m10744a(c3379a));
    }

    public static void m10748c(Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void m10749d(Activity activity) {
        activity.startPostponedEnterTransition();
    }

    private static SharedElementCallback m10744a(C3379a c3379a) {
        if (c3379a != null) {
            return new C3391b(c3379a);
        }
        return null;
    }
}
