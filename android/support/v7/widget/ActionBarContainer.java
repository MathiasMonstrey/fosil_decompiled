package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.fossil.li;
import com.fossil.pk.f;
import com.fossil.pk.j;
import com.fossil.qz;
import com.fossil.ra;
import com.fossil.sn;

public class ActionBarContainer extends FrameLayout {
    public Drawable aga;
    private boolean ahE;
    private View ahF;
    private View ahG;
    private View ahH;
    public Drawable ahI;
    public Drawable ahJ;
    public boolean ahK;
    public boolean ahL;
    private int pT;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable raVar;
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 21) {
            raVar = new ra(this);
        } else {
            raVar = new qz(this);
        }
        li.m12248a((View) this, raVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBar);
        this.aga = obtainStyledAttributes.getDrawable(j.ActionBar_background);
        this.ahI = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundStacked);
        this.pT = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_height, -1);
        if (getId() == f.split_action_bar) {
            this.ahK = true;
            this.ahJ = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.ahK ? this.ahJ == null : this.aga == null && this.ahI == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.ahG = findViewById(f.action_bar);
        this.ahH = findViewById(f.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.aga != null) {
            this.aga.setCallback(null);
            unscheduleDrawable(this.aga);
        }
        this.aga = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.ahG != null) {
                this.aga.setBounds(this.ahG.getLeft(), this.ahG.getTop(), this.ahG.getRight(), this.ahG.getBottom());
            }
        }
        if (this.ahK) {
            if (this.ahJ != null) {
                z = false;
            }
        } else if (!(this.aga == null && this.ahI == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.ahI != null) {
            this.ahI.setCallback(null);
            unscheduleDrawable(this.ahI);
        }
        this.ahI = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.ahL && this.ahI != null) {
                this.ahI.setBounds(this.ahF.getLeft(), this.ahF.getTop(), this.ahF.getRight(), this.ahF.getBottom());
            }
        }
        if (this.ahK) {
            if (this.ahJ != null) {
                z = false;
            }
        } else if (!(this.aga == null && this.ahI == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.ahJ != null) {
            this.ahJ.setCallback(null);
            unscheduleDrawable(this.ahJ);
        }
        this.ahJ = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.ahK && this.ahJ != null) {
                this.ahJ.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.ahK) {
            if (this.ahJ != null) {
                z = false;
            }
        } else if (!(this.aga == null && this.ahI == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.aga != null) {
            this.aga.setVisible(z, false);
        }
        if (this.ahI != null) {
            this.ahI.setVisible(z, false);
        }
        if (this.ahJ != null) {
            this.ahJ.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.aga && !this.ahK) || ((drawable == this.ahI && this.ahL) || ((drawable == this.ahJ && this.ahK) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aga != null && this.aga.isStateful()) {
            this.aga.setState(getDrawableState());
        }
        if (this.ahI != null && this.ahI.isStateful()) {
            this.ahI.setState(getDrawableState());
        }
        if (this.ahJ != null && this.ahJ.isStateful()) {
            this.ahJ.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.aga != null) {
                this.aga.jumpToCurrentState();
            }
            if (this.ahI != null) {
                this.ahI.jumpToCurrentState();
            }
            if (this.ahJ != null) {
                this.ahJ.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.ahE = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.ahE || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(sn snVar) {
        if (this.ahF != null) {
            removeView(this.ahF);
        }
        this.ahF = snVar;
        if (snVar != null) {
            addView(snVar);
            LayoutParams layoutParams = snVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            snVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.ahF;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    private boolean br(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int bs(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.ahG == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.pT >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.pT, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.ahG != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.ahF != null && this.ahF.getVisibility() != 8 && mode != 1073741824) {
                int bs;
                if (!br(this.ahG)) {
                    bs = bs(this.ahG);
                } else if (br(this.ahH)) {
                    bs = 0;
                } else {
                    bs = bs(this.ahH);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(bs + bs(this.ahF), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.ahF;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.ahK) {
            int i6;
            if (this.aga != null) {
                if (this.ahG.getVisibility() == 0) {
                    this.aga.setBounds(this.ahG.getLeft(), this.ahG.getTop(), this.ahG.getRight(), this.ahG.getBottom());
                } else if (this.ahH == null || this.ahH.getVisibility() != 0) {
                    this.aga.setBounds(0, 0, 0, 0);
                } else {
                    this.aga.setBounds(this.ahH.getLeft(), this.ahH.getTop(), this.ahH.getRight(), this.ahH.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.ahL = z2;
            if (!z2 || this.ahI == null) {
                i5 = i6;
            } else {
                this.ahI.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.ahJ != null) {
            this.ahJ.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}
