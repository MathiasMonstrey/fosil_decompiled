package io.reactivex.internal.disposables;

import com.fossil.eqn;
import com.fossil.era;
import com.fossil.ers;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

public enum DisposableHelper implements eqn {
    DISPOSED;

    public static boolean isDisposed(eqn com_fossil_eqn) {
        return com_fossil_eqn == DISPOSED;
    }

    public static boolean set(AtomicReference<eqn> atomicReference, eqn com_fossil_eqn) {
        eqn com_fossil_eqn2;
        do {
            com_fossil_eqn2 = (eqn) atomicReference.get();
            if (com_fossil_eqn2 == DISPOSED) {
                if (com_fossil_eqn != null) {
                    com_fossil_eqn.dispose();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(com_fossil_eqn2, com_fossil_eqn));
        if (com_fossil_eqn2 != null) {
            com_fossil_eqn2.dispose();
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<eqn> atomicReference, eqn com_fossil_eqn) {
        era.requireNonNull(com_fossil_eqn, "d is null");
        if (atomicReference.compareAndSet(null, com_fossil_eqn)) {
            return true;
        }
        com_fossil_eqn.dispose();
        if (atomicReference.get() != DISPOSED) {
            reportDisposableSet();
        }
        return false;
    }

    public static boolean replace(AtomicReference<eqn> atomicReference, eqn com_fossil_eqn) {
        eqn com_fossil_eqn2;
        do {
            com_fossil_eqn2 = (eqn) atomicReference.get();
            if (com_fossil_eqn2 == DISPOSED) {
                if (com_fossil_eqn != null) {
                    com_fossil_eqn.dispose();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(com_fossil_eqn2, com_fossil_eqn));
        return true;
    }

    public static boolean dispose(AtomicReference<eqn> atomicReference) {
        eqn com_fossil_eqn = (eqn) atomicReference.get();
        eqn com_fossil_eqn2 = DISPOSED;
        if (com_fossil_eqn != com_fossil_eqn2) {
            com_fossil_eqn = (eqn) atomicReference.getAndSet(com_fossil_eqn2);
            if (com_fossil_eqn != com_fossil_eqn2) {
                if (com_fossil_eqn != null) {
                    com_fossil_eqn.dispose();
                }
                return true;
            }
        }
        return false;
    }

    public static boolean validate(eqn com_fossil_eqn, eqn com_fossil_eqn2) {
        if (com_fossil_eqn2 == null) {
            ers.onError(new NullPointerException("next is null"));
            return false;
        } else if (com_fossil_eqn == null) {
            return true;
        } else {
            com_fossil_eqn2.dispose();
            reportDisposableSet();
            return false;
        }
    }

    public static void reportDisposableSet() {
        ers.onError(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean trySet(AtomicReference<eqn> atomicReference, eqn com_fossil_eqn) {
        if (atomicReference.compareAndSet(null, com_fossil_eqn)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            com_fossil_eqn.dispose();
        }
        return false;
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }
}
