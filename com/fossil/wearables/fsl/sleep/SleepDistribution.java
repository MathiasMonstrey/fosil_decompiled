package com.fossil.wearables.fsl.sleep;

import com.fossil.cfj;
import com.fossil.cgu;

public class SleepDistribution {
    private int awake;
    private int deep;
    private int light;

    static class C41951 extends cgu<SleepDistribution> {
        C41951() {
        }
    }

    public SleepDistribution(int i, int i2, int i3) {
        this.awake = i;
        this.deep = i3;
        this.light = i2;
    }

    public int getAwake() {
        return this.awake;
    }

    public void setAwake(int i) {
        this.awake = i;
    }

    public int getDeep() {
        return this.deep;
    }

    public void setDeep(int i) {
        this.deep = i;
    }

    public int getLight() {
        return this.light;
    }

    public void setLight(int i) {
        this.light = i;
    }

    public String getSleepDistribution() {
        return new cfj().toJson(this);
    }

    public static SleepDistribution getSleepDistributionByString(String str) {
        return (SleepDistribution) new cfj().a(str, new C41951().getType());
    }

    public static String getStringSleepDistributionByArrayInt(int[] iArr) {
        String str = "";
        if (iArr != null && iArr.length > 2) {
            return new SleepDistribution(iArr[0], iArr[1], iArr[2]).getSleepDistribution();
        }
        return str;
    }

    public int getTotalMinuteBySleepDistribution() {
        return (this.awake + this.light) + this.deep;
    }

    public static int getTotalMinuteBySleepDistribution(SleepDistribution sleepDistribution) {
        if (sleepDistribution == null) {
            return 0;
        }
        return (sleepDistribution.getAwake() + sleepDistribution.getLight()) + sleepDistribution.getDeep();
    }

    public int[] getArrayDistribution() {
        return new int[]{this.awake, this.light, this.deep};
    }
}
