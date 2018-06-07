package com.fossil;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.en.C3467a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class fh {
    private static final int[] Kb = new int[]{0, 3, 0, 1, 5, 4, 7, 6};

    static class C3569a {
        public Fragment Kt;
        public boolean Ku;
        public en Kv;
        public Fragment Kw;
        public boolean Kx;
        public en Ky;

        C3569a() {
        }
    }

    static void m11365a(fb fbVar, ArrayList<en> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (fbVar.Jn >= 1 && VERSION.SDK_INT >= 21) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                en enVar = (en) arrayList.get(i3);
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    m11376b(enVar, sparseArray, z);
                } else {
                    m11362a(enVar, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(fbVar.mHost.getContext());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    jl a = m11353a(keyAt, (ArrayList) arrayList, (ArrayList) arrayList2, i, i2);
                    C3569a c3569a = (C3569a) sparseArray.valueAt(i4);
                    if (z) {
                        m11364a(fbVar, keyAt, c3569a, view, a);
                    } else {
                        m11377b(fbVar, keyAt, c3569a, view, a);
                    }
                }
            }
        }
    }

    private static jl<String, String> m11353a(int i, ArrayList<en> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        jl<String, String> jlVar = new jl();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            en enVar = (en) arrayList.get(i4);
            if (enVar.aC(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
                if (enVar.Ik != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int size = enVar.Ik.size();
                    if (booleanValue) {
                        arrayList3 = enVar.Ik;
                        arrayList4 = enVar.Il;
                    } else {
                        ArrayList arrayList5 = enVar.Ik;
                        arrayList3 = enVar.Il;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String str3 = (String) jlVar.remove(str2);
                        if (str3 != null) {
                            jlVar.put(str, str3);
                        } else {
                            jlVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return jlVar;
    }

    private static void m11364a(fb fbVar, int i, C3569a c3569a, View view, jl<String, String> jlVar) {
        ViewGroup viewGroup = null;
        if (fbVar.Jo.onHasView()) {
            viewGroup = (ViewGroup) fbVar.Jo.onFindViewById(i);
        }
        if (viewGroup != null) {
            Fragment fragment = c3569a.Kt;
            Fragment fragment2 = c3569a.Kw;
            boolean z = c3569a.Ku;
            boolean z2 = c3569a.Kx;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object i2 = m11380i(fragment, z);
            Object j = m11381j(fragment2, z2);
            Object a = m11356a(viewGroup, view, (jl) jlVar, c3569a, arrayList2, arrayList, i2, j);
            if (i2 != null || a != null || j != null) {
                ArrayList a2 = m11359a(j, fragment2, arrayList2, view);
                ArrayList a3 = m11359a(i2, fragment, arrayList, view);
                m11369a(a3, 4);
                Object a4 = m11357a(i2, j, a, fragment, z);
                if (a4 != null) {
                    m11367a(j, fragment2, a2);
                    ArrayList d = fi.m11405d(arrayList);
                    fi.m11391a(a4, i2, a3, j, a2, a, arrayList);
                    fi.m11386a(viewGroup, a4);
                    fi.m11384a(viewGroup, arrayList2, arrayList, d, jlVar);
                    m11369a(a3, 0);
                    fi.m11393a(a, arrayList2, arrayList);
                }
            }
        }
    }

    private static void m11367a(Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fi.m11402b(obj, fragment.getView(), (ArrayList) arrayList);
            ga.m11502a(fragment.mContainer, new Runnable() {
                public void run() {
                    fh.m11369a(arrayList, 4);
                }
            });
        }
    }

    private static void m11377b(fb fbVar, int i, C3569a c3569a, View view, jl<String, String> jlVar) {
        ViewGroup viewGroup = null;
        if (fbVar.Jo.onHasView()) {
            viewGroup = (ViewGroup) fbVar.Jo.onFindViewById(i);
        }
        if (viewGroup != null) {
            Fragment fragment = c3569a.Kt;
            Fragment fragment2 = c3569a.Kw;
            boolean z = c3569a.Ku;
            boolean z2 = c3569a.Kx;
            Object i2 = m11380i(fragment, z);
            Object j = m11381j(fragment2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object b = m11373b(viewGroup, view, jlVar, c3569a, arrayList, arrayList2, i2, j);
            if (i2 != null || b != null || j != null) {
                Object obj;
                ArrayList a = m11359a(j, fragment2, arrayList, view);
                if (a == null || a.isEmpty()) {
                    obj = null;
                } else {
                    obj = j;
                }
                fi.m11401b(i2, view);
                j = m11357a(i2, obj, b, fragment, c3569a.Ku);
                if (j != null) {
                    ArrayList arrayList3 = new ArrayList();
                    fi.m11391a(j, i2, arrayList3, obj, a, b, arrayList2);
                    m11361a(viewGroup, fragment, view, arrayList2, i2, arrayList3, obj, a);
                    fi.m11385a((View) viewGroup, arrayList2, (Map) jlVar);
                    fi.m11386a(viewGroup, j);
                    fi.m11387a(viewGroup, arrayList2, (Map) jlVar);
                }
            }
        }
    }

    private static void m11361a(ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final View view2 = view;
        final Fragment fragment2 = fragment;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        ga.m11502a(viewGroup, new Runnable() {
            public void run() {
                if (obj3 != null) {
                    fi.m11404c(obj3, view2);
                    arrayList5.addAll(fh.m11359a(obj3, fragment2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        fi.m11403b(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static Object m11355a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object sharedElementReturnTransition;
        if (z) {
            sharedElementReturnTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementReturnTransition = fragment.getSharedElementEnterTransition();
        }
        return fi.m11409m(fi.m11407l(sharedElementReturnTransition));
    }

    private static Object m11380i(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        Object reenterTransition;
        if (z) {
            reenterTransition = fragment.getReenterTransition();
        } else {
            reenterTransition = fragment.getEnterTransition();
        }
        return fi.m11407l(reenterTransition);
    }

    private static Object m11381j(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        Object returnTransition;
        if (z) {
            returnTransition = fragment.getReturnTransition();
        } else {
            returnTransition = fragment.getExitTransition();
        }
        return fi.m11407l(returnTransition);
    }

    private static Object m11356a(ViewGroup viewGroup, View view, jl<String, String> jlVar, C3569a c3569a, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        View view2 = null;
        final Fragment fragment = c3569a.Kt;
        final Fragment fragment2 = c3569a.Kw;
        if (fragment != null) {
            fragment.getView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object obj3;
        Object obj4;
        final boolean z = c3569a.Ku;
        if (jlVar.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = m11355a(fragment, fragment2, z);
        }
        jl a = m11354a((jl) jlVar, obj3, c3569a);
        final jl b = m11372b((jl) jlVar, obj3, c3569a);
        if (jlVar.isEmpty()) {
            if (a != null) {
                a.clear();
            }
            if (b != null) {
                b.clear();
                obj4 = null;
            } else {
                obj4 = null;
            }
        } else {
            m11370a((ArrayList) arrayList, a, jlVar.keySet());
            m11370a((ArrayList) arrayList2, b, jlVar.values());
            obj4 = obj3;
        }
        if (obj == null && obj2 == null && obj4 == null) {
            return null;
        }
        Rect rect;
        m11360a(fragment, fragment2, z, a, true);
        if (obj4 != null) {
            arrayList2.add(view);
            fi.m11390a(obj4, view, (ArrayList) arrayList);
            m11368a(obj4, obj2, a, c3569a.Kx, c3569a.Ky);
            rect = new Rect();
            view2 = m11351a(b, c3569a, obj, z);
            if (view2 != null) {
                fi.m11388a(obj, rect);
            }
        } else {
            rect = null;
        }
        ga.m11502a(viewGroup, new Runnable() {
            public void run() {
                fh.m11360a(fragment, fragment2, z, b, false);
                if (view2 != null) {
                    fi.m11406d(view2, rect);
                }
            }
        });
        return obj4;
    }

    private static void m11370a(ArrayList<View> arrayList, jl<String, View> jlVar, Collection<String> collection) {
        for (int size = jlVar.size() - 1; size >= 0; size--) {
            View view = (View) jlVar.valueAt(size);
            if (collection.contains(li.ah(view))) {
                arrayList.add(view);
            }
        }
    }

    private static Object m11373b(ViewGroup viewGroup, View view, jl<String, String> jlVar, C3569a c3569a, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        final Fragment fragment = c3569a.Kt;
        final Fragment fragment2 = c3569a.Kw;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object obj3;
        Object obj4;
        final boolean z = c3569a.Ku;
        if (jlVar.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = m11355a(fragment, fragment2, z);
        }
        jl a = m11354a((jl) jlVar, obj3, c3569a);
        if (jlVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList.addAll(a.values());
            obj4 = obj3;
        }
        if (obj == null && obj2 == null && obj4 == null) {
            return null;
        }
        Rect rect;
        m11360a(fragment, fragment2, z, a, true);
        if (obj4 != null) {
            rect = new Rect();
            fi.m11390a(obj4, view, (ArrayList) arrayList);
            m11368a(obj4, obj2, a, c3569a.Kx, c3569a.Ky);
            if (obj != null) {
                fi.m11388a(obj, rect);
            }
        } else {
            rect = null;
        }
        final jl<String, String> jlVar2 = jlVar;
        final C3569a c3569a2 = c3569a;
        final ArrayList<View> arrayList3 = arrayList2;
        final View view2 = view;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj5 = obj;
        ga.m11502a(viewGroup, new Runnable() {
            public void run() {
                jl c = fh.m11372b(jlVar2, obj4, c3569a2);
                if (c != null) {
                    arrayList3.addAll(c.values());
                    arrayList3.add(view2);
                }
                fh.m11360a(fragment, fragment2, z, c, false);
                if (obj4 != null) {
                    fi.m11393a(obj4, arrayList4, arrayList3);
                    View b = fh.m11351a(c, c3569a2, obj5, z);
                    if (b != null) {
                        fi.m11406d(b, rect);
                    }
                }
            }
        });
        return obj4;
    }

    private static jl<String, View> m11354a(jl<String, String> jlVar, Object obj, C3569a c3569a) {
        if (jlVar.isEmpty() || obj == null) {
            jlVar.clear();
            return null;
        }
        ArrayList arrayList;
        gg ggVar;
        Fragment fragment = c3569a.Kw;
        Map jlVar2 = new jl();
        fi.m11396a(jlVar2, fragment.getView());
        en enVar = c3569a.Ky;
        gg enterTransitionCallback;
        if (c3569a.Kx) {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = enVar.Il;
            ggVar = enterTransitionCallback;
        } else {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = enVar.Ik;
            ggVar = enterTransitionCallback;
        }
        jlVar2.retainAll(arrayList);
        if (ggVar != null) {
            ggVar.onMapSharedElements(arrayList, jlVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = (View) jlVar2.get(str);
                if (view == null) {
                    jlVar.remove(str);
                } else if (!str.equals(li.ah(view))) {
                    jlVar.put(li.ah(view), (String) jlVar.remove(str));
                }
            }
        } else {
            jlVar.retainAll(jlVar2.keySet());
        }
        return jlVar2;
    }

    private static jl<String, View> m11372b(jl<String, String> jlVar, Object obj, C3569a c3569a) {
        Fragment fragment = c3569a.Kt;
        View view = fragment.getView();
        if (jlVar.isEmpty() || obj == null || view == null) {
            jlVar.clear();
            return null;
        }
        ArrayList arrayList;
        gg ggVar;
        jl<String, View> jlVar2 = new jl();
        fi.m11396a((Map) jlVar2, view);
        en enVar = c3569a.Kv;
        gg exitTransitionCallback;
        if (c3569a.Ku) {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = enVar.Ik;
            ggVar = exitTransitionCallback;
        } else {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = enVar.Il;
            ggVar = exitTransitionCallback;
        }
        if (arrayList != null) {
            jlVar2.retainAll(arrayList);
        }
        if (ggVar != null) {
            ggVar.onMapSharedElements(arrayList, jlVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                view = (View) jlVar2.get(str);
                if (view == null) {
                    str = m11358a((jl) jlVar, str);
                    if (str != null) {
                        jlVar.remove(str);
                    }
                } else if (!str.equals(li.ah(view))) {
                    str = m11358a((jl) jlVar, str);
                    if (str != null) {
                        jlVar.put(str, li.ah(view));
                    }
                }
            }
        } else {
            m11366a((jl) jlVar, (jl) jlVar2);
        }
        return jlVar2;
    }

    private static String m11358a(jl<String, String> jlVar, String str) {
        int size = jlVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(jlVar.valueAt(i))) {
                return (String) jlVar.keyAt(i);
            }
        }
        return null;
    }

    private static View m11351a(jl<String, View> jlVar, C3569a c3569a, Object obj, boolean z) {
        en enVar = c3569a.Kv;
        if (obj == null || jlVar == null || enVar.Ik == null || enVar.Ik.isEmpty()) {
            return null;
        }
        Object obj2;
        if (z) {
            obj2 = (String) enVar.Ik.get(0);
        } else {
            String str = (String) enVar.Il.get(0);
        }
        return (View) jlVar.get(obj2);
    }

    private static void m11368a(Object obj, Object obj2, jl<String, View> jlVar, boolean z, en enVar) {
        if (enVar.Ik != null && !enVar.Ik.isEmpty()) {
            Object obj3;
            if (z) {
                obj3 = (String) enVar.Il.get(0);
            } else {
                String str = (String) enVar.Ik.get(0);
            }
            View view = (View) jlVar.get(obj3);
            fi.m11389a(obj, view);
            if (obj2 != null) {
                fi.m11389a(obj2, view);
            }
        }
    }

    private static void m11366a(jl<String, String> jlVar, jl<String, View> jlVar2) {
        for (int size = jlVar.size() - 1; size >= 0; size--) {
            if (!jlVar2.containsKey((String) jlVar.valueAt(size))) {
                jlVar.removeAt(size);
            }
        }
    }

    private static void m11360a(Fragment fragment, Fragment fragment2, boolean z, jl<String, View> jlVar, boolean z2) {
        gg enterTransitionCallback;
        int i = 0;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int size = jlVar == null ? 0 : jlVar.size();
            while (i < size) {
                arrayList2.add(jlVar.keyAt(i));
                arrayList.add(jlVar.valueAt(i));
                i++;
            }
            if (z2) {
                enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    private static ArrayList<View> m11359a(Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList();
            View view2 = fragment.getView();
            if (view2 != null) {
                fi.m11394a((ArrayList) arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                fi.m11392a(obj, (ArrayList) arrayList2);
            }
        }
        return arrayList2;
    }

    private static void m11369a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    private static Object m11357a(Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2 = true;
        if (!(obj == null || obj2 == null || fragment == null)) {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return fi.m11382a(obj2, obj, obj3);
        }
        return fi.m11399b(obj2, obj, obj3);
    }

    public static void m11362a(en enVar, SparseArray<C3569a> sparseArray, boolean z) {
        int size = enVar.HW.size();
        for (int i = 0; i < size; i++) {
            m11363a(enVar, (C3467a) enVar.HW.get(i), (SparseArray) sparseArray, false, z);
        }
    }

    public static void m11376b(en enVar, SparseArray<C3569a> sparseArray, boolean z) {
        if (enVar.HV.Jo.onHasView()) {
            for (int size = enVar.HW.size() - 1; size >= 0; size--) {
                m11363a(enVar, (C3467a) enVar.HW.get(size), (SparseArray) sparseArray, true, z);
            }
        }
    }

    private static void m11363a(en enVar, C3467a c3467a, SparseArray<C3569a> sparseArray, boolean z, boolean z2) {
        Fragment fragment = c3467a.fragment;
        int i = fragment.mContainerId;
        if (i != 0) {
            int i2;
            int i3;
            C3569a a;
            boolean z3;
            int i4;
            int i5;
            boolean z4;
            int i6;
            switch (z ? Kb[c3467a.In] : c3467a.In) {
                case 1:
                case 7:
                    z3 = z2 ? fragment.mIsNewlyAdded : (fragment.mAdded || fragment.mHidden) ? false : true;
                    i4 = 1;
                    i2 = 0;
                    i5 = 0;
                    z4 = z3;
                    break;
                case 3:
                case 6:
                    i6 = z2 ? (fragment.mAdded || fragment.mView == null || fragment.mView.getVisibility() != 0 || fragment.mPostponedAlpha < 0.0f) ? 0 : 1 : (!fragment.mAdded || fragment.mHidden) ? 0 : 1;
                    i4 = 0;
                    i2 = i6;
                    i5 = 1;
                    i3 = 0;
                    break;
                case 4:
                    i6 = z2 ? (fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden) ? 1 : 0 : (!fragment.mAdded || fragment.mHidden) ? 0 : 1;
                    i4 = 0;
                    i2 = i6;
                    i5 = 1;
                    i3 = 0;
                    break;
                case 5:
                    z3 = z2 ? fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded : fragment.mHidden;
                    i4 = 1;
                    i2 = 0;
                    i5 = 0;
                    z4 = z3;
                    break;
                default:
                    i4 = 0;
                    i2 = 0;
                    i5 = 0;
                    i3 = 0;
                    break;
            }
            C3569a c3569a = (C3569a) sparseArray.get(i);
            if (i3 != 0) {
                a = m11352a(c3569a, (SparseArray) sparseArray, i);
                a.Kt = fragment;
                a.Ku = z;
                a.Kv = enVar;
            } else {
                a = c3569a;
            }
            if (!(z2 || r4 == 0)) {
                if (a != null && a.Kw == fragment) {
                    a.Kw = null;
                }
                fb fbVar = enVar.HV;
                if (fragment.mState < 1 && fbVar.Jn >= 1 && !enVar.Im) {
                    fbVar.m11339j(fragment);
                    fbVar.m11310a(fragment, 1, 0, 0, false);
                }
            }
            if (i2 == 0 || !(a == null || a.Kw == null)) {
                c3569a = a;
            } else {
                c3569a = m11352a(a, (SparseArray) sparseArray, i);
                c3569a.Kw = fragment;
                c3569a.Kx = z;
                c3569a.Ky = enVar;
            }
            if (!z2 && r7 != 0 && c3569a != null && c3569a.Kt == fragment) {
                c3569a.Kt = null;
            }
        }
    }

    private static C3569a m11352a(C3569a c3569a, SparseArray<C3569a> sparseArray, int i) {
        if (c3569a != null) {
            return c3569a;
        }
        c3569a = new C3569a();
        sparseArray.put(i, c3569a);
        return c3569a;
    }
}
