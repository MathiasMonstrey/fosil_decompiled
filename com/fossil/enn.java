package com.fossil;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class enn implements Closeable {
    private static final Logger bUq = Logger.getLogger(enn.class.getName());
    private final byte[] buffer = new byte[16];
    private final RandomAccessFile dOe;
    int dOf;
    private C3479a dOg;
    private C3479a dOh;
    private int elementCount;

    public interface C1611c {
        void mo834a(InputStream inputStream, int i) throws IOException;
    }

    static class C3479a {
        static final C3479a dOk = new C3479a(0, 0);
        final int length;
        final int position;

        C3479a(int i, int i2) {
            this.position = i;
            this.length = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[" + "position = " + this.position + ", length = " + this.length + "]";
        }
    }

    final class C3480b extends InputStream {
        private int aAB;
        final /* synthetic */ enn dOj;
        private int position;

        private C3480b(enn com_fossil_enn, C3479a c3479a) {
            this.dOj = com_fossil_enn;
            this.position = com_fossil_enn.pe(c3479a.position + 4);
            this.aAB = c3479a.length;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            enn.m10974g(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (this.aAB <= 0) {
                return -1;
            } else {
                if (i2 > this.aAB) {
                    i2 = this.aAB;
                }
                this.dOj.m10972b(this.position, bArr, i, i2);
                this.position = this.dOj.pe(this.position + i2);
                this.aAB -= i2;
                return i2;
            }
        }

        public int read() throws IOException {
            if (this.aAB == 0) {
                return -1;
            }
            this.dOj.dOe.seek((long) this.position);
            int read = this.dOj.dOe.read();
            this.position = this.dOj.pe(this.position + 1);
            this.aAB--;
            return read;
        }
    }

    public enn(File file) throws IOException {
        if (!file.exists()) {
            m10965A(file);
        }
        this.dOe = m10966B(file);
        ur();
    }

    private static void m10976k(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void m10971a(byte[] bArr, int... iArr) {
        int i = 0;
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            m10976k(bArr, i2, iArr[i]);
            i2 += 4;
            i++;
        }
    }

    private static int m10973e(byte[] bArr, int i) {
        return ((((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16)) + ((bArr[i + 2] & 255) << 8)) + (bArr[i + 3] & 255);
    }

    private void ur() throws IOException {
        this.dOe.seek(0);
        this.dOe.readFully(this.buffer);
        this.dOf = m10973e(this.buffer, 0);
        if (((long) this.dOf) > this.dOe.length()) {
            throw new IOException("File is truncated. Expected length: " + this.dOf + ", Actual length: " + this.dOe.length());
        }
        this.elementCount = m10973e(this.buffer, 4);
        int e = m10973e(this.buffer, 8);
        int e2 = m10973e(this.buffer, 12);
        this.dOg = pd(e);
        this.dOh = pd(e2);
    }

    private void m10964A(int i, int i2, int i3, int i4) throws IOException {
        m10971a(this.buffer, i, i2, i3, i4);
        this.dOe.seek(0);
        this.dOe.write(this.buffer);
    }

    private C3479a pd(int i) throws IOException {
        if (i == 0) {
            return C3479a.dOk;
        }
        this.dOe.seek((long) i);
        return new C3479a(i, this.dOe.readInt());
    }

    private static void m10965A(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile B = m10966B(file2);
        try {
            B.setLength(4096);
            B.seek(0);
            byte[] bArr = new byte[16];
            m10971a(bArr, 4096, 0, 0, 0);
            B.write(bArr);
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } finally {
            B.close();
        }
    }

    private static RandomAccessFile m10966B(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private int pe(int i) {
        return i < this.dOf ? i : (i + 16) - this.dOf;
    }

    private void m10969a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int pe = pe(i);
        if (pe + i3 <= this.dOf) {
            this.dOe.seek((long) pe);
            this.dOe.write(bArr, i2, i3);
            return;
        }
        int i4 = this.dOf - pe;
        this.dOe.seek((long) pe);
        this.dOe.write(bArr, i2, i4);
        this.dOe.seek(16);
        this.dOe.write(bArr, i2 + i4, i3 - i4);
    }

    private void m10972b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int pe = pe(i);
        if (pe + i3 <= this.dOf) {
            this.dOe.seek((long) pe);
            this.dOe.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.dOf - pe;
        this.dOe.seek((long) pe);
        this.dOe.readFully(bArr, i2, i4);
        this.dOe.seek(16);
        this.dOe.readFully(bArr, i2 + i4, i3 - i4);
    }

    public void av(byte[] bArr) throws IOException {
        m10978l(bArr, 0, bArr.length);
    }

    public synchronized void m10978l(byte[] bArr, int i, int i2) throws IOException {
        m10974g(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int i3;
        pf(i2);
        boolean isEmpty = isEmpty();
        if (isEmpty) {
            i3 = 16;
        } else {
            i3 = pe((this.dOh.position + 4) + this.dOh.length);
        }
        C3479a c3479a = new C3479a(i3, i2);
        m10976k(this.buffer, 0, i2);
        m10969a(c3479a.position, this.buffer, 0, 4);
        m10969a(c3479a.position + 4, bArr, i, i2);
        m10964A(this.dOf, this.elementCount + 1, isEmpty ? c3479a.position : this.dOg.position, c3479a.position);
        this.dOh = c3479a;
        this.elementCount++;
        if (isEmpty) {
            this.dOg = this.dOh;
        }
    }

    public int aFC() {
        if (this.elementCount == 0) {
            return 16;
        }
        if (this.dOh.position >= this.dOg.position) {
            return (((this.dOh.position - this.dOg.position) + 4) + this.dOh.length) + 16;
        }
        return (((this.dOh.position + 4) + this.dOh.length) + this.dOf) - this.dOg.position;
    }

    private int aFD() {
        return this.dOf - aFC();
    }

    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    private void pf(int i) throws IOException {
        int i2 = i + 4;
        int aFD = aFD();
        if (aFD < i2) {
            int i3 = this.dOf;
            do {
                aFD += i3;
                i3 <<= 1;
            } while (aFD < i2);
            setLength(i3);
            i2 = pe((this.dOh.position + 4) + this.dOh.length);
            if (i2 < this.dOg.position) {
                FileChannel channel = this.dOe.getChannel();
                channel.position((long) this.dOf);
                int i4 = i2 - 4;
                if (channel.transferTo(16, (long) i4, channel) != ((long) i4)) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.dOh.position < this.dOg.position) {
                aFD = (this.dOf + this.dOh.position) - 16;
                m10964A(i3, this.elementCount, this.dOg.position, aFD);
                this.dOh = new C3479a(aFD, this.dOh.length);
            } else {
                m10964A(i3, this.elementCount, this.dOg.position, this.dOh.position);
            }
            this.dOf = i3;
        }
    }

    private void setLength(int i) throws IOException {
        this.dOe.setLength((long) i);
        this.dOe.getChannel().force(true);
    }

    public synchronized void m10977a(C1611c c1611c) throws IOException {
        int i = this.dOg.position;
        for (int i2 = 0; i2 < this.elementCount; i2++) {
            C3479a pd = pd(i);
            c1611c.mo834a(new C3480b(pd), pd.length);
            i = pe(pd.length + (pd.position + 4));
        }
    }

    private static <T> T m10974g(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public synchronized void remove() throws IOException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (this.elementCount == 1) {
            clear();
        } else {
            int pe = pe((this.dOg.position + 4) + this.dOg.length);
            m10972b(pe, this.buffer, 0, 4);
            int e = m10973e(this.buffer, 0);
            m10964A(this.dOf, this.elementCount - 1, pe, this.dOh.position);
            this.elementCount--;
            this.dOg = new C3479a(pe, e);
        }
    }

    public synchronized void clear() throws IOException {
        m10964A(4096, 0, 0, 0);
        this.elementCount = 0;
        this.dOg = C3479a.dOk;
        this.dOh = C3479a.dOk;
        if (this.dOf > 4096) {
            setLength(4096);
        }
        this.dOf = 4096;
    }

    public synchronized void close() throws IOException {
        this.dOe.close();
    }

    public boolean cq(int i, int i2) {
        return (aFC() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append('[');
        stringBuilder.append("fileLength=").append(this.dOf);
        stringBuilder.append(", size=").append(this.elementCount);
        stringBuilder.append(", first=").append(this.dOg);
        stringBuilder.append(", last=").append(this.dOh);
        stringBuilder.append(", element lengths=[");
        try {
            m10977a(new C1611c(this) {
                final /* synthetic */ enn dOj;
                boolean first = true;

                public void mo834a(InputStream inputStream, int i) throws IOException {
                    if (this.first) {
                        this.first = false;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(i);
                }
            });
        } catch (Throwable e) {
            bUq.log(Level.WARNING, "read error", e);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
