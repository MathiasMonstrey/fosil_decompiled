package com.fossil;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.fossil.wearables.fsl.goaltracking.GoalTracking;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"NewApi"})
public class bt extends ca implements bs {
    private C1941a DE;
    private ArgbEvaluator DF;
    private AnimatorListener DG;
    private ArrayList<Object> DH;
    final Callback DI;
    private Context mContext;

    class C19401 implements Callback {
        final /* synthetic */ bt DJ;

        C19401(bt btVar) {
            this.DJ = btVar;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.DJ.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.DJ.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.DJ.unscheduleSelf(runnable);
        }
    }

    static class C1941a extends ConstantState {
        int DK;
        cb DL;
        AnimatorSet DM;
        private ArrayList<Animator> DN;
        jl<Animator, String> DP;

        public C1941a(Context context, C1941a c1941a, Callback callback, Resources resources) {
            int i = 0;
            if (c1941a != null) {
                this.DK = c1941a.DK;
                if (c1941a.DL != null) {
                    ConstantState constantState = c1941a.DL.getConstantState();
                    if (resources != null) {
                        this.DL = (cb) constantState.newDrawable(resources);
                    } else {
                        this.DL = (cb) constantState.newDrawable();
                    }
                    this.DL = (cb) this.DL.mutate();
                    this.DL.setCallback(callback);
                    this.DL.setBounds(c1941a.DL.getBounds());
                    this.DL.m5948u(false);
                }
                if (c1941a.DN != null) {
                    int size = c1941a.DN.size();
                    this.DN = new ArrayList(size);
                    this.DP = new jl(size);
                    while (i < size) {
                        Animator animator = (Animator) c1941a.DN.get(i);
                        Animator clone = animator.clone();
                        String str = (String) c1941a.DP.get(animator);
                        clone.setTarget(this.DL.m5946R(str));
                        this.DN.add(clone);
                        this.DP.put(clone, str);
                        i++;
                    }
                    hj();
                }
            }
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public int getChangingConfigurations() {
            return this.DK;
        }

        public void hj() {
            if (this.DM == null) {
                this.DM = new AnimatorSet();
            }
            this.DM.playTogether(this.DN);
        }
    }

    static class C1942b extends ConstantState {
        private final ConstantState DQ;

        public C1942b(ConstantState constantState) {
            this.DQ = constantState;
        }

        public Drawable newDrawable() {
            Drawable btVar = new bt();
            btVar.Ea = this.DQ.newDrawable();
            btVar.Ea.setCallback(btVar.DI);
            return btVar;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable btVar = new bt();
            btVar.Ea = this.DQ.newDrawable(resources);
            btVar.Ea.setCallback(btVar.DI);
            return btVar;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable btVar = new bt();
            btVar.Ea = this.DQ.newDrawable(resources, theme);
            btVar.Ea.setCallback(btVar.DI);
            return btVar;
        }

        public boolean canApplyTheme() {
            return this.DQ.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.DQ.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    bt() {
        this(null, null, null);
    }

    private bt(Context context) {
        this(context, null, null);
    }

    private bt(Context context, C1941a c1941a, Resources resources) {
        this.DF = null;
        this.DG = null;
        this.DH = null;
        this.DI = new C19401(this);
        this.mContext = context;
        if (c1941a != null) {
            this.DE = c1941a;
        } else {
            this.DE = new C1941a(context, c1941a, this.DI, resources);
        }
    }

    public Drawable mutate() {
        if (this.Ea != null) {
            this.Ea.mutate();
        }
        return this;
    }

    public static bt m5644a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        bt btVar = new bt(context);
        btVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return btVar;
    }

    public ConstantState getConstantState() {
        if (this.Ea != null) {
            return new C1942b(this.Ea.getConstantState());
        }
        return null;
    }

    public int getChangingConfigurations() {
        if (this.Ea != null) {
            return this.Ea.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.DE.DK;
    }

    public void draw(Canvas canvas) {
        if (this.Ea != null) {
            this.Ea.draw(canvas);
            return;
        }
        this.DE.DL.draw(canvas);
        if (this.DE.DM.isStarted()) {
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.Ea != null) {
            this.Ea.setBounds(rect);
        } else {
            this.DE.DL.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.Ea != null) {
            return this.Ea.setState(iArr);
        }
        return this.DE.DL.setState(iArr);
    }

    protected boolean onLevelChange(int i) {
        if (this.Ea != null) {
            return this.Ea.setLevel(i);
        }
        return this.DE.DL.setLevel(i);
    }

    public int getAlpha() {
        if (this.Ea != null) {
            return hh.m11631e(this.Ea);
        }
        return this.DE.DL.getAlpha();
    }

    public void setAlpha(int i) {
        if (this.Ea != null) {
            this.Ea.setAlpha(i);
        } else {
            this.DE.DL.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.Ea != null) {
            this.Ea.setColorFilter(colorFilter);
        } else {
            this.DE.DL.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        if (this.Ea != null) {
            hh.m11621a(this.Ea, i);
        } else {
            this.DE.DL.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.Ea != null) {
            hh.m11623a(this.Ea, colorStateList);
        } else {
            this.DE.DL.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.Ea != null) {
            hh.m11626a(this.Ea, mode);
        } else {
            this.DE.DL.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.Ea != null) {
            return this.Ea.setVisible(z, z2);
        }
        this.DE.DL.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public boolean isStateful() {
        if (this.Ea != null) {
            return this.Ea.isStateful();
        }
        return this.DE.DL.isStateful();
    }

    public int getOpacity() {
        if (this.Ea != null) {
            return this.Ea.getOpacity();
        }
        return this.DE.DL.getOpacity();
    }

    public int getIntrinsicWidth() {
        if (this.Ea != null) {
            return this.Ea.getIntrinsicWidth();
        }
        return this.DE.DL.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.Ea != null) {
            return this.Ea.getIntrinsicHeight();
        }
        return this.DE.DL.getIntrinsicHeight();
    }

    public boolean isAutoMirrored() {
        if (this.Ea != null) {
            return hh.m11630d(this.Ea);
        }
        return this.DE.DL.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        if (this.Ea != null) {
            this.Ea.setAutoMirrored(z);
        } else {
            this.DE.DL.setAutoMirrored(z);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (this.Ea != null) {
            hh.m11625a(this.Ea, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray a;
                if ("animated-vector".equals(name)) {
                    a = bz.m5835a(resources, theme, attributeSet, br.Dw);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        cb a2 = cb.m5940a(resources, resourceId, theme);
                        a2.m5948u(false);
                        a2.setCallback(this.DI);
                        if (this.DE.DL != null) {
                            this.DE.DL.setCallback(null);
                        }
                        this.DE.DL = a2;
                    }
                    a.recycle();
                } else if (GoalTracking.COLUMN_TARGET.equals(name)) {
                    a = resources.obtainAttributes(attributeSet, br.Dx);
                    String string = a.getString(0);
                    int resourceId2 = a.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.mContext != null) {
                            m5646a(string, bv.loadAnimator(this.mContext, resourceId2));
                        } else {
                            a.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.DE.hj();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void applyTheme(Theme theme) {
        if (this.Ea != null) {
            hh.m11624a(this.Ea, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.Ea != null) {
            return hh.m11632f(this.Ea);
        }
        return false;
    }

    private void m5645a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m5645a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.DF == null) {
                    this.DF = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.DF);
            }
        }
    }

    private void m5646a(String str, Animator animator) {
        animator.setTarget(this.DE.DL.m5946R(str));
        if (VERSION.SDK_INT < 21) {
            m5645a(animator);
        }
        if (this.DE.DN == null) {
            this.DE.DN = new ArrayList();
            this.DE.DP = new jl();
        }
        this.DE.DN.add(animator);
        this.DE.DP.put(animator, str);
    }

    public boolean isRunning() {
        if (this.Ea != null) {
            return ((AnimatedVectorDrawable) this.Ea).isRunning();
        }
        return this.DE.DM.isRunning();
    }

    public void start() {
        if (this.Ea != null) {
            ((AnimatedVectorDrawable) this.Ea).start();
        } else if (!this.DE.DM.isStarted()) {
            this.DE.DM.start();
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.Ea != null) {
            ((AnimatedVectorDrawable) this.Ea).stop();
        } else {
            this.DE.DM.end();
        }
    }
}
