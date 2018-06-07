package com.fossil;

import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import java.util.List;

public class ale {
    private static final ald[] aUs = new ald[0];
    protected SerializationConfig _config;
    protected Object _filterId;
    protected als _objectIdWriter;
    protected AnnotatedMember _typeId;
    protected final agu aQQ;
    protected List<ald> aRW;
    protected ald[] aUt;
    protected alb aUu;

    public ale(agu com_fossil_agu) {
        this.aQQ = com_fossil_agu;
    }

    public void m3705a(SerializationConfig serializationConfig) {
        this._config = serializationConfig;
    }

    public void m3710w(List<ald> list) {
        this.aRW = list;
    }

    public void m3708a(ald[] com_fossil_aldArr) {
        this.aUt = com_fossil_aldArr;
    }

    public void m3706a(alb com_fossil_alb) {
        this.aUu = com_fossil_alb;
    }

    public void bC(Object obj) {
        this._filterId = obj;
    }

    public void m3709j(AnnotatedMember annotatedMember) {
        if (this._typeId != null) {
            throw new IllegalArgumentException("Multiple type ids specified with " + this._typeId + " and " + annotatedMember);
        }
        this._typeId = annotatedMember;
    }

    public void m3707a(als com_fossil_als) {
        this._objectIdWriter = com_fossil_als;
    }

    public agu GC() {
        return this.aQQ;
    }

    public List<ald> FD() {
        return this.aRW;
    }

    public alb GD() {
        return this.aUu;
    }

    public Object GE() {
        return this._filterId;
    }

    public AnnotatedMember GF() {
        return this._typeId;
    }

    public als GG() {
        return this._objectIdWriter;
    }

    public ahb<?> GH() {
        ald[] com_fossil_aldArr;
        if (this.aRW != null && !this.aRW.isEmpty()) {
            com_fossil_aldArr = (ald[]) this.aRW.toArray(new ald[this.aRW.size()]);
        } else if (this.aUu == null && this._objectIdWriter == null) {
            return null;
        } else {
            com_fossil_aldArr = aUs;
        }
        return new BeanSerializer(this.aQQ.getType(), this, com_fossil_aldArr, this.aUt);
    }

    public BeanSerializer GI() {
        return BeanSerializer.createDummy(this.aQQ.getType());
    }
}
