package com.fossil;

import android.annotation.TargetApi;
import android.media.session.MediaSession.QueueItem;
import android.media.session.MediaSession.Token;

@TargetApi(21)
class im {

    static class C3728a {
        public static Object m11829K(Object obj) {
            return ((QueueItem) obj).getDescription();
        }

        public static long m11830L(Object obj) {
            return ((QueueItem) obj).getQueueId();
        }
    }

    public static Object m11831J(Object obj) {
        if (obj instanceof Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}
