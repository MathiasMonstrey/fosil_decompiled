package com.fossil;

import com.google.android.gms.fitness.data.DataType;

final class bak implements bjh<DataType> {
    public static final bak boG = new bak();

    private bak() {
    }

    private static bac m4789a(DataType dataType, int i) {
        return (bac) dataType.Mj().get(i);
    }

    public final /* synthetic */ int bT(Object obj) {
        return ((DataType) obj).Mj().size();
    }

    public final /* synthetic */ String bU(Object obj) {
        return ((DataType) obj).getName();
    }

    public final boolean dw(String str) {
        return baq.dx(str) != null;
    }

    public final /* synthetic */ int mo1253r(Object obj, int i) {
        return m4789a((DataType) obj, i).getFormat();
    }

    public final /* synthetic */ boolean mo1254s(Object obj, int i) {
        return Boolean.TRUE.equals(m4789a((DataType) obj, i).Ml());
    }

    public final /* synthetic */ String mo1255t(Object obj, int i) {
        return m4789a((DataType) obj, i).getName();
    }
}
