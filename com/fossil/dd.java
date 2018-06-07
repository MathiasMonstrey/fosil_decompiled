package com.fossil;

import android.annotation.TargetApi;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.fossil.dh.C2251c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(14)
class dd {
    private static final String[] Gi = new String[0];
    private static dh Gj = new ck();
    private static ThreadLocal<WeakReference<jl<ViewGroup, ArrayList<dh>>>> Gk = new ThreadLocal();
    static ArrayList<ViewGroup> Gl = new ArrayList();
    private static String LOG_TAG = "TransitionManager";

    static class C2681a implements OnAttachStateChangeListener, OnPreDrawListener {
        ViewGroup Gb;
        dh Gd;

        C2681a(dh dhVar, ViewGroup viewGroup) {
            this.Gd = dhVar;
            this.Gb = viewGroup;
        }

        private void hz() {
            this.Gb.getViewTreeObserver().removeOnPreDrawListener(this);
            this.Gb.removeOnAttachStateChangeListener(this);
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            hz();
            dd.Gl.remove(this.Gb);
            ArrayList arrayList = (ArrayList) dd.hy().get(this.Gb);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((dh) it.next()).mo1861B(this.Gb);
                }
            }
            this.Gd.m6855v(true);
        }

        public boolean onPreDraw() {
            ArrayList arrayList;
            hz();
            dd.Gl.remove(this.Gb);
            final jl hy = dd.hy();
            ArrayList arrayList2 = (ArrayList) hy.get(this.Gb);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hy.put(this.Gb, arrayList2);
                arrayList = arrayList2;
                arrayList2 = null;
            } else if (arrayList2.size() > 0) {
                ArrayList arrayList3 = new ArrayList(arrayList2);
                arrayList = arrayList2;
                arrayList2 = arrayList3;
            } else {
                arrayList = arrayList2;
                arrayList2 = null;
            }
            arrayList.add(this.Gd);
            this.Gd.mo1862a(new C2251c(this) {
                final /* synthetic */ C2681a Gn;

                public void mo1903a(dh dhVar) {
                    ((ArrayList) hy.get(this.Gn.Gb)).remove(dhVar);
                }
            });
            this.Gd.m6850b(this.Gb, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((dh) it.next()).mo1861B(this.Gb);
                }
            }
            this.Gd.m6853c(this.Gb);
            return true;
        }
    }

    static jl<ViewGroup, ArrayList<dh>> hy() {
        WeakReference weakReference = (WeakReference) Gk.get();
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference(new jl());
            Gk.set(weakReference);
        }
        return (jl) weakReference.get();
    }

    private static void m8352a(ViewGroup viewGroup, dh dhVar) {
        if (dhVar != null && viewGroup != null) {
            Object c2681a = new C2681a(dhVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(c2681a);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(c2681a);
        }
    }

    private static void m8353b(ViewGroup viewGroup, dh dhVar) {
        ArrayList arrayList = (ArrayList) hy().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((dh) it.next()).mo1860A(viewGroup);
            }
        }
        if (dhVar != null) {
            dhVar.m6850b(viewGroup, true);
        }
        cv z = cv.m7616z(viewGroup);
        if (z != null) {
            z.exit();
        }
    }

    public static void m8354c(ViewGroup viewGroup, dh dhVar) {
        if (!Gl.contains(viewGroup) && li.as(viewGroup)) {
            Gl.add(viewGroup);
            if (dhVar == null) {
                dhVar = Gj;
            }
            dh hC = dhVar.hC();
            m8353b(viewGroup, hC);
            cv.m7615a(viewGroup, null);
            m8352a(viewGroup, hC);
        }
    }
}
