package com.fossil;

import com.fossil.ats.C1887c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface bge {
    void KD();

    atn KE();

    void Nl();

    boolean mo1288a(bgv com_fossil_bgv);

    <A extends C1887c, R extends atz, T extends bds<R, A>> T mo1289c(T t);

    void connect();

    <A extends C1887c, T extends bds<? extends atz, A>> T mo1291d(T t);

    void disconnect();

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    boolean isConnected();

    boolean isConnecting();
}
