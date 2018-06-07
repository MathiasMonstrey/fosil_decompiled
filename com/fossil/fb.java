package com.fossil;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.C1136b;
import android.support.v8.renderscript.Allocation;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.fossil.fa.C3106a;
import com.fossil.fa.C3555b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class fb extends fa implements km {
    static boolean DEBUG = false;
    static final Interpolator JC = new DecelerateInterpolator(2.5f);
    static final Interpolator JD = new DecelerateInterpolator(1.5f);
    static final Interpolator JE = new AccelerateInterpolator(2.5f);
    static final Interpolator JF = new AccelerateInterpolator(1.5f);
    static final boolean Jb;
    static Field Jq = null;
    ArrayList<C3562e> JA;
    Runnable JB = new C35561(this);
    ArrayList<C3468c> Jc;
    boolean Jd;
    int Je = 0;
    ArrayList<Fragment> Jf;
    SparseArray<Fragment> Jg;
    ArrayList<en> Jh;
    ArrayList<Fragment> Ji;
    ArrayList<en> Jj;
    ArrayList<Integer> Jk;
    ArrayList<C3555b> Jl;
    private CopyOnWriteArrayList<jt<C3106a, Boolean>> Jm;
    int Jn = 0;
    ex Jo;
    Fragment Jp;
    boolean Jr;
    boolean Js;
    String Jt;
    boolean Ju;
    ArrayList<en> Jv;
    ArrayList<Boolean> Jw;
    ArrayList<Fragment> Jx;
    Bundle Jy = null;
    SparseArray<Parcelable> Jz = null;
    boolean mDestroyed;
    public ez mHost;

    interface C3468c {
        boolean mo2969a(ArrayList<en> arrayList, ArrayList<Boolean> arrayList2);
    }

    class C35561 implements Runnable {
        final /* synthetic */ fb JG;

        C35561(fb fbVar) {
            this.JG = fbVar;
        }

        public void run() {
            this.JG.execPendingActions();
        }
    }

    static class C3557a implements AnimationListener {
        private AnimationListener JI;
        private boolean JJ;
        View mView;

        class C35591 implements Runnable {
            final /* synthetic */ C3557a JK;

            C35591(C3557a c3557a) {
                this.JK = c3557a;
            }

            public void run() {
                li.m12244a(this.JK.mView, 0, null);
            }
        }

        public C3557a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.mView = view;
            }
        }

        public C3557a(View view, Animation animation, AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.JI = animationListener;
                this.mView = view;
                this.JJ = true;
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.JI != null) {
                this.JI.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.mView != null && this.JJ) {
                if (li.au(this.mView) || it.ji()) {
                    this.mView.post(new C35591(this));
                } else {
                    li.m12244a(this.mView, 0, null);
                }
            }
            if (this.JI != null) {
                this.JI.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.JI != null) {
                this.JI.onAnimationRepeat(animation);
            }
        }
    }

    static class C3560b {
        public static final int[] JL = new int[]{16842755, 16842960, 16842961};
    }

    class C3561d implements C3468c {
        final /* synthetic */ fb JG;
        final int JM;
        final int mId;
        final String mName;

        C3561d(fb fbVar, String str, int i, int i2) {
            this.JG = fbVar;
            this.mName = str;
            this.mId = i;
            this.JM = i2;
        }

        public boolean mo2969a(ArrayList<en> arrayList, ArrayList<Boolean> arrayList2) {
            return this.JG.m11319a((ArrayList) arrayList, (ArrayList) arrayList2, this.mName, this.mId, this.JM);
        }
    }

    static class C3562e implements C1136b {
        private final boolean JN;
        private final en JO;
        private int JP;

        C3562e(en enVar, boolean z) {
            this.JN = z;
            this.JO = enVar;
        }

        public void hN() {
            this.JP--;
            if (this.JP == 0) {
                this.JO.HV.hZ();
            }
        }

        public void startListening() {
            this.JP++;
        }

        public boolean ij() {
            return this.JP == 0;
        }

        public void ik() {
            boolean z;
            boolean z2 = false;
            if (this.JP > 0) {
                z = true;
            } else {
                z = false;
            }
            fb fbVar = this.JO.HV;
            int size = fbVar.Jf.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) fbVar.Jf.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            fb fbVar2 = this.JO.HV;
            en enVar = this.JO;
            boolean z3 = this.JN;
            if (!z) {
                z2 = true;
            }
            fbVar2.m11286a(enVar, z3, z2, true);
        }

        public void il() {
            this.JO.HV.m11286a(this.JO, this.JN, false, false);
        }
    }

    public boolean execPendingActions() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r1 = 1;
        r4.m11303y(r1);
        r0 = 0;
    L_0x0005:
        r2 = r4.Jv;
        r3 = r4.Jw;
        r2 = r4.m11301d(r2, r3);
        if (r2 == 0) goto L_0x0022;
    L_0x000f:
        r4.Jd = r1;
        r0 = r4.Jv;	 Catch:{ all -> 0x001d }
        r2 = r4.Jw;	 Catch:{ all -> 0x001d }
        r4.m11300c(r0, r2);	 Catch:{ all -> 0x001d }
        r4.ia();
        r0 = r1;
        goto L_0x0005;
    L_0x001d:
        r0 = move-exception;
        r4.ia();
        throw r0;
    L_0x0022:
        r4.ie();
        r4.ih();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.fb.execPendingActions():boolean");
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        Jb = z;
    }

    static boolean m11292a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean m11291a(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && li.m12234R(view) == 0 && li.am(view) && m11292a(animation);
    }

    private void m11289a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new jp("FragmentManager"));
        if (this.mHost != null) {
            try {
                this.mHost.onDump("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                dump("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public fg hW() {
        return new en(this);
    }

    public boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions();
        ib();
        return execPendingActions;
    }

    public void popBackStack() {
        m11318a(new C3561d(this, null, -1, 0), false);
    }

    public boolean popBackStackImmediate() {
        hY();
        return m11293a(null, -1, 0);
    }

    public void popBackStack(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m11318a(new C3561d(this, null, i, i2), false);
    }

    private boolean m11293a(String str, int i, int i2) {
        execPendingActions();
        m11303y(true);
        boolean a = m11319a(this.Jv, this.Jw, str, i, i2);
        if (a) {
            this.Jd = true;
            try {
                m11300c(this.Jv, this.Jw);
            } finally {
                ia();
            }
        }
        ie();
        ih();
        return a;
    }

    public int getBackStackEntryCount() {
        return this.Jh != null ? this.Jh.size() : 0;
    }

    public void m11308a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            m11289a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public Fragment m11320b(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        Fragment fragment = (Fragment) this.Jg.get(i);
        if (fragment != null) {
            return fragment;
        }
        m11289a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(Allocation.USAGE_SHARED);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.Jp != null) {
            jo.m11895a(this.Jp, stringBuilder);
        } else {
            jo.m11895a(this.mHost, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.Jg != null) {
            size = this.Jg.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.Jg.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.Jf != null) {
            size = this.Jf.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.Jf.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.Ji != null) {
            size = this.Ji.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.Ji.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.Jh != null) {
            size = this.Jh.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    en enVar = (en) this.Jh.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(enVar.toString());
                    enVar.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.Jj != null) {
                int size2 = this.Jj.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        enVar = (en) this.Jj.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(enVar);
                    }
                }
            }
            if (this.Jk != null && this.Jk.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.Jk.toArray()));
            }
        }
        if (this.Jc != null) {
            i = this.Jc.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    C3468c c3468c = (C3468c) this.Jc.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(c3468c);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.Jo);
        if (this.Jp != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.Jp);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.Jn);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.Js);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.Jr) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.Jr);
        }
        if (this.Jt != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.Jt);
        }
    }

    static Animation m11285a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(JC);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(JD);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    static Animation m11284a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(JD);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    Animation m11306a(Fragment fragment, int i, boolean z, int i2) {
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, fragment.getNextAnim());
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.getNextAnim() != 0) {
            onCreateAnimation = AnimationUtils.loadAnimation(this.mHost.getContext(), fragment.getNextAnim());
            if (onCreateAnimation != null) {
                return onCreateAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        int c = m11299c(i, z);
        if (c < 0) {
            return null;
        }
        switch (c) {
            case 1:
                return m11285a(this.mHost.getContext(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return m11285a(this.mHost.getContext(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return m11285a(this.mHost.getContext(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return m11285a(this.mHost.getContext(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return m11284a(this.mHost.getContext(), 0.0f, 1.0f);
            case 6:
                return m11284a(this.mHost.getContext(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.mHost.onHasWindowAnimations()) {
                    i2 = this.mHost.onGetWindowAnimations();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public void m11331f(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.Jd) {
            this.Ju = true;
            return;
        }
        fragment.mDeferStart = false;
        m11310a(fragment, this.Jn, 0, 0, false);
    }

    private void m11294b(View view, Animation animation) {
        if (view != null && animation != null && m11291a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (Jq == null) {
                    Jq = Animation.class.getDeclaredField("mListener");
                    Jq.setAccessible(true);
                }
                animationListener = (AnimationListener) Jq.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            li.m12244a(view, 2, null);
            animation.setAnimationListener(new C3557a(view, animation, animationListener));
        }
    }

    public boolean aG(int i) {
        return this.Jn >= i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m11310a(final android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r7 = 0;
        r3 = 0;
        r0 = r11.mAdded;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.mDetached;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.mRemoving;
        if (r0 == 0) goto L_0x0023;
    L_0x0014:
        r0 = r11.mState;
        if (r12 <= r0) goto L_0x0023;
    L_0x0018:
        r0 = r11.mState;
        if (r0 != 0) goto L_0x003b;
    L_0x001c:
        r0 = r11.isInBackStack();
        if (r0 == 0) goto L_0x003b;
    L_0x0022:
        r12 = r5;
    L_0x0023:
        r0 = r11.mDeferStart;
        if (r0 == 0) goto L_0x002e;
    L_0x0027:
        r0 = r11.mState;
        if (r0 >= r9) goto L_0x002e;
    L_0x002b:
        if (r12 <= r6) goto L_0x002e;
    L_0x002d:
        r12 = r6;
    L_0x002e:
        r0 = r11.mState;
        if (r0 >= r12) goto L_0x032d;
    L_0x0032:
        r0 = r11.mFromLayout;
        if (r0 == 0) goto L_0x003e;
    L_0x0036:
        r0 = r11.mInLayout;
        if (r0 != 0) goto L_0x003e;
    L_0x003a:
        return;
    L_0x003b:
        r12 = r11.mState;
        goto L_0x0023;
    L_0x003e:
        r0 = r11.getAnimatingAway();
        if (r0 == 0) goto L_0x0051;
    L_0x0044:
        r11.setAnimatingAway(r7);
        r2 = r11.getStateAfterAnimating();
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m11310a(r1, r2, r3, r4, r5);
    L_0x0051:
        r0 = r11.mState;
        switch(r0) {
            case 0: goto L_0x0091;
            case 1: goto L_0x01a5;
            case 2: goto L_0x02a6;
            case 3: goto L_0x02ab;
            case 4: goto L_0x02cf;
            default: goto L_0x0056;
        };
    L_0x0056:
        r0 = r11.mState;
        if (r0 == r12) goto L_0x003a;
    L_0x005a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.mState;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.mState = r12;
        goto L_0x003a;
    L_0x0091:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x00ad;
    L_0x0095:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x00ad:
        r0 = r11.mSavedFragmentState;
        if (r0 == 0) goto L_0x00f5;
    L_0x00b1:
        r0 = r11.mSavedFragmentState;
        r1 = r10.mHost;
        r1 = r1.getContext();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.mSavedFragmentState;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.mSavedViewState = r0;
        r0 = r11.mSavedFragmentState;
        r1 = "android:target_state";
        r0 = r10.m11320b(r0, r1);
        r11.mTarget = r0;
        r0 = r11.mTarget;
        if (r0 == 0) goto L_0x00e2;
    L_0x00d8:
        r0 = r11.mSavedFragmentState;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.mTargetRequestCode = r0;
    L_0x00e2:
        r0 = r11.mSavedFragmentState;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.mUserVisibleHint = r0;
        r0 = r11.mUserVisibleHint;
        if (r0 != 0) goto L_0x00f5;
    L_0x00f0:
        r11.mDeferStart = r5;
        if (r12 <= r6) goto L_0x00f5;
    L_0x00f4:
        r12 = r6;
    L_0x00f5:
        r0 = r10.mHost;
        r11.mHost = r0;
        r0 = r10.Jp;
        r11.mParentFragment = r0;
        r0 = r10.Jp;
        if (r0 == 0) goto L_0x013e;
    L_0x0101:
        r0 = r10.Jp;
        r0 = r0.mChildFragmentManager;
    L_0x0105:
        r11.mFragmentManager = r0;
        r0 = r10.mHost;
        r0 = r0.getContext();
        r10.m11311a(r11, r0, r3);
        r11.mCalled = r3;
        r0 = r10.mHost;
        r0 = r0.getContext();
        r11.onAttach(r0);
        r0 = r11.mCalled;
        if (r0 != 0) goto L_0x0145;
    L_0x011f:
        r0 = new android.support.v4.app.SuperNotCalledException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x013e:
        r0 = r10.mHost;
        r0 = r0.hT();
        goto L_0x0105;
    L_0x0145:
        r0 = r11.mParentFragment;
        if (r0 != 0) goto L_0x02f9;
    L_0x0149:
        r0 = r10.mHost;
        r0.onAttachFragment(r11);
    L_0x014e:
        r0 = r10.mHost;
        r0 = r0.getContext();
        r10.m11322b(r11, r0, r3);
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x0300;
    L_0x015b:
        r0 = r11.mSavedFragmentState;
        r11.performCreate(r0);
        r0 = r11.mSavedFragmentState;
        r10.m11312a(r11, r0, r3);
    L_0x0165:
        r11.mRetaining = r3;
        r0 = r11.mFromLayout;
        if (r0 == 0) goto L_0x01a5;
    L_0x016b:
        r0 = r11.mSavedFragmentState;
        r0 = r11.performGetLayoutInflater(r0);
        r1 = r11.mSavedFragmentState;
        r0 = r11.performCreateView(r0, r7, r1);
        r11.mView = r0;
        r0 = r11.mView;
        if (r0 == 0) goto L_0x0313;
    L_0x017d:
        r0 = r11.mView;
        r11.mInnerView = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x0309;
    L_0x0187:
        r0 = r11.mView;
        com.fossil.li.m12256c(r0, r3);
    L_0x018c:
        r0 = r11.mHidden;
        if (r0 == 0) goto L_0x0197;
    L_0x0190:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0197:
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r11.onViewCreated(r0, r1);
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r10.m11313a(r11, r0, r1, r3);
    L_0x01a5:
        if (r12 <= r5) goto L_0x02a6;
    L_0x01a7:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x01c3;
    L_0x01ab:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x01c3:
        r0 = r11.mFromLayout;
        if (r0 != 0) goto L_0x0291;
    L_0x01c7:
        r0 = r11.mContainerId;
        if (r0 == 0) goto L_0x048e;
    L_0x01cb:
        r0 = r11.mContainerId;
        r1 = -1;
        if (r0 != r1) goto L_0x01f1;
    L_0x01d0:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " for a container view with no id";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r10.m11289a(r0);
    L_0x01f1:
        r0 = r10.Jo;
        r1 = r11.mContainerId;
        r0 = r0.onFindViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0240;
    L_0x01fd:
        r1 = r11.mRestored;
        if (r1 != 0) goto L_0x0240;
    L_0x0201:
        r1 = r11.getResources();	 Catch:{ NotFoundException -> 0x0317 }
        r2 = r11.mContainerId;	 Catch:{ NotFoundException -> 0x0317 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x0317 }
    L_0x020b:
        r2 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = "No view found for id 0x";
        r4 = r4.append(r8);
        r8 = r11.mContainerId;
        r8 = java.lang.Integer.toHexString(r8);
        r4 = r4.append(r8);
        r8 = " (";
        r4 = r4.append(r8);
        r1 = r4.append(r1);
        r4 = ") for fragment ";
        r1 = r1.append(r4);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r2.<init>(r1);
        r10.m11289a(r2);
    L_0x0240:
        r11.mContainer = r0;
        r1 = r11.mSavedFragmentState;
        r1 = r11.performGetLayoutInflater(r1);
        r2 = r11.mSavedFragmentState;
        r1 = r11.performCreateView(r1, r0, r2);
        r11.mView = r1;
        r1 = r11.mView;
        if (r1 == 0) goto L_0x0329;
    L_0x0254:
        r1 = r11.mView;
        r11.mInnerView = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x031c;
    L_0x025e:
        r1 = r11.mView;
        com.fossil.li.m12256c(r1, r3);
    L_0x0263:
        if (r0 == 0) goto L_0x026a;
    L_0x0265:
        r1 = r11.mView;
        r0.addView(r1);
    L_0x026a:
        r0 = r11.mHidden;
        if (r0 == 0) goto L_0x0275;
    L_0x026e:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0275:
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r11.onViewCreated(r0, r1);
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r10.m11313a(r11, r0, r1, r3);
        r0 = r11.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0326;
    L_0x028b:
        r0 = r11.mContainer;
        if (r0 == 0) goto L_0x0326;
    L_0x028f:
        r11.mIsNewlyAdded = r5;
    L_0x0291:
        r0 = r11.mSavedFragmentState;
        r11.performActivityCreated(r0);
        r0 = r11.mSavedFragmentState;
        r10.m11323b(r11, r0, r3);
        r0 = r11.mView;
        if (r0 == 0) goto L_0x02a4;
    L_0x029f:
        r0 = r11.mSavedFragmentState;
        r11.restoreViewState(r0);
    L_0x02a4:
        r11.mSavedFragmentState = r7;
    L_0x02a6:
        r0 = 2;
        if (r12 <= r0) goto L_0x02ab;
    L_0x02a9:
        r11.mState = r6;
    L_0x02ab:
        if (r12 <= r6) goto L_0x02cf;
    L_0x02ad:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02c9;
    L_0x02b1:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02c9:
        r11.performStart();
        r10.m11324b(r11, r3);
    L_0x02cf:
        if (r12 <= r9) goto L_0x0056;
    L_0x02d1:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02ed;
    L_0x02d5:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02ed:
        r11.performResume();
        r10.m11328c(r11, r3);
        r11.mSavedFragmentState = r7;
        r11.mSavedViewState = r7;
        goto L_0x0056;
    L_0x02f9:
        r0 = r11.mParentFragment;
        r0.onAttachFragment(r11);
        goto L_0x014e;
    L_0x0300:
        r0 = r11.mSavedFragmentState;
        r11.restoreChildFragmentState(r0);
        r11.mState = r5;
        goto L_0x0165;
    L_0x0309:
        r0 = r11.mView;
        r0 = com.fossil.fn.m11445H(r0);
        r11.mView = r0;
        goto L_0x018c;
    L_0x0313:
        r11.mInnerView = r7;
        goto L_0x01a5;
    L_0x0317:
        r1 = move-exception;
        r1 = "unknown";
        goto L_0x020b;
    L_0x031c:
        r1 = r11.mView;
        r1 = com.fossil.fn.m11445H(r1);
        r11.mView = r1;
        goto L_0x0263;
    L_0x0326:
        r5 = r3;
        goto L_0x028f;
    L_0x0329:
        r11.mInnerView = r7;
        goto L_0x0291;
    L_0x032d:
        r0 = r11.mState;
        if (r0 <= r12) goto L_0x0056;
    L_0x0331:
        r0 = r11.mState;
        switch(r0) {
            case 1: goto L_0x0338;
            case 2: goto L_0x03c4;
            case 3: goto L_0x03a3;
            case 4: goto L_0x037f;
            case 5: goto L_0x035a;
            default: goto L_0x0336;
        };
    L_0x0336:
        goto L_0x0056;
    L_0x0338:
        if (r12 >= r5) goto L_0x0056;
    L_0x033a:
        r0 = r10.mDestroyed;
        if (r0 == 0) goto L_0x034e;
    L_0x033e:
        r0 = r11.getAnimatingAway();
        if (r0 == 0) goto L_0x034e;
    L_0x0344:
        r0 = r11.getAnimatingAway();
        r11.setAnimatingAway(r7);
        r0.clearAnimation();
    L_0x034e:
        r0 = r11.getAnimatingAway();
        if (r0 == 0) goto L_0x044a;
    L_0x0354:
        r11.setStateAfterAnimating(r12);
        r12 = r5;
        goto L_0x0056;
    L_0x035a:
        r0 = 5;
        if (r12 >= r0) goto L_0x037f;
    L_0x035d:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0379;
    L_0x0361:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0379:
        r11.performPause();
        r10.m11329d(r11, r3);
    L_0x037f:
        if (r12 >= r9) goto L_0x03a3;
    L_0x0381:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x039d;
    L_0x0385:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x039d:
        r11.performStop();
        r10.m11330e(r11, r3);
    L_0x03a3:
        if (r12 >= r6) goto L_0x03c4;
    L_0x03a5:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x03c1;
    L_0x03a9:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03c1:
        r11.performReallyStop();
    L_0x03c4:
        r0 = 2;
        if (r12 >= r0) goto L_0x0338;
    L_0x03c7:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x03e3;
    L_0x03cb:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03e3:
        r0 = r11.mView;
        if (r0 == 0) goto L_0x03f6;
    L_0x03e7:
        r0 = r10.mHost;
        r0 = r0.mo3075d(r11);
        if (r0 == 0) goto L_0x03f6;
    L_0x03ef:
        r0 = r11.mSavedViewState;
        if (r0 != 0) goto L_0x03f6;
    L_0x03f3:
        r10.m11346r(r11);
    L_0x03f6:
        r11.performDestroyView();
        r10.m11332f(r11, r3);
        r0 = r11.mView;
        if (r0 == 0) goto L_0x0442;
    L_0x0400:
        r0 = r11.mContainer;
        if (r0 == 0) goto L_0x0442;
    L_0x0404:
        r0 = r10.Jn;
        if (r0 <= 0) goto L_0x048c;
    L_0x0408:
        r0 = r10.mDestroyed;
        if (r0 != 0) goto L_0x048c;
    L_0x040c:
        r0 = r11.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x048c;
    L_0x0414:
        r0 = r11.mPostponedAlpha;
        r1 = 0;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x048c;
    L_0x041b:
        r0 = r10.m11306a(r11, r13, r3, r14);
    L_0x041f:
        r1 = 0;
        r11.mPostponedAlpha = r1;
        if (r0 == 0) goto L_0x043b;
    L_0x0424:
        r1 = r11.mView;
        r11.setAnimatingAway(r1);
        r11.setStateAfterAnimating(r12);
        r1 = r11.mView;
        r2 = new com.fossil.fb$2;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.mView;
        r1.startAnimation(r0);
    L_0x043b:
        r0 = r11.mContainer;
        r1 = r11.mView;
        r0.removeView(r1);
    L_0x0442:
        r11.mContainer = r7;
        r11.mView = r7;
        r11.mInnerView = r7;
        goto L_0x0338;
    L_0x044a:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0466;
    L_0x044e:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0466:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x0481;
    L_0x046a:
        r11.performDestroy();
        r10.m11334g(r11, r3);
    L_0x0470:
        r11.performDetach();
        r10.m11336h(r11, r3);
        if (r15 != 0) goto L_0x0056;
    L_0x0478:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x0484;
    L_0x047c:
        r10.m11340k(r11);
        goto L_0x0056;
    L_0x0481:
        r11.mState = r3;
        goto L_0x0470;
    L_0x0484:
        r11.mHost = r7;
        r11.mParentFragment = r7;
        r11.mFragmentManager = r7;
        goto L_0x0056;
    L_0x048c:
        r0 = r7;
        goto L_0x041f;
    L_0x048e:
        r0 = r7;
        goto L_0x0240;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.fb.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    void m11333g(Fragment fragment) {
        m11310a(fragment, this.Jn, 0, 0, false);
    }

    void m11335h(Fragment fragment) {
        if (fragment.mView != null) {
            int i;
            Animation a = m11306a(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (a != null) {
                m11294b(fragment.mView, a);
                fragment.mView.startAnimation(a);
                m11294b(fragment.mView, a);
                a.start();
            }
            if (!fragment.mHidden || fragment.isHideReplaced()) {
                i = 0;
            } else {
                i = 8;
            }
            fragment.mView.setVisibility(i);
            if (fragment.isHideReplaced()) {
                fragment.setHideReplaced(false);
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.Jr = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    void m11337i(Fragment fragment) {
        if (fragment != null) {
            int i = this.Jn;
            if (fragment.mRemoving) {
                if (fragment.isInBackStack()) {
                    i = Math.min(i, 1);
                } else {
                    i = Math.min(i, 0);
                }
            }
            m11310a(fragment, i, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
            if (fragment.mView != null) {
                Fragment q = m11302q(fragment);
                if (q != null) {
                    View view = q.mView;
                    ViewGroup viewGroup = fragment.mContainer;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    i = viewGroup.indexOfChild(fragment.mView);
                    if (i < indexOfChild) {
                        viewGroup.removeViewAt(i);
                        viewGroup.addView(fragment.mView, indexOfChild);
                    }
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    if (VERSION.SDK_INT < 11) {
                        fragment.mView.setVisibility(0);
                    } else if (fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    Animation a = m11306a(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                    if (a != null) {
                        m11294b(fragment.mView, a);
                        fragment.mView.startAnimation(a);
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                m11335h(fragment);
            }
        }
    }

    void m11321b(int i, boolean z) {
        if (this.mHost == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.Jn) {
            this.Jn = i;
            if (this.Jg != null) {
                int size;
                int i2;
                int i3;
                Fragment fragment;
                int iq;
                if (this.Jf != null) {
                    size = this.Jf.size();
                    i2 = 0;
                    i3 = 0;
                    while (i2 < size) {
                        fragment = (Fragment) this.Jf.get(i2);
                        m11337i(fragment);
                        if (fragment.mLoaderManager != null) {
                            iq = fragment.mLoaderManager.iq() | i3;
                        } else {
                            iq = i3;
                        }
                        i2++;
                        i3 = iq;
                    }
                } else {
                    i3 = 0;
                }
                size = this.Jg.size();
                i2 = 0;
                while (i2 < size) {
                    fragment = (Fragment) this.Jg.valueAt(i2);
                    if (fragment != null && ((fragment.mRemoving || fragment.mDetached) && !fragment.mIsNewlyAdded)) {
                        m11337i(fragment);
                        if (fragment.mLoaderManager != null) {
                            iq = fragment.mLoaderManager.iq() | i3;
                            i2++;
                            i3 = iq;
                        }
                    }
                    iq = i3;
                    i2++;
                    i3 = iq;
                }
                if (i3 == 0) {
                    hX();
                }
                if (this.Jr && this.mHost != null && this.Jn == 5) {
                    this.mHost.hP();
                    this.Jr = false;
                }
            }
        }
    }

    void hX() {
        if (this.Jg != null) {
            for (int i = 0; i < this.Jg.size(); i++) {
                Fragment fragment = (Fragment) this.Jg.valueAt(i);
                if (fragment != null) {
                    m11331f(fragment);
                }
            }
        }
    }

    void m11339j(Fragment fragment) {
        if (fragment.mIndex < 0) {
            int i = this.Je;
            this.Je = i + 1;
            fragment.setIndex(i, this.Jp);
            if (this.Jg == null) {
                this.Jg = new SparseArray();
            }
            this.Jg.put(fragment.mIndex, fragment);
            if (DEBUG) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void m11340k(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (DEBUG) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.Jg.put(fragment.mIndex, null);
            this.mHost.m11260V(fragment.mWho);
            fragment.initState();
        }
    }

    public void m11314a(Fragment fragment, boolean z) {
        if (this.Jf == null) {
            this.Jf = new ArrayList();
        }
        if (DEBUG) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m11339j(fragment);
        if (!fragment.mDetached) {
            if (this.Jf.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            synchronized (this.Jf) {
                this.Jf.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.Jr = true;
            }
            if (z) {
                m11333g(fragment);
            }
        }
    }

    public void m11341l(Fragment fragment) {
        if (DEBUG) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            if (this.Jf != null) {
                synchronized (this.Jf) {
                    this.Jf.remove(fragment);
                }
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.Jr = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    public void m11342m(Fragment fragment) {
        boolean z = true;
        if (DEBUG) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mHiddenChanged) {
                z = false;
            }
            fragment.mHiddenChanged = z;
        }
    }

    public void m11343n(Fragment fragment) {
        boolean z = false;
        if (DEBUG) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (!fragment.mHiddenChanged) {
                z = true;
            }
            fragment.mHiddenChanged = z;
        }
    }

    public void m11344o(Fragment fragment) {
        if (DEBUG) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (this.Jf != null) {
                    if (DEBUG) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    synchronized (this.Jf) {
                        this.Jf.remove(fragment);
                    }
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.Jr = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    public void m11345p(Fragment fragment) {
        if (DEBUG) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.Jf == null) {
                    this.Jf = new ArrayList();
                }
                if (this.Jf.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (DEBUG) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                synchronized (this.Jf) {
                    this.Jf.add(fragment);
                }
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.Jr = true;
                }
            }
        }
    }

    public Fragment aF(int i) {
        int size;
        Fragment fragment;
        if (this.Jf != null) {
            for (size = this.Jf.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.Jf.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        if (this.Jg != null) {
            for (size = this.Jg.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.Jg.valueAt(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment mo3086W(String str) {
        int size;
        Fragment fragment;
        if (!(this.Jf == null || str == null)) {
            for (size = this.Jf.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.Jf.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (!(this.Jg == null || str == null)) {
            for (size = this.Jg.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.Jg.valueAt(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByWho(String str) {
        if (!(this.Jg == null || str == null)) {
            for (int size = this.Jg.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.Jg.valueAt(size);
                if (fragment != null) {
                    fragment = fragment.findFragmentByWho(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void hY() {
        if (this.Js) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.Jt != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.Jt);
        }
    }

    public void m11318a(C3468c c3468c, boolean z) {
        if (!z) {
            hY();
        }
        synchronized (this) {
            if (!this.mDestroyed && this.mHost != null) {
                if (this.Jc == null) {
                    this.Jc = new ArrayList();
                }
                this.Jc.add(c3468c);
                hZ();
            } else if (z) {
            } else {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    private void hZ() {
        Object obj = 1;
        synchronized (this) {
            Object obj2 = (this.JA == null || this.JA.isEmpty()) ? null : 1;
            if (this.Jc == null || this.Jc.size() != 1) {
                obj = null;
            }
            if (!(obj2 == null && r0 == null)) {
                this.mHost.getHandler().removeCallbacks(this.JB);
                this.mHost.getHandler().post(this.JB);
            }
        }
    }

    public int m11305a(en enVar) {
        int size;
        synchronized (this) {
            if (this.Jk == null || this.Jk.size() <= 0) {
                if (this.Jj == null) {
                    this.Jj = new ArrayList();
                }
                size = this.Jj.size();
                if (DEBUG) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + enVar);
                }
                this.Jj.add(enVar);
            } else {
                size = ((Integer) this.Jk.remove(this.Jk.size() - 1)).intValue();
                if (DEBUG) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + enVar);
                }
                this.Jj.set(size, enVar);
            }
        }
        return size;
    }

    public void m11307a(int i, en enVar) {
        synchronized (this) {
            if (this.Jj == null) {
                this.Jj = new ArrayList();
            }
            int size = this.Jj.size();
            if (i < size) {
                if (DEBUG) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + enVar);
                }
                this.Jj.set(i, enVar);
            } else {
                while (size < i) {
                    this.Jj.add(null);
                    if (this.Jk == null) {
                        this.Jk = new ArrayList();
                    }
                    if (DEBUG) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.Jk.add(Integer.valueOf(size));
                    size++;
                }
                if (DEBUG) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + enVar);
                }
                this.Jj.add(enVar);
            }
        }
    }

    public void aH(int i) {
        synchronized (this) {
            this.Jj.set(i, null);
            if (this.Jk == null) {
                this.Jk = new ArrayList();
            }
            if (DEBUG) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.Jk.add(Integer.valueOf(i));
        }
    }

    private void m11303y(boolean z) {
        if (this.Jd) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() != this.mHost.getHandler().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                hY();
            }
            if (this.Jv == null) {
                this.Jv = new ArrayList();
                this.Jw = new ArrayList();
            }
            this.Jd = true;
            try {
                m11297b(null, null);
            } finally {
                this.Jd = false;
            }
        }
    }

    public void m11326b(C3468c c3468c, boolean z) {
        if (!z || (this.mHost != null && !this.mDestroyed)) {
            m11303y(z);
            if (c3468c.mo2969a(this.Jv, this.Jw)) {
                this.Jd = true;
                try {
                    m11300c(this.Jv, this.Jw);
                } finally {
                    ia();
                }
            }
            ie();
            ih();
        }
    }

    private void ia() {
        this.Jd = false;
        this.Jw.clear();
        this.Jv.clear();
    }

    private void m11297b(ArrayList<en> arrayList, ArrayList<Boolean> arrayList2) {
        int i = 0;
        int size = this.JA == null ? 0 : this.JA.size();
        while (i < size) {
            int indexOf;
            int i2;
            C3562e c3562e = (C3562e) this.JA.get(i);
            if (!(arrayList == null || c3562e.JN)) {
                indexOf = arrayList.indexOf(c3562e.JO);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    c3562e.il();
                    i2 = i;
                    indexOf = size;
                    i = i2 + 1;
                    size = indexOf;
                }
            }
            if (c3562e.ij() || (arrayList != null && c3562e.JO.m10945a((ArrayList) arrayList, 0, arrayList.size()))) {
                this.JA.remove(i);
                i--;
                size--;
                if (!(arrayList == null || c3562e.JN)) {
                    indexOf = arrayList.indexOf(c3562e.JO);
                    if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                        c3562e.il();
                        i2 = i;
                        indexOf = size;
                        i = i2 + 1;
                        size = indexOf;
                    }
                }
                c3562e.ik();
            }
            i2 = i;
            indexOf = size;
            i = i2 + 1;
            size = indexOf;
        }
    }

    private void m11300c(ArrayList<en> arrayList, ArrayList<Boolean> arrayList2) {
        int i = 0;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            m11297b((ArrayList) arrayList, (ArrayList) arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            while (i < size) {
                int i3;
                if (((en) arrayList.get(i)).Im) {
                    i3 = i;
                } else {
                    if (i2 != i) {
                        m11290a((ArrayList) arrayList, (ArrayList) arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (((Boolean) arrayList2.get(i)).booleanValue()) {
                        while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((en) arrayList.get(i2)).Im) {
                            i2++;
                        }
                    }
                    i3 = i2;
                    m11290a((ArrayList) arrayList, (ArrayList) arrayList2, i, i3);
                    i2 = i3;
                    i3--;
                }
                i = i3 + 1;
            }
            if (i2 != size) {
                m11290a((ArrayList) arrayList, (ArrayList) arrayList2, i2, size);
            }
        }
    }

    private void m11290a(ArrayList<en> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int a;
        boolean z = ((en) arrayList.get(i)).Im;
        if (this.Jx == null) {
            this.Jx = new ArrayList();
        } else {
            this.Jx.clear();
        }
        if (this.Jf != null) {
            this.Jx.addAll(this.Jf);
        }
        int i3 = i;
        boolean z2 = false;
        while (i3 < i2) {
            boolean z3;
            en enVar = (en) arrayList.get(i3);
            if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                enVar.m10951c(this.Jx);
            } else {
                enVar.m10949b(this.Jx);
            }
            if (z2 || enVar.Id) {
                z3 = true;
            } else {
                z3 = false;
            }
            i3++;
            z2 = z3;
        }
        this.Jx.clear();
        if (!z) {
            fh.m11365a(this, arrayList, arrayList2, i, i2, false);
        }
        m11298b(arrayList, arrayList2, i, i2);
        if (z) {
            jm jmVar = new jm();
            m11296b(jmVar);
            a = m11283a((ArrayList) arrayList, (ArrayList) arrayList2, i, i2, jmVar);
            m11288a(jmVar);
        } else {
            a = i2;
        }
        if (a != i && z) {
            fh.m11365a(this, arrayList, arrayList2, i, a, true);
            m11321b(this.Jn, true);
        }
        while (i < i2) {
            enVar = (en) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue() && enVar.mIndex >= 0) {
                aH(enVar.mIndex);
                enVar.mIndex = -1;
            }
            i++;
        }
        if (z2) {
            m11338if();
        }
    }

    private void m11288a(jm<Fragment> jmVar) {
        int size = jmVar.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) jmVar.valueAt(i);
            if (!fragment.mAdded) {
                View view = fragment.getView();
                if (VERSION.SDK_INT < 11) {
                    fragment.getView().setVisibility(4);
                } else {
                    fragment.mPostponedAlpha = view.getAlpha();
                    view.setAlpha(0.0f);
                }
            }
        }
    }

    private int m11283a(ArrayList<en> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, jm<Fragment> jmVar) {
        int i3 = i2 - 1;
        int i4 = i2;
        while (i3 >= i) {
            boolean z;
            int i5;
            en enVar = (en) arrayList.get(i3);
            boolean booleanValue = ((Boolean) arrayList2.get(i3)).booleanValue();
            if (!enVar.isPostponed() || enVar.m10945a((ArrayList) arrayList, i3 + 1, i2)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.JA == null) {
                    this.JA = new ArrayList();
                }
                C1136b c3562e = new C3562e(enVar, booleanValue);
                this.JA.add(c3562e);
                enVar.m10942a(c3562e);
                if (booleanValue) {
                    enVar.hM();
                } else {
                    enVar.m10953x(false);
                }
                int i6 = i4 - 1;
                if (i3 != i6) {
                    arrayList.remove(i3);
                    arrayList.add(i6, enVar);
                }
                m11296b((jm) jmVar);
                i5 = i6;
            } else {
                i5 = i4;
            }
            i3--;
            i4 = i5;
        }
        return i4;
    }

    private void m11286a(en enVar, boolean z, boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(enVar);
        arrayList2.add(Boolean.valueOf(z));
        m11298b(arrayList, arrayList2, 0, 1);
        if (z2) {
            fh.m11365a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            m11321b(this.Jn, true);
        }
        if (this.Jg != null) {
            int size = this.Jg.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) this.Jg.valueAt(i);
                if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && enVar.aC(fragment.mContainerId)) {
                    if (VERSION.SDK_INT >= 11 && fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    if (z3) {
                        fragment.mPostponedAlpha = 0.0f;
                    } else {
                        fragment.mPostponedAlpha = -1.0f;
                        fragment.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    private Fragment m11302q(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int indexOf = this.Jf.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
            Fragment fragment2 = (Fragment) this.Jf.get(indexOf);
            if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                return fragment2;
            }
        }
        return null;
    }

    private static void m11298b(ArrayList<en> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            en enVar = (en) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                enVar.aB(-1);
                enVar.m10953x(i == i2 + -1);
            } else {
                enVar.aB(1);
                enVar.hM();
            }
            i++;
        }
    }

    private void m11296b(jm<Fragment> jmVar) {
        if (this.Jn >= 1) {
            int min = Math.min(this.Jn, 4);
            boolean size = this.Jf == null ? false : this.Jf.size();
            for (boolean z = false; z < size; z++) {
                Fragment fragment = (Fragment) this.Jf.get(z);
                if (fragment.mState < min) {
                    m11310a(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (!(fragment.mView == null || fragment.mHidden || !fragment.mIsNewlyAdded)) {
                        jmVar.add(fragment);
                    }
                }
            }
        }
    }

    private void ib() {
        if (this.JA != null) {
            while (!this.JA.isEmpty()) {
                ((C3562e) this.JA.remove(0)).ik();
            }
        }
    }

    private void ic() {
        int i;
        if (this.Jg == null) {
            i = 0;
        } else {
            i = this.Jg.size();
        }
        for (int i2 = 0; i2 < i; i2++) {
            Fragment fragment = (Fragment) this.Jg.valueAt(i2);
            if (!(fragment == null || fragment.getAnimatingAway() == null)) {
                int stateAfterAnimating = fragment.getStateAfterAnimating();
                View animatingAway = fragment.getAnimatingAway();
                fragment.setAnimatingAway(null);
                Animation animation = animatingAway.getAnimation();
                if (animation != null) {
                    animation.cancel();
                    animatingAway.clearAnimation();
                }
                m11310a(fragment, stateAfterAnimating, 0, 0, false);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m11301d(java.util.ArrayList<com.fossil.en> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
        r4 = this;
        r1 = 0;
        monitor-enter(r4);
        r0 = r4.Jc;	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = r4.Jc;	 Catch:{ all -> 0x003e }
        r0 = r0.size();	 Catch:{ all -> 0x003e }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        r0 = r1;
    L_0x0010:
        return r0;
    L_0x0011:
        r0 = r4.Jc;	 Catch:{ all -> 0x003e }
        r3 = r0.size();	 Catch:{ all -> 0x003e }
        r2 = r1;
    L_0x0018:
        if (r2 >= r3) goto L_0x0029;
    L_0x001a:
        r0 = r4.Jc;	 Catch:{ all -> 0x003e }
        r0 = r0.get(r2);	 Catch:{ all -> 0x003e }
        r0 = (com.fossil.fb.C3468c) r0;	 Catch:{ all -> 0x003e }
        r0.mo2969a(r5, r6);	 Catch:{ all -> 0x003e }
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0018;
    L_0x0029:
        r0 = r4.Jc;	 Catch:{ all -> 0x003e }
        r0.clear();	 Catch:{ all -> 0x003e }
        r0 = r4.mHost;	 Catch:{ all -> 0x003e }
        r0 = r0.getHandler();	 Catch:{ all -> 0x003e }
        r2 = r4.JB;	 Catch:{ all -> 0x003e }
        r0.removeCallbacks(r2);	 Catch:{ all -> 0x003e }
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        if (r3 <= 0) goto L_0x0041;
    L_0x003c:
        r0 = 1;
        goto L_0x0010;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        throw r0;
    L_0x0041:
        r0 = r1;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.fb.d(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    void ie() {
        if (this.Ju) {
            int i = 0;
            for (int i2 = 0; i2 < this.Jg.size(); i2++) {
                Fragment fragment = (Fragment) this.Jg.valueAt(i2);
                if (!(fragment == null || fragment.mLoaderManager == null)) {
                    i |= fragment.mLoaderManager.iq();
                }
            }
            if (i == 0) {
                this.Ju = false;
                hX();
            }
        }
    }

    void m11338if() {
        if (this.Jl != null) {
            for (int i = 0; i < this.Jl.size(); i++) {
                ((C3555b) this.Jl.get(i)).onBackStackChanged();
            }
        }
    }

    void m11325b(en enVar) {
        if (this.Jh == null) {
            this.Jh = new ArrayList();
        }
        this.Jh.add(enVar);
    }

    boolean m11319a(ArrayList<en> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.Jh == null) {
            return false;
        }
        int size;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.Jh.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.Jh.remove(size));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                en enVar;
                size2 = this.Jh.size() - 1;
                while (size2 >= 0) {
                    enVar = (en) this.Jh.get(size2);
                    if ((str != null && str.equals(enVar.getName())) || (i >= 0 && i == enVar.mIndex)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        enVar = (en) this.Jh.get(size2);
                        if ((str == null || !str.equals(enVar.getName())) && (i < 0 || i != enVar.mIndex)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.Jh.size() - 1) {
                return false;
            }
            for (size2 = this.Jh.size() - 1; size2 > size; size2--) {
                arrayList.add(this.Jh.remove(size2));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    fc ig() {
        List list;
        List list2;
        if (this.Jg != null) {
            int i = 0;
            list = null;
            list2 = null;
            while (i < this.Jg.size()) {
                ArrayList arrayList;
                Fragment fragment = (Fragment) this.Jg.valueAt(i);
                if (fragment != null) {
                    boolean z;
                    if (fragment.mRetainInstance) {
                        if (list2 == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(fragment);
                        fragment.mRetaining = true;
                        fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                        if (DEBUG) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                        }
                    }
                    if (fragment.mChildFragmentManager != null) {
                        fc ig = fragment.mChildFragmentManager.ig();
                        if (ig != null) {
                            ArrayList arrayList2;
                            if (list == null) {
                                arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < i; i2++) {
                                    arrayList2.add(null);
                                }
                            } else {
                                arrayList2 = list;
                            }
                            arrayList2.add(ig);
                            list = arrayList2;
                            z = true;
                            if (!(list == null || r0)) {
                                list.add(null);
                            }
                        }
                    }
                    z = false;
                    list.add(null);
                }
                i++;
                Object obj = arrayList;
            }
        } else {
            list = null;
            list2 = null;
        }
        if (list2 == null && list == null) {
            return null;
        }
        return new fc(list2, list);
    }

    void m11346r(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.Jz == null) {
                this.Jz = new SparseArray();
            } else {
                this.Jz.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.Jz);
            if (this.Jz.size() > 0) {
                fragment.mSavedViewState = this.Jz;
                this.Jz = null;
            }
        }
    }

    Bundle m11347s(Fragment fragment) {
        Bundle bundle;
        if (this.Jy == null) {
            this.Jy = new Bundle();
        }
        fragment.performSaveInstanceState(this.Jy);
        m11327c(fragment, this.Jy, false);
        if (this.Jy.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.Jy;
            this.Jy = null;
        }
        if (fragment.mView != null) {
            m11346r(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    public Parcelable saveAllState() {
        eo[] eoVarArr = null;
        ib();
        ic();
        execPendingActions();
        if (Jb) {
            this.Js = true;
        }
        if (this.Jg == null || this.Jg.size() <= 0) {
            return null;
        }
        int size = this.Jg.size();
        ff[] ffVarArr = new ff[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.Jg.valueAt(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    m11289a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                ff ffVar = new ff(fragment);
                ffVarArr[i] = ffVar;
                if (fragment.mState <= 0 || ffVar.mSavedFragmentState != null) {
                    ffVar.mSavedFragmentState = fragment.mSavedFragmentState;
                } else {
                    ffVar.mSavedFragmentState = m11347s(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            m11289a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget));
                        }
                        if (ffVar.mSavedFragmentState == null) {
                            ffVar.mSavedFragmentState = new Bundle();
                        }
                        m11308a(ffVar.mSavedFragmentState, "android:target_state", fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            ffVar.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode);
                        }
                    }
                }
                if (DEBUG) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + ffVar.mSavedFragmentState);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            fd fdVar;
            if (this.Jf != null) {
                i = this.Jf.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.Jf.get(i2)).mIndex;
                        if (iArr[i2] < 0) {
                            m11289a(new IllegalStateException("Failure saving state: active " + this.Jf.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (DEBUG) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.Jf.get(i2));
                        }
                    }
                    if (this.Jh != null) {
                        i = this.Jh.size();
                        if (i > 0) {
                            eoVarArr = new eo[i];
                            for (i2 = 0; i2 < i; i2++) {
                                eoVarArr[i2] = new eo((en) this.Jh.get(i2));
                                if (DEBUG) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.Jh.get(i2));
                                }
                            }
                        }
                    }
                    fdVar = new fd();
                    fdVar.JS = ffVarArr;
                    fdVar.JT = iArr;
                    fdVar.JU = eoVarArr;
                    fdVar.Je = this.Je;
                    return fdVar;
                }
            }
            iArr = null;
            if (this.Jh != null) {
                i = this.Jh.size();
                if (i > 0) {
                    eoVarArr = new eo[i];
                    for (i2 = 0; i2 < i; i2++) {
                        eoVarArr[i2] = new eo((en) this.Jh.get(i2));
                        if (DEBUG) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.Jh.get(i2));
                        }
                    }
                }
            }
            fdVar = new fd();
            fdVar.JS = ffVarArr;
            fdVar.JT = iArr;
            fdVar.JU = eoVarArr;
            fdVar.Je = this.Je;
            return fdVar;
        } else if (!DEBUG) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public void m11309a(Parcelable parcelable, fc fcVar) {
        if (parcelable != null) {
            fd fdVar = (fd) parcelable;
            if (fdVar.JS != null) {
                int size;
                Fragment fragment;
                int i;
                List list;
                if (fcVar != null) {
                    List im = fcVar.im();
                    List io = fcVar.io();
                    if (im != null) {
                        size = im.size();
                    } else {
                        boolean z = false;
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        fragment = (Fragment) im.get(i2);
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        i = 0;
                        while (i < fdVar.JS.length && fdVar.JS[i].mIndex != fragment.mIndex) {
                            i++;
                        }
                        if (i == fdVar.JS.length) {
                            m11289a(new IllegalStateException("Could not find active fragment with index " + fragment.mIndex));
                        }
                        ff ffVar = fdVar.JS[i];
                        ffVar.JZ = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (ffVar.mSavedFragmentState != null) {
                            ffVar.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                            fragment.mSavedViewState = ffVar.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                            fragment.mSavedFragmentState = ffVar.mSavedFragmentState;
                        }
                    }
                    list = io;
                } else {
                    list = null;
                }
                this.Jg = new SparseArray(fdVar.JS.length);
                i = 0;
                while (i < fdVar.JS.length) {
                    ff ffVar2 = fdVar.JS[i];
                    if (ffVar2 != null) {
                        fc fcVar2;
                        if (list == null || i >= list.size()) {
                            fcVar2 = null;
                        } else {
                            fcVar2 = (fc) list.get(i);
                        }
                        fragment = ffVar2.m11350a(this.mHost, this.Jp, fcVar2);
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + fragment);
                        }
                        this.Jg.put(fragment.mIndex, fragment);
                        ffVar2.JZ = null;
                    }
                    i++;
                }
                if (fcVar != null) {
                    List im2 = fcVar.im();
                    if (im2 != null) {
                        i = im2.size();
                    } else {
                        boolean z2 = false;
                    }
                    for (int i3 = 0; i3 < i; i3++) {
                        fragment = (Fragment) im2.get(i3);
                        if (fragment.mTargetIndex >= 0) {
                            fragment.mTarget = (Fragment) this.Jg.get(fragment.mTargetIndex);
                            if (fragment.mTarget == null) {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.mTargetIndex);
                            }
                        }
                    }
                }
                if (fdVar.JT != null) {
                    this.Jf = new ArrayList(fdVar.JT.length);
                    for (size = 0; size < fdVar.JT.length; size++) {
                        fragment = (Fragment) this.Jg.get(fdVar.JT[size]);
                        if (fragment == null) {
                            m11289a(new IllegalStateException("No instantiated fragment for index #" + fdVar.JT[size]));
                        }
                        fragment.mAdded = true;
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: added #" + size + ": " + fragment);
                        }
                        if (this.Jf.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.Jf) {
                            this.Jf.add(fragment);
                        }
                    }
                } else {
                    this.Jf = null;
                }
                if (fdVar.JU != null) {
                    this.Jh = new ArrayList(fdVar.JU.length);
                    for (int i4 = 0; i4 < fdVar.JU.length; i4++) {
                        en a = fdVar.JU[i4].m10983a(this);
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i4 + " (index " + a.mIndex + "): " + a);
                            PrintWriter printWriter = new PrintWriter(new jp("FragmentManager"));
                            a.m10944a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.Jh.add(a);
                        if (a.mIndex >= 0) {
                            m11307a(a.mIndex, a);
                        }
                    }
                } else {
                    this.Jh = null;
                }
                this.Je = fdVar.Je;
            }
        }
    }

    private void ih() {
        if (this.Jg != null) {
            for (int size = this.Jg.size() - 1; size >= 0; size--) {
                if (this.Jg.valueAt(size) == null) {
                    this.Jg.delete(this.Jg.keyAt(size));
                }
            }
        }
    }

    public void m11315a(ez ezVar, ex exVar, Fragment fragment) {
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = ezVar;
        this.Jo = exVar;
        this.Jp = fragment;
    }

    public void noteStateNotSaved() {
        this.Js = false;
        int size = this.Jf == null ? 0 : this.Jf.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) this.Jf.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public void dispatchCreate() {
        this.Js = false;
        this.Jd = true;
        m11321b(1, false);
        this.Jd = false;
    }

    public void dispatchActivityCreated() {
        this.Js = false;
        this.Jd = true;
        m11321b(2, false);
        this.Jd = false;
    }

    public void dispatchStart() {
        this.Js = false;
        this.Jd = true;
        m11321b(4, false);
        this.Jd = false;
    }

    public void dispatchResume() {
        this.Js = false;
        this.Jd = true;
        m11321b(5, false);
        this.Jd = false;
    }

    public void dispatchPause() {
        this.Jd = true;
        m11321b(4, false);
        this.Jd = false;
    }

    public void dispatchStop() {
        this.Js = true;
        this.Jd = true;
        m11321b(3, false);
        this.Jd = false;
    }

    public void hR() {
        this.Jd = true;
        m11321b(2, false);
        this.Jd = false;
    }

    public void dispatchDestroyView() {
        this.Jd = true;
        m11321b(1, false);
        this.Jd = false;
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        this.Jd = true;
        m11321b(0, false);
        this.Jd = false;
        this.mHost = null;
        this.Jo = null;
        this.Jp = null;
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        if (this.Jf != null) {
            for (int size = this.Jf.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.Jf.get(size);
                if (fragment != null) {
                    fragment.performMultiWindowModeChanged(z);
                }
            }
        }
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        if (this.Jf != null) {
            for (int size = this.Jf.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.Jf.get(size);
                if (fragment != null) {
                    fragment.performPictureInPictureModeChanged(z);
                }
            }
        }
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        if (this.Jf != null) {
            for (int i = 0; i < this.Jf.size(); i++) {
                Fragment fragment = (Fragment) this.Jf.get(i);
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration);
                }
            }
        }
    }

    public void dispatchLowMemory() {
        if (this.Jf != null) {
            for (int i = 0; i < this.Jf.size(); i++) {
                Fragment fragment = (Fragment) this.Jf.get(i);
                if (fragment != null) {
                    fragment.performLowMemory();
                }
            }
        }
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.Jf != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.Jf.size()) {
                fragment = (Fragment) this.Jf.get(i2);
                if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.Ji != null) {
            while (i < this.Ji.size()) {
                fragment = (Fragment) this.Ji.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.Ji = arrayList;
        return z;
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        if (this.Jf == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.Jf.size(); i++) {
            Fragment fragment = (Fragment) this.Jf.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.Jf == null) {
            return false;
        }
        for (int i = 0; i < this.Jf.size(); i++) {
            Fragment fragment = (Fragment) this.Jf.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.Jf == null) {
            return false;
        }
        for (int i = 0; i < this.Jf.size(); i++) {
            Fragment fragment = (Fragment) this.Jf.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        if (this.Jf != null) {
            for (int i = 0; i < this.Jf.size(); i++) {
                Fragment fragment = (Fragment) this.Jf.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public void mo3088a(C3106a c3106a, boolean z) {
        if (this.Jm == null) {
            this.Jm = new CopyOnWriteArrayList();
        }
        this.Jm.add(new jt(c3106a, Boolean.valueOf(z)));
    }

    public void mo3087a(C3106a c3106a) {
        if (this.Jm != null) {
            synchronized (this.Jm) {
                int size = this.Jm.size();
                for (int i = 0; i < size; i++) {
                    if (((jt) this.Jm.get(i)).first == c3106a) {
                        this.Jm.remove(i);
                        break;
                    }
                }
            }
        }
    }

    void m11311a(Fragment fragment, Context context, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11311a(fragment, context, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).m9378a((fa) this, fragment, context);
                }
            }
        }
    }

    void m11322b(Fragment fragment, Context context, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11322b(fragment, context, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).m9382b((fa) this, fragment, context);
                }
            }
        }
    }

    void m11312a(Fragment fragment, Bundle bundle, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11312a(fragment, bundle, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).m9379a((fa) this, fragment, bundle);
                }
            }
        }
    }

    void m11323b(Fragment fragment, Bundle bundle, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11323b(fragment, bundle, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).m9383b((fa) this, fragment, bundle);
                }
            }
        }
    }

    void m11313a(Fragment fragment, View view, Bundle bundle, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11313a(fragment, view, bundle, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).m9380a(this, fragment, view, bundle);
                }
            }
        }
    }

    void m11324b(Fragment fragment, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11324b(fragment, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).m9377a(this, fragment);
                }
            }
        }
    }

    void m11328c(Fragment fragment, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11328c(fragment, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).m9381b(this, fragment);
                }
            }
        }
    }

    void m11329d(Fragment fragment, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11329d(fragment, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).m9384c(this, fragment);
                }
            }
        }
    }

    void m11330e(Fragment fragment, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11330e(fragment, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).m9386d(this, fragment);
                }
            }
        }
    }

    void m11327c(Fragment fragment, Bundle bundle, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11327c(fragment, bundle, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).m9385c(this, fragment, bundle);
                }
            }
        }
    }

    void m11332f(Fragment fragment, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11332f(fragment, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).mo2664e(this, fragment);
                }
            }
        }
    }

    void m11334g(Fragment fragment, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11334g(fragment, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).m9388f(this, fragment);
                }
            }
        }
    }

    void m11336h(Fragment fragment, boolean z) {
        if (this.Jp != null) {
            fa fragmentManager = this.Jp.getFragmentManager();
            if (fragmentManager instanceof fb) {
                ((fb) fragmentManager).m11336h(fragment, true);
            }
        }
        if (this.Jm != null) {
            Iterator it = this.Jm.iterator();
            while (it.hasNext()) {
                jt jtVar = (jt) it.next();
                if (!z || ((Boolean) jtVar.second).booleanValue()) {
                    ((C3106a) jtVar.first).m9389g(this, fragment);
                }
            }
        }
    }

    public static int aI(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int m11299c(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3560b.JL);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.mHost.getContext(), string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment aF = resourceId != -1 ? aF(resourceId) : null;
        if (aF == null && string2 != null) {
            aF = mo3086W(string2);
        }
        if (aF == null && id != -1) {
            aF = aF(id);
        }
        if (DEBUG) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + aF);
        }
        if (aF == null) {
            Fragment instantiate = Fragment.instantiate(context, string);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            instantiate.mContainerId = id;
            instantiate.mTag = string2;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this;
            instantiate.mHost = this.mHost;
            instantiate.onInflate(this.mHost.getContext(), attributeSet, instantiate.mSavedFragmentState);
            m11314a(instantiate, true);
            fragment = instantiate;
        } else if (aF.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            aF.mInLayout = true;
            aF.mHost = this.mHost;
            if (!aF.mRetaining) {
                aF.onInflate(this.mHost.getContext(), attributeSet, aF.mSavedFragmentState);
            }
            fragment = aF;
        }
        if (this.Jn >= 1 || !fragment.mFromLayout) {
            m11333g(fragment);
        } else {
            m11310a(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string2);
        }
        return fragment.mView;
    }

    public km ii() {
        return this;
    }
}
