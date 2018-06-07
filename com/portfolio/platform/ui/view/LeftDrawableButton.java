package com.portfolio.platform.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fossil.cjz.a;
import com.fossil.gn;
import com.fossil.wearables.fossil.R;

public class LeftDrawableButton extends LinearLayout {
    protected int ddD;
    protected int ddE;
    protected TextView ddF;
    protected ImageView ddG;
    protected int iconRes;
    protected int textColor;

    public LeftDrawableButton(Context context) {
        super(context);
    }

    public LeftDrawableButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15755s(context, attributeSet);
    }

    public LeftDrawableButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15755s(context, attributeSet);
    }

    protected void m15755s(Context context, AttributeSet attributeSet) {
        inflate(context, R.layout.button_left_drawable_button, this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.LeftDrawableButton);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            this.iconRes = obtainStyledAttributes.getResourceId(0, -1);
            this.ddD = obtainStyledAttributes.getResourceId(3, -1);
            Object string = obtainStyledAttributes.getString(4);
            float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(6, -1);
            this.textColor = obtainStyledAttributes.getResourceId(7, -1);
            this.ddE = obtainStyledAttributes.getResourceId(8, -1);
            boolean z = obtainStyledAttributes.getBoolean(5, true);
            if (drawable != null) {
                setBackground(drawable);
            }
            this.ddG = (ImageView) findViewById(R.id.button_icon);
            this.ddF = (TextView) findViewById(R.id.button_name_tv);
            if (!TextUtils.isEmpty(string)) {
                this.ddF.setText(string.toUpperCase());
            }
            if (dimensionPixelSize != -1.0f) {
                this.ddF.setTextSize(0, dimensionPixelSize);
            }
            this.ddF.setSingleLine(z);
            dl(true);
            obtainStyledAttributes.recycle();
        }
    }

    public void setText(String str) {
        if (this.ddF != null) {
            this.ddF.setText(str);
        }
    }

    public void setLeftDrawable(int i) {
        if (this.ddG != null) {
            this.ddG.setImageResource(i);
        }
    }

    public void dl(boolean z) {
        if (z) {
            if (!(this.iconRes == -1 || this.ddG == null)) {
                this.ddG.setImageResource(this.iconRes);
            }
            if (this.textColor != -1 && this.ddF != null) {
                this.ddF.setTextColor(gn.e(getContext(), this.textColor));
                return;
            }
            return;
        }
        if (!(this.ddD == -1 || this.ddG == null)) {
            this.ddG.setImageResource(this.ddD);
        }
        if (this.ddE != -1 && this.ddF != null) {
            this.ddF.setTextColor(gn.e(getContext(), this.ddE));
        }
    }

    public void setIconSelected(boolean z) {
        if (this.ddG != null) {
            this.ddG.setSelected(z);
        }
    }
}
