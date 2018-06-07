package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream extends FilterInputStream {
    private volatile byte[] buf;
    private int count;
    private int marklimit;
    private int markpos = -1;
    private int pos;

    public static class InvalidMarkException extends RuntimeException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("buffer is null or empty");
        }
        this.buf = bArr;
    }

    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.buf == null || inputStream == null) {
            throw vQ();
        }
        return inputStream.available() + (this.count - this.pos);
    }

    private static IOException vQ() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void vR() {
        this.marklimit = this.buf.length;
    }

    public void close() throws IOException {
        this.buf = null;
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private int m2612a(InputStream inputStream, byte[] bArr) throws IOException {
        int read;
        if (this.markpos == -1 || this.pos - this.markpos >= this.marklimit) {
            read = inputStream.read(bArr);
            if (read <= 0) {
                return read;
            }
            this.markpos = -1;
            this.pos = 0;
            this.count = read;
            return read;
        }
        if (this.markpos == 0 && this.marklimit > bArr.length && this.count == bArr.length) {
            read = bArr.length * 2;
            if (read > this.marklimit) {
                read = this.marklimit;
            }
            if (Log.isLoggable("BufferedIs", 3)) {
                Log.d("BufferedIs", "allocate buffer of length: " + read);
            }
            Object obj = new byte[read];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            this.buf = obj;
            bArr = obj;
        } else if (this.markpos > 0) {
            System.arraycopy(bArr, this.markpos, bArr, 0, bArr.length - this.markpos);
        }
        this.pos -= this.markpos;
        this.markpos = 0;
        this.count = 0;
        int read2 = inputStream.read(bArr, this.pos, bArr.length - this.pos);
        this.count = read2 <= 0 ? this.pos : this.pos + read2;
        return read2;
    }

    public synchronized void mark(int i) {
        this.marklimit = Math.max(this.marklimit, i);
        this.markpos = this.pos;
    }

    public boolean markSupported() {
        return true;
    }

    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            byte[] bArr = this.buf;
            InputStream inputStream = this.in;
            if (bArr == null || inputStream == null) {
                throw vQ();
            }
            if (this.pos < this.count || m2612a(inputStream, bArr) != -1) {
                if (bArr != this.buf) {
                    bArr = this.buf;
                    if (bArr == null) {
                        throw vQ();
                    }
                }
                if (this.count - this.pos > 0) {
                    i = this.pos;
                    this.pos = i + 1;
                    i = bArr[i] & 255;
                }
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
        r6 = this;
        r0 = -1;
        monitor-enter(r6);
        r2 = r6.buf;	 Catch:{ all -> 0x000b }
        if (r2 != 0) goto L_0x000e;
    L_0x0006:
        r0 = vQ();	 Catch:{ all -> 0x000b }
        throw r0;	 Catch:{ all -> 0x000b }
    L_0x000b:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x000e:
        if (r9 != 0) goto L_0x0013;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        monitor-exit(r6);
        return r0;
    L_0x0013:
        r4 = r6.in;	 Catch:{ all -> 0x000b }
        if (r4 != 0) goto L_0x001c;
    L_0x0017:
        r0 = vQ();	 Catch:{ all -> 0x000b }
        throw r0;	 Catch:{ all -> 0x000b }
    L_0x001c:
        r1 = r6.pos;	 Catch:{ all -> 0x000b }
        r3 = r6.count;	 Catch:{ all -> 0x000b }
        if (r1 >= r3) goto L_0x0059;
    L_0x0022:
        r1 = r6.count;	 Catch:{ all -> 0x000b }
        r3 = r6.pos;	 Catch:{ all -> 0x000b }
        r1 = r1 - r3;
        if (r1 < r9) goto L_0x003e;
    L_0x0029:
        r1 = r9;
    L_0x002a:
        r3 = r6.pos;	 Catch:{ all -> 0x000b }
        java.lang.System.arraycopy(r2, r3, r7, r8, r1);	 Catch:{ all -> 0x000b }
        r3 = r6.pos;	 Catch:{ all -> 0x000b }
        r3 = r3 + r1;
        r6.pos = r3;	 Catch:{ all -> 0x000b }
        if (r1 == r9) goto L_0x003c;
    L_0x0036:
        r3 = r4.available();	 Catch:{ all -> 0x000b }
        if (r3 != 0) goto L_0x0044;
    L_0x003c:
        r0 = r1;
        goto L_0x0011;
    L_0x003e:
        r1 = r6.count;	 Catch:{ all -> 0x000b }
        r3 = r6.pos;	 Catch:{ all -> 0x000b }
        r1 = r1 - r3;
        goto L_0x002a;
    L_0x0044:
        r8 = r8 + r1;
        r3 = r9 - r1;
    L_0x0047:
        r1 = r6.markpos;	 Catch:{ all -> 0x000b }
        if (r1 != r0) goto L_0x005b;
    L_0x004b:
        r1 = r2.length;	 Catch:{ all -> 0x000b }
        if (r3 < r1) goto L_0x005b;
    L_0x004e:
        r1 = r4.read(r7, r8, r3);	 Catch:{ all -> 0x000b }
        if (r1 != r0) goto L_0x0085;
    L_0x0054:
        if (r3 == r9) goto L_0x0011;
    L_0x0056:
        r0 = r9 - r3;
        goto L_0x0011;
    L_0x0059:
        r3 = r9;
        goto L_0x0047;
    L_0x005b:
        r1 = r6.m2612a(r4, r2);	 Catch:{ all -> 0x000b }
        if (r1 != r0) goto L_0x0066;
    L_0x0061:
        if (r3 == r9) goto L_0x0011;
    L_0x0063:
        r0 = r9 - r3;
        goto L_0x0011;
    L_0x0066:
        r1 = r6.buf;	 Catch:{ all -> 0x000b }
        if (r2 == r1) goto L_0x0073;
    L_0x006a:
        r2 = r6.buf;	 Catch:{ all -> 0x000b }
        if (r2 != 0) goto L_0x0073;
    L_0x006e:
        r0 = vQ();	 Catch:{ all -> 0x000b }
        throw r0;	 Catch:{ all -> 0x000b }
    L_0x0073:
        r1 = r6.count;	 Catch:{ all -> 0x000b }
        r5 = r6.pos;	 Catch:{ all -> 0x000b }
        r1 = r1 - r5;
        if (r1 < r3) goto L_0x008a;
    L_0x007a:
        r1 = r3;
    L_0x007b:
        r5 = r6.pos;	 Catch:{ all -> 0x000b }
        java.lang.System.arraycopy(r2, r5, r7, r8, r1);	 Catch:{ all -> 0x000b }
        r5 = r6.pos;	 Catch:{ all -> 0x000b }
        r5 = r5 + r1;
        r6.pos = r5;	 Catch:{ all -> 0x000b }
    L_0x0085:
        r3 = r3 - r1;
        if (r3 != 0) goto L_0x0090;
    L_0x0088:
        r0 = r9;
        goto L_0x0011;
    L_0x008a:
        r1 = r6.count;	 Catch:{ all -> 0x000b }
        r5 = r6.pos;	 Catch:{ all -> 0x000b }
        r1 = r1 - r5;
        goto L_0x007b;
    L_0x0090:
        r5 = r4.available();	 Catch:{ all -> 0x000b }
        if (r5 != 0) goto L_0x009a;
    L_0x0096:
        r0 = r9 - r3;
        goto L_0x0011;
    L_0x009a:
        r8 = r8 + r1;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read(byte[], int, int):int");
    }

    public synchronized void reset() throws IOException {
        if (this.buf == null) {
            throw new IOException("Stream is closed");
        } else if (-1 == this.markpos) {
            throw new InvalidMarkException("Mark has been invalidated");
        } else {
            this.pos = this.markpos;
        }
    }

    public synchronized long skip(long j) throws IOException {
        byte[] bArr = this.buf;
        InputStream inputStream = this.in;
        if (bArr == null) {
            throw vQ();
        } else if (j < 1) {
            j = 0;
        } else if (inputStream == null) {
            throw vQ();
        } else if (((long) (this.count - this.pos)) >= j) {
            this.pos = (int) (((long) this.pos) + j);
        } else {
            long j2 = (long) (this.count - this.pos);
            this.pos = this.count;
            if (this.markpos == -1 || j > ((long) this.marklimit)) {
                j = j2 + inputStream.skip(j - j2);
            } else if (m2612a(inputStream, bArr) == -1) {
                j = j2;
            } else if (((long) (this.count - this.pos)) >= j - j2) {
                this.pos = (int) ((j - j2) + ((long) this.pos));
            } else {
                j = (j2 + ((long) this.count)) - ((long) this.pos);
                this.pos = this.count;
            }
        }
        return j;
    }
}
