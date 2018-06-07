package com.fossil;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

public abstract class afh extends JsonParser {
    protected JsonToken aMA;
    protected JsonToken aMB;

    protected abstract void AQ() throws JsonParseException;

    public abstract String getText() throws IOException;

    public abstract JsonToken zP() throws IOException;

    public abstract String zW() throws IOException;

    protected afh(int i) {
        super(i);
    }

    public JsonToken zU() {
        return this.aMA;
    }

    public int zV() {
        JsonToken jsonToken = this.aMA;
        return jsonToken == null ? 0 : jsonToken.id();
    }

    public boolean fn(int i) {
        JsonToken jsonToken = this.aMA;
        if (jsonToken == null) {
            if (i == 0) {
                return true;
            }
            return false;
        } else if (jsonToken.id() != i) {
            return false;
        } else {
            return true;
        }
    }

    public boolean mo865a(JsonToken jsonToken) {
        return this.aMA == jsonToken;
    }

    public boolean Aa() {
        return this.aMA == JsonToken.START_ARRAY;
    }

    public boolean Ab() {
        return this.aMA == JsonToken.START_OBJECT;
    }

    public JsonToken zQ() throws IOException {
        JsonToken zP = zP();
        if (zP == JsonToken.FIELD_NAME) {
            return zP();
        }
        return zP;
    }

    public JsonParser zT() throws IOException {
        if (this.aMA == JsonToken.START_OBJECT || this.aMA == JsonToken.START_ARRAY) {
            int i = 1;
            while (true) {
                JsonToken zP = zP();
                if (zP == null) {
                    break;
                } else if (zP.isStructStart()) {
                    i++;
                } else if (zP.isStructEnd()) {
                    i--;
                    if (i == 0) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            AQ();
        }
        return this;
    }

    public void Ac() {
        if (this.aMA != null) {
            this.aMB = this.aMA;
            this.aMA = null;
        }
    }

    public int As() throws IOException {
        JsonToken jsonToken = this.aMA;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
            return getIntValue();
        }
        if (jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return getIntValue();
        }
        return fo(0);
    }

    public int fo(int i) throws IOException {
        JsonToken jsonToken = this.aMA;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
            return getIntValue();
        }
        if (jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return getIntValue();
        }
        if (jsonToken == null) {
            return i;
        }
        switch (jsonToken.id()) {
            case 6:
                String text = getText();
                if (_hasTextualNull(text)) {
                    return 0;
                }
                return afr.m3164i(text, i);
            case 9:
                return 1;
            case 10:
                return 0;
            case 11:
                return 0;
            case 12:
                Object Aq = Aq();
                if (Aq instanceof Number) {
                    return ((Number) Aq).intValue();
                }
                return i;
            default:
                return i;
        }
    }

    public long At() throws IOException {
        JsonToken jsonToken = this.aMA;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
            return Al();
        }
        if (jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Al();
        }
        return getValueAsLong(0);
    }

    public long getValueAsLong(long j) throws IOException {
        JsonToken jsonToken = this.aMA;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
            return Al();
        }
        if (jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Al();
        }
        if (jsonToken == null) {
            return j;
        }
        switch (jsonToken.id()) {
            case 6:
                String text = getText();
                if (_hasTextualNull(text)) {
                    return 0;
                }
                return afr.m3160c(text, j);
            case 9:
                return 1;
            case 10:
            case 11:
                return 0;
            case 12:
                Object Aq = Aq();
                if (Aq instanceof Number) {
                    return ((Number) Aq).longValue();
                }
                return j;
            default:
                return j;
        }
    }

    public String Au() throws IOException {
        if (this.aMA == JsonToken.VALUE_STRING) {
            return getText();
        }
        if (this.aMA == JsonToken.FIELD_NAME) {
            return zW();
        }
        return aY(null);
    }

    public String aY(String str) throws IOException {
        if (this.aMA == JsonToken.VALUE_STRING) {
            return getText();
        }
        if (this.aMA == JsonToken.FIELD_NAME) {
            return zW();
        }
        return (this.aMA == null || this.aMA == JsonToken.VALUE_NULL || !this.aMA.isScalarValue()) ? str : getText();
    }

    protected void m3107a(String str, agn com_fossil_agn, Base64Variant base64Variant) throws IOException {
        try {
            base64Variant.decode(str, com_fossil_agn);
        } catch (IllegalArgumentException e) {
            aX(e.getMessage());
        }
    }

    protected boolean _hasTextualNull(String str) {
        return "null".equals(str);
    }

    protected void m3112h(int i, String str) throws JsonParseException {
        if (i < 0) {
            Bc();
        }
        String str2 = "Unexpected character (" + fu(i) + ")";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        aX(str2);
    }

    protected void Bc() throws JsonParseException {
        bg(" in " + this.aMA);
    }

    protected void bg(String str) throws JsonParseException {
        aX("Unexpected end-of-input" + str);
    }

    protected void Bd() throws JsonParseException {
        bg(" in a value");
    }

    protected void fs(int i) throws JsonParseException {
        m3112h(i, "Expected space separating root-level values");
    }

    protected void ft(int i) throws JsonParseException {
        aX("Illegal character (" + fu((char) i) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    protected void m3113i(int i, String str) throws JsonParseException {
        if (!isEnabled(Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i > 32) {
            aX("Illegal unquoted character (" + fu((char) i) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    protected char m3110b(char c) throws JsonProcessingException {
        if (!(isEnabled(Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER) || (c == '\'' && isEnabled(Feature.ALLOW_SINGLE_QUOTES)))) {
            aX("Unrecognized character escape " + fu(c));
        }
        return c;
    }

    protected static final String fu(int i) {
        char c = (char) i;
        if (Character.isISOControl(c)) {
            return "(CTRL-CHAR, code " + i + ")";
        }
        if (i > 255) {
            return "'" + c + "' (code " + i + " / 0x" + Integer.toHexString(i) + ")";
        }
        return "'" + c + "' (code " + i + ")";
    }

    protected final void aX(String str) throws JsonParseException {
        throw aZ(str);
    }

    protected final void m3108a(String str, Throwable th) throws JsonParseException {
        throw m3111b(str, th);
    }

    protected final void zN() {
        ags.Dk();
    }

    protected final JsonParseException m3111b(String str, Throwable th) {
        return new JsonParseException(str, zZ(), th);
    }
}
