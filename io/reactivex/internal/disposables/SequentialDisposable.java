package io.reactivex.internal.disposables;

import com.fossil.eqn;
import java.util.concurrent.atomic.AtomicReference;

public final class SequentialDisposable extends AtomicReference<eqn> implements eqn {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable(eqn com_fossil_eqn) {
        lazySet(com_fossil_eqn);
    }

    public boolean update(eqn com_fossil_eqn) {
        return DisposableHelper.set(this, com_fossil_eqn);
    }

    public boolean replace(eqn com_fossil_eqn) {
        return DisposableHelper.replace(this, com_fossil_eqn);
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((eqn) get());
    }
}
