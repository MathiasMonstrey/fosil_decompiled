package com.portfolio.platform.response.sleep;

import com.fossil.cne;
import com.fossil.wearables.fsl.sleep.MFSleepDay;
import com.fossil.wearables.fsl.sleep.SleepDistribution;
import java.util.Calendar;
import org.joda.time.DateTime;

public class SleepDayParse {
    private String date;
    private int goalMinutes;
    private String owner;
    private boolean reachGoal;
    private int totalSleepMinutes;
    private int[] totalSleepStateDistInMinute;

    public MFSleepDay getMFSleepBySleepDayParse() {
        if (this.totalSleepStateDistInMinute == null) {
            return null;
        }
        String str = "";
        if (this.totalSleepStateDistInMinute.length > 2) {
            str = new SleepDistribution(this.totalSleepStateDistInMinute[0], this.totalSleepStateDistInMinute[1], this.totalSleepStateDistInMinute[2]).getSleepDistribution();
        }
        return new MFSleepDay(this.date, cne.getTimezoneOffset(), this.goalMinutes, this.totalSleepMinutes, str, new DateTime(Calendar.getInstance().getTimeInMillis()));
    }
}
