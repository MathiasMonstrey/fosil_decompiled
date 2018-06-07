package com.fossil;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.fossil.mv.C3885a;
import com.fossil.mw.C3889a;
import java.util.ArrayList;
import java.util.List;

public class mu {
    private static final C3884a US;
    private final Object UT;

    interface C3884a {
        Object mo3473a(mu muVar);
    }

    static class C3887d implements C3884a {
        C3887d() {
        }

        public Object mo3473a(mu muVar) {
            return null;
        }
    }

    static class C3888b extends C3887d {
        C3888b() {
        }

        public Object mo3473a(final mu muVar) {
            return mv.m12610a(new C3885a(this) {
                final /* synthetic */ C3888b UV;

                public boolean performAction(int i, int i2, Bundle bundle) {
                    return muVar.performAction(i, i2, bundle);
                }

                public List<Object> findAccessibilityNodeInfosByText(String str, int i) {
                    List findAccessibilityNodeInfosByText = muVar.findAccessibilityNodeInfosByText(str, i);
                    if (findAccessibilityNodeInfosByText == null) {
                        return null;
                    }
                    List<Object> arrayList = new ArrayList();
                    int size = findAccessibilityNodeInfosByText.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((ml) findAccessibilityNodeInfosByText.get(i2)).jU());
                    }
                    return arrayList;
                }

                public Object bz(int i) {
                    ml bx = muVar.bx(i);
                    if (bx == null) {
                        return null;
                    }
                    return bx.jU();
                }
            });
        }
    }

    static class C3891c extends C3887d {
        C3891c() {
        }

        public Object mo3473a(final mu muVar) {
            return mw.m12611a(new C3889a(this) {
                final /* synthetic */ C3891c UW;

                public boolean performAction(int i, int i2, Bundle bundle) {
                    return muVar.performAction(i, i2, bundle);
                }

                public List<Object> findAccessibilityNodeInfosByText(String str, int i) {
                    List findAccessibilityNodeInfosByText = muVar.findAccessibilityNodeInfosByText(str, i);
                    if (findAccessibilityNodeInfosByText == null) {
                        return null;
                    }
                    List<Object> arrayList = new ArrayList();
                    int size = findAccessibilityNodeInfosByText.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((ml) findAccessibilityNodeInfosByText.get(i2)).jU());
                    }
                    return arrayList;
                }

                public Object bz(int i) {
                    ml bx = muVar.bx(i);
                    if (bx == null) {
                        return null;
                    }
                    return bx.jU();
                }

                public Object bA(int i) {
                    ml by = muVar.by(i);
                    if (by == null) {
                        return null;
                    }
                    return by.jU();
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            US = new C3891c();
        } else if (VERSION.SDK_INT >= 16) {
            US = new C3888b();
        } else {
            US = new C3887d();
        }
    }

    public mu() {
        this.UT = US.mo3473a(this);
    }

    public mu(Object obj) {
        this.UT = obj;
    }

    public Object kd() {
        return this.UT;
    }

    public ml bx(int i) {
        return null;
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<ml> findAccessibilityNodeInfosByText(String str, int i) {
        return null;
    }

    public ml by(int i) {
        return null;
    }
}
