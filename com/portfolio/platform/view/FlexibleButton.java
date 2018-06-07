package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.fossil.arp;
import com.fossil.cjz.a;
import com.portfolio.platform.PortfolioApp;

public class FlexibleButton extends AppCompatButton {
    protected int diE;

    public FlexibleButton(Context context) {
        super(context);
        m15861a(null);
    }

    public FlexibleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15861a(attributeSet);
    }

    public FlexibleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15861a(attributeSet);
    }

    public int getTextType() {
        return this.diE;
    }

    public void setTextType(int i) {
        this.diE = i;
        setText(getText());
    }

    protected void m15861a(AttributeSet attributeSet) {
        this.diE = 0;
        CharSequence text = getText();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.FlexibleButton);
            this.diE = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
            obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16843087}, 0, 0);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            if (resourceId != -1) {
                text = lD(resourceId);
            }
            obtainStyledAttributes.recycle();
        }
        if (!TextUtils.isEmpty(text)) {
            setText(text);
        }
        if (VERSION.SDK_INT >= 21) {
            setElevation(0.0f);
            setStateListAnimator(null);
        }
    }

    public void setTextByResourceId(int i) {
        setText(lD(i));
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    private String lD(int i) {
        return arp.u(PortfolioApp.ZQ(), i);
    }
}
