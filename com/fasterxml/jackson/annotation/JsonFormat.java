package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.TimeZone;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonFormat {

    public enum Feature {
        ACCEPT_SINGLE_VALUE_AS_ARRAY,
        WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,
        WRITE_DATES_WITH_ZONE_ID,
        WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED,
        WRITE_SORTED_MAP_ENTRIES
    }

    public enum Shape {
        ANY,
        SCALAR,
        ARRAY,
        OBJECT,
        NUMBER,
        NUMBER_FLOAT,
        NUMBER_INT,
        STRING,
        BOOLEAN;

        public boolean isNumeric() {
            return this == NUMBER || this == NUMBER_INT || this == NUMBER_FLOAT;
        }

        public boolean isStructured() {
            return this == OBJECT || this == ARRAY;
        }
    }

    public static class C1500a {
        private static final C1500a aKX = new C1500a(0, 0);
        private final int aKW;
        private final int enabled;

        private C1500a(int i, int i2) {
            this.enabled = i;
            this.aKW = i2;
        }

        public static C1500a yY() {
            return aKX;
        }

        public static C1500a m2650a(JsonFormat jsonFormat) {
            return C1500a.m2651a(jsonFormat.yW(), jsonFormat.yX());
        }

        public static C1500a m2651a(Feature[] featureArr, Feature[] featureArr2) {
            int i = 0;
            int i2 = 0;
            for (Feature ordinal : featureArr) {
                i2 |= 1 << ordinal.ordinal();
            }
            int i3 = 0;
            while (i < featureArr2.length) {
                i3 |= 1 << featureArr2[i].ordinal();
                i++;
            }
            return new C1500a(i2, i3);
        }

        public Boolean m2652a(Feature feature) {
            int ordinal = 1 << feature.ordinal();
            if ((this.aKW & ordinal) != 0) {
                return Boolean.FALSE;
            }
            if ((ordinal & this.enabled) != 0) {
                return Boolean.TRUE;
            }
            return null;
        }
    }

    public static class C1501b {
        private TimeZone _timezone;
        private final String aKZ;
        private final Shape aLa;
        private final String aLb;
        private final C1500a aLc;
        private final Locale locale;

        public C1501b() {
            this("", Shape.ANY, "", "", C1500a.yY());
        }

        public C1501b(JsonFormat jsonFormat) {
            this(jsonFormat.pattern(), jsonFormat.yT(), jsonFormat.yU(), jsonFormat.yV(), C1500a.m2650a(jsonFormat));
        }

        public C1501b(String str, Shape shape, String str2, String str3, C1500a c1500a) {
            Locale locale = (str2 == null || str2.length() == 0 || "##default".equals(str2)) ? null : new Locale(str2);
            String str4 = (str3 == null || str3.length() == 0 || "##default".equals(str3)) ? null : str3;
            this(str, shape, locale, str4, null, c1500a);
        }

        public C1501b(String str, Shape shape, Locale locale, String str2, TimeZone timeZone, C1500a c1500a) {
            this.aKZ = str;
            if (shape == null) {
                shape = Shape.ANY;
            }
            this.aLa = shape;
            this.locale = locale;
            this._timezone = timeZone;
            this.aLb = str2;
            if (c1500a == null) {
                c1500a = C1500a.yY();
            }
            this.aLc = c1500a;
        }

        public String getPattern() {
            return this.aKZ;
        }

        public Shape yZ() {
            return this.aLa;
        }

        public Locale getLocale() {
            return this.locale;
        }

        public TimeZone getTimeZone() {
            TimeZone timeZone = this._timezone;
            if (timeZone != null) {
                return timeZone;
            }
            if (this.aLb == null) {
                return null;
            }
            timeZone = TimeZone.getTimeZone(this.aLb);
            this._timezone = timeZone;
            return timeZone;
        }

        public boolean za() {
            return this.aKZ != null && this.aKZ.length() > 0;
        }

        public boolean zb() {
            return this.locale != null;
        }

        public Boolean m2653b(Feature feature) {
            return this.aLc.m2652a(feature);
        }
    }

    String pattern() default "";

    Shape yT() default Shape.ANY;

    String yU() default "##default";

    String yV() default "##default";

    Feature[] yW() default {};

    Feature[] yX() default {};
}
