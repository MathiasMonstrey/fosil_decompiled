package com.fossil;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.fossil.arv.C1875c;

public final class axa {
    private static final jv<String, String> biH = new jv();

    public static String m4667A(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C1875c.common_google_play_services_install_button);
            case 2:
                return resources.getString(C1875c.common_google_play_services_update_button);
            case 3:
                return resources.getString(C1875c.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    private static String ar(Context context) {
        CharSequence charSequence;
        String packageName = context.getPackageName();
        try {
            return bje.aQ(context).dL(packageName).toString();
        } catch (NameNotFoundException e) {
            charSequence = context.getApplicationInfo().name;
            return TextUtils.isEmpty(charSequence) ? charSequence : packageName;
        } catch (NullPointerException e2) {
            charSequence = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(charSequence)) {
            }
        }
    }

    private static String m4668c(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String m = m4669m(context, str);
        if (m == null) {
            m = resources.getString(C1875c.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, m, new Object[]{str2});
    }

    private static String m4669m(Context context, String str) {
        synchronized (biH) {
            String str2 = (String) biH.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources al = atq.al(context);
            if (al == null) {
                return null;
            }
            int identifier = al.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String str3 = "GoogleApiAvailability";
                String str4 = "Missing resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            Object string = al.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                str3 = "GoogleApiAvailability";
                str4 = "Got empty resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            biH.put(str, string);
            return string;
        }
    }

    public static String m4670w(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C1875c.common_google_play_services_install_title);
            case 2:
                return resources.getString(C1875c.common_google_play_services_update_title);
            case 3:
                return resources.getString(C1875c.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return m4669m(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return m4669m(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return m4669m(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return m4669m(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    public static String m4671x(Context context, int i) {
        String m = i == 6 ? m4669m(context, "common_google_play_services_resolution_required_title") : m4670w(context, i);
        return m == null ? context.getResources().getString(C1875c.common_google_play_services_notification_ticker) : m;
    }

    public static String m4672y(Context context, int i) {
        Resources resources = context.getResources();
        String ar = ar(context);
        switch (i) {
            case 1:
                return resources.getString(C1875c.common_google_play_services_install_text, new Object[]{ar});
            case 2:
                if (axo.at(context)) {
                    return resources.getString(C1875c.common_google_play_services_wear_update_text);
                }
                return resources.getString(C1875c.common_google_play_services_update_text, new Object[]{ar});
            case 3:
                return resources.getString(C1875c.common_google_play_services_enable_text, new Object[]{ar});
            case 5:
                return m4668c(context, "common_google_play_services_invalid_account_text", ar);
            case 7:
                return m4668c(context, "common_google_play_services_network_error_text", ar);
            case 9:
                return resources.getString(C1875c.common_google_play_services_unsupported_text, new Object[]{ar});
            case 16:
                return m4668c(context, "common_google_play_services_api_unavailable_text", ar);
            case 17:
                return m4668c(context, "common_google_play_services_sign_in_failed_text", ar);
            case 18:
                return resources.getString(C1875c.common_google_play_services_updating_text, new Object[]{ar});
            case 20:
                return m4668c(context, "common_google_play_services_restricted_profile_text", ar);
            default:
                return resources.getString(C1875c.common_google_play_services_unknown_issue, new Object[]{ar});
        }
    }

    public static String m4673z(Context context, int i) {
        return i == 6 ? m4668c(context, "common_google_play_services_resolution_required_text", ar(context)) : m4672y(context, i);
    }
}
