package com.portfolio.platform.response.logService;

import com.misfit.frameworks.common.log.MFLogger;

public class FQLogServiceSyncSession extends FQBaseLogService {
    private long activityPoint;
    private int activityTaggingState;
    private String alarm;
    private int battery;
    private String calculationLibVersion;
    private int callNotificationState;
    private long deltaStep;
    private int deltaTimestamp;
    private String deviceIdentifier;
    private int failureReason;
    private long goal;
    private int inactiveNotificationState;
    private int isDataLoss;
    private int phoneTimestamp;
    private long postSyncActivityPoint;
    private long postSyncGoal;
    private int postSyncTimezone;
    private long realTimeStep;
    private int retries;
    private int syncMode;
    private int timezone;
    private long todaySumMinuteDataStep;
    private String userInfo;
    private int watchTimestamp;

    public FQLogServiceSyncSession(String str, int i, int i2, String str2, String str3, long j, long j2, int i3, int i4, long j3, long j4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j5, long j6, int[] iArr, String str4, String str5, String str6, String str7, long j7) {
        int i12;
        if (i6 == 0) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        super(str, i, i2, str2, i12, str3, iArr, str4, str5, str6);
        this.activityPoint = -1;
        this.postSyncActivityPoint = -1;
        this.timezone = -1;
        this.postSyncTimezone = -1;
        this.goal = -1;
        this.postSyncGoal = -1;
        this.battery = -1;
        this.failureReason = 0;
        this.retries = -1;
        this.syncMode = -1;
        this.activityTaggingState = -1;
        this.calculationLibVersion = "";
        this.watchTimestamp = -1;
        this.phoneTimestamp = -1;
        this.deltaTimestamp = -1;
        this.deviceIdentifier = "";
        this.alarm = "";
        this.inactiveNotificationState = -1;
        this.callNotificationState = -1;
        this.isDataLoss = -1;
        this.userInfo = "";
        this.activityPoint = j;
        this.postSyncActivityPoint = j2;
        this.timezone = i3;
        this.postSyncTimezone = i4;
        this.goal = j3;
        this.postSyncGoal = j4;
        this.battery = i5;
        this.failureReason = i6;
        this.retries = i7;
        this.syncMode = i8;
        this.activityTaggingState = i9;
        this.calculationLibVersion = str7;
        this.watchTimestamp = i10;
        this.phoneTimestamp = i11;
        this.deltaTimestamp = i10 - i11;
        this.realTimeStep = j5;
        MFLogger.d("FQLogServiceSyncSession", ".FQLogServiceSyncSession - todaySumMinuteDataStep=" + j6);
        this.todaySumMinuteDataStep = j7;
        this.deltaStep = j5 - this.todaySumMinuteDataStep;
    }
}
