package com.fossil;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class dtx extends RelativeLayout {
    private TextView dts;

    public dtx(Context context) {
        super(context);
        avf();
    }

    private void avf() {
        setLayoutParams(new LayoutParams(-1, dum.m9773I(getContext(), 24)));
        setBackgroundDrawable(dum.m9774O(getContext(), "tableview_sectionheader_background.png"));
        this.dts = new TextView(getContext());
        this.dts.setTextSize(14.0f);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.leftMargin = dum.m9773I(getContext(), 10);
        this.dts.setLayoutParams(layoutParams);
        this.dts.setGravity(3);
        this.dts.setTextColor(-7171438);
        this.dts.setGravity(16);
        addView(this.dts);
    }

    public void setTitle(String str) {
        this.dts.setText(str);
    }

    public void kc(String str) {
        setTitle(str);
    }
}
