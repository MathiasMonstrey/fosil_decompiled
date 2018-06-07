package com.fossil;

import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bvz extends aul {
    public bvz(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private final byte[] m5723f(String str, byte[] bArr) {
        return (!da(str) || db(str)) ? null : getByteArray(str);
    }

    protected final float m5724a(String str, float f) {
        return (!da(str) || db(str)) ? f : getFloat(str);
    }

    protected final <E extends SafeParcelable> E m5725a(String str, Creator<E> creator) {
        byte[] f = m5723f(str, null);
        return f == null ? null : aut.m4568a(f, creator);
    }

    protected final <E extends SafeParcelable> List<E> m5726a(String str, Creator<E> creator, List<E> list) {
        byte[] f = m5723f(str, null);
        if (f == null) {
            return list;
        }
        try {
            bcu ah = bcu.ah(f);
            if (ah.brc == null) {
                return list;
            }
            List<E> arrayList = new ArrayList(ah.brc.length);
            for (byte[] a : ah.brc) {
                arrayList.add(aut.m4568a(a, creator));
            }
            return arrayList;
        } catch (Throwable e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    protected final String af(String str, String str2) {
        return (!da(str) || db(str)) ? str2 : getString(str);
    }

    protected final List<Integer> m5727b(String str, List<Integer> list) {
        byte[] f = m5723f(str, null);
        if (f == null) {
            return list;
        }
        try {
            bcu ah = bcu.ah(f);
            if (ah.brb == null) {
                return list;
            }
            List<Integer> arrayList = new ArrayList(ah.brb.length);
            for (int valueOf : ah.brb) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList;
        } catch (Throwable e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    protected final List<String> m5728c(String str, List<String> list) {
        byte[] f = m5723f(str, null);
        if (f != null) {
            try {
                bcu ah = bcu.ah(f);
                if (ah.bra != null) {
                    list = Arrays.asList(ah.bra);
                }
            } catch (Throwable e) {
                if (Log.isLoggable("SafeDataBufferRef", 6)) {
                    Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
                }
            }
        }
        return list;
    }

    protected final int m5729u(String str, int i) {
        return (!da(str) || db(str)) ? i : getInteger(str);
    }
}
