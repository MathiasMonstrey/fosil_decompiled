package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.fossil.caa.C1943a;
import com.fossil.caa.C1949b;
import com.fossil.caa.C1949b.C1945a;
import com.fossil.caa.C1949b.C1947b;
import com.fossil.caa.C1951c;
import com.fossil.caa.C1953d;
import com.fossil.caa.C1955e;
import com.fossil.caa.C1957f;
import com.fossil.caa.C1959g;
import com.fossil.wearables.fsl.goaltracking.GoalPhase;
import com.misfit.frameworks.common.constants.Constants;
import com.portfolio.platform.data.model.Widget;
import com.portfolio.platform.response.user.MFGetWechatUserInfoResponse;
import com.sina.weibo.sdk.api.CmdObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class btf extends bip implements caa {
    public static final Creator<btf> CREATOR = new btg();
    private static final HashMap<String, bin<?, ?>> bFg;
    private String bFA;
    private String bFB;
    private List<C1960g> bFC;
    private boolean bFD;
    private Set<Integer> bFh;
    private String bFi;
    private C1944a bFj;
    private String bFk;
    private String bFl;
    private int bFm;
    private C1950b bFn;
    private String bFo;
    private int bFp;
    private C1952c bFq;
    private boolean bFr;
    private String bFs;
    private C1954d bFt;
    private String bFu;
    private int bFv;
    private List<C1956e> bFw;
    private List<C1958f> bFx;
    private int bFy;
    private int bFz;
    private String beB;
    private String beE;
    private int ber;

    public static final class C1944a extends bip implements C1943a {
        public static final Creator<C1944a> CREATOR = new bth();
        private static final HashMap<String, bin<?, ?>> bFg;
        private int bFE;
        private int bFF;
        private Set<Integer> bFh;
        private int ber;

        static {
            HashMap hashMap = new HashMap();
            bFg = hashMap;
            hashMap.put("max", bin.m5208r("max", 2));
            bFg.put("min", bin.m5208r("min", 3));
        }

        public C1944a() {
            this.ber = 1;
            this.bFh = new HashSet();
        }

        C1944a(Set<Integer> set, int i, int i2, int i3) {
            this.bFh = set;
            this.ber = i;
            this.bFE = i2;
            this.bFF = i3;
        }

        public final /* synthetic */ Map Ox() {
            return bFg;
        }

        protected final boolean mo1470a(bin com_fossil_bin) {
            return this.bFh.contains(Integer.valueOf(com_fossil_bin.Oy()));
        }

        protected final Object mo1471b(bin com_fossil_bin) {
            switch (com_fossil_bin.Oy()) {
                case 2:
                    return Integer.valueOf(this.bFE);
                case 3:
                    return Integer.valueOf(this.bFF);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_fossil_bin.Oy());
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1944a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1944a c1944a = (C1944a) obj;
            for (bin com_fossil_bin : bFg.values()) {
                if (mo1470a(com_fossil_bin)) {
                    if (!c1944a.mo1470a(com_fossil_bin)) {
                        return false;
                    }
                    if (!mo1471b(com_fossil_bin).equals(c1944a.mo1471b(com_fossil_bin))) {
                        return false;
                    }
                } else if (c1944a.mo1470a(com_fossil_bin)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            return this;
        }

        public final int hashCode() {
            int i = 0;
            for (bin com_fossil_bin : bFg.values()) {
                int hashCode;
                if (mo1470a(com_fossil_bin)) {
                    hashCode = mo1471b(com_fossil_bin).hashCode() + (i + com_fossil_bin.Oy());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int A = aus.m4537A(parcel);
            Set set = this.bFh;
            if (set.contains(Integer.valueOf(1))) {
                aus.m4565c(parcel, 1, this.ber);
            }
            if (set.contains(Integer.valueOf(2))) {
                aus.m4565c(parcel, 2, this.bFE);
            }
            if (set.contains(Integer.valueOf(3))) {
                aus.m4565c(parcel, 3, this.bFF);
            }
            aus.m4540G(parcel, A);
        }
    }

    public static final class C1950b extends bip implements C1949b {
        public static final Creator<C1950b> CREATOR = new bti();
        private static final HashMap<String, bin<?, ?>> bFg;
        private C1946a bFG;
        private C1948b bFH;
        private int bFI;
        private Set<Integer> bFh;
        private int ber;

        public static final class C1946a extends bip implements C1945a {
            public static final Creator<C1946a> CREATOR = new btj();
            private static final HashMap<String, bin<?, ?>> bFg;
            private int bFJ;
            private int bFK;
            private Set<Integer> bFh;
            private int ber;

            static {
                HashMap hashMap = new HashMap();
                bFg = hashMap;
                hashMap.put("leftImageOffset", bin.m5208r("leftImageOffset", 2));
                bFg.put("topImageOffset", bin.m5208r("topImageOffset", 3));
            }

            public C1946a() {
                this.ber = 1;
                this.bFh = new HashSet();
            }

            C1946a(Set<Integer> set, int i, int i2, int i3) {
                this.bFh = set;
                this.ber = i;
                this.bFJ = i2;
                this.bFK = i3;
            }

            public final /* synthetic */ Map Ox() {
                return bFg;
            }

            protected final boolean mo1470a(bin com_fossil_bin) {
                return this.bFh.contains(Integer.valueOf(com_fossil_bin.Oy()));
            }

            protected final Object mo1471b(bin com_fossil_bin) {
                switch (com_fossil_bin.Oy()) {
                    case 2:
                        return Integer.valueOf(this.bFJ);
                    case 3:
                        return Integer.valueOf(this.bFK);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + com_fossil_bin.Oy());
                }
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof C1946a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1946a c1946a = (C1946a) obj;
                for (bin com_fossil_bin : bFg.values()) {
                    if (mo1470a(com_fossil_bin)) {
                        if (!c1946a.mo1470a(com_fossil_bin)) {
                            return false;
                        }
                        if (!mo1471b(com_fossil_bin).equals(c1946a.mo1471b(com_fossil_bin))) {
                            return false;
                        }
                    } else if (c1946a.mo1470a(com_fossil_bin)) {
                        return false;
                    }
                }
                return true;
            }

            public final /* bridge */ /* synthetic */ Object freeze() {
                return this;
            }

            public final int hashCode() {
                int i = 0;
                for (bin com_fossil_bin : bFg.values()) {
                    int hashCode;
                    if (mo1470a(com_fossil_bin)) {
                        hashCode = mo1471b(com_fossil_bin).hashCode() + (i + com_fossil_bin.Oy());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                int A = aus.m4537A(parcel);
                Set set = this.bFh;
                if (set.contains(Integer.valueOf(1))) {
                    aus.m4565c(parcel, 1, this.ber);
                }
                if (set.contains(Integer.valueOf(2))) {
                    aus.m4565c(parcel, 2, this.bFJ);
                }
                if (set.contains(Integer.valueOf(3))) {
                    aus.m4565c(parcel, 3, this.bFK);
                }
                aus.m4540G(parcel, A);
            }
        }

        public static final class C1948b extends bip implements C1947b {
            public static final Creator<C1948b> CREATOR = new btk();
            private static final HashMap<String, bin<?, ?>> bFg;
            private String bFB;
            private int bFL;
            private int bFM;
            private Set<Integer> bFh;
            private int ber;

            static {
                HashMap hashMap = new HashMap();
                bFg = hashMap;
                hashMap.put(Constants.PROFILE_KEY_UNITS_HEIGHT, bin.m5208r(Constants.PROFILE_KEY_UNITS_HEIGHT, 2));
                bFg.put("url", bin.m5210t("url", 3));
                bFg.put("width", bin.m5208r("width", 4));
            }

            public C1948b() {
                this.ber = 1;
                this.bFh = new HashSet();
            }

            C1948b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.bFh = set;
                this.ber = i;
                this.bFL = i2;
                this.bFB = str;
                this.bFM = i3;
            }

            public final /* synthetic */ Map Ox() {
                return bFg;
            }

            protected final boolean mo1470a(bin com_fossil_bin) {
                return this.bFh.contains(Integer.valueOf(com_fossil_bin.Oy()));
            }

            protected final Object mo1471b(bin com_fossil_bin) {
                switch (com_fossil_bin.Oy()) {
                    case 2:
                        return Integer.valueOf(this.bFL);
                    case 3:
                        return this.bFB;
                    case 4:
                        return Integer.valueOf(this.bFM);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + com_fossil_bin.Oy());
                }
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof C1948b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1948b c1948b = (C1948b) obj;
                for (bin com_fossil_bin : bFg.values()) {
                    if (mo1470a(com_fossil_bin)) {
                        if (!c1948b.mo1470a(com_fossil_bin)) {
                            return false;
                        }
                        if (!mo1471b(com_fossil_bin).equals(c1948b.mo1471b(com_fossil_bin))) {
                            return false;
                        }
                    } else if (c1948b.mo1470a(com_fossil_bin)) {
                        return false;
                    }
                }
                return true;
            }

            public final /* bridge */ /* synthetic */ Object freeze() {
                return this;
            }

            public final int hashCode() {
                int i = 0;
                for (bin com_fossil_bin : bFg.values()) {
                    int hashCode;
                    if (mo1470a(com_fossil_bin)) {
                        hashCode = mo1471b(com_fossil_bin).hashCode() + (i + com_fossil_bin.Oy());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                int A = aus.m4537A(parcel);
                Set set = this.bFh;
                if (set.contains(Integer.valueOf(1))) {
                    aus.m4565c(parcel, 1, this.ber);
                }
                if (set.contains(Integer.valueOf(2))) {
                    aus.m4565c(parcel, 2, this.bFL);
                }
                if (set.contains(Integer.valueOf(3))) {
                    aus.m4554a(parcel, 3, this.bFB, true);
                }
                if (set.contains(Integer.valueOf(4))) {
                    aus.m4565c(parcel, 4, this.bFM);
                }
                aus.m4540G(parcel, A);
            }
        }

        static {
            HashMap hashMap = new HashMap();
            bFg = hashMap;
            hashMap.put("coverInfo", bin.m5205a("coverInfo", 2, C1946a.class));
            bFg.put("coverPhoto", bin.m5205a("coverPhoto", 3, C1948b.class));
            bFg.put(Widget.COLUMN_LAYOUT, bin.m5204a(Widget.COLUMN_LAYOUT, 4, new bii().m5198q("banner", 0), false));
        }

        public C1950b() {
            this.ber = 1;
            this.bFh = new HashSet();
        }

        C1950b(Set<Integer> set, int i, C1946a c1946a, C1948b c1948b, int i2) {
            this.bFh = set;
            this.ber = i;
            this.bFG = c1946a;
            this.bFH = c1948b;
            this.bFI = i2;
        }

        public final /* synthetic */ Map Ox() {
            return bFg;
        }

        protected final boolean mo1470a(bin com_fossil_bin) {
            return this.bFh.contains(Integer.valueOf(com_fossil_bin.Oy()));
        }

        protected final Object mo1471b(bin com_fossil_bin) {
            switch (com_fossil_bin.Oy()) {
                case 2:
                    return this.bFG;
                case 3:
                    return this.bFH;
                case 4:
                    return Integer.valueOf(this.bFI);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_fossil_bin.Oy());
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1950b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1950b c1950b = (C1950b) obj;
            for (bin com_fossil_bin : bFg.values()) {
                if (mo1470a(com_fossil_bin)) {
                    if (!c1950b.mo1470a(com_fossil_bin)) {
                        return false;
                    }
                    if (!mo1471b(com_fossil_bin).equals(c1950b.mo1471b(com_fossil_bin))) {
                        return false;
                    }
                } else if (c1950b.mo1470a(com_fossil_bin)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            return this;
        }

        public final int hashCode() {
            int i = 0;
            for (bin com_fossil_bin : bFg.values()) {
                int hashCode;
                if (mo1470a(com_fossil_bin)) {
                    hashCode = mo1471b(com_fossil_bin).hashCode() + (i + com_fossil_bin.Oy());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int A = aus.m4537A(parcel);
            Set set = this.bFh;
            if (set.contains(Integer.valueOf(1))) {
                aus.m4565c(parcel, 1, this.ber);
            }
            if (set.contains(Integer.valueOf(2))) {
                aus.m4548a(parcel, 2, this.bFG, i, true);
            }
            if (set.contains(Integer.valueOf(3))) {
                aus.m4548a(parcel, 3, this.bFH, i, true);
            }
            if (set.contains(Integer.valueOf(4))) {
                aus.m4565c(parcel, 4, this.bFI);
            }
            aus.m4540G(parcel, A);
        }
    }

    public static final class C1952c extends bip implements C1951c {
        public static final Creator<C1952c> CREATOR = new btl();
        private static final HashMap<String, bin<?, ?>> bFg;
        private String bFB;
        private Set<Integer> bFh;
        private int ber;

        static {
            HashMap hashMap = new HashMap();
            bFg = hashMap;
            hashMap.put("url", bin.m5210t("url", 2));
        }

        public C1952c() {
            this.ber = 1;
            this.bFh = new HashSet();
        }

        C1952c(Set<Integer> set, int i, String str) {
            this.bFh = set;
            this.ber = i;
            this.bFB = str;
        }

        public final /* synthetic */ Map Ox() {
            return bFg;
        }

        protected final boolean mo1470a(bin com_fossil_bin) {
            return this.bFh.contains(Integer.valueOf(com_fossil_bin.Oy()));
        }

        protected final Object mo1471b(bin com_fossil_bin) {
            switch (com_fossil_bin.Oy()) {
                case 2:
                    return this.bFB;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_fossil_bin.Oy());
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1952c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1952c c1952c = (C1952c) obj;
            for (bin com_fossil_bin : bFg.values()) {
                if (mo1470a(com_fossil_bin)) {
                    if (!c1952c.mo1470a(com_fossil_bin)) {
                        return false;
                    }
                    if (!mo1471b(com_fossil_bin).equals(c1952c.mo1471b(com_fossil_bin))) {
                        return false;
                    }
                } else if (c1952c.mo1470a(com_fossil_bin)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            return this;
        }

        public final int hashCode() {
            int i = 0;
            for (bin com_fossil_bin : bFg.values()) {
                int hashCode;
                if (mo1470a(com_fossil_bin)) {
                    hashCode = mo1471b(com_fossil_bin).hashCode() + (i + com_fossil_bin.Oy());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int A = aus.m4537A(parcel);
            Set set = this.bFh;
            if (set.contains(Integer.valueOf(1))) {
                aus.m4565c(parcel, 1, this.ber);
            }
            if (set.contains(Integer.valueOf(2))) {
                aus.m4554a(parcel, 2, this.bFB, true);
            }
            aus.m4540G(parcel, A);
        }
    }

    public static final class C1954d extends bip implements C1953d {
        public static final Creator<C1954d> CREATOR = new btm();
        private static final HashMap<String, bin<?, ?>> bFg;
        private String bFN;
        private String bFO;
        private String bFP;
        private String bFQ;
        private Set<Integer> bFh;
        private String beK;
        private String beL;
        private int ber;

        static {
            HashMap hashMap = new HashMap();
            bFg = hashMap;
            hashMap.put("familyName", bin.m5210t("familyName", 2));
            bFg.put("formatted", bin.m5210t("formatted", 3));
            bFg.put("givenName", bin.m5210t("givenName", 4));
            bFg.put("honorificPrefix", bin.m5210t("honorificPrefix", 5));
            bFg.put("honorificSuffix", bin.m5210t("honorificSuffix", 6));
            bFg.put("middleName", bin.m5210t("middleName", 7));
        }

        public C1954d() {
            this.ber = 1;
            this.bFh = new HashSet();
        }

        C1954d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.bFh = set;
            this.ber = i;
            this.beL = str;
            this.bFN = str2;
            this.beK = str3;
            this.bFO = str4;
            this.bFP = str5;
            this.bFQ = str6;
        }

        public final String JM() {
            return this.beK;
        }

        public final String JN() {
            return this.beL;
        }

        public final /* synthetic */ Map Ox() {
            return bFg;
        }

        protected final boolean mo1470a(bin com_fossil_bin) {
            return this.bFh.contains(Integer.valueOf(com_fossil_bin.Oy()));
        }

        protected final Object mo1471b(bin com_fossil_bin) {
            switch (com_fossil_bin.Oy()) {
                case 2:
                    return this.beL;
                case 3:
                    return this.bFN;
                case 4:
                    return this.beK;
                case 5:
                    return this.bFO;
                case 6:
                    return this.bFP;
                case 7:
                    return this.bFQ;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_fossil_bin.Oy());
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1954d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1954d c1954d = (C1954d) obj;
            for (bin com_fossil_bin : bFg.values()) {
                if (mo1470a(com_fossil_bin)) {
                    if (!c1954d.mo1470a(com_fossil_bin)) {
                        return false;
                    }
                    if (!mo1471b(com_fossil_bin).equals(c1954d.mo1471b(com_fossil_bin))) {
                        return false;
                    }
                } else if (c1954d.mo1470a(com_fossil_bin)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            return this;
        }

        public final int hashCode() {
            int i = 0;
            for (bin com_fossil_bin : bFg.values()) {
                int hashCode;
                if (mo1470a(com_fossil_bin)) {
                    hashCode = mo1471b(com_fossil_bin).hashCode() + (i + com_fossil_bin.Oy());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int A = aus.m4537A(parcel);
            Set set = this.bFh;
            if (set.contains(Integer.valueOf(1))) {
                aus.m4565c(parcel, 1, this.ber);
            }
            if (set.contains(Integer.valueOf(2))) {
                aus.m4554a(parcel, 2, this.beL, true);
            }
            if (set.contains(Integer.valueOf(3))) {
                aus.m4554a(parcel, 3, this.bFN, true);
            }
            if (set.contains(Integer.valueOf(4))) {
                aus.m4554a(parcel, 4, this.beK, true);
            }
            if (set.contains(Integer.valueOf(5))) {
                aus.m4554a(parcel, 5, this.bFO, true);
            }
            if (set.contains(Integer.valueOf(6))) {
                aus.m4554a(parcel, 6, this.bFP, true);
            }
            if (set.contains(Integer.valueOf(7))) {
                aus.m4554a(parcel, 7, this.bFQ, true);
            }
            aus.m4540G(parcel, A);
        }
    }

    public static final class C1956e extends bip implements C1955e {
        public static final Creator<C1956e> CREATOR = new btn();
        private static final HashMap<String, bin<?, ?>> bFg;
        private String bFR;
        private String bFS;
        private String bFT;
        private String bFU;
        private boolean bFV;
        private String bFW;
        private String bFX;
        private Set<Integer> bFh;
        private int ber;
        private int bfw;
        private String mName;

        static {
            HashMap hashMap = new HashMap();
            bFg = hashMap;
            hashMap.put("department", bin.m5210t("department", 2));
            bFg.put("description", bin.m5210t("description", 3));
            bFg.put(GoalPhase.COLUMN_END_DATE, bin.m5210t(GoalPhase.COLUMN_END_DATE, 4));
            bFg.put("location", bin.m5210t("location", 5));
            bFg.put("name", bin.m5210t("name", 6));
            bFg.put("primary", bin.m5209s("primary", 7));
            bFg.put(GoalPhase.COLUMN_START_DATE, bin.m5210t(GoalPhase.COLUMN_START_DATE, 8));
            bFg.put("title", bin.m5210t("title", 9));
            bFg.put("type", bin.m5204a("type", 10, new bii().m5198q("work", 0).m5198q("school", 1), false));
        }

        public C1956e() {
            this.ber = 1;
            this.bFh = new HashSet();
        }

        C1956e(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.bFh = set;
            this.ber = i;
            this.bFR = str;
            this.bFS = str2;
            this.bFT = str3;
            this.bFU = str4;
            this.mName = str5;
            this.bFV = z;
            this.bFW = str6;
            this.bFX = str7;
            this.bfw = i2;
        }

        public final /* synthetic */ Map Ox() {
            return bFg;
        }

        protected final boolean mo1470a(bin com_fossil_bin) {
            return this.bFh.contains(Integer.valueOf(com_fossil_bin.Oy()));
        }

        protected final Object mo1471b(bin com_fossil_bin) {
            switch (com_fossil_bin.Oy()) {
                case 2:
                    return this.bFR;
                case 3:
                    return this.bFS;
                case 4:
                    return this.bFT;
                case 5:
                    return this.bFU;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.bFV);
                case 8:
                    return this.bFW;
                case 9:
                    return this.bFX;
                case 10:
                    return Integer.valueOf(this.bfw);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_fossil_bin.Oy());
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1956e)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1956e c1956e = (C1956e) obj;
            for (bin com_fossil_bin : bFg.values()) {
                if (mo1470a(com_fossil_bin)) {
                    if (!c1956e.mo1470a(com_fossil_bin)) {
                        return false;
                    }
                    if (!mo1471b(com_fossil_bin).equals(c1956e.mo1471b(com_fossil_bin))) {
                        return false;
                    }
                } else if (c1956e.mo1470a(com_fossil_bin)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            return this;
        }

        public final int hashCode() {
            int i = 0;
            for (bin com_fossil_bin : bFg.values()) {
                int hashCode;
                if (mo1470a(com_fossil_bin)) {
                    hashCode = mo1471b(com_fossil_bin).hashCode() + (i + com_fossil_bin.Oy());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int A = aus.m4537A(parcel);
            Set set = this.bFh;
            if (set.contains(Integer.valueOf(1))) {
                aus.m4565c(parcel, 1, this.ber);
            }
            if (set.contains(Integer.valueOf(2))) {
                aus.m4554a(parcel, 2, this.bFR, true);
            }
            if (set.contains(Integer.valueOf(3))) {
                aus.m4554a(parcel, 3, this.bFS, true);
            }
            if (set.contains(Integer.valueOf(4))) {
                aus.m4554a(parcel, 4, this.bFT, true);
            }
            if (set.contains(Integer.valueOf(5))) {
                aus.m4554a(parcel, 5, this.bFU, true);
            }
            if (set.contains(Integer.valueOf(6))) {
                aus.m4554a(parcel, 6, this.mName, true);
            }
            if (set.contains(Integer.valueOf(7))) {
                aus.m4556a(parcel, 7, this.bFV);
            }
            if (set.contains(Integer.valueOf(8))) {
                aus.m4554a(parcel, 8, this.bFW, true);
            }
            if (set.contains(Integer.valueOf(9))) {
                aus.m4554a(parcel, 9, this.bFX, true);
            }
            if (set.contains(Integer.valueOf(10))) {
                aus.m4565c(parcel, 10, this.bfw);
            }
            aus.m4540G(parcel, A);
        }
    }

    public static final class C1958f extends bip implements C1957f {
        public static final Creator<C1958f> CREATOR = new bto();
        private static final HashMap<String, bin<?, ?>> bFg;
        private boolean bFV;
        private Set<Integer> bFh;
        private int ber;
        private String mValue;

        static {
            HashMap hashMap = new HashMap();
            bFg = hashMap;
            hashMap.put("primary", bin.m5209s("primary", 2));
            bFg.put("value", bin.m5210t("value", 3));
        }

        public C1958f() {
            this.ber = 1;
            this.bFh = new HashSet();
        }

        C1958f(Set<Integer> set, int i, boolean z, String str) {
            this.bFh = set;
            this.ber = i;
            this.bFV = z;
            this.mValue = str;
        }

        public final /* synthetic */ Map Ox() {
            return bFg;
        }

        protected final boolean mo1470a(bin com_fossil_bin) {
            return this.bFh.contains(Integer.valueOf(com_fossil_bin.Oy()));
        }

        protected final Object mo1471b(bin com_fossil_bin) {
            switch (com_fossil_bin.Oy()) {
                case 2:
                    return Boolean.valueOf(this.bFV);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_fossil_bin.Oy());
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1958f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1958f c1958f = (C1958f) obj;
            for (bin com_fossil_bin : bFg.values()) {
                if (mo1470a(com_fossil_bin)) {
                    if (!c1958f.mo1470a(com_fossil_bin)) {
                        return false;
                    }
                    if (!mo1471b(com_fossil_bin).equals(c1958f.mo1471b(com_fossil_bin))) {
                        return false;
                    }
                } else if (c1958f.mo1470a(com_fossil_bin)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            return this;
        }

        public final int hashCode() {
            int i = 0;
            for (bin com_fossil_bin : bFg.values()) {
                int hashCode;
                if (mo1470a(com_fossil_bin)) {
                    hashCode = mo1471b(com_fossil_bin).hashCode() + (i + com_fossil_bin.Oy());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int A = aus.m4537A(parcel);
            Set set = this.bFh;
            if (set.contains(Integer.valueOf(1))) {
                aus.m4565c(parcel, 1, this.ber);
            }
            if (set.contains(Integer.valueOf(2))) {
                aus.m4556a(parcel, 2, this.bFV);
            }
            if (set.contains(Integer.valueOf(3))) {
                aus.m4554a(parcel, 3, this.mValue, true);
            }
            aus.m4540G(parcel, A);
        }
    }

    public static final class C1960g extends bip implements C1959g {
        public static final Creator<C1960g> CREATOR = new btp();
        private static final HashMap<String, bin<?, ?>> bFg;
        private String bFY;
        private final int bFZ;
        private Set<Integer> bFh;
        private int ber;
        private int bfw;
        private String mValue;

        static {
            HashMap hashMap = new HashMap();
            bFg = hashMap;
            hashMap.put("label", bin.m5210t("label", 5));
            bFg.put("type", bin.m5204a("type", 6, new bii().m5198q(CmdObject.CMD_HOME, 0).m5198q("work", 1).m5198q("blog", 2).m5198q("profile", 3).m5198q(FacebookRequestErrorClassification.KEY_OTHER, 4).m5198q("otherProfile", 5).m5198q("contributor", 6).m5198q("website", 7), false));
            bFg.put("value", bin.m5210t("value", 4));
        }

        public C1960g() {
            this.bFZ = 4;
            this.ber = 1;
            this.bFh = new HashSet();
        }

        C1960g(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.bFZ = 4;
            this.bFh = set;
            this.ber = i;
            this.bFY = str;
            this.bfw = i2;
            this.mValue = str2;
        }

        public final /* synthetic */ Map Ox() {
            return bFg;
        }

        protected final boolean mo1470a(bin com_fossil_bin) {
            return this.bFh.contains(Integer.valueOf(com_fossil_bin.Oy()));
        }

        protected final Object mo1471b(bin com_fossil_bin) {
            switch (com_fossil_bin.Oy()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.bFY;
                case 6:
                    return Integer.valueOf(this.bfw);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_fossil_bin.Oy());
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1960g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1960g c1960g = (C1960g) obj;
            for (bin com_fossil_bin : bFg.values()) {
                if (mo1470a(com_fossil_bin)) {
                    if (!c1960g.mo1470a(com_fossil_bin)) {
                        return false;
                    }
                    if (!mo1471b(com_fossil_bin).equals(c1960g.mo1471b(com_fossil_bin))) {
                        return false;
                    }
                } else if (c1960g.mo1470a(com_fossil_bin)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            return this;
        }

        public final int hashCode() {
            int i = 0;
            for (bin com_fossil_bin : bFg.values()) {
                int hashCode;
                if (mo1470a(com_fossil_bin)) {
                    hashCode = mo1471b(com_fossil_bin).hashCode() + (i + com_fossil_bin.Oy());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int A = aus.m4537A(parcel);
            Set set = this.bFh;
            if (set.contains(Integer.valueOf(1))) {
                aus.m4565c(parcel, 1, this.ber);
            }
            if (set.contains(Integer.valueOf(3))) {
                aus.m4565c(parcel, 3, 4);
            }
            if (set.contains(Integer.valueOf(4))) {
                aus.m4554a(parcel, 4, this.mValue, true);
            }
            if (set.contains(Integer.valueOf(5))) {
                aus.m4554a(parcel, 5, this.bFY, true);
            }
            if (set.contains(Integer.valueOf(6))) {
                aus.m4565c(parcel, 6, this.bfw);
            }
            aus.m4540G(parcel, A);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        bFg = hashMap;
        hashMap.put("aboutMe", bin.m5210t("aboutMe", 2));
        bFg.put("ageRange", bin.m5205a("ageRange", 3, C1944a.class));
        bFg.put(Constants.PROFILE_KEY_BIRTHDAY, bin.m5210t(Constants.PROFILE_KEY_BIRTHDAY, 4));
        bFg.put("braggingRights", bin.m5210t("braggingRights", 5));
        bFg.put("circledByCount", bin.m5208r("circledByCount", 6));
        bFg.put("cover", bin.m5205a("cover", 7, C1950b.class));
        bFg.put("currentLocation", bin.m5210t("currentLocation", 8));
        bFg.put("displayName", bin.m5210t("displayName", 9));
        bFg.put("gender", bin.m5204a("gender", 12, new bii().m5198q("male", 0).m5198q("female", 1).m5198q(FacebookRequestErrorClassification.KEY_OTHER, 2), false));
        bFg.put("id", bin.m5210t("id", 14));
        bFg.put("image", bin.m5205a("image", 15, C1952c.class));
        bFg.put("isPlusUser", bin.m5209s("isPlusUser", 16));
        bFg.put("language", bin.m5210t("language", 18));
        bFg.put("name", bin.m5205a("name", 19, C1954d.class));
        bFg.put(MFGetWechatUserInfoResponse.NICK_NAME, bin.m5210t(MFGetWechatUserInfoResponse.NICK_NAME, 20));
        bFg.put("objectType", bin.m5204a("objectType", 21, new bii().m5198q("person", 0).m5198q("page", 1), false));
        bFg.put("organizations", bin.m5206b("organizations", 22, C1956e.class));
        bFg.put("placesLived", bin.m5206b("placesLived", 23, C1958f.class));
        bFg.put("plusOneCount", bin.m5208r("plusOneCount", 24));
        bFg.put("relationshipStatus", bin.m5204a("relationshipStatus", 25, new bii().m5198q("single", 0).m5198q("in_a_relationship", 1).m5198q("engaged", 2).m5198q("married", 3).m5198q("its_complicated", 4).m5198q("open_relationship", 5).m5198q("widowed", 6).m5198q("in_domestic_partnership", 7).m5198q("in_civil_union", 8), false));
        bFg.put("tagline", bin.m5210t("tagline", 26));
        bFg.put("url", bin.m5210t("url", 27));
        bFg.put("urls", bin.m5206b("urls", 28, C1960g.class));
        bFg.put("verified", bin.m5209s("verified", 29));
    }

    public btf() {
        this.ber = 1;
        this.bFh = new HashSet();
    }

    btf(Set<Integer> set, int i, String str, C1944a c1944a, String str2, String str3, int i2, C1950b c1950b, String str4, String str5, int i3, String str6, C1952c c1952c, boolean z, String str7, C1954d c1954d, String str8, int i4, List<C1956e> list, List<C1958f> list2, int i5, int i6, String str9, String str10, List<C1960g> list3, boolean z2) {
        this.bFh = set;
        this.ber = i;
        this.bFi = str;
        this.bFj = c1944a;
        this.bFk = str2;
        this.bFl = str3;
        this.bFm = i2;
        this.bFn = c1950b;
        this.bFo = str4;
        this.beE = str5;
        this.bFp = i3;
        this.beB = str6;
        this.bFq = c1952c;
        this.bFr = z;
        this.bFs = str7;
        this.bFt = c1954d;
        this.bFu = str8;
        this.bFv = i4;
        this.bFw = list;
        this.bFx = list2;
        this.bFy = i5;
        this.bFz = i6;
        this.bFA = str9;
        this.bFB = str10;
        this.bFC = list3;
        this.bFD = z2;
    }

    public static btf al(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        btf com_fossil_btf = (btf) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return com_fossil_btf;
    }

    public final /* synthetic */ Map Ox() {
        return bFg;
    }

    public final C1953d Sv() {
        return this.bFt;
    }

    protected final boolean mo1470a(bin com_fossil_bin) {
        return this.bFh.contains(Integer.valueOf(com_fossil_bin.Oy()));
    }

    protected final Object mo1471b(bin com_fossil_bin) {
        switch (com_fossil_bin.Oy()) {
            case 2:
                return this.bFi;
            case 3:
                return this.bFj;
            case 4:
                return this.bFk;
            case 5:
                return this.bFl;
            case 6:
                return Integer.valueOf(this.bFm);
            case 7:
                return this.bFn;
            case 8:
                return this.bFo;
            case 9:
                return this.beE;
            case 12:
                return Integer.valueOf(this.bFp);
            case 14:
                return this.beB;
            case 15:
                return this.bFq;
            case 16:
                return Boolean.valueOf(this.bFr);
            case 18:
                return this.bFs;
            case 19:
                return this.bFt;
            case 20:
                return this.bFu;
            case 21:
                return Integer.valueOf(this.bFv);
            case 22:
                return this.bFw;
            case 23:
                return this.bFx;
            case 24:
                return Integer.valueOf(this.bFy);
            case 25:
                return Integer.valueOf(this.bFz);
            case 26:
                return this.bFA;
            case 27:
                return this.bFB;
            case 28:
                return this.bFC;
            case 29:
                return Boolean.valueOf(this.bFD);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + com_fossil_bin.Oy());
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof btf)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        btf com_fossil_btf = (btf) obj;
        for (bin com_fossil_bin : bFg.values()) {
            if (mo1470a(com_fossil_bin)) {
                if (!com_fossil_btf.mo1470a(com_fossil_bin)) {
                    return false;
                }
                if (!mo1471b(com_fossil_bin).equals(com_fossil_btf.mo1471b(com_fossil_bin))) {
                    return false;
                }
            } else if (com_fossil_btf.mo1470a(com_fossil_bin)) {
                return false;
            }
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        int i = 0;
        for (bin com_fossil_bin : bFg.values()) {
            int hashCode;
            if (mo1470a(com_fossil_bin)) {
                hashCode = mo1471b(com_fossil_bin).hashCode() + (i + com_fossil_bin.Oy());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        Set set = this.bFh;
        if (set.contains(Integer.valueOf(1))) {
            aus.m4565c(parcel, 1, this.ber);
        }
        if (set.contains(Integer.valueOf(2))) {
            aus.m4554a(parcel, 2, this.bFi, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            aus.m4548a(parcel, 3, this.bFj, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            aus.m4554a(parcel, 4, this.bFk, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            aus.m4554a(parcel, 5, this.bFl, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            aus.m4565c(parcel, 6, this.bFm);
        }
        if (set.contains(Integer.valueOf(7))) {
            aus.m4548a(parcel, 7, this.bFn, i, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            aus.m4554a(parcel, 8, this.bFo, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            aus.m4554a(parcel, 9, this.beE, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            aus.m4565c(parcel, 12, this.bFp);
        }
        if (set.contains(Integer.valueOf(14))) {
            aus.m4554a(parcel, 14, this.beB, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            aus.m4548a(parcel, 15, this.bFq, i, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            aus.m4556a(parcel, 16, this.bFr);
        }
        if (set.contains(Integer.valueOf(18))) {
            aus.m4554a(parcel, 18, this.bFs, true);
        }
        if (set.contains(Integer.valueOf(19))) {
            aus.m4548a(parcel, 19, this.bFt, i, true);
        }
        if (set.contains(Integer.valueOf(20))) {
            aus.m4554a(parcel, 20, this.bFu, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            aus.m4565c(parcel, 21, this.bFv);
        }
        if (set.contains(Integer.valueOf(22))) {
            aus.m4566c(parcel, 22, this.bFw, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            aus.m4566c(parcel, 23, this.bFx, true);
        }
        if (set.contains(Integer.valueOf(24))) {
            aus.m4565c(parcel, 24, this.bFy);
        }
        if (set.contains(Integer.valueOf(25))) {
            aus.m4565c(parcel, 25, this.bFz);
        }
        if (set.contains(Integer.valueOf(26))) {
            aus.m4554a(parcel, 26, this.bFA, true);
        }
        if (set.contains(Integer.valueOf(27))) {
            aus.m4554a(parcel, 27, this.bFB, true);
        }
        if (set.contains(Integer.valueOf(28))) {
            aus.m4566c(parcel, 28, this.bFC, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            aus.m4556a(parcel, 29, this.bFD);
        }
        aus.m4540G(parcel, A);
    }
}
