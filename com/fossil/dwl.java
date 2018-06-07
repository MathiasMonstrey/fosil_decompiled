package com.fossil;

import com.fossil.dvy.C3238a;
import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.HeadersMode;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import okio.ByteString;

public final class dwl implements dwm {
    static final byte[] dyV;

    static final class C3266a implements dvy {
        private final boolean dwY;
        private final dwh dyW = new dwh(this.dyk);
        private final etj dyk;

        C3266a(etj com_fossil_etj, boolean z) {
            this.dyk = com_fossil_etj;
            this.dwY = z;
        }

        public void azP() {
        }

        public boolean mo2737a(C3238a c3238a) throws IOException {
            boolean z = false;
            try {
                int readInt = this.dyk.readInt();
                int readInt2 = this.dyk.readInt();
                int i = (-16777216 & readInt2) >>> 24;
                readInt2 &= 16777215;
                int i2;
                if ((Integer.MIN_VALUE & readInt) != 0) {
                    int i3 = (2147418112 & readInt) >>> 16;
                    i2 = 65535 & readInt;
                    if (i3 != 3) {
                        throw new ProtocolException("version != 3: " + i3);
                    }
                    switch (i2) {
                        case 1:
                            m10150a(c3238a, i, readInt2);
                            return true;
                        case 2:
                            m10151b(c3238a, i, readInt2);
                            return true;
                        case 3:
                            m10153c(c3238a, i, readInt2);
                            return true;
                        case 4:
                            m10158h(c3238a, i, readInt2);
                            return true;
                        case 6:
                            m10156f(c3238a, i, readInt2);
                            return true;
                        case 7:
                            m10157g(c3238a, i, readInt2);
                            return true;
                        case 8:
                            m10154d(c3238a, i, readInt2);
                            return true;
                        case 9:
                            m10155e(c3238a, i, readInt2);
                            return true;
                        default:
                            this.dyk.bh((long) readInt2);
                            return true;
                    }
                }
                i2 = Integer.MAX_VALUE & readInt;
                if ((i & 1) != 0) {
                    z = true;
                }
                c3238a.mo2720a(z, i2, this.dyk, readInt2);
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        private void m10150a(C3238a c3238a, int i, int i2) throws IOException {
            boolean z;
            boolean z2 = true;
            int readInt = this.dyk.readInt();
            int i3 = readInt & Integer.MAX_VALUE;
            int readInt2 = this.dyk.readInt() & Integer.MAX_VALUE;
            this.dyk.readShort();
            List mO = this.dyW.mO(i2 - 10);
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i & 2) == 0) {
                z2 = false;
            }
            c3238a.mo2722a(z2, z, i3, readInt2, mO, HeadersMode.SPDY_SYN_STREAM);
        }

        private void m10151b(C3238a c3238a, int i, int i2) throws IOException {
            boolean z;
            int readInt = this.dyk.readInt() & Integer.MAX_VALUE;
            List mO = this.dyW.mO(i2 - 4);
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            c3238a.mo2722a(false, z, readInt, -1, mO, HeadersMode.SPDY_REPLY);
        }

        private void m10153c(C3238a c3238a, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw C3266a.m10152c("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
            }
            int readInt = this.dyk.readInt() & Integer.MAX_VALUE;
            ErrorCode fromSpdy3Rst = ErrorCode.fromSpdy3Rst(this.dyk.readInt());
            if (fromSpdy3Rst == null) {
                throw C3266a.m10152c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(r1));
            } else {
                c3238a.mo2718a(readInt, fromSpdy3Rst);
            }
        }

        private void m10154d(C3238a c3238a, int i, int i2) throws IOException {
            c3238a.mo2722a(false, false, this.dyk.readInt() & Integer.MAX_VALUE, -1, this.dyW.mO(i2 - 4), HeadersMode.SPDY_HEADERS);
        }

        private void m10155e(C3238a c3238a, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw C3266a.m10152c("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
            }
            int readInt = this.dyk.readInt() & Integer.MAX_VALUE;
            long readInt2 = (long) (this.dyk.readInt() & Integer.MAX_VALUE);
            if (readInt2 == 0) {
                throw C3266a.m10152c("windowSizeIncrement was 0", Long.valueOf(readInt2));
            } else {
                c3238a.mo2727k(readInt, readInt2);
            }
        }

        private void m10156f(C3238a c3238a, int i, int i2) throws IOException {
            boolean z = true;
            if (i2 != 4) {
                throw C3266a.m10152c("TYPE_PING length: %d != 4", Integer.valueOf(i2));
            }
            boolean z2;
            int readInt = this.dyk.readInt();
            boolean z3 = this.dwY;
            if ((readInt & 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3 != z2) {
                z = false;
            }
            c3238a.mo2726c(z, readInt, 0);
        }

        private void m10157g(C3238a c3238a, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw C3266a.m10152c("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
            }
            int readInt = this.dyk.readInt() & Integer.MAX_VALUE;
            ErrorCode fromSpdyGoAway = ErrorCode.fromSpdyGoAway(this.dyk.readInt());
            if (fromSpdyGoAway == null) {
                throw C3266a.m10152c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(r1));
            } else {
                c3238a.mo2719a(readInt, fromSpdyGoAway, ByteString.EMPTY);
            }
        }

        private void m10158h(C3238a c3238a, int i, int i2) throws IOException {
            boolean z = true;
            int readInt = this.dyk.readInt();
            if (i2 != (readInt * 8) + 4) {
                throw C3266a.m10152c("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(readInt));
            }
            dwk com_fossil_dwk = new dwk();
            for (int i3 = 0; i3 < readInt; i3++) {
                int readInt2 = this.dyk.readInt();
                int i4 = (-16777216 & readInt2) >>> 24;
                com_fossil_dwk.m10148J(readInt2 & 16777215, i4, this.dyk.readInt());
            }
            if ((i & 1) == 0) {
                z = false;
            }
            c3238a.mo2721a(z, com_fossil_dwk);
        }

        private static IOException m10152c(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        public void close() throws IOException {
            this.dyW.close();
        }
    }

    static final class C3267b implements dvz {
        private boolean closed;
        private final boolean dwY;
        private final eti dyA;
        private final eth dyX = new eth();
        private final eti dyY;

        C3267b(eti com_fossil_eti, boolean z) {
            this.dyA = com_fossil_eti;
            this.dwY = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(dwl.dyV);
            this.dyY = etp.m11179c(new etk(this.dyX, deflater));
        }

        public void mo2741a(dwk com_fossil_dwk) {
        }

        public void mo2746b(int i, int i2, List<dwc> list) throws IOException {
        }

        public synchronized void azR() {
        }

        public synchronized void flush() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.dyA.flush();
        }

        public synchronized void mo2743a(boolean z, boolean z2, int i, int i2, List<dwc> list) throws IOException {
            int i3 = 0;
            synchronized (this) {
                if (this.closed) {
                    throw new IOException("closed");
                }
                aA(list);
                int size = (int) (10 + this.dyX.size());
                int i4 = z ? 1 : 0;
                if (z2) {
                    i3 = 2;
                }
                i3 |= i4;
                this.dyA.pv(-2147287039);
                this.dyA.pv(((i3 & 255) << 24) | (size & 16777215));
                this.dyA.pv(i & Integer.MAX_VALUE);
                this.dyA.pv(i2 & Integer.MAX_VALUE);
                this.dyA.pw(0);
                this.dyA.mo3040b(this.dyX);
                this.dyA.flush();
            }
        }

        public synchronized void mo2739a(int i, ErrorCode errorCode) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.spdyRstCode == -1) {
                throw new IllegalArgumentException();
            } else {
                this.dyA.pv(-2147287037);
                this.dyA.pv(8);
                this.dyA.pv(Integer.MAX_VALUE & i);
                this.dyA.pv(errorCode.spdyRstCode);
                this.dyA.flush();
            }
        }

        public int azS() {
            return 16383;
        }

        public synchronized void mo2742a(boolean z, int i, eth com_fossil_eth, int i2) throws IOException {
            m10160a(i, z ? 1 : 0, com_fossil_eth, i2);
        }

        void m10160a(int i, int i2, eth com_fossil_eth, int i3) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (((long) i3) > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i3);
            } else {
                this.dyA.pv(Integer.MAX_VALUE & i);
                this.dyA.pv(((i2 & 255) << 24) | (16777215 & i3));
                if (i3 > 0) {
                    this.dyA.mo2728a(com_fossil_eth, (long) i3);
                }
            }
        }

        private void aA(List<dwc> list) throws IOException {
            this.dyY.pv(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString byteString = ((dwc) list.get(i)).dyc;
                this.dyY.pv(byteString.size());
                this.dyY.mo3046f(byteString);
                byteString = ((dwc) list.get(i)).dyd;
                this.dyY.pv(byteString.size());
                this.dyY.mo3046f(byteString);
            }
            this.dyY.flush();
        }

        public synchronized void mo2747b(dwk com_fossil_dwk) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            int size = com_fossil_dwk.size();
            int i = (size * 8) + 4;
            this.dyA.pv(-2147287036);
            this.dyA.pv((i & 16777215) | 0);
            this.dyA.pv(size);
            for (size = 0; size <= 10; size++) {
                if (com_fossil_dwk.isSet(size)) {
                    this.dyA.pv(((com_fossil_dwk.mP(size) & 255) << 24) | (size & 16777215));
                    this.dyA.pv(com_fossil_dwk.get(size));
                }
            }
            this.dyA.flush();
        }

        public synchronized void mo2748c(boolean z, int i, int i2) throws IOException {
            boolean z2 = true;
            synchronized (this) {
                if (this.closed) {
                    throw new IOException("closed");
                }
                boolean z3;
                boolean z4 = this.dwY;
                if ((i & 1) == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z4 == z3) {
                    z2 = false;
                }
                if (z != z2) {
                    throw new IllegalArgumentException("payload != reply");
                }
                this.dyA.pv(-2147287034);
                this.dyA.pv(4);
                this.dyA.pv(i);
                this.dyA.flush();
            }
        }

        public synchronized void mo2740a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.spdyGoAwayCode == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            } else {
                this.dyA.pv(-2147287033);
                this.dyA.pv(8);
                this.dyA.pv(i);
                this.dyA.pv(errorCode.spdyGoAwayCode);
                this.dyA.flush();
            }
        }

        public synchronized void mo2750k(int i, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            } else {
                this.dyA.pv(-2147287031);
                this.dyA.pv(8);
                this.dyA.pv(i);
                this.dyA.pv((int) j);
                this.dyA.flush();
            }
        }

        public synchronized void close() throws IOException {
            this.closed = true;
            dvw.m9968a(this.dyA, this.dyY);
        }
    }

    static {
        try {
            dyV = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(dvw.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }

    public dvy mo2751a(etj com_fossil_etj, boolean z) {
        return new C3266a(com_fossil_etj, z);
    }

    public dvz mo2752a(eti com_fossil_eti, boolean z) {
        return new C3267b(com_fossil_eti, z);
    }
}
