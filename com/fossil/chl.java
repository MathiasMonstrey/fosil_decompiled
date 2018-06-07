package com.fossil;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.fossil.cho.C2077b;
import com.fossil.cho.C2078c;
import com.misfit.chart.lib.DottedBarWithGoalChart;
import com.misfit.chart.lib.SleepDayBarChart;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;

public class chl extends ew {
    ViewPager RZ;
    DottedBarWithGoalChart bWA;
    SleepDayBarChart bWB;
    C2072a bWv;
    private int bWw = -12835631;
    private int bWx = -14216046;
    private int bWy = -10863620;
    private int bWz = -1;

    class C20691 implements OnTouchListener {
        final /* synthetic */ chl bWC;

        C20691(chl com_fossil_chl) {
            this.bWC = com_fossil_chl;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public static class C2072a extends fe {
        public C2072a(fa faVar) {
            super(faVar);
        }

        public int getCount() {
            return 1;
        }

        public Fragment aK(int i) {
            return new chq();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2078c.activity_main2);
        this.bWv = new C2072a(getSupportFragmentManager());
        this.RZ = (ViewPager) findViewById(C2077b.pager);
        this.RZ.setAdapter(this.bWv);
        this.RZ.setOnTouchListener(new C20691(this));
        final View findViewById = findViewById(C2077b.viewTemp);
        this.bWB = (SleepDayBarChart) findViewById(C2077b.sleep_chart);
        this.bWA = (DottedBarWithGoalChart) findViewById(C2077b.stackedbarchart);
        this.bWA.setMaxValue(10.0f);
        this.bWA.setMaxValueForLine(4.0f);
        this.bWA.setOnBarClickedListener(new chr(this) {
            final /* synthetic */ chl bWC;

            public void mo1702a(int i, float f, float f2) {
                findViewById.setX(f);
                findViewById.setY(f2);
            }

            public void mo1703b(int i, float f, float f2) {
            }

            public void jh(int i) {
            }
        });
        XQ();
    }

    private void XQ() {
        final cii com_fossil_cii = new cii("Su");
        this.bWA.setBarBottomColor(-65536);
        this.bWA.setBarCenterColor(-16711936);
        this.bWA.setBarTopColor(-16776961);
        com_fossil_cii.m6509a(new cig(8.9f, -65536));
        com_fossil_cii.m6509a(new cig(1.1f, -16711936));
        final cii com_fossil_cii2 = new cii("M");
        com_fossil_cii2.m6509a(new cig(1.1f, this.bWx));
        com_fossil_cii2.m6509a(new cig(1.1f, this.bWy));
        com_fossil_cii2.m6509a(new cig(4.3f, this.bWz));
        final cii com_fossil_cii3 = new cii("T");
        com_fossil_cii3.m6509a(new cig(2.3f, this.bWx));
        com_fossil_cii3.m6509a(new cig(2.0f, this.bWy));
        com_fossil_cii3.m6509a(new cig(3.3f, this.bWz));
        final cii com_fossil_cii4 = new cii("W");
        com_fossil_cii4.m6509a(new cig(1.0f, this.bWx));
        com_fossil_cii4.m6509a(new cig(4.2f, this.bWy));
        com_fossil_cii4.m6509a(new cig(2.1f, this.bWz));
        final cii com_fossil_cii5 = new cii("Th");
        com_fossil_cii5.m6509a(new cig(3.3f, this.bWx));
        com_fossil_cii5.m6509a(new cig(5.6f, this.bWy));
        com_fossil_cii5.m6509a(new cig(1.1f, this.bWz));
        final cii com_fossil_cii6 = new cii(DeviceIdentityUtils.FLASH_SERIAL_NUMBER_PREFIX);
        com_fossil_cii6.m6509a(new cig(3.0f, this.bWx));
        com_fossil_cii6.m6509a(new cig(0.7f, this.bWy));
        com_fossil_cii6.m6509a(new cig(1.7f, this.bWz));
        final cii com_fossil_cii7 = new cii(DeviceIdentityUtils.SHINE_SERIAL_NUMBER_PREFIX);
        com_fossil_cii7.m6509a(new cig(2.3f, this.bWx));
        com_fossil_cii7.m6509a(new cig(2.0f, this.bWy));
        com_fossil_cii7.m6509a(new cig(3.3f, this.bWz));
        final cii com_fossil_cii8 = new cii("Su");
        com_fossil_cii8.m6509a(new cig(0.0f, this.bWx));
        this.bWB.a(com_fossil_cii);
        this.bWB.a(com_fossil_cii2);
        this.bWB.a(com_fossil_cii3);
        this.bWB.a(com_fossil_cii4);
        this.bWB.a(com_fossil_cii5);
        this.bWB.a(com_fossil_cii6);
        this.bWB.a(com_fossil_cii7);
        this.bWB.a(com_fossil_cii8);
        new CountDownTimer(this, 3000, 3000) {
            final /* synthetic */ chl bWC;

            public void onTick(long j) {
            }

            public void onFinish() {
                this.bWC.bWA.a(com_fossil_cii);
                this.bWC.bWA.a(com_fossil_cii2);
                this.bWC.bWA.a(com_fossil_cii3);
                this.bWC.bWA.a(com_fossil_cii4);
                this.bWC.bWA.a(com_fossil_cii5);
                this.bWC.bWA.a(com_fossil_cii6);
                this.bWC.bWA.a(com_fossil_cii7);
                this.bWC.bWA.a(com_fossil_cii8);
            }
        }.start();
    }
}
