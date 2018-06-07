package com.fossil;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dvh {
    private static final Pattern dvH = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern dvI = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String charset;
    private final String dvJ;
    private final String dvK;
    private final String type;

    private dvh(String str, String str2, String str3, String str4) {
        this.dvJ = str;
        this.type = str2;
        this.dvK = str3;
        this.charset = str4;
    }

    public static dvh kJ(String str) {
        Matcher matcher = dvH.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String toLowerCase = matcher.group(1).toLowerCase(Locale.US);
        String toLowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = dvI.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                if (matcher2.group(2) != null) {
                    group = matcher2.group(2);
                } else {
                    group = matcher2.group(3);
                }
                if (str2 == null || group.equalsIgnoreCase(str2)) {
                    str2 = group;
                } else {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
        }
        return new dvh(str, toLowerCase, toLowerCase2, str2);
    }

    public Charset charset() {
        return this.charset != null ? Charset.forName(this.charset) : null;
    }

    public String toString() {
        return this.dvJ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof dvh) && ((dvh) obj).dvJ.equals(this.dvJ);
    }

    public int hashCode() {
        return this.dvJ.hashCode();
    }
}
