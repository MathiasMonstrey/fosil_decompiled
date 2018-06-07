package com.google.common.collect;

import com.fossil.ccq;
import com.fossil.ccw;
import com.fossil.cdh;
import com.fossil.cdo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class MultimapBuilder<K0, V0> {

    public static abstract class C4346b<K0> {
        abstract <K extends K0, V> Map<K, Collection<V>> createMap();

        C4346b() {
        }

        public C4349a<K0, Object> Vx() {
            return iF(2);
        }

        public C4349a<K0, Object> iF(final int i) {
            ccw.n(i, "expectedValuesPerKey");
            return new C4349a<K0, Object>(this) {
                final /* synthetic */ C4346b bNE;

                public <K extends K0, V> cdh<K, V> Vw() {
                    return Multimaps.m14465a(this.bNE.createMap(), new ArrayListSupplier(i));
                }
            };
        }

        public C4351c<K0, Object> Vy() {
            return iG(2);
        }

        public C4351c<K0, Object> iG(final int i) {
            ccw.n(i, "expectedValuesPerKey");
            return new C4351c<K0, Object>(this) {
                final /* synthetic */ C4346b bNE;

                public <K extends K0, V> cdo<K, V> Vz() {
                    return Multimaps.m14467b(this.bNE.createMap(), new LinkedHashSetSupplier(i));
                }
            };
        }
    }

    static class C43471 extends C4346b<Object> {
        final /* synthetic */ int bNC;

        <K, V> Map<K, Collection<V>> createMap() {
            return Maps.iB(this.bNC);
        }
    }

    static final class ArrayListSupplier<V> implements ccq<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        ArrayListSupplier(int i) {
            this.expectedValuesPerKey = ccw.n(i, "expectedValuesPerKey");
        }

        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    static final class LinkedHashSetSupplier<V> implements ccq<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        LinkedHashSetSupplier(int i) {
            this.expectedValuesPerKey = ccw.n(i, "expectedValuesPerKey");
        }

        public Set<V> get() {
            return Sets.iO(this.expectedValuesPerKey);
        }
    }

    public static abstract class C4349a<K0, V0> extends MultimapBuilder<K0, V0> {
        public abstract <K extends K0, V extends V0> cdh<K, V> Vw();

        C4349a() {
            super();
        }
    }

    public static abstract class C4351c<K0, V0> extends MultimapBuilder<K0, V0> {
        public abstract <K extends K0, V extends V0> cdo<K, V> Vz();

        C4351c() {
            super();
        }
    }

    private MultimapBuilder() {
    }

    public static C4346b<Object> Vv() {
        return iE(8);
    }

    public static C4346b<Object> iE(final int i) {
        ccw.n(i, "expectedKeys");
        return new C4346b<Object>() {
            <K, V> Map<K, Collection<V>> createMap() {
                return Maps.iD(i);
            }
        };
    }
}
