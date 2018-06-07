package com.portfolio.platform.data.source.local;

import com.fossil.cnq;
import com.fossil.cpl;
import com.portfolio.platform.data.model.Widget;
import com.portfolio.platform.data.source.WidgetDataSource;
import com.portfolio.platform.data.source.WidgetDataSource.GetListWidgetCallback;
import java.util.List;

public class WidgetLocalDataSource implements WidgetDataSource {
    public void addOrUpdateWidgetList(List<Widget> list) {
        cpl acg = cnq.acd().acg();
        acg.aeQ();
        for (Widget b : list) {
            acg.b(b);
        }
    }

    public List<Widget> getAllWidget(GetListWidgetCallback getListWidgetCallback) {
        return cnq.acd().acg().aeP();
    }

    public void refreshWidget() {
    }

    public void preloadWidget() {
    }
}
