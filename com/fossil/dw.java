package com.fossil;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(14)
abstract class dw extends dh {
    private static final String[] FI = new String[]{"android:visibility:visibility", "android:visibility:parent"};

    static class C3239a {
        boolean Hc;
        boolean Hd;
        int He;
        int Hf;
        ViewGroup Hg;
        ViewGroup Hh;

        C3239a() {
        }
    }

    dw() {
    }

    public String[] getTransitionProperties() {
        return FI;
    }

    private void m7467c(dn dnVar) {
        dnVar.values.put("android:visibility:visibility", Integer.valueOf(dnVar.view.getVisibility()));
        dnVar.values.put("android:visibility:parent", dnVar.view.getParent());
    }

    public void mo1864a(dn dnVar) {
        m7467c(dnVar);
    }

    public void mo1866b(dn dnVar) {
        m7467c(dnVar);
    }

    public boolean mo2676d(dn dnVar) {
        if (dnVar == null) {
            return false;
        }
        boolean z = ((Integer) dnVar.values.get("android:visibility:visibility")).intValue() == 0 && ((View) dnVar.values.get("android:visibility:parent")) != null;
        return z;
    }

    private C3239a m7466a(dn dnVar, dn dnVar2) {
        C3239a c3239a = new C3239a();
        c3239a.Hc = false;
        c3239a.Hd = false;
        if (dnVar != null) {
            c3239a.He = ((Integer) dnVar.values.get("android:visibility:visibility")).intValue();
            c3239a.Hg = (ViewGroup) dnVar.values.get("android:visibility:parent");
        } else {
            c3239a.He = -1;
            c3239a.Hg = null;
        }
        if (dnVar2 != null) {
            c3239a.Hf = ((Integer) dnVar2.values.get("android:visibility:visibility")).intValue();
            c3239a.Hh = (ViewGroup) dnVar2.values.get("android:visibility:parent");
        } else {
            c3239a.Hf = -1;
            c3239a.Hh = null;
        }
        if (!(dnVar == null || dnVar2 == null)) {
            if (c3239a.He == c3239a.Hf && c3239a.Hg == c3239a.Hh) {
                return c3239a;
            }
            if (c3239a.He != c3239a.Hf) {
                if (c3239a.He == 0) {
                    c3239a.Hd = false;
                    c3239a.Hc = true;
                } else if (c3239a.Hf == 0) {
                    c3239a.Hd = true;
                    c3239a.Hc = true;
                }
            } else if (c3239a.Hg != c3239a.Hh) {
                if (c3239a.Hh == null) {
                    c3239a.Hd = false;
                    c3239a.Hc = true;
                } else if (c3239a.Hg == null) {
                    c3239a.Hd = true;
                    c3239a.Hc = true;
                }
            }
        }
        if (dnVar == null) {
            c3239a.Hd = true;
            c3239a.Hc = true;
        } else if (dnVar2 == null) {
            c3239a.Hd = false;
            c3239a.Hc = true;
        }
        return c3239a;
    }

    public Animator mo1907a(ViewGroup viewGroup, dn dnVar, dn dnVar2) {
        Object obj = null;
        int i = -1;
        C3239a a = m7466a(dnVar, dnVar2);
        if (a.Hc) {
            if (this.Gs.size() > 0 || this.Gr.size() > 0) {
                View view;
                int id;
                Object obj2;
                View view2 = dnVar != null ? dnVar.view : null;
                if (dnVar2 != null) {
                    view = dnVar2.view;
                } else {
                    view = null;
                }
                if (view2 != null) {
                    id = view2.getId();
                } else {
                    id = -1;
                }
                if (view != null) {
                    i = view.getId();
                }
                if (m6847a(view2, (long) id) || m6847a(view, (long) r0)) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = obj2;
            }
            if (!(obj == null && a.Hg == null && a.Hh == null)) {
                if (a.Hd) {
                    return mo2020a(viewGroup, dnVar, a.He, dnVar2, a.Hf);
                }
                return mo2021b(viewGroup, dnVar, a.He, dnVar2, a.Hf);
            }
        }
        return null;
    }

    public Animator mo2020a(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        return null;
    }

    public Animator mo2021b(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        return null;
    }
}
