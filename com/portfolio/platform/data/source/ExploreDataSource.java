package com.portfolio.platform.data.source;

import com.portfolio.platform.data.model.Explore;
import java.util.List;

public interface ExploreDataSource {

    public interface GetExploreListCallback {
        void onFailed(int i);

        void onSuccess(List<Explore> list);
    }

    void addOrUpdateExploreList(List<Explore> list);

    List<Explore> getAllExplore(GetExploreListCallback getExploreListCallback);

    List<Explore> getExploreByType(String str);

    void refreshExplore();
}
