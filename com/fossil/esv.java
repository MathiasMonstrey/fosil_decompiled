package com.fossil;

class esv extends esu {
    public static final boolean m11131a(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        if (Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2)) {
            return true;
        }
        return false;
    }
}
