package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.misfit.ble.setting.eventmapping.GoalTrackingEventMapping;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ImageHeaderParser {
    private static final byte[] aEg;
    private static final int[] aEh = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private final C1295b aEi;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        PNG_A(true),
        PNG(false),
        UNKNOWN(false);
        
        private final boolean hasAlpha;

        private ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    static class C1294a {
        private final ByteBuffer aEk;

        public C1294a(byte[] bArr) {
            this.aEk = ByteBuffer.wrap(bArr);
            this.aEk.order(ByteOrder.BIG_ENDIAN);
        }

        public void m2610a(ByteOrder byteOrder) {
            this.aEk.order(byteOrder);
        }

        public int length() {
            return this.aEk.array().length;
        }

        public int eK(int i) {
            return this.aEk.getInt(i);
        }

        public short eL(int i) {
            return this.aEk.getShort(i);
        }
    }

    static class C1295b {
        private final InputStream aEl;

        public C1295b(InputStream inputStream) {
            this.aEl = inputStream;
        }

        public int vN() throws IOException {
            return ((this.aEl.read() << 8) & 65280) | (this.aEl.read() & 255);
        }

        public short vO() throws IOException {
            return (short) (this.aEl.read() & 255);
        }

        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.aEl.skip(j2);
                if (skip > 0) {
                    j2 -= skip;
                } else if (this.aEl.read() == -1) {
                    break;
                } else {
                    j2--;
                }
            }
            return j - j2;
        }

        public int read(byte[] bArr) throws IOException {
            int length = bArr.length;
            while (length > 0) {
                int read = this.aEl.read(bArr, bArr.length - length, length);
                if (read == -1) {
                    break;
                }
                length -= read;
            }
            return bArr.length - length;
        }

        public int vP() throws IOException {
            return this.aEl.read();
        }
    }

    static {
        byte[] bArr = new byte[0];
        try {
            bArr = "Exif\u0000\u0000".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        aEg = bArr;
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.aEi = new C1295b(inputStream);
    }

    public boolean hasAlpha() throws IOException {
        return vL().hasAlpha();
    }

    public ImageType vL() throws IOException {
        int vN = this.aEi.vN();
        if (vN == 65496) {
            return ImageType.JPEG;
        }
        vN = ((vN << 16) & -65536) | (this.aEi.vN() & 65535);
        if (vN == -1991225785) {
            this.aEi.skip(21);
            return this.aEi.vP() >= 3 ? ImageType.PNG_A : ImageType.PNG;
        } else if ((vN >> 8) == 4671814) {
            return ImageType.GIF;
        } else {
            return ImageType.UNKNOWN;
        }
    }

    public int getOrientation() throws IOException {
        Object obj = null;
        if (!eJ(this.aEi.vN())) {
            return -1;
        }
        byte[] vM = vM();
        Object obj2 = (vM == null || vM.length <= aEg.length) ? null : 1;
        if (obj2 != null) {
            for (int i = 0; i < aEg.length; i++) {
                if (vM[i] != aEg[i]) {
                    break;
                }
            }
        }
        obj = obj2;
        if (obj != null) {
            return m2611a(new C1294a(vM));
        }
        return -1;
    }

    private byte[] vM() throws IOException {
        long skip;
        int vN;
        do {
            short vO;
            short vO2 = this.aEi.vO();
            if (vO2 == GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER) {
                vO = this.aEi.vO();
                if (vO == (short) 218) {
                    return null;
                }
                if (vO != (short) 217) {
                    vN = this.aEi.vN() - 2;
                    if (vO != (short) 225) {
                        skip = this.aEi.skip((long) vN);
                    } else {
                        byte[] bArr = new byte[vN];
                        int read = this.aEi.read(bArr);
                        if (read == vN) {
                            return bArr;
                        }
                        if (!Log.isLoggable("ImageHeaderParser", 3)) {
                            return null;
                        }
                        Log.d("ImageHeaderParser", "Unable to read segment data, type: " + vO + ", length: " + vN + ", actually read: " + read);
                        return null;
                    }
                } else if (!Log.isLoggable("ImageHeaderParser", 3)) {
                    return null;
                } else {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                    return null;
                }
            } else if (!Log.isLoggable("ImageHeaderParser", 3)) {
                return null;
            } else {
                Log.d("ImageHeaderParser", "Unknown segmentId=" + vO2);
                return null;
            }
        } while (skip == ((long) vN));
        if (!Log.isLoggable("ImageHeaderParser", 3)) {
            return null;
        }
        Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + vO + ", wanted to skip: " + vN + ", but actually skipped: " + skip);
        return null;
    }

    private static int m2611a(C1294a c1294a) {
        ByteOrder byteOrder;
        int length = "Exif\u0000\u0000".length();
        short eL = c1294a.eL(length);
        if (eL == (short) 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (eL == (short) 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + eL);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        c1294a.m2610a(byteOrder);
        length += c1294a.eK(length + 4);
        short eL2 = c1294a.eL(length);
        for (eL = (short) 0; eL < eL2; eL++) {
            int bd = bd(length, eL);
            short eL3 = c1294a.eL(bd);
            if (eL3 == (short) 274) {
                short eL4 = c1294a.eL(bd + 2);
                if (eL4 >= (short) 1 && eL4 <= (short) 12) {
                    int eK = c1294a.eK(bd + 4);
                    if (eK >= 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + eL + " tagType=" + eL3 + " formatCode=" + eL4 + " componentCount=" + eK);
                        }
                        eK += aEh[eL4];
                        if (eK <= 4) {
                            bd += 8;
                            if (bd < 0 || bd > c1294a.length()) {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + bd + " tagType=" + eL3);
                                }
                            } else if (eK >= 0 && bd + eK <= c1294a.length()) {
                                return c1294a.eL(bd);
                            } else {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + eL3);
                                }
                            }
                        } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + eL4);
                        }
                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Got invalid format code=" + eL4);
                }
            }
        }
        return -1;
    }

    private static int bd(int i, int i2) {
        return (i + 2) + (i2 * 12);
    }

    private static boolean eJ(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }
}
