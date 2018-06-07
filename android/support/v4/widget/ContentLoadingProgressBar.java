package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    boolean VM;
    boolean VN;
    private final Runnable VO;
    private final Runnable VP;
    boolean mDismissed;
    long mStartTime;

    class C11631 implements Runnable {
        final /* synthetic */ ContentLoadingProgressBar VQ;

        C11631(ContentLoadingProgressBar contentLoadingProgressBar) {
            this.VQ = contentLoadingProgressBar;
        }

        public void run() {
            this.VQ.VM = false;
            this.VQ.mStartTime = -1;
            this.VQ.setVisibility(8);
        }
    }

    class C11642 implements Runnable {
        final /* synthetic */ ContentLoadingProgressBar VQ;

        C11642(ContentLoadingProgressBar contentLoadingProgressBar) {
            this.VQ = contentLoadingProgressBar;
        }

        public void run() {
            this.VQ.VN = false;
            if (!this.VQ.mDismissed) {
                this.VQ.mStartTime = System.currentTimeMillis();
                this.VQ.setVisibility(0);
            }
        }
    }

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mStartTime = -1;
        this.VM = false;
        this.VN = false;
        this.mDismissed = false;
        this.VO = new C11631(this);
        this.VP = new C11642(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        kn();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        kn();
    }

    private void kn() {
        removeCallbacks(this.VO);
        removeCallbacks(this.VP);
    }
}
