package com.fossil;

import com.google.gson.JsonIOException;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class cge {
    private final Map<Type, cfl<?>> bRa;

    class C20352 implements cgg<T> {
        final /* synthetic */ cge bRq;

        C20352(cge com_fossil_cge) {
            this.bRq = com_fossil_cge;
        }

        public T WL() {
            return new ConcurrentHashMap();
        }
    }

    class C20363 implements cgg<T> {
        final /* synthetic */ cge bRq;

        C20363(cge com_fossil_cge) {
            this.bRq = com_fossil_cge;
        }

        public T WL() {
            return new TreeMap();
        }
    }

    class C20374 implements cgg<T> {
        final /* synthetic */ cge bRq;

        C20374(cge com_fossil_cge) {
            this.bRq = com_fossil_cge;
        }

        public T WL() {
            return new LinkedHashMap();
        }
    }

    class C20385 implements cgg<T> {
        final /* synthetic */ cge bRq;

        C20385(cge com_fossil_cge) {
            this.bRq = com_fossil_cge;
        }

        public T WL() {
            return new LinkedTreeMap();
        }
    }

    class C20429 implements cgg<T> {
        final /* synthetic */ cge bRq;

        C20429(cge com_fossil_cge) {
            this.bRq = com_fossil_cge;
        }

        public T WL() {
            return new TreeSet();
        }
    }

    public cge(Map<Type, cfl<?>> map) {
        this.bRa = map;
    }

    public <T> cgg<T> m6236b(cgu<T> com_fossil_cgu_T) {
        final Type type = com_fossil_cgu_T.getType();
        Class rawType = com_fossil_cgu_T.getRawType();
        final cfl com_fossil_cfl = (cfl) this.bRa.get(type);
        if (com_fossil_cfl != null) {
            return new cgg<T>(this) {
                final /* synthetic */ cge bRq;

                public T WL() {
                    return com_fossil_cfl.m6209t(type);
                }
            };
        }
        com_fossil_cfl = (cfl) this.bRa.get(rawType);
        if (com_fossil_cfl != null) {
            return new cgg<T>(this) {
                final /* synthetic */ cge bRq;

                public T WL() {
                    return com_fossil_cfl.m6209t(type);
                }
            };
        }
        cgg<T> ab = ab(rawType);
        if (ab != null) {
            return ab;
        }
        ab = m6234c(type, rawType);
        return ab == null ? m6235d(type, rawType) : ab;
    }

    private <T> cgg<T> ab(Class<? super T> cls) {
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new cgg<T>(this) {
                final /* synthetic */ cge bRq;

                public T WL() {
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (Throwable e) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2.getTargetException());
                    } catch (IllegalAccessException e3) {
                        throw new AssertionError(e3);
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> cgg<T> m6234c(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new C20429(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new cgg<T>(this) {
                    final /* synthetic */ cge bRq;

                    public T WL() {
                        if (type instanceof ParameterizedType) {
                            Type type = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (type instanceof Class) {
                                return EnumSet.noneOf((Class) type);
                            }
                            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new cgg<T>(this) {
                    final /* synthetic */ cge bRq;

                    {
                        this.bRq = r1;
                    }

                    public T WL() {
                        return new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new cgg<T>(this) {
                    final /* synthetic */ cge bRq;

                    {
                        this.bRq = r1;
                    }

                    public T WL() {
                        return new ArrayDeque();
                    }
                };
            }
            return new cgg<T>(this) {
                final /* synthetic */ cge bRq;

                {
                    this.bRq = r1;
                }

                public T WL() {
                    return new ArrayList();
                }
            };
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new cgg<T>(this) {
                    final /* synthetic */ cge bRq;

                    {
                        this.bRq = r1;
                    }

                    public T WL() {
                        return new ConcurrentSkipListMap();
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new C20352(this);
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new C20363(this);
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(cgu.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new C20385(this);
            }
            return new C20374(this);
        }
    }

    private <T> cgg<T> m6235d(final Type type, final Class<? super T> cls) {
        return new cgg<T>(this) {
            final /* synthetic */ cge bRq;
            private final cgj bRr = cgj.WS();

            public T WL() {
                try {
                    return this.bRr.af(cls);
                } catch (Throwable e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public String toString() {
        return this.bRa.toString();
    }
}
