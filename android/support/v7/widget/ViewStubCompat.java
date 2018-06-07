package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.fossil.pk.j;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private LayoutInflater Yg;
    private int awi;
    private int awj;
    private WeakReference<View> awk;
    private C1286a awl;

    public interface C1286a {
        void m2603a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awi = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ViewStubCompat, i, 0);
        this.awj = obtainStyledAttributes.getResourceId(j.ViewStubCompat_android_inflatedId, -1);
        this.awi = obtainStyledAttributes.getResourceId(j.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(j.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.awj;
    }

    public void setInflatedId(int i) {
        this.awj = i;
    }

    public int getLayoutResource() {
        return this.awi;
    }

    public void setLayoutResource(int i) {
        this.awi = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.Yg = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.Yg;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void draw(Canvas canvas) {
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void setVisibility(int i) {
        if (this.awk != null) {
            View view = (View) this.awk.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            inflate();
        }
    }

    public View inflate() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.awi != 0) {
            LayoutInflater layoutInflater;
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.Yg != null) {
                layoutInflater = this.Yg;
            } else {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.awi, viewGroup, false);
            if (this.awj != -1) {
                inflate.setId(this.awj);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.awk = new WeakReference(inflate);
            if (this.awl != null) {
                this.awl.m2603a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public void setOnInflateListener(C1286a c1286a) {
        this.awl = c1286a;
    }
}
