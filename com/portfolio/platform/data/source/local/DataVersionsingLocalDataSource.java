package com.portfolio.platform.data.source.local;

import com.fossil.cnq;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.DataVersion;
import com.portfolio.platform.data.source.DataVersioningDataSource;
import com.portfolio.platform.data.source.DataVersioningDataSource.GetDataVersioningCallback;

public class DataVersionsingLocalDataSource implements DataVersioningDataSource {
    private static final String TAG = DataVersionsingLocalDataSource.class.getSimpleName();

    public void addOrUpdateDataVersioning(DataVersion dataVersion) {
        cnq.acd().acf().addOrUpdateDataVersioning(dataVersion);
    }

    public DataVersion getDataVersioning(String str) {
        return cnq.acd().acf().hc(str);
    }

    public void checkDataVersioning(GetDataVersioningCallback getDataVersioningCallback) {
    }

    public void clearAllDataVersioning() {
        cnq.acd().acf().adQ();
    }

    public void removeDataVersion(String str) {
        MFLogger.d(TAG, "clearDeviceDataVersioning key=" + str);
        cnq.acd().acf().removeDataVersion(str);
    }

    public void clearDeviceDataVersioning() {
    }

    public DataVersion getDataVersion(String str) {
        return cnq.acd().acf().hc(str);
    }
}
