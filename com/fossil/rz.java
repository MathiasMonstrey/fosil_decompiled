package com.fossil;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.h.a;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.v;
import com.misfit.frameworks.buttonservice.ButtonService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public final class rz implements Runnable {
    public static final ThreadLocal<rz> amY = new ThreadLocal();
    static Comparator<C4068b> and = new C40661();
    ArrayList<RecyclerView> amZ = new ArrayList();
    long ana;
    public long anb;
    private ArrayList<C4068b> anc = new ArrayList();

    static class C40661 implements Comparator<C4068b> {
        C40661() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m13477a((C4068b) obj, (C4068b) obj2);
        }

        public int m13477a(C4068b c4068b, C4068b c4068b2) {
            int i = -1;
            if ((c4068b.ank == null ? 1 : 0) != (c4068b2.ank == null ? 1 : 0)) {
                return c4068b.ank == null ? 1 : -1;
            } else {
                if (c4068b.anh != c4068b2.anh) {
                    if (!c4068b.anh) {
                        i = 1;
                    }
                    return i;
                }
                int i2 = c4068b2.ani - c4068b.ani;
                if (i2 != 0) {
                    return i2;
                }
                i2 = c4068b.anj - c4068b2.anj;
                if (i2 == 0) {
                    return 0;
                }
                return i2;
            }
        }
    }

    public static class C4067a implements a {
        int ane;
        int anf;
        int[] ang;
        int mCount;

        void ac(int i, int i2) {
            this.ane = i;
            this.anf = i2;
        }

        void m13478a(RecyclerView recyclerView, boolean z) {
            this.mCount = 0;
            if (this.ang != null) {
                Arrays.fill(this.ang, -1);
            }
            h hVar = recyclerView.apC;
            if (recyclerView.apB != null && hVar != null && hVar.qF()) {
                if (z) {
                    if (!recyclerView.apv.ol()) {
                        hVar.a(recyclerView.apB.getItemCount(), this);
                    }
                } else if (!recyclerView.qu()) {
                    hVar.a(this.ane, this.anf, recyclerView.aqj, this);
                }
                if (this.mCount > hVar.aqS) {
                    hVar.aqS = this.mCount;
                    hVar.aqT = z;
                    recyclerView.apt.qS();
                }
            }
        }

        public void ad(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            } else {
                int i3 = this.mCount * 2;
                if (this.ang == null) {
                    this.ang = new int[4];
                    Arrays.fill(this.ang, -1);
                } else if (i3 >= this.ang.length) {
                    Object obj = this.ang;
                    this.ang = new int[(i3 * 2)];
                    System.arraycopy(obj, 0, this.ang, 0, obj.length);
                }
                this.ang[i3] = i;
                this.ang[i3 + 1] = i2;
                this.mCount++;
            }
        }

        public boolean cZ(int i) {
            if (this.ang == null) {
                return false;
            }
            int i2 = this.mCount * 2;
            for (int i3 = 0; i3 < i2; i3 += 2) {
                if (this.ang[i3] == i) {
                    return true;
                }
            }
            return false;
        }

        public void oU() {
            if (this.ang != null) {
                Arrays.fill(this.ang, -1);
            }
            this.mCount = 0;
        }
    }

    static class C4068b {
        public boolean anh;
        public int ani;
        public int anj;
        public RecyclerView ank;
        public int position;

        C4068b() {
        }

        public void clear() {
            this.anh = false;
            this.ani = 0;
            this.anj = 0;
            this.ank = null;
            this.position = 0;
        }
    }

    public void m13484a(RecyclerView recyclerView) {
        this.amZ.add(recyclerView);
    }

    public void m13486b(RecyclerView recyclerView) {
        this.amZ.remove(recyclerView);
    }

    public void m13485a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.ana == 0) {
            this.ana = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.aqi.ac(i, i2);
    }

    private void oT() {
        int size = this.amZ.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            RecyclerView recyclerView = (RecyclerView) this.amZ.get(i);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.aqi.m13478a(recyclerView, false);
                i3 = recyclerView.aqi.mCount + i2;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        this.anc.ensureCapacity(i2);
        boolean z = false;
        for (int i4 = 0; i4 < size; i4++) {
            recyclerView = (RecyclerView) this.amZ.get(i4);
            if (recyclerView.getWindowVisibility() == 0) {
                C4067a c4067a = recyclerView.aqi;
                int abs = Math.abs(c4067a.ane) + Math.abs(c4067a.anf);
                boolean z2 = z;
                for (i = 0; i < c4067a.mCount * 2; i += 2) {
                    C4068b c4068b;
                    boolean z3;
                    if (z2 >= this.anc.size()) {
                        c4068b = new C4068b();
                        this.anc.add(c4068b);
                    } else {
                        c4068b = (C4068b) this.anc.get(z2);
                    }
                    int i5 = c4067a.ang[i + 1];
                    if (i5 <= abs) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    c4068b.anh = z3;
                    c4068b.ani = abs;
                    c4068b.anj = i5;
                    c4068b.ank = recyclerView;
                    c4068b.position = c4067a.ang[i];
                    z2++;
                }
                z = z2;
            }
        }
        Collections.sort(this.anc, and);
    }

    static boolean m13482a(RecyclerView recyclerView, int i) {
        int oH = recyclerView.apw.oH();
        for (int i2 = 0; i2 < oH; i2++) {
            v bU = RecyclerView.bU(recyclerView.apw.cW(i2));
            if (bU.BO == i && !bU.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private v m13479a(RecyclerView recyclerView, int i, long j) {
        if (m13482a(recyclerView, i)) {
            return null;
        }
        n nVar = recyclerView.apt;
        try {
            recyclerView.pZ();
            v a = nVar.a(i, false, j);
            if (a != null) {
                if (!a.isBound() || a.isInvalid()) {
                    nVar.a(a, false);
                } else {
                    nVar.cu(a.arT);
                }
            }
            recyclerView.aq(false);
            return a;
        } catch (Throwable th) {
            recyclerView.aq(false);
        }
    }

    private void m13480a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.apQ && recyclerView.apw.oH() != 0) {
                recyclerView.pL();
            }
            C4067a c4067a = recyclerView.aqi;
            c4067a.m13478a(recyclerView, true);
            if (c4067a.mCount != 0) {
                try {
                    jc.beginSection("RV Nested Prefetch");
                    recyclerView.aqj.b(recyclerView.apB);
                    for (int i = 0; i < c4067a.mCount * 2; i += 2) {
                        m13479a(recyclerView, c4067a.ang[i], j);
                    }
                } finally {
                    jc.endSection();
                }
            }
        }
    }

    private void m13481a(C4068b c4068b, long j) {
        v a = m13479a(c4068b.ank, c4068b.position, c4068b.anh ? ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD : j);
        if (a != null && a.arU != null && a.isBound() && !a.isInvalid()) {
            m13480a((RecyclerView) a.arU.get(), j);
        }
    }

    private void m13483r(long j) {
        int i = 0;
        while (i < this.anc.size()) {
            C4068b c4068b = (C4068b) this.anc.get(i);
            if (c4068b.ank != null) {
                m13481a(c4068b, j);
                c4068b.clear();
                i++;
            } else {
                return;
            }
        }
    }

    void m13487s(long j) {
        oT();
        m13483r(j);
    }

    public void run() {
        try {
            jc.beginSection("RV Prefetch");
            if (!this.amZ.isEmpty()) {
                int size = this.amZ.size();
                int i = 0;
                long j = 0;
                while (i < size) {
                    long max;
                    RecyclerView recyclerView = (RecyclerView) this.amZ.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        max = Math.max(recyclerView.getDrawingTime(), j);
                    } else {
                        max = j;
                    }
                    i++;
                    j = max;
                }
                if (j == 0) {
                    this.ana = 0;
                    jc.endSection();
                    return;
                }
                m13487s(TimeUnit.MILLISECONDS.toNanos(j) + this.anb);
                this.ana = 0;
                jc.endSection();
            }
        } finally {
            this.ana = 0;
            jc.endSection();
        }
    }
}
