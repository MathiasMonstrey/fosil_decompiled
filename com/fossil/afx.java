package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import java.util.HashSet;

public class afx {
    protected final Object aOa;
    protected String aOb;
    protected String aOc;
    protected HashSet<String> aOd;

    private afx(Object obj) {
        this.aOa = obj;
    }

    public static afx m3181d(JsonParser jsonParser) {
        return new afx(jsonParser);
    }

    public static afx m3180a(JsonGenerator jsonGenerator) {
        return new afx(jsonGenerator);
    }

    public afx BO() {
        return new afx(this.aOa);
    }

    public void reset() {
        this.aOb = null;
        this.aOc = null;
        this.aOd = null;
    }

    public JsonLocation BP() {
        if (this.aOa instanceof JsonParser) {
            return ((JsonParser) this.aOa).zZ();
        }
        return null;
    }

    public boolean bp(String str) throws JsonParseException {
        if (this.aOb == null) {
            this.aOb = str;
            return false;
        } else if (str.equals(this.aOb)) {
            return true;
        } else {
            if (this.aOc == null) {
                this.aOc = str;
                return false;
            } else if (str.equals(this.aOc)) {
                return true;
            } else {
                if (this.aOd == null) {
                    this.aOd = new HashSet(16);
                    this.aOd.add(this.aOb);
                    this.aOd.add(this.aOc);
                }
                if (this.aOd.add(str)) {
                    return false;
                }
                return true;
            }
        }
    }
}
