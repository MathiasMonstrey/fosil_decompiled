package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager.C1223a;
import android.support.v7.widget.LinearLayoutManager.C1224b;
import android.support.v7.widget.LinearLayoutManager.C1225c;
import android.support.v7.widget.RecyclerView.C1221h;
import android.support.v7.widget.RecyclerView.C1221h.C1246a;
import android.support.v7.widget.RecyclerView.C1254n;
import android.support.v7.widget.RecyclerView.C1261s;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import com.fossil.ml;
import com.fossil.ml.C3883n;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean anl = false;
    int anm = -1;
    int[] ann;
    View[] ano;
    final SparseIntArray anp = new SparseIntArray();
    final SparseIntArray anq = new SparseIntArray();
    C1219b anr = new C1220a();
    final Rect ans = new Rect();

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        int ant = -1;
        int anu = 0;

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

        public int pb() {
            return this.ant;
        }

        public int pc() {
            return this.anu;
        }
    }

    public static abstract class C1219b {
        final SparseIntArray anv = new SparseIntArray();
        private boolean anw = false;

        public abstract int dc(int i);

        public void pd() {
            this.anv.clear();
        }

        int ag(int i, int i2) {
            if (!this.anw) {
                return af(i, i2);
            }
            int i3 = this.anv.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = af(i, i2);
            this.anv.put(i, i3);
            return i3;
        }

        public int af(int i, int i2) {
            int dc = dc(i);
            if (dc == i2) {
                return 0;
            }
            int dd;
            int dc2;
            int i3;
            if (this.anw && this.anv.size() > 0) {
                dd = dd(i);
                if (dd >= 0) {
                    dc2 = this.anv.get(dd) + dc(dd);
                    dd++;
                    i3 = dd;
                    while (i3 < i) {
                        dd = dc(i3);
                        dc2 += dd;
                        if (dc2 == i2) {
                            dd = 0;
                        } else if (dc2 <= i2) {
                            dd = dc2;
                        }
                        i3++;
                        dc2 = dd;
                    }
                    if (dc2 + dc > i2) {
                        return dc2;
                    }
                    return 0;
                }
            }
            dd = 0;
            dc2 = 0;
            i3 = dd;
            while (i3 < i) {
                dd = dc(i3);
                dc2 += dd;
                if (dc2 == i2) {
                    dd = 0;
                } else if (dc2 <= i2) {
                    dd = dc2;
                }
                i3++;
                dc2 = dd;
            }
            if (dc2 + dc > i2) {
                return 0;
            }
            return dc2;
        }

        int dd(int i) {
            int i2 = 0;
            int size = this.anv.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.anv.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            size = i2 - 1;
            if (size < 0 || size >= this.anv.size()) {
                return -1;
            }
            return this.anv.keyAt(size);
        }

        public int ah(int i, int i2) {
            int dc = dc(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int dc2 = dc(i3);
                i5 += dc2;
                if (i5 == i2) {
                    i4++;
                    dc2 = 0;
                } else if (i5 > i2) {
                    i4++;
                } else {
                    dc2 = i5;
                }
                i3++;
                i5 = dc2;
            }
            if (i5 + dc > i2) {
                return i4 + 1;
            }
            return i4;
        }
    }

    public static final class C1220a extends C1219b {
        public int dc(int i) {
            return 1;
        }

        public int af(int i, int i2) {
            return i % i2;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        db(C1221h.m2226b(context, attributeSet, i, i2).spanCount);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        db(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        db(i);
    }

    public void al(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.al(false);
    }

    public int mo150a(C1254n c1254n, C1261s c1261s) {
        if (this.mOrientation == 0) {
            return this.anm;
        }
        if (c1261s.getItemCount() < 1) {
            return 0;
        }
        return m2352a(c1254n, c1261s, c1261s.getItemCount() - 1) + 1;
    }

    public int mo161b(C1254n c1254n, C1261s c1261s) {
        if (this.mOrientation == 1) {
            return this.anm;
        }
        if (c1261s.getItemCount() < 1) {
            return 0;
        }
        return m2352a(c1254n, c1261s, c1261s.getItemCount() - 1) + 1;
    }

    public void mo155a(C1254n c1254n, C1261s c1261s, View view, ml mlVar) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = m2352a(c1254n, c1261s, layoutParams2.qR());
            if (this.mOrientation == 0) {
                int pb = layoutParams2.pb();
                int pc = layoutParams2.pc();
                boolean z = this.anm > 1 && layoutParams2.pc() == this.anm;
                mlVar.aq(C3883n.m12567b(pb, pc, a, 1, z, false));
                return;
            }
            int pb2 = layoutParams2.pb();
            int pc2 = layoutParams2.pc();
            boolean z2 = this.anm > 1 && layoutParams2.pc() == this.anm;
            mlVar.aq(C3883n.m12567b(a, 1, pb2, pc2, z2, false));
            return;
        }
        super.m2271b(view, mlVar);
    }

    public void mo132c(C1254n c1254n, C1261s c1261s) {
        if (c1261s.rb()) {
            oW();
        }
        super.mo132c(c1254n, c1261s);
        oV();
    }

    public void mo127a(C1261s c1261s) {
        super.mo127a(c1261s);
        this.anl = false;
    }

    private void oV() {
        this.anp.clear();
        this.anq.clear();
    }

    private void oW() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int qR = layoutParams.qR();
            this.anp.put(qR, layoutParams.pc());
            this.anq.put(qR, layoutParams.pb());
        }
    }

    public void mo162b(RecyclerView recyclerView, int i, int i2) {
        this.anr.pd();
    }

    public void mo163c(RecyclerView recyclerView) {
        this.anr.pd();
    }

    public void mo164c(RecyclerView recyclerView, int i, int i2) {
        this.anr.pd();
    }

    public void mo158a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.anr.pd();
    }

    public void mo157a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.anr.pd();
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

    public void m2366a(C1219b c1219b) {
        this.anr = c1219b;
    }

    private void oY() {
        int width;
        if (getOrientation() == 1) {
            width = (getWidth() - getPaddingRight()) - getPaddingLeft();
        } else {
            width = (getHeight() - getPaddingBottom()) - getPaddingTop();
        }
        da(width);
    }

    public void mo152a(Rect rect, int i, int i2) {
        if (this.ann == null) {
            super.mo152a(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            paddingTop = C1221h.m2231m(i2, paddingTop + rect.height(), getMinimumHeight());
            paddingRight = C1221h.m2231m(i, paddingRight + this.ann[this.ann.length - 1], getMinimumWidth());
        } else {
            paddingRight = C1221h.m2231m(i, paddingRight + rect.width(), getMinimumWidth());
            paddingTop = C1221h.m2231m(i2, paddingTop + this.ann[this.ann.length - 1], getMinimumHeight());
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    private void da(int i) {
        this.ann = m2360c(this.ann, this.anm, i);
    }

    static int[] m2360c(int[] iArr, int i, int i2) {
        int i3 = 0;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i4 = i2 / i;
        int i5 = i2 % i;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8;
            i3 += i5;
            if (i3 <= 0 || i - i3 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i3 -= i;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        return iArr;
    }

    int ae(int i, int i2) {
        if (this.mOrientation == 1 && ph()) {
            return this.ann[this.anm - i] - this.ann[(this.anm - i) - i2];
        }
        return this.ann[i + i2] - this.ann[i];
    }

    void mo153a(C1254n c1254n, C1261s c1261s, C1223a c1223a, int i) {
        super.mo153a(c1254n, c1261s, c1223a, i);
        oY();
        if (c1261s.getItemCount() > 0 && !c1261s.rb()) {
            m2357b(c1254n, c1261s, c1223a, i);
        }
        oZ();
    }

    private void oZ() {
        if (this.ano == null || this.ano.length != this.anm) {
            this.ano = new View[this.anm];
        }
    }

    public int mo123a(int i, C1254n c1254n, C1261s c1261s) {
        oY();
        oZ();
        return super.mo123a(i, c1254n, c1261s);
    }

    public int mo131b(int i, C1254n c1254n, C1261s c1261s) {
        oY();
        oZ();
        return super.mo131b(i, c1254n, c1261s);
    }

    private void m2357b(C1254n c1254n, C1261s c1261s, C1223a c1223a, int i) {
        Object obj = 1;
        if (i != 1) {
            obj = null;
        }
        int b = m2355b(c1254n, c1261s, c1223a.BO);
        if (obj != null) {
            while (b > 0 && c1223a.BO > 0) {
                c1223a.BO--;
                b = m2355b(c1254n, c1261s, c1223a.BO);
            }
            return;
        }
        int itemCount = c1261s.getItemCount() - 1;
        int i2 = c1223a.BO;
        int i3 = b;
        while (i2 < itemCount) {
            b = m2355b(c1254n, c1261s, i2 + 1);
            if (b <= i3) {
                break;
            }
            i2++;
            i3 = b;
        }
        c1223a.BO = i2;
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
                if (m2355b(c1254n, c1261s, ce) != 0) {
                    view3 = view;
                    childAt = view2;
                } else if (((android.support.v7.widget.RecyclerView.LayoutParams) childAt.getLayoutParams()).qP()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.anH.bK(childAt) < pG && this.anH.bL(childAt) >= pF) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        childAt = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = childAt;
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

    private int m2352a(C1254n c1254n, C1261s c1261s, int i) {
        if (!c1261s.rb()) {
            return this.anr.ah(i, this.anm);
        }
        int dy = c1254n.dy(i);
        if (dy != -1) {
            return this.anr.ah(dy, this.anm);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int m2355b(C1254n c1254n, C1261s c1261s, int i) {
        if (!c1261s.rb()) {
            return this.anr.ag(i, this.anm);
        }
        int i2 = this.anq.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c1254n.dy(i);
        if (i2 != -1) {
            return this.anr.ag(i2, this.anm);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int m2359c(C1254n c1254n, C1261s c1261s, int i) {
        if (!c1261s.rb()) {
            return this.anr.dc(i);
        }
        int i2 = this.anp.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c1254n.dy(i);
        if (i2 != -1) {
            return this.anr.dc(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    void mo156a(C1261s c1261s, C1225c c1225c, C1246a c1246a) {
        int i = this.anm;
        for (int i2 = 0; i2 < this.anm && c1225c.m2385b(c1261s) && i > 0; i2++) {
            int i3 = c1225c.anz;
            c1246a.ad(i3, Math.max(0, c1225c.aoa));
            i -= this.anr.dc(i3);
            c1225c.anz += c1225c.anA;
        }
    }

    void mo154a(C1254n c1254n, C1261s c1261s, C1225c c1225c, C1224b c1224b) {
        int pI = this.anH.pI();
        Object obj = pI != 1073741824 ? 1 : null;
        int i = getChildCount() > 0 ? this.ann[this.anm] : 0;
        if (obj != null) {
            oY();
        }
        boolean z = c1225c.anA == 1;
        int i2 = 0;
        int i3 = 0;
        int i4 = this.anm;
        if (!z) {
            i4 = m2355b(c1254n, c1261s, c1225c.anz) + m2359c(c1254n, c1261s, c1225c.anz);
        }
        while (i2 < this.anm && c1225c.m2385b(c1261s) && i4 > 0) {
            int i5 = c1225c.anz;
            int c = m2359c(c1254n, c1261s, i5);
            if (c <= this.anm) {
                i4 -= c;
                if (i4 >= 0) {
                    View a = c1225c.m2384a(c1254n);
                    if (a == null) {
                        break;
                    }
                    i3 += c;
                    this.ano[i2] = a;
                    i2++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i5 + " requires " + c + " spans but GridLayoutManager has only " + this.anm + " spans.");
        }
        if (i2 == 0) {
            c1224b.aeb = true;
            return;
        }
        LayoutParams layoutParams;
        int i6;
        int ae;
        m2353a(c1254n, c1261s, i2, i3, z);
        i3 = 0;
        float f = 0.0f;
        i5 = 0;
        while (i3 < i2) {
            View view = this.ano[i3];
            if (c1225c.aoe == null) {
                if (z) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z) {
                cd(view);
            } else {
                m2233A(view, 0);
            }
            m2291g(view, this.ans);
            m2358b(view, pI, false);
            i4 = this.anH.bO(view);
            if (i4 > i5) {
                i5 = i4;
            }
            float bP = (((float) this.anH.bP(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).anu);
            if (bP <= f) {
                bP = f;
            }
            i3++;
            f = bP;
        }
        if (obj != null) {
            m2356b(f, i);
            i5 = 0;
            c = 0;
            while (c < i2) {
                View view2 = this.ano[c];
                m2358b(view2, 1073741824, true);
                i4 = this.anH.bO(view2);
                if (i4 <= i5) {
                    i4 = i5;
                }
                c++;
                i5 = i4;
            }
        }
        for (i3 = 0; i3 < i2; i3++) {
            View view3 = this.ano[i3];
            if (this.anH.bO(view3) != i5) {
                layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.ans;
                i6 = ((rect.top + rect.bottom) + layoutParams.topMargin) + layoutParams.bottomMargin;
                c = ((rect.right + rect.left) + layoutParams.leftMargin) + layoutParams.rightMargin;
                ae = ae(layoutParams.ant, layoutParams.anu);
                if (this.mOrientation == 1) {
                    c = C1221h.m2225b(ae, 1073741824, c, layoutParams.width, false);
                    i4 = MeasureSpec.makeMeasureSpec(i5 - i6, 1073741824);
                } else {
                    c = MeasureSpec.makeMeasureSpec(i5 - c, 1073741824);
                    i4 = C1221h.m2225b(ae, 1073741824, i6, layoutParams.height, false);
                }
                m2354a(view3, c, i4, true);
            }
        }
        c1224b.anY = i5;
        i4 = 0;
        if (this.mOrientation == 1) {
            if (c1225c.anB == -1) {
                i4 = c1225c.Qz;
                i5 = i4 - i5;
                c = 0;
                i3 = 0;
            } else {
                c = c1225c.Qz;
                i4 = c + i5;
                i5 = c;
                c = 0;
                i3 = 0;
            }
        } else if (c1225c.anB == -1) {
            i3 = c1225c.Qz;
            c = i3;
            i3 -= i5;
            i5 = 0;
        } else {
            i3 = c1225c.Qz;
            c = i5 + i3;
            i5 = 0;
        }
        i = i4;
        ae = i5;
        int i7 = c;
        i6 = i3;
        for (i5 = 0; i5 < i2; i5++) {
            view3 = this.ano[i5];
            layoutParams = (LayoutParams) view3.getLayoutParams();
            if (this.mOrientation != 1) {
                ae = getPaddingTop() + this.ann[layoutParams.ant];
                i = ae + this.anH.bP(view3);
            } else if (ph()) {
                i7 = getPaddingLeft() + this.ann[this.anm - layoutParams.ant];
                i6 = i7 - this.anH.bP(view3);
            } else {
                i6 = getPaddingLeft() + this.ann[layoutParams.ant];
                i7 = i6 + this.anH.bP(view3);
            }
            m2294h(view3, i6, ae, i7, i);
            if (layoutParams.qP() || layoutParams.qQ()) {
                c1224b.anZ = true;
            }
            c1224b.aec |= view3.hasFocusable();
        }
        Arrays.fill(this.ano, null);
    }

    private void m2358b(View view, int i, boolean z) {
        int b;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.ans;
        int i2 = ((rect.top + rect.bottom) + layoutParams.topMargin) + layoutParams.bottomMargin;
        int i3 = layoutParams.rightMargin + ((rect.right + rect.left) + layoutParams.leftMargin);
        int ae = ae(layoutParams.ant, layoutParams.anu);
        if (this.mOrientation == 1) {
            ae = C1221h.m2225b(ae, i, i3, layoutParams.width, false);
            b = C1221h.m2225b(this.anH.pH(), qI(), i2, layoutParams.height, true);
        } else {
            int b2 = C1221h.m2225b(ae, i, i2, layoutParams.height, false);
            ae = C1221h.m2225b(this.anH.pH(), qH(), i3, layoutParams.width, true);
            b = b2;
        }
        m2354a(view, ae, b, z);
    }

    private void m2356b(float f, int i) {
        da(Math.max(Math.round(((float) this.anm) * f), i));
    }

    private void m2354a(View view, int i, int i2, boolean z) {
        boolean a;
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            a = m2262a(view, i, i2, layoutParams);
        } else {
            a = m2275b(view, i, i2, layoutParams);
        }
        if (a) {
            view.measure(i, i2);
        }
    }

    private void m2353a(C1254n c1254n, C1261s c1261s, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i3 = i - 1;
            i = -1;
            i4 = i3;
            i3 = -1;
        }
        int i5 = 0;
        for (int i6 = i4; i6 != i; i6 += i3) {
            View view = this.ano[i6];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.anu = m2359c(c1254n, c1261s, ce(view));
            layoutParams.ant = i5;
            i5 += layoutParams.anu;
        }
    }

    public void db(int i) {
        if (i != this.anm) {
            this.anl = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.anm = i;
            this.anr.pd();
            requestLayout();
        }
    }

    public View mo124a(View view, int i, C1254n c1254n, C1261s c1261s) {
        View bS = bS(view);
        if (bS == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) bS.getLayoutParams();
        int i2 = layoutParams.ant;
        int i3 = layoutParams.ant + layoutParams.anu;
        if (super.mo124a(view, i, c1254n, c1261s) == null) {
            return null;
        }
        int childCount;
        int i4;
        int i5;
        if (((dh(i) == 1) != this.anK ? 1 : null) != null) {
            childCount = getChildCount() - 1;
            i4 = -1;
            i5 = -1;
        } else {
            childCount = 0;
            i4 = 1;
            i5 = getChildCount();
        }
        Object obj = (this.mOrientation == 1 && ph()) ? 1 : null;
        View view2 = null;
        int i6 = -1;
        int i7 = 0;
        View view3 = null;
        int i8 = -1;
        int i9 = 0;
        int a = m2352a(c1254n, c1261s, childCount);
        int i10 = childCount;
        while (i10 != i5) {
            childCount = m2352a(c1254n, c1261s, i10);
            View childAt = getChildAt(i10);
            if (childAt == bS) {
                break;
            }
            View view4;
            int min;
            View view5;
            int i11;
            if (childAt.hasFocusable() && childCount != a) {
                if (view2 != null) {
                    break;
                }
            }
            layoutParams = (LayoutParams) childAt.getLayoutParams();
            int i12 = layoutParams.ant;
            int i13 = layoutParams.ant + layoutParams.anu;
            if (childAt.hasFocusable() && i12 == i2 && i13 == i3) {
                return childAt;
            }
            Object obj2 = null;
            if (!(childAt.hasFocusable() && view2 == null) && (childAt.hasFocusable() || view3 != null)) {
                int min2 = Math.min(i13, i3) - Math.max(i12, i2);
                if (childAt.hasFocusable()) {
                    if (min2 > i7) {
                        obj2 = 1;
                    } else if (min2 == i7) {
                        if (obj == (i12 > i6 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                } else if (view2 == null && m2264a(childAt, false, true)) {
                    if (min2 > i9) {
                        obj2 = 1;
                    } else if (min2 == i9) {
                        if (obj == (i12 > i8 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                if (childAt.hasFocusable()) {
                    i7 = layoutParams.ant;
                    int i14 = i9;
                    i9 = i8;
                    view4 = view3;
                    min = Math.min(i13, i3) - Math.max(i12, i2);
                    childCount = i14;
                    int i15 = i7;
                    view5 = childAt;
                    i11 = i15;
                } else {
                    i9 = layoutParams.ant;
                    childCount = Math.min(i13, i3) - Math.max(i12, i2);
                    view4 = childAt;
                    min = i7;
                    i11 = i6;
                    view5 = view2;
                }
                i10 += i4;
                view2 = view5;
                i7 = min;
                i6 = i11;
                view3 = view4;
                i8 = i9;
                i9 = childCount;
            }
            childCount = i9;
            i11 = i6;
            i9 = i8;
            view4 = view3;
            min = i7;
            view5 = view2;
            i10 += i4;
            view2 = view5;
            i7 = min;
            i6 = i11;
            view3 = view4;
            i8 = i9;
            i9 = childCount;
        }
        if (view2 == null) {
            view2 = view3;
        }
        return view2;
    }

    public boolean pa() {
        return this.anQ == null && !this.anl;
    }
}
