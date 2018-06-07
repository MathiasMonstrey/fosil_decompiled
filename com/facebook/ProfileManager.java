package com.facebook;

import android.content.Intent;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.fossil.gy;

final class ProfileManager {
    static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    private static volatile ProfileManager instance;
    private Profile currentProfile;
    private final gy localBroadcastManager;
    private final ProfileCache profileCache;

    ProfileManager(gy gyVar, ProfileCache profileCache) {
        Validate.notNull(gyVar, "localBroadcastManager");
        Validate.notNull(profileCache, "profileCache");
        this.localBroadcastManager = gyVar;
        this.profileCache = profileCache;
    }

    static ProfileManager getInstance() {
        if (instance == null) {
            synchronized (ProfileManager.class) {
                if (instance == null) {
                    instance = new ProfileManager(gy.m11536p(FacebookSdk.getApplicationContext()), new ProfileCache());
                }
            }
        }
        return instance;
    }

    Profile getCurrentProfile() {
        return this.currentProfile;
    }

    boolean loadCurrentProfile() {
        Profile load = this.profileCache.load();
        if (load == null) {
            return false;
        }
        setCurrentProfile(load, false);
        return true;
    }

    void setCurrentProfile(Profile profile) {
        setCurrentProfile(profile, true);
    }

    private void setCurrentProfile(Profile profile, boolean z) {
        Profile profile2 = this.currentProfile;
        this.currentProfile = profile;
        if (z) {
            if (profile != null) {
                this.profileCache.save(profile);
            } else {
                this.profileCache.clear();
            }
        }
        if (!Utility.areObjectsEqual(profile2, profile)) {
            sendCurrentProfileChangedBroadcast(profile2, profile);
        }
    }

    private void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
        intent.putExtra(EXTRA_OLD_PROFILE, profile);
        intent.putExtra(EXTRA_NEW_PROFILE, profile2);
        this.localBroadcastManager.m11538b(intent);
    }
}
