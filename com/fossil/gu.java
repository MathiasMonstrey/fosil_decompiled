package com.fossil;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.os.OperationCanceledException;
import com.fossil.gx.C3635a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class gu extends gk<Cursor> {
    String[] MA;
    String MB;
    Cursor MC;
    iu MD;
    final C3635a Mx = new C3635a(this);
    String[] My;
    String Mz;
    Uri mUri;

    public Cursor loadInBackground() {
        Cursor a;
        synchronized (this) {
            if (isLoadInBackgroundCanceled()) {
                throw new OperationCanceledException();
            }
            this.MD = new iu();
        }
        try {
            a = gl.m11524a(getContext().getContentResolver(), this.mUri, this.My, this.Mz, this.MA, this.MB, this.MD);
            if (a != null) {
                a.getCount();
                a.registerContentObserver(this.Mx);
            }
            synchronized (this) {
                this.MD = null;
            }
            return a;
        } catch (RuntimeException e) {
            a.close();
            throw e;
        } catch (Throwable th) {
            synchronized (this) {
                this.MD = null;
            }
        }
    }

    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            if (this.MD != null) {
                this.MD.cancel();
            }
        }
    }

    public void deliverResult(Cursor cursor) {
        if (!isReset()) {
            Cursor cursor2 = this.MC;
            this.MC = cursor;
            if (isStarted()) {
                super.deliverResult(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public gu(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.mUri = uri;
        this.My = strArr;
        this.Mz = str;
        this.MA = strArr2;
        this.MB = str2;
    }

    protected void onStartLoading() {
        if (this.MC != null) {
            deliverResult(this.MC);
        }
        if (takeContentChanged() || this.MC == null) {
            forceLoad();
        }
    }

    protected void onStopLoading() {
        cancelLoad();
    }

    public void onCanceled(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    protected void onReset() {
        super.onReset();
        onStopLoading();
        if (!(this.MC == null || this.MC.isClosed())) {
            this.MC.close();
        }
        this.MC = null;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.mUri);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.My));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.Mz);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.MA));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.MB);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.MC);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.mContentChanged);
    }
}
