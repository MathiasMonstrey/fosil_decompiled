package com.portfolio.platform.data.source.local;

import com.fossil.cnq;
import com.portfolio.platform.data.source.UAppSystemVersionDataSource;
import com.portfolio.platform.model.UAppSystemVersionModel;

public class UAppSystemVersionLocalDataSource implements UAppSystemVersionDataSource {
    public UAppSystemVersionModel getUAppSystemVersionModel(String str) {
        return cnq.acd().acp().getUAppSystemVersionModel(str);
    }

    public void addOrUpdateUAppSystemVersionModel(UAppSystemVersionModel uAppSystemVersionModel) {
        cnq.acd().acp().addOrUpdateUAppSystemVersionModel(uAppSystemVersionModel);
    }
}
