package com.jawbone.upplatformsdk.oauth;

import android.net.Uri.Builder;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants.UpPlatformAuthScope;
import java.util.List;

public class OauthUtils {
    private static final String TAG = OauthUtils.class.getSimpleName();

    public static Builder setOauthParameters(String str, String str2, List<UpPlatformAuthScope> list) {
        Builder baseParameters = setBaseParameters();
        baseParameters.appendPath("auth");
        baseParameters.appendPath("oauth2");
        baseParameters.appendPath("auth");
        baseParameters.appendQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "code");
        baseParameters.appendQueryParameter("client_id", str);
        baseParameters = setOauthScopeParameters(list, baseParameters);
        baseParameters.appendQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, str2);
        return baseParameters;
    }

    public static Builder setOauthScopeParameters(List<UpPlatformAuthScope> list, Builder builder) {
        StringBuilder stringBuilder = new StringBuilder();
        for (UpPlatformAuthScope upPlatformAuthScope : list) {
            switch (upPlatformAuthScope) {
                case BASIC_READ:
                    stringBuilder.append("basic_read ");
                    break;
                case EXTENDED_READ:
                    stringBuilder.append("extended_read ");
                    break;
                case LOCATION_READ:
                    stringBuilder.append("location_read ");
                    break;
                case FRIENDS_READ:
                    stringBuilder.append("friends_read ");
                    break;
                case MOOD_READ:
                    stringBuilder.append("mood_read ");
                    break;
                case MOOD_WRITE:
                    stringBuilder.append("mood_write ");
                    break;
                case MOVE_READ:
                    stringBuilder.append("move_read ");
                    break;
                case MOVE_WRITE:
                    stringBuilder.append("move_write ");
                    break;
                case SLEEP_READ:
                    stringBuilder.append("sleep_read ");
                    break;
                case SLEEP_WRITE:
                    stringBuilder.append("sleep_write ");
                    break;
                case MEAL_READ:
                    stringBuilder.append("meal_read ");
                    break;
                case MEAL_WRITE:
                    stringBuilder.append("meal_write ");
                    break;
                case WEIGHT_READ:
                    stringBuilder.append("weight_read ");
                    break;
                case WEIGHT_WRITE:
                    stringBuilder.append("weight_write ");
                    break;
                case CARDIAC_READ:
                    stringBuilder.append("cardiac_read ");
                    break;
                case CARDIAC_WRITE:
                    stringBuilder.append("cardiac_write ");
                    break;
                case GENERIC_EVENT_READ:
                    stringBuilder.append("generic_event_read ");
                    break;
                case GENERIC_EVENT_WRITE:
                    stringBuilder.append("generic_event_write ");
                    break;
                case TIME_SERIES_WRITE:
                    stringBuilder.append("timeseries_write ");
                    break;
                case ALL:
                    stringBuilder.append("basic_read ");
                    stringBuilder.append("extended_read ");
                    stringBuilder.append("location_read ");
                    stringBuilder.append("friends_read ");
                    stringBuilder.append("mood_read ");
                    stringBuilder.append("mood_write ");
                    stringBuilder.append("move_read ");
                    stringBuilder.append("move_write ");
                    stringBuilder.append("sleep_read ");
                    stringBuilder.append("sleep_write ");
                    stringBuilder.append("meal_read ");
                    stringBuilder.append("meal_write ");
                    stringBuilder.append("weight_read ");
                    stringBuilder.append("weight_write ");
                    stringBuilder.append("cardiac_read ");
                    stringBuilder.append("cardiac_write ");
                    stringBuilder.append("generic_event_read ");
                    stringBuilder.append("generic_event_write ");
                    stringBuilder.append("timeseries_write ");
                    break;
                default:
                    Log.e(TAG, "unknown scope:" + upPlatformAuthScope);
                    break;
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
            builder.appendQueryParameter("scope", stringBuilder.toString());
        }
        return builder;
    }

    public static Builder setBaseParameters() {
        Builder builder = new Builder();
        builder.scheme(UpPlatformSdkConstants.URI_SCHEME);
        builder.authority(UpPlatformSdkConstants.AUTHORITY);
        return builder;
    }
}
