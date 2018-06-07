package com.fossil;

import com.misfit.frameworks.common.constants.Constants;
import java.io.IOException;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.List;

public final class dwn implements dus {
    public static final dus dyZ = new dwn();

    public dvj mo2758a(Proxy proxy, dvl com_fossil_dvl) throws IOException {
        List azE = com_fossil_dvl.azE();
        dvj azy = com_fossil_dvl.azy();
        dvf azq = azy.azq();
        int size = azE.size();
        for (int i = 0; i < size; i++) {
            dux com_fossil_dux = (dux) azE.get(i);
            if ("Basic".equalsIgnoreCase(com_fossil_dux.getScheme())) {
                PasswordAuthentication requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(azq.ayV(), m10172a(proxy, azq), azq.ayW(), azq.ayR(), com_fossil_dux.getRealm(), com_fossil_dux.getScheme(), azq.ayP(), RequestorType.SERVER);
                if (requestPasswordAuthentication != null) {
                    return azy.azv().aY(Constants.YO_HEADER_TOKEN, dvb.aT(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()))).azx();
                }
            }
        }
        return null;
    }

    public dvj mo2759b(Proxy proxy, dvl com_fossil_dvl) throws IOException {
        List azE = com_fossil_dvl.azE();
        dvj azy = com_fossil_dvl.azy();
        dvf azq = azy.azq();
        int size = azE.size();
        for (int i = 0; i < size; i++) {
            dux com_fossil_dux = (dux) azE.get(i);
            if ("Basic".equalsIgnoreCase(com_fossil_dux.getScheme())) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                PasswordAuthentication requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), m10172a(proxy, azq), inetSocketAddress.getPort(), azq.ayR(), com_fossil_dux.getRealm(), com_fossil_dux.getScheme(), azq.ayP(), RequestorType.PROXY);
                if (requestPasswordAuthentication != null) {
                    return azy.azv().aY("Proxy-Authorization", dvb.aT(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()))).azx();
                }
            }
        }
        return null;
    }

    private InetAddress m10172a(Proxy proxy, dvf com_fossil_dvf) throws IOException {
        if (proxy == null || proxy.type() == Type.DIRECT) {
            return InetAddress.getByName(com_fossil_dvf.ayV());
        }
        return ((InetSocketAddress) proxy.address()).getAddress();
    }
}
