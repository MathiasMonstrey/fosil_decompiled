package com.fossil;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ru extends so {
    private ArrayList<v> amc = new ArrayList();
    private ArrayList<v> amd = new ArrayList();
    private ArrayList<C4061b> ame = new ArrayList();
    private ArrayList<C4060a> amf = new ArrayList();
    ArrayList<ArrayList<v>> amg = new ArrayList();
    ArrayList<ArrayList<C4061b>> amh = new ArrayList();
    ArrayList<ArrayList<C4060a>> ami = new ArrayList();
    ArrayList<v> amj = new ArrayList();
    ArrayList<v> amk = new ArrayList();
    ArrayList<v> aml = new ArrayList();
    ArrayList<v> amm = new ArrayList();

    static class C4054c implements md {
        C4054c() {
        }

        public void mo4090e(View view) {
        }

        public void mo4091f(View view) {
        }

        public void aD(View view) {
        }
    }

    static class C4060a {
        public v amA;
        public int amB;
        public int amC;
        public int amD;
        public int amE;
        public v amz;

        private C4060a(v vVar, v vVar2) {
            this.amz = vVar;
            this.amA = vVar2;
        }

        C4060a(v vVar, v vVar2, int i, int i2, int i3, int i4) {
            this(vVar, vVar2);
            this.amB = i;
            this.amC = i2;
            this.amD = i3;
            this.amE = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.amz + ", newHolder=" + this.amA + ", fromX=" + this.amB + ", fromY=" + this.amC + ", toX=" + this.amD + ", toY=" + this.amE + '}';
        }
    }

    static class C4061b {
        public int amB;
        public int amC;
        public int amD;
        public int amE;
        public v amF;

        C4061b(v vVar, int i, int i2, int i3, int i4) {
            this.amF = vVar;
            this.amB = i;
            this.amC = i2;
            this.amD = i3;
            this.amE = i4;
        }
    }

    public void oM() {
        int i;
        int i2;
        int i3;
        int i4 = !this.amc.isEmpty() ? 1 : 0;
        if (this.ame.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.amf.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.amd.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            final ArrayList arrayList;
            Runnable c40511;
            Iterator it = this.amc.iterator();
            while (it.hasNext()) {
                m13457c((v) it.next());
            }
            this.amc.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.ame);
                this.amh.add(arrayList);
                this.ame.clear();
                c40511 = new Runnable(this) {
                    final /* synthetic */ ru amo;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            C4061b c4061b = (C4061b) it.next();
                            this.amo.m13463b(c4061b.amF, c4061b.amB, c4061b.amC, c4061b.amD, c4061b.amE);
                        }
                        arrayList.clear();
                        this.amo.amh.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    li.a(((C4061b) arrayList.get(0)).amF.arT, c40511, qA());
                } else {
                    c40511.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.amf);
                this.ami.add(arrayList);
                this.amf.clear();
                c40511 = new Runnable(this) {
                    final /* synthetic */ ru amo;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            this.amo.m13459a((C4060a) it.next());
                        }
                        arrayList.clear();
                        this.amo.ami.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    li.a(((C4060a) arrayList.get(0)).amz.arT, c40511, qA());
                } else {
                    c40511.run();
                }
            }
            if (i3 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.amd);
                this.amg.add(arrayList2);
                this.amd.clear();
                Runnable c40533 = new Runnable(this) {
                    final /* synthetic */ ru amo;

                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            this.amo.m13466e((v) it.next());
                        }
                        arrayList2.clear();
                        this.amo.amg.remove(arrayList2);
                    }
                };
                if (i4 == 0 && i == 0 && i2 == 0) {
                    c40533.run();
                    return;
                }
                long qy;
                long qB;
                long qA = i4 != 0 ? qA() : 0;
                if (i != 0) {
                    qy = qy();
                } else {
                    qy = 0;
                }
                if (i2 != 0) {
                    qB = qB();
                } else {
                    qB = 0;
                }
                li.a(((v) arrayList2.get(0)).arT, c40533, qA + Math.max(qy, qB));
            }
        }
    }

    public boolean mo4095b(v vVar) {
        m13458g(vVar);
        this.amc.add(vVar);
        return true;
    }

    private void m13457c(final v vVar) {
        final lz ae = li.ae(vVar.arT);
        this.aml.add(vVar);
        ae.n(qA()).y(0.0f).a(new C4054c(this) {
            final /* synthetic */ ru amo;

            public void mo4090e(View view) {
                this.amo.m13432H(vVar);
            }

            public void mo4091f(View view) {
                ae.a(null);
                li.g(view, 1.0f);
                this.amo.m13429E(vVar);
                this.amo.aml.remove(vVar);
                this.amo.oN();
            }
        }).start();
    }

    public boolean mo4096d(v vVar) {
        m13458g(vVar);
        li.g(vVar.arT, 0.0f);
        this.amd.add(vVar);
        return true;
    }

    void m13466e(final v vVar) {
        final lz ae = li.ae(vVar.arT);
        this.amj.add(vVar);
        ae.y(1.0f).n(qz()).a(new C4054c(this) {
            final /* synthetic */ ru amo;

            public void mo4090e(View view) {
                this.amo.m13434J(vVar);
            }

            public void aD(View view) {
                li.g(view, 1.0f);
            }

            public void mo4091f(View view) {
                ae.a(null);
                this.amo.m13431G(vVar);
                this.amo.amj.remove(vVar);
                this.amo.oN();
            }
        }).start();
    }

    public boolean mo4093a(v vVar, int i, int i2, int i3, int i4) {
        View view = vVar.arT;
        int Z = (int) (((float) i) + li.Z(vVar.arT));
        int aa = (int) (((float) i2) + li.aa(vVar.arT));
        m13458g(vVar);
        int i5 = i3 - Z;
        int i6 = i4 - aa;
        if (i5 == 0 && i6 == 0) {
            m13430F(vVar);
            return false;
        }
        if (i5 != 0) {
            li.e(view, (float) (-i5));
        }
        if (i6 != 0) {
            li.f(view, (float) (-i6));
        }
        this.ame.add(new C4061b(vVar, Z, aa, i3, i4));
        return true;
    }

    void m13463b(v vVar, int i, int i2, int i3, int i4) {
        View view = vVar.arT;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            li.ae(view).z(0.0f);
        }
        if (i6 != 0) {
            li.ae(view).A(0.0f);
        }
        final lz ae = li.ae(view);
        this.amk.add(vVar);
        final v vVar2 = vVar;
        ae.n(qy()).a(new C4054c(this) {
            final /* synthetic */ ru amo;

            public void mo4090e(View view) {
                this.amo.m13433I(vVar2);
            }

            public void aD(View view) {
                if (i5 != 0) {
                    li.e(view, 0.0f);
                }
                if (i6 != 0) {
                    li.f(view, 0.0f);
                }
            }

            public void mo4091f(View view) {
                ae.a(null);
                this.amo.m13430F(vVar2);
                this.amo.amk.remove(vVar2);
                this.amo.oN();
            }
        }).start();
    }

    public boolean mo4094a(v vVar, v vVar2, int i, int i2, int i3, int i4) {
        if (vVar == vVar2) {
            return mo4093a(vVar, i, i2, i3, i4);
        }
        float Z = li.Z(vVar.arT);
        float aa = li.aa(vVar.arT);
        float Q = li.Q(vVar.arT);
        m13458g(vVar);
        int i5 = (int) (((float) (i3 - i)) - Z);
        int i6 = (int) (((float) (i4 - i2)) - aa);
        li.e(vVar.arT, Z);
        li.f(vVar.arT, aa);
        li.g(vVar.arT, Q);
        if (vVar2 != null) {
            m13458g(vVar2);
            li.e(vVar2.arT, (float) (-i5));
            li.f(vVar2.arT, (float) (-i6));
            li.g(vVar2.arT, 0.0f);
        }
        this.amf.add(new C4060a(vVar, vVar2, i, i2, i3, i4));
        return true;
    }

    void m13459a(final C4060a c4060a) {
        View view = null;
        v vVar = c4060a.amz;
        View view2 = vVar == null ? null : vVar.arT;
        v vVar2 = c4060a.amA;
        if (vVar2 != null) {
            view = vVar2.arT;
        }
        if (view2 != null) {
            final lz n = li.ae(view2).n(qB());
            this.amm.add(c4060a.amz);
            n.z((float) (c4060a.amD - c4060a.amB));
            n.A((float) (c4060a.amE - c4060a.amC));
            n.y(0.0f).a(new C4054c(this) {
                final /* synthetic */ ru amo;

                public void mo4090e(View view) {
                    this.amo.m13446d(c4060a.amz, true);
                }

                public void mo4091f(View view) {
                    n.a(null);
                    li.g(view, 1.0f);
                    li.e(view, 0.0f);
                    li.f(view, 0.0f);
                    this.amo.m13445c(c4060a.amz, true);
                    this.amo.amm.remove(c4060a.amz);
                    this.amo.oN();
                }
            }).start();
        }
        if (view != null) {
            n = li.ae(view);
            this.amm.add(c4060a.amA);
            n.z(0.0f).A(0.0f).n(qB()).y(1.0f).a(new C4054c(this) {
                final /* synthetic */ ru amo;

                public void mo4090e(View view) {
                    this.amo.m13446d(c4060a.amA, false);
                }

                public void mo4091f(View view) {
                    n.a(null);
                    li.g(view, 1.0f);
                    li.e(view, 0.0f);
                    li.f(view, 0.0f);
                    this.amo.m13445c(c4060a.amA, false);
                    this.amo.amm.remove(c4060a.amA);
                    this.amo.oN();
                }
            }).start();
        }
    }

    private void m13454a(List<C4060a> list, v vVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C4060a c4060a = (C4060a) list.get(size);
            if (m13455a(c4060a, vVar) && c4060a.amz == null && c4060a.amA == null) {
                list.remove(c4060a);
            }
        }
    }

    private void m13456b(C4060a c4060a) {
        if (c4060a.amz != null) {
            m13455a(c4060a, c4060a.amz);
        }
        if (c4060a.amA != null) {
            m13455a(c4060a, c4060a.amA);
        }
    }

    private boolean m13455a(C4060a c4060a, v vVar) {
        boolean z = false;
        if (c4060a.amA == vVar) {
            c4060a.amA = null;
        } else if (c4060a.amz != vVar) {
            return false;
        } else {
            c4060a.amz = null;
            z = true;
        }
        li.g(vVar.arT, 1.0f);
        li.e(vVar.arT, 0.0f);
        li.f(vVar.arT, 0.0f);
        m13445c(vVar, z);
        return true;
    }

    public void m13467f(v vVar) {
        int size;
        View view = vVar.arT;
        li.ae(view).cancel();
        for (size = this.ame.size() - 1; size >= 0; size--) {
            if (((C4061b) this.ame.get(size)).amF == vVar) {
                li.f(view, 0.0f);
                li.e(view, 0.0f);
                m13430F(vVar);
                this.ame.remove(size);
            }
        }
        m13454a(this.amf, vVar);
        if (this.amc.remove(vVar)) {
            li.g(view, 1.0f);
            m13429E(vVar);
        }
        if (this.amd.remove(vVar)) {
            li.g(view, 1.0f);
            m13431G(vVar);
        }
        for (size = this.ami.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.ami.get(size);
            m13454a(list, vVar);
            if (list.isEmpty()) {
                this.ami.remove(size);
            }
        }
        for (int size2 = this.amh.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.amh.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((C4061b) arrayList.get(size3)).amF == vVar) {
                    li.f(view, 0.0f);
                    li.e(view, 0.0f);
                    m13430F(vVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.amh.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.amg.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.amg.get(size);
            if (arrayList.remove(vVar)) {
                li.g(view, 1.0f);
                m13431G(vVar);
                if (arrayList.isEmpty()) {
                    this.amg.remove(size);
                }
            }
        }
        if (this.aml.remove(vVar)) {
        }
        if (this.amj.remove(vVar)) {
        }
        if (this.amm.remove(vVar)) {
        }
        if (this.amk.remove(vVar)) {
            oN();
        } else {
            oN();
        }
    }

    private void m13458g(v vVar) {
        dz.F(vVar.arT);
        m13467f(vVar);
    }

    public boolean isRunning() {
        return (this.amd.isEmpty() && this.amf.isEmpty() && this.ame.isEmpty() && this.amc.isEmpty() && this.amk.isEmpty() && this.aml.isEmpty() && this.amj.isEmpty() && this.amm.isEmpty() && this.amh.isEmpty() && this.amg.isEmpty() && this.ami.isEmpty()) ? false : true;
    }

    void oN() {
        if (!isRunning()) {
            qC();
        }
    }

    public void oO() {
        int size;
        for (size = this.ame.size() - 1; size >= 0; size--) {
            C4061b c4061b = (C4061b) this.ame.get(size);
            View view = c4061b.amF.arT;
            li.f(view, 0.0f);
            li.e(view, 0.0f);
            m13430F(c4061b.amF);
            this.ame.remove(size);
        }
        for (size = this.amc.size() - 1; size >= 0; size--) {
            m13429E((v) this.amc.get(size));
            this.amc.remove(size);
        }
        for (size = this.amd.size() - 1; size >= 0; size--) {
            v vVar = (v) this.amd.get(size);
            li.g(vVar.arT, 1.0f);
            m13431G(vVar);
            this.amd.remove(size);
        }
        for (size = this.amf.size() - 1; size >= 0; size--) {
            m13456b((C4060a) this.amf.get(size));
        }
        this.amf.clear();
        if (isRunning()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.amh.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.amh.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C4061b c4061b2 = (C4061b) arrayList.get(size3);
                    View view2 = c4061b2.amF.arT;
                    li.f(view2, 0.0f);
                    li.e(view2, 0.0f);
                    m13430F(c4061b2.amF);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.amh.remove(arrayList);
                    }
                }
            }
            for (size2 = this.amg.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.amg.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    v vVar2 = (v) arrayList.get(size3);
                    li.g(vVar2.arT, 1.0f);
                    m13431G(vVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.amg.remove(arrayList);
                    }
                }
            }
            for (size2 = this.ami.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.ami.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    m13456b((C4060a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.ami.remove(arrayList);
                    }
                }
            }
            m13468r(this.aml);
            m13468r(this.amk);
            m13468r(this.amj);
            m13468r(this.amm);
            qC();
        }
    }

    void m13468r(List<v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            li.ae(((v) list.get(size)).arT).cancel();
        }
    }

    public boolean m13462a(v vVar, List<Object> list) {
        return !list.isEmpty() || super.a(vVar, list);
    }
}
