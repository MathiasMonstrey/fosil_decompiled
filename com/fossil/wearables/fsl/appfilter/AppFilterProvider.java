package com.fossil.wearables.fsl.appfilter;

import com.fossil.wearables.fsl.BaseProvider;
import java.util.List;

public interface AppFilterProvider extends BaseProvider {
    void clearAppFilterTable();

    List<AppFilter> getAllAppFilterVibration(int i);

    List<AppFilter> getAllAppFilters();

    List<AppFilter> getAllAppFilters(int i);

    List<AppFilter> getAllAppFiltersWithHour(int i, int i2);

    AppFilter getAppFilter(int i);

    AppFilter getAppFilterMatchingType(String str);

    AppFilter getAppFilterMatchingType(String str, int i);

    void removeAllAppFilters();

    void removeAppFilter(AppFilter appFilter);

    void saveAppFilter(AppFilter appFilter);
}
