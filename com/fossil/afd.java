package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public abstract class afd {
    public abstract afe createArrayNode();

    public abstract afe createObjectNode();

    public abstract <T extends afe> T readTree(JsonParser jsonParser) throws IOException, JsonProcessingException;

    public abstract JsonParser treeAsTokens(afe com_fossil_afe);

    public abstract void writeTree(JsonGenerator jsonGenerator, afe com_fossil_afe) throws IOException, JsonProcessingException;
}
