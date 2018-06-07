package com.fossil;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class js<K, V> {
    C3759b Qw;
    C3760c Qx;
    C3762e Qy;

    final class C3758a<T> implements Iterator<T> {
        boolean QA = false;
        final /* synthetic */ js QB;
        final int Qz;
        int mIndex;
        int mSize;

        C3758a(js jsVar, int i) {
            this.QB = jsVar;
            this.Qz = i;
            this.mSize = jsVar.jn();
        }

        public boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        public T next() {
            T y = this.QB.mo3247y(this.mIndex, this.Qz);
            this.mIndex++;
            this.QA = true;
            return y;
        }

        public void remove() {
            if (this.QA) {
                this.mIndex--;
                this.mSize--;
                this.QA = false;
                this.QB.bh(this.mIndex);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class C3759b implements Set<Entry<K, V>> {
        final /* synthetic */ js QB;

        C3759b(js jsVar) {
            this.QB = jsVar;
        }

        public /* synthetic */ boolean add(Object obj) {
            return m11897a((Entry) obj);
        }

        public boolean m11897a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int jn = this.QB.jn();
            for (Entry entry : collection) {
                this.QB.mo3243c(entry.getKey(), entry.getValue());
            }
            return jn != this.QB.jn();
        }

        public void clear() {
            this.QB.jp();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int ab = this.QB.ab(entry.getKey());
            if (ab >= 0) {
                return jn.equal(this.QB.mo3247y(ab, 1), entry.getValue());
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.QB.jn() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C3761d(this.QB);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.QB.jn();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return js.m11877a((Set) this, obj);
        }

        public int hashCode() {
            int jn = this.QB.jn() - 1;
            int i = 0;
            while (jn >= 0) {
                int i2;
                Object y = this.QB.mo3247y(jn, 0);
                Object y2 = this.QB.mo3247y(jn, 1);
                int hashCode = y == null ? 0 : y.hashCode();
                if (y2 == null) {
                    i2 = 0;
                } else {
                    i2 = y2.hashCode();
                }
                jn--;
                i += i2 ^ hashCode;
            }
            return i;
        }
    }

    final class C3760c implements Set<K> {
        final /* synthetic */ js QB;

        C3760c(js jsVar) {
            this.QB = jsVar;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.QB.jp();
        }

        public boolean contains(Object obj) {
            return this.QB.ab(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return js.m11876a(this.QB.jo(), (Collection) collection);
        }

        public boolean isEmpty() {
            return this.QB.jn() == 0;
        }

        public Iterator<K> iterator() {
            return new C3758a(this.QB, 0);
        }

        public boolean remove(Object obj) {
            int ab = this.QB.ab(obj);
            if (ab < 0) {
                return false;
            }
            this.QB.bh(ab);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return js.m11878b(this.QB.jo(), (Collection) collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return js.m11879c(this.QB.jo(), (Collection) collection);
        }

        public int size() {
            return this.QB.jn();
        }

        public Object[] toArray() {
            return this.QB.bm(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.QB.m11881b((Object[]) tArr, 0);
        }

        public boolean equals(Object obj) {
            return js.m11877a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int jn = this.QB.jn() - 1; jn >= 0; jn--) {
                Object y = this.QB.mo3247y(jn, 0);
                i += y == null ? 0 : y.hashCode();
            }
            return i;
        }
    }

    final class C3761d implements Iterator<Entry<K, V>>, Entry<K, V> {
        final /* synthetic */ js QB;
        int QC;
        boolean QD = false;
        int mIndex;

        public /* synthetic */ Object next() {
            return jv();
        }

        C3761d(js jsVar) {
            this.QB = jsVar;
            this.QC = jsVar.jn() - 1;
            this.mIndex = -1;
        }

        public boolean hasNext() {
            return this.mIndex < this.QC;
        }

        public Entry<K, V> jv() {
            this.mIndex++;
            this.QD = true;
            return this;
        }

        public void remove() {
            if (this.QD) {
                this.QB.bh(this.mIndex);
                this.mIndex--;
                this.QC--;
                this.QD = false;
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.QD) {
                return this.QB.mo3247y(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.QD) {
                return this.QB.mo3247y(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.QD) {
                return this.QB.mo3239a(this.mIndex, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.QD) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(jn.equal(entry.getKey(), this.QB.mo3247y(this.mIndex, 0)) && jn.equal(entry.getValue(), this.QB.mo3247y(this.mIndex, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.QD) {
                Object y = this.QB.mo3247y(this.mIndex, 0);
                Object y2 = this.QB.mo3247y(this.mIndex, 1);
                int hashCode = y == null ? 0 : y.hashCode();
                if (y2 != null) {
                    i = y2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + SimpleComparison.EQUAL_TO_OPERATION + getValue();
        }
    }

    final class C3762e implements Collection<V> {
        final /* synthetic */ js QB;

        C3762e(js jsVar) {
            this.QB = jsVar;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.QB.jp();
        }

        public boolean contains(Object obj) {
            return this.QB.ac(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.QB.jn() == 0;
        }

        public Iterator<V> iterator() {
            return new C3758a(this.QB, 1);
        }

        public boolean remove(Object obj) {
            int ac = this.QB.ac(obj);
            if (ac < 0) {
                return false;
            }
            this.QB.bh(ac);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int jn = this.QB.jn();
            boolean z = false;
            while (i < jn) {
                if (collection.contains(this.QB.mo3247y(i, 1))) {
                    this.QB.bh(i);
                    i--;
                    jn--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int jn = this.QB.jn();
            boolean z = false;
            while (i < jn) {
                if (!collection.contains(this.QB.mo3247y(i, 1))) {
                    this.QB.bh(i);
                    i--;
                    jn--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.QB.jn();
        }

        public Object[] toArray() {
            return this.QB.bm(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.QB.m11881b((Object[]) tArr, 1);
        }
    }

    protected abstract V mo3239a(int i, V v);

    protected abstract int ab(Object obj);

    protected abstract int ac(Object obj);

    protected abstract void bh(int i);

    protected abstract void mo3243c(K k, V v);

    protected abstract int jn();

    protected abstract Map<K, V> jo();

    protected abstract void jp();

    protected abstract Object mo3247y(int i, int i2);

    js() {
    }

    public static <K, V> boolean m11876a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean m11878b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m11879c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] bm(int i) {
        int jn = jn();
        Object[] objArr = new Object[jn];
        for (int i2 = 0; i2 < jn; i2++) {
            objArr[i2] = mo3247y(i2, i);
        }
        return objArr;
    }

    public <T> T[] m11881b(T[] tArr, int i) {
        T[] tArr2;
        int jn = jn();
        if (tArr.length < jn) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), jn);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < jn; i2++) {
            tArr2[i2] = mo3247y(i2, i);
        }
        if (tArr2.length > jn) {
            tArr2[jn] = null;
        }
        return tArr2;
    }

    public static <T> boolean m11877a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public Set<Entry<K, V>> jt() {
        if (this.Qw == null) {
            this.Qw = new C3759b(this);
        }
        return this.Qw;
    }

    public Set<K> getKeySet() {
        if (this.Qx == null) {
            this.Qx = new C3760c(this);
        }
        return this.Qx;
    }

    public Collection<V> ju() {
        if (this.Qy == null) {
            this.Qy = new C3762e(this);
        }
        return this.Qy;
    }
}
