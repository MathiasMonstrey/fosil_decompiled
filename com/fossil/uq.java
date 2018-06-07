package com.fossil;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;

public abstract class uq<T> implements us<T> {
    private final String aBf;
    private final AssetManager aBg;
    private T data;

    protected abstract T mo4189a(AssetManager assetManager, String str) throws IOException;

    protected abstract void bd(T t) throws IOException;

    public uq(AssetManager assetManager, String str) {
        this.aBg = assetManager;
        this.aBf = str;
    }

    public T mo4186d(Priority priority) throws Exception {
        this.data = mo4189a(this.aBg, this.aBf);
        return this.data;
    }

    public void lG() {
        if (this.data != null) {
            try {
                bd(this.data);
            } catch (Throwable e) {
                if (Log.isLoggable("AssetUriFetcher", 2)) {
                    Log.v("AssetUriFetcher", "Failed to close data", e);
                }
            }
        }
    }

    public String getId() {
        return this.aBf;
    }

    public void cancel() {
    }
}
