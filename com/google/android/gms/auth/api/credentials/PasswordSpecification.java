package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.fossil.asb;
import com.fossil.auq;
import com.fossil.aus;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification extends auq implements ReflectedParcelable {
    public static final Creator<PasswordSpecification> CREATOR = new asb();
    public static final PasswordSpecification bep = new C4245a().bH(12, 16).cQ("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").m14182o("abcdefghijkmnopqrstxyz", 1).m14182o("ABCDEFGHJKLMNPQRSTXY", 1).m14182o("3456789", 1).JK();
    private static PasswordSpecification beq = new C4245a().bH(12, 16).cQ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").m14182o("abcdefghijklmnopqrstuvwxyz", 1).m14182o("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).m14182o("1234567890", 1).JK();
    private int ber;
    private String bes;
    private List<String> bet;
    private List<Integer> beu;
    private int bev;
    private int bew;
    private final int[] bex;
    private final Random bey;

    public static class C4245a {
        private final List<String> bet = new ArrayList();
        private final List<Integer> beu = new ArrayList();
        private int bev = 12;
        private int bew = 16;
        private final TreeSet<Character> bez = new TreeSet();

        private static TreeSet<Character> m14181K(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new zzb(String.valueOf(str2).concat(" cannot be null or empty"));
            }
            TreeSet<Character> treeSet = new TreeSet();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.m14183A(c, 32, 126)) {
                    throw new zzb(String.valueOf(str2).concat(" must only contain ASCII printable characters"));
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        public final PasswordSpecification JK() {
            if (this.bez.isEmpty()) {
                throw new zzb("no allowed characters specified");
            }
            int i = 0;
            for (Integer intValue : this.beu) {
                i = intValue.intValue() + i;
            }
            if (i > this.bew) {
                throw new zzb("required character count cannot be greater than the max password size");
            }
            boolean[] zArr = new boolean[95];
            for (String toCharArray : this.bet) {
                for (char c : toCharArray.toCharArray()) {
                    if (zArr[c - 32]) {
                        throw new zzb("character " + c + " occurs in more than one required character set");
                    }
                    zArr[c - 32] = true;
                }
            }
            return new PasswordSpecification(1, PasswordSpecification.m14185c(this.bez), this.bet, this.beu, this.bev, this.bew);
        }

        public final C4245a bH(int i, int i2) {
            this.bev = 12;
            this.bew = 16;
            return this;
        }

        public final C4245a cQ(String str) {
            this.bez.addAll(C4245a.m14181K(str, "allowedChars"));
            return this;
        }

        public final C4245a m14182o(String str, int i) {
            this.bet.add(PasswordSpecification.m14185c(C4245a.m14181K(str, "requiredChars")));
            this.beu.add(Integer.valueOf(1));
            return this;
        }
    }

    public static class zzb extends Error {
        public zzb(String str) {
            super(str);
        }
    }

    public PasswordSpecification(int i, String str, List<String> list, List<Integer> list2, int i2, int i3) {
        this.ber = i;
        this.bes = str;
        this.bet = Collections.unmodifiableList(list);
        this.beu = Collections.unmodifiableList(list2);
        this.bev = i2;
        this.bew = i3;
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i4 = 0;
        for (String toCharArray : this.bet) {
            for (char c : toCharArray.toCharArray()) {
                iArr[c - 32] = i4;
            }
            i4++;
        }
        this.bex = iArr;
        this.bey = new SecureRandom();
    }

    private static boolean m14183A(int i, int i2, int i3) {
        return i < 32 || i > 126;
    }

    private static String m14185c(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character charValue : collection) {
            int i2 = i + 1;
            cArr[i] = charValue.charValue();
            i = i2;
        }
        return new String(cArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.a(parcel, 1, this.bes, false);
        aus.b(parcel, 2, this.bet, false);
        aus.a(parcel, 3, this.beu, false);
        aus.c(parcel, 4, this.bev);
        aus.c(parcel, 5, this.bew);
        aus.c(parcel, 1000, this.ber);
        aus.G(parcel, A);
    }
}
