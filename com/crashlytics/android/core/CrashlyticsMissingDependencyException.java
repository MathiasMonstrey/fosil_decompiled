package com.crashlytics.android.core;

public class CrashlyticsMissingDependencyException extends RuntimeException {
    private static final long serialVersionUID = -1151536370019872859L;

    public CrashlyticsMissingDependencyException(String str) {
        super(ay(str));
    }

    private static String ay(String str) {
        return "\n" + str + "\n";
    }
}
