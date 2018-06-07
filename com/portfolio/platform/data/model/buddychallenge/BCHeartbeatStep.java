package com.portfolio.platform.data.model.buddychallenge;

import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "heartbeatStep")
public class BCHeartbeatStep {
    @cga("_id")
    @DatabaseField(allowGeneratedIdInsert = true, columnName = "_id", generatedId = true)
    private int heartbeatId;
    @cga("heartbeatSteps")
    @DatabaseField(columnName = "heartbeatSteps")
    private int heartbeatSteps;
    @cga("lastHeartbeatStamp")
    @DatabaseField(columnName = "lastHeartbeatStamp")
    private long lastHeartbeatStamp;

    public int getHeartbeatSteps() {
        return this.heartbeatSteps;
    }

    public void setHeartbeatSteps(int i) {
        this.heartbeatSteps = i;
    }

    public long getLastHeartbeatStamp() {
        return this.lastHeartbeatStamp;
    }

    public void setLastHeartbeatStamp(long j) {
        this.lastHeartbeatStamp = j;
    }

    public int getHeartbeatId() {
        return this.heartbeatId;
    }

    public void setHeartbeatId(int i) {
        this.heartbeatId = i;
    }

    public void updateHeartbeat(BCHeartbeatStep bCHeartbeatStep) {
        setHeartbeatSteps(bCHeartbeatStep.getHeartbeatSteps());
        setLastHeartbeatStamp(bCHeartbeatStep.getLastHeartbeatStamp());
    }

    public String toString() {
        return "HeartbeatStep steps=" + this.heartbeatSteps + " timestamp=" + this.lastHeartbeatStamp;
    }
}
