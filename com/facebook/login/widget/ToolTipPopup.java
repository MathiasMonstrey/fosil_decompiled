package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.C1325R;
import java.lang.ref.WeakReference;

public class ToolTipPopup {
    public static final long DEFAULT_POPUP_DISPLAY_TIME = 6000;
    private final WeakReference<View> mAnchorViewRef;
    private final Context mContext;
    private long mNuxDisplayTime = DEFAULT_POPUP_DISPLAY_TIME;
    private PopupContentView mPopupContent;
    private PopupWindow mPopupWindow;
    private final OnScrollChangedListener mScrollListener = new C14171();
    private Style mStyle = Style.BLUE;
    private final String mText;

    class C14171 implements OnScrollChangedListener {
        C14171() {
        }

        public void onScrollChanged() {
            if (ToolTipPopup.this.mAnchorViewRef.get() != null && ToolTipPopup.this.mPopupWindow != null && ToolTipPopup.this.mPopupWindow.isShowing()) {
                if (ToolTipPopup.this.mPopupWindow.isAboveAnchor()) {
                    ToolTipPopup.this.mPopupContent.showBottomArrow();
                } else {
                    ToolTipPopup.this.mPopupContent.showTopArrow();
                }
            }
        }
    }

    class C14182 implements Runnable {
        C14182() {
        }

        public void run() {
            ToolTipPopup.this.dismiss();
        }
    }

    class C14193 implements OnClickListener {
        C14193() {
        }

        public void onClick(View view) {
            ToolTipPopup.this.dismiss();
        }
    }

    class PopupContentView extends FrameLayout {
        private View bodyFrame;
        private ImageView bottomArrow;
        private ImageView topArrow;
        private ImageView xOut;

        public PopupContentView(Context context) {
            super(context);
            init();
        }

        private void init() {
            LayoutInflater.from(getContext()).inflate(C1325R.layout.com_facebook_tooltip_bubble, this);
            this.topArrow = (ImageView) findViewById(C1325R.id.com_facebook_tooltip_bubble_view_top_pointer);
            this.bottomArrow = (ImageView) findViewById(C1325R.id.com_facebook_tooltip_bubble_view_bottom_pointer);
            this.bodyFrame = findViewById(C1325R.id.com_facebook_body_frame);
            this.xOut = (ImageView) findViewById(C1325R.id.com_facebook_button_xout);
        }

        public void showTopArrow() {
            this.topArrow.setVisibility(0);
            this.bottomArrow.setVisibility(4);
        }

        public void showBottomArrow() {
            this.topArrow.setVisibility(4);
            this.bottomArrow.setVisibility(0);
        }
    }

    public enum Style {
        BLUE,
        BLACK
    }

    public ToolTipPopup(String str, View view) {
        this.mText = str;
        this.mAnchorViewRef = new WeakReference(view);
        this.mContext = view.getContext();
    }

    public void setStyle(Style style) {
        this.mStyle = style;
    }

    public void show() {
        if (this.mAnchorViewRef.get() != null) {
            this.mPopupContent = new PopupContentView(this.mContext);
            ((TextView) this.mPopupContent.findViewById(C1325R.id.com_facebook_tooltip_bubble_view_text_body)).setText(this.mText);
            if (this.mStyle == Style.BLUE) {
                this.mPopupContent.bodyFrame.setBackgroundResource(C1325R.drawable.com_facebook_tooltip_blue_background);
                this.mPopupContent.bottomArrow.setImageResource(C1325R.drawable.com_facebook_tooltip_blue_bottomnub);
                this.mPopupContent.topArrow.setImageResource(C1325R.drawable.com_facebook_tooltip_blue_topnub);
                this.mPopupContent.xOut.setImageResource(C1325R.drawable.com_facebook_tooltip_blue_xout);
            } else {
                this.mPopupContent.bodyFrame.setBackgroundResource(C1325R.drawable.com_facebook_tooltip_black_background);
                this.mPopupContent.bottomArrow.setImageResource(C1325R.drawable.com_facebook_tooltip_black_bottomnub);
                this.mPopupContent.topArrow.setImageResource(C1325R.drawable.com_facebook_tooltip_black_topnub);
                this.mPopupContent.xOut.setImageResource(C1325R.drawable.com_facebook_tooltip_black_xout);
            }
            View decorView = ((Activity) this.mContext).getWindow().getDecorView();
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            registerObserver();
            this.mPopupContent.measure(MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
            this.mPopupWindow = new PopupWindow(this.mPopupContent, this.mPopupContent.getMeasuredWidth(), this.mPopupContent.getMeasuredHeight());
            this.mPopupWindow.showAsDropDown((View) this.mAnchorViewRef.get());
            updateArrows();
            if (this.mNuxDisplayTime > 0) {
                this.mPopupContent.postDelayed(new C14182(), this.mNuxDisplayTime);
            }
            this.mPopupWindow.setTouchable(true);
            this.mPopupContent.setOnClickListener(new C14193());
        }
    }

    public void setNuxDisplayTime(long j) {
        this.mNuxDisplayTime = j;
    }

    private void updateArrows() {
        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            if (this.mPopupWindow.isAboveAnchor()) {
                this.mPopupContent.showBottomArrow();
            } else {
                this.mPopupContent.showTopArrow();
            }
        }
    }

    public void dismiss() {
        unregisterObserver();
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
        }
    }

    private void registerObserver() {
        unregisterObserver();
        if (this.mAnchorViewRef.get() != null) {
            ((View) this.mAnchorViewRef.get()).getViewTreeObserver().addOnScrollChangedListener(this.mScrollListener);
        }
    }

    private void unregisterObserver() {
        if (this.mAnchorViewRef.get() != null) {
            ((View) this.mAnchorViewRef.get()).getViewTreeObserver().removeOnScrollChangedListener(this.mScrollListener);
        }
    }
}
