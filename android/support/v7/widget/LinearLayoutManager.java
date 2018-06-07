package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView.C1221h;
import android.support.v7.widget.RecyclerView.C1221h.C1246a;
import android.support.v7.widget.RecyclerView.C1221h.C1247b;
import android.support.v7.widget.RecyclerView.C1254n;
import android.support.v7.widget.RecyclerView.C1260r;
import android.support.v7.widget.RecyclerView.C1260r.C1222b;
import android.support.v7.widget.RecyclerView.C1261s;
import android.support.v7.widget.RecyclerView.C1264v;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.fossil.mj;
import com.fossil.mx;
import com.fossil.sb;
import com.fossil.sf;
import com.fossil.sm;
import com.fossil.tc.d;
import java.util.List;

public class LinearLayoutManager extends C1221h implements C1222b, d {
    private C1225c anG;
    sf anH;
    private boolean anI;
    private boolean anJ;
    boolean anK;
    private boolean anL;
    private boolean anM;
    int anN;
    int anO;
    private boolean anP;
    C1227d anQ;
    final C1223a anR;
    private final C1224b anS;
    private int anT;
    int mOrientation;

    class C1223a {
        int BO;
        int anU;
        boolean anV;
        boolean anW;
        final /* synthetic */ LinearLayoutManager anX;

        C1223a(LinearLayoutManager linearLayoutManager) {
            this.anX = linearLayoutManager;
            reset();
        }

        void reset() {
            this.BO = -1;
            this.anU = Integer.MIN_VALUE;
            this.anV = false;
            this.anW = false;
        }

        void pr() {
            int pG;
            if (this.anV) {
                pG = this.anX.anH.pG();
            } else {
                pG = this.anX.anH.pF();
            }
            this.anU = pG;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.BO + ", mCoordinate=" + this.anU + ", mLayoutFromEnd=" + this.anV + ", mValid=" + this.anW + '}';
        }

        boolean m2383a(View view, C1261s c1261s) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return !layoutParams.qP() && layoutParams.qR() >= 0 && layoutParams.qR() < c1261s.getItemCount();
        }

        public void bG(View view) {
            int pE = this.anX.anH.pE();
            if (pE >= 0) {
                bH(view);
                return;
            }
            this.BO = this.anX.ce(view);
            int bO;
            if (this.anV) {
                pE = (this.anX.anH.pG() - pE) - this.anX.anH.bL(view);
                this.anU = this.anX.anH.pG() - pE;
                if (pE > 0) {
                    bO = this.anU - this.anX.anH.bO(view);
                    int pF = this.anX.anH.pF();
                    bO -= pF + Math.min(this.anX.anH.bK(view) - pF, 0);
                    if (bO < 0) {
                        this.anU = Math.min(pE, -bO) + this.anU;
                        return;
                    }
                    return;
                }
                return;
            }
            bO = this.anX.anH.bK(view);
            pF = bO - this.anX.anH.pF();
            this.anU = bO;
            if (pF > 0) {
                pE = (this.anX.anH.pG() - Math.min(0, (this.anX.anH.pG() - pE) - this.anX.anH.bL(view))) - (bO + this.anX.anH.bO(view));
                if (pE < 0) {
                    this.anU -= Math.min(pF, -pE);
                }
            }
        }

        public void bH(View view) {
            if (this.anV) {
                this.anU = this.anX.anH.bL(view) + this.anX.anH.pE();
            } else {
                this.anU = this.anX.anH.bK(view);
            }
            this.BO = this.anX.ce(view);
        }
    }

    public static class C1224b {
        public boolean aeb;
        public boolean aec;
        public int anY;
        public boolean anZ;

        protected C1224b() {
        }

        void ps() {
            this.anY = 0;
            this.aeb = false;
            this.anZ = false;
            this.aec = false;
        }
    }

    static class C1225c {
        int Qz;
        int anA;
        int anB;
        boolean anF;
        boolean anx = true;
        int any;
        int anz;
        int aoa;
        int aob = 0;
        boolean aoc = false;
        int aod;
        List<C1264v> aoe = null;

        C1225c() {
        }

        boolean m2385b(C1261s c1261s) {
            return this.anz >= 0 && this.anz < c1261s.getItemCount();
        }

        View m2384a(C1254n c1254n) {
            if (this.aoe != null) {
                return pt();
            }
            View dz = c1254n.dz(this.anz);
            this.anz += this.anA;
            return dz;
        }

        private View pt() {
            int size = this.aoe.size();
            for (int i = 0; i < size; i++) {
                View view = ((C1264v) this.aoe.get(i)).arT;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (!layoutParams.qP() && this.anz == layoutParams.qR()) {
                    bI(view);
                    return view;
                }
            }
            return null;
        }

        public void pu() {
            bI(null);
        }

        public void bI(View view) {
            View bJ = bJ(view);
            if (bJ == null) {
                this.anz = -1;
            } else {
                this.anz = ((LayoutParams) bJ.getLayoutParams()).qR();
            }
        }

        public View bJ(View view) {
            int size = this.aoe.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < size) {
                int i3;
                View view3;
                View view4 = ((C1264v) this.aoe.get(i2)).arT;
                LayoutParams layoutParams = (LayoutParams) view4.getLayoutParams();
                if (view4 != view) {
                    if (layoutParams.qP()) {
                        i3 = i;
                        view3 = view2;
                    } else {
                        i3 = (layoutParams.qR() - this.anz) * this.anA;
                        if (i3 < 0) {
                            i3 = i;
                            view3 = view2;
                        } else if (i3 < i) {
                            if (i3 == 0) {
                                return view4;
                            }
                            view3 = view4;
                        }
                    }
                    i2++;
                    view2 = view3;
                    i = i3;
                }
                i3 = i;
                view3 = view2;
                i2++;
                view2 = view3;
                i = i3;
            }
            return view2;
        }
    }

    public static class C1227d implements Parcelable {
        public static final Creator<C1227d> CREATOR = new C12261();
        int aof;
        int aog;
        boolean aoh;

        static class C12261 implements Creator<C1227d> {
            C12261() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2386w(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return di(i);
            }

            public C1227d m2386w(Parcel parcel) {
                return new C1227d(parcel);
            }

            public C1227d[] di(int i) {
                return new C1227d[i];
            }
        }

        C1227d(Parcel parcel) {
            boolean z = true;
            this.aof = parcel.readInt();
            this.aog = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.aoh = z;
        }

        public C1227d(C1227d c1227d) {
            this.aof = c1227d.aof;
            this.aog = c1227d.aog;
            this.aoh = c1227d.aoh;
        }

        boolean pv() {
            return this.aof >= 0;
        }

        void pw() {
            this.aof = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.aof);
            parcel.writeInt(this.aog);
            parcel.writeInt(this.aoh ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.anJ = false;
        this.anK = false;
        this.anL = false;
        this.anM = true;
        this.anN = -1;
        this.anO = Integer.MIN_VALUE;
        this.anQ = null;
        this.anR = new C1223a(this);
        this.anS = new C1224b();
        this.anT = 2;
        setOrientation(i);
        am(z);
        ar(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.anJ = false;
        this.anK = false;
        this.anL = false;
        this.anM = true;
        this.anN = -1;
        this.anO = Integer.MIN_VALUE;
        this.anQ = null;
        this.anR = new C1223a(this);
        this.anS = new C1224b();
        this.anT = 2;
        C1247b b = C1221h.m2226b(context, attributeSet, i, i2);
        setOrientation(b.orientation);
        am(b.aqX);
        al(b.aqY);
        ar(true);
    }

    public LayoutParams oX() {
        return new LayoutParams(-2, -2);
    }

    public void mo128a(RecyclerView recyclerView, C1254n c1254n) {
        super.mo128a(recyclerView, c1254n);
        if (this.anP) {
            m2282d(c1254n);
            c1254n.clear();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            mx a = mj.m12457a(accessibilityEvent);
            a.setFromIndex(po());
            a.setToIndex(pq());
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.anQ != null) {
            return new C1227d(this.anQ);
        }
        Parcelable c1227d = new C1227d();
        if (getChildCount() > 0) {
            pi();
            boolean z = this.anI ^ this.anK;
            c1227d.aoh = z;
            View pn;
            if (z) {
                pn = pn();
                c1227d.aog = this.anH.pG() - this.anH.bL(pn);
                c1227d.aof = ce(pn);
                return c1227d;
            }
            pn = pm();
            c1227d.aof = ce(pn);
            c1227d.aog = this.anH.bK(pn) - this.anH.pF();
            return c1227d;
        }
        c1227d.pw();
        return c1227d;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1227d) {
            this.anQ = (C1227d) parcelable;
            requestLayout();
        }
    }

    public boolean pe() {
        return this.mOrientation == 0;
    }

    public boolean pf() {
        return this.mOrientation == 1;
    }

    public void al(boolean z) {
        ae(null);
        if (this.anL != z) {
            this.anL = z;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            ae(null);
            if (i != this.mOrientation) {
                this.mOrientation = i;
                this.anH = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    private void pg() {
        boolean z = true;
        if (this.mOrientation == 1 || !ph()) {
            this.anK = this.anJ;
            return;
        }
        if (this.anJ) {
            z = false;
        }
        this.anK = z;
    }

    public void am(boolean z) {
        ae(null);
        if (z != this.anJ) {
            this.anJ = z;
            requestLayout();
        }
    }

    public View de(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int ce = i - ce(getChildAt(0));
        if (ce >= 0 && ce < childCount) {
            View childAt = getChildAt(ce);
            if (ce(childAt) == i) {
                return childAt;
            }
        }
        return super.de(i);
    }

    public int m2344c(C1261s c1261s) {
        if (c1261s.re()) {
            return this.anH.pH();
        }
        return 0;
    }

    public void mo129a(RecyclerView recyclerView, C1261s c1261s, int i) {
        C1260r sbVar = new sb(recyclerView.getContext());
        sbVar.dE(i);
        m2247a(sbVar);
    }

    public PointF df(int i) {
        int i2 = 1;
        boolean z = false;
        if (getChildCount() == 0) {
            return null;
        }
        if (i < ce(getChildAt(0))) {
            z = true;
        }
        if (z != this.anK) {
            i2 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public void mo132c(C1254n c1254n, C1261s c1261s) {
        int i = -1;
        if (!(this.anQ == null && this.anN == -1) && c1261s.getItemCount() == 0) {
            m2282d(c1254n);
            return;
        }
        int i2;
        int pG;
        if (this.anQ != null && this.anQ.pv()) {
            this.anN = this.anQ.aof;
        }
        pi();
        this.anG.anx = false;
        pg();
        if (!(this.anR.anW && this.anN == -1 && this.anQ == null)) {
            this.anR.reset();
            this.anR.anV = this.anK ^ this.anL;
            m2309a(c1254n, c1261s, this.anR);
            this.anR.anW = true;
        }
        int c = m2344c(c1261s);
        if (this.anG.aod >= 0) {
            i2 = 0;
        } else {
            i2 = c;
            c = 0;
        }
        i2 += this.anH.pF();
        c += this.anH.getEndPadding();
        if (!(!c1261s.rb() || this.anN == -1 || this.anO == Integer.MIN_VALUE)) {
            View de = de(this.anN);
            if (de != null) {
                if (this.anK) {
                    pG = (this.anH.pG() - this.anH.bL(de)) - this.anO;
                } else {
                    pG = this.anO - (this.anH.bK(de) - this.anH.pF());
                }
                if (pG > 0) {
                    i2 += pG;
                } else {
                    c -= pG;
                }
            }
        }
        if (this.anR.anV) {
            if (this.anK) {
                i = 1;
            }
        } else if (!this.anK) {
            i = 1;
        }
        mo153a(c1254n, c1261s, this.anR, i);
        m2267b(c1254n);
        this.anG.anF = pk();
        this.anG.aoc = c1261s.rb();
        if (this.anR.anV) {
            m2312b(this.anR);
            this.anG.aob = i2;
            m2329a(c1254n, this.anG, c1261s, false);
            i2 = this.anG.Qz;
            pG = this.anG.anz;
            if (this.anG.any > 0) {
                c += this.anG.any;
            }
            m2304a(this.anR);
            this.anG.aob = c;
            C1225c c1225c = this.anG;
            c1225c.anz += this.anG.anA;
            m2329a(c1254n, this.anG, c1261s, false);
            i = this.anG.Qz;
            if (this.anG.any > 0) {
                c = this.anG.any;
                aj(pG, i2);
                this.anG.aob = c;
                m2329a(c1254n, this.anG, c1261s, false);
                c = this.anG.Qz;
            } else {
                c = i2;
            }
            i2 = c;
            c = i;
        } else {
            m2304a(this.anR);
            this.anG.aob = c;
            m2329a(c1254n, this.anG, c1261s, false);
            c = this.anG.Qz;
            i = this.anG.anz;
            if (this.anG.any > 0) {
                i2 += this.anG.any;
            }
            m2312b(this.anR);
            this.anG.aob = i2;
            C1225c c1225c2 = this.anG;
            c1225c2.anz += this.anG.anA;
            m2329a(c1254n, this.anG, c1261s, false);
            i2 = this.anG.Qz;
            if (this.anG.any > 0) {
                pG = this.anG.any;
                ai(i, c);
                this.anG.aob = pG;
                m2329a(c1254n, this.anG, c1261s, false);
                c = this.anG.Qz;
            }
        }
        if (getChildCount() > 0) {
            int b;
            if ((this.anK ^ this.anL) != 0) {
                i = m2302a(c, c1254n, c1261s, true);
                i2 += i;
                c += i;
                b = m2311b(i2, c1254n, c1261s, false);
                i2 += b;
                c += b;
            } else {
                i = m2311b(i2, c1254n, c1261s, true);
                i2 += i;
                c += i;
                b = m2302a(c, c1254n, c1261s, false);
                i2 += b;
                c += b;
            }
        }
        m2308a(c1254n, c1261s, i2, c);
        if (c1261s.rb()) {
            this.anR.reset();
        } else {
            this.anH.pD();
        }
        this.anI = this.anL;
    }

    public void mo127a(C1261s c1261s) {
        super.mo127a(c1261s);
        this.anQ = null;
        this.anN = -1;
        this.anO = Integer.MIN_VALUE;
        this.anR.reset();
    }

    void mo153a(C1254n c1254n, C1261s c1261s, C1223a c1223a, int i) {
    }

    private void m2308a(C1254n c1254n, C1261s c1261s, int i, int i2) {
        if (c1261s.rc() && getChildCount() != 0 && !c1261s.rb() && pa()) {
            int i3 = 0;
            int i4 = 0;
            List qT = c1254n.qT();
            int size = qT.size();
            int ce = ce(getChildAt(0));
            int i5 = 0;
            while (i5 < size) {
                int i6;
                int i7;
                C1264v c1264v = (C1264v) qT.get(i5);
                if (c1264v.isRemoved()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((c1264v.rl() < ce) != this.anK ? -1 : 1) == -1) {
                        i7 = this.anH.bO(c1264v.arT) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.anH.bO(c1264v.arT) + i4;
                        i7 = i3;
                    }
                }
                i5++;
                i3 = i7;
                i4 = i6;
            }
            this.anG.aoe = qT;
            if (i3 > 0) {
                aj(ce(pm()), i);
                this.anG.aob = i3;
                this.anG.any = 0;
                this.anG.pu();
                m2329a(c1254n, this.anG, c1261s, false);
            }
            if (i4 > 0) {
                ai(ce(pn()), i2);
                this.anG.aob = i4;
                this.anG.any = 0;
                this.anG.pu();
                m2329a(c1254n, this.anG, c1261s, false);
            }
            this.anG.aoe = null;
        }
    }

    private void m2309a(C1254n c1254n, C1261s c1261s, C1223a c1223a) {
        if (!m2310a(c1261s, c1223a) && !m2314b(c1254n, c1261s, c1223a)) {
            c1223a.pr();
            c1223a.BO = this.anL ? c1261s.getItemCount() - 1 : 0;
        }
    }

    private boolean m2314b(C1254n c1254n, C1261s c1261s, C1223a c1223a) {
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && c1223a.m2383a(focusedChild, c1261s)) {
            c1223a.bG(focusedChild);
            return true;
        } else if (this.anI != this.anL) {
            return false;
        } else {
            if (c1223a.anV) {
                focusedChild = m2315d(c1254n, c1261s);
            } else {
                focusedChild = m2316e(c1254n, c1261s);
            }
            if (focusedChild == null) {
                return false;
            }
            c1223a.bH(focusedChild);
            if (!c1261s.rb() && pa()) {
                if (this.anH.bK(focusedChild) >= this.anH.pG() || this.anH.bL(focusedChild) < this.anH.pF()) {
                    z = true;
                }
                if (z) {
                    int pG;
                    if (c1223a.anV) {
                        pG = this.anH.pG();
                    } else {
                        pG = this.anH.pF();
                    }
                    c1223a.anU = pG;
                }
            }
            return true;
        }
    }

    private boolean m2310a(C1261s c1261s, C1223a c1223a) {
        boolean z = false;
        if (c1261s.rb() || this.anN == -1) {
            return false;
        }
        if (this.anN < 0 || this.anN >= c1261s.getItemCount()) {
            this.anN = -1;
            this.anO = Integer.MIN_VALUE;
            return false;
        }
        c1223a.BO = this.anN;
        if (this.anQ != null && this.anQ.pv()) {
            c1223a.anV = this.anQ.aoh;
            if (c1223a.anV) {
                c1223a.anU = this.anH.pG() - this.anQ.aog;
                return true;
            }
            c1223a.anU = this.anH.pF() + this.anQ.aog;
            return true;
        } else if (this.anO == Integer.MIN_VALUE) {
            View de = de(this.anN);
            if (de == null) {
                if (getChildCount() > 0) {
                    boolean z2;
                    if (this.anN < ce(getChildAt(0))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 == this.anK) {
                        z = true;
                    }
                    c1223a.anV = z;
                }
                c1223a.pr();
                return true;
            } else if (this.anH.bO(de) > this.anH.pH()) {
                c1223a.pr();
                return true;
            } else if (this.anH.bK(de) - this.anH.pF() < 0) {
                c1223a.anU = this.anH.pF();
                c1223a.anV = false;
                return true;
            } else if (this.anH.pG() - this.anH.bL(de) < 0) {
                c1223a.anU = this.anH.pG();
                c1223a.anV = true;
                return true;
            } else {
                int bL;
                if (c1223a.anV) {
                    bL = this.anH.bL(de) + this.anH.pE();
                } else {
                    bL = this.anH.bK(de);
                }
                c1223a.anU = bL;
                return true;
            }
        } else {
            c1223a.anV = this.anK;
            if (this.anK) {
                c1223a.anU = this.anH.pG() - this.anO;
                return true;
            }
            c1223a.anU = this.anH.pF() + this.anO;
            return true;
        }
    }

    private int m2302a(int i, C1254n c1254n, C1261s c1261s, boolean z) {
        int pG = this.anH.pG() - i;
        if (pG <= 0) {
            return 0;
        }
        pG = -m2343c(-pG, c1254n, c1261s);
        int i2 = i + pG;
        if (!z) {
            return pG;
        }
        i2 = this.anH.pG() - i2;
        if (i2 <= 0) {
            return pG;
        }
        this.anH.dl(i2);
        return pG + i2;
    }

    private int m2311b(int i, C1254n c1254n, C1261s c1261s, boolean z) {
        int pF = i - this.anH.pF();
        if (pF <= 0) {
            return 0;
        }
        pF = -m2343c(pF, c1254n, c1261s);
        int i2 = i + pF;
        if (!z) {
            return pF;
        }
        i2 -= this.anH.pF();
        if (i2 <= 0) {
            return pF;
        }
        this.anH.dl(-i2);
        return pF - i2;
    }

    private void m2304a(C1223a c1223a) {
        ai(c1223a.BO, c1223a.anU);
    }

    private void ai(int i, int i2) {
        this.anG.any = this.anH.pG() - i2;
        this.anG.anA = this.anK ? -1 : 1;
        this.anG.anz = i;
        this.anG.anB = 1;
        this.anG.Qz = i2;
        this.anG.aoa = Integer.MIN_VALUE;
    }

    private void m2312b(C1223a c1223a) {
        aj(c1223a.BO, c1223a.anU);
    }

    private void aj(int i, int i2) {
        this.anG.any = i2 - this.anH.pF();
        this.anG.anz = i;
        this.anG.anA = this.anK ? 1 : -1;
        this.anG.anB = -1;
        this.anG.Qz = i2;
        this.anG.aoa = Integer.MIN_VALUE;
    }

    protected boolean ph() {
        return getLayoutDirection() == 1;
    }

    void pi() {
        if (this.anG == null) {
            this.anG = pj();
        }
        if (this.anH == null) {
            this.anH = sf.a(this, this.mOrientation);
        }
    }

    C1225c pj() {
        return new C1225c();
    }

    public void dg(int i) {
        this.anN = i;
        this.anO = Integer.MIN_VALUE;
        if (this.anQ != null) {
            this.anQ.pw();
        }
        requestLayout();
    }

    public void ak(int i, int i2) {
        this.anN = i;
        this.anO = i2;
        if (this.anQ != null) {
            this.anQ.pw();
        }
        requestLayout();
    }

    public int mo123a(int i, C1254n c1254n, C1261s c1261s) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return m2343c(i, c1254n, c1261s);
    }

    public int mo131b(int i, C1254n c1254n, C1261s c1261s) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return m2343c(i, c1254n, c1261s);
    }

    public int mo133d(C1261s c1261s) {
        return m2323j(c1261s);
    }

    public int mo137e(C1261s c1261s) {
        return m2323j(c1261s);
    }

    public int mo138f(C1261s c1261s) {
        return m2325k(c1261s);
    }

    public int mo139g(C1261s c1261s) {
        return m2325k(c1261s);
    }

    public int mo140h(C1261s c1261s) {
        return m2327l(c1261s);
    }

    public int mo141i(C1261s c1261s) {
        return m2327l(c1261s);
    }

    private int m2323j(C1261s c1261s) {
        boolean z = false;
        if (getChildCount() == 0) {
            return 0;
        }
        pi();
        sf sfVar = this.anH;
        View g = m2319g(!this.anM, true);
        if (!this.anM) {
            z = true;
        }
        return sm.a(c1261s, sfVar, g, m2321h(z, true), this, this.anM, this.anK);
    }

    private int m2325k(C1261s c1261s) {
        boolean z = false;
        if (getChildCount() == 0) {
            return 0;
        }
        pi();
        sf sfVar = this.anH;
        View g = m2319g(!this.anM, true);
        if (!this.anM) {
            z = true;
        }
        return sm.a(c1261s, sfVar, g, m2321h(z, true), this, this.anM);
    }

    private int m2327l(C1261s c1261s) {
        boolean z = false;
        if (getChildCount() == 0) {
            return 0;
        }
        pi();
        sf sfVar = this.anH;
        View g = m2319g(!this.anM, true);
        if (!this.anM) {
            z = true;
        }
        return sm.b(c1261s, sfVar, g, m2321h(z, true), this, this.anM);
    }

    private void m2303a(int i, int i2, boolean z, C1261s c1261s) {
        int i3 = -1;
        int i4 = 1;
        this.anG.anF = pk();
        this.anG.aob = m2344c(c1261s);
        this.anG.anB = i;
        View pn;
        C1225c c1225c;
        if (i == 1) {
            C1225c c1225c2 = this.anG;
            c1225c2.aob += this.anH.getEndPadding();
            pn = pn();
            c1225c = this.anG;
            if (!this.anK) {
                i3 = 1;
            }
            c1225c.anA = i3;
            this.anG.anz = ce(pn) + this.anG.anA;
            this.anG.Qz = this.anH.bL(pn);
            i3 = this.anH.bL(pn) - this.anH.pG();
        } else {
            pn = pm();
            c1225c = this.anG;
            c1225c.aob += this.anH.pF();
            c1225c = this.anG;
            if (!this.anK) {
                i4 = -1;
            }
            c1225c.anA = i4;
            this.anG.anz = ce(pn) + this.anG.anA;
            this.anG.Qz = this.anH.bK(pn);
            i3 = (-this.anH.bK(pn)) + this.anH.pF();
        }
        this.anG.any = i2;
        if (z) {
            C1225c c1225c3 = this.anG;
            c1225c3.any -= i3;
        }
        this.anG.aoa = i3;
    }

    boolean pk() {
        return this.anH.getMode() == 0 && this.anH.getEnd() == 0;
    }

    void mo156a(C1261s c1261s, C1225c c1225c, C1246a c1246a) {
        int i = c1225c.anz;
        if (i >= 0 && i < c1261s.getItemCount()) {
            c1246a.ad(i, Math.max(0, c1225c.aoa));
        }
    }

    public void mo126a(int i, C1246a c1246a) {
        int i2;
        boolean z;
        if (this.anQ == null || !this.anQ.pv()) {
            pg();
            boolean z2 = this.anK;
            if (this.anN == -1) {
                i2 = z2 ? i - 1 : 0;
                z = z2;
            } else {
                i2 = this.anN;
                z = z2;
            }
        } else {
            z = this.anQ.aoh;
            i2 = this.anQ.aof;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.anT && i2 >= 0 && i2 < i; i4++) {
            c1246a.ad(i2, 0);
            i2 += i3;
        }
    }

    public void mo125a(int i, int i2, C1261s c1261s, C1246a c1246a) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            m2303a(i > 0 ? 1 : -1, Math.abs(i), true, c1261s);
            mo156a(c1261s, this.anG, c1246a);
        }
    }

    int m2343c(int i, C1254n c1254n, C1261s c1261s) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.anG.anx = true;
        pi();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m2303a(i2, abs, true, c1261s);
        int a = this.anG.aoa + m2329a(c1254n, this.anG, c1261s, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.anH.dl(-i);
        this.anG.aod = i;
        return i;
    }

    public void ae(String str) {
        if (this.anQ == null) {
            super.ae(str);
        }
    }

    private void m2306a(C1254n c1254n, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    m2241a(i3, c1254n);
                }
                return;
            }
            while (i > i2) {
                m2241a(i, c1254n);
                i--;
            }
        }
    }

    private void m2305a(C1254n c1254n, int i) {
        if (i >= 0) {
            int childCount = getChildCount();
            int i2;
            if (this.anK) {
                for (i2 = childCount - 1; i2 >= 0; i2--) {
                    View childAt = getChildAt(i2);
                    if (this.anH.bL(childAt) > i || this.anH.bM(childAt) > i) {
                        m2306a(c1254n, childCount - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < childCount; i2++) {
                View childAt2 = getChildAt(i2);
                if (this.anH.bL(childAt2) > i || this.anH.bM(childAt2) > i) {
                    m2306a(c1254n, 0, i2);
                    return;
                }
            }
        }
    }

    private void m2313b(C1254n c1254n, int i) {
        int childCount = getChildCount();
        if (i >= 0) {
            int end = this.anH.getEnd() - i;
            int i2;
            if (this.anK) {
                for (i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (this.anH.bK(childAt) < end || this.anH.bN(childAt) < end) {
                        m2306a(c1254n, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt2 = getChildAt(i2);
                if (this.anH.bK(childAt2) < end || this.anH.bN(childAt2) < end) {
                    m2306a(c1254n, childCount - 1, i2);
                    return;
                }
            }
        }
    }

    private void m2307a(C1254n c1254n, C1225c c1225c) {
        if (c1225c.anx && !c1225c.anF) {
            if (c1225c.anB == -1) {
                m2313b(c1254n, c1225c.aoa);
            } else {
                m2305a(c1254n, c1225c.aoa);
            }
        }
    }

    int m2329a(C1254n c1254n, C1225c c1225c, C1261s c1261s, boolean z) {
        int i = c1225c.any;
        if (c1225c.aoa != Integer.MIN_VALUE) {
            if (c1225c.any < 0) {
                c1225c.aoa += c1225c.any;
            }
            m2307a(c1254n, c1225c);
        }
        int i2 = c1225c.any + c1225c.aob;
        C1224b c1224b = this.anS;
        while (true) {
            if ((!c1225c.anF && i2 <= 0) || !c1225c.m2385b(c1261s)) {
                break;
            }
            c1224b.ps();
            mo154a(c1254n, c1261s, c1225c, c1224b);
            if (!c1224b.aeb) {
                c1225c.Qz += c1224b.anY * c1225c.anB;
                if (!(c1224b.anZ && this.anG.aoe == null && c1261s.rb())) {
                    c1225c.any -= c1224b.anY;
                    i2 -= c1224b.anY;
                }
                if (c1225c.aoa != Integer.MIN_VALUE) {
                    c1225c.aoa += c1224b.anY;
                    if (c1225c.any < 0) {
                        c1225c.aoa += c1225c.any;
                    }
                    m2307a(c1254n, c1225c);
                }
                if (z && c1224b.aec) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - c1225c.any;
    }

    void mo154a(C1254n c1254n, C1261s c1261s, C1225c c1225c, C1224b c1224b) {
        View a = c1225c.m2384a(c1254n);
        if (a == null) {
            c1224b.aeb = true;
            return;
        }
        int bP;
        int i;
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        if (c1225c.aoe == null) {
            if (this.anK == (c1225c.anB == -1)) {
                addView(a);
            } else {
                addView(a, 0);
            }
        } else {
            boolean z;
            boolean z2 = this.anK;
            if (c1225c.anB == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 == z) {
                cd(a);
            } else {
                m2233A(a, 0);
            }
        }
        m2298j(a, 0, 0);
        c1224b.anY = this.anH.bO(a);
        if (this.mOrientation == 1) {
            int width;
            if (ph()) {
                width = getWidth() - getPaddingRight();
                bP = width - this.anH.bP(a);
            } else {
                bP = getPaddingLeft();
                width = this.anH.bP(a) + bP;
            }
            if (c1225c.anB == -1) {
                i = c1225c.Qz;
                i2 = c1225c.Qz - c1224b.anY;
                i3 = width;
            } else {
                i2 = c1225c.Qz;
                i = c1224b.anY + c1225c.Qz;
                i3 = width;
            }
        } else {
            i2 = getPaddingTop();
            i = i2 + this.anH.bP(a);
            if (c1225c.anB == -1) {
                bP = c1225c.Qz - c1224b.anY;
                i3 = c1225c.Qz;
            } else {
                bP = c1225c.Qz;
                i3 = c1225c.Qz + c1224b.anY;
            }
        }
        m2294h(a, bP, i2, i3, i);
        if (layoutParams.qP() || layoutParams.qQ()) {
            c1224b.anZ = true;
        }
        c1224b.aec = a.hasFocusable();
    }

    boolean pl() {
        return (qI() == 1073741824 || qH() == 1073741824 || !qL()) ? false : true;
    }

    int dh(int i) {
        int i2 = Integer.MIN_VALUE;
        int i3 = 1;
        switch (i) {
            case 1:
                if (this.mOrientation == 1 || !ph()) {
                    return -1;
                }
                return 1;
            case 2:
                if (this.mOrientation == 1) {
                    return 1;
                }
                if (ph()) {
                    return -1;
                }
                return 1;
            case 17:
                if (this.mOrientation != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 33:
                if (this.mOrientation != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 66:
                if (this.mOrientation != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return i3;
            case 130:
                if (this.mOrientation == 1) {
                    i2 = 1;
                }
                return i2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View pm() {
        return getChildAt(this.anK ? getChildCount() - 1 : 0);
    }

    private View pn() {
        return getChildAt(this.anK ? 0 : getChildCount() - 1);
    }

    private View m2319g(boolean z, boolean z2) {
        if (this.anK) {
            return m2342b(getChildCount() - 1, -1, z, z2);
        }
        return m2342b(0, getChildCount(), z, z2);
    }

    private View m2321h(boolean z, boolean z2) {
        if (this.anK) {
            return m2342b(0, getChildCount(), z, z2);
        }
        return m2342b(getChildCount() - 1, -1, z, z2);
    }

    private View m2315d(C1254n c1254n, C1261s c1261s) {
        if (this.anK) {
            return m2317f(c1254n, c1261s);
        }
        return m2318g(c1254n, c1261s);
    }

    private View m2316e(C1254n c1254n, C1261s c1261s) {
        if (this.anK) {
            return m2318g(c1254n, c1261s);
        }
        return m2317f(c1254n, c1261s);
    }

    private View m2317f(C1254n c1254n, C1261s c1261s) {
        return mo151a(c1254n, c1261s, 0, getChildCount(), c1261s.getItemCount());
    }

    private View m2318g(C1254n c1254n, C1261s c1261s) {
        return mo151a(c1254n, c1261s, getChildCount() - 1, -1, c1261s.getItemCount());
    }

    View mo151a(C1254n c1254n, C1261s c1261s, int i, int i2, int i3) {
        View view = null;
        pi();
        int pF = this.anH.pF();
        int pG = this.anH.pG();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int ce = ce(childAt);
            if (ce >= 0 && ce < i3) {
                if (((LayoutParams) childAt.getLayoutParams()).qP()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                } else if (this.anH.bK(childAt) < pG && this.anH.bL(childAt) >= pF) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        childAt = view2;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                }
            }
            view3 = view;
            childAt = view2;
            i += i4;
            view = view3;
            view2 = childAt;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    private View m2320h(C1254n c1254n, C1261s c1261s) {
        if (this.anK) {
            return m2324j(c1254n, c1261s);
        }
        return m2326k(c1254n, c1261s);
    }

    private View m2322i(C1254n c1254n, C1261s c1261s) {
        if (this.anK) {
            return m2326k(c1254n, c1261s);
        }
        return m2324j(c1254n, c1261s);
    }

    private View m2324j(C1254n c1254n, C1261s c1261s) {
        return al(0, getChildCount());
    }

    private View m2326k(C1254n c1254n, C1261s c1261s) {
        return al(getChildCount() - 1, -1);
    }

    public int po() {
        View b = m2342b(0, getChildCount(), false, true);
        return b == null ? -1 : ce(b);
    }

    public int pp() {
        View b = m2342b(0, getChildCount(), true, false);
        return b == null ? -1 : ce(b);
    }

    public int pq() {
        View b = m2342b(getChildCount() - 1, -1, false, true);
        if (b == null) {
            return -1;
        }
        return ce(b);
    }

    View m2342b(int i, int i2, boolean z, boolean z2) {
        int i3;
        int i4 = 320;
        pi();
        if (z) {
            i3 = 24579;
        } else {
            i3 = 320;
        }
        if (!z2) {
            i4 = 0;
        }
        if (this.mOrientation == 0) {
            return this.aqL.o(i, i2, i3, i4);
        }
        return this.aqM.o(i, i2, i3, i4);
    }

    View al(int i, int i2) {
        pi();
        Object obj = i2 > i ? 1 : i2 < i ? -1 : null;
        if (obj == null) {
            return getChildAt(i);
        }
        int i3;
        int i4;
        if (this.anH.bK(getChildAt(i)) < this.anH.pF()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.aqL.o(i, i2, i3, i4);
        }
        return this.aqM.o(i, i2, i3, i4);
    }

    public View mo124a(View view, int i, C1254n c1254n, C1261s c1261s) {
        pg();
        if (getChildCount() == 0) {
            return null;
        }
        int dh = dh(i);
        if (dh == Integer.MIN_VALUE) {
            return null;
        }
        View i2;
        View pm;
        pi();
        pi();
        m2303a(dh, (int) (0.33333334f * ((float) this.anH.pH())), false, c1261s);
        this.anG.aoa = Integer.MIN_VALUE;
        this.anG.anx = false;
        m2329a(c1254n, this.anG, c1261s, true);
        if (dh == -1) {
            i2 = m2322i(c1254n, c1261s);
        } else {
            i2 = m2320h(c1254n, c1261s);
        }
        if (dh == -1) {
            pm = pm();
        } else {
            pm = pn();
        }
        if (!pm.hasFocusable()) {
            return i2;
        }
        if (i2 == null) {
            return null;
        }
        return pm;
    }

    public boolean pa() {
        return this.anQ == null && this.anI == this.anL;
    }

    public void m2340a(View view, View view2, int i, int i2) {
        ae("Cannot drop a view during a scroll or layout calculation");
        pi();
        pg();
        int ce = ce(view);
        int ce2 = ce(view2);
        if (ce < ce2) {
            Object obj = 1;
        } else {
            ce = -1;
        }
        if (this.anK) {
            if (obj == 1) {
                ak(ce2, this.anH.pG() - (this.anH.bK(view2) + this.anH.bO(view)));
            } else {
                ak(ce2, this.anH.pG() - this.anH.bL(view2));
            }
        } else if (obj == -1) {
            ak(ce2, this.anH.bK(view2));
        } else {
            ak(ce2, this.anH.bL(view2) - this.anH.bO(view));
        }
    }
}
