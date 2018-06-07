package com.portfolio.platform.data.source;

import com.fossil.cco;
import com.fossil.cfj;
import com.fossil.cnq;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.PinObject;
import com.portfolio.platform.data.source.AlarmsSettingDataSource.GetAlarmsSettingCallback;
import com.portfolio.platform.data.source.AlarmsSettingDataSource.SetAlarmsSettingCallback;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import java.util.List;

public class AlarmsSettingRepository implements AlarmsSettingDataSource {
    private static final String TAG = "AlarmsSettingRepository";
    private final AlarmsSettingDataSource mAlarmsSettingLocalDataSource;
    private final AlarmsSettingDataSource mAlarmsSettingRemoteDataSource;
    private boolean mCacheIsDirty = true;
    private boolean mCachedAlarmsSetting;
    private final cnq mProviderManager;

    AlarmsSettingRepository(@Local AlarmsSettingDataSource alarmsSettingDataSource, @Remote AlarmsSettingDataSource alarmsSettingDataSource2, cnq com_fossil_cnq) {
        this.mAlarmsSettingLocalDataSource = (AlarmsSettingDataSource) cco.s(alarmsSettingDataSource, "alarmsSettingLocalDataSource cannot be null!");
        this.mAlarmsSettingRemoteDataSource = (AlarmsSettingDataSource) cco.s(alarmsSettingDataSource2, "alarmsSettingRemoteDataSource cannot be null!");
        this.mProviderManager = (cnq) cco.s(com_fossil_cnq, "pinProvider cannot be null!");
    }

    public void getAlarmsSetting(final GetAlarmsSettingCallback getAlarmsSettingCallback) {
        cco.ce(getAlarmsSettingCallback);
        if (this.mCacheIsDirty) {
            this.mAlarmsSettingRemoteDataSource.getAlarmsSetting(new GetAlarmsSettingCallback() {
                public void onGetAlarmsSettingSuccess(boolean z) {
                    AlarmsSettingRepository.this.mCacheIsDirty = false;
                    AlarmsSettingRepository.this.mCachedAlarmsSetting = z;
                    AlarmsSettingRepository.this.mAlarmsSettingLocalDataSource.setAlarmsSetting(z, null);
                    getAlarmsSettingCallback.onGetAlarmsSettingSuccess(z);
                }

                public void onGetAlarmsSettingError() {
                    AlarmsSettingRepository.this.mAlarmsSettingLocalDataSource.getAlarmsSetting(getAlarmsSettingCallback);
                }
            });
        } else {
            getAlarmsSettingCallback.onGetAlarmsSettingSuccess(this.mCachedAlarmsSetting);
        }
    }

    public void setAlarmsSetting(boolean z, SetAlarmsSettingCallback setAlarmsSettingCallback) {
        this.mAlarmsSettingLocalDataSource.setAlarmsSetting(z, null);
        this.mCachedAlarmsSetting = z;
        final PinObject pinObject = new PinObject(TAG, Boolean.valueOf(z));
        pinAlarmsSettingObject(pinObject);
        this.mAlarmsSettingRemoteDataSource.setAlarmsSetting(z, new SetAlarmsSettingCallback() {
            public void onSetAlarmsSettingSuccess() {
                AlarmsSettingRepository.this.mProviderManager.acq().b(pinObject);
            }

            public void onSetAlarmsSettingError() {
            }
        });
    }

    private void pinAlarmsSettingObject(PinObject pinObject) {
        List<PinObject> hu = this.mProviderManager.acq().hu(TAG);
        if (hu != null) {
            for (PinObject b : hu) {
                this.mProviderManager.acq().b(b);
            }
        }
        this.mProviderManager.acq().a(pinObject);
    }

    void executePendingRequest() {
        MFLogger.d(TAG, "Inside AlarmsSettingRepository.executePendingRequest");
        cfj com_fossil_cfj = new cfj();
        for (final PinObject pinObject : this.mProviderManager.acq().hu(TAG)) {
            this.mAlarmsSettingRemoteDataSource.setAlarmsSetting(((Boolean) com_fossil_cfj.c(pinObject.getJsonData(), Boolean.class)).booleanValue(), new SetAlarmsSettingCallback() {
                public void onSetAlarmsSettingSuccess() {
                    AlarmsSettingRepository.this.mProviderManager.acq().b(pinObject);
                }

                public void onSetAlarmsSettingError() {
                }
            });
        }
    }

    void refreshAlarmsSetting() {
        this.mCacheIsDirty = true;
    }
}
