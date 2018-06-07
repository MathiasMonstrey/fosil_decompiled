package com.portfolio.platform.data.source;

import com.portfolio.platform.data.model.LandingPage;
import java.util.List;

public interface LandingPageDataSource {

    public interface GetListLandingPageCallback {
        void onFailed(int i);

        void onSuccess(List<LandingPage> list);
    }

    void addOrUpdateLandingPage(List<LandingPage> list);

    List<LandingPage> getAllLandingPage(GetListLandingPageCallback getListLandingPageCallback);

    void preloadLandingPage();

    void refreshLandingPage();
}
