package com.fossil;

import android.os.Bundle;
import android.text.TextUtils;
import com.fossil.dhs.C2796a;
import com.fossil.dhs.C2800b;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings.TIME_FORMAT;

public class dhu implements C2796a {
    private static final String TAG = dhu.class.getSimpleName();
    private CommuteTimeSettings cDY;
    private C2800b cVV;
    private CommuteTimeSettings cVW;

    public dhu(C2800b c2800b) {
        this.cVV = (C2800b) emj.ce(c2800b);
    }

    public void apk() {
        MFLogger.m12670d(TAG, "startCommuteSetting");
        if (this.cDY != null) {
            this.cVV.mo2492b(this.cDY);
        }
    }

    public void iJ(String str) {
        MFLogger.m12670d(TAG, "loadCommuteSettings");
        if (TextUtils.isEmpty(str)) {
            this.cDY = new CommuteTimeSettings();
        } else {
            try {
                this.cDY = (CommuteTimeSettings) new cfj().m6205c(str, CommuteTimeSettings.class);
            } catch (Exception e) {
                this.cDY = new CommuteTimeSettings();
            }
            if (this.cDY == null) {
                this.cDY = new CommuteTimeSettings();
            }
        }
        this.cVW = new CommuteTimeSettings(this.cDY);
    }

    public void cW(boolean z) {
        this.cVW.setIsAvoidTolls(z);
    }

    public void mo2463a(TIME_FORMAT time_format) {
        if (time_format != this.cDY.getTimeFormat()) {
            this.cVW.setTimeFormat(time_format);
            if (this.cVW.getDestination() != null && !this.cVW.getDestination().isEmpty()) {
                this.cVV.apc();
            }
        }
    }

    public void apl() {
    }

    public void setDestination(String str) {
        this.cVW.setDestination(str);
    }

    public void ahu() {
        this.cVV.cK(this);
    }

    public boolean apo() {
        return (this.cDY == null || this.cDY.getDestination() == null || this.cDY.getDestination().isEmpty()) ? false : true;
    }

    public CommuteTimeSettings apC() {
        MFLogger.m12670d(TAG, "saveCommuteSettingstimeFormat=" + this.cDY.getTimeFormat().getValue());
        return this.cVW;
    }

    public boolean lM() {
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("COMMUTE_SETTINGS", this.cDY);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            CommuteTimeSettings commuteTimeSettings = (CommuteTimeSettings) bundle.getParcelable("COMMUTE_SETTINGS");
            if (commuteTimeSettings != null) {
                this.cDY = commuteTimeSettings;
            }
        }
    }
}
