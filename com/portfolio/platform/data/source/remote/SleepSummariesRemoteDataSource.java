package com.portfolio.platform.data.source.remote;

import android.content.Context;
import com.fossil.cmq;
import com.fossil.csj;
import com.fossil.csk;
import com.fossil.cso;
import com.fossil.wearables.fsl.sleep.MFSleepDay;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.SleepSummariesDataSource;
import com.portfolio.platform.data.source.SleepSummariesDataSource.GetSleepSummaryCallback;
import com.portfolio.platform.data.source.SleepSummariesDataSource.LoadSleepSummariesCallback;
import com.portfolio.platform.data.source.SleepSummariesDataSource.UpdateSleepGoalCallback;
import com.portfolio.platform.response.sleep.MFGetSleepDayListResponse;
import com.portfolio.platform.response.sleep.MFGetSleepDayResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SleepSummariesRemoteDataSource extends SleepSummariesDataSource {
    private static final String TAG = SleepSummariesRemoteDataSource.class.getSimpleName();
    private final Context mContext;
    private final MFNetwork mMfNetwork;

    public SleepSummariesRemoteDataSource(Context context, MFNetwork mFNetwork) {
        this.mContext = context;
        this.mMfNetwork = mFNetwork;
    }

    protected void getSleepSummary(Date date, final GetSleepSummaryCallback getSleepSummaryCallback) {
        MFLogger.d(TAG, "getSleepSummary: date = " + date);
        this.mMfNetwork.execute(new csk(this.mContext, cmq.a(date)), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFGetSleepDayResponse mFGetSleepDayResponse = (MFGetSleepDayResponse) mFResponse;
                MFSleepDay mFSleepDay = null;
                if (mFGetSleepDayResponse != null) {
                    mFSleepDay = mFGetSleepDayResponse.getSleep();
                }
                if (mFSleepDay != null) {
                    getSleepSummaryCallback.onSleepSummaryLoaded(mFSleepDay);
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                getSleepSummaryCallback.onDataNotAvailable();
            }
        });
    }

    protected void loadSleepSummaries(Date date, Date date2, final LoadSleepSummariesCallback loadSleepSummariesCallback) {
        MFLogger.d(TAG, "loadSleepSummaries: startDate = " + date + ", endDate = " + date2);
        this.mMfNetwork.execute(new csj(this.mContext, cmq.a(date), cmq.a(date2)), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFGetSleepDayListResponse mFGetSleepDayListResponse = (MFGetSleepDayListResponse) mFResponse;
                List arrayList = new ArrayList();
                if (mFGetSleepDayListResponse.getSleeps() != null) {
                    arrayList.addAll(mFGetSleepDayListResponse.getSleeps());
                }
                loadSleepSummariesCallback.onSleepSummariesLoaded(arrayList);
            }

            public void onFail(int i, MFResponse mFResponse) {
                loadSleepSummariesCallback.onDataNotAvailable();
            }
        });
    }

    public void insert(MFSleepDay mFSleepDay) {
    }

    public void updateLastSleepGoal(int i, final UpdateSleepGoalCallback updateSleepGoalCallback) {
        MFLogger.d(TAG, "updateLastSleepGoal: sleepGoal = " + i);
        this.mMfNetwork.execute(new cso(PortfolioApp.ZQ(), i), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(SleepSummariesRemoteDataSource.TAG, "updateLastSleepGoal onSuccess");
                if (updateSleepGoalCallback != null) {
                    updateSleepGoalCallback.onUpdateSleepGoalFinish(mFResponse, true);
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(SleepSummariesRemoteDataSource.TAG, "updateLastSleepGoal onFail");
                if (updateSleepGoalCallback != null) {
                    updateSleepGoalCallback.onUpdateSleepGoalFinish(mFResponse, false);
                }
            }
        });
    }
}
