package com.portfolio.platform.data.source;

import com.portfolio.platform.data.model.Widget;
import java.util.List;

public interface WidgetDataSource {

    public interface GetListWidgetCallback {
        void onFailed(int i);

        void onSuccess(List<Widget> list);
    }

    void addOrUpdateWidgetList(List<Widget> list);

    List<Widget> getAllWidget(GetListWidgetCallback getListWidgetCallback);

    void preloadWidget();

    void refreshWidget();
}
