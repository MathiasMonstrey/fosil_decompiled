package com.fossil;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class aus {
    public static int m4537A(Parcel parcel) {
        return m4538E(parcel, 20293);
    }

    private static int m4538E(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m4539F(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void m4540G(Parcel parcel, int i) {
        m4539F(parcel, i);
    }

    public static void m4541a(Parcel parcel, int i, byte b) {
        m4563b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void m4542a(Parcel parcel, int i, double d) {
        m4563b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void m4543a(Parcel parcel, int i, float f) {
        m4563b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m4544a(Parcel parcel, int i, long j) {
        m4563b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m4545a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int E = m4538E(parcel, i);
            parcel.writeBundle(bundle);
            m4539F(parcel, E);
        }
    }

    public static void m4546a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int E = m4538E(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m4539F(parcel, E);
        }
    }

    public static void m4547a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int E = m4538E(parcel, 2);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            m4539F(parcel, E);
        }
    }

    public static void m4548a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int E = m4538E(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m4539F(parcel, E);
        } else if (z) {
            m4563b(parcel, i, 0);
        }
    }

    public static void m4549a(Parcel parcel, int i, Boolean bool, boolean z) {
        if (bool != null) {
            m4563b(parcel, 3, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    public static void m4550a(Parcel parcel, int i, Double d, boolean z) {
        if (d != null) {
            m4563b(parcel, 8, 8);
            parcel.writeDouble(d.doubleValue());
        }
    }

    public static void m4551a(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            m4563b(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        }
    }

    public static void m4552a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            m4563b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        }
    }

    public static void m4553a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            m4563b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        }
    }

    public static void m4554a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int E = m4538E(parcel, i);
            parcel.writeString(str);
            m4539F(parcel, E);
        } else if (z) {
            m4563b(parcel, i, 0);
        }
    }

    public static void m4555a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list != null) {
            int E = m4538E(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            m4539F(parcel, E);
        }
    }

    public static void m4556a(Parcel parcel, int i, boolean z) {
        m4563b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m4557a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int E = m4538E(parcel, i);
            parcel.writeByteArray(bArr);
            m4539F(parcel, E);
        }
    }

    public static void m4558a(Parcel parcel, int i, float[] fArr, boolean z) {
        if (fArr != null) {
            int E = m4538E(parcel, 7);
            parcel.writeFloatArray(fArr);
            m4539F(parcel, E);
        }
    }

    public static void m4559a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int E = m4538E(parcel, i);
            parcel.writeIntArray(iArr);
            m4539F(parcel, E);
        }
    }

    public static <T extends Parcelable> void m4560a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int E = m4538E(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m4562a(parcel, parcelable, i2);
                }
            }
            m4539F(parcel, E);
        }
    }

    public static void m4561a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int E = m4538E(parcel, i);
            parcel.writeStringArray(strArr);
            m4539F(parcel, E);
        }
    }

    private static <T extends Parcelable> void m4562a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static void m4563b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static void m4564b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int E = m4538E(parcel, i);
            parcel.writeStringList(list);
            m4539F(parcel, E);
        }
    }

    public static void m4565c(Parcel parcel, int i, int i2) {
        m4563b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static <T extends Parcelable> void m4566c(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int E = m4538E(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m4562a(parcel, parcelable, 0);
                }
            }
            m4539F(parcel, E);
        } else if (z) {
            m4563b(parcel, i, 0);
        }
    }

    public static void m4567d(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int E = m4538E(parcel, i);
            parcel.writeList(list);
            m4539F(parcel, E);
        }
    }
}
