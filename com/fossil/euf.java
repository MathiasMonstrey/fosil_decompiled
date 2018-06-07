package com.fossil;

import java.io.PrintWriter;

public interface euf {
    Throwable getCause();

    String getMessage(int i);

    void printPartialStackTrace(PrintWriter printWriter);
}
