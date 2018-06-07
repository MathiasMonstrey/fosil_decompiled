package com.fossil;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import java.io.IOException;
import java.util.Iterator;

public abstract class afa extends afd {
    public abstract afe createArrayNode();

    public abstract afe createObjectNode();

    public abstract <T extends afe> T readTree(JsonParser jsonParser) throws IOException, JsonProcessingException;

    public abstract <T> T readValue(JsonParser jsonParser, agk com_fossil_agk) throws IOException, JsonProcessingException;

    public abstract <T> T readValue(JsonParser jsonParser, agl<?> com_fossil_agl_) throws IOException, JsonProcessingException;

    public abstract <T> T readValue(JsonParser jsonParser, Class<T> cls) throws IOException, JsonProcessingException;

    public abstract <T> Iterator<T> readValues(JsonParser jsonParser, agk com_fossil_agk) throws IOException, JsonProcessingException;

    public abstract <T> Iterator<T> readValues(JsonParser jsonParser, agl<?> com_fossil_agl_) throws IOException, JsonProcessingException;

    public abstract <T> Iterator<T> readValues(JsonParser jsonParser, Class<T> cls) throws IOException, JsonProcessingException;

    public abstract JsonParser treeAsTokens(afe com_fossil_afe);

    public abstract <T> T treeToValue(afe com_fossil_afe, Class<T> cls) throws JsonProcessingException;

    public abstract void writeTree(JsonGenerator jsonGenerator, afe com_fossil_afe) throws IOException, JsonProcessingException;

    public abstract void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonProcessingException;

    protected afa() {
    }

    public Version version() {
        return Version.unknownVersion();
    }

    @Deprecated
    public JsonFactory getJsonFactory() {
        return getFactory();
    }

    public JsonFactory getFactory() {
        return getJsonFactory();
    }
}
