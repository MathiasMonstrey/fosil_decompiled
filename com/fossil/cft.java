package com.fossil;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

public final class cft extends cfp {
    private static final Class<?>[] bRl = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object value;

    public cft(Boolean bool) {
        setValue(bool);
    }

    public cft(Number number) {
        setValue(number);
    }

    public cft(String str) {
        setValue(str);
    }

    cft(Object obj) {
        setValue(obj);
    }

    void setValue(Object obj) {
        if (obj instanceof Character) {
            this.value = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z = (obj instanceof Number) || cH(obj);
        cgd.bz(z);
        this.value = obj;
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    Boolean WD() {
        return (Boolean) this.value;
    }

    public boolean getAsBoolean() {
        if (isBoolean()) {
            return WD().booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    public boolean DI() {
        return this.value instanceof Number;
    }

    public Number Wv() {
        return this.value instanceof String ? new LazilyParsedNumber((String) this.value) : (Number) this.value;
    }

    public boolean WE() {
        return this.value instanceof String;
    }

    public String getAsString() {
        if (DI()) {
            return Wv().toString();
        }
        if (isBoolean()) {
            return WD().toString();
        }
        return (String) this.value;
    }

    public double getAsDouble() {
        return DI() ? Wv().doubleValue() : Double.parseDouble(getAsString());
    }

    public long getAsLong() {
        return DI() ? Wv().longValue() : Long.parseLong(getAsString());
    }

    public int getAsInt() {
        return DI() ? Wv().intValue() : Integer.parseInt(getAsString());
    }

    private static boolean cH(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class cls = obj.getClass();
        for (Class isAssignableFrom : bRl) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.value == null) {
            return 31;
        }
        long longValue;
        if (m6215a(this)) {
            longValue = Wv().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.value instanceof Number)) {
            return this.value.hashCode();
        } else {
            longValue = Double.doubleToLongBits(Wv().doubleValue());
            return (int) (longValue ^ (longValue >>> 32));
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        cft com_fossil_cft = (cft) obj;
        if (this.value == null) {
            if (com_fossil_cft.value != null) {
                return false;
            }
            return true;
        } else if (m6215a(this) && m6215a(com_fossil_cft)) {
            if (Wv().longValue() != com_fossil_cft.Wv().longValue()) {
                return false;
            }
            return true;
        } else if (!(this.value instanceof Number) || !(com_fossil_cft.value instanceof Number)) {
            return this.value.equals(com_fossil_cft.value);
        } else {
            double doubleValue = Wv().doubleValue();
            double doubleValue2 = com_fossil_cft.Wv().doubleValue();
            if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                z = true;
            }
            return z;
        }
    }

    private static boolean m6215a(cft com_fossil_cft) {
        if (!(com_fossil_cft.value instanceof Number)) {
            return false;
        }
        Number number = (Number) com_fossil_cft.value;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }
}
