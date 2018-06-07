package com.portfolio.platform.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fossil.wearables.fossil.R;

public class CustomCheckbox extends LinearLayout {
    private TextView dis;
    private ImageView dit;

    public CustomCheckbox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        avf();
    }

    private void avf() {
        View inflate = inflate(getContext(), R.layout.view_custom_checkbox, this);
        this.dis = (TextView) inflate.findViewById(R.id.checkbox_title);
        this.dit = (ImageView) inflate.findViewById(R.id.checkbox_icon);
    }

    public void setTitle(String str) {
        this.dis.setText(str);
    }

    public void dm(boolean z) {
        if (z) {
            this.dit.setImageResource(R.drawable.circle_checkmark_checked);
        } else {
            this.dit.setImageResource(R.drawable.circle_checkmark_unchecked);
        }
    }
}
