package com.portfolio.platform.data.model.microapp.goaltracking;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cfj;
import com.fossil.cga;
import com.fossil.cmq;
import com.fossil.wearables.fsl.goaltracking.Frequency;
import com.fossil.wearables.fsl.goaltracking.PeriodType;
import java.util.Calendar;
import java.util.Date;

public class GoalTrackingSettings implements Parcelable {
    public static final Creator<GoalTrackingSettings> CREATOR = new 1();
    @cga("frequency")
    private int mFrequency;
    @cga("goalId")
    private int mGoalId;
    @cga("goalName")
    private String mName;
    @cga("periodType")
    private int mPeriodType;
    @cga("periodValue")
    private int mPeriodValue;
    @cga("target")
    private int mTarget;
    @cga("updatedDate")
    private String mUpdatedDate;
    @cga("value")
    private int mValue;

    public GoalTrackingSettings() {
        this.mGoalId = 1;
        this.mName = "Drink Water";
        this.mFrequency = Frequency.DAILY.getValue();
        this.mTarget = 1;
        this.mPeriodType = PeriodType.UNKNOWN.getValue();
        this.mPeriodValue = -1;
        this.mValue = 0;
        this.mUpdatedDate = cmq.m7124f(Calendar.getInstance().getTime());
    }

    public GoalTrackingSettings(int i, String str, Frequency frequency, int i2, PeriodType periodType, int i3, int i4, Date date) {
        this.mGoalId = i;
        this.mName = str;
        this.mFrequency = frequency.getValue();
        this.mTarget = i2;
        this.mPeriodType = periodType.getValue();
        this.mPeriodValue = i3;
        this.mValue = i4;
        this.mUpdatedDate = cmq.m7124f(date);
    }

    private GoalTrackingSettings(Parcel parcel) {
        this.mGoalId = parcel.readInt();
        this.mName = parcel.readString();
        this.mFrequency = parcel.readInt();
        this.mTarget = parcel.readInt();
        this.mPeriodType = parcel.readInt();
        this.mPeriodValue = parcel.readInt();
        this.mValue = parcel.readInt();
        this.mUpdatedDate = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mGoalId);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mFrequency);
        parcel.writeInt(this.mTarget);
        parcel.writeInt(this.mPeriodType);
        parcel.writeInt(this.mPeriodValue);
        parcel.writeInt(this.mValue);
        parcel.writeString(this.mUpdatedDate);
    }

    public int describeContents() {
        return 0;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public Frequency getFrequency() {
        return Frequency.fromInt(this.mFrequency);
    }

    public void setFrequency(Frequency frequency) {
        this.mFrequency = frequency.getValue();
    }

    public int getTarget() {
        return this.mTarget;
    }

    public void setTarget(int i) {
        this.mTarget = i;
    }

    public PeriodType getPeriodType() {
        return PeriodType.fromInt(this.mPeriodType);
    }

    public void setPeriodType(PeriodType periodType) {
        this.mPeriodType = periodType.getValue();
    }

    public int getPeriodValue() {
        return this.mPeriodValue;
    }

    public void setPeriodValue(int i) {
        this.mPeriodValue = i;
    }

    public int getValue() {
        return this.mValue;
    }

    public void setValue(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mValue = i;
    }

    public Date getUpdatedDate() {
        return cmq.fX(this.mUpdatedDate);
    }

    public void setUpdatedDate(Date date) {
        this.mUpdatedDate = cmq.m7124f(date);
    }

    public int getGoalId() {
        return this.mGoalId;
    }

    public void setGoalId(int i) {
        this.mGoalId = i;
    }

    public String toJson() {
        return new cfj().toJson(this);
    }
}
