package com.fossil;

import com.fossil.wearables.fsl.BaseProvider;
import com.portfolio.platform.data.model.DataVersion;

public interface coi extends BaseProvider {
    void adQ();

    void addOrUpdateDataVersioning(DataVersion dataVersion);

    DataVersion hc(String str);

    void removeDataVersion(String str);
}
