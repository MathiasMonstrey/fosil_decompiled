package com.fossil;

import android.support.v8.renderscript.Allocation;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import com.misfit.frameworks.common.constants.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;

final class dwd {
    private static final dwc[] dyh = new dwc[]{new dwc(dwc.dxZ, ""), new dwc(dwc.dxW, "GET"), new dwc(dwc.dxW, "POST"), new dwc(dwc.dxX, "/"), new dwc(dwc.dxX, "/index.html"), new dwc(dwc.dxY, "http"), new dwc(dwc.dxY, UpPlatformSdkConstants.URI_SCHEME), new dwc(dwc.dxV, "200"), new dwc(dwc.dxV, "204"), new dwc(dwc.dxV, "206"), new dwc(dwc.dxV, "304"), new dwc(dwc.dxV, "400"), new dwc(dwc.dxV, "404"), new dwc(dwc.dxV, "500"), new dwc("accept-charset", ""), new dwc("accept-encoding", "gzip, deflate"), new dwc("accept-language", ""), new dwc("accept-ranges", ""), new dwc("accept", ""), new dwc("access-control-allow-origin", ""), new dwc("age", ""), new dwc("allow", ""), new dwc(Constants.IF_AUTHORIZATION, ""), new dwc("cache-control", ""), new dwc("content-disposition", ""), new dwc("content-encoding", ""), new dwc("content-language", ""), new dwc("content-length", ""), new dwc("content-location", ""), new dwc("content-range", ""), new dwc("content-type", ""), new dwc("cookie", ""), new dwc("date", ""), new dwc(Constants.JSON_KEY_ETAG, ""), new dwc("expect", ""), new dwc("expires", ""), new dwc("from", ""), new dwc("host", ""), new dwc("if-match", ""), new dwc("if-modified-since", ""), new dwc("if-none-match", ""), new dwc("if-range", ""), new dwc("if-unmodified-since", ""), new dwc("last-modified", ""), new dwc("link", ""), new dwc("location", ""), new dwc("max-forwards", ""), new dwc("proxy-authenticate", ""), new dwc("proxy-authorization", ""), new dwc("range", ""), new dwc("referer", ""), new dwc("refresh", ""), new dwc("retry-after", ""), new dwc("server", ""), new dwc("set-cookie", ""), new dwc("strict-transport-security", ""), new dwc("transfer-encoding", ""), new dwc("user-agent", ""), new dwc("vary", ""), new dwc("via", ""), new dwc("www-authenticate", "")};
    private static final Map<ByteString, Integer> dyi = aAj();

    static final class C3255a {
        private final List<dwc> dyj = new ArrayList();
        private final etj dyk;
        private int dyl;
        private int dym;
        dwc[] dyn = new dwc[8];
        int dyo = (this.dyn.length - 1);
        int dyp = 0;
        int dyq = 0;

        C3255a(int i, etv com_fossil_etv) {
            this.dyl = i;
            this.dym = i;
            this.dyk = etp.m11180c(com_fossil_etv);
        }

        void mG(int i) {
            this.dyl = i;
            this.dym = i;
            aAm();
        }

        private void aAm() {
            if (this.dym >= this.dyq) {
                return;
            }
            if (this.dym == 0) {
                aAn();
            } else {
                mH(this.dyq - this.dym);
            }
        }

        private void aAn() {
            this.dyj.clear();
            Arrays.fill(this.dyn, null);
            this.dyo = this.dyn.length - 1;
            this.dyp = 0;
            this.dyq = 0;
        }

        private int mH(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.dyn.length - 1; length >= this.dyo && i > 0; length--) {
                    i -= this.dyn[length].dyf;
                    this.dyq -= this.dyn[length].dyf;
                    this.dyp--;
                    i2++;
                }
                System.arraycopy(this.dyn, this.dyo + 1, this.dyn, (this.dyo + 1) + i2, this.dyp);
                this.dyo += i2;
            }
            return i2;
        }

        void aAo() throws IOException {
            while (!this.dyk.aHi()) {
                int readByte = this.dyk.readByte() & 255;
                if (readByte == Allocation.USAGE_SHARED) {
                    throw new IOException("index == 0");
                } else if ((readByte & Allocation.USAGE_SHARED) == Allocation.USAGE_SHARED) {
                    mI(cn(readByte, 127) - 1);
                } else if (readByte == 64) {
                    aAr();
                } else if ((readByte & 64) == 64) {
                    mL(cn(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    this.dym = cn(readByte, 31);
                    if (this.dym < 0 || this.dym > this.dyl) {
                        throw new IOException("Invalid dynamic table size update " + this.dym);
                    }
                    aAm();
                } else if (readByte == 16 || readByte == 0) {
                    aAq();
                } else {
                    mK(cn(readByte, 15) - 1);
                }
            }
        }

        public List<dwc> aAp() {
            List arrayList = new ArrayList(this.dyj);
            this.dyj.clear();
            return arrayList;
        }

        private void mI(int i) throws IOException {
            if (mN(i)) {
                this.dyj.add(dwd.dyh[i]);
                return;
            }
            int mJ = mJ(i - dwd.dyh.length);
            if (mJ < 0 || mJ > this.dyn.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.dyj.add(this.dyn[mJ]);
        }

        private int mJ(int i) {
            return (this.dyo + 1) + i;
        }

        private void mK(int i) throws IOException {
            this.dyj.add(new dwc(mM(i), aAt()));
        }

        private void aAq() throws IOException {
            this.dyj.add(new dwc(dwd.m10086b(aAt()), aAt()));
        }

        private void mL(int i) throws IOException {
            m10083a(-1, new dwc(mM(i), aAt()));
        }

        private void aAr() throws IOException {
            m10083a(-1, new dwc(dwd.m10086b(aAt()), aAt()));
        }

        private ByteString mM(int i) {
            if (mN(i)) {
                return dwd.dyh[i].dyc;
            }
            return this.dyn[mJ(i - dwd.dyh.length)].dyc;
        }

        private boolean mN(int i) {
            return i >= 0 && i <= dwd.dyh.length - 1;
        }

        private void m10083a(int i, dwc com_fossil_dwc) {
            this.dyj.add(com_fossil_dwc);
            int i2 = com_fossil_dwc.dyf;
            if (i != -1) {
                i2 -= this.dyn[mJ(i)].dyf;
            }
            if (i2 > this.dym) {
                aAn();
                return;
            }
            int mH = mH((this.dyq + i2) - this.dym);
            if (i == -1) {
                if (this.dyp + 1 > this.dyn.length) {
                    Object obj = new dwc[(this.dyn.length * 2)];
                    System.arraycopy(this.dyn, 0, obj, this.dyn.length, this.dyn.length);
                    this.dyo = this.dyn.length - 1;
                    this.dyn = obj;
                }
                mH = this.dyo;
                this.dyo = mH - 1;
                this.dyn[mH] = com_fossil_dwc;
                this.dyp++;
            } else {
                this.dyn[(mH + mJ(i)) + i] = com_fossil_dwc;
            }
            this.dyq = i2 + this.dyq;
        }

        private int aAs() throws IOException {
            return this.dyk.readByte() & 255;
        }

        int cn(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            i3 = 0;
            while (true) {
                int aAs = aAs();
                if ((aAs & Allocation.USAGE_SHARED) == 0) {
                    return (aAs << i3) + i2;
                }
                i2 += (aAs & 127) << i3;
                i3 += 7;
            }
        }

        ByteString aAt() throws IOException {
            int aAs = aAs();
            Object obj = (aAs & Allocation.USAGE_SHARED) == Allocation.USAGE_SHARED ? 1 : null;
            aAs = cn(aAs, 127);
            if (obj != null) {
                return ByteString.of(dwf.aAx().decode(this.dyk.bg((long) aAs)));
            }
            return this.dyk.bd((long) aAs);
        }
    }

    static final class C3256b {
        private final eth dyr;

        C3256b(eth com_fossil_eth) {
            this.dyr = com_fossil_eth;
        }

        void az(List<dwc> list) throws IOException {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString toAsciiLowercase = ((dwc) list.get(i)).dyc.toAsciiLowercase();
                Integer num = (Integer) dwd.dyi.get(toAsciiLowercase);
                if (num != null) {
                    m10084I(num.intValue() + 1, 15, 0);
                    m10085d(((dwc) list.get(i)).dyd);
                } else {
                    this.dyr.pr(0);
                    m10085d(toAsciiLowercase);
                    m10085d(((dwc) list.get(i)).dyd);
                }
            }
        }

        void m10084I(int i, int i2, int i3) throws IOException {
            if (i < i2) {
                this.dyr.pr(i3 | i);
                return;
            }
            this.dyr.pr(i3 | i2);
            int i4 = i - i2;
            while (i4 >= Allocation.USAGE_SHARED) {
                this.dyr.pr((i4 & 127) | Allocation.USAGE_SHARED);
                i4 >>>= 7;
            }
            this.dyr.pr(i4);
        }

        void m10085d(ByteString byteString) throws IOException {
            m10084I(byteString.size(), 127, 0);
            this.dyr.m11160e(byteString);
        }
    }

    private static Map<ByteString, Integer> aAj() {
        Map linkedHashMap = new LinkedHashMap(dyh.length);
        for (int i = 0; i < dyh.length; i++) {
            if (!linkedHashMap.containsKey(dyh[i].dyc)) {
                linkedHashMap.put(dyh[i].dyc, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static ByteString m10086b(ByteString byteString) throws IOException {
        int i = 0;
        int size = byteString.size();
        while (i < size) {
            byte b = byteString.getByte(i);
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
