package com.portfolio.platform.data.source.local;

import com.fossil.cnq;
import com.fossil.com;
import com.portfolio.platform.data.model.Explore;
import com.portfolio.platform.data.source.ExploreDataSource;
import com.portfolio.platform.data.source.ExploreDataSource.GetExploreListCallback;
import java.util.List;

public class ExploreLocalDataSource implements ExploreDataSource {
    public void addOrUpdateExploreList(List<Explore> list) {
        com ach = cnq.acd().ach();
        ach.aeq();
        for (Explore b : list) {
            ach.b(b);
        }
    }

    public List<Explore> getAllExplore(GetExploreListCallback getExploreListCallback) {
        return cnq.acd().ach().aep();
    }

    public List<Explore> getExploreByType(String str) {
        return null;
    }

    public void refreshExplore() {
    }
}
