package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.misfit.frameworks.common.constants.Constants;

public final class AppInviteContent implements ShareModel {
    public static final Creator<AppInviteContent> CREATOR = new C14701();
    private final String applinkUrl;
    private final Destination destination;
    private final String previewImageUrl;
    private final String promoCode;
    private final String promoText;

    static class C14701 implements Creator<AppInviteContent> {
        C14701() {
        }

        public AppInviteContent createFromParcel(Parcel parcel) {
            return new AppInviteContent(parcel);
        }

        public AppInviteContent[] newArray(int i) {
            return new AppInviteContent[i];
        }
    }

    public static class Builder implements ShareModelBuilder<AppInviteContent, Builder> {
        private String applinkUrl;
        private Destination destination;
        private String previewImageUrl;
        private String promoCode;
        private String promoText;

        public enum Destination {
            FACEBOOK(Constants.FACEBOOK),
            MESSENGER("messenger");
            
            private final String name;

            private Destination(String str) {
                this.name = str;
            }

            public boolean equalsName(String str) {
                return str == null ? false : this.name.equals(str);
            }

            public String toString() {
                return this.name;
            }
        }

        public Builder setApplinkUrl(String str) {
            this.applinkUrl = str;
            return this;
        }

        public Builder setPreviewImageUrl(String str) {
            this.previewImageUrl = str;
            return this;
        }

        public Builder setPromotionDetails(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    throw new IllegalArgumentException("promotionCode cannot be specified without a valid promotionText");
                }
            } else if (str.length() > 80) {
                throw new IllegalArgumentException("Invalid promotion text, promotionText needs to be between1 and 80 characters long");
            } else if (!isAlphanumericWithSpaces(str)) {
                throw new IllegalArgumentException("Invalid promotion text, promotionText can only contain alphanumericcharacters and spaces.");
            } else if (!TextUtils.isEmpty(str2)) {
                if (str2.length() > 10) {
                    throw new IllegalArgumentException("Invalid promotion code, promotionCode can be between1 and 10 characters long");
                } else if (!isAlphanumericWithSpaces(str2)) {
                    throw new IllegalArgumentException("Invalid promotion code, promotionCode can only contain alphanumeric characters and spaces.");
                }
            }
            this.promoCode = str2;
            this.promoText = str;
            return this;
        }

        public Builder setDestination(Destination destination) {
            this.destination = destination;
            return this;
        }

        public AppInviteContent build() {
            return new AppInviteContent();
        }

        public Builder readFrom(AppInviteContent appInviteContent) {
            return appInviteContent == null ? this : setApplinkUrl(appInviteContent.getApplinkUrl()).setPreviewImageUrl(appInviteContent.getPreviewImageUrl()).setPromotionDetails(appInviteContent.getPromotionText(), appInviteContent.getPromotionCode()).setDestination(appInviteContent.getDestination());
        }

        private boolean isAlphanumericWithSpaces(String str) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!Character.isDigit(charAt) && !Character.isLetter(charAt) && !Character.isSpaceChar(charAt)) {
                    return false;
                }
            }
            return true;
        }
    }

    private AppInviteContent(Builder builder) {
        this.applinkUrl = builder.applinkUrl;
        this.previewImageUrl = builder.previewImageUrl;
        this.promoCode = builder.promoCode;
        this.promoText = builder.promoText;
        this.destination = builder.destination;
    }

    AppInviteContent(Parcel parcel) {
        this.applinkUrl = parcel.readString();
        this.previewImageUrl = parcel.readString();
        this.promoText = parcel.readString();
        this.promoCode = parcel.readString();
        String readString = parcel.readString();
        if (readString.length() > 0) {
            this.destination = Destination.valueOf(readString);
        } else {
            this.destination = Destination.FACEBOOK;
        }
    }

    public String getApplinkUrl() {
        return this.applinkUrl;
    }

    public String getPreviewImageUrl() {
        return this.previewImageUrl;
    }

    public String getPromotionCode() {
        return this.promoCode;
    }

    public String getPromotionText() {
        return this.promoText;
    }

    public Destination getDestination() {
        if (this.destination != null) {
            return this.destination;
        }
        return Destination.FACEBOOK;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.applinkUrl);
        parcel.writeString(this.previewImageUrl);
        parcel.writeString(this.promoText);
        parcel.writeString(this.promoCode);
        parcel.writeString(this.destination.toString());
    }
}
