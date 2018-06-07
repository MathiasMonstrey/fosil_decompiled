package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfo;
import com.fossil.cfv;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cfz;
import com.fossil.cge;
import com.fossil.cgu;

public final class JsonAdapterAnnotationTypeAdapterFactory implements cfx {
    private final cge bQM;

    public JsonAdapterAnnotationTypeAdapterFactory(cge com_fossil_cge) {
        this.bQM = com_fossil_cge;
    }

    public <T> cfw<T> m14598a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        cfz com_fossil_cfz = (cfz) com_fossil_cgu_T.getRawType().getAnnotation(cfz.class);
        if (com_fossil_cfz == null) {
            return null;
        }
        return m14599a(this.bQM, com_fossil_cfj, com_fossil_cgu_T, com_fossil_cfz);
    }

    cfw<?> m14599a(cge com_fossil_cge, cfj com_fossil_cfj, cgu<?> com_fossil_cgu_, cfz com_fossil_cfz) {
        cfw<?> com_fossil_cfw_;
        Object WL = com_fossil_cge.b(cgu.get(com_fossil_cfz.value())).WL();
        if (WL instanceof cfw) {
            com_fossil_cfw_ = (cfw) WL;
        } else if (WL instanceof cfx) {
            com_fossil_cfw_ = ((cfx) WL).a(com_fossil_cfj, com_fossil_cgu_);
        } else if ((WL instanceof cfv) || (WL instanceof cfo)) {
            cfo com_fossil_cfo;
            cfv com_fossil_cfv = WL instanceof cfv ? (cfv) WL : null;
            if (WL instanceof cfo) {
                com_fossil_cfo = (cfo) WL;
            } else {
                com_fossil_cfo = null;
            }
            com_fossil_cfw_ = new TreeTypeAdapter(com_fossil_cfv, com_fossil_cfo, com_fossil_cfj, com_fossil_cgu_, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (com_fossil_cfw_ == null || !com_fossil_cfz.WI()) {
            return com_fossil_cfw_;
        }
        return com_fossil_cfw_.WF();
    }
}
