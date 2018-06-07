package com.fossil;

final class bdz extends ThreadLocal<Boolean> {
    bdz() {
    }

    protected final /* synthetic */ Object initialValue() {
        return Boolean.valueOf(false);
    }
}
