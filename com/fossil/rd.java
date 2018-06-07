package com.fossil;

import android.support.v7.widget.RecyclerView.v;
import com.fossil.ju.a;
import com.fossil.ju.b;
import com.fossil.se.C4041a;
import java.util.ArrayList;
import java.util.List;

public class rd implements C4041a {
    private a<C4040b> ajW;
    final ArrayList<C4040b> ajX;
    final ArrayList<C4040b> ajY;
    final C4039a ajZ;
    Runnable aka;
    final boolean akb;
    final se akc;
    private int akd;

    public interface C4039a {
        void m13282W(int i, int i2);

        void m13283X(int i, int i2);

        void m13284Y(int i, int i2);

        void m13285Z(int i, int i2);

        void m13286b(int i, int i2, Object obj);

        v cP(int i);

        void m13287h(C4040b c4040b);

        void m13288i(C4040b c4040b);
    }

    public static class C4040b {
        public int In;
        public int ake;
        public Object akf;
        public int akg;

        C4040b(int i, int i2, int i3, Object obj) {
            this.In = i;
            this.ake = i2;
            this.akg = i3;
            this.akf = obj;
        }

        String oo() {
            switch (this.In) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                case 4:
                    return "up";
                case 8:
                    return "mv";
                default:
                    return "??";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + oo() + ",s:" + this.ake + "c:" + this.akg + ",p:" + this.akf + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C4040b c4040b = (C4040b) obj;
            if (this.In != c4040b.In) {
                return false;
            }
            if (this.In == 8 && Math.abs(this.akg - this.ake) == 1 && this.akg == c4040b.ake && this.ake == c4040b.akg) {
                return true;
            }
            if (this.akg != c4040b.akg) {
                return false;
            }
            if (this.ake != c4040b.ake) {
                return false;
            }
            if (this.akf != null) {
                if (this.akf.equals(c4040b.akf)) {
                    return true;
                }
                return false;
            } else if (c4040b.akf != null) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            return (((this.In * 31) + this.ake) * 31) + this.akg;
        }
    }

    public rd(C4039a c4039a) {
        this(c4039a, false);
    }

    rd(C4039a c4039a, boolean z) {
        this.ajW = new b(30);
        this.ajX = new ArrayList();
        this.ajY = new ArrayList();
        this.akd = 0;
        this.ajZ = c4039a;
        this.akb = z;
        this.akc = new se(this);
    }

    public void reset() {
        m13306q(this.ajX);
        m13306q(this.ajY);
        this.akd = 0;
    }

    public void oj() {
        this.akc.m13512s(this.ajX);
        int size = this.ajX.size();
        for (int i = 0; i < size; i++) {
            C4040b c4040b = (C4040b) this.ajX.get(i);
            switch (c4040b.In) {
                case 1:
                    m13296e(c4040b);
                    break;
                case 2:
                    m13293b(c4040b);
                    break;
                case 4:
                    m13294c(c4040b);
                    break;
                case 8:
                    m13292a(c4040b);
                    break;
            }
            if (this.aka != null) {
                this.aka.run();
            }
        }
        this.ajX.clear();
    }

    public void ok() {
        int size = this.ajY.size();
        for (int i = 0; i < size; i++) {
            this.ajZ.m13288i((C4040b) this.ajY.get(i));
        }
        m13306q(this.ajY);
        this.akd = 0;
    }

    private void m13292a(C4040b c4040b) {
        m13297f(c4040b);
    }

    private void m13293b(C4040b c4040b) {
        int i = c4040b.ake;
        int i2 = c4040b.ake + c4040b.akg;
        Object obj = -1;
        int i3 = c4040b.ake;
        int i4 = 0;
        while (i3 < i2) {
            Object obj2;
            int i5;
            if (this.ajZ.cP(i3) != null || cL(i3)) {
                if (obj == null) {
                    m13295d(mo4068a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = 1;
            } else {
                if (obj == 1) {
                    m13297f(mo4068a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                i5 = i3 - i4;
                i3 = i2 - i4;
                i2 = 1;
            } else {
                int i6 = i3;
                i3 = i2;
                i2 = i4 + 1;
                i5 = i6;
            }
            i4 = i2;
            i2 = i3;
            i3 = i5 + 1;
        }
        if (i4 != c4040b.akg) {
            mo4069g(c4040b);
            c4040b = mo4068a(2, i, i4, null);
        }
        if (obj == null) {
            m13295d(c4040b);
        } else {
            m13297f(c4040b);
        }
    }

    private void m13294c(C4040b c4040b) {
        int i = c4040b.ake;
        int i2 = c4040b.ake + c4040b.akg;
        int i3 = c4040b.ake;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.ajZ.cP(i3) != null || cL(i3)) {
                if (obj == null) {
                    m13295d(mo4068a(4, i, i4, c4040b.akf));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    m13297f(mo4068a(4, i, i4, c4040b.akf));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != c4040b.akg) {
            Object obj4 = c4040b.akf;
            mo4069g(c4040b);
            c4040b = mo4068a(4, i, i4, obj4);
        }
        if (obj == null) {
            m13295d(c4040b);
        } else {
            m13297f(c4040b);
        }
    }

    private void m13295d(C4040b c4040b) {
        if (c4040b.In == 1 || c4040b.In == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int S = m13291S(c4040b.ake, c4040b.In);
        int i2 = c4040b.ake;
        switch (c4040b.In) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + c4040b);
        }
        int i3 = 1;
        int i4 = S;
        S = i2;
        for (i2 = 1; i2 < c4040b.akg; i2++) {
            Object obj;
            int S2 = m13291S(c4040b.ake + (i * i2), c4040b.In);
            int i5;
            switch (c4040b.In) {
                case 2:
                    if (S2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 4:
                    if (S2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                C4040b a = mo4068a(c4040b.In, i4, i3, c4040b.akf);
                m13302a(a, S);
                mo4069g(a);
                if (c4040b.In == 4) {
                    S += i3;
                }
                i3 = 1;
                i4 = S2;
            }
        }
        Object obj2 = c4040b.akf;
        mo4069g(c4040b);
        if (i3 > 0) {
            C4040b a2 = mo4068a(c4040b.In, i4, i3, obj2);
            m13302a(a2, S);
            mo4069g(a2);
        }
    }

    void m13302a(C4040b c4040b, int i) {
        this.ajZ.m13287h(c4040b);
        switch (c4040b.In) {
            case 2:
                this.ajZ.m13282W(i, c4040b.akg);
                return;
            case 4:
                this.ajZ.m13286b(i, c4040b.akg, c4040b.akf);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int m13291S(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.ajY.size() - 1; size >= 0; size--) {
            C4040b c4040b = (C4040b) this.ajY.get(size);
            if (c4040b.In == 8) {
                int i5;
                int i6;
                if (c4040b.ake < c4040b.akg) {
                    i5 = c4040b.ake;
                    i3 = c4040b.akg;
                } else {
                    i5 = c4040b.akg;
                    i3 = c4040b.ake;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < c4040b.ake) {
                        if (i2 == 1) {
                            c4040b.ake++;
                            c4040b.akg++;
                            i6 = i4;
                        } else if (i2 == 2) {
                            c4040b.ake--;
                            c4040b.akg--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == c4040b.ake) {
                    if (i2 == 1) {
                        c4040b.akg++;
                    } else if (i2 == 2) {
                        c4040b.akg--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        c4040b.ake++;
                    } else if (i2 == 2) {
                        c4040b.ake--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (c4040b.ake <= i4) {
                if (c4040b.In == 1) {
                    i4 -= c4040b.akg;
                } else if (c4040b.In == 2) {
                    i4 += c4040b.akg;
                }
            } else if (i2 == 1) {
                c4040b.ake++;
            } else if (i2 == 2) {
                c4040b.ake--;
            }
        }
        for (i3 = this.ajY.size() - 1; i3 >= 0; i3--) {
            c4040b = (C4040b) this.ajY.get(i3);
            if (c4040b.In == 8) {
                if (c4040b.akg == c4040b.ake || c4040b.akg < 0) {
                    this.ajY.remove(i3);
                    mo4069g(c4040b);
                }
            } else if (c4040b.akg <= 0) {
                this.ajY.remove(i3);
                mo4069g(c4040b);
            }
        }
        return i4;
    }

    private boolean cL(int i) {
        int size = this.ajY.size();
        for (int i2 = 0; i2 < size; i2++) {
            C4040b c4040b = (C4040b) this.ajY.get(i2);
            if (c4040b.In == 8) {
                if (m13298T(c4040b.akg, i2 + 1) == i) {
                    return true;
                }
            } else if (c4040b.In == 1) {
                int i3 = c4040b.ake + c4040b.akg;
                for (int i4 = c4040b.ake; i4 < i3; i4++) {
                    if (m13298T(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m13296e(C4040b c4040b) {
        m13297f(c4040b);
    }

    private void m13297f(C4040b c4040b) {
        this.ajY.add(c4040b);
        switch (c4040b.In) {
            case 1:
                this.ajZ.m13284Y(c4040b.ake, c4040b.akg);
                return;
            case 2:
                this.ajZ.m13283X(c4040b.ake, c4040b.akg);
                return;
            case 4:
                this.ajZ.m13286b(c4040b.ake, c4040b.akg, c4040b.akf);
                return;
            case 8:
                this.ajZ.m13285Z(c4040b.ake, c4040b.akg);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + c4040b);
        }
    }

    public boolean ol() {
        return this.ajX.size() > 0;
    }

    public boolean cM(int i) {
        return (this.akd & i) != 0;
    }

    public int cN(int i) {
        return m13298T(i, 0);
    }

    int m13298T(int i, int i2) {
        int size = this.ajY.size();
        int i3 = i;
        while (i2 < size) {
            C4040b c4040b = (C4040b) this.ajY.get(i2);
            if (c4040b.In == 8) {
                if (c4040b.ake == i3) {
                    i3 = c4040b.akg;
                } else {
                    if (c4040b.ake < i3) {
                        i3--;
                    }
                    if (c4040b.akg <= i3) {
                        i3++;
                    }
                }
            } else if (c4040b.ake > i3) {
                continue;
            } else if (c4040b.In == 2) {
                if (i3 < c4040b.ake + c4040b.akg) {
                    return -1;
                }
                i3 -= c4040b.akg;
            } else if (c4040b.In == 1) {
                i3 += c4040b.akg;
            }
            i2++;
        }
        return i3;
    }

    public boolean m13303a(int i, int i2, Object obj) {
        boolean z = true;
        if (i2 < 1) {
            return false;
        }
        this.ajX.add(mo4068a(4, i, i2, obj));
        this.akd |= 4;
        if (this.ajX.size() != 1) {
            z = false;
        }
        return z;
    }

    public boolean m13299U(int i, int i2) {
        boolean z = true;
        if (i2 < 1) {
            return false;
        }
        this.ajX.add(mo4068a(1, i, i2, null));
        this.akd |= 1;
        if (this.ajX.size() != 1) {
            z = false;
        }
        return z;
    }

    public boolean m13300V(int i, int i2) {
        boolean z = true;
        if (i2 < 1) {
            return false;
        }
        this.ajX.add(mo4068a(2, i, i2, null));
        this.akd |= 2;
        if (this.ajX.size() != 1) {
            z = false;
        }
        return z;
    }

    public boolean m13305k(int i, int i2, int i3) {
        boolean z = true;
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.ajX.add(mo4068a(8, i, i2, null));
        this.akd |= 8;
        if (this.ajX.size() != 1) {
            z = false;
        }
        return z;
    }

    public void om() {
        ok();
        int size = this.ajX.size();
        for (int i = 0; i < size; i++) {
            C4040b c4040b = (C4040b) this.ajX.get(i);
            switch (c4040b.In) {
                case 1:
                    this.ajZ.m13288i(c4040b);
                    this.ajZ.m13284Y(c4040b.ake, c4040b.akg);
                    break;
                case 2:
                    this.ajZ.m13288i(c4040b);
                    this.ajZ.m13282W(c4040b.ake, c4040b.akg);
                    break;
                case 4:
                    this.ajZ.m13288i(c4040b);
                    this.ajZ.m13286b(c4040b.ake, c4040b.akg, c4040b.akf);
                    break;
                case 8:
                    this.ajZ.m13288i(c4040b);
                    this.ajZ.m13285Z(c4040b.ake, c4040b.akg);
                    break;
            }
            if (this.aka != null) {
                this.aka.run();
            }
        }
        m13306q(this.ajX);
        this.akd = 0;
    }

    public int cO(int i) {
        int size = this.ajX.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            C4040b c4040b = (C4040b) this.ajX.get(i3);
            switch (c4040b.In) {
                case 1:
                    if (c4040b.ake > i2) {
                        break;
                    }
                    i2 += c4040b.akg;
                    break;
                case 2:
                    if (c4040b.ake <= i2) {
                        if (c4040b.ake + c4040b.akg <= i2) {
                            i2 -= c4040b.akg;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (c4040b.ake != i2) {
                        if (c4040b.ake < i2) {
                            i2--;
                        }
                        if (c4040b.akg > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = c4040b.akg;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    public boolean on() {
        return (this.ajY.isEmpty() || this.ajX.isEmpty()) ? false : true;
    }

    public C4040b mo4068a(int i, int i2, int i3, Object obj) {
        C4040b c4040b = (C4040b) this.ajW.ea();
        if (c4040b == null) {
            return new C4040b(i, i2, i3, obj);
        }
        c4040b.In = i;
        c4040b.ake = i2;
        c4040b.akg = i3;
        c4040b.akf = obj;
        return c4040b;
    }

    public void mo4069g(C4040b c4040b) {
        if (!this.akb) {
            c4040b.akf = null;
            this.ajW.e(c4040b);
        }
    }

    void m13306q(List<C4040b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo4069g((C4040b) list.get(i));
        }
        list.clear();
    }
}
