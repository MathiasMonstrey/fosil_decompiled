package com.fossil;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.widget.VisibilityAwareImageButton;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.fossil.ag.C1620a;
import com.fossil.aq.C1806a;
import com.fossil.bb.C1097a;
import com.fossil.bj.C1073c;
import com.fossil.bj.C1114a;
import com.fossil.bj.C1115b;
import com.fossil.bj.C1929d;

public class az extends bb {
    private final bh zp = new bh();
    be zq;

    abstract class C1904d extends C1115b implements C1073c {
        final /* synthetic */ az zt;
        private boolean zu;
        private float zv;
        private float zw;

        protected abstract float go();

        private C1904d(az azVar) {
            this.zt = azVar;
        }

        public void mo14a(bj bjVar) {
            if (!this.zu) {
                this.zv = this.zt.zq.gA();
                this.zw = go();
                this.zu = true;
            }
            this.zt.zq.m4918r(this.zv + ((this.zw - this.zv) * bjVar.getAnimatedFraction()));
        }

        public void mo71b(bj bjVar) {
            this.zt.zq.m4918r(this.zw);
            this.zu = false;
        }
    }

    class C1905a extends C1904d {
        final /* synthetic */ az zt;

        C1905a(az azVar) {
            this.zt = azVar;
            super();
        }

        protected float go() {
            return 0.0f;
        }
    }

    class C1906b extends C1904d {
        final /* synthetic */ az zt;

        C1906b(az azVar) {
            this.zt = azVar;
            super();
        }

        protected float go() {
            return this.zt.zF + this.zt.zG;
        }
    }

    class C1907c extends C1904d {
        final /* synthetic */ az zt;

        C1907c(az azVar) {
            this.zt = azVar;
            super();
        }

        protected float go() {
            return this.zt.zF;
        }
    }

    public az(VisibilityAwareImageButton visibilityAwareImageButton, bf bfVar, C1929d c1929d) {
        super(visibilityAwareImageButton, bfVar, c1929d);
        this.zp.m5154a(PRESSED_ENABLED_STATE_SET, m4732a(new C1906b(this)));
        this.zp.m5154a(zH, m4732a(new C1906b(this)));
        this.zp.m5154a(ENABLED_STATE_SET, m4732a(new C1907c(this)));
        this.zp.m5154a(EMPTY_STATE_SET, m4732a(new C1905a(this)));
    }

    void mo1224a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.zB = hh.m11635i(gv());
        hh.m11623a(this.zB, colorStateList);
        if (mode != null) {
            hh.m11626a(this.zB, mode);
        }
        this.zC = hh.m11635i(gv());
        hh.m11623a(this.zC, ae(i));
        if (i2 > 0) {
            this.zD = m4723a(i2, colorStateList);
            drawableArr = new Drawable[]{this.zD, this.zB, this.zC};
        } else {
            this.zD = null;
            drawableArr = new Drawable[]{this.zB, this.zC};
        }
        this.zE = new LayerDrawable(drawableArr);
        this.zq = new be(this.zI.getContext(), this.zE, this.zJ.getRadius(), this.zF, this.zF + this.zG);
        this.zq.m4917o(false);
        this.zJ.setBackgroundDrawable(this.zq);
    }

    void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.zB != null) {
            hh.m11623a(this.zB, colorStateList);
        }
        if (this.zD != null) {
            this.zD.m4494a(colorStateList);
        }
    }

    void setBackgroundTintMode(Mode mode) {
        if (this.zB != null) {
            hh.m11626a(this.zB, mode);
        }
    }

    void setRippleColor(int i) {
        if (this.zC != null) {
            hh.m11623a(this.zC, ae(i));
        }
    }

    float getElevation() {
        return this.zF;
    }

    void mo1227b(float f, float f2) {
        if (this.zq != null) {
            this.zq.m4916c(f, this.zG + f);
            gt();
        }
    }

    void mo1226a(int[] iArr) {
        this.zp.m5155b(iArr);
    }

    void gm() {
        this.zp.jumpToCurrentState();
    }

    void mo1225a(final C1097a c1097a, final boolean z) {
        if (!gy()) {
            this.zA = 1;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.zI.getContext(), C1620a.design_fab_out);
            loadAnimation.setInterpolator(aq.vd);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new C1806a(this) {
                final /* synthetic */ az zt;

                public void onAnimationEnd(Animation animation) {
                    this.zt.zA = 0;
                    this.zt.zI.m1863a(z ? 8 : 4, z);
                    if (c1097a != null) {
                        c1097a.gk();
                    }
                }
            });
            this.zI.startAnimation(loadAnimation);
        }
    }

    void mo1228b(final C1097a c1097a, boolean z) {
        if (!gx()) {
            this.zA = 2;
            this.zI.m1863a(0, z);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.zI.getContext(), C1620a.design_fab_in);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(aq.ve);
            loadAnimation.setAnimationListener(new C1806a(this) {
                final /* synthetic */ az zt;

                public void onAnimationEnd(Animation animation) {
                    this.zt.zA = 0;
                    if (c1097a != null) {
                        c1097a.gj();
                    }
                }
            });
            this.zI.startAnimation(loadAnimation);
        }
    }

    void gn() {
    }

    void mo1229d(Rect rect) {
        this.zq.getPadding(rect);
    }

    private bj m4732a(C1904d c1904d) {
        bj ha = this.zK.ha();
        ha.setInterpolator(zz);
        ha.setDuration(100);
        ha.m5221a((C1114a) c1904d);
        ha.m5222a((C1073c) c1904d);
        ha.m5223d(0.0f, 1.0f);
        return ha;
    }

    private static ColorStateList ae(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{zH, i, PRESSED_ENABLED_STATE_SET};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }
}
