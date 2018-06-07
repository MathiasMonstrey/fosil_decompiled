package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.C1325R;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.fossil.ew;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class LoginClient implements Parcelable {
    public static final Creator<LoginClient> CREATOR = new C14001();
    BackgroundProcessingListener backgroundProcessingListener;
    boolean checkedInternetPermission;
    int currentHandler = -1;
    Fragment fragment;
    LoginMethodHandler[] handlersToTry;
    Map<String, String> loggingExtras;
    private LoginLogger loginLogger;
    OnCompletedListener onCompletedListener;
    Request pendingRequest;

    static class C14001 implements Creator {
        C14001() {
        }

        public LoginClient createFromParcel(Parcel parcel) {
            return new LoginClient(parcel);
        }

        public LoginClient[] newArray(int i) {
            return new LoginClient[i];
        }
    }

    interface BackgroundProcessingListener {
        void onBackgroundProcessingStarted();

        void onBackgroundProcessingStopped();
    }

    public interface OnCompletedListener {
        void onCompleted(Result result);
    }

    public static class Request implements Parcelable {
        public static final Creator<Request> CREATOR = new C14011();
        private final String applicationId;
        private final String authId;
        private final DefaultAudience defaultAudience;
        private String deviceRedirectUriString;
        private boolean isRerequest;
        private final LoginBehavior loginBehavior;
        private Set<String> permissions;

        static class C14011 implements Creator {
            C14011() {
            }

            public Request createFromParcel(Parcel parcel) {
                return new Request(parcel);
            }

            public Request[] newArray(int i) {
                return new Request[i];
            }
        }

        Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String str, String str2) {
            this.isRerequest = false;
            this.loginBehavior = loginBehavior;
            if (set == null) {
                set = new HashSet();
            }
            this.permissions = set;
            this.defaultAudience = defaultAudience;
            this.applicationId = str;
            this.authId = str2;
        }

        Set<String> getPermissions() {
            return this.permissions;
        }

        void setPermissions(Set<String> set) {
            Validate.notNull(set, NativeProtocol.RESULT_ARGS_PERMISSIONS);
            this.permissions = set;
        }

        LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        String getApplicationId() {
            return this.applicationId;
        }

        String getAuthId() {
            return this.authId;
        }

        boolean isRerequest() {
            return this.isRerequest;
        }

        void setRerequest(boolean z) {
            this.isRerequest = z;
        }

        String getDeviceRedirectUriString() {
            return this.deviceRedirectUriString;
        }

        void setDeviceRedirectUriString(String str) {
            this.deviceRedirectUriString = str;
        }

        boolean hasPublishPermission() {
            for (String isPublishPermission : this.permissions) {
                if (LoginManager.isPublishPermission(isPublishPermission)) {
                    return true;
                }
            }
            return false;
        }

        private Request(Parcel parcel) {
            boolean z;
            DefaultAudience defaultAudience = null;
            this.isRerequest = false;
            String readString = parcel.readString();
            this.loginBehavior = readString != null ? LoginBehavior.valueOf(readString) : null;
            Collection arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.permissions = new HashSet(arrayList);
            readString = parcel.readString();
            if (readString != null) {
                defaultAudience = DefaultAudience.valueOf(readString);
            }
            this.defaultAudience = defaultAudience;
            this.applicationId = parcel.readString();
            this.authId = parcel.readString();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.isRerequest = z;
            this.deviceRedirectUriString = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            String str = null;
            parcel.writeString(this.loginBehavior != null ? this.loginBehavior.name() : null);
            parcel.writeStringList(new ArrayList(this.permissions));
            if (this.defaultAudience != null) {
                str = this.defaultAudience.name();
            }
            parcel.writeString(str);
            parcel.writeString(this.applicationId);
            parcel.writeString(this.authId);
            parcel.writeByte((byte) (this.isRerequest ? 1 : 0));
            parcel.writeString(this.deviceRedirectUriString);
        }
    }

    public static class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new C14021();
        final Code code;
        final String errorCode;
        final String errorMessage;
        public Map<String, String> loggingExtras;
        final Request request;
        final AccessToken token;

        static class C14021 implements Creator {
            C14021() {
            }

            public Result createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public Result[] newArray(int i) {
                return new Result[i];
            }
        }

        enum Code {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");
            
            private final String loggingValue;

            private Code(String str) {
                this.loggingValue = str;
            }

            String getLoggingValue() {
                return this.loggingValue;
            }
        }

        Result(Request request, Code code, AccessToken accessToken, String str, String str2) {
            Validate.notNull(code, "code");
            this.request = request;
            this.token = accessToken;
            this.errorMessage = str;
            this.code = code;
            this.errorCode = str2;
        }

        static Result createTokenResult(Request request, AccessToken accessToken) {
            return new Result(request, Code.SUCCESS, accessToken, null, null);
        }

        static Result createCancelResult(Request request, String str) {
            return new Result(request, Code.CANCEL, null, str, null);
        }

        static Result createErrorResult(Request request, String str, String str2) {
            return createErrorResult(request, str, str2, null);
        }

        static Result createErrorResult(Request request, String str, String str2, String str3) {
            return new Result(request, Code.ERROR, null, TextUtils.join(": ", Utility.asListNoNulls(str, str2)), str3);
        }

        private Result(Parcel parcel) {
            this.code = Code.valueOf(parcel.readString());
            this.token = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.errorMessage = parcel.readString();
            this.errorCode = parcel.readString();
            this.request = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readStringMapFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.code.name());
            parcel.writeParcelable(this.token, i);
            parcel.writeString(this.errorMessage);
            parcel.writeString(this.errorCode);
            parcel.writeParcelable(this.request, i);
            Utility.writeStringMapToParcel(parcel, this.loggingExtras);
        }
    }

    public LoginClient(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    void setFragment(Fragment fragment) {
        if (this.fragment != null) {
            throw new FacebookException("Can't set fragment once it is already set.");
        }
        this.fragment = fragment;
    }

    ew getActivity() {
        return this.fragment.getActivity();
    }

    public Request getPendingRequest() {
        return this.pendingRequest;
    }

    public static int getLoginRequestCode() {
        return RequestCodeOffset.Login.toRequestCode();
    }

    void startOrContinueAuth(Request request) {
        if (!getInProgress()) {
            authorize(request);
        }
    }

    void authorize(Request request) {
        if (request != null) {
            if (this.pendingRequest != null) {
                throw new FacebookException("Attempted to authorize while a request is pending.");
            } else if (AccessToken.getCurrentAccessToken() == null || checkInternetPermission()) {
                this.pendingRequest = request;
                this.handlersToTry = getHandlersToTry(request);
                tryNextHandler();
            }
        }
    }

    boolean getInProgress() {
        return this.pendingRequest != null && this.currentHandler >= 0;
    }

    void cancelCurrentHandler() {
        if (this.currentHandler >= 0) {
            getCurrentHandler().cancel();
        }
    }

    LoginMethodHandler getCurrentHandler() {
        if (this.currentHandler >= 0) {
            return this.handlersToTry[this.currentHandler];
        }
        return null;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.pendingRequest != null) {
            return getCurrentHandler().onActivityResult(i, i2, intent);
        }
        return false;
    }

    protected LoginMethodHandler[] getHandlersToTry(Request request) {
        ArrayList arrayList = new ArrayList();
        LoginBehavior loginBehavior = request.getLoginBehavior();
        if (loginBehavior.allowsGetTokenAuth()) {
            arrayList.add(new GetTokenLoginMethodHandler(this));
        }
        if (loginBehavior.allowsKatanaAuth()) {
            arrayList.add(new KatanaProxyLoginMethodHandler(this));
        }
        if (loginBehavior.allowsFacebookLiteAuth()) {
            arrayList.add(new FacebookLiteLoginMethodHandler(this));
        }
        if (loginBehavior.allowsCustomTabAuth()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (loginBehavior.allowsWebViewAuth()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (loginBehavior.allowsDeviceAuth()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        LoginMethodHandler[] loginMethodHandlerArr = new LoginMethodHandler[arrayList.size()];
        arrayList.toArray(loginMethodHandlerArr);
        return loginMethodHandlerArr;
    }

    boolean checkInternetPermission() {
        if (this.checkedInternetPermission) {
            return true;
        }
        if (checkPermission("android.permission.INTERNET") != 0) {
            Activity activity = getActivity();
            complete(Result.createErrorResult(this.pendingRequest, activity.getString(C1325R.string.com_facebook_internet_permission_error_title), activity.getString(C1325R.string.com_facebook_internet_permission_error_message)));
            return false;
        }
        this.checkedInternetPermission = true;
        return true;
    }

    void tryNextHandler() {
        if (this.currentHandler >= 0) {
            logAuthorizationMethodComplete(getCurrentHandler().getNameForLogging(), "skipped", null, null, getCurrentHandler().methodLoggingExtras);
        }
        while (this.handlersToTry != null && this.currentHandler < this.handlersToTry.length - 1) {
            this.currentHandler++;
            if (tryCurrentHandler()) {
                return;
            }
        }
        if (this.pendingRequest != null) {
            completeWithFailure();
        }
    }

    private void completeWithFailure() {
        complete(Result.createErrorResult(this.pendingRequest, "Login attempt failed.", null));
    }

    private void addLoggingExtra(String str, String str2, boolean z) {
        if (this.loggingExtras == null) {
            this.loggingExtras = new HashMap();
        }
        if (this.loggingExtras.containsKey(str) && z) {
            str2 = ((String) this.loggingExtras.get(str)) + "," + str2;
        }
        this.loggingExtras.put(str, str2);
    }

    boolean tryCurrentHandler() {
        boolean z = false;
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (!currentHandler.needsInternetPermission() || checkInternetPermission()) {
            z = currentHandler.tryAuthorize(this.pendingRequest);
            if (z) {
                getLogger().logAuthorizationMethodStart(this.pendingRequest.getAuthId(), currentHandler.getNameForLogging());
            } else {
                getLogger().logAuthorizationMethodNotTried(this.pendingRequest.getAuthId(), currentHandler.getNameForLogging());
                addLoggingExtra("not_tried", currentHandler.getNameForLogging(), true);
            }
        } else {
            addLoggingExtra("no_internet_permission", AppEventsConstants.EVENT_PARAM_VALUE_YES, false);
        }
        return z;
    }

    void completeAndValidate(Result result) {
        if (result.token == null || AccessToken.getCurrentAccessToken() == null) {
            complete(result);
        } else {
            validateSameFbidAndFinish(result);
        }
    }

    void complete(Result result) {
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler != null) {
            logAuthorizationMethodComplete(currentHandler.getNameForLogging(), result, currentHandler.methodLoggingExtras);
        }
        if (this.loggingExtras != null) {
            result.loggingExtras = this.loggingExtras;
        }
        this.handlersToTry = null;
        this.currentHandler = -1;
        this.pendingRequest = null;
        this.loggingExtras = null;
        notifyOnCompleteListener(result);
    }

    OnCompletedListener getOnCompletedListener() {
        return this.onCompletedListener;
    }

    void setOnCompletedListener(OnCompletedListener onCompletedListener) {
        this.onCompletedListener = onCompletedListener;
    }

    BackgroundProcessingListener getBackgroundProcessingListener() {
        return this.backgroundProcessingListener;
    }

    void setBackgroundProcessingListener(BackgroundProcessingListener backgroundProcessingListener) {
        this.backgroundProcessingListener = backgroundProcessingListener;
    }

    int checkPermission(String str) {
        return getActivity().checkCallingOrSelfPermission(str);
    }

    void validateSameFbidAndFinish(Result result) {
        if (result.token == null) {
            throw new FacebookException("Can't validate without a token");
        }
        Result createTokenResult;
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        AccessToken accessToken = result.token;
        if (!(currentAccessToken == null || accessToken == null)) {
            try {
                if (currentAccessToken.getUserId().equals(accessToken.getUserId())) {
                    createTokenResult = Result.createTokenResult(this.pendingRequest, result.token);
                    complete(createTokenResult);
                }
            } catch (Exception e) {
                complete(Result.createErrorResult(this.pendingRequest, "Caught exception", e.getMessage()));
                return;
            }
        }
        createTokenResult = Result.createErrorResult(this.pendingRequest, "User logged in as different Facebook user.", null);
        complete(createTokenResult);
    }

    private static AccessToken createFromTokenWithRefreshedPermissions(AccessToken accessToken, Collection<String> collection, Collection<String> collection2) {
        return new AccessToken(accessToken.getToken(), accessToken.getApplicationId(), accessToken.getUserId(), collection, collection2, accessToken.getSource(), accessToken.getExpires(), accessToken.getLastRefresh());
    }

    private LoginLogger getLogger() {
        if (this.loginLogger == null || !this.loginLogger.getApplicationId().equals(this.pendingRequest.getApplicationId())) {
            this.loginLogger = new LoginLogger(getActivity(), this.pendingRequest.getApplicationId());
        }
        return this.loginLogger;
    }

    private void notifyOnCompleteListener(Result result) {
        if (this.onCompletedListener != null) {
            this.onCompletedListener.onCompleted(result);
        }
    }

    void notifyBackgroundProcessingStart() {
        if (this.backgroundProcessingListener != null) {
            this.backgroundProcessingListener.onBackgroundProcessingStarted();
        }
    }

    void notifyBackgroundProcessingStop() {
        if (this.backgroundProcessingListener != null) {
            this.backgroundProcessingListener.onBackgroundProcessingStopped();
        }
    }

    private void logAuthorizationMethodComplete(String str, Result result, Map<String, String> map) {
        logAuthorizationMethodComplete(str, result.code.getLoggingValue(), result.errorMessage, result.errorCode, map);
    }

    private void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (this.pendingRequest == null) {
            getLogger().logUnexpectedError("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
        } else {
            getLogger().logAuthorizationMethodComplete(this.pendingRequest.getAuthId(), str, str2, str3, str4, map);
        }
    }

    static String getE2E() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public LoginClient(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.handlersToTry = new LoginMethodHandler[readParcelableArray.length];
        for (int i = 0; i < readParcelableArray.length; i++) {
            this.handlersToTry[i] = (LoginMethodHandler) readParcelableArray[i];
            this.handlersToTry[i].setLoginClient(this);
        }
        this.currentHandler = parcel.readInt();
        this.pendingRequest = (Request) parcel.readParcelable(Request.class.getClassLoader());
        this.loggingExtras = Utility.readStringMapFromParcel(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.handlersToTry, i);
        parcel.writeInt(this.currentHandler);
        parcel.writeParcelable(this.pendingRequest, i);
        Utility.writeStringMapToParcel(parcel, this.loggingExtras);
    }
}
