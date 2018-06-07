package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.fossil.gn;

public class PagerTabStrip extends PagerTitleStrip {
    private int RK;
    private int RL;
    private int RM;
    private int RN;
    private int RO;
    private int RP;
    private final Paint RQ;
    private int RR;
    private boolean RS;
    private boolean RT;
    private int RU;
    private boolean RV;
    private float RW;
    private float RX;
    private int mTouchSlop;
    private final Rect uU;

    class C01151 implements OnClickListener {
        final /* synthetic */ PagerTabStrip RY;

        C01151(PagerTabStrip pagerTabStrip) {
            this.RY = pagerTabStrip;
        }

        public void onClick(View view) {
            this.RY.RZ.setCurrentItem(this.RY.RZ.getCurrentItem() - 1);
        }
    }

    class C01162 implements OnClickListener {
        final /* synthetic */ PagerTabStrip RY;

        C01162(PagerTabStrip pagerTabStrip) {
            this.RY = pagerTabStrip;
        }

        public void onClick(View view) {
            this.RY.RZ.setCurrentItem(this.RY.RZ.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.RQ = new Paint();
        this.uU = new Rect();
        this.RR = 255;
        this.RS = false;
        this.RT = false;
        this.RK = this.Sn;
        this.RQ.setColor(this.RK);
        float f = context.getResources().getDisplayMetrics().density;
        this.RL = (int) ((3.0f * f) + 0.5f);
        this.RM = (int) ((6.0f * f) + 0.5f);
        this.RN = (int) (64.0f * f);
        this.RP = (int) ((16.0f * f) + 0.5f);
        this.RU = (int) ((1.0f * f) + 0.5f);
        this.RO = (int) ((f * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.Sa.setFocusable(true);
        this.Sa.setOnClickListener(new C01151(this));
        this.Sc.setFocusable(true);
        this.Sc.setOnClickListener(new C01162(this));
        if (getBackground() == null) {
            this.RS = true;
        }
    }

    public void setTabIndicatorColor(int i) {
        this.RK = i;
        this.RQ.setColor(this.RK);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(gn.m10634e(getContext(), i));
    }

    public int getTabIndicatorColor() {
        return this.RK;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.RM) {
            i4 = this.RM;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTextSpacing(int i) {
        if (i < this.RN) {
            i = this.RN;
        }
        super.setTextSpacing(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.RT) {
            this.RS = drawable == null;
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.RT) {
            this.RS = (-16777216 & i) == 0;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.RT) {
            this.RS = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.RS = z;
        this.RT = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.RS;
    }

    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.RO);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.RV) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.RW = x;
                this.RX = y;
                this.RV = false;
                break;
            case 1:
                if (x >= ((float) (this.Sb.getLeft() - this.RP))) {
                    if (x > ((float) (this.Sb.getRight() + this.RP))) {
                        this.RZ.setCurrentItem(this.RZ.getCurrentItem() + 1);
                        break;
                    }
                }
                this.RZ.setCurrentItem(this.RZ.getCurrentItem() - 1);
                break;
                break;
            case 2:
                if (Math.abs(x - this.RW) > ((float) this.mTouchSlop) || Math.abs(y - this.RX) > ((float) this.mTouchSlop)) {
                    this.RV = true;
                    break;
                }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.Sb.getLeft() - this.RP;
        int right = this.Sb.getRight() + this.RP;
        int i = height - this.RL;
        this.RQ.setColor((this.RR << 24) | (this.RK & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.RQ);
        if (this.RS) {
            this.RQ.setColor(-16777216 | (this.RK & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.RU), (float) (getWidth() - getPaddingRight()), (float) height, this.RQ);
        }
    }

    void mo89b(int i, float f, boolean z) {
        Rect rect = this.uU;
        int height = getHeight();
        int i2 = height - this.RL;
        rect.set(this.Sb.getLeft() - this.RP, i2, this.Sb.getRight() + this.RP, height);
        super.mo89b(i, f, z);
        this.RR = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.Sb.getLeft() - this.RP, i2, this.Sb.getRight() + this.RP, height);
        invalidate(rect);
    }
}
