package com.facebook.internal;

import android.net.Uri;
import android.support.v8.renderscript.Allocation;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache.Limits;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class UrlRedirectCache {
    private static final String REDIRECT_CONTENT_TAG = (TAG + "_Redirect");
    static final String TAG = UrlRedirectCache.class.getSimpleName();
    private static volatile FileLruCache urlRedirectCache;

    UrlRedirectCache() {
    }

    static synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            if (urlRedirectCache == null) {
                urlRedirectCache = new FileLruCache(TAG, new Limits());
            }
            fileLruCache = urlRedirectCache;
        }
        return fileLruCache;
    }

    static Uri getRedirectedUri(Uri uri) {
        Closeable inputStreamReader;
        Throwable th;
        Uri uri2 = null;
        Object obj = null;
        if (uri != null) {
            String uri3 = uri.toString();
            try {
                FileLruCache cache = getCache();
                String str = uri3;
                Closeable closeable = uri2;
                while (true) {
                    try {
                        InputStream inputStream = cache.get(str, REDIRECT_CONTENT_TAG);
                        if (inputStream == null) {
                            break;
                        }
                        inputStreamReader = new InputStreamReader(inputStream);
                        try {
                            char[] cArr = new char[Allocation.USAGE_SHARED];
                            StringBuilder stringBuilder = new StringBuilder();
                            while (true) {
                                int read = inputStreamReader.read(cArr, 0, cArr.length);
                                if (read <= 0) {
                                    break;
                                }
                                stringBuilder.append(cArr, 0, read);
                            }
                            Utility.closeQuietly(inputStreamReader);
                            str = stringBuilder.toString();
                            closeable = inputStreamReader;
                            int i = 1;
                        } catch (IOException e) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (IOException e2) {
                        inputStreamReader = closeable;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = closeable;
                    }
                }
                if (obj != null) {
                    uri2 = Uri.parse(str);
                    Utility.closeQuietly(closeable);
                } else {
                    Utility.closeQuietly(closeable);
                }
            } catch (IOException e3) {
                obj = uri2;
                Utility.closeQuietly(inputStreamReader);
                return uri2;
            } catch (Throwable th4) {
                Throwable th5 = th4;
                inputStreamReader = uri2;
                th = th5;
                Utility.closeQuietly(inputStreamReader);
                throw th;
            }
        }
        return uri2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void cacheUriRedirect(android.net.Uri r5, android.net.Uri r6) {
        /*
        if (r5 == 0) goto L_0x0004;
    L_0x0002:
        if (r6 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 0;
        r1 = getCache();	 Catch:{ IOException -> 0x0023, all -> 0x0028 }
        r2 = r5.toString();	 Catch:{ IOException -> 0x0023, all -> 0x0028 }
        r3 = REDIRECT_CONTENT_TAG;	 Catch:{ IOException -> 0x0023, all -> 0x0028 }
        r0 = r1.openPutStream(r2, r3);	 Catch:{ IOException -> 0x0023, all -> 0x0028 }
        r1 = r6.toString();	 Catch:{ IOException -> 0x0023, all -> 0x0030 }
        r1 = r1.getBytes();	 Catch:{ IOException -> 0x0023, all -> 0x0030 }
        r0.write(r1);	 Catch:{ IOException -> 0x0023, all -> 0x0030 }
        com.facebook.internal.Utility.closeQuietly(r0);
        goto L_0x0004;
    L_0x0023:
        r1 = move-exception;
        com.facebook.internal.Utility.closeQuietly(r0);
        goto L_0x0004;
    L_0x0028:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x002c:
        com.facebook.internal.Utility.closeQuietly(r1);
        throw r0;
    L_0x0030:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.UrlRedirectCache.cacheUriRedirect(android.net.Uri, android.net.Uri):void");
    }

    static void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + e.getMessage());
        }
    }
}
