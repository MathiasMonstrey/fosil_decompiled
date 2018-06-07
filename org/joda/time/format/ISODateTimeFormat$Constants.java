package org.joda.time.format;

import org.joda.time.DateTimeFieldType;

final class ISODateTimeFormat$Constants {
    private static final DateTimeFormatter bd = basicDate();
    private static final DateTimeFormatter bdt = basicDateTime();
    private static final DateTimeFormatter bdtx = basicDateTimeNoMillis();
    private static final DateTimeFormatter bod = basicOrdinalDate();
    private static final DateTimeFormatter bodt = basicOrdinalDateTime();
    private static final DateTimeFormatter bodtx = basicOrdinalDateTimeNoMillis();
    private static final DateTimeFormatter bt = basicTime();
    private static final DateTimeFormatter btt = basicTTime();
    private static final DateTimeFormatter bttx = basicTTimeNoMillis();
    private static final DateTimeFormatter btx = basicTimeNoMillis();
    private static final DateTimeFormatter bwd = basicWeekDate();
    private static final DateTimeFormatter bwdt = basicWeekDateTime();
    private static final DateTimeFormatter bwdtx = basicWeekDateTimeNoMillis();
    private static final DateTimeFormatter dh = dateHour();
    private static final DateTimeFormatter dhm = dateHourMinute();
    private static final DateTimeFormatter dhms = dateHourMinuteSecond();
    private static final DateTimeFormatter dhmsf = dateHourMinuteSecondFraction();
    private static final DateTimeFormatter dhmsl = dateHourMinuteSecondMillis();
    private static final DateTimeFormatter dme = dayOfMonthElement();
    private static final DateTimeFormatter dotp = dateOptionalTimeParser();
    private static final DateTimeFormatter dp = dateParser();
    private static final DateTimeFormatter dpe = dateElementParser();
    private static final DateTimeFormatter dt = dateTime();
    private static final DateTimeFormatter dtp = dateTimeParser();
    private static final DateTimeFormatter dtx = dateTimeNoMillis();
    private static final DateTimeFormatter dwe = dayOfWeekElement();
    private static final DateTimeFormatter dye = dayOfYearElement();
    private static final DateTimeFormatter fse = fractionElement();
    private static final DateTimeFormatter hde = hourElement();
    private static final DateTimeFormatter hm = hourMinute();
    private static final DateTimeFormatter hms = hourMinuteSecond();
    private static final DateTimeFormatter hmsf = hourMinuteSecondFraction();
    private static final DateTimeFormatter hmsl = hourMinuteSecondMillis();
    private static final DateTimeFormatter ldotp = localDateOptionalTimeParser();
    private static final DateTimeFormatter ldp = localDateParser();
    private static final DateTimeFormatter lte = literalTElement();
    private static final DateTimeFormatter ltp = localTimeParser();
    private static final DateTimeFormatter mhe = minuteElement();
    private static final DateTimeFormatter mye = monthElement();
    private static final DateTimeFormatter od = ordinalDate();
    private static final DateTimeFormatter odt = ordinalDateTime();
    private static final DateTimeFormatter odtx = ordinalDateTimeNoMillis();
    private static final DateTimeFormatter sme = secondElement();
    private static final DateTimeFormatter f1655t = time();
    private static final DateTimeFormatter tp = timeParser();
    private static final DateTimeFormatter tpe = timeElementParser();
    private static final DateTimeFormatter tt = tTime();
    private static final DateTimeFormatter ttx = tTimeNoMillis();
    private static final DateTimeFormatter tx = timeNoMillis();
    private static final DateTimeFormatter wdt = weekDateTime();
    private static final DateTimeFormatter wdtx = weekDateTimeNoMillis();
    private static final DateTimeFormatter we = weekyearElement();
    private static final DateTimeFormatter ww = weekyearWeek();
    private static final DateTimeFormatter wwd = weekyearWeekDay();
    private static final DateTimeFormatter wwe = weekElement();
    private static final DateTimeFormatter ye = yearElement();
    private static final DateTimeFormatter ym = yearMonth();
    private static final DateTimeFormatter ymd = yearMonthDay();
    private static final DateTimeFormatter ze = offsetElement();

    ISODateTimeFormat$Constants() {
    }

    private static DateTimeFormatter dateParser() {
        if (dp != null) {
            return dp;
        }
        return new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(new DateTimeFormatterBuilder().appendLiteral('T').append(offsetElement()).toParser()).toFormatter();
    }

    private static DateTimeFormatter localDateParser() {
        if (ldp == null) {
            return dateElementParser().withZoneUTC();
        }
        return ldp;
    }

    private static DateTimeFormatter dateElementParser() {
        if (dpe != null) {
            return dpe;
        }
        return new DateTimeFormatterBuilder().append(null, new DateTimeParser[]{new DateTimeFormatterBuilder().append(yearElement()).appendOptional(new DateTimeFormatterBuilder().append(monthElement()).appendOptional(dayOfMonthElement().getParser()).toParser()).toParser(), new DateTimeFormatterBuilder().append(weekyearElement()).append(weekElement()).appendOptional(dayOfWeekElement().getParser()).toParser(), new DateTimeFormatterBuilder().append(yearElement()).append(dayOfYearElement()).toParser()}).toFormatter();
    }

    private static DateTimeFormatter timeParser() {
        if (tp == null) {
            return new DateTimeFormatterBuilder().appendOptional(literalTElement().getParser()).append(timeElementParser()).appendOptional(offsetElement().getParser()).toFormatter();
        }
        return tp;
    }

    private static DateTimeFormatter localTimeParser() {
        if (ltp == null) {
            return new DateTimeFormatterBuilder().appendOptional(literalTElement().getParser()).append(timeElementParser()).toFormatter().withZoneUTC();
        }
        return ltp;
    }

    private static DateTimeFormatter timeElementParser() {
        if (tpe != null) {
            return tpe;
        }
        DateTimeParser toParser = new DateTimeFormatterBuilder().append(null, new DateTimeParser[]{new DateTimeFormatterBuilder().appendLiteral('.').toParser(), new DateTimeFormatterBuilder().appendLiteral(',').toParser()}).toParser();
        DateTimeFormatterBuilder append = new DateTimeFormatterBuilder().append(hourElement());
        r2 = new DateTimeParser[3];
        r2[0] = new DateTimeFormatterBuilder().append(minuteElement()).append(null, new DateTimeParser[]{new DateTimeFormatterBuilder().append(secondElement()).appendOptional(new DateTimeFormatterBuilder().append(toParser).appendFractionOfSecond(1, 9).toParser()).toParser(), new DateTimeFormatterBuilder().append(toParser).appendFractionOfMinute(1, 9).toParser(), null}).toParser();
        r2[1] = new DateTimeFormatterBuilder().append(toParser).appendFractionOfHour(1, 9).toParser();
        r2[2] = null;
        return append.append(null, r2).toFormatter();
    }

    private static DateTimeFormatter dateTimeParser() {
        if (dtp != null) {
            return dtp;
        }
        DateTimeParser toParser = new DateTimeFormatterBuilder().appendLiteral('T').append(timeElementParser()).appendOptional(offsetElement().getParser()).toParser();
        return new DateTimeFormatterBuilder().append(null, new DateTimeParser[]{toParser, dateOptionalTimeParser().getParser()}).toFormatter();
    }

    private static DateTimeFormatter dateOptionalTimeParser() {
        if (dotp != null) {
            return dotp;
        }
        return new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(new DateTimeFormatterBuilder().appendLiteral('T').appendOptional(timeElementParser().getParser()).appendOptional(offsetElement().getParser()).toParser()).toFormatter();
    }

    private static DateTimeFormatter localDateOptionalTimeParser() {
        if (ldotp != null) {
            return ldotp;
        }
        return new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(new DateTimeFormatterBuilder().appendLiteral('T').append(timeElementParser()).toParser()).toFormatter().withZoneUTC();
    }

    private static DateTimeFormatter time() {
        if (f1655t == null) {
            return new DateTimeFormatterBuilder().append(hourMinuteSecondFraction()).append(offsetElement()).toFormatter();
        }
        return f1655t;
    }

    private static DateTimeFormatter timeNoMillis() {
        if (tx == null) {
            return new DateTimeFormatterBuilder().append(hourMinuteSecond()).append(offsetElement()).toFormatter();
        }
        return tx;
    }

    private static DateTimeFormatter tTime() {
        if (tt == null) {
            return new DateTimeFormatterBuilder().append(literalTElement()).append(time()).toFormatter();
        }
        return tt;
    }

    private static DateTimeFormatter tTimeNoMillis() {
        if (ttx == null) {
            return new DateTimeFormatterBuilder().append(literalTElement()).append(timeNoMillis()).toFormatter();
        }
        return ttx;
    }

    private static DateTimeFormatter dateTime() {
        if (dt == null) {
            return new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(tTime()).toFormatter();
        }
        return dt;
    }

    private static DateTimeFormatter dateTimeNoMillis() {
        if (dtx == null) {
            return new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(tTimeNoMillis()).toFormatter();
        }
        return dtx;
    }

    private static DateTimeFormatter ordinalDate() {
        if (od == null) {
            return new DateTimeFormatterBuilder().append(yearElement()).append(dayOfYearElement()).toFormatter();
        }
        return od;
    }

    private static DateTimeFormatter ordinalDateTime() {
        if (odt == null) {
            return new DateTimeFormatterBuilder().append(ordinalDate()).append(tTime()).toFormatter();
        }
        return odt;
    }

    private static DateTimeFormatter ordinalDateTimeNoMillis() {
        if (odtx == null) {
            return new DateTimeFormatterBuilder().append(ordinalDate()).append(tTimeNoMillis()).toFormatter();
        }
        return odtx;
    }

    private static DateTimeFormatter weekDateTime() {
        if (wdt == null) {
            return new DateTimeFormatterBuilder().append(ISODateTimeFormat.weekDate()).append(tTime()).toFormatter();
        }
        return wdt;
    }

    private static DateTimeFormatter weekDateTimeNoMillis() {
        if (wdtx == null) {
            return new DateTimeFormatterBuilder().append(ISODateTimeFormat.weekDate()).append(tTimeNoMillis()).toFormatter();
        }
        return wdtx;
    }

    private static DateTimeFormatter basicDate() {
        if (bd == null) {
            return new DateTimeFormatterBuilder().appendYear(4, 4).appendFixedDecimal(DateTimeFieldType.monthOfYear(), 2).appendFixedDecimal(DateTimeFieldType.dayOfMonth(), 2).toFormatter();
        }
        return bd;
    }

    private static DateTimeFormatter basicTime() {
        if (bt == null) {
            return new DateTimeFormatterBuilder().appendFixedDecimal(DateTimeFieldType.hourOfDay(), 2).appendFixedDecimal(DateTimeFieldType.minuteOfHour(), 2).appendFixedDecimal(DateTimeFieldType.secondOfMinute(), 2).appendLiteral('.').appendFractionOfSecond(3, 9).appendTimeZoneOffset("Z", false, 2, 2).toFormatter();
        }
        return bt;
    }

    private static DateTimeFormatter basicTimeNoMillis() {
        if (btx == null) {
            return new DateTimeFormatterBuilder().appendFixedDecimal(DateTimeFieldType.hourOfDay(), 2).appendFixedDecimal(DateTimeFieldType.minuteOfHour(), 2).appendFixedDecimal(DateTimeFieldType.secondOfMinute(), 2).appendTimeZoneOffset("Z", false, 2, 2).toFormatter();
        }
        return btx;
    }

    private static DateTimeFormatter basicTTime() {
        if (btt == null) {
            return new DateTimeFormatterBuilder().append(literalTElement()).append(basicTime()).toFormatter();
        }
        return btt;
    }

    private static DateTimeFormatter basicTTimeNoMillis() {
        if (bttx == null) {
            return new DateTimeFormatterBuilder().append(literalTElement()).append(basicTimeNoMillis()).toFormatter();
        }
        return bttx;
    }

    private static DateTimeFormatter basicDateTime() {
        if (bdt == null) {
            return new DateTimeFormatterBuilder().append(basicDate()).append(basicTTime()).toFormatter();
        }
        return bdt;
    }

    private static DateTimeFormatter basicDateTimeNoMillis() {
        if (bdtx == null) {
            return new DateTimeFormatterBuilder().append(basicDate()).append(basicTTimeNoMillis()).toFormatter();
        }
        return bdtx;
    }

    private static DateTimeFormatter basicOrdinalDate() {
        if (bod == null) {
            return new DateTimeFormatterBuilder().appendYear(4, 4).appendFixedDecimal(DateTimeFieldType.dayOfYear(), 3).toFormatter();
        }
        return bod;
    }

    private static DateTimeFormatter basicOrdinalDateTime() {
        if (bodt == null) {
            return new DateTimeFormatterBuilder().append(basicOrdinalDate()).append(basicTTime()).toFormatter();
        }
        return bodt;
    }

    private static DateTimeFormatter basicOrdinalDateTimeNoMillis() {
        if (bodtx == null) {
            return new DateTimeFormatterBuilder().append(basicOrdinalDate()).append(basicTTimeNoMillis()).toFormatter();
        }
        return bodtx;
    }

    private static DateTimeFormatter basicWeekDate() {
        if (bwd == null) {
            return new DateTimeFormatterBuilder().appendWeekyear(4, 4).appendLiteral('W').appendFixedDecimal(DateTimeFieldType.weekOfWeekyear(), 2).appendFixedDecimal(DateTimeFieldType.dayOfWeek(), 1).toFormatter();
        }
        return bwd;
    }

    private static DateTimeFormatter basicWeekDateTime() {
        if (bwdt == null) {
            return new DateTimeFormatterBuilder().append(basicWeekDate()).append(basicTTime()).toFormatter();
        }
        return bwdt;
    }

    private static DateTimeFormatter basicWeekDateTimeNoMillis() {
        if (bwdtx == null) {
            return new DateTimeFormatterBuilder().append(basicWeekDate()).append(basicTTimeNoMillis()).toFormatter();
        }
        return bwdtx;
    }

    private static DateTimeFormatter yearMonth() {
        if (ym == null) {
            return new DateTimeFormatterBuilder().append(yearElement()).append(monthElement()).toFormatter();
        }
        return ym;
    }

    private static DateTimeFormatter yearMonthDay() {
        if (ymd == null) {
            return new DateTimeFormatterBuilder().append(yearElement()).append(monthElement()).append(dayOfMonthElement()).toFormatter();
        }
        return ymd;
    }

    private static DateTimeFormatter weekyearWeek() {
        if (ww == null) {
            return new DateTimeFormatterBuilder().append(weekyearElement()).append(weekElement()).toFormatter();
        }
        return ww;
    }

    private static DateTimeFormatter weekyearWeekDay() {
        if (wwd == null) {
            return new DateTimeFormatterBuilder().append(weekyearElement()).append(weekElement()).append(dayOfWeekElement()).toFormatter();
        }
        return wwd;
    }

    private static DateTimeFormatter hourMinute() {
        if (hm == null) {
            return new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).toFormatter();
        }
        return hm;
    }

    private static DateTimeFormatter hourMinuteSecond() {
        if (hms == null) {
            return new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).append(secondElement()).toFormatter();
        }
        return hms;
    }

    private static DateTimeFormatter hourMinuteSecondMillis() {
        if (hmsl == null) {
            return new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).append(secondElement()).appendLiteral('.').appendFractionOfSecond(3, 3).toFormatter();
        }
        return hmsl;
    }

    private static DateTimeFormatter hourMinuteSecondFraction() {
        if (hmsf == null) {
            return new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).append(secondElement()).append(fractionElement()).toFormatter();
        }
        return hmsf;
    }

    private static DateTimeFormatter dateHour() {
        if (dh == null) {
            return new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(literalTElement()).append(ISODateTimeFormat.hour()).toFormatter();
        }
        return dh;
    }

    private static DateTimeFormatter dateHourMinute() {
        if (dhm == null) {
            return new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(literalTElement()).append(hourMinute()).toFormatter();
        }
        return dhm;
    }

    private static DateTimeFormatter dateHourMinuteSecond() {
        if (dhms == null) {
            return new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(literalTElement()).append(hourMinuteSecond()).toFormatter();
        }
        return dhms;
    }

    private static DateTimeFormatter dateHourMinuteSecondMillis() {
        if (dhmsl == null) {
            return new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(literalTElement()).append(hourMinuteSecondMillis()).toFormatter();
        }
        return dhmsl;
    }

    private static DateTimeFormatter dateHourMinuteSecondFraction() {
        if (dhmsf == null) {
            return new DateTimeFormatterBuilder().append(ISODateTimeFormat.date()).append(literalTElement()).append(hourMinuteSecondFraction()).toFormatter();
        }
        return dhmsf;
    }

    private static DateTimeFormatter yearElement() {
        if (ye == null) {
            return new DateTimeFormatterBuilder().appendYear(4, 9).toFormatter();
        }
        return ye;
    }

    private static DateTimeFormatter monthElement() {
        if (mye == null) {
            return new DateTimeFormatterBuilder().appendLiteral('-').appendMonthOfYear(2).toFormatter();
        }
        return mye;
    }

    private static DateTimeFormatter dayOfMonthElement() {
        if (dme == null) {
            return new DateTimeFormatterBuilder().appendLiteral('-').appendDayOfMonth(2).toFormatter();
        }
        return dme;
    }

    private static DateTimeFormatter weekyearElement() {
        if (we == null) {
            return new DateTimeFormatterBuilder().appendWeekyear(4, 9).toFormatter();
        }
        return we;
    }

    private static DateTimeFormatter weekElement() {
        if (wwe == null) {
            return new DateTimeFormatterBuilder().appendLiteral("-W").appendWeekOfWeekyear(2).toFormatter();
        }
        return wwe;
    }

    private static DateTimeFormatter dayOfWeekElement() {
        if (dwe == null) {
            return new DateTimeFormatterBuilder().appendLiteral('-').appendDayOfWeek(1).toFormatter();
        }
        return dwe;
    }

    private static DateTimeFormatter dayOfYearElement() {
        if (dye == null) {
            return new DateTimeFormatterBuilder().appendLiteral('-').appendDayOfYear(3).toFormatter();
        }
        return dye;
    }

    private static DateTimeFormatter literalTElement() {
        if (lte == null) {
            return new DateTimeFormatterBuilder().appendLiteral('T').toFormatter();
        }
        return lte;
    }

    private static DateTimeFormatter hourElement() {
        if (hde == null) {
            return new DateTimeFormatterBuilder().appendHourOfDay(2).toFormatter();
        }
        return hde;
    }

    private static DateTimeFormatter minuteElement() {
        if (mhe == null) {
            return new DateTimeFormatterBuilder().appendLiteral(':').appendMinuteOfHour(2).toFormatter();
        }
        return mhe;
    }

    private static DateTimeFormatter secondElement() {
        if (sme == null) {
            return new DateTimeFormatterBuilder().appendLiteral(':').appendSecondOfMinute(2).toFormatter();
        }
        return sme;
    }

    private static DateTimeFormatter fractionElement() {
        if (fse == null) {
            return new DateTimeFormatterBuilder().appendLiteral('.').appendFractionOfSecond(3, 9).toFormatter();
        }
        return fse;
    }

    private static DateTimeFormatter offsetElement() {
        if (ze == null) {
            return new DateTimeFormatterBuilder().appendTimeZoneOffset("Z", true, 2, 4).toFormatter();
        }
        return ze;
    }
}
