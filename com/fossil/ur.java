package com.fossil;

import com.bumptech.glide.Priority;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ur implements us<InputStream> {
    private final byte[] bytes;
    private final String id;

    public /* synthetic */ Object mo4186d(Priority priority) throws Exception {
        return m13837e(priority);
    }

    public ur(byte[] bArr, String str) {
        this.bytes = bArr;
        this.id = str;
    }

    public InputStream m13837e(Priority priority) {
        return new ByteArrayInputStream(this.bytes);
    }

    public void lG() {
    }

    public String getId() {
        return this.id;
    }

    public void cancel() {
    }
}
