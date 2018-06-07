package com.fossil;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class akc extends akb {
    protected final String aTl;
    protected final String aTm;

    protected akc(JavaType javaType, TypeFactory typeFactory) {
        super(javaType, typeFactory);
        String name = javaType.getRawClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            this.aTl = "";
            this.aTm = ".";
            return;
        }
        this.aTm = name.substring(0, lastIndexOf + 1);
        this.aTl = name.substring(0, lastIndexOf);
    }

    public String bA(Object obj) {
        String name = obj.getClass().getName();
        if (name.startsWith(this.aTm)) {
            return name.substring(this.aTm.length() - 1);
        }
        return name;
    }

    protected JavaType mo1048a(String str, TypeFactory typeFactory) {
        if (str.startsWith(".")) {
            StringBuilder stringBuilder = new StringBuilder(str.length() + this.aTl.length());
            if (this.aTl.length() == 0) {
                stringBuilder.append(str.substring(1));
            } else {
                stringBuilder.append(this.aTl).append(str);
            }
            str = stringBuilder.toString();
        }
        return super.mo1048a(str, typeFactory);
    }
}
