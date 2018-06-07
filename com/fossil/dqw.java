package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.fossil.drk.C3126a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.utils.ReturnCodeRangeChecker;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.ui.notifications.domain.model.ContactWrapper;
import com.portfolio.platform.util.URLHelper;
import com.portfolio.platform.util.URLHelper.StaticPage;

public class dqw {
    public static final String TAG = dqw.class.getSimpleName();

    static class C31112 extends ClickableSpan {
        C31112() {
        }

        public void onClick(View view) {
        }

        public void updateDrawState(TextPaint textPaint) {
            try {
                TextPaint.class.getMethod("setUnderlineText", new Class[]{Integer.TYPE, Float.TYPE}).invoke(textPaint, new Object[]{Integer.valueOf(gn.m10634e(PortfolioApp.ZQ(), R.color.fossilCharcoal)), Float.valueOf(PortfolioApp.ZQ().getResources().getDimension(R.dimen.dp1))});
            } catch (Exception e) {
                textPaint.setUnderlineText(true);
            }
        }
    }

    public static void m9424b(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).cf(R.id.aciv_checked, R.drawable.red_checkmark).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_Title_EMAIL_SENT)).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_Text_Check_your_email_for_a)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).lB(R.id.fb_ok).m9495c(faVar, "FORGOT_PASSWORD");
    }

    public static void m9427c(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Success_Title_All_Done)).cf(R.id.aciv_checked, R.drawable.red_checkmark).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Success_Text_Youre_fully_updated_and_ready)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Signup_Success_CTA_NEXT)).lB(R.id.fb_ok).m9495c(faVar, "DEVICE_CONNECTED");
    }

    public static void m9428d(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.General_Error_Storage_Header_STORAGE_IS_FULL)).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.General_Error_Storage_Text_Your_devices_storage_is_full)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).lB(R.id.fb_ok).m9495c(faVar, "NOTIFICATION_WARNING");
    }

    public static void m9429e(fa faVar) {
        new C3126a(R.layout.dialog_error_permission).lB(R.id.fb_ok).lB(R.id.ftv_go_to_setting).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Permission_Title_Contact_Permission)).m9498w(R.id.ftv_desc, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Permission_Text_This_feature_requires_contact_permission)).m9498w(R.id.ftv_go_to_setting, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Permission_CTA_Go_to_settings)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).m9495c(faVar, "REQUEST_CONTACT_PERMISSION");
    }

    public static void m9430f(fa faVar) {
        new C3126a(R.layout.dialog_error_permission).lB(R.id.fb_ok).lB(R.id.ftv_go_to_setting).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Notifications_Onboarding_Notifications_Header_NOTIFICATION_ACCESS_REQUIRED)).m9498w(R.id.ftv_desc, arp.m4318u(PortfolioApp.ZQ(), R.string.Notifications_Onboarding_Notifications_Text_To_receive_notifications_we_will)).m9498w(R.id.ftv_go_to_setting, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Permission_CTA_Go_to_settings)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Notifications_Onboarding_Notifications_CTA_OK)).m9495c(faVar, "REQUEST_NOTIFICATION_ACCESS");
    }

    public static void m9431g(fa faVar) {
        new C3126a(R.layout.dialog_unsaved_changes).lB(R.id.fb_ok).lB(R.id.fb_cancel).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Feature_Unsaved_Title_UNSAVED_CHANGES)).m9498w(R.id.content_setting, arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Feature_Unsaved_Header_Configure_Settings)).m9498w(R.id.ftv_desc, arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Feature_Unsaved_Text_You_have_unsaved_changes_Canceling)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Feature_Unsaved_CTA_SAVE)).m9498w(R.id.fb_cancel, arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Feature_Unsaved_CTA_CANCEL)).m9496d(faVar, "UNSAVED_CHANGE");
    }

    public static void m9432h(fa faVar) {
        new C3126a(R.layout.dialog_unsaved_changes).lB(R.id.fb_ok).lB(R.id.fb_cancel).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Edit_Unsaved_Title_UNSAVED_CHANGES)).m9498w(R.id.content_setting, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Edit_Unsaved_Header_Configure_Settings)).m9498w(R.id.ftv_desc, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Edit_Unsaved_Text_You_have_unsaved_changes_Canceling)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Edit_Unsaved_CTA_SAVE)).m9498w(R.id.fb_cancel, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Edit_Unsaved_CTA_CANCEL)).m9496d(faVar, "UNSAVED_CHANGE");
    }

    public static void m9433i(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Change_Success_Title_SUCCESS)).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Change_Success_Text_Youve_successfully_changed_your_password)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Change_Success_CTA_OK)).lB(R.id.fb_ok).m9495c(faVar, "PROFILE_CHANGE_PASS_SUCCESS");
    }

    public static void m9434j(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Error_Header_ERROR)).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Error_Text_Something_went_wrong_Try_that)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Change_Success_CTA_OK)).lB(R.id.fb_ok).m9495c(faVar, "GENERAL_ERROR");
    }

    public static void m9435k(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Error_Header_ERROR)).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Error_Unmatched_Your_passwords_do_not_match)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Same_CTA_TRY_AGAIN)).lB(R.id.fb_ok).m9495c(faVar, "PROFILE_CHANGE_PASS_MISMATCH");
    }

    public static void m9436l(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Same_Header_ERROR)).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Same_Text_Your_new_password_cannot_be)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Same_CTA_TRY_AGAIN)).lB(R.id.fb_ok).m9495c(faVar, "PROFILE_CHANGE_PASS_SAME_OLD");
    }

    public static void m9437m(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Error_Header_ERROR)).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Error_Incorrect_Your_password_is_not_correct)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Password_Same_CTA_TRY_AGAIN)).lB(R.id.fb_ok).m9495c(faVar, "PROFILE_CHANGE_PASS_WRONG_OLD");
    }

    public static void m9438n(fa faVar) {
        m9423a(faVar, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Permission_Title_Location_Permission), arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Permission_Text_This_feature_requires_location_services));
    }

    public static void m9439o(fa faVar) {
        m9423a(faVar, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_General_Error_Location_Header_PERMISSION_NEEDED), arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_General_Error_Location_Text_This_feature_requires_location_services_1));
    }

    private static void m9423a(fa faVar, String str, String str2) {
        new C3126a(R.layout.dialog_error_permission).lB(R.id.fb_ok).lB(R.id.ftv_go_to_setting).m9498w(R.id.ftv_title, str).m9498w(R.id.ftv_desc, str2).m9498w(R.id.ftv_go_to_setting, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Permission_CTA_Go_to_settings)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).m9495c(faVar, "REQUEST_LOCATION_SERVICE_PERMISSION");
    }

    public static void m9440p(fa faVar) {
        m9426b(faVar, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Permission_Header_TURN_ON_LOCATION), arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Permission_Text_For_your_devices_low_energy));
    }

    public static void m9441q(fa faVar) {
        m9426b(faVar, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_General_Error_Location_Header_TURN_ON_LOCATION), arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_General_Error_Location_Text_This_feature_requires_location_services));
    }

    private static void m9426b(fa faVar, String str, String str2) {
        new C3126a(R.layout.dialog_error_permission).lB(R.id.fb_ok).lB(R.id.ftv_go_to_setting).m9498w(R.id.ftv_title, str).m9498w(R.id.ftv_desc, str2).m9498w(R.id.ftv_go_to_setting, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Permission_CTA_Go_to_settings)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).m9495c(faVar, "REQUEST_OPEN_LOCATION_SERVICE");
    }

    public static void m9442r(fa faVar) {
        new C3126a(R.layout.dialog_error_permission).lB(R.id.ftv_go_to_setting).lB(R.id.fb_ok).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_General_Error_Bluetooth_Header_TURN_ON_BLUETOOTH)).m9498w(R.id.ftv_desc, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_General_Error_Bluetooth_Text_We_could_not_connect_to)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).m9498w(R.id.ftv_go_to_setting, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Permission_CTA_Go_to_settings)).m9495c(faVar, "BLUETOOTH_OFF");
    }

    public static void m9443s(fa faVar) {
        new C3126a(R.layout.dialog_pair_error).lB(R.id.fb_tryagain).lA(R.id.fb_help).lA(R.id.fb_tryagain).lA(R.id.ftv_desc_2).m9492a(R.id.ftv_desc_2, m9418J(faVar)).lB(R.id.iv_close).m9495c(faVar, "DEVICE_CONNECT_FAILED");
    }

    public static void m9444t(fa faVar) {
        new C3126a(R.layout.dialog_pair_error).lB(R.id.fb_tryagain).lA(R.id.fb_help).lA(R.id.fb_tryagain).lA(R.id.ftv_desc_2).m9492a(R.id.ftv_desc_2, m9418J(faVar)).lB(R.id.iv_close).m9495c(faVar, "NO_DEVICE_FOUND");
    }

    public static void m9445u(fa faVar) {
        new C3126a(R.layout.dialog_set_device_data_error).lB(R.id.fb_tryagain).lB(R.id.fb_help).lB(R.id.iv_close).lA(R.id.ftv_desc_2).m9492a(R.id.ftv_desc_2, m9418J(faVar)).lB(R.id.iv_close).m9495c(faVar, "DEVICE_SET_DATA_FAILED");
    }

    public static void m9446v(fa faVar) {
        new C3126a(R.layout.dialog_set_device_data_error).lB(R.id.fb_tryagain).lB(R.id.fb_help).lB(R.id.iv_close).lA(R.id.ftv_desc_2).lB(R.id.iv_close).m9492a(R.id.ftv_desc_2, m9418J(faVar)).m9495c(faVar, "SYNC_FAILED");
    }

    public static void m9447w(fa faVar) {
        new C3126a(R.layout.activity_pair_device_support).lB(R.id.iv_back).lA(R.id.fb_download_aw).lA(R.id.fb_download_legacy).lA(R.id.fb_help).m9498w(R.id.ftv_legacy_desc, String.format(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Device_Supported_Text_The_brand_app_is_needed), new Object[]{"Fossil Q Legacy"})).cf(R.id.iv_base_background, R.drawable.fs_background).m9495c(faVar, "DEVICE_NOT_SUPPORTED");
    }

    public static void m9421a(fa faVar, String str) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, String.format(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Signup_Success_Title_Thanks_Name), new Object[]{str})).m9498w(R.id.ftv_description, String.format(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Welcome_Title_Welcome_to_BRAND), new Object[]{PortfolioApp.ZQ().getString(R.string.brand_name)})).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Signup_Success_CTA_NEXT)).lB(R.id.fb_ok).m9495c(faVar, "REGISTER_SUCCESS");
    }

    public static void m9425b(fa faVar, String str) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, String.format(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Login_Return_Title_WELCOME_BACK_first_name), new Object[]{str})).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Login_Return_Text_We_missed_you_Pick_up)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Login_Return_CTA_CONTINUE)).lB(R.id.fb_ok).m9495c(faVar, "AUTHENTICATE_SUCCESS");
    }

    public static void m9448x(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Mode_Toggle_Warning_Title_SET_UP_FEATURES)).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Mode_Toggle_Warning_Text_For_all_Mode_Toggle_features)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Shortcuts_Mode_Toggle_Warning_CTA_OK)).lB(R.id.fb_ok).m9495c(faVar, "SHORTCUT_TOGGLE_SET_SUCCESS");
    }

    public static void m9419a(int i, fa faVar) {
        if (ReturnCodeRangeChecker.isSuccessReturnCode(i)) {
            MFLogger.m12670d(TAG, "Response is OK, no need to show error message");
            return;
        }
        switch (i) {
            case MFNetworkReturnCode.INTERNAL_SERVER_ERROR /*500*/:
            case 503:
            case 504:
                m9449y(faVar);
                return;
            case 601:
                m9409A(faVar);
                return;
            default:
                m9450z(faVar);
                return;
        }
    }

    private static void m9449y(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Server_Maintenance_Header_SERVER_MAINTENANCE)).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Server_Maintenance_Text_Our_servers_are_currently_undergoing)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).lB(R.id.fb_ok).m9495c(faVar, "SERVER_MAINTENANCE");
    }

    private static void m9450z(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_General_Error_Network_Header_NETWORK_ERROR)).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_General_Error_Network_Text_There_was_a_problem_processing)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).lB(R.id.fb_ok).m9495c(faVar, "SERVER_ERROR");
    }

    private static void m9409A(fa faVar) {
        new C3126a(R.layout.dialog_error_permission).lB(R.id.fb_ok).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_General_Error_Connection_Header_NETWORK_CONNECTION_NEEDED)).m9498w(R.id.ftv_desc, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_General_Error_Connection_Text_You_need_to_be_connected)).m9498w(R.id.ftv_go_to_setting, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Permission_CTA_Go_to_settings)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).lA(R.id.ftv_go_to_setting).m9495c(faVar, "NO_INTERNET_CONNECTION");
    }

    public static void m9410B(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_BC_Expired_Title_EXPIRED)).m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_BC_Expired_Text_This_challenge_is_no_longer)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).lB(R.id.fb_ok).m9495c(faVar, "INVITATION_EXPIRED_ERROR");
    }

    public static void m9411C(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, "").m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Login_Error_Password_Text_Your_password_must_be_at)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).lB(R.id.fb_ok).m9495c(faVar, "WRONG_FORMAT_PASSWORD");
    }

    public static void m9412D(fa faVar) {
        new C3126a(R.layout.confirm_dialog_fragment).m9498w(R.id.ftv_title, "").m9498w(R.id.ftv_description, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Login_Error_Invalid_Text_Invalid_email_address)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).lB(R.id.fb_ok).m9495c(faVar, "WRONG_FORMAT_EMAIL");
    }

    public static void m9413E(fa faVar) {
        new C3126a(R.layout.dialog_pair_error).lB(R.id.fb_tryagain).lB(R.id.iv_close).lA(R.id.fb_help).lA(R.id.ftv_desc_2).m9498w(R.id.ftv_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Firmware_Error_Update_Header_UPDATE_FAILED)).m9492a(R.id.ftv_desc_2, m9418J(faVar)).m9495c(faVar, "UPDATE_FW_FAIL");
    }

    public static void m9414F(fa faVar) {
        new C3126a(R.layout.dialog_make_decision).m9498w(R.id.ftv_confirm_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Delete_Account_Title_Are_You_Sure)).m9498w(R.id.ftv_confirm_desc, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Delete_Account_Text_Once_You_Delete)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Delete_Account_CTA_Delete)).m9498w(R.id.fb_cancel, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Logout_CTA_Cancel)).lB(R.id.fb_ok).lB(R.id.fb_cancel).m9496d(faVar, "CONFIRM_DELETE_ACCOUNT");
    }

    public static void m9415G(fa faVar) {
        new C3126a(R.layout.dialog_make_decision).m9498w(R.id.ftv_confirm_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Logout_Title_Its_Hard_To_Say_Goodbye)).m9498w(R.id.ftv_confirm_desc, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Logout_Subtitle_Hope_Youll_Be_Back_Soon)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Logout_CTA_Logout)).m9498w(R.id.fb_cancel, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Logout_CTA_Cancel)).lB(R.id.fb_ok).lB(R.id.fb_cancel).m9496d(faVar, "CONFIRM_LOGOUT_ACCOUNT");
    }

    public static void m9420a(fa faVar, ContactWrapper contactWrapper, int i, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("CONFIRM_REASSIGN_CONTACT_POSITION", i3);
        bundle.putSerializable("CONFIRM_REASSIGN_CONTACT_CONTACT_WRAPPER", contactWrapper);
        new C3126a(R.layout.dialog_reassign).m9498w(R.id.ftv_confirm_desc, String.format(arp.m4318u(PortfolioApp.ZQ(), R.string.Notifications_Contacts_Reassign_Text_Do_you_want_to_reassign), new Object[]{contactWrapper.getContact().getDisplayName(), Integer.valueOf(i), Integer.valueOf(i2)})).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).m9498w(R.id.fb_cancel, arp.m4318u(PortfolioApp.ZQ(), R.string.Notifications_Contacts_Reassign_CTA_CANCEL)).lB(R.id.fb_ok).lB(R.id.fb_cancel).m9494a(faVar, "CONFIRM_REASSIGN_CONTACT", bundle);
    }

    public static void m9422a(fa faVar, String str, int i, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("CONFIRM_REASSIGN_APP_POSITION", i3);
        new C3126a(R.layout.dialog_reassign).m9498w(R.id.ftv_confirm_desc, String.format(arp.m4318u(PortfolioApp.ZQ(), R.string.Notifications_Contacts_Reassign_Text_Do_you_want_to_reassign), new Object[]{str, String.valueOf(i), String.valueOf(i2)})).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Account_Forgot_CTA_OK)).m9498w(R.id.fb_cancel, arp.m4318u(PortfolioApp.ZQ(), R.string.Notifications_Contacts_Reassign_CTA_CANCEL)).lB(R.id.fb_ok).lB(R.id.fb_cancel).m9494a(faVar, "CONFIRM_REASSIGN_APP", bundle);
    }

    public static void m9416H(fa faVar) {
        new C3126a(R.layout.dialog_make_decision).m9498w(R.id.ftv_confirm_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Remove_Title_ARE_YOU_SURE)).m9498w(R.id.ftv_confirm_desc, arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Remove_Text_Once_you_delete_your_device)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Remove_CTA_REMOVE)).m9498w(R.id.fb_cancel, arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Remove_CTA_CANCEL)).lB(R.id.fb_ok).lB(R.id.fb_cancel).m9496d(faVar, "CONFIRM_REMOVE_DEVICE");
    }

    public static void m9417I(fa faVar) {
        new C3126a(R.layout.dialog_make_decision).m9498w(R.id.ftv_confirm_title, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Support_Popup_Reset_Tutorials_Title_ARE_YOU_SURE)).m9498w(R.id.ftv_confirm_desc, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Support_Popup_Reset_Tutorials_Text_Completing_this_action_will_reset)).m9498w(R.id.fb_ok, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Support_Popup_Reset_Tutorials_CTA_YES)).m9498w(R.id.fb_cancel, arp.m4318u(PortfolioApp.ZQ(), R.string.Profile_Support_Popup_Reset_Tutorials_CTA_NO)).lB(R.id.fb_ok).lB(R.id.fb_cancel).m9496d(faVar, "CONFIRM_RESET_TUTORIAL");
    }

    public static void bS(Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URLHelper.a(StaticPage.SUPPORT, null))));
    }

    private static SpannableString m9418J(final fa faVar) {
        String u = arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Pair_Error_List_Check_to_see_if_your);
        int indexOf = u.indexOf("<a href=your_device_is_supported_url>");
        u = u.replace("<a href=your_device_is_supported_url>", "");
        int indexOf2 = u.indexOf("</a>");
        u = u.replace("</a>", "");
        SpannableString spannableString = new SpannableString(u);
        C31101 c31101 = new ClickableSpan() {
            public void onClick(View view) {
                dqw.m9447w(faVar);
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
            }
        };
        if (indexOf >= 0 && indexOf2 <= u.length()) {
            spannableString.setSpan(c31101, indexOf, indexOf2, 33);
            spannableString.setSpan(new ForegroundColorSpan(gn.m10634e(PortfolioApp.ZQ(), R.color.fossilCharcoal)), indexOf, indexOf2, 33);
        }
        C31112 c31112 = new C31112();
        if (indexOf >= 0 && indexOf2 <= u.length()) {
            spannableString.setSpan(c31112, indexOf, indexOf2, 33);
        }
        return spannableString;
    }
}
