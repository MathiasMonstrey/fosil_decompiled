package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;
import com.fossil.lf;
import com.fossil.pk.a;
import com.fossil.re;
import com.fossil.rk;
import com.fossil.st;

public class AppCompatEditText extends EditText implements lf {
    private final re akh;
    private final rk aki;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(st.C(context), attributeSet, i);
        this.akh = new re(this);
        this.akh.a(attributeSet, i);
        this.aki = rk.d(this);
        this.aki.a(attributeSet, i);
        this.aki.oB();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.akh != null) {
            this.akh.cQ(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.akh != null) {
            this.akh.o(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.akh != null) {
            this.akh.setSupportBackgroundTintList(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.akh != null ? this.akh.getSupportBackgroundTintList() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.akh != null) {
            this.akh.setSupportBackgroundTintMode(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.akh != null ? this.akh.getSupportBackgroundTintMode() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.akh != null) {
            this.akh.op();
        }
        if (this.aki != null) {
            this.aki.oB();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.aki != null) {
            this.aki.q(context, i);
        }
    }
}
