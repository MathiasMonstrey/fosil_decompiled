package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fossil.li;
import com.fossil.lz;
import com.fossil.pk.a;
import com.fossil.pk.f;
import com.fossil.pk.g;
import com.fossil.pk.j;
import com.fossil.pu;
import com.fossil.qj;
import com.fossil.qy;
import com.fossil.rb;
import com.fossil.sw;
import com.fossil.tb;

public class ActionBarContextView extends qy {
    private View BP;
    private CharSequence Od;
    private CharSequence Oe;
    private TextView aak;
    private View ahM;
    private LinearLayout ahN;
    private TextView ahO;
    private int ahP;
    private int ahQ;
    private boolean ahR;
    private int ahS;

    public /* bridge */ /* synthetic */ lz m2182c(int i, long j) {
        return super.c(i, j);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        sw a = sw.a(context, attributeSet, j.ActionMode, i, 0);
        li.m12248a((View) this, a.getDrawable(j.ActionMode_background));
        this.ahP = a.getResourceId(j.ActionMode_titleTextStyle, 0);
        this.ahQ = a.getResourceId(j.ActionMode_subtitleTextStyle, 0);
        this.ahx = a.getLayoutDimension(j.ActionMode_height, 0);
        this.ahS = a.getResourceId(j.ActionMode_closeItemLayout, g.abc_action_mode_close_item_material);
        a.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ahw != null) {
            this.ahw.hideOverflowMenu();
            this.ahw.nM();
        }
    }

    public void setContentHeight(int i) {
        this.ahx = i;
    }

    public void setCustomView(View view) {
        if (this.BP != null) {
            removeView(this.BP);
        }
        this.BP = view;
        if (!(view == null || this.ahN == null)) {
            removeView(this.ahN);
            this.ahN = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.Od = charSequence;
        nx();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.Oe = charSequence;
        nx();
    }

    public CharSequence getTitle() {
        return this.Od;
    }

    public CharSequence getSubtitle() {
        return this.Oe;
    }

    private void nx() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.ahN == null) {
            LayoutInflater.from(getContext()).inflate(g.abc_action_bar_title_item, this);
            this.ahN = (LinearLayout) getChildAt(getChildCount() - 1);
            this.aak = (TextView) this.ahN.findViewById(f.action_bar_title);
            this.ahO = (TextView) this.ahN.findViewById(f.action_bar_subtitle);
            if (this.ahP != 0) {
                this.aak.setTextAppearance(getContext(), this.ahP);
            }
            if (this.ahQ != 0) {
                this.ahO.setTextAppearance(getContext(), this.ahQ);
            }
        }
        this.aak.setText(this.Od);
        this.ahO.setText(this.Oe);
        Object obj2 = !TextUtils.isEmpty(this.Od) ? 1 : null;
        if (TextUtils.isEmpty(this.Oe)) {
            obj = null;
        }
        TextView textView = this.ahO;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.ahN;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.ahN.getParent() == null) {
            addView(this.ahN);
        }
    }

    public void m2183e(final pu puVar) {
        if (this.ahM == null) {
            this.ahM = LayoutInflater.from(getContext()).inflate(this.ahS, this, false);
            addView(this.ahM);
        } else if (this.ahM.getParent() == null) {
            addView(this.ahM);
        }
        this.ahM.findViewById(f.action_mode_close_button).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionBarContextView ahU;

            public void onClick(View view) {
                puVar.finish();
            }
        });
        qj qjVar = (qj) puVar.getMenu();
        if (this.ahw != null) {
            this.ahw.nL();
        }
        this.ahw = new rb(getContext());
        this.ahw.ai(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        qjVar.a(this.ahw, this.ahu);
        this.ahv = (ActionMenuView) this.ahw.a(this);
        li.m12248a(this.ahv, null);
        addView(this.ahv, layoutParams);
    }

    public void ny() {
        if (this.ahM == null) {
            nz();
        }
    }

    public void nz() {
        removeAllViews();
        this.BP = null;
        this.ahv = null;
    }

    public boolean showOverflowMenu() {
        if (this.ahw != null) {
            return this.ahw.showOverflowMenu();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int i5;
            int a;
            int size = MeasureSpec.getSize(i);
            if (this.ahx > 0) {
                i5 = this.ahx;
            } else {
                i5 = MeasureSpec.getSize(i2);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i6 = i5 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
            if (this.ahM != null) {
                a = a(this.ahM, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.ahM.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.ahv != null && this.ahv.getParent() == this) {
                paddingLeft = a(this.ahv, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.ahN != null && this.BP == null) {
                if (this.ahR) {
                    this.ahN.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.ahN.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.ahN.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = a(this.ahN, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.BP != null) {
                int min;
                LayoutParams layoutParams = this.BP.getLayoutParams();
                if (layoutParams.width != -2) {
                    makeMeasureSpec = 1073741824;
                } else {
                    makeMeasureSpec = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i6);
                } else {
                    min = i6;
                }
                this.BP.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.ahx <= 0) {
                makeMeasureSpec = getChildCount();
                i5 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= i5) {
                        paddingLeft = i5;
                    }
                    i4++;
                    i5 = paddingLeft;
                }
                setMeasuredDimension(size, i5);
                return;
            }
            setMeasuredDimension(size, i5);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean cH = tb.cH(this);
        int paddingRight = cH ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.ahM == null || this.ahM.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.ahM.getLayoutParams();
            i5 = cH ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = cH ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            i5 = a(paddingRight, i5, cH);
            i5 = a(a(this.ahM, i5, paddingTop, paddingTop2, cH) + i5, i6, cH);
        }
        if (!(this.ahN == null || this.BP != null || this.ahN.getVisibility() == 8)) {
            i5 += a(this.ahN, i5, paddingTop, paddingTop2, cH);
        }
        if (this.BP != null) {
            int a = a(this.BP, i5, paddingTop, paddingTop2, cH) + i5;
        }
        i5 = cH ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.ahv != null) {
            a = a(this.ahv, i5, paddingTop, paddingTop2, !cH) + i5;
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.Od);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.ahR) {
            requestLayout();
        }
        this.ahR = z;
    }

    public boolean isTitleOptional() {
        return this.ahR;
    }
}
