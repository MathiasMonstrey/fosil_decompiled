package com.fossil;

import android.text.TextUtils;
import com.fossil.wearables.fsl.fitness.DailyGoal;
import com.fossil.wearables.fsl.fitness.FitnessMovementType;
import com.fossil.wearables.fsl.fitness.FitnessProvider;
import com.fossil.wearables.fsl.fitness.FitnessSourceType;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.fossil.wearables.fsl.sleep.SleepDistribution;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.buttonservice.model.WrapperMinuteData;
import com.misfit.frameworks.buttonservice.model.WrapperSleep;
import com.misfit.frameworks.buttonservice.utils.MetricAlgorithmUtil;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.FitnessDayData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.joda.time.DateTime;

public class cmt {
    private static final String TAG = cmt.class.getSimpleName();
    private static cmt cyt;
    cnr cmQ;

    class C22091 implements Comparator<WrapperMinuteData> {
        final /* synthetic */ cmt cyu;

        C22091(cmt com_fossil_cmt) {
            this.cyu = com_fossil_cmt;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7142a((WrapperMinuteData) obj, (WrapperMinuteData) obj2);
        }

        public int m7142a(WrapperMinuteData wrapperMinuteData, WrapperMinuteData wrapperMinuteData2) {
            if (wrapperMinuteData == null) {
                return -1;
            }
            if (wrapperMinuteData2 == null) {
                return 1;
            }
            return (int) (wrapperMinuteData.startTime - wrapperMinuteData2.startTime);
        }
    }

    private cmt() {
        PortfolioApp.ZQ().aam().mo1828a(this);
    }

    public static synchronized cmt abK() {
        cmt com_fossil_cmt;
        synchronized (cmt.class) {
            if (cyt == null) {
                cyt = new cmt();
            }
            com_fossil_cmt = cyt;
        }
        return com_fossil_cmt;
    }

    public static int aC(long j) {
        if (j < 70) {
            return 0;
        }
        if (j < 70 || j >= 140) {
            return 2;
        }
        return 1;
    }

    public List<SampleRaw> m7146a(List<WrapperMinuteData> list, String str) throws Exception {
        List<SampleRaw> arrayList = new ArrayList();
        UserProfile aad = PortfolioApp.ZQ().aad();
        List arrayList2 = new ArrayList();
        MFLogger.m12670d(TAG, "Inside " + TAG + ".minuteDataToSampleRaw - START - size=" + list.size());
        WrapperMinuteData wrapperMinuteData;
        SampleRaw sampleRaw;
        if (list.size() > 1) {
            Collections.sort(list, new C22091(this));
            MFLogger.m12670d(TAG, "Inside " + TAG + ".minuteDataToSampleRaw - after sort - size=" + list.size());
            wrapperMinuteData = (WrapperMinuteData) list.remove(0);
            int aC = aC(wrapperMinuteData.steps);
            Date aD = aD(wrapperMinuteData.startTime * 1000);
            sampleRaw = new SampleRaw(new Date(wrapperMinuteData.startTime * 1000), new Date((wrapperMinuteData.startTime + 60) * 1000), TimeZone.getDefault().getID(), str, FitnessSourceType.Device, FitnessMovementType.WALKING, (double) wrapperMinuteData.steps, 0.0d, 0.0d);
            MFLogger.m12670d(TAG, "Inside " + TAG + ".minuteDataToSampleRaw - Running " + sampleRaw);
            arrayList2.add(wrapperMinuteData);
            int i = aC;
            for (WrapperMinuteData wrapperMinuteData2 : list) {
                Date date;
                MFLogger.m12670d(TAG, "Inside " + TAG + ".minuteDataToSampleRaw- Running " + wrapperMinuteData2);
                Date aD2 = aD(wrapperMinuteData2.startTime * 1000);
                if (cmq.m7108a(aD, aD2)) {
                    Date aD3 = aD(sampleRaw.getStartTime().getTime());
                    if (aD3.getMinutes() < 30) {
                        aD3.setMinutes(0);
                        aD3.setSeconds(0);
                    } else {
                        aD3.setMinutes(30);
                        aD3.setSeconds(0);
                    }
                    long time = aD2.getTime() - aD3.getTime();
                    Object obj = aD2.getHours() == aD3.getHours() ? 1 : null;
                    if (time > 0) {
                        int aC2 = aC(wrapperMinuteData2.steps);
                        if (obj == null || time >= 1800000 || r6 != aC2) {
                            MFLogger.m12670d(TAG, "Inside " + TAG + ".minuteDataToSampleRaw - New sample hour - current=" + sampleRaw);
                            if (sampleRaw.getSteps() > 0.0d) {
                                m7144a(aad, sampleRaw, arrayList2);
                                arrayList.add(sampleRaw);
                            }
                            arrayList2.clear();
                            arrayList2.add(wrapperMinuteData2);
                            sampleRaw = new SampleRaw(new Date(wrapperMinuteData2.startTime * 1000), new Date((wrapperMinuteData2.startTime + 60) * 1000), TimeZone.getDefault().getID(), str, FitnessSourceType.Device, FitnessMovementType.WALKING, (double) wrapperMinuteData2.steps, 0.0d, 0.0d);
                        } else {
                            sampleRaw.setSteps(sampleRaw.getSteps() + ((double) wrapperMinuteData2.steps));
                            sampleRaw.setEndTime(new Date((wrapperMinuteData2.startTime + 60) * 1000));
                            arrayList2.add(wrapperMinuteData2);
                        }
                    }
                    date = aD;
                } else {
                    if (sampleRaw.getSteps() > 0.0d) {
                        m7144a(aad, sampleRaw, arrayList2);
                        arrayList.add(sampleRaw);
                    }
                    arrayList2.clear();
                    arrayList2.add(wrapperMinuteData2);
                    sampleRaw = new SampleRaw(new Date(wrapperMinuteData2.startTime * 1000), new Date((wrapperMinuteData2.startTime + 60) * 1000), TimeZone.getDefault().getID(), str, FitnessSourceType.Device, FitnessMovementType.WALKING, (double) wrapperMinuteData2.steps, 0.0d, 0.0d);
                    date = aD2;
                }
                aD = date;
                i = aC(wrapperMinuteData2.steps);
            }
            if (sampleRaw.getSteps() > 0.0d) {
                m7144a(aad, sampleRaw, arrayList2);
                arrayList.add(sampleRaw);
            }
            for (SampleRaw sampleRaw2 : arrayList) {
                MFLogger.m12670d(TAG, "Inside " + TAG + ".minuteDataToSampleRaw - END - activityData=[start=" + cmq.m7138p(sampleRaw2.getStartTime()) + ", end=" + cmq.m7138p(sampleRaw2.getEndTime()) + ", steps=" + sampleRaw2.getSteps() + ", distance=" + sampleRaw2.getDistance() + ", calories=" + sampleRaw2.getCalories() + "]");
            }
        } else if (list.size() == 1) {
            wrapperMinuteData2 = (WrapperMinuteData) list.get(0);
            sampleRaw = new SampleRaw(new Date(wrapperMinuteData2.startTime * 1000), new Date((wrapperMinuteData2.startTime + 60) * 1000), TimeZone.getDefault().getID(), str, FitnessSourceType.Device, FitnessMovementType.WALKING, (double) wrapperMinuteData2.steps, 0.0d, 0.0d);
            arrayList2.add(wrapperMinuteData2);
            m7144a(aad, sampleRaw, arrayList2);
            arrayList.add(sampleRaw);
        }
        return arrayList;
    }

    private void m7144a(UserProfile userProfile, SampleRaw sampleRaw, List<WrapperMinuteData> list) {
        float calculateCalories = MetricAlgorithmUtil.calculateCalories(userProfile, list);
        float calculateDistance = MetricAlgorithmUtil.calculateDistance(userProfile, list);
        MFLogger.m12670d(TAG, "calculateCaloriesAndDistance - totalMinuteData=" + list.size() + ", calories=" + calculateCalories + ", distance=" + calculateDistance);
        sampleRaw.setDistance((double) calculateDistance);
        sampleRaw.setCalories((double) calculateCalories);
    }

    public Date aD(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.setTimeZone(TimeZone.getDefault());
        return instance.getTime();
    }

    public List<SampleRaw> m7145a(Date date, boolean z) {
        if (cne.getStartOfDay(date).before(PortfolioApp.ZQ().aac())) {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".getAllRawInDateFromDatabase, this date -" + date + "- before user signing up date, return null.");
            return new ArrayList();
        }
        FitnessProvider acr = cnq.acd().acr();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar b = cmq.m7110b(instance);
        List<SampleRaw> rawSamples = acr.getRawSamples(b.getTime(), cmq.m7115c((Calendar) b.clone()).getTime());
        if (z && cmq.m7114c(date).booleanValue()) {
            long q = m7152q(date);
            long j = 0;
            long j2 = 0;
            for (SampleRaw sampleRaw : rawSamples) {
                long steps = (long) (((double) j2) + sampleRaw.getSteps());
                j = sampleRaw.getEndTime().getTime();
                j2 = steps;
            }
            MFLogger.m12670d(TAG, "Inside " + TAG + ".getAllRawInDateFromDatabase - steps=" + j2 + ", realTimeSteps=" + q);
            if (j2 < q) {
                try {
                    rawSamples.add(new SampleRaw(new Date(1 + j), new Date(j + 100), TimeZone.getDefault().getID(), "", FitnessSourceType.Device, FitnessMovementType.WALKING, (double) (q - j2), 0.0d, 0.0d));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return rawSamples;
    }

    public float m7150b(Date date, boolean z) {
        if (cne.getStartOfDay(date).before(PortfolioApp.ZQ().aac())) {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".getCurrentSteps, this date -" + date + "- before user signing up date, return null.");
            return 0.0f;
        }
        float f = 0.0f;
        for (SampleRaw steps : m7145a(date, z)) {
            f = (float) (steps.getSteps() + ((double) f));
        }
        return f;
    }

    public SampleDay getSamplesForDay(Calendar calendar) {
        if (cne.getStartOfDay(calendar.getTime()).before(PortfolioApp.ZQ().aac())) {
            return null;
        }
        SampleDay samplesForDay = cnq.acd().acr().getSamplesForDay(calendar);
        if (!cmq.m7114c(calendar.getTime()).booleanValue() || samplesForDay == null) {
            return samplesForDay;
        }
        long q = m7152q(calendar.getTime());
        long steps = (long) (((double) 0) + samplesForDay.getSteps());
        if (steps >= q) {
            return samplesForDay;
        }
        samplesForDay.setSteps(((double) (q - steps)) + samplesForDay.getSteps());
        return samplesForDay;
    }

    public boolean m7149a(FitnessDayData fitnessDayData) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(fitnessDayData.getDate().toDate());
        SampleDay samplesForDay = getSamplesForDay(instance);
        return samplesForDay != null && samplesForDay.getSteps() == fitnessDayData.getTotalSteps() && samplesForDay.getStepGoal() == fitnessDayData.getGoalSteps() && samplesForDay.getCalories() == fitnessDayData.getTotalCalories() && samplesForDay.getDistance() == fitnessDayData.getTotalDistance();
    }

    public void m7147a(SampleDay sampleDay) {
        if (sampleDay != null) {
            cnq.acd().acs().saveSampleDay(sampleDay);
        }
    }

    public List<SampleRaw> getSampleRawsByIds(List<String> list) {
        return cnq.acd().acs().getSampleRawsByIds(list);
    }

    public SampleDay m7151b(FitnessDayData fitnessDayData) {
        DateTime date = fitnessDayData.getDate();
        int year = date.getYear();
        int monthOfYear = date.getMonthOfYear();
        int dayOfMonth = date.getDayOfMonth();
        DailyGoal dailyGoal = new DailyGoal(year, monthOfYear, dayOfMonth, fitnessDayData.getGoalSteps());
        TimeZone toTimeZone = date.getZone().toTimeZone();
        SampleDay sampleDay = new SampleDay(year, monthOfYear, dayOfMonth, toTimeZone.getID(), toTimeZone.inDaylightTime(date.toDate()) ? toTimeZone.getDSTSavings() : 0, fitnessDayData.getTotalSteps(), fitnessDayData.getTotalCalories(), fitnessDayData.getTotalDistance());
        sampleDay.setGoal(dailyGoal);
        sampleDay.setCreatedAt(System.currentTimeMillis());
        sampleDay.setUpdatedAt(System.currentTimeMillis());
        return sampleDay;
    }

    public void m7148a(Date date, long j, String str) {
        long b = (long) m7150b(date, false);
        MFLogger.m12670d(TAG, "Inside " + TAG + ".saveRealTimeStep - realTimeSteps=" + j + ", actualSteps=" + b);
        if (j - b <= 600) {
            Object acI = this.cmQ.acI();
            if (TextUtils.isEmpty(acI)) {
                this.cmQ.gA(date.getTime() + "_" + j);
                return;
            }
            String[] split = euh.split(acI, "_");
            if (split != null && split.length == 2) {
                try {
                    b = Long.parseLong(split[0]);
                    MFLogger.m12670d(TAG, "Inside " + TAG + ".saveRealTimeStep - lastSampleRawTimeStamp=" + date + ", savedRealTimeStepTimeStamp=" + new Date(b));
                    if (cmq.m7108a(new Date(b), date)) {
                        this.cmQ.gA(date.getTime() + "_" + j);
                        return;
                    }
                    MFLogger.m12670d(TAG, "Inside " + TAG + ".saveRealTimeStep - Different date, clear realTimeStepStamp");
                    this.cmQ.gA("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public long m7152q(Date date) {
        long j = 0;
        Object acI = this.cmQ.acI();
        MFLogger.m12670d(TAG, "Inside " + TAG + ".getRealTimeStep - data=" + acI + ", date=" + cmq.m7124f(date));
        if (!TextUtils.isEmpty(acI)) {
            String[] split = euh.split(acI, "_");
            if (split != null && split.length == 2) {
                try {
                    if (cmq.m7108a(date, new Date(Long.parseLong(split[0])))) {
                        j = Long.parseLong(split[1]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return j;
    }

    public static MFSleepSession m7143a(WrapperSleep wrapperSleep, String str) {
        if (wrapperSleep == null) {
            return null;
        }
        int i = (int) wrapperSleep.deepSleepMinute;
        int i2 = (int) (wrapperSleep.sleepMinute - ((long) i));
        int i3 = (int) (wrapperSleep.duration / 60);
        int i4 = (int) (((long) i3) - wrapperSleep.sleepMinute);
        if (i4 < 0) {
            i4 = 0;
        }
        String str2 = "";
        if (wrapperSleep.getSleepStateChanges() != null) {
            str2 = new cfj().toJson(wrapperSleep.getSleepStateChanges());
        }
        MFLogger.m12670d("MFSleepSession", "Inside MFSleepSession.cloneFrom - WrapperSleep.getSleepStateChanges()=" + str2);
        if (str2 == null) {
            return null;
        }
        String sleepDistribution = new SleepDistribution(i4, i2, i).getSleepDistribution();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long j = wrapperSleep.startTime + wrapperSleep.duration;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(1000 * j);
        return new MFSleepSession(j * 1000, cne.getTimezoneOffset(), cmq.m7105a(instance.getTime()), str, (int) (timeInMillis / 1000), (int) (timeInMillis / 1000), (double) wrapperSleep.sleepQuality, FitnessSourceType.Device.ordinal(), (int) wrapperSleep.startTime, (int) j, i3, sleepDistribution, str2, new DateTime(timeInMillis));
    }
}
