package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TypeParser implements Serializable {
    private static final long serialVersionUID = 1;
    protected final TypeFactory _factory;

    static final class C1528a extends StringTokenizer {
        protected int _index;
        protected final String aVr;
        protected String aVs;

        public C1528a(String str) {
            super(str, "<,>", true);
            this.aVr = str;
        }

        public boolean hasMoreTokens() {
            return this.aVs != null || super.hasMoreTokens();
        }

        public String nextToken() {
            String str;
            if (this.aVs != null) {
                str = this.aVs;
                this.aVs = null;
            } else {
                str = super.nextToken();
            }
            this._index += str.length();
            return str;
        }

        public void ca(String str) {
            this.aVs = str;
            this._index -= str.length();
        }

        public String Ha() {
            return this.aVr;
        }

        public String Hb() {
            return this.aVr.substring(this._index);
        }
    }

    public TypeParser(TypeFactory typeFactory) {
        this._factory = typeFactory;
    }

    public JavaType parse(String str) throws IllegalArgumentException {
        C1528a c1528a = new C1528a(str.trim());
        JavaType parseType = parseType(c1528a);
        if (!c1528a.hasMoreTokens()) {
            return parseType;
        }
        throw _problem(c1528a, "Unexpected tokens after complete type");
    }

    protected JavaType parseType(C1528a c1528a) throws IllegalArgumentException {
        if (c1528a.hasMoreTokens()) {
            Class findClass = findClass(c1528a.nextToken(), c1528a);
            if (c1528a.hasMoreTokens()) {
                String nextToken = c1528a.nextToken();
                if (SimpleComparison.LESS_THAN_OPERATION.equals(nextToken)) {
                    return this._factory._fromParameterizedClass(findClass, parseTypes(c1528a));
                }
                c1528a.ca(nextToken);
            }
            return this._factory._fromClass(findClass, null);
        }
        throw _problem(c1528a, "Unexpected end-of-string");
    }

    protected List<JavaType> parseTypes(C1528a c1528a) throws IllegalArgumentException {
        List arrayList = new ArrayList();
        while (c1528a.hasMoreTokens()) {
            arrayList.add(parseType(c1528a));
            if (!c1528a.hasMoreTokens()) {
                break;
            }
            String nextToken = c1528a.nextToken();
            if (SimpleComparison.GREATER_THAN_OPERATION.equals(nextToken)) {
                return arrayList;
            }
            if (!",".equals(nextToken)) {
                throw _problem(c1528a, "Unexpected token '" + nextToken + "', expected ',' or '>')");
            }
        }
        throw _problem(c1528a, "Unexpected end-of-string");
    }

    protected Class<?> findClass(String str, C1528a c1528a) {
        try {
            return this._factory.findClass(str);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            }
            throw _problem(c1528a, "Can not locate class '" + str + "', problem: " + e.getMessage());
        }
    }

    protected IllegalArgumentException _problem(C1528a c1528a, String str) {
        return new IllegalArgumentException("Failed to parse type '" + c1528a.Ha() + "' (remaining: '" + c1528a.Hb() + "'): " + str);
    }
}
