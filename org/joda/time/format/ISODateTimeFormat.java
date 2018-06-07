package org.joda.time.format;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.joda.time.DateTimeFieldType;

public class ISODateTimeFormat {
    protected ISODateTimeFormat() {
    }

    public static DateTimeFormatter forFields(Collection<DateTimeFieldType> collection, boolean z, boolean z2) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException("The fields must not be null or empty");
        }
        boolean dateByMonth;
        boolean z3;
        Set hashSet = new HashSet(collection);
        int size = hashSet.size();
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        if (hashSet.contains(DateTimeFieldType.monthOfYear())) {
            dateByMonth = dateByMonth(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.contains(DateTimeFieldType.dayOfYear())) {
            dateByMonth = dateByOrdinal(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.contains(DateTimeFieldType.weekOfWeekyear())) {
            dateByMonth = dateByWeek(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.contains(DateTimeFieldType.dayOfMonth())) {
            dateByMonth = dateByMonth(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.contains(DateTimeFieldType.dayOfWeek())) {
            dateByMonth = dateByWeek(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.remove(DateTimeFieldType.year())) {
            dateTimeFormatterBuilder.append(Constants.access$000());
            dateByMonth = true;
        } else if (hashSet.remove(DateTimeFieldType.weekyear())) {
            dateTimeFormatterBuilder.append(Constants.access$100());
            dateByMonth = true;
        } else {
            dateByMonth = false;
        }
        if (hashSet.size() < size) {
            z3 = true;
        } else {
            z3 = false;
        }
        time(dateTimeFormatterBuilder, hashSet, z, z2, dateByMonth, z3);
        if (dateTimeFormatterBuilder.canBuildFormatter()) {
            try {
                collection.retainAll(hashSet);
            } catch (UnsupportedOperationException e) {
            }
            return dateTimeFormatterBuilder.toFormatter();
        }
        throw new IllegalArgumentException("No valid format for fields: " + collection);
    }

    private static boolean dateByMonth(DateTimeFormatterBuilder dateTimeFormatterBuilder, Collection<DateTimeFieldType> collection, boolean z, boolean z2) {
        if (collection.remove(DateTimeFieldType.year())) {
            dateTimeFormatterBuilder.append(Constants.access$000());
            if (collection.remove(DateTimeFieldType.monthOfYear())) {
                if (collection.remove(DateTimeFieldType.dayOfMonth())) {
                    appendSeparator(dateTimeFormatterBuilder, z);
                    dateTimeFormatterBuilder.appendMonthOfYear(2);
                    appendSeparator(dateTimeFormatterBuilder, z);
                    dateTimeFormatterBuilder.appendDayOfMonth(2);
                    return false;
                }
                dateTimeFormatterBuilder.appendLiteral('-');
                dateTimeFormatterBuilder.appendMonthOfYear(2);
                return true;
            } else if (!collection.remove(DateTimeFieldType.dayOfMonth())) {
                return true;
            } else {
                checkNotStrictISO(collection, z2);
                dateTimeFormatterBuilder.appendLiteral('-');
                dateTimeFormatterBuilder.appendLiteral('-');
                dateTimeFormatterBuilder.appendDayOfMonth(2);
                return false;
            }
        } else if (collection.remove(DateTimeFieldType.monthOfYear())) {
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendMonthOfYear(2);
            if (!collection.remove(DateTimeFieldType.dayOfMonth())) {
                return true;
            }
            appendSeparator(dateTimeFormatterBuilder, z);
            dateTimeFormatterBuilder.appendDayOfMonth(2);
            return false;
        } else if (!collection.remove(DateTimeFieldType.dayOfMonth())) {
            return false;
        } else {
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendDayOfMonth(2);
            return false;
        }
    }

    private static boolean dateByOrdinal(DateTimeFormatterBuilder dateTimeFormatterBuilder, Collection<DateTimeFieldType> collection, boolean z, boolean z2) {
        if (collection.remove(DateTimeFieldType.year())) {
            dateTimeFormatterBuilder.append(Constants.access$000());
            if (!collection.remove(DateTimeFieldType.dayOfYear())) {
                return true;
            }
            appendSeparator(dateTimeFormatterBuilder, z);
            dateTimeFormatterBuilder.appendDayOfYear(3);
            return false;
        } else if (!collection.remove(DateTimeFieldType.dayOfYear())) {
            return false;
        } else {
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendDayOfYear(3);
            return false;
        }
    }

    private static boolean dateByWeek(DateTimeFormatterBuilder dateTimeFormatterBuilder, Collection<DateTimeFieldType> collection, boolean z, boolean z2) {
        if (collection.remove(DateTimeFieldType.weekyear())) {
            dateTimeFormatterBuilder.append(Constants.access$100());
            if (collection.remove(DateTimeFieldType.weekOfWeekyear())) {
                appendSeparator(dateTimeFormatterBuilder, z);
                dateTimeFormatterBuilder.appendLiteral('W');
                dateTimeFormatterBuilder.appendWeekOfWeekyear(2);
                if (!collection.remove(DateTimeFieldType.dayOfWeek())) {
                    return true;
                }
                appendSeparator(dateTimeFormatterBuilder, z);
                dateTimeFormatterBuilder.appendDayOfWeek(1);
                return false;
            } else if (!collection.remove(DateTimeFieldType.dayOfWeek())) {
                return true;
            } else {
                checkNotStrictISO(collection, z2);
                appendSeparator(dateTimeFormatterBuilder, z);
                dateTimeFormatterBuilder.appendLiteral('W');
                dateTimeFormatterBuilder.appendLiteral('-');
                dateTimeFormatterBuilder.appendDayOfWeek(1);
                return false;
            }
        } else if (collection.remove(DateTimeFieldType.weekOfWeekyear())) {
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendLiteral('W');
            dateTimeFormatterBuilder.appendWeekOfWeekyear(2);
            if (!collection.remove(DateTimeFieldType.dayOfWeek())) {
                return true;
            }
            appendSeparator(dateTimeFormatterBuilder, z);
            dateTimeFormatterBuilder.appendDayOfWeek(1);
            return false;
        } else if (!collection.remove(DateTimeFieldType.dayOfWeek())) {
            return false;
        } else {
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendLiteral('W');
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendDayOfWeek(1);
            return false;
        }
    }

    private static void time(DateTimeFormatterBuilder dateTimeFormatterBuilder, Collection<DateTimeFieldType> collection, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean remove = collection.remove(DateTimeFieldType.hourOfDay());
        boolean remove2 = collection.remove(DateTimeFieldType.minuteOfHour());
        boolean remove3 = collection.remove(DateTimeFieldType.secondOfMinute());
        boolean remove4 = collection.remove(DateTimeFieldType.millisOfSecond());
        if (remove || remove2 || remove3 || remove4) {
            if (remove || remove2 || remove3 || remove4) {
                if (z2 && z3) {
                    throw new IllegalArgumentException("No valid ISO8601 format for fields because Date was reduced precision: " + collection);
                } else if (z4) {
                    dateTimeFormatterBuilder.appendLiteral('T');
                }
            }
            if (!(remove && remove2 && remove3) && (!remove || remove3 || remove4)) {
                if (z2 && z4) {
                    throw new IllegalArgumentException("No valid ISO8601 format for fields because Time was truncated: " + collection);
                } else if ((remove || (!(remove2 && remove3) && ((!remove2 || remove4) && !remove3))) && z2) {
                    throw new IllegalArgumentException("No valid ISO8601 format for fields: " + collection);
                }
            }
            if (remove) {
                dateTimeFormatterBuilder.appendHourOfDay(2);
            } else if (remove2 || remove3 || remove4) {
                dateTimeFormatterBuilder.appendLiteral('-');
            }
            if (z && remove && remove2) {
                dateTimeFormatterBuilder.appendLiteral(':');
            }
            if (remove2) {
                dateTimeFormatterBuilder.appendMinuteOfHour(2);
            } else if (remove3 || remove4) {
                dateTimeFormatterBuilder.appendLiteral('-');
            }
            if (z && remove2 && remove3) {
                dateTimeFormatterBuilder.appendLiteral(':');
            }
            if (remove3) {
                dateTimeFormatterBuilder.appendSecondOfMinute(2);
            } else if (remove4) {
                dateTimeFormatterBuilder.appendLiteral('-');
            }
            if (remove4) {
                dateTimeFormatterBuilder.appendLiteral('.');
                dateTimeFormatterBuilder.appendMillisOfSecond(3);
            }
        }
    }

    private static void checkNotStrictISO(Collection<DateTimeFieldType> collection, boolean z) {
        if (z) {
            throw new IllegalArgumentException("No valid ISO8601 format for fields: " + collection);
        }
    }

    private static void appendSeparator(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z) {
        if (z) {
            dateTimeFormatterBuilder.appendLiteral('-');
        }
    }

    public static DateTimeFormatter dateParser() {
        return Constants.access$200();
    }

    public static DateTimeFormatter localDateParser() {
        return Constants.access$300();
    }

    public static DateTimeFormatter dateElementParser() {
        return Constants.access$400();
    }

    public static DateTimeFormatter timeParser() {
        return Constants.access$500();
    }

    public static DateTimeFormatter localTimeParser() {
        return Constants.access$600();
    }

    public static DateTimeFormatter timeElementParser() {
        return Constants.access$700();
    }

    public static DateTimeFormatter dateTimeParser() {
        return Constants.access$800();
    }

    public static DateTimeFormatter dateOptionalTimeParser() {
        return Constants.access$900();
    }

    public static DateTimeFormatter localDateOptionalTimeParser() {
        return Constants.access$1000();
    }

    public static DateTimeFormatter date() {
        return yearMonthDay();
    }

    public static DateTimeFormatter time() {
        return Constants.access$1100();
    }

    public static DateTimeFormatter timeNoMillis() {
        return Constants.access$1200();
    }

    public static DateTimeFormatter tTime() {
        return Constants.access$1300();
    }

    public static DateTimeFormatter tTimeNoMillis() {
        return Constants.access$1400();
    }

    public static DateTimeFormatter dateTime() {
        return Constants.access$1500();
    }

    public static DateTimeFormatter dateTimeNoMillis() {
        return Constants.access$1600();
    }

    public static DateTimeFormatter ordinalDate() {
        return Constants.access$1700();
    }

    public static DateTimeFormatter ordinalDateTime() {
        return Constants.access$1800();
    }

    public static DateTimeFormatter ordinalDateTimeNoMillis() {
        return Constants.access$1900();
    }

    public static DateTimeFormatter weekDate() {
        return Constants.access$2000();
    }

    public static DateTimeFormatter weekDateTime() {
        return Constants.access$2100();
    }

    public static DateTimeFormatter weekDateTimeNoMillis() {
        return Constants.access$2200();
    }

    public static DateTimeFormatter basicDate() {
        return Constants.access$2300();
    }

    public static DateTimeFormatter basicTime() {
        return Constants.access$2400();
    }

    public static DateTimeFormatter basicTimeNoMillis() {
        return Constants.access$2500();
    }

    public static DateTimeFormatter basicTTime() {
        return Constants.access$2600();
    }

    public static DateTimeFormatter basicTTimeNoMillis() {
        return Constants.access$2700();
    }

    public static DateTimeFormatter basicDateTime() {
        return Constants.access$2800();
    }

    public static DateTimeFormatter basicDateTimeNoMillis() {
        return Constants.access$2900();
    }

    public static DateTimeFormatter basicOrdinalDate() {
        return Constants.access$3000();
    }

    public static DateTimeFormatter basicOrdinalDateTime() {
        return Constants.access$3100();
    }

    public static DateTimeFormatter basicOrdinalDateTimeNoMillis() {
        return Constants.access$3200();
    }

    public static DateTimeFormatter basicWeekDate() {
        return Constants.access$3300();
    }

    public static DateTimeFormatter basicWeekDateTime() {
        return Constants.access$3400();
    }

    public static DateTimeFormatter basicWeekDateTimeNoMillis() {
        return Constants.access$3500();
    }

    public static DateTimeFormatter year() {
        return Constants.access$000();
    }

    public static DateTimeFormatter yearMonth() {
        return Constants.access$3600();
    }

    public static DateTimeFormatter yearMonthDay() {
        return Constants.access$3700();
    }

    public static DateTimeFormatter weekyear() {
        return Constants.access$100();
    }

    public static DateTimeFormatter weekyearWeek() {
        return Constants.access$3800();
    }

    public static DateTimeFormatter weekyearWeekDay() {
        return Constants.access$2000();
    }

    public static DateTimeFormatter hour() {
        return Constants.access$3900();
    }

    public static DateTimeFormatter hourMinute() {
        return Constants.access$4000();
    }

    public static DateTimeFormatter hourMinuteSecond() {
        return Constants.access$4100();
    }

    public static DateTimeFormatter hourMinuteSecondMillis() {
        return Constants.access$4200();
    }

    public static DateTimeFormatter hourMinuteSecondFraction() {
        return Constants.access$4300();
    }

    public static DateTimeFormatter dateHour() {
        return Constants.access$4400();
    }

    public static DateTimeFormatter dateHourMinute() {
        return Constants.access$4500();
    }

    public static DateTimeFormatter dateHourMinuteSecond() {
        return Constants.access$4600();
    }

    public static DateTimeFormatter dateHourMinuteSecondMillis() {
        return Constants.access$4700();
    }

    public static DateTimeFormatter dateHourMinuteSecondFraction() {
        return Constants.access$4800();
    }
}
