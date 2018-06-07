package com.fossil;

import io.reactivex.internal.util.ExceptionHelper;

public final class eqp {
    public static RuntimeException m11066j(Throwable th) {
        throw ExceptionHelper.m(th);
    }

    public static void m11067k(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
