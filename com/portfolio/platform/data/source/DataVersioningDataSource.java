package com.portfolio.platform.data.source;

import com.portfolio.platform.data.model.DataVersion;
import java.util.List;

public interface DataVersioningDataSource {

    public interface GetDataVersioningCallback {
        void onFailed(int i);

        void onSuccess(List<DataVersion> list);
    }

    void addOrUpdateDataVersioning(DataVersion dataVersion);

    void checkDataVersioning(GetDataVersioningCallback getDataVersioningCallback);

    void clearAllDataVersioning();

    void clearDeviceDataVersioning();

    DataVersion getDataVersion(String str);

    DataVersion getDataVersioning(String str);

    void removeDataVersion(String str);
}
