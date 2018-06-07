package com.portfolio.platform.data.source;

public interface AlarmsSettingDataSource {

    public interface GetAlarmsSettingCallback {
        void onGetAlarmsSettingError();

        void onGetAlarmsSettingSuccess(boolean z);
    }

    public interface SetAlarmsSettingCallback {
        void onSetAlarmsSettingError();

        void onSetAlarmsSettingSuccess();
    }

    void getAlarmsSetting(GetAlarmsSettingCallback getAlarmsSettingCallback);

    void setAlarmsSetting(boolean z, SetAlarmsSettingCallback setAlarmsSettingCallback);
}
