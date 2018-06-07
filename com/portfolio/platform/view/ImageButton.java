package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fossil.arp;
import com.fossil.cjz.a;
import com.fossil.dri;
import com.fossil.gn;
import com.fossil.wearables.fossil.R;

public class ImageButton extends RelativeLayout {
    private ImageView djI = ((ImageView) findViewById(R.id.fossil_button_icon));
    private TextView djJ = ((TextView) findViewById(R.id.fossil_button_title));
    private ViewGroup djK = ((ViewGroup) findViewById(R.id.fossil_button_container));

    public ImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(context, R.layout.view_fossil_button, this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.ImageButton);
        setIcon(obtainStyledAttributes.getResourceId(0, -1));
        setTitle(obtainStyledAttributes.getResourceId(1, -1));
        setTitleColor(obtainStyledAttributes.getResourceId(3, -1));
        setBackground(obtainStyledAttributes.getResourceId(2, -1));
        obtainStyledAttributes.recycle();
    }

    public void setIcon(int i) {
        if (i != -1) {
            this.djI.setImageDrawable(gn.c(getContext(), i));
            this.djI.setVisibility(0);
            return;
        }
        this.djI.setVisibility(8);
    }

    public void setTitle(int i) {
        if (i != -1) {
            arp.c(this.djJ, i);
            this.djJ.setVisibility(0);
            return;
        }
        this.djJ.setVisibility(8);
    }

    public void setTitle(String str) {
        this.djJ.setText(str);
        this.djJ.setVisibility(0);
    }

    public void ci(int i, int i2) {
        LayoutParams layoutParams = this.djI.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.djI.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.djI.getLayoutParams();
        layoutParams2.setMarginStart((int) (dri.at(70.0f) - (((float) i) - dri.at(30.0f))));
        this.djI.setLayoutParams(layoutParams2);
    }

    public String getTitle() {
        return this.djJ.getText().toString();
    }

    public void setTitleColor(int i) {
        if (i != -1) {
            this.djJ.setTextColor(getResources().getColorStateList(i));
        }
    }

    public void setBackground(int i) {
        Drawable c = gn.c(getContext(), R.drawable.bg_graydark_to_scarlett);
        if (i != -1) {
            c = gn.c(getContext(), i);
        }
        this.djK.setBackground(c);
    }

    public TextView getTextView() {
        return this.djJ;
    }
}
