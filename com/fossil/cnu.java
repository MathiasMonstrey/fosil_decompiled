package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.Factory;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.GraphJSONObjectCallback;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.common.model.Profile;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFLoginResponse;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.enums.AuthType;
import com.portfolio.platform.response.auth.MFGetCurrentUserResponse;
import java.util.Arrays;
import java.util.StringTokenizer;
import org.json.JSONObject;

public class cnu {
    private static final String TAG = cnu.class.getCanonicalName();
    private static cnu cAz;
    private CallbackManager cAA;
    cnr mSharedPreferencesManager;
    UserRepository mUserRepository;

    public cnu() {
        PortfolioApp.ZQ().aam().mo1832a(this);
    }

    public static synchronized cnu adu() {
        cnu com_fossil_cnu;
        synchronized (cnu.class) {
            if (cAz == null) {
                cAz = new cnu();
            }
            com_fossil_cnu = cAz;
        }
        return com_fossil_cnu;
    }

    public void m7271a(final Activity activity, final coc com_fossil_coc) {
        final Context applicationContext = PortfolioApp.ZQ().getApplicationContext();
        this.cAA = Factory.create();
        LoginManager.getInstance().logOut();
        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList(new String[]{Constants.EMAIL, "user_photos", "public_profile"}));
        LoginManager.getInstance().registerCallback(this.cAA, new FacebookCallback<LoginResult>(this) {
            final /* synthetic */ cnu cAD;

            public /* synthetic */ void onSuccess(Object obj) {
                m7266a((LoginResult) obj);
            }

            public void m7266a(LoginResult loginResult) {
                MFLogger.m12670d(cnu.TAG, "Step 1: Login using facebook success");
                final AccessToken accessToken = loginResult.getAccessToken();
                this.cAD.mSharedPreferencesManager.gG(accessToken.getToken());
                MFNetwork.getInstance(applicationContext).execute(new cqj(activity.getApplicationContext()), new MFServerResultCallback(this) {
                    final /* synthetic */ C22361 cAE;

                    public void onSuccess(MFResponse mFResponse) {
                        MFLoginResponse mFLoginResponse = (MFLoginResponse) mFResponse;
                        if (mFLoginResponse != null) {
                            Profile profile = mFLoginResponse.getProfile();
                            MFUser mFUser = new MFUser();
                            mFUser.setCreatedAt(profile.getCreatedAt());
                            mFUser.setUserAccessToken(profile.getAccessToken());
                            mFUser.setUserId(profile.getUid());
                            mFUser.setObjectId(profile.getObjectId());
                            mFUser.setAuthType(AuthType.FACEBOOK.getValue());
                            PortfolioApp.ZQ().aam().YV().setUserAccessToken(mFLoginResponse.getProfile().getAccessToken());
                            this.cAE.cAD.mUserRepository.addOrUpdateUser(mFUser, null);
                        }
                        MFLogger.m12670d(cnu.TAG, "Step 2: Login server with facebook token success");
                        this.cAE.cAD.m7270a(com_fossil_coc, accessToken);
                    }

                    public void onFail(int i, MFResponse mFResponse) {
                        MFLogger.m12671e(cnu.TAG, "Log in facebook fail " + i);
                        com_fossil_coc.onLoginFailed(i, null);
                    }
                });
            }

            public void onCancel() {
                MFLogger.m12671e(cnu.TAG, "login facebook is cancel");
                com_fossil_coc.onLoginFailed(2, null);
            }

            public void onError(FacebookException facebookException) {
                MFLogger.m12671e(cnu.TAG, "login facebook fail " + facebookException.getMessage());
                com_fossil_coc.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
            }
        });
    }

    private void m7270a(final coc com_fossil_coc, final AccessToken accessToken) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqe(PortfolioApp.ZQ()), new MFServerResultCallback(this) {
            final /* synthetic */ cnu cAD;

            public void onSuccess(MFResponse mFResponse) {
                MFGetCurrentUserResponse mFGetCurrentUserResponse = (MFGetCurrentUserResponse) mFResponse;
                MFLogger.m12670d(cnu.TAG, "Step 3: Fetch user data from server with facebook success, isRegistrationComplete: " + mFGetCurrentUserResponse.isRegistrationComplete());
                if (mFGetCurrentUserResponse.isRegistrationComplete()) {
                    com_fossil_coc.onLoginSuccess(0);
                } else {
                    this.cAD.m7267a(accessToken, com_fossil_coc);
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                switch (i) {
                    case 401:
                    case 404:
                        com_fossil_coc.onLoginSuccess(1);
                        return;
                    default:
                        com_fossil_coc.onLoginFailed(i, null);
                        return;
                }
            }
        });
    }

    private void m7267a(AccessToken accessToken, final coc com_fossil_coc) {
        GraphRequest newMeRequest = GraphRequest.newMeRequest(accessToken, new GraphJSONObjectCallback(this) {
            final /* synthetic */ cnu cAD;

            public void onCompleted(JSONObject jSONObject, GraphResponse graphResponse) {
                MFLogger.m12670d(cnu.TAG, "Inside .fetchGraphDataFacebook response=" + graphResponse + ", error=" + graphResponse.getError());
                if (graphResponse.getError() != null) {
                    com_fossil_coc.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
                } else if (jSONObject != null) {
                    MFUser currentUser = this.cAD.mUserRepository.getCurrentUser();
                    if (currentUser == null) {
                        com_fossil_coc.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
                        return;
                    }
                    currentUser.setEmail(jSONObject.optString(Constants.EMAIL));
                    Object optString = jSONObject.optString("name");
                    MFLogger.m12670d(cnu.TAG, "Facebook email is " + jSONObject.optString(Constants.EMAIL) + " facebook name " + jSONObject.optString("name"));
                    if (!TextUtils.isEmpty(optString)) {
                        String[] gX = cnu.gW(optString);
                        currentUser.setFirstName(gX[0]);
                        currentUser.setLastName(gX[1]);
                    }
                    this.cAD.mUserRepository.addOrUpdateUser(currentUser, null);
                    com_fossil_coc.onLoginSuccess(1);
                } else {
                    com_fossil_coc.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
                }
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id, name, email");
        newMeRequest.setParameters(bundle);
        newMeRequest.executeAsync();
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.cAA == null) {
            return false;
        }
        boolean onActivityResult = this.cAA.onActivityResult(i, i2, intent);
        this.cAA = null;
        return onActivityResult;
    }

    private static String[] gW(String str) {
        String[] strArr = new String[]{"", ""};
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        if (stringTokenizer.hasMoreTokens()) {
            strArr[0] = stringTokenizer.nextToken();
        }
        if (stringTokenizer.hasMoreTokens()) {
            strArr[1] = stringTokenizer.nextToken();
        }
        return strArr;
    }
}
