package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fossil.amh;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class ByteBufferDeserializer extends StdScalarDeserializer<ByteBuffer> {
    private static final long serialVersionUID = 1;

    public ByteBufferDeserializer() {
        super(ByteBuffer.class);
    }

    public ByteBuffer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return ByteBuffer.wrap(jsonParser.Ar());
    }

    public ByteBuffer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, ByteBuffer byteBuffer) throws IOException {
        OutputStream com_fossil_amh = new amh(byteBuffer);
        jsonParser.mo904a(deserializationContext.getBase64Variant(), com_fossil_amh);
        com_fossil_amh.close();
        return byteBuffer;
    }
}
