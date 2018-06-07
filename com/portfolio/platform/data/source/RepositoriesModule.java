package com.portfolio.platform.data.source;

import android.content.Context;
import com.fossil.cnq;
import com.fossil.cnr;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.portfolio.platform.data.source.local.ActivitiesLocalDataSource;
import com.portfolio.platform.data.source.local.AlarmsLocalDataSource;
import com.portfolio.platform.data.source.local.AlarmsSettingLocalDataSource;
import com.portfolio.platform.data.source.local.SleepSessionsLocalDataSource;
import com.portfolio.platform.data.source.local.SleepSummariesLocalDataSource;
import com.portfolio.platform.data.source.local.SummariesLocalDataSource;
import com.portfolio.platform.data.source.remote.ActivitiesRemoteDataSource;
import com.portfolio.platform.data.source.remote.AlarmsRemoteDataSource;
import com.portfolio.platform.data.source.remote.AlarmsSettingRemoteDataSource;
import com.portfolio.platform.data.source.remote.SleepSessionsRemoteDataSource;
import com.portfolio.platform.data.source.remote.SleepSummariesRemoteDataSource;
import com.portfolio.platform.data.source.remote.SummariesRemoteDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;

public class RepositoriesModule {
    @Local
    ActivitiesDataSource provideActivitiesLocalDataSource(cnq com_fossil_cnq) {
        return new ActivitiesLocalDataSource(com_fossil_cnq);
    }

    @Remote
    ActivitiesDataSource provideActivitiesRemoteDataSource(Context context, MFNetwork mFNetwork) {
        return new ActivitiesRemoteDataSource(context, mFNetwork);
    }

    @Local
    SummariesDataSource provideSummariesLocalDataSource(cnq com_fossil_cnq) {
        return new SummariesLocalDataSource(com_fossil_cnq);
    }

    @Remote
    SummariesDataSource provideSummariesRemoteDataSource(Context context, MFNetwork mFNetwork) {
        return new SummariesRemoteDataSource(context, mFNetwork);
    }

    @Local
    SleepSessionsDataSource provideSleepSessionsLocalDataSource(cnq com_fossil_cnq) {
        return new SleepSessionsLocalDataSource(com_fossil_cnq);
    }

    @Remote
    SleepSessionsDataSource provideSleepSessionsRemoteDataSource(Context context, MFNetwork mFNetwork) {
        return new SleepSessionsRemoteDataSource(context, mFNetwork);
    }

    @Local
    SleepSummariesDataSource provideSleepSummariesLocalDataSource(cnq com_fossil_cnq) {
        return new SleepSummariesLocalDataSource(com_fossil_cnq);
    }

    @Remote
    SleepSummariesDataSource provideSleepSummariesRemoteDataSource(Context context, MFNetwork mFNetwork) {
        return new SleepSummariesRemoteDataSource(context, mFNetwork);
    }

    @Remote
    AlarmsSettingDataSource provideAlarmsSettingRemoteDataSource(Context context) {
        return new AlarmsSettingRemoteDataSource(context);
    }

    @Local
    AlarmsSettingDataSource provideAlarmsSettingLocalDataSource(Context context, cnr com_fossil_cnr) {
        return new AlarmsSettingLocalDataSource(context, com_fossil_cnr);
    }

    @Remote
    AlarmsDataSource provideAlarmsRemoteDataSource() {
        return new AlarmsRemoteDataSource();
    }

    @Local
    AlarmsDataSource provideAlarmsLocalDataSource() {
        return new AlarmsLocalDataSource();
    }
}
