package com.fossil;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class ux extends uq<InputStream> {
    protected /* synthetic */ Object mo4189a(AssetManager assetManager, String str) throws IOException {
        return m13853c(assetManager, str);
    }

    protected /* synthetic */ void bd(Object obj) throws IOException {
        m13854c((InputStream) obj);
    }

    public ux(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    protected InputStream m13853c(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    protected void m13854c(InputStream inputStream) throws IOException {
        inputStream.close();
    }
}
