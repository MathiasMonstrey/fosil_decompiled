package com.fossil.wearables.fsl.goal;

import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.field.DatabaseField;

public class GoalInterval extends BaseModel {
    @DatabaseField(columnName = "goal_id", foreign = true, foreignAutoRefresh = true)
    private Goal goal;
    @DatabaseField
    private int index;
    @DatabaseField
    private int value;

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int i) {
        if (i > this.goal.getTargetValue()) {
            i = this.goal.getTargetValue();
        }
        this.value = i;
    }

    public Goal getGoal() {
        return this.goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public double getProgress() {
        return ((double) this.value) / ((double) this.goal.getTargetValue());
    }
}
