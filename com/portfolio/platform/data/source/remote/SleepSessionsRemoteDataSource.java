package com.portfolio.platform.data.source.remote;

import android.content.Context;
import com.fossil.cmq;
import com.fossil.csl;
import com.fossil.csn;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.source.SleepSessionsDataSource;
import com.portfolio.platform.data.source.SleepSessionsDataSource.LoadSleepSessionsCallback;
import com.portfolio.platform.data.source.SleepSessionsDataSource.SaveSleepSessionCallback;
import com.portfolio.platform.response.sleep.MFGetSleepSessionsListResponse;
import java.util.Date;
import java.util.List;

public class SleepSessionsRemoteDataSource extends SleepSessionsDataSource {
    private static final String TAG = SleepSessionsRemoteDataSource.class.getSimpleName();
    private final Context mContext;
    private final MFNetwork mMfNetwork;

    public SleepSessionsRemoteDataSource(Context context, MFNetwork mFNetwork) {
        this.mContext = context;
        this.mMfNetwork = mFNetwork;
    }

    public void getSleepSessionList(Date date, Date date2, final LoadSleepSessionsCallback loadSleepSessionsCallback) {
        MFLogger.d(TAG, "getSleepSessionList: start = " + date + ", end = " + date2);
        this.mMfNetwork.execute(new csl(this.mContext, cmq.a(date), cmq.a(date2), 0, Integer.MAX_VALUE), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(SleepSessionsRemoteDataSource.TAG, "getSleepSessionList onSuccess");
                List sleepSession = ((MFGetSleepSessionsListResponse) mFResponse).getSleepSession();
                if (sleepSession == null || sleepSession.isEmpty()) {
                    MFLogger.d(SleepSessionsRemoteDataSource.TAG, "getSleepSessionList onSuccess onDataNotAvailable");
                    loadSleepSessionsCallback.onDataNotAvailable();
                    return;
                }
                MFLogger.d(SleepSessionsRemoteDataSource.TAG, "getSleepSessionList onSuccess onSleepSessionsLoaded: sleepSessionList = " + sleepSession);
                loadSleepSessionsCallback.onSleepSessionsLoaded(sleepSession);
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(SleepSessionsRemoteDataSource.TAG, "getSleepSessionList onSuccess onDataNotAvailable");
                loadSleepSessionsCallback.onDataNotAvailable();
            }
        });
    }

    public void insertSleepSession(final MFSleepSession mFSleepSession, final SaveSleepSessionCallback saveSleepSessionCallback) {
        this.mMfNetwork.execute(new csn(this.mContext, mFSleepSession), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(SleepSessionsRemoteDataSource.TAG, "insertSleepSession onSuccess, sleepSession= " + mFSleepSession.toString());
                if (saveSleepSessionCallback != null) {
                    saveSleepSessionCallback.saveSuccess(mFSleepSession);
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(SleepSessionsRemoteDataSource.TAG, "insertSleepSession onFailed, error= " + i);
                if (saveSleepSessionCallback != null) {
                    saveSleepSessionCallback.saveFailed(i, mFSleepSession);
                }
            }
        });
    }
}
