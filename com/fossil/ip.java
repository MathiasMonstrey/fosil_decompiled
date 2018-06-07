package com.fossil;

import android.annotation.TargetApi;
import android.media.session.PlaybackState;
import android.media.session.PlaybackState.CustomAction;
import android.os.Bundle;
import java.util.List;

@TargetApi(21)
class ip {

    static final class C3733a {
        public static String m11837X(Object obj) {
            return ((CustomAction) obj).getAction();
        }

        public static CharSequence m11838Y(Object obj) {
            return ((CustomAction) obj).getName();
        }

        public static int m11839Z(Object obj) {
            return ((CustomAction) obj).getIcon();
        }

        public static Bundle m11840y(Object obj) {
            return ((CustomAction) obj).getExtras();
        }
    }

    public static int m11841O(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static long m11842P(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static long m11843Q(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static float m11844R(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long m11845S(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static CharSequence m11846T(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long m11847U(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static List<Object> m11848V(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static long m11849W(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }
}
