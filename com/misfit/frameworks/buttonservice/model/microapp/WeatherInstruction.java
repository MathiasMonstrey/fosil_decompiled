package com.misfit.frameworks.buttonservice.model.microapp;

import android.os.Parcel;
import com.fossil.jt;
import com.misfit.ble.setting.uapp.UAppEnum.UAppID;
import com.misfit.ble.setting.uapp.UAppEnum.UAppVariant;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import com.misfit.ble.setting.uapp.instruction.builder.UAppInstructionFactory;
import com.misfit.ble.setting.uapp.instruction.builder.UAppInstructionFactory.AngleTemperaturePair;
import com.misfit.ble.setting.uapp.instruction.builder.UAppInstructionFactory.UAppWeatherConfiguration;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class WeatherInstruction extends MicroAppInstruction {
    private static final String TAG = WeatherInstruction.class.getSimpleName();
    private jt<Float, Integer> mMaxPoint;
    private jt<Float, Integer> mMinPoint;
    private jt<Float, Integer> mStartPoint;
    private float mTemperature;

    public WeatherInstruction(float f, jt<Float, Integer> jtVar, jt<Float, Integer> jtVar2, jt<Float, Integer> jtVar3) {
        super(UAppID.UAPP_WEATHER, UAppVariant.UAPP_VARIANT_STANDARD);
        this.mTemperature = f;
        this.mMinPoint = jtVar;
        this.mMaxPoint = jtVar2;
        this.mStartPoint = jtVar3;
    }

    protected WeatherInstruction(Parcel parcel) {
        super(parcel);
        this.mTemperature = parcel.readFloat();
        this.mMinPoint = new jt(Float.valueOf(parcel.readFloat()), Integer.valueOf(parcel.readInt()));
        this.mMaxPoint = new jt(Float.valueOf(parcel.readFloat()), Integer.valueOf(parcel.readInt()));
        this.mStartPoint = new jt(Float.valueOf(parcel.readFloat()), Integer.valueOf(parcel.readInt()));
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.mTemperature);
        parcel.writeFloat(((Float) this.mMinPoint.first).floatValue());
        parcel.writeInt(((Integer) this.mMinPoint.second).intValue());
        parcel.writeFloat(((Float) this.mMaxPoint.first).floatValue());
        parcel.writeInt(((Integer) this.mMaxPoint.second).intValue());
        parcel.writeFloat(((Float) this.mStartPoint.first).floatValue());
        parcel.writeInt(((Integer) this.mStartPoint.second).intValue());
    }

    public String toString() {
        return "[Weather Instruction]:[temperature: " + this.mTemperature + ", minPoint<" + this.mMinPoint.first + "," + this.mMinPoint.second + ">, maxPoint<" + this.mMaxPoint.first + "," + this.mMaxPoint.second + ">, startPoint<" + this.mStartPoint.first + "," + this.mStartPoint.second + ">]";
    }

    public float getTemperature() {
        return this.mTemperature;
    }

    public void setTemperature(float f) {
        this.mTemperature = f;
    }

    public jt<Float, Integer> getMinPoint() {
        return this.mMinPoint;
    }

    public void setMinPoint(jt<Float, Integer> jtVar) {
        this.mMinPoint = jtVar;
    }

    public jt<Float, Integer> getMaxPoint() {
        return this.mMaxPoint;
    }

    public void setMaxPoint(jt<Float, Integer> jtVar) {
        this.mMaxPoint = jtVar;
    }

    public jt<Float, Integer> getStartPoint() {
        return this.mStartPoint;
    }

    public void setStartPoint(jt<Float, Integer> jtVar) {
        this.mStartPoint = jtVar;
    }

    public List<UAppInstruction> getInstructions() {
        try {
            return UAppInstructionFactory.buildWeatherInstructions(new UAppWeatherConfiguration(new AngleTemperaturePair(((Integer) this.mMinPoint.second).intValue(), ((Float) this.mMinPoint.first).floatValue()), new AngleTemperaturePair(((Integer) this.mMaxPoint.second).intValue(), ((Float) this.mMaxPoint.first).floatValue()), new AngleTemperaturePair(((Integer) this.mStartPoint.second).intValue(), ((Float) this.mStartPoint.first).floatValue())), this.mTemperature);
        } catch (IllegalArgumentException e) {
            MFLogger.e(TAG, "Inside " + TAG + ".getInstructions, error=" + e.getMessage());
            return ErrorInstructionFactory.getErrorInstructions(2).getInstructions();
        }
    }
}
