package com.fossil;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class dtw extends RelativeLayout {
    private TextView dsO;
    private TextView dsP;

    public dtw(Context context, String str, String str2) {
        super(context);
        aO(str, str2);
    }

    private void aO(String str, String str2) {
        setLayoutParams(new LayoutParams(-1, dum.m9773I(getContext(), 40)));
        this.dsP = new TextView(getContext());
        this.dsP.setTextSize(16.0f);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = dum.m9773I(getContext(), 15);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.dsP.setGravity(16);
        this.dsP.setLayoutParams(layoutParams);
        this.dsP.setText(str);
        this.dsP.setTextColor(-13421773);
        addView(this.dsP);
        this.dsO = new TextView(getContext());
        this.dsO.setTextSize(16.0f);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = dum.m9773I(getContext(), 40);
        this.dsO.setLayoutParams(layoutParams);
        this.dsO.setText(str2);
        this.dsO.setTextColor(-11502161);
        this.dsO.setGravity(16);
        addView(this.dsO);
        aQ(str, str2);
    }

    public void aP(String str, String str2) {
        aQ(str, str2);
    }

    private void aQ(String str, String str2) {
        this.dsP.setText(str);
        this.dsO.setText(str2);
    }
}
