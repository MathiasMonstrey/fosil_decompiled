package com.fossil;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public final class alx {
    public Object aRQ;
    protected boolean aUW = false;
    public final ObjectIdGenerator<?> generator;

    public alx(ObjectIdGenerator<?> objectIdGenerator) {
        this.generator = objectIdGenerator;
    }

    public boolean m3798a(JsonGenerator jsonGenerator, ahg com_fossil_ahg, als com_fossil_als) throws IOException {
        if (this.aRQ == null || (!this.aUW && !com_fossil_als.aUE)) {
            return false;
        }
        if (jsonGenerator.zD()) {
            jsonGenerator.bo(String.valueOf(this.aRQ));
        } else {
            com_fossil_als.aUD.serialize(this.aRQ, jsonGenerator, com_fossil_ahg);
        }
        return true;
    }

    public Object generateId(Object obj) {
        Object generateId = this.generator.generateId(obj);
        this.aRQ = generateId;
        return generateId;
    }

    public void m3799b(JsonGenerator jsonGenerator, ahg com_fossil_ahg, als com_fossil_als) throws IOException {
        this.aUW = true;
        if (jsonGenerator.zD()) {
            jsonGenerator.bn(String.valueOf(this.aRQ));
            return;
        }
        afc com_fossil_afc = com_fossil_als.aUC;
        if (com_fossil_afc != null) {
            jsonGenerator.mo850b(com_fossil_afc);
            com_fossil_als.aUD.serialize(this.aRQ, jsonGenerator, com_fossil_ahg);
        }
    }
}
