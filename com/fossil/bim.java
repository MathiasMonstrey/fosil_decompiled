package com.fossil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class bim {
    protected static <O, I> I m5199a(bin<I, O> com_fossil_bin_I__O, Object obj) {
        return com_fossil_bin_I__O.bvC != null ? com_fossil_bin_I__O.convertBack(obj) : obj;
    }

    private static void m5200a(StringBuilder stringBuilder, bin com_fossil_bin, Object obj) {
        if (com_fossil_bin.bvt == 11) {
            stringBuilder.append(((bim) com_fossil_bin.bvz.cast(obj)).toString());
        } else if (com_fossil_bin.bvt == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(axr.di((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private static void m5201a(StringBuilder stringBuilder, bin com_fossil_bin, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m5200a(stringBuilder, com_fossil_bin, obj);
            }
        }
        stringBuilder.append("]");
    }

    public abstract Map<String, bin<?, ?>> Ox();

    protected boolean mo1470a(bin com_fossil_bin) {
        if (com_fossil_bin.bvv != 11) {
            return dJ(com_fossil_bin.bvx);
        }
        if (com_fossil_bin.bvw) {
            String str = com_fossil_bin.bvx;
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        str = com_fossil_bin.bvx;
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected Object mo1471b(bin com_fossil_bin) {
        String str = com_fossil_bin.bvx;
        if (com_fossil_bin.bvz == null) {
            return dI(com_fossil_bin.bvx);
        }
        dI(com_fossil_bin.bvx);
        awa.m4635a(true, "Concrete field shouldn't be value object: %s", com_fossil_bin.bvx);
        boolean z = com_fossil_bin.bvw;
        try {
            char toUpperCase = Character.toUpperCase(str.charAt(0));
            str = String.valueOf(str.substring(1));
            return getClass().getMethod(new StringBuilder(String.valueOf(str).length() + 4).append("get").append(toUpperCase).append(str).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Object dI(String str);

    protected abstract boolean dJ(String str);

    public String toString() {
        Map Ox = Ox();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : Ox.keySet()) {
            bin com_fossil_bin = (bin) Ox.get(str);
            if (mo1470a(com_fossil_bin)) {
                Object a = m5199a(com_fossil_bin, mo1471b(com_fossil_bin));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (com_fossil_bin.bvv) {
                        case 8:
                            stringBuilder.append("\"").append(axk.encode((byte[]) a)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(axk.ac((byte[]) a)).append("\"");
                            break;
                        case 10:
                            axs.m4686a(stringBuilder, (HashMap) a);
                            break;
                        default:
                            if (!com_fossil_bin.bvu) {
                                m5200a(stringBuilder, com_fossil_bin, a);
                                break;
                            }
                            m5201a(stringBuilder, com_fossil_bin, (ArrayList) a);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
