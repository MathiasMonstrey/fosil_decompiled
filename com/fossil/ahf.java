package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter.Prefetch;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public class ahf implements Closeable, Flushable {
    protected final SerializationConfig _config;
    protected alt _dynamicSerializers = alt.GN();
    protected boolean aLR;
    protected final boolean aQA = this._config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE);
    protected boolean aQB;
    protected final DefaultSerializerProvider aQu;
    protected final JsonGenerator aQv;
    protected final ahb<Object> aQw;
    protected final ajv aQx;
    protected final boolean aQy;
    protected final boolean aQz = this._config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE);

    public ahf(DefaultSerializerProvider defaultSerializerProvider, JsonGenerator jsonGenerator, boolean z, Prefetch prefetch) throws IOException {
        this.aQu = defaultSerializerProvider;
        this.aQv = jsonGenerator;
        this.aQy = z;
        this.aQw = prefetch.getValueSerializer();
        this.aQx = prefetch.getTypeSerializer();
        this._config = defaultSerializerProvider.getConfig();
    }

    public ahf aJ(boolean z) throws IOException {
        if (z) {
            this.aQv.zH();
            this.aQB = true;
        }
        return this;
    }

    public void flush() throws IOException {
        if (!this.aLR) {
            this.aQv.flush();
        }
    }

    public void close() throws IOException {
        if (!this.aLR) {
            this.aLR = true;
            if (this.aQB) {
                this.aQB = false;
                this.aQv.zI();
            }
            if (this.aQy) {
                this.aQv.close();
            }
        }
    }
}
