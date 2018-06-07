package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.fossil.arp;
import com.fossil.cjz.a;
import com.fossil.drh;
import com.portfolio.platform.PortfolioApp;

public class FlexibleTextView extends AppCompatTextView {
    protected int diE;
    protected int diF;

    public FlexibleTextView(Context context) {
        super(context);
        m15817a(null);
    }

    public FlexibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15817a(attributeSet);
    }

    public FlexibleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15817a(attributeSet);
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
        setHint(m15816a(getHint(), i));
    }

    protected void m15817a(AttributeSet attributeSet) {
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
            setHint(m15816a(hint, this.diF));
        }
    }

    public void setTextByResourceId(int i) {
        setText(lD(i));
    }

    public void setHintByResourceId(int i) {
        setHint(m15816a(lD(i), this.diF));
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(m15815C(charSequence), bufferType);
    }

    protected CharSequence m15815C(CharSequence charSequence) {
        return m15816a(charSequence, this.diE);
    }

    protected CharSequence m15816a(CharSequence charSequence, int i) {
        switch (i) {
            case 1:
                return drh.x(charSequence);
            case 2:
                return drh.y(charSequence);
            case 3:
                return drh.z(charSequence);
            case 4:
                return drh.A(charSequence);
            case 5:
                return drh.B(charSequence);
            default:
                return charSequence;
        }
    }

    private String lD(int i) {
        return arp.u(PortfolioApp.ZQ(), i);
    }
}
