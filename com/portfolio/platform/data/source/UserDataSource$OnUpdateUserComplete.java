package com.portfolio.platform.data.source;

import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.MFUser;

public interface UserDataSource$OnUpdateUserComplete {
    void onComplete(MFResponse mFResponse, boolean z, MFUser mFUser);
}
