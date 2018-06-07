package com.portfolio.platform.data.source.remote;

import android.content.Context;
import com.fossil.cmq;
import com.fossil.cmt;
import com.fossil.crp;
import com.fossil.crq;
import com.fossil.crs;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.FitnessDayData;
import com.portfolio.platform.data.source.SummariesDataSource;
import com.portfolio.platform.data.source.SummariesDataSource$GetSummaryCallback;
import com.portfolio.platform.data.source.SummariesDataSource$LoadSummariesCallback;
import com.portfolio.platform.data.source.SummariesDataSource$UpdateStepGoalCallback;
import com.portfolio.platform.response.fitness.MFSampleDayByRangeResponse;
import com.portfolio.platform.response.fitness.MFSampleDayResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SummariesRemoteDataSource extends SummariesDataSource {
    private static final String TAG = SummariesRemoteDataSource.class.getSimpleName();
    private final Context mContext;
    private final MFNetwork mMfNetwork;

    public SummariesRemoteDataSource(Context context, MFNetwork mFNetwork) {
        this.mContext = context;
        this.mMfNetwork = mFNetwork;
    }

    protected void getSummary(Date date, final SummariesDataSource$GetSummaryCallback summariesDataSource$GetSummaryCallback) {
        MFLogger.d(TAG, "getSummary: date = " + date);
        this.mMfNetwork.execute(new crp(this.mContext, cmq.a(date)), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFSampleDayResponse mFSampleDayResponse = (MFSampleDayResponse) mFResponse;
                SampleDay sampleDay = null;
                if (mFSampleDayResponse != null) {
                    sampleDay = cmt.abK().b(mFSampleDayResponse.getSampleDayData());
                }
                if (sampleDay != null) {
                    summariesDataSource$GetSummaryCallback.onSummaryLoaded(sampleDay);
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                summariesDataSource$GetSummaryCallback.onDataNotAvailable();
            }
        });
    }

    protected void loadSummaries(Date date, Date date2, final SummariesDataSource$LoadSummariesCallback summariesDataSource$LoadSummariesCallback) {
        MFLogger.d(TAG, "loadSummaries: startDate = " + date + ", endDate = " + date2);
        this.mMfNetwork.execute(new crq(this.mContext, cmq.a(date), cmq.a(date2)), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFSampleDayByRangeResponse mFSampleDayByRangeResponse = (MFSampleDayByRangeResponse) mFResponse;
                List arrayList = new ArrayList();
                if (mFSampleDayByRangeResponse.getSampleDays() != null) {
                    for (FitnessDayData b : mFSampleDayByRangeResponse.getSampleDays()) {
                        arrayList.add(cmt.abK().b(b));
                    }
                }
                summariesDataSource$LoadSummariesCallback.onSummariesLoaded(arrayList);
            }

            public void onFail(int i, MFResponse mFResponse) {
                summariesDataSource$LoadSummariesCallback.onDataNotAvailable();
            }
        });
    }

    public void insert(SampleDay sampleDay) {
    }

    public void updateLastStepGoal(Date date, int i, final SummariesDataSource$UpdateStepGoalCallback summariesDataSource$UpdateStepGoalCallback) {
        MFLogger.d(TAG, "updateLastStepGoal: date = " + date + ", stepGoal = " + i);
        this.mMfNetwork.execute(new crs(PortfolioApp.ZQ(), i), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(SummariesRemoteDataSource.TAG, "updateLastStepGoal: onSuccess");
                if (summariesDataSource$UpdateStepGoalCallback != null) {
                    summariesDataSource$UpdateStepGoalCallback.onUpdateStepGoalFinish(mFResponse, true);
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(SummariesRemoteDataSource.TAG, "updateLastStepGoal: onFail");
                if (summariesDataSource$UpdateStepGoalCallback != null) {
                    summariesDataSource$UpdateStepGoalCallback.onUpdateStepGoalFinish(mFResponse, false);
                }
            }
        });
    }
}
