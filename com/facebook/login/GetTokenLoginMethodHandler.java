package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Creator<GetTokenLoginMethodHandler> CREATOR = new C13983();
    private GetTokenClient getTokenClient;

    static class C13983 implements Creator {
        C13983() {
        }

        public GetTokenLoginMethodHandler createFromParcel(Parcel parcel) {
            return new GetTokenLoginMethodHandler(parcel);
        }

        public GetTokenLoginMethodHandler[] newArray(int i) {
            return new GetTokenLoginMethodHandler[i];
        }
    }

    GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    String getNameForLogging() {
        return "get_token";
    }

    void cancel() {
        if (this.getTokenClient != null) {
            this.getTokenClient.cancel();
            this.getTokenClient.setCompletedListener(null);
            this.getTokenClient = null;
        }
    }

    boolean tryAuthorize(final Request request) {
        this.getTokenClient = new GetTokenClient(this.loginClient.getActivity(), request.getApplicationId());
        if (!this.getTokenClient.start()) {
            return false;
        }
        this.loginClient.notifyBackgroundProcessingStart();
        this.getTokenClient.setCompletedListener(new CompletedListener() {
            public void completed(Bundle bundle) {
                GetTokenLoginMethodHandler.this.getTokenCompleted(request, bundle);
            }
        });
        return true;
    }

    void getTokenCompleted(Request request, Bundle bundle) {
        if (this.getTokenClient != null) {
            this.getTokenClient.setCompletedListener(null);
        }
        this.getTokenClient = null;
        this.loginClient.notifyBackgroundProcessingStop();
        if (bundle != null) {
            ArrayList stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            Object<String> permissions = request.getPermissions();
            if (stringArrayList == null || !(permissions == null || stringArrayList.containsAll(permissions))) {
                Object hashSet = new HashSet();
                for (String str : permissions) {
                    if (!stringArrayList.contains(str)) {
                        hashSet.add(str);
                    }
                }
                if (!hashSet.isEmpty()) {
                    addLoggingExtra("new_permissions", TextUtils.join(",", hashSet));
                }
                request.setPermissions(hashSet);
            } else {
                complete(request, bundle);
                return;
            }
        }
        this.loginClient.tryNextHandler();
    }

    void onComplete(Request request, Bundle bundle) {
        this.loginClient.completeAndValidate(Result.createTokenResult(this.loginClient.getPendingRequest(), LoginMethodHandler.createAccessTokenFromNativeLogin(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.getApplicationId())));
    }

    void complete(final Request request, final Bundle bundle) {
        String string = bundle.getString(NativeProtocol.EXTRA_USER_ID);
        if (string == null || string.isEmpty()) {
            this.loginClient.notifyBackgroundProcessingStart();
            Utility.getGraphMeRequestWithCacheAsync(bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN), new GraphMeRequestWithCacheCallback() {
                public void onSuccess(JSONObject jSONObject) {
                    try {
                        bundle.putString(NativeProtocol.EXTRA_USER_ID, jSONObject.getString("id"));
                        GetTokenLoginMethodHandler.this.onComplete(request, bundle);
                    } catch (JSONException e) {
                        GetTokenLoginMethodHandler.this.loginClient.complete(Result.createErrorResult(GetTokenLoginMethodHandler.this.loginClient.getPendingRequest(), "Caught exception", e.getMessage()));
                    }
                }

                public void onFailure(FacebookException facebookException) {
                    GetTokenLoginMethodHandler.this.loginClient.complete(Result.createErrorResult(GetTokenLoginMethodHandler.this.loginClient.getPendingRequest(), "Caught exception", facebookException.getMessage()));
                }
            });
            return;
        }
        onComplete(request, bundle);
    }

    GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
