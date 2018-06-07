package com.fossil;

import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.fossil.wearables.fsl.sleep.SleepDistribution;
import com.misfit.frameworks.buttonservice.model.WrapperSleepStateChange;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class csp {
    private static final String TAG = csp.class.getSimpleName();
    private int bookmarkTime;
    private String date;
    private String deviceSerialNumber;
    private int editedEndTime;
    private int editedSleepMinutes;
    private int[] editedSleepStateDistInMinute;
    private int editedStartTime;
    private double normalizeSleepQuality;
    private int realEndTime;
    private int realSleepMinutes;
    private int[] realSleepStateDistInMinute;
    private int realStartTime;
    private List<int[]> sleepStates = new ArrayList();
    private int source;
    private int syncTime;
    private int timezoneOffset;

    class C22801 extends cgu<List<WrapperSleepStateChange>> {
        final /* synthetic */ csp cCq;

        C22801(csp com_fossil_csp) {
            this.cCq = com_fossil_csp;
        }
    }

    public csp(MFSleepSession mFSleepSession) {
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(mFSleepSession.getDate()));
        this.timezoneOffset = mFSleepSession.getTimezoneOffset();
        this.source = mFSleepSession.getSource();
        this.deviceSerialNumber = mFSleepSession.getDeviceSerialNumber();
        this.syncTime = mFSleepSession.getSyncTime();
        this.bookmarkTime = mFSleepSession.getBookmarkTime();
        this.realStartTime = mFSleepSession.getRealStartTime();
        this.realEndTime = mFSleepSession.getRealEndTime();
        this.realSleepMinutes = mFSleepSession.getRealSleepMinutes();
        this.realSleepStateDistInMinute = SleepDistribution.getSleepDistributionByString(mFSleepSession.getRealSleepStateDistInMinute()).getArrayDistribution();
        this.editedStartTime = mFSleepSession.getEditedStartTime();
        this.editedEndTime = mFSleepSession.getEditedEndTime();
        this.editedSleepMinutes = mFSleepSession.getEditedSleepMinutes();
        this.editedSleepStateDistInMinute = SleepDistribution.getSleepDistributionByString(mFSleepSession.getEditedSleepStateDistInMinute()).getArrayDistribution();
        this.normalizeSleepQuality = mFSleepSession.getNormalizedSleepQuality();
        List<WrapperSleepStateChange> list = (List) new cfj().m6197a(mFSleepSession.getSleepStates(), new C22801(this).getType());
        for (WrapperSleepStateChange wrapperSleepStateChange : list) {
            if (wrapperSleepStateChange != null) {
                this.sleepStates.add(new int[]{wrapperSleepStateChange.getState(), (int) wrapperSleepStateChange.getIndex()});
            }
        }
    }
}
