package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fossil.afm;
import java.io.IOException;

public class MappingJsonFactory extends JsonFactory {
    private static final long serialVersionUID = -6744103724013275513L;

    public MappingJsonFactory() {
        this(null);
    }

    public MappingJsonFactory(ObjectMapper objectMapper) {
        super(objectMapper);
        if (objectMapper == null) {
            setCodec(new ObjectMapper((JsonFactory) this));
        }
    }

    public final ObjectMapper getCodec() {
        return (ObjectMapper) this._objectCodec;
    }

    public JsonFactory copy() {
        _checkInvalidCopy(MappingJsonFactory.class);
        return new MappingJsonFactory(null);
    }

    public String getFormatName() {
        return JsonFactory.FORMAT_NAME_JSON;
    }

    public MatchStrength hasFormat(afm com_fossil_afm) throws IOException {
        if (getClass() == MappingJsonFactory.class) {
            return hasJSONFormat(com_fossil_afm);
        }
        return null;
    }
}
