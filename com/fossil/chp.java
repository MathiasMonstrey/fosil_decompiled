package com.fossil;

import android.os.Bundle;
import com.fossil.cho.C2077b;
import com.fossil.cho.C2078c;
import com.misfit.chart.lib.SleepWeeklyBarChart;
import com.misfit.chart.models.WrapperSleepStateChange;
import java.util.ArrayList;
import java.util.Iterator;

public class chp extends ot {
    private static final String TAG = chp.class.getSimpleName();
    private ArrayList<WrapperSleepStateChange> bWR = new ArrayList();
    private ArrayList<cip> bWS = new ArrayList();
    private int bWT = 0;
    private SleepWeeklyBarChart bWU;

    protected void onCreate(Bundle bundle) {
        int i;
        WrapperSleepStateChange wrapperSleepStateChange;
        super.onCreate(bundle);
        setContentView(C2078c.activity_sleep_weekly);
        this.bWU = (SleepWeeklyBarChart) findViewById(C2077b.barchart);
        int i2 = 1;
        for (i = 0; i < 600; i++) {
            if (i > i2 * 50) {
                i2++;
            }
            this.bWR.add(new WrapperSleepStateChange(i2 % 3, i));
        }
        WrapperSleepStateChange wrapperSleepStateChange2 = (WrapperSleepStateChange) this.bWR.get(0);
        if (this.bWR.size() > 0) {
            i = 1;
            wrapperSleepStateChange = wrapperSleepStateChange2;
        } else {
            i = 1;
            wrapperSleepStateChange = wrapperSleepStateChange2;
        }
        while (i < this.bWR.size()) {
            WrapperSleepStateChange wrapperSleepStateChange3;
            wrapperSleepStateChange2 = (WrapperSleepStateChange) this.bWR.get(i);
            if (wrapperSleepStateChange2.getState() == wrapperSleepStateChange.getState()) {
                ((cip) this.bWS.get(this.bWT)).setEndIndex(wrapperSleepStateChange2.getIndex());
                wrapperSleepStateChange3 = wrapperSleepStateChange;
            } else {
                this.bWT++;
                wrapperSleepStateChange3 = wrapperSleepStateChange2;
            }
            i++;
            wrapperSleepStateChange = wrapperSleepStateChange3;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.bWS.iterator();
        while (it.hasNext()) {
            cip com_fossil_cip = (cip) it.next();
            cim com_fossil_cim = new cim((float) (com_fossil_cip.getEndIndex() - com_fossil_cip.YJ()));
            com_fossil_cim.m6511a(com_fossil_cip);
            arrayList.add(com_fossil_cim);
        }
        this.bWU.setMaxValue(600.0f);
        this.bWU.f(arrayList);
    }
}
