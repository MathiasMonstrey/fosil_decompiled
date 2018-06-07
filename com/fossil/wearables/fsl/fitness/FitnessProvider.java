package com.fossil.wearables.fsl.fitness;

import android.util.Pair;
import com.fossil.wearables.fsl.BaseProvider;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface FitnessProvider extends BaseProvider {
    void addDownloadedSampleRaw(SampleRaw sampleRaw);

    void addSample(SampleRaw sampleRaw);

    List<DailyGoal> getAllDailyGoals();

    List<SampleDay> getAllSampleDays();

    DailyGoal getDailyGoal(int i, int i2, int i3);

    DailyGoal getDailyGoal(Calendar calendar);

    List<DailyGoal> getDailyGoalInRange(Date date, Date date2);

    Date getEndDateOfSampleDay();

    Date getEndDateOfSampleRaw();

    int getLastDailyGoal();

    int getLastDailyGoalFromDate(Date date);

    SampleRaw getLastSampleRaw();

    List<SampleRaw> getPendingSampleRaws();

    List<SampleRaw> getRawSamples(Date date, Date date2);

    SampleDay getSampleDayByDate(int i, int i2, int i3);

    List<SampleDay> getSampleDays(Calendar calendar, Calendar calendar2);

    List<SampleRaw> getSampleRawsByIds(List<String> list);

    SampleDay getSamplesForDay(int i, int i2, int i3);

    SampleDay getSamplesForDay(Calendar calendar);

    Date getStartDateOfSampleDay();

    Date getStartDateOfSampleRaw();

    Pair<Integer, Integer> getTodayStepCountAndGoal();

    int getTodayStepGoal();

    void saveSampleDay(SampleDay sampleDay);

    void saveSampleDays(List<SampleDay> list);

    DailyGoal updateDailyStepGoal(int i, int i2, int i3, int i4);

    DailyGoal updateDailyStepGoal(int i, Calendar calendar);

    void updateSampleRawPinType(String str, int i);
}
