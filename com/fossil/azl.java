package com.fossil;

import dalvik.system.PathClassLoader;

public final class azl extends PathClassLoader {
    public azl(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    protected final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!(str.startsWith("java.") || str.startsWith("android."))) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException e) {
            }
        }
        return super.loadClass(str, z);
    }
}
