package com.fossil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class aig {
    private final C1646b[] aRv;
    private final HashMap<String, Integer> aRw;
    private final String[] aRx;
    private final amt[] aRy;

    public static class C1645a {
        private final HashMap<String, Integer> aRw = new HashMap();
        private final ArrayList<C1646b> aRz = new ArrayList();

        public void m3388a(SettableBeanProperty settableBeanProperty, ajs com_fossil_ajs) {
            Integer valueOf = Integer.valueOf(this.aRz.size());
            this.aRz.add(new C1646b(settableBeanProperty, com_fossil_ajs));
            this.aRw.put(settableBeanProperty.getName(), valueOf);
            this.aRw.put(com_fossil_ajs.getPropertyName(), valueOf);
        }

        public aig ED() {
            return new aig((C1646b[]) this.aRz.toArray(new C1646b[this.aRz.size()]), this.aRw, null, null);
        }
    }

    static final class C1646b {
        private final ajs _typeDeserializer;
        private final String _typePropertyName;
        private final SettableBeanProperty aRA;

        public C1646b(SettableBeanProperty settableBeanProperty, ajs com_fossil_ajs) {
            this.aRA = settableBeanProperty;
            this._typeDeserializer = com_fossil_ajs;
            this._typePropertyName = com_fossil_ajs.getPropertyName();
        }

        public boolean bI(String str) {
            return str.equals(this._typePropertyName);
        }

        public boolean EE() {
            return this._typeDeserializer.getDefaultImpl() != null;
        }

        public String EF() {
            Class defaultImpl = this._typeDeserializer.getDefaultImpl();
            if (defaultImpl == null) {
                return null;
            }
            return this._typeDeserializer.getTypeIdResolver().mo1045a(null, defaultImpl);
        }

        public String EG() {
            return this._typePropertyName;
        }

        public SettableBeanProperty EH() {
            return this.aRA;
        }
    }

    protected aig(C1646b[] c1646bArr, HashMap<String, Integer> hashMap, String[] strArr, amt[] com_fossil_amtArr) {
        this.aRv = c1646bArr;
        this.aRw = hashMap;
        this.aRx = strArr;
        this.aRy = com_fossil_amtArr;
    }

    protected aig(aig com_fossil_aig) {
        this.aRv = com_fossil_aig.aRv;
        this.aRw = com_fossil_aig.aRw;
        int length = this.aRv.length;
        this.aRx = new String[length];
        this.aRy = new amt[length];
    }

    public aig EC() {
        return new aig(this);
    }

    public boolean m3393a(JsonParser jsonParser, DeserializationContext deserializationContext, String str, Object obj) throws IOException {
        Object obj2 = null;
        Integer num = (Integer) this.aRw.get(str);
        if (num == null) {
            return false;
        }
        int intValue = num.intValue();
        if (!this.aRv[intValue].bI(str)) {
            return false;
        }
        String text = jsonParser.getText();
        if (!(obj == null || this.aRy[intValue] == null)) {
            obj2 = 1;
        }
        if (obj2 != null) {
            m3392a(jsonParser, deserializationContext, obj, intValue, text);
            this.aRy[intValue] = null;
        } else {
            this.aRx[intValue] = text;
        }
        return true;
    }

    public boolean m3394b(JsonParser jsonParser, DeserializationContext deserializationContext, String str, Object obj) throws IOException {
        boolean z = false;
        Integer num = (Integer) this.aRw.get(str);
        if (num == null) {
            return false;
        }
        boolean z2;
        int intValue = num.intValue();
        if (this.aRv[intValue].bI(str)) {
            this.aRx[intValue] = jsonParser.getText();
            jsonParser.zT();
            if (obj == null || this.aRy[intValue] == null) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            amt com_fossil_amt = new amt(jsonParser);
            com_fossil_amt.mo1097b(jsonParser);
            this.aRy[intValue] = com_fossil_amt;
            if (!(obj == null || this.aRx[intValue] == null)) {
                z = true;
            }
            z2 = z;
        }
        if (z2) {
            String str2 = this.aRx[intValue];
            this.aRx[intValue] = null;
            m3392a(jsonParser, deserializationContext, obj, intValue, str2);
            this.aRy[intValue] = null;
        }
        return true;
    }

    public Object m3391a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        int length = this.aRv.length;
        for (int i = 0; i < length; i++) {
            String str = this.aRx[i];
            String str2;
            if (str == null) {
                amt com_fossil_amt = this.aRy[i];
                if (com_fossil_amt == null) {
                    continue;
                } else {
                    JsonToken Hv = com_fossil_amt.Hv();
                    if (Hv != null && Hv.isScalarValue()) {
                        JsonParser e = com_fossil_amt.m3933e(jsonParser);
                        e.zP();
                        SettableBeanProperty EH = this.aRv[i].EH();
                        Object deserializeIfNatural = ajs.deserializeIfNatural(e, deserializationContext, EH.getType());
                        if (deserializeIfNatural != null) {
                            EH.set(obj, deserializeIfNatural);
                        } else if (this.aRv[i].EE()) {
                            str = this.aRv[i].EF();
                        } else {
                            throw deserializationContext.mappingException("Missing external type id property '%s'", this.aRv[i].EG());
                        }
                    }
                    str2 = str;
                    m3392a(jsonParser, deserializationContext, obj, i, str2);
                }
            } else if (this.aRy[i] == null) {
                throw deserializationContext.mappingException("Missing property '%s' for external type id '%s'", this.aRv[i].EH().getName(), this.aRv[i].EG());
            } else {
                str2 = str;
                m3392a(jsonParser, deserializationContext, obj, i, str2);
            }
        }
        return obj;
    }

    public Object m3390a(JsonParser jsonParser, DeserializationContext deserializationContext, aik com_fossil_aik, aii com_fossil_aii) throws IOException {
        int i;
        int length = this.aRv.length;
        Object[] objArr = new Object[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = this.aRx[i2];
            if (str != null) {
                if (this.aRy[i2] == null) {
                    throw deserializationContext.mappingException("Missing property '%s' for external type id '%s'", this.aRv[i2].EH().getName(), this.aRv[i2].EG());
                }
                objArr[i2] = m3389a(jsonParser, deserializationContext, i2, str);
            } else if (this.aRy[i2] == null) {
                continue;
            } else if (this.aRv[i2].EE()) {
                str = this.aRv[i2].EF();
                objArr[i2] = m3389a(jsonParser, deserializationContext, i2, str);
            } else {
                throw deserializationContext.mappingException("Missing external type id property '%s'", this.aRv[i2].EG());
            }
        }
        for (i = 0; i < length; i++) {
            SettableBeanProperty EH = this.aRv[i].EH();
            if (com_fossil_aii.bJ(EH.getName()) != null) {
                com_fossil_aik.m3400a(EH, objArr[i]);
            }
        }
        Object a = com_fossil_aii.m3397a(deserializationContext, com_fossil_aik);
        for (i = 0; i < length; i++) {
            SettableBeanProperty EH2 = this.aRv[i].EH();
            if (com_fossil_aii.bJ(EH2.getName()) == null) {
                EH2.set(a, objArr[i]);
            }
        }
        return a;
    }

    protected final Object m3389a(JsonParser jsonParser, DeserializationContext deserializationContext, int i, String str) throws IOException {
        amt com_fossil_amt = new amt(jsonParser);
        com_fossil_amt.zH();
        com_fossil_amt.writeString(str);
        JsonParser e = this.aRy[i].m3933e(jsonParser);
        e.zP();
        com_fossil_amt.mo1097b(e);
        com_fossil_amt.zI();
        JsonParser e2 = com_fossil_amt.m3933e(jsonParser);
        e2.zP();
        return this.aRv[i].EH().deserialize(e2, deserializationContext);
    }

    protected final void m3392a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, int i, String str) throws IOException {
        amt com_fossil_amt = new amt(jsonParser);
        com_fossil_amt.zH();
        com_fossil_amt.writeString(str);
        JsonParser e = this.aRy[i].m3933e(jsonParser);
        e.zP();
        com_fossil_amt.mo1097b(e);
        com_fossil_amt.zI();
        JsonParser e2 = com_fossil_amt.m3933e(jsonParser);
        e2.zP();
        this.aRv[i].EH().deserializeAndSet(e2, deserializationContext, obj);
    }
}
