package com.fossil;

import java.net.InetAddress;
import java.net.UnknownHostException;

public interface dvs {
    public static final dvs dwB = new C32331();

    static class C32331 implements dvs {
        C32331() {
        }

        public InetAddress[] kO(String str) throws UnknownHostException {
            if (str != null) {
                return InetAddress.getAllByName(str);
            }
            throw new UnknownHostException("host == null");
        }
    }

    InetAddress[] kO(String str) throws UnknownHostException;
}
