package com.portfolio.platform.data.source;

import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.MFUser;

public interface UserDataSource$OnLoadUserInfoComplete {
    void onComplete(MFResponse mFResponse, MFUser mFUser);
}
