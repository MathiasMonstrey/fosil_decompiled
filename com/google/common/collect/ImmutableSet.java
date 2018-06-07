package com.google.common.collect;

import com.fossil.cco;
import com.fossil.cdf;
import com.fossil.cdk;
import com.fossil.cdt;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    static final int MAX_TABLE_SIZE = 1073741824;
    private transient ImmutableList<E> bMP;

    public abstract cdt<E> iterator();

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    public static <E> ImmutableSet<E> of(E e) {
        return new SingletonImmutableSet(e);
    }

    public static <E> ImmutableSet<E> of(E e, E e2) {
        return m12661a(2, e, e2);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3) {
        return m12661a(3, e, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4) {
        return m12661a(4, e, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5) {
        return m12661a(5, e, e2, e3, e4, e5);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Object obj = new Object[(eArr.length + 6)];
        obj[0] = e;
        obj[1] = e2;
        obj[2] = e3;
        obj[3] = e4;
        obj[4] = e5;
        obj[5] = e6;
        System.arraycopy(eArr, 0, obj, 6, eArr.length);
        return m12661a(obj.length, obj);
    }

    private static <E> ImmutableSet<E> m12661a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return of();
            case 1:
                return of(objArr[0]);
            default:
                int chooseTableSize = chooseTableSize(i);
                Object[] objArr2 = new Object[chooseTableSize];
                int i2 = chooseTableSize - 1;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    Object x = cdk.m6020x(objArr[i5], i5);
                    int hashCode = x.hashCode();
                    int iv = cdf.iv(hashCode);
                    while (true) {
                        int i6 = iv & i2;
                        Object obj = objArr2[i6];
                        if (obj == null) {
                            iv = i3 + 1;
                            objArr[i3] = x;
                            objArr2[i6] = x;
                            i4 += hashCode;
                            i3 = iv;
                        } else if (!obj.equals(x)) {
                            iv++;
                        }
                    }
                }
                Arrays.fill(objArr, i3, i, null);
                if (i3 == 1) {
                    return new SingletonImmutableSet(objArr[0], i4);
                }
                if (chooseTableSize(i3) < chooseTableSize / 2) {
                    return m12661a(i3, objArr);
                }
                Object[] copyOf;
                if (i3 < objArr.length / 2) {
                    copyOf = Arrays.copyOf(objArr, i3);
                } else {
                    copyOf = objArr;
                }
                return new RegularImmutableSet(copyOf, i4, objArr2, i2, i3);
        }
    }

    static int chooseTableSize(int i) {
        if (i < 751619276) {
            int highestOneBit = Integer.highestOneBit(i - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) i)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        cco.m5991d(i < MAX_TABLE_SIZE, "collection too large");
        return MAX_TABLE_SIZE;
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] toArray = collection.toArray();
        return m12661a(toArray.length, toArray);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        Object next = it.next();
        if (it.hasNext()) {
            return new a().cr(next).f(it).UN();
        }
        return of(next);
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        switch (eArr.length) {
            case 0:
                return of();
            case 1:
                return of(eArr[0]);
            default:
                return m12661a(eArr.length, (Object[]) eArr.clone());
        }
    }

    ImmutableSet() {
    }

    boolean isHashCodeFast() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.b(this, obj);
    }

    public int hashCode() {
        return Sets.h(this);
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.bMP;
        if (immutableList != null) {
            return immutableList;
        }
        immutableList = createAsList();
        this.bMP = immutableList;
        return immutableList;
    }

    ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> a<E> builder() {
        return new a();
    }
}
