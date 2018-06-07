package com.portfolio.platform.data.model.buddychallenge;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "invitations")
public class BCInvitation implements Parcelable {
    public static final Creator<BCInvitation> CREATOR = new 1();
    @cga("challengeId")
    @DatabaseField(columnName = "challengeId")
    private String challengeId;
    @cga("challengeType")
    @DatabaseField(columnName = "challengeType")
    private int challengeType;
    @cga("id")
    @DatabaseField(columnName = "id", id = true)
    private String invitationId;
    @cga("receiver")
    @DatabaseField(columnName = "receiver")
    private String receiver;
    @cga("sender")
    @DatabaseField(columnName = "sender")
    private String sender;
    @cga("status")
    @DatabaseField(columnName = "status")
    private int status;
    @cga("timezoneOffset")
    @DatabaseField(columnName = "timezoneOffset")
    private int timezoneOffset;
    @cga("token")
    @DatabaseField(columnName = "token")
    private String token;

    public String getInvitationId() {
        return this.invitationId;
    }

    public void setInvitationId(String str) {
        this.invitationId = str;
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

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getTimezoneOffset() {
        return this.timezoneOffset;
    }

    public void setTimezoneOffset(int i) {
        this.timezoneOffset = i;
    }

    public int getChallengeType() {
        return this.challengeType;
    }

    public void setChallengeType(int i) {
        this.challengeType = i;
    }

    protected BCInvitation(Parcel parcel) {
        this.invitationId = parcel.readString();
        this.sender = parcel.readString();
        this.receiver = parcel.readString();
        this.token = parcel.readString();
        this.timezoneOffset = parcel.readInt();
        this.challengeType = parcel.readInt();
        this.status = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.invitationId);
        parcel.writeString(this.sender);
        parcel.writeString(this.receiver);
        parcel.writeString(this.token);
        parcel.writeInt(this.timezoneOffset);
        parcel.writeInt(this.challengeType);
        parcel.writeInt(this.status);
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
}
