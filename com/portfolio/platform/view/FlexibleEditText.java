package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView.BufferType;
import com.fossil.arp;
import com.fossil.cjz.a;
import com.fossil.drh;
import com.portfolio.platform.PortfolioApp;

public class FlexibleEditText extends AppCompatEditText {
    protected int diE;
    protected int diF;

    public FlexibleEditText(Context context) {
        super(context);
        m15860a(null);
    }

    public FlexibleEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15860a(attributeSet);
    }

    public FlexibleEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15860a(attributeSet);
    }

    public int getTextType() {
        return this.diE;
    }

    public void setTextType(int i) {
        this.diE = i;
        setText(getText());
    }

    public int getHintType() {
        return this.diF;
    }

    public void setHintType(int i) {
        this.diF = i;
        setHint(m15859a(getHint(), i));
    }

    protected void m15860a(AttributeSet attributeSet) {
        this.diE = 0;
        CharSequence text = getText();
        CharSequence hint = getHint();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.FlexibleEditText);
            this.diE = obtainStyledAttributes.getInt(1, 0);
            this.diF = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
            obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16843087, 16843088}, 0, 0);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            if (resourceId != -1) {
                text = lD(resourceId);
            }
            resourceId = obtainStyledAttributes.getResourceId(1, -1);
            if (resourceId != -1) {
                hint = lD(resourceId);
            }
            obtainStyledAttributes.recycle();
        }
        if (!TextUtils.isEmpty(text)) {
            setText(text);
        }
        if (!TextUtils.isEmpty(hint)) {
            setHint(m15859a(hint, this.diF));
        }
    }

    public void setTextByResourceId(int i) {
        setText(lD(i));
    }

    public void setHintByResourceId(int i) {
        setHint(m15859a(lD(i), this.diF));
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(m15858C(charSequence), bufferType);
    }

    protected CharSequence m15858C(CharSequence charSequence) {
        return m15859a(charSequence, this.diE);
    }

    protected CharSequence m15859a(CharSequence charSequence, int i) {
        switch (i) {
            case 1:
                return drh.x(charSequence);
            case 2:
                return drh.y(charSequence);
            case 3:
                return drh.z(charSequence);
            case 4:
                return drh.A(charSequence);
            default:
                return charSequence;
        }
    }

    private String lD(int i) {
        return arp.u(PortfolioApp.ZQ(), i);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            clearFocus();
        }
        return false;
    }
}
