package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
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
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.fossil.mj;
import com.fossil.ml;
import com.fossil.ml.C3883n;
import com.fossil.mx;
import com.fossil.sa;
import com.fossil.sb;
import com.fossil.sf;
import com.fossil.sm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends C1221h implements C1222b {
    boolean anJ = false;
    boolean anK = false;
    private boolean anM = true;
    int anN = -1;
    int anO = Integer.MIN_VALUE;
    private int anm = -1;
    C1281d[] atj;
    sf atk;
    sf atl;
    private int atm;
    private final sa atn;
    private BitSet ato;
    C1278b atp = new C1278b();
    private int atq = 2;
    private boolean atr;
    private boolean ats;
    private C1280c att;
    private int atu;
    private final C1275a atv = new C1275a(this);
    private boolean atw = false;
    private int[] atx;
    private final Runnable aty = new C02361(this);
    private int mOrientation;
    private final Rect xL = new Rect();

    class C02361 implements Runnable {
        final /* synthetic */ StaggeredGridLayoutManager atz;

        C02361(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.atz = staggeredGridLayoutManager;
        }

        public void run() {
            this.atz.rT();
        }
    }

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        C1281d atC;
        boolean atD;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean sc() {
            return this.atD;
        }

        public final int pb() {
            if (this.atC == null) {
                return -1;
            }
            return this.atC.mIndex;
        }
    }

    class C1275a {
        int BO;
        int Qz;
        boolean anV;
        boolean anW;
        boolean atA;
        int[] atB;
        final /* synthetic */ StaggeredGridLayoutManager atz;

        public C1275a(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.atz = staggeredGridLayoutManager;
            reset();
        }

        void reset() {
            this.BO = -1;
            this.Qz = Integer.MIN_VALUE;
            this.anV = false;
            this.atA = false;
            this.anW = false;
            if (this.atB != null) {
                Arrays.fill(this.atB, -1);
            }
        }

        void m2513a(C1281d[] c1281dArr) {
            int length = c1281dArr.length;
            if (this.atB == null || this.atB.length < length) {
                this.atB = new int[this.atz.atj.length];
            }
            for (int i = 0; i < length; i++) {
                this.atB[i] = c1281dArr[i].eg(Integer.MIN_VALUE);
            }
        }

        void pr() {
            int pG;
            if (this.anV) {
                pG = this.atz.atk.pG();
            } else {
                pG = this.atz.atk.pF();
            }
            this.Qz = pG;
        }

        void dV(int i) {
            if (this.anV) {
                this.Qz = this.atz.atk.pG() - i;
            } else {
                this.Qz = this.atz.atk.pF() + i;
            }
        }
    }

    static class C1278b {
        List<C1277a> atE;
        int[] mData;

        static class C1277a implements Parcelable {
            public static final Creator<C1277a> CREATOR = new C12761();
            int BO;
            int atF;
            int[] atG;
            boolean atH;

            static class C12761 implements Creator<C1277a> {
                C12761() {
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return m2514x(parcel);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return ee(i);
                }

                public C1277a m2514x(Parcel parcel) {
                    return new C1277a(parcel);
                }

                public C1277a[] ee(int i) {
                    return new C1277a[i];
                }
            }

            public C1277a(Parcel parcel) {
                boolean z = true;
                this.BO = parcel.readInt();
                this.atF = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.atH = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.atG = new int[readInt];
                    parcel.readIntArray(this.atG);
                }
            }

            int ed(int i) {
                return this.atG == null ? 0 : this.atG[i];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.BO);
                parcel.writeInt(this.atF);
                parcel.writeInt(this.atH ? 1 : 0);
                if (this.atG == null || this.atG.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.atG.length);
                parcel.writeIntArray(this.atG);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.BO + ", mGapDir=" + this.atF + ", mHasUnwantedGapAfter=" + this.atH + ", mGapPerSpan=" + Arrays.toString(this.atG) + '}';
            }
        }

        C1278b() {
        }

        int dW(int i) {
            if (this.atE != null) {
                for (int size = this.atE.size() - 1; size >= 0; size--) {
                    if (((C1277a) this.atE.get(size)).BO >= i) {
                        this.atE.remove(size);
                    }
                }
            }
            return dX(i);
        }

        int dX(int i) {
            if (this.mData == null || i >= this.mData.length) {
                return -1;
            }
            int eb = eb(i);
            if (eb == -1) {
                Arrays.fill(this.mData, i, this.mData.length, -1);
                return this.mData.length;
            }
            Arrays.fill(this.mData, i, eb + 1, -1);
            return eb + 1;
        }

        int dY(int i) {
            if (this.mData == null || i >= this.mData.length) {
                return -1;
            }
            return this.mData[i];
        }

        void m2516a(int i, C1281d c1281d) {
            ea(i);
            this.mData[i] = c1281d.mIndex;
        }

        int dZ(int i) {
            int length = this.mData.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void ea(int i) {
            if (this.mData == null) {
                this.mData = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.mData, -1);
            } else if (i >= this.mData.length) {
                Object obj = this.mData;
                this.mData = new int[dZ(i)];
                System.arraycopy(obj, 0, this.mData, 0, obj.length);
                Arrays.fill(this.mData, obj.length, this.mData.length, -1);
            }
        }

        void clear() {
            if (this.mData != null) {
                Arrays.fill(this.mData, -1);
            }
            this.atE = null;
        }

        void aO(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                ea(i + i2);
                System.arraycopy(this.mData, i + i2, this.mData, i, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, this.mData.length - i2, this.mData.length, -1);
                aP(i, i2);
            }
        }

        private void aP(int i, int i2) {
            if (this.atE != null) {
                int i3 = i + i2;
                for (int size = this.atE.size() - 1; size >= 0; size--) {
                    C1277a c1277a = (C1277a) this.atE.get(size);
                    if (c1277a.BO >= i) {
                        if (c1277a.BO < i3) {
                            this.atE.remove(size);
                        } else {
                            c1277a.BO -= i2;
                        }
                    }
                }
            }
        }

        void aQ(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                ea(i + i2);
                System.arraycopy(this.mData, i, this.mData, i + i2, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, i, i + i2, -1);
                aR(i, i2);
            }
        }

        private void aR(int i, int i2) {
            if (this.atE != null) {
                for (int size = this.atE.size() - 1; size >= 0; size--) {
                    C1277a c1277a = (C1277a) this.atE.get(size);
                    if (c1277a.BO >= i) {
                        c1277a.BO += i2;
                    }
                }
            }
        }

        private int eb(int i) {
            if (this.atE == null) {
                return -1;
            }
            C1277a ec = ec(i);
            if (ec != null) {
                this.atE.remove(ec);
            }
            int size = this.atE.size();
            int i2 = 0;
            while (i2 < size) {
                if (((C1277a) this.atE.get(i2)).BO >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            ec = (C1277a) this.atE.get(i2);
            this.atE.remove(i2);
            return ec.BO;
        }

        public void m2517a(C1277a c1277a) {
            if (this.atE == null) {
                this.atE = new ArrayList();
            }
            int size = this.atE.size();
            for (int i = 0; i < size; i++) {
                C1277a c1277a2 = (C1277a) this.atE.get(i);
                if (c1277a2.BO == c1277a.BO) {
                    this.atE.remove(i);
                }
                if (c1277a2.BO >= c1277a.BO) {
                    this.atE.add(i, c1277a);
                    return;
                }
            }
            this.atE.add(c1277a);
        }

        public C1277a ec(int i) {
            if (this.atE == null) {
                return null;
            }
            for (int size = this.atE.size() - 1; size >= 0; size--) {
                C1277a c1277a = (C1277a) this.atE.get(size);
                if (c1277a.BO == i) {
                    return c1277a;
                }
            }
            return null;
        }

        public C1277a m2515a(int i, int i2, int i3, boolean z) {
            if (this.atE == null) {
                return null;
            }
            int size = this.atE.size();
            for (int i4 = 0; i4 < size; i4++) {
                C1277a c1277a = (C1277a) this.atE.get(i4);
                if (c1277a.BO >= i2) {
                    return null;
                }
                if (c1277a.BO >= i) {
                    if (i3 == 0 || c1277a.atF == i3) {
                        return c1277a;
                    }
                    if (z && c1277a.atH) {
                        return c1277a;
                    }
                }
            }
            return null;
        }
    }

    public static class C1280c implements Parcelable {
        public static final Creator<C1280c> CREATOR = new C12791();
        boolean anJ;
        int aof;
        boolean aoh;
        List<C1277a> atE;
        int atI;
        int atJ;
        int[] atK;
        int atL;
        int[] atM;
        boolean ats;

        static class C12791 implements Creator<C1280c> {
            C12791() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2518y(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return ef(i);
            }

            public C1280c m2518y(Parcel parcel) {
                return new C1280c(parcel);
            }

            public C1280c[] ef(int i) {
                return new C1280c[i];
            }
        }

        C1280c(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.aof = parcel.readInt();
            this.atI = parcel.readInt();
            this.atJ = parcel.readInt();
            if (this.atJ > 0) {
                this.atK = new int[this.atJ];
                parcel.readIntArray(this.atK);
            }
            this.atL = parcel.readInt();
            if (this.atL > 0) {
                this.atM = new int[this.atL];
                parcel.readIntArray(this.atM);
            }
            this.anJ = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.aoh = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.ats = z2;
            this.atE = parcel.readArrayList(C1277a.class.getClassLoader());
        }

        public C1280c(C1280c c1280c) {
            this.atJ = c1280c.atJ;
            this.aof = c1280c.aof;
            this.atI = c1280c.atI;
            this.atK = c1280c.atK;
            this.atL = c1280c.atL;
            this.atM = c1280c.atM;
            this.anJ = c1280c.anJ;
            this.aoh = c1280c.aoh;
            this.ats = c1280c.ats;
            this.atE = c1280c.atE;
        }

        void sd() {
            this.atK = null;
            this.atJ = 0;
            this.atL = 0;
            this.atM = null;
            this.atE = null;
        }

        void se() {
            this.atK = null;
            this.atJ = 0;
            this.aof = -1;
            this.atI = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeInt(this.aof);
            parcel.writeInt(this.atI);
            parcel.writeInt(this.atJ);
            if (this.atJ > 0) {
                parcel.writeIntArray(this.atK);
            }
            parcel.writeInt(this.atL);
            if (this.atL > 0) {
                parcel.writeIntArray(this.atM);
            }
            if (this.anJ) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.aoh) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.ats) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeList(this.atE);
        }
    }

    class C1281d {
        ArrayList<View> atN = new ArrayList();
        int atO = Integer.MIN_VALUE;
        int atP = Integer.MIN_VALUE;
        int atQ = 0;
        final /* synthetic */ StaggeredGridLayoutManager atz;
        final int mIndex;

        C1281d(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
            this.atz = staggeredGridLayoutManager;
            this.mIndex = i;
        }

        int eg(int i) {
            if (this.atO != Integer.MIN_VALUE) {
                return this.atO;
            }
            if (this.atN.size() == 0) {
                return i;
            }
            sf();
            return this.atO;
        }

        void sf() {
            View view = (View) this.atN.get(0);
            LayoutParams cC = cC(view);
            this.atO = this.atz.atk.bK(view);
            if (cC.atD) {
                C1277a ec = this.atz.atp.ec(cC.qR());
                if (ec != null && ec.atF == -1) {
                    this.atO -= ec.ed(this.mIndex);
                }
            }
        }

        int sg() {
            if (this.atO != Integer.MIN_VALUE) {
                return this.atO;
            }
            sf();
            return this.atO;
        }

        int eh(int i) {
            if (this.atP != Integer.MIN_VALUE) {
                return this.atP;
            }
            if (this.atN.size() == 0) {
                return i;
            }
            sh();
            return this.atP;
        }

        void sh() {
            View view = (View) this.atN.get(this.atN.size() - 1);
            LayoutParams cC = cC(view);
            this.atP = this.atz.atk.bL(view);
            if (cC.atD) {
                C1277a ec = this.atz.atp.ec(cC.qR());
                if (ec != null && ec.atF == 1) {
                    this.atP = ec.ed(this.mIndex) + this.atP;
                }
            }
        }

        int si() {
            if (this.atP != Integer.MIN_VALUE) {
                return this.atP;
            }
            sh();
            return this.atP;
        }

        void cA(View view) {
            LayoutParams cC = cC(view);
            cC.atC = this;
            this.atN.add(0, view);
            this.atO = Integer.MIN_VALUE;
            if (this.atN.size() == 1) {
                this.atP = Integer.MIN_VALUE;
            }
            if (cC.qP() || cC.qQ()) {
                this.atQ += this.atz.atk.bO(view);
            }
        }

        void cB(View view) {
            LayoutParams cC = cC(view);
            cC.atC = this;
            this.atN.add(view);
            this.atP = Integer.MIN_VALUE;
            if (this.atN.size() == 1) {
                this.atO = Integer.MIN_VALUE;
            }
            if (cC.qP() || cC.qQ()) {
                this.atQ += this.atz.atk.bO(view);
            }
        }

        void m2520b(boolean z, int i) {
            int eh;
            if (z) {
                eh = eh(Integer.MIN_VALUE);
            } else {
                eh = eg(Integer.MIN_VALUE);
            }
            clear();
            if (eh != Integer.MIN_VALUE) {
                if (z && eh < this.atz.atk.pG()) {
                    return;
                }
                if (z || eh <= this.atz.atk.pF()) {
                    if (i != Integer.MIN_VALUE) {
                        eh += i;
                    }
                    this.atP = eh;
                    this.atO = eh;
                }
            }
        }

        void clear() {
            this.atN.clear();
            sj();
            this.atQ = 0;
        }

        void sj() {
            this.atO = Integer.MIN_VALUE;
            this.atP = Integer.MIN_VALUE;
        }

        void ei(int i) {
            this.atO = i;
            this.atP = i;
        }

        void sk() {
            int size = this.atN.size();
            View view = (View) this.atN.remove(size - 1);
            LayoutParams cC = cC(view);
            cC.atC = null;
            if (cC.qP() || cC.qQ()) {
                this.atQ -= this.atz.atk.bO(view);
            }
            if (size == 1) {
                this.atO = Integer.MIN_VALUE;
            }
            this.atP = Integer.MIN_VALUE;
        }

        void sl() {
            View view = (View) this.atN.remove(0);
            LayoutParams cC = cC(view);
            cC.atC = null;
            if (this.atN.size() == 0) {
                this.atP = Integer.MIN_VALUE;
            }
            if (cC.qP() || cC.qQ()) {
                this.atQ -= this.atz.atk.bO(view);
            }
            this.atO = Integer.MIN_VALUE;
        }

        public int sm() {
            return this.atQ;
        }

        LayoutParams cC(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        void ej(int i) {
            if (this.atO != Integer.MIN_VALUE) {
                this.atO += i;
            }
            if (this.atP != Integer.MIN_VALUE) {
                this.atP += i;
            }
        }

        public int sn() {
            if (this.atz.anJ) {
                return m2521d(this.atN.size() - 1, -1, true);
            }
            return m2521d(0, this.atN.size(), true);
        }

        public int so() {
            if (this.atz.anJ) {
                return m2521d(0, this.atN.size(), true);
            }
            return m2521d(this.atN.size() - 1, -1, true);
        }

        int m2519a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int pF = this.atz.atk.pF();
            int pG = this.atz.atk.pG();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                Object obj;
                View view = (View) this.atN.get(i);
                int bK = this.atz.atk.bK(view);
                int bL = this.atz.atk.bL(view);
                if (z3) {
                    obj = bK <= pG ? 1 : null;
                } else if (bK < pG) {
                    int i4 = 1;
                } else {
                    obj = null;
                }
                Object obj2 = z3 ? bL >= pF ? 1 : null : bL > pF ? 1 : null;
                if (!(obj == null || r2 == null)) {
                    if (z && z2) {
                        if (bK >= pF && bL <= pG) {
                            return this.atz.ce(view);
                        }
                    } else if (z2) {
                        return this.atz.ce(view);
                    } else {
                        if (bK < pF || bL > pG) {
                            return this.atz.ce(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        int m2521d(int i, int i2, boolean z) {
            return m2519a(i, i2, false, false, z);
        }

        public View aS(int i, int i2) {
            View view = null;
            int i3;
            View view2;
            if (i2 == -1) {
                int size = this.atN.size();
                i3 = 0;
                while (i3 < size) {
                    view2 = (View) this.atN.get(i3);
                    if ((this.atz.anJ && this.atz.ce(view2) <= i) || ((!this.atz.anJ && this.atz.ce(view2) >= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            i3 = this.atN.size() - 1;
            while (i3 >= 0) {
                view2 = (View) this.atN.get(i3);
                if (this.atz.anJ && this.atz.ce(view2) >= i) {
                    break;
                } else if (this.atz.anJ || this.atz.ce(view2) > i) {
                    if (!view2.hasFocusable()) {
                        break;
                    }
                    i3--;
                    view = view2;
                } else {
                    return view;
                }
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        C1247b b = C1221h.m2226b(context, attributeSet, i, i2);
        setOrientation(b.orientation);
        db(b.spanCount);
        am(b.aqX);
        if (this.atq == 0) {
            z = false;
        }
        ar(z);
        this.atn = new sa();
        rS();
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.mOrientation = i2;
        db(i);
        if (this.atq == 0) {
            z = false;
        }
        ar(z);
        this.atn = new sa();
        rS();
    }

    private void rS() {
        this.atk = sf.a(this, this.mOrientation);
        this.atl = sf.a(this, 1 - this.mOrientation);
    }

    boolean rT() {
        if (getChildCount() == 0 || this.atq == 0 || !isAttachedToWindow()) {
            return false;
        }
        int sa;
        int sb;
        if (this.anK) {
            sa = sa();
            sb = sb();
        } else {
            sa = sb();
            sb = sa();
        }
        if (sa == 0 && rU() != null) {
            this.atp.clear();
            qK();
            requestLayout();
            return true;
        } else if (!this.atw) {
            return false;
        } else {
            int i = this.anK ? -1 : 1;
            C1277a a = this.atp.m2515a(sa, sb + 1, i, true);
            if (a == null) {
                this.atw = false;
                this.atp.dW(sb + 1);
                return false;
            }
            C1277a a2 = this.atp.m2515a(sa, a.BO, i * -1, true);
            if (a2 == null) {
                this.atp.dW(a.BO);
            } else {
                this.atp.dW(a2.BO + 1);
            }
            qK();
            requestLayout();
            return true;
        }
    }

    public void dq(int i) {
        if (i == 0) {
            rT();
        }
    }

    public void mo128a(RecyclerView recyclerView, C1254n c1254n) {
        removeCallbacks(this.aty);
        for (int i = 0; i < this.anm; i++) {
            this.atj[i].clear();
        }
        recyclerView.requestLayout();
    }

    View rU() {
        int i;
        int i2;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.anm);
        bitSet.set(0, this.anm, true);
        boolean z = (this.mOrientation == 1 && ph()) ? true : true;
        if (this.anK) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        if (childCount < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = childCount;
        while (i3 != i) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.atC.mIndex)) {
                if (m2532a(layoutParams.atC)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.atC.mIndex);
            }
            if (!(layoutParams.atD || i3 + i2 == i)) {
                boolean z2;
                View childAt2 = getChildAt(i3 + i2);
                int bL;
                if (this.anK) {
                    childCount = this.atk.bL(childAt);
                    bL = this.atk.bL(childAt2);
                    if (childCount < bL) {
                        return childAt;
                    }
                    if (childCount == bL) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    childCount = this.atk.bK(childAt);
                    bL = this.atk.bK(childAt2);
                    if (childCount > bL) {
                        return childAt;
                    }
                    if (childCount == bL) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if (layoutParams.atC.mIndex - ((LayoutParams) childAt2.getLayoutParams()).atC.mIndex < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 != (z >= false)) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    private boolean m2532a(C1281d c1281d) {
        boolean z = true;
        if (this.anK) {
            if (c1281d.si() < this.atk.pG()) {
                return !c1281d.cC((View) c1281d.atN.get(c1281d.atN.size() + -1)).atD;
            }
        } else if (c1281d.sg() > this.atk.pF()) {
            if (c1281d.cC((View) c1281d.atN.get(0)).atD) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void db(int i) {
        ae(null);
        if (i != this.anm) {
            rV();
            this.anm = i;
            this.ato = new BitSet(this.anm);
            this.atj = new C1281d[this.anm];
            for (int i2 = 0; i2 < this.anm; i2++) {
                this.atj[i2] = new C1281d(this, i2);
            }
            requestLayout();
        }
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            ae(null);
            if (i != this.mOrientation) {
                this.mOrientation = i;
                sf sfVar = this.atk;
                this.atk = this.atl;
                this.atl = sfVar;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void am(boolean z) {
        ae(null);
        if (!(this.att == null || this.att.anJ == z)) {
            this.att.anJ = z;
        }
        this.anJ = z;
        requestLayout();
    }

    public void ae(String str) {
        if (this.att == null) {
            super.ae(str);
        }
    }

    public void rV() {
        this.atp.clear();
        requestLayout();
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

    boolean ph() {
        return getLayoutDirection() == 1;
    }

    public void mo152a(Rect rect, int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            paddingTop = C1221h.m2231m(i2, paddingTop + rect.height(), getMinimumHeight());
            paddingRight = C1221h.m2231m(i, paddingRight + (this.atm * this.anm), getMinimumWidth());
        } else {
            paddingRight = C1221h.m2231m(i, paddingRight + rect.width(), getMinimumWidth());
            paddingTop = C1221h.m2231m(i2, paddingTop + (this.atm * this.anm), getMinimumHeight());
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    public void mo132c(C1254n c1254n, C1261s c1261s) {
        m2525a(c1254n, c1261s, true);
    }

    private void m2525a(C1254n c1254n, C1261s c1261s, boolean z) {
        C1275a c1275a = this.atv;
        if (!(this.att == null && this.anN == -1) && c1261s.getItemCount() == 0) {
            m2282d(c1254n);
            c1275a.reset();
            return;
        }
        boolean z2 = (c1275a.anW && this.anN == -1 && this.att == null) ? false : true;
        if (z2) {
            c1275a.reset();
            if (this.att != null) {
                m2527a(c1275a);
            } else {
                pg();
                c1275a.anV = this.anK;
            }
            m2550a(c1261s, c1275a);
            c1275a.anW = true;
        }
        if (this.att == null && this.anN == -1 && !(c1275a.anV == this.atr && ph() == this.ats)) {
            this.atp.clear();
            c1275a.atA = true;
        }
        if (getChildCount() > 0 && (this.att == null || this.att.atJ < 1)) {
            int i;
            if (c1275a.atA) {
                for (i = 0; i < this.anm; i++) {
                    this.atj[i].clear();
                    if (c1275a.Qz != Integer.MIN_VALUE) {
                        this.atj[i].ei(c1275a.Qz);
                    }
                }
            } else if (z2 || this.atv.atB == null) {
                for (i = 0; i < this.anm; i++) {
                    this.atj[i].m2520b(this.anK, c1275a.Qz);
                }
                this.atv.m2513a(this.atj);
            } else {
                for (i = 0; i < this.anm; i++) {
                    C1281d c1281d = this.atj[i];
                    c1281d.clear();
                    c1281d.ei(this.atv.atB[i]);
                }
            }
        }
        m2267b(c1254n);
        this.atn.anx = false;
        this.atw = false;
        dJ(this.atl.pH());
        m2524a(c1275a.BO, c1261s);
        if (c1275a.anV) {
            dK(-1);
            m2522a(c1254n, this.atn, c1261s);
            dK(1);
            this.atn.anz = c1275a.BO + this.atn.anA;
            m2522a(c1254n, this.atn, c1261s);
        } else {
            dK(1);
            m2522a(c1254n, this.atn, c1261s);
            dK(-1);
            this.atn.anz = c1275a.BO + this.atn.anA;
            m2522a(c1254n, this.atn, c1261s);
        }
        rW();
        if (getChildCount() > 0) {
            if (this.anK) {
                m2533b(c1254n, c1261s, true);
                m2536c(c1254n, c1261s, false);
            } else {
                m2536c(c1254n, c1261s, true);
                m2533b(c1254n, c1261s, false);
            }
        }
        if (z && !c1261s.rb()) {
            if (this.atq == 0 || getChildCount() <= 0 || (!this.atw && rU() == null)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                removeCallbacks(this.aty);
                if (rT()) {
                    z2 = true;
                    if (c1261s.rb()) {
                        this.atv.reset();
                    }
                    this.atr = c1275a.anV;
                    this.ats = ph();
                    if (z2) {
                        this.atv.reset();
                        m2525a(c1254n, c1261s, false);
                    }
                }
            }
        }
        z2 = false;
        if (c1261s.rb()) {
            this.atv.reset();
        }
        this.atr = c1275a.anV;
        this.ats = ph();
        if (z2) {
            this.atv.reset();
            m2525a(c1254n, c1261s, false);
        }
    }

    public void mo127a(C1261s c1261s) {
        super.mo127a(c1261s);
        this.anN = -1;
        this.anO = Integer.MIN_VALUE;
        this.att = null;
        this.atv.reset();
    }

    private void rW() {
        if (this.atl.getMode() != 1073741824) {
            float f = 0.0f;
            int childCount = getChildCount();
            int i = 0;
            while (i < childCount) {
                float f2;
                View childAt = getChildAt(i);
                float bO = (float) this.atl.bO(childAt);
                if (bO < f) {
                    f2 = f;
                } else {
                    if (((LayoutParams) childAt.getLayoutParams()).sc()) {
                        f2 = (1.0f * bO) / ((float) this.anm);
                    } else {
                        f2 = bO;
                    }
                    f2 = Math.max(f, f2);
                }
                i++;
                f = f2;
            }
            i = this.atm;
            int round = Math.round(((float) this.anm) * f);
            if (this.atl.getMode() == Integer.MIN_VALUE) {
                round = Math.min(round, this.atl.pH());
            }
            dJ(round);
            if (this.atm != i) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt2 = getChildAt(i2);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.atD) {
                        if (ph() && this.mOrientation == 1) {
                            childAt2.offsetLeftAndRight(((-((this.anm - 1) - layoutParams.atC.mIndex)) * this.atm) - ((-((this.anm - 1) - layoutParams.atC.mIndex)) * i));
                        } else {
                            int i3 = layoutParams.atC.mIndex * this.atm;
                            round = layoutParams.atC.mIndex * i;
                            if (this.mOrientation == 1) {
                                childAt2.offsetLeftAndRight(i3 - round);
                            } else {
                                childAt2.offsetTopAndBottom(i3 - round);
                            }
                        }
                    }
                }
            }
        }
    }

    private void m2527a(C1275a c1275a) {
        if (this.att.atJ > 0) {
            if (this.att.atJ == this.anm) {
                for (int i = 0; i < this.anm; i++) {
                    this.atj[i].clear();
                    int i2 = this.att.atK[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.att.aoh) {
                            i2 += this.atk.pG();
                        } else {
                            i2 += this.atk.pF();
                        }
                    }
                    this.atj[i].ei(i2);
                }
            } else {
                this.att.sd();
                this.att.aof = this.att.atI;
            }
        }
        this.ats = this.att.ats;
        am(this.att.anJ);
        pg();
        if (this.att.aof != -1) {
            this.anN = this.att.aof;
            c1275a.anV = this.att.aoh;
        } else {
            c1275a.anV = this.anK;
        }
        if (this.att.atL > 1) {
            this.atp.mData = this.att.atM;
            this.atp.atE = this.att.atE;
        }
    }

    void m2550a(C1261s c1261s, C1275a c1275a) {
        if (!m2564c(c1261s, c1275a) && !m2534b(c1261s, c1275a)) {
            c1275a.pr();
            c1275a.BO = 0;
        }
    }

    private boolean m2534b(C1261s c1261s, C1275a c1275a) {
        int dU;
        if (this.atr) {
            dU = dU(c1261s.getItemCount());
        } else {
            dU = dT(c1261s.getItemCount());
        }
        c1275a.BO = dU;
        c1275a.Qz = Integer.MIN_VALUE;
        return true;
    }

    boolean m2564c(C1261s c1261s, C1275a c1275a) {
        boolean z = false;
        if (c1261s.rb() || this.anN == -1) {
            return false;
        }
        if (this.anN < 0 || this.anN >= c1261s.getItemCount()) {
            this.anN = -1;
            this.anO = Integer.MIN_VALUE;
            return false;
        } else if (this.att == null || this.att.aof == -1 || this.att.atJ < 1) {
            View de = de(this.anN);
            if (de != null) {
                int sa;
                if (this.anK) {
                    sa = sa();
                } else {
                    sa = sb();
                }
                c1275a.BO = sa;
                if (this.anO != Integer.MIN_VALUE) {
                    if (c1275a.anV) {
                        c1275a.Qz = (this.atk.pG() - this.anO) - this.atk.bL(de);
                        return true;
                    }
                    c1275a.Qz = (this.atk.pF() + this.anO) - this.atk.bK(de);
                    return true;
                } else if (this.atk.bO(de) > this.atk.pH()) {
                    if (c1275a.anV) {
                        sa = this.atk.pG();
                    } else {
                        sa = this.atk.pF();
                    }
                    c1275a.Qz = sa;
                    return true;
                } else {
                    sa = this.atk.bK(de) - this.atk.pF();
                    if (sa < 0) {
                        c1275a.Qz = -sa;
                        return true;
                    }
                    sa = this.atk.pG() - this.atk.bL(de);
                    if (sa < 0) {
                        c1275a.Qz = sa;
                        return true;
                    }
                    c1275a.Qz = Integer.MIN_VALUE;
                    return true;
                }
            }
            c1275a.BO = this.anN;
            if (this.anO == Integer.MIN_VALUE) {
                if (dS(c1275a.BO) == 1) {
                    z = true;
                }
                c1275a.anV = z;
                c1275a.pr();
            } else {
                c1275a.dV(this.anO);
            }
            c1275a.atA = true;
            return true;
        } else {
            c1275a.Qz = Integer.MIN_VALUE;
            c1275a.BO = this.anN;
            return true;
        }
    }

    void dJ(int i) {
        this.atm = i / this.anm;
        this.atu = MeasureSpec.makeMeasureSpec(i, this.atl.getMode());
    }

    public boolean pa() {
        return this.att == null;
    }

    public int mo133d(C1261s c1261s) {
        return m2538j(c1261s);
    }

    private int m2538j(C1261s c1261s) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        sf sfVar = this.atk;
        View av = av(!this.anM);
        if (this.anM) {
            z = false;
        }
        return sm.a(c1261s, sfVar, av, aw(z), this, this.anM, this.anK);
    }

    public int mo137e(C1261s c1261s) {
        return m2538j(c1261s);
    }

    public int mo138f(C1261s c1261s) {
        return m2539k(c1261s);
    }

    private int m2539k(C1261s c1261s) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        sf sfVar = this.atk;
        View av = av(!this.anM);
        if (this.anM) {
            z = false;
        }
        return sm.a(c1261s, sfVar, av, aw(z), this, this.anM);
    }

    public int mo139g(C1261s c1261s) {
        return m2539k(c1261s);
    }

    public int mo140h(C1261s c1261s) {
        return m2540l(c1261s);
    }

    private int m2540l(C1261s c1261s) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        sf sfVar = this.atk;
        View av = av(!this.anM);
        if (this.anM) {
            z = false;
        }
        return sm.b(c1261s, sfVar, av, aw(z), this, this.anM);
    }

    public int mo141i(C1261s c1261s) {
        return m2540l(c1261s);
    }

    private void m2531a(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.atD) {
            if (this.mOrientation == 1) {
                m2529a(view, this.atu, C1221h.m2225b(getHeight(), qI(), 0, layoutParams.height, true), z);
            } else {
                m2529a(view, C1221h.m2225b(getWidth(), qH(), 0, layoutParams.width, true), this.atu, z);
            }
        } else if (this.mOrientation == 1) {
            m2529a(view, C1221h.m2225b(this.atm, qH(), 0, layoutParams.width, false), C1221h.m2225b(getHeight(), qI(), 0, layoutParams.height, true), z);
        } else {
            m2529a(view, C1221h.m2225b(getWidth(), qH(), 0, layoutParams.width, true), C1221h.m2225b(this.atm, qI(), 0, layoutParams.height, false), z);
        }
    }

    private void m2529a(View view, int i, int i2, boolean z) {
        boolean a;
        m2291g(view, this.xL);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int p = m2541p(i, layoutParams.leftMargin + this.xL.left, layoutParams.rightMargin + this.xL.right);
        int p2 = m2541p(i2, layoutParams.topMargin + this.xL.top, layoutParams.bottomMargin + this.xL.bottom);
        if (z) {
            a = m2262a(view, p, p2, (android.support.v7.widget.RecyclerView.LayoutParams) layoutParams);
        } else {
            a = m2275b(view, p, p2, (android.support.v7.widget.RecyclerView.LayoutParams) layoutParams);
        }
        if (a) {
            view.measure(p, p2);
        }
    }

    private int m2541p(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1280c) {
            this.att = (C1280c) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.att != null) {
            return new C1280c(this.att);
        }
        C1280c c1280c = new C1280c();
        c1280c.anJ = this.anJ;
        c1280c.aoh = this.atr;
        c1280c.ats = this.ats;
        if (this.atp == null || this.atp.mData == null) {
            c1280c.atL = 0;
        } else {
            c1280c.atM = this.atp.mData;
            c1280c.atL = c1280c.atM.length;
            c1280c.atE = this.atp.atE;
        }
        if (getChildCount() > 0) {
            int sa;
            if (this.atr) {
                sa = sa();
            } else {
                sa = sb();
            }
            c1280c.aof = sa;
            c1280c.atI = rX();
            c1280c.atJ = this.anm;
            c1280c.atK = new int[this.anm];
            for (sa = 0; sa < this.anm; sa++) {
                int eh;
                if (this.atr) {
                    eh = this.atj[sa].eh(Integer.MIN_VALUE);
                    if (eh != Integer.MIN_VALUE) {
                        eh -= this.atk.pG();
                    }
                } else {
                    eh = this.atj[sa].eg(Integer.MIN_VALUE);
                    if (eh != Integer.MIN_VALUE) {
                        eh -= this.atk.pF();
                    }
                }
                c1280c.atK[sa] = eh;
            }
        } else {
            c1280c.aof = -1;
            c1280c.atI = -1;
            c1280c.atJ = 0;
        }
        return c1280c;
    }

    public void mo155a(C1254n c1254n, C1261s c1261s, View view, ml mlVar) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.mOrientation == 0) {
                mlVar.aq(C3883n.m12567b(layoutParams2.pb(), layoutParams2.atD ? this.anm : 1, -1, -1, layoutParams2.atD, false));
                return;
            } else {
                mlVar.aq(C3883n.m12567b(-1, -1, layoutParams2.pb(), layoutParams2.atD ? this.anm : 1, layoutParams2.atD, false));
                return;
            }
        }
        super.m2271b(view, mlVar);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            mx a = mj.m12457a(accessibilityEvent);
            View av = av(false);
            View aw = aw(false);
            if (av != null && aw != null) {
                int ce = ce(av);
                int ce2 = ce(aw);
                if (ce < ce2) {
                    a.setFromIndex(ce);
                    a.setToIndex(ce2);
                    return;
                }
                a.setFromIndex(ce2);
                a.setToIndex(ce);
            }
        }
    }

    int rX() {
        View aw;
        if (this.anK) {
            aw = aw(true);
        } else {
            aw = av(true);
        }
        return aw == null ? -1 : ce(aw);
    }

    public int mo150a(C1254n c1254n, C1261s c1261s) {
        if (this.mOrientation == 0) {
            return this.anm;
        }
        return super.mo150a(c1254n, c1261s);
    }

    public int mo161b(C1254n c1254n, C1261s c1261s) {
        if (this.mOrientation == 1) {
            return this.anm;
        }
        return super.mo161b(c1254n, c1261s);
    }

    View av(boolean z) {
        int pF = this.atk.pF();
        int pG = this.atk.pG();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int bK = this.atk.bK(childAt);
            if (this.atk.bL(childAt) > pF && bK < pG) {
                if (bK >= pF || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    View aw(boolean z) {
        int pF = this.atk.pF();
        int pG = this.atk.pG();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int bK = this.atk.bK(childAt);
            int bL = this.atk.bL(childAt);
            if (bL > pF && bK < pG) {
                if (bL <= pG || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void m2533b(C1254n c1254n, C1261s c1261s, boolean z) {
        int dP = dP(Integer.MIN_VALUE);
        if (dP != Integer.MIN_VALUE) {
            dP = this.atk.pG() - dP;
            if (dP > 0) {
                dP -= -m2560c(-dP, c1254n, c1261s);
                if (z && dP > 0) {
                    this.atk.dl(dP);
                }
            }
        }
    }

    private void m2536c(C1254n c1254n, C1261s c1261s, boolean z) {
        int dO = dO(Integer.MAX_VALUE);
        if (dO != Integer.MAX_VALUE) {
            dO -= this.atk.pF();
            if (dO > 0) {
                dO -= m2560c(dO, c1254n, c1261s);
                if (z && dO > 0) {
                    this.atk.dl(-dO);
                }
            }
        }
    }

    private void m2524a(int i, C1261s c1261s) {
        int rd;
        int i2;
        sa saVar;
        boolean z = false;
        this.atn.any = 0;
        this.atn.anz = i;
        if (qG()) {
            rd = c1261s.rd();
            if (rd != -1) {
                if (this.anK == (rd < i)) {
                    rd = this.atk.pH();
                    i2 = 0;
                } else {
                    i2 = this.atk.pH();
                    rd = 0;
                }
                if (getClipToPadding()) {
                    this.atn.anD = rd + this.atk.getEnd();
                    this.atn.anC = -i2;
                } else {
                    this.atn.anC = this.atk.pF() - i2;
                    this.atn.anD = rd + this.atk.pG();
                }
                this.atn.anE = false;
                this.atn.anx = true;
                saVar = this.atn;
                if (this.atk.getMode() == 0 && this.atk.getEnd() == 0) {
                    z = true;
                }
                saVar.anF = z;
            }
        }
        rd = 0;
        i2 = 0;
        if (getClipToPadding()) {
            this.atn.anD = rd + this.atk.getEnd();
            this.atn.anC = -i2;
        } else {
            this.atn.anC = this.atk.pF() - i2;
            this.atn.anD = rd + this.atk.pG();
        }
        this.atn.anE = false;
        this.atn.anx = true;
        saVar = this.atn;
        z = true;
        saVar.anF = z;
    }

    private void dK(int i) {
        int i2 = 1;
        this.atn.anB = i;
        sa saVar = this.atn;
        if (this.anK != (i == -1)) {
            i2 = -1;
        }
        saVar.anA = i2;
    }

    public void dp(int i) {
        super.dp(i);
        for (int i2 = 0; i2 < this.anm; i2++) {
            this.atj[i2].ej(i);
        }
    }

    public void mo176do(int i) {
        super.mo176do(i);
        for (int i2 = 0; i2 < this.anm; i2++) {
            this.atj[i2].ej(i);
        }
    }

    public void mo164c(RecyclerView recyclerView, int i, int i2) {
        m2542q(i, i2, 2);
    }

    public void mo162b(RecyclerView recyclerView, int i, int i2) {
        m2542q(i, i2, 1);
    }

    public void mo163c(RecyclerView recyclerView) {
        this.atp.clear();
        requestLayout();
    }

    public void mo157a(RecyclerView recyclerView, int i, int i2, int i3) {
        m2542q(i, i2, 8);
    }

    public void mo158a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m2542q(i, i2, 4);
    }

    private void m2542q(int i, int i2, int i3) {
        int i4;
        int i5;
        int sa = this.anK ? sa() : sb();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.atp.dX(i5);
        switch (i3) {
            case 1:
                this.atp.aQ(i, i2);
                break;
            case 2:
                this.atp.aO(i, i2);
                break;
            case 8:
                this.atp.aO(i, 1);
                this.atp.aQ(i2, 1);
                break;
        }
        if (i4 > sa) {
            if (i5 <= (this.anK ? sb() : sa())) {
                requestLayout();
            }
        }
    }

    private int m2522a(C1254n c1254n, sa saVar, C1261s c1261s) {
        int i;
        int pG;
        int dP;
        this.ato.set(0, this.anm, true);
        if (this.atn.anF) {
            if (saVar.anB == 1) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.MIN_VALUE;
            }
        } else if (saVar.anB == 1) {
            i = saVar.anD + saVar.any;
        } else {
            i = saVar.anC - saVar.any;
        }
        aN(saVar.anB, i);
        if (this.anK) {
            pG = this.atk.pG();
        } else {
            pG = this.atk.pF();
        }
        Object obj = null;
        while (saVar.b(c1261s) && (this.atn.anF || !this.ato.isEmpty())) {
            C1281d c1281d;
            int bO;
            int bO2;
            View a = saVar.a(c1254n);
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            int qR = layoutParams.qR();
            int dY = this.atp.dY(qR);
            Object obj2 = dY == -1 ? 1 : null;
            if (obj2 != null) {
                C1281d a2 = layoutParams.atD ? this.atj[0] : m2523a(saVar);
                this.atp.m2516a(qR, a2);
                c1281d = a2;
            } else {
                c1281d = this.atj[dY];
            }
            layoutParams.atC = c1281d;
            if (saVar.anB == 1) {
                addView(a);
            } else {
                addView(a, 0);
            }
            m2531a(a, layoutParams, false);
            if (saVar.anB == 1) {
                if (layoutParams.atD) {
                    dP = dP(pG);
                } else {
                    dP = c1281d.eh(pG);
                }
                bO = dP + this.atk.bO(a);
                if (obj2 == null || !layoutParams.atD) {
                    dY = dP;
                } else {
                    C1277a dL = dL(dP);
                    dL.atF = -1;
                    dL.BO = qR;
                    this.atp.m2517a(dL);
                    dY = dP;
                }
            } else {
                if (layoutParams.atD) {
                    dP = dO(pG);
                } else {
                    dP = c1281d.eg(pG);
                }
                dY = dP - this.atk.bO(a);
                if (obj2 != null && layoutParams.atD) {
                    C1277a dM = dM(dP);
                    dM.atF = 1;
                    dM.BO = qR;
                    this.atp.m2517a(dM);
                }
                bO = dP;
            }
            if (layoutParams.atD && saVar.anA == -1) {
                if (obj2 != null) {
                    this.atw = true;
                } else {
                    obj = saVar.anB == 1 ? !rY() ? 1 : null : !rZ() ? 1 : null;
                    if (obj != null) {
                        C1277a ec = this.atp.ec(qR);
                        if (ec != null) {
                            ec.atH = true;
                        }
                        this.atw = true;
                    }
                }
            }
            m2530a(a, layoutParams, saVar);
            if (ph() && this.mOrientation == 1) {
                if (layoutParams.atD) {
                    dP = this.atl.pG();
                } else {
                    dP = this.atl.pG() - (((this.anm - 1) - c1281d.mIndex) * this.atm);
                }
                bO2 = dP - this.atl.bO(a);
                qR = dP;
            } else {
                if (layoutParams.atD) {
                    dP = this.atl.pF();
                } else {
                    dP = (c1281d.mIndex * this.atm) + this.atl.pF();
                }
                qR = dP + this.atl.bO(a);
                bO2 = dP;
            }
            if (this.mOrientation == 1) {
                m2294h(a, bO2, dY, qR, bO);
            } else {
                m2294h(a, dY, bO2, bO, qR);
            }
            if (layoutParams.atD) {
                aN(this.atn.anB, i);
            } else {
                m2528a(c1281d, this.atn.anB, i);
            }
            m2526a(c1254n, this.atn);
            if (this.atn.anE && a.hasFocusable()) {
                if (layoutParams.atD) {
                    this.ato.clear();
                } else {
                    this.ato.set(c1281d.mIndex, false);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            m2526a(c1254n, this.atn);
        }
        if (this.atn.anB == -1) {
            dP = this.atk.pF() - dO(this.atk.pF());
        } else {
            dP = dP(this.atk.pG()) - this.atk.pG();
        }
        return dP > 0 ? Math.min(saVar.any, dP) : 0;
    }

    private C1277a dL(int i) {
        C1277a c1277a = new C1277a();
        c1277a.atG = new int[this.anm];
        for (int i2 = 0; i2 < this.anm; i2++) {
            c1277a.atG[i2] = i - this.atj[i2].eh(i);
        }
        return c1277a;
    }

    private C1277a dM(int i) {
        C1277a c1277a = new C1277a();
        c1277a.atG = new int[this.anm];
        for (int i2 = 0; i2 < this.anm; i2++) {
            c1277a.atG[i2] = this.atj[i2].eg(i) - i;
        }
        return c1277a;
    }

    private void m2530a(View view, LayoutParams layoutParams, sa saVar) {
        if (saVar.anB == 1) {
            if (layoutParams.atD) {
                cy(view);
            } else {
                layoutParams.atC.cB(view);
            }
        } else if (layoutParams.atD) {
            cz(view);
        } else {
            layoutParams.atC.cA(view);
        }
    }

    private void m2526a(C1254n c1254n, sa saVar) {
        if (saVar.anx && !saVar.anF) {
            if (saVar.any == 0) {
                if (saVar.anB == -1) {
                    m2537d(c1254n, saVar.anD);
                } else {
                    m2535c(c1254n, saVar.anC);
                }
            } else if (saVar.anB == -1) {
                r0 = saVar.anC - dN(saVar.anC);
                if (r0 < 0) {
                    r0 = saVar.anD;
                } else {
                    r0 = saVar.anD - Math.min(r0, saVar.any);
                }
                m2537d(c1254n, r0);
            } else {
                r0 = dQ(saVar.anD) - saVar.anD;
                if (r0 < 0) {
                    r0 = saVar.anC;
                } else {
                    r0 = Math.min(r0, saVar.any) + saVar.anC;
                }
                m2535c(c1254n, r0);
            }
        }
    }

    private void cy(View view) {
        for (int i = this.anm - 1; i >= 0; i--) {
            this.atj[i].cB(view);
        }
    }

    private void cz(View view) {
        for (int i = this.anm - 1; i >= 0; i--) {
            this.atj[i].cA(view);
        }
    }

    private void aN(int i, int i2) {
        for (int i3 = 0; i3 < this.anm; i3++) {
            if (!this.atj[i3].atN.isEmpty()) {
                m2528a(this.atj[i3], i, i2);
            }
        }
    }

    private void m2528a(C1281d c1281d, int i, int i2) {
        int sm = c1281d.sm();
        if (i == -1) {
            if (sm + c1281d.sg() <= i2) {
                this.ato.set(c1281d.mIndex, false);
            }
        } else if (c1281d.si() - sm >= i2) {
            this.ato.set(c1281d.mIndex, false);
        }
    }

    private int dN(int i) {
        int eg = this.atj[0].eg(i);
        for (int i2 = 1; i2 < this.anm; i2++) {
            int eg2 = this.atj[i2].eg(i);
            if (eg2 > eg) {
                eg = eg2;
            }
        }
        return eg;
    }

    private int dO(int i) {
        int eg = this.atj[0].eg(i);
        for (int i2 = 1; i2 < this.anm; i2++) {
            int eg2 = this.atj[i2].eg(i);
            if (eg2 < eg) {
                eg = eg2;
            }
        }
        return eg;
    }

    boolean rY() {
        int eh = this.atj[0].eh(Integer.MIN_VALUE);
        for (int i = 1; i < this.anm; i++) {
            if (this.atj[i].eh(Integer.MIN_VALUE) != eh) {
                return false;
            }
        }
        return true;
    }

    boolean rZ() {
        int eg = this.atj[0].eg(Integer.MIN_VALUE);
        for (int i = 1; i < this.anm; i++) {
            if (this.atj[i].eg(Integer.MIN_VALUE) != eg) {
                return false;
            }
        }
        return true;
    }

    private int dP(int i) {
        int eh = this.atj[0].eh(i);
        for (int i2 = 1; i2 < this.anm; i2++) {
            int eh2 = this.atj[i2].eh(i);
            if (eh2 > eh) {
                eh = eh2;
            }
        }
        return eh;
    }

    private int dQ(int i) {
        int eh = this.atj[0].eh(i);
        for (int i2 = 1; i2 < this.anm; i2++) {
            int eh2 = this.atj[i2].eh(i);
            if (eh2 < eh) {
                eh = eh2;
            }
        }
        return eh;
    }

    private void m2535c(C1254n c1254n, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.atk.bL(childAt) <= i && this.atk.bM(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.atD) {
                    int i2 = 0;
                    while (i2 < this.anm) {
                        if (this.atj[i2].atN.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.anm; i2++) {
                        this.atj[i2].sl();
                    }
                } else if (layoutParams.atC.atN.size() != 1) {
                    layoutParams.atC.sl();
                } else {
                    return;
                }
                m2254a(childAt, c1254n);
            } else {
                return;
            }
        }
    }

    private void m2537d(C1254n c1254n, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.atk.bK(childAt) >= i && this.atk.bN(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.atD) {
                    int i2 = 0;
                    while (i2 < this.anm) {
                        if (this.atj[i2].atN.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.anm; i2++) {
                        this.atj[i2].sk();
                    }
                } else if (layoutParams.atC.atN.size() != 1) {
                    layoutParams.atC.sk();
                } else {
                    return;
                }
                m2254a(childAt, c1254n);
                childCount--;
            } else {
                return;
            }
        }
    }

    private boolean dR(int i) {
        if (this.mOrientation == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.anK) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.anK) != ph()) {
            return false;
        }
        return true;
    }

    private C1281d m2523a(sa saVar) {
        int i;
        int i2;
        C1281d c1281d = null;
        int i3 = -1;
        if (dR(saVar.anB)) {
            i = this.anm - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.anm;
            i3 = 1;
        }
        int pF;
        int i4;
        C1281d c1281d2;
        int eh;
        C1281d c1281d3;
        if (saVar.anB == 1) {
            pF = this.atk.pF();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                c1281d2 = this.atj[i4];
                eh = c1281d2.eh(pF);
                if (eh < i) {
                    c1281d3 = c1281d2;
                } else {
                    eh = i;
                    c1281d3 = c1281d;
                }
                i4 += i3;
                c1281d = c1281d3;
                i = eh;
            }
        } else {
            pF = this.atk.pG();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                c1281d2 = this.atj[i4];
                eh = c1281d2.eg(pF);
                if (eh > i) {
                    c1281d3 = c1281d2;
                } else {
                    eh = i;
                    c1281d3 = c1281d;
                }
                i4 += i3;
                c1281d = c1281d3;
                i = eh;
            }
        }
        return c1281d;
    }

    public boolean pf() {
        return this.mOrientation == 1;
    }

    public boolean pe() {
        return this.mOrientation == 0;
    }

    public int mo123a(int i, C1254n c1254n, C1261s c1261s) {
        return m2560c(i, c1254n, c1261s);
    }

    public int mo131b(int i, C1254n c1254n, C1261s c1261s) {
        return m2560c(i, c1254n, c1261s);
    }

    private int dS(int i) {
        int i2 = -1;
        if (getChildCount() != 0) {
            if ((i < sb()) == this.anK) {
                i2 = 1;
            }
            return i2;
        } else if (this.anK) {
            return 1;
        } else {
            return -1;
        }
    }

    public PointF df(int i) {
        int dS = dS(i);
        PointF pointF = new PointF();
        if (dS == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = (float) dS;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = (float) dS;
        return pointF;
    }

    public void mo129a(RecyclerView recyclerView, C1261s c1261s, int i) {
        C1260r sbVar = new sb(recyclerView.getContext());
        sbVar.dE(i);
        m2247a(sbVar);
    }

    public void dg(int i) {
        if (!(this.att == null || this.att.aof == i)) {
            this.att.se();
        }
        this.anN = i;
        this.anO = Integer.MIN_VALUE;
        requestLayout();
    }

    public void mo125a(int i, int i2, C1261s c1261s, C1246a c1246a) {
        int i3 = 0;
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            m2558b(i, c1261s);
            if (this.atx == null || this.atx.length < this.anm) {
                this.atx = new int[this.anm];
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.anm; i5++) {
                int eg;
                if (this.atn.anA == -1) {
                    eg = this.atn.anC - this.atj[i5].eg(this.atn.anC);
                } else {
                    eg = this.atj[i5].eh(this.atn.anD) - this.atn.anD;
                }
                if (eg >= 0) {
                    this.atx[i4] = eg;
                    i4++;
                }
            }
            Arrays.sort(this.atx, 0, i4);
            while (i3 < i4 && this.atn.b(c1261s)) {
                c1246a.ad(this.atn.anz, this.atx[i3]);
                sa saVar = this.atn;
                saVar.anz += this.atn.anA;
                i3++;
            }
        }
    }

    void m2558b(int i, C1261s c1261s) {
        int sa;
        int i2;
        if (i > 0) {
            sa = sa();
            i2 = 1;
        } else {
            i2 = -1;
            sa = sb();
        }
        this.atn.anx = true;
        m2524a(sa, c1261s);
        dK(i2);
        this.atn.anz = this.atn.anA + sa;
        this.atn.any = Math.abs(i);
    }

    int m2560c(int i, C1254n c1254n, C1261s c1261s) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        m2558b(i, c1261s);
        int a = m2522a(c1254n, this.atn, c1261s);
        if (this.atn.any >= a) {
            i = i < 0 ? -a : a;
        }
        this.atk.dl(-i);
        this.atr = this.anK;
        this.atn.any = 0;
        m2526a(c1254n, this.atn);
        return i;
    }

    int sa() {
        int childCount = getChildCount();
        return childCount == 0 ? 0 : ce(getChildAt(childCount - 1));
    }

    int sb() {
        if (getChildCount() == 0) {
            return 0;
        }
        return ce(getChildAt(0));
    }

    private int dT(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int ce = ce(getChildAt(i2));
            if (ce >= 0 && ce < i) {
                return ce;
            }
        }
        return 0;
    }

    private int dU(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int ce = ce(getChildAt(childCount));
            if (ce >= 0 && ce < i) {
                return ce;
            }
        }
        return 0;
    }

    public android.support.v7.widget.RecyclerView.LayoutParams oX() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams mo165d(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams mo166f(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean mo159a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public View mo124a(View view, int i, C1254n c1254n, C1261s c1261s) {
        int i2 = 0;
        if (getChildCount() == 0) {
            return null;
        }
        View bS = bS(view);
        if (bS == null) {
            return null;
        }
        pg();
        int dh = dh(i);
        if (dh == Integer.MIN_VALUE) {
            return null;
        }
        int sa;
        View aS;
        int i3;
        View de;
        LayoutParams layoutParams = (LayoutParams) bS.getLayoutParams();
        boolean z = layoutParams.atD;
        C1281d c1281d = layoutParams.atC;
        if (dh == 1) {
            sa = sa();
        } else {
            sa = sb();
        }
        m2524a(sa, c1261s);
        dK(dh);
        this.atn.anz = this.atn.anA + sa;
        this.atn.any = (int) (0.33333334f * ((float) this.atk.pH()));
        this.atn.anE = true;
        this.atn.anx = false;
        m2522a(c1254n, this.atn, c1261s);
        this.atr = this.anK;
        if (!z) {
            aS = c1281d.aS(sa, dh);
            if (!(aS == null || aS == bS)) {
                return aS;
            }
        }
        if (dR(dh)) {
            for (int i4 = this.anm - 1; i4 >= 0; i4--) {
                aS = this.atj[i4].aS(sa, dh);
                if (aS != null && aS != bS) {
                    return aS;
                }
            }
        } else {
            for (i3 = 0; i3 < this.anm; i3++) {
                View aS2 = this.atj[i3].aS(sa, dh);
                if (aS2 != null && aS2 != bS) {
                    return aS2;
                }
            }
        }
        boolean z2 = (!this.anJ) == (dh == -1);
        if (!z) {
            if (z2) {
                sa = c1281d.sn();
            } else {
                sa = c1281d.so();
            }
            de = de(sa);
            if (!(de == null || de == bS)) {
                return de;
            }
        }
        if (dR(dh)) {
            for (i3 = this.anm - 1; i3 >= 0; i3--) {
                if (i3 != c1281d.mIndex) {
                    if (z2) {
                        sa = this.atj[i3].sn();
                    } else {
                        sa = this.atj[i3].so();
                    }
                    de = de(sa);
                    if (!(de == null || de == bS)) {
                        return de;
                    }
                }
            }
        } else {
            while (i2 < this.anm) {
                if (z2) {
                    sa = this.atj[i2].sn();
                } else {
                    sa = this.atj[i2].so();
                }
                de = de(sa);
                if (de != null && de != bS) {
                    return de;
                }
                i2++;
            }
        }
        return null;
    }

    private int dh(int i) {
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
}
