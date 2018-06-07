package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fossil.ag.C1623d;
import com.fossil.ag.C1625f;
import com.fossil.ag.C1630k;
import com.fossil.ar.C1071c;
import com.fossil.li;

public class SnackbarContentLayout extends LinearLayout implements C1071c {
    private int mMaxWidth;
    private TextView uW;
    private Button uX;
    private int uY;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.SnackbarLayout);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(C1630k.SnackbarLayout_android_maxWidth, -1);
        this.uY = obtainStyledAttributes.getDimensionPixelSize(C1630k.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.uW = (TextView) findViewById(C1625f.snackbar_text);
        this.uX = (Button) findViewById(C1625f.snackbar_action);
    }

    public TextView getMessageView() {
        return this.uW;
    }

    public Button getActionView() {
        return this.uX;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mMaxWidth > 0 && getMeasuredWidth() > this.mMaxWidth) {
            i = MeasureSpec.makeMeasureSpec(this.mMaxWidth, 1073741824);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C1623d.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C1623d.design_snackbar_padding_vertical);
        int i3 = this.uW.getLayout().getLineCount() > 1 ? 1 : 0;
        if (i3 == 0 || this.uY <= 0 || this.uX.getMeasuredWidth() <= this.uY) {
            if (i3 == 0) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (m1741d(0, dimensionPixelSize, dimensionPixelSize)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        } else {
            if (m1741d(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        }
        if (dimensionPixelSize != 0) {
            super.onMeasure(i, i2);
        }
    }

    private boolean m1741d(int i, int i2, int i3) {
        boolean z = false;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        }
        if (this.uW.getPaddingTop() == i2 && this.uW.getPaddingBottom() == i3) {
            return z;
        }
        m1740a(this.uW, i2, i3);
        return true;
    }

    private static void m1740a(View view, int i, int i2) {
        if (li.an(view)) {
            li.m12261e(view, li.m12240X(view), i, li.m12241Y(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    public void mo12k(int i, int i2) {
        li.m12264g(this.uW, 0.0f);
        li.ae(this.uW).m12420y(1.0f).m12418n((long) i2).m12419o((long) i).start();
        if (this.uX.getVisibility() == 0) {
            li.m12264g(this.uX, 0.0f);
            li.ae(this.uX).m12420y(1.0f).m12418n((long) i2).m12419o((long) i).start();
        }
    }

    public void mo13l(int i, int i2) {
        li.m12264g(this.uW, 1.0f);
        li.ae(this.uW).m12420y(0.0f).m12418n((long) i2).m12419o((long) i).start();
        if (this.uX.getVisibility() == 0) {
            li.m12264g(this.uX, 1.0f);
            li.ae(this.uX).m12420y(0.0f).m12418n((long) i2).m12419o((long) i).start();
        }
    }
}
