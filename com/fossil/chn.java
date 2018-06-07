package com.fossil;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import com.fossil.cho.C2077b;
import com.fossil.cho.C2078c;
import com.misfit.chart.lib.CubicChart;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class chn extends ew {
    boolean bWL = false;
    CountDownTimer bWM;
    CubicChart bWN;

    class C20741 implements chs {
        final /* synthetic */ chn bWO;

        C20741(chn com_fossil_chn) {
            this.bWO = com_fossil_chn;
        }

        public void mo1715w(float f, float f2) {
            final float f3 = f;
            this.bWO.bWM = new CountDownTimer(this, 1000, 1000) {
                final /* synthetic */ C20741 bWQ;

                public void onTick(long j) {
                }

                public void onFinish() {
                    Log.d("bambi", "bambi actuon down");
                    this.bWQ.bWO.bWN.jj((int) f3);
                    this.bWQ.bWO.bWL = true;
                }
            };
            this.bWO.bWM.start();
        }

        public void mo1716x(float f, float f2) {
            if (this.bWO.bWL) {
                this.bWO.bWN.jj((int) f);
            }
            Log.d("bambi", "bambi actuon move: " + f);
        }

        public void mo1717y(float f, float f2) {
            Log.d("bambi", "bambi actuon up");
            if (this.bWO.bWM != null) {
                this.bWO.bWM.cancel();
            }
            this.bWO.bWL = false;
            this.bWO.bWN.freeMemory();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2078c.activity_main3);
        this.bWN = (CubicChart) findViewById(C2077b.stackedbarchart2);
        this.bWN.setListener(new C20741(this));
        this.bWN.setIsToday(false);
        this.bWN.setDebugMode(false);
        this.bWN.setBaseMaxCoordinateY(54000000);
        this.bWN.setMarginTopPercentage(0);
        this.bWN.setPositionXToDrawCurrentLineTo(900);
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.set(10, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        ((Calendar) instance.clone()).add(6, 1);
        this.bWN.setStartCoordinateX(m6455F(0, 0, 0).getTime());
        this.bWN.setEndCoordinateX(m6455F(23, 59, 59).getTime());
        new CountDownTimer(this, 1000, 1000) {
            final /* synthetic */ chn bWO;

            public void onTick(long j) {
            }

            public void onFinish() {
                List arrayList = new ArrayList();
                arrayList.add(new cij(this.bWO.m6455F(0, 0, 0).getTime(), 18000000));
                arrayList.add(new cij(this.bWO.m6455F(1, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(2, 0, 0).getTime(), 48000000));
                arrayList.add(new cij(this.bWO.m6455F(3, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(4, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(4, 30, 0).getTime(), 42000000));
                arrayList.add(new cij(this.bWO.m6455F(5, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(5, 30, 0).getTime(), 30000000));
                arrayList.add(new cij(this.bWO.m6455F(6, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(6, 30, 0).getTime(), 24000000));
                arrayList.add(new cij(this.bWO.m6455F(7, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(7, 30, 0).getTime(), 54000000));
                arrayList.add(new cij(this.bWO.m6455F(8, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(8, 30, 0).getTime(), 1800000));
                arrayList.add(new cij(this.bWO.m6455F(9, 0, 0).getTime(), 36000000));
                arrayList.add(new cij(this.bWO.m6455F(9, 30, 0).getTime(), 1800000));
                arrayList.add(new cij(this.bWO.m6455F(10, 0, 0).getTime(), 12000000));
                arrayList.add(new cij(this.bWO.m6455F(10, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(11, 0, 0).getTime(), 18000000));
                arrayList.add(new cij(this.bWO.m6455F(11, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(12, 0, 0).getTime(), 6000000));
                arrayList.add(new cij(this.bWO.m6455F(12, 30, 0).getTime(), 18000000));
                arrayList.add(new cij(this.bWO.m6455F(13, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(13, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(14, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(14, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(15, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(15, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(16, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(16, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(17, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(17, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(18, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(18, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(19, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(19, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(20, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(20, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(21, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(21, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(22, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(22, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWO.m6455F(23, 0, 0).getTime(), 12000000));
                arrayList.add(new cij(this.bWO.m6455F(23, 30, 0).getTime(), 18000000));
                arrayList.add(new cij(this.bWO.m6455F(24, 0, 0).getTime(), 12000000));
                this.bWO.m6453F(arrayList);
            }
        }.start();
    }

    private void m6453F(List<cij> list) {
        this.bWN.a(list, true, true);
    }

    public Date m6455F(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.set(10, i);
        instance.set(12, i2);
        instance.set(13, i3);
        return instance.getTime();
    }
}
