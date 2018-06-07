package com.portfolio.platform.data.model.buddychallenge;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "opponent")
public class BCOpponent implements Parcelable {
    public static final Creator<BCOpponent> CREATOR = new 1();
    @cga("id")
    @DatabaseField(columnName = "id", id = true)
    private String opponentId;
    @cga("profilePicture")
    @DatabaseField(columnName = "profilePicture")
    private String profilePicture;
    @cga("username")
    @DatabaseField(columnName = "username")
    private String userName;

    public String getOpponentId() {
        return this.opponentId;
    }

    public void setOpponentId(String str) {
        this.opponentId = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(String str) {
        this.profilePicture = str;
    }

    public String toString() {
        return "BCOpponent id:" + this.opponentId + " username:" + this.userName;
    }

    protected BCOpponent(Parcel parcel) {
        this.opponentId = parcel.readString();
        this.userName = parcel.readString();
        this.profilePicture = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.opponentId);
        parcel.writeString(this.userName);
        parcel.writeString(this.profilePicture);
    }

    public int describeContents() {
        return 0;
    }
}
