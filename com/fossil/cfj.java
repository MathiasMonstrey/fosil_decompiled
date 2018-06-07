package com.fossil;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class cfj {
    private static final cgu<?> bQI = new C20241();
    private final ThreadLocal<Map<cgu<?>, C2030a<?>>> bQJ;
    private final Map<cgu<?>, cfw<?>> bQK;
    private final List<cfx> bQL;
    private final cge bQM;
    private final Excluder bQN;
    private final cfi bQO;
    private final boolean bQP;
    private final boolean bQQ;
    private final boolean bQR;
    private final boolean bQS;
    private final boolean bQT;
    private final JsonAdapterAnnotationTypeAdapterFactory bQU;

    static class C20241 extends cgu<Object> {
        C20241() {
        }
    }

    class C20252 extends cfw<Number> {
        final /* synthetic */ cfj bQV;

        C20252(cfj com_fossil_cfj) {
            this.bQV = com_fossil_cfj;
        }

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6160a(com_fossil_cgv);
        }

        public Double m6160a(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() != JsonToken.NULL) {
                return Double.valueOf(com_fossil_cgv.nextDouble());
            }
            com_fossil_cgv.nextNull();
            return null;
        }

        public void m6161a(cgw com_fossil_cgw, Number number) throws IOException {
            if (number == null) {
                com_fossil_cgw.Xe();
                return;
            }
            cfj.m6187g(number.doubleValue());
            com_fossil_cgw.mo1689a(number);
        }
    }

    class C20263 extends cfw<Number> {
        final /* synthetic */ cfj bQV;

        C20263(cfj com_fossil_cfj) {
            this.bQV = com_fossil_cfj;
        }

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6167c(com_fossil_cgv);
        }

        public Float m6167c(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() != JsonToken.NULL) {
                return Float.valueOf((float) com_fossil_cgv.nextDouble());
            }
            com_fossil_cgv.nextNull();
            return null;
        }

        public void m6164a(cgw com_fossil_cgw, Number number) throws IOException {
            if (number == null) {
                com_fossil_cgw.Xe();
                return;
            }
            cfj.m6187g((double) number.floatValue());
            com_fossil_cgw.mo1689a(number);
        }
    }

    static class C20274 extends cfw<Number> {
        C20274() {
        }

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6171d(com_fossil_cgv);
        }

        public Number m6171d(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() != JsonToken.NULL) {
                return Long.valueOf(com_fossil_cgv.nextLong());
            }
            com_fossil_cgv.nextNull();
            return null;
        }

        public void m6168a(cgw com_fossil_cgw, Number number) throws IOException {
            if (number == null) {
                com_fossil_cgw.Xe();
            } else {
                com_fossil_cgw.fv(number.toString());
            }
        }
    }

    static class C2030a<T> extends cfw<T> {
        private cfw<T> bQX;

        C2030a() {
        }

        public void m6182c(cfw<T> com_fossil_cfw_T) {
            if (this.bQX != null) {
                throw new AssertionError();
            }
            this.bQX = com_fossil_cfw_T;
        }

        public T mo1657b(cgv com_fossil_cgv) throws IOException {
            if (this.bQX != null) {
                return this.bQX.mo1657b(com_fossil_cgv);
            }
            throw new IllegalStateException();
        }

        public void mo1656a(cgw com_fossil_cgw, T t) throws IOException {
            if (this.bQX == null) {
                throw new IllegalStateException();
            }
            this.bQX.mo1656a(com_fossil_cgw, t);
        }
    }

    public cfj() {
        this(Excluder.bRv, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    cfj(Excluder excluder, cfi com_fossil_cfi, Map<Type, cfl<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<cfx> list) {
        this.bQJ = new ThreadLocal();
        this.bQK = new ConcurrentHashMap();
        this.bQM = new cge(map);
        this.bQN = excluder;
        this.bQO = com_fossil_cfi;
        this.bQP = z;
        this.bQR = z3;
        this.bQQ = z4;
        this.bQS = z5;
        this.bQT = z6;
        List arrayList = new ArrayList();
        arrayList.add(cgs.bTN);
        arrayList.add(cgo.bSa);
        arrayList.add(excluder);
        arrayList.addAll(list);
        arrayList.add(cgs.bTs);
        arrayList.add(cgs.bTb);
        arrayList.add(cgs.bSV);
        arrayList.add(cgs.bSX);
        arrayList.add(cgs.bSZ);
        cfw a = m6184a(longSerializationPolicy);
        arrayList.add(cgs.m6395a(Long.TYPE, Long.class, a));
        arrayList.add(cgs.m6395a(Double.TYPE, Double.class, bE(z7)));
        arrayList.add(cgs.m6395a(Float.TYPE, Float.class, bF(z7)));
        arrayList.add(cgs.bTm);
        arrayList.add(cgs.bTd);
        arrayList.add(cgs.bTf);
        arrayList.add(cgs.m6394a(AtomicLong.class, m6183a(a)));
        arrayList.add(cgs.m6394a(AtomicLongArray.class, m6186b(a)));
        arrayList.add(cgs.bTh);
        arrayList.add(cgs.bTo);
        arrayList.add(cgs.bTu);
        arrayList.add(cgs.bTw);
        arrayList.add(cgs.m6394a(BigDecimal.class, cgs.bTq));
        arrayList.add(cgs.m6394a(BigInteger.class, cgs.bTr));
        arrayList.add(cgs.bTy);
        arrayList.add(cgs.bTA);
        arrayList.add(cgs.bTE);
        arrayList.add(cgs.bTG);
        arrayList.add(cgs.bTL);
        arrayList.add(cgs.bTC);
        arrayList.add(cgs.bSS);
        arrayList.add(cgl.bSa);
        arrayList.add(cgs.bTJ);
        arrayList.add(cgq.bSa);
        arrayList.add(cgp.bSa);
        arrayList.add(cgs.bTH);
        arrayList.add(cgk.bSa);
        arrayList.add(cgs.bSQ);
        arrayList.add(new CollectionTypeAdapterFactory(this.bQM));
        arrayList.add(new MapTypeAdapterFactory(this.bQM, z2));
        this.bQU = new JsonAdapterAnnotationTypeAdapterFactory(this.bQM);
        arrayList.add(this.bQU);
        arrayList.add(cgs.bTO);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.bQM, com_fossil_cfi, excluder, this.bQU));
        this.bQL = Collections.unmodifiableList(arrayList);
    }

    private cfw<Number> bE(boolean z) {
        if (z) {
            return cgs.bTk;
        }
        return new C20252(this);
    }

    private cfw<Number> bF(boolean z) {
        if (z) {
            return cgs.bTj;
        }
        return new C20263(this);
    }

    static void m6187g(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static cfw<Number> m6184a(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return cgs.bTi;
        }
        return new C20274();
    }

    private static cfw<AtomicLong> m6183a(final cfw<Number> com_fossil_cfw_java_lang_Number) {
        return new cfw<AtomicLong>() {
            public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
                return m6175e(com_fossil_cgv);
            }

            public void m6173a(cgw com_fossil_cgw, AtomicLong atomicLong) throws IOException {
                com_fossil_cfw_java_lang_Number.mo1656a(com_fossil_cgw, Long.valueOf(atomicLong.get()));
            }

            public AtomicLong m6175e(cgv com_fossil_cgv) throws IOException {
                return new AtomicLong(((Number) com_fossil_cfw_java_lang_Number.mo1657b(com_fossil_cgv)).longValue());
            }
        }.WF();
    }

    private static cfw<AtomicLongArray> m6186b(final cfw<Number> com_fossil_cfw_java_lang_Number) {
        return new cfw<AtomicLongArray>() {
            public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
                return m6179f(com_fossil_cgv);
            }

            public void m6177a(cgw com_fossil_cgw, AtomicLongArray atomicLongArray) throws IOException {
                com_fossil_cgw.Xa();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    com_fossil_cfw_java_lang_Number.mo1656a(com_fossil_cgw, Long.valueOf(atomicLongArray.get(i)));
                }
                com_fossil_cgw.Xb();
            }

            public AtomicLongArray m6179f(cgv com_fossil_cgv) throws IOException {
                List arrayList = new ArrayList();
                com_fossil_cgv.beginArray();
                while (com_fossil_cgv.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) com_fossil_cfw_java_lang_Number.mo1657b(com_fossil_cgv)).longValue()));
                }
                com_fossil_cgv.endArray();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.WF();
    }

    public <T> cfw<T> m6190a(cgu<T> com_fossil_cgu_T) {
        Object obj;
        Map map;
        Map map2 = this.bQK;
        if (com_fossil_cgu_T == null) {
            obj = bQI;
        } else {
            cgu<T> com_fossil_cgu_T2 = com_fossil_cgu_T;
        }
        cfw<T> com_fossil_cfw_T = (cfw) map2.get(obj);
        if (com_fossil_cfw_T == null) {
            Map map3 = (Map) this.bQJ.get();
            Object obj2 = null;
            if (map3 == null) {
                HashMap hashMap = new HashMap();
                this.bQJ.set(hashMap);
                map = hashMap;
                obj2 = 1;
            } else {
                map = map3;
            }
            C2030a c2030a = (C2030a) map.get(com_fossil_cgu_T);
            if (c2030a == null) {
                try {
                    C2030a c2030a2 = new C2030a();
                    map.put(com_fossil_cgu_T, c2030a2);
                    for (cfx a : this.bQL) {
                        com_fossil_cfw_T = a.m6220a(this, com_fossil_cgu_T);
                        if (com_fossil_cfw_T != null) {
                            c2030a2.m6182c(com_fossil_cfw_T);
                            this.bQK.put(com_fossil_cgu_T, com_fossil_cfw_T);
                            map.remove(com_fossil_cgu_T);
                            if (obj2 != null) {
                                this.bQJ.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + com_fossil_cgu_T);
                } catch (Throwable th) {
                    map.remove(com_fossil_cgu_T);
                    if (obj2 != null) {
                        this.bQJ.remove();
                    }
                }
            }
        }
        return com_fossil_cfw_T;
    }

    public <T> cfw<T> m6189a(cfx com_fossil_cfx, cgu<T> com_fossil_cgu_T) {
        if (!this.bQL.contains(com_fossil_cfx)) {
            com_fossil_cfx = this.bQU;
        }
        Object obj = null;
        for (cfx com_fossil_cfx2 : this.bQL) {
            if (obj != null) {
                cfw<T> a = com_fossil_cfx2.m6220a(this, com_fossil_cgu_T);
                if (a != null) {
                    return a;
                }
            } else if (com_fossil_cfx2 == com_fossil_cfx) {
                obj = 1;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + com_fossil_cgu_T);
    }

    public <T> cfw<T> aa(Class<T> cls) {
        return m6190a(cgu.get((Class) cls));
    }

    public cfp cF(Object obj) {
        if (obj == null) {
            return cfq.bRj;
        }
        return m6188a(obj, obj.getClass());
    }

    public cfp m6188a(Object obj, Type type) {
        cgw com_fossil_cgn = new cgn();
        m6201a(obj, type, com_fossil_cgn);
        return com_fossil_cgn.WY();
    }

    public String toJson(Object obj) {
        if (obj == null) {
            return m6203b(cfq.bRj);
        }
        return m6204b(obj, obj.getClass());
    }

    public String m6204b(Object obj, Type type) {
        Appendable stringWriter = new StringWriter();
        m6202a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void m6200a(Object obj, Appendable appendable) throws JsonIOException {
        if (obj != null) {
            m6202a(obj, obj.getClass(), appendable);
        } else {
            m6199a(cfq.bRj, appendable);
        }
    }

    public void m6202a(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            m6201a(obj, type, m6192a(cgi.m6241a(appendable)));
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    public void m6201a(Object obj, Type type, cgw com_fossil_cgw) throws JsonIOException {
        cfw a = m6190a(cgu.get(type));
        boolean isLenient = com_fossil_cgw.isLenient();
        com_fossil_cgw.setLenient(true);
        boolean Xo = com_fossil_cgw.Xo();
        com_fossil_cgw.bI(this.bQQ);
        boolean Xp = com_fossil_cgw.Xp();
        com_fossil_cgw.bJ(this.bQP);
        try {
            a.mo1656a(com_fossil_cgw, obj);
            com_fossil_cgw.setLenient(isLenient);
            com_fossil_cgw.bI(Xo);
            com_fossil_cgw.bJ(Xp);
        } catch (Throwable e) {
            throw new JsonIOException(e);
        } catch (Throwable th) {
            com_fossil_cgw.setLenient(isLenient);
            com_fossil_cgw.bI(Xo);
            com_fossil_cgw.bJ(Xp);
        }
    }

    public String m6203b(cfp com_fossil_cfp) {
        Appendable stringWriter = new StringWriter();
        m6199a(com_fossil_cfp, stringWriter);
        return stringWriter.toString();
    }

    public void m6199a(cfp com_fossil_cfp, Appendable appendable) throws JsonIOException {
        try {
            m6198a(com_fossil_cfp, m6192a(cgi.m6241a(appendable)));
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    public cgw m6192a(Writer writer) throws IOException {
        if (this.bQR) {
            writer.write(")]}'\n");
        }
        cgw com_fossil_cgw = new cgw(writer);
        if (this.bQS) {
            com_fossil_cgw.setIndent("  ");
        }
        com_fossil_cgw.bJ(this.bQP);
        return com_fossil_cgw;
    }

    public cgv m6191a(Reader reader) {
        cgv com_fossil_cgv = new cgv(reader);
        com_fossil_cgv.setLenient(this.bQT);
        return com_fossil_cgv;
    }

    public void m6198a(cfp com_fossil_cfp, cgw com_fossil_cgw) throws JsonIOException {
        boolean isLenient = com_fossil_cgw.isLenient();
        com_fossil_cgw.setLenient(true);
        boolean Xo = com_fossil_cgw.Xo();
        com_fossil_cgw.bI(this.bQQ);
        boolean Xp = com_fossil_cgw.Xp();
        com_fossil_cgw.bJ(this.bQP);
        try {
            cgi.m6242b(com_fossil_cfp, com_fossil_cgw);
            com_fossil_cgw.setLenient(isLenient);
            com_fossil_cgw.bI(Xo);
            com_fossil_cgw.bJ(Xp);
        } catch (Throwable e) {
            throw new JsonIOException(e);
        } catch (Throwable th) {
            com_fossil_cgw.setLenient(isLenient);
            com_fossil_cgw.bI(Xo);
            com_fossil_cgw.bJ(Xp);
        }
    }

    public <T> T m6205c(String str, Class<T> cls) throws JsonSyntaxException {
        return cgh.m6238N(cls).cast(m6197a(str, (Type) cls));
    }

    public <T> T m6197a(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return m6196a(new StringReader(str), type);
    }

    public <T> T m6196a(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        cgv a = m6191a(reader);
        Object a2 = m6195a(a, type);
        m6185a(a2, a);
        return a2;
    }

    private static void m6185a(Object obj, cgv com_fossil_cgv) {
        if (obj != null) {
            try {
                if (com_fossil_cgv.WT() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            } catch (Throwable e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    public <T> T m6195a(cgv com_fossil_cgv, Type type) throws JsonIOException, JsonSyntaxException {
        boolean z = true;
        boolean isLenient = com_fossil_cgv.isLenient();
        com_fossil_cgv.setLenient(true);
        try {
            com_fossil_cgv.WT();
            z = false;
            T b = m6190a(cgu.get(type)).mo1657b(com_fossil_cgv);
            com_fossil_cgv.setLenient(isLenient);
            return b;
        } catch (Throwable e) {
            if (z) {
                com_fossil_cgv.setLenient(isLenient);
                return null;
            }
            throw new JsonSyntaxException(e);
        } catch (Throwable e2) {
            throw new JsonSyntaxException(e2);
        } catch (Throwable e22) {
            throw new JsonSyntaxException(e22);
        } catch (Throwable th) {
            com_fossil_cgv.setLenient(isLenient);
        }
    }

    public <T> T m6193a(cfp com_fossil_cfp, Class<T> cls) throws JsonSyntaxException {
        return cgh.m6238N(cls).cast(m6194a(com_fossil_cfp, (Type) cls));
    }

    public <T> T m6194a(cfp com_fossil_cfp, Type type) throws JsonSyntaxException {
        if (com_fossil_cfp == null) {
            return null;
        }
        return m6195a(new cgm(com_fossil_cfp), type);
    }

    public String toString() {
        return "{serializeNulls:" + this.bQP + "factories:" + this.bQL + ",instanceCreators:" + this.bQM + "}";
    }
}
