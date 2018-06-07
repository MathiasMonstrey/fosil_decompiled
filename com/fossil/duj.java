package com.fossil;

import android.util.Log;

public class duj {
    public static boolean dtX = false;

    public static void m9769d(String str, String str2) {
        if (dtX) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.d(str, new StringBuilder(String.valueOf(stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName())).append(": ").append(str2).toString());
        }
    }

    public static void m9771i(String str, String str2) {
        if (dtX) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.i(str, new StringBuilder(String.valueOf(stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName())).append(": ").append(str2).toString());
        }
    }

    public static void m9770e(String str, String str2) {
        if (dtX) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.e(str, new StringBuilder(String.valueOf(stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName())).append(": ").append(str2).toString());
        }
    }

    public static void aS(String str, String str2) {
        if (dtX) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.w(str, new StringBuilder(String.valueOf(stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName())).append(": ").append(str2).toString());
        }
    }

    public static void m9772v(String str, String str2) {
        if (dtX) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.v(str, new StringBuilder(String.valueOf(stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName())).append(": ").append(str2).toString());
        }
    }
}
