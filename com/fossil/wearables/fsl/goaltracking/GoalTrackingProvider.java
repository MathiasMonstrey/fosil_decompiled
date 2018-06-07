package com.fossil.wearables.fsl.goaltracking;

import android.util.SparseArray;
import com.fossil.wearables.fsl.BaseProvider;
import java.util.List;

public interface GoalTrackingProvider extends BaseProvider {
    void deleteAllGoalPhases(long j);

    void deleteGoalTrackingSummary(long j);

    void disposeGoalTrackingFromDB(long j);

    void disposeGoalTrackingFromDB(String str);

    GoalTracking getActiveGoalTracking();

    List<GoalTracking> getAllGoalTrackings();

    GoalPhase getGoalPhase(long j);

    List<GoalPhase> getGoalPhases(long j);

    List<GoalPhase> getGoalPhases(long j, long j2);

    GoalTracking getGoalTracking(long j);

    GoalTracking getGoalTracking(String str);

    GoalTracking getGoalTracking(String str, Frequency frequency, int i);

    List<GoalTracking> getGoalTracking(GoalStatus goalStatus);

    GoalTracking getGoalTrackingByServerId(String str);

    SparseArray<List<GoalTrackingEvent>> getGoalTrackingEvent(int i, int i2, long j);

    SparseArray<List<GoalTrackingEvent>> getGoalTrackingEvent(long j);

    List<GoalTrackingEvent> getGoalTrackingEventByTrackingTimes(List<Long> list);

    List<Integer> getGoalTrackingEventDates(int i, int i2, long j);

    List<Integer> getGoalTrackingEventDates(long j);

    List<GoalTrackingSummary> getGoalTrackingSummaries(long j, long j2);

    List<GoalTrackingSummary> getGoalTrackingSummariesPaging(long j, long j2);

    GoalTrackingSummary getGoalTrackingSummary(long j);

    GoalTracking getGoalTrackingsByIdIncludeDeleted(long j);

    GoalTracking getGoalTrackingsByServerIdIncludeDeleted(String str);

    GoalTracking getLatestEndedGoalTracking();

    GoalTracking getOldedGoalTracking();

    List<GoalTracking> getPendingGoalTracking();

    List<GoalTrackingEvent> getPendingGoalTrackingEvents();

    void saveGoalPhase(GoalPhase goalPhase);

    void saveGoalTracking(GoalTracking goalTracking);

    void saveGoalTrackingEvent(GoalTrackingEvent goalTrackingEvent);

    void saveGoalTrackingSummary(GoalTrackingSummary goalTrackingSummary);

    void setGoalTrackingStatus(String str, GoalStatus goalStatus);

    void updateGoalTrackingEvent(GoalTrackingEvent goalTrackingEvent);
}
