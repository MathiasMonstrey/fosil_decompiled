package com.portfolio.platform.data.source.remote;

import com.fossil.cpx;
import com.fossil.cpz;
import com.fossil.cqb;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.AlarmsDataSource;
import com.portfolio.platform.data.source.AlarmsDataSource.DeleteAlarmCallback;
import com.portfolio.platform.data.source.AlarmsDataSource.LoadAlarmsCallback;
import com.portfolio.platform.data.source.AlarmsDataSource.PutAlarmCallback;
import com.portfolio.platform.response.alarm.MFAlarmResponse;
import com.portfolio.platform.response.alarm.MFListAlarmResponse;

public class AlarmsRemoteDataSource implements AlarmsDataSource {
    private static final String TAG = "AlarmsRemoteDataSource";

    public void getAlarms(final LoadAlarmsCallback loadAlarmsCallback) {
        MFLogger.d(TAG, "getAlarms");
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cpz(PortfolioApp.ZQ()), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(AlarmsRemoteDataSource.TAG, "getAlarms onSuccess");
                loadAlarmsCallback.onAlarmsLoaded(((MFListAlarmResponse) mFResponse).getAlarmList());
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(AlarmsRemoteDataSource.TAG, "getAlarms onFail");
                loadAlarmsCallback.onDataNotAvailable();
            }
        });
    }

    public void getAllAlarmIgnorePinType(LoadAlarmsCallback loadAlarmsCallback) {
    }

    public void setAlarm(Alarm alarm, final PutAlarmCallback putAlarmCallback) {
        MFLogger.d(TAG, "setAlarm");
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqb(PortfolioApp.ZQ(), alarm), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(AlarmsRemoteDataSource.TAG, "setAlarm onSuccess");
                if (putAlarmCallback != null) {
                    putAlarmCallback.onPutAlarmSuccess(((MFAlarmResponse) mFResponse).getAlarm());
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(AlarmsRemoteDataSource.TAG, "setAlarm onFail");
                if (putAlarmCallback != null) {
                    putAlarmCallback.onPutAlarmError();
                }
            }
        });
    }

    public void deleteAlarm(final Alarm alarm, final DeleteAlarmCallback deleteAlarmCallback) {
        MFLogger.d(TAG, "deleteAlarm");
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cpx(PortfolioApp.ZQ(), alarm.getObjectId()), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(AlarmsRemoteDataSource.TAG, "deleteAlarm onSuccess");
                if (deleteAlarmCallback != null) {
                    deleteAlarmCallback.onDeleteAlarmSuccess(alarm);
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(AlarmsRemoteDataSource.TAG, "deleteAlarm onFail");
                if (deleteAlarmCallback != null) {
                    deleteAlarmCallback.onDeleteAlarmError();
                }
            }
        });
    }

    public void cleanUp() {
    }

    public Alarm findAlarm(String str) {
        return null;
    }

    public void getActiveAlarms(LoadAlarmsCallback loadAlarmsCallback) {
    }
}
