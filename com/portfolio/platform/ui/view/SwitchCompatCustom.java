package com.portfolio.platform.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.fossil.arp;
import com.fossil.cjz.a;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;

public class SwitchCompatCustom extends FrameLayout {
    private View cJc = findViewById(R.id.v_enable);
    private FlexibleTextView csI = ((FlexibleTextView) findViewById(R.id.text_view_setting_item_title));
    private FrameLayout ddN = ((FrameLayout) findViewById(R.id.switch_container));
    private AttributeSet ddO;

    public SwitchCompatCustom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ddO = attributeSet;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.SwitchCompatCustom);
        inflate(context, R.layout.switch_compat_custom_view, this);
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        if (resourceId > 0) {
            this.csI.setText(arp.u(context, resourceId));
        }
        this.cJc.setSelected(obtainStyledAttributes.getBoolean(2, false));
        this.csI.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(3, 16));
        String string = obtainStyledAttributes.getString(4);
        if (string != null) {
            this.csI.setTypeface(Typeface.createFromAsset(getContext().getAssets(), string));
        }
        this.ddN.setBackgroundColor(obtainStyledAttributes.getColor(0, getResources().getColor(R.color.primary)));
        obtainStyledAttributes.recycle();
        dm(true);
    }

    public void setBackground(int i) {
        this.ddN.setBackgroundColor(getResources().getColor(i));
    }

    public void setTitle(String str) {
        this.csI.setText(str);
    }

    public void dm(boolean z) {
        this.cJc.setSelected(z);
    }

    public boolean isChecked() {
        return this.cJc.isSelected();
    }

    public void setTextAlpha(float f) {
        this.csI.setAlpha(f);
    }

    public void setOnCheckedChangeListener(OnClickListener onClickListener) {
        this.cJc.setOnClickListener(onClickListener);
    }

    public void setChecked(boolean z) {
        this.cJc.setSelected(z);
    }

    public void aua() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(this.ddO, a.SwitchCompatCustom);
        this.ddN.setBackgroundColor(obtainStyledAttributes.getColor(0, getResources().getColor(R.color.white)));
        obtainStyledAttributes.recycle();
    }
}
