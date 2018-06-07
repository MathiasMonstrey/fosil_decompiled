package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.fossil.asq;
import com.fossil.asr;
import com.fossil.ate;
import com.fossil.atf;
import com.fossil.ats.a.c;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.awa;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.misfit.frameworks.common.constants.Constants;
import com.portfolio.platform.response.user.MFGetWechatUserInfoResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions extends auq implements c, ReflectedParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new atf();
    private static Comparator<Scope> beM = new ate();
    public static final Scope beN = new Scope("profile");
    public static final Scope beO = new Scope(Constants.EMAIL);
    public static final Scope beP = new Scope(MFGetWechatUserInfoResponse.OPEN_ID);
    private static Scope beQ = new Scope("https://www.googleapis.com/auth/games");
    public static final GoogleSignInOptions beR = new C4246a().JV().JX().JY();
    public static final GoogleSignInOptions beS = new C4246a().m14187a(beQ, new Scope[0]).JY();
    private final ArrayList<Scope> beT;
    private Account beU;
    private boolean beV;
    private final boolean beW;
    private final boolean beX;
    private String beY;
    private String beZ;
    private ArrayList<asq> bfa;
    private Map<Integer, asq> bfb;
    private int versionCode;

    public static final class C4246a {
        private Account beU;
        private boolean beV;
        private boolean beW;
        private boolean beX;
        private String beY;
        private String beZ;
        private Set<Scope> bfc = new HashSet();
        private Map<Integer, asq> bfd = new HashMap();

        public C4246a(GoogleSignInOptions googleSignInOptions) {
            awa.bO(googleSignInOptions);
            this.bfc = new HashSet(googleSignInOptions.beT);
            this.beW = googleSignInOptions.beW;
            this.beX = googleSignInOptions.beX;
            this.beV = googleSignInOptions.beV;
            this.beY = googleSignInOptions.beY;
            this.beU = googleSignInOptions.beU;
            this.beZ = googleSignInOptions.beZ;
            this.bfd = GoogleSignInOptions.m14197y(googleSignInOptions.bfa);
        }

        private final String cV(String str) {
            awa.df(str);
            boolean z = this.beY == null || this.beY.equals(str);
            awa.b(z, "two different server client ids provided");
            return str;
        }

        public final C4246a JV() {
            this.bfc.add(GoogleSignInOptions.beP);
            return this;
        }

        public final C4246a JW() {
            this.bfc.add(GoogleSignInOptions.beO);
            return this;
        }

        public final C4246a JX() {
            this.bfc.add(GoogleSignInOptions.beN);
            return this;
        }

        public final GoogleSignInOptions JY() {
            if (this.beV && (this.beU == null || !this.bfc.isEmpty())) {
                JV();
            }
            return new GoogleSignInOptions(new ArrayList(this.bfc), this.beU, this.beV, this.beW, this.beX, this.beY, this.beZ, this.bfd);
        }

        public final C4246a m14187a(Scope scope, Scope... scopeArr) {
            this.bfc.add(scope);
            this.bfc.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final C4246a cT(String str) {
            this.beV = true;
            this.beY = cV(str);
            return this;
        }

        public final C4246a cU(String str) {
            return m14188j(str, false);
        }

        public final C4246a m14188j(String str, boolean z) {
            this.beW = true;
            this.beY = cV(str);
            this.beX = z;
            return this;
        }
    }

    public GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<asq> arrayList2) {
        this(i, (ArrayList) arrayList, account, z, z2, z3, str, str2, m14197y(arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, asq> map) {
        this.versionCode = i;
        this.beT = arrayList;
        this.beU = account;
        this.beV = z;
        this.beW = z2;
        this.beX = z3;
        this.beY = str;
        this.beZ = str2;
        this.bfa = new ArrayList(map.values());
        this.bfb = map;
    }

    private final JSONObject JS() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.beT, beM);
            ArrayList arrayList = this.beT;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                jSONArray.put(((Scope) obj).KK());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.beU != null) {
                jSONObject.put("accountName", this.beU.name);
            }
            jSONObject.put("idTokenRequested", this.beV);
            jSONObject.put("forceCodeForRefreshToken", this.beX);
            jSONObject.put("serverAuthRequested", this.beW);
            if (!TextUtils.isEmpty(this.beY)) {
                jSONObject.put("serverClientId", this.beY);
            }
            if (!TextUtils.isEmpty(this.beZ)) {
                jSONObject.put("hostedDomain", this.beZ);
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static GoogleSignInOptions cS(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Collection hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        Object optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    private static Map<Integer, asq> m14197y(List<asq> list) {
        Map<Integer, asq> hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (asq com_fossil_asq : list) {
            hashMap.put(Integer.valueOf(com_fossil_asq.getType()), com_fossil_asq);
        }
        return hashMap;
    }

    public final ArrayList<Scope> JT() {
        return new ArrayList(this.beT);
    }

    public final String JU() {
        return JS().toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.bfa.size() > 0 || googleSignInOptions.bfa.size() > 0 || this.beT.size() != googleSignInOptions.JT().size() || !this.beT.containsAll(googleSignInOptions.JT())) {
                return false;
            }
            if (this.beU == null) {
                if (googleSignInOptions.beU != null) {
                    return false;
                }
            } else if (!this.beU.equals(googleSignInOptions.beU)) {
                return false;
            }
            if (TextUtils.isEmpty(this.beY)) {
                if (!TextUtils.isEmpty(googleSignInOptions.beY)) {
                    return false;
                }
            } else if (!this.beY.equals(googleSignInOptions.beY)) {
                return false;
            }
            return this.beX == googleSignInOptions.beX && this.beV == googleSignInOptions.beV && this.beW == googleSignInOptions.beW;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        List arrayList = new ArrayList();
        ArrayList arrayList2 = this.beT;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((Scope) obj).KK());
        }
        Collections.sort(arrayList);
        return new asr().bL(arrayList).bL(this.beU).bL(this.beY).aW(this.beX).aW(this.beV).aW(this.beW).Km();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.c(parcel, 1, this.versionCode);
        aus.c(parcel, 2, JT(), false);
        aus.a(parcel, 3, this.beU, i, false);
        aus.a(parcel, 4, this.beV);
        aus.a(parcel, 5, this.beW);
        aus.a(parcel, 6, this.beX);
        aus.a(parcel, 7, this.beY, false);
        aus.a(parcel, 8, this.beZ, false);
        aus.c(parcel, 9, this.bfa, false);
        aus.G(parcel, A);
    }
}
