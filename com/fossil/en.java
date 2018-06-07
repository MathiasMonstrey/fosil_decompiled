package com.fossil;

import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.C1136b;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.fb.C3468c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class en extends fg implements C3468c {
    static final boolean HU = (VERSION.SDK_INT >= 21);
    final fb HV;
    ArrayList<C3467a> HW = new ArrayList();
    int HX;
    int HY;
    int HZ;
    int Ia;
    int Ib;
    int Ic;
    boolean Id;
    boolean Ie = true;
    boolean If;
    int Ig;
    CharSequence Ih;
    int Ii;
    CharSequence Ij;
    ArrayList<String> Ik;
    ArrayList<String> Il;
    boolean Im = false;
    int mIndex = -1;
    String mName;

    static final class C3467a {
        int In;
        int Io;
        int Ip;
        int Iq;
        int Ir;
        Fragment fragment;

        C3467a() {
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(Allocation.USAGE_SHARED);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mName != null) {
            stringBuilder.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            stringBuilder.append(this.mName);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m10944a(str, printWriter, true);
    }

    public void m10944a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.If);
            if (this.Ib != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.Ib));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.Ic));
            }
            if (!(this.HX == 0 && this.HY == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.HX));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.HY));
            }
            if (!(this.HZ == 0 && this.Ia == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.HZ));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.Ia));
            }
            if (!(this.Ig == 0 && this.Ih == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.Ig));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.Ih);
            }
            if (!(this.Ii == 0 && this.Ij == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.Ii));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.Ij);
            }
        }
        if (!this.HW.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            str + "    ";
            int size = this.HW.size();
            for (int i = 0; i < size; i++) {
                String str2;
                C3467a c3467a = (C3467a) this.HW.get(i);
                switch (c3467a.In) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    default:
                        str2 = "cmd=" + c3467a.In;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                printWriter.println(c3467a.fragment);
                if (z) {
                    if (!(c3467a.Io == 0 && c3467a.Ip == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c3467a.Io));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c3467a.Ip));
                    }
                    if (c3467a.Iq != 0 || c3467a.Ir != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c3467a.Iq));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c3467a.Ir));
                    }
                }
            }
        }
    }

    public en(fb fbVar) {
        this.HV = fbVar;
    }

    void m10943a(C3467a c3467a) {
        this.HW.add(c3467a);
        c3467a.Io = this.HX;
        c3467a.Ip = this.HY;
        c3467a.Iq = this.HZ;
        c3467a.Ir = this.Ia;
    }

    public fg mo2968a(Fragment fragment, String str) {
        m10935a(0, fragment, str, 1);
        return this;
    }

    public fg mo2966a(int i, Fragment fragment, String str) {
        m10935a(i, fragment, str, 1);
        return this;
    }

    private void m10935a(int i, Fragment fragment, String str, int i2) {
        Class cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state.");
        }
        fragment.mFragmentManager = this.HV;
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.mFragmentId == 0 || fragment.mFragmentId == i) {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
        }
        C3467a c3467a = new C3467a();
        c3467a.In = i2;
        c3467a.fragment = fragment;
        m10943a(c3467a);
    }

    public fg mo2965a(int i, Fragment fragment) {
        return mo2970b(i, fragment, null);
    }

    public fg mo2970b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m10935a(i, fragment, str, 2);
        return this;
    }

    public fg mo2967a(Fragment fragment) {
        C3467a c3467a = new C3467a();
        c3467a.In = 3;
        c3467a.fragment = fragment;
        m10943a(c3467a);
        return this;
    }

    public fg mo2971b(Fragment fragment) {
        C3467a c3467a = new C3467a();
        c3467a.In = 6;
        c3467a.fragment = fragment;
        m10943a(c3467a);
        return this;
    }

    public fg mo2972c(Fragment fragment) {
        C3467a c3467a = new C3467a();
        c3467a.In = 7;
        c3467a.fragment = fragment;
        m10943a(c3467a);
        return this;
    }

    public fg mo2964T(String str) {
        if (this.Ie) {
            this.Id = true;
            this.mName = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public fg hL() {
        if (this.Id) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.Ie = false;
        return this;
    }

    void aB(int i) {
        if (this.Id) {
            if (fb.DEBUG) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.HW.size();
            for (int i2 = 0; i2 < size; i2++) {
                C3467a c3467a = (C3467a) this.HW.get(i2);
                if (c3467a.fragment != null) {
                    Fragment fragment = c3467a.fragment;
                    fragment.mBackStackNesting += i;
                    if (fb.DEBUG) {
                        Log.v("FragmentManager", "Bump nesting of " + c3467a.fragment + " to " + c3467a.fragment.mBackStackNesting);
                    }
                }
            }
        }
    }

    public int commit() {
        return m10952w(false);
    }

    public int commitAllowingStateLoss() {
        return m10952w(true);
    }

    public void commitNowAllowingStateLoss() {
        hL();
        this.HV.m11326b((C3468c) this, true);
    }

    int m10952w(boolean z) {
        if (this.If) {
            throw new IllegalStateException("commit already called");
        }
        if (fb.DEBUG) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new jp("FragmentManager"));
            dump("  ", null, printWriter, null);
            printWriter.close();
        }
        this.If = true;
        if (this.Id) {
            this.mIndex = this.HV.m11305a(this);
        } else {
            this.mIndex = -1;
        }
        this.HV.m11318a((C3468c) this, z);
        return this.mIndex;
    }

    public boolean mo2969a(ArrayList<en> arrayList, ArrayList<Boolean> arrayList2) {
        if (fb.DEBUG) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.valueOf(false));
        if (this.Id) {
            this.HV.m11325b(this);
        }
        return true;
    }

    boolean aC(int i) {
        int size = this.HW.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C3467a) this.HW.get(i2)).fragment.mContainerId == i) {
                return true;
            }
        }
        return false;
    }

    boolean m10945a(ArrayList<en> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.HW.size();
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            int i5;
            int i6 = ((C3467a) this.HW.get(i4)).fragment.mContainerId;
            if (i6 == 0 || i6 == i3) {
                i5 = i3;
            } else {
                for (int i7 = i; i7 < i2; i7++) {
                    en enVar = (en) arrayList.get(i7);
                    int size2 = enVar.HW.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        if (((C3467a) enVar.HW.get(i8)).fragment.mContainerId == i6) {
                            return true;
                        }
                    }
                }
                i5 = i6;
            }
            i4++;
            i3 = i5;
        }
        return false;
    }

    void hM() {
        int size = this.HW.size();
        for (int i = 0; i < size; i++) {
            C3467a c3467a = (C3467a) this.HW.get(i);
            Fragment fragment = c3467a.fragment;
            fragment.setNextTransition(this.Ib, this.Ic);
            switch (c3467a.In) {
                case 1:
                    fragment.setNextAnim(c3467a.Io);
                    this.HV.m11314a(fragment, false);
                    break;
                case 3:
                    fragment.setNextAnim(c3467a.Ip);
                    this.HV.m11341l(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(c3467a.Ip);
                    this.HV.m11342m(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(c3467a.Io);
                    this.HV.m11343n(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(c3467a.Ip);
                    this.HV.m11344o(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(c3467a.Io);
                    this.HV.m11345p(fragment);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c3467a.In);
            }
            if (!(this.Im || c3467a.In == 1)) {
                this.HV.m11337i(fragment);
            }
        }
        if (!this.Im) {
            this.HV.m11321b(this.HV.Jn, true);
        }
    }

    void m10953x(boolean z) {
        for (int size = this.HW.size() - 1; size >= 0; size--) {
            C3467a c3467a = (C3467a) this.HW.get(size);
            Fragment fragment = c3467a.fragment;
            fragment.setNextTransition(fb.aI(this.Ib), this.Ic);
            switch (c3467a.In) {
                case 1:
                    fragment.setNextAnim(c3467a.Ir);
                    this.HV.m11341l(fragment);
                    break;
                case 3:
                    fragment.setNextAnim(c3467a.Iq);
                    this.HV.m11314a(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(c3467a.Iq);
                    this.HV.m11343n(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(c3467a.Ir);
                    this.HV.m11342m(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(c3467a.Iq);
                    this.HV.m11345p(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(c3467a.Ir);
                    this.HV.m11344o(fragment);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c3467a.In);
            }
            if (!(this.Im || c3467a.In == 3)) {
                this.HV.m11337i(fragment);
            }
        }
        if (!this.Im && z) {
            this.HV.m11321b(this.HV.Jn, true);
        }
    }

    void m10949b(ArrayList<Fragment> arrayList) {
        int i = 0;
        while (i < this.HW.size()) {
            C3467a c3467a = (C3467a) this.HW.get(i);
            switch (c3467a.In) {
                case 1:
                case 7:
                    arrayList.add(c3467a.fragment);
                    break;
                case 2:
                    Fragment fragment = c3467a.fragment;
                    int i2 = fragment.mContainerId;
                    int size = arrayList.size() - 1;
                    int i3 = i;
                    int i4 = 0;
                    while (size >= 0) {
                        Fragment fragment2 = (Fragment) arrayList.get(size);
                        if (fragment2.mContainerId != i2) {
                            i = i4;
                            i4 = i3;
                        } else if (fragment2 == fragment) {
                            i = 1;
                            i4 = i3;
                        } else {
                            C3467a c3467a2 = new C3467a();
                            c3467a2.In = 3;
                            c3467a2.fragment = fragment2;
                            c3467a2.Io = c3467a.Io;
                            c3467a2.Iq = c3467a.Iq;
                            c3467a2.Ip = c3467a.Ip;
                            c3467a2.Ir = c3467a.Ir;
                            this.HW.add(i3, c3467a2);
                            arrayList.remove(fragment2);
                            int i5 = i4;
                            i4 = i3 + 1;
                            i = i5;
                        }
                        size--;
                        i3 = i4;
                        i4 = i;
                    }
                    if (i4 == 0) {
                        c3467a.In = 1;
                        arrayList.add(fragment);
                        i = i3;
                        break;
                    }
                    this.HW.remove(i3);
                    i = i3 - 1;
                    break;
                case 3:
                case 6:
                    arrayList.remove(c3467a.fragment);
                    break;
                default:
                    break;
            }
            i++;
        }
    }

    void m10951c(ArrayList<Fragment> arrayList) {
        for (int i = 0; i < this.HW.size(); i++) {
            C3467a c3467a = (C3467a) this.HW.get(i);
            switch (c3467a.In) {
                case 1:
                case 7:
                    arrayList.remove(c3467a.fragment);
                    break;
                case 3:
                case 6:
                    arrayList.add(c3467a.fragment);
                    break;
                default:
                    break;
            }
        }
    }

    boolean isPostponed() {
        for (int i = 0; i < this.HW.size(); i++) {
            if (m10936b((C3467a) this.HW.get(i))) {
                return true;
            }
        }
        return false;
    }

    void m10942a(C1136b c1136b) {
        for (int i = 0; i < this.HW.size(); i++) {
            C3467a c3467a = (C3467a) this.HW.get(i);
            if (m10936b(c3467a)) {
                c3467a.fragment.setOnStartEnterTransitionListener(c1136b);
            }
        }
    }

    private static boolean m10936b(C3467a c3467a) {
        Fragment fragment = c3467a.fragment;
        return (!fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    public String getName() {
        return this.mName;
    }
}
