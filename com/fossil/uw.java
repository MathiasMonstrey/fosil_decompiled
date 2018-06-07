package com.fossil;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class uw<T> implements us<T> {
    private final Context context;
    private T data;
    private final Uri uri;

    protected abstract T mo4191b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    protected abstract void bd(T t) throws IOException;

    public uw(Context context, Uri uri) {
        this.context = context.getApplicationContext();
        this.uri = uri;
    }

    public final T mo4186d(Priority priority) throws Exception {
        this.data = mo4191b(this.uri, this.context.getContentResolver());
        return this.data;
    }

    public void lG() {
        if (this.data != null) {
            try {
                bd(this.data);
            } catch (Throwable e) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", e);
                }
            }
        }
    }

    public void cancel() {
    }

    public String getId() {
        return this.uri.toString();
    }
}
