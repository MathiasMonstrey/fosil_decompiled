package com.fossil;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.fossil.ka.C3768a;
import com.fossil.kb.C3773a;

public class jz {
    private static final C3770b QN;
    private static final Object QO = QN.jy();
    final Object QP = QN.mo3257a(this);

    interface C3770b {
        Object mo3257a(jz jzVar);

        void mo3258a(Object obj, View view, int i);

        void mo3259a(Object obj, View view, ml mlVar);

        boolean mo3260a(Object obj, View view, int i, Bundle bundle);

        boolean mo3261a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean mo3262a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo3263b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo3264c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        mu mo3265d(Object obj, View view);

        void mo3266d(Object obj, View view, AccessibilityEvent accessibilityEvent);

        Object jy();
    }

    static class C3771d implements C3770b {
        C3771d() {
        }

        public Object jy() {
            return null;
        }

        public Object mo3257a(jz jzVar) {
            return null;
        }

        public boolean mo3261a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public void mo3263b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void mo3259a(Object obj, View view, ml mlVar) {
        }

        public void mo3264c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public boolean mo3262a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void mo3258a(Object obj, View view, int i) {
        }

        public void mo3266d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public mu mo3265d(Object obj, View view) {
            return null;
        }

        public boolean mo3260a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static class C3772a extends C3771d {
        C3772a() {
        }

        public Object jy() {
            return ka.jz();
        }

        public Object mo3257a(final jz jzVar) {
            return ka.m11945a(new C3768a(this) {
                final /* synthetic */ C3772a QR;

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return jzVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    jzVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                public void mo3250b(View view, Object obj) {
                    jzVar.mo2a(view, new ml(obj));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    jzVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return jzVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    jzVar.sendAccessibilityEvent(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    jzVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }
            });
        }

        public boolean mo3261a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return ka.m11948a(obj, view, accessibilityEvent);
        }

        public void mo3263b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            ka.m11950b(obj, view, accessibilityEvent);
        }

        public void mo3259a(Object obj, View view, ml mlVar) {
            ka.m11947a(obj, view, mlVar.jU());
        }

        public void mo3264c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            ka.m11951c(obj, view, accessibilityEvent);
        }

        public boolean mo3262a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return ka.m11949a(obj, viewGroup, view, accessibilityEvent);
        }

        public void mo3258a(Object obj, View view, int i) {
            ka.m11946a(obj, view, i);
        }

        public void mo3266d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            ka.m11952d(obj, view, accessibilityEvent);
        }
    }

    static class C3775c extends C3772a {
        C3775c() {
        }

        public Object mo3257a(final jz jzVar) {
            return kb.m11953a(new C3773a(this) {
                final /* synthetic */ C3775c QS;

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return jzVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    jzVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                public void mo3269b(View view, Object obj) {
                    jzVar.mo2a(view, new ml(obj));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    jzVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return jzVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    jzVar.sendAccessibilityEvent(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    jzVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }

                public Object mo3268J(View view) {
                    mu I = jzVar.m1684I(view);
                    return I != null ? I.kd() : null;
                }

                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return jzVar.performAccessibilityAction(view, i, bundle);
                }
            });
        }

        public mu mo3265d(Object obj, View view) {
            Object e = kb.m11955e(obj, view);
            if (e != null) {
                return new mu(e);
            }
            return null;
        }

        public boolean mo3260a(Object obj, View view, int i, Bundle bundle) {
            return kb.m11954a(obj, view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            QN = new C3775c();
        } else if (VERSION.SDK_INT >= 14) {
            QN = new C3772a();
        } else {
            QN = new C3771d();
        }
    }

    Object jx() {
        return this.QP;
    }

    public void sendAccessibilityEvent(View view, int i) {
        QN.mo3258a(QO, view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        QN.mo3266d(QO, view, accessibilityEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return QN.mo3261a(QO, view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        QN.mo3264c(QO, view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        QN.mo3263b(QO, view, accessibilityEvent);
    }

    public void mo2a(View view, ml mlVar) {
        QN.mo3259a(QO, view, mlVar);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return QN.mo3262a(QO, viewGroup, view, accessibilityEvent);
    }

    public mu m1684I(View view) {
        return QN.mo3265d(QO, view);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return QN.mo3260a(QO, view, i, bundle);
    }
}
