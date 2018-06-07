package com.portfolio.platform.data.source;

import com.misfit.frameworks.buttonservice.model.Alarm;
import java.util.List;

public interface AlarmsDataSource {

    public interface DeleteAlarmCallback {
        void onDeleteAlarmError();

        void onDeleteAlarmSuccess(Alarm alarm);
    }

    public interface DeleteAlarmsCallback {
        void onDeleteAlarmsError();

        void onDeleteAlarmsSuccess();
    }

    public interface LoadAlarmsCallback {
        void onAlarmsLoaded(List<Alarm> list);

        void onDataNotAvailable();
    }

    public interface PushPendingAlarmsCallback {
        void onDone();
    }

    public interface PutAlarmCallback {
        void onPutAlarmError();

        void onPutAlarmSuccess(Alarm alarm);
    }

    void cleanUp();

    void deleteAlarm(Alarm alarm, DeleteAlarmCallback deleteAlarmCallback);

    Alarm findAlarm(String str);

    void getActiveAlarms(LoadAlarmsCallback loadAlarmsCallback);

    void getAlarms(LoadAlarmsCallback loadAlarmsCallback);

    void getAllAlarmIgnorePinType(LoadAlarmsCallback loadAlarmsCallback);

    void setAlarm(Alarm alarm, PutAlarmCallback putAlarmCallback);
}
