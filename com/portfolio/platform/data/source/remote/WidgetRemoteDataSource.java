package com.portfolio.platform.data.source.remote;

import com.fossil.cnq;
import com.fossil.cpw;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DataVersion;
import com.portfolio.platform.data.model.Widget;
import com.portfolio.platform.data.source.WidgetDataSource;
import com.portfolio.platform.data.source.WidgetDataSource.GetListWidgetCallback;
import com.portfolio.platform.response.MFGetListWidgetResponse;
import java.util.List;

public class WidgetRemoteDataSource implements WidgetDataSource {

    static final class ServerResultCallback implements MFServerResultCallback {
        private GetListWidgetCallback mGetListWidgetCallback;
        private int mWidgetType;

        public ServerResultCallback(int i) {
            this.mWidgetType = i;
        }

        public ServerResultCallback(GetListWidgetCallback getListWidgetCallback, int i) {
            this(i);
            this.mGetListWidgetCallback = getListWidgetCallback;
        }

        public void onSuccess(MFResponse mFResponse) {
            switch (this.mWidgetType) {
                case 7:
                    if (this.mGetListWidgetCallback != null) {
                        this.mGetListWidgetCallback.onSuccess(((MFGetListWidgetResponse) mFResponse).getWidgetList());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            switch (this.mWidgetType) {
                case 7:
                    if (this.mGetListWidgetCallback != null) {
                        this.mGetListWidgetCallback.onFailed(i);
                    }
                    cnq.acd().acf().addOrUpdateDataVersioning(new DataVersion("widgets", 0));
                    return;
                default:
                    return;
            }
        }
    }

    public void addOrUpdateWidgetList(List<Widget> list) {
    }

    public List<Widget> getAllWidget(GetListWidgetCallback getListWidgetCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cpw(PortfolioApp.ZQ()), new ServerResultCallback(getListWidgetCallback, 7));
        return null;
    }

    public void refreshWidget() {
    }

    public void preloadWidget() {
    }
}
