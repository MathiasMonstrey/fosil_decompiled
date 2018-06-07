package com.fossil;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.dve.C3222a;
import com.fossil.dvl.C3232a;
import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

public final class dwq implements dxd {
    private static final List<ByteString> dzj = dvw.m9976m(ByteString.encodeUtf8("connection"), ByteString.encodeUtf8("host"), ByteString.encodeUtf8("keep-alive"), ByteString.encodeUtf8("proxy-connection"), ByteString.encodeUtf8("transfer-encoding"));
    private static final List<ByteString> dzk = dvw.m9976m(ByteString.encodeUtf8("connection"), ByteString.encodeUtf8("host"), ByteString.encodeUtf8("keep-alive"), ByteString.encodeUtf8("proxy-connection"), ByteString.encodeUtf8("te"), ByteString.encodeUtf8("transfer-encoding"), ByteString.encodeUtf8("encoding"), ByteString.encodeUtf8("upgrade"));
    private final dwa duV;
    private final dwu dzl;
    private dwb dzm;

    public dwq(dwu com_fossil_dwu, dwa com_fossil_dwa) {
        this.dzl = com_fossil_dwu;
        this.duV = com_fossil_dwa;
    }

    public etu mo2760a(dvj com_fossil_dvj, long j) throws IOException {
        return this.dzm.aAa();
    }

    public void mo2766m(dvj com_fossil_dvj) throws IOException {
        if (this.dzm == null) {
            this.dzl.aAX();
            this.dzm = this.duV.m10046b(m10182a(com_fossil_dvj, this.duV.ayB(), dwz.m10245d(this.dzl.aBb().ayB())), this.dzl.aAY(), true);
            this.dzm.azY().mo3063f((long) this.dzl.client.getReadTimeout(), TimeUnit.MILLISECONDS);
        }
    }

    public void mo2761a(dxa com_fossil_dxa) throws IOException {
        com_fossil_dxa.m10249a(this.dzm.aAa());
    }

    public void aAI() throws IOException {
        this.dzm.aAa().close();
    }

    public C3232a aAJ() throws IOException {
        return m10181a(this.dzm.azX(), this.duV.ayB());
    }

    public static List<dwc> m10182a(dvj com_fossil_dvj, Protocol protocol, String str) {
        dve azt = com_fossil_dvj.azt();
        List<dwc> arrayList = new ArrayList(azt.size() + 10);
        arrayList.add(new dwc(dwc.dxW, com_fossil_dvj.azs()));
        arrayList.add(new dwc(dwc.dxX, dwz.m10246g(com_fossil_dvj.azq())));
        String e = dvw.m9975e(com_fossil_dvj.azq());
        if (Protocol.SPDY_3 == protocol) {
            arrayList.add(new dwc(dwc.dyb, str));
            arrayList.add(new dwc(dwc.dya, e));
        } else if (Protocol.HTTP_2 == protocol) {
            arrayList.add(new dwc(dwc.dxZ, e));
        } else {
            throw new AssertionError();
        }
        arrayList.add(new dwc(dwc.dxY, com_fossil_dvj.azq().ayR()));
        Set linkedHashSet = new LinkedHashSet();
        int size = azt.size();
        for (int i = 0; i < size; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(azt.my(i).toLowerCase(Locale.US));
            String mz = azt.mz(i);
            if (!m10183a(protocol, encodeUtf8) && !encodeUtf8.equals(dwc.dxW) && !encodeUtf8.equals(dwc.dxX) && !encodeUtf8.equals(dwc.dxY) && !encodeUtf8.equals(dwc.dxZ) && !encodeUtf8.equals(dwc.dya) && !encodeUtf8.equals(dwc.dyb)) {
                if (linkedHashSet.add(encodeUtf8)) {
                    arrayList.add(new dwc(encodeUtf8, mz));
                } else {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (((dwc) arrayList.get(i2)).dyc.equals(encodeUtf8)) {
                            arrayList.set(i2, new dwc(encodeUtf8, bd(((dwc) arrayList.get(i2)).dyd.utf8(), mz)));
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static String bd(String str, String str2) {
        return '\u0000' + str2;
    }

    public static C3232a m10181a(List<dwc> list, Protocol protocol) throws IOException {
        String str = null;
        String str2 = "HTTP/1.1";
        C3222a c3222a = new C3222a();
        c3222a.aW(dwx.dzT, protocol.toString());
        int size = list.size();
        int i = 0;
        while (i < size) {
            ByteString byteString = ((dwc) list.get(i)).dyc;
            String utf8 = ((dwc) list.get(i)).dyd.utf8();
            String str3 = str2;
            int i2 = 0;
            while (i2 < utf8.length()) {
                int indexOf = utf8.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = utf8.length();
                }
                str2 = utf8.substring(i2, indexOf);
                if (!byteString.equals(dwc.dxV)) {
                    if (byteString.equals(dwc.dyb)) {
                        str3 = str2;
                        str2 = str;
                    } else {
                        if (!m10183a(protocol, byteString)) {
                            c3222a.aU(byteString.utf8(), str2);
                        }
                        str2 = str;
                    }
                }
                str = str2;
                i2 = indexOf + 1;
            }
            i++;
            str2 = str3;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        dxc kV = dxc.kV(str2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str);
        return new C3232a().m9924b(protocol).mB(kV.drk).kN(kV.message).m9923b(c3222a.ayO());
    }

    public dvm mo2767p(dvl com_fossil_dvl) throws IOException {
        return new dwy(com_fossil_dvl.azt(), etp.m11180c(this.dzm.azZ()));
    }

    public void aAK() {
    }

    public boolean aAL() {
        return true;
    }

    private static boolean m10183a(Protocol protocol, ByteString byteString) {
        if (protocol == Protocol.SPDY_3) {
            return dzj.contains(byteString);
        }
        if (protocol == Protocol.HTTP_2) {
            return dzk.contains(byteString);
        }
        throw new AssertionError(protocol);
    }
}
