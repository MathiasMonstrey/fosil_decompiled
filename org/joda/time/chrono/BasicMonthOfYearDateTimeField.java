package org.joda.time.chrono;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

class BasicMonthOfYearDateTimeField extends ImpreciseDateTimeField {
    private static final int MIN = 1;
    private static final long serialVersionUID = -8258715387168736L;
    private final BasicChronology iChronology;
    private final int iLeapMonth;
    private final int iMax = this.iChronology.getMaxMonth();

    BasicMonthOfYearDateTimeField(BasicChronology basicChronology, int i) {
        super(DateTimeFieldType.monthOfYear(), basicChronology.getAverageMillisPerMonth());
        this.iChronology = basicChronology;
        this.iLeapMonth = i;
    }

    public boolean isLenient() {
        return false;
    }

    public int get(long j) {
        return this.iChronology.getMonthOfYear(j);
    }

    public long add(long j, int i) {
        if (i == 0) {
            return j;
        }
        int i2;
        long millisOfDay = (long) this.iChronology.getMillisOfDay(j);
        int year = this.iChronology.getYear(j);
        int monthOfYear = this.iChronology.getMonthOfYear(j, year);
        int i3 = (monthOfYear - 1) + i;
        if (i3 >= 0) {
            i2 = (i3 / this.iMax) + year;
            i3 = (i3 % this.iMax) + 1;
        } else {
            i2 = ((i3 / this.iMax) + year) - 1;
            i3 = Math.abs(i3) % this.iMax;
            if (i3 == 0) {
                i3 = this.iMax;
            }
            i3 = (this.iMax - i3) + 1;
            if (i3 == 1) {
                i2++;
            }
        }
        monthOfYear = this.iChronology.getDayOfMonth(j, year, monthOfYear);
        year = this.iChronology.getDaysInYearMonth(i2, i3);
        if (monthOfYear <= year) {
            year = monthOfYear;
        }
        return this.iChronology.getYearMonthDayMillis(i2, i3, year) + millisOfDay;
    }

    public long add(long j, long j2) {
        int i = (int) j2;
        if (((long) i) == j2) {
            return add(j, i);
        }
        long j3;
        long millisOfDay = (long) this.iChronology.getMillisOfDay(j);
        int year = this.iChronology.getYear(j);
        int monthOfYear = this.iChronology.getMonthOfYear(j, year);
        long j4 = ((long) (monthOfYear - 1)) + j2;
        if (j4 >= 0) {
            j3 = ((long) year) + (j4 / ((long) this.iMax));
            j4 = (j4 % ((long) this.iMax)) + 1;
        } else {
            j3 = (((long) year) + (j4 / ((long) this.iMax))) - 1;
            i = (int) (Math.abs(j4) % ((long) this.iMax));
            if (i == 0) {
                i = this.iMax;
            }
            j4 = (long) ((this.iMax - i) + 1);
            if (j4 == 1) {
                j3++;
            }
        }
        if (j3 < ((long) this.iChronology.getMinYear()) || j3 > ((long) this.iChronology.getMaxYear())) {
            throw new IllegalArgumentException("Magnitude of add amount is too large: " + j2);
        }
        int i2 = (int) j3;
        int i3 = (int) j4;
        int dayOfMonth = this.iChronology.getDayOfMonth(j, year, monthOfYear);
        i = this.iChronology.getDaysInYearMonth(i2, i3);
        if (dayOfMonth <= i) {
            i = dayOfMonth;
        }
        return this.iChronology.getYearMonthDayMillis(i2, i3, i) + millisOfDay;
    }

    public int[] add(ReadablePartial readablePartial, int i, int[] iArr, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return iArr;
        }
        if (readablePartial.size() > 0 && readablePartial.getFieldType(0).equals(DateTimeFieldType.monthOfYear()) && i == 0) {
            return set(readablePartial, 0, iArr, ((((iArr[0] - 1) + (i2 % 12)) + 12) % 12) + 1);
        }
        if (!DateTimeUtils.isContiguous(readablePartial)) {
            return super.add(readablePartial, i, iArr, i2);
        }
        long j = 0;
        int size = readablePartial.size();
        while (i3 < size) {
            j = readablePartial.getFieldType(i3).getField(this.iChronology).set(j, iArr[i3]);
            i3++;
        }
        return this.iChronology.get(readablePartial, add(j, i2));
    }

    public long addWrapField(long j, int i) {
        return set(j, FieldUtils.getWrappedValue(get(j), i, 1, this.iMax));
    }

    public long getDifferenceAsLong(long j, long j2) {
        if (j < j2) {
            return (long) (-getDifference(j2, j));
        }
        int year = this.iChronology.getYear(j);
        int monthOfYear = this.iChronology.getMonthOfYear(j, year);
        int year2 = this.iChronology.getYear(j2);
        int monthOfYear2 = this.iChronology.getMonthOfYear(j2, year2);
        long j3 = ((((long) (year - year2)) * ((long) this.iMax)) + ((long) monthOfYear)) - ((long) monthOfYear2);
        int dayOfMonth = this.iChronology.getDayOfMonth(j, year, monthOfYear);
        if (dayOfMonth == this.iChronology.getDaysInYearMonth(year, monthOfYear) && this.iChronology.getDayOfMonth(j2, year2, monthOfYear2) > dayOfMonth) {
            j2 = this.iChronology.dayOfMonth().set(j2, dayOfMonth);
        }
        if (j - this.iChronology.getYearMonthMillis(year, monthOfYear) < j2 - this.iChronology.getYearMonthMillis(year2, monthOfYear2)) {
            return j3 - 1;
        }
        return j3;
    }

    public long set(long j, int i) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i, 1, this.iMax);
        int year = this.iChronology.getYear(j);
        int dayOfMonth = this.iChronology.getDayOfMonth(j, year);
        int daysInYearMonth = this.iChronology.getDaysInYearMonth(year, i);
        if (dayOfMonth <= daysInYearMonth) {
            daysInYearMonth = dayOfMonth;
        }
        return this.iChronology.getYearMonthDayMillis(year, i, daysInYearMonth) + ((long) this.iChronology.getMillisOfDay(j));
    }

    public DurationField getRangeDurationField() {
        return this.iChronology.years();
    }

    public boolean isLeap(long j) {
        int year = this.iChronology.getYear(j);
        if (this.iChronology.isLeapYear(year) && this.iChronology.getMonthOfYear(j, year) == this.iLeapMonth) {
            return true;
        }
        return false;
    }

    public int getLeapAmount(long j) {
        return isLeap(j) ? 1 : 0;
    }

    public DurationField getLeapDurationField() {
        return this.iChronology.days();
    }

    public int getMinimumValue() {
        return 1;
    }

    public int getMaximumValue() {
        return this.iMax;
    }

    public long roundFloor(long j) {
        int year = this.iChronology.getYear(j);
        return this.iChronology.getYearMonthMillis(year, this.iChronology.getMonthOfYear(j, year));
    }

    public long remainder(long j) {
        return j - roundFloor(j);
    }

    private Object readResolve() {
        return this.iChronology.monthOfYear();
    }
}
