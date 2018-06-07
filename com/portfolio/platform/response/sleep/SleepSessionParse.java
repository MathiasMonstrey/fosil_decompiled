package com.portfolio.platform.response.sleep;

import com.fossil.cfj;
import com.fossil.cnf;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.fossil.wearables.fsl.sleep.SleepDistribution;
import com.misfit.frameworks.buttonservice.model.WrapperSleepStateChange;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

public class SleepSessionParse {
    private int bookmarkTime;
    private DateTime createdAt;
    private String date;
    private String deviceSerialNumber;
    private int editedEndTime;
    private int editedSleepMinutes;
    private int[] editedSleepStateDistInMinute;
    private int editedStartTime;
    private String href;
    private double normalizeSleepQuality;
    private String objectId;
    private String owner;
    private int realEndTime;
    private int realSleepMinutes;
    private int[] realSleepStateDistInMinute;
    private int realStartTime;
    private List<int[]> sleepStates;
    private int source;
    private int syncTime;
    private int timezoneOffset;
    private DateTime updatedAt;

    public SleepSessionParse(DateTime dateTime, DateTime dateTime2, String str, String str2, String str3, int i, int i2, String str4, int i3, int i4, int i5, int i6, int i7, int[] iArr, int i8, int i9, int i10, int[] iArr2, double d, List<int[]> list, String str5) {
        this.createdAt = dateTime;
        this.updatedAt = dateTime2;
        this.objectId = str;
        this.owner = str2;
        this.date = str3;
        this.timezoneOffset = i;
        this.source = i2;
        this.deviceSerialNumber = str4;
        this.syncTime = i3;
        this.bookmarkTime = i4;
        this.realStartTime = i5;
        this.realEndTime = i6;
        this.realSleepMinutes = i7;
        this.realSleepStateDistInMinute = iArr;
        this.editedStartTime = i8;
        this.editedEndTime = i9;
        this.editedSleepMinutes = i10;
        this.editedSleepStateDistInMinute = iArr2;
        this.normalizeSleepQuality = d;
        this.sleepStates = list;
        this.href = str5;
    }

    public MFSleepSession getMFSleepSessionBySleepSessionParse() {
        String stringSleepDistributionByArrayInt = SleepDistribution.getStringSleepDistributionByArrayInt(this.editedSleepStateDistInMinute);
        String stringSleepDistributionByArrayInt2 = SleepDistribution.getStringSleepDistributionByArrayInt(this.realSleepStateDistInMinute);
        List arrayList = new ArrayList();
        for (int i = 0; i < this.sleepStates.size(); i++) {
            int[] iArr = (int[]) this.sleepStates.get(i);
            if (iArr != null && iArr.length > 1) {
                arrayList.add(new WrapperSleepStateChange(iArr[0], (long) iArr[1]));
            }
        }
        return new MFSleepSession(cnf.go(this.date), this.timezoneOffset, this.owner, this.date, this.objectId, this.deviceSerialNumber, this.syncTime, this.bookmarkTime, this.normalizeSleepQuality, this.source, this.realStartTime, this.realEndTime, this.realSleepMinutes, stringSleepDistributionByArrayInt2, this.editedStartTime, this.editedEndTime, this.editedSleepMinutes, stringSleepDistributionByArrayInt, new cfj().toJson(arrayList), this.createdAt, this.updatedAt);
    }

    public static MFSleepSession getMFSleepSessionBySleepSessionParse(SleepSessionParse sleepSessionParse) {
        if (sleepSessionParse == null) {
            return null;
        }
        String stringSleepDistributionByArrayInt = SleepDistribution.getStringSleepDistributionByArrayInt(sleepSessionParse.editedSleepStateDistInMinute);
        String stringSleepDistributionByArrayInt2 = SleepDistribution.getStringSleepDistributionByArrayInt(sleepSessionParse.realSleepStateDistInMinute);
        List arrayList = new ArrayList();
        for (int i = 0; i < sleepSessionParse.sleepStates.size(); i++) {
            int[] iArr = (int[]) sleepSessionParse.sleepStates.get(i);
            if (iArr != null && iArr.length > 1) {
                arrayList.add(new WrapperSleepStateChange(iArr[0], (long) iArr[1]));
            }
        }
        return new MFSleepSession(cnf.go(sleepSessionParse.date), sleepSessionParse.timezoneOffset, sleepSessionParse.owner, sleepSessionParse.date, sleepSessionParse.objectId, sleepSessionParse.deviceSerialNumber, sleepSessionParse.syncTime, sleepSessionParse.bookmarkTime, sleepSessionParse.normalizeSleepQuality, sleepSessionParse.source, sleepSessionParse.realStartTime, sleepSessionParse.realEndTime, sleepSessionParse.realSleepMinutes, stringSleepDistributionByArrayInt2, sleepSessionParse.editedStartTime, sleepSessionParse.editedEndTime, sleepSessionParse.editedSleepMinutes, stringSleepDistributionByArrayInt, new cfj().toJson(arrayList), sleepSessionParse.createdAt, sleepSessionParse.updatedAt);
    }
}
