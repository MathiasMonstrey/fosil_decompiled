package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fossil.ahg;
import com.fossil.ajv;
import java.io.IOException;
import java.net.InetAddress;

public class InetAddressSerializer extends StdScalarSerializer<InetAddress> {
    public InetAddressSerializer() {
        super(InetAddress.class);
    }

    public void serialize(InetAddress inetAddress, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        String trim = inetAddress.toString().trim();
        int indexOf = trim.indexOf(47);
        if (indexOf >= 0) {
            if (indexOf == 0) {
                trim = trim.substring(1);
            } else {
                trim = trim.substring(0, indexOf);
            }
        }
        jsonGenerator.writeString(trim);
    }

    public void serializeWithType(InetAddress inetAddress, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException, JsonGenerationException {
        com_fossil_ajv.mo1027a((Object) inetAddress, jsonGenerator, InetAddress.class);
        serialize(inetAddress, jsonGenerator, com_fossil_ahg);
        com_fossil_ajv.mo1034d(inetAddress, jsonGenerator);
    }
}
