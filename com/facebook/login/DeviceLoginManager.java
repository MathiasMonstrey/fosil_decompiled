package com.facebook.login;

import android.net.Uri;
import com.facebook.login.LoginClient.Request;
import java.util.Collection;

public class DeviceLoginManager extends LoginManager {
    private static volatile DeviceLoginManager instance;
    private Uri deviceRedirectUri;

    public static DeviceLoginManager getInstance() {
        if (instance == null) {
            synchronized (DeviceLoginManager.class) {
                if (instance == null) {
                    instance = new DeviceLoginManager();
                }
            }
        }
        return instance;
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.deviceRedirectUri = uri;
    }

    public Uri getDeviceRedirectUri() {
        return this.deviceRedirectUri;
    }

    protected Request createLoginRequest(Collection<String> collection) {
        Request createLoginRequest = super.createLoginRequest(collection);
        Uri deviceRedirectUri = getDeviceRedirectUri();
        if (deviceRedirectUri != null) {
            createLoginRequest.setDeviceRedirectUriString(deviceRedirectUri.toString());
        }
        return createLoginRequest;
    }
}
