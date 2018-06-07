package com.fossil;

public abstract class dvr implements Runnable {
    protected final String name;

    protected abstract void execute();

    public dvr(String str, Object... objArr) {
        this.name = String.format(str, objArr);
    }

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            execute();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
