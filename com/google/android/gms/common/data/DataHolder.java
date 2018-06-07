package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.fossil.aun;
import com.fossil.auo;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.awa;
import com.google.android.gms.common.annotation.KeepName;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@KeepName
public final class DataHolder extends auq implements Closeable {
    public static final Creator<DataHolder> CREATOR = new auo();
    private static final C4248a bgL = new aun(new String[0], null);
    private int ber;
    private final int bfI;
    private final String[] bgE;
    private Bundle bgF;
    private final CursorWindow[] bgG;
    private final Bundle bgH;
    private int[] bgI;
    public int bgJ;
    private boolean bgK;
    private boolean mClosed;

    public static class C4248a {
        private final String[] bgE;
        private final ArrayList<HashMap<String, Object>> bgM;
        private final String bgN;
        private final HashMap<Object, Integer> bgO;
        private boolean bgP;
        private String bgQ;

        private C4248a(String[] strArr, String str) {
            this.bgE = (String[]) awa.bO(strArr);
            this.bgM = new ArrayList();
            this.bgN = str;
            this.bgO = new HashMap();
            this.bgP = false;
            this.bgQ = null;
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.bgK = true;
        this.ber = i;
        this.bgE = strArr;
        this.bgG = cursorWindowArr;
        this.bfI = i2;
        this.bgH = bundle;
    }

    private DataHolder(C4248a c4248a, int i, Bundle bundle) {
        this(c4248a.bgE, m14209a(c4248a, -1), i, null);
    }

    private DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.bgK = true;
        this.ber = 1;
        this.bgE = (String[]) awa.bO(strArr);
        this.bgG = (CursorWindow[]) awa.bO(cursorWindowArr);
        this.bfI = i;
        this.bgH = bundle;
        KM();
    }

    private static CursorWindow[] m14209a(C4248a c4248a, int i) {
        int i2 = 0;
        if (c4248a.bgE.length == 0) {
            return new CursorWindow[0];
        }
        List b = c4248a.bgM;
        int size = b.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(c4248a.bgE.length);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            try {
                int i5;
                int i6;
                CursorWindow cursorWindow2;
                if (!cursorWindow.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(c4248a.bgE.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) b.get(i3);
                boolean z = true;
                for (int i7 = 0; i7 < c4248a.bgE.length && z; i7++) {
                    String str = c4248a.bgE[i7];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i3, i7);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i3, i7);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i3, i7);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i3, i7);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i7);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i3, i7);
                    } else if (obj instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i7);
                    } else if (obj instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i3, i7);
                    } else {
                        String valueOf = String.valueOf(obj);
                        throw new IllegalArgumentException(new StringBuilder((String.valueOf(str).length() + 32) + String.valueOf(valueOf).length()).append("Unsupported object for column ").append(str).append(": ").append(valueOf).toString());
                    }
                }
                if (z) {
                    i5 = i3;
                    i6 = 0;
                    cursorWindow2 = cursorWindow;
                } else if (i4 != 0) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(c4248a.bgE.length);
                    arrayList.add(cursorWindow3);
                    i5 = i3 - 1;
                    cursorWindow2 = cursorWindow3;
                    i6 = 1;
                }
                i4 = i6;
                cursorWindow = cursorWindow2;
                i3 = i5 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                i3 = arrayList.size();
                while (i2 < i3) {
                    ((CursorWindow) arrayList.get(i2)).close();
                    i2++;
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder ht(int i) {
        return new DataHolder(bgL, i, null);
    }

    private final void m14210p(String str, int i) {
        if (this.bgF == null || !this.bgF.containsKey(str)) {
            String str2 = "No such column: ";
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.bgJ) {
            throw new CursorIndexOutOfBoundsException(i, this.bgJ);
        }
    }

    public final void KM() {
        int i;
        int i2 = 0;
        this.bgF = new Bundle();
        for (i = 0; i < this.bgE.length; i++) {
            this.bgF.putInt(this.bgE[i], i);
        }
        this.bgI = new int[this.bgG.length];
        i = 0;
        while (i2 < this.bgG.length) {
            this.bgI[i2] = i;
            i += this.bgG[i2].getNumRows() - (i - this.bgG[i2].getStartPosition());
            i2++;
        }
        this.bgJ = i;
    }

    public final Bundle KN() {
        return this.bgH;
    }

    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.bgG) {
                    close.close();
                }
            }
        }
    }

    public final boolean da(String str) {
        return this.bgF.containsKey(str);
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.bgK && this.bgG.length > 0 && !isClosed()) {
                close();
                String valueOf = String.valueOf(toString());
                Log.e("DataBuffer", new StringBuilder(String.valueOf(valueOf).length() + 178).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ").append(valueOf).append(")").toString());
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final int getCount() {
        return this.bgJ;
    }

    public final int getStatusCode() {
        return this.bfI;
    }

    public final int hs(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.bgJ;
        awa.aX(z);
        while (i2 < this.bgI.length) {
            if (i < this.bgI[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.bgI.length ? i2 - 1 : i2;
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final int m14211j(String str, int i, int i2) {
        m14210p(str, i);
        return this.bgG[i2].getInt(i, this.bgF.getInt(str));
    }

    public final String m14212k(String str, int i, int i2) {
        m14210p(str, i);
        return this.bgG[i2].getString(i, this.bgF.getInt(str));
    }

    public final boolean m14213l(String str, int i, int i2) {
        m14210p(str, i);
        return Long.valueOf(this.bgG[i2].getLong(i, this.bgF.getInt(str))).longValue() == 1;
    }

    public final float m14214m(String str, int i, int i2) {
        m14210p(str, i);
        return this.bgG[i2].getFloat(i, this.bgF.getInt(str));
    }

    public final byte[] m14215n(String str, int i, int i2) {
        m14210p(str, i);
        return this.bgG[i2].getBlob(i, this.bgF.getInt(str));
    }

    public final boolean m14216o(String str, int i, int i2) {
        m14210p(str, i);
        return this.bgG[i2].isNull(i, this.bgF.getInt(str));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.a(parcel, 1, this.bgE, false);
        aus.a(parcel, 2, this.bgG, i, false);
        aus.c(parcel, 3, this.bfI);
        aus.a(parcel, 4, this.bgH, false);
        aus.c(parcel, 1000, this.ber);
        aus.G(parcel, A);
    }
}
