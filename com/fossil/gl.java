package com.fossil;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.os.OperationCanceledException;

public final class gl {
    private static final C3628a Mu;

    interface C3628a {
        Cursor mo3129a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, iu iuVar);
    }

    static class C3629b implements C3628a {
        C3629b() {
        }

        public Cursor mo3129a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, iu iuVar) {
            if (iuVar != null) {
                iuVar.throwIfCanceled();
            }
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        }
    }

    static class C3630c extends C3629b {
        C3630c() {
        }

        public Cursor mo3129a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, iu iuVar) {
            Object jj;
            if (iuVar != null) {
                try {
                    jj = iuVar.jj();
                } catch (Exception e) {
                    if (gm.m11526a(e)) {
                        throw new OperationCanceledException();
                    }
                    throw e;
                }
            }
            jj = null;
            return gm.m11525a(contentResolver, uri, strArr, str, strArr2, str2, jj);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            Mu = new C3630c();
        } else {
            Mu = new C3629b();
        }
    }

    public static Cursor m11524a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, iu iuVar) {
        return Mu.mo3129a(contentResolver, uri, strArr, str, strArr2, str2, iuVar);
    }
}
