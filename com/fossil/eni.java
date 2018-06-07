package com.fossil;

public abstract class eni {
    private final String sessionId;

    public static class C3473a extends eni {
        public C3473a(String str) {
            super(str);
        }
    }

    public eni(String str) {
        this.sessionId = str;
    }

    public String aFq() {
        return this.sessionId;
    }
}
