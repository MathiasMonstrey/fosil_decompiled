package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.Mapper;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView.ObjectType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareInternalUtility {
    public static final String MY_PHOTOS = "me/photos";
    private static final String MY_STAGING_RESOURCES = "me/staging_resources";
    private static final String STAGING_PARAM = "file";

    static class C14585 implements Mapper<Attachment, String> {
        C14585() {
        }

        public String apply(Attachment attachment) {
            return attachment.getAttachmentUrl();
        }
    }

    static class C14618 implements PhotoJSONProcessor {
        C14618() {
        }

        public JSONObject toJSONObject(SharePhoto sharePhoto) {
            Uri imageUrl = sharePhoto.getImageUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", imageUrl.toString());
                return jSONObject;
            } catch (Throwable e) {
                throw new FacebookException("Unable to attach images", e);
            }
        }
    }

    public static void invokeCallbackWithException(FacebookCallback<Result> facebookCallback, Exception exception) {
        if (exception instanceof FacebookException) {
            invokeOnErrorCallback((FacebookCallback) facebookCallback, (FacebookException) exception);
        } else {
            invokeCallbackWithError(facebookCallback, "Error preparing share content: " + exception.getLocalizedMessage());
        }
    }

    public static void invokeCallbackWithError(FacebookCallback<Result> facebookCallback, String str) {
        invokeOnErrorCallback((FacebookCallback) facebookCallback, str);
    }

    public static void invokeCallbackWithResults(FacebookCallback<Result> facebookCallback, String str, GraphResponse graphResponse) {
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            if (Utility.isNullOrEmpty(errorMessage)) {
                errorMessage = "Unexpected error sharing.";
            }
            invokeOnErrorCallback(facebookCallback, graphResponse, errorMessage);
            return;
        }
        invokeOnSuccessCallback(facebookCallback, str);
    }

    public static String getNativeDialogCompletionGesture(Bundle bundle) {
        if (bundle.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY)) {
            return bundle.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY);
        }
        return bundle.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
    }

    public static String getShareDialogPostId(Bundle bundle) {
        if (bundle.containsKey(ShareConstants.RESULT_POST_ID)) {
            return bundle.getString(ShareConstants.RESULT_POST_ID);
        }
        if (bundle.containsKey(ShareConstants.EXTRA_RESULT_POST_ID)) {
            return bundle.getString(ShareConstants.EXTRA_RESULT_POST_ID);
        }
        return bundle.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
    }

    public static boolean handleActivityResult(int i, int i2, Intent intent, ResultProcessor resultProcessor) {
        AppCall appCallFromActivityResult = getAppCallFromActivityResult(i, i2, intent);
        if (appCallFromActivityResult == null) {
            return false;
        }
        NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCallFromActivityResult.getCallId());
        if (resultProcessor == null) {
            return true;
        }
        FacebookException exceptionFromErrorData = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent));
        if (exceptionFromErrorData == null) {
            resultProcessor.onSuccess(appCallFromActivityResult, NativeProtocol.getSuccessResultsFromIntent(intent));
            return true;
        } else if (exceptionFromErrorData instanceof FacebookOperationCanceledException) {
            resultProcessor.onCancel(appCallFromActivityResult);
            return true;
        } else {
            resultProcessor.onError(appCallFromActivityResult, exceptionFromErrorData);
            return true;
        }
    }

    public static ResultProcessor getShareResultProcessor(final FacebookCallback<Result> facebookCallback) {
        return new ResultProcessor(facebookCallback) {
            public void onSuccess(AppCall appCall, Bundle bundle) {
                if (bundle != null) {
                    String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
                    if (nativeDialogCompletionGesture == null || "post".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                        ShareInternalUtility.invokeOnSuccessCallback(facebookCallback, ShareInternalUtility.getShareDialogPostId(bundle));
                    } else if ("cancel".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                        ShareInternalUtility.invokeOnCancelCallback(facebookCallback);
                    } else {
                        ShareInternalUtility.invokeOnErrorCallback(facebookCallback, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
                    }
                }
            }

            public void onCancel(AppCall appCall) {
                ShareInternalUtility.invokeOnCancelCallback(facebookCallback);
            }

            public void onError(AppCall appCall, FacebookException facebookException) {
                ShareInternalUtility.invokeOnErrorCallback(facebookCallback, facebookException);
            }
        };
    }

    private static AppCall getAppCallFromActivityResult(int i, int i2, Intent intent) {
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return null;
        }
        return AppCall.finishPendingCall(callIdFromIntent, i);
    }

    public static void registerStaticShareCallback(final int i) {
        CallbackManagerImpl.registerStaticCallback(i, new Callback() {
            public boolean onActivityResult(int i, Intent intent) {
                return ShareInternalUtility.handleActivityResult(i, i, intent, ShareInternalUtility.getShareResultProcessor(null));
            }
        });
    }

    public static void registerSharerCallback(final int i, CallbackManager callbackManager, final FacebookCallback<Result> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(i, new Callback() {
                public boolean onActivityResult(int i, Intent intent) {
                    return ShareInternalUtility.handleActivityResult(i, i, intent, ShareInternalUtility.getShareResultProcessor(facebookCallback));
                }
            });
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public static List<String> getPhotoUrls(SharePhotoContent sharePhotoContent, final UUID uuid) {
        if (sharePhotoContent != null) {
            List photos = sharePhotoContent.getPhotos();
            if (photos != null) {
                Collection map = Utility.map(photos, new Mapper<SharePhoto, Attachment>() {
                    public Attachment apply(SharePhoto sharePhoto) {
                        return ShareInternalUtility.getAttachment(uuid, sharePhoto);
                    }
                });
                List<String> map2 = Utility.map(map, new C14585());
                NativeAppCallAttachmentStore.addAttachments(map);
                return map2;
            }
        }
        return null;
    }

    public static String getVideoUrl(ShareVideoContent shareVideoContent, UUID uuid) {
        if (shareVideoContent == null || shareVideoContent.getVideo() == null) {
            return null;
        }
        Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, shareVideoContent.getVideo().getLocalUrl());
        Collection arrayList = new ArrayList(1);
        arrayList.add(createAttachment);
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return createAttachment.getAttachmentUrl();
    }

    public static List<Bundle> getMediaInfos(ShareMediaContent shareMediaContent, final UUID uuid) {
        if (shareMediaContent != null) {
            List media = shareMediaContent.getMedia();
            if (media != null) {
                final Collection arrayList = new ArrayList();
                List<Bundle> map = Utility.map(media, new Mapper<ShareMedia, Bundle>() {
                    public Bundle apply(ShareMedia shareMedia) {
                        Attachment access$000 = ShareInternalUtility.getAttachment(uuid, shareMedia);
                        arrayList.add(access$000);
                        Bundle bundle = new Bundle();
                        bundle.putString("type", shareMedia.getMediaType().name());
                        bundle.putString("uri", access$000.getAttachmentUrl());
                        return bundle;
                    }
                });
                NativeAppCallAttachmentStore.addAttachments(arrayList);
                return map;
            }
        }
        return null;
    }

    public static JSONObject toJSONObjectForCall(final UUID uuid, ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        ShareOpenGraphAction action = shareOpenGraphContent.getAction();
        final Collection arrayList = new ArrayList();
        JSONObject toJSONObject = OpenGraphJSONUtility.toJSONObject(action, new PhotoJSONProcessor() {
            public JSONObject toJSONObject(SharePhoto sharePhoto) {
                Attachment access$000 = ShareInternalUtility.getAttachment(uuid, sharePhoto);
                if (access$000 == null) {
                    return null;
                }
                arrayList.add(access$000);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", access$000.getAttachmentUrl());
                    if (!sharePhoto.getUserGenerated()) {
                        return jSONObject;
                    }
                    jSONObject.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, true);
                    return jSONObject;
                } catch (Throwable e) {
                    throw new FacebookException("Unable to attach images", e);
                }
            }
        });
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        if (shareOpenGraphContent.getPlaceId() != null && Utility.isNullOrEmpty(toJSONObject.optString("place"))) {
            toJSONObject.put("place", shareOpenGraphContent.getPlaceId());
        }
        if (shareOpenGraphContent.getPeopleIds() != null) {
            JSONArray optJSONArray = toJSONObject.optJSONArray("tags");
            if (optJSONArray == null) {
                arrayList = new HashSet();
            } else {
                Object jsonArrayToSet = Utility.jsonArrayToSet(optJSONArray);
            }
            for (String add : shareOpenGraphContent.getPeopleIds()) {
                arrayList.add(add);
            }
            toJSONObject.put("tags", new ArrayList(arrayList));
        }
        return toJSONObject;
    }

    public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        return OpenGraphJSONUtility.toJSONObject(shareOpenGraphContent.getAction(), new C14618());
    }

    public static JSONArray removeNamespacesFromOGJsonArray(JSONArray jSONArray, boolean z) throws JSONException {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = removeNamespacesFromOGJsonArray((JSONArray) obj, z);
            } else if (obj instanceof JSONObject) {
                obj = removeNamespacesFromOGJsonObject((JSONObject) obj, z);
            }
            jSONArray2.put(obj);
        }
        return jSONArray2;
    }

    public static JSONObject removeNamespacesFromOGJsonObject(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray names = jSONObject.names();
            for (int i = 0; i < names.length(); i++) {
                Object removeNamespacesFromOGJsonObject;
                String string = names.getString(i);
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    removeNamespacesFromOGJsonObject = removeNamespacesFromOGJsonObject((JSONObject) obj, true);
                } else if (obj instanceof JSONArray) {
                    JSONArray removeNamespacesFromOGJsonArray = removeNamespacesFromOGJsonArray((JSONArray) obj, true);
                } else {
                    removeNamespacesFromOGJsonObject = obj;
                }
                Pair fieldNameAndNamespaceFromFullName = getFieldNameAndNamespaceFromFullName(string);
                String str = (String) fieldNameAndNamespaceFromFullName.first;
                String str2 = (String) fieldNameAndNamespaceFromFullName.second;
                if (z) {
                    if (str != null && str.equals("fbsdk")) {
                        jSONObject2.put(string, removeNamespacesFromOGJsonObject);
                    } else if (str == null || str.equals("og")) {
                        jSONObject2.put(str2, removeNamespacesFromOGJsonObject);
                    } else {
                        jSONObject3.put(str2, removeNamespacesFromOGJsonObject);
                    }
                } else if (str == null || !str.equals("fb")) {
                    jSONObject2.put(str2, removeNamespacesFromOGJsonObject);
                } else {
                    jSONObject2.put(string, removeNamespacesFromOGJsonObject);
                }
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("data", jSONObject3);
            }
            return jSONObject2;
        } catch (JSONException e) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    public static Pair<String, String> getFieldNameAndNamespaceFromFullName(String str) {
        Object obj = null;
        int indexOf = str.indexOf(58);
        if (indexOf != -1 && str.length() > indexOf + 1) {
            obj = str.substring(0, indexOf);
            str = str.substring(indexOf + 1);
        }
        return new Pair(obj, str);
    }

    private static Attachment getAttachment(UUID uuid, ShareMedia shareMedia) {
        Bitmap bitmap;
        Uri imageUrl;
        if (shareMedia instanceof SharePhoto) {
            SharePhoto sharePhoto = (SharePhoto) shareMedia;
            bitmap = sharePhoto.getBitmap();
            imageUrl = sharePhoto.getImageUrl();
        } else if (shareMedia instanceof ShareVideo) {
            imageUrl = ((ShareVideo) shareMedia).getLocalUrl();
            bitmap = null;
        } else {
            imageUrl = null;
            bitmap = null;
        }
        if (bitmap != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
        }
        if (imageUrl != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, imageUrl);
        }
        return null;
    }

    static void invokeOnCancelCallback(FacebookCallback<Result> facebookCallback) {
        logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, null);
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
    }

    static void invokeOnSuccessCallback(FacebookCallback<Result> facebookCallback, String str) {
        logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, null);
        if (facebookCallback != null) {
            facebookCallback.onSuccess(new Result(str));
        }
    }

    static void invokeOnErrorCallback(FacebookCallback<Result> facebookCallback, GraphResponse graphResponse, String str) {
        logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookGraphResponseException(graphResponse, str));
        }
    }

    static void invokeOnErrorCallback(FacebookCallback<Result> facebookCallback, String str) {
        logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookException(str));
        }
    }

    static void invokeOnErrorCallback(FacebookCallback<Result> facebookCallback, FacebookException facebookException) {
        logShareResult("error", facebookException.getMessage());
        if (facebookCallback != null) {
            facebookCallback.onError(facebookException);
        }
    }

    private static void logShareResult(String str, String str2) {
        AppEventsLogger newLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
        if (str2 != null) {
            bundle.putString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str2);
        }
        newLogger.logSdkEvent(AnalyticsEvents.EVENT_SHARE_RESULT, null, bundle);
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Bitmap bitmap, GraphRequest.Callback callback) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(STAGING_PARAM, bitmap);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, File file, GraphRequest.Callback callback) throws FileNotFoundException {
        Parcelable parcelableResourceWithMimeType = new ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(STAGING_PARAM, parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Uri uri, GraphRequest.Callback callback) throws FileNotFoundException {
        if (Utility.isFileUri(uri)) {
            return newUploadStagingResourceWithImageRequest(accessToken, new File(uri.getPath()), callback);
        }
        if (Utility.isContentUri(uri)) {
            Parcelable parcelableResourceWithMimeType = new ParcelableResourceWithMimeType((Parcelable) uri, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable(STAGING_PARAM, parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
        }
        throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
    }

    public static ObjectType getMostSpecificObjectType(ObjectType objectType, ObjectType objectType2) {
        if (objectType == objectType2) {
            return objectType;
        }
        if (objectType == ObjectType.UNKNOWN) {
            return objectType2;
        }
        return objectType2 != ObjectType.UNKNOWN ? null : objectType;
    }
}
