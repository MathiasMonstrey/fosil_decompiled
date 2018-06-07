package com.misfit.frameworks.common.entities;

import java.io.Serializable;
import java.util.Date;

public class Firmware implements Serializable {
    private String changeLog;
    private String checksum;
    private Date createdAt;
    private String deviceModel;
    private String downloadUrl;
    private long id;
    private boolean isLatest;
    private Date updatedAt;
    private String versionNum;

    public void setId(long j) {
        this.id = j;
    }

    public long getId() {
        return this.id;
    }

    public void setChangeLog(String str) {
        this.changeLog = str;
    }

    public String getChangeLog() {
        return this.changeLog;
    }

    public void setChecksum(String str) {
        this.checksum = str;
    }

    public String getChecksum() {
        return this.checksum;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setIsLatest(boolean z) {
        this.isLatest = z;
    }

    public boolean isLatest() {
        return this.isLatest;
    }

    public void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setVersionNum(String str) {
        this.versionNum = str;
    }

    public String getVersionNum() {
        return this.versionNum;
    }

    public String toString() {
        return "[Firmware: changeLog=" + this.changeLog + ", checksum=" + this.checksum + ", createdAt=" + this.createdAt + ", deviceModel=" + this.deviceModel + ", downloadUrl=" + this.downloadUrl + ", isLatest=" + this.isLatest + ", updatedAt=" + this.updatedAt + ", versionNum=" + this.versionNum + "]";
    }
}
