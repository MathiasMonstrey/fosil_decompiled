package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import com.fossil.pn;
import com.fossil.rk;
import com.fossil.st;
import com.fossil.sw;

public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] afU = new int[]{16843016};
    private final rk aki;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(st.C(context), attributeSet, i);
        this.aki = rk.d(this);
        this.aki.a(attributeSet, i);
        this.aki.oB();
        sw a = sw.a(getContext(), attributeSet, afU, i, 0);
        setCheckMarkDrawable(a.getDrawable(0));
        a.recycle();
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(pn.c(getContext(), i));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.aki != null) {
            this.aki.q(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aki != null) {
            this.aki.oB();
        }
    }
}
