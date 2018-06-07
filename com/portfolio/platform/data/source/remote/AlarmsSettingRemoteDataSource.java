package com.portfolio.platform.data.source.remote;

import android.content.Context;
import com.fossil.cpy;
import com.fossil.cqa;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.AlarmsSettingDataSource;
import com.portfolio.platform.data.source.AlarmsSettingDataSource.GetAlarmsSettingCallback;
import com.portfolio.platform.data.source.AlarmsSettingDataSource.SetAlarmsSettingCallback;
import com.portfolio.platform.response.MFEnableFeatureSettingResponse;

public class AlarmsSettingRemoteDataSource implements AlarmsSettingDataSource {
    private Context mApplicationContext;

    public AlarmsSettingRemoteDataSource(Context context) {
        this.mApplicationContext = context;
    }

    public void getAlarmsSetting(final GetAlarmsSettingCallback getAlarmsSettingCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cpy(this.mApplicationContext), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                if (getAlarmsSettingCallback != null) {
                    getAlarmsSettingCallback.onGetAlarmsSettingSuccess(((MFEnableFeatureSettingResponse) mFResponse).isEnable());
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                if (getAlarmsSettingCallback != null) {
                    getAlarmsSettingCallback.onGetAlarmsSettingError();
                }
            }
        });
    }

    public void setAlarmsSetting(boolean z, final SetAlarmsSettingCallback setAlarmsSettingCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqa(PortfolioApp.ZQ(), z), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                if (setAlarmsSettingCallback != null) {
                    setAlarmsSettingCallback.onSetAlarmsSettingSuccess();
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                if (setAlarmsSettingCallback != null) {
                    setAlarmsSettingCallback.onSetAlarmsSettingError();
                }
            }
        });
    }
}
