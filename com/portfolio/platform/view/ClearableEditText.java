package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.fossil.cjz.a;
import com.fossil.cnc;
import com.fossil.wearables.fossil.R;

public class ClearableEditText extends RelativeLayout {
    private ImageView dhr;
    private FlexibleEditText dhs;
    private String dht;
    private int dhu;
    private int editTextBackground;

    public ClearableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.ClearableEditText, 0, 0);
        this.editTextBackground = obtainStyledAttributes.getColor(3, getResources().getColor(R.color.gray_lighter));
        this.dht = obtainStyledAttributes.getString(2);
        this.dhu = obtainStyledAttributes.getResourceId(1, R.drawable.ic_close_dark);
        ave();
    }

    private void ave() {
        removeAllViews();
        View inflate = inflate(getContext(), R.layout.layout_clearable_edit_text, this);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.clearable_container);
        this.dhr = (ImageView) inflate.findViewById(R.id.iv_clear_text);
        this.dhs = (FlexibleEditText) inflate.findViewById(R.id.edit_text);
        this.dhs.setHint(this.dht);
        relativeLayout.setBackgroundColor(this.editTextBackground);
        this.dhr.setImageResource(this.dhu);
        cnc.b(this.dhs, getContext());
    }

    public FlexibleEditText getEditTextView() {
        return this.dhs;
    }

    public void setOnTextWatcherListener(TextWatcher textWatcher) {
        this.dhs.addTextChangedListener(textWatcher);
    }

    public void setOnClearClickListener(OnClickListener onClickListener) {
        this.dhr.setOnClickListener(onClickListener);
    }
}
