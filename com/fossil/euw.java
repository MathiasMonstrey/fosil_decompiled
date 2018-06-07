package com.fossil;

import com.facebook.appevents.AppEventsConstants;
import java.util.StringTokenizer;
import org.apache.maven.artifact.versioning.ComparableVersion;

public class euw implements euv {
    private Integer dWd;
    private Integer dWe;
    private Integer dWf;
    private Integer dWg;
    private String dWh;
    private ComparableVersion dWi;

    public /* synthetic */ int compareTo(Object obj) {
        return m11251a((euv) obj);
    }

    public euw(String str) {
        mR(str);
    }

    public int hashCode() {
        return this.dWi.hashCode() + 11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof euv)) {
            return false;
        }
        if (m11251a((euv) obj) != 0) {
            return false;
        }
        return true;
    }

    public int m11251a(euv com_fossil_euv) {
        if (com_fossil_euv instanceof euw) {
            return this.dWi.a(((euw) com_fossil_euv).dWi);
        }
        return m11251a(new euw(com_fossil_euv.toString()));
    }

    public final void mR(String str) {
        String str2;
        String str3;
        int i = 0;
        this.dWi = new ComparableVersion(str);
        int indexOf = str.indexOf("-");
        if (indexOf < 0) {
            str2 = null;
            str3 = str;
        } else {
            str3 = str.substring(0, indexOf);
            str2 = str.substring(indexOf + 1);
        }
        if (str2 != null) {
            try {
                if (str2.length() == 1 || !str2.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    this.dWg = Integer.valueOf(str2);
                } else {
                    this.dWh = str2;
                }
            } catch (NumberFormatException e) {
                this.dWh = str2;
            }
        }
        if (str3.indexOf(".") >= 0 || str3.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str3, ".");
            try {
                this.dWd = m11250a(stringTokenizer);
                if (stringTokenizer.hasMoreTokens()) {
                    this.dWe = m11250a(stringTokenizer);
                }
                if (stringTokenizer.hasMoreTokens()) {
                    this.dWf = m11250a(stringTokenizer);
                }
                if (stringTokenizer.hasMoreTokens()) {
                    i = 1;
                }
                if (str3.indexOf("..") >= 0 || str3.startsWith(".") || str3.endsWith(".")) {
                    i = 1;
                }
            } catch (NumberFormatException e2) {
                i = 1;
            }
            if (i != 0) {
                this.dWh = str;
                this.dWd = null;
                this.dWe = null;
                this.dWf = null;
                this.dWg = null;
                return;
            }
            return;
        }
        try {
            this.dWd = Integer.valueOf(str3);
        } catch (NumberFormatException e3) {
            this.dWh = str;
            this.dWg = null;
        }
    }

    private static Integer m11250a(StringTokenizer stringTokenizer) {
        String nextToken = stringTokenizer.nextToken();
        if (nextToken.length() <= 1 || !nextToken.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            return Integer.valueOf(nextToken);
        }
        throw new NumberFormatException("Number part has a leading 0: '" + nextToken + "'");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.dWd != null) {
            stringBuilder.append(this.dWd);
        }
        if (this.dWe != null) {
            stringBuilder.append(".");
            stringBuilder.append(this.dWe);
        }
        if (this.dWf != null) {
            stringBuilder.append(".");
            stringBuilder.append(this.dWf);
        }
        if (this.dWg != null) {
            stringBuilder.append("-");
            stringBuilder.append(this.dWg);
        } else if (this.dWh != null) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("-");
            }
            stringBuilder.append(this.dWh);
        }
        return stringBuilder.toString();
    }
}
