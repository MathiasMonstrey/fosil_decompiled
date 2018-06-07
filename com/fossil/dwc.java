package com.fossil;

import okio.ByteString;

public final class dwc {
    public static final ByteString dxV = ByteString.encodeUtf8(":status");
    public static final ByteString dxW = ByteString.encodeUtf8(":method");
    public static final ByteString dxX = ByteString.encodeUtf8(":path");
    public static final ByteString dxY = ByteString.encodeUtf8(":scheme");
    public static final ByteString dxZ = ByteString.encodeUtf8(":authority");
    public static final ByteString dya = ByteString.encodeUtf8(":host");
    public static final ByteString dyb = ByteString.encodeUtf8(":version");
    public final ByteString dyc;
    public final ByteString dyd;
    final int dyf;

    public dwc(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public dwc(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public dwc(ByteString byteString, ByteString byteString2) {
        this.dyc = byteString;
        this.dyd = byteString2;
        this.dyf = (byteString.size() + 32) + byteString2.size();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof dwc)) {
            return false;
        }
        dwc com_fossil_dwc = (dwc) obj;
        if (this.dyc.equals(com_fossil_dwc.dyc) && this.dyd.equals(com_fossil_dwc.dyd)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.dyc.hashCode() + 527) * 31) + this.dyd.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", new Object[]{this.dyc.utf8(), this.dyd.utf8()});
    }
}
