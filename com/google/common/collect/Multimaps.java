package com.google.common.collect;

import com.fossil.cco;
import com.fossil.ccq;
import com.fossil.ccu;
import com.fossil.ccw;
import com.fossil.cdh;
import com.fossil.cdi;
import com.fossil.cdj;
import com.fossil.cdj.a;
import com.fossil.cdo;
import com.fossil.cds;
import com.google.common.collect.Multisets.C4354a;
import com.google.common.collect.Multisets.C4357c;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Multimaps {

    static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient ccq<? extends List<V>> factory;

        CustomListMultimap(Map<K, Collection<V>> map, ccq<? extends List<V>> com_fossil_ccq__extends_java_util_List_V) {
            super(map);
            this.factory = (ccq) cco.ce(com_fossil_ccq__extends_java_util_List_V);
        }

        protected List<V> createCollection() {
            return (List) this.factory.get();
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (ccq) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }
    }

    static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient ccq<? extends Set<V>> factory;

        CustomSetMultimap(Map<K, Collection<V>> map, ccq<? extends Set<V>> com_fossil_ccq__extends_java_util_Set_V) {
            super(map);
            this.factory = (ccq) cco.ce(com_fossil_ccq__extends_java_util_Set_V);
        }

        protected Set<V> createCollection() {
            return (Set) this.factory.get();
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (ccq) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }
    }

    public static abstract class C4353a<K, V> extends AbstractCollection<Entry<K, V>> {
        public abstract cdi<K, V> Ux();

        protected C4353a() {
        }

        public int size() {
            return Ux().size();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return Ux().containsEntry(entry.getKey(), entry.getValue());
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return Ux().remove(entry.getKey(), entry.getValue());
        }

        public void clear() {
            Ux().clear();
        }
    }

    public static class C4359b<K, V> extends ccu<K> {
        final cdi<K, V> bNF;

        class C4358a extends C4357c<K> {
            final /* synthetic */ C4359b bNG;

            C4358a(C4359b c4359b) {
                this.bNG = c4359b;
            }

            cdj<K> UA() {
                return this.bNG;
            }

            public Iterator<a<K>> iterator() {
                return this.bNG.entryIterator();
            }

            public int size() {
                return this.bNG.Uz();
            }

            public boolean isEmpty() {
                return this.bNG.bNF.isEmpty();
            }

            public boolean contains(Object obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                Collection collection = (Collection) this.bNG.bNF.asMap().get(aVar.getElement());
                if (collection == null || collection.size() != aVar.getCount()) {
                    return false;
                }
                return true;
            }

            public boolean remove(Object obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    Collection collection = (Collection) this.bNG.bNF.asMap().get(aVar.getElement());
                    if (collection != null && collection.size() == aVar.getCount()) {
                        collection.clear();
                        return true;
                    }
                }
                return false;
            }
        }

        public C4359b(cdi<K, V> com_fossil_cdi_K__V) {
            this.bNF = com_fossil_cdi_K__V;
        }

        Iterator<a<K>> entryIterator() {
            return new cds<Entry<K, Collection<V>>, a<K>>(this, this.bNF.asMap().entrySet().iterator()) {
                final /* synthetic */ C4359b bNG;

                /* synthetic */ Object cu(Object obj) {
                    return m14464g((Entry) obj);
                }

                a<K> m14464g(final Entry<K, Collection<V>> entry) {
                    return new C4354a<K>(this) {
                        final /* synthetic */ C43561 bNH;

                        public K getElement() {
                            return entry.getKey();
                        }

                        public int getCount() {
                            return ((Collection) entry.getValue()).size();
                        }
                    };
                }
            };
        }

        int Uz() {
            return this.bNF.asMap().size();
        }

        Set<a<K>> Uf() {
            return new C4358a(this);
        }

        public boolean contains(Object obj) {
            return this.bNF.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return Maps.m14461m(this.bNF.entries().iterator());
        }

        public int count(Object obj) {
            Collection collection = (Collection) Maps.m14453a(this.bNF.asMap(), obj);
            return collection == null ? 0 : collection.size();
        }

        public int remove(Object obj, int i) {
            int i2 = 0;
            ccw.n(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.m14453a(this.bNF.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                while (i2 < i) {
                    it.next();
                    it.remove();
                    i2++;
                }
            }
            return size;
        }

        public void clear() {
            this.bNF.clear();
        }

        public Set<K> elementSet() {
            return this.bNF.keySet();
        }
    }

    public static <K, V> cdh<K, V> m14465a(Map<K, Collection<V>> map, ccq<? extends List<V>> com_fossil_ccq__extends_java_util_List_V) {
        return new CustomListMultimap(map, com_fossil_ccq__extends_java_util_List_V);
    }

    public static <K, V> cdo<K, V> m14467b(Map<K, Collection<V>> map, ccq<? extends Set<V>> com_fossil_ccq__extends_java_util_Set_V) {
        return new CustomSetMultimap(map, com_fossil_ccq__extends_java_util_Set_V);
    }

    public static boolean m14466a(cdi<?, ?> com_fossil_cdi___, Object obj) {
        if (obj == com_fossil_cdi___) {
            return true;
        }
        if (!(obj instanceof cdi)) {
            return false;
        }
        return com_fossil_cdi___.asMap().equals(((cdi) obj).asMap());
    }
}
