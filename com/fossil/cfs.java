package com.fossil;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.io.StringReader;

public final class cfs {
    public cfp fs(String str) throws JsonSyntaxException {
        return m6213b(new StringReader(str));
    }

    public cfp m6213b(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            cgv com_fossil_cgv = new cgv(reader);
            cfp g = m6214g(com_fossil_cgv);
            if (g.Wz() || com_fossil_cgv.WT() == JsonToken.END_DOCUMENT) {
                return g;
            }
            throw new JsonSyntaxException("Did not consume the entire document.");
        } catch (Throwable e) {
            throw new JsonSyntaxException(e);
        } catch (Throwable e2) {
            throw new JsonIOException(e2);
        } catch (Throwable e22) {
            throw new JsonSyntaxException(e22);
        }
    }

    public cfp m6214g(cgv com_fossil_cgv) throws JsonIOException, JsonSyntaxException {
        boolean isLenient = com_fossil_cgv.isLenient();
        com_fossil_cgv.setLenient(true);
        try {
            cfp g = cgi.m6243g(com_fossil_cgv);
            com_fossil_cgv.setLenient(isLenient);
            return g;
        } catch (Throwable e) {
            throw new JsonParseException("Failed parsing JSON source: " + com_fossil_cgv + " to Json", e);
        } catch (Throwable e2) {
            throw new JsonParseException("Failed parsing JSON source: " + com_fossil_cgv + " to Json", e2);
        } catch (Throwable th) {
            com_fossil_cgv.setLenient(isLenient);
        }
    }
}
