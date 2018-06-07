package com.portfolio.platform.view;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.arp;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.view.NumberPicker.C4977f;

public class ChooseAlarmPicker extends LinearLayout implements C4977f {
    private NumberPicker dgI;
    private NumberPicker dgJ;
    private NumberPicker dgK;
    private int dgL;
    private int dgM;
    private int dgN;
    private String[] dgO;
    private String[] dgP;
    private C4976a dgQ;

    public interface C4976a {
        void m15823o(String str, String str2, String str3);
    }

    public ChooseAlarmPicker(Context context) {
        super(context);
        cA(context);
    }

    public ChooseAlarmPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cA(context);
    }

    private void cA(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_choose_alarm_picker, this, true);
        setOrientation(0);
        setGravity(17);
        this.dgI = (NumberPicker) inflate.findViewById(R.id.np_hour);
        this.dgJ = (NumberPicker) inflate.findViewById(R.id.np_minute);
        this.dgK = (NumberPicker) inflate.findViewById(R.id.np_suffix);
        cB(context);
        auY();
    }

    public void cB(Context context) {
        if (DateFormat.is24HourFormat(context)) {
            this.dgK.setVisibility(8);
            auX();
            return;
        }
        this.dgK.setVisibility(0);
        amM();
    }

    private void auX() {
        this.dgI.setMinValue(0);
        this.dgI.setMaxValue(23);
        this.dgI.setValue(this.dgL);
        this.dgO = new String[60];
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                this.dgO[i] = AppEventsConstants.EVENT_PARAM_VALUE_NO + String.valueOf(i);
            } else {
                this.dgO[i] = String.valueOf(i);
            }
        }
        this.dgJ.setMinValue(0);
        this.dgJ.setMaxValue(59);
        this.dgJ.setDisplayedValues(this.dgO);
        this.dgJ.setValue(this.dgM);
        this.dgP = new String[2];
        this.dgP[0] = "";
        this.dgP[1] = "";
        this.dgK.setMinValue(0);
        this.dgK.setMaxValue(1);
        this.dgK.setDisplayedValues(this.dgP);
        this.dgK.setValue(this.dgN);
    }

    private void amM() {
        this.dgI.setMinValue(1);
        this.dgI.setMaxValue(12);
        this.dgI.setValue(this.dgL);
        this.dgO = new String[60];
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                this.dgO[i] = AppEventsConstants.EVENT_PARAM_VALUE_NO + String.valueOf(i);
            } else {
                this.dgO[i] = String.valueOf(i);
            }
        }
        this.dgJ.setMinValue(0);
        this.dgJ.setMaxValue(59);
        this.dgJ.setDisplayedValues(this.dgO);
        this.dgJ.setValue(this.dgM);
        this.dgP = new String[2];
        this.dgP[0] = arp.u(PortfolioApp.ZQ(), R.string.Device_Alarm_Text_AM);
        this.dgP[1] = arp.u(PortfolioApp.ZQ(), R.string.Device_Alarm_Text_PM);
        this.dgK.setMinValue(0);
        this.dgK.setMaxValue(1);
        this.dgK.setDisplayedValues(this.dgP);
        this.dgK.setValue(this.dgN);
    }

    private void auY() {
        this.dgI.setOnValueChangedListener(this);
        this.dgJ.setOnValueChangedListener(this);
        this.dgK.setOnValueChangedListener(this);
    }

    public void m15825G(int i, int i2, int i3) {
        this.dgL = i;
        this.dgM = i2;
        this.dgN = i3;
        this.dgI.setValue(i);
        this.dgJ.setValue(i2);
        this.dgK.setValue(i3);
    }

    public void mo5424a(NumberPicker numberPicker, int i, int i2) {
        switch (numberPicker.getId()) {
            case R.id.np_hour:
                this.dgL = i2;
                break;
            case R.id.np_minute:
                this.dgM = i2;
                break;
            case R.id.np_suffix:
                this.dgN = i2;
                break;
        }
        if (this.dgQ != null) {
            this.dgQ.m15823o(String.valueOf(this.dgL), this.dgO[this.dgM], this.dgP[this.dgN]);
        }
    }

    public void setOnValueChangeListener(C4976a c4976a) {
        this.dgQ = c4976a;
    }
}
