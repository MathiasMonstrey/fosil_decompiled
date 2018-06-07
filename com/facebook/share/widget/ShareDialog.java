package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.SharePhotoContent.Builder;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public final class ShareDialog extends FacebookDialogBase<ShareContent, Result> implements Sharer {
    private static final int DEFAULT_REQUEST_CODE = RequestCodeOffset.Share.toRequestCode();
    private static final String FEED_DIALOG = "feed";
    private static final String WEB_OG_SHARE_DIALOG = "share_open_graph";
    public static final String WEB_SHARE_DIALOG = "share";
    private boolean isAutomaticMode;
    private boolean shouldFailOnDataError;

    class FeedHandler extends ModeHandler {
        private FeedHandler() {
            super();
        }

        public Object getMode() {
            return Mode.FEED;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent);
        }

        public AppCall createAppCall(ShareContent shareContent) {
            Bundle createForFeed;
            ShareDialog.this.logDialogShare(ShareDialog.this.getActivityContext(), shareContent, Mode.FEED);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            if (shareContent instanceof ShareLinkContent) {
                ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
                ShareContentValidation.validateForWebShare(shareLinkContent);
                createForFeed = WebDialogParameters.createForFeed(shareLinkContent);
            } else {
                createForFeed = WebDialogParameters.createForFeed((ShareFeedContent) shareContent);
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, ShareDialog.FEED_DIALOG, createForFeed);
            return createBaseAppCall;
        }
    }

    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    class NativeHandler extends ModeHandler {
        private NativeHandler() {
            super();
        }

        public Object getMode() {
            return Mode.NATIVE;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            boolean z2 = true;
            if (shareContent == null) {
                return false;
            }
            int i;
            if (z) {
                i = 1;
            } else {
                if (shareContent.getShareHashtag() != null) {
                    i = DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.HASHTAG);
                } else {
                    i = 1;
                }
                if ((shareContent instanceof ShareLinkContent) && !Utility.isNullOrEmpty(((ShareLinkContent) shareContent).getQuote())) {
                    i &= DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.LINK_SHARE_QUOTES);
                }
            }
            if (i == 0 || !ShareDialog.canShowNative(shareContent.getClass())) {
                z2 = false;
            }
            return z2;
        }

        public AppCall createAppCall(final ShareContent shareContent) {
            ShareDialog.this.logDialogShare(ShareDialog.this.getActivityContext(), shareContent, Mode.NATIVE);
            ShareContentValidation.validateForNativeShare(shareContent);
            final AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ParameterProvider() {
                public Bundle getParameters() {
                    return NativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                }

                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                }
            }, ShareDialog.getFeature(shareContent.getClass()));
            return createBaseAppCall;
        }
    }

    class WebShareHandler extends ModeHandler {
        private WebShareHandler() {
            super();
        }

        public Object getMode() {
            return Mode.WEB;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            return shareContent != null && ShareDialog.canShowWebTypeCheck(shareContent.getClass());
        }

        public AppCall createAppCall(ShareContent shareContent) {
            Bundle create;
            ShareDialog.this.logDialogShare(ShareDialog.this.getActivityContext(), shareContent, Mode.WEB);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            ShareContentValidation.validateForWebShare(shareContent);
            if (shareContent instanceof ShareLinkContent) {
                create = WebDialogParameters.create((ShareLinkContent) shareContent);
            } else if (shareContent instanceof SharePhotoContent) {
                create = WebDialogParameters.create(createAndMapAttachments((SharePhotoContent) shareContent, createBaseAppCall.getCallId()));
            } else {
                create = WebDialogParameters.create((ShareOpenGraphContent) shareContent);
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, getActionName(shareContent), create);
            return createBaseAppCall;
        }

        private String getActionName(ShareContent shareContent) {
            if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof SharePhotoContent)) {
                return ShareDialog.WEB_SHARE_DIALOG;
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                return ShareDialog.WEB_OG_SHARE_DIALOG;
            }
            return null;
        }

        private SharePhotoContent createAndMapAttachments(SharePhotoContent sharePhotoContent, UUID uuid) {
            Builder readFrom = new Builder().readFrom(sharePhotoContent);
            List arrayList = new ArrayList();
            Collection arrayList2 = new ArrayList();
            for (int i = 0; i < sharePhotoContent.getPhotos().size(); i++) {
                Object obj = (SharePhoto) sharePhotoContent.getPhotos().get(i);
                Bitmap bitmap = obj.getBitmap();
                if (bitmap != null) {
                    Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
                    obj = new SharePhoto.Builder().readFrom((SharePhoto) obj).setImageUrl(Uri.parse(createAttachment.getAttachmentUrl())).setBitmap(null).build();
                    arrayList2.add(createAttachment);
                }
                arrayList.add(obj);
            }
            readFrom.setPhotos(arrayList);
            NativeAppCallAttachmentStore.addAttachments(arrayList2);
            return readFrom.build();
        }
    }

    public static void show(Activity activity, ShareContent shareContent) {
        new ShareDialog(activity).show(shareContent);
    }

    public static void show(Fragment fragment, ShareContent shareContent) {
        show(new FragmentWrapper(fragment), shareContent);
    }

    public static void show(android.app.Fragment fragment, ShareContent shareContent) {
        show(new FragmentWrapper(fragment), shareContent);
    }

    private static void show(FragmentWrapper fragmentWrapper, ShareContent shareContent) {
        new ShareDialog(fragmentWrapper).show(shareContent);
    }

    public static boolean canShow(Class<? extends ShareContent> cls) {
        return canShowWebTypeCheck(cls) || canShowNative(cls);
    }

    private static boolean canShowNative(Class<? extends ShareContent> cls) {
        DialogFeature feature = getFeature(cls);
        return feature != null && DialogPresenter.canPresentNativeDialogWithFeature(feature);
    }

    private static boolean canShowWebTypeCheck(Class<? extends ShareContent> cls) {
        return ShareLinkContent.class.isAssignableFrom(cls) || ShareOpenGraphContent.class.isAssignableFrom(cls) || SharePhotoContent.class.isAssignableFrom(cls);
    }

    public ShareDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
    }

    public ShareDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    public ShareDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private ShareDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
    }

    ShareDialog(Activity activity, int i) {
        super(activity, i);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    ShareDialog(Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
    }

    ShareDialog(android.app.Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
    }

    private ShareDialog(FragmentWrapper fragmentWrapper, int i) {
        super(fragmentWrapper, i);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    protected void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManagerImpl, facebookCallback);
    }

    public boolean getShouldFailOnDataError() {
        return this.shouldFailOnDataError;
    }

    public void setShouldFailOnDataError(boolean z) {
        this.shouldFailOnDataError = z;
    }

    public boolean canShow(ShareContent shareContent, Mode mode) {
        if (mode == Mode.AUTOMATIC) {
            mode = BASE_AUTOMATIC_MODE;
        }
        return canShowImpl(shareContent, mode);
    }

    public void show(ShareContent shareContent, Mode mode) {
        this.isAutomaticMode = mode == Mode.AUTOMATIC;
        if (this.isAutomaticMode) {
            mode = BASE_AUTOMATIC_MODE;
        }
        showImpl(shareContent, mode);
    }

    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    protected List<ModeHandler> getOrderedModeHandlers() {
        List arrayList = new ArrayList();
        arrayList.add(new NativeHandler());
        arrayList.add(new FeedHandler());
        arrayList.add(new WebShareHandler());
        return arrayList;
    }

    private static DialogFeature getFeature(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.SHARE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
            return OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
        }
        if (ShareMediaContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.MULTIMEDIA;
        }
        return null;
    }

    private void logDialogShare(Context context, ShareContent shareContent, Mode mode) {
        String str;
        String str2;
        if (this.isAutomaticMode) {
            mode = Mode.AUTOMATIC;
        }
        switch (mode) {
            case AUTOMATIC:
                str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC;
                break;
            case WEB:
                str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB;
                break;
            case NATIVE:
                str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE;
                break;
            default:
                str = "unknown";
                break;
        }
        DialogFeature feature = getFeature(shareContent.getClass());
        if (feature == ShareDialogFeature.SHARE_DIALOG) {
            str2 = "status";
        } else if (feature == ShareDialogFeature.PHOTOS) {
            str2 = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;
        } else if (feature == ShareDialogFeature.VIDEO) {
            str2 = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO;
        } else if (feature == OpenGraphActionDialogFeature.OG_ACTION_DIALOG) {
            str2 = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_OPENGRAPH;
        } else {
            str2 = "unknown";
        }
        AppEventsLogger newLogger = AppEventsLogger.newLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str);
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_TYPE, str2);
        newLogger.logSdkEvent("fb_share_dialog_show", null, bundle);
    }
}
