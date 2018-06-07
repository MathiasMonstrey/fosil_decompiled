package com.fossil;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(14)
abstract class dh implements Cloneable {
    private static ThreadLocal<jl<Animator, C2762a>> Go = new ThreadLocal();
    long CZ = -1;
    ArrayList<Animator> DN = new ArrayList();
    ArrayList<C2250b> Da = null;
    boolean GA = false;
    int GB = 0;
    boolean GC = false;
    private C3009do GD = new C3009do();
    private C3009do GE = new C3009do();
    ArrayList<Animator> GF = new ArrayList();
    private boolean GG = false;
    ViewGroup Gb = null;
    long Gp = -1;
    TimeInterpolator Gq = null;
    ArrayList<Integer> Gr = new ArrayList();
    ArrayList<View> Gs = new ArrayList();
    ArrayList<Integer> Gt = null;
    ArrayList<View> Gu = null;
    ArrayList<Class> Gv = null;
    ArrayList<Integer> Gw = null;
    ArrayList<View> Gx = null;
    ArrayList<Class> Gy = null;
    dm Gz = null;
    private String mName = getClass().getName();

    public interface C2250b {
        void mo1903a(dh dhVar);

        void mo1904b(dh dhVar);

        void mo1905c(dh dhVar);

        void mo1906d(dh dhVar);
    }

    public static class C2251c implements C2250b {
        public void mo1906d(dh dhVar) {
        }

        public void mo1903a(dh dhVar) {
        }

        public void mo1904b(dh dhVar) {
        }

        public void mo1905c(dh dhVar) {
        }
    }

    class C27612 extends AnimatorListenerAdapter {
        final /* synthetic */ dh GI;

        C27612(dh dhVar) {
            this.GI = dhVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.GI.end();
            animator.removeListener(this);
        }
    }

    static class C2762a {
        dn GJ;
        dx GK;
        String name;
        View view;

        C2762a(View view, String str, dx dxVar, dn dnVar) {
            this.view = view;
            this.name = str;
            this.GJ = dnVar;
            this.GK = dxVar;
        }
    }

    public abstract void mo1864a(dn dnVar);

    public abstract void mo1866b(dn dnVar);

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return hC();
    }

    private static jl<Animator, C2762a> hA() {
        jl<Animator, C2762a> jlVar = (jl) Go.get();
        if (jlVar != null) {
            return jlVar;
        }
        jlVar = new jl();
        Go.set(jlVar);
        return jlVar;
    }

    public long getDuration() {
        return this.CZ;
    }

    public dh mo1871k(long j) {
        this.CZ = j;
        return this;
    }

    public long getStartDelay() {
        return this.Gp;
    }

    public TimeInterpolator getInterpolator() {
        return this.Gq;
    }

    public dh mo1867c(TimeInterpolator timeInterpolator) {
        this.Gq = timeInterpolator;
        return this;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public Animator mo1907a(ViewGroup viewGroup, dn dnVar, dn dnVar2) {
        return null;
    }

    protected void mo1863a(ViewGroup viewGroup, C3009do c3009do, C3009do c3009do2) {
        int i;
        int i2;
        jl jlVar = new jl(c3009do2.GS);
        SparseArray sparseArray = new SparseArray(c3009do2.GT.size());
        for (i = 0; i < c3009do2.GT.size(); i++) {
            sparseArray.put(c3009do2.GT.keyAt(i), c3009do2.GT.valueAt(i));
        }
        jq jqVar = new jq(c3009do2.GU.size());
        for (i = 0; i < c3009do2.GU.size(); i++) {
            jqVar.put(c3009do2.GU.keyAt(i), c3009do2.GU.valueAt(i));
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (View view : c3009do.GS.keySet()) {
            Object obj = null;
            if (view.getParent() instanceof ListView) {
                obj = 1;
            }
            if (obj == null) {
                Object obj2;
                int id = view.getId();
                if (c3009do.GS.get(view) != null) {
                    obj2 = (dn) c3009do.GS.get(view);
                } else {
                    dn dnVar = (dn) c3009do.GT.get(id);
                }
                if (c3009do2.GS.get(view) != null) {
                    obj = (dn) c3009do2.GS.get(view);
                    jlVar.remove(view);
                } else if (id != -1) {
                    dn dnVar2 = (dn) c3009do2.GT.get(id);
                    View view2 = null;
                    for (View view3 : jlVar.keySet()) {
                        View view32;
                        if (view32.getId() != id) {
                            view32 = view2;
                        }
                        view2 = view32;
                    }
                    if (view2 != null) {
                        jlVar.remove(view2);
                    }
                } else {
                    obj = null;
                }
                sparseArray.remove(id);
                if (m6847a(view, (long) id)) {
                    arrayList.add(obj2);
                    arrayList2.add(obj);
                }
            } else {
                ListView listView = (ListView) view.getParent();
                if (listView.getAdapter().hasStableIds()) {
                    long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                    dn dnVar3 = (dn) c3009do.GU.get(itemIdAtPosition);
                    jqVar.remove(itemIdAtPosition);
                    arrayList.add(dnVar3);
                    arrayList2.add(null);
                }
            }
        }
        int size = c3009do.GU.size();
        for (i2 = 0; i2 < size; i2++) {
            long keyAt = c3009do.GU.keyAt(i2);
            if (m6847a(null, keyAt)) {
                dnVar3 = (dn) c3009do.GU.get(keyAt);
                dnVar2 = (dn) c3009do2.GU.get(keyAt);
                jqVar.remove(keyAt);
                arrayList.add(dnVar3);
                arrayList2.add(dnVar2);
            }
        }
        for (View view4 : jlVar.keySet()) {
            size = view4.getId();
            if (m6847a(view4, (long) size)) {
                if (c3009do.GS.get(view4) != null) {
                    obj = (dn) c3009do.GS.get(view4);
                } else {
                    dnVar2 = (dn) c3009do.GT.get(size);
                }
                dnVar3 = (dn) jlVar.get(view4);
                sparseArray.remove(size);
                arrayList.add(obj);
                arrayList2.add(dnVar3);
            }
        }
        size = sparseArray.size();
        for (i2 = 0; i2 < size; i2++) {
            int keyAt2 = sparseArray.keyAt(i2);
            if (m6847a(null, (long) keyAt2)) {
                dnVar3 = (dn) c3009do.GT.get(keyAt2);
                dnVar2 = (dn) sparseArray.get(keyAt2);
                arrayList.add(dnVar3);
                arrayList2.add(dnVar2);
            }
        }
        size = jqVar.size();
        for (i2 = 0; i2 < size; i2++) {
            long keyAt3 = jqVar.keyAt(i2);
            dnVar2 = (dn) jqVar.get(keyAt3);
            arrayList.add((dn) c3009do.GU.get(keyAt3));
            arrayList2.add(dnVar2);
        }
        jl hA = hA();
        for (i2 = 0; i2 < arrayList.size(); i2++) {
            dnVar3 = (dn) arrayList.get(i2);
            dnVar2 = (dn) arrayList2.get(i2);
            if (!(dnVar3 == null && dnVar2 == null) && (dnVar3 == null || !dnVar3.equals(dnVar2))) {
                Object a = mo1907a(viewGroup, dnVar3, dnVar2);
                if (a != null) {
                    View view5;
                    if (dnVar2 != null) {
                        View view6 = dnVar2.view;
                        String[] transitionProperties = getTransitionProperties();
                        if (view6 == null || transitionProperties == null || transitionProperties.length <= 0) {
                            dnVar3 = null;
                            obj = a;
                        } else {
                            dnVar = new dn();
                            dnVar.view = view6;
                            dnVar3 = (dn) c3009do2.GS.get(view6);
                            if (dnVar3 != null) {
                                for (keyAt2 = 0; keyAt2 < transitionProperties.length; keyAt2++) {
                                    dnVar.values.put(transitionProperties[keyAt2], dnVar3.values.get(transitionProperties[keyAt2]));
                                }
                            }
                            int size2 = hA.size();
                            for (keyAt2 = 0; keyAt2 < size2; keyAt2++) {
                                C2762a c2762a = (C2762a) hA.get((Animator) hA.keyAt(keyAt2));
                                if (c2762a.GJ != null && c2762a.view == view6 && (((c2762a.name == null && getName() == null) || c2762a.name.equals(getName())) && c2762a.GJ.equals(dnVar))) {
                                    obj = null;
                                    dnVar3 = dnVar;
                                    break;
                                }
                            }
                            dnVar3 = dnVar;
                            obj = a;
                        }
                        a = obj;
                        view5 = view6;
                    } else {
                        view5 = dnVar3.view;
                        dnVar3 = null;
                    }
                    if (a != null) {
                        hA.put(a, new C2762a(view5, getName(), dx.m10247E(viewGroup), dnVar3));
                        this.DN.add(a);
                    }
                }
            }
        }
    }

    boolean m6847a(View view, long j) {
        if (this.Gt != null && this.Gt.contains(Integer.valueOf((int) j))) {
            return false;
        }
        if (this.Gu != null && this.Gu.contains(view)) {
            return false;
        }
        int i;
        if (!(this.Gv == null || view == null)) {
            int size = this.Gv.size();
            for (i = 0; i < size; i++) {
                if (((Class) this.Gv.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.Gr.size() == 0 && this.Gs.size() == 0) {
            return true;
        }
        if (this.Gr.size() > 0) {
            for (i = 0; i < this.Gr.size(); i++) {
                if (((long) ((Integer) this.Gr.get(i)).intValue()) == j) {
                    return true;
                }
            }
        }
        if (view == null || this.Gs.size() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.Gs.size(); i2++) {
            if (this.Gs.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    protected void hB() {
        start();
        jl hA = hA();
        Iterator it = this.DN.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (hA.containsKey(animator)) {
                start();
                m6839a(animator, hA);
            }
        }
        this.DN.clear();
        end();
    }

    private void m6839a(Animator animator, final jl<Animator, C2762a> jlVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ dh GI;

                public void onAnimationStart(Animator animator) {
                    this.GI.GF.add(animator);
                }

                public void onAnimationEnd(Animator animator) {
                    jlVar.remove(animator);
                    this.GI.GF.remove(animator);
                }
            });
            m6849b(animator);
        }
    }

    void m6850b(ViewGroup viewGroup, boolean z) {
        int i = 0;
        m6855v(z);
        if (this.Gr.size() > 0 || this.Gs.size() > 0) {
            if (this.Gr.size() > 0) {
                for (int i2 = 0; i2 < this.Gr.size(); i2++) {
                    int intValue = ((Integer) this.Gr.get(i2)).intValue();
                    View findViewById = viewGroup.findViewById(intValue);
                    if (findViewById != null) {
                        dn dnVar = new dn();
                        dnVar.view = findViewById;
                        if (z) {
                            mo1864a(dnVar);
                        } else {
                            mo1866b(dnVar);
                        }
                        if (z) {
                            this.GD.GS.put(findViewById, dnVar);
                            if (intValue >= 0) {
                                this.GD.GT.put(intValue, dnVar);
                            }
                        } else {
                            this.GE.GS.put(findViewById, dnVar);
                            if (intValue >= 0) {
                                this.GE.GT.put(intValue, dnVar);
                            }
                        }
                    }
                }
            }
            if (this.Gs.size() > 0) {
                while (i < this.Gs.size()) {
                    View view = (View) this.Gs.get(i);
                    if (view != null) {
                        dn dnVar2 = new dn();
                        dnVar2.view = view;
                        if (z) {
                            mo1864a(dnVar2);
                        } else {
                            mo1866b(dnVar2);
                        }
                        if (z) {
                            this.GD.GS.put(view, dnVar2);
                        } else {
                            this.GE.GS.put(view, dnVar2);
                        }
                    }
                    i++;
                }
                return;
            }
            return;
        }
        m6840a((View) viewGroup, z);
    }

    void m6855v(boolean z) {
        if (z) {
            this.GD.GS.clear();
            this.GD.GT.clear();
            this.GD.GU.clear();
            return;
        }
        this.GE.GS.clear();
        this.GE.GT.clear();
        this.GE.GU.clear();
    }

    private void m6840a(View view, boolean z) {
        if (view != null) {
            Object obj;
            if (view.getParent() instanceof ListView) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null || ((ListView) view.getParent()).getAdapter().hasStableIds()) {
                int id;
                long j;
                if (obj == null) {
                    id = view.getId();
                    j = -1;
                } else {
                    ListView listView = (ListView) view.getParent();
                    id = -1;
                    j = listView.getItemIdAtPosition(listView.getPositionForView(view));
                }
                if (this.Gt != null && this.Gt.contains(Integer.valueOf(id))) {
                    return;
                }
                if (this.Gu == null || !this.Gu.contains(view)) {
                    if (!(this.Gv == null || view == null)) {
                        int size = this.Gv.size();
                        int i = 0;
                        while (i < size) {
                            if (!((Class) this.Gv.get(i)).isInstance(view)) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                    dn dnVar = new dn();
                    dnVar.view = view;
                    if (z) {
                        mo1864a(dnVar);
                    } else {
                        mo1866b(dnVar);
                    }
                    if (z) {
                        if (obj == null) {
                            this.GD.GS.put(view, dnVar);
                            if (id >= 0) {
                                this.GD.GT.put(id, dnVar);
                            }
                        } else {
                            this.GD.GU.put(j, dnVar);
                        }
                    } else if (obj == null) {
                        this.GE.GS.put(view, dnVar);
                        if (id >= 0) {
                            this.GE.GT.put(id, dnVar);
                        }
                    } else {
                        this.GE.GU.put(j, dnVar);
                    }
                    if (!(view instanceof ViewGroup)) {
                        return;
                    }
                    if (this.Gw != null && this.Gw.contains(Integer.valueOf(id))) {
                        return;
                    }
                    if (this.Gx == null || !this.Gx.contains(view)) {
                        if (!(this.Gy == null || view == null)) {
                            int size2 = this.Gy.size();
                            id = 0;
                            while (id < size2) {
                                if (!((Class) this.Gy.get(id)).isInstance(view)) {
                                    id++;
                                } else {
                                    return;
                                }
                            }
                        }
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            m6840a(viewGroup.getChildAt(i2), z);
                        }
                    }
                }
            }
        }
    }

    public void mo1860A(View view) {
        if (!this.GG) {
            jl hA = hA();
            int size = hA.size();
            dx E = dx.m10247E(view);
            for (int i = size - 1; i >= 0; i--) {
                C2762a c2762a = (C2762a) hA.valueAt(i);
                if (c2762a.view != null && E.equals(c2762a.GK)) {
                    ((Animator) hA.keyAt(i)).cancel();
                }
            }
            if (this.Da != null && this.Da.size() > 0) {
                ArrayList arrayList = (ArrayList) this.Da.clone();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((C2250b) arrayList.get(i2)).mo1904b(this);
                }
            }
            this.GC = true;
        }
    }

    public void mo1861B(View view) {
        if (this.GC) {
            if (!this.GG) {
                jl hA = hA();
                int size = hA.size();
                dx E = dx.m10247E(view);
                for (int i = size - 1; i >= 0; i--) {
                    C2762a c2762a = (C2762a) hA.valueAt(i);
                    if (c2762a.view != null && E.equals(c2762a.GK)) {
                        ((Animator) hA.keyAt(i)).end();
                    }
                }
                if (this.Da != null && this.Da.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.Da.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((C2250b) arrayList.get(i2)).mo1905c(this);
                    }
                }
            }
            this.GC = false;
        }
    }

    void m6853c(ViewGroup viewGroup) {
        jl hA = hA();
        for (int size = hA.size() - 1; size >= 0; size--) {
            Animator animator = (Animator) hA.keyAt(size);
            if (animator != null) {
                C2762a c2762a = (C2762a) hA.get(animator);
                if (!(c2762a == null || c2762a.view == null || c2762a.view.getContext() != viewGroup.getContext())) {
                    dn dnVar;
                    Object obj;
                    dn dnVar2 = c2762a.GJ;
                    View view = c2762a.view;
                    dn dnVar3 = this.GE.GS != null ? (dn) this.GE.GS.get(view) : null;
                    if (dnVar3 == null) {
                        dnVar = (dn) this.GE.GT.get(view.getId());
                    } else {
                        dnVar = dnVar3;
                    }
                    if (!(dnVar2 == null || dnVar == null)) {
                        for (String str : dnVar2.values.keySet()) {
                            Object obj2 = dnVar2.values.get(str);
                            obj = dnVar.values.get(str);
                            if (obj2 != null && obj != null && !obj2.equals(obj)) {
                                obj = 1;
                                break;
                            }
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        } else {
                            hA.remove(animator);
                        }
                    }
                }
            }
        }
        mo1863a(viewGroup, this.GD, this.GE);
        hB();
    }

    protected void m6849b(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new C27612(this));
        animator.start();
    }

    protected void start() {
        if (this.GB == 0) {
            if (this.Da != null && this.Da.size() > 0) {
                ArrayList arrayList = (ArrayList) this.Da.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((C2250b) arrayList.get(i)).mo1906d(this);
                }
            }
            this.GG = false;
        }
        this.GB++;
    }

    protected void end() {
        int i = 0;
        this.GB--;
        if (this.GB == 0) {
            View view;
            if (this.Da != null && this.Da.size() > 0) {
                ArrayList arrayList = (ArrayList) this.Da.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((C2250b) arrayList.get(i2)).mo1903a(this);
                }
            }
            for (int i3 = 0; i3 < this.GD.GU.size(); i3++) {
                view = ((dn) this.GD.GU.valueAt(i3)).view;
            }
            while (i < this.GE.GU.size()) {
                view = ((dn) this.GE.GU.valueAt(i)).view;
                i++;
            }
            this.GG = true;
        }
    }

    public dh mo1862a(C2250b c2250b) {
        if (this.Da == null) {
            this.Da = new ArrayList();
        }
        this.Da.add(c2250b);
        return this;
    }

    public dh mo1865b(C2250b c2250b) {
        if (this.Da != null) {
            this.Da.remove(c2250b);
            if (this.Da.size() == 0) {
                this.Da = null;
            }
        }
        return this;
    }

    public String toString() {
        return toString("");
    }

    public dh hC() {
        try {
            dh dhVar = (dh) super.clone();
            try {
                dhVar.DN = new ArrayList();
                dhVar.GD = new C3009do();
                dhVar.GE = new C3009do();
                return dhVar;
            } catch (CloneNotSupportedException e) {
                return dhVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    String toString(String str) {
        int i = 0;
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.CZ != -1) {
            str2 = str2 + "dur(" + this.CZ + ") ";
        }
        if (this.Gp != -1) {
            str2 = str2 + "dly(" + this.Gp + ") ";
        }
        if (this.Gq != null) {
            str2 = str2 + "interp(" + this.Gq + ") ";
        }
        if (this.Gr.size() <= 0 && this.Gs.size() <= 0) {
            return str2;
        }
        String str3;
        str2 = str2 + "tgts(";
        if (this.Gr.size() > 0) {
            str3 = str2;
            for (int i2 = 0; i2 < this.Gr.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.Gr.get(i2);
            }
        } else {
            str3 = str2;
        }
        if (this.Gs.size() > 0) {
            while (i < this.Gs.size()) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.Gs.get(i);
                i++;
            }
        }
        return str3 + ")";
    }
}
