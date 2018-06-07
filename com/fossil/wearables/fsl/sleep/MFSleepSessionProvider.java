package com.fossil.wearables.fsl.sleep;

import com.fossil.wearables.fsl.BaseProvider;
import java.util.List;

public interface MFSleepSessionProvider extends BaseProvider {
    boolean addSleepDay(MFSleepDay mFSleepDay);

    boolean addSleepSession(MFSleepSession mFSleepSession);

    boolean deleteSleepSession(long j);

    boolean deleteSleepSession(MFSleepSession mFSleepSession);

    boolean editSleepSession(MFSleepSession mFSleepSession);

    MFSleepGoal getDailySleepGoal(String str);

    int getLastSleepGoal();

    List<MFSleepSession> getPendingSleepSessions();

    MFSleepDay getSleepDay(String str);

    List<MFSleepDay> getSleepDays(long j, long j2);

    MFSleepSession getSleepSession(long j);

    int getSleepSessionNumberFromSleepDay(long j);

    List<MFSleepSession> getSleepSessions(long j);

    List<MFSleepSession> getSleepSessions(long j, long j2);

    List<MFSleepSession> getSleepSessions(String str);

    int getTodaySleepGoal();

    MFSleepGoal updateDailySleepGoal(MFSleepGoal mFSleepGoal);

    void updateSleepDay(MFSleepDay mFSleepDay);

    void updateSleepSessionPinType(MFSleepSession mFSleepSession, int i);
}
