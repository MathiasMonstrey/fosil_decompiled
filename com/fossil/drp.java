package com.fossil;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.enums.FossilBrand;
import com.portfolio.platform.enums.Gender;
import com.portfolio.platform.view.ClockView;
import com.portfolio.platform.view.ClockView.b;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.NumberPicker;
import com.portfolio.platform.view.NumberPicker.f;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class drp extends Dialog {
    public static final SimpleDateFormat dlC = new SimpleDateFormat("MMM d", Locale.US);
    private int day;
    private NumberPicker dlD;
    private NumberPicker dlE;
    private NumberPicker dlF;
    private ClockView dlG;
    private int dlH;
    private String dlI;
    private FlexibleTextView dlJ;
    private FlexibleTextView dlK;
    boolean dlL;
    private C2471a dlM;
    private int dlN;
    private final OnClickListener dlO = new C31387(this);
    int dlP = -1;
    int dlQ = -1;
    private final OnClickListener dlR = new OnClickListener(this) {
        final /* synthetic */ drp dmb;

        {
            this.dmb = r1;
        }

        public void onClick(View view) {
            this.dmb.dismiss();
        }
    };
    private final OnClickListener dlS = new OnClickListener(this) {
        final /* synthetic */ drp dmb;

        {
            this.dmb = r1;
        }

        public void onClick(View view) {
            Map hashMap = new HashMap(1);
            hashMap.put("gender", Gender.values()[this.dmb.dlD.getValue()]);
            this.dmb.dlM.mo2162x(hashMap);
            this.dmb.dismiss();
        }
    };
    private final OnClickListener dlT = new OnClickListener(this) {
        final /* synthetic */ drp dmb;

        {
            this.dmb = r1;
        }

        public void onClick(View view) {
            Map hashMap = new HashMap(1);
            hashMap.put("goal", Integer.valueOf(this.dmb.dlD.getValue() * MFNetworkReturnCode.RESPONSE_OK));
            this.dmb.dlM.mo2162x(hashMap);
            this.dmb.dismiss();
        }
    };
    private final OnClickListener dlU = new OnClickListener(this) {
        final /* synthetic */ drp dmb;

        {
            this.dmb = r1;
        }

        public void onClick(View view) {
            Map hashMap = new HashMap(3);
            hashMap.put("month", Integer.valueOf(this.dmb.dlD.getValue()));
            hashMap.put("day", Integer.valueOf(this.dmb.dlE.getValue()));
            hashMap.put("year", Integer.valueOf(this.dmb.dlF.getValue()));
            this.dmb.dlM.mo2162x(hashMap);
            this.dmb.dismiss();
        }
    };
    private final OnClickListener dlV = new OnClickListener(this) {
        final /* synthetic */ drp dmb;

        {
            this.dmb = r1;
        }

        public void onClick(View view) {
            int value;
            Map hashMap = new HashMap(1);
            if (this.dmb.dlL) {
                value = (int) (((double) ((this.dmb.dlD.getValue() * 12) + this.dmb.dlE.getValue())) * 2.54d);
            } else {
                value = this.dmb.dlD.getValue();
            }
            hashMap.put(Constants.PROFILE_KEY_UNITS_HEIGHT, Integer.valueOf(value));
            this.dmb.dlM.mo2162x(hashMap);
            this.dmb.dismiss();
        }
    };
    private final OnClickListener dlW = new C31332(this);
    private final OnClickListener dlX = new C31343(this);
    private final OnClickListener dlY = new C31354(this);
    private final OnClickListener dlZ = new C31365(this);
    private final OnClickListener dma = new C31376(this);
    private int hour;
    private int month;
    private long startTime;
    private long time;
    private int type;
    private int weight;
    private int year;

    public interface C2471a {
        void mo2162x(Map<String, Object> map);
    }

    class C31321 implements b {
        final /* synthetic */ drp dmb;

        C31321(drp com_fossil_drp) {
            this.dmb = com_fossil_drp;
        }

        public void kq(int i) {
            this.dmb.dlN = i;
            this.dmb.dlG.setCurrentHour(i);
        }
    }

    class C31332 implements OnClickListener {
        final /* synthetic */ drp dmb;

        C31332(drp com_fossil_drp) {
            this.dmb = com_fossil_drp;
        }

        public void onClick(View view) {
            int jB;
            Map hashMap = new HashMap(1);
            if (this.dmb.dlL) {
                jB = cmv.jB(this.dmb.dlD.getValue() * 16);
            } else {
                jB = this.dmb.dlD.getValue() * 1000;
            }
            hashMap.put(Constants.PROFILE_KEY_UNITS_WEIGHT, Integer.valueOf(jB));
            this.dmb.dlM.mo2162x(hashMap);
            this.dmb.dismiss();
        }
    }

    class C31343 implements OnClickListener {
        final /* synthetic */ drp dmb;

        C31343(drp com_fossil_drp) {
            this.dmb = com_fossil_drp;
        }

        public void onClick(View view) {
            int i = 1;
            Map hashMap = new HashMap(1);
            int value = this.dmb.dlD.getValue();
            if (this.dmb.dlF.getValue() != 1) {
                i = 0;
            }
            if (i != 0) {
                if (value != 12) {
                    value += 12;
                }
            } else if (value == 12) {
                value = 0;
            }
            int value2 = this.dmb.dlE.getValue();
            hashMap.put(AppFilter.COLUMN_HOUR, Integer.valueOf(value));
            hashMap.put("min", Integer.valueOf(value2));
            this.dmb.dlM.mo2162x(hashMap);
            this.dmb.dismiss();
        }
    }

    class C31354 implements OnClickListener {
        final /* synthetic */ drp dmb;

        C31354(drp com_fossil_drp) {
            this.dmb = com_fossil_drp;
        }

        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            Map hashMap = new HashMap(1);
            int value = this.dmb.dlD.getValue();
            if (this.dmb.dlF.getValue() != 1) {
                z = false;
            }
            if (value != 12) {
                i = value;
            }
            value = this.dmb.dlE.getValue();
            hashMap.put(AppFilter.COLUMN_HOUR, Integer.valueOf(i));
            hashMap.put("min", Integer.valueOf(value));
            hashMap.put("pm", Boolean.valueOf(z));
            this.dmb.dlM.mo2162x(hashMap);
            this.dmb.dismiss();
        }
    }

    class C31365 implements OnClickListener {
        final /* synthetic */ drp dmb;

        C31365(drp com_fossil_drp) {
            this.dmb = com_fossil_drp;
        }

        public void onClick(View view) {
            Map hashMap = new HashMap(1);
            Calendar instance = Calendar.getInstance();
            hashMap.put("date", Long.valueOf(instance.getTimeInMillis() - (((long) (instance.get(6) - this.dmb.dlD.getValue())) * 86400000)));
            this.dmb.dlM.mo2162x(hashMap);
            this.dmb.dismiss();
        }
    }

    class C31376 implements OnClickListener {
        final /* synthetic */ drp dmb;

        C31376(drp com_fossil_drp) {
            this.dmb = com_fossil_drp;
        }

        public void onClick(View view) {
            Map hashMap = new HashMap(1);
            hashMap.put("goal", Integer.valueOf(this.dmb.dlD.getValue()));
            this.dmb.dlM.mo2162x(hashMap);
            this.dmb.dismiss();
        }
    }

    class C31387 implements OnClickListener {
        final /* synthetic */ drp dmb;

        C31387(drp com_fossil_drp) {
            this.dmb = com_fossil_drp;
        }

        public void onClick(View view) {
            Map hashMap = new HashMap(1);
            hashMap.put("hand_number", Integer.valueOf(this.dmb.dlN));
            this.dmb.dlM.mo2162x(hashMap);
            this.dmb.dismiss();
        }
    }

    class C31398 implements f {
        final /* synthetic */ drp dmb;

        C31398(drp com_fossil_drp) {
            this.dmb = com_fossil_drp;
        }

        public void m9516a(NumberPicker numberPicker, int i, int i2) {
        }
    }

    class C31409 implements f {
        final /* synthetic */ drp dmb;

        C31409(drp com_fossil_drp) {
            this.dmb = com_fossil_drp;
        }

        public void m9517a(NumberPicker numberPicker, int i, int i2) {
        }
    }

    public static drp m9519a(Context context, int i, int i2, int i3, C2471a c2471a) {
        drp com_fossil_drp = new drp(context);
        com_fossil_drp.type = 5;
        com_fossil_drp.month = i;
        com_fossil_drp.day = i2;
        com_fossil_drp.year = i3;
        com_fossil_drp.dlM = c2471a;
        return com_fossil_drp;
    }

    public drp(Context context) {
        super(context);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        avM();
    }

    private void avM() {
        switch (this.type) {
            case 1:
                avU();
                return;
            case 2:
                avS();
                return;
            case 3:
                avT();
                return;
            case 4:
                avR();
                return;
            case 5:
                avV();
                return;
            case 6:
                avO();
                return;
            case 7:
                avP();
                return;
            case 8:
                avQ();
                return;
            case 9:
                avW();
                return;
            case 10:
                avN();
                return;
            default:
                throw new RuntimeException("You must use a picker type!");
        }
    }

    private void avN() {
        setContentView(R.layout.picker_hand_number);
        this.dlG = (ClockView) findViewById(R.id.clock_view);
        this.dlG.setCurrentHour(this.dlN);
        this.dlG.setClockOnTouchListener(new C31321(this));
        m9522a(this.dlO, this.dlR);
    }

    private void avO() {
    }

    public static drp m9520a(Context context, String str, int i, int i2, C2471a c2471a) {
        drp com_fossil_drp = new drp(context);
        com_fossil_drp.type = 8;
        com_fossil_drp.hour = i;
        com_fossil_drp.dlH = i2;
        com_fossil_drp.jx(str);
        com_fossil_drp.dlM = c2471a;
        String.valueOf(1);
        return com_fossil_drp;
    }

    private void avP() {
        setContentView(R.layout.picker_sleep_date);
        CharSequence avX = avX();
        if (avX != null) {
            ((TextView) findViewById(R.id.textViewTitle)).setText(avX);
        }
        this.dlD = (NumberPicker) findViewById(R.id.numberPickerOne);
        Calendar instance = Calendar.getInstance();
        int i = instance.get(6);
        long timeInMillis = instance.getTimeInMillis() - (((long) i) * 86400000);
        int time = ((int) (((cnf.getStartOfDay(new Date(this.time)).getTime() + 60000) - timeInMillis) / 86400000)) + 1;
        int time2 = ((int) (((cnf.getStartOfDay(new Date(this.startTime)).getTime() + 3600000) - timeInMillis) / 86400000)) + 1;
        if (time2 > i) {
            time2 = i;
        }
        String[] strArr = new String[time2];
        for (int i2 = 1; i2 <= time2; i2++) {
            if (i2 == time2 && time2 == i) {
                strArr[i2 - 1] = PortfolioApp.ZQ().getResources().getString(R.string.Stats_Activity_Label_Today);
            } else {
                strArr[i2 - 1] = dlC.format(new Date((((long) i2) * 86400000) + timeInMillis));
            }
        }
        this.dlD.setMinValue(1);
        this.dlD.setMaxValue(time2);
        this.dlD.setDisplayedValues(strArr);
        this.dlD.setValue(time);
        m9522a(this.dlZ, this.dlR);
    }

    private void avQ() {
        int i;
        int i2 = 1;
        setContentView(R.layout.picker_sleep_time);
        CharSequence avX = avX();
        if (avX != null) {
            ((TextView) findViewById(R.id.textViewTitle)).setText(avX);
        }
        this.dlD = (NumberPicker) findViewById(R.id.numberPickerOne);
        this.dlE = (NumberPicker) findViewById(R.id.numberPickerTwo);
        this.dlF = (NumberPicker) findViewById(R.id.numberPickerThree);
        if (this.hour >= 12) {
            this.hour -= 12;
            i = 1;
        } else {
            i = 0;
        }
        if (this.hour == 0) {
            this.hour = 12;
        }
        this.dlD.setMinValue(1);
        this.dlD.setMaxValue(12);
        this.dlD.setValue(this.hour);
        String[] strArr = new String[60];
        for (int i3 = 0; i3 < 60; i3++) {
            if (i3 < 10) {
                strArr[i3] = AppEventsConstants.EVENT_PARAM_VALUE_NO + i3;
            } else {
                strArr[i3] = Integer.toString(i3);
            }
        }
        this.dlE.setMinValue(0);
        this.dlE.setMaxValue(59);
        this.dlE.setDisplayedValues(strArr);
        this.dlE.setValue(this.dlH);
        String[] strArr2 = new String[]{arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Alarm_Text_AM), arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Alarm_Text_PM)};
        this.dlF.setMinValue(0);
        this.dlF.setMaxValue(1);
        this.dlF.setDisplayedValues(strArr2);
        NumberPicker numberPicker = this.dlF;
        if (i == 0) {
            i2 = 0;
        }
        numberPicker.setValue(i2);
        m9522a(this.dlY, this.dlR);
    }

    private void avR() {
        int i;
        int i2 = 1;
        setContentView(R.layout.picker_sleep_time);
        this.dlD = (NumberPicker) findViewById(R.id.numberPickerOne);
        this.dlE = (NumberPicker) findViewById(R.id.numberPickerTwo);
        this.dlF = (NumberPicker) findViewById(R.id.numberPickerThree);
        if (this.hour >= 12) {
            this.hour -= 12;
            i = 1;
        } else {
            i = 0;
        }
        if (this.hour == 0) {
            this.hour = 12;
        }
        this.dlD.setMinValue(1);
        this.dlD.setMaxValue(12);
        this.dlD.setValue(this.hour);
        String[] strArr = new String[60];
        for (int i3 = 0; i3 < 60; i3++) {
            if (i3 < 10) {
                strArr[i3] = AppEventsConstants.EVENT_PARAM_VALUE_NO + i3;
            } else {
                strArr[i3] = Integer.toString(i3);
            }
        }
        this.dlE.setMinValue(0);
        this.dlE.setMaxValue(59);
        this.dlE.setDisplayedValues(strArr);
        this.dlE.setValue(this.dlH);
        String[] strArr2 = new String[]{arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Alarm_Text_AM), arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Alarm_Text_PM)};
        this.dlF.setMinValue(0);
        this.dlF.setMaxValue(1);
        this.dlF.setDisplayedValues(strArr2);
        NumberPicker numberPicker = this.dlF;
        if (i == 0) {
            i2 = 0;
        }
        numberPicker.setValue(i2);
        m9522a(this.dlX, this.dlR);
    }

    private void avS() {
        setContentView(R.layout.picker_weight);
        this.dlD = (NumberPicker) findViewById(R.id.numberPickerOne);
        String[] strArr = new String[999];
        String u = arp.m4318u(PortfolioApp.ZQ(), R.string.General_Measurement_Abbreviations_Kilograms_kg);
        if (this.dlL) {
            u = arp.m4318u(PortfolioApp.ZQ(), R.string.General_Measurement_Abbreviations_Pounds_lbs);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 999; i++) {
            strArr[i - 1] = stringBuilder.append(i).append(' ').append(u).toString();
            stringBuilder.setLength(0);
        }
        this.dlD.setMinValue(1);
        this.dlD.setMaxValue(999);
        this.dlD.setDisplayedValues(strArr);
        if (this.dlL) {
            this.dlD.setValue((int) Math.round(((double) cmv.jA(this.weight)) / 16.0d));
        } else {
            this.dlD.setValue((int) Math.round(((double) this.weight) / 1000.0d));
        }
        m9522a(this.dlW, this.dlR);
    }

    private void avT() {
    }

    private void avU() {
    }

    private void avV() {
        setContentView(R.layout.picker_date);
        this.dlD = (NumberPicker) findViewById(R.id.numberPickerOne);
        this.dlE = (NumberPicker) findViewById(R.id.numberPickerTwo);
        this.dlF = (NumberPicker) findViewById(R.id.numberPickerThree);
        this.dlD.setMinValue(1);
        this.dlD.setMaxValue(12);
        this.dlD.setDisplayedValues(DateFormatSymbols.getInstance(Locale.getDefault()).getShortMonths());
        this.dlD.setOnValueChangedListener(new C31398(this));
        this.dlE.setMinValue(1);
        this.dlE.setMaxValue(31);
        this.dlF.setMinValue(1915);
        this.dlF.setMaxValue(Calendar.getInstance().get(1));
        this.dlF.setValue(1990);
        this.dlD.setValue(this.month);
        this.dlE.setValue(this.day);
        this.dlF.setValue(this.year);
        m9522a(this.dlU, this.dlR);
    }

    private void avW() {
        setContentView(R.layout.picker_date);
        TextView textView = (TextView) findViewById(R.id.textViewTitle);
        this.dlD = (NumberPicker) findViewById(R.id.numberPickerOne);
        this.dlE = (NumberPicker) findViewById(R.id.numberPickerTwo);
        this.dlF = (NumberPicker) findViewById(R.id.numberPickerThree);
        this.dlD.setMinValue(1);
        this.dlD.setMaxValue(12);
        this.dlD.setDisplayedValues(DateFormatSymbols.getInstance(Locale.getDefault()).getShortMonths());
        this.dlD.setOnValueChangedListener(new C31409(this));
        this.dlE.setMinValue(1);
        this.dlE.setMaxValue(31);
        this.dlF.setMinValue(Calendar.getInstance().get(1));
        this.dlF.setMaxValue(Calendar.getInstance().get(1) + 10);
        this.dlF.setValue(1990);
        this.dlD.setValue(this.month);
        this.dlE.setValue(this.day);
        this.dlF.setValue(this.year);
        m9522a(this.dlU, this.dlR);
    }

    private void m9522a(OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.dlJ = (FlexibleTextView) findViewById(R.id.buttonSave);
        this.dlJ.setOnClickListener(onClickListener);
        this.dlK = (FlexibleTextView) findViewById(R.id.buttonCancel);
        this.dlK.setOnClickListener(onClickListener2);
        if (!(PortfolioApp.ZQ().aag() != FossilBrand.KATESPADE || this.dlP == -1 || this.dlQ == -1)) {
            this.dlJ.setBackgroundResource(this.dlP);
            this.dlK.setBackgroundResource(this.dlQ);
        }
        if (this.type == 10) {
            this.dlK.setVisibility(8);
            this.dlJ.setBackgroundResource(R.color.white);
            this.dlJ.setText(R.string.Notifications_Preview_Assign_CTA_DONE);
            this.dlJ.setTextColor(PortfolioApp.ZQ().getResources().getColor(R.color.fossilOrange));
        }
    }

    public String avX() {
        return this.dlI;
    }

    public void jx(String str) {
        this.dlI = str;
    }
}
