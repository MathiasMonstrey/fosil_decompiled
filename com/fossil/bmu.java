package com.fossil;

import android.os.DeadObjectException;
import android.os.IInterface;

public interface bmu<T extends IInterface> {
    void Ll();

    T Lm() throws DeadObjectException;
}
