package com.portfolio.platform.data.source.local;

import com.fossil.cnq;
import com.fossil.cov;
import com.portfolio.platform.data.model.Integration;
import com.portfolio.platform.data.source.IntegrationDataSource;
import com.portfolio.platform.data.source.IntegrationDataSource.GetListIntegrationCallback;
import java.util.List;

public class IntegrationLocalDataSource implements IntegrationDataSource {
    public void addOrUpdateListIntegration(List<Integration> list) {
        cov acj = cnq.acd().acj();
        acj.aeA();
        for (Integration a : list) {
            acj.a(a);
        }
    }

    public List<Integration> getAllIntegrations(GetListIntegrationCallback getListIntegrationCallback) {
        return cnq.acd().acj().aez();
    }

    public void refreshIntegration() {
    }
}
