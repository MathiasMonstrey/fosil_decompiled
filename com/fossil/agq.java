package com.fossil;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class agq extends agp {
    protected final JsonParser[] aPP;
    protected int aPQ = 1;

    protected agq(JsonParser[] jsonParserArr) {
        super(jsonParserArr[0]);
        this.aPP = jsonParserArr;
    }

    public static agq m3319a(JsonParser jsonParser, JsonParser jsonParser2) {
        if ((jsonParser instanceof agq) || (jsonParser2 instanceof agq)) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser instanceof agq) {
                ((agq) jsonParser).m3320v(arrayList);
            } else {
                arrayList.add(jsonParser);
            }
            if (jsonParser2 instanceof agq) {
                ((agq) jsonParser2).m3320v(arrayList);
            } else {
                arrayList.add(jsonParser2);
            }
            return new agq((JsonParser[]) arrayList.toArray(new JsonParser[arrayList.size()]));
        }
        return new agq(new JsonParser[]{jsonParser, jsonParser2});
    }

    protected void m3320v(List<JsonParser> list) {
        int i = this.aPQ - 1;
        int length = this.aPP.length;
        for (int i2 = i; i2 < length; i2++) {
            Object obj = this.aPP[i2];
            if (obj instanceof agq) {
                ((agq) obj).m3320v(list);
            } else {
                list.add(obj);
            }
        }
    }

    public void close() throws IOException {
        do {
            this.aPO.close();
        } while (CV());
    }

    public JsonToken zP() throws IOException, JsonParseException {
        JsonToken zP = this.aPO.zP();
        if (zP != null) {
            return zP;
        }
        while (CV()) {
            zP = this.aPO.zP();
            if (zP != null) {
                return zP;
            }
        }
        return null;
    }

    protected boolean CV() {
        if (this.aPQ >= this.aPP.length) {
            return false;
        }
        JsonParser[] jsonParserArr = this.aPP;
        int i = this.aPQ;
        this.aPQ = i + 1;
        this.aPO = jsonParserArr[i];
        return true;
    }
}
