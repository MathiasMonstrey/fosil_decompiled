package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.fossil.pk.C3991j;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class pz extends MenuInflater {
    static final Class<?>[] aeh = new Class[]{Context.class};
    static final Class<?>[] aei = aeh;
    final Object[] aej;
    final Object[] aek = this.aej;
    private Object ael;
    Context mContext;

    static class C4001a implements OnMenuItemClickListener {
        private static final Class<?>[] aem = new Class[]{MenuItem.class};
        private Object ael;
        private Method aen;

        public C4001a(Object obj, String str) {
            this.ael = obj;
            Class cls = obj.getClass();
            try {
                this.aen = cls.getMethod(str, aem);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.aen.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.aen.invoke(this.ael, new Object[]{menuItem})).booleanValue();
                }
                this.aen.invoke(this.ael, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    class C4002b {
        private int aeA;
        private char aeB;
        private char aeC;
        private int aeD;
        private boolean aeE;
        private boolean aeF;
        private boolean aeG;
        private int aeH;
        private int aeI;
        private String aeJ;
        private String aeK;
        private String aeL;
        kc aeM;
        final /* synthetic */ pz aeN;
        private Menu aeo;
        private int aep;
        private int aeq;
        private int aer;
        private int aes;
        private boolean aet;
        private boolean aeu;
        private boolean aev;
        private int aew;
        private int aex;
        private CharSequence aey;
        private CharSequence aez;

        public C4002b(pz pzVar, Menu menu) {
            this.aeN = pzVar;
            this.aeo = menu;
            ms();
        }

        public void ms() {
            this.aep = 0;
            this.aeq = 0;
            this.aer = 0;
            this.aes = 0;
            this.aet = true;
            this.aeu = true;
        }

        public void m13098g(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = this.aeN.mContext.obtainStyledAttributes(attributeSet, C3991j.MenuGroup);
            this.aep = obtainStyledAttributes.getResourceId(C3991j.MenuGroup_android_id, 0);
            this.aeq = obtainStyledAttributes.getInt(C3991j.MenuGroup_android_menuCategory, 0);
            this.aer = obtainStyledAttributes.getInt(C3991j.MenuGroup_android_orderInCategory, 0);
            this.aes = obtainStyledAttributes.getInt(C3991j.MenuGroup_android_checkableBehavior, 0);
            this.aet = obtainStyledAttributes.getBoolean(C3991j.MenuGroup_android_visible, true);
            this.aeu = obtainStyledAttributes.getBoolean(C3991j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void m13099h(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = this.aeN.mContext.obtainStyledAttributes(attributeSet, C3991j.MenuItem);
            this.aew = obtainStyledAttributes.getResourceId(C3991j.MenuItem_android_id, 0);
            this.aex = (obtainStyledAttributes.getInt(C3991j.MenuItem_android_menuCategory, this.aeq) & -65536) | (obtainStyledAttributes.getInt(C3991j.MenuItem_android_orderInCategory, this.aer) & 65535);
            this.aey = obtainStyledAttributes.getText(C3991j.MenuItem_android_title);
            this.aez = obtainStyledAttributes.getText(C3991j.MenuItem_android_titleCondensed);
            this.aeA = obtainStyledAttributes.getResourceId(C3991j.MenuItem_android_icon, 0);
            this.aeB = ad(obtainStyledAttributes.getString(C3991j.MenuItem_android_alphabeticShortcut));
            this.aeC = ad(obtainStyledAttributes.getString(C3991j.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(C3991j.MenuItem_android_checkable)) {
                this.aeD = obtainStyledAttributes.getBoolean(C3991j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.aeD = this.aes;
            }
            this.aeE = obtainStyledAttributes.getBoolean(C3991j.MenuItem_android_checked, false);
            this.aeF = obtainStyledAttributes.getBoolean(C3991j.MenuItem_android_visible, this.aet);
            this.aeG = obtainStyledAttributes.getBoolean(C3991j.MenuItem_android_enabled, this.aeu);
            this.aeH = obtainStyledAttributes.getInt(C3991j.MenuItem_showAsAction, -1);
            this.aeL = obtainStyledAttributes.getString(C3991j.MenuItem_android_onClick);
            this.aeI = obtainStyledAttributes.getResourceId(C3991j.MenuItem_actionLayout, 0);
            this.aeJ = obtainStyledAttributes.getString(C3991j.MenuItem_actionViewClass);
            this.aeK = obtainStyledAttributes.getString(C3991j.MenuItem_actionProviderClass);
            if (this.aeK == null) {
                z = false;
            }
            if (z && this.aeI == 0 && this.aeJ == null) {
                this.aeM = (kc) m13096a(this.aeK, pz.aei, this.aeN.aek);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.aeM = null;
            }
            obtainStyledAttributes.recycle();
            this.aev = false;
        }

        private char ad(String str) {
            if (str == null) {
                return '\u0000';
            }
            return str.charAt(0);
        }

        private void m13097f(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.aeE).setVisible(this.aeF).setEnabled(this.aeG).setCheckable(this.aeD >= 1).setTitleCondensed(this.aez).setIcon(this.aeA).setAlphabeticShortcut(this.aeB).setNumericShortcut(this.aeC);
            if (this.aeH >= 0) {
                kp.a(menuItem, this.aeH);
            }
            if (this.aeL != null) {
                if (this.aeN.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new C4001a(this.aeN.mr(), this.aeL));
            }
            if (menuItem instanceof ql) {
                ql qlVar = (ql) menuItem;
            }
            if (this.aeD >= 2) {
                if (menuItem instanceof ql) {
                    ((ql) menuItem).ad(true);
                } else if (menuItem instanceof qm) {
                    ((qm) menuItem).ad(true);
                }
            }
            if (this.aeJ != null) {
                kp.a(menuItem, (View) m13096a(this.aeJ, pz.aeh, this.aeN.aej));
            } else {
                z = false;
            }
            if (this.aeI > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    kp.b(menuItem, this.aeI);
                }
            }
            if (this.aeM != null) {
                kp.a(menuItem, this.aeM);
            }
        }

        public void mt() {
            this.aev = true;
            m13097f(this.aeo.add(this.aep, this.aew, this.aex, this.aey));
        }

        public SubMenu mu() {
            this.aev = true;
            SubMenu addSubMenu = this.aeo.addSubMenu(this.aep, this.aew, this.aex, this.aey);
            m13097f(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean mv() {
            return this.aev;
        }

        private <T> T m13096a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.aeN.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Throwable e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }

    public pz(Context context) {
        super(context);
        this.mContext = context;
        this.aej = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof hu) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.mContext.getResources().getLayout(i);
                m13100a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13100a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        r10 = this;
        r4 = 0;
        r1 = 1;
        r6 = 0;
        r7 = new com.fossil.pz$b;
        r7.<init>(r10, r13);
        r0 = r11.getEventType();
    L_0x000c:
        r2 = 2;
        if (r0 != r2) goto L_0x004a;
    L_0x000f:
        r0 = r11.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r2 = r4;
        r5 = r6;
        r3 = r0;
        r0 = r6;
    L_0x0023:
        if (r0 != 0) goto L_0x00dd;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x00d5;
            case 2: goto L_0x0051;
            case 3: goto L_0x0087;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5;
    L_0x0029:
        r5 = r11.next();
        r9 = r3;
        r3 = r5;
        r5 = r9;
        goto L_0x0023;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Expecting menu, got ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r11.next();
        if (r0 != r1) goto L_0x000c;
    L_0x0050:
        goto L_0x001f;
    L_0x0051:
        if (r5 == 0) goto L_0x0055;
    L_0x0053:
        r3 = r5;
        goto L_0x0029;
    L_0x0055:
        r3 = r11.getName();
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0066;
    L_0x0061:
        r7.m13098g(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0066:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0073;
    L_0x006e:
        r7.m13099h(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0073:
        r8 = "menu";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0084;
    L_0x007b:
        r3 = r7.mu();
        r10.m13100a(r11, r12, r3);
        r3 = r5;
        goto L_0x0029;
    L_0x0084:
        r2 = r3;
        r3 = r1;
        goto L_0x0029;
    L_0x0087:
        r3 = r11.getName();
        if (r5 == 0) goto L_0x0096;
    L_0x008d:
        r8 = r3.equals(r2);
        if (r8 == 0) goto L_0x0096;
    L_0x0093:
        r2 = r4;
        r3 = r6;
        goto L_0x0029;
    L_0x0096:
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00a3;
    L_0x009e:
        r7.ms();
        r3 = r5;
        goto L_0x0029;
    L_0x00a3:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00c9;
    L_0x00ab:
        r3 = r7.mv();
        if (r3 != 0) goto L_0x0028;
    L_0x00b1:
        r3 = r7.aeM;
        if (r3 == 0) goto L_0x00c3;
    L_0x00b5:
        r3 = r7.aeM;
        r3 = r3.hasSubMenu();
        if (r3 == 0) goto L_0x00c3;
    L_0x00bd:
        r7.mu();
        r3 = r5;
        goto L_0x0029;
    L_0x00c3:
        r7.mt();
        r3 = r5;
        goto L_0x0029;
    L_0x00c9:
        r8 = "menu";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x0028;
    L_0x00d1:
        r0 = r1;
        r3 = r5;
        goto L_0x0029;
    L_0x00d5:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x00dd:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.pz.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object mr() {
        if (this.ael == null) {
            this.ael = aR(this.mContext);
        }
        return this.ael;
    }

    private Object aR(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return aR(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }
}
