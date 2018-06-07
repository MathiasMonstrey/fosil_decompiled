package com.portfolio.platform.data;

import android.text.TextUtils;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public enum NotificationType {
    CONTACT(R.string.notifications_section_contacts),
    CODE_WORD(R.string.notifications_section_code_words),
    CALL(R.string.activity_contact_detail_calls),
    SMS(R.string.activity_contact_detail_texts),
    EMAIL(R.string.Onboarding_Account_Login_Email_Input_Email),
    APP_FILTER(R.string.notifications_section_apps),
    FITNESS_GOAL_ACHIEVED(R.string.notifications_section_fitness),
    APP_MODE(R.string.notifications_app_mode),
    OTHER(R.string.notification_other),
    CONTACT_EMPTY(R.string.notifications_contact_empty_message),
    APP_EMPTY(R.string.notifications_app_empty_message);
    
    private int sectionTitleResId;

    private NotificationType(int i) {
        this.sectionTitleResId = i;
    }

    public int getSectionTitleResId() {
        return this.sectionTitleResId;
    }

    public String getSectionTitleString() {
        return PortfolioApp.ZQ().getString(this.sectionTitleResId);
    }

    public static NotificationType find(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return valueOf(str);
    }
}
