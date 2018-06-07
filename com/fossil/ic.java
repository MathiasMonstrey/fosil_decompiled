package com.fossil;

import android.annotation.TargetApi;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import com.fossil.ib.C3692a;

@TargetApi(23)
class ic extends ib {

    static class C3693a extends C3692a {
        public static void m11740b(Object obj, Uri uri) {
            ((Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri m11741A(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
