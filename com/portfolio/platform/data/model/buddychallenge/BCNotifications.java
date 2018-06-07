package com.portfolio.platform.data.model.buddychallenge;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "bc_notification")
public class BCNotifications implements Parcelable {
    public static final Creator<BCNotifications> CREATOR = new 1();
    @cga("challengeId")
    @DatabaseField(columnName = "challengeId")
    private String challengeId;
    @cga("challengeType")
    @DatabaseField(columnName = "challengeType")
    private int challengeType;
    @cga("id")
    @DatabaseField(columnName = "id")
    private String id;
    @cga("message")
    @DatabaseField(columnName = "message")
    private String message;
    @cga("needToShowPoup")
    @DatabaseField(columnName = "needToShowPoup")
    private boolean needToShowPopup;
    @cga("notification_id")
    @DatabaseField(allowGeneratedIdInsert = true, columnName = "notification_id", generatedId = true)
    private int notificationId;
    @cga("receiver")
    @DatabaseField(columnName = "receiver")
    private String receiver;
    @cga("sender")
    @DatabaseField(columnName = "sender")
    private String sender;
    @cga("type")
    @DatabaseField(columnName = "type")
    private int type;

    protected BCNotifications(Parcel parcel) {
        this.notificationId = parcel.readInt();
        this.sender = parcel.readString();
        this.receiver = parcel.readString();
        this.id = parcel.readString();
        this.type = parcel.readInt();
        this.challengeType = parcel.readInt();
        this.challengeId = parcel.readString();
        this.message = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.notificationId);
        parcel.writeString(this.sender);
        parcel.writeString(this.receiver);
        parcel.writeString(this.id);
        parcel.writeInt(this.type);
        parcel.writeInt(this.challengeType);
        parcel.writeString(this.challengeId);
        parcel.writeString(this.message);
    }

    public int describeContents() {
        return 0;
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    public void setNotificationId(int i) {
        this.notificationId = i;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public void setReceiver(String str) {
        this.receiver = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getChallengeType() {
        return this.challengeType;
    }

    public void setChallengeType(int i) {
        this.challengeType = i;
    }

    public String getChallengeId() {
        return this.challengeId;
    }

    public void setChallengeId(String str) {
        this.challengeId = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public boolean isNeedToShowPopup() {
        return this.needToShowPopup;
    }

    public void setNeedToShowPopup(boolean z) {
        this.needToShowPopup = z;
    }

    public boolean isEqual(BCNotifications bCNotifications) {
        return this.type == bCNotifications.type && this.sender.equals(bCNotifications.sender) && this.receiver.equals(bCNotifications.receiver) && this.id.equals(bCNotifications.id) && this.challengeType == bCNotifications.challengeType;
    }

    public String toString() {
        return "BCNotification id:" + this.id + " type:" + this.type + " sender:" + this.sender + " receiver:" + this.receiver;
    }
}
