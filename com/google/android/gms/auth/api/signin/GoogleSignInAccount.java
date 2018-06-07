package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.fossil.atc;
import com.fossil.atd;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.awa;
import com.fossil.axm;
import com.fossil.axn;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.misfit.frameworks.common.constants.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount extends auq implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new atd();
    private static axm beA = axn.LE();
    private static Comparator<Scope> beM = new atc();
    private String beB;
    private String beC;
    private String beD;
    private String beE;
    private Uri beF;
    private String beG;
    private long beH;
    private String beI;
    private List<Scope> beJ;
    private String beK;
    private String beL;
    private int versionCode;

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.versionCode = i;
        this.beB = str;
        this.beC = str2;
        this.beD = str3;
        this.beE = str4;
        this.beF = uri;
        this.beG = str5;
        this.beH = j;
        this.beI = str6;
        this.beJ = list;
        this.beK = str7;
        this.beL = str8;
    }

    private final JSONObject JS() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (JL() != null) {
                jSONObject.put("tokenId", JL());
            }
            if (getEmail() != null) {
                jSONObject.put(Constants.EMAIL, getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (JM() != null) {
                jSONObject.put("givenName", JM());
            }
            if (JN() != null) {
                jSONObject.put("familyName", JN());
            }
            if (JO() != null) {
                jSONObject.put("photoUrl", JO().toString());
            }
            if (JP() != null) {
                jSONObject.put("serverAuthCode", JP());
            }
            jSONObject.put("expirationTime", this.beH);
            jSONObject.put("obfuscatedIdentifier", this.beI);
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.beJ, beM);
            for (Scope KK : this.beJ) {
                jSONArray.put(KK.KK());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static GoogleSignInAccount cR(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Uri uri = null;
        Object optString = jSONObject.optString("photoUrl", null);
        if (!TextUtils.isEmpty(optString)) {
            uri = Uri.parse(optString);
        }
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.optString("tokenId", null);
        String optString4 = jSONObject.optString(Constants.EMAIL, null);
        String optString5 = jSONObject.optString("displayName", null);
        String optString6 = jSONObject.optString("givenName", null);
        String optString7 = jSONObject.optString("familyName", null);
        Long valueOf = Long.valueOf(parseLong);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, uri, null, (valueOf == null ? Long.valueOf(beA.currentTimeMillis() / 1000) : valueOf).longValue(), awa.df(jSONObject.getString("obfuscatedIdentifier")), new ArrayList((Collection) awa.bO(hashSet)), optString6, optString7);
        googleSignInAccount.beG = jSONObject.optString("serverAuthCode", null);
        return googleSignInAccount;
    }

    public String JL() {
        return this.beC;
    }

    public String JM() {
        return this.beK;
    }

    public String JN() {
        return this.beL;
    }

    public Uri JO() {
        return this.beF;
    }

    public String JP() {
        return this.beG;
    }

    public final String JQ() {
        return this.beI;
    }

    public final String JR() {
        JSONObject JS = JS();
        JS.remove("serverAuthCode");
        return JS.toString();
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).JS().toString().equals(JS().toString());
    }

    public String getDisplayName() {
        return this.beE;
    }

    public String getEmail() {
        return this.beD;
    }

    public String getId() {
        return this.beB;
    }

    public int hashCode() {
        return JS().toString().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.c(parcel, 1, this.versionCode);
        aus.a(parcel, 2, getId(), false);
        aus.a(parcel, 3, JL(), false);
        aus.a(parcel, 4, getEmail(), false);
        aus.a(parcel, 5, getDisplayName(), false);
        aus.a(parcel, 6, JO(), i, false);
        aus.a(parcel, 7, JP(), false);
        aus.a(parcel, 8, this.beH);
        aus.a(parcel, 9, this.beI, false);
        aus.c(parcel, 10, this.beJ, false);
        aus.a(parcel, 11, JM(), false);
        aus.a(parcel, 12, JN(), false);
        aus.G(parcel, A);
    }
}
