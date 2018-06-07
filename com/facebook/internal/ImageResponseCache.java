package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache.Limits;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

class ImageResponseCache {
    static final String TAG = ImageResponseCache.class.getSimpleName();
    private static volatile FileLruCache imageCache;

    static class BufferedHttpInputStream extends BufferedInputStream {
        HttpURLConnection connection;

        BufferedHttpInputStream(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            this.connection = httpURLConnection;
        }

        public void close() throws IOException {
            super.close();
            Utility.disconnectQuietly(this.connection);
        }
    }

    ImageResponseCache() {
    }

    static synchronized FileLruCache getCache(Context context) throws IOException {
        FileLruCache fileLruCache;
        synchronized (ImageResponseCache.class) {
            if (imageCache == null) {
                imageCache = new FileLruCache(TAG, new Limits());
            }
            fileLruCache = imageCache;
        }
        return fileLruCache;
    }

    static InputStream getCachedImageStream(Uri uri, Context context) {
        InputStream inputStream = null;
        if (uri != null && isCDNURL(uri)) {
            try {
                inputStream = getCache(context).get(uri.toString());
            } catch (IOException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, e.toString());
            }
        }
        return inputStream;
    }

    static InputStream interceptAndCacheImageStream(Context context, HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        if (httpURLConnection.getResponseCode() == MFNetworkReturnCode.RESPONSE_OK) {
            Uri parse = Uri.parse(httpURLConnection.getURL().toString());
            inputStream = httpURLConnection.getInputStream();
            try {
                if (isCDNURL(parse)) {
                    inputStream = getCache(context).interceptAndPut(parse.toString(), new BufferedHttpInputStream(inputStream, httpURLConnection));
                }
            } catch (IOException e) {
            }
        }
        return inputStream;
    }

    private static boolean isCDNURL(Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (host.endsWith("fbcdn.net")) {
                return true;
            }
            if (host.startsWith("fbcdn") && host.endsWith("akamaihd.net")) {
                return true;
            }
        }
        return false;
    }

    static void clearCache(Context context) {
        try {
            getCache(context).clearCache();
        } catch (IOException e) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + e.getMessage());
        }
    }
}
