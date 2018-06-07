package com.portfolio.platform.data.model.buddychallenge;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cga;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.ArrayList;
import java.util.List;

@DatabaseTable(tableName = "challenges")
public class BCChallenge implements Parcelable {
    public static final Creator<BCChallenge> CREATOR = new 1();
    @cga("id")
    @DatabaseField(columnName = "id", id = true)
    private String challengeId;
    @cga("type")
    @DatabaseField(columnName = "type")
    private int challengeType;
    @cga("closeTime")
    @DatabaseField(columnName = "closeTime")
    private String closeTime;
    @cga("endTime")
    @DatabaseField(columnName = "endTime")
    private String endTime;
    @cga("goal")
    @DatabaseField(columnName = "goal")
    private int goal;
    @cga("isReceiverViewedAfterClosed")
    @DatabaseField(columnName = "isReceiverViewedAfterClosed")
    private boolean isReceiverViewedAfterClosed;
    @cga("isSenderViewedAfterClosed")
    @DatabaseField(columnName = "isSenderViewedAfterClosed")
    private boolean isSenderViewedAfterClosed;
    @DatabaseField(columnName = "pinType")
    private int pinType;
    @cga("receiver")
    @DatabaseField(columnName = "receiver")
    private String receiverId;
    @cga("receiverScore")
    @DatabaseField(columnName = "receiverScore")
    private int receiverScore;
    @cga("receiverStepsDays")
    @DatabaseField(columnName = "receiverStepsDays", dataType = DataType.SERIALIZABLE)
    private ArrayList<Integer> receiverStepsDays;
    @cga("sender")
    @DatabaseField(columnName = "sender")
    private String senderId;
    @cga("senderScore")
    @DatabaseField(columnName = "senderScore")
    private int senderScore;
    @cga("senderStepsDays")
    @DatabaseField(columnName = "senderStepsDays", dataType = DataType.SERIALIZABLE)
    private ArrayList<Integer> senderStepsDays;
    @cga("startTime")
    @DatabaseField(columnName = "startTime")
    private String startTime;
    @cga("status")
    @DatabaseField(columnName = "status")
    private int status;
    @cga("timezoneOffset")
    @DatabaseField(columnName = "timezoneOffset")
    private int timezoneOffset;
    @cga("updatedAt")
    @DatabaseField(columnName = "updatedAt")
    private String updatedAt;
    @cga("winner")
    @DatabaseField(columnName = "winner")
    private String winner;

    protected BCChallenge(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.challengeId = parcel.readString();
        this.goal = parcel.readInt();
        this.challengeType = parcel.readInt();
        this.senderId = parcel.readString();
        this.senderStepsDays = parcel.readArrayList(Integer.class.getClassLoader());
        this.senderScore = parcel.readInt();
        this.receiverId = parcel.readString();
        this.receiverStepsDays = parcel.readArrayList(Integer.class.getClassLoader());
        this.receiverScore = parcel.readInt();
        this.startTime = parcel.readString();
        this.endTime = parcel.readString();
        this.closeTime = parcel.readString();
        this.updatedAt = parcel.readString();
        this.timezoneOffset = parcel.readInt();
        this.status = parcel.readInt();
        this.winner = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.isSenderViewedAfterClosed = z;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.isReceiverViewedAfterClosed = z2;
        this.pinType = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.challengeId);
        parcel.writeInt(this.goal);
        parcel.writeInt(this.challengeType);
        parcel.writeString(this.senderId);
        parcel.writeList(this.senderStepsDays);
        parcel.writeInt(this.senderScore);
        parcel.writeString(this.receiverId);
        parcel.writeList(this.receiverStepsDays);
        parcel.writeInt(this.receiverScore);
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        parcel.writeString(this.closeTime);
        parcel.writeString(this.updatedAt);
        parcel.writeInt(this.timezoneOffset);
        parcel.writeInt(this.status);
        parcel.writeString(this.winner);
        if (this.isSenderViewedAfterClosed) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.isReceiverViewedAfterClosed) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.pinType);
    }

    public int describeContents() {
        return 0;
    }

    public String getChallengeId() {
        return this.challengeId;
    }

    public void setChallengeId(String str) {
        this.challengeId = str;
    }

    public int getType() {
        return this.challengeType;
    }

    public void setType(int i) {
        this.challengeType = i;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public void setSenderId(String str) {
        this.senderId = str;
    }

    public String getReceiverId() {
        return this.receiverId;
    }

    public void setReceiverId(String str) {
        this.receiverId = str;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getWinner() {
        return this.winner;
    }

    public void setWinner(String str) {
        this.winner = str;
    }

    public int getGoal() {
        return this.goal;
    }

    public void setGoal(int i) {
        this.goal = i;
    }

    public String getCloseTime() {
        return this.closeTime;
    }

    public void setCloseTime(String str) {
        this.closeTime = str;
    }

    public int getTimezoneOffset() {
        return this.timezoneOffset;
    }

    public void setTimezoneOffset(int i) {
        this.timezoneOffset = i;
    }

    public boolean isSenderViewedAfterClosed() {
        return this.isSenderViewedAfterClosed;
    }

    public void setSenderViewedAfterClosed(boolean z) {
        this.isSenderViewedAfterClosed = z;
    }

    public boolean isReceiverViewedAfterClosed() {
        return this.isReceiverViewedAfterClosed;
    }

    public void setReceiverViewedAfterClosed(boolean z) {
        this.isReceiverViewedAfterClosed = z;
    }

    public List<Integer> getSenderStepsDays() {
        if (this.senderStepsDays == null) {
            this.senderStepsDays = new ArrayList();
        }
        return this.senderStepsDays;
    }

    public void setSenderStepsDays(List<Integer> list) {
        this.senderStepsDays.clear();
        this.senderStepsDays.addAll(list);
    }

    public int getSenderScore() {
        return this.senderScore;
    }

    public void setSenderScore(int i) {
        this.senderScore = i;
    }

    public ArrayList<Integer> getReceiverStepsDays() {
        if (this.receiverStepsDays == null) {
            return new ArrayList();
        }
        return this.receiverStepsDays;
    }

    public void setReceiverStepsDays(List<Integer> list) {
        this.receiverStepsDays.clear();
        this.receiverStepsDays.addAll(list);
    }

    public int getReceiverScore() {
        return this.receiverScore;
    }

    public void setReceiverScore(int i) {
        this.receiverScore = i;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String str) {
        this.updatedAt = str;
    }

    public int getPinType() {
        return this.pinType;
    }

    public void setPinType(int i) {
        this.pinType = i;
    }

    public String toString() {
        return "BCChallenge  id:" + this.challengeId + " type:" + this.challengeType + " status:" + this.status + " goal:" + this.goal + " sender:" + this.senderId + " receiver:" + this.receiverId + " winner:" + this.winner;
    }
}
