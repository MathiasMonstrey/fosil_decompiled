package com.fossil;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.portfolio.platform.enums.Gender;

public class dqz {
    private static final String TAG = dqz.class.getSimpleName();
    private static dqz dfa;

    public void m9451F(Context context, String str) {
        setString(context, "com.misfit.frameworks.profile.baseUrl", str);
    }

    public String bT(Context context) {
        return getString(context, "com.misfit.frameworks.profile.href");
    }

    public String bU(Context context) {
        return getString(context, "com.misfit.frameworks.profile.createdAt");
    }

    public String bV(Context context) {
        return getString(context, "com.misfit.frameworks.profile.updateAt");
    }

    public boolean bW(Context context) {
        return Boolean.valueOf(getString(context, "com.misfit.frameworks.profile.emailOptIn")).booleanValue();
    }

    public boolean bX(Context context) {
        return Boolean.valueOf(getString(context, "com.misfit.frameworks.profile.emailProgress")).booleanValue();
    }

    public String bY(Context context) {
        return getString(context, "com.misfit.frameworks.profile.email");
    }

    public String bZ(Context context) {
        return getString(context, "com.misfit.frameworks.profile.height");
    }

    public String ca(Context context) {
        return getString(context, "com.misfit.frameworks.profile.weight");
    }

    public String cb(Context context) {
        return getString(context, "com.misfit.frameworks.profile.profilePic");
    }

    public String cc(Context context) {
        return getString(context, "com.misfit.frameworks.profile.registration");
    }

    public String cd(Context context) {
        return getString(context, "com.misfit.frameworks.profile.registerDate");
    }

    public String ce(Context context) {
        return getString(context, "com.misfit.frameworks.profile.integrations");
    }

    public String cf(Context context) {
        return getString(context, "com.misfit.frameworks.profile.authType");
    }

    public Gender cg(Context context) {
        return Gender.fromString(getString(context, "com.misfit.frameworks.profile.gender"));
    }

    public String ch(Context context) {
        return getString(context, "com.misfit.frameworks.profile.units.height");
    }

    public String ci(Context context) {
        return getString(context, "com.misfit.frameworks.profile.units.weight");
    }

    public String cj(Context context) {
        return getString(context, "com.misfit.frameworks.profile.units.distance");
    }

    public String ck(Context context) {
        return getString(context, "com.misfit.frameworks.profile.birthday");
    }

    public String cl(Context context) {
        return getString(context, "com.misfit.frameworks.profile.firstname");
    }

    public String cm(Context context) {
        return getString(context, "com.misfit.frameworks.profile.lastname");
    }

    public String cn(Context context) {
        return getString(context, "com.misfit.frameworks.profile.userObjectId");
    }

    public String co(Context context) {
        return getString(context, "com.misfit.frameworks.profile.userId");
    }

    public String cp(Context context) {
        return getString(context, "com.misfit.frameworks.profile.accessToken");
    }

    public boolean cq(Context context) {
        Object string = getString(context, "com.misfit.frameworks.onboarding.all");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return Boolean.valueOf(string).booleanValue();
    }

    public boolean cr(Context context) {
        return m9452f(context, "com.misfit.frameworks.profile.diagnosticEnable", true);
    }

    public String cs(Context context) {
        return getString(context, "com.misfit.frameworks.profile.baseUrl");
    }

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(Constants.FRAMEWORKS_SHAREPREFS, 0);
    }

    public static synchronized dqz aum() {
        dqz com_fossil_dqz;
        synchronized (dqz.class) {
            if (dfa == null) {
                dfa = new dqz();
            }
            com_fossil_dqz = dfa;
        }
        return com_fossil_dqz;
    }

    public String getString(Context context, String str) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            return preferences.getString(str, "");
        }
        return "";
    }

    public boolean m9452f(Context context, String str, boolean z) {
        SharedPreferences preferences = getPreferences(context);
        return preferences != null && preferences.getBoolean(str, z);
    }

    public void setString(Context context, String str, String str2) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Editor edit = preferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }
}
