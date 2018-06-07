package com.fossil;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.fossil.gd.C3617a;
import com.fossil.gd.C3617a.C3611a;

public final class gb extends C3617a {
    private static final C3613a Me;
    public static final C3611a Mf = new C36121();
    private final Bundle KV;
    private final String Ma;
    private final CharSequence Mb;
    private final CharSequence[] Mc;
    private final boolean Md;

    static class C36121 implements C3611a {
        C36121() {
        }
    }

    interface C3613a {
    }

    static class C3614b implements C3613a {
        C3614b() {
        }
    }

    static class C3615c implements C3613a {
        C3615c() {
        }
    }

    static class C3616d implements C3613a {
        C3616d() {
        }
    }

    public String getResultKey() {
        return this.Ma;
    }

    public CharSequence getLabel() {
        return this.Mb;
    }

    public CharSequence[] getChoices() {
        return this.Mc;
    }

    public boolean getAllowFreeFormInput() {
        return this.Md;
    }

    public Bundle getExtras() {
        return this.KV;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            Me = new C3614b();
        } else if (VERSION.SDK_INT >= 16) {
            Me = new C3616d();
        } else {
            Me = new C3615c();
        }
    }
}
