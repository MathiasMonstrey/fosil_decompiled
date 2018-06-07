package com.fossil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public final class cea {
    public static <T> T m6052a(Class<T> cls, InvocationHandler invocationHandler) {
        cco.ce(invocationHandler);
        cco.m5986a(cls.isInterface(), "%s is not an interface", (Object) cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
