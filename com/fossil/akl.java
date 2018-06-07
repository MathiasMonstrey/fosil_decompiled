package com.fossil;

import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.io.IOException;

public class akl extends ala {
    public static final akl aTA = new akl(false);
    public static final akl aTz = new akl(true);
    private final boolean aTB;

    private akl(boolean z) {
        this.aTB = z;
    }

    public static akl Gl() {
        return aTz;
    }

    public static akl Gm() {
        return aTA;
    }

    public JsonNodeType DG() {
        return JsonNodeType.BOOLEAN;
    }

    public JsonToken AE() {
        return this.aTB ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE;
    }

    public String DP() {
        return this.aTB ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
    }

    public final void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonProcessingException {
        jsonGenerator.writeBoolean(this.aTB);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof akl)) {
            return false;
        }
        if (this.aTB != ((akl) obj).aTB) {
            return false;
        }
        return true;
    }
}
