package com.fossil;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class cnr {
    private SharedPreferences cAe;
    private SharedPreferences cAf;
    private SharedPreferences cAg;
    private SharedPreferences cAh;
    private SharedPreferences cAi;
    private SharedPreferences cAj;
    private SharedPreferences cAk;
    private SharedPreferences cAl;
    private final UserRepository mUserRepository;

    class C22311 extends cgu<HashMap<CommunicateMode, Long>> {
        final /* synthetic */ cnr cAm;

        C22311(cnr com_fossil_cnr) {
            this.cAm = com_fossil_cnr;
        }
    }

    class C22322 extends cgu<HashMap<CommunicateMode, Long>> {
        final /* synthetic */ cnr cAm;

        C22322(cnr com_fossil_cnr) {
            this.cAm = com_fossil_cnr;
        }
    }

    public cnr(Context context, UserRepository userRepository) {
        this.cAe = context.getSharedPreferences("PREFERENCE_DEVICE", 0);
        this.cAf = context.getSharedPreferences("PREFERENCE_AUTH", 0);
        this.cAg = context.getSharedPreferences("PREFERENCE_ONBOARDING", 0);
        this.cAh = context.getSharedPreferences("PREFERENCE_MIGRATE", 0);
        this.cAi = context.getSharedPreferences("PREFERENCE_BUDDY_CHALLENGE", 0);
        this.cAj = context.getSharedPreferences("PREFERENCE_CONNECTED_APPS", 0);
        this.cAl = context.getSharedPreferences("project_fossil_wearables_fossil", 0);
        this.mUserRepository = userRepository;
        this.cAk = context.getSharedPreferences("PREFERENCE_APPS", 0);
    }

    private void m7229a(SharedPreferences sharedPreferences, String str, int i) {
        sharedPreferences.edit().putInt(str, i).apply();
    }

    private int m7232b(SharedPreferences sharedPreferences, String str, int i) {
        return sharedPreferences.getInt(str, i);
    }

    private void m7230a(SharedPreferences sharedPreferences, String str, long j) {
        sharedPreferences.edit().putLong(str, j).apply();
    }

    private long m7233b(SharedPreferences sharedPreferences, String str, long j) {
        return sharedPreferences.getLong(str, j);
    }

    private void m7234b(SharedPreferences sharedPreferences, String str, String str2) {
        sharedPreferences.edit().putString(str, str2).apply();
    }

    private void m7228a(SharedPreferences sharedPreferences, String str) {
        sharedPreferences.edit().remove(str).apply();
    }

    private String m7236c(SharedPreferences sharedPreferences, String str, String str2) {
        return sharedPreferences.getString(str, str2);
    }

    private boolean m7231a(SharedPreferences sharedPreferences, String str, boolean z) {
        return sharedPreferences.getBoolean(str, z);
    }

    private void m7235b(SharedPreferences sharedPreferences, String str, boolean z) {
        sharedPreferences.edit().putBoolean(str, z).apply();
    }

    public void gx(String str) {
        m7234b(this.cAe, "active_device_address", str);
    }

    public String getActiveDeviceId() {
        return m7236c(this.cAe, "active_device_address", "");
    }

    public void gy(String str) {
        m7234b(this.cAe, "installation_id_android", str);
    }

    public void gz(String str) {
        m7234b(this.cAe, "KEY_FIREBASE_TOKEN", str);
    }

    public String acC() {
        return m7236c(this.cAe, "KEY_FIREBASE_TOKEN", "");
    }

    public void bR(boolean z) {
        m7235b(this.cAe, "skipOta", z);
    }

    public boolean acD() {
        return m7231a(this.cAe, "skipOta", false);
    }

    public void bS(boolean z) {
        m7235b(this.cAe, "consider_bundle_firmware_as_latest", z);
    }

    public boolean acE() {
        return m7231a(this.cAe, "consider_bundle_firmware_as_latest", false);
    }

    public void bT(boolean z) {
        m7235b(this.cAe, "showAllDevices", z);
    }

    public boolean acF() {
        return m7231a(this.cAe, "showAllDevices", false);
    }

    public void bU(boolean z) {
        m7235b(this.cAe, "HWLogSyncEnable", z);
    }

    public boolean acG() {
        return m7231a(this.cAe, "HWLogSyncEnable", true);
    }

    public void bV(boolean z) {
        m7235b(this.cAe, "AutoSyncEnable", z);
    }

    public boolean acH() {
        return m7231a(this.cAe, "AutoSyncEnable", true);
    }

    public String acI() {
        return m7236c(this.cAe, "realTimeStepTimeStamp_", "");
    }

    public void gA(String str) {
        m7234b(this.cAe, "realTimeStepTimeStamp_", str);
    }

    public long gB(String str) {
        return m7233b(this.cAe, "lastSyncTime" + str, 0);
    }

    public void m7244c(long j, String str) {
        m7230a(this.cAe, "lastSyncTime" + str, j);
    }

    public long gC(String str) {
        return m7233b(this.cAe, "lastSyncTimeSuccess" + str, 0);
    }

    public void m7246d(long j, String str) {
        m7230a(this.cAe, "lastSyncTimeSuccess" + str, j);
    }

    public long acJ() {
        return m7233b(this.cAe, "lastHWSyncTime", 0);
    }

    public void aG(long j) {
        m7230a(this.cAe, "lastHWSyncTime", j);
    }

    public String acK() {
        return m7236c(this.cAe, "KEY_SHORTCUT_DOWNLOADING_STATE", "INIT_STATUS");
    }

    public void gD(String str) {
        m7234b(this.cAe, "KEY_SHORTCUT_DOWNLOADING_STATE", str);
    }

    public void m7238A(String str, int i) {
        MFLogger.m12670d("SharedPreferencesManager", "setVibrationStrength - serial=" + str + ", vibeStrengthLevel=" + i);
        m7229a(this.cAe, "PREFS_VIBRATION_STRENGTH" + str, i);
    }

    public int gE(String str) {
        return m7232b(this.cAe, "PREFS_VIBRATION_STRENGTH" + str, 25);
    }

    public HashMap<CommunicateMode, Long> acL() {
        String c = m7236c(this.cAe, "PREFS_BLE_RESULT_TIME_STAMP", "");
        HashMap<CommunicateMode, Long> hashMap = new HashMap();
        if (TextUtils.isEmpty(c)) {
            return hashMap;
        }
        try {
            return (HashMap) new cfj().m6197a(c, new C22311(this).getType());
        } catch (Exception e) {
            return new HashMap();
        }
    }

    public void m7245c(HashMap<CommunicateMode, Long> hashMap) {
        if (hashMap != null) {
            m7234b(this.cAe, "PREFS_BLE_RESULT_TIME_STAMP", new cfj().m6204b(hashMap, new C22322(this).getType()));
        }
    }

    public void m7248o(String str, boolean z) {
        m7235b(this.cAe, "calibrationState_" + str + cnq.acd().acz(), z);
    }

    public boolean gF(String str) {
        return m7236c(this.cAe, "FULL_SYNC_DEVICE", "").startsWith(str);
    }

    public void m7241a(String str, long j, boolean z) {
        m7234b(this.cAe, "FULL_SYNC_DEVICE", z ? str + j : "");
    }

    public void setUserAccessToken(String str) {
        m7234b(this.cAf, "USER_ACCESS_TOKEN", str);
    }

    public String getUserAccessToken() {
        return m7236c(this.cAf, "USER_ACCESS_TOKEN", "");
    }

    public void gG(String str) {
        m7234b(this.cAf, "FACEBOOK_ACCESS_TOKEN", str);
    }

    public String acM() {
        return m7236c(this.cAf, "FACEBOOK_ACCESS_TOKEN", "");
    }

    public void gH(String str) {
        m7234b(this.cAf, "GOOGLE_ACCESS_TOKEN", str);
    }

    public String acN() {
        return m7236c(this.cAf, "GOOGLE_ACCESS_TOKEN", "");
    }

    public void gI(String str) {
        m7234b(this.cAf, "WECHAT_ACCESS_TOKEN", str);
    }

    public String acO() {
        return m7236c(this.cAf, "WECHAT_ACCESS_TOKEN", "");
    }

    public void gJ(String str) {
        m7234b(this.cAf, "WEIBO_ACCESS_TOKEN", str);
    }

    public String acP() {
        return m7236c(this.cAf, "WEIBO_ACCESS_TOKEN", "");
    }

    public void gK(String str) {
        m7234b(this.cAf, "KEY_UN_PUSHED_AUTH_EVENT", str);
    }

    public String acQ() {
        return m7236c(this.cAf, "KEY_UN_PUSHED_AUTH_EVENT", "");
    }

    public int acR() {
        return m7232b(this.cAg, "KEY_ONBOARDING_STATS", 0);
    }

    public void jF(int i) {
        m7229a(this.cAg, "KEY_ONBOARDING_STATS", i);
    }

    public void jG(int i) {
        m7229a(this.cAg, "KEY_CURRENT_DASHBOARD_TAB_POS", i);
    }

    public void bW(boolean z) {
        m7235b(this.cAg, "KEY_TOOLTIP_MAIN_NOTIFICATION", z);
    }

    public boolean acS() {
        return m7231a(this.cAg, "KEY_TOOLTIP_MAIN_NOTIFICATION", false);
    }

    public void bX(boolean z) {
        m7235b(this.cAg, "KEY_TOOLTIP_CALL_NOTIFICATION", z);
    }

    public boolean acT() {
        return m7231a(this.cAg, "KEY_TOOLTIP_CALL_NOTIFICATION", false);
    }

    public void bY(boolean z) {
        m7235b(this.cAg, "KEY_TOOLTIP_ADD_NOTIFICATION", z);
    }

    public boolean acU() {
        return m7231a(this.cAg, "KEY_TOOLTIP_ADD_NOTIFICATION", false);
    }

    String acV() {
        return m7236c(this.cAl, "KEY_LOW_BATTERY_DEVICE", "");
    }

    public String acW() {
        return m7236c(this.cAe, "KEY_LOW_BATTERY_DEVICE", "");
    }

    public void gL(String str) {
        m7234b(this.cAe, "KEY_LOW_BATTERY_DEVICE", str);
    }

    int acX() {
        return m7232b(this.cAl, "KEY_DEBUG_REPLACE_BATTERY_LEVEL", 25);
    }

    public int acY() {
        return m7232b(this.cAe, "KEY_DEBUG_REPLACE_BATTERY_LEVEL", 25);
    }

    public void jH(int i) {
        m7229a(this.cAe, "KEY_DEBUG_REPLACE_BATTERY_LEVEL", i);
    }

    public void m7249p(String str, boolean z) {
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser != null) {
            m7235b(this.cAe, str + currentUser.getUserId(), z);
        }
    }

    private boolean m7237q(String str, boolean z) {
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser != null) {
            return m7231a(this.cAe, str + currentUser.getUserId(), z);
        }
        return z;
    }

    public boolean bA(Context context) {
        return m7237q("enable_alarm", false);
    }

    public void m7247i(Context context, boolean z) {
        m7249p("enable_alarm", z);
    }

    public boolean acZ() {
        return m7231a(this.cAh, "KEY_IS_MIGRATED_ALARMS_SETTING_VERSION_1_2_0", true);
    }

    public void bZ(boolean z) {
        m7235b(this.cAh, "KEY_IS_MIGRATED_ALARMS_SETTING_VERSION_1_2_0", z);
    }

    public boolean ada() {
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser == null || !this.cAe.contains("KEY_PUSH_NOTIFICATIONS" + currentUser.getUserId())) {
            return m7231a(this.cAe, "KEY_PUSH_NOTIFICATIONS", true);
        }
        return m7231a(this.cAe, "KEY_PUSH_NOTIFICATIONS" + currentUser.getUserId(), true);
    }

    public void av(String str, String str2) {
        m7234b(this.cAe, "tempDeviceFirmwareInfo_" + str, str2);
    }

    public String gM(String str) {
        return m7236c(this.cAe, "tempDeviceFirmwareInfo_" + str, "");
    }

    public void gN(String str) {
        m7228a(this.cAe, "tempDeviceFirmwareInfo_" + str);
    }

    public void gO(String str) {
        m7234b(this.cAj, "u56n_45nt", str);
    }

    public String adb() {
        return m7236c(this.cAj, "u56n_45nt", "");
    }

    public void gP(String str) {
        m7234b(this.cAj, "eh4j_fg34", str);
    }

    public String adc() {
        return m7236c(this.cAj, "eh4j_fg34", "");
    }

    public void ca(boolean z) {
        m7235b(this.cAg, "KEY_SHOW_SHORTCUT_TOOLTIPS", z);
    }

    public boolean add() {
        return this.cAg.getBoolean("KEY_SHOW_SHORTCUT_TOOLTIPS", false);
    }

    public boolean gQ(String str) {
        return this.cAe.getBoolean("KEY_PAIR_COMPLETE_DEVICE" + str, false);
    }

    public void m7251r(String str, boolean z) {
        m7235b(this.cAe, "KEY_PAIR_COMPLETE_DEVICE" + str, z);
    }

    public boolean ade() {
        return this.cAe.getBoolean("KEY_IS_DEVICE_LOCATE_ENABLE", false);
    }

    public void cb(boolean z) {
        m7235b(this.cAe, "KEY_IS_DEVICE_LOCATE_ENABLE", z);
    }

    public String adf() {
        return this.cAh.getString("KEY_USER_LAST_APP_VERSION_NAME_Q", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
    }

    public void gR(String str) {
        m7234b(this.cAh, "KEY_USER_LAST_APP_VERSION_NAME_Q", str);
    }

    public String adg() {
        return this.cAl.getString("active_device_address", "");
    }

    public boolean adh() {
        return this.cAl.getBoolean("KEY_ENABLE_FIND_MY_DEVICE", false);
    }

    public boolean adi() {
        return this.cAg.getBoolean("KEY_DEVICE_LOCATE_NEED_WARNING", true);
    }

    public void cc(boolean z) {
        m7235b(this.cAi, "KEY_BUDDY_CHALLENGE_DEBUG", z);
    }

    public boolean adj() {
        return m7231a(this.cAi, "KEY_BUDDY_CHALLENGE_DEBUG", false);
    }

    public void m7240a(String str, int i, Date date) {
        if (this.mUserRepository.getCurrentUser() != null) {
            m7234b(this.cAe, String.format(Locale.US, "KEY_GOAL_TRACKING_CELEBRATION_DATE:%s:%s", new Object[]{this.mUserRepository.getCurrentUser().getUserId(), str}), cmq.m7124f(date));
        }
    }

    public Date m7239B(String str, int i) {
        if (this.mUserRepository.getCurrentUser() == null) {
            return Calendar.getInstance().getTime();
        }
        Object c = m7236c(this.cAe, String.format(Locale.US, "KEY_GOAL_TRACKING_CELEBRATION_DATE:%s:%s", new Object[]{this.mUserRepository.getCurrentUser().getUserId(), str}), "");
        if (TextUtils.isEmpty(c)) {
            return new Date(0);
        }
        return cmq.fX(c);
    }

    public boolean adk() {
        return m7231a(this.cAe, "KEY_IS_SHOWED_POPUP_LEGACY_BEFORE", false);
    }

    public void cd(boolean z) {
        m7235b(this.cAe, "KEY_IS_SHOWED_POPUP_LEGACY_BEFORE", z);
    }

    public boolean adl() {
        return m7231a(this.cAe, "KEY_NEED_TO_SHOW_LEGACY_POPUP", false);
    }

    public void ce(boolean z) {
        m7235b(this.cAe, "KEY_NEED_TO_SHOW_LEGACY_POPUP", z);
    }

    public boolean gS(String str) {
        return m7231a(this.cAk, "KEY_MIGRATION_COMPLETE" + str, false);
    }

    public void m7242a(boolean z, String str) {
        m7235b(this.cAk, "KEY_MIGRATION_COMPLETE" + str, z);
    }

    public boolean gT(String str) {
        return m7231a(this.cAk, "KEY_MIGRATION_STARTED_YET" + str, false);
    }

    public void m7243b(boolean z, String str) {
        m7235b(this.cAk, "KEY_MIGRATION_STARTED_YET" + str, z);
    }

    public int gU(String str) {
        return m7232b(this.cAe, "KEY_APP_SYNC_STATE" + str, 3);
    }

    public void m7250r(int i, String str) {
        m7229a(this.cAe, "KEY_APP_SYNC_STATE" + str, i);
    }

    public void jI(int i) {
        MFLogger.m12670d("SharedPreferencesManager", "setAppDataVersion - appDataVersion=" + i);
        m7229a(this.cAk, "KEY_USER_LAST_DATA_VERSION", i);
    }

    public void jJ(int i) {
        MFLogger.m12670d("SharedPreferencesManager", "setKeyUsingSwitchUrlSetting - keyUsingSwitchUrlSetting=" + i);
        m7229a(this.cAk, "KEY_USING_SWITCH_URL_SETTING", i);
    }

    public int adm() {
        return m7232b(this.cAk, "KEY_USING_SWITCH_URL_SETTING", 0);
    }

    public boolean adn() {
        return m7231a(this.cAk, "KEY_NEED_TO_UPDATE_BLE_WHEN_UPGRADE_LEGACY", false);
    }

    public void cf(boolean z) {
        MFLogger.m12670d("SharedPreferencesManager", "setIsNeedToUpdateBLEWhenUpgradeLegacy - isNeedToUpdate=" + z);
        m7235b(this.cAk, "KEY_NEED_TO_UPDATE_BLE_WHEN_UPGRADE_LEGACY", z);
    }

    public void cg(boolean z) {
        MFLogger.m12670d("SharedPreferencesManager", "setIsNeedRemoveRedundantContact - isNeed=" + z);
        m7235b(this.cAk, "KEY_NEED_REMOVE_REDUNDANT_CONTACT", z);
    }

    public void ch(boolean z) {
        MFLogger.m12670d("SharedPreferencesManager", "setIsRegisteredContactObserver - isSet=" + z);
        m7235b(this.cAk, "KEY_IS_REGISTER_CONTACT_OBSERVER", z);
    }

    public boolean ado() {
        return m7231a(this.cAk, "KEY_IS_REGISTER_CONTACT_OBSERVER", false);
    }

    public void reset() {
        this.cAe.edit().clear().apply();
        this.cAf.edit().clear().apply();
        this.cAg.edit().clear().apply();
        this.cAi.edit().clear().apply();
    }

    public void adp() {
        this.cAg.edit().clear().apply();
    }
}
