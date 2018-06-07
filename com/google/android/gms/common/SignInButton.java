package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.fossil.arv.C1876d;
import com.fossil.awh;
import com.fossil.awi;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.dynamic.zzq;

public final class SignInButton extends FrameLayout implements OnClickListener {
    private int LA;
    private View bfP;
    private OnClickListener bfQ;
    private int mSize;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfQ = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1876d.SignInButton, 0, 0);
        try {
            this.mSize = obtainStyledAttributes.getInt(C1876d.SignInButton_buttonSize, 0);
            this.LA = obtainStyledAttributes.getInt(C1876d.SignInButton_colorScheme, 2);
            setStyle(this.mSize, this.LA);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Deprecated
    public final void m12654a(int i, int i2, Scope[] scopeArr) {
        setStyle(i, i2);
    }

    public final void onClick(View view) {
        if (this.bfQ != null && view == this.bfP) {
            this.bfQ.onClick(this);
        }
    }

    public final void setColorScheme(int i) {
        setStyle(this.mSize, i);
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.bfP.setEnabled(z);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.bfQ = onClickListener;
        if (this.bfP != null) {
            this.bfP.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        setStyle(this.mSize, this.LA);
    }

    public final void setSize(int i) {
        setStyle(i, this.LA);
    }

    public final void setStyle(int i, int i2) {
        this.mSize = i;
        this.LA = i2;
        Context context = getContext();
        if (this.bfP != null) {
            removeView(this.bfP);
        }
        try {
            this.bfP = awh.m4642b(context, this.mSize, this.LA);
        } catch (zzq e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i3 = this.mSize;
            int i4 = this.LA;
            View com_fossil_awi = new awi(context);
            com_fossil_awi.m4646a(context.getResources(), i3, i4);
            this.bfP = com_fossil_awi;
        }
        addView(this.bfP);
        this.bfP.setEnabled(isEnabled());
        this.bfP.setOnClickListener(this);
    }
}
