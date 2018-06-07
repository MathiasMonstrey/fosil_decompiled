package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.SparseIntArray;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2133c;
import com.fossil.clx.C2164b;
import com.fossil.cwx.C2455a;
import com.fossil.cwx.C2456b;
import com.fossil.cxh.C2475a;
import com.fossil.cxh.C2476b;
import com.fossil.cxh.C2477c;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.enums.PermissionCodes;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class cwz implements C2455a {
    private final String TAG = "AlarmSetPresenter";
    private final List<Alarm> cIW;
    private Alarm cJI;
    private final C2456b cJV;
    private int cJW;
    private boolean cJX;
    private SparseIntArray cJY;
    private boolean cJZ;
    private final cmj cJv;
    private final cxh cJy;
    private Context mApplicationContext;
    private final String mDeviceId;
    private String mName;
    private final ckc mUseCaseHandler;

    class C24731 implements C2126d<C2133c, C2475a> {
        final /* synthetic */ cwz cKa;

        C24731(cwz com_fossil_cwz) {
            this.cKa = com_fossil_cwz;
        }

        public /* synthetic */ void onError(Object obj) {
            m7831a((C2475a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m7830a((C2133c) obj);
        }

        public void m7830a(C2133c c2133c) {
            MFLogger.m12670d("AlarmSetPresenter", "saveAlarm SetAlarms onSuccess");
            this.cKa.cJV.afU();
            Alarm b = this.cKa.cJI != null ? this.cKa.cJI : ((C2477c) c2133c).getAlarm();
            b.setSynced(true);
            this.cKa.cJV.mo2167c(b, true);
        }

        public void m7831a(C2475a c2475a) {
            MFLogger.m12670d("AlarmSetPresenter", "saveAlarm SetAlarms onError");
            this.cKa.cJV.afU();
            int ajg = c2475a.ajg();
            MFLogger.m12670d("AlarmSetPresenter", "saveAlarm - SetAlarms - onError - lastErrorCode = " + ajg);
            if (ajg == FailureCode.BLUETOOTH_IS_DISABLED || ajg == FailureCode.LOCATION_SERVICE_DISABLED || ajg == FailureCode.LOCATION_ACCESS_DENIED) {
                this.cKa.cJV.m7524a((PermissionCodes[]) PermissionCodes.convertBLEPermissionErrorCode(c2475a.ajf()).toArray(new PermissionCodes[0]));
            } else if (this.cKa.cJI == null) {
                this.cKa.cJV.mo2167c(c2475a.getAlarm(), false);
            } else {
                this.cKa.cJV.aiQ();
            }
        }
    }

    cwz(Context context, cmj com_fossil_cmj, C2456b c2456b, String str, List<Alarm> list, Alarm alarm, ckc com_fossil_ckc, cxh com_fossil_cxh) {
        this.mApplicationContext = (Context) cco.m5996s(context, "applicationContext cannot be null!");
        this.cJv = (cmj) cco.m5996s(com_fossil_cmj, "analyticsHelper cannot be null!");
        this.cJV = (C2456b) cco.m5996s(c2456b, "view cannot be null!");
        this.cIW = (List) cco.m5996s(list, "alarms cannot be null!");
        this.cJI = alarm;
        this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be null!");
        this.cJy = (cxh) cco.m5996s(com_fossil_cxh, "setAlarms cannot be null!");
    }

    public void ahu() {
        this.cJV.cK(this);
    }

    public void start() {
        MFLogger.m12670d("AlarmSetPresenter", "start");
        PortfolioApp.cM(this);
        this.cJy.ajd();
        PortfolioApp.ZQ().m12685I(Collections.singletonList(CommunicateMode.SET_LIST_ALARM));
        this.cJV.hW(arp.m4318u(this.mApplicationContext, this.cJI == null ? R.string.Device_Alarm_Empty_CTA_Add_Alarm : R.string.Device_Alarm_Edit_Title_EDIT_ALARM));
        this.cJV.cs(this.cJI != null);
        if (this.cJY == null) {
            this.cJY = new SparseIntArray();
        }
        if (this.mName == null) {
            if (this.cJI != null) {
                this.mName = this.cJI.getAlarmTitle();
                this.cJW = this.cJI.getAlarmMinute();
                this.cJX = this.cJI.isRepeat();
                this.cJY = m7835h(this.cJI.getDays());
                this.cJZ = this.cJI.isActive();
            } else {
                this.mName = arp.m4318u(this.mApplicationContext, R.string.Device_Alarm_Empty_Title_Alarm);
                this.cJZ = true;
                this.cJX = true;
                this.cJY = m7835h(new int[]{2, 3, 4, 5, 6, 7, 1});
            }
            this.cJV.hX(this.mName);
        }
        this.cJV.kk(this.cJW);
        this.cJV.mo2165b(this.cJY);
        this.cJV.ct(this.cJZ);
    }

    public void stop() {
        MFLogger.m12670d("AlarmSetPresenter", "stop");
        PortfolioApp.cN(this);
        this.cJy.aje();
    }

    public void hV(String str) {
        MFLogger.m12670d("AlarmSetPresenter", "updateName - name: " + str);
        this.mName = str;
    }

    public void mo2174a(String str, String str2, boolean z) {
        int intValue;
        int intValue2;
        Object obj;
        int i = 0;
        int i2 = 12;
        MFLogger.m12670d("AlarmSetPresenter", "updateTime - hourValue: " + str + " - minuteValue: " + str2 + " - isPM: " + z);
        try {
            intValue = Integer.valueOf(str).intValue();
            try {
                intValue2 = Integer.valueOf(str2).intValue();
            } catch (Exception e) {
                Exception exception = e;
                intValue2 = intValue;
                Exception exception2 = exception;
                abm.m2872a(0, "AlarmSetPresenter", "Exception when parse time e=" + obj);
                intValue = intValue2;
                intValue2 = 0;
                if (DateFormat.is24HourFormat(this.mApplicationContext)) {
                    if (!z) {
                        if (intValue != 12) {
                            i2 = intValue + 12;
                        }
                        i = i2;
                    } else if (intValue != 12) {
                        i = intValue;
                    }
                    this.cJW = intValue2 + (i * 60);
                } else {
                    i = z ? intValue : intValue == 12 ? intValue + 12 : 12;
                    this.cJW = intValue2 + (i * 60);
                }
                this.cJV.kk(this.cJW);
            }
        } catch (Exception e2) {
            obj = e2;
            intValue2 = 0;
            abm.m2872a(0, "AlarmSetPresenter", "Exception when parse time e=" + obj);
            intValue = intValue2;
            intValue2 = 0;
            if (DateFormat.is24HourFormat(this.mApplicationContext)) {
                if (z) {
                    if (intValue == 12) {
                    }
                }
                this.cJW = intValue2 + (i * 60);
            } else {
                if (!z) {
                    if (intValue != 12) {
                        i2 = intValue + 12;
                    }
                    i = i2;
                } else if (intValue != 12) {
                    i = intValue;
                }
                this.cJW = intValue2 + (i * 60);
            }
            this.cJV.kk(this.cJW);
        }
        if (DateFormat.is24HourFormat(this.mApplicationContext)) {
            if (z) {
                if (intValue == 12) {
                }
            }
            this.cJW = intValue2 + (i * 60);
        } else {
            if (!z) {
                if (intValue != 12) {
                    i2 = intValue + 12;
                }
                i = i2;
            } else if (intValue != 12) {
                i = intValue;
            }
            this.cJW = intValue2 + (i * 60);
        }
        this.cJV.kk(this.cJW);
    }

    public void cq(boolean z) {
        MFLogger.m12670d("AlarmSetPresenter", "updateIsRepeat: b = " + z);
        this.cJX = z;
        this.cJV.mo2165b(z ? this.cJY : new SparseIntArray());
    }

    public void mo2173a(SparseIntArray sparseIntArray) {
        MFLogger.m12670d("AlarmSetPresenter", "updateDaysRepeat: days = " + sparseIntArray);
        this.cJY = sparseIntArray;
    }

    public void cr(boolean z) {
        this.cJZ = z;
    }

    public void ajj() {
        MFLogger.m12670d("AlarmSetPresenter", "saveAlarm");
        if (TextUtils.isEmpty(this.mName)) {
            this.cJV.ajl();
            return;
        }
        this.cJV.afT();
        String i = cmq.m7131i(Calendar.getInstance().getTime());
        int[] iArr = null;
        if (this.cJX) {
            iArr = m7834d(this.cJY);
        }
        Alarm alarm = new Alarm(this.mName, this.cJW, this.cJX, i, true, iArr);
        if (this.cJI != null) {
            this.cJI.setActive(this.cJZ);
            this.cJI.setAlarmTitle(this.mName);
            this.cJI.setAlarmMinute(this.cJW);
            this.cJI.setRepeat(this.cJX);
            this.cJI.setDays(iArr);
            this.cJI.setSynced(false);
            this.cJI.setUpdatedAt(i);
            for (Alarm alarm2 : this.cIW) {
                if (alarm2.is(this.cJI)) {
                    this.cIW.set(this.cIW.indexOf(alarm2), this.cJI);
                    break;
                }
            }
        }
        this.cIW.add(alarm);
        MFLogger.m12670d("AlarmSetPresenter", "saveAlarm SetAlarms");
        ckc com_fossil_ckc = this.mUseCaseHandler;
        ckb com_fossil_ckb = this.cJy;
        i = this.mDeviceId;
        List list = this.cIW;
        if (this.cJI != null) {
            alarm = this.cJI;
        }
        com_fossil_ckc.m6886a(com_fossil_ckb, new C2476b(i, list, alarm), new C24731(this));
    }

    public void ajk() {
        this.cJV.bX(this.cJW, this.cJI == null ? R.string.Device_Alarm_Empty_CTA_Add_Alarm : R.string.Device_Alarm_Edit_Title_EDIT_ALARM);
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int getMinutes() {
        return this.cJW;
    }

    public void setMinutes(int i) {
        this.cJW = i;
    }

    public boolean isActive() {
        return this.cJZ;
    }

    public void cu(boolean z) {
        this.cJZ = z;
    }

    public boolean isRepeat() {
        return this.cJX;
    }

    public void cv(boolean z) {
        this.cJX = z;
    }

    public SparseIntArray ajn() {
        return this.cJY;
    }

    public void m7838c(SparseIntArray sparseIntArray) {
        this.cJY = sparseIntArray;
    }

    public static int[] m7834d(SparseIntArray sparseIntArray) {
        int size = sparseIntArray != null ? sparseIntArray.size() : 0;
        if (size <= 0) {
            return null;
        }
        int i = 0;
        while (i < size) {
            if (sparseIntArray.keyAt(i) != sparseIntArray.valueAt(i)) {
                sparseIntArray.removeAt(i);
                size--;
                i--;
            }
            i++;
        }
        int size2 = sparseIntArray.size();
        if (size2 <= 0) {
            return null;
        }
        int[] iArr = new int[size2];
        for (size = 0; size < size2; size++) {
            iArr[size] = sparseIntArray.valueAt(size);
        }
        return iArr;
    }

    public static SparseIntArray m7835h(int[] iArr) {
        int i = 0;
        int length = iArr != null ? iArr.length : 0;
        if (length <= 0) {
            return new SparseIntArray();
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i < length) {
            int i2 = iArr[i];
            sparseIntArray.put(i2, i2);
            i++;
        }
        return sparseIntArray;
    }

    @dxn
    public void onSetAlarmEventEndComplete(C2164b c2164b) {
        MFLogger.m12670d("AlarmSetPresenter", "onSetAlarmEventEndComplete - event=" + c2164b);
        if (c2164b != null && c2164b.Kb()) {
            String uri = c2164b.getUri();
            for (Alarm alarm : this.cIW) {
                if (alarm.getUri().equals(uri)) {
                    alarm.setActive(false);
                }
            }
        }
    }
}
