package com.fossil;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.fossil.C1909b.C1908a;
import com.fossil.tq.a;
import com.portfolio.platform.data.model.Widget;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class C2161i extends C1548a {
    static int SDK_INT = VERSION.SDK_INT;
    private static final int og = "binding_".length();
    private static final boolean oh = (C1978c.ob >= 14);
    private static final boolean oi;
    private static final C3679a oj = new C36801();
    private static final C3679a ok = new C36812();
    private static final C3679a ol = new C36823();
    private static final C1908a<C3610g, C2161i, Void> om = new C36834();
    private static final ReferenceQueue<C2161i> on = new ReferenceQueue();
    private static final OnAttachStateChangeListener oo;
    protected final C2160d oA;
    private C2161i oB;
    private final Runnable op = new C36856(this);
    private boolean oq = false;
    private boolean or = false;
    private C3689d[] ot;
    private final View ou;
    private C1909b<C3610g, C2161i, Void> ov;
    private boolean ow;
    private Choreographer ox;
    private final FrameCallback oy;
    private Handler oz;

    interface C3679a {
    }

    static class C36801 implements C3679a {
        C36801() {
        }
    }

    static class C36812 implements C3679a {
        C36812() {
        }
    }

    static class C36823 implements C3679a {
        C36823() {
        }
    }

    static class C36834 extends C1908a<C3610g, C2161i, Void> {
        C36834() {
        }

        public void m11711a(C3610g c3610g, C2161i c2161i, int i, Void voidR) {
            switch (i) {
                case 1:
                    if (!c3610g.m11499a(c2161i)) {
                        c2161i.or = true;
                        return;
                    }
                    return;
                case 2:
                    c3610g.m11500b(c2161i);
                    return;
                case 3:
                    c3610g.m11501c(c2161i);
                    return;
                default:
                    return;
            }
        }
    }

    static class C36845 implements OnAttachStateChangeListener {
        C36845() {
        }

        @TargetApi(19)
        public void onViewAttachedToWindow(View view) {
            C2161i.m6994b(view).op.run();
            view.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    class C36856 implements Runnable {
        final /* synthetic */ C2161i oC;

        C36856(C2161i c2161i) {
            this.oC = c2161i;
        }

        public void run() {
            synchronized (this) {
                this.oC.oq = false;
            }
            C2161i.dB();
            if (VERSION.SDK_INT < 19 || this.oC.ou.isAttachedToWindow()) {
                this.oC.dv();
                return;
            }
            this.oC.ou.removeOnAttachStateChangeListener(C2161i.oo);
            this.oC.ou.addOnAttachStateChangeListener(C2161i.oo);
        }
    }

    class C36867 implements FrameCallback {
        final /* synthetic */ C2161i oC;

        C36867(C2161i c2161i) {
            this.oC = c2161i;
        }

        public void doFrame(long j) {
            this.oC.op.run();
        }
    }

    public static class C3687b {
        public final String[][] oD;
        public final int[][] oE;
        public final int[][] oF;

        public C3687b(int i) {
            this.oD = new String[i][];
            this.oE = new int[i][];
            this.oF = new int[i][];
        }

        public void m11713a(int i, String[] strArr, int[] iArr, int[] iArr2) {
            this.oD[i] = strArr;
            this.oE[i] = iArr;
            this.oF[i] = iArr2;
        }
    }

    interface C3688c<T> {
        void m11714b(T t);
    }

    static class C3689d<T> extends WeakReference<C2161i> {
        private final C3688c<T> oG;
        private T oH;

        public boolean dE() {
            boolean z = false;
            if (this.oH != null) {
                this.oG.m11714b(this.oH);
                z = true;
            }
            this.oH = null;
            return z;
        }
    }

    protected abstract void dx();

    public abstract boolean dy();

    static {
        boolean z = true;
        if (SDK_INT < 16) {
            z = false;
        }
        oi = z;
        if (VERSION.SDK_INT < 19) {
            oo = null;
        } else {
            oo = new C36845();
        }
    }

    protected C2161i(C2160d c2160d, View view, int i) {
        this.oA = c2160d;
        this.ot = new C3689d[i];
        this.ou = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        } else if (oi) {
            this.ox = Choreographer.getInstance();
            this.oy = new C36867(this);
        } else {
            this.oy = null;
            this.oz = new Handler(Looper.myLooper());
        }
    }

    protected void m7001a(View view) {
        if (oh) {
            view.setTag(a.dataBinding, this);
        } else {
            view.setTag(this);
        }
    }

    public void dv() {
        if (this.oB == null) {
            dw();
        } else {
            this.oB.dv();
        }
    }

    private void dw() {
        if (this.ow) {
            dA();
        } else if (dy()) {
            this.ow = true;
            this.or = false;
            if (this.ov != null) {
                this.ov.m4765a(this, 1, null);
                if (this.or) {
                    this.ov.m4765a(this, 2, null);
                }
            }
            if (!this.or) {
                dx();
                if (this.ov != null) {
                    this.ov.m4765a(this, 3, null);
                }
            }
            this.ow = false;
        }
    }

    protected static void m6998d(C2161i c2161i) {
        c2161i.dw();
    }

    static C2161i m6994b(View view) {
        if (view != null) {
            if (oh) {
                return (C2161i) view.getTag(a.dataBinding);
            }
            Object tag = view.getTag();
            if (tag instanceof C2161i) {
                return (C2161i) tag;
            }
        }
        return null;
    }

    public View dz() {
        return this.ou;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void dA() {
        /*
        r2 = this;
        r0 = r2.oB;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r2.oB;
        r0.dA();
    L_0x0009:
        return;
    L_0x000a:
        monitor-enter(r2);
        r0 = r2.oq;	 Catch:{ all -> 0x0011 }
        if (r0 == 0) goto L_0x0014;
    L_0x000f:
        monitor-exit(r2);	 Catch:{ all -> 0x0011 }
        goto L_0x0009;
    L_0x0011:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0011 }
        throw r0;
    L_0x0014:
        r0 = 1;
        r2.oq = r0;	 Catch:{ all -> 0x0011 }
        monitor-exit(r2);	 Catch:{ all -> 0x0011 }
        r0 = oi;
        if (r0 == 0) goto L_0x0024;
    L_0x001c:
        r0 = r2.ox;
        r1 = r2.oy;
        r0.postFrameCallback(r1);
        goto L_0x0009;
    L_0x0024:
        r0 = r2.oz;
        r1 = r2.op;
        r0.post(r1);
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.i.dA():void");
    }

    protected void m7002c(Class<?> cls) {
        if (this.oA == null) {
            throw new IllegalStateException("Required DataBindingComponent is null in class " + getClass().getSimpleName() + ". A BindingAdapter in " + cls.getCanonicalName() + " is not static and requires an object to use, retrieved from the " + "DataBindingComponent. If you don't use an inflation method taking a " + "DataBindingComponent, use DataBindingUtil.setDefaultComponent or " + "make all BindingAdapter methods static.");
        }
    }

    protected static Object[] m6993a(C2160d c2160d, View view, int i, C3687b c3687b, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i];
        C2161i.m6991a(c2160d, view, objArr, c3687b, sparseIntArray, true);
        return objArr;
    }

    protected void m7003e(C2161i c2161i) {
        if (c2161i != null) {
            c2161i.oB = this;
        }
    }

    private static void m6991a(C2160d c2160d, View view, Object[] objArr, C3687b c3687b, SparseIntArray sparseIntArray, boolean z) {
        if (C2161i.m6994b(view) == null) {
            String str;
            int lastIndexOf;
            int c;
            int i;
            Object tag = view.getTag();
            if (tag instanceof String) {
                str = (String) tag;
            } else {
                str = null;
            }
            tag = null;
            if (z && str != null && str.startsWith(Widget.COLUMN_LAYOUT)) {
                int i2;
                lastIndexOf = str.lastIndexOf(95);
                if (lastIndexOf <= 0 || !C2161i.m6996b(str, lastIndexOf + 1)) {
                    i2 = -1;
                } else {
                    c = C2161i.m6997c(str, lastIndexOf + 1);
                    if (objArr[c] == null) {
                        objArr[c] = view;
                    }
                    if (c3687b == null) {
                        c = -1;
                    }
                    i2 = c;
                    tag = 1;
                }
                i = i2;
            } else if (str == null || !str.startsWith("binding_")) {
                i = -1;
            } else {
                c = C2161i.m6997c(str, og);
                if (objArr[c] == null) {
                    objArr[c] = view;
                }
                if (c3687b == null) {
                    c = -1;
                }
                i = c;
                c = 1;
            }
            if (tag == null) {
                c = view.getId();
                if (c > 0 && sparseIntArray != null) {
                    c = sparseIntArray.get(c, -1);
                    if (c >= 0 && objArr[c] == null) {
                        objArr[c] = view;
                    }
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i4 < childCount) {
                    int i5;
                    int i6;
                    View childAt = viewGroup.getChildAt(i4);
                    if (i >= 0 && (childAt.getTag() instanceof String)) {
                        String str2 = (String) childAt.getTag();
                        if (str2.endsWith("_0") && str2.startsWith(Widget.COLUMN_LAYOUT) && str2.indexOf(47) > 0) {
                            int a = C2161i.m6990a(str2, i3, c3687b, i);
                            if (a >= 0) {
                                tag = 1;
                                i3 = a + 1;
                                i5 = c3687b.oE[i][a];
                                a = c3687b.oF[i][a];
                                lastIndexOf = C2161i.m6989a(viewGroup, i4);
                                if (lastIndexOf == i4) {
                                    objArr[i5] = C3311e.m10388b(c2160d, childAt, a);
                                    i5 = i4;
                                    i6 = i3;
                                } else {
                                    i6 = (lastIndexOf - i4) + 1;
                                    View[] viewArr = new View[i6];
                                    for (lastIndexOf = 0; lastIndexOf < i6; lastIndexOf++) {
                                        viewArr[lastIndexOf] = viewGroup.getChildAt(i4 + lastIndexOf);
                                    }
                                    objArr[i5] = C3311e.m10389b(c2160d, viewArr, a);
                                    i5 = (i6 - 1) + i4;
                                    i6 = i3;
                                }
                                if (tag == null) {
                                    C2161i.m6991a(c2160d, childAt, objArr, c3687b, sparseIntArray, false);
                                }
                                i4 = i5 + 1;
                                i3 = i6;
                            }
                        }
                    }
                    tag = null;
                    i5 = i4;
                    i6 = i3;
                    if (tag == null) {
                        C2161i.m6991a(c2160d, childAt, objArr, c3687b, sparseIntArray, false);
                    }
                    i4 = i5 + 1;
                    i3 = i6;
                }
            }
        }
    }

    private static int m6990a(String str, int i, C3687b c3687b, int i2) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = c3687b.oD[i2];
        int length = strArr.length;
        for (int i3 = i; i3 < length; i3++) {
            if (TextUtils.equals(subSequence, strArr[i3])) {
                return i3;
            }
        }
        return -1;
    }

    private static int m6989a(ViewGroup viewGroup, int i) {
        String str = (String) viewGroup.getChildAt(i).getTag();
        String substring = str.substring(0, str.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        int i2 = i + 1;
        int i3 = i;
        while (i2 < childCount) {
            int i4;
            View childAt = viewGroup.getChildAt(i2);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(substring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    break;
                } else if (C2161i.m6996b(str2, length)) {
                    i4 = i2;
                    i2++;
                    i3 = i4;
                }
            }
            i4 = i3;
            i2++;
            i3 = i4;
        }
        return i3;
    }

    private static boolean m6996b(String str, int i) {
        int length = str.length();
        if (length == i) {
            return false;
        }
        while (i < length) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static int m6997c(String str, int i) {
        int i2 = 0;
        while (i < str.length()) {
            i2 = (i2 * 10) + (str.charAt(i) - 48);
            i++;
        }
        return i2;
    }

    private static void dB() {
        while (true) {
            Reference poll = on.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof C3689d) {
                ((C3689d) poll).dE();
            }
        }
    }
}
