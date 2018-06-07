package com.portfolio.platform.data.source.remote;

import android.content.Context;
import com.fossil.cmq;
import com.fossil.crr;
import com.fossil.crt;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.source.ActivitiesDataSource;
import com.portfolio.platform.data.source.ActivitiesDataSource.LoadActivitiesCallback;
import com.portfolio.platform.data.source.ActivitiesDataSource.SaveSampleRawCallback;
import com.portfolio.platform.response.fitness.MFSampleRawByRangeResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivitiesRemoteDataSource extends ActivitiesDataSource {
    private static final String TAG = ActivitiesRemoteDataSource.class.getSimpleName();
    private final Context mContext;
    private final MFNetwork mMfNetwork;

    public ActivitiesRemoteDataSource(Context context, MFNetwork mFNetwork) {
        this.mContext = context;
        this.mMfNetwork = mFNetwork;
    }

    public void getActivityList(Date date, Date date2, final LoadActivitiesCallback loadActivitiesCallback) {
        MFLogger.d(TAG, "getActivityList: start = " + date + ", end = " + date2);
        this.mMfNetwork.execute(new crr(this.mContext, cmq.a(date), cmq.a(date2), 0, Integer.MAX_VALUE), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                List listSampleRaw = ((MFSampleRawByRangeResponse) mFResponse).getListSampleRaw();
                MFLogger.d(ActivitiesRemoteDataSource.TAG, "getActivityList onSuccess: activityList = " + (listSampleRaw != null ? listSampleRaw.size() : 0));
                if (listSampleRaw == null || listSampleRaw.isEmpty()) {
                    loadActivitiesCallback.onActivitiesLoaded(new ArrayList());
                } else {
                    loadActivitiesCallback.onActivitiesLoaded(listSampleRaw);
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(ActivitiesRemoteDataSource.TAG, "getActivityList onSuccess onDataNotAvailable");
                loadActivitiesCallback.onDataNotAvailable();
            }
        });
    }

    public void insertActivity(final SampleRaw sampleRaw, final SaveSampleRawCallback saveSampleRawCallback) {
        this.mMfNetwork.execute(new crt(this.mContext, sampleRaw), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(ActivitiesRemoteDataSource.TAG, "insertActivity onSuccess, activity= " + sampleRaw.toString());
                if (saveSampleRawCallback != null) {
                    saveSampleRawCallback.saveSuccess(sampleRaw);
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(ActivitiesRemoteDataSource.TAG, "insertActivity onFailed errorCode=" + i + ", activity=" + sampleRaw.toString());
                if (saveSampleRawCallback != null) {
                    saveSampleRawCallback.saveFailed(i, sampleRaw);
                }
            }
        });
    }
}
