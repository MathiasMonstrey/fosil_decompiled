package com.portfolio.platform.service;

import android.content.Intent;
import android.os.Bundle;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import java.util.ArrayList;

class MFDeviceService$a {
    private CommunicateMode cDo;
    private int cDp;
    private ArrayList<Integer> cDq;
    private Bundle cDr;
    private int errorCode;
    private Intent intent;
    private String serial;
    private long timeStamp;

    public MFDeviceService$a(CommunicateMode communicateMode, String str, int i, int i2, ArrayList<Integer> arrayList, Bundle bundle, long j, Intent intent) {
        this.cDo = communicateMode;
        this.serial = str;
        this.cDp = i;
        this.errorCode = i2;
        this.cDq = arrayList;
        this.cDr = bundle;
        this.timeStamp = j;
        this.intent = intent;
    }

    public CommunicateMode aff() {
        return this.cDo;
    }

    public String getSerial() {
        return this.serial;
    }

    public int afg() {
        return this.cDp;
    }

    public ArrayList<Integer> afh() {
        return this.cDq;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public Bundle afi() {
        return this.cDr;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public String toString() {
        return String.format("Mode: %s \n Serial: %s \n Result: %s \n ErrorCode: %s \n ExtraInfo: %s \n TimeStamp: %s \n", new Object[]{this.cDo, this.serial, Integer.valueOf(this.cDp), Integer.valueOf(this.errorCode), this.cDr, Long.valueOf(this.timeStamp)});
    }
}
