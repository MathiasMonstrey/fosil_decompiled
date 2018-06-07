package com.misfit.ble.setting.uapp.instruction.builder;

import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.obfuscated.ai.C4439a;
import com.misfit.ble.obfuscated.aj;
import com.misfit.ble.obfuscated.ak;
import com.misfit.ble.obfuscated.al;
import com.misfit.ble.obfuscated.al.C4440a;
import com.misfit.ble.obfuscated.al.C4441b;
import com.misfit.ble.obfuscated.al.C4442c;
import com.misfit.ble.obfuscated.al.C4443d;
import com.misfit.ble.obfuscated.al.C4444e;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import com.misfit.ble.util.LogUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class UAppInstructionFactory {
    private static final String TAG = LogUtils.m15475b(UAppInstructionFactory.class);

    public static class AngleTemperaturePair {
        public int angle;
        public float temperature;

        public AngleTemperaturePair(AngleTemperaturePair angleTemperaturePair) {
            if (angleTemperaturePair != null) {
                this.angle = angleTemperaturePair.angle;
                this.temperature = angleTemperaturePair.temperature;
            }
        }

        public AngleTemperaturePair(int i, float f) {
            if (i < 0 || i > 359) {
                throw new IllegalArgumentException("angle must be from 0 to 359");
            }
            this.angle = i;
            this.temperature = f;
        }

        public AngleTemperaturePair clone() {
            return new AngleTemperaturePair(this);
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("angle", this.angle);
                jSONObject.put("temperature", (double) this.temperature);
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            return jSONObject;
        }

        public String toString() {
            return toJSONObject().toString();
        }
    }

    public enum UAppErrorInstructionType {
        ETA,
        TRAVEL_TIME,
        WEATHER
    }

    public static class UAppWeatherConfiguration {
        private AngleTemperaturePair cT;
        private AngleTemperaturePair cU;
        private AngleTemperaturePair cV;

        UAppWeatherConfiguration(UAppWeatherConfiguration uAppWeatherConfiguration) {
            if (uAppWeatherConfiguration != null) {
                this.cT = uAppWeatherConfiguration.getMinPoint().clone();
                this.cU = uAppWeatherConfiguration.getMaxPoint().clone();
                this.cV = uAppWeatherConfiguration.getStartPoint().clone();
            }
        }

        public UAppWeatherConfiguration(AngleTemperaturePair angleTemperaturePair, AngleTemperaturePair angleTemperaturePair2, AngleTemperaturePair angleTemperaturePair3) throws IllegalArgumentException {
            if (angleTemperaturePair == null) {
                throw new IllegalArgumentException("minPoint must not be null.");
            } else if (angleTemperaturePair2 == null) {
                throw new IllegalArgumentException("maxPoint must not be null.");
            } else if (angleTemperaturePair3 == null) {
                throw new IllegalArgumentException("startPoint must not be null.");
            } else if (angleTemperaturePair2.temperature < angleTemperaturePair3.temperature || angleTemperaturePair3.temperature < angleTemperaturePair.temperature) {
                throw new IllegalArgumentException("Condition not satisfied: maxPoint.temperature >= startPoint.temperature >= minPoint.temperature");
            } else if (angleTemperaturePair2.angle < 0 || angleTemperaturePair2.angle >= 360 || angleTemperaturePair3.angle < 0 || angleTemperaturePair3.angle >= 360 || angleTemperaturePair.angle < 0 || angleTemperaturePair.angle >= 360) {
                throw new IllegalArgumentException("Angle of maxPoint, minPoint, startPoint must be in [0; 359] range");
            } else {
                this.cT = angleTemperaturePair;
                this.cU = angleTemperaturePair2;
                this.cV = angleTemperaturePair3;
            }
        }

        public AngleTemperaturePair getMinPoint() {
            return this.cT;
        }

        public AngleTemperaturePair getMaxPoint() {
            return this.cU;
        }

        public AngleTemperaturePair getStartPoint() {
            return this.cV;
        }

        public UAppWeatherConfiguration clone() {
            return new UAppWeatherConfiguration(this);
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("minPoint", this.cT);
                jSONObject.put("maxPoint", this.cU);
                jSONObject.put("startPoint", this.cV);
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            return jSONObject;
        }

        public String toString() {
            return toJSONObject().toString();
        }
    }

    public static List<UAppInstruction> buildTravelTimeInstructions(int i) throws IllegalArgumentException {
        LogUtils.m15476d(TAG, "buildTravelTimeInstructions(travelTimeInMinutes: " + i + ")");
        if (i < 0 || i > 719) {
            throw new IllegalArgumentException("travelTimeInMinutes value must be from 0 to " + 719);
        }
        ak akVar = new ak();
        ArrayList arrayList = new ArrayList();
        if (i >= 60) {
            int i2 = (i % 60) * 6;
            arrayList.add(new al(C4440a.HOUR, (i / 60) * 30, C4443d.POSITION, C4444e.PRESET, C4441b.CLOCKWISE, C4442c.FULL));
            arrayList.add(new al(C4440a.MINUTE, i2, C4443d.POSITION, C4444e.PRESET, C4441b.CLOCKWISE, C4442c.FULL));
        } else if (i > 0) {
            int i3 = i * 6;
            arrayList.add(new al(C4440a.HOUR, i3, C4443d.DISTANCE, C4444e.PRESET, C4441b.CLOCKWISE, C4442c.FULL));
            arrayList.add(new al(C4440a.MINUTE, i3, C4443d.DISTANCE, C4444e.PRESET, C4441b.CLOCKWISE, C4442c.FULL));
        }
        akVar.m14692d(arrayList);
        akVar.m14690b(8.0d);
        return akVar.m14687N();
    }

    public static List<UAppInstruction> buildETAInstructions(int i, int i2) throws IllegalArgumentException {
        LogUtils.m15476d(TAG, "buildETAInstructions(hour: " + i + ", minute: " + i2 + ")");
        if (i < 0 || i > 11) {
            throw new IllegalArgumentException("hour value must be from 0 to 11");
        } else if (i2 < 0 || i2 > 59) {
            throw new IllegalArgumentException("minute value must be from 0 to 59");
        } else {
            ak akVar = new ak();
            List arrayList = new ArrayList();
            int i3 = i2 * 6;
            arrayList.add(new al(C4440a.HOUR, (i * 30) + ((i2 * 30) / 60), C4443d.POSITION, C4444e.PRESET, C4441b.CLOCKWISE, C4442c.FULL));
            arrayList.add(new al(C4440a.MINUTE, i3, C4443d.POSITION, C4444e.PRESET, C4441b.CLOCKWISE, C4442c.FULL));
            akVar.m14691c(new ArrayList());
            akVar.m14692d(arrayList);
            akVar.m14690b(8.0d);
            return akVar.m14687N();
        }
    }

    public static List<UAppInstruction> buildRingPhoneInstructions() {
        LogUtils.m15476d(TAG, "buildRingPhoneInstructions()");
        List arrayList = new ArrayList();
        arrayList.add(new aj());
        return arrayList;
    }

    public static List<UAppInstruction> buildWeatherInstructions(UAppWeatherConfiguration uAppWeatherConfiguration, float f) throws IllegalArgumentException {
        LogUtils.m15476d(TAG, "buildWeatherInstructions(weatherConfiguration: " + uAppWeatherConfiguration + ", temperature: " + f + ")");
        if (uAppWeatherConfiguration == null) {
            throw new IllegalArgumentException("weatherConfiguration must not be null.");
        }
        ak akVar = new ak();
        List arrayList = new ArrayList();
        arrayList.add(new al(C4440a.HOUR, uAppWeatherConfiguration.getStartPoint().angle, C4443d.POSITION, C4444e.PRESET, C4441b.SHORTEST_PATH, C4442c.FULL));
        arrayList.add(new al(C4440a.MINUTE, uAppWeatherConfiguration.getStartPoint().angle, C4443d.POSITION, C4444e.PRESET, C4441b.SHORTEST_PATH, C4442c.FULL));
        akVar.m14691c(arrayList);
        arrayList = new ArrayList();
        int a = m15253a(uAppWeatherConfiguration.getMinPoint(), uAppWeatherConfiguration.getMaxPoint(), uAppWeatherConfiguration.getStartPoint(), f);
        if (a != 0) {
            C4441b c4441b = a > 0 ? C4441b.CLOCKWISE : C4441b.COUNTER_CLOCKWISE;
            arrayList.add(new al(C4440a.HOUR, Math.abs(a), C4443d.DISTANCE, C4444e.PRESET, c4441b, C4442c.FULL));
            arrayList.add(new al(C4440a.MINUTE, Math.abs(a), C4443d.DISTANCE, C4444e.PRESET, c4441b, C4442c.FULL));
        }
        akVar.m14692d(arrayList);
        return akVar.m14687N();
    }

    public static List<UAppInstruction> buildErrorInstruction(UAppErrorInstructionType uAppErrorInstructionType) {
        Object obj;
        LogUtils.m15476d(TAG, "buildErrorInstruction(errorInstructionType: " + uAppErrorInstructionType + ")");
        switch (uAppErrorInstructionType) {
            case ETA:
                obj = null;
                break;
            default:
                obj = 1;
                break;
        }
        ak akVar = new ak();
        if (obj == null) {
            akVar.m14691c(new ArrayList());
        }
        akVar.m14688a(0.0d);
        akVar.m14689a(C4439a.ERROR);
        akVar.m14692d(new ArrayList());
        akVar.m14690b(0.0d);
        return akVar.m14687N();
    }

    private static int m15253a(AngleTemperaturePair angleTemperaturePair, AngleTemperaturePair angleTemperaturePair2, AngleTemperaturePair angleTemperaturePair3, float f) {
        int i;
        float f2;
        AngleTemperaturePair clone = angleTemperaturePair3.clone();
        AngleTemperaturePair clone2 = angleTemperaturePair.clone();
        AngleTemperaturePair clone3 = angleTemperaturePair2.clone();
        if (clone.angle > clone3.angle) {
            clone.angle -= 360;
            clone2.angle -= 360;
        }
        if (clone2.angle > clone.angle) {
            clone2.angle -= 360;
        }
        float max = Math.max(Math.min(f, clone3.temperature), clone2.temperature);
        if (max <= clone.temperature) {
            i = clone.angle - clone2.angle;
            f2 = clone.temperature - clone2.temperature;
        } else {
            i = clone3.angle - clone.angle;
            f2 = clone3.temperature - clone.temperature;
        }
        return Math.round((((float) i) / f2) * (max - clone.temperature));
    }
}
