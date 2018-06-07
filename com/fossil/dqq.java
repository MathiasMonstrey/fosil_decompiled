package com.fossil;

import android.content.ContentUris;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.contact.Contact;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.portfolio.platform.PortfolioApp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class dqq {
    static final /* synthetic */ boolean $assertionsDisabled = (!dqq.class.desiredAssertionStatus());
    private static final String TAG = dqq.class.getSimpleName();
    private static final Config azC = Config.ARGB_8888;

    public static Bitmap m9395a(Bitmap bitmap, Bitmap bitmap2, int i) {
        Bitmap b = m9399b(bitmap, i);
        Bitmap b2 = m9399b(bitmap2, i);
        Bitmap createBitmap = Bitmap.createBitmap(i * 2, i * 2, azC);
        Canvas canvas = new Canvas(createBitmap);
        if (b != null) {
            canvas.drawBitmap(b, 0.0f, 0.0f, null);
            b.recycle();
        }
        if (b2 != null) {
            canvas.drawBitmap(b2, (float) i, 0.0f, null);
            b2.recycle();
        }
        return createBitmap;
    }

    public static Bitmap m9396a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, int i) {
        Bitmap b = m9399b(bitmap, i);
        Bitmap a = m9394a(bitmap2, i);
        Bitmap a2 = m9394a(bitmap3, i);
        Bitmap createBitmap = Bitmap.createBitmap(i * 2, i * 2, azC);
        Canvas canvas = new Canvas(createBitmap);
        if (b != null) {
            canvas.drawBitmap(b, 0.0f, 0.0f, null);
            b.recycle();
        }
        if (a != null) {
            canvas.drawBitmap(a, (float) i, 0.0f, null);
            a.recycle();
        }
        if (a2 != null) {
            canvas.drawBitmap(a2, (float) i, (float) i, null);
            a2.recycle();
        }
        return createBitmap;
    }

    public static Bitmap m9397a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, int i) {
        Bitmap a = m9394a(bitmap, i);
        Bitmap a2 = m9394a(bitmap2, i);
        Bitmap a3 = m9394a(bitmap3, i);
        Bitmap a4 = m9394a(bitmap4, i);
        Bitmap createBitmap = Bitmap.createBitmap(i * 2, i * 2, azC);
        Canvas canvas = new Canvas(createBitmap);
        if (a != null) {
            canvas.drawBitmap(a, 0.0f, 0.0f, null);
            a.recycle();
        }
        if (a2 != null) {
            canvas.drawBitmap(a2, 0.0f, (float) i, null);
            a2.recycle();
        }
        if (a3 != null) {
            canvas.drawBitmap(a3, (float) i, 0.0f, null);
            a3.recycle();
        }
        if (a4 != null) {
            canvas.drawBitmap(a4, (float) i, (float) i, null);
            a4.recycle();
        }
        return createBitmap;
    }

    private static Bitmap m9394a(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            createBitmap = Bitmap.createBitmap(bitmap, (width / 2) - (height / 2), 0, height, height);
        } else {
            createBitmap = Bitmap.createBitmap(bitmap, 0, (height / 2) - (width / 2), width, width);
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap.getWidth() + 4, createBitmap.getHeight() + 4, createBitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap2);
        canvas.drawColor(Color.parseColor("#C9C9C9"));
        canvas.drawBitmap(createBitmap, 2.0f, 2.0f, null);
        createBitmap.recycle();
        return Bitmap.createScaledBitmap(createBitmap2, i, i, false);
    }

    private static Bitmap m9399b(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height > width * 2) {
            createBitmap = Bitmap.createBitmap(bitmap, 0, (height / 2) - width, width, width * 2);
        } else {
            createBitmap = Bitmap.createBitmap(bitmap, (width / 2) - (height / 4), 0, height / 2, height);
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, i, i * 2, false);
        createBitmap.recycle();
        createBitmap = Bitmap.createBitmap(createScaledBitmap.getWidth() + 4, createScaledBitmap.getHeight() + 4, createScaledBitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(Color.parseColor("#C9C9C9"));
        canvas.drawBitmap(createScaledBitmap, 2.0f, 2.0f, null);
        createScaledBitmap.recycle();
        return createBitmap;
    }

    public static Bitmap m9393A(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        try {
            Bitmap createBitmap;
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, azC);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), azC);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap jj(String str) {
        try {
            return Bitmap.createScaledBitmap(Media.getBitmap(PortfolioApp.ZQ().getContentResolver(), Uri.parse(str)), 1, 1, false);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap jk(String str) {
        String[] split = str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        String str2 = split[0];
        String str3 = "";
        if (split.length > 1) {
            str3 = split[1];
        }
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.substring(0, 1);
        }
        if (!TextUtils.isEmpty(str3)) {
            str3 = str3.substring(0, 1);
        }
        return m9393A(drt.awc().awd().lR(MFNetworkReturnCode.RESPONSE_OK).lS(MFNetworkReturnCode.RESPONSE_OK).lU(ly(30)).lT(PortfolioApp.ZQ().getResources().getColor(R.color.white)).awe().mo2668I(str2 + str3, PortfolioApp.ZQ().getResources().getColor(R.color.fossilCoolGray)));
    }

    public static Bitmap m9398a(Contact contact) {
        String[] split = contact.getDisplayName().split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        String str = split[0];
        String str2 = "";
        if (split.length > 1) {
            str2 = split[1];
        }
        if (!TextUtils.isEmpty(str)) {
            str = str.substring(0, 1);
        }
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.substring(0, 1);
        }
        return m9393A(drt.awc().awd().lR(MFNetworkReturnCode.RESPONSE_OK).lS(MFNetworkReturnCode.RESPONSE_OK).lU(ly(30)).lT(PortfolioApp.ZQ().getResources().getColor(R.color.white)).awe().mo2668I(str + str2, PortfolioApp.ZQ().getResources().getColor(R.color.fossilCoolGray)));
    }

    public static Bitmap jl(String str) {
        Drawable I = drt.awc().awd().lR(MFNetworkReturnCode.RESPONSE_OK).lS(MFNetworkReturnCode.RESPONSE_OK).lU(120).lT(PortfolioApp.ZQ().getResources().getColor(R.color.hex7D7D7D)).awe().mo2668I(str, PortfolioApp.ZQ().getResources().getColor(R.color.white_30));
        I.du(true);
        return m9393A(I);
    }

    public static Bitmap m9400b(Long l) {
        if (dre.dff.m9462a(PortfolioApp.ZQ(), "android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE", "android.permission.READ_SMS")) {
            try {
                Bitmap decodeStream;
                InputStream openContactPhotoInputStream = Contacts.openContactPhotoInputStream(PortfolioApp.ZQ().getContentResolver(), ContentUris.withAppendedId(Contacts.CONTENT_URI, l.longValue()), true);
                if (openContactPhotoInputStream != null) {
                    decodeStream = BitmapFactory.decodeStream(openContactPhotoInputStream);
                } else {
                    decodeStream = null;
                }
                if ($assertionsDisabled || openContactPhotoInputStream != null) {
                    openContactPhotoInputStream.close();
                    return decodeStream;
                }
                throw new AssertionError();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        Log.d(TAG, "getContactPhotoById does not enough permissions");
        return null;
    }

    public static int ly(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, PortfolioApp.ZQ().getResources().getDisplayMetrics());
    }

    public static String m9401t(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        try {
            return new String(Base64.encode(byteArrayOutputStream.toByteArray(), 2), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
