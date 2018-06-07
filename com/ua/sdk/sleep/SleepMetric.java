package com.ua.sdk.sleep;

import android.os.Parcelable;
import com.fossil.ecb;
import com.fossil.ece;

public interface SleepMetric extends ecb<ece<SleepMetric>> {

    public enum State {
        AWAKE(1),
        LIGHT_SLEEP(2),
        DEEP_SLEEP(3);
        
        public final int value;

        private State(int i) {
            this.value = i;
        }

        public static final State getState(int i) {
            if (i == AWAKE.value) {
                return AWAKE;
            }
            if (i == LIGHT_SLEEP.value) {
                return LIGHT_SLEEP;
            }
            if (i == DEEP_SLEEP.value) {
                return DEEP_SLEEP;
            }
            return null;
        }
    }

    public interface C5078a extends Parcelable {
    }

    public interface C5079b extends Parcelable {
    }
}
