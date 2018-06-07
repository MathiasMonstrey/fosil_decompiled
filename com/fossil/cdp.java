package com.fossil;

import java.util.Comparator;

public interface cdp<T> extends Iterable<T> {
    Comparator<? super T> comparator();
}
