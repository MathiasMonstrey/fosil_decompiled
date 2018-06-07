package com.fossil;

import android.os.Build.VERSION;
import android.support.v8.renderscript.Allocation;
import android.view.KeyEvent;

public final class kg {
    static final C3789c Rv;

    interface C3789c {
        boolean mo3280c(KeyEvent keyEvent);

        boolean metaStateHasModifiers(int i, int i2);

        boolean metaStateHasNoModifiers(int i);
    }

    static class C3790a implements C3789c {
        C3790a() {
        }

        private static int m11959c(int i, int i2, int i3, int i4, int i5) {
            Object obj = 1;
            Object obj2 = (i2 & i3) != 0 ? 1 : null;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                obj = null;
            }
            if (obj2 != null) {
                if (obj == null) {
                    return i & (i6 ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            } else if (obj != null) {
                return i & (i3 ^ -1);
            } else {
                return i;
            }
        }

        public int normalizeMetaState(int i) {
            int i2;
            if ((i & 192) != 0) {
                i2 = i | 1;
            } else {
                i2 = i;
            }
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        public boolean metaStateHasModifiers(int i, int i2) {
            if (C3790a.m11959c(C3790a.m11959c(normalizeMetaState(i) & 247, i2, 1, 64, Allocation.USAGE_SHARED), i2, 2, 16, 32) == i2) {
                return true;
            }
            return false;
        }

        public boolean metaStateHasNoModifiers(int i) {
            return (normalizeMetaState(i) & 247) == 0;
        }

        public boolean mo3280c(KeyEvent keyEvent) {
            return false;
        }
    }

    static class C3791b extends C3790a {
        C3791b() {
        }

        public int normalizeMetaState(int i) {
            return kh.normalizeMetaState(i);
        }

        public boolean metaStateHasModifiers(int i, int i2) {
            return kh.metaStateHasModifiers(i, i2);
        }

        public boolean metaStateHasNoModifiers(int i) {
            return kh.metaStateHasNoModifiers(i);
        }

        public boolean mo3280c(KeyEvent keyEvent) {
            return kh.m11965c(keyEvent);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            Rv = new C3791b();
        } else {
            Rv = new C3790a();
        }
    }

    public static boolean m11962a(KeyEvent keyEvent, int i) {
        return Rv.metaStateHasModifiers(keyEvent.getMetaState(), i);
    }

    public static boolean m11963b(KeyEvent keyEvent) {
        return Rv.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public static boolean m11964c(KeyEvent keyEvent) {
        return Rv.mo3280c(keyEvent);
    }
}
