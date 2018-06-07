package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fossil.ahg;
import com.fossil.ajv;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetSocketAddressSerializer extends StdScalarSerializer<InetSocketAddress> {
    public InetSocketAddressSerializer() {
        super(InetSocketAddress.class);
    }

    public void serialize(InetSocketAddress inetSocketAddress, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        InetAddress address = inetSocketAddress.getAddress();
        String hostName = address == null ? inetSocketAddress.getHostName() : address.toString().trim();
        int indexOf = hostName.indexOf(47);
        if (indexOf >= 0) {
            hostName = indexOf == 0 ? address instanceof Inet6Address ? "[" + hostName.substring(1) + "]" : hostName.substring(1) : hostName.substring(0, indexOf);
        }
        jsonGenerator.writeString(hostName + ":" + inetSocketAddress.getPort());
    }

    public void serializeWithType(InetSocketAddress inetSocketAddress, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException, JsonGenerationException {
        com_fossil_ajv.mo1027a((Object) inetSocketAddress, jsonGenerator, InetSocketAddress.class);
        serialize(inetSocketAddress, jsonGenerator, com_fossil_ahg);
        com_fossil_ajv.mo1034d(inetSocketAddress, jsonGenerator);
    }
}
