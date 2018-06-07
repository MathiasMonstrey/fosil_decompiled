package android.support.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.fossil.cg;
import com.fossil.cg.C1131b;
import com.fossil.cg.C2032a;

public class PercentFrameLayout extends FrameLayout {
    private final cg Ft = new cg(this);

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams implements C1131b {
        private C2032a Fu;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.Fu = cg.m6231b(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public C2032a hs() {
            if (this.Fu == null) {
                this.Fu = new C2032a();
            }
            return this.Fu;
        }

        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            cg.m6229a(this, typedArray, i, i2);
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return hr();
    }

    protected /* synthetic */ android.widget.FrameLayout.LayoutParams m16379generateDefaultLayoutParams() {
        return hr();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1975e(attributeSet);
    }

    public /* synthetic */ android.widget.FrameLayout.LayoutParams m16380generateLayoutParams(AttributeSet attributeSet) {
        return m1975e(attributeSet);
    }

    public PercentFrameLayout(Context context) {
        super(context);
    }

    public PercentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PercentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected LayoutParams hr() {
        return new LayoutParams(-1, -1);
    }

    public LayoutParams m1975e(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        this.Ft.m6233u(i, i2);
        super.onMeasure(i, i2);
        if (this.Ft.hu()) {
            super.onMeasure(i, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.Ft.ht();
    }
}
