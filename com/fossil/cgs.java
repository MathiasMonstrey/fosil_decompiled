package com.fossil;

import com.fossil.wearables.fsl.sleep.MFSleepGoal;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.bind.TypeAdapters.26;
import com.google.gson.internal.bind.TypeAdapters.30;
import com.google.gson.internal.bind.TypeAdapters.31;
import com.google.gson.internal.bind.TypeAdapters.32;
import com.google.gson.internal.bind.TypeAdapters.33;
import com.google.gson.internal.bind.TypeAdapters.34;
import com.google.gson.internal.bind.TypeAdapters.35;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class cgs {
    public static final cfw<Class> bSP = new C20521();
    public static final cfx bSQ = m6394a(Class.class, bSP);
    public static final cfw<BitSet> bSR = new cfw<BitSet>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6288u(com_fossil_cgv);
        }

        public BitSet m6288u(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            BitSet bitSet = new BitSet();
            com_fossil_cgv.beginArray();
            JsonToken WT = com_fossil_cgv.WT();
            int i = 0;
            while (WT != JsonToken.END_ARRAY) {
                boolean z;
                switch (AnonymousClass23.bSt[WT.ordinal()]) {
                    case 1:
                        if (com_fossil_cgv.nextInt() == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 2:
                        z = com_fossil_cgv.nextBoolean();
                        break;
                    case 3:
                        String nextString = com_fossil_cgv.nextString();
                        try {
                            if (Integer.parseInt(nextString) == 0) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + nextString);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + WT);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                WT = com_fossil_cgv.WT();
            }
            com_fossil_cgv.endArray();
            return bitSet;
        }

        public void m6286a(cgw com_fossil_cgw, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                com_fossil_cgw.Xe();
                return;
            }
            com_fossil_cgw.Xa();
            for (int i = 0; i < bitSet.length(); i++) {
                int i2;
                if (bitSet.get(i)) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                com_fossil_cgw.ax((long) i2);
            }
            com_fossil_cgw.Xb();
        }
    };
    public static final cfx bSS = m6394a(BitSet.class, bSR);
    public static final cfw<Boolean> bST = new cfw<Boolean>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6329F(com_fossil_cgv);
        }

        public Boolean m6329F(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            } else if (com_fossil_cgv.WT() == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(com_fossil_cgv.nextString()));
            } else {
                return Boolean.valueOf(com_fossil_cgv.nextBoolean());
            }
        }

        public void m6330a(cgw com_fossil_cgw, Boolean bool) throws IOException {
            com_fossil_cgw.mo1692c(bool);
        }
    };
    public static final cfw<Boolean> bSU = new cfw<Boolean>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6333F(com_fossil_cgv);
        }

        public Boolean m6333F(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() != JsonToken.NULL) {
                return Boolean.valueOf(com_fossil_cgv.nextString());
            }
            com_fossil_cgv.nextNull();
            return null;
        }

        public void m6334a(cgw com_fossil_cgw, Boolean bool) throws IOException {
            com_fossil_cgw.fv(bool == null ? "null" : bool.toString());
        }
    };
    public static final cfx bSV = m6395a(Boolean.TYPE, Boolean.class, bST);
    public static final cfw<Number> bSW = new cfw<Number>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6340d(com_fossil_cgv);
        }

        public Number m6340d(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) com_fossil_cgv.nextInt());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void m6337a(cgw com_fossil_cgw, Number number) throws IOException {
            com_fossil_cgw.mo1689a(number);
        }
    };
    public static final cfx bSX = m6395a(Byte.TYPE, Byte.class, bSW);
    public static final cfw<Number> bSY = new cfw<Number>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6344d(com_fossil_cgv);
        }

        public Number m6344d(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) com_fossil_cgv.nextInt());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void m6341a(cgw com_fossil_cgw, Number number) throws IOException {
            com_fossil_cgw.mo1689a(number);
        }
    };
    public static final cfx bSZ = m6395a(Short.TYPE, Short.class, bSY);
    public static final cfx bTA = m6394a(URI.class, bTz);
    public static final cfw<InetAddress> bTB = new cfw<InetAddress>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6304y(com_fossil_cgv);
        }

        public InetAddress m6304y(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() != JsonToken.NULL) {
                return InetAddress.getByName(com_fossil_cgv.nextString());
            }
            com_fossil_cgv.nextNull();
            return null;
        }

        public void m6302a(cgw com_fossil_cgw, InetAddress inetAddress) throws IOException {
            com_fossil_cgw.fv(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final cfx bTC = m6396b(InetAddress.class, bTB);
    public static final cfw<UUID> bTD = new cfw<UUID>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6308z(com_fossil_cgv);
        }

        public UUID m6308z(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() != JsonToken.NULL) {
                return UUID.fromString(com_fossil_cgv.nextString());
            }
            com_fossil_cgv.nextNull();
            return null;
        }

        public void m6306a(cgw com_fossil_cgw, UUID uuid) throws IOException {
            com_fossil_cgw.fv(uuid == null ? null : uuid.toString());
        }
    };
    public static final cfx bTE = m6394a(UUID.class, bTD);
    public static final cfw<Currency> bTF = new cfw<Currency>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6309A(com_fossil_cgv);
        }

        public Currency m6309A(cgv com_fossil_cgv) throws IOException {
            return Currency.getInstance(com_fossil_cgv.nextString());
        }

        public void m6311a(cgw com_fossil_cgw, Currency currency) throws IOException {
            com_fossil_cgw.fv(currency.getCurrencyCode());
        }
    }.WF();
    public static final cfx bTG = m6394a(Currency.class, bTF);
    public static final cfx bTH = new 26();
    public static final cfw<Calendar> bTI = new cfw<Calendar>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6313C(com_fossil_cgv);
        }

        public Calendar m6313C(cgv com_fossil_cgv) throws IOException {
            int i = 0;
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            com_fossil_cgv.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (com_fossil_cgv.WT() != JsonToken.END_OBJECT) {
                String nextName = com_fossil_cgv.nextName();
                int nextInt = com_fossil_cgv.nextInt();
                if ("year".equals(nextName)) {
                    i6 = nextInt;
                } else if ("month".equals(nextName)) {
                    i5 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i4 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i3 = nextInt;
                } else if (MFSleepGoal.COLUMN_MINUTE.equals(nextName)) {
                    i2 = nextInt;
                } else if ("second".equals(nextName)) {
                    i = nextInt;
                }
            }
            com_fossil_cgv.endObject();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }

        public void m6315a(cgw com_fossil_cgw, Calendar calendar) throws IOException {
            if (calendar == null) {
                com_fossil_cgw.Xe();
                return;
            }
            com_fossil_cgw.Xc();
            com_fossil_cgw.fu("year");
            com_fossil_cgw.ax((long) calendar.get(1));
            com_fossil_cgw.fu("month");
            com_fossil_cgw.ax((long) calendar.get(2));
            com_fossil_cgw.fu("dayOfMonth");
            com_fossil_cgw.ax((long) calendar.get(5));
            com_fossil_cgw.fu("hourOfDay");
            com_fossil_cgw.ax((long) calendar.get(11));
            com_fossil_cgw.fu(MFSleepGoal.COLUMN_MINUTE);
            com_fossil_cgw.ax((long) calendar.get(12));
            com_fossil_cgw.fu("second");
            com_fossil_cgw.ax((long) calendar.get(13));
            com_fossil_cgw.Xd();
        }
    };
    public static final cfx bTJ = m6397b(Calendar.class, GregorianCalendar.class, bTI);
    public static final cfw<Locale> bTK = new cfw<Locale>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6321D(com_fossil_cgv);
        }

        public Locale m6321D(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            String nextToken;
            String nextToken2;
            String nextToken3;
            StringTokenizer stringTokenizer = new StringTokenizer(com_fossil_cgv.nextString(), "_");
            if (stringTokenizer.hasMoreElements()) {
                nextToken = stringTokenizer.nextToken();
            } else {
                nextToken = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                nextToken2 = stringTokenizer.nextToken();
            } else {
                nextToken2 = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                nextToken3 = stringTokenizer.nextToken();
            } else {
                nextToken3 = null;
            }
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            if (nextToken3 == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, nextToken3);
        }

        public void m6323a(cgw com_fossil_cgw, Locale locale) throws IOException {
            com_fossil_cgw.fv(locale == null ? null : locale.toString());
        }
    };
    public static final cfx bTL = m6394a(Locale.class, bTK);
    public static final cfw<cfp> bTM = new cfw<cfp>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6325E(com_fossil_cgv);
        }

        public cfp m6325E(cgv com_fossil_cgv) throws IOException {
            cfp com_fossil_cfm;
            switch (AnonymousClass23.bSt[com_fossil_cgv.WT().ordinal()]) {
                case 1:
                    return new cft(new LazilyParsedNumber(com_fossil_cgv.nextString()));
                case 2:
                    return new cft(Boolean.valueOf(com_fossil_cgv.nextBoolean()));
                case 3:
                    return new cft(com_fossil_cgv.nextString());
                case 4:
                    com_fossil_cgv.nextNull();
                    return cfq.bRj;
                case 5:
                    com_fossil_cfm = new cfm();
                    com_fossil_cgv.beginArray();
                    while (com_fossil_cgv.hasNext()) {
                        com_fossil_cfm.m6210c(m6325E(com_fossil_cgv));
                    }
                    com_fossil_cgv.endArray();
                    return com_fossil_cfm;
                case 6:
                    com_fossil_cfm = new cfr();
                    com_fossil_cgv.beginObject();
                    while (com_fossil_cgv.hasNext()) {
                        com_fossil_cfm.m6212a(com_fossil_cgv.nextName(), m6325E(com_fossil_cgv));
                    }
                    com_fossil_cgv.endObject();
                    return com_fossil_cfm;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void m6326a(cgw com_fossil_cgw, cfp com_fossil_cfp) throws IOException {
            if (com_fossil_cfp == null || com_fossil_cfp.Wz()) {
                com_fossil_cgw.Xe();
            } else if (com_fossil_cfp.Wy()) {
                cft WC = com_fossil_cfp.WC();
                if (WC.DI()) {
                    com_fossil_cgw.mo1689a(WC.Wv());
                } else if (WC.isBoolean()) {
                    com_fossil_cgw.bG(WC.getAsBoolean());
                } else {
                    com_fossil_cgw.fv(WC.getAsString());
                }
            } else if (com_fossil_cfp.Ww()) {
                com_fossil_cgw.Xa();
                Iterator it = com_fossil_cfp.WB().iterator();
                while (it.hasNext()) {
                    m6326a(com_fossil_cgw, (cfp) it.next());
                }
                com_fossil_cgw.Xb();
            } else if (com_fossil_cfp.Wx()) {
                com_fossil_cgw.Xc();
                for (Entry entry : com_fossil_cfp.WA().entrySet()) {
                    com_fossil_cgw.fu((String) entry.getKey());
                    m6326a(com_fossil_cgw, (cfp) entry.getValue());
                }
                com_fossil_cgw.Xd();
            } else {
                throw new IllegalArgumentException("Couldn't write " + com_fossil_cfp.getClass());
            }
        }
    };
    public static final cfx bTN = m6396b(cfp.class, bTM);
    public static final cfx bTO = new 30();
    public static final cfw<Number> bTa = new cfw<Number>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6348d(com_fossil_cgv);
        }

        public Number m6348d(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(com_fossil_cgv.nextInt());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void m6345a(cgw com_fossil_cgw, Number number) throws IOException {
            com_fossil_cgw.mo1689a(number);
        }
    };
    public static final cfx bTb = m6395a(Integer.TYPE, Integer.class, bTa);
    public static final cfw<AtomicInteger> bTc = new cfw<AtomicInteger>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6349G(com_fossil_cgv);
        }

        public AtomicInteger m6349G(cgv com_fossil_cgv) throws IOException {
            try {
                return new AtomicInteger(com_fossil_cgv.nextInt());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void m6351a(cgw com_fossil_cgw, AtomicInteger atomicInteger) throws IOException {
            com_fossil_cgw.ax((long) atomicInteger.get());
        }
    }.WF();
    public static final cfx bTd = m6394a(AtomicInteger.class, bTc);
    public static final cfw<AtomicBoolean> bTe = new cfw<AtomicBoolean>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6353H(com_fossil_cgv);
        }

        public AtomicBoolean m6353H(cgv com_fossil_cgv) throws IOException {
            return new AtomicBoolean(com_fossil_cgv.nextBoolean());
        }

        public void m6355a(cgw com_fossil_cgw, AtomicBoolean atomicBoolean) throws IOException {
            com_fossil_cgw.bG(atomicBoolean.get());
        }
    }.WF();
    public static final cfx bTf = m6394a(AtomicBoolean.class, bTe);
    public static final cfw<AtomicIntegerArray> bTg = new C20532().WF();
    public static final cfx bTh = m6394a(AtomicIntegerArray.class, bTg);
    public static final cfw<Number> bTi = new C20543();
    public static final cfw<Number> bTj = new C20554();
    public static final cfw<Number> bTk = new C20565();
    public static final cfw<Number> bTl = new C20576();
    public static final cfx bTm = m6394a(Number.class, bTl);
    public static final cfw<Character> bTn = new C20587();
    public static final cfx bTo = m6395a(Character.TYPE, Character.class, bTn);
    public static final cfw<String> bTp = new C20598();
    public static final cfw<BigDecimal> bTq = new C20609();
    public static final cfw<BigInteger> bTr = new cfw<BigInteger>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6280s(com_fossil_cgv);
        }

        public BigInteger m6280s(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            try {
                return new BigInteger(com_fossil_cgv.nextString());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void m6278a(cgw com_fossil_cgw, BigInteger bigInteger) throws IOException {
            com_fossil_cgw.mo1689a(bigInteger);
        }
    };
    public static final cfx bTs = m6394a(String.class, bTp);
    public static final cfw<StringBuilder> bTt = new cfw<StringBuilder>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6284t(com_fossil_cgv);
        }

        public StringBuilder m6284t(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() != JsonToken.NULL) {
                return new StringBuilder(com_fossil_cgv.nextString());
            }
            com_fossil_cgv.nextNull();
            return null;
        }

        public void m6282a(cgw com_fossil_cgw, StringBuilder stringBuilder) throws IOException {
            com_fossil_cgw.fv(stringBuilder == null ? null : stringBuilder.toString());
        }
    };
    public static final cfx bTu = m6394a(StringBuilder.class, bTt);
    public static final cfw<StringBuffer> bTv = new cfw<StringBuffer>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6292v(com_fossil_cgv);
        }

        public StringBuffer m6292v(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() != JsonToken.NULL) {
                return new StringBuffer(com_fossil_cgv.nextString());
            }
            com_fossil_cgv.nextNull();
            return null;
        }

        public void m6290a(cgw com_fossil_cgw, StringBuffer stringBuffer) throws IOException {
            com_fossil_cgw.fv(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final cfx bTw = m6394a(StringBuffer.class, bTv);
    public static final cfw<URL> bTx = new cfw<URL>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6296w(com_fossil_cgv);
        }

        public URL m6296w(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            String nextString = com_fossil_cgv.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }

        public void m6294a(cgw com_fossil_cgw, URL url) throws IOException {
            com_fossil_cgw.fv(url == null ? null : url.toExternalForm());
        }
    };
    public static final cfx bTy = m6394a(URL.class, bTx);
    public static final cfw<URI> bTz = new cfw<URI>() {
        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6300x(com_fossil_cgv);
        }

        public URI m6300x(cgv com_fossil_cgv) throws IOException {
            URI uri = null;
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
            } else {
                try {
                    String nextString = com_fossil_cgv.nextString();
                    if (!"null".equals(nextString)) {
                        uri = new URI(nextString);
                    }
                } catch (Throwable e) {
                    throw new JsonIOException(e);
                }
            }
            return uri;
        }

        public void m6298a(cgw com_fossil_cgw, URI uri) throws IOException {
            com_fossil_cgw.fv(uri == null ? null : uri.toASCIIString());
        }
    };

    static class C20521 extends cfw<Class> {
        C20521() {
        }

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6320n(com_fossil_cgv);
        }

        public void m6317a(cgw com_fossil_cgw, Class cls) throws IOException {
            if (cls == null) {
                com_fossil_cgw.Xe();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        public Class m6320n(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    static /* synthetic */ class AnonymousClass23 {
        static final /* synthetic */ int[] bSt = new int[JsonToken.values().length];

        static {
            try {
                bSt[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                bSt[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                bSt[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                bSt[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                bSt[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                bSt[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                bSt[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                bSt[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                bSt[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                bSt[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    static class C20532 extends cfw<AtomicIntegerArray> {
        C20532() {
        }

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6360o(com_fossil_cgv);
        }

        public AtomicIntegerArray m6360o(cgv com_fossil_cgv) throws IOException {
            List arrayList = new ArrayList();
            com_fossil_cgv.beginArray();
            while (com_fossil_cgv.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(com_fossil_cgv.nextInt()));
                } catch (Throwable e) {
                    throw new JsonSyntaxException(e);
                }
            }
            com_fossil_cgv.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        public void m6358a(cgw com_fossil_cgw, AtomicIntegerArray atomicIntegerArray) throws IOException {
            com_fossil_cgw.Xa();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                com_fossil_cgw.ax((long) atomicIntegerArray.get(i));
            }
            com_fossil_cgw.Xb();
        }
    }

    static class C20543 extends cfw<Number> {
        C20543() {
        }

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6364d(com_fossil_cgv);
        }

        public Number m6364d(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            try {
                return Long.valueOf(com_fossil_cgv.nextLong());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void m6361a(cgw com_fossil_cgw, Number number) throws IOException {
            com_fossil_cgw.mo1689a(number);
        }
    }

    static class C20554 extends cfw<Number> {
        C20554() {
        }

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6368d(com_fossil_cgv);
        }

        public Number m6368d(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() != JsonToken.NULL) {
                return Float.valueOf((float) com_fossil_cgv.nextDouble());
            }
            com_fossil_cgv.nextNull();
            return null;
        }

        public void m6365a(cgw com_fossil_cgw, Number number) throws IOException {
            com_fossil_cgw.mo1689a(number);
        }
    }

    static class C20565 extends cfw<Number> {
        C20565() {
        }

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6372d(com_fossil_cgv);
        }

        public Number m6372d(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() != JsonToken.NULL) {
                return Double.valueOf(com_fossil_cgv.nextDouble());
            }
            com_fossil_cgv.nextNull();
            return null;
        }

        public void m6369a(cgw com_fossil_cgw, Number number) throws IOException {
            com_fossil_cgw.mo1689a(number);
        }
    }

    static class C20576 extends cfw<Number> {
        C20576() {
        }

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6376d(com_fossil_cgv);
        }

        public Number m6376d(cgv com_fossil_cgv) throws IOException {
            JsonToken WT = com_fossil_cgv.WT();
            switch (AnonymousClass23.bSt[WT.ordinal()]) {
                case 1:
                    return new LazilyParsedNumber(com_fossil_cgv.nextString());
                case 4:
                    com_fossil_cgv.nextNull();
                    return null;
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + WT);
            }
        }

        public void m6373a(cgw com_fossil_cgw, Number number) throws IOException {
            com_fossil_cgw.mo1689a(number);
        }
    }

    static class C20587 extends cfw<Character> {
        C20587() {
        }

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6380p(com_fossil_cgv);
        }

        public Character m6380p(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            String nextString = com_fossil_cgv.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + nextString);
        }

        public void m6377a(cgw com_fossil_cgw, Character ch) throws IOException {
            com_fossil_cgw.fv(ch == null ? null : String.valueOf(ch));
        }
    }

    static class C20598 extends cfw<String> {
        C20598() {
        }

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6384q(com_fossil_cgv);
        }

        public String m6384q(cgv com_fossil_cgv) throws IOException {
            JsonToken WT = com_fossil_cgv.WT();
            if (WT == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            } else if (WT == JsonToken.BOOLEAN) {
                return Boolean.toString(com_fossil_cgv.nextBoolean());
            } else {
                return com_fossil_cgv.nextString();
            }
        }

        public void m6382a(cgw com_fossil_cgw, String str) throws IOException {
            com_fossil_cgw.fv(str);
        }
    }

    static class C20609 extends cfw<BigDecimal> {
        C20609() {
        }

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6388r(com_fossil_cgv);
        }

        public BigDecimal m6388r(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            try {
                return new BigDecimal(com_fossil_cgv.nextString());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void m6386a(cgw com_fossil_cgw, BigDecimal bigDecimal) throws IOException {
            com_fossil_cgw.mo1689a(bigDecimal);
        }
    }

    public static final class C2061a<T extends Enum<T>> extends cfw<T> {
        private final Map<String, T> bTZ = new HashMap();
        private final Map<T, String> bUa = new HashMap();

        public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
            return m6389I(com_fossil_cgv);
        }

        public C2061a(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    cga com_fossil_cga = (cga) cls.getField(name).getAnnotation(cga.class);
                    if (com_fossil_cga != null) {
                        name = com_fossil_cga.value();
                        for (Object put : com_fossil_cga.WJ()) {
                            this.bTZ.put(put, enumR);
                        }
                    }
                    String str = name;
                    this.bTZ.put(str, enumR);
                    this.bUa.put(enumR, str);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        public T m6389I(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() != JsonToken.NULL) {
                return (Enum) this.bTZ.get(com_fossil_cgv.nextString());
            }
            com_fossil_cgv.nextNull();
            return null;
        }

        public void m6390a(cgw com_fossil_cgw, T t) throws IOException {
            com_fossil_cgw.fv(t == null ? null : (String) this.bUa.get(t));
        }
    }

    public static <TT> cfx m6393a(cgu<TT> com_fossil_cgu_TT, cfw<TT> com_fossil_cfw_TT) {
        return new 31(com_fossil_cgu_TT, com_fossil_cfw_TT);
    }

    public static <TT> cfx m6394a(Class<TT> cls, cfw<TT> com_fossil_cfw_TT) {
        return new 32(cls, com_fossil_cfw_TT);
    }

    public static <TT> cfx m6395a(Class<TT> cls, Class<TT> cls2, cfw<? super TT> com_fossil_cfw__super_TT) {
        return new 33(cls, cls2, com_fossil_cfw__super_TT);
    }

    public static <TT> cfx m6397b(Class<TT> cls, Class<? extends TT> cls2, cfw<? super TT> com_fossil_cfw__super_TT) {
        return new 34(cls, cls2, com_fossil_cfw__super_TT);
    }

    public static <T1> cfx m6396b(Class<T1> cls, cfw<T1> com_fossil_cfw_T1) {
        return new 35(cls, com_fossil_cfw_T1);
    }
}
