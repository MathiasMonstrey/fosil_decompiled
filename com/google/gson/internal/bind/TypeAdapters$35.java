package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgu;
import com.fossil.cgv;
import com.fossil.cgw;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;

public class TypeAdapters$35 implements cfx {
    final /* synthetic */ cfw bSw;
    final /* synthetic */ Class bTW;

    public TypeAdapters$35(Class cls, cfw com_fossil_cfw) {
        this.bTW = cls;
        this.bSw = com_fossil_cfw;
    }

    public <T2> cfw<T2> m14642a(cfj com_fossil_cfj, cgu<T2> com_fossil_cgu_T2) {
        final Class rawType = com_fossil_cgu_T2.getRawType();
        if (this.bTW.isAssignableFrom(rawType)) {
            return new cfw<T1>(this) {
                final /* synthetic */ TypeAdapters$35 bTY;

                public void m14640a(cgw com_fossil_cgw, T1 t1) throws IOException {
                    this.bTY.bSw.a(com_fossil_cgw, t1);
                }

                public T1 m14641b(cgv com_fossil_cgv) throws IOException {
                    T1 b = this.bTY.bSw.b(com_fossil_cgv);
                    if (b == null || rawType.isInstance(b)) {
                        return b;
                    }
                    throw new JsonSyntaxException("Expected a " + rawType.getName() + " but was " + b.getClass().getName());
                }
            };
        }
        return null;
    }

    public String toString() {
        return "Factory[typeHierarchy=" + this.bTW.getName() + ",adapter=" + this.bSw + "]";
    }
}
