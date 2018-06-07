package com.portfolio.platform.data.source.local;

import com.fossil.cnq;
import com.fossil.cox;
import com.portfolio.platform.data.model.LandingPage;
import com.portfolio.platform.data.source.LandingPageDataSource;
import com.portfolio.platform.data.source.LandingPageDataSource.GetListLandingPageCallback;
import java.util.List;

public class LandingPageLocalDataSource implements LandingPageDataSource {
    public void addOrUpdateLandingPage(List<LandingPage> list) {
        cox aci = cnq.acd().aci();
        aci.aeD();
        for (LandingPage a : list) {
            aci.a(a);
        }
    }

    public List<LandingPage> getAllLandingPage(GetListLandingPageCallback getListLandingPageCallback) {
        return cnq.acd().aci().aeC();
    }

    public void refreshLandingPage() {
    }

    public void preloadLandingPage() {
    }
}
