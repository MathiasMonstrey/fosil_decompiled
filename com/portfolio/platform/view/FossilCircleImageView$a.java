package com.portfolio.platform.view;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import com.fossil.dqq;
import java.lang.ref.WeakReference;

class FossilCircleImageView$a extends AsyncTask<Bitmap, Void, Bitmap> {
    private WeakReference<FossilCircleImageView> diL;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m15862b((Bitmap[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m15863u((Bitmap) obj);
    }

    public FossilCircleImageView$a(WeakReference<FossilCircleImageView> weakReference) {
        this.diL = weakReference;
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected Bitmap m15862b(Bitmap... bitmapArr) {
        switch (bitmapArr.length) {
            case 1:
                Log.d(FossilCircleImageView.access$000(), "doInBackground bitmap list = 0");
                return bitmapArr[0];
            case 2:
                Log.d(FossilCircleImageView.access$000(), "doInBackground bitmap list = 2");
                return dqq.a(bitmapArr[0], bitmapArr[1], 140);
            case 3:
                Log.d(FossilCircleImageView.access$000(), "doInBackground bitmap list = 3");
                return dqq.a(bitmapArr[0], bitmapArr[1], bitmapArr[2], 140);
            case 4:
                Log.d(FossilCircleImageView.access$000(), "doInBackground bitmap list = 4");
                return dqq.a(bitmapArr[0], bitmapArr[1], bitmapArr[2], bitmapArr[3], 140);
            default:
                return null;
        }
    }

    protected void m15863u(Bitmap bitmap) {
        Log.d(FossilCircleImageView.access$000(), "onPostExecute");
        if (this.diL.get() != null) {
            ((FossilCircleImageView) this.diL.get()).setImageBitmap(bitmap);
        }
    }
}
