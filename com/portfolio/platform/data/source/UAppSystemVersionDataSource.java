package com.portfolio.platform.data.source;

import com.portfolio.platform.model.UAppSystemVersionModel;

public interface UAppSystemVersionDataSource {
    void addOrUpdateUAppSystemVersionModel(UAppSystemVersionModel uAppSystemVersionModel);

    UAppSystemVersionModel getUAppSystemVersionModel(String str);
}
