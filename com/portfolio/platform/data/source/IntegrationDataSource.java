package com.portfolio.platform.data.source;

import com.portfolio.platform.data.model.Integration;
import java.util.List;

public interface IntegrationDataSource {

    public interface GetListIntegrationCallback {
        void onFailed(int i);

        void onSuccess(List<Integration> list);
    }

    void addOrUpdateListIntegration(List<Integration> list);

    List<Integration> getAllIntegrations(GetListIntegrationCallback getListIntegrationCallback);

    void refreshIntegration();
}
