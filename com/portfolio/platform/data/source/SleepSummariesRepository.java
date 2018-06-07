package com.portfolio.platform.data.source;

import android.os.Bundle;
import com.fossil.bbm;
import com.fossil.ciw;
import com.fossil.cmq;
import com.fossil.wearables.fsl.sleep.MFSleepDay;
import com.google.android.gms.gcm.OneoffTask$a;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.source.SleepSummariesDataSource.GetSleepSummaryCallback;
import com.portfolio.platform.data.source.SleepSummariesDataSource.LoadSleepSummariesCallback;
import com.portfolio.platform.data.source.SleepSummariesDataSource.UpdateSleepGoalCallback;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import com.portfolio.platform.manager.network.BestTimeService;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;

public class SleepSummariesRepository extends SleepSummariesDataSource {
    private final String TAG = SleepSummariesRepository.class.getSimpleName();
    private final ciw mAppExecutors;
    private final bbm mGcmNetworkManager;
    private List<SleepSummariesRepositoryObserver> mObservers = new ArrayList();
    private final SleepSummariesDataSource mSleepSummariesLocalDataSource;
    private final SleepSummariesDataSource mSleepSummariesRemoteDataSource;

    class C48361 implements Runnable {
        C48361() {
        }

        public void run() {
            for (SleepSummariesRepositoryObserver onSleepSummariesChanged : SleepSummariesRepository.this.mObservers) {
                onSleepSummariesChanged.onSleepSummariesChanged();
            }
        }
    }

    public interface SleepSummariesRepositoryObserver {
        void onSleepSummariesChanged();
    }

    SleepSummariesRepository(@Remote SleepSummariesDataSource sleepSummariesDataSource, @Local SleepSummariesDataSource sleepSummariesDataSource2, bbm com_fossil_bbm, ciw com_fossil_ciw) {
        this.mSleepSummariesRemoteDataSource = sleepSummariesDataSource;
        this.mSleepSummariesLocalDataSource = sleepSummariesDataSource2;
        this.mGcmNetworkManager = com_fossil_bbm;
        this.mAppExecutors = com_fossil_ciw;
    }

    public void addContentObserver(SleepSummariesRepositoryObserver sleepSummariesRepositoryObserver) {
        MFLogger.d(this.TAG, "addSavedPresetObserver: observer = " + sleepSummariesRepositoryObserver);
        if (!this.mObservers.contains(sleepSummariesRepositoryObserver)) {
            this.mObservers.add(sleepSummariesRepositoryObserver);
        }
    }

    public void removeContentObserver(SleepSummariesRepositoryObserver sleepSummariesRepositoryObserver) {
        MFLogger.d(this.TAG, "removeSavedPresetObserver: observer = " + sleepSummariesRepositoryObserver);
        if (this.mObservers.contains(sleepSummariesRepositoryObserver)) {
            this.mObservers.remove(sleepSummariesRepositoryObserver);
        }
    }

    private void notifyContentObserver() {
        MFLogger.d(this.TAG, "notifyContentObserver");
        this.mAppExecutors.YS().execute(new C48361());
    }

    public void refresh() {
        notifyContentObserver();
    }

    public MFSleepDay getSleepSummary(Date date) {
        MFLogger.d(this.TAG, "getSummary: calendar = " + date);
        MFSleepDay sleepSummary = this.mSleepSummariesLocalDataSource.getSleepSummary(date);
        if (sleepSummary == null) {
            getSleepSummary(date, null);
        }
        return sleepSummary;
    }

    public int getLastSleepGoal(Date date) {
        return this.mSleepSummariesLocalDataSource.getLastSleepGoal(date);
    }

    public void updateLastSleepGoal(final int i, final UpdateSleepGoalCallback updateSleepGoalCallback) {
        this.mSleepSummariesRemoteDataSource.updateLastSleepGoal(i, new UpdateSleepGoalCallback() {
            public void onUpdateSleepGoalFinish(MFResponse mFResponse, boolean z) {
                if (z) {
                    SleepSummariesRepository.this.mSleepSummariesLocalDataSource.updateLastSleepGoal(i, null);
                }
                if (updateSleepGoalCallback != null) {
                    updateSleepGoalCallback.onUpdateSleepGoalFinish(mFResponse, z);
                }
            }
        });
    }

    public void getSleepSummary(final Date date, final GetSleepSummaryCallback getSleepSummaryCallback) {
        MFSleepDay sleepSummary = this.mSleepSummariesLocalDataSource.getSleepSummary(date);
        if (sleepSummary == null) {
            this.mSleepSummariesRemoteDataSource.getSleepSummary(date, new GetSleepSummaryCallback() {
                public void onSleepSummaryLoaded(final MFSleepDay mFSleepDay) {
                    SleepSummariesRepository.this.mGcmNetworkManager.a("SLEEP_SUMMARY-" + date.getTime(), BestTimeService.class);
                    SleepSummariesRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                        public void run() {
                            SleepSummariesRepository.this.mSleepSummariesLocalDataSource.insert(mFSleepDay);
                            SleepSummariesRepository.this.notifyContentObserver();
                            if (getSleepSummaryCallback != null) {
                                getSleepSummaryCallback.onSleepSummaryLoaded(mFSleepDay);
                            }
                        }
                    });
                }

                public void onDataNotAvailable() {
                }
            });
        } else if (getSleepSummaryCallback != null) {
            getSleepSummaryCallback.onSleepSummaryLoaded(sleepSummary);
        }
    }

    public List<MFSleepDay> loadSleepSummaries(Date date, Date date2) {
        MFLogger.d(this.TAG, "loadSleepSummaries: startDate = " + date + ", endDate = " + date2);
        return this.mSleepSummariesLocalDataSource.loadSleepSummaries(date, date2);
    }

    public void loadSleepSummaries(final Date date, final Date date2, LoadSleepSummariesCallback loadSleepSummariesCallback) {
        this.mSleepSummariesRemoteDataSource.loadSleepSummaries(date, date2, new LoadSleepSummariesCallback() {
            public void onSleepSummariesLoaded(final List<MFSleepDay> list) {
                SleepSummariesRepository.this.mGcmNetworkManager.a("SLEEP_SUMMARIES-" + date.getTime(), BestTimeService.class);
                SleepSummariesRepository.this.mAppExecutors.YQ().execute(new Runnable() {

                    class C48411 implements GetSleepSummaryCallback {
                        C48411() {
                        }

                        public void onSleepSummaryLoaded(final MFSleepDay mFSleepDay) {
                            SleepSummariesRepository.this.mGcmNetworkManager.a("SLEEP_SUMMARY-" + date.getTime(), BestTimeService.class);
                            SleepSummariesRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                                public void run() {
                                    SleepSummariesRepository.this.mSleepSummariesLocalDataSource.insert(mFSleepDay);
                                    C48421.this.handleSummaries(mFSleepDay);
                                }
                            });
                        }

                        public void onDataNotAvailable() {
                        }
                    }

                    public void run() {
                        MFSleepDay sleepSummary = SleepSummariesRepository.this.mSleepSummariesLocalDataSource.getSleepSummary(date);
                        if (sleepSummary == null) {
                            SleepSummariesRepository.this.mSleepSummariesRemoteDataSource.getSleepSummary(date, new C48411());
                        } else {
                            handleSummaries(sleepSummary);
                        }
                    }

                    private void handleSummaries(MFSleepDay mFSleepDay) {
                        Date date;
                        ParseException parseException;
                        Date date2 = date;
                        if (list.isEmpty()) {
                            date = date2;
                        } else {
                            Collections.reverse(list);
                            try {
                                date2 = cmq.fY(((MFSleepDay) list.get(0)).getDate());
                                if (mFSleepDay != null && cmq.d(date, date2) > 1) {
                                    C48434.this.fillSummary(mFSleepDay, date, date2);
                                }
                                for (MFSleepDay mFSleepDay2 : list) {
                                    SleepSummariesRepository.this.mSleepSummariesLocalDataSource.insert(mFSleepDay2);
                                    try {
                                        Date fY = cmq.fY(mFSleepDay2.getDate());
                                        if (cmq.d(date2, fY) > 1) {
                                            C48434.this.fillSummary(mFSleepDay2, date2, fY);
                                        }
                                        date2 = fY;
                                        mFSleepDay = mFSleepDay2;
                                    } catch (ParseException e) {
                                        mFSleepDay = mFSleepDay2;
                                        date = date2;
                                        parseException = e;
                                    }
                                }
                                date = date2;
                            } catch (ParseException e2) {
                                ParseException parseException2 = e2;
                                date = date2;
                                parseException = parseException2;
                                parseException.printStackTrace();
                                if (cmq.e(new Date(), date2)) {
                                    date2 = date2;
                                } else {
                                    date2 = new Date();
                                }
                                C48434.this.fillSummary(mFSleepDay, date, date2);
                                C48434.this.dummySummary(mFSleepDay, date2);
                                SleepSummariesRepository.this.notifyContentObserver();
                            }
                        }
                        if (cmq.e(new Date(), date2)) {
                            date2 = date2;
                        } else {
                            date2 = new Date();
                        }
                        if (!(mFSleepDay == null || cmq.a(date, date2))) {
                            C48434.this.fillSummary(mFSleepDay, date, date2);
                            C48434.this.dummySummary(mFSleepDay, date2);
                        }
                        SleepSummariesRepository.this.notifyContentObserver();
                    }
                });
            }

            public void onDataNotAvailable() {
            }

            private void fillSummary(MFSleepDay mFSleepDay, Date date, Date date2) {
                MFLogger.d(SleepSummariesRepository.this.TAG, "fillSummary: start = " + date + ", end = " + date2);
                for (Date h = cmq.h(date); !cmq.a(h, date2); h = cmq.h(h)) {
                    dummySummary(mFSleepDay, h);
                }
            }

            private void dummySummary(MFSleepDay mFSleepDay, Date date) {
                if (mFSleepDay.getGoalMinutes() != 0) {
                    Calendar.getInstance().setTime(date);
                    SleepSummariesRepository.this.mSleepSummariesLocalDataSource.insert(new MFSleepDay(cmq.a(date), mFSleepDay.getTimezoneOffset(), mFSleepDay.getGoalMinutes(), 0, "{\"light\":0,\"awake\":0,\"deep\":0}", new DateTime(System.currentTimeMillis())));
                }
            }
        });
    }

    public void insert(MFSleepDay mFSleepDay) {
    }

    public void cleanUp() {
        this.mSleepSummariesLocalDataSource.cleanUp();
    }

    public void fetch(Date date) {
        MFLogger.d(this.TAG, "fetch: date = " + date);
        Bundle bundle = new Bundle();
        bundle.putString("taskId", "SLEEP_SUMMARY");
        bundle.putSerializable("START_DATE", date);
        this.mGcmNetworkManager.a(new OneoffTask$a().m14246L(BestTimeService.class).dC("SLEEP_SUMMARY-" + date.getTime()).hJ(0).m14247c(0, 30).m14248p(bundle).Mx());
    }

    public void fetch(Date date, Date date2) {
        MFLogger.d(this.TAG, "fetch: startDate = " + date + ", endDate = " + date2);
        Bundle bundle = new Bundle();
        bundle.putString("taskId", "SLEEP_SUMMARIES");
        bundle.putSerializable("START_DATE", date);
        bundle.putSerializable("END_DATE", date2);
        this.mGcmNetworkManager.a(new OneoffTask$a().m14246L(BestTimeService.class).dC("SLEEP_SUMMARIES-" + date.getTime()).hJ(0).m14247c(0, 30).m14248p(bundle).Mx());
    }
}
