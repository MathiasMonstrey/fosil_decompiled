package com.fossil;

import java.util.Arrays;
import java.util.Collection;

public class um<T> implements up<T> {
    private final Collection<? extends up<T>> aBe;
    private String id;

    @SafeVarargs
    public um(up<T>... upVarArr) {
        if (upVarArr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.aBe = Arrays.asList(upVarArr);
    }

    public vh<T> m12651a(vh<T> vhVar, int i, int i2) {
        vh<T> vhVar2 = vhVar;
        for (up a : this.aBe) {
            vh<T> a2 = a.a(vhVar2, i, i2);
            if (!(vhVar2 == null || vhVar2.equals(vhVar) || vhVar2.equals(a2))) {
                vhVar2.recycle();
            }
            vhVar2 = a2;
        }
        return vhVar2;
    }

    public String getId() {
        if (this.id == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (up id : this.aBe) {
                stringBuilder.append(id.getId());
            }
            this.id = stringBuilder.toString();
        }
        return this.id;
    }
}
