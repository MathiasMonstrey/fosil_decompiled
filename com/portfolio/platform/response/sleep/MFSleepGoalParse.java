package com.portfolio.platform.response.sleep;

import java.io.Serializable;
import org.joda.time.DateTime;

public class MFSleepGoalParse implements Serializable {
    private DateTime createAt;
    private int currentGoalMinutes;
    private String objectId;
    private String owner;
    private DateTime updateAt;

    public String getObjectId() {
        return this.objectId;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getCurrentGoalMinutes() {
        return this.currentGoalMinutes;
    }

    public DateTime getCreateAt() {
        return this.createAt;
    }

    public DateTime getUpdateAt() {
        return this.updateAt;
    }
}
