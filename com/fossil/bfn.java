package com.fossil;

import android.os.Bundle;
import com.fossil.ats.C1887c;

public interface bfn {
    void mo1317a(atn com_fossil_atn, ats<?> com_fossil_ats_, boolean z);

    void begin();

    <A extends C1887c, R extends atz, T extends bds<R, A>> T mo1319c(T t);

    void connect();

    <A extends C1887c, T extends bds<? extends atz, A>> T mo1321d(T t);

    boolean disconnect();

    void hr(int i);

    void mo1324l(Bundle bundle);
}
