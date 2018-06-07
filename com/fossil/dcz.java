package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.cmk.C2196a;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.portfolio.platform.data.model.InstalledApp;
import com.portfolio.platform.ui.notifications.domain.model.AppWrapper;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class dcz extends ckb<C2132b, C2679a, C2131a> {
    private final String TAG = dcz.class.getSimpleName();
    private final Context mContext;

    public static final class C2679a implements C2133c {
        private final List<AppWrapper> cQF;

        public C2679a(List<AppWrapper> list) {
            this.cQF = (List) cco.m5996s(list, "apps cannot be null!");
        }

        public List<AppWrapper> amy() {
            return this.cQF;
        }
    }

    dcz(Context context) {
        this.mContext = (Context) cco.ce(context);
    }

    protected void mo2022b(C2132b c2132b) {
        Log.d(this.TAG, "executeUseCase GetApps");
        List<AppFilter> allAppFilters = cnq.acd().acm().getAllAppFilters(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
        List linkedList = new LinkedList();
        for (C2196a c2196a : cmk.bt(this.mContext)) {
            if (TextUtils.isEmpty(c2196a.cxF) || !c2196a.cxF.equalsIgnoreCase(this.mContext.getPackageName())) {
                InstalledApp installedApp = new InstalledApp(c2196a.cxF, c2196a.cxE, Boolean.valueOf(false));
                for (AppFilter appFilter : allAppFilters) {
                    if (appFilter.getType().equals(installedApp.getIdentifier())) {
                        installedApp.setSelected(true);
                        installedApp.setDbRowId(appFilter.getDbRowId());
                        installedApp.setCurrentHandGroup(appFilter.getHour());
                        break;
                    }
                }
                AppWrapper appWrapper = new AppWrapper();
                appWrapper.installedApp = installedApp;
                appWrapper.uri = c2196a.uri;
                appWrapper.setCurrentHandGroup(installedApp.getCurrentHandGroup());
                Log.d(this.TAG, "--------------------");
                Log.d(this.TAG, "Title = " + installedApp.getTitle());
                Log.d(this.TAG, "uri = " + c2196a.uri);
                Log.d(this.TAG, "--------------------");
                linkedList.add(appWrapper);
            }
        }
        Collections.sort(linkedList);
        abr().onSuccess(new C2679a(linkedList));
    }
}
