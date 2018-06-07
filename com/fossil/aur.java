package com.fossil;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public final class aur {
    public static ArrayList<String> m4500A(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }

    public static Parcel m4501B(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a);
        parcel.setDataPosition(a + dataPosition);
        return obtain;
    }

    public static Parcel[] m4502C(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a);
        return parcelArr;
    }

    public static void m4503D(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new zzc("Overread allowed size end=" + i, parcel);
        }
    }

    public static int m4504a(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static <T extends Parcelable> T m4505a(Parcel parcel, int i, Creator<T> creator) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m4506a(Parcel parcel, int i, int i2) {
        int a = m4504a(parcel, i);
        if (a != i2) {
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new zzc(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i2).append(" got ").append(a).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    private static void m4507a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String valueOf = String.valueOf(Integer.toHexString(i2));
            throw new zzc(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i3).append(" got ").append(i2).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    public static void m4508a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(a + dataPosition);
        }
    }

    public static void m4509b(Parcel parcel, int i) {
        parcel.setDataPosition(m4504a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] m4510b(Parcel parcel, int i, Creator<T> creator) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static <T> ArrayList<T> m4511c(Parcel parcel, int i, Creator<T> creator) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m4512c(Parcel parcel, int i) {
        m4506a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean m4513d(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        if (a == 0) {
            return null;
        }
        m4507a(parcel, i, a, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte m4514e(Parcel parcel, int i) {
        m4506a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static int m4515f(Parcel parcel, int i) {
        m4506a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer m4516g(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        if (a == 0) {
            return null;
        }
        m4507a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long m4517h(Parcel parcel, int i) {
        m4506a(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long m4518i(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        if (a == 0) {
            return null;
        }
        m4507a(parcel, i, a, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static BigInteger m4519j(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static float m4520k(Parcel parcel, int i) {
        m4506a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float m4521l(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        if (a == 0) {
            return null;
        }
        m4507a(parcel, i, a, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static double m4522m(Parcel parcel, int i) {
        m4506a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static Double m4523n(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        if (a == 0) {
            return null;
        }
        m4507a(parcel, i, a, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static BigDecimal m4524o(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(a + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static String m4525p(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static IBinder m4526q(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m4527r(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static byte[] m4528s(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    public static boolean[] m4529t(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(a + dataPosition);
        return createBooleanArray;
    }

    public static int[] m4530u(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    public static long[] m4531v(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(a + dataPosition);
        return createLongArray;
    }

    public static float[] m4532w(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(a + dataPosition);
        return createFloatArray;
    }

    public static BigDecimal[] m4533x(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigDecimalArr;
    }

    public static String[] m4534y(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }

    public static int m4535z(Parcel parcel) {
        int readInt = parcel.readInt();
        int a = m4504a(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if ((65535 & readInt) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(readInt));
            throw new zzc(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
        }
        readInt = dataPosition + a;
        if (readInt >= dataPosition && readInt <= parcel.dataSize()) {
            return readInt;
        }
        throw new zzc("Size read is invalid start=" + dataPosition + " end=" + readInt, parcel);
    }

    public static ArrayList<Integer> m4536z(Parcel parcel, int i) {
        int a = m4504a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + a);
        return arrayList;
    }
}
