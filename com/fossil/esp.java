package com.fossil;

public final class esp extends esn {
    private static final esp dSV = new esp(1, 0);
    public static final C3536a dSW = new C3536a();

    public static final class C3536a {
        private C3536a() {
        }
    }

    public esp(int i, int i2) {
        super(i, i2, 1);
    }

    public boolean isEmpty() {
        return aGX() > aGY();
    }

    public boolean equals(Object obj) {
        return (obj instanceof esp) && ((isEmpty() && ((esp) obj).isEmpty()) || (aGX() == ((esp) obj).aGX() && aGY() == ((esp) obj).aGY()));
    }

    public int hashCode() {
        return isEmpty() ? -1 : (aGX() * 31) + aGY();
    }

    public String toString() {
        return "" + aGX() + ".." + aGY();
    }
}
