package com.google.common.primitives;

import com.fossil.cco;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Ints {

    static class IntArrayAsList extends AbstractList<Integer> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        IntArrayAsList(int[] iArr, int i, int i2) {
            this.array = iArr;
            this.start = i;
            this.end = i2;
        }

        public int size() {
            return this.end - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public Integer get(int i) {
            cco.bO(i, size());
            return Integer.valueOf(this.array[this.start + i]);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Integer) && Ints.m14485b(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                int d = Ints.m14485b(this.array, ((Integer) obj).intValue(), this.start, this.end);
                if (d >= 0) {
                    return d - this.start;
                }
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                int e = Ints.m14486c(this.array, ((Integer) obj).intValue(), this.start, this.end);
                if (e >= 0) {
                    return e - this.start;
                }
            }
            return -1;
        }

        public Integer set(int i, Integer num) {
            cco.bO(i, size());
            int i2 = this.array[this.start + i];
            this.array[this.start + i] = ((Integer) cco.ce(num)).intValue();
            return Integer.valueOf(i2);
        }

        public List<Integer> subList(int i, int i2) {
            cco.C(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            return new IntArrayAsList(this.array, this.start + i, this.start + i2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != intArrayAsList.array[intArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Ints.hashCode(this.array[i2]);
            }
            return i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(size() * 5);
            stringBuilder.append('[').append(this.array[this.start]);
            for (int i = this.start + 1; i < this.end; i++) {
                stringBuilder.append(", ").append(this.array[i]);
            }
            return stringBuilder.append(']').toString();
        }

        int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }
    }

    public static int hashCode(int i) {
        return i;
    }

    public static int aw(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    private static int m14485b(int[] iArr, int i, int i2, int i3) {
        for (int i4 = i2; i4 < i3; i4++) {
            if (iArr[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    private static int m14486c(int[] iArr, int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (iArr[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    public static int[] m14489i(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).toIntArray();
        }
        Object[] toArray = collection.toArray();
        int length = toArray.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) cco.ce(toArray[i])).intValue();
        }
        return iArr;
    }
}
