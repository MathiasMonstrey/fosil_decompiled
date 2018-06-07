package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fossil.ahg;
import com.fossil.amg;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferSerializer extends StdScalarSerializer<ByteBuffer> {
    public ByteBufferSerializer() {
        super(ByteBuffer.class);
    }

    public void serialize(ByteBuffer byteBuffer, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (byteBuffer.hasArray()) {
            jsonGenerator.m2680d(byteBuffer.array(), 0, byteBuffer.limit());
            return;
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        if (asReadOnlyBuffer.position() > 0) {
            asReadOnlyBuffer.rewind();
        }
        InputStream com_fossil_amg = new amg(asReadOnlyBuffer);
        jsonGenerator.m2673b(com_fossil_amg, asReadOnlyBuffer.remaining());
        com_fossil_amg.close();
    }
}
