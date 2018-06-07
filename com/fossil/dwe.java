package com.fossil;

import com.fossil.dvy.C3238a;
import com.fossil.dwd.C3255a;
import com.fossil.dwd.C3256b;
import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.HeadersMode;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;

public final class dwe implements dwm {
    private static final ByteString dys = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final Logger logger = Logger.getLogger(C3258b.class.getName());

    static final class C3257a implements etv {
        private final etj dyk;
        byte dyt;
        int dyu;
        short dyv;
        int left;
        int length;

        public C3257a(etj com_fossil_etj) {
            this.dyk = com_fossil_etj;
        }

        public long mo2733b(eth com_fossil_eth, long j) throws IOException {
            while (this.left == 0) {
                this.dyk.bh((long) this.dyv);
                this.dyv = (short) 0;
                if ((this.dyt & 4) != 0) {
                    return -1;
                }
                aAw();
            }
            long b = this.dyk.mo2733b(com_fossil_eth, Math.min(j, (long) this.left));
            if (b == -1) {
                return -1;
            }
            this.left = (int) (((long) this.left) - b);
            return b;
        }

        public etw aAf() {
            return this.dyk.aAf();
        }

        public void close() throws IOException {
        }

        private void aAw() throws IOException {
            int i = this.dyu;
            int b = dwe.m10119a(this.dyk);
            this.left = b;
            this.length = b;
            byte readByte = (byte) (this.dyk.readByte() & 255);
            this.dyt = (byte) (this.dyk.readByte() & 255);
            if (dwe.logger.isLoggable(Level.FINE)) {
                dwe.logger.fine(C3258b.m10090a(true, this.dyu, this.length, readByte, this.dyt));
            }
            this.dyu = this.dyk.readInt() & Integer.MAX_VALUE;
            if (readByte != (byte) 9) {
                throw dwe.m10125c("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (this.dyu != i) {
                throw dwe.m10125c("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static final class C3258b {
        private static final String[] TYPES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        private static final String[] dyw = new String[64];
        private static final String[] dyx = new String[256];

        C3258b() {
        }

        static String m10090a(boolean z, int i, int i2, byte b, byte b2) {
            String format = b < TYPES.length ? TYPES[b] : String.format("0x%02x", new Object[]{Byte.valueOf(b)});
            String a = C3258b.m10089a(b, b2);
            String str = "%s 0x%08x %5d %-13s %s";
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = format;
            objArr[4] = a;
            return String.format(str, objArr);
        }

        static String m10089a(byte b, byte b2) {
            if (b2 == (byte) 0) {
                return "";
            }
            switch (b) {
                case (byte) 2:
                case (byte) 3:
                case (byte) 7:
                case (byte) 8:
                    return dyx[b2];
                case (byte) 4:
                case (byte) 6:
                    return b2 == (byte) 1 ? "ACK" : dyx[b2];
                default:
                    String str = b2 < dyw.length ? dyw[b2] : dyx[b2];
                    if (b == (byte) 5 && (b2 & 4) != 0) {
                        return str.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (b != (byte) 0 || (b2 & 32) == 0) {
                        return str;
                    }
                    return str.replace("PRIORITY", "COMPRESSED");
            }
        }

        static {
            int i = 0;
            for (int i2 = 0; i2 < dyx.length; i2++) {
                dyx[i2] = String.format("%8s", new Object[]{Integer.toBinaryString(i2)}).replace(' ', '0');
            }
            dyw[0] = "";
            dyw[1] = "END_STREAM";
            int[] iArr = new int[]{1};
            dyw[8] = "PADDED";
            for (int i3 : iArr) {
                dyw[i3 | 8] = dyw[i3] + "|PADDED";
            }
            dyw[4] = "END_HEADERS";
            dyw[32] = "PRIORITY";
            dyw[36] = "END_HEADERS|PRIORITY";
            for (int i4 : new int[]{4, 32, 36}) {
                for (int i5 : iArr) {
                    dyw[i5 | i4] = dyw[i5] + '|' + dyw[i4];
                    dyw[(i5 | i4) | 8] = dyw[i5] + '|' + dyw[i4] + "|PADDED";
                }
            }
            while (i < dyw.length) {
                if (dyw[i] == null) {
                    dyw[i] = dyx[i];
                }
                i++;
            }
        }
    }

    static final class C3259c implements dvy {
        private final boolean dwY;
        private final etj dyk;
        private final C3257a dyy = new C3257a(this.dyk);
        final C3255a dyz;

        C3259c(etj com_fossil_etj, int i, boolean z) {
            this.dyk = com_fossil_etj;
            this.dwY = z;
            this.dyz = new C3255a(i, this.dyy);
        }

        public void azP() throws IOException {
            if (!this.dwY) {
                ByteString bd = this.dyk.bd((long) dwe.dys.size());
                if (dwe.logger.isLoggable(Level.FINE)) {
                    dwe.logger.fine(String.format("<< CONNECTION %s", new Object[]{bd.hex()}));
                }
                if (!dwe.dys.equals(bd)) {
                    throw dwe.m10125c("Expected a connection header but was %s", bd.utf8());
                }
            }
        }

        public boolean mo2737a(C3238a c3238a) throws IOException {
            try {
                this.dyk.bb(9);
                int b = dwe.m10119a(this.dyk);
                if (b < 0 || b > 16384) {
                    throw dwe.m10125c("FRAME_SIZE_ERROR: %s", Integer.valueOf(b));
                }
                byte readByte = (byte) (this.dyk.readByte() & 255);
                byte readByte2 = (byte) (this.dyk.readByte() & 255);
                int readInt = this.dyk.readInt() & Integer.MAX_VALUE;
                if (dwe.logger.isLoggable(Level.FINE)) {
                    dwe.logger.fine(C3258b.m10090a(true, readInt, b, readByte, readByte2));
                }
                switch (readByte) {
                    case (byte) 0:
                        m10094b(c3238a, b, readByte2, readInt);
                        return true;
                    case (byte) 1:
                        m10093a(c3238a, b, readByte2, readInt);
                        return true;
                    case (byte) 2:
                        m10095c(c3238a, b, readByte2, readInt);
                        return true;
                    case (byte) 3:
                        m10096d(c3238a, b, readByte2, readInt);
                        return true;
                    case (byte) 4:
                        m10097e(c3238a, b, readByte2, readInt);
                        return true;
                    case (byte) 5:
                        m10098f(c3238a, b, readByte2, readInt);
                        return true;
                    case (byte) 6:
                        m10099g(c3238a, b, readByte2, readInt);
                        return true;
                    case (byte) 7:
                        m10100h(c3238a, b, readByte2, readInt);
                        return true;
                    case (byte) 8:
                        m10101i(c3238a, b, readByte2, readInt);
                        return true;
                    default:
                        this.dyk.bh((long) b);
                        return true;
                }
            } catch (IOException e) {
                return false;
            }
        }

        private void m10093a(C3238a c3238a, int i, byte b, int i2) throws IOException {
            if (i2 == 0) {
                throw dwe.m10125c("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            short readByte;
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                readByte = (short) (this.dyk.readByte() & 255);
            } else {
                readByte = (short) 0;
            }
            if ((b & 32) != 0) {
                m10092a(c3238a, i2);
                i -= 5;
            }
            c3238a.mo2722a(false, z, i2, -1, m10091a(dwe.m10118a(i, b, readByte), readByte, b, i2), HeadersMode.HTTP_20_HEADERS);
        }

        private List<dwc> m10091a(int i, short s, byte b, int i2) throws IOException {
            C3257a c3257a = this.dyy;
            this.dyy.left = i;
            c3257a.length = i;
            this.dyy.dyv = s;
            this.dyy.dyt = b;
            this.dyy.dyu = i2;
            this.dyz.aAo();
            return this.dyz.aAp();
        }

        private void m10094b(C3238a c3238a, int i, byte b, int i2) throws IOException {
            boolean z;
            short s = (short) 1;
            short s2 = (short) 0;
            if ((b & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((b & 32) == 0) {
                s = (short) 0;
            }
            if (s != (short) 0) {
                throw dwe.m10125c("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            if ((b & 8) != 0) {
                s2 = (short) (this.dyk.readByte() & 255);
            }
            c3238a.mo2720a(z, i2, this.dyk, dwe.m10118a(i, b, s2));
            this.dyk.bh((long) s2);
        }

        private void m10095c(C3238a c3238a, int i, byte b, int i2) throws IOException {
            if (i != 5) {
                throw dwe.m10125c("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            } else if (i2 == 0) {
                throw dwe.m10125c("TYPE_PRIORITY streamId == 0", new Object[0]);
            } else {
                m10092a(c3238a, i2);
            }
        }

        private void m10092a(C3238a c3238a, int i) throws IOException {
            int readInt = this.dyk.readInt();
            c3238a.mo2724b(i, readInt & Integer.MAX_VALUE, (this.dyk.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
        }

        private void m10096d(C3238a c3238a, int i, byte b, int i2) throws IOException {
            if (i != 4) {
                throw dwe.m10125c("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            } else if (i2 == 0) {
                throw dwe.m10125c("TYPE_RST_STREAM streamId == 0", new Object[0]);
            } else {
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(this.dyk.readInt());
                if (fromHttp2 == null) {
                    throw dwe.m10125c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(r0));
                } else {
                    c3238a.mo2718a(i2, fromHttp2);
                }
            }
        }

        private void m10097e(C3238a c3238a, int i, byte b, int i2) throws IOException {
            if (i2 != 0) {
                throw dwe.m10125c("TYPE_SETTINGS streamId != 0", new Object[0]);
            } else if ((b & 1) != 0) {
                if (i != 0) {
                    throw dwe.m10125c("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                c3238a.azQ();
            } else if (i % 6 != 0) {
                throw dwe.m10125c("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            } else {
                dwk com_fossil_dwk = new dwk();
                for (int i3 = 0; i3 < i; i3 += 6) {
                    int readShort = this.dyk.readShort();
                    int readInt = this.dyk.readInt();
                    switch (readShort) {
                        case 1:
                        case 6:
                            break;
                        case 2:
                            if (!(readInt == 0 || readInt == 1)) {
                                throw dwe.m10125c("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            }
                        case 3:
                            readShort = 4;
                            break;
                        case 4:
                            readShort = 7;
                            if (readInt >= 0) {
                                break;
                            }
                            throw dwe.m10125c("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        case 5:
                            if (readInt >= 16384 && readInt <= 16777215) {
                                break;
                            }
                            throw dwe.m10125c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        default:
                            throw dwe.m10125c("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(readShort));
                    }
                    com_fossil_dwk.m10148J(readShort, 0, readInt);
                }
                c3238a.mo2721a(false, com_fossil_dwk);
                if (com_fossil_dwk.aAB() >= 0) {
                    this.dyz.mG(com_fossil_dwk.aAB());
                }
            }
        }

        private void m10098f(C3238a c3238a, int i, byte b, int i2) throws IOException {
            short s = (short) 0;
            if (i2 == 0) {
                throw dwe.m10125c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            if ((b & 8) != 0) {
                s = (short) (this.dyk.readByte() & 255);
            }
            c3238a.mo2725b(i2, this.dyk.readInt() & Integer.MAX_VALUE, m10091a(dwe.m10118a(i - 4, b, s), s, b, i2));
        }

        private void m10099g(C3238a c3238a, int i, byte b, int i2) throws IOException {
            boolean z = true;
            if (i != 8) {
                throw dwe.m10125c("TYPE_PING length != 8: %s", Integer.valueOf(i));
            } else if (i2 != 0) {
                throw dwe.m10125c("TYPE_PING streamId != 0", new Object[0]);
            } else {
                int readInt = this.dyk.readInt();
                int readInt2 = this.dyk.readInt();
                if ((b & 1) == 0) {
                    z = false;
                }
                c3238a.mo2726c(z, readInt, readInt2);
            }
        }

        private void m10100h(C3238a c3238a, int i, byte b, int i2) throws IOException {
            if (i < 8) {
                throw dwe.m10125c("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            } else if (i2 != 0) {
                throw dwe.m10125c("TYPE_GOAWAY streamId != 0", new Object[0]);
            } else {
                int readInt = this.dyk.readInt();
                int i3 = i - 8;
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(this.dyk.readInt());
                if (fromHttp2 == null) {
                    throw dwe.m10125c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(r0));
                }
                ByteString byteString = ByteString.EMPTY;
                if (i3 > 0) {
                    byteString = this.dyk.bd((long) i3);
                }
                c3238a.mo2719a(readInt, fromHttp2, byteString);
            }
        }

        private void m10101i(C3238a c3238a, int i, byte b, int i2) throws IOException {
            if (i != 4) {
                throw dwe.m10125c("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            }
            long readInt = ((long) this.dyk.readInt()) & 2147483647L;
            if (readInt == 0) {
                throw dwe.m10125c("windowSizeIncrement was 0", Long.valueOf(readInt));
            } else {
                c3238a.mo2727k(i2, readInt);
            }
        }

        public void close() throws IOException {
            this.dyk.close();
        }
    }

    static final class C3260d implements dvz {
        private boolean closed;
        private final boolean dwY;
        private final eti dyA;
        private final eth dyB = new eth();
        private final C3256b dyC = new C3256b(this.dyB);
        private int dyD = 16384;

        C3260d(eti com_fossil_eti, boolean z) {
            this.dyA = com_fossil_eti;
            this.dwY = z;
        }

        public synchronized void flush() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.dyA.flush();
        }

        public synchronized void mo2741a(dwk com_fossil_dwk) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.dyD = com_fossil_dwk.mQ(this.dyD);
            m10105a(0, 0, (byte) 4, (byte) 1);
            this.dyA.flush();
        }

        public synchronized void azR() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (this.dwY) {
                if (dwe.logger.isLoggable(Level.FINE)) {
                    dwe.logger.fine(String.format(">> CONNECTION %s", new Object[]{dwe.dys.hex()}));
                }
                this.dyA.ay(dwe.dys.toByteArray());
                this.dyA.flush();
            }
        }

        public synchronized void mo2743a(boolean z, boolean z2, int i, int i2, List<dwc> list) throws IOException {
            if (z2) {
                throw new UnsupportedOperationException();
            } else if (this.closed) {
                throw new IOException("closed");
            } else {
                m10110a(z, i, (List) list);
            }
        }

        public synchronized void mo2746b(int i, int i2, List<dwc> list) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.dyC.az(list);
            long size = this.dyB.size();
            int min = (int) Math.min((long) (this.dyD - 4), size);
            m10105a(i, min + 4, (byte) 5, size == ((long) min) ? (byte) 4 : (byte) 0);
            this.dyA.pv(Integer.MAX_VALUE & i2);
            this.dyA.mo2728a(this.dyB, (long) min);
            if (size > ((long) min)) {
                m10103m(i, size - ((long) min));
            }
        }

        void m10110a(boolean z, int i, List<dwc> list) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.dyC.az(list);
            long size = this.dyB.size();
            int min = (int) Math.min((long) this.dyD, size);
            byte b = size == ((long) min) ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            m10105a(i, min, (byte) 1, b);
            this.dyA.mo2728a(this.dyB, (long) min);
            if (size > ((long) min)) {
                m10103m(i, size - ((long) min));
            }
        }

        private void m10103m(int i, long j) throws IOException {
            while (j > 0) {
                int min = (int) Math.min((long) this.dyD, j);
                j -= (long) min;
                m10105a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
                this.dyA.mo2728a(this.dyB, (long) min);
            }
        }

        public synchronized void mo2739a(int i, ErrorCode errorCode) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.httpCode == -1) {
                throw new IllegalArgumentException();
            } else {
                m10105a(i, 4, (byte) 3, (byte) 0);
                this.dyA.pv(errorCode.httpCode);
                this.dyA.flush();
            }
        }

        public int azS() {
            return this.dyD;
        }

        public synchronized void mo2742a(boolean z, int i, eth com_fossil_eth, int i2) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            byte b = (byte) 0;
            if (z) {
                b = (byte) 1;
            }
            m10104a(i, b, com_fossil_eth, i2);
        }

        void m10104a(int i, byte b, eth com_fossil_eth, int i2) throws IOException {
            m10105a(i, i2, (byte) 0, b);
            if (i2 > 0) {
                this.dyA.mo2728a(com_fossil_eth, (long) i2);
            }
        }

        public synchronized void mo2747b(dwk com_fossil_dwk) throws IOException {
            synchronized (this) {
                if (this.closed) {
                    throw new IOException("closed");
                }
                m10105a(0, com_fossil_dwk.size() * 6, (byte) 4, (byte) 0);
                for (int i = 0; i < 10; i++) {
                    if (com_fossil_dwk.isSet(i)) {
                        int i2;
                        if (i == 4) {
                            i2 = 3;
                        } else if (i == 7) {
                            i2 = 4;
                        } else {
                            i2 = i;
                        }
                        this.dyA.pw(i2);
                        this.dyA.pv(com_fossil_dwk.get(i));
                    }
                }
                this.dyA.flush();
            }
        }

        public synchronized void mo2748c(boolean z, int i, int i2) throws IOException {
            byte b = (byte) 0;
            synchronized (this) {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (z) {
                    b = (byte) 1;
                }
                m10105a(0, 8, (byte) 6, b);
                this.dyA.pv(i);
                this.dyA.pv(i2);
                this.dyA.flush();
            }
        }

        public synchronized void mo2740a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.httpCode == -1) {
                throw dwe.m10123b("errorCode.httpCode == -1", new Object[0]);
            } else {
                m10105a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.dyA.pv(i);
                this.dyA.pv(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.dyA.ay(bArr);
                }
                this.dyA.flush();
            }
        }

        public synchronized void mo2750k(int i, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw dwe.m10123b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            } else {
                m10105a(i, 4, (byte) 8, (byte) 0);
                this.dyA.pv((int) j);
                this.dyA.flush();
            }
        }

        public synchronized void close() throws IOException {
            this.closed = true;
            this.dyA.close();
        }

        void m10105a(int i, int i2, byte b, byte b2) throws IOException {
            if (dwe.logger.isLoggable(Level.FINE)) {
                dwe.logger.fine(C3258b.m10090a(false, i, i2, b, b2));
            }
            if (i2 > this.dyD) {
                throw dwe.m10123b("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.dyD), Integer.valueOf(i2));
            } else if ((Integer.MIN_VALUE & i) != 0) {
                throw dwe.m10123b("reserved bit set: %s", Integer.valueOf(i));
            } else {
                dwe.m10120a(this.dyA, i2);
                this.dyA.px(b & 255);
                this.dyA.px(b2 & 255);
                this.dyA.pv(Integer.MAX_VALUE & i);
            }
        }
    }

    public dvy mo2751a(etj com_fossil_etj, boolean z) {
        return new C3259c(com_fossil_etj, 4096, z);
    }

    public dvz mo2752a(eti com_fossil_eti, boolean z) {
        return new C3260d(com_fossil_eti, z);
    }

    private static IllegalArgumentException m10123b(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    private static IOException m10125c(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    private static int m10118a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            short s2 = i - 1;
        }
        if (s <= s2) {
            return (short) (s2 - s);
        }
        throw m10125c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(s2));
    }

    private static int m10119a(etj com_fossil_etj) throws IOException {
        return (((com_fossil_etj.readByte() & 255) << 16) | ((com_fossil_etj.readByte() & 255) << 8)) | (com_fossil_etj.readByte() & 255);
    }

    private static void m10120a(eti com_fossil_eti, int i) throws IOException {
        com_fossil_eti.px((i >>> 16) & 255);
        com_fossil_eti.px((i >>> 8) & 255);
        com_fossil_eti.px(i & 255);
    }
}
