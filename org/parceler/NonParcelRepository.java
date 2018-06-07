package org.parceler;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.parceler.Parcels.ParcelableFactory;
import org.parceler.converter.ArrayListParcelConverter;
import org.parceler.converter.BooleanArrayParcelConverter;
import org.parceler.converter.CharArrayParcelConverter;
import org.parceler.converter.CollectionParcelConverter;
import org.parceler.converter.HashMapParcelConverter;
import org.parceler.converter.HashSetParcelConverter;
import org.parceler.converter.LinkedHashMapParcelConverter;
import org.parceler.converter.LinkedHashSetParcelConverter;
import org.parceler.converter.LinkedListParcelConverter;
import org.parceler.converter.NullableParcelConverter;
import org.parceler.converter.SparseArrayParcelConverter;
import org.parceler.converter.TreeMapParcelConverter;
import org.parceler.converter.TreeSetParcelConverter;

final class NonParcelRepository implements Repository<ParcelableFactory> {
    private static final NonParcelRepository dWl = new NonParcelRepository();
    private final Map<Class, ParcelableFactory> dWm = new HashMap();

    static class C5109i<T> implements Parcelable, ParcelWrapper<T> {
        private final TypeRangeParcelConverter<T, T> converter;
        private final T value;

        private C5109i(Parcel parcel, TypeRangeParcelConverter<T, T> typeRangeParcelConverter) {
            this(typeRangeParcelConverter.fromParcel(parcel), (TypeRangeParcelConverter) typeRangeParcelConverter);
        }

        private C5109i(T t, TypeRangeParcelConverter<T, T> typeRangeParcelConverter) {
            this.converter = typeRangeParcelConverter;
            this.value = t;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.converter.toParcel(this.value, parcel);
        }

        public int describeContents() {
            return 0;
        }

        public T getParcel() {
            return this.value;
        }
    }

    public static final class BooleanArrayParcelable extends C5109i<boolean[]> {
        private static final BooleanArrayParcelConverter CONVERTER = new BooleanArrayParcelConverter();
        public static final C5108a CREATOR = new C5108a();

        static final class C5108a implements Creator<BooleanArrayParcelable> {
            private C5108a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bC(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pB(i);
            }

            public BooleanArrayParcelable bC(Parcel parcel) {
                return new BooleanArrayParcelable(parcel);
            }

            public BooleanArrayParcelable[] pB(int i) {
                return new BooleanArrayParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public BooleanArrayParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public BooleanArrayParcelable(boolean[] zArr) {
            super((Object) zArr, CONVERTER);
        }
    }

    public static final class BooleanParcelable extends C5109i<Boolean> {
        private static final NullableParcelConverter<Boolean> CONVERTER = new C51101();
        public static final C5111a CREATOR = new C5111a();

        static class C51101 extends NullableParcelConverter<Boolean> {
            C51101() {
            }

            public /* synthetic */ Object nullSafeFromParcel(Parcel parcel) {
                return bD(parcel);
            }

            public /* synthetic */ void nullSafeToParcel(Object obj, Parcel parcel) {
                m16342a((Boolean) obj, parcel);
            }

            public Boolean bD(Parcel parcel) {
                return Boolean.valueOf(parcel.createBooleanArray()[0]);
            }

            public void m16342a(Boolean bool, Parcel parcel) {
                parcel.writeBooleanArray(new boolean[]{bool.booleanValue()});
            }
        }

        static final class C5111a implements Creator<BooleanParcelable> {
            private C5111a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bE(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pC(i);
            }

            public BooleanParcelable bE(Parcel parcel) {
                return new BooleanParcelable(parcel);
            }

            public BooleanParcelable[] pC(int i) {
                return new BooleanParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public BooleanParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public BooleanParcelable(boolean z) {
            super(Boolean.valueOf(z), CONVERTER);
        }
    }

    public static final class ByteArrayParcelable extends C5109i<byte[]> {
        private static final NullableParcelConverter<byte[]> CONVERTER = new C51121();
        public static final C5113a CREATOR = new C5113a();

        static class C51121 extends NullableParcelConverter<byte[]> {
            C51121() {
            }

            public /* synthetic */ Object nullSafeFromParcel(Parcel parcel) {
                return bF(parcel);
            }

            public /* synthetic */ void nullSafeToParcel(Object obj, Parcel parcel) {
                m16343a((byte[]) obj, parcel);
            }

            public byte[] bF(Parcel parcel) {
                return parcel.createByteArray();
            }

            public void m16343a(byte[] bArr, Parcel parcel) {
                parcel.writeByteArray(bArr);
            }
        }

        static final class C5113a implements Creator<ByteArrayParcelable> {
            private C5113a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bG(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pD(i);
            }

            public ByteArrayParcelable bG(Parcel parcel) {
                return new ByteArrayParcelable(parcel);
            }

            public ByteArrayParcelable[] pD(int i) {
                return new ByteArrayParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public ByteArrayParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public ByteArrayParcelable(byte[] bArr) {
            super((Object) bArr, CONVERTER);
        }
    }

    public static final class ByteParcelable extends C5109i<Byte> {
        private static final NullableParcelConverter<Byte> CONVERTER = new C51141();
        public static final C5115a CREATOR = new C5115a();

        static class C51141 extends NullableParcelConverter<Byte> {
            C51141() {
            }

            public /* synthetic */ Object nullSafeFromParcel(Parcel parcel) {
                return bH(parcel);
            }

            public /* synthetic */ void nullSafeToParcel(Object obj, Parcel parcel) {
                m16344a((Byte) obj, parcel);
            }

            public Byte bH(Parcel parcel) {
                return Byte.valueOf(parcel.readByte());
            }

            public void m16344a(Byte b, Parcel parcel) {
                parcel.writeByte(b.byteValue());
            }
        }

        static final class C5115a implements Creator<ByteParcelable> {
            private C5115a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bI(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pE(i);
            }

            public ByteParcelable bI(Parcel parcel) {
                return new ByteParcelable(parcel);
            }

            public ByteParcelable[] pE(int i) {
                return new ByteParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public ByteParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public ByteParcelable(Byte b) {
            super((Object) b, CONVERTER);
        }
    }

    public static final class CharArrayParcelable extends C5109i<char[]> {
        private static final CharArrayParcelConverter CONVERTER = new CharArrayParcelConverter();
        public static final C5116a CREATOR = new C5116a();

        static final class C5116a implements Creator<CharArrayParcelable> {
            private C5116a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bJ(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pF(i);
            }

            public CharArrayParcelable bJ(Parcel parcel) {
                return new CharArrayParcelable(parcel);
            }

            public CharArrayParcelable[] pF(int i) {
                return new CharArrayParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public CharArrayParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public CharArrayParcelable(char[] cArr) {
            super((Object) cArr, CONVERTER);
        }
    }

    public static final class CharacterParcelable extends C5109i<Character> {
        private static final NullableParcelConverter<Character> CONVERTER = new C51171();
        public static final C5118a CREATOR = new C5118a();

        static class C51171 extends NullableParcelConverter<Character> {
            C51171() {
            }

            public /* synthetic */ Object nullSafeFromParcel(Parcel parcel) {
                return bK(parcel);
            }

            public /* synthetic */ void nullSafeToParcel(Object obj, Parcel parcel) {
                m16345a((Character) obj, parcel);
            }

            public Character bK(Parcel parcel) {
                return Character.valueOf(parcel.createCharArray()[0]);
            }

            public void m16345a(Character ch, Parcel parcel) {
                parcel.writeCharArray(new char[]{ch.charValue()});
            }
        }

        static final class C5118a implements Creator<CharacterParcelable> {
            private C5118a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bL(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pG(i);
            }

            public CharacterParcelable bL(Parcel parcel) {
                return new CharacterParcelable(parcel);
            }

            public CharacterParcelable[] pG(int i) {
                return new CharacterParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public CharacterParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public CharacterParcelable(Character ch) {
            super((Object) ch, CONVERTER);
        }
    }

    public static final class CollectionParcelable extends C5109i<Collection> {
        private static final CollectionParcelConverter CONVERTER = new C51191();
        public static final C5120a CREATOR = new C5120a();

        static class C51191 extends ArrayListParcelConverter {
            C51191() {
            }

            public Object itemFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(CollectionParcelable.class.getClassLoader()));
            }

            public void itemToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        }

        static final class C5120a implements Creator<CollectionParcelable> {
            private C5120a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bM(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pH(i);
            }

            public CollectionParcelable bM(Parcel parcel) {
                return new CollectionParcelable(parcel);
            }

            public CollectionParcelable[] pH(int i) {
                return new CollectionParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public CollectionParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public CollectionParcelable(Collection collection) {
            super((Object) collection, CONVERTER);
        }
    }

    public static final class DoubleParcelable extends C5109i<Double> {
        private static final NullableParcelConverter<Double> CONVERTER = new C51211();
        public static final C5122a CREATOR = new C5122a();

        static class C51211 extends NullableParcelConverter<Double> {
            C51211() {
            }

            public /* synthetic */ Object nullSafeFromParcel(Parcel parcel) {
                return bN(parcel);
            }

            public /* synthetic */ void nullSafeToParcel(Object obj, Parcel parcel) {
                m16346a((Double) obj, parcel);
            }

            public Double bN(Parcel parcel) {
                return Double.valueOf(parcel.readDouble());
            }

            public void m16346a(Double d, Parcel parcel) {
                parcel.writeDouble(d.doubleValue());
            }
        }

        static final class C5122a implements Creator<DoubleParcelable> {
            private C5122a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bO(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pI(i);
            }

            public DoubleParcelable bO(Parcel parcel) {
                return new DoubleParcelable(parcel);
            }

            public DoubleParcelable[] pI(int i) {
                return new DoubleParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public DoubleParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public DoubleParcelable(Double d) {
            super((Object) d, CONVERTER);
        }
    }

    public static final class FloatParcelable extends C5109i<Float> {
        private static final NullableParcelConverter<Float> CONVERTER = new C51231();
        public static final C5124a CREATOR = new C5124a();

        static class C51231 extends NullableParcelConverter<Float> {
            C51231() {
            }

            public /* synthetic */ Object nullSafeFromParcel(Parcel parcel) {
                return bP(parcel);
            }

            public /* synthetic */ void nullSafeToParcel(Object obj, Parcel parcel) {
                m16347a((Float) obj, parcel);
            }

            public Float bP(Parcel parcel) {
                return Float.valueOf(parcel.readFloat());
            }

            public void m16347a(Float f, Parcel parcel) {
                parcel.writeFloat(f.floatValue());
            }
        }

        static final class C5124a implements Creator<FloatParcelable> {
            private C5124a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bQ(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pJ(i);
            }

            public FloatParcelable bQ(Parcel parcel) {
                return new FloatParcelable(parcel);
            }

            public FloatParcelable[] pJ(int i) {
                return new FloatParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public FloatParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public FloatParcelable(Float f) {
            super((Object) f, CONVERTER);
        }
    }

    public static final class IBinderParcelable extends C5109i<IBinder> {
        private static final NullableParcelConverter<IBinder> CONVERTER = new C51251();
        public static final C5126a CREATOR = new C5126a();

        static class C51251 extends NullableParcelConverter<IBinder> {
            C51251() {
            }

            public /* synthetic */ Object nullSafeFromParcel(Parcel parcel) {
                return bR(parcel);
            }

            public /* synthetic */ void nullSafeToParcel(Object obj, Parcel parcel) {
                m16348a((IBinder) obj, parcel);
            }

            public IBinder bR(Parcel parcel) {
                return parcel.readStrongBinder();
            }

            public void m16348a(IBinder iBinder, Parcel parcel) {
                parcel.writeStrongBinder(iBinder);
            }
        }

        static final class C5126a implements Creator<IBinderParcelable> {
            private C5126a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bS(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pK(i);
            }

            public IBinderParcelable bS(Parcel parcel) {
                return new IBinderParcelable(parcel);
            }

            public IBinderParcelable[] pK(int i) {
                return new IBinderParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public IBinderParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public IBinderParcelable(IBinder iBinder) {
            super((Object) iBinder, CONVERTER);
        }
    }

    public static final class IntegerParcelable extends C5109i<Integer> {
        private static final NullableParcelConverter<Integer> CONVERTER = new C51271();
        public static final C5128a CREATOR = new C5128a();

        static class C51271 extends NullableParcelConverter<Integer> {
            C51271() {
            }

            public /* synthetic */ Object nullSafeFromParcel(Parcel parcel) {
                return bT(parcel);
            }

            public /* synthetic */ void nullSafeToParcel(Object obj, Parcel parcel) {
                m16349a((Integer) obj, parcel);
            }

            public Integer bT(Parcel parcel) {
                return Integer.valueOf(parcel.readInt());
            }

            public void m16349a(Integer num, Parcel parcel) {
                parcel.writeInt(num.intValue());
            }
        }

        static final class C5128a implements Creator<IntegerParcelable> {
            private C5128a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bU(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pL(i);
            }

            public IntegerParcelable bU(Parcel parcel) {
                return new IntegerParcelable(parcel);
            }

            public IntegerParcelable[] pL(int i) {
                return new IntegerParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public IntegerParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public IntegerParcelable(Integer num) {
            super((Object) num, CONVERTER);
        }
    }

    public static final class LinkedHashMapParcelable extends C5109i<LinkedHashMap> {
        private static final LinkedHashMapParcelConverter CONVERTER = new C51291();
        public static final C5130a CREATOR = new C5130a();

        static class C51291 extends LinkedHashMapParcelConverter {
            C51291() {
            }

            public void mapKeyToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }

            public void mapValueToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }

            public Object mapKeyFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            public Object mapValueFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }
        }

        static final class C5130a implements Creator<LinkedHashMapParcelable> {
            private C5130a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bV(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pM(i);
            }

            public LinkedHashMapParcelable bV(Parcel parcel) {
                return new LinkedHashMapParcelable(parcel);
            }

            public LinkedHashMapParcelable[] pM(int i) {
                return new LinkedHashMapParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LinkedHashMapParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public LinkedHashMapParcelable(LinkedHashMap linkedHashMap) {
            super((Object) linkedHashMap, CONVERTER);
        }
    }

    public static final class LinkedHashSetParcelable extends C5109i<LinkedHashSet> {
        private static final LinkedHashSetParcelConverter CONVERTER = new C51311();
        public static final C5132a CREATOR = new C5132a();

        static class C51311 extends LinkedHashSetParcelConverter {
            C51311() {
            }

            public Object itemFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(LinkedHashSetParcelable.class.getClassLoader()));
            }

            public void itemToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        }

        static final class C5132a implements Creator<LinkedHashSetParcelable> {
            private C5132a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bW(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pN(i);
            }

            public LinkedHashSetParcelable bW(Parcel parcel) {
                return new LinkedHashSetParcelable(parcel);
            }

            public LinkedHashSetParcelable[] pN(int i) {
                return new LinkedHashSetParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LinkedHashSetParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public LinkedHashSetParcelable(LinkedHashSet linkedHashSet) {
            super((Object) linkedHashSet, CONVERTER);
        }
    }

    public static final class LinkedListParcelable extends C5109i<LinkedList> {
        private static final LinkedListParcelConverter CONVERTER = new C51331();
        public static final C5134a CREATOR = new C5134a();

        static class C51331 extends LinkedListParcelConverter {
            C51331() {
            }

            public Object itemFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(LinkedListParcelable.class.getClassLoader()));
            }

            public void itemToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        }

        static final class C5134a implements Creator<LinkedListParcelable> {
            private C5134a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bX(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pO(i);
            }

            public LinkedListParcelable bX(Parcel parcel) {
                return new LinkedListParcelable(parcel);
            }

            public LinkedListParcelable[] pO(int i) {
                return new LinkedListParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LinkedListParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public LinkedListParcelable(LinkedList linkedList) {
            super((Object) linkedList, CONVERTER);
        }
    }

    public static final class ListParcelable extends C5109i<List> {
        private static final ArrayListParcelConverter CONVERTER = new C51351();
        public static final C5136a CREATOR = new C5136a();

        static class C51351 extends ArrayListParcelConverter {
            C51351() {
            }

            public Object itemFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(ListParcelable.class.getClassLoader()));
            }

            public void itemToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        }

        static final class C5136a implements Creator<ListParcelable> {
            private C5136a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return bY(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pP(i);
            }

            public ListParcelable bY(Parcel parcel) {
                return new ListParcelable(parcel);
            }

            public ListParcelable[] pP(int i) {
                return new ListParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public ListParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public ListParcelable(List list) {
            super((Object) list, CONVERTER);
        }
    }

    public static final class LongParcelable extends C5109i<Long> {
        private static final NullableParcelConverter<Long> CONVERTER = new C51371();
        public static final C5138a CREATOR = new C5138a();

        static class C51371 extends NullableParcelConverter<Long> {
            C51371() {
            }

            public /* synthetic */ Object nullSafeFromParcel(Parcel parcel) {
                return bZ(parcel);
            }

            public /* synthetic */ void nullSafeToParcel(Object obj, Parcel parcel) {
                m16350a((Long) obj, parcel);
            }

            public Long bZ(Parcel parcel) {
                return Long.valueOf(parcel.readLong());
            }

            public void m16350a(Long l, Parcel parcel) {
                parcel.writeLong(l.longValue());
            }
        }

        static final class C5138a implements Creator<LongParcelable> {
            private C5138a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return ca(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pQ(i);
            }

            public LongParcelable ca(Parcel parcel) {
                return new LongParcelable(parcel);
            }

            public LongParcelable[] pQ(int i) {
                return new LongParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LongParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public LongParcelable(Long l) {
            super((Object) l, CONVERTER);
        }
    }

    public static final class MapParcelable extends C5109i<Map> {
        private static final HashMapParcelConverter CONVERTER = new C51391();
        public static final C5140a CREATOR = new C5140a();

        static class C51391 extends HashMapParcelConverter {
            C51391() {
            }

            public void mapKeyToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }

            public void mapValueToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }

            public Object mapKeyFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            public Object mapValueFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }
        }

        static final class C5140a implements Creator<MapParcelable> {
            private C5140a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return cb(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pR(i);
            }

            public MapParcelable cb(Parcel parcel) {
                return new MapParcelable(parcel);
            }

            public MapParcelable[] pR(int i) {
                return new MapParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public MapParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public MapParcelable(Map map) {
            super((Object) map, CONVERTER);
        }
    }

    public static final class ParcelableParcelable implements Parcelable, ParcelWrapper<Parcelable> {
        public static final C5141a CREATOR = new C5141a();
        private Parcelable parcelable;

        static final class C5141a implements Creator<ParcelableParcelable> {
            private C5141a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return cc(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pS(i);
            }

            public ParcelableParcelable cc(Parcel parcel) {
                return new ParcelableParcelable(parcel);
            }

            public ParcelableParcelable[] pS(int i) {
                return new ParcelableParcelable[i];
            }
        }

        private ParcelableParcelable(Parcel parcel) {
            this.parcelable = parcel.readParcelable(ParcelableParcelable.class.getClassLoader());
        }

        private ParcelableParcelable(Parcelable parcelable) {
            this.parcelable = parcelable;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.parcelable, i);
        }

        public int describeContents() {
            return 0;
        }

        public Parcelable getParcel() {
            return this.parcelable;
        }
    }

    public static final class SetParcelable extends C5109i<Set> {
        private static final HashSetParcelConverter CONVERTER = new C51421();
        public static final C5143a CREATOR = new C5143a();

        static class C51421 extends HashSetParcelConverter {
            C51421() {
            }

            public Object itemFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(SetParcelable.class.getClassLoader()));
            }

            public void itemToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        }

        static final class C5143a implements Creator<SetParcelable> {
            private C5143a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return cd(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pT(i);
            }

            public SetParcelable cd(Parcel parcel) {
                return new SetParcelable(parcel);
            }

            public SetParcelable[] pT(int i) {
                return new SetParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public SetParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public SetParcelable(Set set) {
            super((Object) set, CONVERTER);
        }
    }

    public static final class SparseArrayParcelable extends C5109i<SparseArray> {
        private static final SparseArrayParcelConverter CONVERTER = new C51441();
        public static final C5145a CREATOR = new C5145a();

        static class C51441 extends SparseArrayParcelConverter {
            C51441() {
            }

            public Object itemFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(SparseArrayParcelable.class.getClassLoader()));
            }

            public void itemToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        }

        static final class C5145a implements Creator<SparseArrayParcelable> {
            private C5145a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return ce(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pU(i);
            }

            public SparseArrayParcelable ce(Parcel parcel) {
                return new SparseArrayParcelable(parcel);
            }

            public SparseArrayParcelable[] pU(int i) {
                return new SparseArrayParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public SparseArrayParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public SparseArrayParcelable(SparseArray sparseArray) {
            super((Object) sparseArray, CONVERTER);
        }
    }

    public static final class SparseBooleanArrayParcelable extends C5109i<SparseBooleanArray> {
        private static final NullableParcelConverter<SparseBooleanArray> CONVERTER = new C51461();
        public static final C5147a CREATOR = new C5147a();

        static class C51461 extends NullableParcelConverter<SparseBooleanArray> {
            C51461() {
            }

            public /* synthetic */ Object nullSafeFromParcel(Parcel parcel) {
                return cf(parcel);
            }

            public /* synthetic */ void nullSafeToParcel(Object obj, Parcel parcel) {
                m16351a((SparseBooleanArray) obj, parcel);
            }

            public SparseBooleanArray cf(Parcel parcel) {
                return parcel.readSparseBooleanArray();
            }

            public void m16351a(SparseBooleanArray sparseBooleanArray, Parcel parcel) {
                parcel.writeSparseBooleanArray(sparseBooleanArray);
            }
        }

        static final class C5147a implements Creator<SparseBooleanArrayParcelable> {
            private C5147a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return cg(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pV(i);
            }

            public SparseBooleanArrayParcelable cg(Parcel parcel) {
                return new SparseBooleanArrayParcelable(parcel);
            }

            public SparseBooleanArrayParcelable[] pV(int i) {
                return new SparseBooleanArrayParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public SparseBooleanArrayParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public SparseBooleanArrayParcelable(SparseBooleanArray sparseBooleanArray) {
            super((Object) sparseBooleanArray, CONVERTER);
        }
    }

    public static final class StringParcelable implements Parcelable, ParcelWrapper<String> {
        public static final C5148a CREATOR = new C5148a();
        private String contents;

        static final class C5148a implements Creator<StringParcelable> {
            private C5148a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return ch(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pW(i);
            }

            public StringParcelable ch(Parcel parcel) {
                return new StringParcelable(parcel);
            }

            public StringParcelable[] pW(int i) {
                return new StringParcelable[i];
            }
        }

        private StringParcelable(Parcel parcel) {
            this.contents = parcel.readString();
        }

        private StringParcelable(String str) {
            this.contents = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.contents);
        }

        public int describeContents() {
            return 0;
        }

        public String getParcel() {
            return this.contents;
        }
    }

    public static final class TreeMapParcelable extends C5109i<Map> {
        private static final TreeMapParcelConverter CONVERTER = new C51491();
        public static final C5150a CREATOR = new C5150a();

        static class C51491 extends TreeMapParcelConverter {
            C51491() {
            }

            public void mapKeyToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }

            public void mapValueToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }

            public Object mapKeyFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            public Object mapValueFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }
        }

        static final class C5150a implements Creator<TreeMapParcelable> {
            private C5150a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return ci(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pX(i);
            }

            public TreeMapParcelable ci(Parcel parcel) {
                return new TreeMapParcelable(parcel);
            }

            public TreeMapParcelable[] pX(int i) {
                return new TreeMapParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public TreeMapParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public TreeMapParcelable(Map map) {
            super((Object) map, CONVERTER);
        }
    }

    public static final class TreeSetParcelable extends C5109i<Set> {
        private static final TreeSetParcelConverter CONVERTER = new C51511();
        public static final C5152a CREATOR = new C5152a();

        static class C51511 extends TreeSetParcelConverter {
            C51511() {
            }

            public Object itemFromParcel(Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(TreeSetParcelable.class.getClassLoader()));
            }

            public void itemToParcel(Object obj, Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        }

        static final class C5152a implements Creator<TreeSetParcelable> {
            private C5152a() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return cj(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return pY(i);
            }

            public TreeSetParcelable cj(Parcel parcel) {
                return new TreeSetParcelable(parcel);
            }

            public TreeSetParcelable[] pY(int i) {
                return new TreeSetParcelable[i];
            }
        }

        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public TreeSetParcelable(Parcel parcel) {
            super(parcel, CONVERTER);
        }

        public TreeSetParcelable(Set set) {
            super((Object) set, CONVERTER);
        }
    }

    static class C5153a implements ParcelableFactory<boolean[]> {
        private C5153a() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16352a((boolean[]) obj);
        }

        public Parcelable m16352a(boolean[] zArr) {
            return new BooleanArrayParcelable(zArr);
        }
    }

    static class C5154b implements ParcelableFactory<Boolean> {
        private C5154b() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16353n((Boolean) obj);
        }

        public Parcelable m16353n(Boolean bool) {
            return new BooleanParcelable(bool.booleanValue());
        }
    }

    static class C5155c implements ParcelableFactory<Bundle> {
        private C5155c() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16354U((Bundle) obj);
        }

        public Parcelable m16354U(Bundle bundle) {
            return bundle;
        }
    }

    static class C5156d implements ParcelableFactory<byte[]> {
        private C5156d() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return az((byte[]) obj);
        }

        public Parcelable az(byte[] bArr) {
            return new ByteArrayParcelable(bArr);
        }
    }

    static class C5157e implements ParcelableFactory<Byte> {
        private C5157e() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16355a((Byte) obj);
        }

        public Parcelable m16355a(Byte b) {
            return new ByteParcelable(b);
        }
    }

    static class C5158f implements ParcelableFactory<char[]> {
        private C5158f() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16356e((char[]) obj);
        }

        public Parcelable m16356e(char[] cArr) {
            return new CharArrayParcelable(cArr);
        }
    }

    static class C5159g implements ParcelableFactory<Character> {
        private C5159g() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16357a((Character) obj);
        }

        public Parcelable m16357a(Character ch) {
            return new CharacterParcelable(ch);
        }
    }

    static class C5160h implements ParcelableFactory<Collection> {
        private C5160h() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16358n((Collection) obj);
        }

        public Parcelable m16358n(Collection collection) {
            return new CollectionParcelable(collection);
        }
    }

    static class C5161j implements ParcelableFactory<Double> {
        private C5161j() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16359e((Double) obj);
        }

        public Parcelable m16359e(Double d) {
            return new DoubleParcelable(d);
        }
    }

    static class C5162k implements ParcelableFactory<Float> {
        private C5162k() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16360a((Float) obj);
        }

        public Parcelable m16360a(Float f) {
            return new FloatParcelable(f);
        }
    }

    static class C5163l implements ParcelableFactory<IBinder> {
        private C5163l() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16361t((IBinder) obj);
        }

        public Parcelable m16361t(IBinder iBinder) {
            return new IBinderParcelable(iBinder);
        }
    }

    static class C5164m implements ParcelableFactory<Integer> {
        private C5164m() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16362e((Integer) obj);
        }

        public Parcelable m16362e(Integer num) {
            return new IntegerParcelable(num);
        }
    }

    static class C5165n implements ParcelableFactory<LinkedHashMap> {
        private C5165n() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16363a((LinkedHashMap) obj);
        }

        public Parcelable m16363a(LinkedHashMap linkedHashMap) {
            return new LinkedHashMapParcelable(linkedHashMap);
        }
    }

    static class C5166o implements ParcelableFactory<LinkedHashSet> {
        private C5166o() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16364a((LinkedHashSet) obj);
        }

        public Parcelable m16364a(LinkedHashSet linkedHashSet) {
            return new LinkedHashSetParcelable(linkedHashSet);
        }
    }

    static class C5167p implements ParcelableFactory<LinkedList> {
        private C5167p() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16365a((LinkedList) obj);
        }

        public Parcelable m16365a(LinkedList linkedList) {
            return new LinkedListParcelable(linkedList);
        }
    }

    static class C5168q implements ParcelableFactory<List> {
        private C5168q() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return aK((List) obj);
        }

        public Parcelable aK(List list) {
            return new ListParcelable(list);
        }
    }

    static class C5169r implements ParcelableFactory<Long> {
        private C5169r() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16366f((Long) obj);
        }

        public Parcelable m16366f(Long l) {
            return new LongParcelable(l);
        }
    }

    static class C5170s implements ParcelableFactory<Map> {
        private C5170s() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16367C((Map) obj);
        }

        public Parcelable m16367C(Map map) {
            return new MapParcelable(map);
        }
    }

    static class C5171t implements ParcelableFactory<Parcelable> {
        C5171t() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16368b((Parcelable) obj);
        }

        public Parcelable m16368b(Parcelable parcelable) {
            return new ParcelableParcelable(parcelable);
        }
    }

    static class C5172u implements ParcelableFactory<Set> {
        private C5172u() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16369j((Set) obj);
        }

        public Parcelable m16369j(Set set) {
            return new SetParcelable(set);
        }
    }

    static class C5173v implements ParcelableFactory<SparseArray> {
        private C5173v() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16370c((SparseArray) obj);
        }

        public Parcelable m16370c(SparseArray sparseArray) {
            return new SparseArrayParcelable(sparseArray);
        }
    }

    static class C5174w implements ParcelableFactory<SparseBooleanArray> {
        private C5174w() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16371a((SparseBooleanArray) obj);
        }

        public Parcelable m16371a(SparseBooleanArray sparseBooleanArray) {
            return new SparseBooleanArrayParcelable(sparseBooleanArray);
        }
    }

    static class C5175x implements ParcelableFactory<String> {
        private C5175x() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return mU((String) obj);
        }

        public Parcelable mU(String str) {
            return new StringParcelable(str);
        }
    }

    static class C5176y implements ParcelableFactory<Map> {
        private C5176y() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16372C((Map) obj);
        }

        public Parcelable m16372C(Map map) {
            return new TreeMapParcelable(map);
        }
    }

    static class C5177z implements ParcelableFactory<Set> {
        private C5177z() {
        }

        public /* synthetic */ Parcelable buildParcelable(Object obj) {
            return m16373j((Set) obj);
        }

        public Parcelable m16373j(Set set) {
            return new TreeSetParcelable(set);
        }
    }

    private NonParcelRepository() {
        this.dWm.put(Collection.class, new C5160h());
        this.dWm.put(List.class, new C5168q());
        this.dWm.put(ArrayList.class, new C5168q());
        this.dWm.put(Set.class, new C5172u());
        this.dWm.put(HashSet.class, new C5172u());
        this.dWm.put(TreeSet.class, new C5177z());
        this.dWm.put(SparseArray.class, new C5173v());
        this.dWm.put(Map.class, new C5170s());
        this.dWm.put(HashMap.class, new C5170s());
        this.dWm.put(TreeMap.class, new C5176y());
        this.dWm.put(Integer.class, new C5164m());
        this.dWm.put(Long.class, new C5169r());
        this.dWm.put(Double.class, new C5161j());
        this.dWm.put(Float.class, new C5162k());
        this.dWm.put(Byte.class, new C5157e());
        this.dWm.put(String.class, new C5175x());
        this.dWm.put(Character.class, new C5159g());
        this.dWm.put(Boolean.class, new C5154b());
        this.dWm.put(byte[].class, new C5156d());
        this.dWm.put(char[].class, new C5158f());
        this.dWm.put(boolean[].class, new C5153a());
        this.dWm.put(IBinder.class, new C5163l());
        this.dWm.put(Bundle.class, new C5155c());
        this.dWm.put(SparseBooleanArray.class, new C5174w());
        this.dWm.put(LinkedList.class, new C5167p());
        this.dWm.put(LinkedHashMap.class, new C5165n());
        this.dWm.put(SortedMap.class, new C5176y());
        this.dWm.put(SortedSet.class, new C5177z());
        this.dWm.put(LinkedHashSet.class, new C5166o());
    }

    public static NonParcelRepository aHV() {
        return dWl;
    }

    public Map<Class, ParcelableFactory> get() {
        return this.dWm;
    }
}
