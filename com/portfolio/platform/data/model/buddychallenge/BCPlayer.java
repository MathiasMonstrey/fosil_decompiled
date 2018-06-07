package com.portfolio.platform.data.model.buddychallenge;

import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "BCPlayer")
public class BCPlayer {
    @cga("createdAt")
    @DatabaseField(columnName = "createdAt")
    private String createAt;
    @cga("goal")
    @DatabaseField(columnName = "goal")
    private int goal;
    @cga("inChallengeProcess")
    @DatabaseField(columnName = "inChallengeProcess")
    private int inChallengeProcess;
    @cga("isAvailableForChallenge")
    @DatabaseField(columnName = "isAvailableForChallenge")
    private boolean isAvailableForChallenge;
    @cga("profilePicture")
    @DatabaseField(columnName = "profilePicture")
    private String profilePicture;
    @cga("timezoneOffset")
    @DatabaseField(columnName = "timezoneOffset")
    private int timeZone;
    @cga("updatedAt")
    @DatabaseField(columnName = "updatedAt")
    private String updateAt;
    @cga("id")
    @DatabaseField(columnName = "id", id = true)
    private String userId;
    @cga("username")
    @DatabaseField(columnName = "username")
    private String userName;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(String str) {
        this.createAt = str;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(String str) {
        this.updateAt = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public int getGoal() {
        return this.goal;
    }

    public void setGoal(int i) {
        this.goal = i;
    }

    public int getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(int i) {
        this.timeZone = i;
    }

    public int getInChallengeProcess() {
        return this.inChallengeProcess;
    }

    public void setInChallengeProcess(int i) {
        this.inChallengeProcess = i;
    }

    public boolean isAvailableForChallenge() {
        return this.isAvailableForChallenge;
    }

    public void setAvailableForChallenge(boolean z) {
        this.isAvailableForChallenge = z;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(String str) {
        this.profilePicture = str;
    }
}
