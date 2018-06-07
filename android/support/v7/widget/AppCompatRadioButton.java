package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.fossil.oo;
import com.fossil.pk.a;
import com.fossil.pn;
import com.fossil.rf;
import com.fossil.st;

public class AppCompatRadioButton extends RadioButton implements oo {
    private final rf ako;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(st.C(context), attributeSet, i);
        this.ako = new rf(this);
        this.ako.a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.ako != null) {
            this.ako.os();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(pn.c(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.ako != null ? this.ako.cR(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.ako != null) {
            this.ako.setSupportButtonTintList(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        return this.ako != null ? this.ako.getSupportButtonTintList() : null;
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.ako != null) {
            this.ako.setSupportButtonTintMode(mode);
        }
    }

    public Mode getSupportButtonTintMode() {
        return this.ako != null ? this.ako.getSupportButtonTintMode() : null;
    }
}
