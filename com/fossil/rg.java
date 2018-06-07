package com.fossil;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import com.fossil.pk.C3982a;
import com.fossil.pk.C3984c;
import com.fossil.pk.C3986e;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class rg {
    private static final int[] akA = new int[]{C3986e.abc_textfield_activated_mtrl_alpha, C3986e.abc_textfield_search_activated_mtrl_alpha, C3986e.abc_cab_background_top_mtrl_alpha, C3986e.abc_text_cursor_material, C3986e.abc_text_select_handle_left_mtrl_dark, C3986e.abc_text_select_handle_middle_mtrl_dark, C3986e.abc_text_select_handle_right_mtrl_dark, C3986e.abc_text_select_handle_left_mtrl_light, C3986e.abc_text_select_handle_middle_mtrl_light, C3986e.abc_text_select_handle_right_mtrl_light};
    private static final int[] akB = new int[]{C3986e.abc_popup_background_mtrl_mult, C3986e.abc_cab_background_internal_bg, C3986e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] akC = new int[]{C3986e.abc_tab_indicator_material, C3986e.abc_textfield_search_material};
    private static final int[] akD = new int[]{C3986e.abc_btn_check_material, C3986e.abc_btn_radio_material};
    private static final Mode akv = Mode.SRC_IN;
    private static rg akw;
    private static final C4044b akx = new C4044b(6);
    private static final int[] aky = new int[]{C3986e.abc_textfield_search_default_mtrl_alpha, C3986e.abc_textfield_default_mtrl_alpha, C3986e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] akz = new int[]{C3986e.abc_ic_commit_search_api_mtrl_alpha, C3986e.abc_seekbar_tick_mark_material, C3986e.abc_ic_menu_share_mtrl_alpha, C3986e.abc_ic_menu_copy_mtrl_am_alpha, C3986e.abc_ic_menu_cut_mtrl_alpha, C3986e.abc_ic_menu_selectall_mtrl_alpha, C3986e.abc_ic_menu_paste_mtrl_am_alpha};
    private WeakHashMap<Context, jw<ColorStateList>> akE;
    private jl<String, C4042c> akF;
    private jw<String> akG;
    private final Object akH = new Object();
    private final WeakHashMap<Context, jq<WeakReference<ConstantState>>> akI = new WeakHashMap(0);
    private TypedValue akJ;
    private boolean akK;

    interface C4042c {
        Drawable mo4070a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    @TargetApi(11)
    static class C4043a implements C4042c {
        C4043a() {
        }

        @SuppressLint({"NewApi"})
        public Drawable mo4070a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return bt.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    static class C4044b extends jr<Integer, PorterDuffColorFilter> {
        public C4044b(int i) {
            super(i);
        }

        PorterDuffColorFilter m13316d(int i, Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(C4044b.m13314e(i, mode)));
        }

        PorterDuffColorFilter m13315a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(C4044b.m13314e(i, mode)), porterDuffColorFilter);
        }

        private static int m13314e(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    static class C4045d implements C4042c {
        C4045d() {
        }

        @SuppressLint({"NewApi"})
        public Drawable mo4070a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return cb.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    public static rg ou() {
        if (akw == null) {
            akw = new rg();
            m13326a(akw);
        }
        return akw;
    }

    private static void m13326a(rg rgVar) {
        if (VERSION.SDK_INT < 24) {
            rgVar.m13327a("vector", new C4045d());
            if (VERSION.SDK_INT >= 11) {
                rgVar.m13327a("animated-vector", new C4043a());
            }
        }
    }

    public Drawable m13342c(Context context, int i) {
        return m13340a(context, i, false);
    }

    Drawable m13340a(Context context, int i, boolean z) {
        m13319B(context);
        Drawable m = m13334m(context, i);
        if (m == null) {
            m = m13333l(context, i);
        }
        if (m == null) {
            m = gn.c(context, i);
        }
        if (m != null) {
            m = m13322a(context, i, z, m);
        }
        if (m != null) {
            rv.m13471u(m);
        }
        return m;
    }

    public void m13344x(Context context) {
        synchronized (this.akH) {
            jq jqVar = (jq) this.akI.get(context);
            if (jqVar != null) {
                jqVar.clear();
            }
        }
    }

    private static long m13320a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable m13333l(Context context, int i) {
        if (this.akJ == null) {
            this.akJ = new TypedValue();
        }
        TypedValue typedValue = this.akJ;
        context.getResources().getValue(i, typedValue, true);
        long a = m13320a(typedValue);
        Drawable a2 = m13323a(context, a);
        if (a2 == null) {
            if (i == C3986e.abc_cab_background_top_material) {
                a2 = new LayerDrawable(new Drawable[]{m13342c(context, C3986e.abc_cab_background_internal_bg), m13342c(context, C3986e.abc_cab_background_top_mtrl_alpha)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                m13329a(context, a, a2);
            }
        }
        return a2;
    }

    private Drawable m13322a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList n = m13343n(context, i);
        if (n != null) {
            if (rv.m13472v(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = hh.i(drawable);
            hh.a(drawable, n);
            Mode cS = cS(i);
            if (cS == null) {
                return drawable;
            }
            hh.a(drawable, cS);
            return drawable;
        } else if (i == C3986e.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            m13324a(r0.findDrawableByLayerId(16908288), sr.m13576r(context, C3982a.colorControlNormal), akv);
            m13324a(r0.findDrawableByLayerId(16908303), sr.m13576r(context, C3982a.colorControlNormal), akv);
            m13324a(r0.findDrawableByLayerId(16908301), sr.m13576r(context, C3982a.colorControlActivated), akv);
            return drawable;
        } else if (i == C3986e.abc_ratingbar_material || i == C3986e.abc_ratingbar_indicator_material || i == C3986e.abc_ratingbar_small_material) {
            r0 = (LayerDrawable) drawable;
            m13324a(r0.findDrawableByLayerId(16908288), sr.m13578t(context, C3982a.colorControlNormal), akv);
            m13324a(r0.findDrawableByLayerId(16908303), sr.m13576r(context, C3982a.colorControlActivated), akv);
            m13324a(r0.findDrawableByLayerId(16908301), sr.m13576r(context, C3982a.colorControlActivated), akv);
            return drawable;
        } else if (m13328a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m13334m(android.content.Context r10, int r11) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 2;
        r7 = 1;
        r0 = r9.akF;
        if (r0 == 0) goto L_0x00bf;
    L_0x0007:
        r0 = r9.akF;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00bf;
    L_0x000f:
        r0 = r9.akG;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r9.akG;
        r0 = r0.get(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r9.akF;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new com.fossil.jw;
        r0.<init>();
        r9.akG = r0;
    L_0x0036:
        r0 = r9.akJ;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.akJ = r0;
    L_0x0041:
        r2 = r9.akJ;
        r0 = r10.getResources();
        r0.getValue(r11, r2, r7);
        r4 = m13320a(r2);
        r1 = r9.m13323a(r10, r4);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = r1;
        goto L_0x002e;
    L_0x0056:
        r3 = r2.string;
        if (r3 == 0) goto L_0x008a;
    L_0x005a:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x008a;
    L_0x0068:
        r3 = r0.getXml(r11);	 Catch:{ Exception -> 0x0082 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0082 }
    L_0x0070:
        r0 = r3.next();	 Catch:{ Exception -> 0x0082 }
        if (r0 == r8) goto L_0x0078;
    L_0x0076:
        if (r0 != r7) goto L_0x0070;
    L_0x0078:
        if (r0 == r8) goto L_0x0095;
    L_0x007a:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0082 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0082 }
        throw r0;	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        r0 = move-exception;
        r2 = "AppCompatDrawableManager";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x008a:
        r0 = r1;
    L_0x008b:
        if (r0 != 0) goto L_0x002e;
    L_0x008d:
        r1 = r9.akG;
        r2 = "appcompat_skip_skip";
        r1.append(r11, r2);
        goto L_0x002e;
    L_0x0095:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0082 }
        r7 = r9.akG;	 Catch:{ Exception -> 0x0082 }
        r7.append(r11, r0);	 Catch:{ Exception -> 0x0082 }
        r7 = r9.akF;	 Catch:{ Exception -> 0x0082 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = (com.fossil.rg.C4042c) r0;	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00a8:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x0082 }
        r1 = r0.mo4070a(r10, r3, r6, r7);	 Catch:{ Exception -> 0x0082 }
    L_0x00b0:
        if (r1 == 0) goto L_0x00bd;
    L_0x00b2:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0082 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = r9.m13329a(r10, r4, r1);	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00bd:
        r0 = r1;
        goto L_0x008b;
    L_0x00bf:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.rg.m(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m13323a(android.content.Context r5, long r6) {
        /*
        r4 = this;
        r2 = 0;
        r3 = r4.akH;
        monitor-enter(r3);
        r0 = r4.akI;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002b }
        r0 = (com.fossil.jq) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.get(r6);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0031;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r5.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0.delete(r6);	 Catch:{ all -> 0x002b }
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.rg.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private boolean m13329a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.akH) {
            jq jqVar = (jq) this.akI.get(context);
            if (jqVar == null) {
                jqVar = new jq();
                this.akI.put(context, jqVar);
            }
            jqVar.put(j, new WeakReference(constantState));
        }
        return true;
    }

    Drawable m13341a(Context context, sy syVar, int i) {
        Drawable m = m13334m(context, i);
        if (m == null) {
            m = syVar.eq(i);
        }
        if (m != null) {
            return m13322a(context, i, false, m);
        }
        return null;
    }

    static boolean m13328a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = akv;
        if (m13330a(aky, i)) {
            i2 = C3982a.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (m13330a(akA, i)) {
            i2 = C3982a.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (m13330a(akB, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C3986e.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else if (i == C3986e.abc_dialog_material_background) {
            i2 = 16842801;
            mode = mode2;
            z = true;
            i3 = -1;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (rv.m13472v(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(m13332c(sr.m13576r(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private void m13327a(String str, C4042c c4042c) {
        if (this.akF == null) {
            this.akF = new jl();
        }
        this.akF.put(str, c4042c);
    }

    private static boolean m13330a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    static Mode cS(int i) {
        if (i == C3986e.abc_switch_thumb_material) {
            return Mode.MULTIPLY;
        }
        return null;
    }

    ColorStateList m13343n(Context context, int i) {
        ColorStateList o = m13335o(context, i);
        if (o == null) {
            if (i == C3986e.abc_edit_text_material) {
                o = pn.m13080d(context, C3984c.abc_tint_edittext);
            } else if (i == C3986e.abc_switch_track_mtrl_alpha) {
                o = pn.m13080d(context, C3984c.abc_tint_switch_track);
            } else if (i == C3986e.abc_switch_thumb_material) {
                o = pn.m13080d(context, C3984c.abc_tint_switch_thumb);
            } else if (i == C3986e.abc_btn_default_mtrl_shape) {
                o = m13338y(context);
            } else if (i == C3986e.abc_btn_borderless_material) {
                o = m13339z(context);
            } else if (i == C3986e.abc_btn_colored_material) {
                o = m13318A(context);
            } else if (i == C3986e.abc_spinner_mtrl_am_alpha || i == C3986e.abc_spinner_textfield_background_material) {
                o = pn.m13080d(context, C3984c.abc_tint_spinner);
            } else if (m13330a(akz, i)) {
                o = sr.m13577s(context, C3982a.colorControlNormal);
            } else if (m13330a(akC, i)) {
                o = pn.m13080d(context, C3984c.abc_tint_default);
            } else if (m13330a(akD, i)) {
                o = pn.m13080d(context, C3984c.abc_tint_btn_checkable);
            } else if (i == C3986e.abc_seekbar_thumb_material) {
                o = pn.m13080d(context, C3984c.abc_tint_seek_thumb);
            }
            if (o != null) {
                m13331b(context, i, o);
            }
        }
        return o;
    }

    private ColorStateList m13335o(Context context, int i) {
        if (this.akE == null) {
            return null;
        }
        jw jwVar = (jw) this.akE.get(context);
        if (jwVar != null) {
            return (ColorStateList) jwVar.get(i);
        }
        return null;
    }

    private void m13331b(Context context, int i, ColorStateList colorStateList) {
        if (this.akE == null) {
            this.akE = new WeakHashMap();
        }
        jw jwVar = (jw) this.akE.get(context);
        if (jwVar == null) {
            jwVar = new jw();
            this.akE.put(context, jwVar);
        }
        jwVar.append(i, colorStateList);
    }

    private ColorStateList m13338y(Context context) {
        return m13336p(context, sr.m13576r(context, C3982a.colorButtonNormal));
    }

    private ColorStateList m13339z(Context context) {
        return m13336p(context, 0);
    }

    private ColorStateList m13318A(Context context) {
        return m13336p(context, sr.m13576r(context, C3982a.colorAccent));
    }

    private ColorStateList m13336p(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int r = sr.m13576r(context, C3982a.colorControlHighlight);
        int t = sr.m13578t(context, C3982a.colorButtonNormal);
        r0[0] = sr.vK;
        r1[0] = t;
        r0[1] = sr.PRESSED_STATE_SET;
        r1[1] = hg.v(r, i);
        r0[2] = sr.FOCUSED_STATE_SET;
        r1[2] = hg.v(r, i);
        r0[3] = sr.EMPTY_STATE_SET;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    static void m13325a(Drawable drawable, su suVar, int[] iArr) {
        if (!rv.m13472v(drawable) || drawable.mutate() == drawable) {
            if (suVar.auW || suVar.auV) {
                drawable.setColorFilter(m13321a(suVar.auW ? suVar.auU : null, suVar.auV ? suVar.Fd : akv, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private static PorterDuffColorFilter m13321a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m13332c(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static PorterDuffColorFilter m13332c(int i, Mode mode) {
        PorterDuffColorFilter d = akx.m13316d(i, mode);
        if (d != null) {
            return d;
        }
        d = new PorterDuffColorFilter(i, mode);
        akx.m13315a(i, mode, d);
        return d;
    }

    private static void m13324a(Drawable drawable, int i, Mode mode) {
        if (rv.m13472v(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = akv;
        }
        drawable.setColorFilter(m13332c(i, mode));
    }

    private void m13319B(Context context) {
        if (!this.akK) {
            this.akK = true;
            Drawable c = m13342c(context, C3986e.abc_vector_test);
            if (c == null || !m13337q(c)) {
                this.akK = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static boolean m13337q(Drawable drawable) {
        return (drawable instanceof cb) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}
