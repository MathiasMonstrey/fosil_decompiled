package com.portfolio.platform.data.source.local;

import com.fossil.cnq;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.AlarmsDataSource;
import com.portfolio.platform.data.source.AlarmsDataSource.DeleteAlarmCallback;
import com.portfolio.platform.data.source.AlarmsDataSource.LoadAlarmsCallback;
import com.portfolio.platform.data.source.AlarmsDataSource.PutAlarmCallback;
import java.util.List;

public class AlarmsLocalDataSource implements AlarmsDataSource {
    private static final String TAG = "AlarmsLocalDataSource";

    public void getAlarms(LoadAlarmsCallback loadAlarmsCallback) {
        List jL = cnq.acd().acu().jL(3);
        if (jL == null || jL.isEmpty()) {
            MFLogger.d(TAG, "getAlarms - onDataNotAvailable");
            loadAlarmsCallback.onDataNotAvailable();
            return;
        }
        MFLogger.d(TAG, "getAlarms - alarms: " + jL.size());
        loadAlarmsCallback.onAlarmsLoaded(jL);
    }

    public void getAllAlarmIgnorePinType(LoadAlarmsCallback loadAlarmsCallback) {
        List adE = cnq.acd().acu().adE();
        if (adE == null || adE.isEmpty()) {
            MFLogger.d(TAG, "getAllAlarmIgnorePinType - onDataNotAvailable");
            loadAlarmsCallback.onDataNotAvailable();
            return;
        }
        MFLogger.d(TAG, "getAllAlarmIgnorePinType - alarms: " + adE.size());
        loadAlarmsCallback.onAlarmsLoaded(adE);
    }

    public void setAlarm(Alarm alarm, PutAlarmCallback putAlarmCallback) {
        MFLogger.d(TAG, "setAlarm - alarm" + alarm.getAlarmTitle());
        cnq.acd().acu().d(alarm);
        if (putAlarmCallback != null) {
            putAlarmCallback.onPutAlarmSuccess(alarm);
        }
    }

    public void deleteAlarm(Alarm alarm, DeleteAlarmCallback deleteAlarmCallback) {
        MFLogger.d(TAG, "deleteAlarm - alarm" + alarm.getAlarmTitle());
        cnq.acd().acu().gZ(alarm.getUri());
        if (deleteAlarmCallback != null) {
            deleteAlarmCallback.onDeleteAlarmSuccess(alarm);
        }
    }

    public void cleanUp() {
        cnq.acd().acu().cleanUp();
    }

    public Alarm findAlarm(String str) {
        MFLogger.d(TAG, "findAlarm - alarmId=" + str);
        return cnq.acd().acu().findAlarm(str);
    }

    public void getActiveAlarms(LoadAlarmsCallback loadAlarmsCallback) {
        MFLogger.d(TAG, "getActiveAlarms - callback=" + loadAlarmsCallback);
        List adG = cnq.acd().acu().adG();
        if (adG == null || adG.isEmpty()) {
            MFLogger.d(TAG, "getActiveAlarms onDataNotAvailable");
            loadAlarmsCallback.onDataNotAvailable();
            return;
        }
        MFLogger.d(TAG, "getActiveAlarms activeAlarms.size=" + adG.size());
        loadAlarmsCallback.onAlarmsLoaded(adG);
    }
}
