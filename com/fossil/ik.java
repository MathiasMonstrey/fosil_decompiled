package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.MediaSession.Token;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.ResultReceiver;
import java.util.List;

@TargetApi(21)
class ik {

    public interface C3702a {
        void mo3225C(Object obj);

        void mo3226D(Object obj);

        void mo3227b(int i, int i2, int i3, int i4, int i5);

        void onExtrasChanged(Bundle bundle);

        void onQueueChanged(List<?> list);

        void onQueueTitleChanged(CharSequence charSequence);

        void onSessionDestroyed();

        void onSessionEvent(String str, Bundle bundle);
    }

    static class C3720b<T extends C3702a> extends Callback {
        protected final T OV;

        public C3720b(T t) {
            this.OV = t;
        }

        public void onSessionDestroyed() {
            this.OV.onSessionDestroyed();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            this.OV.onSessionEvent(str, bundle);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.OV.mo3225C(playbackState);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.OV.mo3226D(mediaMetadata);
        }

        public void onQueueChanged(List<QueueItem> list) {
            this.OV.onQueueChanged(list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.OV.onQueueTitleChanged(charSequence);
        }

        public void onExtrasChanged(Bundle bundle) {
            this.OV.onExtrasChanged(bundle);
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
            this.OV.mo3227b(playbackInfo.getPlaybackType(), C3721c.m11814G(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }

    public static class C3721c {
        public static AudioAttributes m11813F(Object obj) {
            return ((PlaybackInfo) obj).getAudioAttributes();
        }

        public static int m11814G(Object obj) {
            return C3721c.m11815a(C3721c.m11813F(obj));
        }

        private static int m11815a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 1:
                case 11:
                case 12:
                case 14:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }
    }

    public static Object m11817a(Context context, Object obj) {
        return new MediaController(context, (Token) obj);
    }

    public static Object m11818a(C3702a c3702a) {
        return new C3720b(c3702a);
    }

    public static void m11819a(Activity activity, Object obj) {
        activity.setMediaController((MediaController) obj);
    }

    public static Object m11821m(Activity activity) {
        return activity.getMediaController();
    }

    public static Object m11816E(Object obj) {
        return ((MediaController) obj).getSessionToken();
    }

    public static void m11820a(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }
}
