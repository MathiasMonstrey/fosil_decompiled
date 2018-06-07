package android.support.v4.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.SwipeRefreshLayout.C1175b;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout.LayoutParams;
import com.fossil.ks;
import com.fossil.li;
import com.fossil.od;

public class FossilSwipeRefreshLayout extends SwipeRefreshLayout {
    private View HB;
    private int WU;
    private od WV;
    private int WW;

    public FossilSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public FossilSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.WW = 0;
        this.WV = new od(getContext());
        this.WV.setVisibility(8);
        this.WW = ((int) getResources().getDisplayMetrics().density) * 800;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!childAt.equals(this.YV)) {
                this.HB = childAt;
                break;
            }
        }
        this.YV.setImageResource(17170445);
        this.YV.bJ(17170445);
        addView(this.WV, 2, new LayoutParams(-1, this.WW));
        if (VERSION.SDK_INT >= 21) {
            this.YV.setElevation(0.0f);
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.WV.measure(i, MeasureSpec.makeMeasureSpec(this.WW, 1073741824));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.YV.getVisibility() == 0) {
            this.WV.setVisibility(0);
            this.WV.onStart();
        } else {
            this.WV.setVisibility(8);
            this.WV.onStop();
        }
        this.WV.layout(0, -this.WW, this.WV.getMeasuredWidth(), 0);
    }

    void mo103f(int i, boolean z) {
        if (this.HB != null && !this.YH) {
            if (this.HB.getTop() + i >= 0) {
                li.m12274p(this.HB, i);
                li.m12274p(this.WV, i);
            }
            li.m12274p(this.YV, i);
            this.YQ = this.YV.getTop();
        }
    }

    public void setOnRefreshListener(final C1175b c1175b) {
        super.setOnRefreshListener(new C1175b(this) {
            final /* synthetic */ FossilSwipeRefreshLayout WY;

            public void kA() {
                c1175b.kA();
                this.WY.Za = this.WY.WU;
                this.WY.reset();
            }
        });
    }

    public void setRefreshing(boolean z) {
        super.setRefreshing(z);
        this.WV.setVisibility(0);
        this.WV.onStart();
    }

    void reset() {
        super.reset();
        this.WV.onStop();
        this.WV.setVisibility(8);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        super.onNestedPreScroll(view, i, i2, iArr);
        if (this.YV.getVisibility() == 0) {
            this.WV.setVisibility(0);
            this.WV.onStart();
            return;
        }
        this.WV.setVisibility(8);
        this.WV.onStop();
    }

    void mo102D(float f) {
        super.mo102D(f);
        if (this.WU != 0) {
            this.Za = this.WU;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = ks.m12043a(motionEvent);
        if (this.Za != 0) {
            this.WU = this.Za;
        }
        if (a == 1) {
            this.Za = 0;
        }
        return super.onTouchEvent(motionEvent);
    }
}
