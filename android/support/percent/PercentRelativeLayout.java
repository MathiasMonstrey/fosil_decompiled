package android.support.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.fossil.cg;
import com.fossil.cg.C1131b;
import com.fossil.cg.C2032a;

public class PercentRelativeLayout extends RelativeLayout {
    private final cg Ft = new cg(this);

    public static class LayoutParams extends android.widget.RelativeLayout.LayoutParams implements C1131b {
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
        return hv();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1976f(attributeSet);
    }

    public /* synthetic */ android.widget.RelativeLayout.LayoutParams m16381generateLayoutParams(AttributeSet attributeSet) {
        return m1976f(attributeSet);
    }

    public PercentRelativeLayout(Context context) {
        super(context);
    }

    public PercentRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PercentRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected LayoutParams hv() {
        return new LayoutParams(-1, -1);
    }

    public LayoutParams m1976f(AttributeSet attributeSet) {
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
