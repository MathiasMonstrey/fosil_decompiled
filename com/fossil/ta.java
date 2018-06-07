package com.fossil;

import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.v;
import com.fossil.ju.a;
import com.fossil.ju.b;

public class ta {
    final jl<v, C4089a> awd = new jl();
    final jq<v> awe = new jq();

    static class C4089a {
        static a<C4089a> awh = new b(20);
        c awf;
        c awg;
        int flags;

        private C4089a() {
        }

        static C4089a sK() {
            C4089a c4089a = (C4089a) awh.ea();
            return c4089a == null ? new C4089a() : c4089a;
        }

        static void m13598a(C4089a c4089a) {
            c4089a.flags = 0;
            c4089a.awf = null;
            c4089a.awg = null;
            awh.e(c4089a);
        }

        static void sL() {
            do {
            } while (awh.ea() != null);
        }
    }

    public interface C4090b {
        void m13599c(v vVar, c cVar, c cVar2);

        void m13600d(v vVar, c cVar, c cVar2);

        void m13601e(v vVar, c cVar, c cVar2);

        void m13602m(v vVar);
    }

    public void clear() {
        this.awd.clear();
        this.awe.clear();
    }

    public void m13614b(v vVar, c cVar) {
        C4089a c4089a = (C4089a) this.awd.get(vVar);
        if (c4089a == null) {
            c4089a = C4089a.sK();
            this.awd.put(vVar, c4089a);
        }
        c4089a.awf = cVar;
        c4089a.flags |= 4;
    }

    public boolean m13604Q(v vVar) {
        C4089a c4089a = (C4089a) this.awd.get(vVar);
        return (c4089a == null || (c4089a.flags & 1) == 0) ? false : true;
    }

    public c m13605R(v vVar) {
        return m13603e(vVar, 4);
    }

    public c m13606S(v vVar) {
        return m13603e(vVar, 8);
    }

    private c m13603e(v vVar, int i) {
        c cVar = null;
        int indexOfKey = this.awd.indexOfKey(vVar);
        if (indexOfKey >= 0) {
            C4089a c4089a = (C4089a) this.awd.valueAt(indexOfKey);
            if (!(c4089a == null || (c4089a.flags & i) == 0)) {
                c4089a.flags &= i ^ -1;
                if (i == 4) {
                    cVar = c4089a.awf;
                } else if (i == 8) {
                    cVar = c4089a.awg;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((c4089a.flags & 12) == 0) {
                    this.awd.removeAt(indexOfKey);
                    C4089a.m13598a(c4089a);
                }
            }
        }
        return cVar;
    }

    public void m13612a(long j, v vVar) {
        this.awe.put(j, vVar);
    }

    public void m13615c(v vVar, c cVar) {
        C4089a c4089a = (C4089a) this.awd.get(vVar);
        if (c4089a == null) {
            c4089a = C4089a.sK();
            this.awd.put(vVar, c4089a);
        }
        c4089a.flags |= 2;
        c4089a.awf = cVar;
    }

    public boolean m13607T(v vVar) {
        C4089a c4089a = (C4089a) this.awd.get(vVar);
        return (c4089a == null || (c4089a.flags & 4) == 0) ? false : true;
    }

    public v m13617u(long j) {
        return (v) this.awe.get(j);
    }

    public void m13616d(v vVar, c cVar) {
        C4089a c4089a = (C4089a) this.awd.get(vVar);
        if (c4089a == null) {
            c4089a = C4089a.sK();
            this.awd.put(vVar, c4089a);
        }
        c4089a.awg = cVar;
        c4089a.flags |= 8;
    }

    public void m13608U(v vVar) {
        C4089a c4089a = (C4089a) this.awd.get(vVar);
        if (c4089a == null) {
            c4089a = C4089a.sK();
            this.awd.put(vVar, c4089a);
        }
        r0.flags |= 1;
    }

    public void m13609V(v vVar) {
        C4089a c4089a = (C4089a) this.awd.get(vVar);
        if (c4089a != null) {
            c4089a.flags &= -2;
        }
    }

    public void m13613a(C4090b c4090b) {
        for (int size = this.awd.size() - 1; size >= 0; size--) {
            v vVar = (v) this.awd.keyAt(size);
            C4089a c4089a = (C4089a) this.awd.removeAt(size);
            if ((c4089a.flags & 3) == 3) {
                c4090b.m13602m(vVar);
            } else if ((c4089a.flags & 1) != 0) {
                if (c4089a.awf == null) {
                    c4090b.m13602m(vVar);
                } else {
                    c4090b.m13599c(vVar, c4089a.awf, c4089a.awg);
                }
            } else if ((c4089a.flags & 14) == 14) {
                c4090b.m13600d(vVar, c4089a.awf, c4089a.awg);
            } else if ((c4089a.flags & 12) == 12) {
                c4090b.m13601e(vVar, c4089a.awf, c4089a.awg);
            } else if ((c4089a.flags & 4) != 0) {
                c4090b.m13599c(vVar, c4089a.awf, null);
            } else if ((c4089a.flags & 8) != 0) {
                c4090b.m13600d(vVar, c4089a.awf, c4089a.awg);
            } else if ((c4089a.flags & 2) != 0) {
            }
            C4089a.m13598a(c4089a);
        }
    }

    public void m13610W(v vVar) {
        for (int size = this.awe.size() - 1; size >= 0; size--) {
            if (vVar == this.awe.valueAt(size)) {
                this.awe.removeAt(size);
                break;
            }
        }
        C4089a c4089a = (C4089a) this.awd.remove(vVar);
        if (c4089a != null) {
            C4089a.m13598a(c4089a);
        }
    }

    public void onDetach() {
        C4089a.sL();
    }

    public void m13611X(v vVar) {
        m13609V(vVar);
    }
}
