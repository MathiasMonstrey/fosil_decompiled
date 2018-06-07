package com.portfolio.platform.data.source.local;

import android.content.Context;
import com.fossil.cco;
import com.fossil.cnr;
import com.portfolio.platform.data.source.AlarmsSettingDataSource;
import com.portfolio.platform.data.source.AlarmsSettingDataSource.GetAlarmsSettingCallback;
import com.portfolio.platform.data.source.AlarmsSettingDataSource.SetAlarmsSettingCallback;

public class AlarmsSettingLocalDataSource implements AlarmsSettingDataSource {
    private final Context mApplicationContext;
    private final cnr mSharedPreferencesManager;

    public AlarmsSettingLocalDataSource(Context context, cnr com_fossil_cnr) {
        this.mApplicationContext = (Context) cco.s(context, "context cannot be null!");
        this.mSharedPreferencesManager = com_fossil_cnr;
    }

    public void getAlarmsSetting(GetAlarmsSettingCallback getAlarmsSettingCallback) {
        if (getAlarmsSettingCallback != null) {
            getAlarmsSettingCallback.onGetAlarmsSettingSuccess(this.mSharedPreferencesManager.bA(this.mApplicationContext));
        }
    }

    public void setAlarmsSetting(boolean z, SetAlarmsSettingCallback setAlarmsSettingCallback) {
        this.mSharedPreferencesManager.i(this.mApplicationContext, z);
        if (setAlarmsSettingCallback != null) {
            setAlarmsSettingCallback.onSetAlarmsSettingSuccess();
        }
    }
}
