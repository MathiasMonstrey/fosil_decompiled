package com.portfolio.platform.ui.notifications.domain.model;

import android.net.Uri;
import com.portfolio.platform.data.model.InstalledApp;
import java.io.Serializable;

public class AppWrapper implements Serializable, Comparable {
    public InstalledApp installedApp;
    private int mCurrentHandGroup;
    public Uri uri;

    public int getCurrentHandGroup() {
        return this.mCurrentHandGroup;
    }

    public void setCurrentHandGroup(int i) {
        this.mCurrentHandGroup = i;
    }

    public int compareTo(Object obj) {
        if (obj instanceof AppWrapper) {
            return this.installedApp.getTitle().toLowerCase().compareTo(((AppWrapper) obj).installedApp.getTitle().toLowerCase());
        }
        return 0;
    }
}
