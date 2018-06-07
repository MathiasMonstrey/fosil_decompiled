package com.facebook.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.C1325R;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.PermissionsPair;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient.Request;
import com.fossil.ev;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class DeviceAuthDialog extends ev {
    private static final String DEVICE_LOGIN_ENDPOINT = "device/login";
    private static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;
    private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
    private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
    private static final String REQUEST_STATE_KEY = "request_state";
    private AtomicBoolean completed = new AtomicBoolean();
    private TextView confirmationCode;
    private volatile GraphRequestAsyncTask currentGraphRequestPoll;
    private volatile RequestState currentRequestState;
    private DeviceAuthMethodHandler deviceAuthMethodHandler;
    private Dialog dialog;
    private boolean isBeingDestroyed = false;
    private ProgressBar progressBar;
    private volatile ScheduledFuture scheduledPoll;

    class C13881 implements OnClickListener {
        C13881() {
        }

        public void onClick(View view) {
            DeviceAuthDialog.this.onCancel();
        }
    }

    class C13892 implements Callback {
        C13892() {
        }

        public void onCompleted(GraphResponse graphResponse) {
            if (graphResponse.getError() != null) {
                DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                return;
            }
            JSONObject jSONObject = graphResponse.getJSONObject();
            RequestState requestState = new RequestState();
            try {
                requestState.setUserCode(jSONObject.getString("user_code"));
                requestState.setRequestCode(jSONObject.getString("code"));
                requestState.setInterval(jSONObject.getLong("interval"));
                DeviceAuthDialog.this.setCurrentRequestState(requestState);
            } catch (Throwable e) {
                DeviceAuthDialog.this.onError(new FacebookException(e));
            }
        }
    }

    class C13903 implements Runnable {
        C13903() {
        }

        public void run() {
            DeviceAuthDialog.this.poll();
        }
    }

    class C13914 implements Callback {
        C13914() {
        }

        public void onCompleted(GraphResponse graphResponse) {
            if (!DeviceAuthDialog.this.completed.get()) {
                FacebookRequestError error = graphResponse.getError();
                if (error != null) {
                    switch (error.getSubErrorCode()) {
                        case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_CODE_EXPIRED /*1349152*/:
                        case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED /*1349173*/:
                            DeviceAuthDialog.this.onCancel();
                            return;
                        case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING /*1349172*/:
                        case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING /*1349174*/:
                            DeviceAuthDialog.this.schedulePoll();
                            return;
                        default:
                            DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                            return;
                    }
                }
                try {
                    DeviceAuthDialog.this.onSuccess(graphResponse.getJSONObject().getString("access_token"));
                } catch (Throwable e) {
                    DeviceAuthDialog.this.onError(new FacebookException(e));
                }
            }
        }
    }

    static class RequestState implements Parcelable {
        public static final Creator<RequestState> CREATOR = new C13931();
        private long interval;
        private long lastPoll;
        private String requestCode;
        private String userCode;

        static class C13931 implements Creator<RequestState> {
            C13931() {
            }

            public RequestState createFromParcel(Parcel parcel) {
                return new RequestState(parcel);
            }

            public RequestState[] newArray(int i) {
                return new RequestState[i];
            }
        }

        RequestState() {
        }

        public String getUserCode() {
            return this.userCode;
        }

        public void setUserCode(String str) {
            this.userCode = str;
        }

        public String getRequestCode() {
            return this.requestCode;
        }

        public void setRequestCode(String str) {
            this.requestCode = str;
        }

        public long getInterval() {
            return this.interval;
        }

        public void setInterval(long j) {
            this.interval = j;
        }

        public void setLastPoll(long j) {
            this.lastPoll = j;
        }

        protected RequestState(Parcel parcel) {
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
        }

        public boolean withinLastRefreshWindow() {
            if (this.lastPoll != 0 && (new Date().getTime() - this.lastPoll) - (this.interval * 1000) < 0) {
                return true;
            }
            return false;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.userCode);
            parcel.writeString(this.requestCode);
            parcel.writeLong(this.interval);
            parcel.writeLong(this.lastPoll);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) ((LoginFragment) ((FacebookActivity) getActivity()).getCurrentFragment()).getLoginClient().getCurrentHandler();
        if (bundle != null) {
            RequestState requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY);
            if (requestState != null) {
                setCurrentRequestState(requestState);
            }
        }
        return onCreateView;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.dialog = new Dialog(getActivity(), C1325R.style.com_facebook_auth_dialog);
        View inflate = getActivity().getLayoutInflater().inflate(C1325R.layout.com_facebook_device_auth_dialog_fragment, null);
        this.progressBar = (ProgressBar) inflate.findViewById(C1325R.id.progress_bar);
        this.confirmationCode = (TextView) inflate.findViewById(C1325R.id.confirmation_code);
        ((Button) inflate.findViewById(C1325R.id.cancel_button)).setOnClickListener(new C13881());
        ((TextView) inflate.findViewById(C1325R.id.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(C1325R.string.com_facebook_device_auth_instructions)));
        this.dialog.setContentView(inflate);
        return this.dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.isBeingDestroyed) {
            onCancel();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
    }

    public void onDestroy() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroy();
        if (this.currentGraphRequestPoll != null) {
            this.currentGraphRequestPoll.cancel(true);
        }
        if (this.scheduledPoll != null) {
            this.scheduledPoll.cancel(true);
        }
    }

    public void startLogin(Request request) {
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.getPermissions()));
        String deviceRedirectUriString = request.getDeviceRedirectUriString();
        if (deviceRedirectUriString != null) {
            bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, deviceRedirectUriString);
        }
        bundle.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
        new GraphRequest(null, DEVICE_LOGIN_ENDPOINT, bundle, HttpMethod.POST, new C13892()).executeAsync();
    }

    private void setCurrentRequestState(RequestState requestState) {
        this.currentRequestState = requestState;
        this.confirmationCode.setText(requestState.getUserCode());
        this.confirmationCode.setVisibility(0);
        this.progressBar.setVisibility(8);
        if (requestState.withinLastRefreshWindow()) {
            schedulePoll();
        } else {
            poll();
        }
    }

    private void poll() {
        this.currentRequestState.setLastPoll(new Date().getTime());
        this.currentGraphRequestPoll = getPollRequest().executeAsync();
    }

    private void schedulePoll() {
        this.scheduledPoll = DeviceAuthMethodHandler.getBackgroundExecutor().schedule(new C13903(), this.currentRequestState.getInterval(), TimeUnit.SECONDS);
    }

    private GraphRequest getPollRequest() {
        Bundle bundle = new Bundle();
        bundle.putString("code", this.currentRequestState.getRequestCode());
        return new GraphRequest(null, DEVICE_LOGIN_STATUS_ENDPOINT, bundle, HttpMethod.POST, new C13914());
    }

    private void onSuccess(final String str) {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,permissions");
        new GraphRequest(new AccessToken(str, FacebookSdk.getApplicationId(), AppEventsConstants.EVENT_PARAM_VALUE_NO, null, null, null, null, null), "me", bundle, HttpMethod.GET, new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                if (!DeviceAuthDialog.this.completed.get()) {
                    if (graphResponse.getError() != null) {
                        DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                        return;
                    }
                    try {
                        JSONObject jSONObject = graphResponse.getJSONObject();
                        String string = jSONObject.getString("id");
                        PermissionsPair handlePermissionResponse = Utility.handlePermissionResponse(jSONObject);
                        DeviceAuthDialog.this.deviceAuthMethodHandler.onSuccess(str, FacebookSdk.getApplicationId(), string, handlePermissionResponse.getGrantedPermissions(), handlePermissionResponse.getDeclinedPermissions(), AccessTokenSource.DEVICE_AUTH, null, null);
                        DeviceAuthDialog.this.dialog.dismiss();
                    } catch (Throwable e) {
                        DeviceAuthDialog.this.onError(new FacebookException(e));
                    }
                }
            }
        }).executeAsync();
    }

    private void onError(FacebookException facebookException) {
        if (this.completed.compareAndSet(false, true)) {
            this.deviceAuthMethodHandler.onError(facebookException);
            this.dialog.dismiss();
        }
    }

    private void onCancel() {
        if (this.completed.compareAndSet(false, true)) {
            if (this.deviceAuthMethodHandler != null) {
                this.deviceAuthMethodHandler.onCancel();
            }
            this.dialog.dismiss();
        }
    }
}
