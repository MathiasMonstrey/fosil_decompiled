package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.WebDialog;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.OnCompleteListener;
import com.facebook.login.LoginClient.Request;

class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Creator<WebViewLoginMethodHandler> CREATOR = new C14092();
    private String e2e;
    private WebDialog loginDialog;

    static class C14092 implements Creator {
        C14092() {
        }

        public WebViewLoginMethodHandler createFromParcel(Parcel parcel) {
            return new WebViewLoginMethodHandler(parcel);
        }

        public WebViewLoginMethodHandler[] newArray(int i) {
            return new WebViewLoginMethodHandler[i];
        }
    }

    static class AuthDialogBuilder extends Builder {
        private static final String OAUTH_DIALOG = "oauth";
        static final String REDIRECT_URI = "fbconnect://success";
        private String e2e;
        private boolean isRerequest;

        public AuthDialogBuilder(Context context, String str, Bundle bundle) {
            super(context, str, OAUTH_DIALOG, bundle);
        }

        public AuthDialogBuilder setE2E(String str) {
            this.e2e = str;
            return this;
        }

        public AuthDialogBuilder setIsRerequest(boolean z) {
            this.isRerequest = z;
            return this;
        }

        public WebDialog build() {
            Bundle parameters = getParameters();
            parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "fbconnect://success");
            parameters.putString("client_id", getApplicationId());
            parameters.putString("e2e", this.e2e);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            parameters.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE);
            return new WebDialog(getContext(), OAUTH_DIALOG, parameters, getTheme(), getListener());
        }
    }

    WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    String getNameForLogging() {
        return "web_view";
    }

    AccessTokenSource getTokenSource() {
        return AccessTokenSource.WEB_VIEW;
    }

    boolean needsInternetPermission() {
        return true;
    }

    void cancel() {
        if (this.loginDialog != null) {
            this.loginDialog.cancel();
            this.loginDialog = null;
        }
    }

    boolean tryAuthorize(final Request request) {
        Bundle parameters = getParameters(request);
        OnCompleteListener c14081 = new OnCompleteListener() {
            public void onComplete(Bundle bundle, FacebookException facebookException) {
                WebViewLoginMethodHandler.this.onWebDialogComplete(request, bundle, facebookException);
            }
        };
        this.e2e = LoginClient.getE2E();
        addLoggingExtra("e2e", this.e2e);
        Context activity = this.loginClient.getActivity();
        this.loginDialog = new AuthDialogBuilder(activity, request.getApplicationId(), parameters).setE2E(this.e2e).setIsRerequest(request.isRerequest()).setOnCompleteListener(c14081).build();
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.setRetainInstance(true);
        facebookDialogFragment.setDialog(this.loginDialog);
        facebookDialogFragment.show(activity.getSupportFragmentManager(), FacebookDialogFragment.TAG);
        return true;
    }

    void onWebDialogComplete(Request request, Bundle bundle, FacebookException facebookException) {
        super.onComplete(request, bundle, facebookException);
    }

    WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.e2e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.e2e);
    }
}
