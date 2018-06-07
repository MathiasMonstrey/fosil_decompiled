package com.fossil;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.cho.C2077b;
import com.fossil.cho.C2078c;
import com.misfit.chart.lib.CubicChart;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class chq extends Fragment {
    boolean bWL = false;
    CountDownTimer bWM;
    CubicChart bWN;

    class C20851 implements chs {
        final /* synthetic */ chq bWV;

        C20851(chq com_fossil_chq) {
            this.bWV = com_fossil_chq;
        }

        public void mo1715w(float f, float f2) {
            final float f3 = f;
            this.bWV.bWM = new CountDownTimer(this, 1000, 1000) {
                final /* synthetic */ C20851 bWW;

                class C20821 implements Runnable {
                    final /* synthetic */ C20841 bWX;

                    C20821(C20841 c20841) {
                        this.bWX = c20841;
                    }

                    public void run() {
                        this.bWX.bWW.bWV.bWN.ji(20);
                        List arrayList = new ArrayList();
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(0, 0, 0).getTime(), 18000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(1, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(2, 0, 0).getTime(), 48000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(3, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(4, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(4, 30, 0).getTime(), 42000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(5, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(5, 30, 0).getTime(), 30000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(6, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(6, 30, 0).getTime(), 24000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(7, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(7, 30, 0).getTime(), 54000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(8, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(8, 30, 0).getTime(), 1800000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(9, 0, 0).getTime(), 36000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(9, 30, 0).getTime(), 1800000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(10, 0, 0).getTime(), 12000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(10, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(11, 0, 0).getTime(), 18000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(11, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(12, 0, 0).getTime(), 6000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(12, 30, 0).getTime(), 18000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(13, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(13, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(14, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(14, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(15, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(15, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(16, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(16, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(17, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(17, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(18, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(18, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(19, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(19, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(20, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(20, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(21, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(21, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(22, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(22, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(23, 0, 0).getTime(), 12000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(23, 30, 0).getTime(), 18000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(24, 0, 0).getTime(), 12000000));
                        this.bWX.bWW.bWV.m6470F(arrayList);
                    }
                }

                class C20832 implements Runnable {
                    final /* synthetic */ C20841 bWX;

                    C20832(C20841 c20841) {
                        this.bWX = c20841;
                    }

                    public void run() {
                        List arrayList = new ArrayList();
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(0, 0, 0).getTime(), 18000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(1, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(2, 0, 0).getTime(), 48000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(3, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(4, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(4, 30, 0).getTime(), 42000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(5, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(5, 30, 0).getTime(), 30000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(6, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(6, 30, 0).getTime(), 24000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(7, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(7, 30, 0).getTime(), 54000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(8, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(8, 30, 0).getTime(), 1800000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(9, 0, 0).getTime(), 36000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(9, 30, 0).getTime(), 1800000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(10, 0, 0).getTime(), 12000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(10, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(11, 0, 0).getTime(), 18000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(11, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(12, 0, 0).getTime(), 6000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(12, 30, 0).getTime(), 18000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(13, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(13, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(14, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(14, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(15, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(15, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(16, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(16, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(17, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(17, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(18, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(18, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(19, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(19, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(20, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(20, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(21, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(21, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(22, 0, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(22, 30, 0).getTime(), 0));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(23, 0, 0).getTime(), 12000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(23, 30, 0).getTime(), 18000000));
                        arrayList.add(new cij(this.bWX.bWW.bWV.m6472F(24, 0, 0).getTime(), 12000000));
                        this.bWX.bWW.bWV.m6470F(arrayList);
                    }
                }

                public void onTick(long j) {
                }

                public void onFinish() {
                    this.bWW.bWV.bWN.jj((int) f3);
                    this.bWW.bWV.bWL = true;
                    new Handler().postDelayed(new C20821(this), 3000);
                    new Handler().postDelayed(new C20832(this), 5000);
                }
            };
            this.bWV.bWM.start();
        }

        public void mo1716x(float f, float f2) {
            if (this.bWV.bWL) {
                this.bWV.bWN.jj((int) f);
            }
        }

        public void mo1717y(float f, float f2) {
            if (this.bWV.bWM != null) {
                this.bWV.bWM.cancel();
            }
            this.bWV.bWL = false;
            this.bWV.bWN.freeMemory();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2078c.fragment_pager_list, viewGroup, false);
        this.bWN = (CubicChart) inflate.findViewById(C2077b.stackedbarchart2);
        this.bWN.setListener(new C20851(this));
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
        this.bWN.setStartCoordinateX(m6472F(0, 0, 0).getTime());
        this.bWN.setEndCoordinateX(m6472F(23, 59, 59).getTime());
        new CountDownTimer(this, 1000, 1000) {
            final /* synthetic */ chq bWV;

            public void onTick(long j) {
            }

            public void onFinish() {
                List arrayList = new ArrayList();
                arrayList.add(new cij(this.bWV.m6472F(0, 0, 0).getTime(), 18000000));
                arrayList.add(new cij(this.bWV.m6472F(1, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(2, 0, 0).getTime(), 48000000));
                arrayList.add(new cij(this.bWV.m6472F(3, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(4, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(4, 30, 0).getTime(), 42000000));
                arrayList.add(new cij(this.bWV.m6472F(5, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(5, 30, 0).getTime(), 30000000));
                arrayList.add(new cij(this.bWV.m6472F(6, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(6, 30, 0).getTime(), 24000000));
                arrayList.add(new cij(this.bWV.m6472F(7, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(7, 30, 0).getTime(), 54000000));
                arrayList.add(new cij(this.bWV.m6472F(8, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(8, 30, 0).getTime(), 1800000));
                arrayList.add(new cij(this.bWV.m6472F(9, 0, 0).getTime(), 36000000));
                arrayList.add(new cij(this.bWV.m6472F(9, 30, 0).getTime(), 1800000));
                arrayList.add(new cij(this.bWV.m6472F(10, 0, 0).getTime(), 12000000));
                arrayList.add(new cij(this.bWV.m6472F(10, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(11, 0, 0).getTime(), 18000000));
                arrayList.add(new cij(this.bWV.m6472F(11, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(12, 0, 0).getTime(), 6000000));
                arrayList.add(new cij(this.bWV.m6472F(12, 30, 0).getTime(), 18000000));
                arrayList.add(new cij(this.bWV.m6472F(13, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(13, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(14, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(14, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(15, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(15, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(16, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(16, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(17, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(17, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(18, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(18, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(19, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(19, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(20, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(20, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(21, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(21, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(22, 0, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(22, 30, 0).getTime(), 0));
                arrayList.add(new cij(this.bWV.m6472F(23, 0, 0).getTime(), 12000000));
                arrayList.add(new cij(this.bWV.m6472F(23, 30, 0).getTime(), 18000000));
                arrayList.add(new cij(this.bWV.m6472F(24, 0, 0).getTime(), 12000000));
                this.bWV.m6470F(arrayList);
            }
        }.start();
        return inflate;
    }

    private void m6470F(List<cij> list) {
        this.bWN.a(list, true, true);
    }

    public Date m6472F(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.set(10, i);
        instance.set(12, i2);
        instance.set(13, i3);
        return instance.getTime();
    }
}
