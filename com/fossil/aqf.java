package com.fossil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class aqf<ObjectType> implements aqi<ObjectType> {
    protected final aqi<ObjectType> bca;

    public aqf(aqi<ObjectType> com_fossil_aqi_ObjectType) {
        this.bca = com_fossil_aqi_ObjectType;
    }

    public void mo1105a(OutputStream outputStream, ObjectType objectType) throws IOException {
        if (this.bca != null && outputStream != null && objectType != null) {
            this.bca.mo1105a(outputStream, objectType);
        }
    }

    public ObjectType mo1106j(InputStream inputStream) throws IOException {
        if (this.bca == null || inputStream == null) {
            return null;
        }
        return this.bca.mo1106j(inputStream);
    }
}
