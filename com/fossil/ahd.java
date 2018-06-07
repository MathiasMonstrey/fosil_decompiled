package com.fossil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ahd<T> implements Closeable, Iterator<T> {
    protected static final ahd<?> aQj = new ahd(null, null, null, null, false, null);
    protected final agy<T> _deserializer;
    protected final JsonParser _parser;
    protected final JavaType _type;
    protected final DeserializationContext aQk;
    protected final aez aQl;
    protected final T aQm;
    protected final boolean aQn;
    protected int aQo;

    public ahd(JavaType javaType, JsonParser jsonParser, DeserializationContext deserializationContext, agy<?> com_fossil_agy_, boolean z, Object obj) {
        this._type = javaType;
        this._parser = jsonParser;
        this.aQk = deserializationContext;
        this._deserializer = com_fossil_agy_;
        this.aQn = z;
        if (obj == null) {
            this.aQm = null;
        } else {
            this.aQm = obj;
        }
        if (jsonParser == null) {
            this.aQl = null;
            this.aQo = 0;
            return;
        }
        aez zX = jsonParser.zX();
        if (z && jsonParser.Aa()) {
            jsonParser.Ac();
        } else {
            JsonToken zU = jsonParser.zU();
            if (zU == JsonToken.START_OBJECT || zU == JsonToken.START_ARRAY) {
                zX = zX.Az();
            }
        }
        this.aQl = zX;
        this.aQo = 2;
    }

    public boolean hasNext() {
        try {
            return DS();
        } catch (JsonMappingException e) {
            return ((Boolean) m3337a(e)).booleanValue();
        } catch (IOException e2) {
            return ((Boolean) m3338a(e2)).booleanValue();
        }
    }

    public T next() {
        try {
            return nextValue();
        } catch (JsonMappingException e) {
            throw new RuntimeJsonMappingException(e.getMessage(), e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void close() throws IOException {
        if (this.aQo != 0) {
            this.aQo = 0;
            if (this._parser != null) {
                this._parser.close();
            }
        }
    }

    public boolean DS() throws IOException {
        switch (this.aQo) {
            case 0:
                return false;
            case 1:
                DT();
                break;
            case 2:
                break;
            default:
                return true;
        }
        if (this._parser.zU() == null) {
            JsonToken zP = this._parser.zP();
            if (zP == null || zP == JsonToken.END_ARRAY) {
                this.aQo = 0;
                if (!this.aQn || this._parser == null) {
                    return false;
                }
                this._parser.close();
                return false;
            }
        }
        this.aQo = 3;
        return true;
    }

    public T nextValue() throws IOException {
        switch (this.aQo) {
            case 0:
                return DU();
            case 1:
            case 2:
                if (!DS()) {
                    return DU();
                }
                break;
        }
        try {
            T deserialize;
            if (this.aQm == null) {
                deserialize = this._deserializer.deserialize(this._parser, this.aQk);
            } else {
                this._deserializer.deserialize(this._parser, this.aQk, this.aQm);
                deserialize = this.aQm;
            }
            this.aQo = 2;
            this._parser.Ac();
            return deserialize;
        } catch (Throwable th) {
            this.aQo = 1;
            this._parser.Ac();
        }
    }

    protected void DT() throws IOException {
        JsonParser jsonParser = this._parser;
        if (jsonParser.zX() != this.aQl) {
            while (true) {
                JsonToken zP = jsonParser.zP();
                if (zP == JsonToken.END_ARRAY || zP == JsonToken.END_OBJECT) {
                    if (jsonParser.zX() == this.aQl) {
                        jsonParser.Ac();
                        return;
                    }
                } else if (zP == JsonToken.START_ARRAY || zP == JsonToken.START_OBJECT) {
                    jsonParser.zT();
                } else if (zP == null) {
                    return;
                }
            }
        }
    }

    protected <R> R DU() {
        throw new NoSuchElementException();
    }

    protected <R> R m3337a(JsonMappingException jsonMappingException) {
        throw new RuntimeJsonMappingException(jsonMappingException.getMessage(), jsonMappingException);
    }

    protected <R> R m3338a(IOException iOException) {
        throw new RuntimeException(iOException.getMessage(), iOException);
    }
}
