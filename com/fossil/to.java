package com.fossil;

public class to<TResult> {
    private final tn<TResult> axQ = new tn();

    public tn<TResult> tk() {
        return this.axQ;
    }

    public boolean tj() {
        return this.axQ.tj();
    }

    public boolean aU(TResult tResult) {
        return this.axQ.aU(tResult);
    }

    public boolean m13682c(Exception exception) {
        return this.axQ.m13696c(exception);
    }

    public void tl() {
        if (!tj()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void aV(TResult tResult) {
        if (!aU(tResult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void m13683d(Exception exception) {
        if (!m13682c(exception)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
