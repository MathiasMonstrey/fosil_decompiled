package com.portfolio.platform.response.fitness;

import java.io.Serializable;
import org.joda.time.DateTime;

public class MFFitnessGoalParse implements Serializable {
    private DateTime createAt;
    private int currentGoalSteps;
    private String objectId;
    private String owner;
    private DateTime updateAt;

    public String getObjectId() {
        return this.objectId;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getCurrentGoalSteps() {
        return this.currentGoalSteps;
    }

    public DateTime getCreateAt() {
        return this.createAt;
    }

    public DateTime getUpdateAt() {
        return this.updateAt;
    }
}
