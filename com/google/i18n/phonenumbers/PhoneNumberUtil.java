package com.google.i18n.phonenumbers;

import com.facebook.appevents.AppEventsConstants;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.cgy;
import com.fossil.cgz;
import com.fossil.chb;
import com.fossil.chc;
import com.fossil.chd;
import com.fossil.chf.a;
import com.fossil.chf.b;
import com.fossil.chf.d;
import com.google.i18n.phonenumbers.NumberParseException.ErrorType;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil {
    static final cgz bUA = new C44061();
    private static final Map<Integer, String> bUB;
    private static final Set<Integer> bUC;
    private static final Map<Character, Character> bUD;
    private static final Map<Character, Character> bUE;
    private static final Map<Character, Character> bUF;
    private static final Map<Character, Character> bUG;
    private static final Pattern bUH = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
    private static final String bUI;
    static final Pattern bUJ = Pattern.compile("[+＋]+");
    private static final Pattern bUK = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]+");
    private static final Pattern bUL = Pattern.compile("(\\p{Nd})");
    private static final Pattern bUM = Pattern.compile("[+＋\\p{Nd}]");
    static final Pattern bUN = Pattern.compile("[\\\\/] *x");
    static final Pattern bUO = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
    private static final Pattern bUP = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    private static final String bUQ;
    private static final String bUR;
    static final String bUS;
    private static final Pattern bUT;
    private static final Pattern bUU;
    static final Pattern bUV = Pattern.compile("(\\D+)");
    private static final Pattern bUW = Pattern.compile("(\\$\\d)");
    private static final Pattern bUX = Pattern.compile("\\$NP");
    private static final Pattern bUY = Pattern.compile("\\$FG");
    private static final Pattern bUZ = Pattern.compile("\\$CC");
    private static final Pattern bVa = Pattern.compile("\\(?\\$1\\)?");
    private static PhoneNumberUtil bVb = null;
    private static final Logger logger = Logger.getLogger(PhoneNumberUtil.class.getName());
    private final chb bVc;
    private final Map<Integer, List<String>> bVd;
    private final Set<String> bVe = new HashSet(35);
    private final chd bVf = new chd(100);
    private final Set<String> bVg = new HashSet(320);
    private final Set<Integer> bVh = new HashSet();

    static class C44061 implements cgz {
        C44061() {
        }

        public InputStream fz(String str) {
            return PhoneNumberUtil.class.getResourceAsStream(str);
        }
    }

    static /* synthetic */ class C44072 {
        static final /* synthetic */ int[] bVi = new int[CountryCodeSource.values().length];
        static final /* synthetic */ int[] bVk = new int[PhoneNumberType.values().length];

        static {
            try {
                bVk[PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                bVk[PhoneNumberType.TOLL_FREE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                bVk[PhoneNumberType.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                bVk[PhoneNumberType.FIXED_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                bVk[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                bVk[PhoneNumberType.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                bVk[PhoneNumberType.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                bVk[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                bVk[PhoneNumberType.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                bVk[PhoneNumberType.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                bVk[PhoneNumberType.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            bVj = new int[PhoneNumberFormat.values().length];
            try {
                bVj[PhoneNumberFormat.E164.ordinal()] = 1;
            } catch (NoSuchFieldError e12) {
            }
            try {
                bVj[PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError e13) {
            }
            try {
                bVj[PhoneNumberFormat.RFC3966.ordinal()] = 3;
            } catch (NoSuchFieldError e14) {
            }
            try {
                bVj[PhoneNumberFormat.NATIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError e15) {
            }
            try {
                bVi[CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError e16) {
            }
            try {
                bVi[CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
            } catch (NoSuchFieldError e17) {
            }
            try {
                bVi[CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError e18) {
            }
            try {
                bVi[CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
            } catch (NoSuchFieldError e19) {
            }
        }
    }

    public enum PhoneNumberFormat {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    public enum PhoneNumberType {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    public enum ValidationResult {
        IS_POSSIBLE,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        TOO_LONG
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put(Integer.valueOf(52), AppEventsConstants.EVENT_PARAM_VALUE_YES);
        hashMap.put(Integer.valueOf(54), "9");
        bUB = Collections.unmodifiableMap(hashMap);
        Set hashSet = new HashSet();
        hashSet.add(Integer.valueOf(52));
        hashSet.add(Integer.valueOf(54));
        hashSet.add(Integer.valueOf(55));
        bUC = Collections.unmodifiableSet(hashSet);
        Map hashMap2 = new HashMap();
        hashMap2.put(Character.valueOf('0'), Character.valueOf('0'));
        hashMap2.put(Character.valueOf('1'), Character.valueOf('1'));
        hashMap2.put(Character.valueOf('2'), Character.valueOf('2'));
        hashMap2.put(Character.valueOf('3'), Character.valueOf('3'));
        hashMap2.put(Character.valueOf('4'), Character.valueOf('4'));
        hashMap2.put(Character.valueOf('5'), Character.valueOf('5'));
        hashMap2.put(Character.valueOf('6'), Character.valueOf('6'));
        hashMap2.put(Character.valueOf('7'), Character.valueOf('7'));
        hashMap2.put(Character.valueOf('8'), Character.valueOf('8'));
        hashMap2.put(Character.valueOf('9'), Character.valueOf('9'));
        hashMap = new HashMap(40);
        hashMap.put(Character.valueOf('A'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('B'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('C'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('D'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('E'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('F'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('G'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('H'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('I'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('J'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('K'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('L'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('M'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('N'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('O'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('P'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('Q'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('R'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('S'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('T'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('U'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('V'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('W'), Character.valueOf('9'));
        hashMap.put(Character.valueOf('X'), Character.valueOf('9'));
        hashMap.put(Character.valueOf('Y'), Character.valueOf('9'));
        hashMap.put(Character.valueOf('Z'), Character.valueOf('9'));
        bUE = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap(100);
        hashMap.putAll(bUE);
        hashMap.putAll(hashMap2);
        bUF = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.putAll(hashMap2);
        hashMap.put(Character.valueOf('+'), Character.valueOf('+'));
        hashMap.put(Character.valueOf('*'), Character.valueOf('*'));
        bUD = Collections.unmodifiableMap(hashMap);
        Map hashMap3 = new HashMap();
        for (Character charValue : bUE.keySet()) {
            char charValue2 = charValue.charValue();
            hashMap3.put(Character.valueOf(Character.toLowerCase(charValue2)), Character.valueOf(charValue2));
            hashMap3.put(Character.valueOf(charValue2), Character.valueOf(charValue2));
        }
        hashMap3.putAll(hashMap2);
        hashMap3.put(Character.valueOf('-'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('－'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('‐'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('‑'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('‒'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('–'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('—'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('―'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('−'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('/'), Character.valueOf('/'));
        hashMap3.put(Character.valueOf('／'), Character.valueOf('/'));
        hashMap3.put(Character.valueOf(' '), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('　'), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('⁠'), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('.'), Character.valueOf('.'));
        hashMap3.put(Character.valueOf('．'), Character.valueOf('.'));
        bUG = Collections.unmodifiableMap(hashMap3);
        String valueOf = String.valueOf(Arrays.toString(bUE.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        String valueOf2 = String.valueOf(Arrays.toString(bUE.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        if (valueOf2.length() != 0) {
            valueOf2 = valueOf.concat(valueOf2);
        } else {
            valueOf2 = new String(valueOf);
        }
        bUI = valueOf2;
        valueOf2 = String.valueOf(String.valueOf("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*"));
        valueOf = String.valueOf(String.valueOf(bUI));
        String valueOf3 = String.valueOf(String.valueOf("\\p{Nd}"));
        bUQ = new StringBuilder(((valueOf2.length() + 2) + valueOf.length()) + valueOf3.length()).append(valueOf2).append(valueOf).append(valueOf3).append("]*").toString();
        valueOf = "xｘ#＃~～";
        valueOf3 = ",";
        valueOf2 = String.valueOf(valueOf);
        bUR = fB(valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3));
        bUS = fB(valueOf);
        valueOf2 = String.valueOf(String.valueOf(bUR));
        bUT = Pattern.compile(new StringBuilder(valueOf2.length() + 5).append("(?:").append(valueOf2).append(")$").toString(), 66);
        valueOf2 = String.valueOf(String.valueOf(bUQ));
        valueOf = String.valueOf(String.valueOf(bUR));
        bUU = Pattern.compile(new StringBuilder((valueOf2.length() + 5) + valueOf.length()).append(valueOf2).append("(?:").append(valueOf).append(")?").toString(), 66);
    }

    private static String fB(String str) {
        String valueOf = String.valueOf(String.valueOf(";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|["));
        String valueOf2 = String.valueOf(String.valueOf(str));
        String valueOf3 = String.valueOf(String.valueOf("(\\p{Nd}{1,7})"));
        String valueOf4 = String.valueOf(String.valueOf("\\p{Nd}"));
        return new StringBuilder((((valueOf.length() + 48) + valueOf2.length()) + valueOf3.length()) + valueOf4.length()).append(valueOf).append(valueOf2).append("]|int|anexo|ｉｎｔ)").append("[:\\.．]?[  \\t,-]*").append(valueOf3).append("#?|").append("[- ]+(").append(valueOf4).append("{1,5})#").toString();
    }

    PhoneNumberUtil(chb com_fossil_chb, Map<Integer, List<String>> map) {
        this.bVc = com_fossil_chb;
        this.bVd = map;
        for (Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            if (list.size() == 1 && "001".equals(list.get(0))) {
                this.bVh.add(entry.getKey());
            } else {
                this.bVg.addAll(list);
            }
        }
        if (this.bVg.remove("001")) {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.bVe.addAll((Collection) map.get(Integer.valueOf(1)));
    }

    static String fC(String str) {
        Matcher matcher = bUM.matcher(str);
        if (!matcher.find()) {
            return "";
        }
        String substring = str.substring(matcher.start());
        Matcher matcher2 = bUO.matcher(substring);
        if (matcher2.find()) {
            String substring2 = substring.substring(0, matcher2.start());
            Logger logger = logger;
            Level level = Level.FINER;
            String str2 = "Stripped trailing characters: ";
            substring = String.valueOf(substring2);
            logger.log(level, substring.length() != 0 ? str2.concat(substring) : new String(str2));
            substring = substring2;
        }
        matcher2 = bUN.matcher(substring);
        if (matcher2.find()) {
            return substring.substring(0, matcher2.start());
        }
        return substring;
    }

    static boolean fD(String str) {
        if (str.length() < 2) {
            return false;
        }
        return bUU.matcher(str).matches();
    }

    static String fE(String str) {
        if (bUP.matcher(str).matches()) {
            return m14657c(str, bUF, true);
        }
        return fF(str);
    }

    static void m14658c(StringBuilder stringBuilder) {
        stringBuilder.replace(0, stringBuilder.length(), fE(stringBuilder.toString()));
    }

    public static String fF(String str) {
        return m14659n(str, false).toString();
    }

    static StringBuilder m14659n(String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            int digit = Character.digit(c, 10);
            if (digit != -1) {
                stringBuilder.append(digit);
            } else if (z) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder;
    }

    private static String m14657c(String str, Map<Character, Character> map, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            Character ch = (Character) map.get(Character.valueOf(Character.toUpperCase(charAt)));
            if (ch != null) {
                stringBuilder.append(ch);
            } else if (!z) {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }

    static synchronized void m14650a(PhoneNumberUtil phoneNumberUtil) {
        synchronized (PhoneNumberUtil.class) {
            bVb = phoneNumberUtil;
        }
    }

    public static synchronized PhoneNumberUtil Xx() {
        PhoneNumberUtil phoneNumberUtil;
        synchronized (PhoneNumberUtil.class) {
            if (bVb == null) {
                m14650a(m14644a(bUA));
            }
            phoneNumberUtil = bVb;
        }
        return phoneNumberUtil;
    }

    public static PhoneNumberUtil m14645a(chb com_fossil_chb) {
        if (com_fossil_chb != null) {
            return new PhoneNumberUtil(com_fossil_chb, cgy.Xw());
        }
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    public static PhoneNumberUtil m14644a(cgz com_fossil_cgz) {
        if (com_fossil_cgz != null) {
            return m14645a(new chc(com_fossil_cgz));
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    private boolean fG(String str) {
        return str != null && this.bVg.contains(str);
    }

    private boolean iW(int i) {
        return this.bVd.containsKey(Integer.valueOf(i));
    }

    public String m14665a(PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat) {
        if (phoneNumber.getNationalNumber() == 0 && phoneNumber.hasRawInput()) {
            String rawInput = phoneNumber.getRawInput();
            if (rawInput.length() > 0) {
                return rawInput;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(20);
        m14666a(phoneNumber, phoneNumberFormat, stringBuilder);
        return stringBuilder.toString();
    }

    public void m14666a(PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        stringBuilder.setLength(0);
        int countryCode = phoneNumber.getCountryCode();
        String a = m14664a(phoneNumber);
        if (phoneNumberFormat == PhoneNumberFormat.E164) {
            stringBuilder.append(a);
            m14649a(countryCode, PhoneNumberFormat.E164, stringBuilder);
        } else if (iW(countryCode)) {
            b q = m14660q(countryCode, iX(countryCode));
            stringBuilder.append(m14647a(a, q, phoneNumberFormat));
            m14651a(phoneNumber, q, phoneNumberFormat, stringBuilder);
            m14649a(countryCode, phoneNumberFormat, stringBuilder);
        } else {
            stringBuilder.append(a);
        }
    }

    private b m14660q(int i, String str) {
        return "001".equals(str) ? iV(i) : fA(str);
    }

    public String m14664a(PhoneNumber phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        if (phoneNumber.isItalianLeadingZero()) {
            char[] cArr = new char[phoneNumber.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            stringBuilder.append(new String(cArr));
        }
        stringBuilder.append(phoneNumber.getNationalNumber());
        return stringBuilder.toString();
    }

    private void m14649a(int i, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        switch (phoneNumberFormat) {
            case E164:
                stringBuilder.insert(0, i).insert(0, '+');
                return;
            case INTERNATIONAL:
                stringBuilder.insert(0, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).insert(0, i).insert(0, '+');
                return;
            case RFC3966:
                stringBuilder.insert(0, "-").insert(0, i).insert(0, '+').insert(0, "tel:");
                return;
            default:
                return;
        }
    }

    private String m14647a(String str, b bVar, PhoneNumberFormat phoneNumberFormat) {
        return m14648a(str, bVar, phoneNumberFormat, null);
    }

    private String m14648a(String str, b bVar, PhoneNumberFormat phoneNumberFormat, String str2) {
        a[] aVarArr = (bVar.bVV.length == 0 || phoneNumberFormat == PhoneNumberFormat.NATIONAL) ? bVar.bVU : bVar.bVV;
        a a = m14663a(aVarArr, str);
        if (a == null) {
            return str;
        }
        return m14646a(str, a, phoneNumberFormat, str2);
    }

    a m14663a(a[] aVarArr, String str) {
        for (a aVar : aVarArr) {
            int length = aVar.bVr.length;
            if ((length == 0 || this.bVf.fH(aVar.bVr[length - 1]).matcher(str).lookingAt()) && this.bVf.fH(aVar.aKZ).matcher(str).matches()) {
                return aVar;
            }
        }
        return null;
    }

    private String m14646a(String str, a aVar, PhoneNumberFormat phoneNumberFormat, String str2) {
        CharSequence replaceAll;
        Object obj = aVar.format;
        Matcher matcher = this.bVf.fH(aVar.aKZ).matcher(str);
        String str3 = "";
        if (phoneNumberFormat != PhoneNumberFormat.NATIONAL || str2 == null || str2.length() <= 0 || aVar.bVu.length() <= 0) {
            str3 = aVar.bVs;
            if (phoneNumberFormat != PhoneNumberFormat.NATIONAL || str3 == null || str3.length() <= 0) {
                replaceAll = matcher.replaceAll(obj);
            } else {
                replaceAll = matcher.replaceAll(bUW.matcher(obj).replaceFirst(str3));
            }
        } else {
            replaceAll = matcher.replaceAll(bUW.matcher(obj).replaceFirst(bUZ.matcher(aVar.bVu).replaceFirst(str2)));
        }
        if (phoneNumberFormat != PhoneNumberFormat.RFC3966) {
            return replaceAll;
        }
        matcher = bUK.matcher(replaceAll);
        if (matcher.lookingAt()) {
            replaceAll = matcher.replaceFirst("");
        }
        return matcher.reset(replaceAll).replaceAll("-");
    }

    private void m14651a(PhoneNumber phoneNumber, b bVar, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        if (phoneNumber.hasExtension() && phoneNumber.getExtension().length() > 0) {
            if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
                stringBuilder.append(";ext=").append(phoneNumber.getExtension());
            } else if (bVar.bVQ.equals("")) {
                stringBuilder.append(" ext. ").append(phoneNumber.getExtension());
            } else {
                stringBuilder.append(bVar.bVQ).append(phoneNumber.getExtension());
            }
        }
    }

    b fA(String str) {
        if (fG(str)) {
            return this.bVc.fA(str);
        }
        return null;
    }

    b iV(int i) {
        if (this.bVd.containsKey(Integer.valueOf(i))) {
            return this.bVc.iV(i);
        }
        return null;
    }

    public String iX(int i) {
        List list = (List) this.bVd.get(Integer.valueOf(i));
        return list == null ? "ZZ" : (String) list.get(0);
    }

    private ValidationResult m14643a(Pattern pattern, String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (matcher.lookingAt()) {
            return ValidationResult.TOO_LONG;
        }
        return ValidationResult.TOO_SHORT;
    }

    private boolean m14655a(b bVar, String str) {
        return m14643a(this.bVf.fH(bVar.bVw.bWc), str) == ValidationResult.TOO_SHORT;
    }

    int m14662a(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        if (stringBuilder.length() == 0 || stringBuilder.charAt(0) == '0') {
            return 0;
        }
        int length = stringBuilder.length();
        int i = 1;
        while (i <= 3 && i <= length) {
            int parseInt = Integer.parseInt(stringBuilder.substring(0, i));
            if (this.bVd.containsKey(Integer.valueOf(parseInt))) {
                stringBuilder2.append(stringBuilder.substring(i));
                return parseInt;
            }
            i++;
        }
        return 0;
    }

    int m14661a(String str, b bVar, StringBuilder stringBuilder, boolean z, PhoneNumber phoneNumber) throws NumberParseException {
        if (str.length() == 0) {
            return 0;
        }
        StringBuilder stringBuilder2 = new StringBuilder(str);
        String str2 = "NonMatch";
        if (bVar != null) {
            str2 = bVar.bVN;
        }
        CountryCodeSource b = m14669b(stringBuilder2, str2);
        if (z) {
            phoneNumber.setCountryCodeSource(b);
        }
        int i;
        if (b == CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (bVar != null) {
                i = bVar.bVM;
                String valueOf = String.valueOf(i);
                String stringBuilder3 = stringBuilder2.toString();
                if (stringBuilder3.startsWith(valueOf)) {
                    StringBuilder stringBuilder4 = new StringBuilder(stringBuilder3.substring(valueOf.length()));
                    d dVar = bVar.bVw;
                    Pattern fH = this.bVf.fH(dVar.bWb);
                    m14668a(stringBuilder4, bVar, null);
                    Pattern fH2 = this.bVf.fH(dVar.bWc);
                    if ((!fH.matcher(stringBuilder2).matches() && fH.matcher(stringBuilder4).matches()) || m14643a(fH2, stringBuilder2.toString()) == ValidationResult.TOO_LONG) {
                        stringBuilder.append(stringBuilder4);
                        if (z) {
                            phoneNumber.setCountryCodeSource(CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                        }
                        phoneNumber.setCountryCode(i);
                        return i;
                    }
                }
            }
            phoneNumber.setCountryCode(0);
            return 0;
        } else if (stringBuilder2.length() <= 2) {
            throw new NumberParseException(ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        } else {
            i = m14662a(stringBuilder2, stringBuilder);
            if (i != 0) {
                phoneNumber.setCountryCode(i);
                return i;
            }
            throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        }
    }

    private boolean m14656a(Pattern pattern, StringBuilder stringBuilder) {
        Matcher matcher = pattern.matcher(stringBuilder);
        if (!matcher.lookingAt()) {
            return false;
        }
        int end = matcher.end();
        Matcher matcher2 = bUL.matcher(stringBuilder.substring(end));
        if (matcher2.find() && fF(matcher2.group(1)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            return false;
        }
        stringBuilder.delete(0, end);
        return true;
    }

    CountryCodeSource m14669b(StringBuilder stringBuilder, String str) {
        if (stringBuilder.length() == 0) {
            return CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = bUJ.matcher(stringBuilder);
        if (matcher.lookingAt()) {
            stringBuilder.delete(0, matcher.end());
            m14658c(stringBuilder);
            return CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern fH = this.bVf.fH(str);
        m14658c(stringBuilder);
        return m14656a(fH, stringBuilder) ? CountryCodeSource.FROM_NUMBER_WITH_IDD : CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    boolean m14668a(StringBuilder stringBuilder, b bVar, StringBuilder stringBuilder2) {
        int length = stringBuilder.length();
        String str = bVar.bVR;
        if (length == 0 || str.length() == 0) {
            return false;
        }
        Matcher matcher = this.bVf.fH(str).matcher(stringBuilder);
        if (!matcher.lookingAt()) {
            return false;
        }
        Pattern fH = this.bVf.fH(bVar.bVw.bWb);
        boolean matches = fH.matcher(stringBuilder).matches();
        int groupCount = matcher.groupCount();
        String str2 = bVar.bVS;
        if (str2 != null && str2.length() != 0 && matcher.group(groupCount) != null) {
            StringBuilder stringBuilder3 = new StringBuilder(stringBuilder);
            stringBuilder3.replace(0, length, matcher.replaceFirst(str2));
            if (matches && !fH.matcher(stringBuilder3.toString()).matches()) {
                return false;
            }
            if (stringBuilder2 != null && groupCount > 1) {
                stringBuilder2.append(matcher.group(1));
            }
            stringBuilder.replace(0, stringBuilder.length(), stringBuilder3.toString());
            return true;
        } else if (matches && !fH.matcher(stringBuilder.substring(matcher.end())).matches()) {
            return false;
        } else {
            if (!(stringBuilder2 == null || groupCount <= 0 || matcher.group(groupCount) == null)) {
                stringBuilder2.append(matcher.group(1));
            }
            stringBuilder.delete(0, matcher.end());
            return true;
        }
    }

    String m14670d(StringBuilder stringBuilder) {
        Matcher matcher = bUT.matcher(stringBuilder);
        if (matcher.find() && fD(stringBuilder.substring(0, matcher.start()))) {
            int groupCount = matcher.groupCount();
            for (int i = 1; i <= groupCount; i++) {
                if (matcher.group(i) != null) {
                    String group = matcher.group(i);
                    stringBuilder.delete(matcher.start(), stringBuilder.length());
                    return group;
                }
            }
        }
        return "";
    }

    private boolean al(String str, String str2) {
        if (fG(str2) || (str != null && str.length() != 0 && bUJ.matcher(str).lookingAt())) {
            return true;
        }
        return false;
    }

    public PhoneNumber am(String str, String str2) throws NumberParseException {
        PhoneNumber phoneNumber = new PhoneNumber();
        m14667a(str, str2, phoneNumber);
        return phoneNumber;
    }

    public void m14667a(String str, String str2, PhoneNumber phoneNumber) throws NumberParseException {
        m14653a(str, str2, false, true, phoneNumber);
    }

    static void m14652a(String str, PhoneNumber phoneNumber) {
        if (str.length() > 1 && str.charAt(0) == '0') {
            phoneNumber.setItalianLeadingZero(true);
            int i = 1;
            while (i < str.length() - 1 && str.charAt(i) == '0') {
                i++;
            }
            if (i != 1) {
                phoneNumber.setNumberOfLeadingZeros(i);
            }
        }
    }

    private void m14653a(String str, String str2, boolean z, boolean z2, PhoneNumber phoneNumber) throws NumberParseException {
        if (str == null) {
            throw new NumberParseException(ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
        } else if (str.length() > 250) {
            throw new NumberParseException(ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            m14654a(str, stringBuilder);
            if (!fD(stringBuilder.toString())) {
                throw new NumberParseException(ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            } else if (!z2 || al(stringBuilder.toString(), str2)) {
                int a;
                if (z) {
                    phoneNumber.setRawInput(str);
                }
                String d = m14670d(stringBuilder);
                if (d.length() > 0) {
                    phoneNumber.setExtension(d);
                }
                b fA = fA(str2);
                StringBuilder stringBuilder2 = new StringBuilder();
                try {
                    a = m14661a(stringBuilder.toString(), fA, stringBuilder2, z, phoneNumber);
                } catch (NumberParseException e) {
                    Matcher matcher = bUJ.matcher(stringBuilder.toString());
                    if (e.getErrorType() == ErrorType.INVALID_COUNTRY_CODE && matcher.lookingAt()) {
                        a = m14661a(stringBuilder.substring(matcher.end()), fA, stringBuilder2, z, phoneNumber);
                        if (a == 0) {
                            throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                        }
                    }
                    throw new NumberParseException(e.getErrorType(), e.getMessage());
                }
                if (a != 0) {
                    String iX = iX(a);
                    if (!iX.equals(str2)) {
                        fA = m14660q(a, iX);
                    }
                } else {
                    m14658c(stringBuilder);
                    stringBuilder2.append(stringBuilder);
                    if (str2 != null) {
                        phoneNumber.setCountryCode(fA.bVM);
                    } else if (z) {
                        phoneNumber.clearCountryCodeSource();
                    }
                }
                if (stringBuilder2.length() < 2) {
                    throw new NumberParseException(ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                }
                if (fA != null) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    StringBuilder stringBuilder4 = new StringBuilder(stringBuilder2);
                    m14668a(stringBuilder4, fA, stringBuilder3);
                    if (!m14655a(fA, stringBuilder4.toString())) {
                        if (z) {
                            phoneNumber.setPreferredDomesticCarrierCode(stringBuilder3.toString());
                        }
                        stringBuilder2 = stringBuilder4;
                    }
                }
                a = stringBuilder2.length();
                if (a < 2) {
                    throw new NumberParseException(ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                } else if (a > 17) {
                    throw new NumberParseException(ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
                } else {
                    m14652a(stringBuilder2.toString(), phoneNumber);
                    phoneNumber.setNationalNumber(Long.parseLong(stringBuilder2.toString()));
                }
            } else {
                throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
            }
        }
    }

    private void m14654a(String str, StringBuilder stringBuilder) {
        int length;
        int indexOf = str.indexOf(";phone-context=");
        if (indexOf > 0) {
            length = ";phone-context=".length() + indexOf;
            if (str.charAt(length) == '+') {
                int indexOf2 = str.indexOf(59, length);
                if (indexOf2 > 0) {
                    stringBuilder.append(str.substring(length, indexOf2));
                } else {
                    stringBuilder.append(str.substring(length));
                }
            }
            length = str.indexOf("tel:");
            stringBuilder.append(str.substring(length >= 0 ? length + "tel:".length() : 0, indexOf));
        } else {
            stringBuilder.append(fC(str));
        }
        length = stringBuilder.indexOf(";isub=");
        if (length > 0) {
            stringBuilder.delete(length, stringBuilder.length());
        }
    }
}
