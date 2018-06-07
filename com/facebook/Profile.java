package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

public final class Profile implements Parcelable {
    public static final Creator<Profile> CREATOR = new C13222();
    private static final String FIRST_NAME_KEY = "first_name";
    private static final String ID_KEY = "id";
    private static final String LAST_NAME_KEY = "last_name";
    private static final String LINK_URI_KEY = "link_uri";
    private static final String MIDDLE_NAME_KEY = "middle_name";
    private static final String NAME_KEY = "name";
    private final String firstName;
    private final String id;
    private final String lastName;
    private final Uri linkUri;
    private final String middleName;
    private final String name;

    static class C13211 implements GraphMeRequestWithCacheCallback {
        C13211() {
        }

        public void onSuccess(JSONObject jSONObject) {
            String optString = jSONObject.optString("id");
            if (optString != null) {
                String optString2 = jSONObject.optString("link");
                Profile.setCurrentProfile(new Profile(optString, jSONObject.optString("first_name"), jSONObject.optString(Profile.MIDDLE_NAME_KEY), jSONObject.optString("last_name"), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
            }
        }

        public void onFailure(FacebookException facebookException) {
        }
    }

    static class C13222 implements Creator {
        C13222() {
        }

        public Profile createFromParcel(Parcel parcel) {
            return new Profile(parcel);
        }

        public Profile[] newArray(int i) {
            return new Profile[i];
        }
    }

    public static Profile getCurrentProfile() {
        return ProfileManager.getInstance().getCurrentProfile();
    }

    public static void setCurrentProfile(Profile profile) {
        ProfileManager.getInstance().setCurrentProfile(profile);
    }

    public static void fetchProfileForCurrentAccessToken() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null) {
            setCurrentProfile(null);
        } else {
            Utility.getGraphMeRequestWithCacheAsync(currentAccessToken.getToken(), new C13211());
        }
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri) {
        Validate.notNullOrEmpty(str, "id");
        this.id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
    }

    public Uri getProfilePictureUri(int i, int i2) {
        return ImageRequest.getProfilePictureUri(this.id, i, i2);
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.name;
    }

    public Uri getLinkUri() {
        return this.linkUri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        if (this.id.equals(profile.id) && this.firstName == null) {
            if (profile.firstName != null) {
                return false;
            }
            return true;
        } else if (this.firstName.equals(profile.firstName) && this.middleName == null) {
            if (profile.middleName != null) {
                return false;
            }
            return true;
        } else if (this.middleName.equals(profile.middleName) && this.lastName == null) {
            if (profile.lastName != null) {
                return false;
            }
            return true;
        } else if (this.lastName.equals(profile.lastName) && this.name == null) {
            if (profile.name != null) {
                return false;
            }
            return true;
        } else if (!this.name.equals(profile.name) || this.linkUri != null) {
            return this.linkUri.equals(profile.linkUri);
        } else {
            if (profile.linkUri != null) {
                return false;
            }
            return true;
        }
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() + 527;
        if (this.firstName != null) {
            hashCode = (hashCode * 31) + this.firstName.hashCode();
        }
        if (this.middleName != null) {
            hashCode = (hashCode * 31) + this.middleName.hashCode();
        }
        if (this.lastName != null) {
            hashCode = (hashCode * 31) + this.lastName.hashCode();
        }
        if (this.name != null) {
            hashCode = (hashCode * 31) + this.name.hashCode();
        }
        if (this.linkUri != null) {
            return (hashCode * 31) + this.linkUri.hashCode();
        }
        return hashCode;
    }

    JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("first_name", this.firstName);
            jSONObject.put(MIDDLE_NAME_KEY, this.middleName);
            jSONObject.put("last_name", this.lastName);
            jSONObject.put("name", this.name);
            if (this.linkUri == null) {
                return jSONObject;
            }
            jSONObject.put(LINK_URI_KEY, this.linkUri.toString());
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    Profile(JSONObject jSONObject) {
        Uri uri = null;
        this.id = jSONObject.optString("id", null);
        this.firstName = jSONObject.optString("first_name", null);
        this.middleName = jSONObject.optString(MIDDLE_NAME_KEY, null);
        this.lastName = jSONObject.optString("last_name", null);
        this.name = jSONObject.optString("name", null);
        String optString = jSONObject.optString(LINK_URI_KEY, null);
        if (optString != null) {
            uri = Uri.parse(optString);
        }
        this.linkUri = uri;
    }

    private Profile(Parcel parcel) {
        this.id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        String readString = parcel.readString();
        this.linkUri = readString == null ? null : Uri.parse(readString);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.name);
        parcel.writeString(this.linkUri == null ? null : this.linkUri.toString());
    }
}
