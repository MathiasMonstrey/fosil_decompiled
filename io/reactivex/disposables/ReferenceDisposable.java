package io.reactivex.disposables;

import com.fossil.eqn;
import com.fossil.era;
import java.util.concurrent.atomic.AtomicReference;

abstract class ReferenceDisposable<T> extends AtomicReference<T> implements eqn {
    private static final long serialVersionUID = 6537757548749041217L;

    protected abstract void onDisposed(T t);

    ReferenceDisposable(T t) {
        super(era.requireNonNull(t, "value is null"));
    }

    public final void dispose() {
        if (get() != null) {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                onDisposed(andSet);
            }
        }
    }

    public final boolean isDisposed() {
        return get() == null;
    }
}
