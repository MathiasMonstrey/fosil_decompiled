package com.fossil;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import java.util.HashMap;
import java.util.Map;

public class aev implements aeu {
    protected Map<IdKey, Object> aLl;

    public void mo842a(IdKey idKey, Object obj) {
        if (this.aLl == null) {
            this.aLl = new HashMap();
        } else if (this.aLl.containsKey(idKey)) {
            throw new IllegalStateException("Already had POJO for id (" + idKey.key.getClass().getName() + ") [" + idKey + "]");
        }
        this.aLl.put(idKey, obj);
    }

    public Object mo841a(IdKey idKey) {
        return this.aLl == null ? null : this.aLl.get(idKey);
    }

    public boolean mo843a(aeu com_fossil_aeu) {
        return com_fossil_aeu.getClass() == getClass();
    }

    public aeu bl(Object obj) {
        return new aev();
    }
}
